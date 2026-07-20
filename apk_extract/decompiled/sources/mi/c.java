package mi;

import android.os.Handler;
import android.os.Looper;
import i2.e;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import li.a2;
import li.d2;
import li.l;
import li.o1;
import li.p1;
import li.q0;
import li.v0;
import li.x0;
import qi.r;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a2 implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f8093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f8096d;

    public c(Handler handler, String str, boolean z2) {
        this.f8093a = handler;
        this.f8094b = str;
        this.f8095c = z2;
        this.f8096d = z2 ? this : new c(handler, str, true);
    }

    @Override // li.q0
    public final void c(long j8, l lVar) {
        e eVar = new e(2, lVar, this);
        if (this.f8093a.postDelayed(eVar, RangesKt.coerceAtMost(j8, DurationKt.MAX_MILLIS))) {
            lVar.v(new gi.a(5, this, eVar));
        } else {
            i(lVar.e, eVar);
        }
    }

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f8093a.post(runnable)) {
            return;
        }
        i(coroutineContext, runnable);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f8093a == this.f8093a && cVar.f8095c == this.f8095c) {
                return true;
            }
        }
        return false;
    }

    @Override // li.q0
    public final x0 g(long j8, final Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f8093a.postDelayed(runnable, RangesKt.coerceAtMost(j8, DurationKt.MAX_MILLIS))) {
            return new x0() { // from class: mi.b
                @Override // li.x0
                public final void dispose() {
                    this.f8091a.f8093a.removeCallbacks(runnable);
                }
            };
        }
        i(coroutineContext, runnable);
        return d2.f7443a;
    }

    public final int hashCode() {
        return (this.f8095c ? 1231 : 1237) ^ System.identityHashCode(this.f8093a);
    }

    public final void i(CoroutineContext coroutineContext, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        p1 p1Var = (p1) coroutineContext.get(o1.f7483a);
        if (p1Var != null) {
            p1Var.h(cancellationException);
        }
        v0 v0Var = v0.f7498a;
        si.e.f10118a.dispatch(coroutineContext, runnable);
    }

    @Override // li.a0
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.f8095c && Intrinsics.areEqual(Looper.myLooper(), this.f8093a.getLooper())) ? false : true;
    }

    @Override // li.a0
    public final String toString() {
        c cVar;
        String str;
        v0 v0Var = v0.f7498a;
        a2 a2Var = r.f9163a;
        if (this == a2Var) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = ((c) a2Var).f8096d;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f8094b;
        if (string == null) {
            string = this.f8093a.toString();
        }
        return this.f8095c ? h0.a.B(string, ".immediate") : string;
    }

    public c(Handler handler) {
        this(handler, null, false);
    }
}
