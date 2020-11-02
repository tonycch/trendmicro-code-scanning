import java.io.*;

public class PM {
  public static void main(String[] args)
  throws IOException {
    String rName = validateInput(args[0]);
    File rFile = new File("/usr/local/apfr/reports/" + rName);
    rFile.delete();

    if (validateInput2("1",args[1]))
    {
      String rName2 = args[0];
      File rFile2 = new File("/usr/local/apfr/reports/" + rName2);
      rFile2.delete();
    }
  
    testObject testobject_1 = new testObject();
    testobject_1.val_1 = args[0];
    testobject_1.cleanVal();

    File rFile3 = new File("/usr/local/apfr/reports/" + testobject_1.val_1);
    rFile3.delete();
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
    
    public void cleanVal()
    {
      if (!val_1.matches("^[A-Z a-z 0-9]*$") && !val_1.matches("^[A-Z a-z 0-9]*$")){
        val_1 = "";
      }
     return;
    }
  }

}
