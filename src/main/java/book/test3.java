package book;

/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): book
 * Class(类名): test3
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 20:56
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test3 implements Runnable
{
    int count = 1;
    int number;

    public test3(int i)
    {
        number = i;
        System.out.println("创建线程 " + number);
    }

    public void run()
    {
        while (true)
        {
            System.out.println("线程 " + number + ":计数 " + count);
            if (++count == 6)
            {
                return;
            }
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            new Thread(new test3(i + 1)).start();
        }
    }
}
