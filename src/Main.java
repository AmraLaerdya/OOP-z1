import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        while(RunControl.run){
            if (RunControl.menuLevel == 1)
                RunControl.startMenu();

            if (RunControl.menuLevel == 2)
                RunControl.workMenu();

            if (RunControl.menuLevel == 3)
                RunControl.taskMenu();
        }
    }
}