package e9;

import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements oh.b {
    @Override // oh.b
    public WindowManager.LayoutParams a(Toast toast) {
        Method methodG = cc.a.g(toast.getClass(), "getWindowParams", new Class[0]);
        if (methodG != null) {
            return (WindowManager.LayoutParams) cc.a.j(methodG, toast, new Object[0]);
        }
        return null;
    }
}
