package qe;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.transsion.hubsdk.util.TranIconDrawableFactory;

/* JADX INFO: loaded from: classes2.dex */
public class b implements kh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranIconDrawableFactory f13986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f13987b;

    public b() {
        this.f13986a = null;
        this.f13987b = null;
        Context contextA = bc.a.a();
        this.f13987b = contextA;
        if (contextA == null) {
            return;
        }
        this.f13986a = new TranIconDrawableFactory(this.f13987b);
    }

    @Override // kh.b
    public Drawable a(Context context, Drawable drawable, String str) {
        if (this.f13986a == null) {
            this.f13986a = new TranIconDrawableFactory(context);
        }
        return this.f13986a.getGlobalThemedIcon(context, drawable, str);
    }

    @Override // kh.b
    public Drawable b(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10) {
        TranIconDrawableFactory tranIconDrawableFactory = new TranIconDrawableFactory(context);
        this.f13986a = tranIconDrawableFactory;
        return tranIconDrawableFactory.getBadgedIcon(packageItemInfo, applicationInfo, i10);
    }

    @Override // kh.b
    public Drawable c(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10) {
        TranIconDrawableFactory tranIconDrawableFactory = new TranIconDrawableFactory(context);
        this.f13986a = tranIconDrawableFactory;
        return tranIconDrawableFactory.getBadgedIcon(context, packageItemInfo, applicationInfo, i10, z10);
    }

    @Override // kh.b
    public Drawable d(Bitmap bitmap, String str) {
        Context context;
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null || (context = this.f13987b) == null) {
            return null;
        }
        return tranIconDrawableFactory.getGlobalThemedIcon(context, bitmap, str);
    }

    @Override // kh.b
    public Drawable e(ApplicationInfo applicationInfo) {
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null) {
            return null;
        }
        return tranIconDrawableFactory.getBadgedIcon(applicationInfo);
    }

    @Override // kh.b
    public Drawable f(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10) {
        Context context;
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null || (context = this.f13987b) == null) {
            return null;
        }
        return tranIconDrawableFactory.getBadgedIcon(context, packageItemInfo, applicationInfo, i10, z10);
    }

    @Override // kh.b
    public Drawable g(Context context, ApplicationInfo applicationInfo) {
        TranIconDrawableFactory tranIconDrawableFactory = new TranIconDrawableFactory(context);
        this.f13986a = tranIconDrawableFactory;
        return tranIconDrawableFactory.getBadgedIcon(applicationInfo);
    }

    @Override // kh.b
    public Drawable h(Context context, boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        TranIconDrawableFactory tranIconDrawableFactory = new TranIconDrawableFactory(context);
        this.f13986a = tranIconDrawableFactory;
        return tranIconDrawableFactory.getUnbadgedIcon(context, z10, packageItemInfo, applicationInfo);
    }

    @Override // kh.b
    public Drawable i(Drawable drawable) {
        Context context;
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null || (context = this.f13987b) == null) {
            return null;
        }
        return tranIconDrawableFactory.getGlobalThemedIcon(context, drawable);
    }

    @Override // kh.b
    public Drawable j(Context context, Drawable drawable) {
        if (this.f13986a == null) {
            this.f13986a = new TranIconDrawableFactory(context);
        }
        return this.f13986a.getGlobalThemedIcon(context, drawable);
    }

    @Override // kh.b
    public Drawable k(Bitmap bitmap) {
        Context context;
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null || (context = this.f13987b) == null) {
            return null;
        }
        return tranIconDrawableFactory.getGlobalThemedIcon(context, bitmap);
    }

    @Override // kh.b
    public Drawable l(Drawable drawable, String str) {
        Context context;
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null || (context = this.f13987b) == null) {
            return null;
        }
        return tranIconDrawableFactory.getGlobalThemedIcon(context, drawable, str);
    }

    @Override // kh.b
    public Drawable m(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10) {
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null) {
            return null;
        }
        return tranIconDrawableFactory.getBadgedIcon(packageItemInfo, applicationInfo, i10);
    }

    @Override // kh.b
    public Drawable n(Context context, Bitmap bitmap) {
        if (this.f13986a == null) {
            this.f13986a = new TranIconDrawableFactory(context);
        }
        return this.f13986a.getGlobalThemedIcon(context, bitmap);
    }

    @Override // kh.b
    public Drawable o(Context context, Bitmap bitmap, String str) {
        if (this.f13986a == null) {
            this.f13986a = new TranIconDrawableFactory(context);
        }
        return this.f13986a.getGlobalThemedIcon(context, bitmap, str);
    }

    @Override // kh.b
    public Drawable p(ApplicationInfo applicationInfo, boolean z10) {
        Context context;
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null || (context = this.f13987b) == null) {
            return null;
        }
        return tranIconDrawableFactory.getBadgedIcon(context, applicationInfo, z10);
    }

    @Override // kh.b
    public Drawable q(Context context, ApplicationInfo applicationInfo, boolean z10) {
        TranIconDrawableFactory tranIconDrawableFactory = new TranIconDrawableFactory(context);
        this.f13986a = tranIconDrawableFactory;
        return tranIconDrawableFactory.getBadgedIcon(context, applicationInfo, z10);
    }

    @Override // kh.b
    public Drawable r(boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo) {
        Context context;
        TranIconDrawableFactory tranIconDrawableFactory = this.f13986a;
        if (tranIconDrawableFactory == null || (context = this.f13987b) == null) {
            return null;
        }
        return tranIconDrawableFactory.getUnbadgedIcon(context, z10, packageItemInfo, applicationInfo);
    }
}
