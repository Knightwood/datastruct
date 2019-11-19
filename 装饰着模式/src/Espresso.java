/**
 * 饮料：浓缩咖啡(具体组件：HouseBlend)
 */
public class Espresso extends Beverage{
    public Espresso(){
        //description是Berverage类里的变量
        description="浓缩咖啡";
    }
    //覆盖父类的cost方法
    public double cost(){
        return 2;
    }
}
