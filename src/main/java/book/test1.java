package book;

/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): book
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 20:48
 * Version(版本): 1.0
 * Description(描述)： 无
 */

class SumThread extends Thread
{
    public void run()
    {
        int sum = 0;
        for (int i = 1; i <= 1000; i++)
        {
            sum += i * i;
        }
        System.out.println("平方和:" + sum);
    }
}

class SquareSumThread extends Thread
{
    public void run()
    {
        int sum = 0;
        for (int i = 1; i <= 1000; i++)
        {
            sum += i;
        }
        System.out.println("和:" + sum);
    }

}


public class test1
{
    public static void main(String[] args)
    {
        // 创建线程对象
        SumThread sum = new SumThread();
        SquareSumThread sum1 = new SquareSumThread();
        // 启动线程
        sum.start();
        sum1.start();
    }
}
