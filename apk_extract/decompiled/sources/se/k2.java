package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class k2 extends SuspendLambda implements Function2 {
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ byte[] $data;
    final /* synthetic */ BluetoothDevice $device;
    final /* synthetic */ int $notify;
    final /* synthetic */ int $offset;
    final /* synthetic */ int $requestId;
    int label;
    final /* synthetic */ com.welink.protocol.nfbd.l this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k2(com.welink.protocol.nfbd.l lVar, BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i8, int i9, byte[] bArr, int i10, Continuation<? super k2> continuation) {
        super(2, continuation);
        this.this$0 = lVar;
        this.$device = bluetoothDevice;
        this.$characteristic = bluetoothGattCharacteristic;
        this.$requestId = i8;
        this.$offset = i9;
        this.$data = bArr;
        this.$notify = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new k2(this.this$0, this.$device, this.$characteristic, this.$requestId, this.$offset, this.$data, this.$notify, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            com.welink.protocol.nfbd.l lVar = this.this$0;
            BluetoothDevice bluetoothDevice = this.$device;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
            int i9 = this.$requestId;
            int i10 = this.$offset;
            byte[] bArr = this.$data;
            int i11 = this.$notify;
            this.label = 1;
            if (lVar.u(bluetoothDevice, bluetoothGattCharacteristic, i9, i10, bArr, i11, this) == coroutine_suspended) {
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
        return ((k2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
