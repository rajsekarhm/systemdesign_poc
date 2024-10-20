package core.taskstream.src;

public class Task {
    String taskName;
    int seconds;
    Task(String name,int _sec){
        this.taskName =name;
        this.seconds = _sec;
    }
    public  void task(){
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Task step: " + i);
            try {
                // Simulate some work with sleep
                Thread.sleep(this.seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  static  void main(String [] args) throws Exception {
        TaskQueue  _queue = new TaskQueue(new Parallelism(2));
        _queue.addTaskWithoutArgs(new Task("task 1",2000)::task);
        _queue.addTaskWithoutArgs(new Task("task 2",3000)::task);
        _queue.execute();
    }

}
