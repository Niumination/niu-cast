package ho;

import eo.c1;
import eo.e1;
import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.List;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public class k0 extends e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.m
    public final jn.l<vp.f0, Void> f7363v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<vp.f0> f7364w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7365x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(@os.l eo.m mVar, @os.l fo.g gVar, boolean z10, @os.l o1 o1Var, @os.l dp.f fVar, int i10, @os.l z0 z0Var, @os.m jn.l<vp.f0, Void> lVar, @os.l c1 c1Var, @os.l up.n nVar) {
        super(nVar, mVar, gVar, fVar, o1Var, z10, i10, z0Var, c1Var);
        if (mVar == null) {
            B(19);
        }
        if (gVar == null) {
            B(20);
        }
        if (o1Var == null) {
            B(21);
        }
        if (fVar == null) {
            B(22);
        }
        if (z0Var == null) {
            B(23);
        }
        if (c1Var == null) {
            B(24);
        }
        if (nVar == null) {
            B(25);
        }
        this.f7364w = new ArrayList(1);
        this.f7365x = false;
        this.f7363v = lVar;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 5 || i10 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 28) ? 2 : 3];
        switch (i10) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = y0.a.f8215h;
                break;
        }
        if (i10 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i10 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i10) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static k0 J0(@os.l eo.m mVar, @os.l fo.g gVar, boolean z10, @os.l o1 o1Var, @os.l dp.f fVar, int i10, @os.l z0 z0Var, @os.m jn.l<vp.f0, Void> lVar, @os.l c1 c1Var, @os.l up.n nVar) {
        if (mVar == null) {
            B(12);
        }
        if (gVar == null) {
            B(13);
        }
        if (o1Var == null) {
            B(14);
        }
        if (fVar == null) {
            B(15);
        }
        if (z0Var == null) {
            B(16);
        }
        if (c1Var == null) {
            B(17);
        }
        if (nVar == null) {
            B(18);
        }
        return new k0(mVar, gVar, z10, o1Var, fVar, i10, z0Var, lVar, c1Var, nVar);
    }

    public static k0 K0(@os.l eo.m mVar, @os.l fo.g gVar, boolean z10, @os.l o1 o1Var, @os.l dp.f fVar, int i10, @os.l z0 z0Var, @os.l up.n nVar) {
        if (mVar == null) {
            B(6);
        }
        if (gVar == null) {
            B(7);
        }
        if (o1Var == null) {
            B(8);
        }
        if (fVar == null) {
            B(9);
        }
        if (z0Var == null) {
            B(10);
        }
        if (nVar == null) {
            B(11);
        }
        return J0(mVar, gVar, z10, o1Var, fVar, i10, z0Var, null, c1.a.f4596a, nVar);
    }

    @os.l
    public static e1 L0(@os.l eo.m mVar, @os.l fo.g gVar, boolean z10, @os.l o1 o1Var, @os.l dp.f fVar, int i10, @os.l up.n nVar) {
        if (mVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (o1Var == null) {
            B(2);
        }
        if (fVar == null) {
            B(3);
        }
        if (nVar == null) {
            B(4);
        }
        k0 k0VarK0 = K0(mVar, gVar, z10, o1Var, fVar, i10, z0.f4654a, nVar);
        k0VarK0.G0(lp.a.g(mVar).y());
        k0VarK0.P0();
        return k0VarK0;
    }

    @Override // ho.e
    public void E0(@os.l vp.f0 f0Var) {
        if (f0Var == null) {
            B(27);
        }
        jn.l<vp.f0, Void> lVar = this.f7363v;
        if (lVar == null) {
            return;
        }
        lVar.invoke(f0Var);
    }

    @Override // ho.e
    @os.l
    public List<vp.f0> F0() {
        H0();
        List<vp.f0> list = this.f7364w;
        if (list == null) {
            B(28);
        }
        return list;
    }

    public void G0(@os.l vp.f0 f0Var) {
        if (f0Var == null) {
            B(26);
        }
        I0();
        M0(f0Var);
    }

    public final void H0() {
        if (this.f7365x) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + O0());
    }

    public final void I0() {
        if (this.f7365x) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + O0());
        }
    }

    public final void M0(vp.f0 f0Var) {
        if (vp.h0.a(f0Var)) {
            return;
        }
        this.f7364w.add(f0Var);
    }

    public boolean N0() {
        return this.f7365x;
    }

    public final String O0() {
        return getName() + " declared in " + hp.d.m(b());
    }

    public void P0() {
        I0();
        this.f7365x = true;
    }
}
