package po;

import eo.w0;
import eo.y;
import eo.z0;
import java.util.List;
import lm.t0;
import os.l;
import os.m;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class b extends ho.f implements a {
    public static final /* synthetic */ boolean Z = false;
    public Boolean X;
    public Boolean Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@l eo.e eVar, @m b bVar, @l fo.g gVar, boolean z10, @l eo.b.a aVar, @l z0 z0Var) {
        super(eVar, bVar, gVar, z10, aVar, z0Var);
        if (eVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (aVar == null) {
            B(2);
        }
        if (z0Var == null) {
            B(3);
        }
        this.X = null;
        this.Y = null;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 11 || i10 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 11 || i10 == 18) ? 2 : 3];
        switch (i10) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 11 && i10 != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @l
    public static b m1(@l eo.e eVar, @l fo.g gVar, boolean z10, @l z0 z0Var) {
        if (eVar == null) {
            B(4);
        }
        if (gVar == null) {
            B(5);
        }
        if (z0Var == null) {
            B(6);
        }
        return new b(eVar, null, gVar, z10, eo.b.a.DECLARATION, z0Var);
    }

    @Override // ho.p
    public boolean K0() {
        return this.X.booleanValue();
    }

    @Override // ho.p
    public void S0(boolean z10) {
        this.X = Boolean.valueOf(z10);
    }

    @Override // ho.p
    public void T0(boolean z10) {
        this.Y = Boolean.valueOf(z10);
    }

    @Override // ho.p, eo.a
    public boolean e0() {
        return this.Y.booleanValue();
    }

    @l
    public b l1(@l eo.e eVar, @m b bVar, @l eo.b.a aVar, @l z0 z0Var, @l fo.g gVar) {
        if (eVar == null) {
            B(12);
        }
        if (aVar == null) {
            B(13);
        }
        if (z0Var == null) {
            B(14);
        }
        if (gVar == null) {
            B(15);
        }
        return new b(eVar, bVar, gVar, this.V, aVar, z0Var);
    }

    @Override // ho.f
    @l
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public b F0(@l eo.m mVar, @m y yVar, @l eo.b.a aVar, @m dp.f fVar, @l fo.g gVar, @l z0 z0Var) {
        if (mVar == null) {
            B(7);
        }
        if (aVar == null) {
            B(8);
        }
        if (gVar == null) {
            B(9);
        }
        if (z0Var == null) {
            B(10);
        }
        if (aVar == eo.b.a.DECLARATION || aVar == eo.b.a.SYNTHESIZED) {
            b bVarL1 = l1((eo.e) mVar, (b) yVar, aVar, z0Var, gVar);
            bVarL1.S0(K0());
            bVarL1.T0(e0());
            return bVarL1;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // po.a
    @l
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public b C0(@m f0 f0Var, @l List<i> list, @l f0 f0Var2, @m t0<eo.a.InterfaceC0106a<?>, ?> t0Var) {
        w0 w0VarF;
        if (list == null) {
            B(16);
        }
        if (f0Var2 == null) {
            B(17);
        }
        b bVarF0 = F0(b(), null, getKind(), null, getAnnotations(), getSource());
        if (f0Var == null) {
            w0VarF = null;
        } else {
            fo.g.f6167h.getClass();
            w0VarF = hp.c.f(bVarF0, f0Var, fo.g.a.f6169b);
        }
        bVarF0.L0(w0VarF, O(), getTypeParameters(), h.a(list, h(), bVarF0), f0Var2, s(), getVisibility());
        if (t0Var != null) {
            bVarF0.O0(t0Var.getFirst(), t0Var.getSecond());
        }
        return bVarF0;
    }
}
