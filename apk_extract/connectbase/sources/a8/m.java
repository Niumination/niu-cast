package a8;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f180b = "TranAospWifiP2pManagerExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f181a;

    public class a implements WifiP2pManager.ChannelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f182a;

        public a(d dVar) {
            this.f182a = dVar;
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ChannelListener
        public void onChannelDisconnected() {
            d dVar = this.f182a;
            if (dVar != null) {
                dVar.onChannelDisconnected();
            }
        }
    }

    public class b implements WifiP2pManager.ActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f184a;

        public b(c cVar) {
            this.f184a = cVar;
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i10) {
            c cVar = this.f184a;
            if (cVar != null) {
                cVar.onFailure(i10);
            }
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            c cVar = this.f184a;
            if (cVar != null) {
                cVar.onSuccess();
            }
        }
    }

    public interface c {
        void onFailure(int i10);

        void onSuccess();
    }

    public interface d {
        void onChannelDisconnected();
    }

    public m(Context context) {
        this.f181a = context;
    }

    @b.a({"MissingPermission"})
    public void a(int i10, int i11, d dVar, c cVar) {
        try {
            dc.e.a(f180b, "setWifiP2pChannels listeningChannel:" + i10 + ",operatingChannel:" + i11);
            WifiP2pManager wifiP2pManager = (WifiP2pManager) this.f181a.getSystemService("wifip2p");
            wifiP2pManager.setWifiP2pChannels(wifiP2pManager.initialize(this.f181a, Looper.myLooper(), new a(dVar)), i10, i11, new b(cVar));
        } catch (Exception unused) {
            dc.e.c(f180b, "setWifiP2pChannels fail");
        }
    }
}
