package u2;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f10368a;

    public /* synthetic */ t(u uVar) {
        this.f10368a = uVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i8 = message.what;
        if (i8 == 0) {
            synchronized (this.f10368a.f10372a) {
                try {
                    r rVar = (r) message.obj;
                    s sVar = (s) this.f10368a.f10372a.get(rVar);
                    if (sVar != null && sVar.f10362a.isEmpty()) {
                        if (sVar.f10364c) {
                            sVar.f10367i.f10374c.removeMessages(1, sVar.e);
                            u uVar = sVar.f10367i;
                            uVar.f10375d.a(uVar.f10373b, sVar);
                            sVar.f10364c = false;
                            sVar.f10363b = 2;
                        }
                        this.f10368a.f10372a.remove(rVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
        if (i8 != 1) {
            return false;
        }
        synchronized (this.f10368a.f10372a) {
            try {
                r rVar2 = (r) message.obj;
                s sVar2 = (s) this.f10368a.f10372a.get(rVar2);
                if (sVar2 != null && sVar2.f10363b == 3) {
                    String strValueOf = String.valueOf(rVar2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(strValueOf), new Exception());
                    ComponentName componentName = sVar2.f10366h;
                    if (componentName == null) {
                        rVar2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = rVar2.f10359b;
                        l.e(str);
                        componentName = new ComponentName(str, EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    sVar2.onServiceDisconnected(componentName);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return true;
    }
}
