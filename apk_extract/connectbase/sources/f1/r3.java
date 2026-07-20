package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public class r3<K extends Comparable<?>, V> implements s5<K, V>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r3<Comparable<?>, Object> f5213c = new r3<>(i3.of(), i3.of());
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient i3<q5<K>> f5214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient i3<V> f5215b;

    public class a extends i3<q5<K>> {
        final /* synthetic */ int val$len;
        final /* synthetic */ int val$off;
        final /* synthetic */ q5 val$range;

        public a(final int val$len, final int val$off, final q5 val$range) {
            this.val$len = val$len;
            this.val$off = val$off;
            this.val$range = val$range;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$len;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public q5<K> get(int index) {
            c1.h0.C(index, this.val$len);
            return (index == 0 || index == this.val$len + (-1)) ? ((q5) r3.this.f5214a.get(index + this.val$off)).intersection(this.val$range) : (q5) r3.this.f5214a.get(index + this.val$off);
        }
    }

    public class b extends r3<K, V> {
        final /* synthetic */ r3 val$outer;
        final /* synthetic */ q5 val$range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(final r3 this$0, i3 ranges, i3 values, final q5 val$range, final r3 val$outer) {
            super(ranges, values);
            this.val$range = val$range;
            this.val$outer = val$outer;
        }

        @Override // f1.r3, f1.s5
        public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
            return super.asDescendingMapOfRanges();
        }

        @Override // f1.r3, f1.s5
        public /* bridge */ /* synthetic */ Map asMapOfRanges() {
            return super.asMapOfRanges();
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
        @Override // f1.r3, f1.s5
        public r3<K, V> subRangeMap(q5<K> subRange) {
            return this.val$range.isConnected(subRange) ? this.val$outer.subRangeMap((q5) subRange.intersection(this.val$range)) : r3.of();
        }
    }

    @t1.f
    public static final class c<K extends Comparable<?>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Map.Entry<q5<K>, V>> f5216a = new ArrayList();

        public r3<K, V> a() {
            Collections.sort(this.f5216a, q5.rangeLexOrdering().onKeys());
            i3.a aVar = new i3.a(this.f5216a.size());
            i3.a aVar2 = new i3.a(this.f5216a.size());
            for (int i10 = 0; i10 < this.f5216a.size(); i10++) {
                q5<K> key = this.f5216a.get(i10).getKey();
                if (i10 > 0) {
                    q5<K> key2 = this.f5216a.get(i10 - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + key2 + " overlaps with entry " + key);
                    }
                }
                aVar.j(key);
                aVar2.j(this.f5216a.get(i10).getValue());
            }
            return new r3<>(aVar.e(), aVar2.e());
        }

        @t1.a
        public c<K, V> b(c<K, V> builder) {
            this.f5216a.addAll(builder.f5216a);
            return this;
        }

        @t1.a
        public c<K, V> c(q5<K> range, V value) {
            range.getClass();
            value.getClass();
            c1.h0.u(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f5216a.add(new f3(range, value));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @t1.a
        public c<K, V> d(s5<K, ? extends V> rangeMap) {
            for (Map.Entry entry : rangeMap.asMapOfRanges().entrySet()) {
                c((q5) entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public static class d<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final k3<q5<K>, V> mapOfRanges;

        public d(k3<q5<K>, V> mapOfRanges) {
            this.mapOfRanges = mapOfRanges;
        }

        public Object createRangeMap() {
            c cVar = new c();
            x7<Map.Entry<q5<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<q5<K>, V> next = it.next();
                cVar.c(next.getKey(), next.getValue());
            }
            return cVar.a();
        }

        public Object readResolve() {
            return this.mapOfRanges.isEmpty() ? r3.of() : createRangeMap();
        }
    }

    public r3(i3<q5<K>> ranges, i3<V> values) {
        this.f5214a = ranges;
        this.f5215b = values;
    }

    public static <K extends Comparable<?>, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K extends Comparable<?>, V> r3<K, V> copyOf(s5<K, ? extends V> rangeMap) {
        if (rangeMap instanceof r3) {
            return (r3) rangeMap;
        }
        Map<q5<K>, ? extends V> mapAsMapOfRanges = rangeMap.asMapOfRanges();
        i3.a aVar = new i3.a(mapAsMapOfRanges.size());
        i3.a aVar2 = new i3.a(mapAsMapOfRanges.size());
        for (Map.Entry entry : mapAsMapOfRanges.entrySet()) {
            aVar.j((q5) entry.getKey());
            aVar2.j(entry.getValue());
        }
        return new r3<>(aVar.e(), aVar2.e());
    }

    public static <K extends Comparable<?>, V> r3<K, V> of() {
        return (r3<K, V>) f5213c;
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.s5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
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
    public V get(K key) {
        int iA = p6.a(this.f5214a, q5.lowerBoundFn(), r0.belowValue(key), p6.c.ANY_PRESENT, p6.b.NEXT_LOWER);
        if (iA != -1 && this.f5214a.get(iA).contains(key)) {
            return this.f5215b.get(iA);
        }
        return null;
    }

    @Override // f1.s5
    @gm.a
    public Map.Entry<q5<K>, V> getEntry(K key) {
        int iA = p6.a(this.f5214a, q5.lowerBoundFn(), r0.belowValue(key), p6.c.ANY_PRESENT, p6.b.NEXT_LOWER);
        if (iA == -1) {
            return null;
        }
        q5<K> q5Var = this.f5214a.get(iA);
        if (q5Var.contains(key)) {
            return t4.O(q5Var, this.f5215b.get(iA));
        }
        return null;
    }

    @Override // f1.s5
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // f1.s5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void put(q5<K> range, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.s5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(s5<K, ? extends V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.s5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putCoalescing(q5<K> range, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.s5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void remove(q5<K> range) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.s5
    public q5<K> span() {
        if (this.f5214a.isEmpty()) {
            throw new NoSuchElementException();
        }
        q5<K> q5Var = this.f5214a.get(0);
        i3<q5<K>> i3Var = this.f5214a;
        return q5.create(q5Var.lowerBound, i3Var.get(i3Var.size() - 1).upperBound);
    }

    @Override // f1.s5
    public String toString() {
        return asMapOfRanges().toString();
    }

    public Object writeReplace() {
        return new d(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> r3<K, V> of(q5<K> range, V value) {
        return new r3<>(i3.of(range), i3.of(value));
    }

    @Override // f1.s5
    public k3<q5<K>, V> asDescendingMapOfRanges() {
        return this.f5214a.isEmpty() ? k3.of() : new w3(new c6(this.f5214a.reverse(), q5.rangeLexOrdering().reverse()), this.f5215b.reverse());
    }

    @Override // f1.s5
    public k3<q5<K>, V> asMapOfRanges() {
        return this.f5214a.isEmpty() ? k3.of() : new w3(new c6(this.f5214a, q5.rangeLexOrdering()), this.f5215b);
    }

    @Override // f1.s5
    public r3<K, V> subRangeMap(final q5<K> range) {
        range.getClass();
        if (range.isEmpty()) {
            return of();
        }
        if (this.f5214a.isEmpty() || range.encloses(span())) {
            return this;
        }
        i3<q5<K>> i3Var = this.f5214a;
        c1.t tVarUpperBoundFn = q5.upperBoundFn();
        Comparable comparable = range.lowerBound;
        p6.c cVar = p6.c.FIRST_AFTER;
        p6.b bVar = p6.b.NEXT_HIGHER;
        int iA = p6.a(i3Var, tVarUpperBoundFn, comparable, cVar, bVar);
        int iA2 = p6.a(this.f5214a, q5.lowerBoundFn(), range.upperBound, p6.c.ANY_PRESENT, bVar);
        return iA >= iA2 ? of() : new b(this, new a(iA2 - iA, iA, range), this.f5215b.subList(iA, iA2), range, this);
    }
}
