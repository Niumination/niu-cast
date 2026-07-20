package se;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class c2 extends SuspendLambda implements Function2 {
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ byte[] $data;
    final /* synthetic */ BluetoothGatt $gatt;
    int label;
    final /* synthetic */ com.welink.protocol.nfbd.j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c2(com.welink.protocol.nfbd.j jVar, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, Continuation<? super c2> continuation) {
        super(2, continuation);
        this.this$0 = jVar;
        this.$gatt = bluetoothGatt;
        this.$characteristic = bluetoothGattCharacteristic;
        this.$data = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new c2(this.this$0, this.$gatt, this.$characteristic, this.$data, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            com.welink.protocol.nfbd.j jVar = this.this$0;
            BluetoothGatt bluetoothGatt = this.$gatt;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
            byte[] bArr = this.$data;
            this.label = 1;
            if (jVar.u(bluetoothGatt, bluetoothGattCharacteristic, bArr, this) == coroutine_suspended) {
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
        return ((c2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
