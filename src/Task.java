public class Task {
    /*
        parrent object used to extend our main task types
     */

    String type;
    String content;
    String date;
    Boolean priority;

    public Task() {
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

    public static Task TaskFromCsv(String lineCSV){
        if(lineCSV == null) {
            return null;
        }
        String[] parts = lineCSV.split(",", 4);
        String type = parts.length > 0 ? parts[0].trim() : "";
        String content = parts.length > 1 ? parts[1].trim() : "";
        String date = parts.length > 2 ? parts[2].trim() : "";
        Boolean priority = parts.length > 3 ? Boolean.parseBoolean(parts[3].trim()) : false;
        return new Task();
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
