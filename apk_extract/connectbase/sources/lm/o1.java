package lm;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class o1<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public o1(A a10, B b10, C c10) {
        this.first = a10;
        this.second = b10;
        this.third = c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ o1 copy$default(o1 o1Var, Object obj, Object obj2, Object obj3, int i10, Object obj4) {
        if ((i10 & 1) != 0) {
            obj = o1Var.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = o1Var.second;
        }
        if ((i10 & 4) != 0) {
            obj3 = o1Var.third;
        }
        return o1Var.copy(obj, obj2, obj3);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    @os.l
    public final o1<A, B, C> copy(A a10, B b10, C c10) {
        return new o1<>(a10, b10, c10);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return kn.l0.g(this.first, o1Var.first) && kn.l0.g(this.second, o1Var.second) && kn.l0.g(this.third, o1Var.third);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a10 = this.first;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.second;
        int iHashCode2 = (iHashCode + (b10 == null ? 0 : b10.hashCode())) * 31;
        C c10 = this.third;
        return iHashCode2 + (c10 != null ? c10.hashCode() : 0);
    }

    @os.l
    public String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
