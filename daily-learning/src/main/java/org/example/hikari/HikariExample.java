package org.example.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author: hanchaowei
 * @date 2024/5/16
 * @description: Hikari连接池示例
 */

public class HikariExample {

	public static void main(String[] args) {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setMinimumIdle(1);
		hikariConfig.setMaximumPoolSize(2);
		hikariConfig.setConnectionTestQuery("select 1");
		hikariConfig.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
		//  设置H2数据库的内存模式，test是数据库
		hikariConfig.addDataSourceProperty("url", "jdbc:h2:mem:test");
		// 创建数据源
		DataSource ds = new HikariDataSource(hikariConfig);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 查询数据
		try {
			// 获取数据库连接
			conn = ds.getConnection();
			// 创建Statement(用来执行SQL语句)
			stmt = conn.createStatement();
			// 创建测试表
			stmt.execute("CREATE TABLE IF NOT EXISTS test (id INT, name VARCHAR(255))");
			// 插入数据
			stmt.executeUpdate("INSERT INTO test (id, name) VALUES (1, '张三')");
			// 查询数据
			rs = stmt.executeQuery("SELECT id, name FROM test");
			// 获取结果
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭ResultSet
			close(rs);
			// 关闭Statement
			close(stmt);
			// 关闭连接
			close(conn);
		}
	}

	public static void close(AutoCloseable rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
