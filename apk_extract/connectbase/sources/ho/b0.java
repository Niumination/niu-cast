package ho;

import eo.e1;
import eo.s0;
import eo.t0;
import eo.w0;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import vp.h1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 extends k implements s0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ boolean f7293x = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f7295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final eo.e0 f7296g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t0 f7297i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7298n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final eo.b.a f7299p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public eo.u f7300v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.m
    public eo.y f7301w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(@os.l eo.e0 e0Var, @os.l eo.u uVar, @os.l t0 t0Var, @os.l fo.g gVar, @os.l dp.f fVar, boolean z10, boolean z11, boolean z12, eo.b.a aVar, @os.l z0 z0Var) {
        super(t0Var.b(), gVar, fVar, z0Var);
        if (e0Var == null) {
            B(0);
        }
        if (uVar == null) {
            B(1);
        }
        if (t0Var == null) {
            B(2);
        }
        if (gVar == null) {
            B(3);
        }
        if (fVar == null) {
            B(4);
        }
        if (z0Var == null) {
            B(5);
        }
        this.f7301w = null;
        this.f7296g = e0Var;
        this.f7300v = uVar;
        this.f7297i = t0Var;
        this.f7294e = z10;
        this.f7295f = z11;
        this.f7298n = z12;
        this.f7299p = aVar;
    }

    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i11 = 2;
                break;
            case 7:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i10) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // eo.y
    public boolean A0() {
        return false;
    }

    @Override // eo.b
    @os.l
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public s0 h0(eo.m mVar, eo.e0 e0Var, eo.u uVar, eo.b.a aVar, boolean z10) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // eo.y
    public boolean D() {
        return false;
    }

    @Override // ho.k
    @os.l
    /* JADX INFO: renamed from: E0 */
    public abstract s0 a();

    @os.l
    public Collection<s0> F0(boolean z10) {
        ArrayList arrayList = new ArrayList(0);
        for (t0 t0Var : W().d()) {
            eo.q getter = z10 ? t0Var.getGetter() : t0Var.getSetter();
            if (getter != null) {
                arrayList.add(getter);
            }
        }
        return arrayList;
    }

    public void G0(boolean z10) {
        this.f7294e = z10;
    }

    public void H0(@os.m eo.y yVar) {
        this.f7301w = yVar;
    }

    @Override // eo.s0
    public boolean I() {
        return this.f7294e;
    }

    public void I0(eo.u uVar) {
        this.f7300v = uVar;
    }

    @Override // eo.a
    @os.m
    public w0 O() {
        return W().O();
    }

    @Override // eo.a
    @os.m
    public w0 R() {
        return W().R();
    }

    @Override // eo.s0
    @os.l
    public t0 W() {
        t0 t0Var = this.f7297i;
        if (t0Var == null) {
            B(12);
        }
        return t0Var;
    }

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    @Override // eo.a
    public boolean e0() {
        return false;
    }

    @Override // eo.b
    @os.l
    public eo.b.a getKind() {
        eo.b.a aVar = this.f7299p;
        if (aVar == null) {
            B(6);
        }
        return aVar;
    }

    @Override // eo.a
    @os.l
    public List<e1> getTypeParameters() {
        List<e1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            B(8);
        }
        return listEmptyList;
    }

    @Override // eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = this.f7300v;
        if (uVar == null) {
            B(10);
        }
        return uVar;
    }

    @Override // eo.d0
    public boolean i0() {
        return false;
    }

    @Override // eo.d0
    public boolean isExternal() {
        return this.f7295f;
    }

    @Override // eo.y
    public boolean isInfix() {
        return false;
    }

    @Override // eo.y
    public boolean isInline() {
        return this.f7298n;
    }

    @Override // eo.y
    public boolean isOperator() {
        return false;
    }

    @Override // eo.y
    public boolean isSuspend() {
        return false;
    }

    @Override // eo.a
    @os.m
    public <V> V j0(eo.a.InterfaceC0106a<V> interfaceC0106a) {
        return null;
    }

    @Override // eo.y
    @os.m
    public eo.y q0() {
        return this.f7301w;
    }

    @Override // eo.d0
    @os.l
    public eo.e0 s() {
        eo.e0 e0Var = this.f7296g;
        if (e0Var == null) {
            B(9);
        }
        return e0Var;
    }

    @Override // eo.y
    @os.l
    public eo.y.a<? extends eo.y> w() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // eo.y
    public boolean y0() {
        return false;
    }

    @Override // eo.b
    public void z0(@os.l Collection<? extends eo.b> collection) {
        if (collection == null) {
            B(14);
        }
    }

    @Override // eo.b1
    @os.l
    public eo.y c(@os.l h1 h1Var) {
        if (h1Var == null) {
            B(7);
        }
        throw new UnsupportedOperationException();
    }
}
