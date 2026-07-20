package no;

import eo.e1;
import eo.h1;
import eo.w0;
import eo.y0;
import java.util.List;
import kn.l0;
import kn.n0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements hp.e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11761a;

        static {
            int[] iArr = new int[hp.j.i.a.values().length];
            iArr[hp.j.i.a.OVERRIDABLE.ordinal()] = 1;
            f11761a = iArr;
        }
    }

    public static final class b extends n0 implements jn.l<h1, vp.f0> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final vp.f0 invoke(h1 h1Var) {
            return h1Var.getType();
        }
    }

    @Override // hp.e
    @os.l
    public hp.e.a a() {
        return hp.e.a.SUCCESS_ONLY;
    }

    @Override // hp.e
    @os.l
    public hp.e.b b(@os.l eo.a aVar, @os.l eo.a aVar2, @os.m eo.e eVar) {
        l0.p(aVar, "superDescriptor");
        l0.p(aVar2, "subDescriptor");
        if (aVar2 instanceof po.e) {
            po.e eVar2 = (po.e) aVar2;
            List<e1> typeParameters = eVar2.getTypeParameters();
            l0.o(typeParameters, "subDescriptor.typeParameters");
            if (typeParameters.isEmpty()) {
                hp.j.i iVarX = hp.j.x(aVar, aVar2);
                if ((iVarX == null ? null : iVarX.c()) != null) {
                    return hp.e.b.UNKNOWN;
                }
                List<h1> listH = eVar2.h();
                l0.o(listH, "subDescriptor.valueParameters");
                gq.m mVarK1 = gq.v.k1(nm.h0.A1(listH), b.INSTANCE);
                vp.f0 returnType = eVar2.getReturnType();
                l0.m(returnType);
                gq.m mVarO2 = gq.v.o2(mVarK1, returnType);
                w0 w0VarR = eVar2.R();
                for (vp.f0 f0Var : gq.v.n2(mVarO2, nm.y.P(w0VarR == null ? null : w0VarR.getType()))) {
                    if (!f0Var.F0().isEmpty() && !(f0Var.J0() instanceof so.f)) {
                        return hp.e.b.UNKNOWN;
                    }
                }
                eo.a aVarC = aVar.c(new so.e(null, 1, null).c());
                if (aVarC == null) {
                    return hp.e.b.UNKNOWN;
                }
                if (aVarC instanceof y0) {
                    y0 y0Var = (y0) aVarC;
                    List<e1> typeParameters2 = y0Var.getTypeParameters();
                    l0.o(typeParameters2, "erasedSuper.typeParameters");
                    if (!typeParameters2.isEmpty()) {
                        aVarC = y0Var.w().o(k0.INSTANCE).build();
                        l0.m(aVarC);
                    }
                }
                hp.j.i.a aVarC2 = hp.j.f7490d.G(aVarC, aVar2, false).c();
                l0.o(aVarC2, "DEFAULT.isOverridableByW…Descriptor, false).result");
                return a.f11761a[aVarC2.ordinal()] == 1 ? hp.e.b.OVERRIDABLE : hp.e.b.UNKNOWN;
            }
        }
        return hp.e.b.UNKNOWN;
    }
}
