package classes;

public class MyRunnable implements Runnable {
    private TaskData taskData;
    private int index;

    public MyRunnable(TaskData taskData, int index) {
        this.taskData = taskData;
        this.index = index;
    }

    public void run() {
        taskData.print(index);
    }
}
