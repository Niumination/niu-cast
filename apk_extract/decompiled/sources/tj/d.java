package tj;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import org.appspot.transsion.aiot.aidl.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f10247b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f10248a;

    public static Message a(int i8, String str, String str2) {
        Message message = new Message();
        message.f8611a = str;
        message.f8612b = str2;
        message.f8613c = i8;
        message.f8614d = System.currentTimeMillis();
        return message;
    }

    public static d b() {
        if (f10247b == null) {
            synchronized (d.class) {
                try {
                    if (f10247b == null) {
                        f10247b = new d();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f10247b;
    }

    public final void c(Message message) {
        Log.d("CellularShareManager", "publishMessage to topic: " + message.f8611a);
        try {
            j jVar = this.f10248a;
            if (jVar != null) {
                ((h) jVar).e(message);
            } else {
                Log.w("CellularShareManager", "CellularShareService not initialized");
            }
        } catch (RemoteException e) {
            if (e.getCause() instanceof DeadObjectException) {
                Log.d("CellularShareManager", "publishMessage - service dead");
            } else {
                Log.e("CellularShareManager", "publishMessage failed", e);
                throw new RuntimeException(e);
            }
        }
    }

    public final void d(String str, m mVar) {
        o.d.B("subscribeToTopic: ", str, "CellularShareManager");
        try {
            j jVar = this.f10248a;
            if (jVar != null) {
                ((h) jVar).g(str, mVar);
            } else {
                Log.w("CellularShareManager", "CellularShareService not initialized");
            }
        } catch (RemoteException e) {
            if (e.getCause() instanceof DeadObjectException) {
                Log.d("CellularShareManager", "subscribeToTopic - service dead");
            } else {
                Log.e("CellularShareManager", "subscribeToTopic failed", e);
                throw new RuntimeException(e);
            }
        }
    }
}
