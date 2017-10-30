package example.demo

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Created by kodaitakahashi on 2017/10/31.
 */

@Configuration
public class AppConfig{

    @Bean(destroyMethod = "close")
    public fun dataSource(): DataSource {
        val ds = HikariDataSource();
        ds.jdbcUrl = "jdbc:mysql://localhost:3306/voic?userSSL=false";
        ds.username = "root";
        ds.password = "root";
        ds.driverClassName = "com.mysql.jdbc.Driver"
        ds.addDataSourceProperty("cachePrepStmts", "true")
        ds.addDataSourceProperty("prepStmtCacheSize", "250")
        ds.addDataSourceProperty("oreoStmtCacheSqlLimit", "2048")
        ds.addDataSourceProperty("setMaxPoolSize", "20")
        ds.addDataSourceProperty("minimumIdle", "20")
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        return ds
    }
}