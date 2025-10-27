public class Task {
    /*
        parrent object used to extend our main task types
     */

    String type;
    String content;
    String date;
    Boolean priority;

    public Task() {
        // optional: you can set default values here
        this.type = null;
        this.content = null;
        this.date = null;
        this.priority = false;
    }

    public Task(String type, String content, String date, Boolean priority){
        this.type = type;
        this.content = content;
        this.date = date;
        this.priority = priority;
    }

    public void getTask(){
            Utils.printLine(type);
            Utils.printLine(content);
            Utils.printLine(date);
            Utils.printLine(Boolean.toString(priority));
    }

    public void completeTask(){

    }

}
