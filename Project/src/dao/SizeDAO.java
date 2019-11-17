package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;

public class SizeDAO {


	/**
	 * 新規登録されたユーザーIDをサイズテーブルに登録
	 *
	 * @param userId
	 *
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public static void insertTemporarilyUserSize(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try{
			con = DBManager.getConnection();

			st = con.prepareStatement("INSERT INTO size(user_id) VALUES(?)");
			st.setInt(1,userId);
			st.executeUpdate();

			System.out.println("UserSizeのinsertを完了しました");


		}catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally {
			if(con != null) {
				con.close();
			}
		}
	}

}
