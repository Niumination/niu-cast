package d7;

import android.graphics.drawable.VectorDrawable;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class f implements of.f {
    @Override // of.f
    public boolean a(VectorDrawable vectorDrawable, int i10, int i11, int i12, String str) {
        Boolean bool;
        Class<?> cls = vectorDrawable.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "updateIconColor", cls2, cls2, cls2, String.class);
        if (methodG == null || (bool = (Boolean) cc.a.j(methodG, vectorDrawable, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
