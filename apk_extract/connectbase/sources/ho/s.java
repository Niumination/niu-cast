package ho;

import eo.e1;
import eo.w0;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import vp.a1;
import vp.f1;
import vp.h1;
import vp.j1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public class s extends t {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ boolean f7443i = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f7444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h1 f7445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h1 f7446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<e1> f7447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<e1> f7448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a1 f7449g;

    public class a implements jn.l<e1, Boolean> {
        public a() {
        }

        @Override // jn.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(e1 e1Var) {
            return Boolean.valueOf(!e1Var.T());
        }
    }

    public s(t tVar, h1 h1Var) {
        this.f7444b = tVar;
        this.f7445c = h1Var;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005b  */
    private static /* synthetic */ void f0(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 8 || i10 == 10 || i10 == 13 || i10 == 22) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 8 || i10 == 10 || i10 == 13 || i10 == 22) ? 3 : 2];
        if (i10 == 2) {
            objArr[0] = "typeArguments";
        } else if (i10 == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i10 == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i10 == 6) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i10 == 8) {
            objArr[0] = "typeArguments";
        } else if (i10 == 10) {
            objArr[0] = "typeSubstitution";
        } else if (i10 == 13) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i10 != 22) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        } else {
            objArr[0] = "substitutor";
        }
        switch (i10) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getConstructors";
                break;
            case 18:
                objArr[1] = "getAnnotations";
                break;
            case 19:
                objArr[1] = "getName";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getContainingDeclaration";
                break;
            case 23:
                objArr[1] = "substitute";
                break;
            case 24:
                objArr[1] = "getKind";
                break;
            case 25:
                objArr[1] = "getModality";
                break;
            case 26:
                objArr[1] = "getVisibility";
                break;
            case 27:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 28:
                objArr[1] = "getSource";
                break;
            case 29:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 30:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6 || i10 == 8 || i10 == 10) {
            objArr[2] = "getMemberScope";
        } else if (i10 == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i10 == 22) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 5 && i10 != 6 && i10 != 8 && i10 != 10 && i10 != 13 && i10 != 22) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    @Override // eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.l(this, d10);
    }

    @Override // ho.t
    @os.l
    public op.h B(@os.l f1 f1Var, @os.l wp.g gVar) {
        if (f1Var == null) {
            f0(5);
        }
        if (gVar == null) {
            f0(6);
        }
        op.h hVarB = this.f7444b.B(f1Var, gVar);
        if (!this.f7445c.k()) {
            return new op.m(hVarB, B0());
        }
        if (hVarB == null) {
            f0(7);
        }
        return hVarB;
    }

    public final h1 B0() {
        if (this.f7446d == null) {
            if (this.f7445c.k()) {
                this.f7446d = this.f7445c;
            } else {
                List<e1> parameters = this.f7444b.i().getParameters();
                this.f7447e = new ArrayList(parameters.size());
                this.f7446d = vp.s.b(parameters, this.f7445c.j(), this, this.f7447e);
                this.f7448f = nm.h0.m2(this.f7447e, new a());
            }
        }
        return this.f7446d;
    }

    @Override // eo.e
    @os.l
    public w0 D0() {
        throw new UnsupportedOperationException();
    }

    @Override // eo.b1
    @os.l
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public eo.e c(@os.l h1 h1Var) {
        if (h1Var == null) {
            f0(22);
        }
        return h1Var.k() ? this : new s(this, h1.h(h1Var.j(), B0().j()));
    }

    @os.m
    public final vp.n0 F0(@os.m vp.n0 n0Var) {
        return (n0Var == null || this.f7445c.k()) ? n0Var : (vp.n0) B0().p(n0Var, o1.INVARIANT);
    }

    @Override // eo.e
    @os.m
    public eo.d G() {
        return this.f7444b.G();
    }

    @Override // eo.e
    @os.l
    public op.h N(@os.l f1 f1Var) {
        if (f1Var == null) {
            f0(10);
        }
        op.h hVarB = B(f1Var, lp.a.k(hp.d.g(this)));
        if (hVarB == null) {
            f0(11);
        }
        return hVarB;
    }

    @Override // eo.e
    @os.l
    public op.h V() {
        op.h hVarV = this.f7444b.V();
        if (hVarV == null) {
            f0(27);
        }
        return hVarV;
    }

    @Override // eo.e
    @os.l
    public op.h X() {
        op.h hVarZ = Z(lp.a.k(hp.d.g(this.f7444b)));
        if (hVarZ == null) {
            f0(12);
        }
        return hVarZ;
    }

    @Override // eo.d0
    public boolean Y() {
        return this.f7444b.Y();
    }

    @Override // ho.t
    @os.l
    public op.h Z(@os.l wp.g gVar) {
        if (gVar == null) {
            f0(13);
        }
        op.h hVarZ = this.f7444b.Z(gVar);
        if (!this.f7445c.k()) {
            return new op.m(hVarZ, B0());
        }
        if (hVarZ == null) {
            f0(14);
        }
        return hVarZ;
    }

    @Override // eo.e
    public boolean a0() {
        return this.f7444b.a0();
    }

    @Override // eo.e, eo.n, eo.m
    @os.l
    public eo.m b() {
        eo.m mVarB = this.f7444b.b();
        if (mVarB == null) {
            f0(21);
        }
        return mVarB;
    }

    @Override // eo.e
    @os.l
    public Collection<eo.d> g() {
        Collection<eo.d> collectionG = this.f7444b.g();
        ArrayList arrayList = new ArrayList(collectionG.size());
        for (eo.d dVar : collectionG) {
            arrayList.add(((eo.d) dVar.w().e(dVar.a()).b(dVar.s()).l(dVar.getVisibility()).p(dVar.getKind()).m(false).build()).c(B0()));
        }
        return arrayList;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        fo.g annotations = this.f7444b.getAnnotations();
        if (annotations == null) {
            f0(18);
        }
        return annotations;
    }

    @Override // eo.e
    @os.l
    public eo.f getKind() {
        eo.f kind = this.f7444b.getKind();
        if (kind == null) {
            f0(24);
        }
        return kind;
    }

    @Override // eo.i0
    @os.l
    public dp.f getName() {
        dp.f name = this.f7444b.getName();
        if (name == null) {
            f0(19);
        }
        return name;
    }

    @Override // eo.p
    @os.l
    public z0 getSource() {
        z0 z0Var = z0.f4654a;
        if (z0Var == null) {
            f0(28);
        }
        return z0Var;
    }

    @Override // eo.e, eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u visibility = this.f7444b.getVisibility();
        if (visibility == null) {
            f0(26);
        }
        return visibility;
    }

    @Override // eo.h
    @os.l
    public a1 i() {
        a1 a1VarI = this.f7444b.i();
        if (this.f7445c.k()) {
            if (a1VarI == null) {
                f0(0);
            }
            return a1VarI;
        }
        if (this.f7449g == null) {
            h1 h1VarB0 = B0();
            Collection<vp.f0> collectionA = a1VarI.a();
            ArrayList arrayList = new ArrayList(collectionA.size());
            Iterator<vp.f0> it = collectionA.iterator();
            while (it.hasNext()) {
                arrayList.add(h1VarB0.p(it.next(), o1.INVARIANT));
            }
            this.f7449g = new vp.l(this, this.f7447e, arrayList, up.f.f16364e);
        }
        a1 a1Var = this.f7449g;
        if (a1Var == null) {
            f0(1);
        }
        return a1Var;
    }

    @Override // eo.d0
    public boolean i0() {
        return this.f7444b.i0();
    }

    @Override // eo.d0
    public boolean isExternal() {
        return this.f7444b.isExternal();
    }

    @Override // eo.e
    public boolean isInline() {
        return this.f7444b.isInline();
    }

    @Override // eo.e
    @os.l
    public Collection<eo.e> k() {
        Collection<eo.e> collectionK = this.f7444b.k();
        if (collectionK == null) {
            f0(30);
        }
        return collectionK;
    }

    @Override // eo.e
    @os.l
    public op.h k0() {
        op.h hVarK0 = this.f7444b.k0();
        if (hVarK0 == null) {
            f0(15);
        }
        return hVarK0;
    }

    @Override // eo.i
    public boolean l() {
        return this.f7444b.l();
    }

    @Override // eo.e
    public eo.e l0() {
        return this.f7444b.l0();
    }

    @Override // eo.e, eo.h
    @os.l
    public vp.n0 q() {
        vp.n0 n0VarL = vp.g0.l(getAnnotations(), i(), j1.h(i().getParameters()), false, X());
        if (n0VarL == null) {
            f0(16);
        }
        return n0VarL;
    }

    @Override // eo.e, eo.i
    @os.l
    public List<e1> r() {
        B0();
        List<e1> list = this.f7448f;
        if (list == null) {
            f0(29);
        }
        return list;
    }

    @Override // eo.e, eo.d0
    @os.l
    public eo.e0 s() {
        eo.e0 e0VarS = this.f7444b.s();
        if (e0VarS == null) {
            f0(25);
        }
        return e0VarS;
    }

    @Override // eo.e
    public boolean t() {
        return this.f7444b.t();
    }

    @Override // eo.e
    public boolean u() {
        return this.f7444b.u();
    }

    @Override // eo.e
    public boolean x() {
        return this.f7444b.x();
    }

    @Override // eo.e
    @os.m
    public eo.z<vp.n0> y() {
        eo.z<vp.n0> zVarY = this.f7444b.y();
        if (zVarY == null) {
            return null;
        }
        return new eo.z<>(zVarY.f4652a, F0((vp.n0) y().f4653b));
    }

    @Override // eo.m
    @os.l
    public eo.e a() {
        eo.e eVarA = this.f7444b.a();
        if (eVarA == null) {
            f0(20);
        }
        return eVarA;
    }
}
