package ki;

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
public class f implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler.Callback f9185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Messenger f9186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Messenger f9187d = new Messenger(new a());

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.i("ReplyMessenger msg.what = " + message.what);
            Handler.Callback callback = f.this.f9185b;
            if (callback != null) {
                callback.handleMessage(message);
            }
            f.c(f.this);
        }
    }

    public f(Context context, Handler.Callback callback) {
        this.f9184a = context;
        this.f9185b = callback;
    }

    public static void c(f fVar) {
        fVar.getClass();
        try {
            if (fVar.f9186c != null) {
                fVar.f9186c = null;
                fVar.f9184a.unbindService(fVar);
            }
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
    }

    public void b() {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.hoffnung", "com.transsion.dataservice.binder.DCService");
            this.f9184a.bindService(intent, this, 1);
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        d.i("onServiceConnected");
        try {
            Message messageObtain = Message.obtain((Handler) null, 100);
            Bundle bundle = new Bundle();
            bundle.putString(cb.b.c.f1408o, "oneid");
            messageObtain.setData(bundle);
            messageObtain.replyTo = this.f9187d;
            Messenger messenger = new Messenger(iBinder);
            this.f9186c = messenger;
            messenger.send(messageObtain);
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        d.i("onServiceDisconnected");
    }
}
