/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 13:25
 * Version(版本): 1.0
 * Description(描述)：
 * Thread.currentThread().getName()  获取当前线程的名字
 * 1.start():1.启动当前线程2.调用线程中的run方法
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():主动释放当前线程的执行权
 * 7.join():在线程中插入执行另一个线程，该线程被阻塞，直到插入执行的线程完全执行完毕以后，该线程才继续执行下去
 * 8.stop():过时方法。当执行此方法时，强制结束当前线程。
 * 9.sleep（long millitime）：线程休眠一段时间
 * 10.isAlive（）：判断当前线程是否存活
 *
 * 方式1：继承于Thread类
 */

class window extends Thread
{
    private static int ticket = 100; //将其加载在类的静态区，所有线程共享该静态变量

    @Override
    public void run()
    {
        while (true)
        {
            if (ticket > 0)
            {
                try
                {
                    sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(getName() + "当前售出第" + ticket + "张票");
                ticket--;
            }
            else
            {
                break;
            }
        }
    }
}

public class test extends Thread
{
    public static void main(String[] args)
    {
        window t1 = new window();
        window t2 = new window();
        window t3 = new window();
        t1.setName("售票口1");
        t2.setName("售票口2");
        t3.setName("售票口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
