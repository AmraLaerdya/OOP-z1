import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {
    /*
        will be used to organize the csv file into array or other file by date priority.. so on
     */
    ArrayList<Task> taskList = new ArrayList<>();

    public void appendList(ArrayList<Task> nTaskList){
        taskList.addAll(nTaskList);
        orderList();
    }

    public void orderList (){
        taskList.sort(Comparator
                .comparing(Task::getPriority, Comparator.reverseOrder())
                .thenComparing(Task::getDateAsLocalDate, Comparator.nullsLast(Comparator.naturalOrder())));
    }

    public void printList (){
        for(int i = 0; i < taskList.size(); i++){
            taskList.get(i).getTask();
        }
    }

    public void printTask (int x){
        taskList.get(x).getTask();
    }
}
