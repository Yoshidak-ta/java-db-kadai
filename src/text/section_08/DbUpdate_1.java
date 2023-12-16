package text.section_08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUpdate_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
       
		Connection con = null;
		Statement statement = null;
		
		try {
			
//			データベースに接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/java_db",
					"root",
					"Hokkyokusei7"
					);
			
			System.out.println("データベース接続成功");
			
//			SQLクエリ準備
			statement = con.createStatement();
			String sql = "UPDATE users SET name = '武士山花子' WHERE id = 2;";
			
//			SQLクエリ実行
			System.out.println("レコード更新:" + statement.toString());
			int rowCnt = statement.executeUpdate(sql);
			System.out.println( rowCnt + "件のレコードが更新されました");
			
		} catch(SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
			if(statement != null) {
				try {statement.close();} catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();} catch(SQLException ignore) {}
			}
		}
	} 

}
