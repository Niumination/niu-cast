package com.transsion.gslb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import f8.c;
import f8.e;
import f8.f;

/* JADX INFO: loaded from: classes2.dex */
public class GslbBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            try {
                f fVar = c.f5000a;
                if (fVar != null) {
                    fVar.c();
                    fVar.a();
                }
            } catch (Exception e) {
                e.f5006a.e(Log.getStackTraceString(e));
            }
        }
    }
}
