package service;

import java.util.List;

public interface ValueListIterator<T> {

    int getSize();
    T getCurrentElement();
    List<T> getPreviousElements(int count);
    List<T> getNextElements(int count);
}
