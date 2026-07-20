package i4;

/* JADX INFO: loaded from: classes.dex */
public final class t extends j0 {
    static final t INSTANCE = new t(t0.of(), 0);
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // i4.j1, i4.a4
    public t0 asMap() {
        return super.asMap();
    }
}
