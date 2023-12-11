package text.section_05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInsert_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
      
		Connection con = null;
		PreparedStatement statement = null;
		
//		ユーザーリスト
		String[][] usersList = {
				{ "侍一郎", "28"},
				{ "侍花子", "24"},
				{ "侍二郎", "26"},
				{ "侍寺子", "37"},
				{ "侍三郎", "21"}
		};
		
		try {
//			データベース接続
			con = DriverManager.getConnection(
				    "jdbc:mysql://localhost/java_db",
				    "root",
				    "Hokkyokusei7"
				    );
			
			System.out.println("データベース接続成功");
			
//			SQLクエリを準備
			String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
			statement = con.prepareStatement(sql);
			
//			リストの一行目から順番に読み込む
			int rowCnt = 0;
			for( int i = 0; i < usersList.length; i++) {
//				SQLクエリの「？」部分をリストデータに置き換え
				statement.setString(1, usersList[i][0]);
				statement.setString(2, usersList[i][1]);
				
//				SQLクエリ実行
				System.out.println("レコード追加：" + statement.toString());
				rowCnt = statement.executeUpdate();
				System.out.println( rowCnt + "件のレコードが追加されました");
			}
		} catch(SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
//			使用したオブジェクトの解放
			if(statement != null) {
				try { statement.close(); } catch(SQLException ignore) {}
			}
			if ( con != null) {
				try { con.close(); } catch(SQLException ignore) {}
			}
		}
	}

}
