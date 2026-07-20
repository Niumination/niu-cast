package qj;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class e extends b0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f9188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Condition f9189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f9190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f9191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static e f9192l;
    public boolean e;
    public e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9193g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f9188h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(conditionNewCondition, "lock.newCondition()");
        f9189i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f9190j = millis;
        f9191k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void h() {
        long j8 = this.f9182c;
        boolean z2 = this.f9180a;
        if (j8 != 0 || z2) {
            ReentrantLock reentrantLock = f9188h;
            reentrantLock.lock();
            try {
                if (this.e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.e = true;
                if (f9192l == null) {
                    f9192l = new e();
                    b bVar = new b("Okio Watchdog");
                    bVar.setDaemon(true);
                    bVar.start();
                }
                long jNanoTime = System.nanoTime();
                if (j8 != 0 && z2) {
                    this.f9193g = Math.min(j8, c() - jNanoTime) + jNanoTime;
                } else if (j8 != 0) {
                    this.f9193g = j8 + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    this.f9193g = c();
                }
                long j10 = this.f9193g - jNanoTime;
                e eVar = f9192l;
                Intrinsics.checkNotNull(eVar);
                while (true) {
                    e eVar2 = eVar.f;
                    if (eVar2 == null) {
                        break;
                    }
                    Intrinsics.checkNotNull(eVar2);
                    if (j10 < eVar2.f9193g - jNanoTime) {
                        break;
                    }
                    eVar = eVar.f;
                    Intrinsics.checkNotNull(eVar);
                }
                this.f = eVar.f;
                eVar.f = this;
                if (eVar == f9192l) {
                    f9189i.signal();
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = f9188h;
        reentrantLock.lock();
        try {
            if (!this.e) {
                return false;
            }
            this.e = false;
            e eVar = f9192l;
            while (eVar != null) {
                e eVar2 = eVar.f;
                if (eVar2 == this) {
                    eVar.f = this.f;
                    this.f = null;
                    return false;
                }
                eVar = eVar2;
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j() {
    }
}
