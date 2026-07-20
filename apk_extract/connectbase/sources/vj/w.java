package vj;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@h
public class w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f17451e = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f17453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.d<k<?>, Object> f17454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f17450d = Logger.getLogger(w.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f17452f = new w();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f17456a;

        public a(Runnable runnable) {
            this.f17456a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            w wVarC = w.this.c();
            try {
                this.f17456a.run();
            } finally {
                w.this.q(wVarC);
            }
        }
    }

    public final class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f17458a;

        public b(Executor executor) {
            this.f17458a = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f17458a.execute(w.o().J0(runnable));
        }
    }

    public final class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f17459a;

        public c(Executor executor) {
            this.f17459a = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f17459a.execute(w.this.J0(runnable));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [C] */
    public class d<C> implements Callable<C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f17461a;

        public d(Callable callable) {
            this.f17461a = callable;
        }

        @Override // java.util.concurrent.Callable
        public C call() throws Exception {
            w wVarC = w.this.c();
            try {
                return (C) this.f17461a.call();
            } finally {
                w.this.q(wVarC);
            }
        }
    }

    public @interface e {
    }

    public static final class f extends w implements Closeable {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final y f17463g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final w f17464i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ArrayList<j> f17465n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public g f17466p;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Throwable f17467v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ScheduledFuture<?> f17468w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f17469x;

        public class a implements g {
            public a() {
            }

            @Override // vj.w.g
            public void a(w wVar) {
                f.this.U0(wVar.k());
            }
        }

        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    f.this.U0(new TimeoutException("context timed out"));
                } catch (Throwable th2) {
                    w.f17450d.log(Level.SEVERE, "Cancel threw an exception, which should not happen", th2);
                }
            }
        }

        public /* synthetic */ f(w wVar, a aVar) {
            this(wVar);
        }

        @Override // vj.w
        public y A() {
            return this.f17463g;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void B1() {
            synchronized (this) {
                try {
                    ArrayList<j> arrayList = this.f17465n;
                    if (arrayList == null) {
                        return;
                    }
                    g gVar = this.f17466p;
                    this.f17466p = null;
                    this.f17465n = null;
                    for (j jVar : arrayList) {
                        if (jVar.f17475c == this) {
                            jVar.b();
                        }
                    }
                    for (j jVar2 : arrayList) {
                        if (jVar2.f17475c != this) {
                            jVar2.b();
                        }
                    }
                    f fVar = this.f17453a;
                    if (fVar != null) {
                        fVar.D1(gVar, fVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void D1(g gVar, w wVar) {
            synchronized (this) {
                try {
                    ArrayList<j> arrayList = this.f17465n;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            j jVar = this.f17465n.get(size);
                            if (jVar.f17474b == gVar && jVar.f17475c == wVar) {
                                this.f17465n.remove(size);
                                break;
                            }
                        }
                        if (this.f17465n.isEmpty()) {
                            f fVar = this.f17453a;
                            if (fVar != null) {
                                fVar.g0(this.f17466p);
                            }
                            this.f17466p = null;
                            this.f17465n = null;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // vj.w
        public boolean E() {
            synchronized (this) {
                try {
                    if (this.f17469x) {
                        return true;
                    }
                    if (!super.E()) {
                        return false;
                    }
                    U0(super.k());
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void I1(y yVar, ScheduledExecutorService scheduledExecutorService) {
            if (yVar.m()) {
                U0(new TimeoutException("context timed out"));
            } else {
                synchronized (this) {
                    this.f17468w = yVar.p(new b(), scheduledExecutorService);
                }
            }
        }

        @Override // vj.w
        @Deprecated
        public boolean O() {
            return this.f17464i.O();
        }

        public final void T0(j jVar) {
            synchronized (this) {
                try {
                    if (E()) {
                        jVar.b();
                    } else {
                        ArrayList<j> arrayList = this.f17465n;
                        if (arrayList == null) {
                            ArrayList<j> arrayList2 = new ArrayList<>();
                            this.f17465n = arrayList2;
                            arrayList2.add(jVar);
                            if (this.f17453a != null) {
                                a aVar = new a();
                                this.f17466p = aVar;
                                this.f17453a.T0(new j(i.INSTANCE, aVar, this));
                            }
                        } else {
                            arrayList.add(jVar);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @e
        public boolean U0(Throwable th2) {
            ScheduledFuture<?> scheduledFuture;
            boolean z10;
            synchronized (this) {
                try {
                    scheduledFuture = null;
                    if (this.f17469x) {
                        z10 = false;
                    } else {
                        z10 = true;
                        this.f17469x = true;
                        ScheduledFuture<?> scheduledFuture2 = this.f17468w;
                        if (scheduledFuture2 != null) {
                            this.f17468w = null;
                            scheduledFuture = scheduledFuture2;
                        }
                        this.f17467v = th2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (z10) {
                B1();
            }
            return z10;
        }

        @Override // vj.w
        public void b(g gVar, Executor executor) {
            w.n(gVar, "cancellationListener");
            w.n(executor, "executor");
            T0(new j(executor, gVar, this));
        }

        @Override // vj.w
        public w c() {
            return this.f17464i.c();
        }

        public void c1(w wVar, Throwable th2) {
            try {
                q(wVar);
            } finally {
                U0(th2);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            U0(null);
        }

        @Override // vj.w
        public int f0() {
            int size;
            synchronized (this) {
                ArrayList<j> arrayList = this.f17465n;
                size = arrayList == null ? 0 : arrayList.size();
            }
            return size;
        }

        @Override // vj.w
        public void g0(g gVar) {
            D1(gVar, this);
        }

        @Override // vj.w
        public Throwable k() {
            if (E()) {
                return this.f17467v;
            }
            return null;
        }

        @Override // vj.w
        public void q(w wVar) {
            this.f17464i.q(wVar);
        }

        public /* synthetic */ f(w wVar, y yVar, a aVar) {
            this(wVar, yVar);
        }

        public f(w wVar) {
            super(wVar, wVar.f17454b);
            this.f17463g = wVar.A();
            this.f17464i = new w(this, this.f17454b);
        }

        public f(w wVar, y yVar) {
            super(wVar, wVar.f17454b);
            this.f17463g = yVar;
            this.f17464i = new w(this, this.f17454b);
        }
    }

    public interface g {
        void a(w wVar);
    }

    public @interface h {
    }

    public enum i implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f17473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f17474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final w f17475c;

        public j(Executor executor, g gVar, w wVar) {
            this.f17473a = executor;
            this.f17474b = gVar;
            this.f17475c = wVar;
        }

        public void b() {
            try {
                this.f17473a.execute(this);
            } catch (Throwable th2) {
                w.f17450d.log(Level.INFO, "Exception notifying context listener", th2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17474b.a(this.f17475c);
        }
    }

    public static final class k<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f17477b;

        public k(String str) {
            this(str, null);
        }

        public T a() {
            return b(w.o());
        }

        public T b(w wVar) {
            T t10 = (T) e2.a(wVar.f17454b, this);
            return t10 == null ? this.f17477b : t10;
        }

        public String toString() {
            return this.f17476a;
        }

        public k(String str, T t10) {
            this.f17476a = (String) w.n(str, "name");
            this.f17477b = t10;
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f17478a;

        static {
            AtomicReference atomicReference = new AtomicReference();
            f17478a = a(atomicReference);
            Throwable th2 = (Throwable) atomicReference.get();
            if (th2 != null) {
                w.f17450d.log(Level.FINE, "Storage override doesn't exist. Using default", th2);
            }
        }

        public static m a(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (m) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(m.class).getConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e10) {
                atomicReference.set(e10);
                return new d3();
            } catch (Exception e11) {
                throw new RuntimeException("Storage override failed to initialize", e11);
            }
        }
    }

    public static abstract class m {
        public abstract w a();

        public abstract void b(w wVar, w wVar2);

        public abstract w c(w wVar);
    }

    public /* synthetic */ w(w wVar, e2.d dVar, a aVar) {
        this(wVar, (e2.d<k<?>, Object>) dVar);
    }

    public static <T> k<T> b0(String str) {
        return new k<>(str, null);
    }

    public static <T> k<T> e0(String str, T t10) {
        return new k<>(str, t10);
    }

    public static f h(w wVar) {
        return wVar instanceof f ? (f) wVar : wVar.f17453a;
    }

    public static m k0() {
        return l.f17478a;
    }

    public static void l0(int i10) {
        if (i10 == 1000) {
            f17450d.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    @e
    public static <T> T n(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static w o() {
        w wVarA = l.f17478a.a();
        return wVarA == null ? f17452f : wVarA;
    }

    public static Executor p(Executor executor) {
        return new b(executor);
    }

    public y A() {
        f fVar = this.f17453a;
        if (fVar == null) {
            return null;
        }
        return fVar.f17463g;
    }

    public boolean E() {
        f fVar = this.f17453a;
        if (fVar == null) {
            return false;
        }
        return fVar.E();
    }

    public <V1, V2, V3, V4> w F0(k<V1> kVar, V1 v10, k<V2> kVar2, V2 v11, k<V3> kVar3, V3 v12, k<V4> kVar4, V4 v13) {
        return new w(this, (e2.d<k<?>, Object>) e2.b(e2.b(e2.b(e2.b(this.f17454b, kVar, v10), kVar2, v11), kVar3, v12), kVar4, v13));
    }

    public Runnable J0(Runnable runnable) {
        return new a(runnable);
    }

    public boolean O() {
        return o() == this;
    }

    public <C> Callable<C> O0(Callable<C> callable) {
        return new d(callable);
    }

    public void b(g gVar, Executor executor) {
        n(gVar, "cancellationListener");
        n(executor, "executor");
        f fVar = this.f17453a;
        if (fVar == null) {
            return;
        }
        fVar.T0(new j(executor, gVar, this));
    }

    public w c() {
        w wVarC = l.f17478a.c(this);
        return wVarC == null ? f17452f : wVarC;
    }

    @e
    public <V> V d(Callable<V> callable) throws Exception {
        w wVarC = c();
        try {
            return callable.call();
        } finally {
            q(wVarC);
        }
    }

    public int f0() {
        f fVar = this.f17453a;
        if (fVar == null) {
            return 0;
        }
        return fVar.f0();
    }

    public void g0(g gVar) {
        f fVar = this.f17453a;
        if (fVar == null) {
            return;
        }
        fVar.D1(gVar, this);
    }

    public void j0(Runnable runnable) {
        w wVarC = c();
        try {
            runnable.run();
        } finally {
            q(wVarC);
        }
    }

    public Throwable k() {
        f fVar = this.f17453a;
        if (fVar == null) {
            return null;
        }
        return fVar.k();
    }

    public f p0() {
        return new f(this);
    }

    public void q(w wVar) {
        n(wVar, "toAttach");
        l.f17478a.b(this, wVar);
    }

    public f q0(y yVar, ScheduledExecutorService scheduledExecutorService) {
        boolean z10;
        n(yVar, "deadline");
        n(scheduledExecutorService, "scheduler");
        y yVarA = A();
        if (yVarA == null || yVarA.compareTo(yVar) > 0) {
            z10 = true;
        } else {
            z10 = false;
            yVar = yVarA;
        }
        f fVar = new f(this, yVar);
        if (z10) {
            fVar.I1(yVar, scheduledExecutorService);
        }
        return fVar;
    }

    public Executor t(Executor executor) {
        return new c(executor);
    }

    public f u0(long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return q0(y.a(j10, timeUnit), scheduledExecutorService);
    }

    public <V> w v0(k<V> kVar, V v10) {
        return new w(this, (e2.d<k<?>, Object>) e2.b(this.f17454b, kVar, v10));
    }

    public <V1, V2> w w0(k<V1> kVar, V1 v10, k<V2> kVar2, V2 v11) {
        return new w(this, (e2.d<k<?>, Object>) e2.b(e2.b(this.f17454b, kVar, v10), kVar2, v11));
    }

    public w y() {
        return new w(this.f17454b, this.f17455c + 1);
    }

    public <V1, V2, V3> w y0(k<V1> kVar, V1 v10, k<V2> kVar2, V2 v11, k<V3> kVar3, V3 v12) {
        return new w(this, (e2.d<k<?>, Object>) e2.b(e2.b(e2.b(this.f17454b, kVar, v10), kVar2, v11), kVar3, v12));
    }

    public w(e2.d<k<?>, Object> dVar, int i10) {
        this.f17453a = null;
        this.f17454b = dVar;
        this.f17455c = i10;
        l0(i10);
    }

    public w(w wVar, e2.d<k<?>, Object> dVar) {
        this.f17453a = h(wVar);
        this.f17454b = dVar;
        int i10 = wVar.f17455c + 1;
        this.f17455c = i10;
        l0(i10);
    }

    public w() {
        this.f17453a = null;
        this.f17454b = null;
        this.f17455c = 0;
        l0(0);
    }
}
