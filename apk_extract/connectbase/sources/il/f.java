package il;

import java.util.Map;
import kn.l0;
import kn.l1;
import kn.x0;
import os.l;
import os.m;
import pl.e0;
import un.o;

/* JADX INFO: loaded from: classes2.dex */
public final class f<Key, Value> implements Map.Entry<Key, Value>, ln.g.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f8260e = {l1.k(new x0(f.class, "backReference", "getBackReference$ktor_utils()Lio/ktor/util/collections/internal/ForwardListNode;", 0)), l1.f9319a.i(new x0(f.class, "value", "getValue()Ljava/lang/Object;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f8261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final qn.f f8262b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final qn.f f8263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8264d;

    public static final class a implements qn.f<Object, e<f<Key, Value>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<f<Key, Value>> f8265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f8266b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj) {
            this.f8266b = obj;
            this.f8265a = obj;
        }

        @Override // qn.f, qn.e
        public e<f<Key, Value>> a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f8265a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, e<f<Key, Value>> eVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f8265a = eVar;
        }
    }

    public static final class b implements qn.f<Object, Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Value f8267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f8268b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj) {
            this.f8268b = obj;
            this.f8267a = obj;
        }

        @Override // qn.f, qn.e
        public Value a(@l Object obj, @l o<?> oVar) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            return this.f8267a;
        }

        @Override // qn.f
        public void b(@l Object obj, @l o<?> oVar, Value value) {
            l0.p(obj, "thisRef");
            l0.p(oVar, "property");
            this.f8267a = value;
        }
    }

    public f(Key key, Value value) {
        this.f8261a = key;
        this.f8263c = new b(value);
        this.f8264d = key == null ? 0 : key.hashCode();
        e0.a(this);
    }

    @m
    public final e<f<Key, Value>> a() {
        return (e) this.f8262b.a(this, f8260e[0]);
    }

    public final int c() {
        return this.f8264d;
    }

    public final void e() {
        e<f<Key, Value>> eVarA = a();
        l0.m(eVarA);
        eVarA.e();
        f(null);
    }

    public final void f(@m e<f<Key, Value>> eVar) {
        this.f8262b.b(this, f8260e[0], eVar);
    }

    public void g(Value value) {
        this.f8263c.b(this, f8260e[1], value);
    }

    @Override // java.util.Map.Entry
    public Key getKey() {
        return this.f8261a;
    }

    @Override // java.util.Map.Entry
    public Value getValue() {
        return (Value) this.f8263c.a(this, f8260e[1]);
    }

    @Override // java.util.Map.Entry
    public Value setValue(Value value) {
        Value value2 = getValue();
        g(value);
        return value2;
    }

    @l
    public String toString() {
        return "MapItem[" + this.f8261a + ", " + getValue() + ']';
    }
}
