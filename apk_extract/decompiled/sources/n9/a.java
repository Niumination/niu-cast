package n9;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.transsion.hubsdk.TranContext;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements y9.a {
    @Override // y9.a
    public final Intent b(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        return TranContext.get(application).registerReceiverAsUser(application, broadcastReceiver, z8.a.f11265a, intentFilter, (String) null, handler);
    }

    @Override // y9.a
    public final void c(Application application, Intent intent) {
        TranContext.get(application).startActivityAsUser(application, intent, z8.a.f11265a);
    }
}
