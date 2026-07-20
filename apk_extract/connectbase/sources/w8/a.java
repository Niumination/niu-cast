package w8;

import android.content.Context;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gh.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f18191f = "a";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f18192g = cc.a.a("android.app.DreamAnimationManager");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f18193h = "Version below 3.1.1 does not have this interface, please implement it yourself";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f18195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<mb.a.b> f18196c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.InterfaceC0468c f18197d = new C0467a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayMap<mb.a.InterfaceC0277a, c.b> f18198e = new ArrayMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18194a = bc.a.a();

    /* JADX INFO: renamed from: w8.a$a, reason: collision with other inner class name */
    public class C0467a implements c.InterfaceC0468c {
        public C0467a() {
        }

        @Override // w8.c.InterfaceC0468c
        public void a(int i10) {
            Iterator it = a.this.f18196c.iterator();
            while (it.hasNext()) {
                ((mb.a.b) it.next()).a(i10);
            }
        }
    }

    public class b implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ mb.a.InterfaceC0277a f18200a;

        public b(mb.a.InterfaceC0277a interfaceC0277a) {
            this.f18200a = interfaceC0277a;
        }

        @Override // w8.c.b
        public void a(int i10) {
            this.f18200a.a(i10);
        }
    }

    @Override // gh.a
    public void a(int i10) throws ac.a {
        if (!fc.a.f()) {
            throw new ac.a(f18193h);
        }
        l().f(i10);
    }

    @Override // gh.a
    public void b(mb.a.InterfaceC0277a interfaceC0277a) throws ac.a {
        if (!fc.a.f()) {
            throw new ac.a(f18193h);
        }
        i(interfaceC0277a, m());
    }

    @Override // gh.a
    public void c(mb.a.InterfaceC0277a interfaceC0277a) throws ac.a {
        if (!fc.a.f()) {
            throw new ac.a(f18193h);
        }
        h(interfaceC0277a, m());
    }

    @Override // gh.a
    public void d(mb.a.b bVar) throws ac.a {
        if (fc.a.a()) {
            throw new ac.a("can not find method registerCallback");
        }
        f(bVar, m());
    }

    @Override // gh.a
    public void e(mb.a.b bVar, int i10) throws ac.a {
        if (fc.a.a()) {
            throw new ac.a("can not find method unRegisterCallback");
        }
        this.f18196c.remove(bVar);
        l().j(this.f18197d, i10);
    }

    @Override // gh.a
    public void f(mb.a.b bVar, int i10) throws ac.a {
        if (fc.a.a()) {
            throw new ac.a("can not find method registerCallback");
        }
        this.f18196c.add(bVar);
        l().h(this.f18197d, i10);
    }

    @Override // gh.a
    public void g(mb.a.b bVar) throws ac.a {
        if (fc.a.a()) {
            throw new ac.a("can not find method unRegisterCallback");
        }
        e(bVar, m());
    }

    @Override // gh.a
    public void h(mb.a.InterfaceC0277a interfaceC0277a, int i10) throws ac.a {
        if (!fc.a.f()) {
            throw new ac.a(f18193h);
        }
        b bVar = new b(interfaceC0277a);
        this.f18198e.put(interfaceC0277a, bVar);
        l().g(bVar, i10);
    }

    @Override // gh.a
    public void i(mb.a.InterfaceC0277a interfaceC0277a, int i10) throws ac.a {
        if (!fc.a.f()) {
            throw new ac.a(f18193h);
        }
        l().i(this.f18198e.get(interfaceC0277a), i10);
        this.f18198e.remove(interfaceC0277a);
    }

    @Override // gh.a
    @b.a({"WrongConstant"})
    public boolean j() {
        try {
            Object objInvoke = cc.a.g(f18192g, "isFeatureEnabled", new Class[0]).invoke(this.f18194a.getSystemService("dream_animation"), null);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Throwable th2) {
            m7.a.a("isFeatureEnabled fail ", th2, f18191f);
            return false;
        }
    }

    public final c l() {
        if (this.f18195b == null) {
            this.f18195b = new c(this.f18194a);
        }
        return this.f18195b;
    }

    public final int m() {
        return ((Integer) cc.a.j(cc.a.g(cc.a.a("android.os.UserHandle"), "myUserId", new Class[0]), null, new Object[0])).intValue();
    }
}
