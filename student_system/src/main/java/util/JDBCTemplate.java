package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTemplate {
    /*private int count = 0;*/
    // 静态字段引用唯一实例:
    private static final JDBCTemplate INSTANCE = new JDBCTemplate();

    HikariConfig config = new HikariConfig();
    private DataSource ds;

    public void setConfig() {
        System.out.println("初始化连接池");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("connectionTimeout", "1000");
        config.addDataSourceProperty("idleTimeout", "60000");
        config.addDataSourceProperty("maximumPoolSize", "10");
        ds = new HikariDataSource(config);
    }

    // private构造方法保证外部无法实例化:
    private JDBCTemplate() {
    }

    public DataSource getDataSource() {
        System.out.println("获取连接");
        if (INSTANCE.ds == null) {
            INSTANCE.setConfig();
        }
        return INSTANCE.ds;
    }

    public static Connection getInstance() {
        try {
            return INSTANCE.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public void print() {
        System.out.println(++count);
    }*/

}
