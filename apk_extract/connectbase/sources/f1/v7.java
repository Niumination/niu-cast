package f1;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public class v7<C extends Comparable<?>> extends k<C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<q5<C>> f5481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<q5<C>> f5482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient t5<C> f5483c;

    @b1.e
    final NavigableMap<r0<C>, q5<C>> rangesByLowerBound;

    public final class b extends s1<q5<C>> implements Set<q5<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<q5<C>> f5484a;

        public b(final v7 this$0, Collection<q5<C>> delegate) {
            this.f5484a = delegate;
        }

        @Override // f1.s1, f1.j2
        public Object delegate() {
            return this.f5484a;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object o10) {
            return k6.g(this, o10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return k6.k(this);
        }

        @Override // f1.s1, f1.j2
        public Collection<q5<C>> delegate() {
            return this.f5484a;
        }
    }

    public final class c extends v7<C> {
        public c() {
            super(new d(v7.this.rangesByLowerBound));
        }

        @Override // f1.v7, f1.k, f1.t5
        public void add(q5<C> rangeToAdd) {
            v7.this.remove(rangeToAdd);
        }

        @Override // f1.v7, f1.t5
        public t5<C> complement() {
            return v7.this;
        }

        @Override // f1.v7, f1.k, f1.t5
        public boolean contains(C value) {
            return !v7.this.contains(value);
        }

        @Override // f1.v7, f1.k, f1.t5
        public void remove(q5<C> rangeToRemove) {
            v7.this.add(rangeToRemove);
        }
    }

    public static final class d<C extends Comparable<?>> extends j<r0<C>, q5<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<r0<C>, q5<C>> f5485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final NavigableMap<r0<C>, q5<C>> f5486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q5<r0<C>> f5487c;

        public class a extends f1.c<Map.Entry<r0<C>, q5<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public r0<C> f5488c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ r0 f5489d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ n5 f5490e;

            public a(final r0 val$firstComplementRangeLowerBound, final n5 val$positiveItr) {
                this.f5489d = val$firstComplementRangeLowerBound;
                this.f5490e = val$positiveItr;
                this.f5488c = val$firstComplementRangeLowerBound;
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<r0<C>, q5<C>> a() {
                q5 q5VarCreate;
                if (d.this.f5487c.upperBound.isLessThan(this.f5488c) || this.f5488c == r0.aboveAll()) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                if (this.f5490e.hasNext()) {
                    q5 q5Var = (q5) this.f5490e.next();
                    q5VarCreate = q5.create(this.f5488c, q5Var.lowerBound);
                    this.f5488c = q5Var.upperBound;
                } else {
                    q5VarCreate = q5.create(this.f5488c, r0.aboveAll());
                    this.f5488c = r0.aboveAll();
                }
                return new f3(q5VarCreate.lowerBound, q5VarCreate);
            }
        }

        public class b extends f1.c<Map.Entry<r0<C>, q5<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public r0<C> f5492c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ r0 f5493d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ n5 f5494e;

            public b(final r0 val$firstComplementRangeUpperBound, final n5 val$positiveItr) {
                this.f5493d = val$firstComplementRangeUpperBound;
                this.f5494e = val$positiveItr;
                this.f5492c = val$firstComplementRangeUpperBound;
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
            public Map.Entry<r0<C>, q5<C>> a() {
                if (this.f5492c == r0.belowAll()) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                if (this.f5494e.hasNext()) {
                    q5 q5Var = (q5) this.f5494e.next();
                    q5 q5VarCreate = q5.create(q5Var.upperBound, this.f5492c);
                    this.f5492c = q5Var.lowerBound;
                    if (d.this.f5487c.lowerBound.isLessThan(q5VarCreate.lowerBound)) {
                        return new f3(q5VarCreate.lowerBound, q5VarCreate);
                    }
                } else if (d.this.f5487c.lowerBound.isLessThan(r0.belowAll())) {
                    q5 q5VarCreate2 = q5.create(r0.belowAll(), this.f5492c);
                    this.f5492c = r0.belowAll();
                    return new f3(r0.belowAll(), q5VarCreate2);
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public d(NavigableMap<r0<C>, q5<C>> positiveRangesByLowerBound) {
            this(positiveRangesByLowerBound, q5.all());
        }

        @Override // f1.t4.a0
        public Iterator<Map.Entry<r0<C>, q5<C>>> a() {
            Collection<q5<C>> collectionValues;
            r0 r0VarBelowAll;
            if (this.f5487c.hasLowerBound()) {
                collectionValues = this.f5486b.tailMap((r0) this.f5487c.lowerEndpoint(), this.f5487c.lowerBoundType() == x.CLOSED).values();
            } else {
                collectionValues = this.f5486b.values();
            }
            n5 n5VarT = h4.T(collectionValues.iterator());
            if (this.f5487c.contains(r0.belowAll()) && (!n5VarT.hasNext() || ((q5) n5VarT.peek()).lowerBound != r0.belowAll())) {
                r0VarBelowAll = r0.belowAll();
            } else {
                if (!n5VarT.hasNext()) {
                    return h4.l.f4958e;
                }
                r0VarBelowAll = ((q5) n5VarT.next()).upperBound;
            }
            return new a(r0VarBelowAll, n5VarT);
        }

        @Override // f1.j
        public Iterator<Map.Entry<r0<C>, q5<C>>> c() {
            r0<C> r0VarHigherKey;
            n5 n5VarT = h4.T(this.f5486b.headMap(this.f5487c.hasUpperBound() ? (r0) this.f5487c.upperEndpoint() : r0.aboveAll(), this.f5487c.hasUpperBound() && this.f5487c.upperBoundType() == x.CLOSED).descendingMap().values().iterator());
            if (n5VarT.hasNext()) {
                r0VarHigherKey = ((q5) n5VarT.peek()).upperBound == r0.aboveAll() ? ((q5) n5VarT.next()).lowerBound : this.f5485a.higherKey(((q5) n5VarT.peek()).upperBound);
            } else {
                if (!this.f5487c.contains(r0.belowAll()) || this.f5485a.containsKey(r0.belowAll())) {
                    return h4.l.f4958e;
                }
                r0VarHigherKey = this.f5485a.higherKey(r0.belowAll());
            }
            return new b((r0) c1.z.a(r0VarHigherKey, r0.aboveAll()), n5VarT);
        }

        @Override // java.util.SortedMap
        public Comparator<? super r0<C>> comparator() {
            return l5.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return get(key) != null;
        }

        @Override // f1.j, java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public q5<C> get(@gm.a Object key) {
            if (key instanceof r0) {
                try {
                    r0<C> r0Var = (r0) key;
                    Map.Entry<r0<C>, q5<C>> entryFirstEntry = tailMap(r0Var, true).firstEntry();
                    if (entryFirstEntry != null && entryFirstEntry.getKey().equals(r0Var)) {
                        return entryFirstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> headMap(r0<C> toKey, boolean inclusive) {
            return h(q5.upTo(toKey, x.forBoolean(inclusive)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> subMap(r0<C> fromKey, boolean fromInclusive, r0<C> toKey, boolean toInclusive) {
            return h(q5.range(fromKey, x.forBoolean(fromInclusive), toKey, x.forBoolean(toInclusive)));
        }

        public final NavigableMap<r0<C>, q5<C>> h(q5<r0<C>> subWindow) {
            if (!this.f5487c.isConnected(subWindow)) {
                return w3.of();
            }
            return new d(this.f5485a, subWindow.intersection(this.f5487c));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> tailMap(r0<C> fromKey, boolean inclusive) {
            return h(q5.downTo(fromKey, x.forBoolean(inclusive)));
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return h4.Z(a());
        }

        public d(NavigableMap<r0<C>, q5<C>> positiveRangesByLowerBound, q5<r0<C>> window) {
            this.f5485a = positiveRangesByLowerBound;
            this.f5486b = new e(positiveRangesByLowerBound);
            this.f5487c = window;
        }
    }

    public final class f extends v7<C> {
        private final q5<C> restriction;

        public f(q5<C> restriction) {
            super(new g(q5.all(), restriction, v7.this.rangesByLowerBound));
            this.restriction = restriction;
        }

        @Override // f1.v7, f1.k, f1.t5
        public void add(q5<C> rangeToAdd) {
            c1.h0.y(this.restriction.encloses(rangeToAdd), "Cannot add range %s to subRangeSet(%s)", rangeToAdd, this.restriction);
            v7.this.add(rangeToAdd);
        }

        @Override // f1.v7, f1.k, f1.t5
        public void clear() {
            v7.this.remove(this.restriction);
        }

        @Override // f1.v7, f1.k, f1.t5
        public boolean contains(C value) {
            return this.restriction.contains(value) && v7.this.contains(value);
        }

        @Override // f1.v7, f1.k, f1.t5
        public boolean encloses(q5<C> range) {
            q5 q5VarA;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (q5VarA = v7.this.a(range)) == null || q5VarA.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // f1.v7, f1.k, f1.t5
        @gm.a
        public q5<C> rangeContaining(C value) {
            q5<C> q5VarRangeContaining;
            if (this.restriction.contains(value) && (q5VarRangeContaining = v7.this.rangeContaining(value)) != null) {
                return q5VarRangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // f1.v7, f1.k, f1.t5
        public void remove(q5<C> rangeToRemove) {
            if (rangeToRemove.isConnected(this.restriction)) {
                v7.this.remove(rangeToRemove.intersection(this.restriction));
            }
        }

        @Override // f1.v7, f1.t5
        public t5<C> subRangeSet(q5<C> view) {
            if (view.encloses(this.restriction)) {
                return this;
            }
            return view.isConnected(this.restriction) ? new f(this.restriction.intersection(view)) : s3.of();
        }
    }

    public static final class g<C extends Comparable<?>> extends j<r0<C>, q5<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q5<r0<C>> f5502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q5<C> f5503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final NavigableMap<r0<C>, q5<C>> f5504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final NavigableMap<r0<C>, q5<C>> f5505d;

        public class a extends f1.c<Map.Entry<r0<C>, q5<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f5506c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ r0 f5507d;

            public a(final Iterator val$completeRangeItr, final r0 val$upperBoundOnLowerBounds) {
                this.f5506c = val$completeRangeItr;
                this.f5507d = val$upperBoundOnLowerBounds;
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<r0<C>, q5<C>> a() {
                if (!this.f5506c.hasNext()) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                q5 q5Var = (q5) this.f5506c.next();
                if (this.f5507d.isLessThan(q5Var.lowerBound)) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                q5 q5VarIntersection = q5Var.intersection(g.this.f5503b);
                return new f3(q5VarIntersection.lowerBound, q5VarIntersection);
            }
        }

        public class b extends f1.c<Map.Entry<r0<C>, q5<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f5509c;

            public b(final Iterator val$completeRangeItr) {
                this.f5509c = val$completeRangeItr;
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
            public Map.Entry<r0<C>, q5<C>> a() {
                if (!this.f5509c.hasNext()) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                q5 q5Var = (q5) this.f5509c.next();
                if (g.this.f5503b.lowerBound.compareTo((r0) q5Var.upperBound) >= 0) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                q5 q5VarIntersection = q5Var.intersection(g.this.f5503b);
                if (g.this.f5502a.contains(q5VarIntersection.lowerBound)) {
                    return new f3(q5VarIntersection.lowerBound, q5VarIntersection);
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        private NavigableMap<r0<C>, q5<C>> i(q5<r0<C>> window) {
            return !window.isConnected(this.f5502a) ? w3.of() : new g(this.f5502a.intersection(window), this.f5503b, this.f5504c);
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
        @Override // f1.t4.a0
        public Iterator<Map.Entry<r0<C>, q5<C>>> a() {
            Iterator<q5<C>> it;
            if (!this.f5503b.isEmpty() && !this.f5502a.upperBound.isLessThan(this.f5503b.lowerBound)) {
                if (this.f5502a.lowerBound.isLessThan(this.f5503b.lowerBound)) {
                    it = this.f5505d.tailMap(this.f5503b.lowerBound, false).values().iterator();
                } else {
                    it = this.f5504c.tailMap((r0) this.f5502a.lowerBound.endpoint(), this.f5502a.lowerBoundType() == x.CLOSED).values().iterator();
                }
                return new a(it, (r0) l5.natural().min(this.f5502a.upperBound, r0.belowValue(this.f5503b.upperBound)));
            }
            return h4.l.f4958e;
        }

        @Override // f1.j
        public Iterator<Map.Entry<r0<C>, q5<C>>> c() {
            if (this.f5503b.isEmpty()) {
                return h4.l.f4958e;
            }
            r0 r0Var = (r0) l5.natural().min(this.f5502a.upperBound, r0.belowValue(this.f5503b.upperBound));
            return new b(this.f5504c.headMap((r0) r0Var.endpoint(), r0Var.typeAsUpperBound() == x.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super r0<C>> comparator() {
            return l5.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return get(key) != null;
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
        @Override // f1.j, java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public q5<C> get(@gm.a Object key) {
            if (key instanceof r0) {
                try {
                    r0<C> r0Var = (r0) key;
                    if (this.f5502a.contains(r0Var) && r0Var.compareTo((r0) this.f5503b.lowerBound) >= 0 && r0Var.compareTo((r0) this.f5503b.upperBound) < 0) {
                        if (r0Var.equals(this.f5503b.lowerBound)) {
                            q5 q5Var = (q5) t4.Q0(this.f5504c.floorEntry(r0Var));
                            if (q5Var != null && q5Var.upperBound.compareTo((r0) this.f5503b.lowerBound) > 0) {
                                return q5Var.intersection(this.f5503b);
                            }
                        } else {
                            q5<C> q5Var2 = this.f5504c.get(r0Var);
                            if (q5Var2 != null) {
                                return q5Var2.intersection(this.f5503b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> headMap(r0<C> toKey, boolean inclusive) {
            return i(q5.upTo(toKey, x.forBoolean(inclusive)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> subMap(r0<C> fromKey, boolean fromInclusive, r0<C> toKey, boolean toInclusive) {
            return i(q5.range(fromKey, x.forBoolean(fromInclusive), toKey, x.forBoolean(toInclusive)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> tailMap(r0<C> fromKey, boolean inclusive) {
            return i(q5.downTo(fromKey, x.forBoolean(inclusive)));
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return h4.Z(a());
        }

        public g(q5<r0<C>> lowerBoundWindow, q5<C> restriction, NavigableMap<r0<C>, q5<C>> rangesByLowerBound) {
            lowerBoundWindow.getClass();
            this.f5502a = lowerBoundWindow;
            restriction.getClass();
            this.f5503b = restriction;
            rangesByLowerBound.getClass();
            this.f5504c = rangesByLowerBound;
            this.f5505d = new e(rangesByLowerBound);
        }
    }

    public static <C extends Comparable<?>> v7<C> create() {
        return new v7<>(new TreeMap());
    }

    @gm.a
    public final q5<C> a(q5<C> range) {
        range.getClass();
        Map.Entry<r0<C>, q5<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (entryFloorEntry == null || !entryFloorEntry.getValue().encloses(range)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // f1.k, f1.t5
    public void add(q5<C> q5Var) {
        q5Var.getClass();
        if (q5Var.isEmpty()) {
            return;
        }
        r0<C> r0Var = q5Var.lowerBound;
        r0<C> r0Var2 = q5Var.upperBound;
        Map.Entry<r0<C>, q5<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(r0Var);
        if (entryLowerEntry != null) {
            q5<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo((r0) r0Var) >= 0) {
                if (value.upperBound.compareTo((r0) r0Var2) >= 0) {
                    r0Var2 = value.upperBound;
                }
                r0Var = value.lowerBound;
            }
        }
        Map.Entry<r0<C>, q5<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(r0Var2);
        if (entryFloorEntry != null) {
            q5<C> value2 = entryFloorEntry.getValue();
            if (value2.upperBound.compareTo((r0) r0Var2) >= 0) {
                r0Var2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(r0Var, r0Var2).clear();
        b(q5.create(r0Var, r0Var2));
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ void addAll(t5 other) {
        super.addAll(other);
    }

    @Override // f1.t5
    public Set<q5<C>> asDescendingSetOfRanges() {
        Set<q5<C>> set = this.f5482b;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.f5482b = bVar;
        return bVar;
    }

    @Override // f1.t5
    public Set<q5<C>> asRanges() {
        Set<q5<C>> set = this.f5481a;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.f5481a = bVar;
        return bVar;
    }

    public final void b(q5<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // f1.t5
    public t5<C> complement() {
        t5<C> t5Var = this.f5483c;
        if (t5Var != null) {
            return t5Var;
        }
        c cVar = new c();
        this.f5483c = cVar;
        return cVar;
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean contains(Comparable value) {
        return super.contains(value);
    }

    @Override // f1.k, f1.t5
    public boolean encloses(q5<C> range) {
        range.getClass();
        Map.Entry<r0<C>, q5<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return entryFloorEntry != null && entryFloorEntry.getValue().encloses(range);
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean enclosesAll(t5 other) {
        return super.enclosesAll(other);
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object obj) {
        return super.equals(obj);
    }

    @Override // f1.k, f1.t5
    public boolean intersects(q5<C> range) {
        range.getClass();
        Map.Entry<r0<C>, q5<C>> entryCeilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().isConnected(range) && !entryCeilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<r0<C>, q5<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (entryLowerEntry == null || !entryLowerEntry.getValue().isConnected(range) || entryLowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // f1.k, f1.t5
    @gm.a
    public q5<C> rangeContaining(C value) {
        value.getClass();
        Map.Entry<r0<C>, q5<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(r0.belowValue(value));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().contains(value)) {
            return null;
        }
        return entryFloorEntry.getValue();
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
    @Override // f1.k, f1.t5
    public void remove(q5<C> rangeToRemove) {
        rangeToRemove.getClass();
        if (rangeToRemove.isEmpty()) {
            return;
        }
        Map.Entry<r0<C>, q5<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(rangeToRemove.lowerBound);
        if (entryLowerEntry != null) {
            q5<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo((r0) rangeToRemove.lowerBound) >= 0) {
                if (rangeToRemove.hasUpperBound() && value.upperBound.compareTo((r0) rangeToRemove.upperBound) >= 0) {
                    b(q5.create(rangeToRemove.upperBound, value.upperBound));
                }
                b(q5.create(value.lowerBound, rangeToRemove.lowerBound));
            }
        }
        Map.Entry<r0<C>, q5<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(rangeToRemove.upperBound);
        if (entryFloorEntry != null) {
            q5<C> value2 = entryFloorEntry.getValue();
            if (rangeToRemove.hasUpperBound() && value2.upperBound.compareTo((r0) rangeToRemove.upperBound) >= 0) {
                b(q5.create(rangeToRemove.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(rangeToRemove.lowerBound, rangeToRemove.upperBound).clear();
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ void removeAll(t5 other) {
        super.removeAll(other);
    }

    @Override // f1.t5
    public q5<C> span() {
        Map.Entry<r0<C>, q5<C>> entryFirstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<r0<C>, q5<C>> entryLastEntry = this.rangesByLowerBound.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return q5.create(entryFirstEntry.getValue().lowerBound, entryLastEntry.getValue().upperBound);
    }

    @Override // f1.t5
    public t5<C> subRangeSet(q5<C> view) {
        return view.equals(q5.all()) ? this : new f(view);
    }

    public v7(NavigableMap<r0<C>, q5<C>> rangesByLowerCut) {
        this.rangesByLowerBound = rangesByLowerCut;
    }

    public static <C extends Comparable<?>> v7<C> create(t5<C> rangeSet) {
        v7<C> v7VarCreate = create();
        v7VarCreate.addAll(rangeSet);
        return v7VarCreate;
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ void addAll(Iterable ranges) {
        super.addAll(ranges);
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable ranges) {
        return super.enclosesAll(ranges);
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ void removeAll(Iterable ranges) {
        super.removeAll(ranges);
    }

    @b1.e
    public static final class e<C extends Comparable<?>> extends j<r0<C>, q5<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<r0<C>, q5<C>> f5496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q5<r0<C>> f5497b;

        public class a extends f1.c<Map.Entry<r0<C>, q5<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f5498c;

            public a(final Iterator val$backingItr) {
                this.f5498c = val$backingItr;
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
            public Map.Entry<r0<C>, q5<C>> a() {
                if (!this.f5498c.hasNext()) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                q5 q5Var = (q5) this.f5498c.next();
                if (!e.this.f5497b.upperBound.isLessThan(q5Var.upperBound)) {
                    return new f3(q5Var.upperBound, q5Var);
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public class b extends f1.c<Map.Entry<r0<C>, q5<C>>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ n5 f5500c;

            public b(final n5 val$backingItr) {
                this.f5500c = val$backingItr;
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
            public Map.Entry<r0<C>, q5<C>> a() {
                if (!this.f5500c.hasNext()) {
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
                q5 q5Var = (q5) this.f5500c.next();
                if (e.this.f5497b.lowerBound.isLessThan(q5Var.upperBound)) {
                    return new f3(q5Var.upperBound, q5Var);
                }
                this.f4711a = f1.c.b.DONE;
                return null;
            }
        }

        public e(NavigableMap<r0<C>, q5<C>> rangesByLowerBound) {
            this.f5496a = rangesByLowerBound;
            this.f5497b = q5.all();
        }

        private NavigableMap<r0<C>, q5<C>> h(q5<r0<C>> window) {
            return window.isConnected(this.f5497b) ? new e(this.f5496a, window.intersection(this.f5497b)) : w3.of();
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
        @Override // f1.t4.a0
        public Iterator<Map.Entry<r0<C>, q5<C>>> a() {
            Map.Entry<r0<C>, q5<C>> entryLowerEntry;
            Iterator<q5<C>> it;
            if (this.f5497b.hasLowerBound() && (entryLowerEntry = this.f5496a.lowerEntry((r0) this.f5497b.lowerEndpoint())) != null) {
                it = this.f5497b.lowerBound.isLessThan(entryLowerEntry.getValue().upperBound) ? this.f5496a.tailMap(entryLowerEntry.getKey(), true).values().iterator() : this.f5496a.tailMap((r0) this.f5497b.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.f5496a.values().iterator();
            }
            return new a(it);
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
        @Override // f1.j
        public Iterator<Map.Entry<r0<C>, q5<C>>> c() {
            n5 n5VarT = h4.T((this.f5497b.hasUpperBound() ? this.f5496a.headMap((r0) this.f5497b.upperEndpoint(), false).descendingMap().values() : this.f5496a.descendingMap().values()).iterator());
            if (n5VarT.hasNext() && this.f5497b.upperBound.isLessThan(((q5) n5VarT.peek()).upperBound)) {
                n5VarT.next();
            }
            return new b(n5VarT);
        }

        @Override // java.util.SortedMap
        public Comparator<? super r0<C>> comparator() {
            return l5.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return get(key) != null;
        }

        @Override // f1.j, java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public q5<C> get(@gm.a Object key) {
            Map.Entry<r0<C>, q5<C>> entryLowerEntry;
            if (key instanceof r0) {
                try {
                    r0<C> r0Var = (r0) key;
                    if (this.f5497b.contains(r0Var) && (entryLowerEntry = this.f5496a.lowerEntry(r0Var)) != null && entryLowerEntry.getValue().upperBound.equals(r0Var)) {
                        return entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> headMap(r0<C> toKey, boolean inclusive) {
            return h(q5.upTo(toKey, x.forBoolean(inclusive)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> subMap(r0<C> fromKey, boolean fromInclusive, r0<C> toKey, boolean toInclusive) {
            return h(q5.range(fromKey, x.forBoolean(fromInclusive), toKey, x.forBoolean(toInclusive)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap<r0<C>, q5<C>> tailMap(r0<C> fromKey, boolean inclusive) {
            return h(q5.downTo(fromKey, x.forBoolean(inclusive)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f5497b.equals(q5.all())) {
                return this.f5496a.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f5497b.equals(q5.all()) ? this.f5496a.size() : h4.Z(a());
        }

        public e(NavigableMap<r0<C>, q5<C>> rangesByLowerBound, q5<r0<C>> upperBoundWindow) {
            this.f5496a = rangesByLowerBound;
            this.f5497b = upperBoundWindow;
        }
    }

    public static <C extends Comparable<?>> v7<C> create(Iterable<q5<C>> ranges) {
        v7<C> v7VarCreate = create();
        v7VarCreate.addAll(ranges);
        return v7VarCreate;
    }
}
