package ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f99a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler.Callback f100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Messenger f101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Messenger f102d = new Messenger(new e(this, 0));

    public f(Context context, Handler.Callback callback) {
        this.f99a = context;
        this.f100b = callback;
    }

    public final void a() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.hoffnung", "com.transsion.dataservice.binder.DCService");
            this.f99a.bindService(intent, this, 1);
        } catch (Exception e) {
            c.h(Log.getStackTraceString(e));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c.g("onServiceConnected");
        try {
            Message messageObtain = Message.obtain((Handler) null, 100);
            Bundle bundle = new Bundle();
            bundle.putString("key", "oneid");
            messageObtain.setData(bundle);
            messageObtain.replyTo = this.f102d;
            Messenger messenger = new Messenger(iBinder);
            this.f101c = messenger;
            messenger.send(messageObtain);
        } catch (Exception e) {
            c.h(Log.getStackTraceString(e));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        c.g("onServiceDisconnected");
    }
}
