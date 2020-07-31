public class TESTT {

    public void test_value_pass(){
        Student a=new Student();
        System.out.println(a.name);
        System.out.println(a.tall);
        a.name="赵子龙";
        a.tall=170;
        a.getName();
        a.getTall();
        System.out.println("测试2");
        Student b= test2(a);
        b.getAge();
        b.getTall();
        b.getName();
        System.out.println("原属性");
        a.getName();
        a.getTall();
        System.out.println("测试3");
        Student c=new Student();
        Student d= test1(c);
        System.out.println("改变后");
        d.getName();
        d.getAge();
        d.getTall();
    }
    public Student test2(Student student){
        student=new Student(15,165,"张三");
        return student;
    }
    public Student test1(Student student){
        student.name="张杰";
        student.tall=180;
        student.setAge(52);
        return student;
    }
}
