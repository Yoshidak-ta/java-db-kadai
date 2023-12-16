package text.section_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DbOederBy_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	  Scanner scanner = null;
      Connection con = null;
      Statement statement = null;
      
      try {
    	  
    	  System.out.println("0（昇順）か１（降順）を入力してください：");
    	  scanner = new Scanner(System.in);
    	  
//    	  入力内容に応じて並べ替え方向を決定
    	  String order = switch(scanner.nextInt()) {
    	  case 0 -> "ASC;";
    	  case 1 -> "DESC;";
    	  default -> "ASC;";
    	  };
    	  
//    	  データベース接続
    	  con = DriverManager.getConnection(
    			  "jdbc:mysql://localhost/java_db",
    			  "root",
    			  "Hokkyokusei7"
    			  );
    	  
    	  System.out.println("データベース接続成功");
    	  
//    	  SQLクエリ準備
    	  statement = con.createStatement();
    	  String sql = "SELECT * FROM users ORDER BY age " + order;
    	  
//    	  SOLクエリ実行
    	  System.out.println("データ取得を実行：" + sql);
    	  ResultSet result = statement.executeQuery(sql);
    	  
//    	  SOLクエリの実行結果取得
    	  while(result.next()) {
    		  int id = result.getInt("id");
    		  String name = result.getString("name");
    		  int age = result.getInt("age");
    		  System.out.println(result.getRow() + "件目：id=" + "id" + "/name=" + name + "/age=" + age);
    	  }
      } catch(InputMismatchException e) {
    	  System.out.println("入力が正しくありません");
      } catch(SQLException e) {
    	  System.out.println("エラー発生：" + e.getMessage());
      } finally {
    	  if(scanner != null) {
    		 scanner.close();
    	  }
    	  if(statement != null) {
    		  try { statement.close();} catch(SQLException ignore) {}
    	  }
    	  if(con != null) {
    		  try { con.close();} catch(SQLException ignore) {}
    	  }
      }
	}

}
