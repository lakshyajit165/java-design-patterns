package observer;

public class CurrentConditionsDisplay implements Observer{

    private int temp;
    private int humidity;

    public CurrentConditionsDisplay(Subject weatherStation){
        weatherStation.registerObserver(this);
    }
    @Override
    public void update(int temp, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
        currentDisplay();
    }

    public void currentDisplay() {
        System.out.println("Current temperatue: " + this.temp);
        System.out.println("Current humidity: " + this.humidity);
    }
}
