package ka;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6811d;

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("switch: false");
        String str = c.f6813c;
        o.d.A(sb2, str, "console: true", str, "tag: ");
        sb2.append(this.f6809b ? "null" : this.f6808a);
        sb2.append(str);
        sb2.append("head: ");
        sb2.append(this.f6810c);
        sb2.append(str);
        sb2.append("file: false");
        sb2.append(str);
        sb2.append("dir: ");
        sb2.append((String) null);
        sb2.append(str);
        sb2.append("border: ");
        sb2.append(this.f6811d);
        sb2.append(str);
        sb2.append("consoleFilter: ");
        char[] cArr = c.f6812b;
        sb2.append(cArr[0]);
        sb2.append(str);
        sb2.append("fileFilter: ");
        sb2.append(cArr[0]);
        return sb2.toString();
    }
}
