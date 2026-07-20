package com.transsion.connectx.mirror.source.receiver;

import a6.m;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenActionReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2167a;

    public interface a {
        void a(boolean z10, String str);
    }

    public void a(a aVar) {
        this.f2167a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        action.getClass();
        switch (action) {
            case "android.intent.action.SCREEN_OFF":
                this.f2167a.a(true, "screen_off");
                break;
            case "android.intent.action.SCREEN_ON":
                if (!m.a()) {
                    this.f2167a.a(false, "screen_on");
                    break;
                }
                break;
            case "android.intent.action.USER_PRESENT":
                this.f2167a.a(false, "user_present");
                break;
        }
    }
}
