package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import base.DBManager;
import beans.BuyBeans;

public class BuyDAO {


	/**
	 * 購入情報登録処理
	 * @param ordereDate 購入情報
	 * @throws SQLException 呼び出し元にスローさせるため
	 */
	public static int insertBuy(BuyBeans ordereDate) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		 int buyId = -1;
		 try{
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO buy(user_id,total_price,silhouetteType,collarType,collarRequest,cuffsDesign,cuffsButtonType,cuffsWatchType,cuffsRequest,pocketDesign,pocketRequest,nameMessage,nameDsign,nameSpelling,nameColor1,nameColor2,namePosition,buttonDesign,buttonThread1,buttonThread2,otherRequest,create_date)"
													+"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
													new String[]{"id"});
			st.setInt(1, ordereDate.getUserId());
			st.setInt(2, ordereDate.getPrice().getTotal());
			st.setString(3, ordereDate.getSilhouetteType());
			st.setString(4, ordereDate.getCollarType());
			st.setString(5, ordereDate.getRequestBeans().getCollarRequest());
			st.setString(6, ordereDate.getCuffsDesignType());
			st.setString(7, ordereDate.getCuffsButtonType());
			st.setString(8, ordereDate.getCuffsWatchType());
			st.setString(9, ordereDate.getRequestBeans().getCuffsRequest());
			st.setString(10, ordereDate.getPocketDesign());
			st.setString(11, ordereDate.getRequestBeans().getPocketRequest());
			st.setString(12, ordereDate.getNameMessage());
			st.setString(13, ordereDate.getNameDesignBeans().getDesingType());
			st.setString(14, ordereDate.getNameSpelling());
			st.setString(15, ordereDate.getNameColorBeans1().getColorType());
			st.setString(16, ordereDate.getNameColorBeans2().getColorType());
			st.setString(17, ordereDate.getNamePosition());
			st.setString(18, ordereDate.getButtonDesingBeans().getButtonTyupe());
			st.setString(19, ordereDate.getButtonThread1());
			st.setString(20, ordereDate.getButtonThread2());
			st.setString(21, ordereDate.getRequestBeans().getOtherRequest());
			st.setTimestamp(22, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();

			if (rs != null && rs.next()) {
			    buyId = rs.getInt("id");
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
}
