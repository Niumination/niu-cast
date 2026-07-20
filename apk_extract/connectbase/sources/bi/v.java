package bi;

/* JADX INFO: loaded from: classes2.dex */
public class v implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f904a;

    public v(StringBuilder sb2) {
        this.f904a = sb2;
    }

    @Override // bi.r
    public int a(String str, int i10, int i11) {
        this.f904a.append((CharSequence) str, i10, i11);
        return i11;
    }

    @Override // bi.r
    public int b(String str, int i10, int i11, String str2) {
        this.f904a.append((CharSequence) str, i10, i11);
        this.f904a.append(str2);
        return i11 + 1;
    }

    @Override // bi.r
    public r c(String str) {
        this.f904a.append(str);
        return this;
    }

    public String toString() {
        return this.f904a.toString();
    }
}
