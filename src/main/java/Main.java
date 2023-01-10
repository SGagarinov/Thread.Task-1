import classes.MyCallable;
import classes.TaskData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TaskData taskData = new TaskData();
        taskData.generateLines();

        //Пул потоков
        final ExecutorService threadPool = Executors.newFixedThreadPool(taskData.getTexts().length);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < taskData.getTexts().length; i++) {
            //Создаём поток для каждой строки
            Callable<Integer> callable = new MyCallable(taskData, i);
            futures.add(threadPool.submit(callable));
        }

        Integer max = 0;
        for (Future<Integer> future: futures) {
            if (future.get() > max)
                max = future.get();
        }

        //Закрываем все потоки
        threadPool.shutdown();
        //Выводим результат
        System.out.println("Максимальное значение среди всех строк: " + max);
    }
}
