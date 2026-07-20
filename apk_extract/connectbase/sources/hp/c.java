package hp;

import eo.t;
import eo.t0;
import eo.u;
import eo.w0;
import eo.y;
import eo.y0;
import eo.z0;
import ho.d0;
import ho.e0;
import ho.g0;
import ho.l0;
import java.util.Collections;
import vp.f0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    public static class a extends ho.f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l eo.e eVar, @os.l z0 z0Var, boolean z10) {
            super(eVar, null, fo.g.a.f6169b, true, eo.b.a.DECLARATION, z0Var);
            if (eVar == null) {
                B(0);
            }
            if (z0Var == null) {
                B(1);
            }
            fo.g.f6167h.getClass();
            j1(Collections.emptyList(), d.k(eVar, z10));
        }

        private static /* synthetic */ void B(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 12 || i10 == 23 || i10 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 12 || i10 == 23 || i10 == 25) ? 2 : 3];
        switch (i10) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i10 == 12) {
            objArr[1] = "createSetter";
        } else if (i10 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i10 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i10) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 12 && i10 != 23 && i10 != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public static d0 b(@os.l t0 t0Var, @os.l fo.g gVar) {
        if (t0Var == null) {
            a(13);
        }
        if (gVar == null) {
            a(14);
        }
        return g(t0Var, gVar, true, false, false);
    }

    @os.l
    public static e0 c(@os.l t0 t0Var, @os.l fo.g gVar, @os.l fo.g gVar2) {
        if (t0Var == null) {
            a(0);
        }
        if (gVar == null) {
            a(1);
        }
        if (gVar2 == null) {
            a(2);
        }
        return k(t0Var, gVar, gVar2, true, false, false, t0Var.getSource());
    }

    @os.l
    public static y0 d(@os.l eo.e eVar) {
        if (eVar == null) {
            a(24);
        }
        fo.g.a aVar = fo.g.f6167h;
        aVar.getClass();
        fo.g gVar = fo.g.a.f6169b;
        g0 g0VarF1 = g0.f1(eVar, gVar, ao.k.f555c, eo.b.a.SYNTHESIZED, eVar.getSource());
        aVar.getClass();
        g0 g0VarH1 = g0VarF1.L0(null, null, Collections.emptyList(), Collections.singletonList(new l0(g0VarF1, null, 0, gVar, dp.f.k("value"), lp.a.g(eVar).W(), false, false, false, null, eVar.getSource())), eVar.q(), eo.e0.FINAL, t.f4633e);
        if (g0VarH1 == null) {
            a(25);
        }
        return g0VarH1;
    }

    @os.l
    public static y0 e(@os.l eo.e eVar) {
        if (eVar == null) {
            a(22);
        }
        fo.g.f6167h.getClass();
        g0 g0VarH1 = g0.f1(eVar, fo.g.a.f6169b, ao.k.f554b, eo.b.a.SYNTHESIZED, eVar.getSource()).L0(null, null, Collections.emptyList(), Collections.emptyList(), lp.a.g(eVar).l(o1.INVARIANT, eVar.q()), eo.e0.FINAL, t.f4633e);
        if (g0VarH1 == null) {
            a(23);
        }
        return g0VarH1;
    }

    @os.m
    public static w0 f(@os.l eo.a aVar, @os.m f0 f0Var, @os.l fo.g gVar) {
        if (aVar == null) {
            a(29);
        }
        if (gVar == null) {
            a(30);
        }
        if (f0Var == null) {
            return null;
        }
        return new ho.f0(aVar, new pp.b(aVar, f0Var, null), gVar);
    }

    @os.l
    public static d0 g(@os.l t0 t0Var, @os.l fo.g gVar, boolean z10, boolean z11, boolean z12) {
        if (t0Var == null) {
            a(15);
        }
        if (gVar == null) {
            a(16);
        }
        return h(t0Var, gVar, z10, z11, z12, t0Var.getSource());
    }

    @os.l
    public static d0 h(@os.l t0 t0Var, @os.l fo.g gVar, boolean z10, boolean z11, boolean z12, @os.l z0 z0Var) {
        if (t0Var == null) {
            a(17);
        }
        if (gVar == null) {
            a(18);
        }
        if (z0Var == null) {
            a(19);
        }
        return new d0(t0Var, gVar, t0Var.s(), t0Var.getVisibility(), z10, z11, z12, eo.b.a.DECLARATION, null, z0Var);
    }

    @os.l
    public static ho.f i(@os.l eo.e eVar, @os.l z0 z0Var) {
        if (eVar == null) {
            a(20);
        }
        if (z0Var == null) {
            a(21);
        }
        return new a(eVar, z0Var, false);
    }

    @os.l
    public static e0 j(@os.l t0 t0Var, @os.l fo.g gVar, @os.l fo.g gVar2, boolean z10, boolean z11, boolean z12, @os.l u uVar, @os.l z0 z0Var) {
        if (t0Var == null) {
            a(7);
        }
        if (gVar == null) {
            a(8);
        }
        if (gVar2 == null) {
            a(9);
        }
        if (uVar == null) {
            a(10);
        }
        if (z0Var == null) {
            a(11);
        }
        e0 e0Var = new e0(t0Var, gVar, t0Var.s(), uVar, z10, z11, z12, eo.b.a.DECLARATION, null, z0Var);
        e0Var.L0(e0.J0(e0Var, t0Var.getType(), gVar2));
        return e0Var;
    }

    @os.l
    public static e0 k(@os.l t0 t0Var, @os.l fo.g gVar, @os.l fo.g gVar2, boolean z10, boolean z11, boolean z12, @os.l z0 z0Var) {
        if (t0Var == null) {
            a(3);
        }
        if (gVar == null) {
            a(4);
        }
        if (gVar2 == null) {
            a(5);
        }
        if (z0Var == null) {
            a(6);
        }
        return j(t0Var, gVar, gVar2, z10, z11, z12, t0Var.getVisibility(), z0Var);
    }

    public static boolean l(@os.l y yVar) {
        if (yVar == null) {
            a(28);
        }
        return yVar.getKind() == eo.b.a.SYNTHESIZED && d.A(yVar.b());
    }

    public static boolean m(@os.l y yVar) {
        if (yVar == null) {
            a(27);
        }
        return yVar.getName().equals(ao.k.f555c) && l(yVar);
    }

    public static boolean n(@os.l y yVar) {
        if (yVar == null) {
            a(26);
        }
        return yVar.getName().equals(ao.k.f554b) && l(yVar);
    }
}
