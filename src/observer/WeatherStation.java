package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    private int temperature;
    private int humidity;
    private List<Observer> observerList;

    public WeatherStation() {
        this.observerList = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int observerIndex = observerList.indexOf(o);
        if(observerIndex >= 0){
            observerList.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(o -> o.update(temperature, humidity));
    }

    public void measurementsChanged(int temp, int hum){
        this.temperature = temp;
        this.humidity = hum;
        notifyObservers();
    }
}
