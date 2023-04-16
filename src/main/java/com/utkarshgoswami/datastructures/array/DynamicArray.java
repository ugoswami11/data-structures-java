package com.utkarshgoswami.datastructures.array;

@SuppressWarnings(value = { "unchecked" })
public class DynamicArray<T> implements Iterable<T> {

	private T[] arr;
	private int len = 0;
	private int capacity = 0;

	public DynamicArray() {
		this(16);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public T get(int index) {
		if (isEmpty()) {
			throw new IllegalArgumentException("Illegal argument: Array is empty");
		} else {
			return arr[index];
		}
	}

	public void set(int index, T value) {
		if (index >= 0 && index < len) {
			arr[index] = value;
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}

	public void add(T value) {
		if (len + 1 >= capacity) {
			if (capacity == 0) {
				capacity = 1;
			}
			capacity *= 2;
			T[] new_arr = (T[]) new Object[capacity];

			for (int i = 0; i < len; i++) {
				new_arr[i] = arr[i];
			}
			arr = new_arr;
		}
		arr[len++] = value;
	}

	public void clear() {
		for (int i = 0; i < len; i++) {
			arr[i] = null;
		}
		len = 0;
	}

	public T removeAt(int index) {
		if (index >= 0 && index < len) {

			T[] new_arr = (T[]) new Object[len - 1];
			T value = arr[index];

			for (int i = 0, j = 0; i < len; i++, j++) {
				if (i == index) {
					j--;
				} else {
					new_arr[j] = arr[i];
				}
			}
			arr = new_arr;
			capacity = --len;
			return value;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean remove(T value) {
		int index = indexOf(value);
		if (index == -1)
			return false;
		removeAt(index);
		return true;
	}

	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	public int indexOf(T value) {
		for (int i = 0; i < len; i++) {
			if (value == null) {
				if (arr[i] == null)
					return i;
			} else if (value.equals(arr[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public java.util.Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index > len;
			}

			@Override
			public T next() {
				return arr[index++];
			}

		};
	}

	public String toString() {
		if (len == 0)
			return "[]";
		else {
			StringBuilder sb = new StringBuilder(len).append("[");
			for (int i = 0; i < len - 1; i++) {
				sb.append(arr[i] + ", ");
			}
			return sb.append(arr[len - 1] + "]").toString();
		}
	}
}
