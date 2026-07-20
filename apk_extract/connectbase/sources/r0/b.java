package r0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import el.b0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import n0.d;
import n0.k;
import z0.h;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f14143e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public d f14146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, k> f14147d;

    public b(Drawable.Callback callback, String str, d dVar, Map<String, k> map) {
        this.f14145b = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f14145b;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f14145b = l.a.a(new StringBuilder(), this.f14145b, b0.f4502a);
            }
        }
        if (callback instanceof View) {
            this.f14144a = ((View) callback).getContext();
            this.f14147d = map;
            d(dVar);
        } else {
            z0.d.e("LottieDrawable must be inside of a view for images to work.");
            this.f14147d = new HashMap();
            this.f14144a = null;
        }
    }

    @Nullable
    public Bitmap a(String str) {
        k kVar = this.f14147d.get(str);
        if (kVar == null) {
            return null;
        }
        Bitmap bitmapA = kVar.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        d dVar = this.f14146c;
        if (dVar != null) {
            Bitmap bitmapA2 = dVar.a(kVar);
            if (bitmapA2 != null) {
                c(str, bitmapA2);
            }
            return bitmapA2;
        }
        String strC = kVar.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e10) {
                z0.d.f("data URL did not have correct base64 format.", e10);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f14145b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                return c(str, h.m(BitmapFactory.decodeStream(this.f14144a.getAssets().open(this.f14145b + strC), null, options), kVar.f(), kVar.d()));
            } catch (IllegalArgumentException e11) {
                z0.d.f("Unable to decode image.", e11);
                return null;
            }
        } catch (IOException e12) {
            z0.d.f("Unable to open asset.", e12);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f14144a == null) || this.f14144a.equals(context);
    }

    public final Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (f14143e) {
            this.f14147d.get(str).h(bitmap);
        }
        return bitmap;
    }

    public void d(@Nullable d dVar) {
        this.f14146c = dVar;
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmapA = this.f14147d.get(str).a();
            c(str, bitmap);
            return bitmapA;
        }
        k kVar = this.f14147d.get(str);
        Bitmap bitmapA2 = kVar.a();
        kVar.h(null);
        return bitmapA2;
    }
}
