package sb;

import android.content.DialogInterface;
import com.transsion.iotservice.multiscreen.pc.ui.BaseActivityDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.ChannelOccupyDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectDialog;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.QrConnectFailedDialog;
import com.transsion.iotservice.multiscreen.pc.ui.permission.PermissionDialog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseActivityDialog f9612b;

    public /* synthetic */ l(BaseActivityDialog baseActivityDialog, int i8) {
        this.f9611a = i8;
        this.f9612b = baseActivityDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        BaseActivityDialog baseActivityDialog = this.f9612b;
        switch (this.f9611a) {
            case 0:
                dc.d dVar = ChannelOccupyDialog.f2726c;
                ob.b bVar = ob.b.f8417b;
                bVar.getClass();
                Intrinsics.checkNotNullParameter("cancel", "handleResult");
                bVar.f8437a.J("cancel");
                ((ChannelOccupyDialog) baseActivityDialog).finishAndRemoveTask();
                dc.d dVar2 = ChannelOccupyDialog.f2726c;
                if (dVar2 != null) {
                    dVar2.invoke(Boolean.FALSE);
                }
                break;
            case 1:
                PcRequestConnectViewModel pcRequestConnectViewModel = ((PcRequestConnectDialog) baseActivityDialog).f2743b;
                if (pcRequestConnectViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConnectRequestVM");
                    pcRequestConnectViewModel = null;
                }
                pcRequestConnectViewModel.b(3);
                break;
            case 2:
                Function1 function1 = QrConnectFailedDialog.f2754c;
                ((QrConnectFailedDialog) baseActivityDialog).finishAndRemoveTask();
                Function1 function2 = QrConnectFailedDialog.f2754c;
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE);
                }
                break;
            default:
                Function1 function3 = PermissionDialog.f2787d;
                ((PermissionDialog) baseActivityDialog).finishAndRemoveTask();
                break;
        }
    }
}
