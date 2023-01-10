import classes.MyRunnable;
import classes.TaskData;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskData taskData = new TaskData();
        taskData.generateLines();

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < taskData.getTexts().length; i++) {
            //Создаём поток для каждой строки
            Thread thread = new Thread(new MyRunnable(taskData, i));
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join(); // зависаем, ждём когда поток объект которого лежит в thread завершится
        }
    }
}
