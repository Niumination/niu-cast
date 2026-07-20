package lj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static HashMap<Integer, Bitmap> f10080r = new HashMap<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f10081s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f10082t = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f10084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f10085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f10086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Typeface f10091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10094l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10095m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10096n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10097o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10098p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10099q;

    public i(Context context) {
        this.f10090h = 12;
        this.f10093k = 64;
        this.f10094l = 54;
        this.f10095m = 82;
        this.f10096n = -1;
        this.f10097o = 0;
        this.f10083a = context;
    }

    public static Bitmap b(Context context, int i10) {
        Drawable drawable = context.getDrawable(i10);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        f10080r.put(Integer.valueOf(i10), bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public static void p() {
        HashMap<Integer, Bitmap> map = f10080r;
        if (map == null) {
            return;
        }
        for (Bitmap bitmap : map.values()) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        f10080r.clear();
        f10080r = null;
    }

    public static void q(Context context) {
        HashMap<Integer, Bitmap> map = f10080r;
        if (map == null) {
            return;
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            b(context, it.next().intValue());
        }
    }

    public i A(Bitmap bitmap) {
        this.f10086d = bitmap;
        return this;
    }

    public void B(int i10) {
        this.f10098p = i10;
    }

    public void C(int i10) {
        this.f10087e = i10;
    }

    public i D(@StringRes int i10) {
        return E(this.f10083a.getString(i10));
    }

    public i E(String str) {
        this.f10088f = str;
        return this;
    }

    public i F(@StyleRes int i10) {
        this.f10092j = i10;
        return this;
    }

    public i G(@ColorInt int i10) {
        this.f10089g = i10;
        return this;
    }

    public i H(@ColorRes int i10) {
        return G(ContextCompat.getColor(this.f10083a, i10));
    }

    public i I(int i10) {
        this.f10090h = i10;
        return this;
    }

    public i J(Typeface typeface) {
        this.f10091i = typeface;
        return this;
    }

    public i K(int i10) {
        this.f10097o = i10;
        return this;
    }

    public i L(int i10) {
        this.f10093k = i10;
        this.f10095m = i10;
        return this;
    }

    public Drawable a() {
        return this.f10084b;
    }

    public Drawable c() {
        return this.f10085c;
    }

    public int d() {
        return this.f10096n;
    }

    public Bitmap e() {
        HashMap<Integer, Bitmap> map = f10080r;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return f10080r.get(Integer.valueOf(this.f10087e));
    }

    public int f() {
        return this.f10098p;
    }

    public int g() {
        return this.f10087e;
    }

    public String h() {
        return this.f10088f;
    }

    public int i() {
        return this.f10092j;
    }

    public int j() {
        return this.f10090h;
    }

    public Typeface k() {
        return this.f10091i;
    }

    public int l() {
        return this.f10089g;
    }

    public int m() {
        return this.f10086d == null ? 0 : 1;
    }

    public int n() {
        return this.f10097o;
    }

    public int o() {
        return m() == 0 ? this.f10095m : this.f10093k;
    }

    public i r(@DrawableRes int i10) {
        return s(ContextCompat.getDrawable(this.f10083a, i10));
    }

    public i s(Drawable drawable) {
        this.f10084b = drawable;
        return this;
    }

    public i t(@ColorInt int i10) {
        this.f10084b = new ColorDrawable(i10);
        return this;
    }

    public i u(@ColorRes int i10) {
        return t(ContextCompat.getColor(this.f10083a, i10));
    }

    public i v(Drawable drawable) {
        this.f10085c = drawable;
        return this;
    }

    public i w(@ColorInt int i10) {
        this.f10085c = new ColorDrawable(i10);
        return this;
    }

    public i x(@ColorRes int i10) {
        return w(ContextCompat.getColor(this.f10083a, i10));
    }

    public i y(int i10) {
        this.f10096n = i10;
        return this;
    }

    public i z(@DrawableRes int i10) {
        this.f10087e = i10;
        return f10080r.containsKey(Integer.valueOf(i10)) ? A(f10080r.get(Integer.valueOf(i10))) : A(b(this.f10083a, i10));
    }

    public i(Context context, int i10) {
        this.f10090h = 12;
        this.f10093k = 64;
        this.f10094l = 54;
        this.f10095m = 82;
        this.f10096n = -1;
        this.f10097o = 0;
        this.f10083a = context;
        this.f10098p = i10;
        this.f10089g = Color.parseColor("#FFFFFF");
        boolean zEqualsIgnoreCase = hj.h.f7214g[0].equalsIgnoreCase(hj.h.o());
        this.f10099q = zEqualsIgnoreCase;
        this.f10093k = ui.a.d(this.f10083a, zEqualsIgnoreCase ? this.f10094l : this.f10093k);
        this.f10095m = ui.a.d(this.f10083a, this.f10095m);
        this.f10090h = ui.a.B(this.f10090h);
    }
}
