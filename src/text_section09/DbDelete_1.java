package text_section09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDelete_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
       Connection con = null;
       Statement statement = null;
       
       try {
    	   
        
//           データベース接続
              con = DriverManager.getConnection(
    		   "jdbc:mysql://localhost/java_db",
    		   "root",
    		   "Hokkyokusei7"
    		   );
       
             System.out.println("データベース接続成功");
       
//             SQLクエリ準備
              statement = con.createStatement();
              String sql = "DELETE FROM users WHERE id = 6;";
              
//              SQLクエリ実行
              System.out.println("レコード削除:" + statement.toString());
              int rowCnt = statement.executeUpdate(sql);
              System.out.println(rowCnt + "件のレコードが削除されました");
              
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
