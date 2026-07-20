package b9;

import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class k implements lh.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f774a = "k";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f775b = cc.a.a("android.view.View");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f776c = cc.a.a("android.view.View$ListenerInfo");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f777d = cc.a.a("android.view.Window");

    @Override // lh.k
    public void a(Window window, int i10) {
        try {
            Method methodG = cc.a.g(f777d, "getDecorView", new Class[0]);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, window, new Object[0]);
            if (objJ == null || !(objJ instanceof View)) {
                return;
            }
            Method methodG2 = cc.a.g(f775b, "setSystemUiVisibility", Integer.TYPE);
            methodG2.setAccessible(true);
            methodG2.invoke((View) objJ, Integer.valueOf(i10));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            dc.e.c(f774a, "setSystemUiVisibility fail " + e10);
        }
    }

    @Override // lh.k
    public boolean b(View view, boolean z10, float f10, int i10) {
        Method methodG = cc.a.g(view.getClass(), "enableBackdropBlurFilter", Boolean.TYPE, Float.TYPE, Integer.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, view, Boolean.valueOf(z10), Float.valueOf(f10), Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // lh.k
    public void c(View view) {
        dc.e.c(f774a, "clearUnionRenderEffect not support");
    }

    @Override // lh.k
    public boolean d(View view, boolean z10) {
        Method methodG = cc.a.g(view.getClass(), "forceRenderSdrUnderHdr", Boolean.TYPE);
        if (methodG != null) {
            return Boolean.TRUE.equals(cc.a.j(methodG, view, Boolean.valueOf(z10)));
        }
        return false;
    }

    @Override // lh.k
    public boolean e(View view, boolean z10, float f10) {
        Method methodG = cc.a.g(view.getClass(), "enableBackdropBlurFilter", Boolean.TYPE, Float.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, view, Boolean.valueOf(z10), Float.valueOf(f10))).booleanValue();
        }
        return false;
    }

    @Override // lh.k
    public boolean f(View view, Consumer<View> consumer) {
        dc.e.c(f774a, "setOnUnionRenderFrameAvailableListener not support");
        return false;
    }

    @Override // lh.k
    public boolean g(View view) {
        try {
            Field fieldD = cc.a.d(f775b, "mRecreateDisplayList");
            fieldD.setAccessible(true);
            Object obj = fieldD.get(view);
            if (obj == null || !(obj instanceof Boolean)) {
                return false;
            }
            return ((Boolean) obj).booleanValue();
        } catch (IllegalAccessException e10) {
            dc.e.c(f774a, "isRecreateDisplayList fail " + e10);
            return false;
        }
    }

    @Override // lh.k
    public boolean h(View view) {
        try {
            Method methodG = cc.a.g(f775b, "getListenerInfo", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(view, null);
            Field fieldD = cc.a.d(f776c, "mOnKeyListener");
            fieldD.setAccessible(true);
            return fieldD.get(objInvoke) != null;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            dc.e.c(f774a, "hasSetKeyListener fail " + e10);
            return false;
        }
    }

    @Override // lh.k
    public boolean i(View view, boolean z10) {
        dc.e.c(f774a, "setPromoteLayerEnabled not support");
        return false;
    }

    @Override // lh.k
    public rb.l j(View view) {
        dc.e.c(f774a, "getUnionRenderEffect not support");
        return null;
    }

    @Override // lh.k
    public void k(View view, rb.l lVar) {
        dc.e.c(f774a, "setUnionRenderEffect not support");
    }

    @Override // lh.k
    public void l(View view, Bitmap bitmap) {
        dc.e.c(f774a, "setMaterialNoise not support");
    }
}
