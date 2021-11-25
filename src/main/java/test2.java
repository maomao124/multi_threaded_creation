import static java.lang.Thread.sleep;

/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 13:36
 * Version(版本): 1.0
 * Description(描述)：
 * 方式2：实现Runable接口方式
 * 1.创建一个实现了Runable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类中的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start（）
 */

class window1 implements Runnable
{
    private int ticket = 100;

    @Override
    public void run()
    {
        while (true)
        {
            if (ticket > 0)
            {
                try
                {
                    sleep(50);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "当前售出第" + ticket + "张票");
                ticket--;
            }
            else
            {
                break;
            }
        }
    }
}

public class test2
{
    public static void main(String[] args)
    {
        window1 w = new window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
