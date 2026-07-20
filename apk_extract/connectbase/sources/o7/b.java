package o7;

import com.android.internal.graphics.drawable.BackgroundBlurDrawable;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public void a(Object obj, float f10) {
        BackgroundBlurDrawable backgroundBlurDrawable;
        Method methodG;
        if (!(obj instanceof BackgroundBlurDrawable) || (backgroundBlurDrawable = (BackgroundBlurDrawable) obj) == null || (methodG = cc.a.g(backgroundBlurDrawable.getClass(), "setBlurSaturation", Float.TYPE)) == null) {
            return;
        }
        cc.a.j(methodG, backgroundBlurDrawable, Float.valueOf(f10));
    }
}
