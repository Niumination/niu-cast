package ho;

import eo.e1;
import eo.t0;
import eo.y0;
import eo.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import vp.a1;

/* JADX INFO: loaded from: classes3.dex */
public class n extends g {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ boolean f7376y = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a1 f7377p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final op.h f7378v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final up.i<Set<dp.f>> f7379w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final fo.g f7380x;

    public class a extends op.i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ boolean f7381f = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final up.g<dp.f, Collection<? extends y0>> f7382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final up.g<dp.f, Collection<? extends t0>> f7383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final up.i<Collection<eo.m>> f7384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ n f7385e;

        /* JADX INFO: renamed from: ho.n$a$a, reason: collision with other inner class name */
        public class C0203a implements jn.l<dp.f, Collection<? extends y0>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f7386a;

            public C0203a(n nVar) {
                this.f7386a = nVar;
            }

            @Override // jn.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends y0> invoke(dp.f fVar) {
                return a.this.n(fVar);
            }
        }

        public class b implements jn.l<dp.f, Collection<? extends t0>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f7388a;

            public b(n nVar) {
                this.f7388a = nVar;
            }

            @Override // jn.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends t0> invoke(dp.f fVar) {
                return a.this.o(fVar);
            }
        }

        public class c implements jn.a<Collection<eo.m>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f7390a;

            public c(n nVar) {
                this.f7390a = nVar;
            }

            @Override // jn.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<eo.m> invoke() {
                return a.this.m();
            }
        }

        public class d extends hp.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Set f7392a;

            public d(Set set) {
                this.f7392a = set;
            }

            public static /* synthetic */ void f(int i10) {
                Object[] objArr = new Object[3];
                if (i10 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i10 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i10 == 1 || i10 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // hp.i
            public void a(@os.l eo.b bVar) {
                if (bVar == null) {
                    f(0);
                }
                hp.j.L(bVar, null);
                this.f7392a.add(bVar);
            }

            @Override // hp.h
            public void e(@os.l eo.b bVar, @os.l eo.b bVar2) {
                if (bVar == null) {
                    f(1);
                }
                if (bVar2 == null) {
                    f(2);
                }
            }
        }

        public a(@os.l n nVar, up.n nVar2) {
            if (nVar2 == null) {
                i(0);
            }
            this.f7385e = nVar;
            this.f7382b = nVar2.a(new C0203a(nVar));
            this.f7383c = nVar2.a(new b(nVar));
            this.f7384d = nVar2.h(new c(nVar));
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0014  */
        public static /* synthetic */ void i(int i10) {
            String str;
            int i11;
            if (i10 != 3 && i10 != 7 && i10 != 9 && i10 != 12) {
                switch (i10) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i10 != 3 && i10 != 7 && i10 != 9 && i10 != 12) {
                switch (i10) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
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
                case 8:
                case 10:
                    objArr[0] = "name";
                    break;
                case 2:
                case 6:
                    objArr[0] = "location";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i10 == 3) {
                objArr[1] = "getContributedVariables";
            } else if (i10 == 7) {
                objArr[1] = "getContributedFunctions";
            } else if (i10 == 9) {
                objArr[1] = "getSupertypeScope";
            } else if (i10 != 12) {
                switch (i10) {
                    case 15:
                        objArr[1] = "getContributedDescriptors";
                        break;
                    case 16:
                        objArr[1] = "computeAllDeclarations";
                        break;
                    case 17:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 18:
                        objArr[1] = "getClassifierNames";
                        break;
                    case 19:
                        objArr[1] = "getVariableNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                        break;
                }
            } else {
                objArr[1] = "resolveFakeOverrides";
            }
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 3 && i10 != 7 && i10 != 9 && i10 != 12) {
                switch (i10) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // op.i, op.h, op.k
        @os.l
        public Collection<? extends y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            Collection<? extends y0> collectionInvoke = this.f7382b.invoke(fVar);
            if (collectionInvoke == null) {
                i(7);
            }
            return collectionInvoke;
        }

        @Override // op.i, op.h
        @os.l
        public Set<dp.f> b() {
            Set<dp.f> set = (Set) this.f7385e.f7379w.invoke();
            if (set == null) {
                i(17);
            }
            return set;
        }

        @Override // op.i, op.h
        @os.l
        public Collection<? extends t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            Collection<? extends t0> collectionInvoke = this.f7383c.invoke(fVar);
            if (collectionInvoke == null) {
                i(3);
            }
            return collectionInvoke;
        }

        @Override // op.i, op.h
        @os.l
        public Set<dp.f> d() {
            Set<dp.f> set = (Set) this.f7385e.f7379w.invoke();
            if (set == null) {
                i(19);
            }
            return set;
        }

        @Override // op.i, op.k
        @os.l
        public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
            if (dVar == null) {
                i(13);
            }
            if (lVar == null) {
                i(14);
            }
            Collection<eo.m> collectionInvoke = this.f7384d.invoke();
            if (collectionInvoke == null) {
                i(15);
            }
            return collectionInvoke;
        }

        @Override // op.i, op.h
        @os.l
        public Set<dp.f> h() {
            Set<dp.f> setEmptySet = Collections.emptySet();
            if (setEmptySet == null) {
                i(18);
            }
            return setEmptySet;
        }

        @os.l
        public final Collection<eo.m> m() {
            HashSet hashSet = new HashSet();
            for (dp.f fVar : (Set) this.f7385e.f7379w.invoke()) {
                mo.d dVar = mo.d.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(a(fVar, dVar));
                hashSet.addAll(c(fVar, dVar));
            }
            return hashSet;
        }

        @os.l
        public final Collection<? extends y0> n(@os.l dp.f fVar) {
            if (fVar == null) {
                i(8);
            }
            return q(fVar, p().a(fVar, mo.d.FOR_NON_TRACKED_SCOPE));
        }

        @os.l
        public final Collection<? extends t0> o(@os.l dp.f fVar) {
            if (fVar == null) {
                i(4);
            }
            return q(fVar, p().c(fVar, mo.d.FOR_NON_TRACKED_SCOPE));
        }

        @os.l
        public final op.h p() {
            op.h hVarO = this.f7385e.i().a().iterator().next().o();
            if (hVarO == null) {
                i(9);
            }
            return hVarO;
        }

        @os.l
        public final <D extends eo.b> Collection<? extends D> q(@os.l dp.f fVar, @os.l Collection<? extends D> collection) {
            if (fVar == null) {
                i(10);
            }
            if (collection == null) {
                i(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            hp.j.f7490d.w(fVar, collection, Collections.emptySet(), this.f7385e, new d(linkedHashSet));
            return linkedHashSet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@os.l up.n nVar, @os.l eo.e eVar, @os.l vp.f0 f0Var, @os.l dp.f fVar, @os.l up.i<Set<dp.f>> iVar, @os.l fo.g gVar, @os.l z0 z0Var) {
        super(nVar, eVar, fVar, z0Var, false);
        if (nVar == null) {
            f0(6);
        }
        if (eVar == null) {
            f0(7);
        }
        if (f0Var == null) {
            f0(8);
        }
        if (fVar == null) {
            f0(9);
        }
        if (iVar == null) {
            f0(10);
        }
        if (gVar == null) {
            f0(11);
        }
        if (z0Var == null) {
            f0(12);
        }
        this.f7380x = gVar;
        this.f7377p = new vp.l(this, Collections.emptyList(), Collections.singleton(f0Var), nVar);
        this.f7378v = new a(this, nVar);
        this.f7379w = iVar;
    }

    @os.l
    public static n F0(@os.l up.n nVar, @os.l eo.e eVar, @os.l dp.f fVar, @os.l up.i<Set<dp.f>> iVar, @os.l fo.g gVar, @os.l z0 z0Var) {
        if (nVar == null) {
            f0(0);
        }
        if (eVar == null) {
            f0(1);
        }
        if (fVar == null) {
            f0(2);
        }
        if (iVar == null) {
            f0(3);
        }
        if (gVar == null) {
            f0(4);
        }
        if (z0Var == null) {
            f0(5);
        }
        return new n(nVar, eVar, eVar.q(), fVar, iVar, gVar, z0Var);
    }

    private static /* synthetic */ void f0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // eo.e
    @os.m
    public eo.d G() {
        return null;
    }

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    @Override // ho.t
    @os.l
    public op.h Z(@os.l wp.g gVar) {
        if (gVar == null) {
            f0(13);
        }
        op.h hVar = this.f7378v;
        if (hVar == null) {
            f0(14);
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
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            f0(16);
        }
        return listEmptyList;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        fo.g gVar = this.f7380x;
        if (gVar == null) {
            f0(21);
        }
        return gVar;
    }

    @Override // eo.e
    @os.l
    public eo.f getKind() {
        eo.f fVar = eo.f.ENUM_ENTRY;
        if (fVar == null) {
            f0(18);
        }
        return fVar;
    }

    @Override // eo.e, eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = eo.t.f4633e;
        if (uVar == null) {
            f0(20);
        }
        return uVar;
    }

    @Override // eo.h
    @os.l
    public a1 i() {
        a1 a1Var = this.f7377p;
        if (a1Var == null) {
            f0(17);
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
            f0(23);
        }
        return listEmptyList;
    }

    @Override // eo.e
    @os.l
    public op.h k0() {
        op.h.c cVar = op.h.c.f12406b;
        if (cVar == null) {
            f0(15);
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
            f0(22);
        }
        return listEmptyList;
    }

    @Override // eo.e, eo.d0
    @os.l
    public eo.e0 s() {
        eo.e0 e0Var = eo.e0.FINAL;
        if (e0Var == null) {
            f0(19);
        }
        return e0Var;
    }

    @Override // eo.e
    public boolean t() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
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
