package me;

import android.os.RemoteException;
import android.util.ArrayMap;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.TranUserHandle;
import com.transsion.hubsdk.trandreamanimation.ITranDreamAnimationManager;
import com.transsion.hubsdk.trandreamanimation.TranDreamAnimationManager;
import dc.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gh.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10637e = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ITranDreamAnimationManager f10640c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap<mb.a.b, TranDreamAnimationManager.CallBack> f10638a = new ArrayMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<mb.a.InterfaceC0277a, b> f10641d = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranDreamAnimationManager f10639b = new TranDreamAnimationManager();

    /* JADX INFO: renamed from: me.a$a, reason: collision with other inner class name */
    public class C0278a implements TranDreamAnimationManager.CallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ mb.a.b f10642a;

        public C0278a(mb.a.b bVar) {
            this.f10642a = bVar;
        }

        public void a(int i10) {
            this.f10642a.a(i10);
        }
    }

    public class b implements TranDreamAnimationManager.AODCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public mb.a.InterfaceC0277a f10644a;

        public b(mb.a.InterfaceC0277a interfaceC0277a) {
            this.f10644a = interfaceC0277a;
        }

        public void a(int i10) {
            mb.a.InterfaceC0277a interfaceC0277a = this.f10644a;
            if (interfaceC0277a != null) {
                interfaceC0277a.a(i10);
            }
        }
    }

    @Override // gh.a
    public void a(int i10) throws ac.a {
        ITranDreamAnimationManager iTranDreamAnimationManagerK = k();
        if (iTranDreamAnimationManagerK != null) {
            try {
                iTranDreamAnimationManagerK.onUpdateAODState(i10);
            } catch (RemoteException e10) {
                j7.b.a("onUpdateAODState fail: ", e10, f10637e);
            }
        }
    }

    @Override // gh.a
    public void b(mb.a.InterfaceC0277a interfaceC0277a) throws ac.a {
        b bVar = this.f10641d.get(interfaceC0277a);
        TranDreamAnimationManager tranDreamAnimationManager = this.f10639b;
        if (tranDreamAnimationManager == null || bVar == null) {
            return;
        }
        tranDreamAnimationManager.unRegisterAODCallback(bVar);
        this.f10641d.remove(bVar);
    }

    @Override // gh.a
    public void c(mb.a.InterfaceC0277a interfaceC0277a) throws ac.a {
        b bVar = new b(interfaceC0277a);
        if (this.f10639b != null) {
            this.f10641d.put(interfaceC0277a, bVar);
            this.f10639b.registerAODCallback(bVar);
        }
    }

    @Override // gh.a
    public void d(mb.a.b bVar) {
        f(bVar, TranUserHandle.myUserId());
    }

    @Override // gh.a
    public void e(mb.a.b bVar, int i10) {
        if (bVar == null) {
            e.n(f10637e, "CallBack is not available while unregister.");
        } else {
            this.f10639b.unRegisterCallback(this.f10638a.get(bVar));
            this.f10638a.remove(bVar);
        }
    }

    @Override // gh.a
    public void f(mb.a.b bVar, int i10) {
        if (bVar == null) {
            e.n(f10637e, "CallBack is not available while register.");
            return;
        }
        C0278a c0278a = new C0278a(bVar);
        this.f10638a.put(bVar, c0278a);
        this.f10639b.registerCallback(c0278a);
    }

    @Override // gh.a
    public void g(mb.a.b bVar) {
        e(bVar, TranUserHandle.myUserId());
    }

    @Override // gh.a
    public void h(mb.a.InterfaceC0277a interfaceC0277a, int i10) throws ac.a {
        b bVar = new b(interfaceC0277a);
        if (this.f10639b != null) {
            this.f10641d.put(interfaceC0277a, bVar);
            this.f10639b.registerAODCallback(bVar, i10);
        }
    }

    @Override // gh.a
    public void i(mb.a.InterfaceC0277a interfaceC0277a, int i10) throws ac.a {
        b bVar = this.f10641d.get(interfaceC0277a);
        TranDreamAnimationManager tranDreamAnimationManager = this.f10639b;
        if (tranDreamAnimationManager == null || bVar == null) {
            return;
        }
        tranDreamAnimationManager.unRegisterAODCallback(bVar, i10);
        this.f10641d.remove(bVar);
    }

    @Override // gh.a
    public boolean j() {
        TranDreamAnimationManager tranDreamAnimationManager = this.f10639b;
        if (tranDreamAnimationManager == null) {
            return false;
        }
        try {
            return tranDreamAnimationManager.isFeatureEnabled();
        } catch (RuntimeException e10) {
            e.c(f10637e, "isFeatureEnabled e=" + e10);
            return false;
        }
    }

    public ITranDreamAnimationManager k() {
        if (this.f10640c == null) {
            this.f10640c = ITranDreamAnimationManager.Stub.asInterface(TranServiceManager.getServiceIBinder("dream_animation"));
        }
        return this.f10640c;
    }

    @VisibleForTesting
    public void l(TranDreamAnimationManager tranDreamAnimationManager) {
        this.f10639b = tranDreamAnimationManager;
    }
}
