import java.io.*;

public class ci {
  public static void main(String[] args)
  throws IOException {
    if(args.length != 1) {
      System.out.println("No arguments");
      System.exit(1);
    }
    Runtime runtime = Runtime.getRuntime();
    Process proc = runtime.exec("find" + " " + validateInput(args[0]));
    
    if (validateInput2("1",args[1]))
    {
      proc = runtime.exec("find" + " " + args[0]);
      proc = runtime.exec("find" + " " + args[1]);
      proc = runtime.exec("find" + " " + args[2]);
    }
    testObject testobject_1 = new testObject();
    testobject_1.val_1 = args[0];
    testobject_1.val_1 = args[3];
    testobject_1.cleanVal();
    
    proc = runtime.exec("find" + " " + testobject_1.val_1);
  }

  public static String validateInput(String arg){
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

