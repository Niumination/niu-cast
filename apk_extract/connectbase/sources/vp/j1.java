package vp;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f17711a = x.p("DONT_CARE");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n0 f17712b = x.j("Cannot be inferred");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final n0 f17713c = new a("NO_EXPECTED_TYPE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n0 f17714d = new a("UNIT_EXPECTED_TYPE");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f17715e = false;

    public static class a extends q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17716b;

        public a(String str) {
            this.f17716b = str;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0030  */
        private static /* synthetic */ void S0(int i10) {
            String str = (i10 == 1 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 4) ? 2 : 3];
            if (i10 == 1) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else if (i10 == 2) {
                objArr[0] = "delegate";
            } else if (i10 == 3) {
                objArr[0] = "kotlinTypeRefiner";
            } else if (i10 != 4) {
                objArr[0] = "newAnnotations";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
            if (i10 == 1) {
                objArr[1] = "toString";
            } else if (i10 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else {
                objArr[1] = "refine";
            }
            if (i10 != 1) {
                if (i10 == 2) {
                    objArr[2] = "replaceDelegate";
                } else if (i10 == 3) {
                    objArr[2] = "refine";
                } else if (i10 != 4) {
                    objArr[2] = "replaceAnnotations";
                }
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // vp.n1
        @os.l
        public n0 N0(boolean z10) {
            throw new IllegalStateException(this.f17716b);
        }

        @Override // vp.n1
        @os.l
        public n0 O0(@os.l fo.g gVar) {
            if (gVar == null) {
                S0(0);
            }
            throw new IllegalStateException(this.f17716b);
        }

        @Override // vp.q
        @os.l
        public n0 P0() {
            throw new IllegalStateException(this.f17716b);
        }

        @Override // vp.q
        @os.l
        public q R0(@os.l n0 n0Var) {
            if (n0Var == null) {
                S0(2);
            }
            throw new IllegalStateException(this.f17716b);
        }

        @Override // vp.q
        @os.l
        /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a Q0(@os.l wp.g gVar) {
            if (gVar == null) {
                S0(3);
            }
            return this;
        }

        @Override // vp.n0
        @os.l
        public String toString() {
            String str = this.f17716b;
            if (str == null) {
                S0(1);
            }
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:76:0x010b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0122  */
    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 4 && i10 != 9 && i10 != 11 && i10 != 15 && i10 != 17 && i10 != 19 && i10 != 26 && i10 != 35 && i10 != 49 && i10 != 54 && i10 != 6 && i10 != 7) {
            switch (i10) {
                case 57:
                case 58:
                case 59:
                case 60:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 4 && i10 != 9 && i10 != 11 && i10 != 15 && i10 != 17 && i10 != 19 && i10 != 26 && i10 != 35 && i10 != 49 && i10 != 54 && i10 != 6 && i10 != 7) {
            switch (i10) {
                case 57:
                case 58:
                case 59:
                case 60:
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
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 54:
            case 57:
            case 58:
            case 59:
            case 60:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = ik.y0.a.f8215h;
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
            case 46:
                objArr[0] = "isSpecialType";
                break;
            case 45:
                objArr[0] = "shouldStopAt";
                break;
            case 47:
                objArr[0] = "parameterDescriptor";
                break;
            case 48:
            case 52:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                objArr[0] = "supertypes";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 56:
                objArr[0] = "expectedType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "makeNullableAsSpecified";
        } else if (i10 == 9) {
            objArr[1] = "makeNullableIfNeeded";
        } else if (i10 == 11 || i10 == 15) {
            objArr[1] = "makeUnsubstitutedType";
        } else if (i10 == 17) {
            objArr[1] = "getDefaultTypeProjections";
        } else if (i10 == 19) {
            objArr[1] = "getImmediateSupertypes";
        } else if (i10 == 26) {
            objArr[1] = "getAllSupertypes";
        } else if (i10 == 35) {
            objArr[1] = "substituteProjectionsForParameters";
        } else if (i10 == 49) {
            objArr[1] = "getDefaultPrimitiveNumberType";
        } else if (i10 != 54) {
            if (i10 != 6 && i10 != 7) {
                switch (i10) {
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                        objArr[1] = "getPrimitiveNumberType";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                }
            } else {
                objArr[1] = "makeNullableIfNeeded";
            }
        } else {
            objArr[1] = "getPrimitiveNumberType";
        }
        switch (i10) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 54:
            case 57:
            case 58:
            case 59:
            case 60:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 46:
                objArr[2] = "contains";
                break;
            case 44:
            case 45:
                objArr[2] = "containsStoppingAt";
                break;
            case 47:
                objArr[2] = "makeStarProjection";
                break;
            case 48:
            case 50:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                objArr[2] = "findByFqName";
                break;
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 61:
                objArr[2] = "isTypeParameter";
                break;
            case 62:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 63:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 64:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 9 && i10 != 11 && i10 != 15 && i10 != 17 && i10 != 19 && i10 != 26 && i10 != 35 && i10 != 49 && i10 != 54 && i10 != 6 && i10 != 7) {
            switch (i10) {
                case 57:
                case 58:
                case 59:
                case 60:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(28);
        }
        if (f0Var.H0()) {
            return true;
        }
        return c0.b(f0Var) && b(c0.a(f0Var).f17774c);
    }

    public static boolean c(@os.m f0 f0Var, @os.l jn.l<n1, Boolean> lVar) {
        if (lVar == null) {
            a(43);
        }
        return d(f0Var, lVar, null, null);
    }

    public static boolean d(@os.m f0 f0Var, @os.l jn.l<n1, Boolean> lVar, @os.m jn.l<f0, Boolean> lVar2, eq.f<f0> fVar) {
        if (lVar == null) {
            a(46);
        }
        if (f0Var == null) {
            return false;
        }
        n1 n1VarJ0 = f0Var.J0();
        if (w(f0Var)) {
            return lVar.invoke(n1VarJ0).booleanValue();
        }
        if (fVar != null && fVar.contains(f0Var)) {
            return false;
        }
        if (lVar.invoke(n1VarJ0).booleanValue()) {
            return true;
        }
        if (lVar2 != null && lVar2.invoke(n1VarJ0).booleanValue()) {
            return false;
        }
        if (fVar == null) {
            fVar = eq.f.a();
        }
        fVar.add(f0Var);
        z zVar = n1VarJ0 instanceof z ? (z) n1VarJ0 : null;
        if (zVar != null && (d(zVar.f17773b, lVar, lVar2, fVar) || d(zVar.f17774c, lVar, lVar2, fVar))) {
            return true;
        }
        if ((n1VarJ0 instanceof o) && d(((o) n1VarJ0).f17724b, lVar, lVar2, fVar)) {
            return true;
        }
        a1 a1VarG0 = f0Var.G0();
        if (a1VarG0 instanceof e0) {
            Iterator<f0> it = ((e0) a1VarG0).f17675b.iterator();
            while (it.hasNext()) {
                if (d(it.next(), lVar, lVar2, fVar)) {
                    return true;
                }
            }
            return false;
        }
        for (c1 c1Var : f0Var.F0()) {
            if (!c1Var.a() && d(c1Var.getType(), lVar, lVar2, fVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(@os.m f0 f0Var, @os.l jn.l<n1, Boolean> lVar, @os.l jn.l<f0, Boolean> lVar2) {
        if (lVar == null) {
            a(44);
        }
        if (lVar2 == null) {
            a(45);
        }
        return d(f0Var, lVar, lVar2, null);
    }

    @os.m
    public static f0 f(@os.l f0 f0Var, @os.l f0 f0Var2, @os.l h1 h1Var) {
        if (f0Var == null) {
            a(20);
        }
        if (f0Var2 == null) {
            a(21);
        }
        if (h1Var == null) {
            a(22);
        }
        f0 f0VarP = h1Var.p(f0Var2, o1.INVARIANT);
        if (f0VarP != null) {
            return r(f0VarP, f0Var.H0());
        }
        return null;
    }

    @os.m
    public static eo.e g(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(30);
        }
        eo.h hVarD = f0Var.G0().d();
        if (hVarD instanceof eo.e) {
            return (eo.e) hVarD;
        }
        return null;
    }

    @os.l
    public static List<c1> h(@os.l List<eo.e1> list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<eo.e1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new e1(it.next().q()));
        }
        List<c1> listV5 = nm.h0.V5(arrayList);
        if (listV5 == null) {
            a(17);
        }
        return listV5;
    }

    @os.l
    public static List<f0> i(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(18);
        }
        h1 h1VarF = h1.f(f0Var);
        Collection<f0> collectionA = f0Var.G0().a();
        ArrayList arrayList = new ArrayList(collectionA.size());
        Iterator<f0> it = collectionA.iterator();
        while (it.hasNext()) {
            f0 f0VarF = f(f0Var, it.next(), h1VarF);
            if (f0VarF != null) {
                arrayList.add(f0VarF);
            }
        }
        return arrayList;
    }

    @os.m
    public static eo.e1 j(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(64);
        }
        if (f0Var.G0().d() instanceof eo.e1) {
            return (eo.e1) f0Var.G0().d();
        }
        return null;
    }

    public static boolean k(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(29);
        }
        if (f0Var.G0().d() instanceof eo.e) {
            return false;
        }
        Iterator<f0> it = i(f0Var).iterator();
        while (it.hasNext()) {
            if (m(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(@os.m f0 f0Var) {
        return f0Var != null && f0Var.G0() == f17711a.G0();
    }

    public static boolean m(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(27);
        }
        if (f0Var.H0()) {
            return true;
        }
        if (c0.b(f0Var) && m(c0.a(f0Var).f17774c)) {
            return true;
        }
        if (q0.c(f0Var)) {
            return false;
        }
        if (n(f0Var)) {
            return k(f0Var);
        }
        if (f0Var instanceof f) {
            eo.e1 e1VarA = ((wp.n) ((f) f0Var).f17681b).a();
            return e1VarA == null || k(e1VarA.q());
        }
        a1 a1VarG0 = f0Var.G0();
        if (a1VarG0 instanceof e0) {
            Iterator<f0> it = ((e0) a1VarG0).f17675b.iterator();
            while (it.hasNext()) {
                if (m(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(61);
        }
        return j(f0Var) != null || (f0Var.G0() instanceof wp.n);
    }

    @os.l
    public static f0 o(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(2);
        }
        return q(f0Var, false);
    }

    @os.l
    public static f0 p(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(1);
        }
        return q(f0Var, true);
    }

    @os.l
    public static f0 q(@os.l f0 f0Var, boolean z10) {
        if (f0Var == null) {
            a(3);
        }
        n1 n1VarN0 = f0Var.J0().N0(z10);
        if (n1VarN0 == null) {
            a(4);
        }
        return n1VarN0;
    }

    @os.l
    public static f0 r(@os.l f0 f0Var, boolean z10) {
        if (f0Var == null) {
            a(8);
        }
        if (z10) {
            return p(f0Var);
        }
        if (f0Var == null) {
            a(9);
        }
        return f0Var;
    }

    @os.l
    public static n0 s(@os.l n0 n0Var, boolean z10) {
        if (n0Var == null) {
            a(5);
        }
        if (!z10) {
            if (n0Var == null) {
                a(7);
            }
            return n0Var;
        }
        n0 n0VarN0 = n0Var.N0(true);
        if (n0VarN0 == null) {
            a(6);
        }
        return n0VarN0;
    }

    @os.l
    public static c1 t(@os.l eo.e1 e1Var) {
        if (e1Var == null) {
            a(47);
        }
        return new s0(e1Var);
    }

    @os.l
    public static n0 u(eo.h hVar, op.h hVar2, jn.l<wp.g, n0> lVar) {
        if (!x.r(hVar)) {
            return v(hVar.i(), hVar2, lVar);
        }
        n0 n0VarJ = x.j("Unsubstituted type for " + hVar);
        if (n0VarJ == null) {
            a(11);
        }
        return n0VarJ;
    }

    @os.l
    public static n0 v(@os.l a1 a1Var, @os.l op.h hVar, @os.l jn.l<wp.g, n0> lVar) {
        if (a1Var == null) {
            a(12);
        }
        if (hVar == null) {
            a(13);
        }
        if (lVar == null) {
            a(14);
        }
        List<c1> listH = h(a1Var.getParameters());
        fo.g.f6167h.getClass();
        n0 n0VarM = g0.m(fo.g.a.f6169b, a1Var, listH, false, hVar, lVar);
        if (n0VarM == null) {
            a(15);
        }
        return n0VarM;
    }

    public static boolean w(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(0);
        }
        return f0Var == f17713c || f0Var == f17714d;
    }
}
