package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends IllegalArgumentException {

    @os.l
    private final String headerValue;
    private final int position;

    public v0(@os.l String str, int i10) {
        kn.l0.p(str, "headerValue");
        StringBuilder sb2 = new StringBuilder("Header value '");
        sb2.append(str);
        sb2.append("' contains illegal character '");
        sb2.append(str.charAt(i10));
        sb2.append("' (code ");
        super(u.a.a(sb2, str.charAt(i10) & 255, ')'));
        this.headerValue = str;
        this.position = i10;
    }

    @os.l
    public final String getHeaderValue() {
        return this.headerValue;
    }

    public final int getPosition() {
        return this.position;
    }
}
