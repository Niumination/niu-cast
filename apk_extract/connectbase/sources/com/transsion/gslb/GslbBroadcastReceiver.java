package com.transsion.gslb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import l6.c;
import l6.g;
import l6.h;

/* JADX INFO: loaded from: classes2.dex */
public class GslbBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            try {
                h hVar = c.f9710a;
                if (hVar != null) {
                    hVar.h();
                }
            } catch (Exception e10) {
                g.f9730a.m(Log.getStackTraceString(e10));
            }
        }
    }
}
