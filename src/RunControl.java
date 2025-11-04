import java.io.IOException;

public class RunControl {

    static Boolean run = true;
    static String fileName = null;
    static int menuLevel = 1;
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
                Utils.printLine("Error: " + e);
            }
        }
        return choice;
    }

    public static void startMenu () throws IOException {
        Utils.printLine("1 - load file");
        Utils.printLine("2 - start working");
        Utils.printLine("3 - (debug) print all tasks");
        Utils.printLine("4 - (debug) print all completed tasks");
        Utils.printLine("0 - end program");

        switch (makeChoiceInt()) {
            case 0:
                run = false;
                break;
            case 1:
                Utils.printLine("files provided MainTasks.csv and secondaryTasks.csv");
                Utils.printLine("Chose your file to load tasks");
                fileName = Utils.getLine();
                tManager.appendList(Utils.loadTask(fileName));
                tManager.exportCompletedToCsv("completedTasks.csv", false);
                tManager.exportUncompletedToCsv("uncompletedTasks.csv", false);
                break;
            case 2:
                try {
                    if(tManager == null || tManager.taskList == null || tManager.taskList.isEmpty()){
                        Utils.printLine("Empty list, load file first");
                    }else {
                        menuLevel++;
                    }
                }catch (Exception e) {
                    Utils.printLine("Error: " + e);
                }
                break;
            case 3:
                Utils.printLine("debug task list");
                tManager.printList();
                break;
            case 4:
                Utils.printLine("debug complete task list");
                tManager.printCompletTaskList();
            default:
                Utils.printLine("Choice out of range");
                break;
        };

    }

    public static void workMenu () {
        try {
            if (tManager.taskList == null || tManager.taskList.isEmpty()){
                Utils.printLine("AWASOME! U finished all tasks! Get yourself a coffe!");
                menuLevel--;
            }else {
                tManager.printTask();

                Utils.printLine("1 - Accept task");
                Utils.printLine("0 - back to menu");

                switch (makeChoiceInt()) {
                    case 0:
                        tManager.exportCompletedToCsv("completedTasks.csv", false);
                        tManager.exportUncompletedToCsv("uncompletedTasks.csv", false);
                        menuLevel--;
                        break;
                    case 1:
                        menuLevel++;
                        break;
                    default:
                        Utils.printLine("Choice out of range");
                        break;
                }
            }
        }catch (Exception e){
            Utils.printLine("Error: " + e);
        }
    }

    public static void taskMenu(){

        Utils.printLine("1 - Finish task");
        Utils.printLine("2 - Postpone / Deny Task");
        Utils.printLine("0 - back to menu");

        switch (makeChoiceInt()){
            case 0:
                /// Exit to Main menu
                tManager.exportCompletedToCsv("completedTasks.csv", false);
                tManager.exportUncompletedToCsv("uncompletedTasks.csv", false);
                menuLevel--;
                menuLevel--;
                break;
            case 1:
                /// Solve task
                tManager.taskList.getFirst().solveTaskPositive();
                menuLevel--;
                break;
            case 2:
                /// Postpone / deny claim ... based on type of Task parsed into it
                tManager.taskList.getFirst().solveTaskNegative();
                menuLevel--;
                break;
            default:
                Utils.printLine("Choice out of range");
                break;
        }
    }

}
