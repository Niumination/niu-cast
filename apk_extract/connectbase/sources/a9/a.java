package a9;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a implements kh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f186a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f187b = cc.a.a("android.util.FeatureFlagUtils");

    @Override // kh.a
    public boolean a(Context context, String str) {
        Object objJ = cc.a.j(cc.a.g(f187b, "isEnabled", Context.class, String.class), f187b, context, str);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }
}
