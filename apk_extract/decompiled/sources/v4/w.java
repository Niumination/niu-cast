package v4;

/* JADX INFO: loaded from: classes.dex */
public final class w extends u {
    public static final w INSTANCE = new w();

    @Deprecated
    public w() {
    }

    public boolean equals(Object obj) {
        return obj instanceof w;
    }

    public int hashCode() {
        return w.class.hashCode();
    }

    @Override // v4.u
    public w deepCopy() {
        return INSTANCE;
    }
}
