package f1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public class x6<R, C, V> extends q<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @t2
    final Map<R, Map<C, V>> backingMap;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<C> f5566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Map<R, Map<C, V>> f5567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient x6<R, C, V>.f f5568e;

    @t2
    final c1.q0<? extends Map<C, V>> factory;

    public class b implements Iterator<z6.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f5569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public Map.Entry<R, Map<C, V>> f5570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f5571c;

        public b() {
            this.f5569a = x6.this.backingMap.entrySet().iterator();
            this.f5571c = h4.n.INSTANCE;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z6.a<R, C, V> next() {
            if (!this.f5571c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f5569a.next();
                this.f5570b = next;
                this.f5571c = next.getValue().entrySet().iterator();
            }
            Objects.requireNonNull(this.f5570b);
            Map.Entry<C, V> next2 = this.f5571c.next();
            return m7.c(this.f5570b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5569a.hasNext() || this.f5571c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f5571c.remove();
            Map.Entry<R, Map<C, V>> entry = this.f5570b;
            Objects.requireNonNull(entry);
            if (entry.getValue().isEmpty()) {
                this.f5569a.remove();
                this.f5570b = null;
            }
        }
    }

    public class c extends t4.r0<R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C f5573d;

        public class a extends k6.k<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.e(c1.j0.j.ALWAYS_TRUE.withNarrowedType());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@gm.a Object o10) {
                if (!(o10 instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) o10;
                return x6.this.a(entry.getKey(), c.this.f5573d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !x6.this.containsColumn(cVar.f5573d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return c.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return x6.this.d(entry.getKey(), c.this.f5573d, entry.getValue());
            }

            @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> c10) {
                return c.this.e(new c1.j0.i(c1.j0.n(c10)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = x6.this.backingMap.values().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.f5573d)) {
                        i10++;
                    }
                }
                return i10;
            }
        }

        public class b extends f1.c<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f5576c;

            public class a extends f1.g<R, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f5578a;

                public a(final Map.Entry val$entry) {
                    this.f5578a = val$entry;
                }

                @Override // f1.g, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f5578a.getKey();
                }

                @Override // f1.g, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f5578a.getValue()).get(c.this.f5573d);
                }

                @Override // f1.g, java.util.Map.Entry
                public V setValue(V v10) {
                    Map map = (Map) this.f5578a.getValue();
                    C c10 = c.this.f5573d;
                    v10.getClass();
                    return (V) map.put(c10, v10);
                }
            }

            public b() {
                this.f5576c = x6.this.backingMap.entrySet().iterator();
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<R, V> a() {
                while (this.f5576c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f5576c.next();
                    if (next.getValue().containsKey(c.this.f5573d)) {
                        return new a(next);
                    }
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        /* JADX INFO: renamed from: f1.x6$c$c, reason: collision with other inner class name */
        public class C0128c extends t4.b0<R, V> {
            public C0128c() {
                super(c.this);
            }

            @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@gm.a Object obj) {
                c cVar = c.this;
                return x6.this.contains(obj, cVar.f5573d);
            }

            @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object obj) {
                c cVar = c.this;
                return x6.this.remove(obj, cVar.f5573d) != null;
            }

            @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(final Collection<?> c10) {
                return c.this.e(c1.j0.h(new c1.j0.i(c1.j0.n(c10)), t4.r.KEY));
            }
        }

        public class d extends t4.q0<R, V> {
            public d() {
                super(c.this);
            }

            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@gm.a Object obj) {
                return obj != null && c.this.e(c1.j0.h(c1.j0.m(obj), t4.r.VALUE));
            }

            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(final Collection<?> c10) {
                return c.this.e(c1.j0.h(c1.j0.n(c10), t4.r.VALUE));
            }

            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(final Collection<?> c10) {
                return c.this.e(c1.j0.h(new c1.j0.i(c1.j0.n(c10)), t4.r.VALUE));
            }
        }

        public c(C columnKey) {
            columnKey.getClass();
            this.f5573d = columnKey;
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // f1.t4.r0
        /* JADX INFO: renamed from: c */
        public Set<R> h() {
            return new C0128c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return x6.this.contains(key, this.f5573d);
        }

        @Override // f1.t4.r0
        public Collection<V> d() {
            return new d();
        }

        @t1.a
        public boolean e(c1.i0<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it = x6.this.backingMap.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v10 = value.get(this.f5573d);
                if (v10 != null && predicate.apply(new f3(next.getKey(), v10))) {
                    value.remove(this.f5573d);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object obj) {
            return (V) x6.this.get(obj, this.f5573d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V put(R r10, V v10) {
            return (V) x6.this.put(r10, this.f5573d, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V remove(@gm.a Object obj) {
            return (V) x6.this.remove(obj, this.f5573d);
        }
    }

    public class d extends f1.c<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<C, V> f5582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Iterator<Map<C, V>> f5583d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f5584e;

        public d() {
            this.f5582c = x6.this.factory.get();
            this.f5583d = x6.this.backingMap.values().iterator();
            this.f5584e = h4.l.f4958e;
        }

        @Override // f1.c
        @gm.a
        public C a() {
            while (true) {
                if (this.f5584e.hasNext()) {
                    Map.Entry<C, V> next = this.f5584e.next();
                    if (!this.f5582c.containsKey(next.getKey())) {
                        this.f5582c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.f5583d.hasNext()) {
                        this.f4711a = f1.c.b.DONE;
                        return null;
                    }
                    this.f5584e = this.f5583d.next().entrySet().iterator();
                }
            }
        }
    }

    public class e extends x6<R, C, V>.i<C> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object obj) {
            return x6.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return x6.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object obj) {
            boolean z10 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = x6.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c10) {
            c10.getClass();
            Iterator<Map<C, V>> it = x6.this.backingMap.values().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (h4.V(next.keySet().iterator(), c10)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c10) {
            c10.getClass();
            Iterator<Map<C, V>> it = x6.this.backingMap.values().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(c10)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h4.Z(iterator());
        }
    }

    public class f extends t4.r0<C, Map<R, V>> {

        public class a extends x6<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: f1.x6$f$a$a, reason: collision with other inner class name */
            public class C0129a implements c1.t<C, Map<R, V>> {
                public C0129a() {
                }

                @Override // c1.t
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<R, V> apply(C columnKey) {
                    return x6.this.column(columnKey);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@gm.a Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!x6.this.containsColumn(entry.getKey())) {
                    return false;
                }
                Map<R, V> map = f.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return t4.m(x6.this.columnKeySet(), new C0129a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                x6.this.c(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> c10) {
                c10.getClass();
                return k6.J(this, c10.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> c10) {
                c10.getClass();
                boolean z10 = false;
                for (Object obj : p4.s(x6.this.columnKeySet().iterator())) {
                    if (!c10.contains(new f3(obj, x6.this.column(obj)))) {
                        x6.this.c(obj);
                        z10 = true;
                    }
                }
                return z10;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return x6.this.columnKeySet().size();
            }
        }

        public class b extends t4.q0<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@gm.a Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        x6.this.c(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> c10) {
                c10.getClass();
                boolean z10 = false;
                for (Object obj : p4.s(x6.this.columnKeySet().iterator())) {
                    if (c10.contains(x6.this.column(obj))) {
                        x6.this.c(obj);
                        z10 = true;
                    }
                }
                return z10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> c10) {
                c10.getClass();
                boolean z10 = false;
                for (Object obj : p4.s(x6.this.columnKeySet().iterator())) {
                    if (!c10.contains(x6.this.column(obj))) {
                        x6.this.c(obj);
                        z10 = true;
                    }
                }
                return z10;
            }
        }

        public f() {
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return x6.this.containsColumn(key);
        }

        @Override // f1.t4.r0
        public Collection<Map<R, V>> d() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(@gm.a Object key) {
            if (!x6.this.containsColumn(key)) {
                return null;
            }
            x6 x6Var = x6.this;
            Objects.requireNonNull(key);
            return x6Var.column(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(@gm.a Object key) {
            if (x6.this.containsColumn(key)) {
                return x6.this.c(key);
            }
            return null;
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<C> i() {
            return x6.this.columnKeySet();
        }
    }

    public class g extends t4.a0<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f5591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public Map<C, V> f5592b;

        public class a implements Iterator<Map.Entry<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f5594a;

            public a(final Iterator val$iterator) {
                this.f5594a = val$iterator;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> next() {
                return g.this.f((Map.Entry) this.f5594a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f5594a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f5594a.remove();
                g.this.d();
            }
        }

        public class b extends e2<C, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map.Entry f5596a;

            public b(final g this$1, final Map.Entry val$entry) {
                this.f5596a = val$entry;
            }

            @Override // f1.e2, java.util.Map.Entry
            public boolean equals(@gm.a Object object) {
                return standardEquals(object);
            }

            @Override // f1.e2, f1.j2
            /* JADX INFO: renamed from: l */
            public Map.Entry<C, V> delegate() {
                return this.f5596a;
            }

            @Override // f1.e2, java.util.Map.Entry
            public V setValue(V v10) {
                v10.getClass();
                return (V) super.setValue(v10);
            }
        }

        public g(R rowKey) {
            rowKey.getClass();
            this.f5591a = rowKey;
        }

        @Override // f1.t4.a0
        public Iterator<Map.Entry<C, V>> a() {
            e();
            Map<C, V> map = this.f5592b;
            return map == null ? h4.n.INSTANCE : new a(map.entrySet().iterator());
        }

        @gm.a
        public Map<C, V> c() {
            return x6.this.backingMap.get(this.f5591a);
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public void clear() {
            e();
            Map<C, V> map = this.f5592b;
            if (map != null) {
                map.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            Map<C, V> map;
            e();
            return (key == null || (map = this.f5592b) == null || !t4.o0(map, key)) ? false : true;
        }

        public void d() {
            e();
            Map<C, V> map = this.f5592b;
            if (map == null || !map.isEmpty()) {
                return;
            }
            x6.this.backingMap.remove(this.f5591a);
            this.f5592b = null;
        }

        public final void e() {
            Map<C, V> map = this.f5592b;
            if (map == null || (map.isEmpty() && x6.this.backingMap.containsKey(this.f5591a))) {
                this.f5592b = c();
            }
        }

        public Map.Entry<C, V> f(final Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object obj) {
            Map<C, V> map;
            e();
            if (obj == null || (map = this.f5592b) == null) {
                return null;
            }
            return (V) t4.p0(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V put(C c10, V v10) {
            c10.getClass();
            v10.getClass();
            Map<C, V> map = this.f5592b;
            return (map == null || map.isEmpty()) ? (V) x6.this.put(this.f5591a, c10, v10) : this.f5592b.put(c10, v10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V remove(@gm.a Object obj) {
            e();
            Map<C, V> map = this.f5592b;
            if (map == null) {
                return null;
            }
            V v10 = (V) t4.q0(map, obj);
            d();
            return v10;
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            e();
            Map<C, V> map = this.f5592b;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    public class h extends t4.r0<R, Map<C, V>> {

        public class a extends x6<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: f1.x6$h$a$a, reason: collision with other inner class name */
            public class C0130a implements c1.t<R, Map<C, V>> {
                public C0130a() {
                }

                @Override // c1.t
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<C, V> apply(R rowKey) {
                    return x6.this.row(rowKey);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@gm.a Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && c0.j(x6.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return t4.m(x6.this.backingMap.keySet(), new C0130a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && x6.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return x6.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return x6.this.containsRow(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get(@gm.a Object key) {
            if (!x6.this.containsRow(key)) {
                return null;
            }
            x6 x6Var = x6.this;
            Objects.requireNonNull(key);
            return x6Var.row(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<C, V> remove(@gm.a Object key) {
            if (key == null) {
                return null;
            }
            return x6.this.backingMap.remove(key);
        }
    }

    public abstract class i<T> extends k6.k<T> {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            x6.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return x6.this.backingMap.isEmpty();
        }
    }

    public x6(Map<R, Map<C, V>> backingMap, c1.q0<? extends Map<C, V>> factory) {
        this.backingMap = backingMap;
        this.factory = factory;
    }

    public final boolean a(@gm.a Object rowKey, @gm.a Object columnKey, @gm.a Object value) {
        return value != null && value.equals(get(rowKey, columnKey));
    }

    public final Map<C, V> b(R rowKey) {
        Map<C, V> map = this.backingMap.get(rowKey);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(rowKey, map2);
        return map2;
    }

    @t1.a
    public final Map<R, V> c(@gm.a Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V vRemove = next.getValue().remove(obj);
            if (vRemove != null) {
                linkedHashMap.put(next.getKey(), vRemove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    @Override // f1.q
    public Iterator<z6.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // f1.q, f1.z6
    public Set<z6.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // f1.q, f1.z6
    public void clear() {
        this.backingMap.clear();
    }

    @Override // f1.z6
    public Map<R, V> column(C columnKey) {
        return new c(columnKey);
    }

    @Override // f1.q, f1.z6
    public Set<C> columnKeySet() {
        Set<C> set = this.f5566c;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.f5566c = eVar;
        return eVar;
    }

    @Override // f1.z6
    public Map<C, Map<R, V>> columnMap() {
        x6<R, C, V>.f fVar = this.f5568e;
        if (fVar != null) {
            return fVar;
        }
        x6<R, C, V>.f fVar2 = new f();
        this.f5568e = fVar2;
        return fVar2;
    }

    @Override // f1.q, f1.z6
    public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
        return (rowKey == null || columnKey == null || !super.contains(rowKey, columnKey)) ? false : true;
    }

    @Override // f1.q, f1.z6
    public boolean containsColumn(@gm.a Object columnKey) {
        if (columnKey == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (t4.o0(it.next(), columnKey)) {
                return true;
            }
        }
        return false;
    }

    @Override // f1.q, f1.z6
    public boolean containsRow(@gm.a Object rowKey) {
        return rowKey != null && t4.o0(this.backingMap, rowKey);
    }

    @Override // f1.q, f1.z6
    public boolean containsValue(@gm.a Object value) {
        return value != null && super.containsValue(value);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    public final boolean d(@gm.a Object rowKey, @gm.a Object columnKey, @gm.a Object value) {
        if (!a(rowKey, columnKey, value)) {
            return false;
        }
        remove(rowKey, columnKey);
        return true;
    }

    @Override // f1.q, f1.z6
    @gm.a
    public V get(@gm.a Object obj, @gm.a Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // f1.q, f1.z6
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // f1.q, f1.z6
    @gm.a
    @t1.a
    public V put(R rowKey, C columnKey, V value) {
        rowKey.getClass();
        columnKey.getClass();
        value.getClass();
        return b(rowKey).put(columnKey, value);
    }

    @Override // f1.q, f1.z6
    @gm.a
    @t1.a
    public V remove(@gm.a Object obj, @gm.a Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) t4.p0(this.backingMap, obj)) == null) {
            return null;
        }
        V v10 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v10;
    }

    @Override // f1.z6
    public Map<C, V> row(R rowKey) {
        return new g(rowKey);
    }

    @Override // f1.q, f1.z6
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // f1.z6
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.f5567d;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> mapCreateRowMap = createRowMap();
        this.f5567d = mapCreateRowMap;
        return mapCreateRowMap;
    }

    @Override // f1.z6
    public int size() {
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // f1.q, f1.z6
    public Collection<V> values() {
        return super.values();
    }
}
