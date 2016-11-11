package com.demo.sjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.jdbc.ShardingDataSource;
import com.demo.dao.algorithm.SingleKeyModuloDatabaseShardingAlgorithm;
import com.demo.dao.algorithm.SingleKeyModuloTableShardingAlgorithm;

public class Test {

	public static void main(String[] args) {
		
		try{
		
			DataSource dataSource = getShardingDataSource();
			printAllSelect(dataSource);
			System.out.println("---------------------------------------------------");
//			printSimpleSelect(dataSource);
//			System.out.println("---------------------------------------------------");
//			printGroupBy(dataSource);
//			System.out.println("---------------------------------------------------");
//			printHintSimpleSelect(dataSource);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static void printAllSelect(final DataSource dataSource) throws SQLException {
		String sql = "SELECT * FROM t_order";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					System.out.print(rs.getInt(1));
					System.out.print(rs.getInt(2));
					System.out.print(rs.getString(3));
					System.out.println("======");
				}
			}
		}
	}
	
	private static void printSimpleSelect(final DataSource dataSource) throws SQLException {
		String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.setInt(1, 10);
			preparedStatement.setInt(2, 1001);
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getInt(2));
					System.out.println(rs.getInt(3));
				}
			}
		}
	}
		
	private static void printGroupBy(final DataSource dataSource) throws SQLException {
		String sql = "SELECT o.user_id, COUNT(*) FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id GROUP BY o.user_id";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql)
		) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("user_id: " + rs.getInt(1) + ", count: " + rs.getInt(2));
			}
		}
	}
	
	private static void printHintSimpleSelect(final DataSource dataSource) throws SQLException {
		String sql = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id";
		try (
			HintManager hintManager = HintManager.getInstance();
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			hintManager.addDatabaseShardingValue("t_order", "user_id", 10);
			hintManager.addTableShardingValue("t_order", "order_id", 1001);
			try (ResultSet rs = preparedStatement.executeQuery()) {
				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getInt(2));
					System.out.println(rs.getInt(3));
				}
			}
		}
	}
	
	private static ShardingDataSource getShardingDataSource() {
		DataSourceRule dataSourceRule = new DataSourceRule(createDataSourceMap());
		
		TableRule orderTableRule = TableRule.builder("t_order").actualTables(Arrays.asList("t_order_0", "t_order_1")).dataSourceRule(dataSourceRule).build();
		TableRule orderItemTableRule = TableRule.builder("t_order_item").actualTables(Arrays.asList("t_order_item_0", "t_order_item_1")).dataSourceRule(dataSourceRule).build();
		
		ShardingRule shardingRule = ShardingRule.builder()
			.dataSourceRule(dataSourceRule)
			.tableRules(Arrays.asList(orderTableRule, orderItemTableRule))
			.databaseShardingStrategy(new DatabaseShardingStrategy("order_id", new SingleKeyModuloDatabaseShardingAlgorithm()))
			.tableShardingStrategy(new TableShardingStrategy("item_id", new SingleKeyModuloTableShardingAlgorithm()))
			.build();
		return new ShardingDataSource(shardingRule);
	}
	
	private static Map<String, DataSource> createDataSourceMap() {
		Map<String, DataSource> result = new HashMap<>(2);
		result.put("dbtbl_0", createDataSource("dbtbl_0"));
		result.put("dbtbl_1", createDataSource("dbtbl_1"));
		return result;
	}

	private static DataSource createDataSource(final String dataSourceName) {
		BasicDataSource result = new BasicDataSource();
		result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		result.setUrl(String.format("jdbc:mysql://192.168.65.105:3306/%s", dataSourceName));
		result.setUsername("root");
		result.setPassword("123456");
		return result;
	}

}
