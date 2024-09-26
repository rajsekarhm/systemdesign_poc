package core.concurrency_parallel;;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

public class TaskQueue <T> {
    private Integer taskCount = 0;
    private Queue<Runnable> currentQueue = new LinkedList<>();

    public void  addTask(Consumer<Objects[]> task_s, Objects... arguments) {
        currentQueue.add(() -> task_s.accept(arguments));
    }

    public void  execute() throws Exception {
        while (!currentQueue.isEmpty()){
            Runnable _task =  currentQueue.poll();
            _task.run();
        }
    }

    public Integer getOnGoingTask() {
        return taskCount;
    }

    public void setOnGoingTask(Integer _taskCount) {
        taskCount = _taskCount;
    }
}
