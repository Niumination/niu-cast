package ho;

import eo.z0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 extends m0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ boolean f7394n = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7395g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public up.j<jp.g<?>> f7396i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(@os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.m vp.f0 f0Var, boolean z10, @os.l z0 z0Var) {
        super(mVar, gVar, fVar, f0Var, z0Var);
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
        this.f7395g = z10;
    }

    private static /* synthetic */ void B(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "annotations";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = "source";
        } else if (i10 != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i10 != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void F0(@os.l up.j<jp.g<?>> jVar) {
        if (jVar == null) {
            B(4);
        }
        this.f7396i = jVar;
    }

    @Override // eo.j1
    public boolean Q() {
        return this.f7395g;
    }

    @Override // eo.j1
    @os.m
    public jp.g<?> m0() {
        up.j<jp.g<?>> jVar = this.f7396i;
        if (jVar != null) {
            return jVar.invoke();
        }
        return null;
    }
}
