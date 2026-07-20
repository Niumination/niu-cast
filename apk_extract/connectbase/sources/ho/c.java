package ho;

import eo.e1;
import eo.h1;
import eo.q0;
import eo.w0;
import eo.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends j implements w0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@os.l fo.g gVar) {
        super(gVar, dp.h.f3831h);
        if (gVar == null) {
            B(0);
        }
    }

    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i10) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.g(this, d10);
    }

    @Override // eo.a
    @os.m
    public w0 O() {
        return null;
    }

    @Override // eo.a
    @os.m
    public w0 R() {
        return null;
    }

    @Override // eo.a
    @os.l
    public Collection<? extends eo.a> d() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            B(5);
        }
        return setEmptySet;
    }

    @Override // eo.a
    public boolean e0() {
        return false;
    }

    @Override // ho.j, eo.m
    @os.l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public q0 a() {
        return this;
    }

    @Override // eo.a
    @os.m
    public vp.f0 getReturnType() {
        return getType();
    }

    @Override // eo.p
    @os.l
    public z0 getSource() {
        z0 z0Var = z0.f4654a;
        if (z0Var == null) {
            B(8);
        }
        return z0Var;
    }

    @Override // eo.g1
    @os.l
    public vp.f0 getType() {
        vp.f0 type = getValue().getType();
        if (type == null) {
            B(3);
        }
        return type;
    }

    @Override // eo.a
    @os.l
    public List<e1> getTypeParameters() {
        List<e1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            B(2);
        }
        return listEmptyList;
    }

    @Override // eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = eo.t.f4634f;
        if (uVar == null) {
            B(6);
        }
        return uVar;
    }

    @Override // eo.a
    @os.l
    public List<h1> h() {
        List<h1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            B(4);
        }
        return listEmptyList;
    }

    @Override // eo.a
    @os.m
    public <V> V j0(eo.a.InterfaceC0106a<V> interfaceC0106a) {
        return null;
    }

    @Override // eo.b1
    @os.m
    public w0 c(@os.l vp.h1 h1Var) {
        if (h1Var == null) {
            B(1);
        }
        if (h1Var.k()) {
            return this;
        }
        vp.f0 f0VarP = b() instanceof eo.e ? h1Var.p(getType(), o1.OUT_VARIANCE) : h1Var.p(getType(), o1.INVARIANT);
        if (f0VarP == null) {
            return null;
        }
        return f0VarP == getType() ? this : new f0(b(), new pp.h(f0VarP), getAnnotations());
    }
}
