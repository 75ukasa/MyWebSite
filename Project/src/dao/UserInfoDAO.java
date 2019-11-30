package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import base.DBManager;
import beans.BuyBeans;
import beans.PersonalInfoBeans;
import beans.UserDataBeans;

/**
 * 個人情報及びサイズ情報の取得、更新、追加を行うDAO
 */

public class UserInfoDAO {


	/**
	 * 空のサイズテーブルを登録
	 *
	 * @return sizeId 登録したサイズ情報ID
	 *
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static int insertTemporarilyUserSize() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int sizeId = -1;
		try{
			con = DBManager.getConnection();

			st = con.prepareStatement("INSERT INTO size VALUE()", Statement.RETURN_GENERATED_KEYS);
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();

			if (rs != null && rs.next()) {
				sizeId = rs.getInt(1);
			}

			System.out.println("UserSizeのinsertを完了しました");

			return sizeId;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if(con != null) {
				con.close();
			}
		}
	}

	/**
	 * 個人情報の登録処理
	 * @param personal 個人情報がセットされたBeans
	 *		   userId ユーザーのID（userId=0:非会員）
	 * @return personalId 登録した個人情報ID
	 *
	 * @throws SQLException 呼び出し元にスローさせるため
	 *
	 */

	public static int insertPersonal(PersonalInfoBeans personal) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int personalId = -1;

		try{
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO personal_info(name, kana, zip, address, tel, gender) VALUES(?,?,?,?,?,?)",
													Statement.RETURN_GENERATED_KEYS);
			st.setString(1, personal.getName());
			st.setString(2, personal.getKana());
			st.setString(3, personal.getZip());
			st.setString(4, personal.getAddress());
			st.setString(5, personal.getTel());
			st.setString(6, personal.getGender());
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();

			if (rs != null && rs.next()) {
				personalId = rs.getInt(1);
			}
			System.out.println("個人情報の登録は完了しました。");

			return personalId;

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
	 * サイズ情報の登録OR更新処理
	 * @param ordereDate 購入情報
	 *		   userId ユーザーのID（userId=0:非会員）
	 * @return sizeId 登録OR更新したサイズ情報のID
	 *
	 * @throws SQLException 呼び出し元にスローさせるため
	 */
	public static int BuySize(BuyBeans buyDate, UserDataBeans userData) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int sizeId = -1;

		try{
			con = DBManager.getConnection();
			//会員有無の確認 (userId=0:非会員)
			if(userData.getUserId() == 0 ) {
				//size情報の登録
				st = con.prepareStatement("INSERT INTO size(user_id, neck, shoulder, arm, sleeveRigt, sleeveLeft, bust, waist, hips, length, cuffsRigt, cuffsLeft, height)"
												   +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)",
												   Statement.RETURN_GENERATED_KEYS);
				st.setInt(1, userData.getUserId());
				st.setString(2, buyDate.getSizeBeanse().getNeck());
				st.setString(3, buyDate.getSizeBeanse().getShoulder());
				st.setString(4, buyDate.getSizeBeanse().getArm());
				st.setString(5, buyDate.getSizeBeanse().getSleeveRigt());
				st.setString(6, buyDate.getSizeBeanse().getSleeveLeft());
				st.setString(7, buyDate.getSizeBeanse().getBust());
				st.setString(8, buyDate.getSizeBeanse().getWaist());
				st.setString(9, buyDate.getSizeBeanse().getHips());
				st.setString(10, buyDate.getSizeBeanse().getLength());
				st.setString(11, buyDate.getSizeBeanse().getCuffsRigt());
				st.setString(12, buyDate.getSizeBeanse().getCuffsLeft());
				st.setString(13, buyDate.getSizeBeanse().getHeight());
				st.executeUpdate();

				ResultSet rs = st.getGeneratedKeys();

				if (rs != null && rs.next()) {
					sizeId = rs.getInt(1);
				}
				System.out.println("サイズ情報の登録は完了しました。");

			}else {
				//size情報の更新
				st = con.prepareStatement("UPDATE size SET user_id=?, neck=?, shoulder=?, arm=?, sleeveRigt=?, sleeveLeft=?, bust=?, waist=?, hips=?, length=?, cuffsRigt=?, cuffsLeft=?, height=?"
												  +"WHERE id=?");
				st.setInt(1, userData.getUserId());
				st.setString(2, buyDate.getSizeBeanse().getNeck());
				st.setString(3, buyDate.getSizeBeanse().getShoulder());
				st.setString(4, buyDate.getSizeBeanse().getArm());
				st.setString(5, buyDate.getSizeBeanse().getSleeveRigt());
				st.setString(6, buyDate.getSizeBeanse().getSleeveLeft());
				st.setString(7, buyDate.getSizeBeanse().getBust());
				st.setString(8, buyDate.getSizeBeanse().getWaist());
				st.setString(9, buyDate.getSizeBeanse().getHips());
				st.setString(10, buyDate.getSizeBeanse().getLength());
				st.setString(11, buyDate.getSizeBeanse().getCuffsRigt());
				st.setString(12, buyDate.getSizeBeanse().getCuffsLeft());
				st.setString(13, buyDate.getSizeBeanse().getHeight());
				st.setInt(14,userData.getSizeId());
				st.executeUpdate();

				sizeId = userData.getSizeId();

				System.out.println("サイズ情報の更新は完了しました。");
			}
			return sizeId;

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
