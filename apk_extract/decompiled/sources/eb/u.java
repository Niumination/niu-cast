package eb;

import android.util.Log;
import com.transsion.connectx.sdk.TCCPSourceApi;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends SuspendLambda implements Function2 {
    final /* synthetic */ String $text;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(String str, Continuation<? super u> continuation) {
        super(2, continuation);
        this.$text = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new u(this.$text, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            if (((s7.d) o7.a.b("com.transsion.file")) != null) {
                String content = this.$text;
                this.label = 1;
                gc.a("CastSourceFileTransfer", "<sendText> " + content);
                TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
                Intrinsics.checkNotNullParameter("syncClipText", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectSdkProxy"), "syncClipText");
                }
                x7.f.f10882a.syncClipText(content);
                Unit unit = Unit.INSTANCE;
                gc.a("CastSourceFileTransfer", "<sendText> result = " + unit);
                if (unit == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ob.b.f8417b.p(1, 1, 0L, 0L, "text", "succes_end");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((u) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
