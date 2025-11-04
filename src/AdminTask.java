public class AdminTask extends Task{

    public AdminTask (String type, String content, String date, Boolean priority){
        this.type = type;
        this.content = content;
        this.date = date;
        this.priority = priority;
    }

    /// POSTPONE
    @Override
    public void solveTaskNegative() {
        Utils.printLine("postponed");
        Task t = RunControl.tManager.taskList.removeFirst(/*RunControl.tManagerPos*/);
        RunControl.tManager.taskList.add(t); // move to end
    }
}
