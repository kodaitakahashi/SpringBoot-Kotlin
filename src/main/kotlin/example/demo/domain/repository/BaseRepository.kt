package example.demo.domain.repository

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotliquery.Session
import kotliquery.sessionOf

/**
 * Created by kodaitakahashi on 2017/10/24.
 */

class BaseRepository {
    companion object {

        private val dataSource by lazy {
            val hikariConfig : HikariConfig = HikariConfig()
            hikariConfig.jdbcUrl = "jdbc:mysql://localhost:3306/voic?userSSL=false";
            hikariConfig.username = "root";
            hikariConfig.password = "root";
            hikariConfig.driverClassName = "com.mysql.jdbc.Driver"
            hikariConfig.addDataSourceProperty("cachePrepStmts", "true")
            hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250")
            hikariConfig.addDataSourceProperty("oreoStmtCacheSqlLimit", "2048")
            hikariConfig.addDataSourceProperty("setMinimumIPoolSize", "20")
            hikariConfig.addDataSourceProperty("setMaxPoolSize", "20")
            val dataSource : HikariDataSource = HikariDataSource(hikariConfig);

            dataSource;
        }

        @JvmStatic fun getSession(): Session {
            return sessionOf(dataSource);
        }
    }
}
