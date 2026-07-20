package n8;

import android.content.Context;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements xg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11421b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f11422c = cc.a.a("android.content.res.AssetManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11423a = bc.a.a();

    @Override // xg.a
    public int a(String str) {
        try {
            Object objJ = cc.a.j(cc.a.g(f11422c, "addAssetPath", String.class), cc.a.c(f11422c, new Class[0]).newInstance(null), str);
            if (objJ instanceof Integer) {
                return ((Integer) objJ).intValue();
            }
            return 0;
        } catch (Exception e10) {
            e.a(f11421b, "addAssetPath fail : " + e10);
            return 0;
        }
    }
}
