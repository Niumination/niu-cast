package no;

import java.util.Map;
import kn.l0;
import kn.n0;
import nm.d1;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final e0 f11791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final e0 f11792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Map<dp.c, e0> f11793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final lm.d0 f11794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11795e;

    public static final class a extends n0 implements jn.a<String[]> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String[] invoke() {
            x xVar = x.this;
            om.b bVar = new om.b();
            bVar.add(xVar.f11791a.getDescription());
            e0 e0Var = xVar.f11792b;
            if (e0Var != null) {
                bVar.add(l0.C("under-migration:", e0Var.getDescription()));
            }
            for (Map.Entry<dp.c, e0> entry : xVar.f11793c.entrySet()) {
                bVar.add("@" + entry.getKey() + n1.e.f11184d + entry.getValue().getDescription());
            }
            Object[] array = nm.x.a(bVar).toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(@os.l e0 e0Var, @os.m e0 e0Var2, @os.l Map<dp.c, ? extends e0> map) {
        l0.p(e0Var, "globalLevel");
        l0.p(map, "userDefinedLevelForSpecificAnnotation");
        this.f11791a = e0Var;
        this.f11792b = e0Var2;
        this.f11793c = map;
        this.f11794d = lm.f0.b(new a());
        e0 e0Var3 = e0.IGNORE;
        this.f11795e = e0Var == e0Var3 && e0Var2 == e0Var3 && map.isEmpty();
    }

    @os.l
    public final e0 a() {
        return this.f11791a;
    }

    @os.m
    public final e0 b() {
        return this.f11792b;
    }

    @os.l
    public final Map<dp.c, e0> c() {
        return this.f11793c;
    }

    public final boolean d() {
        return this.f11795e;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f11791a == xVar.f11791a && this.f11792b == xVar.f11792b && l0.g(this.f11793c, xVar.f11793c);
    }

    public int hashCode() {
        int iHashCode = this.f11791a.hashCode() * 31;
        e0 e0Var = this.f11792b;
        return this.f11793c.hashCode() + ((iHashCode + (e0Var == null ? 0 : e0Var.hashCode())) * 31);
    }

    @os.l
    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f11791a + ", migrationLevel=" + this.f11792b + ", userDefinedLevelForSpecificAnnotation=" + this.f11793c + ')';
    }

    public /* synthetic */ x(e0 e0Var, e0 e0Var2, Map map, int i10, kn.w wVar) {
        this(e0Var, (i10 & 2) != 0 ? null : e0Var2, (i10 & 4) != 0 ? d1.z() : map);
    }
}
