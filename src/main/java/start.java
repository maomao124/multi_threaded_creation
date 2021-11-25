/**
 * Project name(项目名称)：多线程的创建
 * Package(包名): PACKAGE_NAME
 * Class(类名): start
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/25
 * Time(创建时间)： 21:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class start
{
    public static void main(String[] args)
    {
        System.out.println("t1:");
        test.main(null);
        System.out.println();
        System.out.println("t2");
        test2.main(null);
        System.out.println();
        System.out.println("t3:");
        test3.main(null);
        System.out.println();
        System.out.println("t4:");
        test4.main(null);
        System.out.println();
        System.out.println("book.t1:");
        book.test1.main(null);
        System.out.println();
        System.out.println("book.t2:");
        book.test2.main(null);
        System.out.println();
        System.out.println("book.t3:");
        book.test3.main(null);
    }
}
