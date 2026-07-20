package eq;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public class e<E> extends AbstractList<E> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4669b;

    public static class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4670a = new b();

        public static <T> b<T> a() {
            return f4670a;
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

    public class c extends d<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4671b;

        public c() {
            this.f4671b = ((AbstractList) e.this).modCount;
        }

        @Override // eq.e.d
        public void a() {
            if (((AbstractList) e.this).modCount == this.f4671b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) e.this).modCount + "; expected: " + this.f4671b);
        }

        @Override // eq.e.d
        public E b() {
            return (E) e.this.f4669b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e.this.clear();
        }
    }

    public static abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4673a;

        public d() {
        }

        public abstract void a();

        public abstract T b();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f4673a;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f4673a) {
                throw new NoSuchElementException();
            }
            this.f4673a = true;
            a();
            return b();
        }

        public d(a aVar) {
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
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
        if (i10 == 2 || i10 == 3) {
            objArr[1] = "iterator";
        } else if (i10 == 5 || i10 == 6 || i10 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i10) {
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
        if (i10 != 2 && i10 != 3 && i10 != 5 && i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        int i10 = this.f4668a;
        if (i10 == 0) {
            this.f4669b = e10;
        } else if (i10 == 1) {
            this.f4669b = new Object[]{this.f4669b, e10};
        } else {
            Object[] objArr = (Object[]) this.f4669b;
            int length = objArr.length;
            if (i10 >= length) {
                int i11 = ((length * 3) / 2) + 1;
                int i12 = i10 + 1;
                if (i11 < i12) {
                    i11 = i12;
                }
                Object[] objArr2 = new Object[i11];
                this.f4669b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f4668a] = e10;
        }
        this.f4668a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f4669b = null;
        this.f4668a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        int i11;
        if (i10 >= 0 && i10 < (i11 = this.f4668a)) {
            return i11 == 1 ? (E) this.f4669b : (E) ((Object[]) this.f4669b)[i10];
        }
        StringBuilder sbA = h.b.a("Index: ", i10, ", Size: ");
        sbA.append(this.f4668a);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @l
    public Iterator<E> iterator() {
        int i10 = this.f4668a;
        if (i10 == 0) {
            b bVarA = b.a();
            if (bVarA == null) {
                a(2);
            }
            return bVarA;
        }
        if (i10 == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            a(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        int i11;
        E e10;
        if (i10 < 0 || i10 >= (i11 = this.f4668a)) {
            StringBuilder sbA = h.b.a("Index: ", i10, ", Size: ");
            sbA.append(this.f4668a);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        if (i11 == 1) {
            e10 = (E) this.f4669b;
            this.f4669b = null;
        } else {
            Object[] objArr = (Object[]) this.f4669b;
            Object obj = objArr[i10];
            if (i11 == 2) {
                this.f4669b = objArr[1 - i10];
            } else {
                int i12 = (i11 - i10) - 1;
                if (i12 > 0) {
                    System.arraycopy(objArr, i10 + 1, objArr, i10, i12);
                }
                objArr[this.f4668a - 1] = null;
            }
            e10 = (E) obj;
        }
        this.f4668a--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f4668a)) {
            StringBuilder sbA = h.b.a("Index: ", i10, ", Size: ");
            sbA.append(this.f4668a);
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        if (i11 == 1) {
            E e11 = (E) this.f4669b;
            this.f4669b = e10;
            return e11;
        }
        Object[] objArr = (Object[]) this.f4669b;
        E e12 = (E) objArr[i10];
        objArr[i10] = e10;
        return e12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f4668a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @l
    public <T> T[] toArray(@l T[] tArr) {
        if (tArr == 0) {
            a(4);
        }
        int length = tArr.length;
        int i10 = this.f4668a;
        if (i10 == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.f4669b;
                return tArr2;
            }
            tArr[0] = this.f4669b;
        } else {
            if (length < i10) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.f4669b, i10, tArr.getClass());
                if (tArr3 == null) {
                    a(6);
                }
                return tArr3;
            }
            if (i10 != 0) {
                System.arraycopy(this.f4669b, 0, tArr, 0, i10);
            }
        }
        int i11 = this.f4668a;
        if (length > i11) {
            tArr[i11] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        int i11;
        if (i10 >= 0 && i10 <= (i11 = this.f4668a)) {
            if (i11 == 0) {
                this.f4669b = e10;
            } else if (i11 == 1 && i10 == 0) {
                this.f4669b = new Object[]{e10, this.f4669b};
            } else {
                Object[] objArr = new Object[i11 + 1];
                if (i11 == 1) {
                    objArr[0] = this.f4669b;
                } else {
                    Object[] objArr2 = (Object[]) this.f4669b;
                    System.arraycopy(objArr2, 0, objArr, 0, i10);
                    System.arraycopy(objArr2, i10, objArr, i10 + 1, this.f4668a - i10);
                }
                objArr[i10] = e10;
                this.f4669b = objArr;
            }
            this.f4668a++;
            ((AbstractList) this).modCount++;
            return;
        }
        StringBuilder sbA = h.b.a("Index: ", i10, ", Size: ");
        sbA.append(this.f4668a);
        throw new IndexOutOfBoundsException(sbA.toString());
    }
}
