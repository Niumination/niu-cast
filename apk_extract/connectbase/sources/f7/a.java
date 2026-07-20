package f7;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class a implements qf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5903c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f5904d = cc.a.a("android.hardware.devicestate.DeviceStateManagerGlobal");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f5906b = bc.a.a();

    @Override // qf.a
    @Deprecated
    public void a(b.InterfaceC0139b interfaceC0139b) {
        d().c(interfaceC0139b);
    }

    @Override // qf.a
    @Deprecated
    public void b(Executor executor, b.InterfaceC0139b interfaceC0139b) {
        d().b(executor, interfaceC0139b);
    }

    @Override // qf.a
    public int c() {
        Object objJ = cc.a.j(cc.a.g(f5904d, "getInstance", new Class[0]), null, new Object[0]);
        if (objJ == null) {
            return 0;
        }
        Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), "getCurrentState", new Class[0]), objJ, new Object[0]);
        if (objJ2 instanceof Integer) {
            return ((Integer) objJ2).intValue();
        }
        return 0;
    }

    public final b d() {
        if (this.f5905a == null) {
            this.f5905a = new b(this.f5906b);
        }
        return this.f5905a;
    }
}
