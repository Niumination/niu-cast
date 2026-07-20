package cj;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public aj.b f1458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f1459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public aj.c f1460d;

    public interface a {
        void a(Throwable th2);

        void b(Bitmap bitmap);
    }

    public b(aj.b bVar, T t10, a aVar, aj.c cVar) {
        this.f1458b = bVar;
        this.f1459c = t10;
        this.f1457a = aVar;
        this.f1460d = cVar;
    }

    public abstract Bitmap a(T t10);

    @Override // java.lang.Runnable
    public void run() {
        aj.c cVar;
        e eVar;
        d dVar = new d(this.f1457a);
        try {
            if (this.f1458b == null) {
                dVar.f1461a = false;
                dj.c.b(this.f1460d, "dispatcher == null");
                this.f1460d.a(new e(dVar));
            } else {
                dVar.f1462b = a(this.f1459c);
                dVar.f1461a = true;
                dj.c.b(this.f1460d, "dispatcher == null");
                cVar = this.f1460d;
                eVar = new e(dVar);
                cVar.a(eVar);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                dVar.f1461a = false;
                dVar.f1464d = th2;
                dj.c.b(this.f1460d, "dispatcher == null");
                cVar = this.f1460d;
                eVar = new e(dVar);
            } catch (Throwable th3) {
                dj.c.b(this.f1460d, "dispatcher == null");
                this.f1460d.a(new e(dVar));
                throw th3;
            }
        }
    }
}
