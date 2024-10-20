package core.taskstream.src;

public interface IParallelism {
    public  void run(Runnable task);
    public void shutdown();
}
