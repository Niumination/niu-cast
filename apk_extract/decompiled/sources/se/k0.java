package se;

import android.bluetooth.BluetoothDevice;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends SuspendLambda implements Function2 {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ BluetoothDevice $device;
    int label;
    final /* synthetic */ com.welink.protocol.nfbd.c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(com.welink.protocol.nfbd.c cVar, BluetoothDevice bluetoothDevice, byte[] bArr, Continuation<? super k0> continuation) {
        super(2, continuation);
        this.this$0 = cVar;
        this.$device = bluetoothDevice;
        this.$data = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new k0(this.this$0, this.$device, this.$data, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            com.welink.protocol.nfbd.c cVar = this.this$0;
            BluetoothDevice bluetoothDevice = this.$device;
            byte[] bArr = this.$data;
            this.label = 1;
            if (cVar.w(bluetoothDevice, bArr, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((k0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
