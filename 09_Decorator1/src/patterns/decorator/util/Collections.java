package patterns.decorator.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Collections {

	public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c) {
		return new UnmodifiableCollection<T>(c);
	}

	public static class UnmodifiableCollection<T> implements Collection<T>{
		private final Collection<? extends T> inner;

		public UnmodifiableCollection(Collection<? extends T> inner) {
			this.inner = inner;
		}

		public boolean add(T arg0) {
			throw new UnsupportedOperationException();
		}

		public boolean addAll(Collection<? extends T> arg0) {
			throw new UnsupportedOperationException();
		}

		public void clear() {
			throw new UnsupportedOperationException();
		}

		public boolean contains(Object arg0) {
			return inner.contains(arg0);
		}

		public boolean containsAll(Collection<?> arg0) {
			return inner.containsAll(arg0);
		}

		public boolean equals(Object arg0) {
			return inner.equals(arg0);
		}

		public void forEach(Consumer<? super T> arg0) {
			inner.forEach(arg0);
		}

		public int hashCode() {
			return inner.hashCode();
		}

		public boolean isEmpty() {
			return inner.isEmpty();
		}

		public Iterator<T> iterator() {
			return new UnmodifiableItterator<T>((Iterator<T>) inner.iterator());
		}

		public Stream<T> parallelStream() {
			throw new UnsupportedOperationException();
		}

		public boolean remove(Object arg0) {
			throw new UnsupportedOperationException();
		}

		public boolean removeAll(Collection<?> arg0) {
			throw new UnsupportedOperationException();
		}

		public boolean removeIf(Predicate<? super T> arg0) {
			throw new UnsupportedOperationException();
		}

		public boolean retainAll(Collection<?> arg0) {
			throw new UnsupportedOperationException();
		}

		public int size() {
			return inner.size();
		}

		public Spliterator<T> spliterator() {
			throw new UnsupportedOperationException();
		}

		public Stream<T> stream() {
			throw new UnsupportedOperationException();
		}

		public Object[] toArray() {
			return inner.toArray();
		}

		public <T> T[] toArray(T[] arg0) {
			return inner.toArray(arg0);
		}
	}

	public static class UnmodifiableItterator<T> implements Iterator<T> {
		private Iterator<T> inner;

		public UnmodifiableItterator(Iterator<T> inner) {
			this.inner = inner;
		}

		public void forEachRemaining(Consumer<? super T> arg0) {
			inner.forEachRemaining(arg0);
		}

		public boolean hasNext() {
			return inner.hasNext();
		}

		public T next() {
			return inner.next();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
