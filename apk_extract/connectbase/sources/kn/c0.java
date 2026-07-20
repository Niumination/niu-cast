package kn;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
@lm.f1(version = "1.7")
public class c0 extends g0 implements Serializable {
    private final Class funInterface;

    public c0(Class cls) {
        super(1);
        this.funInterface = cls;
    }

    @Override // kn.g0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return this.funInterface.equals(((c0) obj).funInterface);
        }
        return false;
    }

    @Override // kn.g0
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override // kn.g0
    public String toString() {
        return "fun interface ".concat(this.funInterface.getName());
    }

    @Override // kn.g0, kn.q
    public un.i getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
