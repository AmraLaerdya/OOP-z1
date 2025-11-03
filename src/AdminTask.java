public class AdminTask extends Task{

    public AdminTask (String type, String content, String date, Boolean priority){
        this.type = type;
        this.content = content;
        this.date = date;
        this.priority = priority;
        Utils.printLine("admin task was created");
    }

    public void postponeTask () {

    }

}
