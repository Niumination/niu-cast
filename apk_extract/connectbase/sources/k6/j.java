package k6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class j extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9134a = true;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (this.f9134a) {
                this.f9134a = false;
                return;
            }
            try {
                if (y3.f.d(context) && s3.e.p(context)) {
                    g.a1();
                    g.a0();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
