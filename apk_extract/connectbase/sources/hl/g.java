package hl;

import fl.p0;
import fl.t0;
import fl.x0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.v;
import kn.w;
import lm.l2;
import ln.h;
import nm.y;
import os.l;
import os.m;
import pl.e0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class g<Key> implements Set<Key>, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final x0 f7276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final e<Key, l2> f7277b;

    public static final class a implements Iterator<Key>, ln.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final Iterator<Map.Entry<Key, l2>> f7278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g<Key> f7279b;

        public a(g<Key> gVar) {
            this.f7279b = gVar;
            e<Key, l2> eVar = gVar.f7277b;
            eVar.getClass();
            this.f7278a = new e.h(eVar);
        }

        @l
        public final Iterator<Map.Entry<Key, l2>> a() {
            return this.f7278a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7278a.hasNext();
        }

        @Override // java.util.Iterator
        @l
        public Key next() {
            return this.f7278a.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f7278a.remove();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(@l Key key) {
        l0.p(key, "element");
        x0 x0Var = this.f7276a;
        try {
            x0Var.b();
            boolean z10 = !this.f7277b.containsKey(key);
            this.f7277b.put(key, l2.f10208a);
            return z10;
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@l Collection<? extends Key> collection) {
        l0.p(collection, "elements");
        Iterator<? extends Key> it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (add(it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public int c() {
        return this.f7277b._size;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f7277b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(@m Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f7277b.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!this.f7277b.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(@m Object obj) {
        x0 x0Var = this.f7276a;
        try {
            x0Var.b();
            boolean z10 = false;
            if (obj != null && (obj instanceof Set) && ((Set) obj).size() == this.f7277b._size) {
                a aVar = new a(this);
                while (aVar.f7278a.hasNext()) {
                    if (!((Set) obj).contains(aVar.next())) {
                    }
                }
                z10 = true;
            }
            return z10;
        } finally {
            x0Var.c();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        x0 x0Var = this.f7276a;
        try {
            x0Var.b();
            Iterator<Key> it = iterator();
            int iA = 7;
            while (it.hasNext()) {
                iA = p0.f6086a.a(Integer.valueOf(it.next().hashCode()), Integer.valueOf(iA));
            }
            x0Var.c();
            return iA;
        } catch (Throwable th2) {
            x0Var.c();
            throw th2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f7277b.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @l
    public Iterator<Key> iterator() {
        return new a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(@m Object obj) {
        if (obj == null) {
            return false;
        }
        return l0.g(this.f7277b.remove(obj), l2.f10208a);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!remove(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        a aVar = new a(this);
        boolean z10 = false;
        while (aVar.f7278a.hasNext()) {
            if (!collection.contains(aVar.next())) {
                aVar.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f7277b._size;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @l
    public String toString() {
        x0 x0Var = this.f7276a;
        try {
            x0Var.b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            int i10 = 0;
            for (Key key : this) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    y.Z();
                }
                sb2.append(String.valueOf(key));
                if (i10 != this.f7277b._size - 1) {
                    sb2.append(", ");
                }
                i10 = i11;
            }
            sb2.append("]");
            String string = sb2.toString();
            l0.o(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        } finally {
            x0Var.c();
        }
    }

    public g(@l x0 x0Var, @l e<Key, l2> eVar) {
        l0.p(x0Var, "lock");
        l0.p(eVar, "delegate");
        this.f7276a = x0Var;
        this.f7277b = eVar;
        e0.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        return (T[]) v.b(this, tArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ g(x0 x0Var, e eVar, int i10, w wVar) {
        x0Var = (i10 & 1) != 0 ? new x0() : x0Var;
        this(x0Var, (i10 & 2) != 0 ? new e(x0Var, 0, 2, null) : eVar);
    }
}
