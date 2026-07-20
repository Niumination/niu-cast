package vd;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranUEventObserver;
import com.transsion.hubsdk.os.ITranUEventObserverManager;
import com.transsion.hubsdk.os.TranUEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class k0 implements pg.o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16951b = "TranThubUEventObserver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranUEventObserverManager f16952a = ITranUEventObserverManager.Stub.asInterface(TranServiceManager.getServiceIBinder("uevent"));

    @Override // pg.o
    public void a(String str) {
        try {
            this.f16952a.startObserving(str);
        } catch (RemoteException e10) {
            j7.b.a("startObserving fail: ", e10, f16951b);
        }
    }

    @Override // pg.o
    public void b(va.u.b bVar) {
        try {
            ITranUEventObserverManager iTranUEventObserverManager = this.f16952a;
            if (iTranUEventObserverManager != null) {
                iTranUEventObserverManager.createObserver(new a(bVar));
            }
        } catch (RemoteException e10) {
            j7.b.a("createObserver fail: ", e10, f16951b);
        }
    }

    @Override // pg.o
    public void c(va.u.a aVar) {
        try {
            ITranUEventObserverManager iTranUEventObserverManager = this.f16952a;
            if (iTranUEventObserverManager != null) {
                iTranUEventObserverManager.createObserver(new a(aVar));
            }
        } catch (RemoteException e10) {
            j7.b.a("createObserver fail: ", e10, f16951b);
        }
    }

    @Override // pg.o
    public void d() {
        try {
            this.f16952a.stopObserving();
        } catch (RemoteException e10) {
            j7.b.a("stopObserving fail: ", e10, f16951b);
        }
    }

    public static class a extends ITranUEventObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public va.u.a f16953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public va.u.b f16954b;

        public a(va.u.a aVar) {
            this.f16953a = aVar;
        }

        public void a(TranUEvent tranUEvent) throws RemoteException {
            if (this.f16954b != null) {
                HashMap<String, String> map = tranUEvent.getMap();
                va.r rVar = new va.r();
                rVar.d(map);
                this.f16954b.a(rVar);
            }
        }

        public void b() throws RemoteException {
            va.u.a aVar = this.f16953a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public a(va.u.b bVar) {
            this.f16954b = bVar;
        }
    }
}
