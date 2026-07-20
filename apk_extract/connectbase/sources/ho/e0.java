package ho;

import eo.h1;
import eo.s0;
import eo.t0;
import eo.v0;
import eo.z0;
import ik.y0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e0 extends b0 implements v0 {
    public static final /* synthetic */ boolean H = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h1 f7341y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final v0 f7342z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e0(@os.l t0 t0Var, @os.l fo.g gVar, @os.l eo.e0 e0Var, @os.l eo.u uVar, boolean z10, boolean z11, boolean z12, @os.l eo.b.a aVar, @os.m v0 v0Var, @os.l z0 z0Var) {
        v0 v0Var2;
        e0 e0Var2;
        super(e0Var, uVar, t0Var, gVar, dp.f.n("<set-" + t0Var.getName() + ">"), z10, z11, z12, aVar, z0Var);
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
        if (v0Var != null) {
            e0Var2 = this;
            v0Var2 = v0Var;
        } else {
            v0Var2 = this;
            e0Var2 = v0Var2;
        }
        e0Var2.f7342z = v0Var2;
    }

    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = y0.a.f8215h;
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i10) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i10) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static l0 J0(@os.l v0 v0Var, @os.l vp.f0 f0Var, @os.l fo.g gVar) {
        if (v0Var == null) {
            B(7);
        }
        if (f0Var == null) {
            B(8);
        }
        if (gVar == null) {
            B(9);
        }
        return new l0(v0Var, null, 0, gVar, dp.f.n("<set-?>"), f0Var, false, false, false, null, z0.f4654a);
    }

    @Override // eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.j(this, d10);
    }

    @Override // ho.b0, ho.k
    @os.l
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public v0 a() {
        v0 v0Var = this.f7342z;
        if (v0Var == null) {
            B(13);
        }
        return v0Var;
    }

    public void L0(@os.l h1 h1Var) {
        if (h1Var == null) {
            B(6);
        }
        this.f7341y = h1Var;
    }

    @Override // eo.y, eo.b, eo.a
    @os.l
    public Collection<? extends v0> d() {
        Collection<s0> collectionF0 = super.F0(false);
        if (collectionF0 == null) {
            B(10);
        }
        return collectionF0;
    }

    @Override // eo.a
    @os.l
    public vp.f0 getReturnType() {
        vp.n0 n0VarZ = lp.a.g(this).Z();
        if (n0VarZ == null) {
            B(12);
        }
        return n0VarZ;
    }

    @Override // eo.a
    @os.l
    public List<h1> h() {
        h1 h1Var = this.f7341y;
        if (h1Var == null) {
            throw new IllegalStateException();
        }
        List<h1> listSingletonList = Collections.singletonList(h1Var);
        if (listSingletonList == null) {
            B(11);
        }
        return listSingletonList;
    }
}
