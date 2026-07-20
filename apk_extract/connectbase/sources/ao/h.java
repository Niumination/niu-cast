package ao;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.OSMaskImageView;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import eo.h0;
import eo.k0;
import eo.p0;
import eo.s;
import eo.t0;
import eo.u0;
import eo.v0;
import ho.x;
import ik.y0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vp.a1;
import vp.e1;
import vp.f0;
import vp.g0;
import vp.j1;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final dp.f f523g = dp.f.n("<built-ins module>");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ boolean f524h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public up.i<x> f526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final up.i<e> f527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final up.i<Collection<p0>> f528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final up.g<dp.f, eo.e> f529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final up.n f530f;

    public class a implements jn.a<Collection<p0>> {
        public a() {
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<p0> invoke() {
            return Arrays.asList(h.this.r().o0(k.f565m), h.this.r().o0(k.f567o), h.this.r().o0(k.f568p), h.this.r().o0(k.f566n));
        }
    }

    public class b implements jn.a<e> {
        public b() {
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e invoke() {
            EnumMap enumMap = new EnumMap(i.class);
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (i iVar : i.values()) {
                n0 n0VarQ = h.this.q(iVar.getTypeName().b());
                n0 n0VarQ2 = h.this.q(iVar.getArrayTypeName().b());
                enumMap.put(iVar, n0VarQ2);
                map.put(n0VarQ, n0VarQ2);
                map2.put(n0VarQ2, n0VarQ);
            }
            return new e(enumMap, map, map2);
        }
    }

    public class c implements jn.l<dp.f, eo.e> {
        public c() {
        }

        @Override // jn.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public eo.e invoke(dp.f fVar) {
            eo.h hVarF = h.this.s().f(fVar, mo.d.FROM_BUILTINS);
            if (hVarF == null) {
                throw new AssertionError("Built-in class " + k.f565m.c(fVar) + " is not found");
            }
            if (hVarF instanceof eo.e) {
                return (eo.e) hVarF;
            }
            throw new AssertionError("Must be a class descriptor " + fVar + ", but was " + hVarF);
        }
    }

    public class d implements jn.a<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f534a;

        public d(x xVar) {
            this.f534a = xVar;
        }

        @Override // jn.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke() {
            if (h.this.f525a == null) {
                h.this.f525a = this.f534a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + h.this.f525a + " (attempting to reset to " + this.f534a + ")");
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<i, n0> f536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<f0, n0> f537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<n0, n0> f538c;

        public /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        public static /* synthetic */ void a(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i10 != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public e(@os.l Map<i, n0> map, @os.l Map<f0, n0> map2, @os.l Map<n0, n0> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.f536a = map;
            this.f537b = map2;
            this.f538c = map3;
        }
    }

    public h(@os.l up.n nVar) {
        if (nVar == null) {
            a(0);
        }
        this.f530f = nVar;
        this.f528d = nVar.h(new a());
        this.f527c = nVar.h(new b());
        this.f529e = nVar.a(new c());
    }

    @os.m
    public static f0 A(@os.l f0 f0Var, @os.l h0 h0Var) {
        dp.b bVarH;
        dp.b bVarA;
        eo.e eVarA;
        if (f0Var == null) {
            a(71);
        }
        if (h0Var == null) {
            a(72);
        }
        eo.h hVarD = f0Var.G0().d();
        if (hVarD == null) {
            return null;
        }
        o oVar = o.f626a;
        if (!oVar.b(hVarD.getName()) || (bVarH = lp.a.h(hVarD)) == null || (bVarA = oVar.a(bVarH)) == null || (eVarA = eo.x.a(h0Var, bVarA)) == null) {
            return null;
        }
        return eVarA.q();
    }

    public static boolean A0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(142);
        }
        return k0(f0Var, k.a.f581f);
    }

    public static boolean B0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(132);
        }
        return v0(f0Var) || y0(f0Var) || w0(f0Var) || x0(f0Var);
    }

    @os.m
    public static i N(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(92);
        }
        eo.h hVarD = f0Var.G0().d();
        if (hVarD == null) {
            return null;
        }
        return P(hVarD);
    }

    @os.m
    public static i P(@os.l eo.m mVar) {
        if (mVar == null) {
            a(77);
        }
        if (k.a.C0.contains(mVar.getName())) {
            return k.a.E0.get(hp.d.m(mVar));
        }
        return null;
    }

    @os.m
    public static i S(@os.l eo.m mVar) {
        if (mVar == null) {
            a(76);
        }
        if (k.a.B0.contains(mVar.getName())) {
            return k.a.D0.get(hp.d.m(mVar));
        }
        return null;
    }

    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 71:
            case TabLayout.f3131k0 /* 72 */:
            case 73:
            case 75:
            case en.a.f4563i /* 76 */:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                i11 = 2;
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 71:
            case TabLayout.f3131k0 /* 72 */:
            case 73:
            case 75:
            case en.a.f4563i /* 76 */:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case TabLayout.f3131k0 /* 72 */:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case en.a.f4563i /* 76 */:
            case 77:
            case 89:
            case 96:
            case 103:
            case y5.a.Z /* 107 */:
            case 108:
            case 145:
            case 146:
            case 148:
            case 156:
            case 157:
            case 158:
            case 159:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 88:
            case 90:
            case ms.a.T /* 91 */:
            case ms.a.W /* 92 */:
            case ms.a.U /* 93 */:
            case 94:
            case da.b.f3634e /* 95 */:
            case 97:
            case 99:
            case 105:
            case 109:
            case 110:
            case y5.a.f20714d0 /* 111 */:
            case y5.a.f20718f0 /* 113 */:
            case y5.a.f20720g0 /* 114 */:
            case y5.a.f20722h0 /* 115 */:
            case y5.a.f20724i0 /* 116 */:
            case y5.a.f20726j0 /* 117 */:
            case y5.a.f20728k0 /* 118 */:
            case y5.a.f20730l0 /* 119 */:
            case 120:
            case 121:
            case y5.a.f20736o0 /* 122 */:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case OSMaskImageView.f2731x /* 130 */:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 147:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 161:
                objArr[0] = y0.a.f8215h;
                break;
            case 46:
                objArr[0] = "classSimpleName";
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                objArr[0] = "arrayType";
                break;
            case 71:
                objArr[0] = "notNullArrayType";
                break;
            case 73:
                objArr[0] = "primitiveType";
                break;
            case 75:
                objArr[0] = "kotlinType";
                break;
            case 78:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case 85:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case y5.a.f20716e0 /* 112 */:
                objArr[0] = "classDescriptor";
                break;
            case 160:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i10) {
            case 3:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 4:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 5:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 6:
                objArr[1] = "getStorageManager";
                break;
            case 7:
                objArr[1] = "getBuiltInsModule";
                break;
            case 8:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 71:
            case TabLayout.f3131k0 /* 72 */:
            case 73:
            case 75:
            case en.a.f4563i /* 76 */:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 11:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 13:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 15:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 18:
                objArr[1] = "getSuspendFunction";
                break;
            case 19:
                objArr[1] = "getKFunction";
                break;
            case 20:
                objArr[1] = "getKSuspendFunction";
                break;
            case 21:
                objArr[1] = "getKClass";
                break;
            case 22:
                objArr[1] = "getKCallable";
                break;
            case 23:
                objArr[1] = "getKProperty";
                break;
            case 24:
                objArr[1] = "getKProperty0";
                break;
            case 25:
                objArr[1] = "getKProperty1";
                break;
            case 26:
                objArr[1] = "getKProperty2";
                break;
            case 27:
                objArr[1] = "getKMutableProperty0";
                break;
            case 28:
                objArr[1] = "getKMutableProperty1";
                break;
            case 29:
                objArr[1] = "getKMutableProperty2";
                break;
            case 30:
                objArr[1] = "getIterator";
                break;
            case 31:
                objArr[1] = "getIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterable";
                break;
            case 33:
                objArr[1] = "getMutableIterator";
                break;
            case 34:
                objArr[1] = "getCollection";
                break;
            case 35:
                objArr[1] = "getMutableCollection";
                break;
            case 36:
                objArr[1] = "getList";
                break;
            case 37:
                objArr[1] = "getMutableList";
                break;
            case 38:
                objArr[1] = "getSet";
                break;
            case 39:
                objArr[1] = "getMutableSet";
                break;
            case 40:
                objArr[1] = "getMap";
                break;
            case 41:
                objArr[1] = "getMutableMap";
                break;
            case 42:
                objArr[1] = "getMapEntry";
                break;
            case 43:
                objArr[1] = "getMutableMapEntry";
                break;
            case 44:
                objArr[1] = "getListIterator";
                break;
            case 45:
                objArr[1] = "getMutableListIterator";
                break;
            case 47:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 48:
                objArr[1] = "getNothingType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                objArr[1] = "getNullableNothingType";
                break;
            case 50:
                objArr[1] = "getAnyType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                objArr[1] = "getNullableAnyType";
                break;
            case 52:
                objArr[1] = "getDefaultBound";
                break;
            case 54:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                objArr[1] = "getNumberType";
                break;
            case 56:
                objArr[1] = "getByteType";
                break;
            case 57:
                objArr[1] = "getShortType";
                break;
            case 58:
                objArr[1] = "getIntType";
                break;
            case 59:
                objArr[1] = "getLongType";
                break;
            case 60:
                objArr[1] = "getFloatType";
                break;
            case 61:
                objArr[1] = "getDoubleType";
                break;
            case 62:
                objArr[1] = "getCharType";
                break;
            case 63:
                objArr[1] = "getBooleanType";
                break;
            case 64:
                objArr[1] = "getUnitType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                objArr[1] = "getStringType";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                objArr[1] = "getIterableType";
                break;
            case 68:
            case 69:
            case 70:
                objArr[1] = "getArrayElementType";
                break;
            case 74:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 81:
            case 84:
                objArr[1] = "getArrayType";
                break;
            case 86:
                objArr[1] = "getEnumType";
                break;
            case 87:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 46:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                objArr[2] = "getArrayElementType";
                break;
            case 71:
            case TabLayout.f3131k0 /* 72 */:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 73:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 75:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case en.a.f4563i /* 76 */:
            case ms.a.U /* 93 */:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case 85:
                objArr[2] = "getEnumType";
                break;
            case 88:
                objArr[2] = "isArray";
                break;
            case 89:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case ms.a.T /* 91 */:
                objArr[2] = "isPrimitiveArray";
                break;
            case ms.a.W /* 92 */:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case da.b.f3634e /* 95 */:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 96:
                objArr[2] = "isPrimitiveClass";
                break;
            case 97:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case 104:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case y5.a.Z /* 107 */:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 108:
            case 109:
                objArr[2] = "isAny";
                break;
            case 110:
            case y5.a.f20716e0 /* 112 */:
                objArr[2] = "isBoolean";
                break;
            case y5.a.f20714d0 /* 111 */:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case y5.a.f20718f0 /* 113 */:
                objArr[2] = "isNumber";
                break;
            case y5.a.f20720g0 /* 114 */:
                objArr[2] = "isChar";
                break;
            case y5.a.f20722h0 /* 115 */:
                objArr[2] = "isCharOrNullableChar";
                break;
            case y5.a.f20724i0 /* 116 */:
                objArr[2] = "isInt";
                break;
            case y5.a.f20726j0 /* 117 */:
                objArr[2] = "isByte";
                break;
            case y5.a.f20728k0 /* 118 */:
                objArr[2] = "isLong";
                break;
            case y5.a.f20730l0 /* 119 */:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case y5.a.f20736o0 /* 122 */:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case 127:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case OSMaskImageView.f2731x /* 130 */:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case 142:
                objArr[2] = "isUnit";
                break;
            case 143:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 144:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 145:
                objArr[2] = "isMemberOfAny";
                break;
            case 146:
            case 147:
                objArr[2] = "isEnum";
                break;
            case 148:
            case 149:
                objArr[2] = "isComparable";
                break;
            case 150:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 151:
                objArr[2] = "isListOrNullableList";
                break;
            case 152:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 153:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 154:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 155:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 156:
                objArr[2] = "isThrowable";
                break;
            case 157:
                objArr[2] = "isKClass";
                break;
            case 158:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 159:
                objArr[2] = "isCloneable";
                break;
            case 160:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 47:
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 68:
            case 69:
            case 70:
            case 74:
            case 81:
            case 84:
            case 86:
            case 87:
                throw new IllegalStateException(str2);
            case 9:
            case 10:
            case 12:
            case 14:
            case 16:
            case 17:
            case 46:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 71:
            case TabLayout.f3131k0 /* 72 */:
            case 73:
            case 75:
            case en.a.f4563i /* 76 */:
            case 77:
            case 78:
            case 79:
            case 80:
            case 82:
            case 83:
            case 85:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean a0(@os.l eo.e eVar) {
        if (eVar == null) {
            a(108);
        }
        return e(eVar, k.a.f573b);
    }

    public static boolean b0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(139);
        }
        return f0(f0Var, k.a.f573b);
    }

    public static boolean c0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(88);
        }
        return f0(f0Var, k.a.f587i);
    }

    public static boolean d0(@os.l eo.e eVar) {
        if (eVar == null) {
            a(89);
        }
        return e(eVar, k.a.f587i) || P(eVar) != null;
    }

    public static boolean e(@os.l eo.h hVar, @os.l dp.d dVar) {
        if (hVar == null) {
            a(103);
        }
        if (dVar == null) {
            a(104);
        }
        return hVar.getName().equals(dVar.i()) && dVar.equals(hp.d.m(hVar));
    }

    public static boolean e0(@os.l eo.m mVar) {
        if (mVar == null) {
            a(9);
        }
        return hp.d.r(mVar, ao.b.class, false) != null;
    }

    public static boolean f0(@os.l f0 f0Var, @os.l dp.d dVar) {
        if (f0Var == null) {
            a(97);
        }
        if (dVar == null) {
            a(98);
        }
        return u0(f0Var.G0(), dVar);
    }

    public static boolean g0(@os.l f0 f0Var, @os.l dp.d dVar) {
        if (f0Var == null) {
            a(134);
        }
        if (dVar == null) {
            a(135);
        }
        return f0(f0Var, dVar) && !f0Var.H0();
    }

    public static boolean h0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(141);
        }
        return n0(f0Var);
    }

    public static boolean i0(@os.l eo.m mVar) {
        if (mVar == null) {
            a(160);
        }
        if (mVar.a().getAnnotations().p(k.a.f619y)) {
            return true;
        }
        if (!(mVar instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) mVar;
        boolean zQ = t0Var.Q();
        u0 getter = t0Var.getGetter();
        v0 setter = t0Var.getSetter();
        if (getter != null && i0(getter)) {
            if (!zQ) {
                return true;
            }
            if (setter != null && i0(setter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j0(@os.l eo.e eVar) {
        if (eVar == null) {
            a(157);
        }
        return e(eVar, k.a.f578d0);
    }

    public static boolean k0(@os.l f0 f0Var, @os.l dp.d dVar) {
        if (f0Var == null) {
            a(105);
        }
        if (dVar == null) {
            a(106);
        }
        return !f0Var.H0() && f0(f0Var, dVar);
    }

    public static boolean l0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(136);
        }
        return m0(f0Var) && !j1.m(f0Var);
    }

    public static boolean m0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(138);
        }
        return f0(f0Var, k.a.f575c);
    }

    public static boolean n0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(140);
        }
        return b0(f0Var) && f0Var.H0();
    }

    public static boolean o0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(91);
        }
        eo.h hVarD = f0Var.G0().d();
        return (hVarD == null || P(hVarD) == null) ? false : true;
    }

    public static boolean p0(@os.l eo.e eVar) {
        if (eVar == null) {
            a(96);
        }
        return S(eVar) != null;
    }

    public static boolean q0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(94);
        }
        return !f0Var.H0() && r0(f0Var);
    }

    public static boolean r0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(95);
        }
        eo.h hVarD = f0Var.G0().d();
        return (hVarD instanceof eo.e) && p0((eo.e) hVarD);
    }

    public static boolean s0(@os.l eo.e eVar) {
        if (eVar == null) {
            a(y5.a.Z);
        }
        return e(eVar, k.a.f573b) || e(eVar, k.a.f575c);
    }

    public static boolean t0(@os.m f0 f0Var) {
        return f0Var != null && k0(f0Var, k.a.f585h);
    }

    public static boolean u0(@os.l a1 a1Var, @os.l dp.d dVar) {
        if (a1Var == null) {
            a(101);
        }
        if (dVar == null) {
            a(102);
        }
        eo.h hVarD = a1Var.d();
        return (hVarD instanceof eo.e) && e(hVarD, dVar);
    }

    public static boolean v0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(128);
        }
        return g0(f0Var, k.a.f618x0.j());
    }

    public static boolean w0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(OSMaskImageView.f2731x);
        }
        return g0(f0Var, k.a.f622z0.j());
    }

    public static boolean x0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(131);
        }
        return g0(f0Var, k.a.A0.j());
    }

    public static boolean y0(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(129);
        }
        return g0(f0Var, k.a.f620y0.j());
    }

    public static boolean z0(@os.l eo.m mVar) {
        if (mVar == null) {
            a(10);
        }
        while (mVar != null) {
            if (mVar instanceof k0) {
                return ((k0) mVar).e().i(k.f564l);
            }
            mVar = mVar.b();
        }
        return false;
    }

    @os.l
    public n0 B() {
        n0 n0VarR = R(i.FLOAT);
        if (n0VarR == null) {
            a(60);
        }
        return n0VarR;
    }

    @os.l
    public eo.e C(int i10) {
        return p(k.b(i10));
    }

    public void C0(@os.l x xVar) {
        if (xVar == null) {
            a(1);
        }
        this.f530f.c(new d(xVar));
    }

    @os.l
    public n0 D() {
        n0 n0VarR = R(i.INT);
        if (n0VarR == null) {
            a(58);
        }
        return n0VarR;
    }

    @os.l
    public eo.e E() {
        eo.e eVarO = o(k.a.f578d0.l());
        if (eVarO == null) {
            a(21);
        }
        return eVarO;
    }

    @os.l
    public n0 F() {
        n0 n0VarR = R(i.LONG);
        if (n0VarR == null) {
            a(59);
        }
        return n0VarR;
    }

    @os.l
    public eo.e G() {
        return p("Nothing");
    }

    @os.l
    public n0 H() {
        n0 n0VarQ = G().q();
        if (n0VarQ == null) {
            a(48);
        }
        return n0VarQ;
    }

    @os.l
    public n0 I() {
        n0 n0VarN0 = i().N0(true);
        if (n0VarN0 == null) {
            a(51);
        }
        return n0VarN0;
    }

    @os.l
    public n0 J() {
        n0 n0VarN0 = H().N0(true);
        if (n0VarN0 == null) {
            a(49);
        }
        return n0VarN0;
    }

    @os.l
    public eo.e K() {
        return p("Number");
    }

    @os.l
    public n0 L() {
        n0 n0VarQ = K().q();
        if (n0VarQ == null) {
            a(55);
        }
        return n0VarQ;
    }

    @os.l
    public go.c M() {
        go.c.b bVar = go.c.b.f6754a;
        if (bVar == null) {
            a(4);
        }
        return bVar;
    }

    @os.l
    public n0 O(@os.l i iVar) {
        if (iVar == null) {
            a(73);
        }
        n0 n0Var = this.f527c.invoke().f536a.get(iVar);
        if (n0Var == null) {
            a(74);
        }
        return n0Var;
    }

    @os.l
    public final eo.e Q(@os.l i iVar) {
        if (iVar == null) {
            a(16);
        }
        return p(iVar.getTypeName().b());
    }

    @os.l
    public n0 R(@os.l i iVar) {
        if (iVar == null) {
            a(53);
        }
        n0 n0VarQ = Q(iVar).q();
        if (n0VarQ == null) {
            a(54);
        }
        return n0VarQ;
    }

    @os.l
    public n0 T() {
        n0 n0VarR = R(i.SHORT);
        if (n0VarR == null) {
            a(57);
        }
        return n0VarR;
    }

    @os.l
    public up.n U() {
        up.n nVar = this.f530f;
        if (nVar == null) {
            a(6);
        }
        return nVar;
    }

    @os.l
    public eo.e V() {
        return p("String");
    }

    @os.l
    public n0 W() {
        n0 n0VarQ = V().q();
        if (n0VarQ == null) {
            a(65);
        }
        return n0VarQ;
    }

    @os.l
    public eo.e X(int i10) {
        eo.e eVarO = o(k.f557e.c(dp.f.k(k.d(i10))));
        if (eVarO == null) {
            a(18);
        }
        return eVarO;
    }

    @os.l
    public eo.e Y() {
        return p("Unit");
    }

    @os.l
    public n0 Z() {
        n0 n0VarQ = Y().q();
        if (n0VarQ == null) {
            a(64);
        }
        return n0VarQ;
    }

    public void f(boolean z10) {
        x xVar = new x(f523g, this.f530f, this, null);
        this.f525a = xVar;
        xVar.M0(ao.a.f516a.a().a(this.f530f, this.f525a, v(), M(), g(), z10));
        x xVar2 = this.f525a;
        xVar2.S0(xVar2);
    }

    @os.l
    public go.a g() {
        go.a.C0182a c0182a = go.a.C0182a.f6752a;
        if (c0182a == null) {
            a(3);
        }
        return c0182a;
    }

    @os.l
    public eo.e h() {
        return p("Any");
    }

    @os.l
    public n0 i() {
        n0 n0VarQ = h().q();
        if (n0VarQ == null) {
            a(50);
        }
        return n0VarQ;
    }

    @os.l
    public eo.e j() {
        return p("Array");
    }

    @os.l
    public f0 k(@os.l f0 f0Var) {
        f0 f0VarA;
        if (f0Var == null) {
            a(67);
        }
        if (c0(f0Var)) {
            if (f0Var.F0().size() != 1) {
                throw new IllegalStateException();
            }
            f0 type = f0Var.F0().get(0).getType();
            if (type == null) {
                a(68);
            }
            return type;
        }
        f0 f0VarO = j1.o(f0Var);
        n0 n0Var = this.f527c.invoke().f538c.get(f0VarO);
        if (n0Var != null) {
            return n0Var;
        }
        h0 h0VarI = hp.d.i(f0VarO);
        if (h0VarI != null && (f0VarA = A(f0VarO, h0VarI)) != null) {
            return f0VarA;
        }
        throw new IllegalStateException("not array: " + f0Var);
    }

    @os.l
    public n0 l(@os.l o1 o1Var, @os.l f0 f0Var) {
        if (o1Var == null) {
            a(82);
        }
        if (f0Var == null) {
            a(83);
        }
        fo.g.f6167h.getClass();
        n0 n0VarM = m(o1Var, f0Var, fo.g.a.f6169b);
        if (n0VarM == null) {
            a(84);
        }
        return n0VarM;
    }

    @os.l
    public n0 m(@os.l o1 o1Var, @os.l f0 f0Var, @os.l fo.g gVar) {
        if (o1Var == null) {
            a(78);
        }
        if (f0Var == null) {
            a(79);
        }
        if (gVar == null) {
            a(80);
        }
        n0 n0VarG = g0.g(gVar, j(), Collections.singletonList(new e1(o1Var, f0Var)));
        if (n0VarG == null) {
            a(81);
        }
        return n0VarG;
    }

    @os.l
    public n0 n() {
        n0 n0VarR = R(i.BOOLEAN);
        if (n0VarR == null) {
            a(63);
        }
        return n0VarR;
    }

    @os.l
    public eo.e o(@os.l dp.c cVar) {
        if (cVar == null) {
            a(12);
        }
        eo.e eVarC = s.c(r(), cVar, mo.d.FROM_BUILTINS);
        if (eVarC == null) {
            a(13);
        }
        return eVarC;
    }

    @os.l
    public final eo.e p(@os.l String str) {
        if (str == null) {
            a(14);
        }
        eo.e eVarInvoke = this.f529e.invoke(dp.f.k(str));
        if (eVarInvoke == null) {
            a(15);
        }
        return eVarInvoke;
    }

    @os.l
    public final n0 q(@os.l String str) {
        if (str == null) {
            a(46);
        }
        n0 n0VarQ = p(str).q();
        if (n0VarQ == null) {
            a(47);
        }
        return n0VarQ;
    }

    @os.l
    public x r() {
        if (this.f525a == null) {
            this.f525a = this.f526b.invoke();
        }
        x xVar = this.f525a;
        if (xVar == null) {
            a(7);
        }
        return xVar;
    }

    @os.l
    public op.h s() {
        op.h hVarO = r().o0(k.f565m).o();
        if (hVarO == null) {
            a(11);
        }
        return hVarO;
    }

    @os.l
    public n0 t() {
        n0 n0VarR = R(i.BYTE);
        if (n0VarR == null) {
            a(56);
        }
        return n0VarR;
    }

    @os.l
    public n0 u() {
        n0 n0VarR = R(i.CHAR);
        if (n0VarR == null) {
            a(62);
        }
        return n0VarR;
    }

    @os.l
    public Iterable<go.b> v() {
        List listSingletonList = Collections.singletonList(new bo.a(this.f530f, r()));
        if (listSingletonList == null) {
            a(5);
        }
        return listSingletonList;
    }

    @os.l
    public eo.e w() {
        eo.e eVarO = o(k.a.P);
        if (eVarO == null) {
            a(34);
        }
        return eVarO;
    }

    @os.l
    public eo.e x() {
        return p("Comparable");
    }

    @os.l
    public n0 y() {
        n0 n0VarI = I();
        if (n0VarI == null) {
            a(52);
        }
        return n0VarI;
    }

    @os.l
    public n0 z() {
        n0 n0VarR = R(i.DOUBLE);
        if (n0VarR == null) {
            a(61);
        }
        return n0VarR;
    }
}
