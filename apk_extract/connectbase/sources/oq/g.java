package oq;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import in.i;
import in.j;
import java.lang.reflect.InvocationTargetException;
import kn.l0;
import kn.r1;
import lm.c1;
import lm.d1;
import lm.k;
import nq.k1;
import nq.p;
import nq.q;
import os.l;
import os.m;
import xm.h;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,217:1\n314#2,11:218\n314#2,9:229\n323#2,2:239\n17#3:238\n1#4:241\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n189#1:218,11\n197#1:229,9\n197#1:239,2\n201#1:238\n*E\n"})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f12426a = 4611686018427387903L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    @in.f
    public static final e f12427b;

    @m
    private static volatile Choreographer choreographer;

    @r1({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerDispatcherKt\n*L\n1#1,18:1\n202#2,2:19\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f12428a;

        public a(p pVar) {
            this.f12428a = pVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g.n(this.f12428a);
        }
    }

    static {
        Object objM59constructorimpl;
        try {
            c1.a aVar = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(new d(e(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            objM59constructorimpl = c1.m59constructorimpl(d1.a(th2));
        }
        f12427b = (e) (c1.m64isFailureimpl(objM59constructorimpl) ? null : objM59constructorimpl);
    }

    @VisibleForTesting
    @l
    public static final Handler e(@l Looper looper, boolean z10) throws IllegalAccessException, InvocationTargetException {
        if (!z10) {
            return new Handler(looper);
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        l0.n(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }

    @m
    public static final Object f(@l um.d<? super Long> dVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            return g(dVar);
        }
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        l(choreographer2, qVar);
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            h.c(dVar);
        }
        return objZ;
    }

    public static final Object g(um.d<? super Long> dVar) {
        q qVar = new q(wm.c.e(dVar), 1);
        qVar.F();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            n(qVar);
        } else {
            k1.e().dispatch(qVar.getContext(), new a(qVar));
        }
        Object objZ = qVar.z();
        if (objZ == wm.a.COROUTINE_SUSPENDED) {
            h.c(dVar);
        }
        return objZ;
    }

    @j
    @i(name = TypedValues.TransitionType.S_FROM)
    @l
    public static final e h(@l Handler handler) {
        return j(handler, null, 1, null);
    }

    @j
    @i(name = TypedValues.TransitionType.S_FROM)
    @l
    public static final e i(@l Handler handler, @m String str) {
        return new d(handler, str, false);
    }

    public static /* synthetic */ e j(Handler handler, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        return i(handler, str);
    }

    @k(level = lm.m.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void k() {
    }

    public static final void l(Choreographer choreographer2, final p<? super Long> pVar) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: oq.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                g.m(pVar, j10);
            }
        });
    }

    public static final void m(p pVar, long j10) {
        pVar.G(k1.e(), Long.valueOf(j10));
    }

    public static final void n(p<? super Long> pVar) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            l0.m(choreographer2);
            choreographer = choreographer2;
        }
        l(choreographer2, pVar);
    }
}
