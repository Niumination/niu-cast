package f1;

import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class u4<E> extends AbstractQueue<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5399g = 1431655765;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5400i = -1431655766;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5401n = 11;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4<E>.c f5402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4<E>.c f5403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b1.e
    public final int f5404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f5405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5407f;

    public static final class b<B> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f5408d = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator<B> f5409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5411c;

        public static l5 a(b bVar) {
            return l5.from(bVar.f5409a);
        }

        public <T extends B> u4<T> c() {
            return d(Collections.emptySet());
        }

        public <T extends B> u4<T> d(Iterable<? extends T> initialContents) {
            u4<T> u4Var = new u4<>(this, u4.r(this.f5410b, this.f5411c, initialContents));
            Iterator<? extends T> it = initialContents.iterator();
            while (it.hasNext()) {
                u4Var.offer(it.next());
            }
            return u4Var;
        }

        @t1.a
        public b<B> e(int expectedSize) {
            c1.h0.d(expectedSize >= 0);
            this.f5410b = expectedSize;
            return this;
        }

        @t1.a
        public b<B> f(int maximumSize) {
            c1.h0.d(maximumSize > 0);
            this.f5411c = maximumSize;
            return this;
        }

        public final <T extends B> l5<T> g() {
            return l5.from(this.f5409a);
        }

        public b(Comparator<B> comparator) {
            this.f5410b = -1;
            this.f5411c = Integer.MAX_VALUE;
            comparator.getClass();
            this.f5409a = comparator;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l5<E> f5412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Weak
        public u4<E>.c f5413b;

        public c(l5<E> ordering) {
            this.f5412a = ordering;
        }

        public void b(int index, E x10) {
            int iF = f(index, x10);
            if (iF != index) {
                this = this.f5413b;
                index = iF;
            }
            this.c(index, x10);
        }

        @t1.a
        public int c(int i10, E e10) {
            while (i10 > 2) {
                int iK = k(i10);
                Object objK = u4.this.k(iK);
                if (this.f5412a.compare((E) objK, e10) <= 0) {
                    break;
                }
                u4.this.f5405d[i10] = objK;
                i10 = iK;
            }
            u4.this.f5405d[i10] = e10;
            return i10;
        }

        public int d(int i10, int i11) {
            return this.f5412a.compare((E) u4.this.k(i10), (E) u4.this.k(i11));
        }

        public int e(int i10, E e10) {
            int i11 = i(i10);
            if (i11 <= 0 || this.f5412a.compare((E) u4.this.k(i11), e10) >= 0) {
                return f(i10, e10);
            }
            u4 u4Var = u4.this;
            u4Var.f5405d[i10] = u4Var.k(i11);
            u4.this.f5405d[i11] = e10;
            return i11;
        }

        public int f(int i10, E e10) {
            int iM;
            if (i10 == 0) {
                u4.this.f5405d[0] = e10;
                return 0;
            }
            int iM2 = m(i10);
            Object objK = u4.this.k(iM2);
            if (iM2 != 0 && (iM = (m(iM2) * 2) + 2) != iM2) {
                int iL = l(iM);
                u4 u4Var = u4.this;
                if (iL >= u4Var.f5406e) {
                    Object objK2 = u4Var.k(iM);
                    if (this.f5412a.compare((E) objK2, (E) objK) < 0) {
                        iM2 = iM;
                        objK = objK2;
                    }
                }
            }
            if (this.f5412a.compare((E) objK, e10) >= 0) {
                u4.this.f5405d[i10] = e10;
                return i10;
            }
            Object[] objArr = u4.this.f5405d;
            objArr[i10] = objK;
            objArr[iM2] = e10;
            return iM2;
        }

        public int g(int index) {
            while (true) {
                int iJ = j(index);
                if (iJ <= 0) {
                    return index;
                }
                u4.this.f5405d[index] = u4.this.k(iJ);
                index = iJ;
            }
        }

        public int h(int index, int len) {
            if (index >= u4.this.f5406e) {
                return -1;
            }
            c1.h0.g0(index > 0);
            int iMin = Math.min(index, u4.this.f5406e - len) + len;
            for (int i10 = index + 1; i10 < iMin; i10++) {
                if (d(i10, index) < 0) {
                    index = i10;
                }
            }
            return index;
        }

        public int i(int index) {
            return h(l(index), 2);
        }

        public int j(int index) {
            int iL = l(index);
            if (iL < 0) {
                return -1;
            }
            return h(l(iL), 4);
        }

        public final int k(int i10) {
            return m(m(i10));
        }

        public final int l(int i10) {
            return (i10 * 2) + 1;
        }

        public final int m(int i10) {
            return (i10 - 1) / 2;
        }

        public final int n(int i10) {
            return (i10 * 2) + 2;
        }

        public int o(E e10) {
            int iM;
            int iM2 = m(u4.this.f5406e);
            if (iM2 != 0 && (iM = (m(iM2) * 2) + 2) != iM2) {
                int iL = l(iM);
                u4 u4Var = u4.this;
                if (iL >= u4Var.f5406e) {
                    Object objK = u4Var.k(iM);
                    if (this.f5412a.compare((E) objK, e10) < 0) {
                        u4 u4Var2 = u4.this;
                        Object[] objArr = u4Var2.f5405d;
                        objArr[iM] = e10;
                        objArr[u4Var2.f5406e] = objK;
                        return iM;
                    }
                }
            }
            return u4.this.f5406e;
        }

        @gm.a
        public d<E> p(int removeIndex, int vacated, E toTrickle) {
            int iE = e(vacated, toTrickle);
            if (iE == vacated) {
                return null;
            }
            Object objK = iE < removeIndex ? u4.this.k(removeIndex) : u4.this.k(m(removeIndex));
            if (this.f5413b.c(iE, toTrickle) < removeIndex) {
                return new d<>(toTrickle, objK);
            }
            return null;
        }

        public final boolean q(int i10) {
            if (l(i10) < u4.this.f5406e && d(i10, l(i10)) > 0) {
                return false;
            }
            int i11 = (i10 * 2) + 2;
            if (i11 < u4.this.f5406e && d(i10, i11) > 0) {
                return false;
            }
            if (i10 <= 0 || d(i10, m(i10)) <= 0) {
                return i10 <= 2 || d(k(i10), i10) <= 0;
            }
            return false;
        }
    }

    public static class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f5415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final E f5416b;

        public d(E toTrickle, E replaced) {
            this.f5415a = toTrickle;
            this.f5416b = replaced;
        }
    }

    public class e implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public Queue<E> f5420d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.a
        public List<E> f5421e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.a
        public E f5422f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f5423g;

        public e() {
            this.f5417a = -1;
            this.f5418b = -1;
            this.f5419c = u4.this.f5407f;
        }

        public final void a() {
            if (u4.this.f5407f != this.f5419c) {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean b(Iterable<E> elements, E target) {
            Iterator<E> it = elements.iterator();
            while (it.hasNext()) {
                if (it.next() == target) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(int c10) {
            if (this.f5418b < c10) {
                if (this.f5421e != null) {
                    while (true) {
                        u4 u4Var = u4.this;
                        if (c10 >= u4Var.f5406e || !b(this.f5421e, u4Var.k(c10))) {
                            break;
                        } else {
                            c10++;
                        }
                    }
                }
                this.f5418b = c10;
            }
        }

        public final boolean d(Object target) {
            for (int i10 = 0; i10 < u4.this.f5406e; i10++) {
                u4 u4Var = u4.this;
                if (u4Var.f5405d[i10] == target) {
                    u4Var.x(i10);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.f5417a + 1);
            if (this.f5418b < u4.this.f5406e) {
                return true;
            }
            Queue<E> queue = this.f5420d;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            c(this.f5417a + 1);
            int i10 = this.f5418b;
            u4 u4Var = u4.this;
            int i11 = u4Var.f5406e;
            if (i10 < i11) {
                this.f5417a = i10;
                this.f5423g = true;
                return (E) u4Var.k(i10);
            }
            Queue<E> queue = this.f5420d;
            if (queue != null) {
                this.f5417a = i11;
                E ePoll = queue.poll();
                this.f5422f = ePoll;
                if (ePoll != null) {
                    this.f5423g = true;
                    return ePoll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            b0.e(this.f5423g);
            a();
            this.f5423g = false;
            this.f5419c++;
            int i10 = this.f5417a;
            u4 u4Var = u4.this;
            if (i10 >= u4Var.f5406e) {
                E e10 = this.f5422f;
                Objects.requireNonNull(e10);
                c1.h0.g0(d(e10));
                this.f5422f = null;
                return;
            }
            d<E> dVarX = u4Var.x(i10);
            if (dVarX != null) {
                if (this.f5420d == null || this.f5421e == null) {
                    this.f5420d = new ArrayDeque();
                    this.f5421e = new ArrayList(3);
                }
                if (!b(this.f5421e, dVarX.f5415a)) {
                    this.f5420d.add(dVarX.f5415a);
                }
                if (!b(this.f5420d, dVarX.f5416b)) {
                    this.f5421e.add(dVarX.f5416b);
                }
            }
            this.f5417a--;
            this.f5418b--;
        }
    }

    public static int f(int queueSize, int maximumSize) {
        return Math.min(queueSize - 1, maximumSize) + 1;
    }

    public static <E extends Comparable<E>> u4<E> i() {
        return new b(l5.natural()).c();
    }

    public static <E extends Comparable<E>> u4<E> j(Iterable<? extends E> initialContents) {
        return new b(l5.natural()).d(initialContents);
    }

    public static b<Comparable> l(int expectedSize) {
        return new b(l5.natural()).e(expectedSize);
    }

    @b1.e
    public static int r(int configuredExpectedSize, int maximumSize, Iterable<?> initialContents) {
        if (configuredExpectedSize == -1) {
            configuredExpectedSize = 11;
        }
        if (initialContents instanceof Collection) {
            configuredExpectedSize = Math.max(configuredExpectedSize, ((Collection) initialContents).size());
        }
        return f(configuredExpectedSize, maximumSize);
    }

    @b1.e
    public static boolean s(int index) {
        int i10 = ~(~(index + 1));
        c1.h0.h0(i10 > 0, "negative index");
        return (1431655765 & i10) > (i10 & f5400i);
    }

    public static b<Comparable> u(int maximumSize) {
        return new b(l5.natural()).f(maximumSize);
    }

    public static <B> b<B> v(Comparator<B> comparator) {
        return new b<>(comparator);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @t1.a
    public boolean add(E element) {
        offer(element);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @t1.a
    public boolean addAll(Collection<? extends E> newElements) {
        Iterator<? extends E> it = newElements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            offer(it.next());
            z10 = true;
        }
        return z10;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i10 = 0; i10 < this.f5406e; i10++) {
            this.f5405d[i10] = null;
        }
        this.f5406e = 0;
    }

    public Comparator<? super E> comparator() {
        return this.f5402a.f5412a;
    }

    public final int e() {
        int length = this.f5405d.length;
        return f(length < 64 ? (length + 1) * 2 : m1.f.d(length / 2, 3), this.f5404c);
    }

    @b1.e
    public int g() {
        return this.f5405d.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new e();
    }

    public E k(int i10) {
        E e10 = (E) this.f5405d[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @gm.a
    public final d<E> m(int index, E toTrickle) {
        u4<E>.c cVarQ = q(index);
        int iG = cVarQ.g(index);
        int iC = cVarQ.c(iG, toTrickle);
        if (iC == iG) {
            return cVarQ.p(index, iG, toTrickle);
        }
        if (iC < index) {
            return new d<>(toTrickle, k(index));
        }
        return null;
    }

    public final int n() {
        int i10 = this.f5406e;
        if (i10 != 1) {
            return (i10 == 2 || this.f5403b.d(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    public final void o() {
        if (this.f5406e > this.f5405d.length) {
            Object[] objArr = new Object[e()];
            Object[] objArr2 = this.f5405d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f5405d = objArr;
        }
    }

    @Override // java.util.Queue
    @t1.a
    public boolean offer(E element) {
        element.getClass();
        this.f5407f++;
        int i10 = this.f5406e;
        this.f5406e = i10 + 1;
        o();
        q(i10).b(i10, element);
        return this.f5406e <= this.f5404c || pollLast() != element;
    }

    @Override // java.util.Queue
    @gm.a
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return k(0);
    }

    @gm.a
    public E peekFirst() {
        return peek();
    }

    @gm.a
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return k(n());
    }

    @Override // java.util.Queue
    @gm.a
    @t1.a
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return w(0);
    }

    @gm.a
    @t1.a
    public E pollFirst() {
        return poll();
    }

    @gm.a
    @t1.a
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return w(n());
    }

    public final u4<E>.c q(int i10) {
        return s(i10) ? this.f5402a : this.f5403b;
    }

    @t1.a
    public E removeFirst() {
        return remove();
    }

    @t1.a
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return w(n());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f5406e;
    }

    @b1.e
    public boolean t() {
        for (int i10 = 1; i10 < this.f5406e; i10++) {
            if (!q(i10).q(i10)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @b1.d
    public Object[] toArray() {
        int i10 = this.f5406e;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f5405d, 0, objArr, 0, i10);
        return objArr;
    }

    public final E w(int index) {
        E eK = k(index);
        x(index);
        return eK;
    }

    @gm.a
    @t1.a
    @b1.e
    public d<E> x(int index) {
        c1.h0.d0(index, this.f5406e);
        this.f5407f++;
        int i10 = this.f5406e - 1;
        this.f5406e = i10;
        if (i10 == index) {
            this.f5405d[i10] = null;
            return null;
        }
        E eK = k(i10);
        int iO = q(this.f5406e).o(eK);
        if (iO == index) {
            this.f5405d[this.f5406e] = null;
            return null;
        }
        E eK2 = k(this.f5406e);
        this.f5405d[this.f5406e] = null;
        d<E> dVarM = m(index, eK2);
        if (iO < index) {
            return dVarM == null ? new d<>(eK, eK2) : new d<>(eK, dVarM.f5416b);
        }
        return dVarM;
    }

    public u4(b<? super E> builder, int queueSize) {
        l5 l5VarFrom = l5.from(builder.f5409a);
        u4<E>.c cVar = new c(l5VarFrom);
        this.f5402a = cVar;
        u4<E>.c cVar2 = new c(l5VarFrom.reverse());
        this.f5403b = cVar2;
        cVar.f5413b = cVar2;
        cVar2.f5413b = cVar;
        this.f5404c = builder.f5411c;
        this.f5405d = new Object[queueSize];
    }
}
