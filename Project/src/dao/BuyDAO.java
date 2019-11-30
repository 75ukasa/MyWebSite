package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyBeans;
import beans.BuyDetailBeans;
import beans.CartBeans;
import beans.OrderPriceBeans;

public class BuyDAO {


	/**
	 * 購入情報登録処理
	 * @param userId
	 * @param ordereDate 購入情報
	 * @return  buyId 登録した購入情報のID
	 *
	 * @throws SQLException 呼び出し元にスローさせるため
	 */
	public static int insertBuy(BuyBeans buyDate, int userId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int buyId = -1;
		try{
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO buy2(user_id, total_price,silhouetteType, collarType, collarRequest, cuffsDesign, cuffsButtonType, cuffsWatchType, cuffsRequest, pocketDesign_id, pocketRequest, nameMessage, nameDesign_id, nameSpelling, nameColor1_id, nameColor2_id, namePosition, buttonDesign_id, buttonThread1, buttonThread2, otherRequest, create_date)"
													+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
													Statement.RETURN_GENERATED_KEYS);
			st.setInt(1,userId);
			st.setInt(2, buyDate.getPrice().getTotal());
			st.setString(3, buyDate.getSilhouetteType());
			st.setString(4, buyDate.getCollarType());
			st.setString(5, buyDate.getRequestBeans().getCollarRequest());
			st.setString(6, buyDate.getCuffsDesignType());
			st.setString(7, buyDate.getCuffsButtonType());
			st.setString(8, buyDate.getCuffsWatchType());
			st.setString(9, buyDate.getRequestBeans().getCuffsRequest());
			st.setInt(10, buyDate.getPocketBeans().getPoketId());
			st.setString(11, buyDate.getRequestBeans().getPocketRequest());
			st.setString(12, buyDate.getNameMessage());
			if(buyDate.getNameMessage().equals("ネームを入いれる")) {
				st.setInt(13, buyDate.getNameDesignBeans().getDesignId());
				st.setString(14, buyDate.getNameSpelling());
				if(buyDate.getNameColorBeans1() != null){
					st.setInt(15, buyDate.getNameColorBeans1().getColorId());
				}else {
					st.setInt(15, 0);
				}

				if(buyDate.getNameColorBeans2() != null) {
					st.setInt(16, buyDate.getNameColorBeans2().getColorId());
				}else {
					st.setNull(16, 0);
				}
				st.setString(17, buyDate.getNamePosition());
			}else {
				st.setInt(13, 0);
				st.setNull(14, java.sql.Types.NULL);
				st.setInt(15, 0);
				st.setInt(16, 0);
				st.setNull(17, java.sql.Types.NULL);
			}
			st.setInt(18, buyDate.getButtonDesignBeans().getButtonId());
			st.setString(19, buyDate.getButtonThread1());
			st.setString(20, buyDate.getButtonThread2());
			st.setString(21, buyDate.getRequestBeans().getOtherRequest());
			st.setTimestamp(22, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();

			if (rs != null && rs.next()) {
			    buyId = rs.getInt(1);
			}
			System.out.println("購入情報の登録は完了しました。");

			return buyId;

		}catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

	/**
	 * 購入詳細登録処理
	 * @param buyDetail BuyDetailBeans
	 * @throws SQLException
	 * 			呼び出し元にスローさせるため
	 */
	public static void insertBuyDetail(BuyDetailBeans buyDetail) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO buy_detail(buy_id, item_id, item_num, personal_id, size_id) VALUES(?,?,?,?,?)");
			st.setInt(1, buyDetail.getBuyId());
			st.setInt(2, buyDetail.getItemId());
			st.setInt(3, buyDetail.getItemNum());
			st.setInt(4, buyDetail.getPersonalId());
			st.setInt(5, buyDetail.getSizeId());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	/**
	 * 購入IDによる購入情報検索
	 * @param buyId
	 * @return BuyBeans
	 * 				購入情報のデータを持つJavaBeans
	 * @throws SQLException
	 * 				呼び出し元にスローさせるため
	 */

	public static BuyBeans getBuyBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM buy2 JOIN pocket_design ON buy2.pocketDesign_id = pocket_design.id LEFT JOIN name_design ON buy2.nameDesign_id = name_design.id LEFT JOIN name_color ON buy2.nameColor1_id = name_color.id AND buy2.nameColor2_id = name_color.id JOIN button_design ON buy2.buttonDesign_id = button_design.id WHERE buy2.id = ?");

			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			BuyBeans buyData = new BuyBeans();
			if (rs.next()) {
				OrderPriceBeans Price = new OrderPriceBeans();
				Price.setTotal(rs.getInt("total_price"));

				int optionPrice = 0;
				optionPrice += (rs.getInt("pocket_design.price"));
				if(rs.getInt("nameDesign_id") != 0) {
					optionPrice += (rs.getInt("name_design.price"));
				}
				if(rs.getInt("nameColor1_id") != 0) {
					optionPrice += (rs.getInt("nameColor1_id.price"));
				}
				if(rs.getInt("nameColor2_id") != 0) {
					optionPrice += (rs.getInt("nameColor2_id.price"));
				}
				optionPrice += (rs.getInt("button_design.price"));
				Price.setOptionPrice(optionPrice);

				buyData.setPrice( Price);
				buyData.setBuyDate(rs.getTimestamp("create_date"));
			}

			System.out.println("購入IDによる購入情報検索は完了しました。");

			return buyData;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 購入IDによる商品情報検索
	 * @param buyId
	 * @return ArrayList<CartBeans>
	 * 				購入商品のデータを持つJavaBeansのリスト
	 * @throws SQLException
	 * 				呼び出し元にスローさせるため
	 */

	public static ArrayList<CartBeans> getItemDataBeansListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT buy_detail.id, item_num, price, cloth FROM buy_detail"
										+ " JOIN buy2 ON buy_detail.buy_id = buy2.id"
										+ " JOIN item ON buy_detail.item_id = item.id"
										+ " WHERE buy2.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<CartBeans> buyItemList = new ArrayList<CartBeans>();

			while(rs.next()) {
				CartBeans buyItem = new CartBeans();
				buyItem.setNum(rs.getInt("item_num"));
				buyItem.setSubPrice(rs.getInt("price"));
				buyItem.setCloth(rs.getString("cloth"));

				buyItemList.add(buyItem);
			}
			System.out.println("購入IDによる商品情報検索は完了しました。");

			return buyItemList;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
