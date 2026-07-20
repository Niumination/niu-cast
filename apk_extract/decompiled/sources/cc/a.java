package cc;

import android.util.Log;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.iotservice.multiscreen.pc.ui.view.RoundedCardView;
import k3.gc;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import li.g0;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SuspendLambda implements Function2 {
    final /* synthetic */ String $imageFolder;
    final /* synthetic */ String $lottieFile;
    int label;
    final /* synthetic */ RoundedCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(RoundedCardView roundedCardView, String str, String str2, Continuation<? super a> continuation) {
        super(2, continuation);
        this.this$0 = roundedCardView;
        this.$imageFolder = str;
        this.$lottieFile = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(this.this$0, this.$imageFolder, this.$lottieFile, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            LottieAnimationView lottieAnimationView = this.this$0.f2898h;
            lottieAnimationView.f1747k = false;
            lottieAnimationView.e.k();
            this.this$0.f2898h.clearAnimation();
            String str = this.$imageFolder;
            if (str != null) {
                this.this$0.f2898h.setImageAssetsFolder(str);
            }
            this.this$0.f2898h.setCacheComposition(false);
            this.this$0.f2898h.setAnimation(this.$lottieFile);
            this.this$0.f2898h.d();
        } catch (Exception unused) {
            String strN = d.n("Lottie update failed: ", this.$lottieFile, "RoundedCardView", "tag", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("RoundedCardView"), strN);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
