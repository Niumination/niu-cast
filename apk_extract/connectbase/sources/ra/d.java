package ra;

import a8.l;
import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14361c = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rd.b f14362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f14363b;

    public interface a {
        void onFailure(int i10);

        void onSuccess();
    }

    public interface b {
        void onChannelDisconnected();
    }

    public void a(WifiP2pManager.Channel channel, int i10, WifiP2pManager.ActionListener actionListener) {
        b(fc.b.a.f5989i).b(channel, i10, actionListener);
    }

    public lg.b b(String str) {
        if (fc.b.b(str)) {
            rd.b bVar = this.f14362a;
            if (bVar != null) {
                return bVar;
            }
            rd.b bVar2 = new rd.b();
            this.f14362a = bVar2;
            return bVar2;
        }
        l lVar = this.f14363b;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l();
        this.f14363b = lVar2;
        return lVar2;
    }

    public void c(int i10, int i11, b bVar, a aVar) {
        b(fc.b.a.f5984d).a(i10, i11, bVar, aVar);
    }
}
