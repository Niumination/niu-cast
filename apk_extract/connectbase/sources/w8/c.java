package w8;

import android.content.Context;
import android.os.RemoteException;
import android.util.ArrayMap;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.trandreamanimation.ITranDreamAnimationCallback;
import com.transsion.hubsdk.trandreamanimation.ITranDreamAnimationManager;
import com.transsion.hubsdk.trandreamanimation.TranDreamAnimationManager;
import dc.e;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f18203h = "TranAospDreamAnimationManagerExt";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f18206c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18204a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<InterfaceC0468c> f18205b = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ITranDreamAnimationCallback.Stub f18208e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayMap<b, TranDreamAnimationManager.AODCallBack> f18209f = new ArrayMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TranDreamAnimationManager f18210g = d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ITranDreamAnimationManager f18207d = ITranDreamAnimationManager.Stub.asInterface(TranServiceManager.getServiceIBinder("dream_animation"));

    public class a extends ITranDreamAnimationCallback.Stub {
        public a() {
        }

        public void a(int i10) {
            synchronized (c.this.f18204a) {
                try {
                    Iterator<InterfaceC0468c> it = c.this.f18205b.iterator();
                    while (it.hasNext()) {
                        it.next().a(i10);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public interface b {
        void a(int i10);
    }

    /* JADX INFO: renamed from: w8.c$c, reason: collision with other inner class name */
    public interface InterfaceC0468c {
        void a(int i10);
    }

    public c(Context context) {
        this.f18206c = context;
    }

    public final TranDreamAnimationManager d() {
        if (this.f18210g == null) {
            this.f18210g = new TranDreamAnimationManager();
        }
        return this.f18210g;
    }

    public void f(int i10) {
        ITranDreamAnimationManager iTranDreamAnimationManager = this.f18207d;
        if (iTranDreamAnimationManager != null) {
            try {
                iTranDreamAnimationManager.onUpdateAODState(i10);
            } catch (RemoteException e10) {
                j7.b.a("onUpdateAODState fail:", e10, f18203h);
            }
        }
    }

    public void g(final b bVar, int i10) {
        if (bVar == null) {
            e.n(f18203h, "CallBack is not available while register.");
            return;
        }
        TranDreamAnimationManager.AODCallBack aODCallBack = new TranDreamAnimationManager.AODCallBack() { // from class: w8.b
            public final void a(int i11) {
                bVar.a(i11);
            }
        };
        try {
            this.f18209f.put(bVar, aODCallBack);
            TranDreamAnimationManager tranDreamAnimationManager = this.f18210g;
            if (tranDreamAnimationManager != null) {
                tranDreamAnimationManager.registerAODCallback(aODCallBack, i10);
            }
        } catch (Exception e10) {
            p6.b.a("registerAODCallback fail:", e10, f18203h);
        }
    }

    public void h(InterfaceC0468c interfaceC0468c, int i10) {
        if (interfaceC0468c == null) {
            e.n(f18203h, "CallBack is not available while register.");
            return;
        }
        synchronized (this.f18204a) {
            try {
                this.f18205b.add(interfaceC0468c);
                if (this.f18205b.size() == 1) {
                    this.f18207d.registerCallback(this.f18208e, i10);
                }
            } catch (Exception e10) {
                e.c(f18203h, "registerCallback fail:" + e10);
            }
        }
    }

    public void i(b bVar, int i10) {
        if (bVar == null) {
            e.n(f18203h, "CallBack is not available while register.");
            return;
        }
        try {
            TranDreamAnimationManager tranDreamAnimationManager = this.f18210g;
            if (tranDreamAnimationManager != null) {
                tranDreamAnimationManager.unRegisterAODCallback(this.f18209f.get(bVar), i10);
                this.f18209f.remove(bVar);
            }
        } catch (Exception e10) {
            p6.b.a("registerAODCallback fail:", e10, f18203h);
        }
    }

    public void j(InterfaceC0468c interfaceC0468c, int i10) {
        if (interfaceC0468c == null) {
            e.n(f18203h, "CallBack is not available while unRegister.");
            return;
        }
        synchronized (this.f18204a) {
            try {
                this.f18205b.remove(interfaceC0468c);
                if (this.f18205b.size() == 0) {
                    this.f18207d.unRegisterCallback(this.f18208e, i10);
                }
            } catch (Exception e10) {
                e.c(f18203h, "unRegisterCallback fail:" + e10);
            }
        }
    }
}
