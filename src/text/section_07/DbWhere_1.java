package text.section_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbWhere_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
       Connection con = null;
       Statement statement = null;
       
//       データベース接続
       try {
    	   con = DriverManager.getConnection(
    			   "jdbc:mysql://localhost/java_db",
    			   "root",
    			   "Hokkyokusei7"
    			   );
    	   
    	   System.out.println("データベース接続成功");
    	   
//    	   SQLクエリ準備
    	   statement = con.createStatement();
    	   String sql = "SELECT * FROM users WHERE age >= 25;";
    	   
//    	   SQLクエリ実行
    	   ResultSet result = statement.executeQuery(sql);
    	   
//    	   SQLクエリ結果抽出
    	   while( result.next()) {
    		   int id = result.getInt("id");
    		   String name = result.getString("name");
    		   int age = result.getInt("age");
    		   System.out.println(result.getRow() + "件目：id=" + id + "/name=" + name + "/age=" + age);
    	   }
       } catch(SQLException e) {
    	   System.out.println("エラー発生：" + e.getMessage());
       } finally {
//    	   使用したオブジェクトの解放
    	   if( statement != null) {
    		   try { statement.close();} catch(SQLException ignore) {}
    	   }
    	   if( con != null) {
    		   try { con.close();} catch(SQLException ignore) {}
    	   }
       }
	}

}
