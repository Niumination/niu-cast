package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
@b1.d
public final class d1<E extends Enum<E>> extends i<E> implements Serializable {

    @b1.c
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Class<E> f4787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient E[] f4788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int[] f4789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int f4790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient long f4791g;

    public class a extends d1<E>.c<E> {
        public a() {
            super();
        }

        @Override // f1.d1.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(int i10) {
            return (E) d1.this.f4788d[i10];
        }
    }

    public class b extends d1<E>.c<b5.a<E>> {

        public class a extends c5.f<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f4794a;

            public a(final int val$index) {
                this.f4794a = val$index;
            }

            @Override // f1.b5.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public E getElement() {
                return (E) d1.this.f4788d[this.f4794a];
            }

            @Override // f1.b5.a
            public int getCount() {
                return d1.this.f4789e[this.f4794a];
            }
        }

        public b() {
            super();
        }

        @Override // f1.d1.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b5.a<E> a(final int index) {
            return new a(index);
        }
    }

    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4796a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4797b = -1;

        public c() {
        }

        public abstract T a(int index);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f4796a < d1.this.f4788d.length) {
                int[] iArr = d1.this.f4789e;
                int i10 = this.f4796a;
                if (iArr[i10] > 0) {
                    return true;
                }
                this.f4796a = i10 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tA = a(this.f4796a);
            int i10 = this.f4796a;
            this.f4797b = i10;
            this.f4796a = i10 + 1;
            return tA;
        }

        @Override // java.util.Iterator
        public void remove() {
            b0.e(this.f4797b >= 0);
            if (d1.this.f4789e[this.f4797b] > 0) {
                d1.access$210(d1.this);
                d1 d1Var = d1.this;
                d1.access$322(d1Var, d1Var.f4789e[this.f4797b]);
                d1.this.f4789e[this.f4797b] = 0;
            }
            this.f4797b = -1;
        }
    }

    public d1(Class<E> type) {
        this.f4787c = type;
        c1.h0.d(type.isEnum());
        E[] enumConstants = type.getEnumConstants();
        this.f4788d = enumConstants;
        this.f4789e = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(d1 d1Var) {
        int i10 = d1Var.f4790f;
        d1Var.f4790f = i10 - 1;
        return i10;
    }

    public static /* synthetic */ long access$322(d1 d1Var, long j10) {
        long j11 = d1Var.f4791g - j10;
        d1Var.f4791g = j11;
        return j11;
    }

    public static <E extends Enum<E>> d1<E> create(Class<E> type) {
        return new d1<>(type);
    }

    @b1.c
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        Object object = stream.readObject();
        Objects.requireNonNull(object);
        Class<E> cls = (Class) object;
        this.f4787c = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.f4788d = enumConstants;
        this.f4789e = new int[enumConstants.length];
        i6.f(this, stream);
    }

    @b1.c
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.f4787c);
        i6.k(this, stream);
    }

    public final void a(Object element) {
        element.getClass();
        if (b(element)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.f4787c + " but got " + element);
    }

    public final boolean b(@gm.a Object o10) {
        if (!(o10 instanceof Enum)) {
            return false;
        }
        Enum r10 = (Enum) o10;
        int iOrdinal = r10.ordinal();
        E[] eArr = this.f4788d;
        return iOrdinal < eArr.length && eArr[iOrdinal] == r10;
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.f4789e, 0);
        this.f4791g = 0L;
        this.f4790f = 0;
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection, f1.b5
    public /* bridge */ /* synthetic */ boolean contains(@gm.a Object element) {
        return super.contains(element);
    }

    @Override // f1.b5
    public int count(@gm.a Object element) {
        if (element == null || !b(element)) {
            return 0;
        }
        return this.f4789e[((Enum) element).ordinal()];
    }

    @Override // f1.i
    public int distinctElements() {
        return this.f4790f;
    }

    @Override // f1.i
    public Iterator<E> elementIterator() {
        return new a();
    }

    @Override // f1.i, f1.b5, f1.r6, f1.s6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // f1.i
    public Iterator<b5.a<E>> entryIterator() {
        return new b();
    }

    @Override // f1.i, f1.b5
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, f1.b5
    public Iterator<E> iterator() {
        return c5.n(this);
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int remove(@gm.a Object element, int occurrences) {
        if (element == null || !b(element)) {
            return 0;
        }
        Enum r10 = (Enum) element;
        b0.b(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        int iOrdinal = r10.ordinal();
        int[] iArr = this.f4789e;
        int i10 = iArr[iOrdinal];
        if (i10 == 0) {
            return 0;
        }
        if (i10 <= occurrences) {
            iArr[iOrdinal] = 0;
            this.f4790f--;
            this.f4791g -= (long) i10;
        } else {
            iArr[iOrdinal] = i10 - occurrences;
            this.f4791g -= (long) occurrences;
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public int size() {
        return o1.l.z(this.f4791g);
    }

    public static <E extends Enum<E>> d1<E> create(Iterable<E> elements) {
        Iterator<E> it = elements.iterator();
        c1.h0.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        d1<E> d1Var = new d1<>(it.next().getDeclaringClass());
        g4.a(d1Var, elements);
        return d1Var;
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int add(E element, int occurrences) {
        a(element);
        b0.b(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        int iOrdinal = element.ordinal();
        int i10 = this.f4789e[iOrdinal];
        long j10 = occurrences;
        long j11 = ((long) i10) + j10;
        c1.h0.p(j11 <= 2147483647L, "too many occurrences: %s", j11);
        this.f4789e[iOrdinal] = (int) j11;
        if (i10 == 0) {
            this.f4790f++;
        }
        this.f4791g += j10;
        return i10;
    }

    @Override // f1.i, f1.b5
    @t1.a
    public boolean setCount(@m5 Object element, int oldCount, int newCount) {
        return c5.w(this, element, oldCount, newCount);
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int setCount(E element, int count) {
        a(element);
        b0.b(count, "count");
        int iOrdinal = element.ordinal();
        int[] iArr = this.f4789e;
        int i10 = iArr[iOrdinal];
        iArr[iOrdinal] = count;
        this.f4791g += (long) (count - i10);
        if (i10 == 0 && count > 0) {
            this.f4790f++;
        } else if (i10 > 0 && count == 0) {
            this.f4790f--;
        }
        return i10;
    }

    public static <E extends Enum<E>> d1<E> create(Iterable<E> elements, Class<E> type) {
        d1<E> d1VarCreate = create(type);
        g4.a(d1VarCreate, elements);
        return d1VarCreate;
    }
}
