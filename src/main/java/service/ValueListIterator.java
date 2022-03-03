package service;

import java.util.List;

public interface ValueListIterator<T, E> {

    void setListHandler(T user);
    int getSize(T user);
    E getCurrentElement();
    List<E> getPreviousElements(int count);
    List<E> getNextElements(int count);
    void resetIndex();
}
