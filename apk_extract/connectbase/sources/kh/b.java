package kh;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    Drawable a(Context context, Drawable drawable, String str);

    Drawable b(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10);

    Drawable c(Context context, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10);

    Drawable d(Bitmap bitmap, String str);

    Drawable e(ApplicationInfo applicationInfo);

    Drawable f(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10, boolean z10);

    Drawable g(Context context, ApplicationInfo applicationInfo);

    Drawable h(Context context, boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo);

    Drawable i(Drawable drawable);

    Drawable j(Context context, Drawable drawable);

    Drawable k(Bitmap bitmap);

    Drawable l(Drawable drawable, String str);

    Drawable m(PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo, int i10);

    Drawable n(Context context, Bitmap bitmap);

    Drawable o(Context context, Bitmap bitmap, String str);

    Drawable p(ApplicationInfo applicationInfo, boolean z10);

    Drawable q(Context context, ApplicationInfo applicationInfo, boolean z10);

    Drawable r(boolean z10, PackageItemInfo packageItemInfo, ApplicationInfo applicationInfo);
}
