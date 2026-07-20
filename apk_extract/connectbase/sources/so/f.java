package so;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jn.l;
import jq.h0;
import kn.l0;
import kn.n0;
import lm.t0;
import op.h;
import vp.c1;
import vp.f0;
import vp.m0;
import vp.z;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends z implements m0 {

    public static final class a extends n0 implements l<String, CharSequence> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l String str) {
            l0.p(str, "it");
            return l0.C("(raw) ", str);
        }
    }

    public f(vp.n0 n0Var, vp.n0 n0Var2, boolean z10) {
        super(n0Var, n0Var2);
        if (z10) {
            return;
        }
        wp.e.f19851a.c(n0Var, n0Var2);
    }

    public static final boolean T0(String str, String str2) {
        return l0.g(str, h0.a4(str2, "out ")) || l0.g(str2, "*");
    }

    public static final List<String> U0(gp.c cVar, f0 f0Var) {
        List<c1> listF0 = f0Var.F0();
        ArrayList arrayList = new ArrayList(nm.z.b0(listF0, 10));
        Iterator<T> it = listF0.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.z((c1) it.next()));
        }
        return arrayList;
    }

    public static final String V0(String str, String str2) {
        if (!h0.S2(str, jq.m0.f8867e, false, 2, null)) {
            return str;
        }
        return h0.u5(str, jq.m0.f8867e, null, 2, null) + jq.m0.f8867e + str2 + jq.m0.f8868f + h0.q5(str, jq.m0.f8868f, null, 2, null);
    }

    @Override // vp.z
    @os.l
    public vp.n0 N0() {
        return this.f17773b;
    }

    @Override // vp.z
    @os.l
    public String Q0(@os.l gp.c cVar, @os.l gp.f fVar) {
        t0 t0Var;
        l0.p(cVar, "renderer");
        l0.p(fVar, "options");
        String strY = cVar.y(this.f17773b);
        String strY2 = cVar.y(this.f17774c);
        if (fVar.h()) {
            return "raw (" + strY + ".." + strY2 + ')';
        }
        if (this.f17774c.F0().isEmpty()) {
            return cVar.v(strY, strY2, zp.a.h(this));
        }
        List<String> listU0 = U0(cVar, this.f17773b);
        List<String> listU1 = U0(cVar, this.f17774c);
        List<String> list = listU0;
        String strM3 = nm.h0.m3(list, ", ", null, null, 0, null, a.INSTANCE, 30, null);
        List listI6 = nm.h0.i6(list, listU1);
        if (!(listI6 instanceof Collection) || !listI6.isEmpty()) {
            Iterator it = listI6.iterator();
            do {
                if (!it.hasNext()) {
                    strY2 = V0(strY2, strM3);
                    break;
                }
                t0Var = (t0) it.next();
            } while (T0((String) t0Var.getFirst(), (String) t0Var.getSecond()));
        } else {
            strY2 = V0(strY2, strM3);
            break;
        }
        String strV0 = V0(strY, strM3);
        return l0.g(strV0, strY2) ? strV0 : cVar.v(strV0, strY2, zp.a.h(this));
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public f N0(boolean z10) {
        return new f(this.f17773b.N0(z10), this.f17774c.N0(z10));
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public z Q0(@os.l wp.g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        return new f((vp.n0) gVar.a(this.f17773b), (vp.n0) gVar.a(this.f17774c), true);
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public f O0(@os.l fo.g gVar) {
        l0.p(gVar, "newAnnotations");
        return new f(this.f17773b.O0(gVar), this.f17774c.O0(gVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vp.z, vp.f0
    @os.l
    public h o() {
        eo.h hVarD = G0().d();
        g gVar = null;
        Object[] objArr = 0;
        eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
        if (eVar == null) {
            throw new IllegalStateException(l0.C("Incorrect classifier: ", G0().d()).toString());
        }
        h hVarN = eVar.N(new e(gVar, 1, objArr == true ? 1 : 0));
        l0.o(hVarN, "classDescriptor.getMemberScope(RawSubstitution())");
        return hVarN;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(@os.l vp.n0 n0Var, @os.l vp.n0 n0Var2) {
        this(n0Var, n0Var2, false);
        l0.p(n0Var, "lowerBound");
        l0.p(n0Var2, "upperBound");
    }
}
