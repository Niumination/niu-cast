package hp;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import eo.e0;
import eo.j1;
import eo.k0;
import eo.p0;
import eo.q;
import eo.t;
import eo.u;
import eo.v0;
import eo.w0;
import ik.y0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import vp.a1;
import vp.f0;
import vp.h0;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dp.c f7480a = new dp.c("kotlin.jvm.JvmName");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f7481b = false;

    public static boolean A(@os.m eo.m mVar) {
        return D(mVar, eo.f.ENUM_CLASS);
    }

    public static boolean B(@os.l eo.m mVar) {
        if (mVar == null) {
            a(36);
        }
        return D(mVar, eo.f.ENUM_ENTRY);
    }

    public static boolean C(@os.m eo.m mVar) {
        return D(mVar, eo.f.INTERFACE);
    }

    public static boolean D(@os.m eo.m mVar, @os.l eo.f fVar) {
        if (fVar == null) {
            a(37);
        }
        return (mVar instanceof eo.e) && ((eo.e) mVar).getKind() == fVar;
    }

    public static boolean E(@os.l eo.m mVar) {
        if (mVar == null) {
            a(1);
        }
        while (mVar != null) {
            if (u(mVar) || y(mVar)) {
                return true;
            }
            mVar = mVar.b();
        }
        return false;
    }

    public static boolean F(@os.l f0 f0Var, @os.l eo.m mVar) {
        if (f0Var == null) {
            a(30);
        }
        if (mVar == null) {
            a(31);
        }
        eo.h hVarD = f0Var.G0().d();
        if (hVarD == null) {
            return false;
        }
        eo.m mVarA = hVarD.a();
        return (mVarA instanceof eo.h) && (mVar instanceof eo.h) && ((eo.h) mVar).i().equals(((eo.h) mVarA).i());
    }

    public static boolean G(@os.m eo.m mVar) {
        return (D(mVar, eo.f.CLASS) || D(mVar, eo.f.INTERFACE)) && ((eo.e) mVar).s() == e0.SEALED;
    }

    public static boolean H(@os.l eo.e eVar, @os.l eo.e eVar2) {
        if (eVar == null) {
            a(28);
        }
        if (eVar2 == null) {
            a(29);
        }
        return I(eVar.q(), eVar2.a());
    }

    public static boolean I(@os.l f0 f0Var, @os.l eo.m mVar) {
        if (f0Var == null) {
            a(32);
        }
        if (mVar == null) {
            a(33);
        }
        if (F(f0Var, mVar)) {
            return true;
        }
        Iterator<f0> it = f0Var.G0().a().iterator();
        while (it.hasNext()) {
            if (I(it.next(), mVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(@os.m eo.m mVar) {
        return mVar != null && (mVar.b() instanceof k0);
    }

    public static boolean K(@os.l j1 j1Var, @os.l f0 f0Var) {
        if (j1Var == null) {
            a(63);
        }
        if (f0Var == null) {
            a(64);
        }
        if (j1Var.Q() || h0.a(f0Var)) {
            return false;
        }
        if (vp.j1.b(f0Var)) {
            return true;
        }
        ao.h hVarG = lp.a.g(j1Var);
        if (!ao.h.q0(f0Var)) {
            wp.e eVar = wp.e.f19851a;
            if (!eVar.b(hVarG.W(), f0Var) && !eVar.b(hVarG.K().q(), f0Var) && !eVar.b(hVarG.i(), f0Var)) {
                ao.o oVar = ao.o.f626a;
                if (!ao.o.d(f0Var)) {
                    return false;
                }
            }
        }
        return true;
    }

    @os.l
    public static <D extends eo.b> D L(@os.l D d10) {
        if (d10 == null) {
            a(59);
        }
        while (d10.getKind() == eo.b.a.FAKE_OVERRIDE) {
            Collection<? extends eo.b> collectionD = d10.d();
            if (collectionD.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d10);
            }
            d10 = (D) collectionD.iterator().next();
        }
        return d10;
    }

    @os.l
    public static <D extends q> D M(@os.l D d10) {
        if (d10 == null) {
            a(61);
        }
        if (d10 instanceof eo.b) {
            return L((eo.b) d10);
        }
        if (d10 == null) {
            a(62);
        }
        return d10;
    }

    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case ms.a.T /* 91 */:
            case ms.a.U /* 93 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case ms.a.T /* 91 */:
            case ms.a.U /* 93 */:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 79:
            case ms.a.W /* 92 */:
            case 94:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case ms.a.T /* 91 */:
            case ms.a.U /* 93 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = y1.o.r.f20674f;
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 64:
                objArr[0] = y0.a.f8215h;
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 74:
            case 75:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 63:
                objArr[0] = "variable";
                break;
            case 68:
                objArr[0] = "f";
                break;
            case 70:
                objArr[0] = "current";
                break;
            case 71:
                objArr[0] = "result";
                break;
            case TabLayout.f3131k0 /* 72 */:
                objArr[0] = "memberDescriptor";
                break;
            case en.a.f4563i /* 76 */:
            case 77:
            case 78:
                objArr[0] = "annotated";
                break;
            case 82:
            case 84:
            case 87:
            case 89:
                objArr[0] = "scope";
                break;
            case 85:
            case 88:
            case 90:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 69:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 73:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 80:
            case 81:
                objArr[1] = "getContainingSourceFile";
                break;
            case 83:
                objArr[1] = "getAllDescriptors";
                break;
            case 86:
                objArr[1] = "getFunctionByName";
                break;
            case ms.a.T /* 91 */:
                objArr[1] = "getPropertyByName";
                break;
            case ms.a.U /* 93 */:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case ms.a.T /* 91 */:
            case ms.a.U /* 93 */:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 63:
            case 64:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 68:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 70:
            case 71:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case TabLayout.f3131k0 /* 72 */:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 74:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 75:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case en.a.f4563i /* 76 */:
                objArr[2] = "getJvmName";
                break;
            case 77:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 78:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 79:
                objArr[2] = "getContainingSourceFile";
                break;
            case 82:
                objArr[2] = "getAllDescriptors";
                break;
            case 84:
            case 85:
                objArr[2] = "getFunctionByName";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 89:
            case 90:
                objArr[2] = "getPropertyByName";
                break;
            case ms.a.W /* 92 */:
                objArr[2] = "getDirectMember";
                break;
            case 94:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case ms.a.T /* 91 */:
            case ms.a.U /* 93 */:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(@os.l eo.m mVar, @os.l eo.m mVar2) {
        if (mVar == null) {
            a(16);
        }
        if (mVar2 == null) {
            a(17);
        }
        return g(mVar).equals(g(mVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <D extends eo.a> void c(@os.l D d10, @os.l Set<D> set) {
        if (d10 == null) {
            a(70);
        }
        if (set == 0) {
            a(71);
        }
        if (set.contains(d10)) {
            return;
        }
        Iterator<? extends eo.a> it = d10.a().d().iterator();
        while (it.hasNext()) {
            eo.a aVarA = it.next().a();
            c(aVarA, set);
            set.add(aVarA);
        }
    }

    @os.l
    public static <D extends eo.a> Set<D> d(@os.l D d10) {
        if (d10 == null) {
            a(68);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d10.a(), linkedHashSet);
        return linkedHashSet;
    }

    @os.l
    public static eo.e e(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(45);
        }
        return f(f0Var.G0());
    }

    @os.l
    public static eo.e f(@os.l a1 a1Var) {
        if (a1Var == null) {
            a(46);
        }
        eo.e eVar = (eo.e) a1Var.d();
        if (eVar == null) {
            a(47);
        }
        return eVar;
    }

    @os.l
    public static eo.h0 g(@os.l eo.m mVar) {
        if (mVar == null) {
            a(21);
        }
        eo.h0 h0VarH = h(mVar);
        if (h0VarH == null) {
            a(22);
        }
        return h0VarH;
    }

    @os.m
    public static eo.h0 h(@os.l eo.m mVar) {
        if (mVar == null) {
            a(23);
        }
        while (mVar != null) {
            if (mVar instanceof eo.h0) {
                return (eo.h0) mVar;
            }
            if (mVar instanceof p0) {
                return ((p0) mVar).x0();
            }
            mVar = mVar.b();
        }
        return null;
    }

    @os.m
    public static eo.h0 i(@os.l f0 f0Var) {
        if (f0Var == null) {
            a(20);
        }
        eo.h hVarD = f0Var.G0().d();
        if (hVarD == null) {
            return null;
        }
        return h(hVarD);
    }

    @os.l
    public static eo.a1 j(@os.l eo.m mVar) {
        if (mVar == null) {
            a(79);
        }
        if (mVar instanceof v0) {
            mVar = ((v0) mVar).W();
        }
        if (mVar instanceof eo.p) {
            eo.a1 a1VarB = ((eo.p) mVar).getSource().b();
            if (a1VarB == null) {
                a(80);
            }
            return a1VarB;
        }
        eo.a1 a1Var = eo.a1.f4590a;
        if (a1Var == null) {
            a(81);
        }
        return a1Var;
    }

    @os.l
    public static u k(@os.l eo.e eVar, boolean z10) {
        if (eVar == null) {
            a(48);
        }
        eo.f kind = eVar.getKind();
        if (kind == eo.f.ENUM_CLASS || kind.isSingleton()) {
            u uVar = t.f4629a;
            if (uVar == null) {
                a(49);
            }
            return uVar;
        }
        if (G(eVar)) {
            if (z10) {
                u uVar2 = t.f4631c;
                if (uVar2 == null) {
                    a(50);
                }
                return uVar2;
            }
            u uVar3 = t.f4629a;
            if (uVar3 == null) {
                a(51);
            }
            return uVar3;
        }
        if (u(eVar)) {
            u uVar4 = t.f4640l;
            if (uVar4 == null) {
                a(52);
            }
            return uVar4;
        }
        u uVar5 = t.f4633e;
        if (uVar5 == null) {
            a(53);
        }
        return uVar5;
    }

    @os.m
    public static w0 l(@os.l eo.m mVar) {
        if (mVar == null) {
            a(0);
        }
        if (mVar instanceof eo.e) {
            return ((eo.e) mVar).D0();
        }
        return null;
    }

    @os.l
    public static dp.d m(@os.l eo.m mVar) {
        if (mVar == null) {
            a(2);
        }
        dp.c cVarO = o(mVar);
        return cVarO != null ? cVarO.j() : p(mVar);
    }

    @os.l
    public static dp.c n(@os.l eo.m mVar) {
        if (mVar == null) {
            a(3);
        }
        dp.c cVarO = o(mVar);
        if (cVarO == null) {
            cVarO = p(mVar).l();
        }
        if (cVarO == null) {
            a(4);
        }
        return cVarO;
    }

    @os.m
    public static dp.c o(@os.l eo.m mVar) {
        if (mVar == null) {
            a(5);
        }
        if ((mVar instanceof eo.h0) || x.r(mVar)) {
            return dp.c.f3809c;
        }
        if (mVar instanceof p0) {
            return ((p0) mVar).e();
        }
        if (mVar instanceof k0) {
            return ((k0) mVar).e();
        }
        return null;
    }

    @os.l
    public static dp.d p(@os.l eo.m mVar) {
        if (mVar == null) {
            a(6);
        }
        dp.d dVarC = m(mVar.b()).c(mVar.getName());
        if (dVarC == null) {
            a(7);
        }
        return dVarC;
    }

    @os.m
    public static <D extends eo.m> D q(@os.m eo.m mVar, @os.l Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(mVar, cls, true);
    }

    @os.m
    public static <D extends eo.m> D r(@os.m eo.m mVar, @os.l Class<D> cls, boolean z10) {
        if (cls == null) {
            a(19);
        }
        if (mVar == null) {
            return null;
        }
        if (z10) {
            mVar = (D) mVar.b();
        }
        while (mVar != null) {
            if (cls.isInstance(mVar)) {
                return (D) mVar;
            }
            mVar = (D) mVar.b();
        }
        return null;
    }

    @os.m
    public static eo.e s(@os.l eo.e eVar) {
        if (eVar == null) {
            a(44);
        }
        Iterator<f0> it = eVar.i().a().iterator();
        while (it.hasNext()) {
            eo.e eVarE = e(it.next());
            if (eVarE.getKind() != eo.f.INTERFACE) {
                return eVarE;
            }
        }
        return null;
    }

    public static boolean t(@os.m eo.m mVar) {
        return D(mVar, eo.f.ANNOTATION_CLASS);
    }

    public static boolean u(@os.l eo.m mVar) {
        if (mVar == null) {
            a(34);
        }
        return D(mVar, eo.f.CLASS) && mVar.getName().equals(dp.h.f3825b);
    }

    public static boolean v(@os.m eo.m mVar) {
        return D(mVar, eo.f.CLASS);
    }

    public static boolean w(@os.m eo.m mVar) {
        return D(mVar, eo.f.CLASS) || D(mVar, eo.f.ENUM_CLASS);
    }

    public static boolean x(@os.m eo.m mVar) {
        return D(mVar, eo.f.OBJECT) && ((eo.e) mVar).a0();
    }

    public static boolean y(eo.m mVar) {
        return (mVar instanceof q) && ((q) mVar).getVisibility() == t.f4634f;
    }

    public static boolean z(@os.l eo.e eVar, @os.l eo.e eVar2) {
        if (eVar == null) {
            a(26);
        }
        if (eVar2 == null) {
            a(27);
        }
        Iterator<f0> it = eVar.i().a().iterator();
        while (it.hasNext()) {
            if (F(it.next(), eVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
