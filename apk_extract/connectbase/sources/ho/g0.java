package ho;

import eo.e1;
import eo.h1;
import eo.w0;
import eo.y0;
import eo.z0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class g0 extends p implements y0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(@os.l eo.m mVar, @os.m y0 y0Var, @os.l fo.g gVar, @os.l dp.f fVar, @os.l eo.b.a aVar, @os.l z0 z0Var) {
        super(mVar, y0Var, gVar, fVar, aVar, z0Var);
        if (mVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (fVar == null) {
            B(2);
        }
        if (aVar == null) {
            B(3);
        }
        if (z0Var == null) {
            B(4);
        }
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 13 || i10 == 17 || i10 == 18 || i10 == 23 || i10 == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 13 || i10 == 17 || i10 == 18 || i10 == 23 || i10 == 24) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i10 == 13 || i10 == 17) {
            objArr[1] = "initialize";
        } else if (i10 == 18) {
            objArr[1] = "getOriginal";
        } else if (i10 == 23) {
            objArr[1] = "copy";
        } else if (i10 != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 13 && i10 != 17 && i10 != 18 && i10 != 23 && i10 != 24) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public static g0 f1(@os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.l eo.b.a aVar, @os.l z0 z0Var) {
        if (mVar == null) {
            B(5);
        }
        if (gVar == null) {
            B(6);
        }
        if (fVar == null) {
            B(7);
        }
        if (aVar == null) {
            B(8);
        }
        if (z0Var == null) {
            B(9);
        }
        return new g0(mVar, null, gVar, fVar, aVar, z0Var);
    }

    @Override // ho.p
    @os.l
    public p F0(@os.l eo.m mVar, @os.m eo.y yVar, @os.l eo.b.a aVar, @os.m dp.f fVar, @os.l fo.g gVar, @os.l z0 z0Var) {
        if (mVar == null) {
            B(19);
        }
        if (aVar == null) {
            B(20);
        }
        if (gVar == null) {
            B(21);
        }
        if (z0Var == null) {
            B(22);
        }
        y0 y0Var = (y0) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new g0(mVar, y0Var, gVar, fVar, aVar, z0Var);
    }

    @Override // ho.p, eo.b
    @os.l
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public y0 h0(eo.m mVar, eo.e0 e0Var, eo.u uVar, eo.b.a aVar, boolean z10) {
        y0 y0Var = (y0) super.h0(mVar, e0Var, uVar, aVar, z10);
        if (y0Var == null) {
            B(23);
        }
        return y0Var;
    }

    @Override // ho.p, ho.k
    @os.l
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public y0 a() {
        y0 y0Var = (y0) super.a();
        if (y0Var == null) {
            B(18);
        }
        return y0Var;
    }

    @Override // ho.p
    @os.l
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public g0 L0(@os.m w0 w0Var, @os.m w0 w0Var2, @os.l List<? extends e1> list, @os.l List<h1> list2, @os.m vp.f0 f0Var, @os.m eo.e0 e0Var, @os.l eo.u uVar) {
        if (list == null) {
            B(10);
        }
        if (list2 == null) {
            B(11);
        }
        if (uVar == null) {
            B(12);
        }
        g0 g0VarI1 = i1(w0Var, w0Var2, list, list2, f0Var, e0Var, uVar, null);
        if (g0VarI1 == null) {
            B(13);
        }
        return g0VarI1;
    }

    @os.l
    public g0 i1(@os.m w0 w0Var, @os.m w0 w0Var2, @os.l List<? extends e1> list, @os.l List<h1> list2, @os.m vp.f0 f0Var, @os.m eo.e0 e0Var, @os.l eo.u uVar, @os.m Map<? extends eo.a.InterfaceC0106a<?>, ?> map) {
        if (list == null) {
            B(14);
        }
        if (list2 == null) {
            B(15);
        }
        if (uVar == null) {
            B(16);
        }
        super.L0(w0Var, w0Var2, list, list2, f0Var, e0Var, uVar);
        if (map != null && !map.isEmpty()) {
            this.U = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // ho.p, eo.y
    @os.l
    public eo.y.a<? extends y0> w() {
        eo.y.a aVarW = super.w();
        if (aVarW == null) {
            B(24);
        }
        return aVarW;
    }
}
