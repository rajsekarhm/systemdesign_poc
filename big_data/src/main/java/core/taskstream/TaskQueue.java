package core.taskstream;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
//import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class TaskQueue {
    private Integer taskCount = 0;
    private  Queue<Runnable> currentQueue = new LinkedList<>();
    private Parallelism parallelStream;

    // Constructor: You can pass the number of threads to the ExecutorService
    public TaskQueue(int numberOfThreads) {
        parallelStream = new Parallelism(numberOfThreads); // Parallelism with thread pool
    }

    // Adding task without arguments
    public void addTaskWithoutArgs(Runnable _task) {
        currentQueue.add(() -> _task.run());
    }

    // Adding task with arguments
    public void addTask(Consumer<Objects[]> task_s, Objects... arguments) {
        if (arguments == null || arguments.length == 0) {
            currentQueue.add(() -> task_s.accept(new Objects[]{}));
        } else {
            currentQueue.add(() -> task_s.accept(arguments));
        }
    }

    // Execute tasks in parallel using ExecutorService
    public void execute() throws Exception {
        while (!currentQueue.isEmpty()) {
//            System.out.println(currentQueue.size());
            Runnable _task = currentQueue.poll();
            parallelStream.run(_task);  // Submit task to ExecutorService for parallel execution
        }

        // Shutdown the executor after submitting all tasks
        parallelStream.shutdown();

//        executorService.awaitTermination(60, TimeUnit.SECONDS);  // Wait for up to 60 seconds for completion
    }

    public Integer getOnGoingTask() {
        return taskCount;
    }

    public void setOnGoingTask(Integer _taskCount) {
        taskCount = _taskCount;
    }
}
