@file:Suppress("SqlDialectInspection")

package services

import entities.HeadphonesByColours
import entities.Iphone
import entities.OwnerWithHeadphones
import java.sql.ResultSet

fun findPhoneById(id: Int): Iphone? = DatabaseManager.executeSqlAndGetResult {
    executeQuery("select * from phones where id = $id")
}?.let {
    if (it.next()) {
        mapToPhone(it)
    } else {
        println("No phone with id = $id found")
        null
    }
}

fun findPhoneIdsWithModelNumberHigherThan(modelNumberLowerBound: Int): List<Iphone>? =
    DatabaseManager.executeSqlAndGetResult {
        executeQuery("select * from phones where modelNumber > $modelNumberLowerBound")
    }?.let {
        sequence {
            while (it.next()) {
                yield(mapToPhone(it))
            }
        }.toList()
    }

fun findOwnerIdsToTheirHeadphoneIds(): List<OwnerWithHeadphones>? = DatabaseManager.executeSqlAndGetResult {
    executeQuery(
        """
        select owners.name, headphones.id
        from owners
        inner join headphones
        on owners.id = headphones.ownerId;
    """.trimIndent()
    )
}?.let {
    sequence {
        while (it.next()) {
            yield(mapToOwnerWithHeadphones(it))
        }
    }.toList()
}

fun findQuantityOfHeadphonesByColours(): List<HeadphonesByColours>? = DatabaseManager.executeSqlAndGetResult {
    executeQuery("select colour, count(colour) as colourCount from headphones group by colour")
}?.let {
    sequence {
        while (it.next()) {
            yield(mapToHeadphonesByColours(it))
        }
    }.toList()
}

fun findQuantityOfHeadphonesByColoursSorted(): List<HeadphonesByColours>? = DatabaseManager.executeSqlAndGetResult {
    executeQuery("select colour, count(colour) as colourCount from headphones group by colour order by colour")
}?.let {
    sequence {
        while (it.next()) {
            yield(mapToHeadphonesByColours(it))
        }
    }.toList()
}

private fun mapToHeadphonesByColours(resultSet: ResultSet): HeadphonesByColours =
    HeadphonesByColours(
        resultSet.getInt("colour"),
        resultSet.getInt("colourCount")
    )

private fun mapToOwnerWithHeadphones(resultSet: ResultSet): OwnerWithHeadphones =
    OwnerWithHeadphones(
        resultSet.getString("name"),
        resultSet.getInt("id")
    )

private fun mapToPhone(resultSet: ResultSet): Iphone =
    Iphone(
        resultSet.getInt("id"),
        resultSet.getInt("modelId"),
        resultSet.getInt("modelNumber"),
        resultSet.getInt("imei")
    )