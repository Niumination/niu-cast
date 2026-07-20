package bi;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f907b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f908c;

    public x(c cVar) {
        this.f906a = cVar;
    }

    public void a() {
        this.f907b = Math.max(this.f907b - 1, 0);
    }

    public void b(String str) {
        this.f908c = str;
    }

    public c c() {
        return this.f906a;
    }

    public void d() {
        this.f907b++;
    }

    public boolean e() {
        return this.f907b != 0;
    }
}
