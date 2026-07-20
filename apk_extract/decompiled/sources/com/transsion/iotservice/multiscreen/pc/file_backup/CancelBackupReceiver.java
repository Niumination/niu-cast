package com.transsion.iotservice.multiscreen.pc.file_backup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.connectx.sdk.TCCPSourceApi;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ob.b;
import wa.c;
import x7.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/file_backup/CancelBackupReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CancelBackupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter("CancelBackupReceiver", "tag");
        Intrinsics.checkNotNullParameter("Backup cancel requested", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CancelBackupReceiver"), "Backup cancel requested");
        }
        c.a();
        TCCPSourceApi tCCPSourceApi = f.f10882a;
        long longExtra = intent.getLongExtra("TASK_ID", -1L);
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("cancelBackup", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "cancelBackup");
        }
        f.f10882a.cancelBackup(longExtra);
        b.f8417b.a("phone");
    }
}
