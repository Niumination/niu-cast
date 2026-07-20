package eq;

import in.n;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kn.i;
import kn.l0;
import kn.u1;
import kn.w;
import lm.l2;
import nm.o1;
import nm.r;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends AbstractSet<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final b f4674c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public Object f4675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4676b;

    public static final class a<T> implements Iterator<T>, ln.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final Iterator<T> f4677a;

        public a(@l T[] tArr) {
            l0.p(tArr, dc.d.f3685p);
            this.f4677a = i.a(tArr);
        }

        @Override // java.util.Iterator
        @l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4677a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f4677a.next();
        }
    }

    public static final class b {
        public b() {
        }

        @n
        @l
        public final <T> f<T> a() {
            return new f<>(null);
        }

        @n
        @l
        public final <T> f<T> b(@l Collection<? extends T> collection) {
            l0.p(collection, "set");
            f<T> fVar = new f<>(null);
            fVar.addAll(collection);
            return fVar;
        }

        public b(w wVar) {
        }
    }

    public static final class c<T> implements Iterator<T>, ln.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f4678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4679b = true;

        public c(T t10) {
            this.f4678a = t10;
        }

        @Override // java.util.Iterator
        @l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4679b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f4679b) {
                throw new NoSuchElementException();
            }
            this.f4679b = false;
            return this.f4678a;
        }
    }

    public f() {
    }

    @n
    @l
    public static final <T> f<T> a() {
        return f4674c.a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t10) {
        Object obj;
        int i10 = this.f4676b;
        if (i10 == 0) {
            this.f4675a = t10;
        } else if (i10 == 1) {
            if (l0.g(this.f4675a, t10)) {
                return false;
            }
            this.f4675a = new Object[]{this.f4675a, t10};
        } else if (i10 < 5) {
            Object obj2 = this.f4675a;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
            Object[] objArr = (Object[]) obj2;
            if (r.s8(objArr, t10)) {
                return false;
            }
            int i11 = this.f4676b;
            if (i11 == 4) {
                LinkedHashSet linkedHashSetO = o1.o(Arrays.copyOf(objArr, objArr.length));
                linkedHashSetO.add(t10);
                l2 l2Var = l2.f10208a;
                obj = linkedHashSetO;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, i11 + 1);
                l0.o(objArrCopyOf, "copyOf(this, newSize)");
                objArrCopyOf[objArrCopyOf.length - 1] = t10;
                l2 l2Var2 = l2.f10208a;
                obj = objArrCopyOf;
            }
            this.f4675a = obj;
        } else {
            Object obj3 = this.f4675a;
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
            if (!u1.o(obj3).add(t10)) {
                return false;
            }
        }
        this.f4676b++;
        return true;
    }

    public int b() {
        return this.f4676b;
    }

    public void c(int i10) {
        this.f4676b = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f4675a = null;
        this.f4676b = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        int i10 = this.f4676b;
        if (i10 == 0) {
            return false;
        }
        if (i10 == 1) {
            return l0.g(this.f4675a, obj);
        }
        if (i10 < 5) {
            Object obj2 = this.f4675a;
            if (obj2 != null) {
                return r.s8((Object[]) obj2, obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        }
        Object obj3 = this.f4675a;
        if (obj3 != null) {
            return ((Set) obj3).contains(obj);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @l
    public Iterator<T> iterator() {
        Iterator<T> aVar;
        int i10 = this.f4676b;
        if (i10 == 0) {
            return Collections.emptySet().iterator();
        }
        if (i10 == 1) {
            aVar = new c<>(this.f4675a);
        } else {
            if (i10 >= 5) {
                Object obj = this.f4675a;
                if (obj != null) {
                    return u1.o(obj).iterator();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
            Object obj2 = this.f4675a;
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
            aVar = new a<>((Object[]) obj2);
        }
        return aVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f4676b;
    }

    public f(w wVar) {
    }
}
