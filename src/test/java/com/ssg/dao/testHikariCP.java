package com.ssg.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class testHikariCP {

    @Test
    public void testHikari() throws Exception {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/ssg?serverTimezone=UTC");
        config.setUsername("webuser");
        config.setPassword("webuser1234");
        config.addDataSourceProperty("cachePrespStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);

        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();

    }

}
