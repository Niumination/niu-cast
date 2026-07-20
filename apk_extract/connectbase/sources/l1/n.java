package l1;

import c1.t0;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class n implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f9605d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b1.e
    public final c f9606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<Closeable> f9607b = new ArrayDeque(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.a
    public Throwable f9608c;

    @b1.e
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9609a = new a();

        @Override // l1.n.c
        public void a(Closeable closeable, Throwable thrown, Throwable suppressed) {
            m.f9603a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, suppressed);
        }
    }

    @b1.e
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f9610a;

        public b(Method addSuppressed) {
            this.f9610a = addSuppressed;
        }

        @gm.a
        public static b b() {
            try {
                return new b(Throwable.class.getMethod("addSuppressed", Throwable.class));
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // l1.n.c
        public void a(Closeable closeable, Throwable thrown, Throwable suppressed) {
            if (thrown == suppressed) {
                return;
            }
            try {
                this.f9610a.invoke(thrown, suppressed);
            } catch (Throwable unused) {
                a.f9609a.a(closeable, thrown, suppressed);
            }
        }
    }

    @b1.e
    public interface c {
        void a(Closeable closeable, Throwable thrown, Throwable suppressed);
    }

    static {
        c cVarB = b.b();
        if (cVarB == null) {
            cVarB = a.f9609a;
        }
        f9605d = cVarB;
    }

    @b1.e
    public n(c suppressor) {
        suppressor.getClass();
        this.f9606a = suppressor;
    }

    public static n b() {
        return new n(f9605d);
    }

    @e0
    @t1.a
    public <C extends Closeable> C c(@e0 C closeable) {
        if (closeable != null) {
            this.f9607b.addFirst(closeable);
        }
        return closeable;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th2 = this.f9608c;
        while (!this.f9607b.isEmpty()) {
            Closeable closeableRemoveFirst = this.f9607b.removeFirst();
            try {
                closeableRemoveFirst.close();
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    this.f9606a.a(closeableRemoveFirst, th2, th3);
                }
            }
        }
        if (this.f9608c != null || th2 == null) {
            return;
        }
        t0.t(th2, IOException.class);
        throw new AssertionError(th2);
    }

    public RuntimeException d(Throwable e10) throws Throwable {
        e10.getClass();
        this.f9608c = e10;
        t0.t(e10, IOException.class);
        throw new RuntimeException(e10);
    }

    public <X extends Exception> RuntimeException h(Throwable e10, Class<X> declaredType) throws Exception {
        e10.getClass();
        this.f9608c = e10;
        t0.t(e10, IOException.class);
        t0.t(e10, declaredType);
        throw new RuntimeException(e10);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException k(Throwable e10, Class<X1> declaredType1, Class<X2> declaredType2) throws Exception {
        e10.getClass();
        this.f9608c = e10;
        t0.t(e10, IOException.class);
        t0.u(e10, declaredType1, declaredType2);
        throw new RuntimeException(e10);
    }
}
