package hj;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.window.embedding.ActivityFilter;
import androidx.window.embedding.ActivityRule;
import androidx.window.embedding.SplitController;
import com.transsion.widgetslib.R;
import java.io.InputStream;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static final int A = 1;
    public static final int B = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7208a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7209b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7210c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7211d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7212e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7213f = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f7223p = "widgetslib.Utils";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7225r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f7226s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f7227t = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7229v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f7230w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f7231x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f7232y = "ro.transsion.lcd.type";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f7233z = "1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f7214g = ui.a.f16267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f7215h = {R.drawable.os_ic_back_hios, R.drawable.os_ic_back_xos, R.drawable.os_ic_back_itel};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f7216i = {R.drawable.os_ic_close_hios, R.drawable.os_ic_close_xos, R.drawable.os_ic_close_itel};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f7217j = {R.drawable.os_ic_save_hios, R.drawable.os_ic_save_xos, R.drawable.os_ic_save_itel};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f7218k = {R.drawable.os_ic_search_hios, R.drawable.os_ic_search_xos, R.drawable.os_ic_search_itel};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f7219l = {R.drawable.os_ic_edit_hios, R.drawable.os_ic_edit_xos, R.drawable.os_ic_edit_itel};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f7220m = {R.drawable.os_ic_more_hios, R.drawable.os_ic_more_xos, R.drawable.os_ic_more_itel};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f7221n = {R.drawable.os_ic_settings_hios, R.drawable.os_ic_settings_xos, R.drawable.os_ic_settings_itel};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f7222o = {R.drawable.os_ic_add_hios, R.drawable.os_ic_add_xos, R.drawable.os_ic_add_itel};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f7224q = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f7228u = -1;
    public static String C = ui.a.l("ro.tranos.type");
    public static boolean D = ui.a.f16281u;

    public class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7234a;

        public a(Context context) {
            this.f7234a = context;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (this.f7234a == null) {
                return windowInsets;
            }
            Insets insets = windowInsets.getInsets(WindowInsets.Side.all());
            Display display = this.f7234a.getDisplay();
            boolean zE = h.E(this.f7234a);
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

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f7236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Dialog f7237c;

        public b(boolean z10, boolean z11, Dialog dialog) {
            this.f7235a = z10;
            this.f7236b = z11;
            this.f7237c = dialog;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Dialog dialog;
            if (!this.f7235a || !this.f7236b) {
                return false;
            }
            if (motionEvent.getAction() == 1 && (dialog = this.f7237c) != null && dialog.isShowing()) {
                this.f7237c.cancel();
            }
            return true;
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f7239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Dialog f7240c;

        public c(boolean z10, boolean z11, Dialog dialog) {
            this.f7238a = z10;
            this.f7239b = z11;
            this.f7240c = dialog;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Dialog dialog;
            if (!this.f7238a || !this.f7239b) {
                return false;
            }
            if (motionEvent.getAction() == 1 && (dialog = this.f7240c) != null && dialog.isShowing()) {
                this.f7240c.cancel();
            }
            return true;
        }
    }

    public static boolean A() {
        return SplitController.getInstance().isSplitSupported();
    }

    public static boolean B(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return A() && ((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) / (((float) displayMetrics.densityDpi) / 160.0f) >= 600.0f;
    }

    public static boolean C(Context context) {
        return B(context) && !x(context);
    }

    public static boolean D(Context context) {
        return B(context) && x(context);
    }

    public static boolean E(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_mode", 0) == 2;
    }

    public static boolean F(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isInMultiWindowMode();
        }
        if (!(context instanceof ContextWrapper)) {
            return false;
        }
        ContextWrapper contextWrapper = (ContextWrapper) context;
        if (contextWrapper.getBaseContext() instanceof Activity) {
            return ((Activity) contextWrapper.getBaseContext()).isInMultiWindowMode();
        }
        return false;
    }

    public static boolean G() {
        return !TextUtils.isEmpty(o());
    }

    public static boolean H() {
        return ui.a.r();
    }

    public static boolean I() {
        return ui.a.s();
    }

    public static boolean J() {
        return ui.a.t();
    }

    public static boolean K(Context context) {
        return ui.a.u(context);
    }

    public static boolean L() {
        String[] strArr = f7214g;
        return TextUtils.equals(strArr[1], C) || TextUtils.equals(strArr[2], C);
    }

    public static float M(Paint paint) {
        return ui.a.v(paint);
    }

    public static void N(Context context, Dialog dialog, boolean z10, boolean z11) {
        dialog.getWindow().getDecorView().setOnTouchListener(new c(z10, z11, dialog));
    }

    public static void O(Context context, int i10, int i11, int i12) {
        Q(context, i10, i11, i12, true, true);
    }

    public static void P(Context context, int i10, int i11, int i12, boolean z10) {
        Q(context, i10, i11, i12, z10, true);
    }

    public static void Q(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        context.setTheme(i(i10, i11, i12));
        if (context instanceof ContextThemeWrapper) {
            Resources.Theme theme = context.getTheme();
            boolean zU = ui.a.u(context);
            if (ui.a.r()) {
                theme.applyStyle(R.style.OSThemOled, true);
            }
            if (zU) {
                theme.applyStyle(R.style.OsCurseSupport, true);
                if (z10) {
                    theme.applyStyle(R.style.actionbar_no_force_padding, true);
                }
                S(context, theme, z10);
                if (z11) {
                    X(context);
                }
            }
        }
    }

    @Deprecated
    public static void R(Context context, boolean z10, int i10) {
        context.setTheme(j(z10, i10));
    }

    public static void S(Context context, Resources.Theme theme, boolean z10) {
        if (!(context instanceof Activity) || ((Activity) context).getWindow() == null) {
            return;
        }
        int rotation = context.getDisplay().getRotation();
        if (rotation == 1) {
            if (z10) {
                theme.applyStyle(R.style.OSThemeCurve_90_no_force_padding, true);
            } else {
                theme.applyStyle(ui.a.s() ? R.style.OSThemeCurve_90_RTL : R.style.OSThemeCurve_90, true);
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
            theme.applyStyle(ui.a.s() ? R.style.OSThemeCurve_270_RTL : R.style.OSThemeCurve_270, true);
        }
        theme.applyStyle(R.style.popup_menu_curse_270, true);
    }

    public static void T(Context context, Dialog dialog, boolean z10, boolean z11) {
        Drawable drawable;
        if (dialog == null) {
            Log.i("widgetslib.Utils", "setDialogWindowBackGround dialog null return");
            return;
        }
        Resources resources = context.getResources();
        boolean zU = ui.a.u(context);
        if (resources.getConfiguration().orientation == 1) {
            if (E(context)) {
                drawable = ContextCompat.getDrawable(context, zU ? R.drawable.os_dialog_background_nav_gone_curve : R.drawable.os_dialog_background_nav_gone);
            } else {
                drawable = ContextCompat.getDrawable(context, zU ? R.drawable.os_dialog_background_curve : R.drawable.os_dialog_background);
            }
            dialog.getWindow().setGravity(80);
        } else {
            drawable = ContextCompat.getDrawable(context, zU ? R.drawable.os_dialog_background_land_curve : R.drawable.os_dialog_background_land);
            dialog.getWindow().setGravity(17);
        }
        dialog.getWindow().setBackgroundDrawable(drawable);
        dialog.getWindow().getDecorView().setOnTouchListener(new b(z10, z11, dialog));
    }

    public static void U(Context context, Window window) {
        Drawable drawable;
        if (window == null) {
            Log.i("widgetslib.Utils", "setDialogWindowBackGround window null return");
            return;
        }
        Resources resources = context.getResources();
        boolean zU = ui.a.u(context);
        if (resources.getConfiguration().orientation != 1) {
            drawable = ContextCompat.getDrawable(context, zU ? R.drawable.os_dialog_background_land_curve : R.drawable.os_dialog_background_land);
        } else if (E(context)) {
            drawable = ContextCompat.getDrawable(context, zU ? R.drawable.os_input_dialog_background_nav_gone_curve : R.drawable.os_input_dialog_background_nav_gone);
        } else {
            drawable = ContextCompat.getDrawable(context, zU ? R.drawable.os_input_dialog_background_curve : R.drawable.os_input_dialog_background);
        }
        window.setBackgroundDrawable(drawable);
    }

    public static void V(Context context, Menu menu, int i10) {
        W(context, menu, i10, false);
    }

    public static void W(Context context, Menu menu, int i10, boolean z10) {
        int iN = n(context);
        if (z10) {
            ui.a.y(menu, i10, iN, R.drawable.os_list_popup_item_selected2, R.drawable.os_list_popup_item_selected_space);
        } else {
            ui.a.x(menu, i10, iN);
        }
    }

    public static void X(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().setOnApplyWindowInsetsListener(new a(context));
        }
    }

    public static int Y(int i10) {
        return ui.a.B(i10);
    }

    public static InputStream a(Bitmap bitmap) {
        return ui.a.a(bitmap);
    }

    public static int b(BitmapFactory.Options options, int i10, int i11) {
        return ui.a.b(options, i10, i11);
    }

    public static Bitmap c(Context context, Drawable drawable, int i10) {
        return ui.a.c(context, drawable, i10);
    }

    public static ActivityRule d(String str, String str2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new ActivityFilter(new ComponentName(str, str2), null));
        return new ActivityRule(linkedHashSet, true);
    }

    public static int e(Context context, int i10) {
        return ui.a.d(context, i10);
    }

    public static Bitmap f(Context context, Drawable drawable, int i10) {
        return ui.a.e(context, drawable, i10);
    }

    public static InputStream g(Context context, Drawable drawable, int i10) {
        return ui.a.f(context, drawable, i10);
    }

    public static Bitmap h(Drawable drawable) {
        return ui.a.g(drawable);
    }

    public static int i(int i10, int i11, int i12) {
        String strO = o();
        if (TextUtils.isEmpty(strO)) {
            return i10;
        }
        String[] strArr = f7214g;
        if (strO.equalsIgnoreCase(strArr[2])) {
            return i12;
        }
        return strO.equalsIgnoreCase(strArr[1]) ? i11 : i10;
    }

    public static int j(boolean z10, int i10) {
        String strO = o();
        if (TextUtils.isEmpty(strO)) {
            return R.style.OS_Theme_Material_hios;
        }
        String[] strArr = f7214g;
        if (strO.equalsIgnoreCase(strArr[0])) {
            if (z10) {
                return i10 == 0 ? R.style.OS_Theme_Material_hios : R.style.OS_Theme_AppCompat_hios;
            }
            return i10 == 0 ? R.style.OS_Theme_Material_hios_NoActionBar : R.style.OS_Theme_AppCompat_hios_NoActionBar;
        }
        if (strO.equalsIgnoreCase(strArr[1])) {
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

    public static int k() {
        return ui.a.h();
    }

    public static int l(Resources resources) {
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", dc.d.f3680k, "android"));
    }

    public static int m(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.OsBgPrimary, typedValue, true)) {
            return context.getColor(typedValue.resourceId);
        }
        return -1;
    }

    public static int n(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? context.getColor(typedValue.resourceId) : context.getColor(R.color.os_platform_basic_color_hios);
    }

    public static String o() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.tranos.type");
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static int p(int[] iArr) {
        String strO = o();
        String[] strArr = f7214g;
        if (strO.equalsIgnoreCase(strArr[1])) {
            return iArr[1];
        }
        return strO.equalsIgnoreCase(strArr[2]) ? iArr[2] : iArr[0];
    }

    public static int q(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int r(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int s(String str, String str2) {
        return ui.a.k(str, str2);
    }

    public static int t(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", dc.d.f3680k, "android"));
    }

    public static String u(String str) {
        return ui.a.l(str);
    }

    public static byte[] v(InputStream inputStream) {
        return ui.a.m(inputStream);
    }

    public static boolean w(Context context) {
        return ui.a.n(context);
    }

    public static boolean x(@NonNull Context context) {
        if (context instanceof Activity) {
            return SplitController.getInstance().isActivityEmbedded((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            return SplitController.getInstance().isActivityEmbedded((Activity) ((ContextWrapper) context).getBaseContext());
        }
        return false;
    }

    public static boolean y(Context context) {
        return ui.a.o(context);
    }

    public static boolean z(Context context) {
        return ui.a.p(context);
    }
}
