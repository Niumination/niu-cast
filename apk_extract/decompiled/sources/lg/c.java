package lg;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.f0;
import li.g0;
import li.g2;
import li.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f7425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SuspendLambda f7426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g2 f7427d;
    volatile /* synthetic */ int isStarted;
    volatile /* synthetic */ long lastActivityTime;

    /* JADX WARN: Multi-variable type inference failed */
    public c(String name, long j8, Function0 clock, g0 scope, Function1 onTimeout) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
        this.f7424a = j8;
        this.f7425b = clock;
        this.f7426c = (SuspendLambda) onTimeout;
        this.lastActivityTime = 0L;
        this.isStarted = 0;
        this.f7427d = j8 != Long.MAX_VALUE ? l0.p(scope, scope.getCoroutineContext().plus(new f0(h0.a.i("Timeout ", name))), null, new b(this, null), 2) : null;
    }

    public final void a() {
        this.lastActivityTime = ((Number) this.f7425b.invoke()).longValue();
        this.isStarted = 1;
    }

    public final void b() {
        this.isStarted = 0;
    }
}
