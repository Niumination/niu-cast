package cc;

import com.transsion.iotservice.multiscreen.pc.ui.view.RoundedCardView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import li.a2;
import li.g0;
import li.l0;
import li.v0;
import qi.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends SuspendLambda implements Function2 {
    final /* synthetic */ String $lottieFile;
    int label;
    final /* synthetic */ RoundedCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, RoundedCardView roundedCardView, Continuation<? super c> continuation) {
        super(2, continuation);
        this.$lottieFile = str;
        this.this$0 = roundedCardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c(this.$lottieFile, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        try {
            if (i8 == 0) {
                ResultKt.throwOnFailure(obj);
                int iLastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) this.$lottieFile, '/', 0, false, 6, (Object) null);
                if (iLastIndexOf$default != -1) {
                    String strSubstring = this.$lottieFile.substring(0, iLastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    str = strSubstring + "/images";
                } else {
                    str = null;
                }
                v0 v0Var = v0.f7498a;
                a2 a2Var = r.f9163a;
                a aVar = new a(this.this$0, str, this.$lottieFile, null);
                this.label = 1;
                if (l0.u(a2Var, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i8 != 1 && i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception unused) {
            v0 v0Var2 = v0.f7498a;
            a2 a2Var2 = r.f9163a;
            b bVar = new b(this.$lottieFile, null);
            this.label = 2;
            if (l0.u(a2Var2, bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((c) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
