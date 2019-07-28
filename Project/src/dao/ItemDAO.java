package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ItemDataBeans;
import beans.brandDataBeans;

public class ItemDAO {

	public static ArrayList<ItemDataBeans> getItemData() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id");
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




	public static ItemDataBeans  getItemDetail(String id) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE item.id = ?");
			st.setString(1, id);

			ResultSet rs = st.executeQuery();
			ItemDataBeans item = new ItemDataBeans();

			if (rs.next()) {
				item.setId(rs.getInt("id"));
				item.setBrandId(rs.getInt("brand_id"));
				item.setMaterial(rs.getString("material"));
				item.setPrice(rs.getInt("price"));
				item.setColor(rs.getString("color"));
				item.setRemark(rs.getString("remark"));
				item.setDepth(rs.getString("depth"));
				item.setCloth(rs.getString("cloth"));
				item.setDetail(rs.getString("detail"));
				item.setFileName1(rs.getString("file_name1"));
				item.setFileName2(rs.getString("file_name2"));

				brandDataBeans brandDataBeans = new brandDataBeans();
				brandDataBeans.setcName(rs.getString("c_name"));
				brandDataBeans.setbName(rs.getString("b_name"));
				item.setBrandDataBeans(brandDataBeans);



			}
			System.out.println("get Items by itemName has been completed");
			return item;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}



	public static ItemDataBeans  getItemCart(String id) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM item"
									+ " JOIN brand"
									+ " ON item.brand_id = brand.id"
									+ " WHERE item.id = ?");
			st.setString(1, id);

			ResultSet rs = st.executeQuery();
			ItemDataBeans item = new ItemDataBeans();

			if (rs.next()) {
				item.setId(rs.getInt("id"));
				item.setBrandId(rs.getInt("brand_id"));
				item.setMaterial(rs.getString("material"));
				item.setPrice(rs.getInt("price"));
				item.setRemark(rs.getString("remark"));
				item.setCloth(rs.getString("cloth"));

				brandDataBeans brandDataBeans = new brandDataBeans();
				brandDataBeans.setbName(rs.getString("b_name"));
				item.setBrandDataBeans(brandDataBeans);



			}
			System.out.println("get Items by itemName has been completed");
			return item;

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
