package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Data{
	Connection con;
	public 	Data(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=src/�ʿ�/�ʿ�.mdb";
			con = DriverManager.getConnection("jdbc:odbc:�ʿ�");
			//con = DriverManager.getConnection(url,"","");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	public ResultSet getData(){
		Statement st;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			String sql = "SELECT * FROM ������Ϣ";
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	public void addData(String word,String character){
		try{
		PreparedStatement pstm = con.prepareStatement("INSERT INTO ������Ϣ(����,��ʾ) VALUES(?,?)");
		pstm.setString(1,word);
		pstm.setString(2,character);
		pstm.executeUpdate();
	    System.out.println("��ӳɹ�");
	    }
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deletData(String str){
		try{
			System.out.println(str);
		PreparedStatement pstm = con.prepareStatement("DELETE FROM ������Ϣ WHERE ����='"+str+"'");
	    pstm.executeUpdate();
	    System.out.println("ɾ��"+str+"���");
		pstm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void DataClose(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





