package b9;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class p implements lh.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f785b = "p";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f786c = cc.a.a("android.view.IWindowManager$Stub");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f787d = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f788a;

    public final Object a() {
        if (this.f788a == null) {
            this.f788a = cc.a.j(cc.a.g(f786c, "asInterface", IBinder.class), f786c, cc.a.j(cc.a.g(f787d, "getService", String.class), f787d, "window"));
        }
        return this.f788a;
    }

    @Override // lh.p
    public void b(WindowManager.LayoutParams layoutParams) {
        cc.a.j(cc.a.g(layoutParams.getClass(), "setTrustedOverlay", new Class[0]), layoutParams, new Object[0]);
    }

    @Override // lh.p
    public void c(WindowManager.LayoutParams layoutParams, int i10) {
        try {
            Field fieldD = cc.a.d(layoutParams.getClass(), "inputFeatures");
            if (fieldD != null) {
                fieldD.set(layoutParams, Integer.valueOf(i10));
            }
        } catch (Exception e10) {
            p6.b.a("setInputFeatures error: ", e10, f785b);
        }
    }

    @Override // lh.p
    public String d() {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA != null && (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) != null) {
            IBinder iBinder = (IBinder) cc.a.j(methodG, null, "window");
            Class clsA2 = cc.a.a("com.transsion.hubsdk.view.ITranWindowManager$Stub");
            if (iBinder != null && clsA2 != null && (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) != null) {
                return (String) cc.a.j(cc.a.g(objJ.getClass(), "getRefreshRateConfigList", new Class[0]), objJ, new Object[0]);
            }
        }
        return null;
    }

    @Override // lh.p
    public void e(String str) {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "window");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.view.ITranWindowManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "setRefreshRateConfigList", String.class), objJ, str);
    }

    @Override // lh.p
    public int[] f() {
        int[] iArr = new int[0];
        if (a() == null) {
            return iArr;
        }
        Object objJ = cc.a.j(cc.a.g(this.f788a.getClass(), "getTranPictureSupportMode", new Class[0]), this.f788a, new Object[0]);
        return objJ instanceof int[] ? (int[]) objJ : iArr;
    }

    @Override // lh.p
    public void g(int i10, String str) {
        if (a() != null) {
            cc.a.j(cc.a.g(this.f788a.getClass(), "setTranPictureMode", Integer.TYPE, String.class), this.f788a, Integer.valueOf(i10), str);
        }
    }

    @Override // lh.p
    public void h(WindowManager.LayoutParams layoutParams, int i10) {
        Field fieldD = cc.a.d(layoutParams.getClass(), "privateFlags");
        try {
            fieldD.set(layoutParams, Integer.valueOf(i10 | fieldD.getInt(layoutParams)));
        } catch (Exception e10) {
            p6.b.a("setPrivateFlags fail: ", e10, f785b);
        }
    }

    @Override // lh.p
    public boolean i() {
        Method methodG;
        Boolean bool;
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.view.WindowManagerGlobal"), "getWindowManagerService", new Class[0]), null, new Object[0]);
        return (objJ == null || (methodG = cc.a.g(objJ.getClass(), "isOccluded", new Class[0])) == null || (bool = (Boolean) cc.a.j(methodG, objJ, new Object[0])) == null || !bool.booleanValue()) ? false : true;
    }

    @Override // lh.p
    public String j() {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA != null && (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) != null) {
            IBinder iBinder = (IBinder) cc.a.j(methodG, null, "window");
            Class clsA2 = cc.a.a("com.transsion.hubsdk.view.ITranWindowManager$Stub");
            if (iBinder != null && clsA2 != null && (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) != null) {
                return (String) cc.a.j(cc.a.g(objJ.getClass(), "getDefaultRefreshRateConfigList", new Class[0]), objJ, new Object[0]);
            }
        }
        return null;
    }

    @Override // lh.p
    public int k(String str) {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return 0;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "window");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.view.ITranWindowManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return 0;
        }
        return ((Integer) cc.a.j(cc.a.g(objJ.getClass(), "getAppRefreshRate", String.class), objJ, str)).intValue();
    }

    @Override // lh.p
    public int l(WindowManager.LayoutParams layoutParams) {
        Field fieldD = cc.a.d(layoutParams.getClass(), "privateFlags");
        if (fieldD != null) {
            return ((Integer) cc.a.f(fieldD, layoutParams)).intValue();
        }
        return 0;
    }

    @Override // lh.p
    public void m(WindowManager.LayoutParams layoutParams, int i10) {
        Field fieldD = cc.a.d(layoutParams.getClass(), "tranLayoutInDisplayCutoutMode");
        if (fieldD == null) {
            dc.e.a(f785b, "setCutoutMode fail: cannot find tranLayoutInDisplayCutoutMode");
            return;
        }
        try {
            fieldD.set(layoutParams, Integer.valueOf(i10));
        } catch (Exception e10) {
            p6.b.a("setCutoutMode fail: ", e10, f785b);
        }
    }

    @Override // lh.p
    public Bitmap n() {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.view.IWindowManager"), "tranScreenshotWallpaperLocked", new Class[0]), cc.a.j(cc.a.g(cc.a.a("android.view.WindowManagerGlobal"), "getWindowManagerService", new Class[0]), null, new Object[0]), new Object[0]);
        if (objJ instanceof Bitmap) {
            return (Bitmap) objJ;
        }
        return null;
    }

    @Override // lh.p
    public List<String> o(int i10) {
        ArrayList arrayList = new ArrayList();
        if (a() != null) {
            Object objJ = cc.a.j(cc.a.g(this.f788a.getClass(), "getTranPictureList", Integer.TYPE), this.f788a, Integer.valueOf(i10));
            if (objJ instanceof List) {
                Iterator it = ((List) objJ).iterator();
                while (it.hasNext()) {
                    arrayList.add((String) String.class.cast(it.next()));
                }
            }
        }
        return arrayList;
    }
}
