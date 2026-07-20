package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@b1.d
public final class n0<E> extends i<E> implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ConcurrentMap<E, AtomicInteger> f5103c;

    public class b extends f1.c<b5.a<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Iterator<Map.Entry<E, AtomicInteger>> f5105c;

        public b() {
            this.f5105c = n0.this.f5103c.entrySet().iterator();
        }

        @Override // f1.c
        @gm.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b5.a<E> a() {
            while (this.f5105c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f5105c.next();
                int i10 = next.getValue().get();
                if (i10 != 0) {
                    return new c5.k(next.getKey(), i10);
                }
            }
            this.f4711a = f1.c.b.DONE;
            return null;
        }
    }

    public class c extends z1<b5.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public b5.a<E> f5107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f5108b;

        public c(final Iterator val$readOnlyIterator) {
            this.f5108b = val$readOnlyIterator;
        }

        @Override // f1.z1, f1.j2
        /* JADX INFO: renamed from: l */
        public Iterator<b5.a<E>> delegate() {
            return this.f5108b;
        }

        @Override // f1.z1, java.util.Iterator
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b5.a<E> next() {
            b5.a<E> aVar = (b5.a) super.next();
            this.f5107a = aVar;
            return aVar;
        }

        @Override // f1.z1, java.util.Iterator
        public void remove() {
            c1.h0.h0(this.f5107a != null, "no calls to next() since the last call to remove()");
            n0.this.setCount(this.f5107a.getElement(), 0);
            this.f5107a = null;
        }
    }

    public class d extends i<E>.b {
        public d() {
            super();
        }

        @Override // f1.i.b, f1.c5.i
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n0<E> a() {
            return n0.this;
        }

        public final List<b5.a<E>> c() {
            ArrayList arrayListV = p4.v(size());
            h4.a(arrayListV, iterator());
            return arrayListV;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return c().toArray();
        }

        public /* synthetic */ d(n0 n0Var, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) c().toArray(tArr);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i6.b<n0> f5111a = i6.a(n0.class, "countMap");
    }

    @b1.e
    public n0(ConcurrentMap<E, AtomicInteger> countMap) {
        c1.h0.u(countMap.isEmpty(), "the backing map (%s) must be empty", countMap);
        this.f5103c = countMap;
    }

    public static <E> n0<E> create() {
        return new n0<>(new ConcurrentHashMap());
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        Object object = stream.readObject();
        Objects.requireNonNull(object);
        e.f5111a.b(this, (ConcurrentMap) object);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.f5103c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<E> a() {
        ArrayList arrayListV = p4.v(size());
        for (b5.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                arrayListV.add(element);
            }
        }
        return arrayListV;
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int add(E element, int occurrences) {
        AtomicInteger atomicIntegerPutIfAbsent;
        int i10;
        AtomicInteger atomicInteger;
        element.getClass();
        if (occurrences == 0) {
            return count(element);
        }
        b0.d(occurrences, "occurrences");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) t4.p0(this.f5103c, element);
            if (atomicIntegerPutIfAbsent == null && (atomicIntegerPutIfAbsent = this.f5103c.putIfAbsent(element, new AtomicInteger(occurrences))) == null) {
                return 0;
            }
            do {
                i10 = atomicIntegerPutIfAbsent.get();
                if (i10 == 0) {
                    atomicInteger = new AtomicInteger(occurrences);
                    if (this.f5103c.putIfAbsent(element, atomicInteger) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException(e0.a.a("Overflow adding ", occurrences, " occurrences to a count of ", i10));
                    }
                }
            } while (!atomicIntegerPutIfAbsent.compareAndSet(i10, m1.f.c(i10, occurrences)));
            return i10;
        } while (!this.f5103c.replace(element, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f5103c.clear();
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection, f1.b5
    public /* bridge */ /* synthetic */ boolean contains(@gm.a Object element) {
        return super.contains(element);
    }

    @Override // f1.b5
    public int count(@gm.a Object element) {
        AtomicInteger atomicInteger = (AtomicInteger) t4.p0(this.f5103c, element);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // f1.i
    public Set<E> createElementSet() {
        return new a(this, this.f5103c.keySet());
    }

    @Override // f1.i
    @Deprecated
    public Set<b5.a<E>> createEntrySet() {
        return new d();
    }

    @Override // f1.i
    public int distinctElements() {
        return this.f5103c.size();
    }

    @Override // f1.i
    public Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.i, f1.b5, f1.r6, f1.s6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // f1.i
    public Iterator<b5.a<E>> entryIterator() {
        return new c(new b());
    }

    @Override // f1.i, f1.b5
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // f1.i, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f5103c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, f1.b5
    public Iterator<E> iterator() {
        return c5.n(this);
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int remove(@gm.a Object element, int occurrences) {
        int i10;
        int iMax;
        if (occurrences == 0) {
            return count(element);
        }
        b0.d(occurrences, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) t4.p0(this.f5103c, element);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i10 = atomicInteger.get();
            if (i10 == 0) {
                return 0;
            }
            iMax = Math.max(0, i10 - occurrences);
        } while (!atomicInteger.compareAndSet(i10, iMax));
        if (iMax == 0) {
            this.f5103c.remove(element, atomicInteger);
        }
        return i10;
    }

    @t1.a
    public boolean removeExactly(@gm.a Object element, int occurrences) {
        int i10;
        int i11;
        if (occurrences == 0) {
            return true;
        }
        b0.d(occurrences, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) t4.p0(this.f5103c, element);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i10 = atomicInteger.get();
            if (i10 < occurrences) {
                return false;
            }
            i11 = i10 - occurrences;
        } while (!atomicInteger.compareAndSet(i10, i11));
        if (i11 == 0) {
            this.f5103c.remove(element, atomicInteger);
        }
        return true;
    }

    @Override // f1.i, f1.b5
    @t1.a
    public int setCount(E element, int count) {
        AtomicInteger atomicIntegerPutIfAbsent;
        AtomicInteger atomicInteger;
        element.getClass();
        b0.b(count, "count");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) t4.p0(this.f5103c, element);
            if (atomicIntegerPutIfAbsent != null || (count != 0 && (atomicIntegerPutIfAbsent = this.f5103c.putIfAbsent(element, new AtomicInteger(count))) != null)) {
                while (true) {
                    int i10 = atomicIntegerPutIfAbsent.get();
                    if (i10 == 0) {
                        break;
                    }
                    if (atomicIntegerPutIfAbsent.compareAndSet(i10, count)) {
                        if (count == 0) {
                            this.f5103c.remove(element, atomicIntegerPutIfAbsent);
                        }
                        return i10;
                    }
                }
                if (count != 0) {
                    atomicInteger = new AtomicInteger(count);
                    if (this.f5103c.putIfAbsent(element, atomicInteger) == null) {
                        break;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } while (!this.f5103c.replace(element, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public int size() {
        Iterator<AtomicInteger> it = this.f5103c.values().iterator();
        long j10 = 0;
        while (it.hasNext()) {
            j10 += (long) it.next().get();
        }
        return o1.l.z(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return a().toArray();
    }

    public class a extends l2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f5104a;

        public a(final n0 this$0, final Set val$delegate) {
            this.f5104a = val$delegate;
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return object != null && c0.j(this.f5104a, object);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object object) {
            return object != null && c0.k(this.f5104a, object);
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c10) {
            return standardRemoveAll(c10);
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<E> delegate() {
            return this.f5104a;
        }
    }

    public static <E> n0<E> create(Iterable<? extends E> elements) {
        n0<E> n0VarCreate = create();
        g4.a(n0VarCreate, elements);
        return n0VarCreate;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) a().toArray(tArr);
    }

    public static <E> n0<E> create(ConcurrentMap<E, AtomicInteger> countMap) {
        return new n0<>(countMap);
    }

    @Override // f1.i, f1.b5
    @t1.a
    public boolean setCount(E element, int expectedOldCount, int newCount) {
        element.getClass();
        b0.b(expectedOldCount, "oldCount");
        b0.b(newCount, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) t4.p0(this.f5103c, element);
        if (atomicInteger == null) {
            if (expectedOldCount != 0) {
                return false;
            }
            return newCount == 0 || this.f5103c.putIfAbsent(element, new AtomicInteger(newCount)) == null;
        }
        int i10 = atomicInteger.get();
        if (i10 == expectedOldCount) {
            if (i10 == 0) {
                if (newCount == 0) {
                    this.f5103c.remove(element, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(newCount);
                return this.f5103c.putIfAbsent(element, atomicInteger2) == null || this.f5103c.replace(element, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i10, newCount)) {
                if (newCount == 0) {
                    this.f5103c.remove(element, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
