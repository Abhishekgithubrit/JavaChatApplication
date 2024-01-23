import java.util.*;
import java.io.*;

public class prac {

  public static void main(String[] args){
    File f = null;
    String str = "E:\\Abhi\\test.txt";
    try{
     FileOutputStream fout = new FileOutputStream("E:\\Abhi\\test.txt");
     FileInputStream fin = new FileInputStream("E:\\Abhi\\test.txt");
     String s = "\nThis is next Line";
     byte b[] = s.getBytes();
     fout.write(b);
     fout.close();
     System.out.println("File Appended");
     f = new File(str);
     boolean bool = f.canExecute();
     System.out.println(bool);
     String a =f.getAbsolutePath();
     System.out.println(a);
     int y=0;
     while ((y=fin.read())!=-1) {
      System.out.println((char)y);
     }
     fin.close();
     System.out.println("Reading from the file is completed");
    }
    catch(Exception e){
      System.out.println(e);

    }
    File text = new File("E:\\Abhi\\test.txt");

try(Scanner scnr = new Scanner(text)){
  int ln = 1;
  while (scnr.hasNextLine()) {
    String line = scnr.nextLine();
    System.out.println("line" + (ln++) + ":" + line);
    
  }

}catch(Exception e){
  System.err.println(e);
}
     }
}
