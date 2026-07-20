package kotlin.reflect.jvm.internal.impl.utils;

import a1.a;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

    public static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    public class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = ((AbstractList) SmartList.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public void checkCoModification() {
            if (((AbstractList) SmartList.this).modCount == this.myInitialModCount) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) SmartList.this).modCount + "; expected: " + this.myInitialModCount);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public E getElement() {
            return (E) SmartList.this.myElem;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    public static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        private SingletonIteratorBase() {
        }

        public abstract void checkCoModification();

        public abstract T getElement();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.myVisited) {
                throw new NoSuchElementException();
            }
            this.myVisited = true;
            checkCoModification();
            return getElement();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i8) {
        String str = (i8 == 2 || i8 == 3 || i8 == 5 || i8 == 6 || i8 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 2 || i8 == 3 || i8 == 5 || i8 == 6 || i8 == 7) ? 2 : 3];
        switch (i8) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i8 == 2 || i8 == 3) {
            objArr[1] = "iterator";
        } else if (i8 == 5 || i8 == 6 || i8 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i8) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i8 != 2 && i8 != 3 && i8 != 5 && i8 != 6 && i8 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        int i8 = this.mySize;
        if (i8 == 0) {
            this.myElem = e;
        } else if (i8 == 1) {
            this.myElem = new Object[]{this.myElem, e};
        } else {
            Object[] objArr = (Object[]) this.myElem;
            int length = objArr.length;
            if (i8 >= length) {
                int i9 = ((length * 3) / 2) + 1;
                int i10 = i8 + 1;
                if (i9 < i10) {
                    i9 = i10;
                }
                Object[] objArr2 = new Object[i9];
                this.myElem = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.mySize] = e;
        }
        this.mySize++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i8) {
        int i9;
        if (i8 >= 0 && i8 < (i9 = this.mySize)) {
            return i9 == 1 ? (E) this.myElem : (E) ((Object[]) this.myElem)[i8];
        }
        StringBuilder sbU = a.u(i8, "Index: ", ", Size: ");
        sbU.append(this.mySize);
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int i8 = this.mySize;
        if (i8 == 0) {
            EmptyIterator emptyIterator = EmptyIterator.getInstance();
            if (emptyIterator == null) {
                $$$reportNull$$$0(2);
            }
            return emptyIterator;
        }
        if (i8 == 1) {
            return new SingletonIterator();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            $$$reportNull$$$0(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i8) {
        int i9;
        E e;
        if (i8 < 0 || i8 >= (i9 = this.mySize)) {
            StringBuilder sbU = a.u(i8, "Index: ", ", Size: ");
            sbU.append(this.mySize);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (i9 == 1) {
            e = (E) this.myElem;
            this.myElem = null;
        } else {
            Object[] objArr = (Object[]) this.myElem;
            Object obj = objArr[i8];
            if (i9 == 2) {
                this.myElem = objArr[1 - i8];
            } else {
                int i10 = (i9 - i8) - 1;
                if (i10 > 0) {
                    System.arraycopy(objArr, i8 + 1, objArr, i8, i10);
                }
                objArr[this.mySize - 1] = null;
            }
            e = (E) obj;
        }
        this.mySize--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i8, E e) {
        int i9;
        if (i8 < 0 || i8 >= (i9 = this.mySize)) {
            StringBuilder sbU = a.u(i8, "Index: ", ", Size: ");
            sbU.append(this.mySize);
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (i9 == 1) {
            E e4 = (E) this.myElem;
            this.myElem = e;
            return e4;
        }
        Object[] objArr = (Object[]) this.myElem;
        E e10 = (E) objArr[i8];
        objArr[i8] = e;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> comparator) {
        int i8 = this.mySize;
        if (i8 >= 2) {
            Arrays.sort((Object[]) this.myElem, 0, i8, comparator);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            $$$reportNull$$$0(4);
        }
        int length = tArr.length;
        int i8 = this.mySize;
        if (i8 == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.myElem;
                return tArr2;
            }
            tArr[0] = this.myElem;
        } else {
            if (length < i8) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.myElem, i8, tArr.getClass());
                if (tArr3 == null) {
                    $$$reportNull$$$0(6);
                }
                return tArr3;
            }
            if (i8 != 0) {
                System.arraycopy(this.myElem, 0, tArr, 0, i8);
            }
        }
        int i9 = this.mySize;
        if (length > i9) {
            tArr[i9] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, E e) {
        int i9;
        if (i8 >= 0 && i8 <= (i9 = this.mySize)) {
            if (i9 == 0) {
                this.myElem = e;
            } else if (i9 == 1 && i8 == 0) {
                this.myElem = new Object[]{e, this.myElem};
            } else {
                Object[] objArr = new Object[i9 + 1];
                if (i9 == 1) {
                    objArr[0] = this.myElem;
                } else {
                    Object[] objArr2 = (Object[]) this.myElem;
                    System.arraycopy(objArr2, 0, objArr, 0, i8);
                    System.arraycopy(objArr2, i8, objArr, i8 + 1, this.mySize - i8);
                }
                objArr[i8] = e;
                this.myElem = objArr;
            }
            this.mySize++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbU = a.u(i8, "Index: ", ", Size: ");
        sbU.append(this.mySize);
        throw new IndexOutOfBoundsException(sbU.toString());
    }
}
