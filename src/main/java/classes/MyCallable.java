package classes;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private TaskData taskData;
    private int index;

    @Override
    public Integer call() {
        //максимальное значение
        return run();
    }
    
    public MyCallable(TaskData taskData, Integer index) {
        this.taskData = taskData;
        this.index = index;
    }

    public int run() {
        return taskData.print(index);
    }
}