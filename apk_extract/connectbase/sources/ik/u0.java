package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends IllegalArgumentException {

    @os.l
    private final String headerName;
    private final int position;

    public u0(@os.l String str, int i10) {
        kn.l0.p(str, "headerName");
        StringBuilder sb2 = new StringBuilder("Header name '");
        sb2.append(str);
        sb2.append("' contains illegal character '");
        sb2.append(str.charAt(i10));
        sb2.append("' (code ");
        super(u.a.a(sb2, str.charAt(i10) & 255, ')'));
        this.headerName = str;
        this.position = i10;
    }

    @os.l
    public final String getHeaderName() {
        return this.headerName;
    }

    public final int getPosition() {
        return this.position;
    }
}
