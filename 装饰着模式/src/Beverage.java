/**
 * 饮料基类(抽象组件：Beverage)
 */
public abstract class Beverage {
    String description = "未知的饮料";

    /**
     * @return 饮料的描述
     */
    public String getDescription(){
        return description;
    }

    /**
     * @return 返回价格
     */
    public abstract double cost();
}
