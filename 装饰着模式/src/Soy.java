/**
 * 黄豆
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;
    public Soy(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+"，黄豆";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.30;
    }
}
