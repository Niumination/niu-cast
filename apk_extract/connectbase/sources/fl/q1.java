package fl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@t0
public class q1 implements o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final lm.d0 f6094e;

    public static final class a extends kn.n0 implements jn.a<Map<String, ? extends List<? extends String>>> {
        final /* synthetic */ Map<String, List<String>> $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Map<String, ? extends List<String>> map) {
            super(0);
            this.$values = map;
        }

        @Override // jn.a
        @os.l
        public final Map<String, ? extends List<? extends String>> invoke() {
            if (!q1.this.a()) {
                return nm.d1.F0(this.$values);
            }
            o oVar = new o();
            oVar.putAll(this.$values);
            return oVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q1() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    @Override // fl.o1
    public boolean a() {
        return this.f6093d;
    }

    @Override // fl.o1
    @os.m
    public List<String> b(@os.l String str) {
        kn.l0.p(str, "name");
        return g(str);
    }

    @Override // fl.o1
    public boolean contains(@os.l String str) {
        kn.l0.p(str, "name");
        return g(str) != null;
    }

    @Override // fl.o1
    public boolean d(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        List<String> listG = g(str);
        if (listG == null) {
            return false;
        }
        return listG.contains(str2);
    }

    @Override // fl.o1
    public void e(@os.l jn.p<? super String, ? super List<String>, l2> pVar) {
        kn.l0.p(pVar, "body");
        for (Map.Entry<String, List<String>> entry : f().entrySet()) {
            pVar.invoke(entry.getKey(), entry.getValue());
        }
    }

    @Override // fl.o1
    @os.l
    public Set<Map.Entry<String, List<String>>> entries() {
        return s.a(f().entrySet());
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        if (a() != o1Var.a()) {
            return false;
        }
        return kn.l0.g(entries(), o1Var.entries());
    }

    @os.l
    public final Map<String, List<String>> f() {
        return (Map) this.f6094e.getValue();
    }

    public final List<String> g(String str) {
        return f().get(str);
    }

    @Override // fl.o1
    @os.m
    public String get(@os.l String str) {
        kn.l0.p(str, "name");
        List<String> listG = g(str);
        if (listG == null) {
            return null;
        }
        return (String) nm.h0.G2(listG);
    }

    public int hashCode() {
        return r1.g(entries(), Boolean.hashCode(a()) * 31);
    }

    @Override // fl.o1
    public boolean isEmpty() {
        return f().isEmpty();
    }

    @Override // fl.o1
    @os.l
    public Set<String> names() {
        return s.a(f().keySet());
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("StringValues(case=");
        sb2.append(!a());
        sb2.append(") ");
        sb2.append(entries());
        return sb2.toString();
    }

    public q1(boolean z10, @os.l Map<String, ? extends List<String>> map) {
        kn.l0.p(map, "values");
        this.f6093d = z10;
        this.f6094e = lm.f0.b(new a(map));
    }

    public /* synthetic */ q1(boolean z10, Map map, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? nm.d1.z() : map);
    }
}
