package core.taskstream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parallelism {
    private ExecutorService executorService;

    // Constructor: You can pass the number of threads to the ExecutorService
    public Parallelism(int numberOfThreads) {
        this.executorService = Executors.newFixedThreadPool(numberOfThreads); // Parallelism with thread pool
    }

    public  void run(Runnable task) {
       this.executorService.submit(task);
    }

    public void shutdown(){
        this.executorService.shutdown();
    }

}
