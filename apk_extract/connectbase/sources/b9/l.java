package b9;

import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class l implements lh.l {
    @Override // lh.l
    public int a() {
        Method methodG = cc.a.g(ViewConfiguration.class, "getHoverTapSlop", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, null, new Object[0])).intValue();
        }
        return 20;
    }

    @Override // lh.l
    public int b() {
        Method methodG = cc.a.g(ViewConfiguration.class, "getHoverTapTimeout", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, null, new Object[0])).intValue();
        }
        return 150;
    }
}
