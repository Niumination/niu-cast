package bf;

import android.content.Context;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.ui.qr.QrConnectViewModel;
import java.util.ArrayList;
import k3.gc;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import li.g2;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1278c;

    public /* synthetic */ d(int i8, Object obj, Object obj2) {
        this.f1276a = i8;
        this.f1277b = obj;
        this.f1278c = obj2;
    }

    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        switch (this.f1276a) {
            case 0:
                ((ze.j) this.f1277b).e(obj);
                Object objA = ((t) this.f1278c).a(continuation);
                return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
            case 1:
                Object objA2 = ((oi.h) ((Function1) this.f1277b).invoke(obj)).a(new b0((oi.i) this.f1278c, 0), continuation);
                return objA2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA2 : Unit.INSTANCE;
            case 2:
                BaseState baseState = (BaseState) obj;
                String log = "stateFlow collect: " + baseState;
                Intrinsics.checkNotNullParameter("EnvironmentCheckUtil", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("EnvironmentCheckUtil"), log);
                }
                if (!Intrinsics.areEqual(baseState, new Initial())) {
                    return Unit.INSTANCE;
                }
                ((Function1) this.f1277b).invoke((Context) this.f1278c);
                g2 g2Var = dc.g.f4407b;
                if (g2Var != null) {
                    g2Var.h(null);
                }
                return Unit.INSTANCE;
            default:
                BaseState baseState2 = (BaseState) obj;
                String log2 = "checkEnv: stateFlow:" + baseState2;
                Intrinsics.checkNotNullParameter("QrConnectViewModel", "tag");
                Intrinsics.checkNotNullParameter(log2, "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("QrConnectViewModel"), log2);
                }
                if (!(baseState2 instanceof Initial)) {
                    return Unit.INSTANCE;
                }
                Object objA3 = ((QrConnectViewModel) this.f1277b).a((ArrayList) this.f1278c, continuation);
                return objA3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA3 : Unit.INSTANCE;
        }
    }
}
