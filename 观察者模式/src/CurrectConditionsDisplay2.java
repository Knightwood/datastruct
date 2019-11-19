import java.util.Observable;
import java.util.Observer;

public class CurrectConditionsDisplay2 implements Observer,DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrectConditionsDisplay2(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData2){
            WeatherData2 weatherData2=(WeatherData2)o;
            this.temperature=weatherData2.getTemperature();
            this.humidity=weatherData2.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Currect conditions:"+temperature+"F degress and "+humidity+"% humidity");
    }
}
