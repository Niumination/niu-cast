package ho;

import eo.e1;
import eo.h1;
import eo.j1;
import eo.w0;
import eo.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 extends k implements j1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f7374f = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vp.f0 f7375e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(@os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.m vp.f0 f0Var, @os.l z0 z0Var) {
        super(mVar, gVar, fVar, z0Var);
        if (mVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (fVar == null) {
            B(2);
        }
        if (z0Var == null) {
            B(3);
        }
        this.f7375e = f0Var;
    }

    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ho.k
    @os.l
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public j1 a() {
        return this;
    }

    public void E0(vp.f0 f0Var) {
        this.f7375e = f0Var;
    }

    public w0 O() {
        return null;
    }

    public w0 R() {
        return null;
    }

    @os.l
    public Collection<? extends eo.a> d() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            B(7);
        }
        return setEmptySet;
    }

    @Override // eo.a
    public boolean e0() {
        return false;
    }

    @os.l
    public vp.f0 getReturnType() {
        vp.f0 type = getType();
        if (type == null) {
            B(9);
        }
        return type;
    }

    @Override // eo.g1
    @os.l
    public vp.f0 getType() {
        vp.f0 f0Var = this.f7375e;
        if (f0Var == null) {
            B(4);
        }
        return f0Var;
    }

    @os.l
    public List<e1> getTypeParameters() {
        List<e1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            B(8);
        }
        return listEmptyList;
    }

    @Override // eo.a
    @os.l
    public List<h1> h() {
        List<h1> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            B(6);
        }
        return listEmptyList;
    }

    public boolean isConst() {
        return false;
    }

    @os.m
    public <V> V j0(eo.a.InterfaceC0106a<V> interfaceC0106a) {
        return null;
    }
}
