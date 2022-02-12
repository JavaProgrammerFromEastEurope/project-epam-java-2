package by.epam.java.observers;

import java.util.EventListener;

@FunctionalInterface
public interface IObserver<T> extends EventListener {
    void observe(T array);
}
