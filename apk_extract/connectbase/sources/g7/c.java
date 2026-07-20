package g7;

import android.view.Display;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements rf.c {
    @Override // rf.c
    public Display a(int i10) {
        Object objJ;
        Method methodG;
        Method methodG2 = cc.a.g(cc.a.a("android.hardware.display.DisplayManagerGlobal"), "getInstance", new Class[0]);
        if (methodG2 == null || (objJ = cc.a.j(methodG2, null, new Object[0])) == null || (methodG = cc.a.g(objJ.getClass(), "getRealDisplay", Integer.TYPE)) == null) {
            return null;
        }
        return (Display) cc.a.j(methodG, objJ, Integer.valueOf(i10));
    }
}
