package core.concurrency_parallel;

public class Task  implements  Runnable{
    String taskName;
    int seconds;
    Task(String name,int _sec){
        this.taskName =name;
        this.seconds = _sec;
    }
    public  void run(){
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

}
