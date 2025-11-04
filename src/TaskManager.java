import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {

    ArrayList<Task> taskList            = new ArrayList<>();
    ArrayList<Task> completedTaskList   = new ArrayList<>();

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

    public void printCompletTaskList(){
        for(int i = 0; i < completedTaskList.size(); i++){
            completedTaskList.get(i).getTask();
        }
    }

    public void printTask (){
        taskList.getFirst().getTask();
    }

    public void addCompleteTask (Task task){
        completedTaskList.add(task);
    }

    public void exportCompletedToCsv(String fileName, boolean append) {
        Utils.fileWrite(fileName, completedTaskList, append);
    }

    public void exportUncompletedToCsv(String fileName, boolean append) {
        Utils.fileWrite(fileName, taskList, append);
    }
}
