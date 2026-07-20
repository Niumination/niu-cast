package sb;

import androidx.lifecycle.Observer;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import li.g2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9622b;

    public /* synthetic */ q(Object obj, int i8) {
        this.f9621a = i8;
        this.f9622b = obj;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        Object obj2 = this.f9622b;
        Boolean bool = (Boolean) obj;
        switch (this.f9621a) {
            case 0:
                boolean zBooleanValue = bool.booleanValue();
                int i8 = PcRequestConnectDialog.f2742h;
                if (!zBooleanValue) {
                    ((PcRequestConnectDialog) obj2).finishAndRemoveTask();
                }
                break;
            default:
                if (bool.booleanValue()) {
                    PcRequestConnectViewModel pcRequestConnectViewModel = (PcRequestConnectViewModel) obj2;
                    g2 g2Var = pcRequestConnectViewModel.f2751g;
                    if (g2Var != null) {
                        g2Var.h(null);
                    }
                    ag.a aVar = pcRequestConnectViewModel.f;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                }
                break;
        }
    }
}
