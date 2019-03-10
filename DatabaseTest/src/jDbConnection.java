import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jDbConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\halil\\Downloads\\00Programs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port +"/qadbt","root","800halil19" );
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from EmployeeInfo where name='sam';");
		rs.next();
		System.out.println(rs.getString("name"));
		System.out.println(rs.getInt("id"));
		System.out.println(rs.getString("location"));
		System.out.println(rs.getInt("age"));
		
		driver.findElement(By.id("username")).sendKeys(rs.getString("name"));
		driver.findElement(By.id("password")).sendKeys(rs.getString("location"));
		

	}

}
