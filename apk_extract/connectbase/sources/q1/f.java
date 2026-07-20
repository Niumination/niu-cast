package q1;

import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class f<V> extends r1.a implements s1<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f13421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f13422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f13423f = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f13424g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f13425i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    public volatile Object f13426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public volatile e f13427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.a
    public volatile l f13428c;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(f<?> future, @gm.a e expect, e update);

        public abstract boolean b(f<?> future, @gm.a Object expect, Object update);

        public abstract boolean c(f<?> future, @gm.a l expect, @gm.a l update);

        public abstract e d(f<?> future, e update);

        public abstract l e(f<?> future, l update);

        public abstract void f(l waiter, @gm.a l newValue);

        public abstract void g(l waiter, Thread newValue);

        public b(a aVar) {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public static final c f13429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public static final c f13430d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f13431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public final Throwable f13432b;

        static {
            if (f.f13421d) {
                f13430d = null;
                f13429c = null;
            } else {
                f13430d = new c(false, null);
                f13429c = new c(true, null);
            }
        }

        public c(boolean wasInterrupted, @gm.a Throwable cause) {
            this.f13431a = wasInterrupted;
            this.f13432b = cause;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f13433b = new d(new a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f13434a;

        public class a extends Throwable {
            public a(String message) {
                super(message);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable exception) {
            exception.getClass();
            this.f13434a = exception;
        }
    }

    /* JADX INFO: renamed from: q1.f$f, reason: collision with other inner class name */
    public static final class C0337f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<l, Thread> f13439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<l, l> f13440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<f, l> f13441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<f, e> f13442d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<f, Object> f13443e;

        public C0337f(AtomicReferenceFieldUpdater<l, Thread> waiterThreadUpdater, AtomicReferenceFieldUpdater<l, l> waiterNextUpdater, AtomicReferenceFieldUpdater<f, l> waitersUpdater, AtomicReferenceFieldUpdater<f, e> listenersUpdater, AtomicReferenceFieldUpdater<f, Object> valueUpdater) {
            this.f13439a = waiterThreadUpdater;
            this.f13440b = waiterNextUpdater;
            this.f13441c = waitersUpdater;
            this.f13442d = listenersUpdater;
            this.f13443e = valueUpdater;
        }

        @Override // q1.f.b
        public boolean a(f<?> future, @gm.a e expect, e update) {
            return j.d.a(this.f13442d, future, expect, update);
        }

        @Override // q1.f.b
        public boolean b(f<?> future, @gm.a Object expect, Object update) {
            return j.d.a(this.f13443e, future, expect, update);
        }

        @Override // q1.f.b
        public boolean c(f<?> future, @gm.a l expect, @gm.a l update) {
            return j.d.a(this.f13441c, future, expect, update);
        }

        @Override // q1.f.b
        public e d(f<?> future, e update) {
            return this.f13442d.getAndSet(future, update);
        }

        @Override // q1.f.b
        public l e(f<?> future, l update) {
            return this.f13441c.getAndSet(future, update);
        }

        @Override // q1.f.b
        public void f(l waiter, @gm.a l newValue) {
            this.f13440b.lazySet(waiter, newValue);
        }

        @Override // q1.f.b
        public void g(l waiter, Thread newValue) {
            this.f13439a.lazySet(waiter, newValue);
        }
    }

    public static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<V> f13444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s1<? extends V> f13445b;

        public g(f<V> owner, s1<? extends V> future) {
            this.f13444a = owner;
            this.f13445b = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13444a.f13426a != this) {
                return;
            }
            if (f.f13424g.b(this.f13444a, this, f.u(this.f13445b))) {
                f.r(this.f13444a, false);
            }
        }
    }

    public static final class h extends b {
        public h() {
        }

        @Override // q1.f.b
        public boolean a(f<?> future, @gm.a e expect, e update) {
            synchronized (future) {
                try {
                    if (future.f13427b != expect) {
                        return false;
                    }
                    future.f13427b = update;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // q1.f.b
        public boolean b(f<?> future, @gm.a Object expect, Object update) {
            synchronized (future) {
                try {
                    if (future.f13426a != expect) {
                        return false;
                    }
                    future.f13426a = update;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // q1.f.b
        public boolean c(f<?> future, @gm.a l expect, @gm.a l update) {
            synchronized (future) {
                try {
                    if (future.f13428c != expect) {
                        return false;
                    }
                    future.f13428c = update;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // q1.f.b
        public e d(f<?> future, e update) {
            e eVar;
            synchronized (future) {
                eVar = future.f13427b;
                if (eVar != update) {
                    future.f13427b = update;
                }
            }
            return eVar;
        }

        @Override // q1.f.b
        public l e(f<?> future, l update) {
            l lVar;
            synchronized (future) {
                lVar = future.f13428c;
                if (lVar != update) {
                    future.f13428c = update;
                }
            }
            return lVar;
        }

        @Override // q1.f.b
        public void f(l waiter, @gm.a l newValue) {
            waiter.f13454b = newValue;
        }

        @Override // q1.f.b
        public void g(l waiter, Thread newValue) {
            waiter.f13453a = newValue;
        }

        public h(a aVar) {
        }
    }

    public interface i<V> extends s1<V> {
    }

    public static abstract class j<V> extends f<V> implements i<V> {
        @Override // q1.f, q1.s1
        public final void addListener(Runnable listener, Executor executor) {
            super.addListener(listener, executor);
        }

        @Override // q1.f, java.util.concurrent.Future
        @t1.a
        public boolean cancel(boolean mayInterruptIfRunning) {
            return super.cancel(mayInterruptIfRunning);
        }

        @Override // q1.f, java.util.concurrent.Future
        @t1.a
        @c2
        public V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // q1.f, java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f13426a instanceof c;
        }

        @Override // q1.f, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // q1.f, java.util.concurrent.Future
        @t1.a
        @c2
        public final V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j10, timeUnit);
        }
    }

    public static final class k extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Unsafe f13446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final long f13447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f13448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f13449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f13450e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f13451f;

        public class a implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                f13448c = unsafe.objectFieldOffset(f.class.getDeclaredField("c"));
                f13447b = unsafe.objectFieldOffset(f.class.getDeclaredField("b"));
                f13449d = unsafe.objectFieldOffset(f.class.getDeclaredField("a"));
                f13450e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                f13451f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                f13446a = unsafe;
            } catch (NoSuchFieldException e11) {
                throw new RuntimeException(e11);
            } catch (RuntimeException e12) {
                throw e12;
            }
        }

        public k() {
        }

        @Override // q1.f.b
        public boolean a(f<?> future, @gm.a e expect, e update) {
            return q1.g.a(f13446a, future, f13447b, expect, update);
        }

        @Override // q1.f.b
        public boolean b(f<?> future, @gm.a Object expect, Object update) {
            return q1.g.a(f13446a, future, f13449d, expect, update);
        }

        @Override // q1.f.b
        public boolean c(f<?> future, @gm.a l expect, @gm.a l update) {
            return q1.g.a(f13446a, future, f13448c, expect, update);
        }

        @Override // q1.f.b
        public e d(f<?> future, e update) {
            e eVar;
            do {
                eVar = future.f13427b;
                if (update == eVar) {
                    return eVar;
                }
            } while (!a(future, eVar, update));
            return eVar;
        }

        @Override // q1.f.b
        public l e(f<?> future, l update) {
            l lVar;
            do {
                lVar = future.f13428c;
                if (update == lVar) {
                    return lVar;
                }
            } while (!c(future, lVar, update));
            return lVar;
        }

        @Override // q1.f.b
        public void f(l waiter, @gm.a l newValue) {
            f13446a.putObject(waiter, f13451f, newValue);
        }

        @Override // q1.f.b
        public void g(l waiter, Thread newValue) {
            f13446a.putObject(waiter, f13450e, newValue);
        }

        public k(a aVar) {
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final l f13452c = new l();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public volatile Thread f13453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public volatile l f13454b;

        public l(boolean unused) {
        }

        public void a(@gm.a l next) {
            f.f13424g.f(this, next);
        }

        public void b() {
            Thread thread = this.f13453a;
            if (thread != null) {
                this.f13453a = null;
                LockSupport.unpark(thread);
            }
        }

        public l() {
            f.f13424g.g(this, Thread.currentThread());
        }
    }

    static {
        boolean z10;
        b hVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f13421d = z10;
        f13422e = Logger.getLogger(f.class.getName());
        Throwable th2 = null;
        try {
            hVar = new k();
            e = null;
        } catch (Error | RuntimeException e10) {
            e = e10;
            try {
                hVar = new C0337f(AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, "b"), AtomicReferenceFieldUpdater.newUpdater(f.class, l.class, "c"), AtomicReferenceFieldUpdater.newUpdater(f.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "a"));
            } catch (Error | RuntimeException e11) {
                th2 = e11;
                hVar = new h();
            }
        }
        f13424g = hVar;
        if (th2 != null) {
            Logger logger = f13422e;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", e);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
        f13425i = new Object();
    }

    public static CancellationException p(String message, @gm.a Throwable cause) {
        CancellationException cancellationException = new CancellationException(message);
        cancellationException.initCause(cause);
        return cancellationException;
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
    public static void r(f<?> fVar, boolean z10) {
        e eVar = null;
        while (true) {
            fVar.z();
            if (z10) {
                fVar.w();
                z10 = false;
            }
            fVar.m();
            e eVarQ = fVar.q(eVar);
            while (eVarQ != null) {
                eVar = eVarQ.f13438c;
                Runnable runnable = eVarQ.f13436a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof g) {
                    g gVar = (g) runnable2;
                    fVar = gVar.f13444a;
                    if (fVar.f13426a == gVar) {
                        if (f13424g.b(fVar, gVar, u(gVar.f13445b))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = eVarQ.f13437b;
                    Objects.requireNonNull(executor);
                    s(runnable2, executor);
                }
                eVarQ = eVar;
            }
            return;
        }
    }

    public static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f13422e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object u(s1<?> future) {
        Throwable thA;
        if (future instanceof i) {
            Object cVar = ((f) future).f13426a;
            if (cVar instanceof c) {
                c cVar2 = (c) cVar;
                if (cVar2.f13431a) {
                    cVar = cVar2.f13432b != null ? new c(false, cVar2.f13432b) : c.f13430d;
                }
            }
            Objects.requireNonNull(cVar);
            return cVar;
        }
        if ((future instanceof r1.a) && (thA = ((r1.a) future).a()) != null) {
            return new d(thA);
        }
        boolean zIsCancelled = future.isCancelled();
        if ((!f13421d) && zIsCancelled) {
            c cVar3 = c.f13430d;
            Objects.requireNonNull(cVar3);
            return cVar3;
        }
        try {
            Object objV = v(future);
            if (!zIsCancelled) {
                return objV == null ? f13425i : objV;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + future));
        } catch (Error | RuntimeException e10) {
            return new d(e10);
        } catch (CancellationException e11) {
            if (zIsCancelled) {
                return new c(false, e11);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + future, e11));
        } catch (ExecutionException e12) {
            if (!zIsCancelled) {
                return new d(e12.getCause());
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + future, e12));
        }
    }

    @c2
    private static <V> V v(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    public final void A(l node) {
        node.f13453a = null;
        while (true) {
            l lVar = this.f13428c;
            if (lVar == l.f13452c) {
                return;
            }
            l lVar2 = null;
            while (lVar != null) {
                l lVar3 = lVar.f13454b;
                if (lVar.f13453a != null) {
                    lVar2 = lVar;
                } else if (lVar2 != null) {
                    lVar2.f13454b = lVar3;
                    if (lVar2.f13453a == null) {
                    }
                } else if (!f13424g.c(this, lVar, lVar3)) {
                }
                lVar = lVar3;
            }
            return;
        }
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
    @t1.a
    public boolean B(@c2 V v10) {
        if (v10 == null) {
            v10 = (V) f13425i;
        }
        if (!f13424g.b(this, null, v10)) {
            return false;
        }
        r(this, false);
        return true;
    }

    @t1.a
    public boolean C(Throwable throwable) {
        throwable.getClass();
        if (!f13424g.b(this, null, new d(throwable))) {
            return false;
        }
        r(this, false);
        return true;
    }

    @t1.a
    public boolean D(s1<? extends V> future) {
        d dVar;
        future.getClass();
        Object obj = this.f13426a;
        if (obj == null) {
            if (future.isDone()) {
                if (!f13424g.b(this, null, u(future))) {
                    return false;
                }
                r(this, false);
                return true;
            }
            g gVar = new g(this, future);
            if (f13424g.b(this, null, gVar)) {
                try {
                    future.addListener(gVar, n0.INSTANCE);
                } catch (Error | RuntimeException e10) {
                    try {
                        dVar = new d(e10);
                    } catch (Error | RuntimeException unused) {
                        dVar = d.f13433b;
                    }
                    f13424g.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f13426a;
        }
        if (obj instanceof c) {
            future.cancel(((c) obj).f13431a);
        }
        return false;
    }

    public final boolean E() {
        Object obj = this.f13426a;
        return (obj instanceof c) && ((c) obj).f13431a;
    }

    @Override // r1.a
    @gm.a
    public final Throwable a() {
        if (!(this instanceof i)) {
            return null;
        }
        Object obj = this.f13426a;
        if (obj instanceof d) {
            return ((d) obj).f13434a;
        }
        return null;
    }

    @Override // q1.s1
    public void addListener(Runnable listener, Executor executor) {
        e eVar;
        c1.h0.F(listener, "Runnable was null.");
        c1.h0.F(executor, "Executor was null.");
        if (!isDone() && (eVar = this.f13427b) != e.f13435d) {
            e eVar2 = new e(listener, executor);
            do {
                eVar2.f13438c = eVar;
                if (f13424g.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f13427b;
                }
            } while (eVar != e.f13435d);
        }
        s(listener, executor);
    }

    @Override // java.util.concurrent.Future
    @t1.a
    public boolean cancel(boolean mayInterruptIfRunning) {
        c cVar;
        Object obj = this.f13426a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f13421d) {
            cVar = new c(mayInterruptIfRunning, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = mayInterruptIfRunning ? c.f13429c : c.f13430d;
            Objects.requireNonNull(cVar);
        }
        boolean z10 = false;
        while (true) {
            if (f13424g.b(this, obj, cVar)) {
                r(this, mayInterruptIfRunning);
                if (!(obj instanceof g)) {
                    return true;
                }
                s1<? extends V> s1Var = ((g) obj).f13445b;
                if (!(s1Var instanceof i)) {
                    s1Var.cancel(mayInterruptIfRunning);
                    return true;
                }
                this = (f) s1Var;
                obj = this.f13426a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z10 = true;
            } else {
                obj = this.f13426a;
                if (!(obj instanceof g)) {
                    return z10;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @t1.a
    @c2
    public V get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = unit.toNanos(timeout);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f13426a;
        if ((obj != null) && (!(obj instanceof g))) {
            return t(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            l lVar = this.f13428c;
            if (lVar != l.f13452c) {
                l lVar2 = new l();
                while (true) {
                    lVar2.a(lVar);
                    if (f13424g.c(this, lVar, lVar2)) {
                        do {
                            b2.a(this, nanos);
                            if (Thread.interrupted()) {
                                A(lVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f13426a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return t(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        A(lVar2);
                        break;
                    }
                    lVar = this.f13428c;
                    if (lVar == l.f13452c) {
                    }
                }
            }
            Object obj3 = this.f13426a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f13426a;
            if ((obj4 != null) && (!(obj4 instanceof g))) {
                return t(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = unit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        StringBuilder sbA = j.b.a("Waited ", timeout, " ");
        sbA.append(unit.toString().toLowerCase(locale));
        String string3 = sbA.toString();
        if (nanos + 1000 < 0) {
            String strA = j.a.a(string3, " (plus ");
            long j10 = -nanos;
            long jConvert = unit.convert(j10, TimeUnit.NANOSECONDS);
            long nanos2 = j10 - unit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strA2 = strA + jConvert + " " + lowerCase;
                if (z10) {
                    strA2 = j.a.a(strA2, ks.g.f9491d);
                }
                strA = j.a.a(strA2, " ");
            }
            if (z10) {
                strA = strA + nanos2 + " nanoseconds ";
            }
            string3 = j.a.a(strA, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(j.a.a(string3, " but future completed as timeout expired"));
        }
        throw new TimeoutException(string3 + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f13426a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f13426a;
        return (!(obj instanceof g)) & (obj != null);
    }

    public final void k(StringBuilder builder) {
        try {
            Object objV = v(this);
            builder.append("SUCCESS, result=[");
            n(builder, objV);
            builder.append("]");
        } catch (CancellationException unused) {
            builder.append("CANCELLED");
        } catch (RuntimeException e10) {
            builder.append("UNKNOWN, cause=[");
            builder.append(e10.getClass());
            builder.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            builder.append("FAILURE, cause=[");
            builder.append(e11.getCause());
            builder.append("]");
        }
    }

    public final void l(StringBuilder builder) {
        String strB;
        int length = builder.length();
        builder.append("PENDING");
        Object obj = this.f13426a;
        if (obj instanceof g) {
            builder.append(", setFuture=[");
            o(builder, ((g) obj).f13445b);
            builder.append("]");
        } else {
            try {
                strB = c1.g0.b(y());
            } catch (RuntimeException | StackOverflowError e10) {
                strB = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strB != null) {
                builder.append(", info=[");
                builder.append(strB);
                builder.append("]");
            }
        }
        if (isDone()) {
            builder.delete(length, builder.length());
            k(builder);
        }
    }

    @t1.g
    public void m() {
    }

    public final void n(StringBuilder builder, @gm.a Object o10) {
        if (o10 == null) {
            builder.append(d6.a.E);
        } else {
            if (o10 == this) {
                builder.append("this future");
                return;
            }
            builder.append(o10.getClass().getName());
            builder.append("@");
            builder.append(Integer.toHexString(System.identityHashCode(o10)));
        }
    }

    public final void o(StringBuilder builder, @gm.a Object o10) {
        try {
            if (o10 == this) {
                builder.append("this future");
            } else {
                builder.append(o10);
            }
        } catch (RuntimeException | StackOverflowError e10) {
            builder.append("Exception thrown from implementation: ");
            builder.append(e10.getClass());
        }
    }

    @gm.a
    public final e q(@gm.a e onto) {
        e eVarD = f13424g.d(this, e.f13435d);
        e eVar = onto;
        while (eVarD != null) {
            e eVar2 = eVarD.f13438c;
            eVarD.f13438c = eVar;
            eVar = eVarD;
            eVarD = eVar2;
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c2
    public final V t(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw p("Task was cancelled.", ((c) obj).f13432b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f13434a);
        }
        if (obj == f13425i) {
            return null;
        }
        return obj;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            k(sb2);
        } else {
            l(sb2);
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void w() {
    }

    public final void x(@gm.a Future<?> related) {
        if ((related != null) && isCancelled()) {
            related.cancel(E());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @gm.a
    public String y() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void z() {
        for (l lVarE = f13424g.e(this, l.f13452c); lVarE != null; lVarE = lVarE.f13454b) {
            lVarE.b();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f13435d = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public final Runnable f13436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public final Executor f13437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public e f13438c;

        public e(Runnable task, Executor executor) {
            this.f13436a = task;
            this.f13437b = executor;
        }

        public e() {
            this.f13436a = null;
            this.f13437b = null;
        }
    }

    @Override // java.util.concurrent.Future
    @t1.a
    @c2
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f13426a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return t(obj2);
            }
            l lVar = this.f13428c;
            if (lVar != l.f13452c) {
                l lVar2 = new l();
                do {
                    lVar2.a(lVar);
                    if (f13424g.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f13426a;
                            } else {
                                A(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return t(obj);
                    }
                    lVar = this.f13428c;
                } while (lVar != l.f13452c);
            }
            Object obj3 = this.f13426a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        throw new InterruptedException();
    }
}
