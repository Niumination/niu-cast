package p6;

import android.app.ActionBar;

/* JADX INFO: loaded from: classes2.dex */
public class a implements bf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12934a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f12935b = cc.a.a("android.app.ActionBar");

    @Override // bf.a
    public void a(ActionBar actionBar, boolean z10) {
        cc.a.j(cc.a.g(f12935b, "setShowHideAnimationEnabled", Boolean.TYPE), actionBar, Boolean.valueOf(z10));
    }
}
