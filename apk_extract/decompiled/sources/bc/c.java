package bc;

import android.content.DialogInterface;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.trust.TrustDevicesActivity;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1265a;

    public /* synthetic */ c(int i8) {
        this.f1265a = i8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i8) {
        switch (this.f1265a) {
            case 0:
                int i9 = TrustDevicesActivity.f2883j;
                Intrinsics.checkNotNullParameter("TrustDevicesActivity", "tag");
                Intrinsics.checkNotNullParameter("cancel delete", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TrustDevicesActivity"), "cancel delete");
                }
                dialogInterface.dismiss();
                break;
            case 1:
                dialogInterface.dismiss();
                break;
            default:
                dialogInterface.dismiss();
                break;
        }
    }
}
