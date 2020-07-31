import testproxy.Friend;
import testproxy.Me;
import testproxy.shop;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import static tool.FileTools.unZipFile;

public class Main {

    public static void main(String[] args) {
        TESTT qw = new TESTT();
        //qw.test_value_pass();
        int a = 5;
        int b = a;
        a = 10;
        System.out.println(b);
        int[] a1 = {1, 2};
        int[] a2 = a1;
        a2[1] = 3;
        System.out.println(a1[1]);

        List<Student> list = new ArrayList<>();
        list.add(new Student(1));
        list.add(new Student(2));
        List<Student> list1 = new ArrayList<>();
        list.add(new Student(3));
        list.add(new Student(4));

        List<Student> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.addAll(list1);
        for (int i = 0; i < list2.size(); i++) {
            list2.get(i).setAge(15);
        }
        list.get(1).setAge(100);
        list2.forEach(Student::getAge);
        list.forEach(Student::getAge);
        list1.forEach(Student::getAge);
        //testProxy();
        System.out.println("测试clear方法\n");
        list2.clear();
        list.forEach(Student::getAge);
        list1.forEach(Student::getAge);
        System.out.println("测试赋值null\n");
        list2 = null;
        list2 = new ArrayList<>();
        list.forEach(Student::getAge);
        list1.forEach(Student::getAge);
        System.out.println("测试赋值元素为null\n");
        list2.addAll(list);
        Student student = list2.get(1);
        student = null;
        list.forEach(Student::getAge);
//测试zip文件
        testzip();
    }
    public static void testzip(){
        try {
            unZipFile("C:/Users/123/Desktop/hu.zip", "D:/we");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testProxy() {
        //被代理类
        Me me = new Me();
        //实现接口的伪代理类
        InvocationHandler invocationHandler = new Friend(me);
        //真正的代理类
        shop shopInterface = (shop) Proxy.newProxyInstance(me.getClass().getClassLoader(), me.getClass().getInterfaces(), invocationHandler);
        //调用被代理类中的方法
        shopInterface.shoping();
        shopInterface.travel();

    }

    public void collectionTest() {
        /*new一个arraylist，向上转型成为collection类型。
        所以，collection是list类型，是arraylist类型，
        也是collection类型。
        因为ArrayList继承自List，List继承自Collection。
        */
        Collection<Object> collection = new ArrayList<>();
        collection.add("sjdbfcsabf");
        String tu = "l25";
        collection.add(tu);
    /* asList函数：
    public static <T> List<T> asList(T... a) {
        return new ArrayList<>(a);}
    所以，aslist会返回arraylist，而arraylist类型也是一个collection类型。
    addAll是一个接口，接受的亦是一个collection对象
    */
        collection.addAll(Arrays.asList(1, 6, 8, 4, 9, 3, 7));
        System.out.println("打印集合\n");
        System.out.println(collection);
        System.out.println("collection里的类型");
        collection.forEach(e -> System.out.println(e instanceof Integer));
        //2
        Collection<Integer> collection1 = new ArrayList<Integer>(Arrays.asList(11, 22, 32, 52));
        Integer[] moreInts = {74, 56, 24, 19, 35};
        /**
         * Collections类中实现的addAll接口：
         * public static <T> boolean addAll(Collection<? super T> c, T... elements) {
         *         boolean result = false;
         *         for (T element : elements)
         *             result |= c.add(element);
         *         return result;
         *     }
         */
        Collections.addAll(collection1, 156, 64, 354);
        Collections.addAll(collection1, moreInts);
        List<Integer> list = Arrays.asList(31, 324, 654, 3647);
        list.set(1, 22222);
        //打印：

        //使用迭代器打印
        System.out.println("使用迭代器打印\n");
        Iterator iterator = collection1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //使用foreach打印
        System.out.println("使用foreach打印\n");
        for (Integer integer : collection1) {
            System.out.println(integer);
        }

        //Set，也是collection，不保存重复元素

        Random random = new Random(60);//60以内的随机数
        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 70; i++) {
            intset.add(random.nextInt(30));//生成30个随机数
        }
    }

}
