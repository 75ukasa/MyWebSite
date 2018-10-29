package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ItemDataBeans;
import beans.brandDataBeans;

public class CategoryDAO {

	public static ArrayList<ItemDataBeans> getBrandItemData(String Date) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE brand.id = ?");

			st.setString(1,Date);

			ResultSet rs = st.executeQuery();
			ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("id"));
				item.setBrandId(rs.getInt("brand_id"));
				item.setMaterial(rs.getString("material"));
				item.setPrice(rs.getInt("price"));
				item.setCloth(rs.getString("cloth"));
				item.setFileName1(rs.getString("file_name1"));

				brandDataBeans brandDataBeans = new brandDataBeans();
				brandDataBeans.setcName(rs.getString("c_name"));
				brandDataBeans.setbName(rs.getString("b_name"));
				item.setBrandDataBeans(brandDataBeans);

				itemList.add(item);


			}
			System.out.println("get Items by itemName has been completed");
			return itemList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


	public static ArrayList<ItemDataBeans> getColorItemData(String Data) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE color = ?");

			st.setString(1, Data);

			ResultSet rs = st.executeQuery();
			ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

			while(rs.next()) {
				ItemDataBeans item = new ItemDataBeans();
				item.setId(rs.getInt("id"));
				item.setBrandId(rs.getInt("brand_id"));
				item.setMaterial(rs.getString("material"));
				item.setPrice(rs.getInt("price"));
				item.setCloth(rs.getString("cloth"));
				item.setFileName1(rs.getString("file_name1"));

				brandDataBeans brandDataBeans = new brandDataBeans();
				brandDataBeans.setcName(rs.getString("c_name"));
				brandDataBeans.setbName(rs.getString("b_name"));
				item.setBrandDataBeans(brandDataBeans);

				itemList.add(item);
			}

			System.out.println("get Items by itemName has been completed");
			return itemList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<ItemDataBeans> getPriceItemData(String Data) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
		if(Data.equals("1")) {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE price <= 18000");

		}else if(Data.equals("2")) {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE price > 18000 and price <= 20000");

		}else if(Data.equals("3")) {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE price > 20000 and price <= 25000");
		}else if(Data.equals("4")) {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE price > 25000" );
		}


		ResultSet rs = st.executeQuery();
		ArrayList<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		while(rs.next()) {
			ItemDataBeans item = new ItemDataBeans();
			item.setId(rs.getInt("id"));
			item.setBrandId(rs.getInt("brand_id"));
			item.setMaterial(rs.getString("material"));
			item.setPrice(rs.getInt("price"));
			item.setCloth(rs.getString("cloth"));
			item.setFileName1(rs.getString("file_name1"));

			brandDataBeans brandDataBeans = new brandDataBeans();
			brandDataBeans.setcName(rs.getString("c_name"));
			brandDataBeans.setbName(rs.getString("b_name"));
			item.setBrandDataBeans(brandDataBeans);

			itemList.add(item);
		}

		System.out.println("get Items by itemName has been completed");
		return itemList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}