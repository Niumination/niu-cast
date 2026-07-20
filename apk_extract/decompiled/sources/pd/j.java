package pd;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.window.embedding.ActivityEmbeddingController;
import androidx.window.embedding.SplitController;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$bool;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetsliquid.utils.Utils;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k3.z8;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f8764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f8765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f8766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f8767d;
    public static final boolean e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f8768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f8769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f8770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f8771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f8772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f8773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f8774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final char[] f8775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f8776o;
    public static final boolean p;
    public static final boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f8777r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f8778s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f8779t;
    public static final boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f8780v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f8781w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f8782x;

    static {
        String[] strArr = hd.a.f5293a;
        f8764a = strArr;
        String osType = getOsType();
        boolean z2 = false;
        f8765b = strArr[0].equalsIgnoreCase(osType) || TextUtils.isEmpty(osType);
        strArr[1].equalsIgnoreCase(getOsType());
        f8766c = !TextUtils.isEmpty(osType) && osType.toLowerCase().contains(strArr[2].toLowerCase());
        String strB = hd.a.b("ro.tr_animation.platform_level");
        if (TextUtils.isEmpty(strB)) {
            strB = ExifInterface.GPS_MEASUREMENT_3D;
        }
        boolean zEquals = "4".equals(strB);
        boolean zEquals2 = ExifInterface.GPS_MEASUREMENT_3D.equals(strB);
        ExifInterface.GPS_MEASUREMENT_2D.equals(strB);
        "1".equals(strB);
        f8767d = "1".equals(hd.a.b("ro.os_flip_screen_support"));
        e = "1".equals(hd.a.b("ro.os_foldable_screen_support"));
        String strB2 = hd.a.b("ro.tranos.type");
        f = strB2;
        f8768g = TextUtils.equals("tablet", hd.a.b("ro.build.characteristics"));
        f8769h = "1".equals(hd.a.b("ro.os_1g_go.support")) || "1".equals(hd.a.b("ro.os_2g_go.support")) || "1".equals(hd.a.b("ro.os_3g_go.support"));
        f8770i = !TextUtils.isEmpty(strB2);
        f8771j = hd.a.b(Utils.OS_TRANS_VERSION);
        n("14");
        n("15.0.1");
        boolean zN = n("16.1.0");
        f8772k = zN;
        f8773l = n("16.2.0");
        f8774m = getOsVersionCode();
        f8775n = new char[]{'.', 12290, 4962, 2404, 1748};
        if ((zEquals || zEquals2) && zN) {
            z2 = true;
        }
        f8776o = z2;
        String strB3 = hd.a.b("ro.tr_display.liquidglass.support");
        if (TextUtils.isEmpty(strB3)) {
            strB3 = "1";
        }
        boolean zEquals3 = "1".equals(strB3);
        p = zEquals3;
        q = zEquals3;
        f8777r = zEquals3;
        f8778s = zEquals3;
        f8779t = true;
        u = zEquals3;
        f8780v = hd.a.f5296d;
        f8781w = hd.a.e;
        String[] strArr2 = hd.a.f5293a;
        f8782x = new int[]{R$color.os_random_colors_0, R$color.os_random_colors_1, R$color.os_random_colors_2, R$color.os_random_colors_3, R$color.os_random_colors_4, R$color.os_random_colors_5, R$color.os_random_colors_6, R$color.os_random_colors_7, R$color.os_random_colors_8, R$color.os_random_colors_9, R$color.os_random_colors_10, R$color.os_random_colors_11, R$color.os_random_colors_12, R$color.os_random_colors_13, R$color.os_random_colors_14, R$color.os_random_colors_15};
    }

    public static boolean A(Context context) {
        try {
            return ((Boolean) Configuration.class.getMethod("isThunderbackWindow", null).invoke(context.getResources().getConfiguration(), null)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean B(Context context) {
        try {
            int i8 = hd.a.f5294b;
            if (i8 == -1) {
                int identifier = context.getResources().getIdentifier("waterfall_display_left_edge_size", "dimen", "android");
                if ((identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0) <= 0) {
                    hd.a.f5294b = 0;
                    return false;
                }
                hd.a.f5294b = 1;
            } else if (i8 != 1) {
                return false;
            }
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static int C(Context context, ListAdapter listAdapter) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i8 = displayMetrics.widthPixels;
        if (context.getResources().getBoolean(R$bool.os_flag_refs_pad_value) && w(context)) {
            i8 = i(context);
        }
        float f4 = i8;
        int iG = (int) (g(context, R$dimen.os_popup_window_width_max_weight) * f4);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_popup_window_width_min);
        StringBuilder sbR = o.d.r(iG, dimensionPixelSize, " maxAllowedWidth = ", ", minAllowedWidth = ", ", widthPixels = ");
        sbR.append(i8);
        z8.b("widgetslib.Utils", sbR.toString());
        if (iG >= i8) {
            iG = (int) (f4 - TypedValue.applyDimension(1, 16.0f, displayMetrics));
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i9 = 0;
        int i10 = 0;
        View view = null;
        for (int i11 = 0; i11 < count; i11++) {
            int itemViewType = listAdapter.getItemViewType(i11);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = listAdapter.getView(i11, view, null);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= iG) {
                z8.b("widgetslib.Utils", "measureAdapterMaxWidth: width = " + iG);
                return iG;
            }
            if (measuredWidth > i9) {
                i9 = measuredWidth;
            }
        }
        if (i9 > dimensionPixelSize) {
            dimensionPixelSize = i9;
        }
        iG = dimensionPixelSize;
        z8.b("widgetslib.Utils", "measureAdapterMaxWidth: width = " + iG);
        return iG;
    }

    public static int D(Context context, ListAdapter listAdapter) {
        return C(context, listAdapter) + ((context.getResources().getDimensionPixelSize(R$dimen.os_space100) + context.getResources().getDimensionPixelSize(R$dimen.os_popup_menu_inset_left)) * 2);
    }

    public static String E(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i8 = length - 1;
        char cCharAt = str.charAt(i8);
        if (cCharAt == '.' && i8 >= 2) {
            return (str.charAt(length + (-2)) == '.' && str.charAt(length + (-3)) == '.') ? str : str.substring(0, i8);
        }
        for (char c9 : f8775n) {
            if (cCharAt == c9) {
                return str.substring(0, i8);
            }
        }
        return str;
    }

    public static void F(AppCompatActivity appCompatActivity, int i8, int i9, int i10, boolean z2) {
        appCompatActivity.setTheme(c(i8, i9, i10));
        Resources.Theme theme = appCompatActivity.getTheme();
        boolean zB = B(appCompatActivity);
        int i11 = hd.a.f5295c;
        if (i11 == -1) {
            if ("1".equals(hd.a.b("ro.transsion.lcd.type"))) {
                hd.a.f5295c = 1;
                theme.applyStyle(R$style.OSThemOled, true);
            } else {
                hd.a.f5295c = 0;
            }
        } else if (i11 == 1) {
            theme.applyStyle(R$style.OSThemOled, true);
        }
        if (zB) {
            theme.applyStyle(R$style.OsCurseSupport, true);
            if (z2) {
                theme.applyStyle(R$style.actionbar_no_force_padding, true);
            }
            if (appCompatActivity.getWindow() != null) {
                int rotation = appCompatActivity.getDisplay().getRotation();
                if (rotation == 1) {
                    if (z2) {
                        theme.applyStyle(R$style.OSThemeCurve_90_no_force_padding, true);
                    } else {
                        theme.applyStyle(v() ? R$style.OSThemeCurve_90_RTL : R$style.OSThemeCurve_90, true);
                    }
                    theme.applyStyle(R$style.popup_menu_curse_90, true);
                } else if (rotation != 3) {
                    if (z2) {
                        theme.applyStyle(R$style.OSThemeCurve_0_180_no_force_padding, true);
                    } else {
                        theme.applyStyle(R$style.OSThemeCurve_0_180, true);
                    }
                    theme.applyStyle(R$style.popup_menu_curse, true);
                } else {
                    if (z2) {
                        theme.applyStyle(R$style.OSThemeCurve_270_no_force_padding, true);
                    } else {
                        theme.applyStyle(v() ? R$style.OSThemeCurve_270_RTL : R$style.OSThemeCurve_270, true);
                    }
                    theme.applyStyle(R$style.popup_menu_curse_270, true);
                }
            }
            setWindowInset(appCompatActivity);
        }
    }

    public static void G(Window window) {
        z(window.getContext());
        View decorView = window.getDecorView();
        if (!z(window.getContext())) {
            decorView.setSystemUiVisibility(1792);
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility((decorView.getResources().getConfiguration().uiMode & 48) == 32 ? systemUiVisibility & (-17) : systemUiVisibility | 16);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setNavigationBarContrastEnforced(false);
        window.setStatusBarContrastEnforced(false);
    }

    public static boolean a(Context context) {
        return t(context) && !s() && (!r(context) || m(context) || u(context));
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        int i8 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i8 < str.length()) {
            char cCharAt = str.charAt(i8);
            boolean z5 = (cCharAt >= 19968 && cCharAt <= 40959) || (cCharAt >= 13312 && cCharAt <= 19903) || (cCharAt >= 63744 && cCharAt <= 64255);
            boolean z10 = Character.isLetterOrDigit(cCharAt) && !z5;
            if (z5 && z2) {
                sb2.append(' ');
            } else if (z10 && z3) {
                sb2.append(' ');
            }
            sb2.append(cCharAt);
            i8++;
            z3 = z5;
            z2 = z10;
        }
        return sb2.toString();
    }

    public static int c(int i8, int i9, int i10) {
        String osType = getOsType();
        if (TextUtils.isEmpty(osType)) {
            return i8;
        }
        if (f8766c) {
            return i10;
        }
        return osType.equalsIgnoreCase(f8764a[1]) ? i9 : i8;
    }

    public static int d(int i8, int i9, Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i8, typedValue, true) ? context.getColor(typedValue.resourceId) : i9;
    }

    public static int e(Context context, int i8, int i9) {
        return d(i8, context.getColor(i9), context);
    }

    public static int f(int i8, int i9, Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(i8, typedValue, true) ? context.getResources().getDimensionPixelSize(typedValue.resourceId) : i9;
    }

    public static float g(Context context, int i8) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i8, typedValue, true);
        return typedValue.getFloat();
    }

    public static int getHardwareType() {
        String[] strArr = hd.a.f5293a;
        String str = Build.HARDWARE;
        return (TextUtils.isEmpty(str) || !str.startsWith("mt")) ? 2 : 1;
    }

    public static String getOsType() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.tranos.type");
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getOsVersion() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, Utils.OS_TRANS_VERSION);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static int getOsVersionCode() {
        StringBuilder sb2 = new StringBuilder("getOsVersionCode.version:");
        String str = f8771j;
        sb2.append(str);
        sb2.append(" type:");
        String str2 = f;
        sb2.append(str2);
        z8.d("widgetslib.Utils", sb2.toString());
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String strSubstring = str.substring(str2.length());
            String[] strArrSplit = strSubstring.split("\\.");
            z8.d("widgetslib.Utils", "OS version($version) :".concat(strSubstring));
            if (strArrSplit.length >= 2) {
                return Integer.parseInt(strArrSplit[0]);
            }
            return 0;
        } catch (Exception unused) {
            z8.c("widgetslib.Utils", "getOsVersionCode: parse fail.version:" + str + " type:" + str2, null);
            return 0;
        }
    }

    public static int getRandomColor() {
        int[] iArr = f8782x;
        if (iArr == null || iArr.length == 0) {
            throw new RuntimeException("Params error.");
        }
        return iArr[new Random().nextInt(iArr.length)];
    }

    public static int h(Context context) {
        return e(context, R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios);
    }

    public static int i(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int j(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int k(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int l(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static boolean m(Context context) {
        boolean zIsActivityEmbedded = false;
        try {
            if (context instanceof Activity) {
                zIsActivityEmbedded = ActivityEmbeddingController.getInstance(context).isActivityEmbedded((Activity) context);
            } else if (context instanceof ContextThemeWrapper) {
                Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
                if (baseContext instanceof Activity) {
                    zIsActivityEmbedded = ActivityEmbeddingController.getInstance(context).isActivityEmbedded((Activity) baseContext);
                } else if (context instanceof ContextThemeWrapper) {
                    zIsActivityEmbedded = ActivityEmbeddingController.getInstance(context).isActivityEmbedded((Activity) ((ContextThemeWrapper) baseContext).getBaseContext());
                }
            }
        } catch (ClassCastException e4) {
            e4.printStackTrace();
        } catch (NoClassDefFoundError e10) {
            z8.c("widgetslib.Utils", "NoClassDefFoundError - ActivityEmbeddingController class not found. ", e10);
        }
        return zIsActivityEmbedded;
    }

    public static boolean n(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = f8771j;
            if (!TextUtils.isEmpty(str2)) {
                Pattern patternCompile = Pattern.compile("[0-9.]+");
                Matcher matcher = patternCompile.matcher(str2);
                Matcher matcher2 = patternCompile.matcher(str);
                String strGroup = "";
                String strGroup2 = "";
                while (matcher.find()) {
                    strGroup2 = matcher.group();
                }
                while (matcher2.find()) {
                    strGroup = matcher2.group();
                }
                if (strGroup2.equalsIgnoreCase(strGroup)) {
                    return true;
                }
                String[] strArrSplit = strGroup2.split("\\.");
                String[] strArrSplit2 = strGroup.split("\\.");
                for (int i8 = 0; i8 < strArrSplit.length && i8 < strArrSplit2.length; i8++) {
                    int i9 = Integer.parseInt(strArrSplit[i8]);
                    int i10 = Integer.parseInt(strArrSplit2[i8]);
                    if (i9 > i10) {
                        return true;
                    }
                    if (i9 < i10) {
                        return false;
                    }
                }
                if (strArrSplit.length > strArrSplit2.length) {
                    for (int length = strArrSplit2.length; length < strArrSplit.length; length++) {
                        if (Integer.parseInt(strArrSplit[length]) >= 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean o(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("zzzzz_tran_display_edge_size", "dimen", "android");
            return (identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0) > 18;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean p(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return SplitController.getInstance(context).getSplitSupportStatus() == SplitController.SplitSupportStatus.SPLIT_AVAILABLE && ((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / (((float) displayMetrics.densityDpi) / 160.0f) >= 600.0f;
    }

    public static boolean q(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_mode", 0) == 2;
    }

    public static boolean r(Context context) {
        boolean zIsInMultiWindowMode = false;
        try {
            if (context instanceof Activity) {
                zIsInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
            } else if (context instanceof ContextThemeWrapper) {
                Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
                if (baseContext instanceof Activity) {
                    zIsInMultiWindowMode = ((Activity) baseContext).isInMultiWindowMode();
                } else if (context instanceof ContextThemeWrapper) {
                    zIsInMultiWindowMode = ((Activity) ((ContextThemeWrapper) baseContext).getBaseContext()).isInMultiWindowMode();
                }
            }
        } catch (ClassCastException e4) {
            e4.printStackTrace();
        }
        return zIsInMultiWindowMode;
    }

    public static boolean s() {
        if (!f8770i || !f8773l) {
            return false;
        }
        try {
            return 2 == new ad.b().b();
        } catch (NoSuchMethodError e4) {
            z8.c("widgetslib.Utils", "NoSuchMethodError - getSwitchMode() method not found in TranWindowManager", e4);
            return false;
        } catch (SecurityException e10) {
            z8.c("widgetslib.Utils", "SecurityException - Permission denied when accessing TranWindowManager.getSwitchMode()", e10);
            return false;
        }
    }

    public static void setBottomWindowFeatures(@NonNull Window window) {
        G(window);
    }

    public static void setDialogWidth(@NonNull Dialog dialog) {
        Context context = dialog.getContext();
        float fG = g(context, R$dimen.os_dialog_large_screen_width_weight);
        if (t(context) && (!r(context) || m(context) || u(context))) {
            Window window = dialog.getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (p(context)) {
                attributes.width = (int) (((context.getResources().getBoolean(R$bool.os_flag_refs_pad_value) && w(context)) ? i(context) : j(context)) * fG);
            } else {
                attributes.width = Math.min((int) ((w(context) ? i(context) : j(context)) * 0.5f), hd.a.a(context, 400));
            }
            dialog.getWindow().setAttributes(attributes);
            return;
        }
        Window window2 = dialog.getWindow();
        if (window2 == null) {
            return;
        }
        WindowManager.LayoutParams attributes2 = window2.getAttributes();
        if (x(context) || ((!x(context) && r(context)) || z(context))) {
            int i8 = context.getResources().getDisplayMetrics().widthPixels;
            attributes2.width = i8;
            if (i8 <= 70) {
                attributes2.width = hd.a.a(context, context.getResources().getConfiguration().screenWidthDp);
            }
        } else {
            attributes2.width = (int) (context.getResources().getDisplayMetrics().widthPixels * fG);
        }
        dialog.getWindow().setAttributes(attributes2);
    }

    public static void setUltraSmallModeDialogWidth(@NonNull Dialog dialog) {
        Context context = dialog.getContext();
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        int iJ = j(context);
        if (x(context)) {
            if (m(context)) {
                attributes.width = iJ / 2;
            } else {
                attributes.width = iJ;
            }
        } else if (m(context)) {
            attributes.width = ((int) (iJ * g(context, R$dimen.os_dialog_large_screen_width_weight))) / 2;
        } else {
            attributes.width = (int) (iJ * g(context, R$dimen.os_dialog_large_screen_width_weight));
        }
        dialog.getWindow().setAttributes(attributes);
    }

    public static void setWindowInset(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().setOnApplyWindowInsetsListener(new h(context));
        }
    }

    public static boolean t(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return ((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / (((float) displayMetrics.densityDpi) / 160.0f) >= 600.0f && !s();
    }

    public static boolean u(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        boolean z2 = displayMetrics.heightPixels >= (context.getResources().getDisplayMetrics().heightPixels << 1);
        z8.f(null, "isLargerUpDownMultiWindowMode isUpDownMode = " + z2);
        return r(context) && t(context) && z2;
    }

    public static boolean v() {
        String[] strArr = hd.a.f5293a;
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static boolean w(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean x(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static boolean y(Window window) {
        return window.getWindowManager().getDefaultDisplay().getRotation() % 2 == 0;
    }

    public static boolean z(Context context) {
        StringBuilder sb2 = new StringBuilder("isSecondHome: OS_FOLD_FLIP_SCREEN_SUPPORT = ");
        boolean z2 = f8767d;
        sb2.append(z2);
        z8.f("widgetslib.Utils", sb2.toString());
        if (!z2 || !context.isUiContext() || context.getDisplay() == null) {
            return false;
        }
        boolean z3 = (context.getDisplay().getFlags() & 2097152) != 0;
        z8.f("widgetslib.Utils", "isSecondHome: secondHome = " + z3);
        return z3;
    }
}
