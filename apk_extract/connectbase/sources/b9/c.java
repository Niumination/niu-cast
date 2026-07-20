package b9;

import android.view.DisplayCutout;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements lh.c {
    @Override // lh.c
    public boolean a(DisplayCutout displayCutout) {
        List list;
        Method methodG = cc.a.g(displayCutout.getClass(), "getBoundingRects", new Class[0]);
        if (methodG == null || (list = (List) cc.a.j(methodG, displayCutout, new Object[0])) == null) {
            return false;
        }
        return list.isEmpty();
    }
}
