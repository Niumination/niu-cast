package tp;

import eo.c1;
import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import nm.h0;
import nm.z;
import rp.a0;
import rp.d0;
import rp.x;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends ho.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final rp.l f16018v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final yo.a.s f16019w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final b f16020x;

    public static final class a extends n0 implements jn.a<List<? extends fo.c>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<? extends fo.c> invoke() {
            n nVar = n.this;
            rp.l lVar = nVar.f16018v;
            return h0.V5(lVar.f14748a.f14731e.j(nVar.f16019w, lVar.f14749b));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public n(@os.l rp.l lVar, @os.l yo.a.s sVar, int i10) {
        l0.p(lVar, "c");
        l0.p(sVar, "proto");
        up.n nVar = lVar.f14748a.f14727a;
        eo.m mVar = lVar.f14750c;
        fo.g.f6167h.getClass();
        fo.g gVar = fo.g.a.f6169b;
        dp.f fVarB = x.b(lVar.f14749b, sVar.getName());
        a0 a0Var = a0.f14685a;
        yo.a.s.c variance = sVar.getVariance();
        l0.o(variance, "proto.variance");
        super(nVar, mVar, gVar, fVarB, a0Var.d(variance), sVar.getReified(), i10, z0.f4654a, c1.a.f4596a);
        this.f16018v = lVar;
        this.f16019w = sVar;
        this.f16020x = new b(lVar.f14748a.f14727a, new a());
    }

    @Override // ho.e
    @os.l
    public List<f0> F0() {
        List<yo.a.q> listP = ap.f.p(this.f16019w, this.f16018v.f14751d);
        if (listP.isEmpty()) {
            return nm.x.k(lp.a.g(this).y());
        }
        List<yo.a.q> list = listP;
        d0 d0Var = this.f16018v.f14755h;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(d0Var.p((yo.a.q) it.next()));
        }
        return arrayList;
    }

    @os.l
    public b H0() {
        return this.f16020x;
    }

    @os.l
    public final yo.a.s I0() {
        return this.f16019w;
    }

    @Override // ho.e
    @os.l
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public Void E0(@os.l f0 f0Var) {
        l0.p(f0Var, y0.a.f8215h);
        throw new IllegalStateException(l0.C("There should be no cycles for deserialized type parameters, but found for: ", this));
    }

    @Override // fo.b, fo.a
    public fo.g getAnnotations() {
        return this.f16020x;
    }
}
