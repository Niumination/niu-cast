package k3;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.DialogUtilActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class fd {
    public static void a(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("DialogUtilActivity", "tag");
        Intrinsics.checkNotNullParameter("goToBackupInterruptDialog from abnormal_interrupt", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("DialogUtilActivity"), "goToBackupInterruptDialog from abnormal_interrupt");
        }
        if (m3.m.f7774a) {
            Intent intent = new Intent(context, (Class<?>) DialogUtilActivity.class);
            intent.putExtra("DialogType", 1);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }
}
