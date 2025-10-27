
/*
    main class for managing doing the tasks, ui for cmd
 */

public class TaskControl {

    public static int makeChoice (){
        boolean valid = false;
        int choice = 0;

        while(!valid){
            try {
                Utils.printLine("make a choice :");
                choice = Integer.parseInt(Utils.getLine());
                valid = true;
            } catch (NumberFormatException e) {
                Utils.printLine("Invalid input! enter a number");
            }
        }
        return choice;
    }

}
