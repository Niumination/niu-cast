package k3;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.UsbConnectFailDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class gd {
    public static void a(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) UsbConnectFailDialog.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
        Intrinsics.checkNotNullParameter("UsbConnectFailDialog", "tag");
        Intrinsics.checkNotNullParameter("USB connect fail dialog shown", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("UsbConnectFailDialog"), "USB connect fail dialog shown");
        }
    }
}
