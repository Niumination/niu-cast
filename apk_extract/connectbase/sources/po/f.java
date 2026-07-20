package po;

import eo.e0;
import eo.u;
import eo.v0;
import eo.w0;
import eo.z0;
import ho.c0;
import ho.d0;
import java.util.List;
import lm.t0;
import os.l;
import os.m;
import up.j;
import vo.r;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public class f extends c0 implements a {
    public final boolean U;

    @m
    public final t0<eo.a.InterfaceC0106a<?>, ?> V;
    public f0 W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@l eo.m mVar, @l fo.g gVar, @l e0 e0Var, @l u uVar, boolean z10, @l dp.f fVar, @l z0 z0Var, @m eo.t0 t0Var, @l eo.b.a aVar, boolean z11, @m t0<eo.a.InterfaceC0106a<?>, ?> t0Var2) {
        super(mVar, t0Var, gVar, e0Var, uVar, z10, fVar, aVar, z0Var, false, false, false, false, false, false);
        if (mVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (e0Var == null) {
            B(2);
        }
        if (uVar == null) {
            B(3);
        }
        if (fVar == null) {
            B(4);
        }
        if (z0Var == null) {
            B(5);
        }
        if (aVar == null) {
            B(6);
        }
        this.W = null;
        this.U = z11;
        this.V = t0Var2;
    }

    private static /* synthetic */ void B(int i10) {
        String str = i10 != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 21 ? 3 : 2];
        switch (i10) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case 22:
                objArr[0] = "inType";
                break;
        }
        if (i10 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            case 22:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 21) {
            throw new IllegalStateException(str2);
        }
    }

    @l
    public static f X0(@l eo.m mVar, @l fo.g gVar, @l e0 e0Var, @l u uVar, boolean z10, @l dp.f fVar, @l z0 z0Var, boolean z11) {
        if (mVar == null) {
            B(7);
        }
        if (gVar == null) {
            B(8);
        }
        if (e0Var == null) {
            B(9);
        }
        if (uVar == null) {
            B(10);
        }
        if (fVar == null) {
            B(11);
        }
        if (z0Var == null) {
            B(12);
        }
        return new f(mVar, gVar, e0Var, uVar, z10, fVar, z0Var, null, eo.b.a.DECLARATION, z11, null);
    }

    @Override // po.a
    @l
    public a C0(@m f0 f0Var, @l List<i> list, @l f0 f0Var2, @m t0<eo.a.InterfaceC0106a<?>, ?> t0Var) {
        d0 d0Var;
        ho.e0 e0Var;
        w0 w0VarF;
        if (list == null) {
            B(19);
        }
        if (f0Var2 == null) {
            B(20);
        }
        eo.t0 t0VarA = a() == this ? null : a();
        f fVar = new f(b(), getAnnotations(), s(), getVisibility(), Q(), getName(), getSource(), t0VarA, getKind(), this.U, t0Var);
        d0 getter = getGetter();
        if (getter != null) {
            d0Var = d0Var;
            d0 d0Var2 = new d0(fVar, getter.getAnnotations(), getter.s(), getter.getVisibility(), getter.I(), getter.isExternal(), getter.isInline(), getKind(), t0VarA == null ? null : t0VarA.getGetter(), getter.getSource());
            d0Var.f7301w = getter.q0();
            d0Var.K0(f0Var2);
        } else {
            d0Var = null;
        }
        v0 setter = getSetter();
        if (setter != null) {
            ho.e0 e0Var2 = new ho.e0(fVar, setter.getAnnotations(), setter.s(), setter.getVisibility(), setter.I(), setter.isExternal(), setter.isInline(), getKind(), t0VarA == null ? null : t0VarA.getSetter(), setter.getSource());
            e0Var2.f7301w = e0Var2.f7301w;
            e0Var2.L0(setter.h().get(0));
            e0Var = e0Var2;
        } else {
            e0Var = null;
        }
        fVar.P0(d0Var, e0Var, t0(), S());
        fVar.R = Q0();
        j<jp.g<?>> jVar = this.f7396i;
        if (jVar != null) {
            fVar.F0(jVar);
        }
        fVar.z0(d());
        if (f0Var == null) {
            w0VarF = null;
        } else {
            fo.g.f6167h.getClass();
            w0VarF = hp.c.f(this, f0Var, fo.g.a.f6169b);
        }
        fVar.V0(f0Var2, getTypeParameters(), O(), w0VarF);
        return fVar;
    }

    @Override // ho.c0
    @l
    public c0 J0(@l eo.m mVar, @l e0 e0Var, @l u uVar, @m eo.t0 t0Var, @l eo.b.a aVar, @l dp.f fVar, @l z0 z0Var) {
        if (mVar == null) {
            B(13);
        }
        if (e0Var == null) {
            B(14);
        }
        if (uVar == null) {
            B(15);
        }
        if (aVar == null) {
            B(16);
        }
        if (fVar == null) {
            B(17);
        }
        if (z0Var == null) {
            B(18);
        }
        return new f(mVar, getAnnotations(), e0Var, uVar, Q(), fVar, z0Var, t0Var, aVar, this.U, this.V);
    }

    @Override // ho.c0
    public void T0(@l f0 f0Var) {
        if (f0Var == null) {
            B(22);
        }
        this.W = f0Var;
    }

    @Override // ho.m0, eo.a
    public boolean e0() {
        return false;
    }

    @Override // ho.c0, ho.m0, eo.j1
    public boolean isConst() {
        f0 type = getType();
        return this.U && eo.j.a(type) && (!r.i(type) || ao.h.t0(type));
    }

    @Override // ho.c0, ho.m0, eo.a
    @m
    public <V> V j0(eo.a.InterfaceC0106a<V> interfaceC0106a) {
        t0<eo.a.InterfaceC0106a<?>, ?> t0Var = this.V;
        if (t0Var == null || !t0Var.getFirst().equals(interfaceC0106a)) {
            return null;
        }
        return (V) this.V.getSecond();
    }
}
