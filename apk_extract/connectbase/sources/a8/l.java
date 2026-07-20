package a8;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes2.dex */
public class l implements lg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f173c = "l";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f175b;

    public class a implements m.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ra.d.a f176a;

        public a(ra.d.a aVar) {
            this.f176a = aVar;
        }

        @Override // a8.m.c
        public void onFailure(int i10) {
            ra.d.a aVar = this.f176a;
            if (aVar != null) {
                aVar.onFailure(i10);
            }
        }

        @Override // a8.m.c
        public void onSuccess() {
            ra.d.a aVar = this.f176a;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }
    }

    public class b implements m.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ra.d.b f178a;

        public b(ra.d.b bVar) {
            this.f178a = bVar;
        }

        @Override // a8.m.d
        public void onChannelDisconnected() {
            ra.d.b bVar = this.f178a;
            if (bVar != null) {
                bVar.onChannelDisconnected();
            }
        }
    }

    public l() {
        Context contextA = bc.a.a();
        this.f174a = contextA;
        this.f175b = new m(contextA);
    }

    @Override // lg.b
    public void a(int i10, int i11, ra.d.b bVar, ra.d.a aVar) {
        this.f175b.a(i10, i11, bVar != null ? new b(bVar) : null, aVar != null ? new a(aVar) : null);
    }

    @Override // lg.b
    public void b(WifiP2pManager.Channel channel, int i10, WifiP2pManager.ActionListener actionListener) {
        WifiP2pManager wifiP2pManager = (WifiP2pManager) this.f174a.getSystemService("wifip2p");
        cc.a.j(cc.a.g(wifiP2pManager.getClass(), "deletePersistentGroup", WifiP2pManager.Channel.class, Integer.TYPE, WifiP2pManager.ActionListener.class), wifiP2pManager, channel, Integer.valueOf(i10), actionListener);
    }
}
