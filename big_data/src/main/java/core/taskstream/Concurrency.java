package core.taskstream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Concurrency {

     public static void executor(Runnable _method) {
        _method.run();
    }

    public void console(Consumer<String> _task , String _output) {
        _task.accept(_output);
    }

    public void  output(String _output){
         System.out.println(_output);
    }

    public  static  void main(String [] args){
        ExecutorService execute = Executors.newFixedThreadPool(2);
//        Thread thread1 = new Thread();
//        Thread thread2 = new Thread(new Task("Task2",1000));
//        execute.execute(new Task("Task1",2000));
//        execute.execute(new Task("Task2",1000));

//        Concurrency con = new Concurrency();
//        con.console(con::output,"oko");
    }
}
