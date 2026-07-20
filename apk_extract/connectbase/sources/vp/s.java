package vp;

import java.util.HashMap;
import java.util.List;
import vp.f1.c;

/* JADX INFO: loaded from: classes3.dex */
public class s {
    public static /* synthetic */ void a(int i10) {
        String str = i10 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 4 ? 3 : 2];
        switch (i10) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i10 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i10 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i10 == 4) {
            throw new IllegalStateException(str2);
        }
    }

    @os.l
    public static h1 b(@os.l List<eo.e1> list, @os.l f1 f1Var, @os.l eo.m mVar, @os.l List<eo.e1> list2) {
        if (list == null) {
            a(0);
        }
        if (f1Var == null) {
            a(1);
        }
        if (mVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        h1 h1VarC = c(list, f1Var, mVar, list2, null);
        if (h1VarC != null) {
            return h1VarC;
        }
        throw new AssertionError("Substitution failed");
    }

    @os.m
    public static h1 c(@os.l List<eo.e1> list, @os.l f1 f1Var, @os.l eo.m mVar, @os.l List<eo.e1> list2, @os.m boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (f1Var == null) {
            a(6);
        }
        if (mVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i10 = 0;
        for (eo.e1 e1Var : list) {
            ho.k0 k0VarK0 = ho.k0.K0(mVar, e1Var.getAnnotations(), e1Var.j(), e1Var.m(), e1Var.getName(), i10, eo.z0.f4654a, e1Var.P());
            map.put(e1Var.i(), new e1(k0VarK0.q()));
            map2.put(e1Var, k0VarK0);
            list2.add(k0VarK0);
            i10++;
        }
        b1 b1VarJ = b1.j(map);
        h1 h1VarH = h1.h(f1Var, b1VarJ);
        f1Var.getClass();
        h1 h1VarH2 = h1.h(f1Var.new c(), b1VarJ);
        for (eo.e1 e1Var2 : list) {
            ho.k0 k0Var = (ho.k0) map2.get(e1Var2);
            for (f0 f0Var : e1Var2.getUpperBounds()) {
                eo.h hVarD = f0Var.G0().d();
                f0 f0VarP = (((hVarD instanceof eo.e1) && zp.a.j((eo.e1) hVarD)) ? h1VarH : h1VarH2).p(f0Var, o1.OUT_VARIANCE);
                if (f0VarP == null) {
                    return null;
                }
                if (f0VarP != f0Var && zArr != null) {
                    zArr[0] = true;
                }
                k0Var.G0(f0VarP);
            }
            k0Var.P0();
        }
        return h1VarH;
    }
}
