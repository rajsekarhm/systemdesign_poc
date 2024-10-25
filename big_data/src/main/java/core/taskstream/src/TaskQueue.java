package core.taskstream.src;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

public class TaskQueue {
    private Integer taskCount = 0;
    private  Queue<Runnable> currentQueue = new LinkedList<>();
    private IParallelism parallelStream;

    public TaskQueue(IParallelism parallel) {
        parallelStream = parallel;
    }

    public void addTaskWithoutArgs(Runnable _task) {
        currentQueue.add(() -> _task.run());
    }

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
            Runnable _task = currentQueue.poll();
            parallelStream.run(_task);
        }
        parallelStream.shutdown();
    }

    public Integer getOnGoingTask() {
        return taskCount;
    }

    public void setOnGoingTask(Integer _taskCount) {
        taskCount = _taskCount;
    }
}
