package v7;

import com.android.internal.widget.LockPatternView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public void a(Object obj, int i10, int i11, int i12) {
        LockPatternView lockPatternView;
        if (!(obj instanceof LockPatternView) || (lockPatternView = (LockPatternView) obj) == null) {
            return;
        }
        Class<?> cls = lockPatternView.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "setColors", cls2, cls2, cls2);
        if (methodG != null) {
            cc.a.j(methodG, lockPatternView, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }
    }

    public void b(Object obj, int i10) {
        LockPatternView lockPatternView;
        Method methodG;
        if (!(obj instanceof LockPatternView) || (lockPatternView = (LockPatternView) obj) == null || (methodG = cc.a.g(lockPatternView.getClass(), "setDotSize", Integer.TYPE)) == null) {
            return;
        }
        cc.a.j(methodG, lockPatternView, Integer.valueOf(i10));
    }

    public void c(Object obj, int i10) {
        LockPatternView lockPatternView;
        Method methodG;
        if (!(obj instanceof LockPatternView) || (lockPatternView = (LockPatternView) obj) == null || (methodG = cc.a.g(lockPatternView.getClass(), "setPathWidth", Integer.TYPE)) == null) {
            return;
        }
        cc.a.j(methodG, lockPatternView, Integer.valueOf(i10));
    }
}
