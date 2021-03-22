package services

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object DatabaseManager {
    init {
        Class.forName("org.hsqldb.jdbc.JDBCDriver")
    }

    fun executeSql(queries: Statement.() -> Unit) =
        try {
            DriverManager.getConnection("jdbc:hsqldb:file:test", "SA", "")
                ?.use { connection -> connection.createStatement().use { it.queries() } }
        } catch (ex: Exception) {
            println(ex)
        }

    fun executeSqlAndGetResult(queries: Statement.() -> ResultSet): ResultSet? =
        try {
            DriverManager.getConnection("jdbc:hsqldb:file:test", "SA", "")
                ?.use { connection -> connection.createStatement().use { it.queries() } }
        } catch (ex: Exception) {
            println(ex)
            null
        }
}