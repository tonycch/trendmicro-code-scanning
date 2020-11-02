import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SI {
  public static void main(String[] args)
  throws SQLException {

    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_name", "user_name", args[2]);
    String firstname = args[0];
    String lastname = args[1];
    // FIXME: do your own validation to detect attacks
    String query = "SELECT id, firstname, lastname FROM authors WHERE forename = '" 
    		+ validateInput(firstname) + "' and surname = '" + validateInput(lastname) + "'";
    PreparedStatement pstmt = connection.prepareStatement( query );
    ResultSet results = pstmt.executeQuery( );
    connection.close();

    if (validateInput2(args[0],args[1]))
    {
    	firstname = args[0];
    	lastname = args[1];
    	query = "SELECT id, firstname, lastname FROM authors WHERE forename = '" 
    		+ firstname + "' and surname = '" + lastname + "'";
    	pstmt = connection.prepareStatement( query );
    	results = pstmt.executeQuery( );
    	connection.close();
    }
    
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_name", "user_name", args[2]);
    testObject testobject_1 = new testObject();
    testobject_1.val_1 = args[0];
    testobject_1.val_2 = args[0];
    testobject_1.cleanVal();

    firstname = testobject_1.val_1;
    lastname = testobject_1.val_2;
    query = "SELECT id, firstname, lastname FROM authors WHERE forename = '" 
    	+ firstname + "' and surname = '" + lastname + "'";
    pstmt = connection.prepareStatement( query );
    results = pstmt.executeQuery( );
    connection.close();
  }
  
  public static String validateInput(String arg)
  {
    if (!arg.matches("^[A-Z a-z 0-9]*$")){
      throw new IllegalArgumentException();
    }
    return arg;
  }

  public static Boolean validateInput2(String arg1, String arg2){
    if (!arg1.matches("^[A-Z a-z 0-9]*$") && !arg2.matches("^[A-Z a-z 0-9]*$")){
      return false;
    }
    return true;
  }
  
  public static class testObject {
    String val_1 = "";
    String val_2 = "";
    
    public void cleanVal()
    {
      if (!val_1.matches("^[A-Z a-z 0-9]*$") && !val_1.matches("^[A-Z a-z 0-9]*$")){
        val_1 = "";
      }
      if (!val_2.matches("^[A-Z a-z 0-9]*$") && !val_2.matches("^[A-Z a-z 0-9]*$")){
        val_2 = "";
      }
     return;
    }
  }

}
