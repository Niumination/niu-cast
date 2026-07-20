package se;

import android.content.Context;
import android.util.SparseArray;
import java.util.LinkedHashSet;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u0 f9652d = new u0(s0.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f9653a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f9654b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.welink.protocol.nfbd.y f9655c;

    public b1(Context context) {
        e listener = new e(this, 18);
        com.welink.protocol.nfbd.y yVar = new com.welink.protocol.nfbd.y(context);
        this.f9655c = yVar;
        Intrinsics.checkNotNullParameter(listener, "listener");
        yVar.f4201o = listener;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(boolean z2, ContinuationImpl continuationImpl) throws Throwable {
        a1 a1Var;
        if (continuationImpl instanceof a1) {
            a1Var = (a1) continuationImpl;
            int i8 = a1Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                a1Var.label = i8 - Integer.MIN_VALUE;
            } else {
                a1Var = new a1(this, continuationImpl);
            }
        } else {
            a1Var = new a1(this, continuationImpl);
        }
        Object objQ = a1Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = a1Var.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objQ);
            a1Var.label = 1;
            objQ = this.f9655c.q(z2, a1Var);
            if (objQ == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQ);
        }
        Integer num = (Integer) objQ;
        if (num != null && num.intValue() == 100) {
            return t0.ENABLED_SUCCESS;
        }
        if (num != null && num.intValue() == 200) {
            return t0.DISABLED_SUCCESS;
        }
        if (num != null && num.intValue() == -2) {
            return t0.ENABLE_TIMEOUT;
        }
        if (num != null && num.intValue() == -3) {
            return t0.DISABLE_TIMEOUT;
        }
        if (num != null && num.intValue() == 0) {
            return t0.DISABLED;
        }
        if (num != null && num.intValue() == 1) {
            return t0.ENABLED_ALREADY;
        }
        if (num != null && num.intValue() == 2) {
            return t0.ENABLED_BUT_BT_OFF;
        }
        if (num != null && num.intValue() == 3) {
            return t0.ENABLED_BUT_WIFI_OFF;
        }
        if (num != null && num.intValue() == 4) {
            return t0.STATE_TURNING_ON;
        }
        return (num != null && num.intValue() == 5) ? t0.STATE_TURNING_OFF : t0.UNKNOWN;
    }
}
