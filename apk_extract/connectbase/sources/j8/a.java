package j8;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements tg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f8609a = cc.a.a("com.mediatek.powerhalmgr.PowerHalMgrFactory");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f8610b = cc.a.a("com.mediatek.powerhalmgr.PowerHalMgr");

    @Override // tg.a
    public int a(int i10, int i11, int[] iArr) {
        Class<?> cls = f8610b;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "perfLockAcquire", cls2, cls2, int[].class);
        methodG.setAccessible(true);
        return ((Integer) cc.a.j(methodG, c(), Integer.valueOf(i10), Integer.valueOf(i11), iArr)).intValue();
    }

    @Override // tg.a
    public void b(int i10) {
        Method methodG = cc.a.g(f8610b, "perfLockRelease", Integer.TYPE);
        methodG.setAccessible(true);
        cc.a.j(methodG, c(), Integer.valueOf(i10));
    }

    public final Object c() {
        Method methodG = cc.a.g(f8609a, "getInstance", new Class[0]);
        methodG.setAccessible(true);
        Object objJ = cc.a.j(methodG, null, new Object[0]);
        Method methodG2 = cc.a.g(f8609a, "makePowerHalMgr", new Class[0]);
        methodG2.setAccessible(true);
        return cc.a.j(methodG2, objJ, new Object[0]);
    }
}
