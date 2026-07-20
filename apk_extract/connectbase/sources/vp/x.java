package vp;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eo.h0 f17760a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f17761b = new c(dp.f.n("<ERROR CLASS>"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n0 f17762c = j("<LOOP IN SUPERTYPES>");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f0 f17763d = j("<ERROR PROPERTY TYPE>");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final eo.t0 f17764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<eo.t0> f17765f;

    public static class a implements eo.h0 {
        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        private static /* synthetic */ void B(int i10) {
            String str;
            int i11;
            if (i10 != 1 && i10 != 4 && i10 != 5 && i10 != 6 && i10 != 13 && i10 != 14) {
                switch (i10) {
                    case 8:
                    case 9:
                    case 10:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i10 != 1 && i10 != 4 && i10 != 5 && i10 != 6 && i10 != 13 && i10 != 14) {
                switch (i10) {
                    case 8:
                    case 9:
                    case 10:
                        i11 = 2;
                        break;
                    default:
                        i11 = 3;
                        break;
                }
            } else {
                i11 = 2;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 2:
                case 7:
                    objArr[0] = "fqName";
                    break;
                case 3:
                    objArr[0] = "nameFilter";
                    break;
                case 11:
                    objArr[0] = "visitor";
                    break;
                case 12:
                    objArr[0] = "targetModule";
                    break;
                default:
                    objArr[0] = "capability";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "getAnnotations";
            } else if (i10 == 4) {
                objArr[1] = "getSubPackagesOf";
            } else if (i10 == 5) {
                objArr[1] = "getName";
            } else if (i10 == 6) {
                objArr[1] = "getStableName";
            } else if (i10 == 13) {
                objArr[1] = "getOriginal";
            } else if (i10 != 14) {
                switch (i10) {
                    case 8:
                        objArr[1] = "getAllDependencyModules";
                        break;
                    case 9:
                        objArr[1] = "getExpectedByModules";
                        break;
                    case 10:
                        objArr[1] = "getAllExpectedByModules";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                        break;
                }
            } else {
                objArr[1] = "getBuiltIns";
            }
            switch (i10) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    break;
                case 2:
                case 3:
                    objArr[2] = "getSubPackagesOf";
                    break;
                case 7:
                    objArr[2] = "getPackage";
                    break;
                case 11:
                    objArr[2] = "accept";
                    break;
                case 12:
                    objArr[2] = "shouldSeeInternalsOf";
                    break;
                default:
                    objArr[2] = "getCapability";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 4 && i10 != 5 && i10 != 6 && i10 != 13 && i10 != 14) {
                switch (i10) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // eo.m
        public <R, D> R A(@os.l eo.o<R, D> oVar, D d10) {
            if (oVar != null) {
                return null;
            }
            B(11);
            return null;
        }

        @Override // eo.h0
        public boolean E(@os.l eo.h0 h0Var) {
            if (h0Var != null) {
                return false;
            }
            B(12);
            return false;
        }

        @Override // eo.h0
        @os.m
        public <T> T M(@os.l eo.g0<T> g0Var) {
            if (g0Var != null) {
                return null;
            }
            B(0);
            return null;
        }

        @Override // eo.m
        @os.l
        public eo.m a() {
            return this;
        }

        @Override // eo.m
        @os.m
        public eo.m b() {
            return null;
        }

        @Override // fo.a
        @os.l
        public fo.g getAnnotations() {
            fo.g.f6167h.getClass();
            fo.g gVar = fo.g.a.f6169b;
            if (gVar == null) {
                B(1);
            }
            return gVar;
        }

        @Override // eo.i0
        @os.l
        public dp.f getName() {
            dp.f fVarN = dp.f.n("<ERROR MODULE>");
            if (fVarN == null) {
                B(5);
            }
            return fVarN;
        }

        @Override // eo.h0
        @os.l
        public ao.h n() {
            ao.e eVarE0 = ao.e.E0();
            if (eVarE0 == null) {
                B(14);
            }
            return eVarE0;
        }

        @Override // eo.h0
        @os.l
        public eo.p0 o0(@os.l dp.c cVar) {
            if (cVar == null) {
                B(7);
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // eo.h0
        @os.l
        public Collection<dp.c> p(@os.l dp.c cVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
            if (cVar == null) {
                B(2);
            }
            if (lVar == null) {
                B(3);
            }
            nm.k0 k0Var = nm.k0.INSTANCE;
            if (k0Var == null) {
                B(4);
            }
            return k0Var;
        }

        @Override // eo.h0
        @os.l
        public List<eo.h0> v0() {
            nm.k0 k0Var = nm.k0.INSTANCE;
            if (k0Var == null) {
                B(9);
            }
            return k0Var;
        }
    }

    public static class b implements a1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f17766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17767b;

        public b(c cVar, String str) {
            this.f17766a = cVar;
            this.f17767b = str;
        }

        private static /* synthetic */ void f(int i10) {
            String str = i10 != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i10 != 3 ? 2 : 3];
            if (i10 != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i10 == 1) {
                objArr[1] = "getSupertypes";
            } else if (i10 == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i10 == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i10 != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i10 == 3) {
                objArr[2] = "refine";
            }
            String str2 = String.format(str, objArr);
            if (i10 == 3) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // vp.a1
        @os.l
        public Collection<f0> a() {
            nm.k0 k0Var = nm.k0.INSTANCE;
            if (k0Var == null) {
                f(1);
            }
            return k0Var;
        }

        @Override // vp.a1
        @os.l
        public a1 b(@os.l wp.g gVar) {
            if (gVar == null) {
                f(3);
            }
            return this;
        }

        @Override // vp.a1
        @os.m
        public eo.h d() {
            return this.f17766a;
        }

        @Override // vp.a1
        public boolean e() {
            return false;
        }

        @Override // vp.a1
        @os.l
        public List<eo.e1> getParameters() {
            nm.k0 k0Var = nm.k0.INSTANCE;
            if (k0Var == null) {
                f(0);
            }
            return k0Var;
        }

        @Override // vp.a1
        @os.l
        public ao.h n() {
            ao.e eVarE0 = ao.e.E0();
            if (eVarE0 == null) {
                f(2);
            }
            return eVarE0;
        }

        public String toString() {
            return this.f17767b;
        }
    }

    public static class c extends ho.h {
        /* JADX WARN: Illegal instructions before constructor call */
        public c(@os.l dp.f fVar) {
            if (fVar == null) {
                f0(0);
            }
            eo.h0 h0VarQ = x.q();
            eo.e0 e0Var = eo.e0.OPEN;
            eo.f fVar2 = eo.f.CLASS;
            List listEmptyList = Collections.emptyList();
            eo.z0 z0Var = eo.z0.f4654a;
            super(h0VarQ, fVar, e0Var, fVar2, listEmptyList, z0Var, false, up.f.f16364e);
            fo.g.f6167h.getClass();
            ho.f fVarG1 = ho.f.g1(this, fo.g.a.f6169b, true, z0Var);
            fVarG1.j1(Collections.emptyList(), eo.t.f4632d);
            op.h hVarH = x.h(getName().b());
            fVarG1.a1(new w(x.m("<ERROR>", this), hVarH));
            E0(hVarH, Collections.singleton(fVarG1), fVarG1);
        }

        private static /* synthetic */ void f0(int i10) {
            String str = (i10 == 2 || i10 == 5 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 2 || i10 == 5 || i10 == 8) ? 2 : 3];
            switch (i10) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i10 == 2) {
                objArr[1] = "substitute";
            } else if (i10 == 5 || i10 == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i10) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 2 && i10 != 5 && i10 != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // ho.a, ho.t
        @os.l
        public op.h B(@os.l f1 f1Var, @os.l wp.g gVar) {
            if (f1Var == null) {
                f0(6);
            }
            if (gVar == null) {
                f0(7);
            }
            op.h hVarH = x.h("Error scope for class " + getName() + " with arguments: " + f1Var);
            if (hVarH == null) {
                f0(8);
            }
            return hVarH;
        }

        @Override // ho.a, eo.b1
        @os.l
        /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
        public eo.e c(@os.l h1 h1Var) {
            if (h1Var == null) {
                f0(1);
            }
            return this;
        }

        @Override // ho.h
        public String toString() {
            return getName().b();
        }
    }

    public static class d implements op.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17768b;

        public /* synthetic */ d(String str, a aVar) {
            this(str);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x000d  */
        private static /* synthetic */ void i(int i10) {
            String str;
            int i11;
            if (i10 != 7 && i10 != 18) {
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
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i10 != 7 && i10 != 18) {
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
            } else {
                i11 = 2;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                case 3:
                case 5:
                case 8:
                case 14:
                case 19:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 9:
                case 15:
                    objArr[0] = "location";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
                case 16:
                    objArr[0] = "kindFilter";
                    break;
                case 17:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "debugMessage";
                    break;
            }
            if (i10 == 7) {
                objArr[1] = "getContributedVariables";
            } else if (i10 != 18) {
                switch (i10) {
                    case 10:
                        objArr[1] = "getContributedFunctions";
                        break;
                    case 11:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 12:
                        objArr[1] = "getVariableNames";
                        break;
                    case 13:
                        objArr[1] = "getClassifierNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                        break;
                }
            } else {
                objArr[1] = "getContributedDescriptors";
            }
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    break;
                case 8:
                case 9:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 14:
                case 15:
                    objArr[2] = "recordLookup";
                    break;
                case 16:
                case 17:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 19:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 7 && i10 != 18) {
                switch (i10) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // op.h
        @os.l
        public Set<dp.f> b() {
            Set<dp.f> setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                i(11);
            }
            return setEmptySet;
        }

        @Override // op.h
        @os.l
        public Set<dp.f> d() {
            Set<dp.f> setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                i(12);
            }
            return setEmptySet;
        }

        @Override // op.k
        @os.l
        public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
            if (dVar == null) {
                i(16);
            }
            if (lVar == null) {
                i(17);
            }
            List listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                i(18);
            }
            return listEmptyList;
        }

        @Override // op.k
        @os.m
        public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            return x.e(fVar.b());
        }

        @Override // op.k
        public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(14);
            }
            if (bVar == null) {
                i(15);
            }
        }

        @Override // op.h
        @os.l
        public Set<dp.f> h() {
            Set<dp.f> setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                i(13);
            }
            return setEmptySet;
        }

        @Override // op.h, op.k
        @os.l
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Set<? extends eo.y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(8);
            }
            if (bVar == null) {
                i(9);
            }
            Set<? extends eo.y0> setSingleton = Collections.singleton(x.f(this));
            if (setSingleton == null) {
                i(10);
            }
            return setSingleton;
        }

        @Override // op.h
        @os.l
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Set<? extends eo.t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            Set<? extends eo.t0> set = x.f17765f;
            if (set == null) {
                i(7);
            }
            return set;
        }

        public String toString() {
            return l.a.a(new StringBuilder("ErrorScope{"), this.f17768b, rs.f.f14860b);
        }

        public d(@os.l String str) {
            if (str == null) {
                i(0);
            }
            this.f17768b = str;
        }
    }

    public static class e implements op.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17769b;

        public /* synthetic */ e(String str, a aVar) {
            this(str);
        }

        private static /* synthetic */ void i(int i10) {
            Object[] objArr = new Object[3];
            switch (i10) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // op.h, op.k
        @os.l
        public Collection<? extends eo.y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(7);
            }
            if (bVar == null) {
                i(8);
            }
            throw new IllegalStateException(this.f17769b + ", required name: " + fVar);
        }

        @Override // op.h
        @os.l
        public Set<dp.f> b() {
            throw new IllegalStateException();
        }

        @Override // op.h
        @os.l
        public Collection<? extends eo.t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            throw new IllegalStateException(this.f17769b + ", required name: " + fVar);
        }

        @Override // op.h
        @os.l
        public Set<dp.f> d() {
            throw new IllegalStateException();
        }

        @Override // op.k
        @os.l
        public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
            if (dVar == null) {
                i(9);
            }
            if (lVar == null) {
                i(10);
            }
            throw new IllegalStateException(this.f17769b);
        }

        @Override // op.k
        @os.m
        public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            throw new IllegalStateException(this.f17769b + ", required name: " + fVar);
        }

        @Override // op.k
        public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(11);
            }
            if (bVar == null) {
                i(12);
            }
            throw new IllegalStateException();
        }

        @Override // op.h
        public Set<dp.f> h() {
            throw new IllegalStateException();
        }

        public String toString() {
            return l.a.a(new StringBuilder("ThrowingScope{"), this.f17769b, rs.f.f14860b);
        }

        public e(@os.l String str) {
            if (str == null) {
                i(0);
            }
            this.f17769b = str;
        }
    }

    public static class f implements a1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final eo.e1 f17770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a1 f17771b;

        private static /* synthetic */ void f(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 6) ? 2 : 3];
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i10 == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i10 == 2) {
                objArr[1] = "getParameters";
            } else if (i10 == 3) {
                objArr[1] = "getSupertypes";
            } else if (i10 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i10 != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 6) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // vp.a1
        @os.l
        public Collection<f0> a() {
            Collection<f0> collectionA = this.f17771b.a();
            if (collectionA == null) {
                f(3);
            }
            return collectionA;
        }

        @Override // vp.a1
        @os.l
        public a1 b(@os.l wp.g gVar) {
            if (gVar == null) {
                f(5);
            }
            return this;
        }

        @Override // vp.a1
        @os.m
        public eo.h d() {
            return this.f17771b.d();
        }

        @Override // vp.a1
        public boolean e() {
            return this.f17771b.e();
        }

        @os.l
        public eo.e1 g() {
            eo.e1 e1Var = this.f17770a;
            if (e1Var == null) {
                f(1);
            }
            return e1Var;
        }

        @Override // vp.a1
        @os.l
        public List<eo.e1> getParameters() {
            List<eo.e1> parameters = this.f17771b.getParameters();
            if (parameters == null) {
                f(2);
            }
            return parameters;
        }

        @Override // vp.a1
        @os.l
        public ao.h n() {
            ao.h hVarG = lp.a.g(this.f17770a);
            if (hVarG == null) {
                f(4);
            }
            return hVarG;
        }
    }

    static {
        ho.c0 c0VarG = g();
        f17764e = c0VarG;
        f17765f = Collections.singleton(c0VarG);
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 4 || i10 == 6 || i10 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 6 || i10 == 19) ? 2 : 3];
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i10 == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i10 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i10) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 6 && i10 != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public static eo.e e(@os.l String str) {
        if (str == null) {
            a(1);
        }
        return new c(dp.f.n("<ERROR CLASS: " + str + ">"));
    }

    @os.l
    public static eo.y0 f(@os.l d dVar) {
        if (dVar == null) {
            a(5);
        }
        xp.a aVar = new xp.a(f17761b, dVar);
        aVar.L0(null, null, Collections.emptyList(), Collections.emptyList(), j("<ERROR FUNCTION RETURN TYPE>"), eo.e0.OPEN, eo.t.f4633e);
        return aVar;
    }

    @os.l
    public static ho.c0 g() {
        c cVar = f17761b;
        fo.g.f6167h.getClass();
        ho.c0 c0VarI0 = ho.c0.I0(cVar, fo.g.a.f6169b, eo.e0.OPEN, eo.t.f4633e, true, dp.f.n("<ERROR PROPERTY>"), eo.b.a.DECLARATION, eo.z0.f4654a, false, false, false, false, false, false);
        c0VarI0.V0(f17763d, Collections.emptyList(), null, null);
        return c0VarI0;
    }

    @os.l
    public static op.h h(@os.l String str) {
        if (str == null) {
            a(2);
        }
        return i(str, false);
    }

    @os.l
    public static op.h i(@os.l String str, boolean z10) {
        if (str == null) {
            a(3);
        }
        return z10 ? new e(str) : new d(str);
    }

    @os.l
    public static n0 j(@os.l String str) {
        if (str == null) {
            a(7);
        }
        return n(str, Collections.emptyList());
    }

    @os.l
    public static a1 k(@os.l String str) {
        if (str == null) {
            a(15);
        }
        return m(n.a.a("[ERROR : ", str, "]"), f17761b);
    }

    @os.l
    public static a1 l(@os.l String str) {
        if (str == null) {
            a(16);
        }
        return m(str, f17761b);
    }

    @os.l
    public static a1 m(@os.l String str, @os.l c cVar) {
        if (str == null) {
            a(17);
        }
        if (cVar == null) {
            a(18);
        }
        return new b(cVar, str);
    }

    @os.l
    public static n0 n(@os.l String str, @os.l List<c1> list) {
        if (str == null) {
            a(11);
        }
        if (list == null) {
            a(12);
        }
        return new w(k(str), h(str), list, false);
    }

    @os.l
    public static n0 o(@os.l String str, @os.l a1 a1Var) {
        if (str == null) {
            a(9);
        }
        if (a1Var == null) {
            a(10);
        }
        return new w(a1Var, h(str));
    }

    @os.l
    public static n0 p(@os.l String str) {
        if (str == null) {
            a(8);
        }
        return o(str, l(str));
    }

    @os.l
    public static eo.h0 q() {
        eo.h0 h0Var = f17760a;
        if (h0Var == null) {
            a(19);
        }
        return h0Var;
    }

    public static boolean r(@os.m eo.m mVar) {
        if (mVar == null) {
            return false;
        }
        return (mVar instanceof c) || (mVar.b() instanceof c) || mVar == f17760a;
    }

    public static boolean s(@os.m eo.m mVar) {
        return mVar instanceof c;
    }

    public static boolean t(@os.m f0 f0Var) {
        return f0Var != null && (f0Var.G0() instanceof f);
    }
}
