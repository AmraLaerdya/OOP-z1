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
        try{
            BufferedReader BR = new BufferedReader(new FileReader(fileName));
            String line = BR.readLine(); //reading the first line
            while(line != null){
                Utils.printLine(line);
                line = BR.readLine();
            }
        }
        catch (Exception e){
            System.out.println(e);
            printLine("wrong input");
        }

    }

    ///  loading task from file into a object
    public static ArrayList<Task> loadTask(String fileName) throws IOException{
        ArrayList<Task> tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;                           // skip blanks
                if (Task.TaskFromCsv(line) != null)
                    tasks.add(Task.TaskFromCsv(line));  //
            }
        }
        return tasks; // file empty or only blanks
    }

}
