package m7;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class j implements xf.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10600a = "j";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f10601b = cc.a.a("com.android.internal.app.UnlaunchableAppActivity");

    @Override // xf.e
    public Intent a(int i10) {
        return (Intent) cc.a.j(cc.a.g(f10601b, "createInQuietModeDialogIntent", Integer.TYPE), null, Integer.valueOf(i10));
    }
}
