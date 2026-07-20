package pd;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.widgetPerGuide.perguide.PerGuideBaseDialog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import k3.z8;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f8728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static float f8729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f8730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static float f8731d;
    public static final c e;
    public static boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Method f8732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f8733h;

    static {
        float f4;
        Class<?> cls;
        Method declaredMethod;
        Constructor<?> constructor;
        String[] strArr = j.f8764a;
        f8728a = Intrinsics.areEqual("1", hd.a.b("ro.tran.display.resolution.switch.support")) || Intrinsics.areEqual("1", hd.a.b("ro.tr_display.resolution.switch.support"));
        Object objNewInstance = null;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls2.getMethod("get", String.class).invoke(cls2, "ro.sf.lcd_density");
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            f4 = Float.parseFloat((String) objInvoke) / 160;
        } catch (Exception e4) {
            e4.printStackTrace();
            z8.c("ScreenDensityAdapter", "getSystemProperties Exception " + e4.getMessage(), null);
            f4 = 3.0f;
        }
        z8.b("ScreenDensityAdapter", "getSystemBaseDensity: value = " + f4);
        f8730c = f4;
        f8731d = 1.0f;
        c cVar = new c();
        cVar.f8724a = f4;
        cVar.f8725b = 1.0f;
        cVar.f8726c = 0;
        cVar.f8727d = 360;
        cVar.e = 0;
        e = cVar;
        if (f8728a) {
            try {
                cls = Class.forName("com.transsion.hubsdk.hardware.display.TranDisplayManagerGlobal");
            } catch (Exception e10) {
                e10.printStackTrace();
                cls = null;
            }
            try {
                declaredMethod = cls.getDeclaredMethod("getDensityDpi", Integer.TYPE);
                try {
                    declaredMethod.setAccessible(true);
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                }
            } catch (Exception e12) {
                e = e12;
                declaredMethod = null;
            }
            f8732g = declaredMethod;
            if (cls != null && (constructor = cls.getConstructor(null)) != null) {
                objNewInstance = constructor.newInstance(null);
            }
            f8733h = objNewInstance;
        }
    }

    public static float a() {
        Method method;
        try {
            Object obj = f8733h;
            if (obj == null || (method = f8732g) == null) {
                return 3.25f;
            }
            Object objInvoke = method.invoke(obj, 0);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) objInvoke).intValue() / 160;
        } catch (Exception e4) {
            e4.printStackTrace();
            z8.c("ScreenDensityAdapter", "getDisplayResolutionBaseDensity Exception " + e4.getMessage(), null);
            return 3.25f;
        }
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return (int) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static final void c(AppCompatActivity context, Application application) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(application, "application");
        d(context);
    }

    public static final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!j.f8770i) {
            z8.d("ScreenDensityAdapter", "setCustomDensity: isn't tran devices, don't need adapt.");
            return;
        }
        if (j.f8767d) {
            z8.d("ScreenDensityAdapter", "setCustomDensity: isFlipScreen, don't need adapt.");
            return;
        }
        if (j.e) {
            z8.d("ScreenDensityAdapter", "setCustomDensity: isFoldScreen, don't need adapt.");
            return;
        }
        float fA = f8730c;
        boolean z2 = f8728a;
        float fA2 = z2 ? a() : fA;
        int iB = (int) (b(context) / fA2);
        if (iB > 600) {
            z8.d("ScreenDensityAdapter", "setCustomDensity: is large screen, don't need adapt.");
            return;
        }
        if (iB == 360) {
            z8.f("ScreenDensityAdapter", "setCustomDensity: baseWidthDp == realWidthDp, don't need adapt. baseDensity = " + fA2);
            return;
        }
        f = true;
        Configuration configuration = context.getApplicationContext().getResources().getConfiguration();
        float f4 = configuration.densityDpi / 160.0f;
        f8729b = configuration.fontScale;
        if (z2) {
            fA = a();
        }
        z8.f("ScreenDensityAdapter", "setCustomDensity: before density = " + f4 + " scaledDensity = " + f8729b + " baseWidthDp = 360 IS_DISPLAY_RESOLUTION = " + z2);
        float f10 = f4 / fA;
        float fB = (((float) b(context)) * f10) / ((float) 360);
        f8731d = fB / f4;
        float f11 = f8729b * fB;
        int i8 = (int) (((float) 160) * fB);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.density = fB;
        displayMetrics.scaledDensity = f11;
        displayMetrics.densityDpi = i8;
        c cVar = e;
        cVar.setDensity(fB);
        cVar.setScaledDensity(displayMetrics.scaledDensity);
        cVar.setDensityDpi(displayMetrics.densityDpi);
        Configuration configuration2 = context.getResources().getConfiguration();
        configuration2.screenWidthDp = (int) (displayMetrics.widthPixels / displayMetrics.density);
        configuration2.screenHeightDp = (int) (displayMetrics.heightPixels / displayMetrics.density);
        cVar.setScreenWidthDp(configuration2.screenWidthDp);
        cVar.setScreenHeightDp(configuration2.screenHeightDp);
        if (!Intrinsics.areEqual(context, context.getApplicationContext())) {
            DisplayMetrics displayMetrics2 = context.getApplicationContext().getResources().getDisplayMetrics();
            displayMetrics2.density = fB;
            displayMetrics2.scaledDensity = f11;
            displayMetrics2.densityDpi = i8;
            configuration.screenWidthDp = (int) (displayMetrics2.widthPixels / fB);
            configuration.screenHeightDp = (int) (displayMetrics2.heightPixels / displayMetrics2.density);
        }
        z8.f("ScreenDensityAdapter", "setCustomDensity: apply targetDensity = " + fB + " targetScaledDensity = " + f11 + " targetDensityDpi = " + i8 + " sFontScale = " + f8729b + " BaseDensity = " + fA + " cusScaleFactor = " + f10 + " glScaleRatio = " + f8731d);
    }

    public static final void e(Resources resources, PerGuideBaseDialog context) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (f) {
            int i8 = displayMetrics.densityDpi;
            c cVar = e;
            if (i8 != cVar.getDensityDpi()) {
                z8.d("ScreenDensityAdapter", "updResource: CONFIG.densityDpi = " + cVar.getDensityDpi());
                displayMetrics.density = cVar.getDensity();
                displayMetrics.densityDpi = cVar.getDensityDpi();
                displayMetrics.scaledDensity = cVar.getScaledDensity();
                Configuration configuration = resources.getConfiguration();
                configuration.screenWidthDp = cVar.getScreenWidthDp();
                configuration.screenHeightDp = cVar.getScreenHeightDp();
                if (context.getApplicationContext() != context) {
                    Resources resources2 = context.getApplicationContext().getResources();
                    Intrinsics.checkNotNullExpressionValue(resources2, "context.applicationContext.resources");
                    DisplayMetrics displayMetrics2 = resources2.getDisplayMetrics();
                    displayMetrics2.density = cVar.getDensity();
                    displayMetrics2.densityDpi = cVar.getDensityDpi();
                    displayMetrics2.scaledDensity = cVar.getScaledDensity();
                    Configuration configuration2 = resources2.getConfiguration();
                    configuration2.screenWidthDp = cVar.getScreenWidthDp();
                    configuration2.screenHeightDp = cVar.getScreenHeightDp();
                }
            }
        }
    }

    @JvmStatic
    public static final void setCustomDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d(context);
    }
}
