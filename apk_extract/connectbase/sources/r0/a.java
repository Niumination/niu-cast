package r0;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import s0.j;
import z0.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AssetManager f14140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public n0.c f14141e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j<String> f14137a = new j<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<j<String>, Typeface> f14138b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Typeface> f14139c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14142f = ".ttf";

    public a(Drawable.Callback callback, @Nullable n0.c cVar) {
        this.f14141e = cVar;
        if (callback instanceof View) {
            this.f14140d = ((View) callback).getContext().getAssets();
        } else {
            d.e("LottieDrawable must be inside of a view for images to work.");
            this.f14140d = null;
        }
    }

    public final Typeface a(String str) {
        String strB;
        Typeface typeface = this.f14139c.get(str);
        if (typeface != null) {
            return typeface;
        }
        n0.c cVar = this.f14141e;
        Typeface typefaceA = cVar != null ? cVar.a(str) : null;
        n0.c cVar2 = this.f14141e;
        if (cVar2 != null && typefaceA == null && (strB = cVar2.b(str)) != null) {
            typefaceA = Typeface.createFromAsset(this.f14140d, strB);
        }
        if (typefaceA == null) {
            typefaceA = Typeface.createFromAsset(this.f14140d, "fonts/" + str + this.f14142f);
        }
        this.f14139c.put(str, typefaceA);
        return typefaceA;
    }

    public Typeface b(String str, String str2) {
        this.f14137a.b(str, str2);
        Typeface typeface = this.f14138b.get(this.f14137a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(a(str), str2);
        this.f14138b.put(this.f14137a, typefaceE);
        return typefaceE;
    }

    public void c(String str) {
        this.f14142f = str;
    }

    public void d(@Nullable n0.c cVar) {
        this.f14141e = cVar;
    }

    public final Typeface e(Typeface typeface, String str) {
        int i10;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i10 = 3;
        } else if (zContains) {
            i10 = 2;
        } else {
            i10 = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i10 ? typeface : Typeface.create(typeface, i10);
    }
}
