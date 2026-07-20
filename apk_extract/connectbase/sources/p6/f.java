package p6;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.IProcessObserver;
import android.app.TaskStackListener;
import android.app.UserSwitchObserver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.IPackageDataObserver;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.util.ArrayMap;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12954e = "TranAospActivityManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<d, e> f12956b = new ArrayMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap<g, TaskStackListener> f12957c = new ArrayMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayMap<h, UserSwitchObserver> f12958d = new ArrayMap<>();

    public class a extends UserSwitchObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f12959a;

        public a(h hVar) {
            this.f12959a = hVar;
        }

        public void a(int i10) {
            h hVar = this.f12959a;
            if (hVar != null) {
                hVar.a(i10);
            }
        }

        public void b(int i10, IRemoteCallback iRemoteCallback) {
            h hVar = this.f12959a;
            if (hVar != null) {
                hVar.b(i10);
            }
        }
    }

    public class b extends TaskStackListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f12961a;

        public b(g gVar) {
            this.f12961a = gVar;
        }

        public void a(int i10) {
            dc.e.a(f.f12954e, "onLockTaskModeChanged listener" + this.f12961a);
            g gVar = this.f12961a;
            if (gVar != null) {
                gVar.b(i10);
            }
        }

        public void b(int i10, ComponentName componentName) {
            dc.e.a(f.f12954e, "onTaskCreated listener" + this.f12961a);
            g gVar = this.f12961a;
            if (gVar != null) {
                gVar.c(i10, componentName);
            }
        }

        public void c(int i10, boolean z10) {
            dc.e.a(f.f12954e, "onTaskFocusChanged listener" + this.f12961a);
            g gVar = this.f12961a;
            if (gVar != null) {
                gVar.a(i10, z10);
            }
        }
    }

    public interface c {
        void a(String str, boolean z10);
    }

    public interface d {
        void a(int i10, int i11);

        void b(int i10, int i11, boolean z10);

        void c(int i10, int i11, int i12);
    }

    public class e extends IProcessObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f12963a;

        public e(d dVar) {
            this.f12963a = dVar;
        }

        public void a(int i10, int i11, boolean z10) throws RemoteException {
            this.f12963a.b(i10, i11, z10);
        }

        public void b(int i10, int i11, int i12) throws RemoteException {
            this.f12963a.c(i10, i11, i12);
        }

        public void c(int i10, int i11) throws RemoteException {
            this.f12963a.a(i10, i11);
        }

        public void d(int i10, int i11, int i12, String str, String str2) throws RemoteException {
        }
    }

    /* JADX INFO: renamed from: p6.f$f, reason: collision with other inner class name */
    public static class C0325f extends IPackageDataObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f12965a;

        public C0325f(c cVar) {
            this.f12965a = cVar;
        }

        public void a(String str, boolean z10) {
            c cVar = this.f12965a;
            if (cVar != null) {
                cVar.a(str, z10);
            }
        }
    }

    public interface g {
        void a(int i10, boolean z10);

        void b(int i10);

        void c(int i10, ComponentName componentName);
    }

    public interface h {
        void a(int i10);

        void b(int i10);
    }

    public f(Context context) {
        this.f12955a = context;
    }

    public final IActivityManager a() {
        return (IActivityManager) cc.a.j(cc.a.g(ActivityManager.class, "getService", new Class[0]), null, new Object[0]);
    }

    public void b(d dVar) {
        e eVar = new e(dVar);
        this.f12956b.put(dVar, eVar);
        try {
            a().registerProcessObserver(eVar);
        } catch (RemoteException e10) {
            dc.e.d(f12954e, "registerProcessObserver: ", e10);
        }
    }

    public void c(g gVar) {
        b bVar = new b(gVar);
        try {
            this.f12957c.put(gVar, bVar);
            a().registerTaskStackListener(bVar);
        } catch (RemoteException e10) {
            dc.e.a(f12954e, "registerTaskStackListener fail" + e10);
        }
    }

    public void d(h hVar, String str) {
        a aVar = new a(hVar);
        try {
            a().registerUserSwitchObserver(aVar, str);
            this.f12958d.put(hVar, aVar);
        } catch (RemoteException e10) {
            dc.e.a(f12954e, "registerUserSwitchObserver fail" + e10);
        }
    }

    public void e(d dVar) {
        e eVar = this.f12956b.get(dVar);
        if (eVar != null) {
            try {
                a().unregisterProcessObserver(eVar);
            } catch (RemoteException e10) {
                dc.e.d(f12954e, "unRegisterProcessObserver: ", e10);
            }
            this.f12956b.remove(dVar);
        }
    }

    public void f(g gVar) {
        try {
            a().unregisterTaskStackListener(this.f12957c.get(gVar));
            this.f12957c.remove(gVar);
        } catch (RemoteException e10) {
            dc.e.a(f12954e, "registerTaskStackListener fail" + e10);
        }
    }

    public void g(h hVar) {
        try {
            a().unregisterUserSwitchObserver(this.f12958d.get(hVar));
            this.f12958d.remove(hVar);
        } catch (RemoteException e10) {
            dc.e.a(f12954e, "registerUserSwitchObserver fail" + e10);
        }
    }
}
