package qb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13890c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qe.b f13891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a9.b f13892b;

    public Drawable a(Context context, ApplicationInfo applicationInfo) {
        return q(fc.b.a.f5985e).g(context, applicationInfo);
    }

    public Drawable b(Context context, ApplicationInfo applicationInfo, boolean z10) {
        if (context == null || applicationInfo == null) {
            throw new IllegalArgumentException("appInfo is null");
        }
        return q(fc.b.a.f6001u).q(context, applicationInfo, z10);
    }

    public Drawable c(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10) {
        return q(fc.b.a.f5988h).b(context, packageItemInfo, applicationInfo, i10);
    }

    public Drawable d(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10) {
        if (context == null || packageItemInfo == null || applicationInfo == null) {
            throw new IllegalArgumentException("Params cannot be null");
        }
        return q(fc.b.a.C).c(context, packageItemInfo, applicationInfo, i10, z10);
    }

    public Drawable e(ApplicationInfo applicationInfo) {
        return q(fc.b.a.f5985e).e(applicationInfo);
    }

    public Drawable f(ApplicationInfo applicationInfo, boolean z10) {
        if (applicationInfo != null) {
            return q(fc.b.a.f6001u).p(applicationInfo, z10);
        }
        throw new IllegalArgumentException("appInfo is null");
    }

    public Drawable g(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10) {
        return q(fc.b.a.f5988h).m(packageItemInfo, applicationInfo, i10);
    }

    public Drawable h(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10) {
        if (packageItemInfo == null || applicationInfo == null) {
            throw new IllegalArgumentException("Params cannot be null");
        }
        return q(fc.b.a.C).f(packageItemInfo, applicationInfo, i10, z10);
    }

    public Drawable i(Context context, Bitmap bitmap) {
        if (context == null || bitmap == null) {
            throw new IllegalArgumentException("params cannot be null");
        }
        return q(fc.b.a.B).n(context, bitmap);
    }

    public Drawable j(Context context, Bitmap bitmap, String str) {
        if (context == null || bitmap == null || str == null) {
            throw new IllegalArgumentException("params cannot be null");
        }
        return q(fc.b.a.B).o(context, bitmap, str);
    }

    public Drawable k(Context context, Drawable drawable) {
        if (context == null || drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null");
        }
        return q(fc.b.a.C).j(context, drawable);
    }

    public Drawable l(Context context, Drawable drawable, String str) {
        if (context == null || drawable == null || str == null) {
            throw new IllegalArgumentException("Drawable or themeId cannot be null");
        }
        return q(fc.b.a.C).a(context, drawable, str);
    }

    public Drawable m(Bitmap bitmap) {
        if (bitmap != null) {
            return q(fc.b.a.B).k(bitmap);
        }
        throw new IllegalArgumentException("bitmap cannot be null");
    }

    public Drawable n(Bitmap bitmap, String str) {
        if (bitmap == null || str == null) {
            throw new IllegalArgumentException("params cannot be null");
        }
        return q(fc.b.a.B).d(bitmap, str);
    }

    public Drawable o(Drawable drawable) {
        if (drawable != null) {
            return q(fc.b.a.C).i(drawable);
        }
        throw new IllegalArgumentException("Drawable cannot be null");
    }

    public Drawable p(Drawable drawable, String str) {
        if (drawable == null || str == null) {
            throw new IllegalArgumentException("Drawable or themeId cannot be null");
        }
        return q(fc.b.a.C).l(drawable, str);
    }

    public kh.b q(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f13890c, "TranThubIconDrawableFactory");
            qe.b bVar = this.f13891a;
            if (bVar != null) {
                return bVar;
            }
            qe.b bVar2 = new qe.b();
            this.f13891a = bVar2;
            return bVar2;
        }
        dc.e.f(f13890c, "TranAospIconDrawableFactory");
        a9.b bVar3 = this.f13892b;
        if (bVar3 != null) {
            return bVar3;
        }
        a9.b bVar4 = new a9.b();
        this.f13892b = bVar4;
        return bVar4;
    }

    public Drawable r(Context context, boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        if (context == null || packageItemInfo == null || applicationInfo == null) {
            throw new IllegalArgumentException("Params cannot be null");
        }
        return q(fc.b.a.B).h(context, z10, packageItemInfo, applicationInfo);
    }

    public Drawable s(boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        if (packageItemInfo == null || applicationInfo == null) {
            throw new IllegalArgumentException("Params cannot be null");
        }
        return q(fc.b.a.B).r(z10, packageItemInfo, applicationInfo);
    }
}
