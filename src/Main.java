import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        while(RunControl.run){

            if (RunControl.menuLevel == 1)
                RunControl.startMenu();


            if (RunControl.menuLevel == 2)
                RunControl.workMenu();
            /*
            tManager.printList();
            */
        }


        //Utils.rWholeFile(fileName);
        //choice = TaskControl.makeChoice();
        //String fileName = Utils.getLine();
        //Integer.parseInt(
        //debug for where we currently looking for file
        //System.out.println(System.getProperty("user.dir"));
    }
}