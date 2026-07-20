package t8;

import android.telephony.NetworkRegistrationInfo;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements dh.c {
    @Override // dh.c
    public boolean a(NetworkRegistrationInfo networkRegistrationInfo) {
        Method methodG = cc.a.g(networkRegistrationInfo.getClass(), "isInService", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, networkRegistrationInfo, new Object[0])).booleanValue();
        }
        return false;
    }
}
