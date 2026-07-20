package hl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import fl.p0;
import fl.t0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.w;
import kn.x0;
import lm.l2;
import nm.y;
import pl.e0;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class e<Key, Value> implements Map<Key, Value>, ln.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f7259d = {l1.k(new x0(e.class, "table", "getTable()Lio/ktor/util/collections/internal/SharedList;", 0)), l1.f9319a.i(new x0(e.class, "insertionOrder", "getInsertionOrder()Lio/ktor/util/collections/internal/SharedForwardList;", 0))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7260e = AtomicIntegerFieldUpdater.newUpdater(e.class, "_size");

    @os.l
    volatile /* synthetic */ int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final fl.x0 f7261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final qn.f f7262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final qn.f f7263c;

    public static final class a extends n0 implements jn.a<l2> {
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e<Key, Value> eVar) {
            super(0);
            this.this$0 = eVar;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.C(new il.i(32));
            this.this$0.B(new il.h<>());
        }
    }

    public static final class b extends n0 implements jn.a<Value> {
        final /* synthetic */ jn.a<Value> $block;
        final /* synthetic */ Key $key;
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(e<Key, Value> eVar, Key key, jn.a<? extends Value> aVar) {
            super(0);
            this.this$0 = eVar;
            this.$key = key;
            this.$block = aVar;
        }

        @Override // jn.a
        @os.l
        public final Value invoke() {
            Value value = this.this$0.get(this.$key);
            if (value != null) {
                return value;
            }
            Value valueInvoke = this.$block.invoke();
            this.this$0.put(this.$key, valueInvoke);
            return valueInvoke;
        }
    }

    public static final class c extends n0 implements jn.a<Boolean> {
        final /* synthetic */ Value $value;
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e<Key, Value> eVar, Value value) {
            super(0);
            this.this$0 = eVar;
            this.$value = value;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Boolean invoke() {
            for (il.h hVar : this.this$0.x()) {
                if (hVar != null) {
                    Iterator it = hVar.iterator();
                    while (it.hasNext()) {
                        if (l0.g(((il.f) it.next()).getValue(), this.$value)) {
                            return Boolean.TRUE;
                        }
                    }
                }
            }
            return Boolean.FALSE;
        }
    }

    public static final class d extends n0 implements jn.a<Boolean> {
        final /* synthetic */ Object $other;
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Object obj, e<Key, Value> eVar) {
            super(0);
            this.$other = obj;
            this.this$0 = eVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Boolean invoke() {
            Object obj = this.$other;
            if (obj == null || !(obj instanceof Map) || ((Map) obj).size() != this.this$0._size) {
                return Boolean.FALSE;
            }
            for (Map.Entry entry : ((Map) this.$other).entrySet()) {
                Object key = entry.getKey();
                if (!l0.g(this.this$0.get(key), entry.getValue())) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: hl.e$e, reason: collision with other inner class name */
    public static final class C0200e extends n0 implements jn.a<Value> {
        final /* synthetic */ Key $key;
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0200e(e<Key, Value> eVar, Key key) {
            super(0);
            this.this$0 = eVar;
            this.$key = key;
        }

        @Override // jn.a
        @os.m
        public final Value invoke() {
            Object next;
            il.h hVarM = this.this$0.m(this.$key);
            if (hVarM == null) {
                return null;
            }
            Key key = this.$key;
            Iterator<T> it = hVarM.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!l0.g(((il.f) next).f8261a, key));
            il.f fVar = (il.f) next;
            if (fVar == null) {
                return null;
            }
            return (Value) fVar.getValue();
        }
    }

    public static final class f extends n0 implements jn.a<Value> {
        final /* synthetic */ jn.a<Value> $block;
        final /* synthetic */ Key $key;
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(e<Key, Value> eVar, Key key, jn.a<? extends Value> aVar) {
            super(0);
            this.this$0 = eVar;
            this.$key = key;
            this.$block = aVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // jn.a
        @os.l
        public final Value invoke() {
            return this.this$0.l(this.$key, (jn.a<? extends Value>) this.$block);
        }
    }

    public static final class g extends n0 implements jn.a<Integer> {
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e<Key, Value> eVar) {
            super(0);
            this.this$0 = eVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Integer invoke() {
            e<Key, Value> eVar = this.this$0;
            eVar.getClass();
            int iA = 7;
            for (Map.Entry<Key, Value> entry : new il.g(eVar)) {
                iA = p0.f6086a.a(Integer.valueOf(entry.getKey().hashCode()), Integer.valueOf(entry.getValue().hashCode()), Integer.valueOf(iA));
            }
            return Integer.valueOf(iA);
        }
    }

    public static final class h implements Iterator<Map.Entry<Key, Value>>, ln.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ o<Object>[] f7264c = {l1.k(new x0(h.class, "current", "getCurrent()Lio/ktor/util/collections/internal/ForwardListNode;", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final qn.f f7265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e<Key, Value> f7266b;

        public static final class a implements qn.f<Object, il.e<il.f<Key, Value>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public il.e<il.f<Key, Value>> f7267a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f7268b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Object obj) {
                this.f7268b = obj;
                this.f7267a = obj;
            }

            @Override // qn.f, qn.e
            public il.e<il.f<Key, Value>> a(@os.l Object obj, @os.l o<?> oVar) {
                l0.p(obj, "thisRef");
                l0.p(oVar, "property");
                return this.f7267a;
            }

            @Override // qn.f
            public void b(@os.l Object obj, @os.l o<?> oVar, il.e<il.f<Key, Value>> eVar) {
                l0.p(obj, "thisRef");
                l0.p(oVar, "property");
                this.f7267a = eVar;
            }
        }

        public h(e<Key, Value> eVar) {
            this.f7266b = eVar;
            this.f7265a = new a(eVar.s().e());
            e0.a(this);
        }

        private final il.e<il.f<Key, Value>> a() {
            return (il.e) this.f7265a.a(this, f7264c[0]);
        }

        private final il.e<il.f<Key, Value>> c() {
            il.e<il.f<Key, Value>> eVarA = a();
            if (eVarA == null) {
                return null;
            }
            return eVarA.c();
        }

        @Override // java.util.Iterator
        @os.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<Key, Value> next() {
            il.e<il.f<Key, Value>> eVarA = a();
            l0.m(eVarA);
            il.f<Key, Value> fVar = eVarA.f8253b;
            l0.m(fVar);
            il.f<Key, Value> fVar2 = fVar;
            il.e<il.f<Key, Value>> eVarA2 = a();
            f(eVarA2 == null ? null : eVarA2.b());
            return fVar2;
        }

        public final void f(il.e<il.f<Key, Value>> eVar) {
            this.f7265a.b(this, f7264c[0], eVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a() != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            il.e<il.f<Key, Value>> eVarC = c();
            l0.m(eVarC);
            il.f<Key, Value> fVar = eVarC.f8253b;
            l0.m(fVar);
            this.f7266b.remove(fVar.f8261a);
        }
    }

    public static final class i extends n0 implements jn.a<Value> {
        final /* synthetic */ Key $key;
        final /* synthetic */ Value $value;
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(e<Key, Value> eVar, Key key, Value value) {
            super(0);
            this.this$0 = eVar;
            this.$key = key;
            this.$value = value;
        }

        @Override // jn.a
        @os.m
        public final Value invoke() {
            il.f<Key, Value> next;
            if (this.this$0.u() > 0.5d) {
                this.this$0.D();
            }
            il.h<il.f<Key, Value>> hVarQ = this.this$0.q(this.$key);
            Key key = this.$key;
            Iterator<il.f<Key, Value>> it = hVarQ.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!l0.g(next.f8261a, key));
            il.f<Key, Value> fVar = next;
            if (fVar != null) {
                Value value = fVar.getValue();
                fVar.g(this.$value);
                return value;
            }
            il.f<Key, Value> fVar2 = new il.f<>(this.$key, this.$value);
            fVar2.f(this.this$0.s().c(fVar2));
            hVarQ.a(fVar2);
            e.f7260e.incrementAndGet(this.this$0);
            return null;
        }
    }

    public static final class j extends n0 implements jn.a<Value> {
        final /* synthetic */ Key $key;
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(e<Key, Value> eVar, Key key) {
            super(0);
            this.this$0 = eVar;
            this.$key = key;
        }

        @Override // jn.a
        @os.m
        public final Value invoke() {
            il.h hVarM = this.this$0.m(this.$key);
            if (hVarM == null) {
                return null;
            }
            Iterator it = hVarM.iterator();
            Key key = this.$key;
            e<Key, Value> eVar = this.this$0;
            while (it.hasNext()) {
                il.f fVar = (il.f) it.next();
                if (l0.g(fVar.f8261a, key)) {
                    Value value = (Value) fVar.getValue();
                    e.f7260e.decrementAndGet(eVar);
                    fVar.e();
                    it.remove();
                    return value;
                }
            }
            return null;
        }
    }

    public static final class k implements qn.f<Object, il.i<il.h<il.f<Key, Value>>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public il.i<il.h<il.f<Key, Value>>> f7269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f7270b;

        /* JADX WARN: Multi-variable type inference failed */
        public k(Object obj) {
            this.f7270b = obj;
            this.f7269a = obj;
        }

        @Override // qn.f, qn.e
        public il.i<il.h<il.f<Key, Value>>> a(@os.l Object obj, @os.l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f7269a;
        }

        @Override // qn.f
        public void b(@os.l Object obj, @os.l o<?> oVar, il.i<il.h<il.f<Key, Value>>> iVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f7269a = iVar;
        }
    }

    public static final class l implements qn.f<Object, il.h<il.f<Key, Value>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public il.h<il.f<Key, Value>> f7271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f7272b;

        /* JADX WARN: Multi-variable type inference failed */
        public l(Object obj) {
            this.f7272b = obj;
            this.f7271a = obj;
        }

        @Override // qn.f, qn.e
        public il.h<il.f<Key, Value>> a(@os.l Object obj, @os.l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f7271a;
        }

        @Override // qn.f
        public void b(@os.l Object obj, @os.l o<?> oVar, il.h<il.f<Key, Value>> hVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f7271a = hVar;
        }
    }

    public static final class m extends n0 implements jn.a<String> {
        final /* synthetic */ e<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(e<Key, Value> eVar) {
            super(0);
            this.this$0 = eVar;
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            e<Key, Value> eVar = this.this$0;
            StringBuilder sb2 = new StringBuilder("{");
            eVar.getClass();
            int i10 = 0;
            for (Map.Entry<Key, Value> entry : new il.g(eVar)) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    y.Z();
                }
                Map.Entry<Key, Value> entry2 = entry;
                Key key = entry2.getKey();
                Value value = entry2.getValue();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(key);
                sb3.append(fl.h.f6043c);
                sb3.append(value);
                sb2.append(sb3.toString());
                if (i10 != eVar._size - 1) {
                    sb2.append(", ");
                }
                i10 = i11;
            }
            sb2.append("}");
            String string = sb2.toString();
            l0.o(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public final <T> T A(jn.a<? extends T> aVar) {
        fl.x0 x0Var = this.f7261a;
        try {
            x0Var.b();
            return aVar.invoke();
        } finally {
            x0Var.c();
        }
    }

    public final void B(il.h<il.f<Key, Value>> hVar) {
        this.f7263c.b(this, f7259d[1], hVar);
    }

    public final void C(il.i<il.h<il.f<Key, Value>>> iVar) {
        this.f7262b.b(this, f7259d[0], iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D() {
        e eVar = new e(null, x().f8279a * 2, 1, 0 == true ? 1 : 0);
        eVar.putAll(this);
        C(eVar.x());
    }

    @Override // java.util.Map
    public void clear() {
        A(new a(this));
    }

    @Override // java.util.Map
    public boolean containsKey(@os.m Object obj) {
        return (obj == null || get(obj) == null) ? false : true;
    }

    @Override // java.util.Map
    public boolean containsValue(@os.m Object obj) {
        if (obj == null) {
            return false;
        }
        return ((Boolean) A(new c(this, obj))).booleanValue();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<Key, Value>> entrySet() {
        return new il.g(this);
    }

    @Override // java.util.Map
    public boolean equals(@os.m Object obj) {
        return ((Boolean) A(new d(obj, this))).booleanValue();
    }

    @Override // java.util.Map
    @os.m
    public Value get(@os.m Object obj) {
        if (obj == null) {
            return null;
        }
        return (Value) A(new C0200e(this, obj));
    }

    @Override // java.util.Map
    public int hashCode() {
        return ((Number) A(new g(this))).intValue();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override // java.util.Map
    public final Set<Key> keySet() {
        return new il.b(this);
    }

    @os.l
    public final Value l(@os.l Key key, @os.l jn.a<? extends Value> aVar) {
        l0.p(key, cb.b.c.f1408o);
        l0.p(aVar, "block");
        return (Value) A(new b(this, key, aVar));
    }

    public final il.h<il.f<Key, Value>> m(Key key) {
        return (il.h) x().f8280b.get(key.hashCode() & (x().f8279a - 1));
    }

    @Override // java.util.Map
    @os.m
    public Value put(@os.l Key key, @os.l Value value) {
        l0.p(key, cb.b.c.f1408o);
        l0.p(value, "value");
        return (Value) A(new i(this, key, value));
    }

    @Override // java.util.Map
    public void putAll(@os.l Map<? extends Key, ? extends Value> map) {
        l0.p(map, TypedValues.TransitionType.S_FROM);
        for (Map.Entry<? extends Key, ? extends Value> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final il.h<il.f<Key, Value>> q(Key key) {
        int iHashCode = key.hashCode() & (x().f8279a - 1);
        il.h<il.f<Key, Value>> hVar = (il.h) x().f8280b.get(iHashCode);
        if (hVar != null) {
            return hVar;
        }
        il.h<il.f<Key, Value>> hVar2 = new il.h<>();
        x().c(iHashCode, hVar2);
        return hVar2;
    }

    @os.l
    public Set<Map.Entry<Key, Value>> r() {
        return new il.g(this);
    }

    @Override // java.util.Map
    @os.m
    public Value remove(@os.m Object obj) {
        if (obj == null) {
            return null;
        }
        return (Value) A(new j(this, obj));
    }

    public final il.h<il.f<Key, Value>> s() {
        return (il.h) this.f7263c.a(this, f7259d[1]);
    }

    @Override // java.util.Map
    public final int size() {
        return this._size;
    }

    @os.l
    public Set<Key> t() {
        return new il.b(this);
    }

    @os.l
    public String toString() {
        return (String) A(new m(this));
    }

    public final float u() {
        return this._size / x().f8279a;
    }

    @lm.k(level = lm.m.ERROR, message = "This is accidentally does insert instead of get. Use computeIfAbsent or getOrElse instead.")
    @os.l
    public final Value v(@os.l Key key, @os.l jn.a<? extends Value> aVar) {
        l0.p(key, cb.b.c.f1408o);
        l0.p(aVar, "block");
        return (Value) A(new f(this, key, aVar));
    }

    @Override // java.util.Map
    public final Collection<Value> values() {
        return new il.c(this);
    }

    public int w() {
        return this._size;
    }

    public final il.i<il.h<il.f<Key, Value>>> x() {
        return (il.i) this.f7262b.a(this, f7259d[0]);
    }

    @os.l
    public Collection<Value> y() {
        return new il.c(this);
    }

    @os.l
    public final Iterator<Map.Entry<Key, Value>> z() {
        return new h(this);
    }

    public e(@os.l fl.x0 x0Var, int i10) {
        l0.p(x0Var, "lock");
        this.f7261a = x0Var;
        this.f7262b = new k(new il.i(i10));
        this.f7263c = new l(new il.h());
        this._size = 0;
        e0.a(this);
    }

    public /* synthetic */ e(fl.x0 x0Var, int i10, int i11, w wVar) {
        this((i11 & 1) != 0 ? new fl.x0() : x0Var, (i11 & 2) != 0 ? 32 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(@os.l fl.x0 x0Var, @os.l Map<Key, ? extends Value> map) {
        this(x0Var, map.size());
        l0.p(x0Var, "lock");
        l0.p(map, "map");
        putAll(map);
    }
}
