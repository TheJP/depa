package ch.fhnw.depa.a01;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E> {
	public int size() {
		int sum = 0;
		for(@SuppressWarnings("unused") E a : this){ ++sum; }
		return sum;
	}
	public boolean isEmpty() { return !iterator().hasNext(); }
	public boolean contains(Object x){
		for(E a : this){
			if(x == a || (a != null && a.equals(x))){ return true; }
		}
		return false;
	}
	public boolean containsAll(Collection<?> c) {
		for(Object a : c){
			if(!contains(a)){ return false; }
		}
		return true;
	}
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for(E a : c){
			result |= add(a);
		}
		return result;
	}
	public boolean remove(Object x) {
		Iterator<E> it = iterator();
		while(it.hasNext()) {
			E a = it.next();
			if(x == a || (a != null && a.equals(x))){ it.remove(); return true; }
		}
		return false;
	}
	public boolean removeAll(Collection<?> c) {
		boolean result = false;
		for(Object x : c){
			result |= remove(x);
		}
		return result;
	}
	public boolean retainAll(Collection<?> c) {
		boolean result = false;
		Iterator<E> it = iterator();
		while(it.hasNext()){
			E a = it.next();
			if(!c.contains(a)){ it.remove(); result = true; }
		}
		return result;
	}
	public void clear() {
		Iterator<E> it = iterator();
		while(it.hasNext()){ it.next(); it.remove(); }
	}
	public Object[] toArray() {
		Object[] arr = new Object[size()];
		return toArray(arr);
	}
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		int i = 0;
		for(E x : this){ a[i++] = (T)x; }
		if(a.length > i){ a[i] = null; } //javadoc?
		return a;
	}
}
