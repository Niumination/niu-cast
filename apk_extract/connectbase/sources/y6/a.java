package y6;

import android.util.ArrayMap;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements kf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20762a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f20763b = cc.a.a("com.mediatek.res.AsyncDrawableCache");

    @Override // kf.a
    public void a() {
        try {
            ArrayMap arrayMap = (ArrayMap) f20763b.getDeclaredField("sDrawableCache").get(f20763b);
            if (arrayMap == null || arrayMap.size() == 0) {
                return;
            }
            int size = arrayMap.size();
            arrayMap.clear();
            e.f(f20762a, "clearCacheBitmap size = " + size);
        } catch (Exception e10) {
            e.f(f20762a, "clearCacheBitmap exception :" + e10.getMessage());
        }
    }
}
