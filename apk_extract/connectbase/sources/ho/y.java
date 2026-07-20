package ho;

import eo.e1;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import vp.a1;

/* JADX INFO: loaded from: classes3.dex */
public class y extends g {
    public static final /* synthetic */ boolean J = false;
    public final Collection<vp.f0> H;
    public final up.n I;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final eo.f f7467p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f7468v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public eo.e0 f7469w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public eo.u f7470x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a1 f7471y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<e1> f7472z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@os.l eo.m mVar, @os.l eo.f fVar, boolean z10, boolean z11, @os.l dp.f fVar2, @os.l z0 z0Var, @os.l up.n nVar) {
        super(nVar, mVar, fVar2, z0Var, z11);
        if (mVar == null) {
            f0(0);
        }
        if (fVar == null) {
            f0(1);
        }
        if (fVar2 == null) {
            f0(2);
        }
        if (z0Var == null) {
            f0(3);
        }
        if (nVar == null) {
            f0(4);
        }
        this.H = new ArrayList();
        this.I = nVar;
        this.f7467p = fVar;
        this.f7468v = z10;
    }

    private static /* synthetic */ void f0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i11 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public void E0() {
        this.f7471y = new vp.l(this, this.f7472z, this.H, this.I);
        Iterator<eo.d> it = g().iterator();
        while (it.hasNext()) {
            ((f) it.next()).a1(q());
        }
    }

    @Override // eo.e
    @os.l
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public Set<eo.d> g() {
        Set<eo.d> setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            f0(13);
        }
        return setEmptySet;
    }

    @Override // eo.e
    @os.m
    public eo.d G() {
        return null;
    }

    public void G0(@os.l eo.e0 e0Var) {
        if (e0Var == null) {
            f0(6);
        }
        this.f7469w = e0Var;
    }

    public void H0(@os.l List<e1> list) {
        if (list == null) {
            f0(14);
        }
        if (this.f7472z == null) {
            this.f7472z = new ArrayList(list);
        } else {
            throw new IllegalStateException("Type parameters are already set for " + getName());
        }
    }

    public void I0(@os.l eo.u uVar) {
        if (uVar == null) {
            f0(9);
        }
        this.f7470x = uVar;
    }

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    @Override // ho.t
    @os.l
    public op.h Z(@os.l wp.g gVar) {
        if (gVar == null) {
            f0(16);
        }
        op.h.c cVar = op.h.c.f12406b;
        if (cVar == null) {
            f0(17);
        }
        return cVar;
    }

    @Override // eo.e
    public boolean a0() {
        return false;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        fo.g.f6167h.getClass();
        fo.g gVar = fo.g.a.f6169b;
        if (gVar == null) {
            f0(5);
        }
        return gVar;
    }

    @Override // eo.e
    @os.l
    public eo.f getKind() {
        eo.f fVar = this.f7467p;
        if (fVar == null) {
            f0(8);
        }
        return fVar;
    }

    @Override // eo.e, eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = this.f7470x;
        if (uVar == null) {
            f0(10);
        }
        return uVar;
    }

    @Override // eo.h
    @os.l
    public a1 i() {
        a1 a1Var = this.f7471y;
        if (a1Var == null) {
            f0(11);
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
            f0(18);
        }
        return cVar;
    }

    @Override // eo.i
    public boolean l() {
        return this.f7468v;
    }

    @Override // eo.e
    @os.m
    public eo.e l0() {
        return null;
    }

    @Override // eo.e, eo.i
    @os.l
    public List<e1> r() {
        List<e1> list = this.f7472z;
        if (list == null) {
            f0(15);
        }
        return list;
    }

    @Override // eo.e, eo.d0
    @os.l
    public eo.e0 s() {
        eo.e0 e0Var = this.f7469w;
        if (e0Var == null) {
            f0(7);
        }
        return e0Var;
    }

    @Override // eo.e
    public boolean t() {
        return false;
    }

    public String toString() {
        return j.Z(this);
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
