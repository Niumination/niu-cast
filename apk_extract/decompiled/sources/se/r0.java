package se;

import android.bluetooth.BluetoothDevice;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends SuspendLambda implements Function2 {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ BluetoothDevice $device;
    final /* synthetic */ int $notify;
    final /* synthetic */ int $offset;
    int label;
    final /* synthetic */ com.welink.protocol.nfbd.f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(com.welink.protocol.nfbd.f fVar, BluetoothDevice bluetoothDevice, int i8, byte[] bArr, int i9, Continuation<? super r0> continuation) {
        super(2, continuation);
        this.this$0 = fVar;
        this.$device = bluetoothDevice;
        this.$offset = i8;
        this.$data = bArr;
        this.$notify = i9;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new r0(this.this$0, this.$device, this.$offset, this.$data, this.$notify, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            com.welink.protocol.nfbd.f fVar = this.this$0;
            byte[] bArr = this.$data;
            int i9 = this.$notify;
            this.label = 1;
            if (fVar.s(bArr, i9, this) == coroutine_suspended) {
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
        return ((r0) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
