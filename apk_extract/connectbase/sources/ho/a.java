package ho;

import eo.d1;
import eo.w0;
import vp.f1;
import vp.h1;
import vp.j1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f7280f = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dp.f f7281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final up.i<vp.n0> f7282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final up.i<op.h> f7283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final up.i<w0> f7284e;

    /* JADX INFO: renamed from: ho.a$a, reason: collision with other inner class name */
    public class C0201a implements jn.a<vp.n0> {

        /* JADX INFO: renamed from: ho.a$a$a, reason: collision with other inner class name */
        public class C0202a implements jn.l<wp.g, vp.n0> {
            public C0202a() {
            }

            @Override // jn.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public vp.n0 invoke(wp.g gVar) {
                eo.h hVarF = gVar.f(a.this);
                if (hVarF == null) {
                    return a.this.f7282c.invoke();
                }
                if (hVarF instanceof d1) {
                    return vp.g0.b((d1) hVarF, j1.h(hVarF.i().getParameters()));
                }
                return hVarF instanceof t ? j1.v(hVarF.i().b(gVar), ((t) hVarF).Z(gVar), this) : hVarF.q();
            }
        }

        public C0201a() {
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vp.n0 invoke() {
            a aVar = a.this;
            return j1.u(aVar, aVar.X(), new C0202a());
        }
    }

    public class b implements jn.a<op.h> {
        public b() {
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public op.h invoke() {
            return new op.f(a.this.X());
        }
    }

    public class c implements jn.a<w0> {
        public c() {
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public w0 invoke() {
            return new q(a.this);
        }
    }

    public a(@os.l up.n nVar, @os.l dp.f fVar) {
        if (nVar == null) {
            f0(0);
        }
        if (fVar == null) {
            f0(1);
        }
        this.f7281b = fVar;
        this.f7282c = nVar.h(new C0201a());
        this.f7283d = nVar.h(new b());
        this.f7284e = nVar.h(new c());
    }

    private static /* synthetic */ void f0(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8 || i10 == 11 || i10 == 13 || i10 == 15 || i10 == 16 || i10 == 18 || i10 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8 || i10 == 11 || i10 == 13 || i10 == 15 || i10 == 16 || i10 == 18 || i10 == 19) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i10 == 2) {
            objArr[1] = "getName";
        } else if (i10 == 3) {
            objArr[1] = "getOriginal";
        } else if (i10 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i10 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i10 == 8 || i10 == 11 || i10 == 13 || i10 == 15) {
            objArr[1] = "getMemberScope";
        } else if (i10 == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i10 == 18) {
            objArr[1] = "substitute";
        } else if (i10 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 8 && i10 != 11 && i10 != 13 && i10 != 15 && i10 != 16 && i10 != 18 && i10 != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.l(this, d10);
    }

    @Override // ho.t
    @os.l
    public op.h B(@os.l f1 f1Var, @os.l wp.g gVar) {
        if (f1Var == null) {
            f0(9);
        }
        if (gVar == null) {
            f0(10);
        }
        if (!f1Var.f()) {
            return new op.m(Z(gVar), h1.g(f1Var));
        }
        op.h hVarZ = Z(gVar);
        if (hVarZ == null) {
            f0(11);
        }
        return hVarZ;
    }

    @Override // eo.b1
    @os.l
    /* JADX INFO: renamed from: B0 */
    public eo.e c(@os.l h1 h1Var) {
        if (h1Var == null) {
            f0(17);
        }
        return h1Var.k() ? this : new s(this, h1Var);
    }

    @Override // eo.e
    @os.l
    public w0 D0() {
        w0 w0VarInvoke = this.f7284e.invoke();
        if (w0VarInvoke == null) {
            f0(5);
        }
        return w0VarInvoke;
    }

    @Override // eo.e
    @os.l
    public op.h N(@os.l f1 f1Var) {
        if (f1Var == null) {
            f0(14);
        }
        op.h hVarB = B(f1Var, lp.a.k(hp.d.g(this)));
        if (hVarB == null) {
            f0(15);
        }
        return hVarB;
    }

    @Override // eo.e
    @os.l
    public op.h V() {
        op.h hVarInvoke = this.f7283d.invoke();
        if (hVarInvoke == null) {
            f0(4);
        }
        return hVarInvoke;
    }

    @Override // eo.e
    @os.l
    public op.h X() {
        op.h hVarZ = Z(lp.a.k(hp.d.g(this)));
        if (hVarZ == null) {
            f0(16);
        }
        return hVarZ;
    }

    @Override // eo.i0
    @os.l
    public dp.f getName() {
        dp.f fVar = this.f7281b;
        if (fVar == null) {
            f0(2);
        }
        return fVar;
    }

    @Override // eo.e, eo.h
    @os.l
    public vp.n0 q() {
        vp.n0 n0VarInvoke = this.f7282c.invoke();
        if (n0VarInvoke == null) {
            f0(19);
        }
        return n0VarInvoke;
    }

    @Override // eo.m
    @os.l
    public eo.e a() {
        return this;
    }
}
