import java.util.LinkedList;
import java.util.Queue;

public class TaskManager {
    Queue<String> tasks = new LinkedList<>();

    public void addTask(String task) {
        tasks.offer(task);
    }

    public void showTasks() {
        System.out.println("\n--- Task Queue ---");
        for (String task : tasks) {
            System.out.println(task);
        }
    }
}
