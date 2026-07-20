package v4;

/* JADX INFO: loaded from: classes.dex */
public final enum b0 extends d0 {
    public b0(String str, int i8) {
        super(str, i8, null);
    }

    @Override // v4.d0
    public u serialize(Long l4) {
        return l4 == null ? w.INSTANCE : new z(l4);
    }
}
