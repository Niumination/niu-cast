package cj;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f1465a;

    public e(d dVar) {
        this.f1465a = dVar;
    }

    public static e a(d dVar) {
        return new e(dVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.f1465a;
        if (dVar != null) {
            if (dVar.d()) {
                if (this.f1465a.b() != null) {
                    this.f1465a.b().b(this.f1465a.a());
                }
            } else if (this.f1465a.b() != null) {
                this.f1465a.b().a(this.f1465a.c());
            }
        }
    }
}
