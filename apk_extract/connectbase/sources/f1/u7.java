package f1;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public final class u7<K extends Comparable, V> implements s5<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s5<Comparable<?>, Object> f5429b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NavigableMap<r0<K>, c<K, V>> f5430a = new TreeMap();

    public class a implements s5<Comparable<?>, Object> {
        @Override // f1.s5
        public Map<q5<Comparable<?>>, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // f1.s5
        public Map<q5<Comparable<?>>, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // f1.s5
        public void clear() {
        }

        @Override // f1.s5
        @gm.a
        public Object get(Comparable<?> key) {
            return null;
        }

        @Override // f1.s5
        @gm.a
        public Map.Entry<q5<Comparable<?>>, Object> getEntry(Comparable<?> key) {
            return null;
        }

        @Override // f1.s5
        public void put(q5<Comparable<?>> range, Object value) {
            range.getClass();
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // f1.s5
        public void putAll(s5<Comparable<?>, ? extends Object> rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // f1.s5
        public void putCoalescing(q5<Comparable<?>> range, Object value) {
            range.getClass();
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // f1.s5
        public void remove(q5<Comparable<?>> range) {
            range.getClass();
        }

        @Override // f1.s5
        public q5<Comparable<?>> span() {
            throw new NoSuchElementException();
        }

        @Override // f1.s5
        public s5<Comparable<?>, Object> subRangeMap(q5<Comparable<?>> range) {
            range.getClass();
            return this;
        }
    }

    public final class b extends t4.a0<q5<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<Map.Entry<q5<K>, V>> f5431a;

        public b(Iterable<c<K, V>> entryIterable) {
            this.f5431a = entryIterable;
        }

        @Override // f1.t4.a0
        public Iterator<Map.Entry<q5<K>, V>> a() {
            return this.f5431a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return get(key) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object key) {
            if (!(key instanceof q5)) {
                return null;
            }
            q5 q5Var = (q5) key;
            c cVar = (c) u7.this.f5430a.get(q5Var.lowerBound);
            if (cVar == null || !cVar.f5433a.equals(q5Var)) {
                return null;
            }
            return cVar.f5434b;
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return u7.this.f5430a.size();
        }
    }

    public static final class c<K extends Comparable, V> extends g<q5<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q5<K> f5433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f5434b;

        public c(r0<K> lowerBound, r0<K> upperBound, V value) {
            this(q5.create(lowerBound, upperBound), value);
        }

        public boolean a(K value) {
            return this.f5433a.contains(value);
        }

        public q5<K> b() {
            return this.f5433a;
        }

        public r0<K> c() {
            return (r0<K>) this.f5433a.lowerBound;
        }

        public r0<K> d() {
            return (r0<K>) this.f5433a.upperBound;
        }

        @Override // f1.g, java.util.Map.Entry
        public Object getKey() {
            return this.f5433a;
        }

        @Override // f1.g, java.util.Map.Entry
        public V getValue() {
            return this.f5434b;
        }

        public c(q5<K> range, V value) {
            this.f5433a = range;
            this.f5434b = value;
        }
    }

    public class d implements s5<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q5<K> f5435a;

        public class a extends u7<K, V>.d.b {

            /* JADX INFO: renamed from: f1.u7$d$a$a, reason: collision with other inner class name */
            public class C0124a extends f1.c<Map.Entry<q5<K>, V>> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Iterator f5438c;

                public C0124a(final Iterator val$backingItr) {
                    this.f5438c = val$backingItr;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // f1.c
                @gm.a
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry<q5<K>, V> a() {
                    if (!this.f5438c.hasNext()) {
                        this.f4711a = f1.c.b.DONE;
                        return null;
                    }
                    c cVar = (c) this.f5438c.next();
                    if (cVar.f5433a.upperBound.compareTo((r0) d.this.f5435a.lowerBound) > 0) {
                        return new f3(cVar.f5433a.intersection(d.this.f5435a), cVar.f5434b);
                    }
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
            }

            public a() {
                super();
            }

            @Override // f1.u7.d.b
            public Iterator<Map.Entry<q5<K>, V>> c() {
                return d.this.f5435a.isEmpty() ? h4.l.f4958e : new C0124a(u7.this.f5430a.headMap(d.this.f5435a.upperBound, false).descendingMap().values().iterator());
            }
        }

        public class b extends AbstractMap<q5<K>, V> {

            public class a extends t4.b0<q5<K>, V> {
                public a(Map map) {
                    super(map);
                }

                @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(@gm.a Object o10) {
                    return b.this.remove(o10) != null;
                }

                @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> c10) {
                    return b.this.d(c1.j0.h(new c1.j0.i(c1.j0.n(c10)), t4.r.KEY));
                }
            }

            /* JADX INFO: renamed from: f1.u7$d$b$b, reason: collision with other inner class name */
            public class C0125b extends t4.s<q5<K>, V> {
                public C0125b() {
                }

                @Override // f1.t4.s
                public Map<q5<K>, V> a() {
                    return b.this;
                }

                @Override // f1.t4.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return !iterator().hasNext();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<q5<K>, V>> iterator() {
                    return b.this.c();
                }

                @Override // f1.t4.s, f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> c10) {
                    return b.this.d(new c1.j0.i(c1.j0.n(c10)));
                }

                @Override // f1.t4.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return h4.Z(iterator());
                }
            }

            public class c extends f1.c<Map.Entry<q5<K>, V>> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ Iterator f5443c;

                public c(final Iterator val$backingItr) {
                    this.f5443c = val$backingItr;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // f1.c
                @gm.a
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry<q5<K>, V> a() {
                    while (this.f5443c.hasNext()) {
                        c cVar = (c) this.f5443c.next();
                        if (cVar.f5433a.lowerBound.compareTo((r0) d.this.f5435a.upperBound) >= 0) {
                            this.f4711a = f1.c.b.DONE;
                            return null;
                        }
                        if (cVar.f5433a.upperBound.compareTo((r0) d.this.f5435a.lowerBound) > 0) {
                            return new f3(cVar.f5433a.intersection(d.this.f5435a), cVar.f5434b);
                        }
                    }
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
            }

            /* JADX INFO: renamed from: f1.u7$d$b$d, reason: collision with other inner class name */
            public class C0126d extends t4.q0<q5<K>, V> {
                public C0126d(Map map) {
                    super(map);
                }

                @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection<?> c10) {
                    return b.this.d(c1.j0.h(c1.j0.n(c10), t4.r.VALUE));
                }

                @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> c10) {
                    return b.this.d(c1.j0.h(new c1.j0.i(c1.j0.n(c10)), t4.r.VALUE));
                }
            }

            public b() {
            }

            public Iterator<Map.Entry<q5<K>, V>> c() {
                if (d.this.f5435a.isEmpty()) {
                    return h4.l.f4958e;
                }
                return new c(u7.this.f5430a.tailMap((r0) c1.z.a((r0) u7.this.f5430a.floorKey(d.this.f5435a.lowerBound), d.this.f5435a.lowerBound), true).values().iterator());
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                d.this.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(@gm.a Object key) {
                return get(key) != null;
            }

            public final boolean d(c1.i0<? super Map.Entry<q5<K>, V>> predicate) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<q5<K>, V> entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        arrayList.add(entry.getKey());
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    u7.this.remove((q5) it.next());
                }
                return !arrayList.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<q5<K>, V>> entrySet() {
                return new C0125b();
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.AbstractMap, java.util.Map
            @gm.a
            public V get(@gm.a Object obj) {
                c cVar;
                try {
                    if (obj instanceof q5) {
                        q5 q5Var = (q5) obj;
                        if (d.this.f5435a.encloses(q5Var) && !q5Var.isEmpty()) {
                            if (q5Var.lowerBound.compareTo((r0) d.this.f5435a.lowerBound) == 0) {
                                Map.Entry entryFloorEntry = u7.this.f5430a.floorEntry(q5Var.lowerBound);
                                cVar = entryFloorEntry != null ? (c) entryFloorEntry.getValue() : null;
                            } else {
                                cVar = (c) u7.this.f5430a.get(q5Var.lowerBound);
                            }
                            if (cVar != null && cVar.f5433a.isConnected(d.this.f5435a) && cVar.f5433a.intersection(d.this.f5435a).equals(q5Var)) {
                                return cVar.f5434b;
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<q5<K>> keySet() {
                return new a(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            @gm.a
            public V remove(@gm.a Object obj) {
                V v10 = (V) get(obj);
                if (v10 == null) {
                    return null;
                }
                Objects.requireNonNull(obj);
                u7.this.remove((q5) obj);
                return v10;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new C0126d(this);
            }
        }

        public d(q5<K> subRange) {
            this.f5435a = subRange;
        }

        @Override // f1.s5
        public Map<q5<K>, V> asDescendingMapOfRanges() {
            return new a();
        }

        @Override // f1.s5
        public Map<q5<K>, V> asMapOfRanges() {
            return new b();
        }

        @Override // f1.s5
        public void clear() {
            u7.this.remove(this.f5435a);
        }

        @Override // f1.s5
        public boolean equals(@gm.a Object o10) {
            if (o10 instanceof s5) {
                return asMapOfRanges().equals(((s5) o10).asMapOfRanges());
            }
            return false;
        }

        @Override // f1.s5
        @gm.a
        public V get(K k10) {
            if (this.f5435a.contains(k10)) {
                return (V) u7.this.get(k10);
            }
            return null;
        }

        @Override // f1.s5
        @gm.a
        public Map.Entry<q5<K>, V> getEntry(K k10) {
            Map.Entry<q5<K>, V> entry;
            if (!this.f5435a.contains(k10) || (entry = u7.this.getEntry(k10)) == null) {
                return null;
            }
            return new f3(entry.getKey().intersection(this.f5435a), entry.getValue());
        }

        @Override // f1.s5
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // f1.s5
        public void put(q5<K> range, V value) {
            c1.h0.y(this.f5435a.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.f5435a);
            u7.this.put(range, value);
        }

        @Override // f1.s5
        public void putAll(s5<K, ? extends V> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            q5<K> q5VarSpan = rangeMap.span();
            c1.h0.y(this.f5435a.encloses(q5VarSpan), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", q5VarSpan, this.f5435a);
            u7.this.putAll(rangeMap);
        }

        @Override // f1.s5
        public void putCoalescing(q5<K> q5Var, V v10) {
            if (u7.this.f5430a.isEmpty() || !this.f5435a.encloses(q5Var)) {
                put(q5Var, v10);
                return;
            }
            u7 u7Var = u7.this;
            v10.getClass();
            put(u7Var.e(q5Var, v10).intersection(this.f5435a), v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // f1.s5
        public void remove(q5<K> q5Var) {
            if (q5Var.isConnected(this.f5435a)) {
                u7.this.remove(q5Var.intersection(this.f5435a));
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // f1.s5
        public q5<K> span() {
            r0 r0Var;
            Map.Entry entryFloorEntry = u7.this.f5430a.floorEntry(this.f5435a.lowerBound);
            if (entryFloorEntry == null || ((c) entryFloorEntry.getValue()).f5433a.upperBound.compareTo((r0) this.f5435a.lowerBound) <= 0) {
                r0Var = (r0) u7.this.f5430a.ceilingKey((r0<K>) this.f5435a.lowerBound);
                if (r0Var == null || r0Var.compareTo((r0) this.f5435a.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                r0Var = this.f5435a.lowerBound;
            }
            Map.Entry entryLowerEntry = u7.this.f5430a.lowerEntry((r0<K>) this.f5435a.upperBound);
            if (entryLowerEntry != null) {
                return q5.create(r0Var, ((c) entryLowerEntry.getValue()).f5433a.upperBound.compareTo((r0) this.f5435a.upperBound) >= 0 ? this.f5435a.upperBound : ((c) entryLowerEntry.getValue()).f5433a.upperBound);
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // f1.s5
        public s5<K, V> subRangeMap(q5<K> q5Var) {
            return !q5Var.isConnected(this.f5435a) ? u7.c(u7.this) : u7.this.subRangeMap(q5Var.intersection(this.f5435a));
        }

        @Override // f1.s5
        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    public static s5 c(u7 u7Var) {
        u7Var.getClass();
        return f5429b;
    }

    public static <K extends Comparable, V> q5<K> d(q5<K> q5Var, V v10, @gm.a Map.Entry<r0<K>, c<K, V>> entry) {
        return (entry != null && entry.getValue().f5433a.isConnected(q5Var) && entry.getValue().f5434b.equals(v10)) ? (q5<K>) q5Var.span(entry.getValue().f5433a) : q5Var;
    }

    public static <K extends Comparable, V> u7<K, V> f() {
        return new u7<>();
    }

    @Override // f1.s5
    public Map<q5<K>, V> asDescendingMapOfRanges() {
        return new b(this.f5430a.descendingMap().values());
    }

    @Override // f1.s5
    public Map<q5<K>, V> asMapOfRanges() {
        return new b(this.f5430a.values());
    }

    @Override // f1.s5
    public void clear() {
        this.f5430a.clear();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final q5<K> e(q5<K> q5Var, V v10) {
        return d(d(q5Var, v10, this.f5430a.lowerEntry((r0<K>) q5Var.lowerBound)), v10, this.f5430a.floorEntry((r0<K>) q5Var.upperBound));
    }

    @Override // f1.s5
    public boolean equals(@gm.a Object o10) {
        if (o10 instanceof s5) {
            return asMapOfRanges().equals(((s5) o10).asMapOfRanges());
        }
        return false;
    }

    public final s5<K, V> g() {
        return f5429b;
    }

    @Override // f1.s5
    @gm.a
    public V get(K key) {
        Map.Entry<q5<K>, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // f1.s5
    @gm.a
    public Map.Entry<q5<K>, V> getEntry(K key) {
        Map.Entry<r0<K>, c<K, V>> entryFloorEntry = this.f5430a.floorEntry(r0.belowValue(key));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().f5433a.contains(key)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    public final void h(r0<K> lowerBound, r0<K> upperBound, V value) {
        this.f5430a.put(lowerBound, new c<>(lowerBound, upperBound, value));
    }

    @Override // f1.s5
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // f1.s5
    public void put(q5<K> q5Var, V v10) {
        if (q5Var.isEmpty()) {
            return;
        }
        v10.getClass();
        remove(q5Var);
        this.f5430a.put((r0<K>) q5Var.lowerBound, new c<>(q5Var, v10));
    }

    @Override // f1.s5
    public void putAll(s5<K, ? extends V> rangeMap) {
        for (Map.Entry<q5<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // f1.s5
    public void putCoalescing(q5<K> range, V value) {
        if (this.f5430a.isEmpty()) {
            put(range, value);
        } else {
            value.getClass();
            put(e(range, value), value);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // f1.s5
    public void remove(q5<K> q5Var) {
        if (q5Var.isEmpty()) {
            return;
        }
        Map.Entry entryLowerEntry = this.f5430a.lowerEntry((r0<K>) q5Var.lowerBound);
        if (entryLowerEntry != null) {
            c cVar = (c) entryLowerEntry.getValue();
            if (cVar.f5433a.upperBound.compareTo((r0) q5Var.lowerBound) > 0) {
                if (cVar.f5433a.upperBound.compareTo((r0) q5Var.upperBound) > 0) {
                    h(q5Var.upperBound, cVar.f5433a.upperBound, ((c) entryLowerEntry.getValue()).f5434b);
                }
                h(cVar.f5433a.lowerBound, q5Var.lowerBound, ((c) entryLowerEntry.getValue()).f5434b);
            }
        }
        Map.Entry entryLowerEntry2 = this.f5430a.lowerEntry((r0<K>) q5Var.upperBound);
        if (entryLowerEntry2 != null) {
            c cVar2 = (c) entryLowerEntry2.getValue();
            if (cVar2.f5433a.upperBound.compareTo((r0) q5Var.upperBound) > 0) {
                h(q5Var.upperBound, cVar2.f5433a.upperBound, ((c) entryLowerEntry2.getValue()).f5434b);
            }
        }
        this.f5430a.subMap((r0<K>) q5Var.lowerBound, (r0<K>) q5Var.upperBound).clear();
    }

    @Override // f1.s5
    public q5<K> span() {
        Map.Entry<r0<K>, c<K, V>> entryFirstEntry = this.f5430a.firstEntry();
        Map.Entry<r0<K>, c<K, V>> entryLastEntry = this.f5430a.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return q5.create(entryFirstEntry.getValue().f5433a.lowerBound, entryLastEntry.getValue().f5433a.upperBound);
    }

    @Override // f1.s5
    public s5<K, V> subRangeMap(q5<K> subRange) {
        return subRange.equals(q5.all()) ? this : new d(subRange);
    }

    @Override // f1.s5
    public String toString() {
        return this.f5430a.values().toString();
    }
}
