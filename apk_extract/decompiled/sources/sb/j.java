package sb;

import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
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
public final class j extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $toExtend;
    final /* synthetic */ boolean $toMirror;
    int label;
    final /* synthetic */ CastControlViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(CastControlViewModel castControlViewModel, boolean z2, boolean z3, Continuation<? super j> continuation) {
        super(2, continuation);
        this.this$0 = castControlViewModel;
        this.$toMirror = z2;
        this.$toExtend = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j(this.this$0, this.$toMirror, this.$toExtend, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            long j8 = this.this$0.f2718b;
            this.label = 1;
            if (r0.a(j8, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.getClass();
        this.this$0.getClass();
        boolean z2 = this.$toMirror;
        CastControlViewModel.f2715l = z2;
        CastControlViewModel.f2716m = this.$toExtend;
        if (z2) {
            x7.f.c();
            x7.f.a();
            ob.b.f8417b.j("turn_on");
        } else {
            ob.b.f8417b.j("turn_off");
        }
        if (this.$toExtend) {
            x7.f.b();
            x7.f.a();
        } else {
            Intrinsics.checkNotNullParameter("CastControlViewModel", "tag");
            Intrinsics.checkNotNullParameter("closeExtendScreen", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("CastControlViewModel"), "closeExtendScreen");
            }
        }
        if (!this.$toMirror && !this.$toExtend) {
            x7.f.d();
            x7.f.j();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((j) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
