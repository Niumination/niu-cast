package w6;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class a implements p000if.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18185a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f18186b = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f18187c = cc.a.a("android.content.om.IOverlayManager$Stub");

    @Override // p000if.a
    public void a(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f18187c, "asInterface", IBinder.class), null, cc.a.j(cc.a.g(f18186b, "getService", String.class), null, "overlay"));
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "setEnabledExclusiveInCategory", String.class, Integer.TYPE), objJ, str, Integer.valueOf(i10));
        }
    }
}
