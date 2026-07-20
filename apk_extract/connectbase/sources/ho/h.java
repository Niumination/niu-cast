package ho;

import eo.e1;
import eo.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import vp.a1;

/* JADX INFO: loaded from: classes3.dex */
public class h extends g {
    public static final /* synthetic */ boolean H = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final eo.e0 f7349p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final eo.f f7350v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a1 f7351w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public op.h f7352x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Set<eo.d> f7353y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public eo.d f7354z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@os.l eo.m mVar, @os.l dp.f fVar, @os.l eo.e0 e0Var, @os.l eo.f fVar2, @os.l Collection<vp.f0> collection, @os.l z0 z0Var, boolean z10, @os.l up.n nVar) {
        super(nVar, mVar, fVar, z0Var, z10);
        if (mVar == null) {
            f0(0);
        }
        if (fVar == null) {
            f0(1);
        }
        if (e0Var == null) {
            f0(2);
        }
        if (fVar2 == null) {
            f0(3);
        }
        if (collection == null) {
            f0(4);
        }
        if (z0Var == null) {
            f0(5);
        }
        if (nVar == null) {
            f0(6);
        }
        this.f7349p = e0Var;
        this.f7350v = fVar2;
        this.f7351w = new vp.l(this, Collections.emptyList(), collection, nVar);
    }

    private static /* synthetic */ void f0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public final void E0(@os.l op.h hVar, @os.l Set<eo.d> set, @os.m eo.d dVar) {
        if (hVar == null) {
            f0(7);
        }
        if (set == null) {
            f0(8);
        }
        this.f7352x = hVar;
        this.f7353y = set;
        this.f7354z = dVar;
    }

    @Override // eo.e
    public eo.d G() {
        return this.f7354z;
    }

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    @Override // ho.t
    @os.l
    public op.h Z(@os.l wp.g gVar) {
        if (gVar == null) {
            f0(12);
        }
        op.h hVar = this.f7352x;
        if (hVar == null) {
            f0(13);
        }
        return hVar;
    }

    @Override // eo.e
    public boolean a0() {
        return false;
    }

    @Override // eo.e
    @os.l
    public Collection<eo.d> g() {
        Set<eo.d> set = this.f7353y;
        if (set == null) {
            f0(11);
        }
        return set;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        fo.g.f6167h.getClass();
        fo.g gVar = fo.g.a.f6169b;
        if (gVar == null) {
            f0(9);
        }
        return gVar;
    }

    @Override // eo.e
    @os.l
    public eo.f getKind() {
        eo.f fVar = this.f7350v;
        if (fVar == null) {
            f0(15);
        }
        return fVar;
    }

    @Override // eo.e, eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = eo.t.f4633e;
        if (uVar == null) {
            f0(17);
        }
        return uVar;
    }

    @Override // eo.h
    @os.l
    public a1 i() {
        a1 a1Var = this.f7351w;
        if (a1Var == null) {
            f0(10);
        }
        return a1Var;
    }

    @Override // eo.d0
    public boolean i0() {
        return false;
    }

    @Override // eo.e
    public boolean isInline() {
        return false;
    }

    @Override // eo.e
    @os.l
    public Collection<eo.e> k() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            f0(19);
        }
        return listEmptyList;
    }

    @Override // eo.e
    @os.l
    public op.h k0() {
        op.h.c cVar = op.h.c.f12406b;
        if (cVar == null) {
            f0(14);
        }
        return cVar;
    }

    @Override // eo.i
    public boolean l() {
        return false;
    }

    @Override // eo.e
    @os.m
    public eo.e l0() {
        return null;
    }

    @Override // eo.e, eo.i
    @os.l
    public List<e1> r() {
        List<e1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            f0(18);
        }
        return listEmptyList;
    }

    @Override // eo.e, eo.d0
    @os.l
    public eo.e0 s() {
        eo.e0 e0Var = this.f7349p;
        if (e0Var == null) {
            f0(16);
        }
        return e0Var;
    }

    @Override // eo.e
    public boolean t() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // eo.e
    public boolean u() {
        return false;
    }

    @Override // eo.e
    public boolean x() {
        return false;
    }

    @Override // eo.e
    @os.m
    public eo.z<vp.n0> y() {
        return null;
    }
}
