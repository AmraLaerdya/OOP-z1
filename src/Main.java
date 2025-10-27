import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int choice = 0;
        boolean run = true;
        String fileName = null;
        Utils.printLine("debug path src/file.csv");
        Task t = new Task();


        while(run){

            Utils.printLine("Chose your file to load tasks");
            fileName = Utils.getLine();
            Utils.rWholeFile(fileName);
            run = false;
        }


        //choice = TaskControl.makeChoice();
        //String fileName = Utils.getLine();
        //Integer.parseInt(
        //debug for where we currently looking for file
        //System.out.println(System.getProperty("user.dir"));
    }
}