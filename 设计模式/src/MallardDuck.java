public class MallardDuck extends Duck{
    //Mallard:绿头鸭
    public MallardDuck(){
        quackBehavior=new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }

}
