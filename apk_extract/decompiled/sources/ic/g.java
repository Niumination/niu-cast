package ic;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.y;
import k3.gc;
import k3.lb;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import li.g2;
import li.l0;
import se.b1;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends h {
    @Override // ic.h
    public final boolean a(hc.c device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return device instanceof hc.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // ic.h
    public final Object b(hc.c cVar, Continuation continuation) {
        a aVar;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i8 = aVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                aVar.label = i8 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuation);
            }
        } else {
            aVar = new a(this, continuation);
        }
        Object objR = aVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = aVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(objR);
            Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.transsion.iotservice.physicalconnect.bean.BLEConnectDevice");
            String strN = o.d.n("connect:", cVar.f5288c, "BLEConnectHelper", "tag", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("BLEConnectHelper"), strN);
            }
            aVar.label = 1;
            li.l lVar = new li.l(1, IntrinsicsKt.intercepted(aVar));
            lVar.s();
            String id2 = ((hc.a) cVar).f5288c;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            g2 g2VarP = l0.p(this.f5733a, null, null, new d(objectRef, lVar, null), 3);
            f fVar = new f(objectRef, g2VarP, lVar);
            c cVar2 = new c(objectRef, g2VarP, lVar);
            e eVar = new e(objectRef, g2VarP, lVar);
            b bVar = new b(objectRef);
            lVar.v(bVar);
            na.a.a(lVar, bVar);
            Lazy lazy = mc.b.f7958a;
            mc.b.h(cVar2, eVar, fVar);
            String log = "connectCallback:" + cVar2;
            Intrinsics.checkNotNullParameter("BLEConnectHelper", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("BLEConnectHelper"), log);
            }
            Intrinsics.checkNotNullParameter(id2, "id");
            NearDevice device = (NearDevice) mc.b.f7965j.get(id2);
            if (device != null) {
                String strN2 = o.d.n("connect, id:", id2, "TranConnectManager", "tag", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("TranConnectManager"), strN2);
                }
                mc.b.g();
                b1 b1VarE = mc.b.e();
                b1VarE.getClass();
                Intrinsics.checkNotNullParameter(device, "device");
                if (b1VarE.f9654b.contains(device)) {
                    y.o(b1VarE.f9655c, device);
                } else {
                    Intrinsics.checkNotNullParameter("NearConnectionManager", "tag");
                    Intrinsics.checkNotNullParameter("connect: device not found", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearConnectionManager", "TransConnect:connect: device not found", null);
                    }
                }
            }
            objR = lVar.r();
            if (objR == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(aVar);
            }
            if (objR == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objR);
        }
        hc.b bVar2 = (hc.b) objR;
        return bVar2 == null ? new hc.b(false, null, null, null, 0, null, 0, 0, null, TypedValues.PositionType.TYPE_POSITION_TYPE) : bVar2;
    }
}
