package kn;

/* JADX INFO: loaded from: classes3.dex */
public class g0 extends q implements e0, un.i {
    private final int arity;

    @lm.f1(version = "1.4")
    private final int flags;

    public g0(int i10) {
        this(i10, q.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kn.q
    @lm.f1(version = "1.1")
    public un.c computeReflected() {
        return l1.c(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            return getName().equals(g0Var.getName()) && getSignature().equals(g0Var.getSignature()) && this.flags == g0Var.flags && this.arity == g0Var.arity && l0.g(getBoundReceiver(), g0Var.getBoundReceiver()) && l0.g(getOwner(), g0Var.getOwner());
        }
        if (obj instanceof un.i) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kn.e0
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // un.i
    @lm.f1(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // un.i
    @lm.f1(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // un.i
    @lm.f1(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // un.i
    @lm.f1(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kn.q, un.c, un.i
    @lm.f1(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        un.c cVarCompute = compute();
        if (cVarCompute != this) {
            return cVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + l1.f9320b;
    }

    @lm.f1(version = "1.1")
    public g0(int i10, Object obj) {
        this(i10, obj, null, null, null, 0);
    }

    @Override // kn.q
    @lm.f1(version = "1.1")
    public un.i getReflected() {
        return (un.i) super.getReflected();
    }

    @lm.f1(version = "1.4")
    public g0(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }
}
