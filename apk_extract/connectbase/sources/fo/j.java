package fo;

import eo.z0;
import java.util.Map;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import lm.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ao.h f6171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final dp.c f6172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Map<dp.f, jp.g<?>> f6173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final d0 f6174d;

    public static final class a extends n0 implements jn.a<vp.n0> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final vp.n0 invoke() {
            j jVar = j.this;
            return jVar.f6171a.o(jVar.f6172b).q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@os.l ao.h hVar, @os.l dp.c cVar, @os.l Map<dp.f, ? extends jp.g<?>> map) {
        l0.p(hVar, "builtIns");
        l0.p(cVar, "fqName");
        l0.p(map, "allValueArguments");
        this.f6171a = hVar;
        this.f6172b = cVar;
        this.f6173c = map;
        this.f6174d = f0.c(h0.PUBLICATION, new a());
    }

    @Override // fo.c
    @os.l
    public Map<dp.f, jp.g<?>> a() {
        return this.f6173c;
    }

    @Override // fo.c
    @os.l
    public dp.c e() {
        return this.f6172b;
    }

    @Override // fo.c
    @os.l
    public z0 getSource() {
        z0 z0Var = z0.f4654a;
        l0.o(z0Var, "NO_SOURCE");
        return z0Var;
    }

    @Override // fo.c
    @os.l
    public vp.f0 getType() {
        Object value = this.f6174d.getValue();
        l0.o(value, "<get-type>(...)");
        return (vp.f0) value;
    }
}
