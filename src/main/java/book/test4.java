package book;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): book
 * Class(类名): test4
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 21:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test4 implements Runnable
{
    private final String targetName;
    Random r = new Random();

    public test4(String targetName)
    {
        this.targetName = targetName;
    }

    @Override
    public void run()
    {
        int sum = 0;
        for (int i = 0; i < 100; i++)
        {
            sum += r.nextInt(100);
        }
        System.out.println(Thread.currentThread().getName() + "执行：" + this.targetName + " 结果：" + sum);
    }


    public static void main(String[] args)
    {
        //创建线程池包含2个线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //创建10个线程任务，并提交到线程池
        for (int i = 1; i <= 10; i++)
        {
            //创建线程执行任务
            test4 t = new test4("线程" + i);
            //把任务提交到线程池
            executorService.execute(t);
        }
        executorService.shutdown();
    }
}
