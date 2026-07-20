package ho;

import eo.z0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final eo.m f7346g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z0 f7347i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7348n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@os.l up.n nVar, @os.l eo.m mVar, @os.l dp.f fVar, @os.l z0 z0Var, boolean z10) {
        super(nVar, fVar);
        if (nVar == null) {
            f0(0);
        }
        if (mVar == null) {
            f0(1);
        }
        if (fVar == null) {
            f0(2);
        }
        if (z0Var == null) {
            f0(3);
        }
        this.f7346g = mVar;
        this.f7347i = z0Var;
        this.f7348n = z10;
    }

    private static /* synthetic */ void f0(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        if (i10 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = "source";
        } else if (i10 == 4 || i10 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i10 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i10 != 4 && i10 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // eo.e, eo.n, eo.m
    @os.l
    public eo.m b() {
        eo.m mVar = this.f7346g;
        if (mVar == null) {
            f0(4);
        }
        return mVar;
    }

    @Override // eo.p
    @os.l
    public z0 getSource() {
        z0 z0Var = this.f7347i;
        if (z0Var == null) {
            f0(5);
        }
        return z0Var;
    }

    public boolean isExternal() {
        return this.f7348n;
    }
}
