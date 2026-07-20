package kb;

import android.app.Application;
import android.util.Log;
import com.transsion.flamboyant.FoldableDeviceManager;
import dc.h;
import k3.gc;
import k3.pb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SuspendLambda implements Function2 {
    int label;

    public a(Continuation<? super a> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Intrinsics.checkNotNullParameter("GestureListener", "tag");
        Intrinsics.checkNotNullParameter("<register>", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("GestureListener"), "<register>");
        }
        Application context = pb.a();
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            h.f4410b = FoldableDeviceManager.get(context);
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("FoldableDeviceManagerPr", "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat("FoldableDeviceManagerPr"), e.getMessage(), e);
        }
        FoldableDeviceManager foldableDeviceManager = h.f4410b;
        if (foldableDeviceManager != null) {
            foldableDeviceManager.getCurrentFoldState();
        }
        Application context2 = pb.a();
        Intrinsics.checkNotNullParameter(context2, "context");
        try {
            h.f4410b = FoldableDeviceManager.get(context2);
        } catch (Exception e4) {
            Intrinsics.checkNotNullParameter("FoldableDeviceManagerPr", "tag");
            Intrinsics.checkNotNullParameter(e4, "e");
            Log.e(gc.f6463b.concat("FoldableDeviceManagerPr"), e4.getMessage(), e4);
        }
        nb.a aVar = nb.b.f8147a;
        h.a aVar2 = new h.a(2);
        FoldableDeviceManager foldableDeviceManager2 = h.f4410b;
        if (foldableDeviceManager2 != null) {
            foldableDeviceManager2.registerStateChangedListener(aVar, aVar2);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((a) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
