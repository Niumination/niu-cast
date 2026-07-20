package bf;

import android.util.Log;
import androidx.lifecycle.ViewModelKt;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.Initial;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.SearchPcFragment;
import com.transsion.iotservice.multiscreen.pc.ui.search.viewModel.DeviceViewModel;
import eb.y0;
import k3.gc;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import li.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1275b;

    public /* synthetic */ b0(Object obj, int i8) {
        this.f1274a = i8;
        this.f1275b = obj;
    }

    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        Object obj2 = this.f1275b;
        switch (this.f1274a) {
            case 0:
                Object objEmit = ((oi.i) obj2).emit(obj, continuation);
                return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
            case 1:
                if (((Boolean) obj).booleanValue()) {
                    ((CastControlDialog) obj2).finish();
                }
                return Unit.INSTANCE;
            case 2:
                ((Boolean) obj).getClass();
                Object objEmit2 = ((CastControlViewModel) obj2).f2719c.emit(Boxing.boxBoolean(true), continuation);
                return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
            default:
                if (Intrinsics.areEqual((BaseState) obj, new Initial())) {
                    if (!y0.e) {
                        Intrinsics.checkNotNullParameter("SearchPcFragment", "tag");
                        Intrinsics.checkNotNullParameter("receive init state when pc connection disabled", "log");
                        if (gc.f6462a <= 6) {
                            Log.e(gc.f6463b.concat("SearchPcFragment"), "receive init state when pc connection disabled");
                        }
                        return Unit.INSTANCE;
                    }
                    Intrinsics.checkNotNullParameter("SearchPcFragment", "tag");
                    Intrinsics.checkNotNullParameter("start scan with init state callback", "log");
                    if (gc.f6462a <= 4) {
                        Log.i(gc.f6463b.concat("SearchPcFragment"), "start scan with init state callback");
                    }
                    DeviceViewModel deviceViewModelE = ((SearchPcFragment) obj2).e();
                    deviceViewModelE.getClass();
                    li.g0 viewModelScope = ViewModelKt.getViewModelScope(deviceViewModelE);
                    v0 v0Var = v0.f7498a;
                    l0.p(viewModelScope, si.e.f10118a, null, new zb.k(deviceViewModelE, null), 2);
                }
                return Unit.INSTANCE;
        }
    }
}
