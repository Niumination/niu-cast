package dr;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f3855c = new l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3856a = "https://ire-oneid.shalltry.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3857b = "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";

    public static l e() {
        return f3855c;
    }

    public String a() {
        return l6.c.d(this.f3856a, true) + "/one/v1/change";
    }

    public void b(boolean z10) {
        this.f3856a = z10 ? "https://oneid-dev-sg.shalltry.com" : "https://ire-oneid.shalltry.com";
        this.f3857b = z10 ? "Xqn2nnO41/L92o1iuXhSLHTbXvY4Z5ZZ62m8mSLA" : "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";
    }

    public String c() {
        return this.f3857b;
    }

    public String d() {
        return this.f3856a;
    }

    public String f() {
        return l6.c.d(this.f3856a, true) + "/one/v1/log";
    }

    public String g() {
        return l6.c.d(this.f3856a, true) + "/one/v1/odid";
    }
}
