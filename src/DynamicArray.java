import java.io.Serializable;
import java.util.Iterator;

/**
 * @author 1ommy
 * @version 21.10.2023
 */
public class DynamicArray<Type> implements Serializable, Iterable<Type> {
    // вместимость,сколько у нас ячеек в массиве
    private int capacity;

    // сколько у нас ЗАПОЛНЕННЫХ ячеек
    private int size;

    private Type[] array;

    public DynamicArray(int capacity) {
        array = (Type[]) new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public void insert(Type element) {
        if (size + 1 >= capacity) resize();

        array[size++] = element;
    }


    public int findElement(Type element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    public Type at(int index) {
        return array[index];
    }

    public void removeElement(Type element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                for (int j = i; j < size; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
    }


    public void resize() {
        capacity = capacity * 2;

        Type[] new_array = (Type[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            new_array[i] = array[i];
        }

        array = new_array;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Type> iterator() {
        return new DynamicArrayIterator();
    }

    private class DynamicArrayIterator implements Iterator<Type> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Type next() {
            return array[currentIndex++];
        }
    }
}
