package e8;

import android.os.UserHandle;

/* JADX INFO: loaded from: classes2.dex */
public class x implements pg.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4156a = 999;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4157b = "x";

    @Override // pg.p
    public int a() {
        try {
            Class clsA = cc.a.a("android.os.UserHandle");
            return ((Integer) cc.a.j(cc.a.g(clsA, "getIdentifier", new Class[0]), (UserHandle) cc.a.c(clsA, new Class[]{Integer.TYPE}).newInstance(999), new Object[0])).intValue();
        } catch (Exception e10) {
            p6.b.a("getIdentifier fail ", e10, f4157b);
            return 0;
        }
    }

    @Override // pg.p
    public int b(UserHandle userHandle) {
        return ((Integer) cc.a.j(cc.a.g(cc.a.a("android.os.UserHandle"), "getIdentifier", new Class[0]), userHandle, new Object[0])).intValue();
    }
}
