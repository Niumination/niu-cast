package bb;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ServiceManager;
import android.util.Log;
import com.transsion.atomiccore.hostsdk.utils.AtomicCoreUtils;
import com.transsion.iotservice.multiscreen.pc.PCConnectApplication;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import com.transsion.iotservice.pc.utils.HiUtils;
import eb.h0;
import eb.k1;
import eb.l0;
import eb.y1;
import java.util.List;
import java.util.TimeZone;
import k3.gc;
import k3.pb;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharDirectionality;
import kotlin.text.StringsKt__StringsKt;
import m3.j6;
import se.b1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1251a;

    public /* synthetic */ s(int i8) {
        this.f1251a = i8;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f1251a) {
            case 0:
                HandlerThread handlerThread = new HandlerThread("NotificationHandler");
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            case 1:
                if (!DeviceConnectState.INSTANCE.isConnected()) {
                    return MapsKt.mapOf(TuplesKt.to(db.f.f4395a, CollectionsKt.emptyList()));
                }
                String str = db.f.f4395a;
                k1 k1Var = k1.f4765a;
                return MapsKt.mapOf(TuplesKt.to(str, CollectionsKt.listOf(db.f.a(k1.e))));
            case 2:
                ld.m mVar = dc.n.f4427a;
                if (mVar != null) {
                    mVar.dismiss();
                }
                return Unit.INSTANCE;
            case 3:
                return Boolean.valueOf(dh.d.a());
            case 4:
                return (WifiP2pManager) pb.a().getSystemService(WifiP2pManager.class);
            case 5:
                Lazy lazy = l0.f4770a;
                WifiP2pManager wifiP2pManager = (WifiP2pManager) l0.f4770a.getValue();
                if (wifiP2pManager != null) {
                    return wifiP2pManager.initialize(pb.a(), pb.a().getMainLooper(), new h0(0));
                }
                return null;
            case 6:
                Intrinsics.checkNotNullParameter("PhysicalConnectManager", "tag");
                Intrinsics.checkNotNullParameter("BleFromPeerConnect:onPreConnectCallback", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PhysicalConnectManager"), "BleFromPeerConnect:onPreConnectCallback");
                }
                k1 k1Var2 = k1.f4765a;
                k1.j("ble_from_peer");
                return Unit.INSTANCE;
            case 7:
                Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
                Intrinsics.checkNotNullParameter("Heart timeout", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("SocketClientManager"), "Heart timeout");
                }
                TCCPHandshakeSocketClient tCCPHandshakeSocketClient = y1.f4826a;
                y1.c();
                return Unit.INSTANCE;
            case 8:
                return Boolean.valueOf(AtomicCoreUtils.isSupportAtomicCoreCard(pb.a()));
            case 9:
                return HiUtils.sGson_delegate$lambda$0();
            case 10:
                return new gb.a();
            case 11:
                return new gb.f();
            case 12:
                return Unit.INSTANCE;
            case 13:
                PCConnectApplication pCConnectApplication = PCConnectApplication.f2386d;
                if (pCConnectApplication != null) {
                    return pCConnectApplication;
                }
                Intrinsics.throwUninitializedPropertyAccessException("context");
                return null;
            case 14:
                hb.a aVar = new hb.a();
                Object systemService = pb.a().getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                aVar.f5276a = notificationManager;
                notificationManager.createNotificationChannel(new NotificationChannel("WelinkService_ChannelId", "WelinkService_ChannelName", 4));
                return aVar;
            case 15:
                return pb.a();
            case 16:
                return CharDirectionality.directionalityMap_delegate$lambda$1();
            case 17:
                return new jb.e();
            case 18:
                return j6.a(true);
            case 19:
                kg.a aVar2 = kg.a.f6870c;
                String rawVersion = System.getProperty("java.version");
                Intrinsics.checkNotNullExpressionValue(rawVersion, "getProperty(...)");
                Intrinsics.checkNotNullParameter(rawVersion, "rawVersion");
                try {
                    List listSplit$default = StringsKt__StringsKt.split$default(rawVersion, new char[]{'-', '_'}, false, 0, 6, (Object) null);
                    return listSplit$default.size() == 2 ? new kg.a((String) listSplit$default.get(0), Integer.parseInt((String) listSplit$default.get(1))) : new kg.a(rawVersion, -1);
                } catch (Throwable unused) {
                    return kg.a.f6870c;
                }
            case 20:
                TimeZone timeZone = ch.a.f1686a;
                return Long.valueOf(System.currentTimeMillis());
            case 21:
                return (b1) b1.f9652d.b(pb.a());
            case 22:
                return j6.a(true);
            case 23:
                return Unit.INSTANCE;
            case 24:
                return pa.a.f8703a.i("ro.tr_project.tos.type", "ro.tranos.type", "");
            case 25:
                return Boolean.valueOf(StringsKt__StringsKt.contains$default((String) na.c.f8133a.getValue(), "itel", false, 2, (Object) null));
            case 26:
                return pa.a.f8703a.d("ro.product.brand", "");
            case 27:
                return new s8.a();
            case 28:
                IBinder service = ServiceManager.getService("vendor.transsion.hardware.trannet.ITranNet/default");
                int i8 = rk.b.f9443b;
                if (service == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = service.queryLocalInterface(rk.c.f9444a);
                if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof rk.c)) {
                    return (rk.c) iInterfaceQueryLocalInterface;
                }
                rk.a aVar3 = new rk.a();
                aVar3.f9442b = service;
                return aVar3;
            default:
                int i9 = vi.j.f10602a;
                return new vi.i(100, 0);
        }
    }

    public /* synthetic */ s(nf.h hVar) {
        this.f1251a = 29;
    }
}
