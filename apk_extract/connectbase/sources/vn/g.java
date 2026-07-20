package vn;

import eo.e1;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import lm.f1;
import lm.i0;
import nm.k0;
import nm.y;
import nm.z;
import os.l;
import un.s;
import un.u;
import un.v;
import vp.a1;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.n0;
import vp.o1;
import vp.s0;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "KClassifiers")
public final class g {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17602a;

        static {
            int[] iArr = new int[v.values().length];
            iArr[v.INVARIANT.ordinal()] = 1;
            iArr[v.IN.ordinal()] = 2;
            iArr[v.OUT.ordinal()] = 3;
            f17602a = iArr;
        }
    }

    public static final n0 a(fo.g gVar, a1 a1Var, List<u> list, boolean z10) {
        c1 s0Var;
        List<e1> parameters = a1Var.getParameters();
        l0.o(parameters, "typeConstructor.parameters");
        List<u> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        int i10 = 0;
        for (Object obj : list2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                y.Z();
            }
            u uVar = (u) obj;
            xn.v vVar = (xn.v) uVar.f16349b;
            f0 f0Var = vVar == null ? null : vVar.f20427a;
            v vVar2 = uVar.f16348a;
            int i12 = vVar2 == null ? -1 : a.f17602a[vVar2.ordinal()];
            if (i12 == -1) {
                e1 e1Var = parameters.get(i10);
                l0.o(e1Var, "parameters[index]");
                s0Var = new s0(e1Var);
            } else if (i12 == 1) {
                o1 o1Var = o1.INVARIANT;
                l0.m(f0Var);
                s0Var = new vp.e1(o1Var, f0Var);
            } else if (i12 == 2) {
                o1 o1Var2 = o1.IN_VARIANCE;
                l0.m(f0Var);
                s0Var = new vp.e1(o1Var2, f0Var);
            } else {
                if (i12 != 3) {
                    throw new i0();
                }
                o1 o1Var3 = o1.OUT_VARIANCE;
                l0.m(f0Var);
                s0Var = new vp.e1(o1Var3, f0Var);
            }
            arrayList.add(s0Var);
            i10 = i11;
        }
        return g0.j(gVar, a1Var, arrayList, z10, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.1")
    @l
    public static final s b(@l un.g gVar, @l List<u> list, boolean z10, @l List<? extends Annotation> list2) {
        fo.g gVar2;
        l0.p(gVar, "<this>");
        l0.p(list, "arguments");
        l0.p(list2, "annotations");
        jn.a aVar = null;
        Object[] objArr = 0;
        xn.i iVar = gVar instanceof xn.i ? (xn.i) gVar : null;
        if (iVar == null) {
            throw new xn.y("Cannot create type for an unsupported classifier: " + gVar + " (" + gVar.getClass() + ')');
        }
        a1 a1VarI = iVar.y().i();
        l0.o(a1VarI, "descriptor.typeConstructor");
        List<e1> parameters = a1VarI.getParameters();
        l0.o(parameters, "typeConstructor.parameters");
        if (parameters.size() == list.size()) {
            if (list2.isEmpty()) {
                fo.g.f6167h.getClass();
                gVar2 = fo.g.a.f6169b;
            } else {
                fo.g.f6167h.getClass();
                gVar2 = fo.g.a.f6169b;
            }
            return new xn.v(a(gVar2, a1VarI, list, z10), aVar, 2, objArr == true ? 1 : 0);
        }
        throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + list.size() + " were provided.");
    }

    public static s c(un.g gVar, List list, boolean z10, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = k0.INSTANCE;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            list2 = k0.INSTANCE;
        }
        return b(gVar, list, z10, list2);
    }

    @l
    public static final s d(@l un.g gVar) {
        l0.p(gVar, "<this>");
        xn.i iVar = gVar instanceof xn.i ? (xn.i) gVar : null;
        if (iVar == null) {
            return c(gVar, null, false, null, 7, null);
        }
        List<e1> parameters = iVar.y().i().getParameters();
        l0.o(parameters, "descriptor.typeConstructor.parameters");
        if (parameters.isEmpty()) {
            return c(gVar, null, false, null, 7, null);
        }
        List<e1> list = parameters;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (e1 e1Var : list) {
            u.f16346c.getClass();
            arrayList.add(u.f16347d);
        }
        return c(gVar, arrayList, false, null, 6, null);
    }

    @f1(version = "1.1")
    public static /* synthetic */ void e(un.g gVar) {
    }
}
