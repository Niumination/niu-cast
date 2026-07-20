package x6;

import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes2.dex */
public class d implements jf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20080a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f20081b = cc.a.a("android.content.pm.PackageItemInfo");

    @Override // jf.d
    public CharSequence a(PackageItemInfo packageItemInfo, PackageManager packageManager, float f10, int i10) {
        Object objJ = cc.a.j(cc.a.g(f20081b, "loadSafeLabel", PackageManager.class, Float.TYPE, Integer.TYPE), packageItemInfo, packageManager, Float.valueOf(f10), Integer.valueOf(i10));
        if (objJ instanceof CharSequence) {
            return (CharSequence) objJ;
        }
        return null;
    }
}
