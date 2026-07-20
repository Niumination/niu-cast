package zb;

import android.os.SystemClock;
import android.util.ArrayMap;
import com.transsion.iotservice.multiscreen.pc.bean.PcBleScanedDeviceBean;
import com.transsion.iotservice.multiscreen.pc.state.PhysicalScanning;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import eb.y;
import java.util.ArrayList;
import java.util.Iterator;
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
public final class d extends SuspendLambda implements Function2 {
    final /* synthetic */ ArrayList<PcBleScanedDeviceBean> $it;
    int label;
    final /* synthetic */ DeviceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ArrayList<PcBleScanedDeviceBean> arrayList, DeviceViewModel deviceViewModel, Continuation<? super d> continuation) {
        super(2, continuation);
        this.$it = arrayList;
        this.this$0 = deviceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new d(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = this.label;
        if (i8 == 0) {
            ResultKt.throwOnFailure(obj);
            y yVar = y.f4799a;
            if (!Intrinsics.areEqual(y.f4804h, new PhysicalScanning())) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (r0.a(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ob.b bVar = ob.b.f8417b;
        ArrayList<PcBleScanedDeviceBean> list = this.$it;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        ob.b.f8425l = size;
        int i9 = ob.b.f8426m;
        if (size > i9) {
            ob.b.f8427n = size;
        }
        if (size != i9) {
            bVar.f8437a.v(size);
            ob.b.f8426m = ob.b.f8425l;
        }
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String mDeviceMac = ((PcBleScanedDeviceBean) it.next()).getMDeviceMac();
                ob.b.f8417b.getClass();
                ArrayMap arrayMap = ob.b.f8424k;
                if (!arrayMap.containsKey(mDeviceMac)) {
                    arrayMap.put(mDeviceMac, Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        }
        this.this$0.f2845l.postValue(this.$it);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
        return ((d) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
