package vp;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d1 implements c1 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return a() == c1Var.a() && c() == c1Var.c() && getType().equals(c1Var.getType());
    }

    public int hashCode() {
        int iHashCode = c().hashCode();
        if (j1.w(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (a() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (a()) {
            return "*";
        }
        if (c() == o1.INVARIANT) {
            return getType().toString();
        }
        return c() + " " + getType();
    }
}
