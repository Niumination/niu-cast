package p8;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements zg.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13023e = "a";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f13024f = cc.a.a("android.service.dreams.IDreamManager$Stub");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f13025g = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13026h = "dreams";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f13027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f13028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a7.a f13029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f13030d = e();

    @Override // zg.a
    public void a(IBinder iBinder, boolean z10) {
        Object obj = this.f13030d;
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "finishSelf", IBinder.class, Boolean.TYPE), this.f13030d, iBinder, Boolean.valueOf(z10));
        }
    }

    @Override // zg.a
    public void b(IBinder iBinder) {
        Object obj = this.f13030d;
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "stopDozing", IBinder.class), this.f13030d, iBinder);
        }
    }

    @Override // zg.a
    public void c(IBinder iBinder, int i10, int i11) {
        Object obj = this.f13030d;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            cc.a.j(cc.a.g(cls, "startDozing", IBinder.class, cls2, cls2), this.f13030d, iBinder, Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    @Override // zg.a
    public IBinder d(a7.a.InterfaceC0003a interfaceC0003a) {
        return f().a(interfaceC0003a);
    }

    public final Object e() {
        this.f13027a = cc.a.g(f13025g, "getService", String.class);
        this.f13028b = cc.a.g(f13024f, "asInterface", IBinder.class);
        Object objJ = cc.a.j(this.f13027a, f13025g, f13026h);
        return cc.a.j(this.f13028b, f13024f, objJ instanceof IBinder ? (IBinder) objJ : null);
    }

    public final a7.a f() {
        if (this.f13029c == null) {
            this.f13029c = new a7.a();
        }
        return this.f13029c;
    }
}
