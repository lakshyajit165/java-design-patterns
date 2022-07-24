package observer;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        // create the data object (publisher/topic)
        WeatherStation weatherStation = new WeatherStation();

        // create and register our displays
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherStation);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);

        // simulate updates
        for(int i = 0; i<5; i++){
            System.out.println("Update: " + i + "\n");
            int randomTemp = getRandomInt(-50, 40);
            int randomHumidity = getRandomInt(0, 100);
            weatherStation.measurementsChanged(randomTemp, randomHumidity);
            Thread.sleep(1000);
        }

    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max+1-min) + min;
    }
}
