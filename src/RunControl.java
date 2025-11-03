import java.io.IOException;

public class RunControl {

    static Boolean run = true;
    static String fileName = null;
    static int menuLevel = 1;
    static int tManagerPos = 0;
    static TaskManager tManager = new TaskManager();

    public static int makeChoiceInt (){
        boolean valid = false;
        int choice = 0;

        while(!valid){
            try {
                Utils.printLine("make a choice: ");
                choice = Integer.parseInt(Utils.getLine());
                valid = true;
            } catch (NumberFormatException e) {
                Utils.printLine("Something went wrong " + e);
            }
        }
        return choice;
    }

    public static char makeChoiceChar (){
        boolean valid = false;
        char choice = '0';

        while (!valid){
            try {
                Utils.printLine("make a choice: ");
                choice = Utils.getLine().charAt(0);
                valid = true;
            } catch (Exception e) {
                Utils.printLine("Something went wrong " + e);
            }
        }
        return choice;
    }

    public static void startMenu () throws IOException {
        Utils.printLine("1 - load file");
        Utils.printLine("2 - start working");
                Utils.printLine("3 - print all tasks (debug)");
                Utils.printLine("0 - end program");

                switch (makeChoiceInt()) {
                    case 0:
                run = false;
                break;
            case 1:
                Utils.printLine("debug path src/file.csv");
                Utils.printLine("Chose your file to load tasks");
                fileName = Utils.getLine();
                tManager.appendList(Utils.loadTask(fileName));
                Utils.printLine("file added and sorted");
                break;
            case 2:
                menuLevel++;
                break;
            case 3:
                tManager.printList();
                break;
            default:
                Utils.printLine("Choice out of range");
                break;
        };

    }

    public static void workMenu () {
        tManager.printTask(tManagerPos);

        Utils.printLine("1 - Accept task");
        Utils.printLine("2 - Deny task");
        Utils.printLine("0 - back to menu");

        switch (makeChoiceInt()){
            case 0:
                menuLevel--;
                break;
            case 1:

                break;
            case 2:
                break;
            default:
                Utils.printLine("Choice out of range");
                break;
        }
    }

    public static void taskMenuWarranty(){

    }

    public static void taskMenuAdmin(){

    }
}
