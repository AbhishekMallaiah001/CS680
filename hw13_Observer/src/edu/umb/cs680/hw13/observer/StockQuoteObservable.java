package edu.umb.cs680.hw13.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable  extends Observable{
    private Map<String, Float> mappings = new HashMap<String, Float>();

    void changeQuote(String T, float Q) {
        mappings.put(T, Q);
        setChanged();
        notifyObservers(new StockEvent(T, Q));
    }
}