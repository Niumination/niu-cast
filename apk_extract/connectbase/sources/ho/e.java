package ho;

import eo.c1;
import eo.e1;
import eo.z0;
import ik.y0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import vp.a1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends k implements e1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o1 f7327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f7328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7329g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final up.i<a1> f7330i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final up.i<vp.n0> f7331n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final up.n f7332p;

    public class a implements jn.a<a1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ up.n f7333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1 f7334b;

        public a(up.n nVar, c1 c1Var) {
            this.f7333a = nVar;
            this.f7334b = c1Var;
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a1 invoke() {
            return new c(e.this, this.f7333a, this.f7334b);
        }
    }

    public class b implements jn.a<vp.n0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ dp.f f7336a;

        public class a implements jn.a<op.h> {
            public a() {
            }

            @Override // jn.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public op.h invoke() {
                return op.n.k("Scope for type parameter " + b.this.f7336a.b(), e.this.getUpperBounds());
            }
        }

        public b(dp.f fVar) {
            this.f7336a = fVar;
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vp.n0 invoke() {
            fo.g.f6167h.getClass();
            return vp.g0.l(fo.g.a.f6169b, e.this.i(), Collections.emptyList(), false, new op.g(new a()));
        }
    }

    public class c extends vp.h {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c1 f7339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f7340e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@os.l e eVar, up.n nVar, c1 c1Var) {
            super(nVar);
            if (nVar == null) {
                u(0);
            }
            this.f7340e = eVar;
            this.f7339d = c1Var;
        }

        private static /* synthetic */ void u(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = y0.a.f8215h;
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i10 == 2) {
                objArr[1] = "getParameters";
            } else if (i10 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i10 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i10 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i10 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // vp.m, vp.a1
        @os.l
        public eo.h d() {
            e eVar = this.f7340e;
            if (eVar == null) {
                u(3);
            }
            return eVar;
        }

        @Override // vp.a1
        public boolean e() {
            return true;
        }

        @Override // vp.a1
        @os.l
        public List<e1> getParameters() {
            List<e1> listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                u(2);
            }
            return listEmptyList;
        }

        @Override // vp.m
        public boolean h(@os.l eo.h hVar) {
            if (hVar == null) {
                u(9);
            }
            return (hVar instanceof e1) && hp.b.f7476a.f(this.f7340e, (e1) hVar, true);
        }

        @Override // vp.h
        @os.l
        public Collection<vp.f0> k() {
            List<vp.f0> listF0 = this.f7340e.F0();
            if (listF0 == null) {
                u(1);
            }
            return listF0;
        }

        @Override // vp.h
        @os.m
        public vp.f0 l() {
            return vp.x.j("Cyclic upper bounds");
        }

        @Override // vp.a1
        @os.l
        public ao.h n() {
            ao.h hVarG = lp.a.g(this.f7340e);
            if (hVarG == null) {
                u(4);
            }
            return hVarG;
        }

        @Override // vp.h
        @os.l
        public c1 p() {
            c1 c1Var = this.f7339d;
            if (c1Var == null) {
                u(5);
            }
            return c1Var;
        }

        @Override // vp.h
        @os.l
        public List<vp.f0> r(@os.l List<vp.f0> list) {
            if (list == null) {
                u(7);
            }
            List<vp.f0> listB0 = this.f7340e.B0(list);
            if (listB0 == null) {
                u(8);
            }
            return listB0;
        }

        @Override // vp.h
        public void t(@os.l vp.f0 f0Var) {
            if (f0Var == null) {
                u(6);
            }
            this.f7340e.E0(f0Var);
        }

        public String toString() {
            return this.f7340e.getName().f3820a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@os.l up.n nVar, @os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.l o1 o1Var, boolean z10, int i10, @os.l z0 z0Var, @os.l c1 c1Var) {
        super(mVar, gVar, fVar, z0Var);
        if (nVar == null) {
            B(0);
        }
        if (mVar == null) {
            B(1);
        }
        if (gVar == null) {
            B(2);
        }
        if (fVar == null) {
            B(3);
        }
        if (o1Var == null) {
            B(4);
        }
        if (z0Var == null) {
            B(5);
        }
        if (c1Var == null) {
            B(6);
        }
        this.f7327e = o1Var;
        this.f7328f = z10;
        this.f7329g = i10;
        this.f7330i = nVar.h(new a(nVar, c1Var));
        this.f7331n = nVar.h(new b(fVar));
        this.f7332p = nVar;
    }

    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
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
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i10) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.h(this, d10);
    }

    @os.l
    public List<vp.f0> B0(@os.l List<vp.f0> list) {
        if (list == null) {
            B(12);
        }
        if (list == null) {
            B(13);
        }
        return list;
    }

    public abstract void E0(@os.l vp.f0 f0Var);

    @os.l
    public abstract List<vp.f0> F0();

    @Override // eo.e1
    @os.l
    public up.n P() {
        up.n nVar = this.f7332p;
        if (nVar == null) {
            B(14);
        }
        return nVar;
    }

    @Override // eo.e1
    public boolean T() {
        return false;
    }

    @Override // eo.e1
    public int f() {
        return this.f7329g;
    }

    @Override // eo.e1
    @os.l
    public List<vp.f0> getUpperBounds() {
        List<vp.f0> listA = ((c) i()).a();
        if (listA == null) {
            B(8);
        }
        return listA;
    }

    @Override // eo.e1, eo.h
    @os.l
    public final a1 i() {
        a1 a1VarInvoke = this.f7330i.invoke();
        if (a1VarInvoke == null) {
            B(9);
        }
        return a1VarInvoke;
    }

    @Override // eo.e1
    public boolean j() {
        return this.f7328f;
    }

    @Override // eo.e1
    @os.l
    public o1 m() {
        o1 o1Var = this.f7327e;
        if (o1Var == null) {
            B(7);
        }
        return o1Var;
    }

    @Override // eo.h
    @os.l
    public vp.n0 q() {
        vp.n0 n0VarInvoke = this.f7331n.invoke();
        if (n0VarInvoke == null) {
            B(10);
        }
        return n0VarInvoke;
    }

    @Override // ho.k
    @os.l
    public e1 a() {
        return this;
    }
}
