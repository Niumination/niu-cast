package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import d2.c;
import d2.d;
import d2.j;
import d2.l;
import i2.g;
import i2.i;
import m2.a;

/* JADX INFO: loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1771a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i8 = intent.getExtras().getInt("attemptNumber");
        l.b(context);
        c cVarA = j.a();
        if (queryParameter == null) {
            throw new NullPointerException("Null backendName");
        }
        cVarA.f4266a = queryParameter;
        cVarA.f4268c = a.b(iIntValue);
        if (queryParameter2 != null) {
            cVarA.f4267b = Base64.decode(queryParameter2, 0);
        }
        i iVar = l.a().f4288d;
        d dVarA = cVarA.a();
        i2.a aVar = i2.a.f5529a;
        iVar.getClass();
        iVar.e.execute(new g(iVar, dVarA, i8, aVar));
    }
}
