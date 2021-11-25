import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): PACKAGE_NAME
 * Class(类名): test3
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 19:46
 * Version(版本): 1.0
 * Description(描述)：
 * 1.创建一个实现callable的实现类
 * 2.实现call方法，将此线程需要执行的操作声明在call（）中
 * 3.创建callable实现类的对象
 * 4.将callable接口实现类的对象作为传递到FutureTask的构造器中，创建FutureTask的对象
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start方法启动（通过FutureTask的对象调用方法get获取线程中的call的返回值）
 */

class NumThread implements Callable
{
    private int sum = 0;

    @Override
    public Object call() throws Exception
    {
        for (int i = 0; i <= 100; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}

public class test3
{
    public static void main(String[] args)
    {
        //new一个实现callable接口的对象
        NumThread numThread = new NumThread();
        //通过futureTask对象的get方法来接收futureTask的值
        FutureTask futureTask = new FutureTask(numThread);

        Thread t1 = new Thread(futureTask);
        t1.setName("线程1");
        t1.start();
        try
        {
            //get返回值即为FutureTask构造器参数callable实现类重写的call的返回值
            Object sum = futureTask.get();
            System.out.println(Thread.currentThread().getName() + ":" + sum);
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
