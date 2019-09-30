package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.OderNameDsingBeans;
import beans.OderPocketBeans;

/**
 * DBに登録されている各種オーダーに関する情報の取得
 * @author let-i
 *
 */

public class OderDAO {


	/**
	 *
	 * シルエット情報をIDをもとに取得
	 * @param silhouetteId
	 * @return silhouetteType [String] : シルエットのタイプ
	 * @throws SQLException
	 */

	public static String getOderSilhouette(int silhouetteId)  throws SQLException {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM silhouette_desing WHERE id = ?");
			st.setInt(1,silhouetteId );

			ResultSet rs = st.executeQuery();

			String silhouetteType = "";
			if(rs.next()) {
				silhouetteType = rs.getString("type");
			}

			System.out.println("OderSilhouette()によるsilhouetteId検索は完了しました。");
			return silhouetteType;

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
	 *
	 * 襟情報をIDをもとに取得
	 * @param silhouetteId
	 * @return collarType [Strig] : 襟のタイプ
	 * @throws SQLException
	 */

	public static String getOderColler(CharSequence collerId) throws SQLException {

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT type FROM collar_desing WHERE id = ?");
			st.setObject(1,collerId);

			ResultSet rs = st.executeQuery();

			String  collarType = "";
			if(rs.next()) {
				 collarType = rs.getString("type");
			}

			System.out.println("OderColler()によるcollerId検索は完了しました。");
			return  collarType;

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
	 *
	 * カフスのデザイン情報をcuffsDesingIdをもとに取得
	 * @param cuffsDesingId
	 * @return cuffsDesingType [String] : カフスのデザインタイプ
	 * @throws SQLException
	 */

	public static String getOderCuffsDesing(CharSequence cuffsDesingId) throws SQLException {

		Connection con =null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT type FROM cuffs_desing WHERE id = ?");
			st.setObject(1,cuffsDesingId);

			ResultSet rs = st.executeQuery();
			String cuffsDesingType = "";

			if(rs.next()) {
				cuffsDesingType = rs.getString("type");
			}
			System.out.println("OderCuffsDesing()によるcuffsDesingId検索は完了しました。");
			return cuffsDesingType;

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
	 *
	 * カフスのボタン情報をcuffsButtonIdをもとに取得
	 * @param cuffsButtonId
	 * @return cuffsButtonType [String] : カフスのボタンタイプ
	 * @throws SQLException
	 */

	public static String getOderCuffsButton(CharSequence cuffsButtonId) throws SQLException{

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT type FROM cuffs_button WHERE id = ?");
			st.setObject(1,cuffsButtonId);

			ResultSet rs = st.executeQuery();
			String cuffsButtonType = "";

			if(rs.next()) {
				cuffsButtonType = rs.getString("type");
			}
			System.out.println("OderCuffsButton()によるcuffsButtonId検索は完了しました。");
			return cuffsButtonType;

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
	 *
	 * カフスの時計仕様情報をcuffsButtonIdをもとに取得
	 * @param cuffsButtonId
	 * @return cuffsWatchType [String] : カフスの時計仕様
	 * @throws SQLException
	 */

	public static String getOderCuffsWatch(CharSequence cuffsWatchId) throws SQLException{

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT type FROM cuffs_watch WHERE id = ?");
			st.setObject(1,cuffsWatchId);

			ResultSet rs = st.executeQuery();
			String OderCuffsWatch = "";

			if(rs.next()) {
				OderCuffsWatch = rs.getString("type");
			}
			System.out.println("OderCuffsWatch()によるcuffsButtonId検索は完了しました。");
			return OderCuffsWatch;

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
	 *
	 * ポケット情報をpocketIdをもとに取得
	 * @param  pocketId
	 * @return poketData [OderPocketBeans] : カフスの情報を持つBeans
	 * @throws SQLException
	 */

	public static OderPocketBeans getOderPocket(CharSequence pocketId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT type, price FROM pocket_desing WHERE id = ?");
			st.setObject(1,pocketId);

			ResultSet rs = st.executeQuery();
			OderPocketBeans poketData = new OderPocketBeans();

			if(rs.next()) {
				poketData.setPocketType(rs.getString("type"));
				poketData.setPoketPrice(rs.getInt("price"));
			}
			System.out.println("OderPocket()によるpocketId検索は完了しました。");
			return poketData;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		}finally{
			if(con != null) {
				con.close();
			}
		}
	}

	/**
	 *
	 * ネームデザイン情報をpocketIdをもとに取得
	 * @param  nameDesingId
	 * @return nDsingData [OderNameDsingBeans] : ネームデザインの情報を持つBeans
	 * @throws SQLException
	 */

	public static OderNameDsingBeans getOderNameDesing(String nameDesingId) throws SQLException{
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT type,price FROM name_desing WHERE id = ?");
			st.setString(1, nameDesingId);

			ResultSet rs = st.executeQuery();
			OderNameDsingBeans nDsingData = new OderNameDsingBeans();

			if(rs.next()) {
				nDsingData.setDesingType(rs.getString("type"));
				nDsingData.setDesingPrice(rs.getInt("price"));
			}
			System.out.println("OderNameDesing()によるnameDesingId検索は完了しました。");
			return nDsingData;

			}catch(SQLException e) {
				System.out.println(e);
				throw new SQLException(e);
			}finally {
				if(con != null) {
					con.close();
				}
			}


		}
}