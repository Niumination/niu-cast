package se;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class x3 extends SuspendLambda implements Function2 {
    final /* synthetic */ int $encrypt;
    final /* synthetic */ String $remoteAddress;
    final /* synthetic */ int $reqType;
    final /* synthetic */ int $state;
    final /* synthetic */ String $version;
    int label;
    final /* synthetic */ com.welink.protocol.nfbd.p this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x3(com.welink.protocol.nfbd.p pVar, String str, String str2, int i8, int i9, int i10, Continuation<? super x3> continuation) {
        super(2, continuation);
        this.this$0 = pVar;
        this.$remoteAddress = str;
        this.$version = str2;
        this.$encrypt = i8;
        this.$reqType = i9;
        this.$state = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new x3(this.this$0, this.$remoteAddress, this.$version, this.$encrypt, this.$reqType, this.$state, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws JSONException {
        String strJoinToString$default;
        Object objU;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            com.welink.protocol.nfbd.p pVar = this.this$0;
            String str = this.$remoteAddress;
            String str2 = this.$version;
            if (str2 == null) {
                pVar.getClass();
                str2 = "1.0";
            }
            int i9 = this.$encrypt;
            int i10 = this.$reqType;
            BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
            Context context = this.this$0.f4185c;
            byte[] bArrM = ne.b.m();
            if (bArrM != null) {
                Intrinsics.checkNotNullParameter(bArrM, "<this>");
                Intrinsics.checkNotNullParameter(":", "separator");
                strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(bArrM, (CharSequence) ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new qg.y0(16), 30, (Object) null);
            } else {
                strJoinToString$default = null;
            }
            int i11 = this.$state;
            this.label = 1;
            objU = pVar.u(str, str2, i9, 47872, i10, strJoinToString$default, "02:00:00:00:00:00", i11, null, false, this);
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objU = obj;
        }
        if (((Boolean) objU).booleanValue()) {
            o.d.z("Unsupported device notify sent to ", this.$remoteAddress, "NearLanTcpServer");
        } else {
            String strN = o.d.n("Unsupported device notify failed to ", this.$remoteAddress, "NearLanTcpServer", "tag", "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", strN, "NearLanTcpServer", null);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((x3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
