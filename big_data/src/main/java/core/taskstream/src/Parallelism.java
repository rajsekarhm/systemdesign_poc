package core.taskstream.src;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parallelism implements  IParallelism{
    private ExecutorService executorService;

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
