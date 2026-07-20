package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j1 extends q implements un.o {
    private final boolean syntheticJavaProperty;

    public j1() {
        this.syntheticJavaProperty = false;
    }

    @Override // kn.q
    public un.c compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j1) {
            j1 j1Var = (j1) obj;
            return getOwner().equals(j1Var.getOwner()) && getName().equals(j1Var.getName()) && getSignature().equals(j1Var.getSignature()) && l0.g(getBoundReceiver(), j1Var.getBoundReceiver());
        }
        if (obj instanceof un.o) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // un.o
    @lm.f1(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // un.o
    @lm.f1(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        un.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        return "property " + getName() + l1.f9320b;
    }

    @Override // kn.q
    @lm.f1(version = "1.1")
    public un.o getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        return (un.o) super.getReflected();
    }

    @lm.f1(version = "1.1")
    public j1(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    @lm.f1(version = "1.4")
    public j1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.syntheticJavaProperty = (i10 & 2) == 2;
    }
}
