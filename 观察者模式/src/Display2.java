public class Display2 implements DisplayElement,Observer{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;
    public Display2(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Currect conditions:"+temperature+"F degress and "+humidity+"% humidity"+pressure+"emmmm");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}
