import java.util.ArrayList;

public class TaskManager {
    /*
        will be used to organize the csv file into array or other file by date priority.. so on
     */
    ArrayList<Task> taskList = new ArrayList<>();

    public void appendList(Task task){
        taskList.add(task);
    }

    public void orderList (){
        for(int i = 0; i < taskList.size(); i++){

        }
    }

    public void printList (){
        for(int i = 0; i < taskList.size(); i++){
            taskList.get(i).getTask();
        }
    }

}
