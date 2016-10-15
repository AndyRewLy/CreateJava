import java.util.*;
import java.io.*;

public class Convert {

   public static void main(String[] args) {
        
      Scanner s = new Scanner(System.in); 
      String className;
      PrintWriter writer;

      System.out.print("Input class name: ");
     
      className = s.nextLine();
    
      try {
         writer = new PrintWriter(className + ".java", "UTF-8");
         writer.println("import java.util.*;\n");
         writer.println("public class " + className + " {\n");
         writer.println("   //Default Constructor");
         writer.println("   public " + className + "() {\n");
         writer.println("   }");
         writer.println("}");
         writer.close();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

}
