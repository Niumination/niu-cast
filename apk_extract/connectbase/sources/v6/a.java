package v6;

import android.content.BroadcastReceiver;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements hf.a {
    @Override // hf.a
    public int a(BroadcastReceiver broadcastReceiver) {
        Method methodG = cc.a.g(BroadcastReceiver.class, "getSendingUserId", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, broadcastReceiver, new Object[0])).intValue();
        }
        return 0;
    }
}
