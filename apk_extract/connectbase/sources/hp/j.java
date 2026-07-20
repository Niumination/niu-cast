package hp;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import eo.d0;
import eo.e0;
import eo.e1;
import eo.h1;
import eo.q;
import eo.s0;
import eo.t;
import eo.u;
import eo.w0;
import eo.y;
import ho.b0;
import ho.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import lm.l2;
import lm.t0;
import nm.h0;
import vp.a1;
import vp.f0;
import vp.z0;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<hp.e> f7489c = h0.V5(ServiceLoader.load(hp.e.class, hp.e.class.getClassLoader()));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f7490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final wp.e.a f7491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f7492f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wp.g f7493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wp.e.a f7494b;

    public static class a implements wp.e.a {
        public static /* synthetic */ void b(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // wp.e.a
        public boolean a(@os.l a1 a1Var, @os.l a1 a1Var2) {
            if (a1Var == null) {
                b(0);
            }
            if (a1Var2 == null) {
                b(1);
            }
            return a1Var.equals(a1Var2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    public static class b<D> implements jn.p<D, D, t0<eo.a, eo.a>> {
        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Llm/t0<Leo/a;Leo/a;>; */
        public t0 a(eo.a aVar, eo.a aVar2) {
            return new t0(aVar, aVar2);
        }

        @Override // jn.p
        public t0<eo.a, eo.a> invoke(Object obj, Object obj2) {
            return new t0<>((eo.a) obj, (eo.a) obj2);
        }
    }

    public static class c implements jn.l<eo.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ eo.m f7495a;

        public c(eo.m mVar) {
            this.f7495a = mVar;
        }

        @Override // jn.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(eo.b bVar) {
            return Boolean.valueOf(bVar.b() == this.f7495a);
        }
    }

    public static class d implements jn.l<eo.b, eo.a> {
        public eo.b a(eo.b bVar) {
            return bVar;
        }

        @Override // jn.l
        public eo.a invoke(eo.b bVar) {
            return bVar;
        }
    }

    public static class e implements jn.l<eo.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ eo.e f7496a;

        public e(eo.e eVar) {
            this.f7496a = eVar;
        }

        @Override // jn.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(eo.b bVar) {
            return Boolean.valueOf(!t.g(bVar.getVisibility()) && t.h(bVar, this.f7496a));
        }
    }

    public static class f implements jn.l<eo.b, eo.a> {
        public eo.a a(eo.b bVar) {
            return bVar;
        }

        @Override // jn.l
        public eo.a invoke(eo.b bVar) {
            return bVar;
        }
    }

    public static class g implements jn.l<eo.b, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hp.i f7497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ eo.b f7498b;

        public g(hp.i iVar, eo.b bVar) {
            this.f7497a = iVar;
            this.f7498b = bVar;
        }

        @Override // jn.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l2 invoke(eo.b bVar) {
            this.f7497a.b(this.f7498b, bVar);
            return l2.f10208a;
        }
    }

    public static /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f7500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f7501c;

        static {
            int[] iArr = new int[e0.values().length];
            f7501c = iArr;
            try {
                iArr[e0.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7501c[e0.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7501c[e0.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7501c[e0.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[i.a.values().length];
            f7500b = iArr2;
            try {
                iArr2[i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7500b[i.a.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7500b[i.a.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[hp.e.b.values().length];
            f7499a = iArr3;
            try {
                iArr3[hp.e.b.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7499a[hp.e.b.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7499a[hp.e.b.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7499a[hp.e.b.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f7502c = new i(a.OVERRIDABLE, "SUCCESS");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f7503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7504b;

        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public i(@os.l a aVar, @os.l String str) {
            if (aVar == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f7503a = aVar;
            this.f7504b = str;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0031  */
        public static /* synthetic */ void a(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? 3 : 2];
            if (i10 == 1 || i10 == 2) {
                objArr[0] = "debugMessage";
            } else if (i10 == 3) {
                objArr[0] = "success";
            } else if (i10 != 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            } else {
                objArr[0] = "debugMessage";
            }
            switch (i10) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = "success";
                    break;
            }
            if (i10 == 1) {
                objArr[2] = "incompatible";
            } else if (i10 == 2) {
                objArr[2] = "conflict";
            } else if (i10 == 3 || i10 == 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
                throw new IllegalStateException(str2);
            }
            throw new IllegalArgumentException(str2);
        }

        @os.l
        public static i b(@os.l String str) {
            if (str == null) {
                a(2);
            }
            return new i(a.CONFLICT, str);
        }

        @os.l
        public static i d(@os.l String str) {
            if (str == null) {
                a(1);
            }
            return new i(a.INCOMPATIBLE, str);
        }

        @os.l
        public static i e() {
            i iVar = f7502c;
            if (iVar == null) {
                a(0);
            }
            return iVar;
        }

        @os.l
        public a c() {
            a aVar = this.f7503a;
            if (aVar == null) {
                a(5);
            }
            return aVar;
        }
    }

    static {
        a aVar = new a();
        f7491e = aVar;
        f7490d = new j(aVar, wp.g.a.f19853a);
    }

    public j(@os.l wp.e.a aVar, @os.l wp.g gVar) {
        if (aVar == null) {
            a(4);
        }
        if (gVar == null) {
            a(5);
        }
        this.f7494b = aVar;
        this.f7493a = gVar;
    }

    @os.l
    public static Set<eo.b> A(@os.l eo.b bVar) {
        if (bVar == null) {
            a(13);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(bVar, linkedHashSet);
        return linkedHashSet;
    }

    public static boolean B(@os.m s0 s0Var, @os.m s0 s0Var2) {
        if (s0Var == null || s0Var2 == null) {
            return true;
        }
        return I(s0Var, s0Var2);
    }

    public static boolean C(@os.l eo.a aVar, @os.l eo.a aVar2) {
        if (aVar == null) {
            a(67);
        }
        if (aVar2 == null) {
            a(68);
        }
        f0 returnType = aVar.getReturnType();
        f0 returnType2 = aVar2.getReturnType();
        if (!I(aVar, aVar2)) {
            return false;
        }
        t0<wp.m, z0> t0VarL = f7490d.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
        if (aVar instanceof y) {
            return H(aVar, returnType, aVar2, returnType2, t0VarL);
        }
        if (!(aVar instanceof eo.t0)) {
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        eo.t0 t0Var = (eo.t0) aVar;
        eo.t0 t0Var2 = (eo.t0) aVar2;
        if (!B(t0Var.getSetter(), t0Var2.getSetter())) {
            return false;
        }
        if (t0Var.Q() && t0Var2.Q()) {
            return t0VarL.getFirst().e(t0VarL.getSecond(), returnType.J0(), returnType2.J0());
        }
        return (t0Var.Q() || !t0Var2.Q()) && H(aVar, returnType, aVar2, returnType2, t0VarL);
    }

    public static boolean D(@os.l eo.a aVar, @os.l Collection<eo.a> collection) {
        if (aVar == null) {
            a(71);
        }
        if (collection == null) {
            a(72);
        }
        Iterator<eo.a> it = collection.iterator();
        while (it.hasNext()) {
            if (!C(aVar, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean H(@os.l eo.a aVar, @os.l f0 f0Var, @os.l eo.a aVar2, @os.l f0 f0Var2, @os.l t0<wp.m, z0> t0Var) {
        if (aVar == null) {
            a(73);
        }
        if (f0Var == null) {
            a(74);
        }
        if (aVar2 == null) {
            a(75);
        }
        if (f0Var2 == null) {
            a(76);
        }
        if (t0Var == null) {
            a(77);
        }
        return t0Var.getFirst().g(t0Var.getSecond(), f0Var.J0(), f0Var2.J0());
    }

    public static boolean I(@os.l q qVar, @os.l q qVar2) {
        if (qVar == null) {
            a(69);
        }
        if (qVar2 == null) {
            a(70);
        }
        Integer numD = t.d(qVar.getVisibility(), qVar2.getVisibility());
        return numD == null || numD.intValue() >= 0;
    }

    public static boolean J(@os.l d0 d0Var, @os.l d0 d0Var2) {
        if (d0Var == null) {
            a(57);
        }
        if (d0Var2 == null) {
            a(58);
        }
        return !t.g(d0Var2.getVisibility()) && t.h(d0Var2, d0Var);
    }

    public static <D extends eo.a> boolean K(@os.l D d10, @os.l D d11, boolean z10, boolean z11) {
        if (d10 == null) {
            a(11);
        }
        if (d11 == null) {
            a(12);
        }
        if (!d10.equals(d11) && hp.b.f7476a.d(d10.a(), d11.a(), z10, z11)) {
            return true;
        }
        eo.a aVarA = d11.a();
        Iterator it = hp.d.d(d10).iterator();
        while (it.hasNext()) {
            if (hp.b.f7476a.d(aVarA, (eo.a) it.next(), z10, z11)) {
                return true;
            }
        }
        return false;
    }

    public static void L(@os.l eo.b bVar, @os.m jn.l<eo.b, l2> lVar) {
        u uVar;
        if (bVar == null) {
            a(y5.a.Z);
        }
        for (eo.b bVar2 : bVar.d()) {
            if (bVar2.getVisibility() == t.f4635g) {
                L(bVar2, lVar);
            }
        }
        if (bVar.getVisibility() != t.f4635g) {
            return;
        }
        u uVarH = h(bVar);
        if (uVarH == null) {
            if (lVar != null) {
                lVar.invoke(bVar);
            }
            uVar = t.f4633e;
        } else {
            uVar = uVarH;
        }
        if (bVar instanceof c0) {
            ((c0) bVar).W0(uVar);
            Iterator<s0> it = ((eo.t0) bVar).z().iterator();
            while (it.hasNext()) {
                L(it.next(), uVarH == null ? null : lVar);
            }
            return;
        }
        if (bVar instanceof ho.p) {
            ((ho.p) bVar).d1(uVar);
            return;
        }
        b0 b0Var = (b0) bVar;
        b0Var.I0(uVar);
        if (uVar != b0Var.W().getVisibility()) {
            b0Var.G0(false);
        }
    }

    @os.l
    public static <H> H M(@os.l Collection<H> collection, @os.l jn.l<H, eo.a> lVar) {
        H h10;
        if (collection == null) {
            a(78);
        }
        if (lVar == null) {
            a(79);
        }
        if (collection.size() == 1) {
            H h11 = (H) h0.z2(collection);
            if (h11 == null) {
                a(80);
            }
            return h11;
        }
        ArrayList arrayList = new ArrayList(2);
        List listX3 = h0.x3(collection, lVar);
        H h12 = (H) h0.z2(collection);
        eo.a aVarInvoke = lVar.invoke(h12);
        for (H h13 : collection) {
            eo.a aVarInvoke2 = lVar.invoke(h13);
            if (D(aVarInvoke2, listX3)) {
                arrayList.add(h13);
            }
            if (C(aVarInvoke2, aVarInvoke) && !C(aVarInvoke, aVarInvoke2)) {
                h12 = h13;
            }
        }
        if (arrayList.isEmpty()) {
            if (h12 == null) {
                a(81);
            }
            return h12;
        }
        if (arrayList.size() == 1) {
            H h14 = (H) h0.z2(arrayList);
            if (h14 == null) {
                a(82);
            }
            return h14;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                h10 = null;
                break;
            }
            h10 = (H) it.next();
        } while (vp.c0.b(lVar.invoke(h10).getReturnType()));
        if (h10 != null) {
            return h10;
        }
        H h15 = (H) h0.z2(arrayList);
        if (h15 == null) {
            a(84);
        }
        return h15;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0197  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[FALL_THROUGH] */
    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 9 && i10 != 10 && i10 != 14 && i10 != 19 && i10 != 95 && i10 != 98 && i10 != 103 && i10 != 44 && i10 != 45) {
            switch (i10) {
                default:
                    switch (i10) {
                        default:
                            switch (i10) {
                                default:
                                    switch (i10) {
                                        case 90:
                                        case ms.a.T /* 91 */:
                                        case ms.a.W /* 92 */:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 9 && i10 != 10 && i10 != 14 && i10 != 19 && i10 != 95 && i10 != 98 && i10 != 103 && i10 != 44 && i10 != 45) {
            switch (i10) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    i11 = 2;
                    break;
                default:
                    switch (i10) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            i11 = 2;
                            break;
                        default:
                            switch (i10) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    i11 = 2;
                                    break;
                                default:
                                    switch (i10) {
                                        case 90:
                                        case ms.a.T /* 91 */:
                                        case ms.a.W /* 92 */:
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
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 3:
            default:
                objArr[0] = "equalityAxioms";
                break;
            case 4:
                objArr[0] = "axioms";
                break;
            case 6:
            case 7:
                objArr[0] = "candidateSet";
                break;
            case 8:
                objArr[0] = "transformFirst";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 44:
            case 45:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 90:
            case ms.a.T /* 91 */:
            case ms.a.W /* 92 */:
            case da.b.f3634e /* 95 */:
            case 98:
            case 103:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 11:
                objArr[0] = "f";
                break;
            case 12:
                objArr[0] = "g";
                break;
            case 13:
            case 15:
                objArr[0] = "descriptor";
                break;
            case 16:
                objArr[0] = "result";
                break;
            case 17:
            case 20:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 18:
            case 21:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
            case 42:
                objArr[0] = "firstParameters";
                break;
            case 41:
            case 43:
                objArr[0] = "secondParameters";
                break;
            case 46:
                objArr[0] = "typeInSuper";
                break;
            case 47:
                objArr[0] = "typeInSub";
                break;
            case 48:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
            case 77:
                objArr[0] = "typeChecker";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                objArr[0] = "superTypeParameter";
                break;
            case 50:
                objArr[0] = "subTypeParameter";
                break;
            case 52:
                objArr[0] = "name";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                objArr[0] = "membersFromSupertypes";
                break;
            case 54:
                objArr[0] = "membersFromCurrent";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 61:
            case 64:
            case 86:
            case 89:
            case 96:
                objArr[0] = "current";
                break;
            case 56:
            case 62:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case 87:
            case 106:
                objArr[0] = "strategy";
                break;
            case 57:
                objArr[0] = "overriding";
                break;
            case 58:
                objArr[0] = "fromSuper";
                break;
            case 59:
                objArr[0] = "fromCurrent";
                break;
            case 60:
                objArr[0] = "descriptorsFromSuper";
                break;
            case 63:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                objArr[0] = "notOverridden";
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 69:
            case 73:
                objArr[0] = "a";
                break;
            case 68:
            case 70:
            case 75:
                objArr[0] = "b";
                break;
            case 71:
                objArr[0] = "candidate";
                break;
            case TabLayout.f3131k0 /* 72 */:
            case 88:
            case ms.a.U /* 93 */:
            case 109:
                objArr[0] = "descriptors";
                break;
            case 74:
                objArr[0] = "aReturnType";
                break;
            case en.a.f4563i /* 76 */:
                objArr[0] = "bReturnType";
                break;
            case 78:
            case 85:
                objArr[0] = "overridables";
                break;
            case 79:
            case 101:
                objArr[0] = "descriptorByHandle";
                break;
            case 94:
                objArr[0] = "classModality";
                break;
            case 97:
                objArr[0] = "toFilter";
                break;
            case 99:
            case 104:
                objArr[0] = "overrider";
                break;
            case 100:
            case 105:
                objArr[0] = "extractFrom";
                break;
            case 102:
                objArr[0] = "onConflict";
                break;
            case y5.a.Z /* 107 */:
            case 108:
                objArr[0] = "memberDescriptor";
                break;
        }
        if (i10 == 9 || i10 == 10) {
            objArr[1] = "filterOverrides";
        } else if (i10 == 14) {
            objArr[1] = "getOverriddenDeclarations";
        } else if (i10 == 19) {
            objArr[1] = "isOverridableBy";
        } else if (i10 == 95) {
            objArr[1] = "getMinimalModality";
        } else if (i10 == 98) {
            objArr[1] = "filterVisibleFakeOverrides";
        } else if (i10 == 103) {
            objArr[1] = "extractMembersOverridableInBothWays";
        } else if (i10 != 44 && i10 != 45) {
            switch (i10) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    objArr[1] = "isOverridableBy";
                    break;
                default:
                    switch (i10) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            objArr[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        default:
                            switch (i10) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    objArr[1] = "selectMostSpecificMember";
                                    break;
                                default:
                                    switch (i10) {
                                        case 90:
                                        case ms.a.T /* 91 */:
                                        case ms.a.W /* 92 */:
                                            objArr[1] = "determineModalityForFakeOverride";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "createTypeCheckerState";
        }
        switch (i10) {
            case 1:
                objArr[2] = "createWithTypeRefiner";
                break;
            case 2:
            case 3:
                objArr[2] = "create";
                break;
            case 4:
            case 5:
                objArr[2] = "<init>";
                break;
            case 6:
                objArr[2] = "filterOutOverridden";
                break;
            case 7:
            case 8:
                objArr[2] = "filterOverrides";
                break;
            case 9:
            case 10:
            case 14:
            case 19:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 44:
            case 45:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 90:
            case ms.a.T /* 91 */:
            case ms.a.W /* 92 */:
            case da.b.f3634e /* 95 */:
            case 98:
            case 103:
                break;
            case 11:
            case 12:
                objArr[2] = "overrides";
                break;
            case 13:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 15:
            case 16:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 17:
            case 18:
            case 20:
            case 21:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeChecker";
                break;
            case 42:
            case 43:
                objArr[2] = "createTypeCheckerState";
                break;
            case 46:
            case 47:
            case 48:
                objArr[2] = "areTypesEquivalent";
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
            case 50:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 52:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case 54:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case 57:
            case 58:
                objArr[2] = "isVisibleForOverride";
                break;
            case 59:
            case 60:
            case 61:
            case 62:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case 63:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 68:
                objArr[2] = "isMoreSpecific";
                break;
            case 69:
            case 70:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 71:
            case TabLayout.f3131k0 /* 72 */:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case 73:
            case 74:
            case 75:
            case en.a.f4563i /* 76 */:
            case 77:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case 78:
            case 79:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 85:
            case 86:
            case 87:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 88:
            case 89:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case ms.a.U /* 93 */:
            case 94:
                objArr[2] = "getMinimalModality";
                break;
            case 96:
            case 97:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case 99:
            case 100:
            case 101:
            case 102:
            case 104:
            case 105:
            case 106:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case y5.a.Z /* 107 */:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 108:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 109:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithEqualityAxioms";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 9 && i10 != 10 && i10 != 14 && i10 != 19 && i10 != 95 && i10 != 98 && i10 != 103 && i10 != 44 && i10 != 45) {
            switch (i10) {
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i10) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i10) {
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    break;
                                default:
                                    switch (i10) {
                                        case 90:
                                        case ms.a.T /* 91 */:
                                        case ms.a.W /* 92 */:
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

    public static boolean b(@os.l Collection<eo.b> collection) {
        if (collection == null) {
            a(63);
        }
        if (collection.size() < 2) {
            return true;
        }
        return h0.w1(collection, new c(collection.iterator().next().b()));
    }

    @os.m
    public static i e(eo.a aVar, eo.a aVar2) {
        if ((aVar.R() == null) != (aVar2.R() == null)) {
            return i.d("Receiver presence mismatch");
        }
        if (aVar.h().size() != aVar2.h().size()) {
            return i.d("Value parameter number mismatch");
        }
        return null;
    }

    public static void f(@os.l eo.b bVar, @os.l Set<eo.b> set) {
        if (bVar == null) {
            a(15);
        }
        if (set == null) {
            a(16);
        }
        if (bVar.getKind().isReal()) {
            set.add(bVar);
            return;
        }
        if (bVar.d().isEmpty()) {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + bVar);
        }
        Iterator<? extends eo.b> it = bVar.d().iterator();
        while (it.hasNext()) {
            f(it.next(), set);
        }
    }

    public static List<f0> g(eo.a aVar) {
        w0 w0VarR = aVar.R();
        ArrayList arrayList = new ArrayList();
        if (w0VarR != null) {
            arrayList.add(w0VarR.getType());
        }
        Iterator<h1> it = aVar.h().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    @os.m
    public static u h(@os.l eo.b bVar) {
        if (bVar == null) {
            a(108);
        }
        Collection<? extends eo.b> collectionD = bVar.d();
        u uVarV = v(collectionD);
        if (uVarV == null) {
            return null;
        }
        if (bVar.getKind() != eo.b.a.FAKE_OVERRIDE) {
            return uVarV.f();
        }
        for (eo.b bVar2 : collectionD) {
            if (bVar2.s() != e0.ABSTRACT && !bVar2.getVisibility().equals(uVarV)) {
                return null;
            }
        }
        return uVarV;
    }

    @os.l
    public static j i(@os.l wp.g gVar, @os.l wp.e.a aVar) {
        if (gVar == null) {
            a(2);
        }
        if (aVar == null) {
            a(3);
        }
        return new j(aVar, gVar);
    }

    public static void j(@os.l Collection<eo.b> collection, @os.l eo.e eVar, @os.l hp.i iVar) {
        if (collection == null) {
            a(85);
        }
        if (eVar == null) {
            a(86);
        }
        if (iVar == null) {
            a(87);
        }
        Collection<eo.b> collectionU = u(eVar, collection);
        boolean zIsEmpty = collectionU.isEmpty();
        if (!zIsEmpty) {
            collection = collectionU;
        }
        eo.b bVarH0 = ((eo.b) M(collection, new d())).h0(eVar, o(collection, eVar), zIsEmpty ? t.f4636h : t.f4635g, eo.b.a.FAKE_OVERRIDE, false);
        iVar.d(bVarH0, collection);
        iVar.a(bVarH0);
    }

    public static void k(@os.l eo.e eVar, @os.l Collection<eo.b> collection, @os.l hp.i iVar) {
        if (eVar == null) {
            a(64);
        }
        if (collection == null) {
            a(65);
        }
        if (iVar == null) {
            a(66);
        }
        if (b(collection)) {
            Iterator<eo.b> it = collection.iterator();
            while (it.hasNext()) {
                j(Collections.singleton(it.next()), eVar, iVar);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                j(q(p.a(linkedList), linkedList, iVar), eVar, iVar);
            }
        }
    }

    @os.l
    public static j n(@os.l wp.g gVar) {
        if (gVar == null) {
            a(1);
        }
        return new j(f7491e, gVar);
    }

    @os.l
    public static e0 o(@os.l Collection<eo.b> collection, @os.l eo.e eVar) {
        if (collection == null) {
            a(88);
        }
        if (eVar == null) {
            a(89);
        }
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (eo.b bVar : collection) {
            int i10 = h.f7501c[bVar.s().ordinal()];
            if (i10 == 1) {
                e0 e0Var = e0.FINAL;
                if (e0Var == null) {
                    a(90);
                }
                return e0Var;
            }
            if (i10 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + bVar);
            }
            if (i10 == 3) {
                z11 = true;
            } else if (i10 == 4) {
                z12 = true;
            }
        }
        if (eVar.i0() && eVar.s() != e0.ABSTRACT && eVar.s() != e0.SEALED) {
            z10 = true;
        }
        if (z11 && !z12) {
            e0 e0Var2 = e0.OPEN;
            if (e0Var2 == null) {
                a(91);
            }
            return e0Var2;
        }
        if (!z11 && z12) {
            e0 e0VarS = z10 ? eVar.s() : e0.ABSTRACT;
            if (e0VarS == null) {
                a(92);
            }
            return e0VarS;
        }
        HashSet hashSet = new HashSet();
        Iterator<eo.b> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(A(it.next()));
        }
        return z(s(hashSet), z10, eVar.s());
    }

    @os.l
    public static Collection<eo.b> q(@os.l eo.b bVar, @os.l Queue<eo.b> queue, @os.l hp.i iVar) {
        if (bVar == null) {
            a(104);
        }
        if (queue == null) {
            a(105);
        }
        if (iVar == null) {
            a(106);
        }
        return r(bVar, queue, new f(), new g(iVar, bVar));
    }

    @os.l
    public static <H> Collection<H> r(@os.l H h10, @os.l Collection<H> collection, @os.l jn.l<H, eo.a> lVar, @os.l jn.l<H, l2> lVar2) {
        if (h10 == null) {
            a(99);
        }
        if (collection == null) {
            a(100);
        }
        if (lVar == null) {
            a(101);
        }
        if (lVar2 == null) {
            a(102);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h10);
        eo.a aVarInvoke = lVar.invoke(h10);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            eo.a aVarInvoke2 = lVar.invoke(next);
            if (h10 == next) {
                it.remove();
            } else {
                i.a aVarY = y(aVarInvoke, aVarInvoke2);
                if (aVarY == i.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (aVarY == i.a.CONFLICT) {
                    lVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    @os.l
    public static <D extends eo.a> Set<D> s(@os.l Set<D> set) {
        if (set == null) {
            a(6);
        }
        return t(set, !set.isEmpty() && lp.a.q(lp.a.l(set.iterator().next())), null, new b());
    }

    @os.l
    public static <D> Set<D> t(@os.l Set<D> set, boolean z10, @os.m jn.a<?> aVar, @os.l jn.p<? super D, ? super D, t0<eo.a, eo.a>> pVar) {
        if (set == null) {
            a(7);
        }
        if (pVar == null) {
            a(8);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (aVar != null) {
                aVar.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedHashSet.add(obj);
                    break;
                }
                t0<eo.a, eo.a> t0VarInvoke = pVar.invoke(obj, (Object) it.next());
                eo.a aVarComponent1 = t0VarInvoke.component1();
                eo.a aVarComponent2 = t0VarInvoke.component2();
                if (!K(aVarComponent1, aVarComponent2, z10, true)) {
                    if (K(aVarComponent2, aVarComponent1, z10, true)) {
                        break;
                    }
                } else {
                    it.remove();
                }
            }
        }
        return linkedHashSet;
    }

    @os.l
    public static Collection<eo.b> u(@os.l eo.e eVar, @os.l Collection<eo.b> collection) {
        if (eVar == null) {
            a(96);
        }
        if (collection == null) {
            a(97);
        }
        List listM2 = h0.m2(collection, new e(eVar));
        if (listM2 == null) {
            a(98);
        }
        return listM2;
    }

    @os.m
    public static u v(@os.l Collection<? extends eo.b> collection) {
        u uVar;
        if (collection == null) {
            a(109);
        }
        if (collection.isEmpty()) {
            return t.f4640l;
        }
        Iterator<? extends eo.b> it = collection.iterator();
        loop0: while (true) {
            uVar = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                u visibility = it.next().getVisibility();
                if (uVar != null) {
                    Integer numD = t.d(visibility, uVar);
                    if (numD == null) {
                        break;
                    }
                    if (numD.intValue() > 0) {
                    }
                }
                uVar = visibility;
            }
        }
        if (uVar == null) {
            return null;
        }
        Iterator<? extends eo.b> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer numD2 = t.d(uVar, it2.next().getVisibility());
            if (numD2 == null || numD2.intValue() < 0) {
                return null;
            }
        }
        return uVar;
    }

    @os.m
    public static i x(@os.l eo.a aVar, @os.l eo.a aVar2) {
        boolean z10;
        if (aVar == null) {
            a(38);
        }
        if (aVar2 == null) {
            a(39);
        }
        boolean z11 = aVar instanceof y;
        if ((z11 && !(aVar2 instanceof y)) || (((z10 = aVar instanceof eo.t0)) && !(aVar2 instanceof eo.t0))) {
            return i.d("Member kind mismatch");
        }
        if (!z11 && !z10) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
        }
        if (!aVar.getName().equals(aVar2.getName())) {
            return i.d("Name mismatch");
        }
        i iVarE = e(aVar, aVar2);
        if (iVarE != null) {
            return iVarE;
        }
        return null;
    }

    @os.m
    public static i.a y(eo.a aVar, eo.a aVar2) {
        j jVar = f7490d;
        i.a aVarC = jVar.E(aVar2, aVar, null).c();
        i.a aVarC2 = jVar.E(aVar, aVar2, null).c();
        i.a aVar3 = i.a.OVERRIDABLE;
        if (aVarC == aVar3 && aVarC2 == aVar3) {
            return aVar3;
        }
        i.a aVar4 = i.a.CONFLICT;
        return (aVarC == aVar4 || aVarC2 == aVar4) ? aVar4 : i.a.INCOMPATIBLE;
    }

    @os.l
    public static e0 z(@os.l Collection<eo.b> collection, boolean z10, @os.l e0 e0Var) {
        if (collection == null) {
            a(93);
        }
        if (e0Var == null) {
            a(94);
        }
        e0 e0Var2 = e0.ABSTRACT;
        for (eo.b bVar : collection) {
            e0 e0VarS = (z10 && bVar.s() == e0.ABSTRACT) ? e0Var : bVar.s();
            if (e0VarS.compareTo(e0Var2) < 0) {
                e0Var2 = e0VarS;
            }
        }
        if (e0Var2 == null) {
            a(95);
        }
        return e0Var2;
    }

    @os.l
    public i E(@os.l eo.a aVar, @os.l eo.a aVar2, @os.m eo.e eVar) {
        if (aVar == null) {
            a(17);
        }
        if (aVar2 == null) {
            a(18);
        }
        i iVarF = F(aVar, aVar2, eVar, false);
        if (iVarF == null) {
            a(19);
        }
        return iVarF;
    }

    @os.l
    public i F(@os.l eo.a aVar, @os.l eo.a aVar2, @os.m eo.e eVar, boolean z10) {
        if (aVar == null) {
            a(20);
        }
        if (aVar2 == null) {
            a(21);
        }
        i iVarG = G(aVar, aVar2, z10);
        boolean z11 = iVarG.c() == i.a.OVERRIDABLE;
        for (hp.e eVar2 : f7489c) {
            if (eVar2.a() != hp.e.a.CONFLICTS_ONLY && (!z11 || eVar2.a() != hp.e.a.SUCCESS_ONLY)) {
                int i10 = h.f7499a[eVar2.b(aVar, aVar2, eVar).ordinal()];
                if (i10 == 1) {
                    z11 = true;
                } else {
                    if (i10 == 2) {
                        i iVarB = i.b("External condition failed");
                        if (iVarB == null) {
                            a(22);
                        }
                        return iVarB;
                    }
                    if (i10 == 3) {
                        i iVarD = i.d("External condition");
                        if (iVarD == null) {
                            a(23);
                        }
                        return iVarD;
                    }
                }
            }
        }
        if (!z11) {
            return iVarG;
        }
        for (hp.e eVar3 : f7489c) {
            if (eVar3.a() == hp.e.a.CONFLICTS_ONLY) {
                int i11 = h.f7499a[eVar3.b(aVar, aVar2, eVar).ordinal()];
                if (i11 == 1) {
                    throw new IllegalStateException("Contract violation in " + eVar3.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i11 == 2) {
                    i iVarB2 = i.b("External condition failed");
                    if (iVarB2 == null) {
                        a(25);
                    }
                    return iVarB2;
                }
                if (i11 == 3) {
                    i iVarD2 = i.d("External condition");
                    if (iVarD2 == null) {
                        a(26);
                    }
                    return iVarD2;
                }
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(27);
        }
        return iVarE;
    }

    @os.l
    public i G(@os.l eo.a aVar, @os.l eo.a aVar2, boolean z10) {
        if (aVar == null) {
            a(28);
        }
        if (aVar2 == null) {
            a(29);
        }
        i iVarX = x(aVar, aVar2);
        if (iVarX != null) {
            return iVarX;
        }
        List<f0> listG = g(aVar);
        List<f0> listG2 = g(aVar2);
        List<e1> typeParameters = aVar.getTypeParameters();
        List<e1> typeParameters2 = aVar2.getTypeParameters();
        int i10 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i10 < listG.size()) {
                if (!wp.e.f19851a.b(listG.get(i10), listG2.get(i10))) {
                    i iVarD = i.d("Type parameter number mismatch");
                    if (iVarD == null) {
                        a(31);
                    }
                    return iVarD;
                }
                i10++;
            }
            i iVarB = i.b("Type parameter number mismatch");
            if (iVarB == null) {
                a(32);
            }
            return iVarB;
        }
        t0<wp.m, z0> t0VarL = l(typeParameters, typeParameters2);
        for (int i11 = 0; i11 < typeParameters.size(); i11++) {
            if (!c(typeParameters.get(i11), typeParameters2.get(i11), t0VarL)) {
                i iVarD2 = i.d("Type parameter bounds mismatch");
                if (iVarD2 == null) {
                    a(33);
                }
                return iVarD2;
            }
        }
        while (i10 < listG.size()) {
            if (!d(listG.get(i10), listG2.get(i10), t0VarL)) {
                i iVarD3 = i.d("Value parameter type mismatch");
                if (iVarD3 == null) {
                    a(34);
                }
                return iVarD3;
            }
            i10++;
        }
        if ((aVar instanceof y) && (aVar2 instanceof y) && ((y) aVar).isSuspend() != ((y) aVar2).isSuspend()) {
            i iVarB2 = i.b("Incompatible suspendability");
            if (iVarB2 == null) {
                a(35);
            }
            return iVarB2;
        }
        if (z10) {
            f0 returnType = aVar.getReturnType();
            f0 returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null && ((!vp.h0.a(returnType2) || !vp.h0.a(returnType)) && !t0VarL.getFirst().g(t0VarL.getSecond(), returnType2.J0(), returnType.J0()))) {
                i iVarB3 = i.b("Return type mismatch");
                if (iVarB3 == null) {
                    a(36);
                }
                return iVarB3;
            }
        }
        i iVarE = i.e();
        if (iVarE == null) {
            a(37);
        }
        return iVarE;
    }

    public final boolean c(@os.l e1 e1Var, @os.l e1 e1Var2, @os.l t0<wp.m, z0> t0Var) {
        if (e1Var == null) {
            a(49);
        }
        if (e1Var2 == null) {
            a(50);
        }
        if (t0Var == null) {
            a(51);
        }
        List<f0> upperBounds = e1Var.getUpperBounds();
        ArrayList arrayList = new ArrayList(e1Var2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (f0 f0Var : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (d(f0Var, (f0) listIterator.next(), t0Var)) {
                    listIterator.remove();
                }
            }
            return false;
        }
        return true;
    }

    public final boolean d(@os.l f0 f0Var, @os.l f0 f0Var2, @os.l t0<wp.m, z0> t0Var) {
        if (f0Var == null) {
            a(46);
        }
        if (f0Var2 == null) {
            a(47);
        }
        if (t0Var == null) {
            a(48);
        }
        if (vp.h0.a(f0Var) && vp.h0.a(f0Var2)) {
            return true;
        }
        return t0Var.getFirst().e(t0Var.getSecond(), f0Var.J0(), f0Var2.J0());
    }

    @os.l
    public final t0<wp.m, z0> l(@os.l List<e1> list, @os.l List<e1> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        return new t0<>(new wp.m(this.f7493a, wp.f.a.f19852a), m(list, list2));
    }

    @os.l
    public final z0 m(@os.l List<e1> list, @os.l List<e1> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            z0 z0VarB0 = new k(null, this.f7494b, this.f7493a).B0(true, true);
            if (z0VarB0 == null) {
                a(44);
            }
            return z0VarB0;
        }
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list.size(); i10++) {
            map.put(list.get(i10).i(), list2.get(i10).i());
        }
        z0 z0VarB1 = new k(map, this.f7494b, this.f7493a).B0(true, true);
        if (z0VarB1 == null) {
            a(45);
        }
        return z0VarB1;
    }

    public final Collection<eo.b> p(@os.l eo.b bVar, @os.l Collection<? extends eo.b> collection, @os.l eo.e eVar, @os.l hp.i iVar) {
        if (bVar == null) {
            a(59);
        }
        if (collection == null) {
            a(60);
        }
        if (eVar == null) {
            a(61);
        }
        if (iVar == null) {
            a(62);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        eq.f fVarA = eq.f.a();
        for (eo.b bVar2 : collection) {
            i.a aVarC = E(bVar2, bVar, eVar).c();
            boolean zJ = J(bVar, bVar2);
            int i10 = h.f7500b[aVarC.ordinal()];
            if (i10 == 1) {
                if (zJ) {
                    fVarA.add(bVar2);
                }
                arrayList.add(bVar2);
            } else if (i10 == 2) {
                if (zJ) {
                    iVar.c(bVar2, bVar);
                }
                arrayList.add(bVar2);
            }
        }
        iVar.d(bVar, fVarA);
        return arrayList;
    }

    public void w(@os.l dp.f fVar, @os.l Collection<? extends eo.b> collection, @os.l Collection<? extends eo.b> collection2, @os.l eo.e eVar, @os.l hp.i iVar) {
        if (fVar == null) {
            a(52);
        }
        if (collection == null) {
            a(53);
        }
        if (collection2 == null) {
            a(54);
        }
        if (eVar == null) {
            a(55);
        }
        if (iVar == null) {
            a(56);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends eo.b> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(p(it.next(), collection, eVar, iVar));
        }
        k(eVar, linkedHashSet, iVar);
    }
}
