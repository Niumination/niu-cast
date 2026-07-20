package vp;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class h1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h1 f17703b = g(f1.f17686b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f17704c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final f1 f17705a;

    public static class a implements jn.l<dp.c, Boolean> {
        private static /* synthetic */ void a(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // jn.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(@os.l dp.c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(ao.k.a.L));
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17706a;

        static {
            int[] iArr = new int[d.values().length];
            f17706a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17706a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17706a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    public enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public h1(@os.l f1 f1Var) {
        if (f1Var == null) {
            a(7);
        }
        this.f17705a = f1Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 1 && i10 != 2 && i10 != 8 && i10 != 34 && i10 != 37) {
            switch (i10) {
                default:
                    switch (i10) {
                        default:
                            switch (i10) {
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 1 && i10 != 2 && i10 != 8 && i10 != 34 && i10 != 37) {
            switch (i10) {
                case 11:
                case 12:
                case 13:
                    i11 = 2;
                    break;
                default:
                    switch (i10) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            i11 = 2;
                            break;
                        default:
                            switch (i10) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    i11 = 2;
                                    break;
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            i11 = 2;
                                            break;
                                        default:
                                            i11 = 3;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 3:
                objArr[0] = "first";
                break;
            case 4:
                objArr[0] = y1.o.r.f20674f;
                break;
            case 5:
                objArr[0] = "substitutionContext";
                break;
            case 6:
                objArr[0] = "context";
                break;
            case 7:
            default:
                objArr[0] = "substitution";
                break;
            case 9:
            case 14:
                objArr[0] = ik.y0.a.f8215h;
                break;
            case 10:
            case 15:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 16:
            case 17:
            case 36:
                objArr[0] = "typeProjection";
                break;
            case 18:
            case 28:
                objArr[0] = "originalProjection";
                break;
            case 26:
                objArr[0] = "originalType";
                break;
            case 27:
                objArr[0] = "substituted";
                break;
            case 33:
                objArr[0] = "annotations";
                break;
            case 35:
            case 38:
                objArr[0] = "typeParameterVariance";
                break;
            case 39:
                objArr[0] = "projectionKind";
                break;
        }
        if (i10 == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i10 == 2) {
            objArr[1] = "replaceWithContravariantApproximatingSubstitution";
        } else if (i10 == 8) {
            objArr[1] = "getSubstitution";
        } else if (i10 == 34) {
            objArr[1] = "filterOutUnsafeVariance";
        } else if (i10 != 37) {
            switch (i10) {
                case 11:
                case 12:
                case 13:
                    objArr[1] = "safeSubstitute";
                    break;
                default:
                    switch (i10) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            objArr[1] = "unsafeSubstitute";
                            break;
                        default:
                            switch (i10) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                    break;
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            objArr[1] = "combine";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "combine";
        }
        switch (i10) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                break;
            case 3:
            case 4:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 5:
            case 6:
            default:
                objArr[2] = "create";
                break;
            case 7:
                objArr[2] = "<init>";
                break;
            case 9:
            case 10:
                objArr[2] = "safeSubstitute";
                break;
            case 14:
            case 15:
            case 16:
                objArr[2] = "substitute";
                break;
            case 17:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 18:
                objArr[2] = "unsafeSubstitute";
                break;
            case 26:
            case 27:
            case 28:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 33:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 35:
            case 36:
            case 38:
            case 39:
                objArr[2] = "combine";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2 && i10 != 8 && i10 != 34 && i10 != 37) {
            switch (i10) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (i10) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i10) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    break;
                                default:
                                    switch (i10) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    public static void b(int i10, c1 c1Var, f1 f1Var) {
        if (i10 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(c1Var) + "; substitution: " + o(f1Var));
    }

    @os.l
    public static o1 c(@os.l o1 o1Var, @os.l c1 c1Var) {
        if (o1Var == null) {
            a(35);
        }
        if (c1Var == null) {
            a(36);
        }
        if (!c1Var.a()) {
            return d(o1Var, c1Var.c());
        }
        o1 o1Var2 = o1.OUT_VARIANCE;
        if (o1Var2 == null) {
            a(37);
        }
        return o1Var2;
    }

    @os.l
    public static o1 d(@os.l o1 o1Var, @os.l o1 o1Var2) {
        if (o1Var == null) {
            a(38);
        }
        if (o1Var2 == null) {
            a(39);
        }
        o1 o1Var3 = o1.INVARIANT;
        if (o1Var == o1Var3) {
            if (o1Var2 == null) {
                a(40);
            }
            return o1Var2;
        }
        if (o1Var2 == o1Var3) {
            if (o1Var == null) {
                a(41);
            }
            return o1Var;
        }
        if (o1Var == o1Var2) {
            if (o1Var2 == null) {
                a(42);
            }
            return o1Var2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + o1Var + "' and projection kind '" + o1Var2 + "' cannot be combined");
    }

    public static d e(o1 o1Var, o1 o1Var2) {
        o1 o1Var3 = o1.IN_VARIANCE;
        if (o1Var == o1Var3 && o1Var2 == o1.OUT_VARIANCE) {
            return d.OUT_IN_IN_POSITION;
        }
        return (o1Var == o1.OUT_VARIANCE && o1Var2 == o1Var3) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    @os.l
    public static h1 f(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(6);
        }
        return g(b1.i(f0Var.G0(), f0Var.F0()));
    }

    @os.l
    public static h1 g(@os.l f1 f1Var) {
        if (f1Var == null) {
            a(0);
        }
        return new h1(f1Var);
    }

    @os.l
    public static h1 h(@os.l f1 f1Var, @os.l f1 f1Var2) {
        if (f1Var == null) {
            a(3);
        }
        if (f1Var2 == null) {
            a(4);
        }
        return g(t.i(f1Var, f1Var2));
    }

    @os.l
    public static fo.g i(@os.l fo.g gVar) {
        if (gVar == null) {
            a(33);
        }
        return !gVar.p(ao.k.a.L) ? gVar : new fo.l(gVar, new a());
    }

    @os.l
    public static c1 l(@os.l f0 f0Var, @os.l c1 c1Var, @os.m eo.e1 e1Var, @os.l c1 c1Var2) {
        if (f0Var == null) {
            a(26);
        }
        if (c1Var == null) {
            a(27);
        }
        if (c1Var2 == null) {
            a(28);
        }
        if (!f0Var.getAnnotations().p(ao.k.a.L)) {
            if (c1Var == null) {
                a(29);
            }
            return c1Var;
        }
        a1 a1VarG0 = c1Var.getType().G0();
        if (!(a1VarG0 instanceof wp.j)) {
            return c1Var;
        }
        c1 c1Var3 = ((wp.j) a1VarG0).f19861a;
        o1 o1VarC = c1Var3.c();
        d dVarE = e(c1Var2.c(), o1VarC);
        d dVar = d.OUT_IN_IN_POSITION;
        if (dVarE == dVar) {
            return new e1(c1Var3.getType());
        }
        return (e1Var != null && e(e1Var.m(), o1VarC) == dVar) ? new e1(c1Var3.getType()) : c1Var;
    }

    public static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th2) {
            if (eq.c.a(th2)) {
                throw th2;
            }
            return "[Exception while computing toString(): " + th2 + "]";
        }
    }

    @os.l
    public f1 j() {
        f1 f1Var = this.f17705a;
        if (f1Var == null) {
            a(8);
        }
        return f1Var;
    }

    public boolean k() {
        return this.f17705a.f();
    }

    @os.l
    public h1 m() {
        f1 f1Var = this.f17705a;
        if (!(f1Var instanceof d0) || !f1Var.b()) {
            return this;
        }
        f1 f1Var2 = this.f17705a;
        return new h1(new d0(((d0) f1Var2).f17670c, ((d0) f1Var2).f17671d, false));
    }

    @os.l
    public f0 n(@os.l f0 f0Var, @os.l o1 o1Var) {
        if (f0Var == null) {
            a(9);
        }
        if (o1Var == null) {
            a(10);
        }
        if (k()) {
            if (f0Var == null) {
                a(11);
            }
            return f0Var;
        }
        try {
            f0 type = u(new e1(o1Var, f0Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e10) {
            n0 n0VarJ = x.j(e10.getMessage());
            if (n0VarJ == null) {
                a(13);
            }
            return n0VarJ;
        }
    }

    @os.m
    public f0 p(@os.l f0 f0Var, @os.l o1 o1Var) {
        if (f0Var == null) {
            a(14);
        }
        if (o1Var == null) {
            a(15);
        }
        c1 c1VarQ = q(new e1(o1Var, j().g(f0Var, o1Var)));
        if (c1VarQ == null) {
            return null;
        }
        return c1VarQ.getType();
    }

    @os.m
    public c1 q(@os.l c1 c1Var) {
        if (c1Var == null) {
            a(16);
        }
        c1 c1VarT = t(c1Var);
        return (this.f17705a.a() || this.f17705a.b()) ? aq.b.c(c1VarT, this.f17705a.b()) : c1VarT;
    }

    public final c1 r(c1 c1Var, int i10) throws c {
        f0 type = c1Var.getType();
        o1 o1VarC = c1Var.c();
        if (type.G0().d() instanceof eo.e1) {
            return c1Var;
        }
        n0 n0VarB = q0.b(type);
        f0 f0VarP = n0VarB != null ? m().p(n0VarB, o1.INVARIANT) : null;
        f0 f0VarB = g1.b(type, s(type.G0().getParameters(), type.F0(), i10), this.f17705a.d(type.getAnnotations()));
        if ((f0VarB instanceof n0) && (f0VarP instanceof n0)) {
            f0VarB = q0.j((n0) f0VarB, (n0) f0VarP);
        }
        return new e1(o1VarC, f0VarB);
    }

    public final List<c1> s(List<eo.e1> list, List<c1> list2, int i10) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z10 = false;
        for (int i11 = 0; i11 < list.size(); i11++) {
            eo.e1 e1Var = list.get(i11);
            c1 c1Var = list2.get(i11);
            c1 c1VarU = u(c1Var, e1Var, i10 + 1);
            int i12 = b.f17706a[e(e1Var.m(), c1VarU.c()).ordinal()];
            if (i12 == 1 || i12 == 2) {
                c1VarU = j1.t(e1Var);
            } else if (i12 == 3) {
                o1 o1VarM = e1Var.m();
                o1 o1Var = o1.INVARIANT;
                if (o1VarM != o1Var && !c1VarU.a()) {
                    c1VarU = new e1(o1Var, c1VarU.getType());
                }
            }
            if (c1VarU != c1Var) {
                z10 = true;
            }
            arrayList.add(c1VarU);
        }
        return !z10 ? list2 : arrayList;
    }

    @os.m
    public c1 t(@os.l c1 c1Var) {
        if (c1Var == null) {
            a(17);
        }
        if (k()) {
            return c1Var;
        }
        try {
            return u(c1Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [fo.a, vp.f0] */
    /* JADX WARN: Type inference failed for: r3v4, types: [vp.f1] */
    /* JADX WARN: Type inference failed for: r6v15, types: [vp.f0] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @os.l
    public final c1 u(@os.l c1 c1Var, @os.m eo.e1 e1Var, int i10) throws c {
        ?? F0;
        if (c1Var == null) {
            a(18);
        }
        b(i10, c1Var, this.f17705a);
        if (c1Var.a()) {
            return c1Var;
        }
        ?? type = c1Var.getType();
        if (type instanceof k1) {
            k1 k1Var = (k1) type;
            n1 n1VarB0 = k1Var.B0();
            f0 f0VarF0 = k1Var.f0();
            c1 c1VarU = u(new e1(c1Var.c(), n1VarB0), e1Var, i10 + 1);
            if (c1VarU.a()) {
                return c1VarU;
            }
            yp.i iVarP = p(f0VarF0, c1Var.c());
            n1 n1VarJ0 = c1VarU.getType().J0();
            if (iVarP instanceof k1) {
                F0 = iVarP;
                F0 = ((k1) iVarP).f0();
            }
            F0 = iVarP;
            return new e1(c1VarU.c(), l1.e(n1VarJ0, F0));
        }
        if (!v.a(type) && !(type.J0() instanceof m0)) {
            c1 c1VarE = this.f17705a.e(type);
            c1 c1VarL = c1VarE != null ? l(type, c1VarE, e1Var, c1Var) : null;
            o1 o1VarC = c1Var.c();
            if (c1VarL == null && c0.b(type) && !y0.b(type)) {
                z zVarA = c0.a(type);
                int i11 = i10 + 1;
                c1 c1VarU2 = u(new e1(o1VarC, zVarA.f17773b), e1Var, i11);
                c1 c1VarU3 = u(new e1(o1VarC, zVarA.f17774c), e1Var, i11);
                return (c1VarU2.getType() == zVarA.f17773b && c1VarU3.getType() == zVarA.f17774c) ? c1Var : new e1(c1VarU2.c(), g0.d(g1.a(c1VarU2.getType()), g1.a(c1VarU3.getType())));
            }
            if (!ao.h.l0(type) && !h0.a(type)) {
                if (c1VarL == null) {
                    c1 c1VarR = r(c1Var, i10);
                    if (c1VarR == null) {
                        a(25);
                    }
                    return c1VarR;
                }
                d dVarE = e(o1VarC, c1VarL.c());
                if (!ip.d.d(type)) {
                    int i12 = b.f17706a[dVarE.ordinal()];
                    if (i12 == 1) {
                        throw new c("Out-projection in in-position");
                    }
                    if (i12 == 2) {
                        return new e1(o1.OUT_VARIANCE, type.G0().n().I());
                    }
                }
                n nVarA = y0.a(type);
                if (c1VarL.a()) {
                    return c1VarL;
                }
                f0 f0VarZ = nVarA != null ? nVarA.Z(c1VarL.getType()) : j1.r(c1VarL.getType(), type.H0());
                if (!type.getAnnotations().isEmpty()) {
                    f0VarZ = zp.a.r(f0VarZ, new fo.k(f0VarZ.getAnnotations(), i(this.f17705a.d(type.getAnnotations()))));
                }
                if (dVarE == d.NO_CONFLICT) {
                    o1VarC = d(o1VarC, c1VarL.c());
                }
                return new e1(o1VarC, f0VarZ);
            }
        }
        return c1Var;
    }
}
