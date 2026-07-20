package ho;

import eo.e1;
import eo.h1;
import eo.w0;
import eo.z0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class f extends p implements eo.d {
    public static final /* synthetic */ boolean W = false;
    public final boolean V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@os.l eo.e eVar, @os.m eo.l lVar, @os.l fo.g gVar, boolean z10, @os.l eo.b.a aVar, @os.l z0 z0Var) {
        super(eVar, lVar, gVar, dp.h.f3832i, aVar, z0Var);
        if (eVar == null) {
            B(0);
        }
        if (gVar == null) {
            B(1);
        }
        if (aVar == null) {
            B(2);
        }
        if (z0Var == null) {
            B(3);
        }
        this.V = z10;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e  */
    private static /* synthetic */ void B(int i10) {
        String str;
        int i11;
        if (i10 != 19 && i10 != 25) {
            switch (i10) {
                case 15:
                case 16:
                case 17:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 19 && i10 != 25) {
            switch (i10) {
                case 15:
                case 16:
                case 17:
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
            case 1:
            case 5:
            case 8:
            case 23:
                objArr[0] = "annotations";
                break;
            case 2:
            case 22:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 24:
                objArr[0] = "source";
                break;
            case 4:
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 18:
                objArr[0] = "originalSubstitutor";
                break;
            case 20:
                objArr[0] = "overriddenDescriptors";
                break;
            case 21:
                objArr[0] = "newOwner";
                break;
        }
        if (i10 == 19) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i10 != 25) {
            switch (i10) {
                case 15:
                    objArr[1] = "getContainingDeclaration";
                    break;
                case 16:
                    objArr[1] = "getConstructedClass";
                    break;
                case 17:
                    objArr[1] = "getOriginal";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            case 20:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 19 && i10 != 25) {
            switch (i10) {
                case 15:
                case 16:
                case 17:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public static f g1(@os.l eo.e eVar, @os.l fo.g gVar, boolean z10, @os.l z0 z0Var) {
        if (eVar == null) {
            B(4);
        }
        if (gVar == null) {
            B(5);
        }
        if (z0Var == null) {
            B(6);
        }
        return new f(eVar, null, gVar, z10, eo.b.a.DECLARATION, z0Var);
    }

    @Override // ho.p, eo.m
    public <R, D> R A(eo.o<R, D> oVar, D d10) {
        return oVar.c(this, d10);
    }

    @Override // eo.l
    public boolean b0() {
        return this.V;
    }

    @Override // eo.l
    @os.l
    public eo.e c0() {
        eo.e eVarB = b();
        if (eVarB == null) {
            B(16);
        }
        return eVarB;
    }

    @Override // ho.p, eo.y, eo.b, eo.a
    @os.l
    public Collection<? extends eo.y> d() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            B(19);
        }
        return setEmptySet;
    }

    @os.m
    public w0 e1() {
        eo.e eVarB = b();
        if (!eVarB.l()) {
            return null;
        }
        eo.m mVarB = eVarB.b();
        if (mVarB instanceof eo.e) {
            return ((eo.e) mVarB).D0();
        }
        return null;
    }

    @Override // ho.p, eo.b
    @os.l
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public eo.d h0(eo.m mVar, eo.e0 e0Var, eo.u uVar, eo.b.a aVar, boolean z10) {
        eo.d dVar = (eo.d) super.h0(mVar, e0Var, uVar, aVar, z10);
        if (dVar == null) {
            B(25);
        }
        return dVar;
    }

    @Override // ho.p
    @os.l
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public f F0(@os.l eo.m mVar, @os.m eo.y yVar, @os.l eo.b.a aVar, @os.m dp.f fVar, @os.l fo.g gVar, @os.l z0 z0Var) {
        if (mVar == null) {
            B(21);
        }
        if (aVar == null) {
            B(22);
        }
        if (gVar == null) {
            B(23);
        }
        if (z0Var == null) {
            B(24);
        }
        eo.b.a aVar2 = eo.b.a.DECLARATION;
        if (aVar == aVar2 || aVar == eo.b.a.SYNTHESIZED) {
            return new f((eo.e) mVar, this, gVar, this.V, aVar2, z0Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + mVar + "\nkind: " + aVar);
    }

    @Override // ho.k, eo.m
    @os.l
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public eo.e b() {
        eo.e eVar = (eo.e) super.b();
        if (eVar == null) {
            B(15);
        }
        return eVar;
    }

    public f j1(@os.l List<h1> list, @os.l eo.u uVar) {
        if (list == null) {
            B(13);
        }
        if (uVar == null) {
            B(14);
        }
        k1(list, uVar, b().r());
        return this;
    }

    public f k1(@os.l List<h1> list, @os.l eo.u uVar, @os.l List<e1> list2) {
        if (list == null) {
            B(10);
        }
        if (uVar == null) {
            B(11);
        }
        if (list2 == null) {
            B(12);
        }
        super.L0(null, e1(), list2, list, null, eo.e0.FINAL, uVar);
        return this;
    }

    @Override // ho.p, eo.b
    public void z0(@os.l Collection<? extends eo.b> collection) {
        if (collection == null) {
            B(20);
        }
    }

    @Override // ho.p, eo.y, eo.b1
    @os.m
    public eo.d c(@os.l vp.h1 h1Var) {
        if (h1Var == null) {
            B(18);
        }
        return (eo.d) super.c(h1Var);
    }

    @Override // ho.p, ho.k
    @os.l
    public eo.d a() {
        eo.d dVar = (eo.d) super.a();
        if (dVar == null) {
            B(17);
        }
        return dVar;
    }
}
