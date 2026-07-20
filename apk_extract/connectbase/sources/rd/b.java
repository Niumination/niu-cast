package rd;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.net.wifi.ITranActionListener;
import com.transsion.hubsdk.net.wifi.ITranChannelListener;
import com.transsion.hubsdk.net.wifi.ITranWifiP2pManager;
import com.transsion.hubsdk.net.wifi.TranWifiP2pManager;
import ra.d;

/* JADX INFO: loaded from: classes2.dex */
public class b implements lg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14456c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranWifiP2pManager f14457a = ITranWifiP2pManager.Stub.asInterface(TranServiceManager.getServiceIBinder("wifi_p2p_manager"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranWifiP2pManager f14458b;

    public class a extends ITranActionListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d.a f14459a;

        public a(d.a aVar) {
            this.f14459a = aVar;
        }

        public void a(int i10) throws RemoteException {
            d.a aVar = this.f14459a;
            if (aVar != null) {
                aVar.onFailure(i10);
            }
        }

        public void b() throws RemoteException {
            d.a aVar = this.f14459a;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }
    }

    /* JADX INFO: renamed from: rd.b$b, reason: collision with other inner class name */
    public class C0351b extends ITranChannelListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d.b f14461a;

        public C0351b(d.b bVar) {
            this.f14461a = bVar;
        }

        public void a() throws RemoteException {
            d.b bVar = this.f14461a;
            if (bVar != null) {
                bVar.onChannelDisconnected();
            }
        }
    }

    @Override // lg.b
    public void a(int i10, int i11, d.b bVar, d.a aVar) {
        a aVar2 = new a(aVar);
        C0351b c0351b = new C0351b(bVar);
        ITranWifiP2pManager iTranWifiP2pManager = this.f14457a;
        if (iTranWifiP2pManager != null) {
            try {
                iTranWifiP2pManager.setWifiP2pChannels(i10, i11, c0351b, aVar2);
            } catch (RemoteException e10) {
                j7.b.a("forget fail ", e10, f14456c);
            }
        }
    }

    @Override // lg.b
    public void b(WifiP2pManager.Channel channel, int i10, WifiP2pManager.ActionListener actionListener) {
        c().deletePersistentGroup(channel, i10, actionListener);
    }

    public final TranWifiP2pManager c() {
        if (this.f14458b == null) {
            this.f14458b = new TranWifiP2pManager(bc.a.a());
        }
        return this.f14458b;
    }
}
