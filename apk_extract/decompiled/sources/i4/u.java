package i4;

/* JADX INFO: loaded from: classes.dex */
public final class u extends w1 {
    static final u INSTANCE = new u(t0.of(), 0, null);
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // i4.j1, i4.a4
    public t0 asMap() {
        return super.asMap();
    }
}
