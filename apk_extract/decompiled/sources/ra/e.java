package ra;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import java.util.LinkedHashMap;
import k3.gc;
import k3.sb;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import qg.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends SuspendLambda implements Function2 {
    int label;

    public e(Continuation<? super e> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new e(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = lb.a.f7355a;
        if (sb.b()) {
            for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("mirrorGesture", 1), TuplesKt.to("airTransfer", 1), TuplesKt.to("airCopy", 1), TuplesKt.to("clipboard_shared_enabled", 1), TuplesKt.to("multi_device_connection.allow_find", 1), TuplesKt.to("multi_device_connection.share_notifications", 1), TuplesKt.to("multi_device_connection.share_network", 1), TuplesKt.to("multi_device_connection.share_call", 1), TuplesKt.to("multi_device_connection.share_sms", 1), TuplesKt.to("multi_transfer_connection_way", 0)})) {
                lb.a.d(((Number) pair.component2()).intValue(), (String) pair.component1());
            }
        } else {
            for (Pair pair2 : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("mirrorGesture", 1), TuplesKt.to("airTransfer", 1), TuplesKt.to("airCopy", 1), TuplesKt.to("clipboard_shared_enabled", 1), TuplesKt.to("multi_device_connection.allow_find", 1), TuplesKt.to("multi_device_connection.share_notifications", 1), TuplesKt.to("multi_device_connection.share_network", 1)})) {
                lb.a.d(((Number) pair2.component2()).intValue(), (String) pair2.component1());
            }
            for (Pair pair3 : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("multi_device_connection.share_call_pad", 0), TuplesKt.to("multi_device_connection.share_sms_pad", 0)})) {
                lb.a.d(((Number) pair3.component2()).intValue(), (String) pair3.component1());
            }
        }
        MutableLiveData mutableLiveData = za.b.f11268a;
        if (Intrinsics.areEqual("1", pa.a.f8703a.k("tr_pcconnect.gesture_file_transfer.feature.support", "ro.gesture_file_transfer_support", "0"))) {
            MutableLiveData mutableLiveData2 = za.b.e;
            Boolean bool = (Boolean) lb.a.b("airTransfer").getValue();
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            mutableLiveData2.setValue(bool);
            lb.a.b("airTransfer").observeForever(new sb.h(2, new y0(25)));
            MutableLiveData mutableLiveData3 = za.b.f11268a;
            Boolean bool2 = (Boolean) lb.a.b("mirrorGesture").getValue();
            if (bool2 == null) {
                bool2 = Boolean.TRUE;
            }
            mutableLiveData3.setValue(bool2);
            lb.a.b("mirrorGesture").observeForever(new sb.h(2, new y0(26)));
            MutableLiveData mutableLiveData4 = za.b.f11270c;
            Boolean bool3 = (Boolean) lb.a.b("airCopy").getValue();
            if (bool3 == null) {
                bool3 = Boolean.TRUE;
            }
            mutableLiveData4.setValue(bool3);
            lb.a.b("airCopy").observeForever(new sb.h(2, new y0(27)));
            String log = "initSetting:airTransfer:" + za.b.f.getValue() + ", mirror:" + za.b.f11269b.getValue();
            Intrinsics.checkNotNullParameter("GlobalSettingManager", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("GlobalSettingManager"), log);
            }
        } else {
            za.b.b(false);
            za.b.c(false);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((e) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
