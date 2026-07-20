package wj;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements t1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f18682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1.b f18683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<InputStream> f18684c = new ArrayDeque();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18685a;

        public a(int i10) {
            this.f18685a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f18683b.b(this.f18685a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18687a;

        public b(boolean z10) {
            this.f18687a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f18683b.e(this.f18687a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f18689a;

        public c(Throwable th2) {
            this.f18689a = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f18683b.c(this.f18689a);
        }
    }

    public interface d {
        void f(Runnable runnable);
    }

    public g(t1.b bVar, d dVar) {
        this.f18683b = (t1.b) c1.h0.F(bVar, "listener");
        this.f18682a = (d) c1.h0.F(dVar, "transportExecutor");
    }

    @Override // wj.t1.b
    public void a(k3.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f18684c.add(next);
            }
        }
    }

    @Override // wj.t1.b
    public void b(int i10) {
        this.f18682a.f(new a(i10));
    }

    @Override // wj.t1.b
    public void c(Throwable th2) {
        this.f18682a.f(new c(th2));
    }

    @Override // wj.t1.b
    public void e(boolean z10) {
        this.f18682a.f(new b(z10));
    }

    public InputStream f() {
        return this.f18684c.poll();
    }
}
