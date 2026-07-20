package ho;

import eo.z0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends j implements eo.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final eo.m f7361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final z0 f7362d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.l z0 z0Var) {
        super(gVar, fVar);
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
        this.f7361c = mVar;
        this.f7362d = z0Var;
    }

    private static /* synthetic */ void B(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6) ? 2 : 3];
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
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getOriginal";
        } else if (i10 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i10 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @os.l
    public eo.m b() {
        eo.m mVar = this.f7361c;
        if (mVar == null) {
            B(5);
        }
        return mVar;
    }

    @Override // ho.j, eo.m
    @os.l
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public eo.p a() {
        return this;
    }

    @Override // eo.p
    @os.l
    public z0 getSource() {
        z0 z0Var = this.f7362d;
        if (z0Var == null) {
            B(6);
        }
        return z0Var;
    }
}
