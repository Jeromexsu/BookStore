package com.jeremy.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;
    static {
        Properties props = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid_config.properties");
        try {
            props.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {}
    }
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) { }
        return null;
    }
    public static void close(Connection connection) {
        DbUtils.closeQuietly(connection);
    }
}
