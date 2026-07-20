package o5;

/* JADX INFO: loaded from: classes2.dex */
public class l extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f12102b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f12103a = new l(new k());
    }

    public static l e() {
        return a.f12103a;
    }

    @Override // o5.i
    public void a(String str) {
        this.f12102b.a(str);
    }

    @Override // o5.i
    public void b(String str) {
        this.f12102b.b(str);
    }

    @Override // o5.i
    public boolean c(String str) {
        return this.f12102b.c(str);
    }

    @Override // o5.i
    public void d() {
        this.f12102b.d();
    }

    public l(i iVar) {
        this.f12102b = iVar;
    }
}
