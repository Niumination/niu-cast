package ki;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9183a = true;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (this.f9183a) {
                this.f9183a = false;
                return;
            }
            try {
                if (d.p(context)) {
                    com.transsion.sdk.oneid.a.a(context).o();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
