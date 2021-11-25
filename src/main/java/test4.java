import java.util.concurrent.*;

/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): PACKAGE_NAME
 * Class(类名): test4
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 20:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */

class NumberThread implements Runnable
{


    @Override
    public void run()
    {
        for (int i = 0; i <= 100; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            if (i % 2 == 1)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread2 implements Callable
{

    @Override
    public Object call() throws Exception
    {
        int sum=0;
        for (int i = 0; i < 100; i++)
        {
            if (i % 2==1)
            {
                System.out.println(Thread.currentThread().getName() +":"+i);
                sum=sum+i;
            }
        }
        return sum;
    }
}

public class test4
{
    public static void main(String[] args)
    {

        //创建固定线程个数为十个的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //new一个Runnable接口的对象
        NumberThread number = new NumberThread();
        NumberThread1 number1 = new NumberThread1();
        NumberThread2 number2=new NumberThread2();
        FutureTask FutureTask=new FutureTask(number2);
        Thread thread1 = new Thread(number);
        Thread thread2=new Thread(number1);
        Thread thread3=new Thread(FutureTask);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");
        thread1.start();
        thread2.start();
        thread3.start();
        //执行线程,最多十个
        //executorService.execute(number1);
        //executorService.execute(number);//适合适用于Runnable
        //executorService.submit(FutureTask);
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.shutdown();
    }
}
