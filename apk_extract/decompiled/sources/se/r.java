package se;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import java.util.Collection;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f9955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WifiP2pGroup f9956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WifiP2pInfo f9957d;
    public final /* synthetic */ Collection e;

    public /* synthetic */ r(Pair pair, WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection collection, int i8) {
        this.f9954a = i8;
        this.f9955b = pair;
        this.f9956c = wifiP2pGroup;
        this.f9957d = wifiP2pInfo;
        this.e = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9954a) {
            case 0:
                e1 e1Var = (e1) this.f9955b.getSecond();
                Collection clientList = this.e;
                e1Var.getClass();
                Intrinsics.checkNotNullParameter(clientList, "clientList");
                com.welink.protocol.nfbd.g.b(e1Var.f9726b, this.f9956c, this.f9957d, clientList);
                break;
            case 1:
                e1 e1Var2 = (e1) this.f9955b.getSecond();
                Collection clientList2 = this.e;
                e1Var2.getClass();
                Intrinsics.checkNotNullParameter(clientList2, "clientList");
                com.welink.protocol.nfbd.g.b(e1Var2.f9726b, this.f9956c, this.f9957d, clientList2);
                break;
            case 2:
                e1 e1Var3 = (e1) this.f9955b.getSecond();
                Collection clientList3 = this.e;
                e1Var3.getClass();
                Intrinsics.checkNotNullParameter(clientList3, "clientList");
                com.welink.protocol.nfbd.g.b(e1Var3.f9726b, this.f9956c, this.f9957d, clientList3);
                break;
            case 3:
                ((b4) this.f9955b.getSecond()).h(this.f9956c, this.f9957d, this.e);
                break;
            case 4:
                ((b4) this.f9955b.getSecond()).h(this.f9956c, this.f9957d, this.e);
                break;
            default:
                ((b4) this.f9955b.getSecond()).f(this.f9956c, this.f9957d, this.e);
                break;
        }
    }
}
