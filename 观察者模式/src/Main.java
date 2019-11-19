public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        WeatherData weatherData = new WeatherData();

        CurrectConditionsDisplay currectConditionsDisplay = new CurrectConditionsDisplay(weatherData);
        Display2 display2 = new Display2(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
        System.out.println("=================");

        WeatherData2 weatherData2 = new WeatherData2();

        CurrectConditionsDisplay2 currectConditionsDisplay2 = new CurrectConditionsDisplay2(weatherData2);
        weatherData2.setMeasurements(80, 65, 30.4f);
        weatherData2.setMeasurements(82, 70, 29.2f);
        weatherData2.setMeasurements(78, 90, 29.2f);
    }
}
