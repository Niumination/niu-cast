package lm;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class t0<A, B> implements Serializable {
    private final A first;
    private final B second;

    public t0(A a10, B b10) {
        this.first = a10;
        this.second = b10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ t0 copy$default(t0 t0Var, Object obj, Object obj2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = t0Var.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = t0Var.second;
        }
        return t0Var.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    @os.l
    public final t0<A, B> copy(A a10, B b10) {
        return new t0<>(a10, b10);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return kn.l0.g(this.first, t0Var.first) && kn.l0.g(this.second, t0Var.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a10 = this.first;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.second;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }

    @os.l
    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
