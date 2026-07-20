package f9;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ph.a {
    @Override // ph.a
    public void a(int i10) {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "display_rotation");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.window.ITranDisplayRotationManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "onNotifySaveRotation", Integer.TYPE), objJ, Integer.valueOf(i10));
    }
}
