package fk;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends l {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;

    public s(int i8) {
        this.limit = i8;
    }

    @Override // fk.l
    public void truncate() {
        if (this.size > this.limit) {
            removeFirst();
        }
    }
}
