package u8;

import android.telephony.ims.feature.ImsFeature;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public boolean a(Object obj, int i10) {
        if (obj instanceof ImsFeature.Capabilities) {
            ImsFeature.Capabilities capabilities = (ImsFeature.Capabilities) obj;
            Method methodG = cc.a.g(capabilities.getClass(), "isCapable", Integer.TYPE);
            if (methodG != null) {
                return ((Boolean) cc.a.j(methodG, capabilities, Integer.valueOf(i10))).booleanValue();
            }
        }
        return false;
    }
}
