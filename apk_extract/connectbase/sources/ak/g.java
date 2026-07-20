package ak;

import c1.g0;
import c1.h0;
import c1.z;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import q1.s1;
import vj.a3;
import vj.v1;
import vj.w1;
import vj.y2;
import vj.z2;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f260a = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1.e
    public static boolean f261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vj.e.c<EnumC0004g> f262c;

    public static final class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BlockingQueue<Object> f263a = new ArrayBlockingQueue(3);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e<T> f264b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vj.k<?, T> f265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f266d;

        public final class a extends e<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f267a = false;

            public a() {
            }

            @Override // vj.k.a
            public void a(y2 y2Var, v1 v1Var) {
                h0.h0(!this.f267a, "ClientCall already closed");
                if (y2Var.r()) {
                    b bVar = b.this;
                    bVar.f263a.add(bVar);
                } else {
                    b.this.f263a.add(new a3(y2Var, v1Var));
                }
                this.f267a = true;
            }

            @Override // vj.k.a
            public void b(v1 v1Var) {
            }

            @Override // vj.k.a
            public void c(T t10) {
                h0.h0(!this.f267a, "ClientCall already closed");
                b.this.f263a.add(t10);
            }

            @Override // ak.g.e
            public void e() {
                b.this.f265c.e(1);
            }
        }

        public b(vj.k<?, T> kVar) {
            this.f265c = kVar;
        }

        public e<T> c() {
            return this.f264b;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0022  */
        public final Object d() throws Throwable {
            Object objTake;
            boolean z10 = false;
            while (true) {
                try {
                    objTake = this.f263a.take();
                    break;
                } catch (InterruptedException e10) {
                    try {
                        this.f265c.a("Thread interrupted", e10);
                        z10 = true;
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = true;
                        if (z10) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            return objTake;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Object obj;
            while (true) {
                obj = this.f266d;
                if (obj != null) {
                    break;
                }
                this.f266d = d();
            }
            if (!(obj instanceof a3)) {
                return obj != this;
            }
            a3 a3Var = (a3) obj;
            y2 status = a3Var.getStatus();
            v1 trailers = a3Var.getTrailers();
            status.getClass();
            throw new a3(status, trailers);
        }

        @Override // java.util.Iterator
        public T next() {
            Object obj = this.f266d;
            if (!(obj instanceof a3) && obj != this) {
                this.f265c.e(1);
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t10 = (T) this.f266d;
            this.f266d = null;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class c<ReqT> extends ak.f<ReqT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.k<ReqT, ?> f270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f273e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f274f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f275g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f276h = false;

        public c(vj.k<ReqT, ?> kVar, boolean z10) {
            this.f270b = kVar;
            this.f271c = z10;
        }

        public static void k(c cVar) {
            cVar.f269a = true;
        }

        @Override // ak.m
        public void b() {
            this.f270b.c();
            this.f276h = true;
        }

        @Override // ak.m
        public void c(ReqT reqt) {
            h0.h0(!this.f275g, "Stream was terminated by error, no further calls are allowed");
            h0.h0(!this.f276h, "Stream is already completed, no further calls are allowed");
            this.f270b.f(reqt);
        }

        @Override // ak.e
        public void d() {
            j(1);
        }

        @Override // ak.f, ak.e
        public boolean e() {
            return this.f270b.d();
        }

        @Override // ak.f, ak.e
        public void f(int i10) {
            if (this.f271c || i10 != 1) {
                this.f270b.e(i10);
            } else {
                this.f270b.e(2);
            }
        }

        @Override // ak.f, ak.e
        public void g(boolean z10) {
            this.f270b.g(z10);
        }

        @Override // ak.f, ak.e
        public void h(Runnable runnable) {
            if (this.f269a) {
                throw new IllegalStateException("Cannot alter onReadyHandler after call started. Use ClientResponseObserver");
            }
            this.f272d = runnable;
        }

        @Override // ak.f
        public void i(@gm.j String str, @gm.j Throwable th2) {
            this.f270b.a(str, th2);
        }

        @Override // ak.f
        public void j(int i10) {
            if (this.f269a) {
                throw new IllegalStateException("Cannot disable auto flow control after call started. Use ClientResponseObserver");
            }
            h0.e(i10 >= 0, "Initial requests must be non-negative");
            this.f273e = i10;
            this.f274f = false;
        }

        @Override // ak.m
        public void onError(Throwable th2) {
            this.f270b.a("Cancelled by client with StreamObserver.onError()", th2);
            this.f275g = true;
        }

        public final void p() {
            this.f269a = true;
        }
    }

    public static final class d<RespT> extends q1.f<RespT> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final vj.k<?, RespT> f277n;

        public d(vj.k<?, RespT> kVar) {
            this.f277n = kVar;
        }

        @Override // q1.f
        public boolean B(@gm.j RespT respt) {
            return super.B(respt);
        }

        @Override // q1.f
        public boolean C(Throwable th2) {
            return super.C(th2);
        }

        @Override // q1.f
        public void w() {
            this.f277n.a("GrpcFuture was cancelled", null);
        }

        @Override // q1.f
        public String y() {
            return z.c(this).j("clientCall", this.f277n).toString();
        }
    }

    public static abstract class e<T> extends vj.k.a<T> {
        public e() {
        }

        public abstract void e();

        public e(a aVar) {
        }
    }

    public static final class f<ReqT, RespT> extends e<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m<RespT> f278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c<ReqT> f279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f280c;

        public f(m<RespT> mVar, c<ReqT> cVar) {
            this.f278a = mVar;
            this.f279b = cVar;
            if (mVar instanceof ak.h) {
                ((ak.h) mVar).a(cVar);
            }
            cVar.f269a = true;
        }

        @Override // vj.k.a
        public void a(y2 y2Var, v1 v1Var) {
            if (y2Var.r()) {
                this.f278a.b();
            } else {
                this.f278a.onError(new a3(y2Var, v1Var));
            }
        }

        @Override // vj.k.a
        public void b(v1 v1Var) {
        }

        @Override // vj.k.a
        public void c(RespT respt) {
            if (this.f280c && !this.f279b.f271c) {
                y2 y2VarU = y2.f17562s.u("More than one responses received for unary or client-streaming call");
                y2VarU.getClass();
                throw new a3(y2VarU);
            }
            this.f280c = true;
            this.f278a.c(respt);
            c<ReqT> cVar = this.f279b;
            if (cVar.f271c && cVar.f274f) {
                cVar.f(1);
            }
        }

        @Override // vj.k.a
        public void d() {
            Runnable runnable = this.f279b.f272d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // ak.g.e
        public void e() {
            c<ReqT> cVar = this.f279b;
            int i10 = cVar.f273e;
            if (i10 > 0) {
                cVar.f(i10);
            }
        }
    }

    /* JADX INFO: renamed from: ak.g$g, reason: collision with other inner class name */
    public enum EnumC0004g {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    public static final class h extends ConcurrentLinkedQueue<Runnable> implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Logger f282a = Logger.getLogger(h.class.getName());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Object f283b = new Object();
        private volatile Object waiter;

        public static void a(Runnable runnable) {
            try {
                runnable.run();
            } catch (Throwable th2) {
                f282a.log(Level.WARNING, "Runnable threw exception", th2);
            }
        }

        public static void b() throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            add(runnable);
            Object obj = this.waiter;
            if (obj != f283b) {
                LockSupport.unpark((Thread) obj);
            } else if (remove(runnable) && g.f261b) {
                throw new RejectedExecutionException();
            }
        }

        public void shutdown() {
            this.waiter = f283b;
            while (true) {
                Runnable runnablePoll = poll();
                if (runnablePoll == null) {
                    return;
                } else {
                    a(runnablePoll);
                }
            }
        }

        public void waitAndDrain() throws InterruptedException {
            Runnable runnablePoll;
            b();
            Runnable runnablePoll2 = poll();
            if (runnablePoll2 == null) {
                this.waiter = Thread.currentThread();
                while (true) {
                    try {
                        runnablePoll = poll();
                        if (runnablePoll != null) {
                            break;
                        }
                        LockSupport.park(this);
                        b();
                    } catch (Throwable th2) {
                        this.waiter = null;
                        throw th2;
                    }
                }
                this.waiter = null;
                runnablePoll2 = runnablePoll;
            }
            do {
                a(runnablePoll2);
                runnablePoll2 = poll();
            } while (runnablePoll2 != null);
        }
    }

    public static final class i<RespT> extends e<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<RespT> f284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RespT f285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f286c = false;

        public i(d<RespT> dVar) {
            this.f284a = dVar;
        }

        @Override // vj.k.a
        public void a(y2 y2Var, v1 v1Var) {
            if (!y2Var.r()) {
                this.f284a.C(new a3(y2Var, v1Var));
                return;
            }
            if (!this.f286c) {
                d<RespT> dVar = this.f284a;
                y2 y2VarU = y2.f17562s.u("No value received for unary call");
                y2VarU.getClass();
                dVar.C(new a3(y2VarU, v1Var));
            }
            this.f284a.B(this.f285b);
        }

        @Override // vj.k.a
        public void b(v1 v1Var) {
        }

        @Override // vj.k.a
        public void c(RespT respt) {
            if (this.f286c) {
                y2 y2VarU = y2.f17562s.u("More than one value received for unary call");
                y2VarU.getClass();
                throw new a3(y2VarU);
            }
            this.f285b = respt;
            this.f286c = true;
        }

        @Override // ak.g.e
        public void e() {
            this.f284a.f277n.e(2);
        }
    }

    static {
        f261b = !g0.j(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f262c = vj.e.c.b("internal-stub-type");
    }

    public static <ReqT, RespT> m<ReqT> a(vj.k<ReqT, RespT> kVar, m<RespT> mVar) {
        h0.F(mVar, "responseObserver");
        return d(kVar, mVar, true);
    }

    public static <ReqT, RespT> m<ReqT> b(vj.k<ReqT, RespT> kVar, m<RespT> mVar) {
        h0.F(mVar, "responseObserver");
        return d(kVar, mVar, false);
    }

    public static <ReqT, RespT> void c(vj.k<ReqT, RespT> kVar, ReqT reqt, m<RespT> mVar) {
        h0.F(mVar, "responseObserver");
        g(kVar, reqt, mVar, true);
    }

    public static <ReqT, RespT> m<ReqT> d(vj.k<ReqT, RespT> kVar, m<RespT> mVar, boolean z10) {
        c cVar = new c(kVar, z10);
        o(kVar, new f(mVar, cVar));
        return cVar;
    }

    public static <ReqT, RespT> void e(vj.k<ReqT, RespT> kVar, ReqT reqt, m<RespT> mVar) {
        h0.F(mVar, "responseObserver");
        g(kVar, reqt, mVar, false);
    }

    public static <ReqT, RespT> void f(vj.k<ReqT, RespT> kVar, ReqT reqt, e<RespT> eVar) {
        o(kVar, eVar);
        try {
            kVar.f(reqt);
            kVar.c();
        } catch (Error | RuntimeException e10) {
            throw l(kVar, e10);
        }
    }

    public static <ReqT, RespT> void g(vj.k<ReqT, RespT> kVar, ReqT reqt, m<RespT> mVar, boolean z10) {
        f(kVar, reqt, new f(mVar, new c(kVar, z10)));
    }

    public static <ReqT, RespT> Iterator<RespT> h(vj.f fVar, w1<ReqT, RespT> w1Var, vj.e eVar, ReqT reqt) {
        vj.k kVarG = fVar.g(w1Var, eVar.x(f262c, EnumC0004g.BLOCKING));
        b bVar = new b(kVarG);
        f(kVarG, reqt, bVar.f264b);
        return bVar;
    }

    public static <ReqT, RespT> Iterator<RespT> i(vj.k<ReqT, RespT> kVar, ReqT reqt) {
        b bVar = new b(kVar);
        f(kVar, reqt, bVar.f264b);
        return bVar;
    }

    public static <ReqT, RespT> RespT j(vj.f fVar, w1<ReqT, RespT> w1Var, vj.e eVar, ReqT reqt) throws Throwable {
        h hVar = new h();
        vj.k kVarG = fVar.g(w1Var, eVar.x(f262c, EnumC0004g.BLOCKING).t(hVar));
        boolean z10 = false;
        try {
            try {
                s1 s1VarM = m(kVarG, reqt);
                while (!s1VarM.isDone()) {
                    try {
                        hVar.waitAndDrain();
                    } catch (InterruptedException e10) {
                        try {
                            kVarG.a("Thread interrupted", e10);
                            z10 = true;
                        } catch (Error | RuntimeException e11) {
                            e = e11;
                            throw l(kVarG, e);
                        } catch (Throwable th2) {
                            th = th2;
                            z10 = true;
                            if (z10) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                hVar.shutdown();
                RespT respt = (RespT) n(s1VarM);
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                return respt;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Error | RuntimeException e12) {
            e = e12;
        }
    }

    public static <ReqT, RespT> RespT k(vj.k<ReqT, RespT> kVar, ReqT reqt) {
        try {
            return (RespT) n(m(kVar, reqt));
        } catch (Error | RuntimeException e10) {
            throw l(kVar, e10);
        }
    }

    public static RuntimeException l(vj.k<?, ?> kVar, Throwable th2) {
        try {
            kVar.a(null, th2);
        } catch (Error | RuntimeException e10) {
            f260a.log(Level.SEVERE, "RuntimeException encountered while closing call", e10);
        }
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        }
        throw new AssertionError(th2);
    }

    public static <ReqT, RespT> s1<RespT> m(vj.k<ReqT, RespT> kVar, ReqT reqt) {
        d dVar = new d(kVar);
        f(kVar, reqt, new i(dVar));
        return dVar;
    }

    public static <V> V n(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            y2 y2VarT = y2.f17549f.u("Thread interrupted").t(e10);
            y2VarT.getClass();
            throw new a3(y2VarT);
        } catch (ExecutionException e11) {
            throw p(e11.getCause());
        }
    }

    public static <ReqT, RespT> void o(vj.k<ReqT, RespT> kVar, e<RespT> eVar) {
        kVar.h(eVar, new v1());
        eVar.e();
    }

    public static a3 p(Throwable th2) {
        for (Throwable cause = (Throwable) h0.F(th2, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof z2) {
                z2 z2Var = (z2) cause;
                return new a3(z2Var.getStatus(), z2Var.getTrailers());
            }
            if (cause instanceof a3) {
                a3 a3Var = (a3) cause;
                return new a3(a3Var.getStatus(), a3Var.getTrailers());
            }
        }
        y2 y2VarT = y2.f17550g.u("unexpected exception").t(th2);
        y2VarT.getClass();
        return new a3(y2VarT);
    }
}
