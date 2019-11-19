public class MiniDuckSimulator {

    public static void main(String[] args) {
        //1
        Duck malled = new MallardDuck();

        malled.performQuack();
        malled.performFly();

        //2
        Duck model = new ModelDuck();
        model.performFly();//没有调用set方法的时候，因为ModelDuck类里默认是 flyBehavior=new FlyNoWay();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();//由于调用了set方法，fly行为被改变
    }
}
