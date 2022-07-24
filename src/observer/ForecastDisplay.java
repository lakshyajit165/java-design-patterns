package observer;

import java.util.ArrayList;
import java.util.List;

public class ForecastDisplay implements Observer{

    private List<Integer> temperatureHistory;
    private List<Integer> humidityHistory;

    public ForecastDisplay(Subject weatherStation) {
        temperatureHistory = new ArrayList<>();
        humidityHistory = new ArrayList<>();
        weatherStation.registerObserver(this);
    }
    @Override
    public void update(int temp, int humidity) {
        temperatureHistory.add(temp);
        humidityHistory.add(humidity);
        display7DaysHistory();
    }

    public void display7DaysHistory() {
        System.out.println("Temperature History: " +
                temperatureHistory.subList(Math.max(temperatureHistory.size() - 7, 0), temperatureHistory.size()));
        System.out.println("Humidity History: " +
                humidityHistory.subList(Math.max(humidityHistory.size() - 7, 0), humidityHistory.size()));
    }
}
