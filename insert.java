import java.sql.*;
import java.util.*;
public class insert
{
public static void main (String args[])
{
Scanner sc = new Scanner(System.in);
String url = "jdbc:mysql://localhost:3306/bata"; 
String user = "root"; 
String pass = "dhivyadinesh"; 
try
{
Connection myConnection = DriverManager.getConnection(url,user,pass);
Statement myStatement = myConnection.createStatement();

System.out.println("Enter no ");
int no = sc.nextInt ();

System.out.println("Enter name  ");
String name = sc.next ();

myStatement.executeUpdate ("insert into bata(no,name) values(" + no + ",'" + name + "')");

System.out.println("enter no to delete");
no =sc.nextInt();
myStatement.executeUpdate("delete from bata where no="+no+";");

System.out.println("enter data to update");
String update= sc.next ();
myStatement.executeUpdate("update bata set name="+name+" where no="+no+";");

System.out.println("Final table");

String strSelect = "select * from bata";
ResultSet rset = myStatement.executeQuery(strSelect);
while(rset.next()) 
{   
System.out.println(rset.getInt("no") + ", "+ rset.getString("name"));
}
}
catch(SQLException ex)
{
ex.printStackTrace();
} 
}
}

