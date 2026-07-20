package q6;

import android.app.role.RoleManager;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import dc.e;
import e8.m;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class b implements cf.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13854e = "b";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f13855f = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f13856g = cc.a.a("android.app.role.IRoleManager$Stub");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Class<?> f13857h = cc.a.a("android.os.RemoteCallback$OnResultListener");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Class<?> f13858i = cc.a.a("android.app.role.RoleManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f13859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f13860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f13861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoleManager f13862d;

    public interface a {
        void a(Bundle bundle);
    }

    /* JADX INFO: renamed from: q6.b$b, reason: collision with other inner class name */
    public static class C0340b implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f13863a;

        public C0340b(a aVar) {
            this.f13863a = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            e.a(b.f13854e, "RemoteCallback invoke methodName:" + name);
            if (!"onResult".equals(name)) {
                return null;
            }
            this.f13863a.a((Bundle) objArr[0]);
            return null;
        }
    }

    public b() {
        Context contextA = bc.a.a();
        this.f13860b = contextA;
        this.f13862d = (RoleManager) contextA.getSystemService("role");
    }

    public static /* synthetic */ void j(CompletableFuture completableFuture, Bundle bundle) {
        completableFuture.complete(Boolean.valueOf(bundle != null));
    }

    @Override // cf.a
    public List<String> a(String str) {
        ArrayList arrayList = new ArrayList();
        Object objJ = cc.a.j(cc.a.g(f13858i, "getRoleHolders", String.class), this.f13862d, str);
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((String) String.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // cf.a
    public boolean b(String str, String str2) {
        Object objJ = cc.a.j(cc.a.g(f13858i, "removeRoleHolderFromController", String.class, String.class), (RoleManager) this.f13860b.getSystemService(RoleManager.class), str, str2);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // cf.a
    public boolean c(String str, String str2) {
        Object objJ = cc.a.j(cc.a.g(f13858i, "addRoleHolderFromController", String.class, String.class), (RoleManager) this.f13860b.getSystemService(RoleManager.class), str, str2);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // cf.a
    public void d(String str, String str2, Executor executor, Consumer<Boolean> consumer) {
        cc.a.j(cc.a.g(this.f13862d.getClass(), "isApplicationVisibleForRole", String.class, String.class, Executor.class, Consumer.class), this.f13862d, str, str2, executor, consumer);
    }

    @Override // cf.a
    public void e(String str, String str2, int i10, int i11, m.a aVar) {
        Method methodG = cc.a.g(f13855f, "getServiceOrThrow", String.class);
        Object binder = new Binder();
        Object objJ = cc.a.j(methodG, f13855f, "role");
        if (objJ instanceof IBinder) {
            binder = (IBinder) objJ;
        }
        String str3 = f13854e;
        e.a(str3, "addRoleHolderAsUserExt iBinder :" + binder);
        Object objJ2 = cc.a.j(cc.a.g(f13856g, "asInterface", IBinder.class), f13856g, binder);
        e.a(str3, "addRoleHolderAsUserExt object :" + objJ2);
        if (objJ2 != null) {
            i().b(objJ2, str, str2, i10, i11, aVar);
        }
    }

    @Override // cf.a
    public void f(String str, String str2, int i10, int i11) {
        try {
            if (this.f13859a == null) {
                this.f13859a = cc.a.g(f13855f, "getService", String.class);
            }
            Object objJ = cc.a.j(this.f13859a, f13855f, "role");
            Object objJ2 = objJ != null ? cc.a.j(cc.a.g(objJ.getClass(), "queryLocalInterface", String.class), objJ, "android.app.role.IRoleManager") : null;
            final CompletableFuture completableFuture = new CompletableFuture();
            Object objNewProxyInstance = Proxy.newProxyInstance(f13857h.getClassLoader(), new Class[]{f13857h}, new C0340b(new a() { // from class: q6.a
                @Override // q6.b.a
                public final void a(Bundle bundle) {
                    b.j(completableFuture, bundle);
                }
            }));
            e.a(f13854e, "addRoleHolderAsUser callback: " + objNewProxyInstance);
            if (objJ2 != null) {
                cc.a.j(cc.a.g(objJ2.getClass(), "addRoleHolderAsUser", String.class, String.class, Integer.class, Integer.class, Object.class), objJ2, str, str2, Integer.valueOf(i10), Integer.valueOf(i11), objNewProxyInstance);
            }
        } catch (Exception e10) {
            p6.b.a("addRoleHolderAsUser fail: ", e10, f13854e);
        }
    }

    public final m i() {
        if (this.f13861c == null) {
            this.f13861c = new m();
        }
        return this.f13861c;
    }
}
