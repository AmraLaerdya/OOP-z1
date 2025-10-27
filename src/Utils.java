import java.util.*;
import java.io.*;

public final class Utils {

    static Scanner scan = new Scanner(System.in);

    public static void printLine (String msg){
        System.out.println(msg);
    }

    public static String getLine (){
        return scan.nextLine();
    }

    public static void rWholeFile(String fileName) throws IOException{
        BufferedReader BR = new BufferedReader(new FileReader(fileName));
        String line = BR.readLine(); //reading the first line

        while(line != null){
            Utils.printLine(line);
            line = BR.readLine();
        }
    }

    ///  loading task from file
    public static Task loadTask(){
        Task task = new Task("","","", true);
        return task;
    }

}
