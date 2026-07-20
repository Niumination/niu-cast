package hl;

import fl.p0;
import il.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kn.l0;
import kn.l1;
import kn.v;
import kn.x0;
import lm.l2;
import nm.y;
import os.l;
import os.m;
import pl.e0;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> implements List<T>, ln.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f7244d = {l1.k(new x0(c.class, "data", "getData()Lio/ktor/util/collections/internal/SharedList;", 0)), l1.f9319a.i(new x0(c.class, ik.f.b.f7973h, "getSize()I", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final qn.f f7245a = new b(new i(32));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final qn.f f7246b = new C0199c(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final Object f7247c = new Object();

    public static final class a implements ListIterator<T>, ln.f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ o<Object>[] f7248d = {l1.k(new x0(a.class, "current", "getCurrent()I", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final qn.f f7249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c<T> f7251c;

        /* JADX INFO: renamed from: hl.c$a$a, reason: collision with other inner class name */
        public static final class C0198a implements qn.f<Object, Integer> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f7252a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f7253b;

            /* JADX WARN: Multi-variable type inference failed */
            public C0198a(Object obj) {
                this.f7253b = obj;
                this.f7252a = obj;
            }

            @Override // qn.f, qn.e
            public Integer a(@l Object obj, @l o<?> oVar) {
                l0.p(obj, "thisRef");
                l0.p(oVar, "property");
                return this.f7252a;
            }

            @Override // qn.f
            public void b(@l Object obj, @l o<?> oVar, Integer num) {
                l0.p(obj, "thisRef");
                l0.p(oVar, "property");
                this.f7252a = num;
            }
        }

        public a(int i10, c<T> cVar) {
            this.f7250b = i10;
            this.f7251c = cVar;
            this.f7249a = new C0198a(Integer.valueOf(i10));
        }

        public final int a() {
            return ((Number) this.f7249a.a(this, f7248d[0])).intValue();
        }

        @Override // java.util.ListIterator
        public void add(T t10) {
            this.f7251c.add(a(), t10);
        }

        public final void c(int i10) {
            this.f7249a.b(this, f7248d[0], Integer.valueOf(i10));
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return a() < this.f7251c.e();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            c<T> cVar = this.f7251c;
            int iA = a();
            c(iA + 1);
            return cVar.get(iA);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a() + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            c<T> cVar = this.f7251c;
            int iA = a();
            c(iA - 1);
            return cVar.get(iA);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f7251c.i(a() - 1);
            c(a() - 1);
        }

        @Override // java.util.ListIterator
        public void set(T t10) {
            this.f7251c.set(a() - 1, t10);
        }
    }

    public static final class b implements qn.f<Object, i<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i<T> f7254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f7255b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj) {
            this.f7255b = obj;
            this.f7254a = obj;
        }

        @Override // qn.f, qn.e
        public i<T> a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f7254a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, i<T> iVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f7254a = iVar;
        }
    }

    /* JADX INFO: renamed from: hl.c$c, reason: collision with other inner class name */
    public static final class C0199c implements qn.f<Object, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f7256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f7257b;

        /* JADX WARN: Multi-variable type inference failed */
        public C0199c(Object obj) {
            this.f7257b = obj;
            this.f7256a = obj;
        }

        @Override // qn.f, qn.e
        public Integer a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f7256a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, Integer num) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f7256a = num;
        }
    }

    public c() {
        e0.a(this);
    }

    public static void g(c cVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = cVar.c().f8279a * 2;
        }
        cVar.f(i10);
    }

    public final void a(int i10) {
        if (i10 >= e() || i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t10) {
        synchronized (this.f7247c) {
            try {
                if (e() >= c().f8279a) {
                    g(this, 0, 1, null);
                }
                c().c(e(), t10);
                m(e() + 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i10, @l Collection<? extends T> collection) {
        l0.p(collection, "elements");
        j(i10, collection.size());
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            c().c(i10, it.next());
            i10++;
        }
        return !collection.isEmpty();
    }

    public final i<T> c() {
        return (i) this.f7245a.a(this, f7244d[0]);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        synchronized (this.f7247c) {
            l(new i<>(32));
            m(0);
            l2 l2Var = l2.f10208a;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int e() {
        return ((Number) this.f7246b.a(this, f7244d[1])).intValue();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@m Object obj) {
        boolean z10;
        synchronized (this.f7247c) {
            z10 = false;
            if (obj != null) {
                try {
                    if ((obj instanceof List) && ((List) obj).size() == e()) {
                        int i10 = 0;
                        for (T t10 : this) {
                            int i11 = i10 + 1;
                            if (i10 < 0) {
                                y.Z();
                            }
                            if (l0.g(((List) obj).get(i10), t10)) {
                                i10 = i11;
                            }
                        }
                        z10 = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(int i10) {
        i iVar = new i(i10);
        int i11 = c().f8279a;
        for (int i12 = 0; i12 < i11; i12++) {
            iVar.c(i12, c().f8280b.get(i12));
        }
        l(iVar);
    }

    @Override // java.util.List
    public T get(int i10) {
        T t10;
        synchronized (this.f7247c) {
            if (i10 >= e()) {
                throw new NoSuchElementException();
            }
            t10 = (T) c().f8280b.get(i10);
            l0.m(t10);
        }
        return t10;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int iA;
        synchronized (this.f7247c) {
            Iterator<T> it = iterator();
            iA = 7;
            while (it.hasNext()) {
                T next = it.next();
                iA = p0.f6086a.a(Integer.valueOf(iA), Integer.valueOf(next == null ? 0 : next.hashCode()));
            }
        }
        return iA;
    }

    public T i(int i10) {
        T t10;
        synchronized (this.f7247c) {
            a(i10);
            t10 = (T) c().f8280b.get(i10);
            c().c(i10, null);
            n(i10);
            l0.m(t10);
        }
        return t10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        synchronized (this.f7247c) {
            int iE = e();
            int i10 = 0;
            while (i10 < iE) {
                int i11 = i10 + 1;
                if (l0.g(c().f8280b.get(i10), obj)) {
                    return i10;
                }
                i10 = i11;
            }
            return -1;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return e() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @l
    public Iterator<T> iterator() {
        return listIterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(int i10, int i11) {
        int iE = e() + i11;
        while (c().f8279a < iE) {
            g(this, 0, 1, null);
        }
        for (int iE2 = e() - 1; iE2 >= i10; iE2--) {
            c().c(iE2 + i11, c().f8280b.get(iE2));
        }
        int i12 = i10 + i11;
        while (i10 < i12) {
            c().c(i10, null);
            i10++;
        }
        m(e() + i11);
    }

    public final void l(i<T> iVar) {
        this.f7245a.b(this, f7244d[0], iVar);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        synchronized (this.f7247c) {
            int iE = e() - 1;
            if (iE >= 0) {
                while (true) {
                    int i10 = iE - 1;
                    if (l0.g(c().f8280b.get(iE), obj)) {
                        return iE;
                    }
                    if (i10 >= 0) {
                        iE = i10;
                    }
                }
            }
            return -1;
        }
    }

    @Override // java.util.List
    @l
    public ListIterator<T> listIterator() {
        return new a(0, this);
    }

    public final void m(int i10) {
        this.f7246b.b(this, f7244d[1], Integer.valueOf(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(int i10) {
        int i11 = i10 + 1;
        int iE = e();
        while (i11 < iE) {
            int i12 = i11 + 1;
            if (c().f8280b.get(i11) != null) {
                c().c(i10, c().f8280b.get(i11));
                i10++;
            }
            i11 = i12;
        }
        int iE2 = e();
        for (int i13 = i10; i13 < iE2; i13++) {
            c().c(i13, null);
        }
        m(i10);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i10) {
        return i(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Iterator<T> it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@l Collection<? extends Object> collection) {
        boolean z10;
        l0.p(collection, "elements");
        synchronized (this.f7247c) {
            try {
                int iE = e();
                int i10 = 0;
                int i11 = -1;
                z10 = false;
                while (i10 < iE) {
                    int i12 = i10 + 1;
                    Object obj = c().f8280b.get(i10);
                    l0.m(obj);
                    if (!collection.contains(obj)) {
                        c().c(i10, null);
                        z10 = true;
                        if (i11 < 0) {
                            i11 = i10;
                        }
                    }
                    i10 = i12;
                }
                if (z10) {
                    n(i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    @Override // java.util.List
    public T set(int i10, T t10) {
        synchronized (this.f7247c) {
            a(i10);
            Object obj = c().f8280b.get(i10);
            c().c(i10, t10);
            if (obj != null) {
                t10 = (T) obj;
            }
        }
        return t10;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.List
    @l
    public List<T> subList(int i10, int i11) {
        return new il.a(this, i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @l
    public String toString() {
        String string;
        synchronized (this.f7247c) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ks.a.f9445d);
                int i10 = 0;
                for (T t10 : this) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        y.Z();
                    }
                    sb2.append(String.valueOf(t10));
                    if (i11 < e()) {
                        sb2.append(", ");
                    }
                    i10 = i11;
                }
                sb2.append(']');
                string = sb2.toString();
                l0.o(string, "StringBuilder().apply(builderAction).toString()");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return string;
    }

    @Override // java.util.List
    @l
    public ListIterator<T> listIterator(int i10) {
        return new a(i10, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        synchronized (this.f7247c) {
            int iIndexOf = indexOf(obj);
            if (iIndexOf < 0) {
                return false;
            }
            i(iIndexOf);
            return true;
        }
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        return (T[]) v.b(this, tArr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@l Collection<? extends T> collection) {
        l0.p(collection, "elements");
        Collection<? extends T> collection2 = collection;
        if (!collection2.isEmpty()) {
            Iterator<T> it = collection2.iterator();
            while (it.hasNext() && add(it.next())) {
            }
        }
        return !collection.isEmpty();
    }

    @Override // java.util.List
    public void add(int i10, T t10) {
        j(i10, 1);
        c().c(i10, t10);
    }
}
