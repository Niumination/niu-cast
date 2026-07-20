package t7;

import android.os.SystemClock;
import android.util.Log;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;
import li.l0;
import na.f;
import na.g;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, Continuation<? super b> continuation) {
        super(2, continuation);
        this.this$0 = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Intrinsics.checkNotNullParameter("GalleryChangeMonitorWorker", "tag");
        Intrinsics.checkNotNullParameter("doWork", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GalleryChangeMonitorWorker"), "doWork");
        }
        c cVar = this.this$0;
        g gVar = cVar.f10197d;
        ag.a action = new ag.a(cVar, 17);
        gVar.getClass();
        Intrinsics.checkNotNullParameter(action, "action");
        gVar.e = action;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (gVar.f8139c == 0) {
            gVar.f8139c = jElapsedRealtime;
        }
        g2 g2Var = gVar.f8140d;
        if (g2Var != null) {
            g2Var.h(null);
        }
        long j8 = jElapsedRealtime - gVar.f8139c;
        long j10 = gVar.f8138b;
        c cVar2 = gVar.f8137a;
        if (j8 >= j10) {
            gVar.f8140d = l0.p(cVar2, null, null, new na.e(gVar, null), 3);
        } else {
            gVar.f8140d = l0.p(cVar2, null, null, new f(gVar, jElapsedRealtime, null), 3);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((b) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
