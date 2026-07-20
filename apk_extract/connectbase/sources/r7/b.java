package r7;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class b implements cg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f14298a = cc.a.a("com.android.internal.policy.SystemBarUtils");

    @Override // cg.b
    public int a(Context context) {
        Object objJ = cc.a.j(cc.a.g(f14298a, "getStatusBarHeight", Context.class), null, context);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }
}
