package h8;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class a implements sg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f6996a = cc.a.a("android.service.persistentdata.PersistentDataBlockManager");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f6997b = cc.a.a("android.service.persistentdata.IPersistentDataBlockService$Stub");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f6998c = cc.a.a("android.os.ServiceManager");

    @Override // sg.a
    public int a() {
        Object objJ = cc.a.j(cc.a.g(f6997b, "asInterface", IBinder.class), f6997b, cc.a.j(cc.a.g(f6998c, "getService", String.class), f6998c, "persistent_data_block"));
        return ((Integer) cc.a.j(cc.a.g(objJ.getClass(), "getDataBlockSize", new Class[0]), objJ, new Object[0])).intValue();
    }
}
