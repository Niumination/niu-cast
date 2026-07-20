package qj;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.View;
import android.view.WindowInsets;
import com.transsion.widgetsThemes.R;
import dc.d;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14019a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14020b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14021c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14022d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14023e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14024f = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f14026h = "widgetslib.Utils";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f14028j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f14029k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f14030l = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f14032n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f14033o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f14034p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f14035q = "ro.transsion.lcd.type";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f14036r = "1";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f14037s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f14038t = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f14025g = {"hios", "xos", "itel"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f14027i = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f14031m = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f14039u = d("ro.tranos.type");

    public class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f14040a;

        public a(Context context) {
            this.f14040a = context;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (this.f14040a == null) {
                return windowInsets;
            }
            Insets insets = windowInsets.getInsets(WindowInsets.Side.all());
            Display display = this.f14040a.getDisplay();
            boolean zE = c.e(this.f14040a);
            if (display != null) {
                if (display.getRotation() == 1) {
                    windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), Insets.of(0, insets.top, zE ? 0 : insets.right, 0)).build();
                } else if (display.getRotation() == 3) {
                    windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), Insets.of(zE ? 0 : insets.left, insets.top, 0, 0)).build();
                } else {
                    windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Side.all(), Insets.of(0, insets.top, 0, insets.bottom)).build();
                }
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    public static int a(int i10, int i11, int i12) {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return i10;
        }
        String[] strArr = f14025g;
        if (strC.equalsIgnoreCase(strArr[2])) {
            return i12;
        }
        return strC.equalsIgnoreCase(strArr[1]) ? i11 : i10;
    }

    public static int b(boolean z10, int i10) {
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return R.style.OS_Theme_Material_hios;
        }
        String[] strArr = f14025g;
        if (strC.equalsIgnoreCase(strArr[0])) {
            if (z10) {
                return i10 == 0 ? R.style.OS_Theme_Material_hios : R.style.OS_Theme_AppCompat_hios;
            }
            return i10 == 0 ? R.style.OS_Theme_Material_hios_NoActionBar : R.style.OS_Theme_AppCompat_hios_NoActionBar;
        }
        if (strC.equalsIgnoreCase(strArr[1])) {
            if (z10) {
                return i10 == 0 ? R.style.OS_Theme_Material_xos : R.style.OS_Theme_AppCompat_xos;
            }
            return i10 == 0 ? R.style.OS_Theme_Material_xos_NoActionBar : R.style.OS_Theme_AppCompat_xos_NoActionBar;
        }
        if (z10) {
            return i10 == 0 ? R.style.OS_Theme_Material_itel : R.style.OS_Theme_AppCompat_itel;
        }
        return i10 == 0 ? R.style.OS_Theme_Material_itel_NoActionBar : R.style.OS_Theme_AppCompat_itel_NoActionBar;
    }

    public static String c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.tranos.type");
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e("widgetslib.Utils", "getSystemProperties Exception " + e10.getMessage());
            return "";
        }
    }

    public static boolean e(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_mode", 0) == 2;
    }

    public static boolean f() {
        int i10 = f14031m;
        if (i10 != -1) {
            return i10 == 1;
        }
        if ("1".equals(d("ro.transsion.lcd.type"))) {
            f14031m = 1;
            return true;
        }
        f14031m = 0;
        return false;
    }

    public static boolean g() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static boolean h(Context context) {
        try {
            int i10 = f14027i;
            if (i10 != -1) {
                return i10 == 1;
            }
            int identifier = context.getResources().getIdentifier("waterfall_display_left_edge_size", d.f3680k, "android");
            if ((identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0) > 0) {
                f14027i = 1;
                return true;
            }
            f14027i = 0;
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void i(Context context, int i10, int i11, int i12) {
        k(context, i10, i11, i12, true, true);
    }

    public static void j(Context context, int i10, int i11, int i12, boolean z10) {
        k(context, i10, i11, i12, z10, true);
    }

    public static void k(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        context.setTheme(a(i10, i11, i12));
        if (context instanceof ContextThemeWrapper) {
            Resources.Theme theme = context.getTheme();
            boolean zH = h(context);
            if (f()) {
                theme.applyStyle(R.style.OSThemOled, true);
            }
            if (zH) {
                theme.applyStyle(R.style.OsCurseSupport, true);
                if (z10) {
                    theme.applyStyle(R.style.actionbar_no_force_padding, true);
                }
                m(context, theme, z10);
                if (z11) {
                    n(context);
                }
            }
        }
    }

    @Deprecated
    public static void l(Context context, boolean z10, int i10) {
        context.setTheme(b(z10, i10));
    }

    public static void m(Context context, Resources.Theme theme, boolean z10) {
        if (!(context instanceof Activity) || ((Activity) context).getWindow() == null) {
            return;
        }
        int rotation = context.getDisplay().getRotation();
        if (rotation == 1) {
            if (z10) {
                theme.applyStyle(R.style.OSThemeCurve_90_no_force_padding, true);
            } else {
                theme.applyStyle(g() ? R.style.OSThemeCurve_90_RTL : R.style.OSThemeCurve_90, true);
            }
            theme.applyStyle(R.style.popup_menu_curse_90, true);
            return;
        }
        if (rotation != 3) {
            if (z10) {
                theme.applyStyle(R.style.OSThemeCurve_0_180_no_force_padding, true);
            } else {
                theme.applyStyle(R.style.OSThemeCurve_0_180, true);
            }
            theme.applyStyle(R.style.popup_menu_curse, true);
            return;
        }
        if (z10) {
            theme.applyStyle(R.style.OSThemeCurve_270_no_force_padding, true);
        } else {
            theme.applyStyle(g() ? R.style.OSThemeCurve_270_RTL : R.style.OSThemeCurve_270, true);
        }
        theme.applyStyle(R.style.popup_menu_curse_270, true);
    }

    public static void n(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().setOnApplyWindowInsetsListener(new a(context));
        }
    }
}
