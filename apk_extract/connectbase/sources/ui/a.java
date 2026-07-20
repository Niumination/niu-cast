package ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.timepicker.TimeModel;
import dc.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16261a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16262b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16263c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16264d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16265e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16266f = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16268h = "widgetslib.Utils";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f16270j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f16271k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f16272l = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f16274n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f16275o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f16276p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f16277q = "ro.transsion.lcd.type";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f16278r = "1";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f16279s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f16280t = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f16267g = {"hios", "xos", "itel"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f16269i = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f16273m = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f16281u = "1".equals(l("ro.tran_vibrate_ontouch.support"));

    /* JADX INFO: renamed from: ui.a$a, reason: collision with other inner class name */
    public class ViewOnApplyWindowInsetsListenerC0432a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16282a;

        public ViewOnApplyWindowInsetsListenerC0432a(Context context) {
            this.f16282a = context;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (this.f16282a == null) {
                return windowInsets;
            }
            Insets insets = windowInsets.getInsets(WindowInsets.Side.all());
            Display display = this.f16282a.getDisplay();
            boolean zQ = a.q(this.f16282a);
            if (display != null) {
                if (display.getRotation() == 1) {
                    windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), Insets.of(0, insets.top, zQ ? 0 : insets.right, 0)).build();
                } else if (display.getRotation() == 3) {
                    windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), Insets.of(zQ ? 0 : insets.left, insets.top, 0, 0)).build();
                } else {
                    windowInsets = new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Side.all(), Insets.of(0, insets.top, 0, insets.bottom)).build();
                }
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }

    public static void A(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0432a(context));
        }
    }

    public static int B(int i10) {
        return (int) TypedValue.applyDimension(2, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static InputStream a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public static int b(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outWidth;
        int i13 = options.outHeight;
        if (i12 > i10 || i13 > i11) {
            return Math.min(Math.round(i12 / i10), Math.round(i13 / i11));
        }
        return 1;
    }

    public static Bitmap c(Context context, Drawable drawable, int i10) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        byte[] bArrM = m(f(context, drawable, i10));
        BitmapFactory.decodeByteArray(bArrM, 0, bArrM.length, options);
        int iB = b(options, i10, i10);
        options.inSampleSize = iB;
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM, 0, bArrM.length, options);
        if (iB == 1) {
            return (options.outWidth == i10 && options.outHeight == i10) ? bitmapDecodeByteArray : Bitmap.createScaledBitmap(bitmapDecodeByteArray, i10, i10, true);
        }
        return bitmapDecodeByteArray;
    }

    public static int d(Context context, int i10) {
        return (int) TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static Bitmap e(Context context, Drawable drawable, int i10) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = i10;
        }
        if (intrinsicHeight > 0) {
            i10 = intrinsicHeight;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, i10, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, i10);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static InputStream f(Context context, Drawable drawable, int i10) {
        return a(e(context, drawable, i10));
    }

    public static Bitmap g(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static int h() {
        String str = Build.HARDWARE;
        return (TextUtils.isEmpty(str) || !str.startsWith("mt")) ? 2 : 1;
    }

    public static int i(Resources resources) {
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", d.f3680k, "android"));
    }

    public static String j() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.tranos.type");
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static int k(String str, String str2) {
        try {
            Field field = Class.forName(str).getField(str2);
            field.setAccessible(true);
            return field.getInt(null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String l(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.e("widgetslib.Utils", "getSystemProperties Exception " + e10.getMessage());
            return "";
        }
    }

    public static byte[] m(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int i10 = inputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i10);
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        inputStream.close();
                        byteArrayOutputStream.close();
                    }
                } catch (Throwable th2) {
                    try {
                        inputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    throw th2;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
        }
        inputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean n(Context context) {
        return DateFormat.is24HourFormat(context);
    }

    public static boolean o(Context context) {
        return context.getResources().getConfiguration().fontWeightAdjustment == 300;
    }

    public static boolean p(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static boolean q(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_mode", 0) == 2;
    }

    public static boolean r() {
        int i10 = f16273m;
        if (i10 != -1) {
            return i10 == 1;
        }
        if ("1".equals(l("ro.transsion.lcd.type"))) {
            f16273m = 1;
            return true;
        }
        f16273m = 0;
        return false;
    }

    public static boolean s() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static boolean t() {
        return s() && !String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 1).equals("1");
    }

    public static boolean u(Context context) {
        try {
            int i10 = f16269i;
            if (i10 != -1) {
                return i10 == 1;
            }
            int identifier = context.getResources().getIdentifier("waterfall_display_left_edge_size", d.f3680k, "android");
            if ((identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0) > 0) {
                f16269i = 1;
                return true;
            }
            f16269i = 0;
            return false;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static float v(Paint paint) {
        if (paint == null) {
            return 0.0f;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (fontMetrics.descent - fontMetrics.ascent) * 0.5f;
    }

    public static void w(Menu menu, boolean z10) {
        try {
            Method declaredMethod = Class.forName("com.android.internal.view.menu.MenuBuilder").getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(menu, Boolean.valueOf(z10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void x(Menu menu, int i10, int i11) {
        y(menu, i10, i11, -1, -1);
    }

    public static void y(Menu menu, int i10, int i11, int i12, int i13) {
        if (menu == null || i10 <= 0) {
            return;
        }
        if (i12 <= 0 || i13 <= 0) {
            z(menu.findItem(i10), i11);
            return;
        }
        w(menu, true);
        int size = menu.size();
        for (int i14 = 0; i14 < size; i14++) {
            MenuItem item = menu.getItem(i14);
            if (item.getItemId() == i10) {
                item.setIcon(i12);
                z(item, i11);
            } else {
                item.setIcon(i13);
            }
        }
    }

    public static void z(MenuItem menuItem, int i10) {
        if (menuItem == null || menuItem.getTitle().length() == 0) {
            return;
        }
        SpannableString spannableString = new SpannableString(menuItem.getTitle());
        spannableString.setSpan(new ForegroundColorSpan(i10), 0, spannableString.length(), 33);
        menuItem.setTitle(spannableString);
    }
}
