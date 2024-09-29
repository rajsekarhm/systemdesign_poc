package core.taskstream;

@FunctionalInterface
interface TaskWithArguments {
    void execute(Object... args);
}

public class TaskQueuePardoy {

//    // Queue to hold tasks
//    private Queue<Runnable> taskQueue = new LinkedList<>();
//
//    // Add task with n arguments using custom interface
//    public void addTask(TaskWithArguments task, Object... arguments) {
//        taskQueue.add(() -> task.execute(arguments));
//    }
//
//    // Process the tasks
//    public void processTasks() {
//        while (!taskQueue.isEmpty()) {
//            Runnable task = taskQueue.poll();
//            task.run();
//        }
//    }
//
//    public static void main(String[] args) {
//        TaskQueue queue = new TaskQueue();
//
//        // Task with n arguments
//        TaskWithArguments nArgTask = (argsArray) -> {
//            System.out.print("Task with " + argsArray.length + " arguments: ");
//            for (Object arg : argsArray) {
//                System.out.print(arg + " ");
//            }
//            System.out.println();
//        };
//
//        // Add tasks to the queue
//        queue.addTask(nArgTask, "Hello", 123, true);  // Task with 3 arguments
//        queue.addTask(nArgTask, 42, "world", 5.5, 'A', false);  // Task with 5 arguments
//
//        // Process and execute all tasks
//        queue.processTasks();
//    }
}

