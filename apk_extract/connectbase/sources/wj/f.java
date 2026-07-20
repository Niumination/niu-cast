package wj;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1.b f18609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wj.g f18610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t1 f18611c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18612a;

        public a(int i10) {
            this.f18612a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f18611c.y()) {
                return;
            }
            try {
                f.this.f18611c.b(this.f18612a);
            } catch (Throwable th2) {
                f.this.f18610b.c(th2);
                f.this.f18611c.close();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2 f18614a;

        public b(i2 i2Var) {
            this.f18614a = i2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f18611c.n(this.f18614a);
            } catch (Throwable th2) {
                f.this.f18610b.c(th2);
                f.this.f18611c.close();
            }
        }
    }

    public class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2 f18616a;

        public c(i2 i2Var) {
            this.f18616a = i2Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18616a.close();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f18611c.p();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f18611c.close();
        }
    }

    /* JADX INFO: renamed from: wj.f$f, reason: collision with other inner class name */
    public class C0476f extends g implements Closeable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Closeable f18620d;

        public C0476f(Runnable runnable, Closeable closeable) {
            super(runnable);
            this.f18620d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f18620d.close();
        }
    }

    public class g implements k3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f18622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18623b;

        public /* synthetic */ g(f fVar, Runnable runnable, a aVar) {
            this(runnable);
        }

        public final void b() {
            if (this.f18623b) {
                return;
            }
            this.f18622a.run();
            this.f18623b = true;
        }

        @Override // wj.k3.a
        @gm.j
        public InputStream next() {
            b();
            return f.this.f18610b.f();
        }

        public g(Runnable runnable) {
            this.f18623b = false;
            this.f18622a = runnable;
        }
    }

    public interface h extends wj.g.d {
    }

    public f(t1.b bVar, h hVar, t1 t1Var) {
        h3 h3Var = new h3((t1.b) c1.h0.F(bVar, "listener"));
        this.f18609a = h3Var;
        wj.g gVar = new wj.g(h3Var, hVar);
        this.f18610b = gVar;
        t1Var.f0(gVar);
        this.f18611c = t1Var;
    }

    @Override // wj.b0
    public void b(int i10) {
        this.f18609a.a(new g(new a(i10)));
    }

    @Override // wj.b0
    public void close() {
        this.f18611c.g0();
        this.f18609a.a(new g(new e()));
    }

    @b1.e
    public t1.b d() {
        return this.f18610b;
    }

    @Override // wj.b0
    public void h(int i10) {
        this.f18611c.h(i10);
    }

    @Override // wj.b0
    public void k(vj.z zVar) {
        this.f18611c.k(zVar);
    }

    @Override // wj.b0
    public void n(i2 i2Var) {
        this.f18609a.a(new C0476f(new b(i2Var), new c(i2Var)));
    }

    @Override // wj.b0
    public void o(w0 w0Var) {
        this.f18611c.o(w0Var);
    }

    @Override // wj.b0
    public void p() {
        this.f18609a.a(new g(new d()));
    }
}
