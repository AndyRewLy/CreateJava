import java.util.*;
import java.io.*;

public class Convert {

   public static void main(String[] args) {
        
      Scanner s = new Scanner(System.in); 
      String className;
      LinkedList attr = new LinkedList<String>();
      LinkedList type = new LinkedList<String>();

      int numAttr = 0;

      PrintWriter writer;

      System.out.print("Input class name: ");
     
      className = s.nextLine();
      
      System.out.print("Add Attributes(y/n)?");
      
      if (s.next().charAt(0) == 'y') {
         System.out.println("How many attributes will you add?");
         numAttr = s.nextInt();
         System.out.println("-- Follow the form: <type> <attr_name> --");
         while (numAttr-- != 0) {
            type.addLast(s.next());
            attr.addLast(s.next());
         }
      }
          
      try {
         writer = new PrintWriter(className + ".java", "UTF-8");
         writer.println("import java.util.*;\n");
         writer.println("public class " + className + " {\n");
         writer.println("   //private variables");
         addAttributes(writer, type, attr);
         writer.println("   //Default Constructor");
         writer.print("   public " + className + "(");
         addParams(writer, type, attr);
         writer.println(") {");
         setClassVar(writer, attr);
         writer.println("   }\n");
         createSetter(writer, type, attr);
         createGetter(writer, type, attr);
         writer.println("}");
         writer.close();
      }
      catch (Exception e) {
         e.printStackTrace();
      }

   }

   public static void addAttributes(PrintWriter writer, LinkedList type,
                                    LinkedList attr) {
      for (int i = 0; i < type.size(); i++) {
         writer.println("   private " + type.get(i) + " " + attr.get(i) + ";"); 
      }
      writer.println();
   }

   public static void addParams(PrintWriter writer, LinkedList type,
                                    LinkedList attr) {
      for (int i = 0; i < type.size(); i++) {
         writer.print(type.get(i) + " " + attr.get(i));
         if (i != type.size() - 1) {
            writer.print(", ");
         } 
      }
   }
   
   public static void setClassVar(PrintWriter writer, LinkedList attr) {
      for (int i = 0; i < attr.size(); i++) {
         writer.println("      this." + attr.get(i) + " = " + attr.get(i) + ";");
      }
   }

   public static void createSetter(PrintWriter writer, LinkedList type,
                                                       LinkedList attr) {
      for (int i = 0; i < attr.size(); i++) {
         writer.println("   public void set_" + attr.get(i) + "(" + type.get(i) + " val) {");
         writer.println("      " + attr.get(i) + " = val;");
         writer.println("   }\n");
      }
   }

   public static void createGetter(PrintWriter writer, LinkedList type,
                                                       LinkedList attr) {
      for (int i = 0; i < attr.size(); i++) {
         writer.println("   public " + type.get(i) + " get_" + attr.get(i) + "() {");
         writer.println("      return " + attr.get(i) + ";");
         writer.println("   }\n");
      }
   }
}
