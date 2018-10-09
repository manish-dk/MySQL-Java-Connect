
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) {
		Connection con =null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adopt an animal","root","");
			st = con.createStatement();
			
			st.executeUpdate("UPDATE receptionist SET Animal = 'test2' WHERE Animal = 'test1'");
			st.executeUpdate("INSERT INTO receptionist VALUES(9,'asdsadsa','asdsada')");
			ResultSet rs = st.executeQuery("SELECT * FROM receptionist");
			while(rs.next()) {
				int id = rs.getInt(1);
				String animal = rs.getString("Animal");
				System.out.println("id: "+id);
				System.out.println("animal: "+animal);
				
			}
			rs.close();
			st.close();
			con.close();
		}catch(Exception se) {
			
		}
		
		
	}
}
