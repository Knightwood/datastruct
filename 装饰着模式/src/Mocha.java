/**
 * 摩卡(具体装饰者)，调料
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+"，摩卡";
    }

    @Override
    public double cost() {
        return .20+beverage.cost();
    }
}
