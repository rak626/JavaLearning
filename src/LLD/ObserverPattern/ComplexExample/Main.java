package LLD.ObserverPattern.ComplexExample;

import LLD.ObserverPattern.ComplexExample.Observable.WeatherStation;
import LLD.ObserverPattern.ComplexExample.Observer.LCDDisplay;
import LLD.ObserverPattern.ComplexExample.Observer.PhoneDisplay;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        PhoneDisplay phoneDisplay = new PhoneDisplay(weatherStation);
        LCDDisplay lcdDisplay = new LCDDisplay(weatherStation);

        weatherStation.setMeasurements(25.0f, 65.0f, 1013.0f);
        weatherStation.setMeasurements(27.0f, 70.0f, 1012.0f);

        weatherStation.removeObserver(phoneDisplay);

        weatherStation.setMeasurements(30.0f, 75.0f, 1011.0f);
    }
}
