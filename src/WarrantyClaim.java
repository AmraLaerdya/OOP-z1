public class WarrantyClaim extends Task{

    public WarrantyClaim (String type, String content, String date, Boolean priority){
        this.type = type;
        this.content = content;
        this.date = date;
        this.priority = priority;
    }

    /// Deny claim
    @Override
    public void solveTaskNegative() {
        Utils.printLine("Claim Denied");
        solveTask();
    }
}
