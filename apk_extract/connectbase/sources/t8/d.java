package t8;

import android.telephony.ServiceState;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d implements dh.d {
    @Override // dh.d
    public int a(ServiceState serviceState) {
        Method methodG = cc.a.g(serviceState.getClass(), "getDataNetworkType", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, serviceState, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // dh.d
    public int b(ServiceState serviceState) {
        Method methodG = cc.a.g(serviceState.getClass(), "getVoiceRegState", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, serviceState, new Object[0])).intValue();
        }
        return 0;
    }
}
