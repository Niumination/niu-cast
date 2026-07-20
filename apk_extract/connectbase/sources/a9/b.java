package a9;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements kh.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f188b = cc.a.a("android.util.IconDrawableFactory");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f189a = bc.a.a();

    @Override // kh.b
    public Drawable a(Context context, Drawable drawable, String str) {
        return null;
    }

    @Override // kh.b
    public Drawable b(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", PackageItemInfo.class, ApplicationInfo.class, Integer.TYPE), cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, context), packageItemInfo, applicationInfo, Integer.valueOf(i10));
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable c(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", PackageItemInfo.class, ApplicationInfo.class, Integer.TYPE), cc.a.j(cc.a.g(f188b, "newInstance", Context.class, Boolean.TYPE), null, context, Boolean.valueOf(z10)), packageItemInfo, applicationInfo, Integer.valueOf(i10));
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable d(Bitmap bitmap, String str) {
        Object objJ = cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, this.f189a);
        Method methodG = cc.a.g(f188b, "getGlobalThemedIcon", Bitmap.class, String.class);
        if (methodG == null) {
            return null;
        }
        Object objJ2 = cc.a.j(methodG, objJ, bitmap, str);
        if (objJ2 instanceof Drawable) {
            return (Drawable) objJ2;
        }
        return null;
    }

    @Override // kh.b
    public Drawable e(ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", ApplicationInfo.class), cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, this.f189a), applicationInfo);
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable f(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", PackageItemInfo.class, ApplicationInfo.class, Integer.TYPE), cc.a.j(cc.a.g(f188b, "newInstance", Context.class, Boolean.TYPE), null, this.f189a, Boolean.valueOf(z10)), packageItemInfo, applicationInfo, Integer.valueOf(i10));
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable g(Context context, ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", ApplicationInfo.class), cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, context), applicationInfo);
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable h(Context context, boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f188b, "newInstance", Context.class, Boolean.TYPE), null, context, Boolean.valueOf(z10));
        Method methodG = cc.a.g(f188b, "getUnbadgedIcon", PackageItemInfo.class, ApplicationInfo.class);
        if (methodG == null) {
            return null;
        }
        Object objJ2 = cc.a.j(methodG, objJ, packageItemInfo, applicationInfo);
        if (objJ2 instanceof Drawable) {
            return (Drawable) objJ2;
        }
        return null;
    }

    @Override // kh.b
    public Drawable i(Drawable drawable) {
        return null;
    }

    @Override // kh.b
    public Drawable j(Context context, Drawable drawable) {
        return null;
    }

    @Override // kh.b
    public Drawable k(Bitmap bitmap) {
        Object objJ = cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, this.f189a);
        Method methodG = cc.a.g(f188b, "getGlobalThemedIcon", Bitmap.class);
        if (methodG == null) {
            return null;
        }
        Object objJ2 = cc.a.j(methodG, objJ, bitmap);
        if (objJ2 instanceof Drawable) {
            return (Drawable) objJ2;
        }
        return null;
    }

    @Override // kh.b
    public Drawable l(Drawable drawable, String str) {
        return null;
    }

    @Override // kh.b
    public Drawable m(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", PackageItemInfo.class, ApplicationInfo.class, Integer.TYPE), cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, this.f189a), packageItemInfo, applicationInfo, Integer.valueOf(i10));
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable n(Context context, Bitmap bitmap) {
        Object objJ = cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, context);
        Method methodG = cc.a.g(f188b, "getGlobalThemedIcon", Bitmap.class);
        if (methodG == null) {
            return null;
        }
        Object objJ2 = cc.a.j(methodG, objJ, bitmap);
        if (objJ2 instanceof Drawable) {
            return (Drawable) objJ2;
        }
        return null;
    }

    @Override // kh.b
    public Drawable o(Context context, Bitmap bitmap, String str) {
        Object objJ = cc.a.j(cc.a.g(f188b, "newInstance", Context.class), null, context);
        Method methodG = cc.a.g(f188b, "getGlobalThemedIcon", Bitmap.class, String.class);
        if (methodG == null) {
            return null;
        }
        Object objJ2 = cc.a.j(methodG, objJ, bitmap, str);
        if (objJ2 instanceof Drawable) {
            return (Drawable) objJ2;
        }
        return null;
    }

    @Override // kh.b
    public Drawable p(ApplicationInfo applicationInfo, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", ApplicationInfo.class), cc.a.j(cc.a.g(f188b, "newInstance", Context.class, Boolean.TYPE), null, this.f189a, Boolean.valueOf(z10)), applicationInfo);
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable q(Context context, ApplicationInfo applicationInfo, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f188b, "getBadgedIcon", ApplicationInfo.class), cc.a.j(cc.a.g(f188b, "newInstance", Context.class, Boolean.TYPE), null, context, Boolean.valueOf(z10)), applicationInfo);
        if (objJ instanceof Drawable) {
            return (Drawable) objJ;
        }
        return null;
    }

    @Override // kh.b
    public Drawable r(boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f188b, "newInstance", Context.class, Boolean.TYPE), null, this.f189a, Boolean.valueOf(z10));
        Method methodG = cc.a.g(f188b, "getUnbadgedIcon", PackageItemInfo.class, ApplicationInfo.class);
        if (methodG == null) {
            return null;
        }
        Object objJ2 = cc.a.j(methodG, objJ, packageItemInfo, applicationInfo);
        if (objJ2 instanceof Drawable) {
            return (Drawable) objJ2;
        }
        return null;
    }
}
