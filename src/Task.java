import java.time.LocalDate;

public abstract class Task {

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
        if(lineCSV == null)
            return null;
        String[] parts = lineCSV.split(",", 4);
        String type = parts.length > 0 ? parts[0].trim() : "";
        String content = parts.length > 1 ? parts[1].trim() : "";
        String date = parts.length > 2 ? parts[2].trim() : "";
        Boolean priority = parts.length > 3 ? Boolean.parseBoolean(parts[3].trim()) : false;
        switch (type.toLowerCase()){
            case "admin":
                return new AdminTask(type, content, date, priority);
            case "reklamacia":
                return  new WarrantyClaim(type, content, date, priority);
            default:
                Utils.printLine("something went wrong");
                return null;
        }
    }

    public void getTask(){
            Utils.printLine(type + " / " + date + " / " + priority);
            Utils.printLine(content);
    }

    public LocalDate getDateAsLocalDate(){
        return LocalDate.parse(this.date);
    }

    public boolean getPriority(){
        return this.priority;
    }

    public void solveTask (){
        RunControl.tManager.completedTaskList.add(RunControl.tManager.taskList.getFirst());
        RunControl.tManager.taskList.removeFirst();
    }

    public void solveTaskPositive(){
        Utils.printLine("solved task");
        solveTask();
    }

    abstract public  void solveTaskNegative();

    private static String csvEscape(String s) {
        if (s == null) s = "";
        String q = "\"";
        return q + s.replace("\"", "\"\"") + q;
    }

    public String toCsvLine() {
        return String.join(",",
                csvEscape(this.type),
                csvEscape(this.content),
                csvEscape(this.date),
                csvEscape(Boolean.toString(this.priority))
        );
    }
}
