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

    //  loading task from file into a object
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
        catch (IOException e){
            Utils.printLine("Error: " + e);
        }
        return tasks; // file empty or only blanks
    }

    // Writes all tasks; set append=true to add to an existing file, or false to (re)create it.
    // If you want a header when not appending, uncomment the header line.
    public static void fileWrite(String fileName, ArrayList<Task> tasks, boolean append) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, append)))) {
            // If you want a header when starting a new file:
            // if (!append) pw.println("\"type\",\"content\",\"date\",\"priority\"");
            for (Task t : tasks) {
                if (t != null) pw.println(t.toCsvLine());
            }
        } catch (IOException e) {
            Utils.printLine("Error: " + e);
        }
    }

}
