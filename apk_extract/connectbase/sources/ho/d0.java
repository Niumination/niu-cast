package ho;

import eo.h1;
import eo.s0;
import eo.t0;
import eo.u0;
import eo.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d0 extends b0 implements u0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public vp.f0 f7325y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final u0 f7326z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(@os.l t0 t0Var, @os.l fo.g gVar, @os.l eo.e0 e0Var, @os.l eo.u uVar, boolean z10, boolean z11, boolean z12, @os.l eo.b.a aVar, @os.m u0 u0Var, @os.l z0 z0Var) {
        u0 u0Var2;
        d0 d0Var;
        super(e0Var, uVar, t0Var, gVar, dp.f.n("<get-" + t0Var.getName() + ">"), z10, z11, z12, aVar, z0Var);
        if (t0Var == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (e0Var == null) {
            B(2);
        }
        if (uVar == null) {
            B(3);
        }
        if (aVar == null) {
            B(4);
        }
        if (z0Var == null) {
            B(5);
        }
        if (u0Var != null) {
            d0Var = this;
            u0Var2 = u0Var;
        } else {
            u0Var2 = this;
            d0Var = u0Var2;
        }
        d0Var.f7326z = u0Var2;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 6 || i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 6 || i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i10 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 6 && i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.e(this, d10);
    }

    @Override // ho.b0, ho.k
    @os.l
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public u0 a() {
        u0 u0Var = this.f7326z;
        if (u0Var == null) {
            B(8);
        }
        return u0Var;
    }

    public void K0(vp.f0 f0Var) {
        if (f0Var == null) {
            f0Var = W().getType();
        }
        this.f7325y = f0Var;
    }

    @Override // eo.y, eo.b, eo.a
    @os.l
    public Collection<? extends u0> d() {
        Collection<s0> collectionF0 = super.F0(true);
        if (collectionF0 == null) {
            B(6);
        }
        return collectionF0;
    }

    @Override // eo.a
    public vp.f0 getReturnType() {
        return this.f7325y;
    }

    @Override // eo.a
    @os.l
    public List<h1> h() {
        List<h1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            B(7);
        }
        return listEmptyList;
    }
}
