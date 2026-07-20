package zb;

import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.lifecycle.MutableLiveData;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.ConnectingViewModel;
import k3.gc;
import k3.wb;
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
    final /* synthetic */ float $loadingDimension;
    final /* synthetic */ float $timeoutDimension;
    int label;
    final /* synthetic */ ConnectingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ConnectingViewModel connectingViewModel, float f, float f4, Continuation<? super a> continuation) {
        super(2, continuation);
        this.this$0 = connectingViewModel;
        this.$timeoutDimension = f;
        this.$loadingDimension = f4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(this.this$0, this.$timeoutDimension, this.$loadingDimension, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (r0.a(15000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Intrinsics.checkNotNullParameter("RememberedViewModel", "tag");
        Intrinsics.checkNotNullParameter("startCountDown: exceed normal time", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("RememberedViewModel"), "startCountDown: exceed normal time");
        }
        ConnectingViewModel connectingViewModel = this.this$0;
        float f = this.$timeoutDimension;
        float f4 = this.$loadingDimension;
        connectingViewModel.e.setValue(Boolean.TRUE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, wb.a(f), 0.0f);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -wb.a(f4));
        dc.c cVar = new dc.c(0.33f, 0.25f);
        MutableLiveData mutableLiveData = connectingViewModel.f2830a;
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(cVar);
        animationSet.setDuration(500L);
        animationSet.setFillAfter(true);
        mutableLiveData.setValue(animationSet);
        MutableLiveData mutableLiveData2 = connectingViewModel.f2832c;
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(translateAnimation2);
        animationSet2.setInterpolator(cVar);
        animationSet2.setDuration(500L);
        animationSet2.setFillAfter(true);
        mutableLiveData2.setValue(animationSet2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
