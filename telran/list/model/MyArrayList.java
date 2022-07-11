package telran.list.model;

import java.util.Arrays;
import java.util.Iterator;

import telran.list.interfaces.IList;

public class MyArrayList<E> implements IList<E> {
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private Object[] elements;
	private int size;

	public MyArrayList() {
		// elements = new Object[10];
		this(10);
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal capacity " + initialCapacity);
		}
		if (initialCapacity > MAX_ARRAY_SIZE) {
			initialCapacity = MAX_ARRAY_SIZE;
		}
		elements = new Object[initialCapacity];
	}

    @SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
            private int counter;


			@Override
			public boolean hasNext() {
				return counter < size;
			}

			@Override
			public E next() {
                

				return (E) elements[counter++];
			}
        };}
	@Override
	public boolean add(E element) {
		ensureCapacity();
		elements[size++] = element;
		return true;
	}

	private void ensureCapacity() {
		if (size == MAX_ARRAY_SIZE) {
			throw new OutOfMemoryError();
		}
		if (size == elements.length) {
			int newCapacity = elements.length + elements.length / 2 + 1;
			if (newCapacity < 0 || newCapacity > MAX_ARRAY_SIZE) {
				newCapacity = MAX_ARRAY_SIZE;
			}
			elements = Arrays.copyOf(elements, newCapacity);
		}

	}

	@Override
	public void clear() {
		elements = new Object[0];
        size = 0;

	}

	//O(1)
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(int index, E element) {
        checkIndex(index);
        ensureCapacity();
		Object[] copyArr = new Object[size+1];

        if (index == size) {
            add(element);
            return true;
        }
        size++;
		System.arraycopy(elements, 0, copyArr, 0, index);
        copyArr[index] = element;
        System.arraycopy(elements, index, copyArr, index+1, size-index-1);
        this.elements = copyArr;
        
        return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}

	}

	@Override
	public int indexOf(Object o) {
		if (o != null) {
			for (int i = 0; i < size; i++) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o == elements[i]) {
					return i;
				}
			}
		}

		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (o != null) {
			for (int i = size - 1; i >= 0; i--) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (o == elements[i]) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		@SuppressWarnings("unchecked")
		E victim = (E) elements[index];
		System.arraycopy(elements, index + 1, elements, index, --size - index);
		elements[size] = null;
		return victim;
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);
		@SuppressWarnings("unchecked")
		E victim = (E) elements[index];
		elements[index] = element;
		return victim;
	}

}

