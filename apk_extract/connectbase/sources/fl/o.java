package fl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class o<Value> implements Map<String, Value>, ln.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<q, Value> f6075a = new LinkedHashMap();

    public static final class a extends kn.n0 implements jn.l<Map.Entry<q, Value>, Map.Entry<String, Value>> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Map.Entry<String, Value> invoke(@os.l Map.Entry<q, Value> entry) {
            kn.l0.p(entry, "$this$$receiver");
            return new m0(entry.getKey().f6090a, entry.getValue());
        }
    }

    public static final class b extends kn.n0 implements jn.l<Map.Entry<String, Value>, Map.Entry<q, Value>> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Map.Entry<q, Value> invoke(@os.l Map.Entry<String, Value> entry) {
            kn.l0.p(entry, "$this$$receiver");
            return new m0(t1.a(entry.getKey()), entry.getValue());
        }
    }

    public static final class c extends kn.n0 implements jn.l<q, String> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l q qVar) {
            kn.l0.p(qVar, "$this$$receiver");
            return qVar.f6090a;
        }
    }

    public static final class d extends kn.n0 implements jn.l<String, q> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final q invoke(@os.l String str) {
            kn.l0.p(str, "$this$$receiver");
            return t1.a(str);
        }
    }

    public boolean a(@os.l String str) {
        kn.l0.p(str, cb.b.c.f1408o);
        return this.f6075a.containsKey(new q(str));
    }

    @os.m
    public Value c(@os.l String str) {
        kn.l0.p(str, cb.b.c.f1408o);
        return this.f6075a.get(t1.a(str));
    }

    @Override // java.util.Map
    public void clear() {
        this.f6075a.clear();
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return a((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f6075a.containsValue(obj);
    }

    @os.l
    public Set<Map.Entry<String, Value>> e() {
        return new g0(this.f6075a.entrySet(), a.INSTANCE, b.INSTANCE);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Value>> entrySet() {
        return e();
    }

    @Override // java.util.Map
    public boolean equals(@os.m Object obj) {
        if (obj == null || !(obj instanceof o)) {
            return false;
        }
        return kn.l0.g(((o) obj).f6075a, this.f6075a);
    }

    @os.l
    public Set<String> f() {
        return new g0(this.f6075a.keySet(), c.INSTANCE, d.INSTANCE);
    }

    public int g() {
        return this.f6075a.size();
    }

    @Override // java.util.Map
    public final /* bridge */ Value get(Object obj) {
        if (obj instanceof String) {
            return c((String) obj);
        }
        return null;
    }

    @os.l
    public Collection<Value> h() {
        return this.f6075a.values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f6075a.hashCode();
    }

    @Override // java.util.Map
    @os.m
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Value put(@os.l String str, Value value) {
        kn.l0.p(str, cb.b.c.f1408o);
        return this.f6075a.put(t1.a(str), value);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f6075a.isEmpty();
    }

    @os.m
    public Value j(@os.l String str) {
        kn.l0.p(str, cb.b.c.f1408o);
        return this.f6075a.remove(t1.a(str));
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return f();
    }

    @Override // java.util.Map
    public void putAll(@os.l Map<? extends String, ? extends Value> map) {
        kn.l0.p(map, TypedValues.TransitionType.S_FROM);
        for (Map.Entry<? extends String, ? extends Value> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Value remove(Object obj) {
        if (obj instanceof String) {
            return j((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f6075a.size();
    }

    @Override // java.util.Map
    public final Collection<Value> values() {
        return this.f6075a.values();
    }
}
