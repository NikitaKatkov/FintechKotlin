@file:Suppress("SqlDialectInspection")

package services

import kotlin.random.Random

fun withDatabaseSetup(actions: () -> Unit) {
    setupDb()
    actions()
    dropDb()
}

private fun setupDb() {
    generatePhones()
    generateHeadphones()
    generatePairedDevices()
    generateOwners()
}

private fun dropDb() = dropAllTables()

private fun generatePhones() = DatabaseManager.executeSql {
    executeQuery("drop table phones if exists")
    executeQuery("create table phones(id int not null primary key , modelId int not null , modelNumber int not null, imei int not null)")
    for (index in 0..1000) {
        executeUpdate(
            "insert into phones values ($index, ${Random.nextInt(20)}, ${Random.nextInt(12)}, ${
                Random.nextInt(
                    1_000_000
                )
            })"
        )
    }
}

private fun generateHeadphones() =
    DatabaseManager.executeSql {
        executeQuery("drop table headphones if exists")
        executeQuery("create table headphones(id int not null primary key , ownerId int not null , isProModel boolean not null, colour int not null)")
        for (index in 0..1000) {
            executeUpdate(
                "insert into headphones values ($index, ${Random.nextInt(1000)}, ${Random.nextBoolean()}, ${Random.nextInt(10)})"
            )
        }
    }

private fun generateOwners() =
    DatabaseManager.executeSql {
        executeQuery("drop table owners if exists")
        executeQuery("create table owners(id int not null primary key , name varchar(50) not null)")
        for (index in 0..1000) {
            executeUpdate(
                "insert into owners values ($index, 'randomName_${Random.nextInt(1000)}')"
            )
        }
    }

private fun generatePairedDevices() =
    DatabaseManager.executeSql {
        executeQuery("drop table pairedDevices if exists")
        executeQuery("""
            create table pairedDevices
            (
            	phoneId int not null,
            	headphoneId int not null,
            	constraint pairedDevicesPrimaryKey
            		primary key (phoneId, headphoneId)
            );
        """.trimIndent())
        for (index in 0..1000) {
            executeUpdate("insert into pairedDevices values ($index, ${Random.nextInt(1000)})")
        }
    }

private fun dropAllTables() =
    DatabaseManager.executeSql {
        executeUpdate("drop table phones")
        executeUpdate("drop table headphones")
        executeUpdate("drop table pairedDevices")
        executeUpdate("drop table owners")
    }
