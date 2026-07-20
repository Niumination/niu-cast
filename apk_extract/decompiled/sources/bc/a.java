package bc;

import android.util.Log;
import android.view.View;
import com.transsion.iotservice.multiscreen.pc.adapter.TrustDevicesAdapter;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesActivity;
import java.util.List;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TrustDevicesActivity f1262b;

    public /* synthetic */ a(TrustDevicesActivity trustDevicesActivity, int i8) {
        this.f1261a = i8;
        this.f1262b = trustDevicesActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TrustDevicesActivity trustDevicesActivity = this.f1262b;
        switch (this.f1261a) {
            case 0:
                View it = (View) obj;
                int i8 = TrustDevicesActivity.f2883j;
                Intrinsics.checkNotNullParameter(it, "it");
                trustDevicesActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            default:
                List list = (List) obj;
                int i9 = TrustDevicesActivity.f2883j;
                String log = "observeData: received " + (list != null ? list.size() : 0) + " devices";
                Intrinsics.checkNotNullParameter("TrustDevicesActivity", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TrustDevicesActivity"), log);
                }
                TrustDevicesAdapter trustDevicesAdapter = trustDevicesActivity.e;
                if (trustDevicesAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    trustDevicesAdapter = null;
                }
                trustDevicesAdapter.submitList(list);
                break;
        }
        return Unit.INSTANCE;
    }
}
