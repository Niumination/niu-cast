package v1;

/* JADX INFO: loaded from: classes.dex */
public final class m extends k {
    public static final m INSTANCE = new m();

    @Deprecated
    public m() {
    }

    public boolean equals(Object obj) {
        return obj instanceof m;
    }

    public int hashCode() {
        return m.class.hashCode();
    }

    @Override // v1.k
    public m deepCopy() {
        return INSTANCE;
    }
}
