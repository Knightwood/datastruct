public class Student {
    private int age;
    public int tall;
    public String name;

    public Student() {
        this.age=0;
        this.tall=0;
        this.name="李四";
    }
    public Student(int age,int tall,String name){
        this.age=age;
        this.tall=tall;
        this.name=name;
    }
    public Student(int age){
        this(age,0,"张三");
    }

    public int getAge() {
        System.out.println(age);
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTall() {
        System.out.println(tall);
        return tall;
    }

    public void setTall(int tall) {
        this.tall = tall;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
