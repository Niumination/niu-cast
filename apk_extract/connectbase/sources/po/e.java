package po;

import eo.e0;
import eo.e1;
import eo.h1;
import eo.m;
import eo.u;
import eo.w0;
import eo.y;
import eo.y0;
import eo.z0;
import ho.g0;
import java.util.List;
import java.util.Map;
import lm.t0;
import os.l;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class e extends g0 implements po.a {
    public static final eo.a.InterfaceC0106a<h1> X = new a();
    public static final eo.a.InterfaceC0106a<Boolean> Y = new b();
    public static final /* synthetic */ boolean Z = false;
    public c V;
    public final boolean W;

    public static class a implements eo.a.InterfaceC0106a<h1> {
    }

    public static class b implements eo.a.InterfaceC0106a<Boolean> {
    }

    public enum c {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        c(boolean z10, boolean z11) {
            this.isStable = z10;
            this.isSynthesized = z11;
        }

        public static /* synthetic */ void a(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        @l
        public static c get(boolean z10, boolean z11) {
            c cVar;
            if (z10) {
                cVar = z11 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
            } else {
                cVar = z11 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            }
            if (cVar == null) {
                a(0);
            }
            return cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@l m mVar, @os.m y0 y0Var, @l fo.g gVar, @l dp.f fVar, @l eo.b.a aVar, @l z0 z0Var, boolean z10) {
        super(mVar, y0Var, gVar, fVar, aVar, z0Var);
        if (mVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (fVar == null) {
            B(2);
        }
        if (aVar == null) {
            B(3);
        }
        if (z0Var == null) {
            B(4);
        }
        this.V = null;
        this.W = z10;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 12 || i10 == 17 || i10 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 12 || i10 == 17 || i10 == 20) ? 2 : 3];
        switch (i10) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i10 == 12) {
            objArr[1] = "initialize";
        } else if (i10 == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i10 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 12 && i10 != 17 && i10 != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @l
    public static e j1(@l m mVar, @l fo.g gVar, @l dp.f fVar, @l z0 z0Var, boolean z10) {
        if (mVar == null) {
            B(5);
        }
        if (gVar == null) {
            B(6);
        }
        if (fVar == null) {
            B(7);
        }
        if (z0Var == null) {
            B(8);
        }
        return new e(mVar, null, gVar, fVar, eo.b.a.DECLARATION, z0Var, z10);
    }

    @Override // ho.p
    public boolean K0() {
        return this.V.isStable;
    }

    @Override // ho.p, eo.a
    public boolean e0() {
        return this.V.isSynthesized;
    }

    @Override // ho.g0
    @l
    public g0 i1(@os.m w0 w0Var, @os.m w0 w0Var2, @l List<? extends e1> list, @l List<h1> list2, @os.m f0 f0Var, @os.m e0 e0Var, @l u uVar, @os.m Map<? extends eo.a.InterfaceC0106a<?>, ?> map) {
        if (list == null) {
            B(9);
        }
        if (list2 == null) {
            B(10);
        }
        if (uVar == null) {
            B(11);
        }
        g0 g0VarI1 = super.i1(w0Var, w0Var2, list, list2, f0Var, e0Var, uVar, map);
        Z0(bq.i.f1063a.a(g0VarI1).f1046a);
        if (g0VarI1 == null) {
            B(12);
        }
        return g0VarI1;
    }

    @Override // ho.g0, ho.p
    @l
    /* JADX INFO: renamed from: k1, reason: merged with bridge method [inline-methods] */
    public e F0(@l m mVar, @os.m y yVar, @l eo.b.a aVar, @os.m dp.f fVar, @l fo.g gVar, @l z0 z0Var) {
        if (mVar == null) {
            B(13);
        }
        if (aVar == null) {
            B(14);
        }
        if (gVar == null) {
            B(15);
        }
        if (z0Var == null) {
            B(16);
        }
        y0 y0Var = (y0) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(mVar, y0Var, gVar, fVar, aVar, z0Var, this.W);
        eVar.m1(K0(), e0());
        return eVar;
    }

    @Override // po.a
    @l
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public e C0(@os.m f0 f0Var, @l List<i> list, @l f0 f0Var2, @os.m t0<eo.a.InterfaceC0106a<?>, ?> t0Var) {
        w0 w0VarF;
        if (list == null) {
            B(18);
        }
        if (f0Var2 == null) {
            B(19);
        }
        List<h1> listA = h.a(list, h(), this);
        if (f0Var == null) {
            w0VarF = null;
        } else {
            fo.g.f6167h.getClass();
            w0VarF = hp.c.f(this, f0Var, fo.g.a.f6169b);
        }
        e eVar = (e) w().c(listA).q(f0Var2).j(w0VarF).a().i().build();
        if (t0Var != null) {
            eVar.O0(t0Var.getFirst(), t0Var.getSecond());
        }
        if (eVar == null) {
            B(20);
        }
        return eVar;
    }

    public void m1(boolean z10, boolean z11) {
        this.V = c.get(z10, z11);
    }
}
