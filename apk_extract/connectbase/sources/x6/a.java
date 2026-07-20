package x6;

import android.content.pm.ActivityInfo;

/* JADX INFO: loaded from: classes2.dex */
public class a implements jf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20074a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f20075b = cc.a.a("android.content.pm.ActivityInfo");

    @Override // jf.a
    public int a(ActivityInfo activityInfo) {
        try {
            return cc.a.d(f20075b, "resizeMode").getInt(activityInfo);
        } catch (IllegalAccessException | IllegalArgumentException e10) {
            p6.b.a("isResizeableMode fail:", e10, f20074a);
            return 0;
        }
    }

    @Override // jf.a
    public boolean b(int i10) {
        Object objJ = cc.a.j(cc.a.g(f20075b, "isResizeableMode", Integer.TYPE), null, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }
}
