package book;

/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): book
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 20:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test2 extends Thread
{
    private static int count = 0;

    public test2(String name)
    {
        super(name);
    }

    public void run()
    {
        for (int i = 0; i < 30; i++)
        {
            count++;
            System.out.println(count + ":" + this.getName());
        }
    }

    public static void main(String[] args)
    {
        test2 p = new test2("线程1");
        p.start();
        for (int i = 0; i <30; i++)
        {
            count++;
            System.out.println(count + ": main");
        }
    }


}
