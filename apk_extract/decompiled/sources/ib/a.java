package ib;

import android.content.Intent;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.receiver.HomeKeyReceiver;
import java.util.Calendar;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SuspendLambda implements Function2 {
    final /* synthetic */ Intent $intent;
    int label;
    final /* synthetic */ HomeKeyReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Intent intent, HomeKeyReceiver homeKeyReceiver, Continuation<? super a> continuation) {
        super(2, continuation);
        this.$intent = intent;
        this.this$0 = homeKeyReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(this.$intent, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            String stringExtra = this.$intent.getStringExtra("reason");
            gc.a("HomeKeyReceiver", "reason:" + stringExtra);
            if (stringExtra != null && (Intrinsics.areEqual(stringExtra, "homekey") || Intrinsics.areEqual(stringExtra, "recentstart"))) {
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                HomeKeyReceiver homeKeyReceiver = this.this$0;
                if (timeInMillis - homeKeyReceiver.f2674c > 200) {
                    homeKeyReceiver.f2674c = timeInMillis;
                    gc.a("HomeKeyReceiver", "home key press down");
                    this.this$0.f2673b.invoke();
                }
            }
            if (stringExtra != null && Intrinsics.areEqual(stringExtra, "recentapps")) {
                this.label = 1;
                if (r0.a(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i8 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Intrinsics.checkNotNullParameter("HomeKeyReceiver", "tag");
        Intrinsics.checkNotNullParameter("home key press down", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("HomeKeyReceiver"), "home key press down");
        }
        this.this$0.f2673b.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
