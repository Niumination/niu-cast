package m4;

import h4.q;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.jb;
import k3.nb;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends nb implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f7928d;
    public static final Logger e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final jb f7929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f7930i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f7931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f7932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile i f7933c;

    static {
        boolean z2;
        jb fVar;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z2 = false;
        }
        f7928d = z2;
        e = Logger.getLogger(j.class.getName());
        Throwable th2 = null;
        try {
            fVar = new h();
            e = null;
        } catch (Error | RuntimeException e4) {
            e = e4;
            try {
                fVar = new e(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(j.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "a"));
            } catch (Error | RuntimeException e10) {
                th2 = e10;
                fVar = new f();
            }
        }
        f7929h = fVar;
        if (th2 != null) {
            Logger logger = e;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", e);
            logger.log(level, "SafeAtomicHelper is broken!", th2);
        }
        f7930i = new Object();
    }

    public static void c(j jVar, boolean z2) {
        jVar.getClass();
        for (i iVarE = f7929h.e(jVar); iVarE != null; iVarE = iVarE.f7927b) {
            Thread thread = iVarE.f7926a;
            if (thread != null) {
                iVarE.f7926a = null;
                LockSupport.unpark(thread);
            }
        }
        if (z2) {
            jVar.g();
        }
        d dVarD = f7929h.d(jVar);
        d dVar = null;
        while (dVarD != null) {
            d dVar2 = dVarD.f7916c;
            dVarD.f7916c = dVar;
            dVar = dVarD;
            dVarD = dVar2;
        }
        while (dVar != null) {
            d dVar3 = dVar.f7916c;
            Runnable runnable = dVar.f7914a;
            Objects.requireNonNull(runnable);
            Executor executor = dVar.f7915b;
            Objects.requireNonNull(executor);
            d(runnable, executor);
            dVar = dVar3;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e4) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e4);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            RuntimeException runtimeException = ((a) obj).f7911a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(runtimeException);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f7912a);
        }
        if (obj == f7930i) {
            return null;
        }
        return obj;
    }

    public static Object f(j jVar) {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = jVar.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th2) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb2) {
        try {
            Object objF = f(this);
            sb2.append("SUCCESS, result=[");
            b(sb2, objF);
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e4) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e4.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e10) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e10.getCause());
            sb2.append("]");
        }
    }

    @Override // m4.l
    public void addListener(Runnable runnable, Executor executor) {
        d dVar;
        d dVar2;
        v8.i(runnable, "Runnable was null.");
        v8.i(executor, "Executor was null.");
        if (!isDone() && (dVar = this.f7932b) != (dVar2 = d.f7913d)) {
            d dVar3 = new d(runnable, executor);
            do {
                dVar3.f7916c = dVar;
                if (f7929h.a(this, dVar, dVar3)) {
                    return;
                } else {
                    dVar = this.f7932b;
                }
            } while (dVar != dVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else {
            if (obj == this) {
                sb2.append("this future");
                return;
            }
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        a aVar;
        Object obj = this.f7931a;
        if (obj != null) {
            return false;
        }
        if (f7928d) {
            aVar = new a(z2, new CancellationException("Future.cancel() was called."));
        } else {
            aVar = z2 ? a.f7909b : a.f7910c;
            Objects.requireNonNull(aVar);
        }
        if (!f7929h.b(this, obj, aVar)) {
            return false;
        }
        c(this, z2);
        return true;
    }

    public void g() {
    }

    @Override // java.util.concurrent.Future
    public Object get(long j8, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j8);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f7931a;
        if (obj != null) {
            return e(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f7933c;
            i iVar2 = i.f7925c;
            if (iVar != iVar2) {
                i iVar3 = new i();
                while (true) {
                    jb jbVar = f7929h;
                    jbVar.f(iVar3, iVar);
                    if (jbVar.c(this, iVar, iVar3)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                i(iVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f7931a;
                            if (obj2 != null) {
                                return e(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        i(iVar3);
                        break;
                    }
                    iVar = this.f7933c;
                    if (iVar == iVar2) {
                    }
                }
            }
            Object obj3 = this.f7931a;
            Objects.requireNonNull(obj3);
            return e(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f7931a;
            if (obj4 != null) {
                return e(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strB = "Waited " + j8 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strB2 = h0.a.B(strB, " (plus ");
            long j10 = -nanos;
            long jConvert = timeUnit.convert(j10, TimeUnit.NANOSECONDS);
            long nanos2 = j10 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strB3 = strB2 + jConvert + " " + lowerCase;
                if (z2) {
                    strB3 = h0.a.B(strB3, ",");
                }
                strB2 = h0.a.B(strB3, " ");
            }
            if (z2) {
                strB2 = strB2 + nanos2 + " nanoseconds ";
            }
            strB = h0.a.B(strB2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(h0.a.B(strB, " but future completed as timeout expired"));
        }
        throw new TimeoutException(o.d.l(strB, " for ", string));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String h() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(i iVar) {
        iVar.f7926a = null;
        while (true) {
            i iVar2 = this.f7933c;
            if (iVar2 == i.f7925c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f7927b;
                if (iVar2.f7926a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f7927b = iVar4;
                    if (iVar3.f7926a == null) {
                    }
                } else if (!f7929h.c(this, iVar2, iVar4)) {
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f7931a instanceof a;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f7931a != null;
    }

    public final String toString() {
        String strH;
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
            a(sb2);
        } else {
            int length = sb2.length();
            sb2.append("PENDING");
            try {
                strH = h();
                if (q.a(strH)) {
                    strH = null;
                }
            } catch (RuntimeException | StackOverflowError e4) {
                strH = "Exception thrown from implementation: " + e4.getClass();
            }
            if (strH != null) {
                sb2.append(", info=[");
                sb2.append(strH);
                sb2.append("]");
            }
            if (isDone()) {
                sb2.delete(length, sb2.length());
                a(sb2);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f7931a;
            if (obj2 != null) {
                return e(obj2);
            }
            i iVar = this.f7933c;
            i iVar2 = i.f7925c;
            if (iVar != iVar2) {
                i iVar3 = new i();
                do {
                    jb jbVar = f7929h;
                    jbVar.f(iVar3, iVar);
                    if (jbVar.c(this, iVar, iVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f7931a;
                            } else {
                                i(iVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return e(obj);
                    }
                    iVar = this.f7933c;
                } while (iVar != iVar2);
            }
            Object obj3 = this.f7931a;
            Objects.requireNonNull(obj3);
            return e(obj3);
        }
        throw new InterruptedException();
    }
}
