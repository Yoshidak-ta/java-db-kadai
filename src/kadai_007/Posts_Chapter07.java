package kadai_007;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Posts_Chapter07 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
        Connection con = null;
        Statement statement = null;
       
        
        try {
//        データベース接続
          con = DriverManager.getConnection(
        		"jdbc:mysql://localhost/challenge_java",
        		"root",
        		"Hokkyokusei7"
        		);
        
          System.out.println("データベース接続成功");
        
//        SQLクエリ準備
          statement = con.createStatement();
          String sql1 = "INSERT INTO posts (user_id, posted_at, post_content, likes) VALUES(1003, '2023-02-08', '昨日の夜は徹夜でした・・', 13), (1002, '2023-02-08', 'お疲れ様です！', 12), (1003, '2023-02-09', '今日も頑張ります！', 18), (1001, '2023-02-09', '無理は禁物ですよ！', 17), (1002, '2023-02-10', '明日から連休ですね！', 20);";
          String sql2 = "SELECT * FROM posts WHERE user_id = 1002;";

//        SQLクエリ実行(spl1)
          System.out.println("レコードを追加します");
          int rowCnt = statement.executeUpdate(sql1);
          System.out.println(rowCnt + "件のレコードが追加されました");
          
//        SQLクエリ実行(sql2)
          ResultSet result = statement.executeQuery(sql2);
          System.out.println("ユーザーIDが1002のレコードを検索しました");
          
//          表示するレコード数をカウント
          int count = 0;
          while(result.next()) {
        	  count++;
        	  Date date = result.getDate("posted_at");
        	  String content = result.getString("post_content");
        	  int likes = result.getInt("likes");
        	  System.out.println(result.getRow() + "件目：投稿日時=" + date + "/投稿内容=" + content + "/いいね数=" + likes);
        	  
//        	  表示するレコード数が２件以上になったら繰り返し処理終了
        	  if(count >= 2) {
        		  break;
        	  }
          }
          
        } catch(SQLException e) {
        	System.out.println("エラー発生：" + e.getMessage());
        } finally {
           if( statement != null) {
        	   try { statement.close(); } catch(SQLException ignore) {}
           }
           if( con != null) {
        	   try { con.close(); } catch(SQLException ignore) {}
           }
        }
	}

}
