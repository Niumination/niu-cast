package bb;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import com.transsion.athena.data.TrackData;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.utils.EncoderUtil;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpHeartBeat;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import eb.l2;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import k3.dd;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import m3.f0;
import m3.g0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1252a;

    public /* synthetic */ t(int i8) {
        this.f1252a = i8;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e7 A[Catch: Exception -> 0x0209, TryCatch #4 {Exception -> 0x0209, blocks: (B:93:0x01c7, B:95:0x01d7, B:97:0x01dd, B:98:0x01e1, B:100:0x01e7, B:102:0x01f3, B:104:0x01fb, B:107:0x020b, B:109:0x0211, B:111:0x0219), top: B:144:0x01c7 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x01f3 A[Catch: Exception -> 0x0209, TryCatch #4 {Exception -> 0x0209, blocks: (B:93:0x01c7, B:95:0x01d7, B:97:0x01dd, B:98:0x01e1, B:100:0x01e7, B:102:0x01f3, B:104:0x01fb, B:107:0x020b, B:109:0x0211, B:111:0x0219), top: B:144:0x01c7 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x020b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x020b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x01fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x01e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x01e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:91:0x01b5  */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        FileInputStream fileInputStream;
        String string;
        String strEncoderByAlgorithm;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        FileInputStream fileInputStream2 = null;
        switch (this.f1252a) {
            case 0:
                if (v.f1257b != null) {
                    NotificationManager notificationManager = v.f1256a;
                    v.b();
                    ((Handler) v.f1260g.getValue()).post(new u(v.f1259d, v.e, v.f));
                    return;
                }
                return;
            case 1:
                Intrinsics.checkNotNullParameter("CastStatusNotificationManager", "tag");
                Intrinsics.checkNotNullParameter("cancelConnectNotification", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("CastStatusNotificationManager"), "cancelConnectNotification");
                }
                v.f1257b = null;
                v.f1256a.cancel(144);
                return;
            case 2:
                if (e8.b.f4711h > 0) {
                    e8.b bVar = e8.b.f;
                    bVar.getClass();
                    if (!e8.b.m()) {
                        z6.a.a("Athena SDK isAthenaEnable = false");
                        return;
                    }
                    for (Integer num : t6.d.f10185b) {
                        if (num.intValue() != 9999) {
                            bVar.o("app_launch", null, num.intValue());
                        }
                    }
                    return;
                }
                return;
            case 3:
                e8.b.f.getClass();
                if (!e8.b.m()) {
                    z6.a.a("Athena SDK isAthenaEnable = false");
                    return;
                }
                TrackData trackData = new TrackData();
                String str = s6.d.f9538a;
                if (e8.b.j()) {
                    trackData.g("iid", g0.c(e8.b.f4712i, 0));
                    trackData.g("iid2", g0.c(e8.b.f4712i, 1));
                }
                if (e8.b.j()) {
                    trackData.g("isd", g0.i(e8.b.f4712i, 1));
                    trackData.g("isd2", g0.i(e8.b.f4712i, 2));
                }
                if (e8.b.j()) {
                    trackData.g("aid", g0.h(e8.b.f4712i));
                }
                StringBuilder sb2 = new StringBuilder();
                try {
                    fileInputStream = new FileInputStream(new File("proc/rid"));
                    try {
                        byte[] bArr = new byte[1];
                        while (fileInputStream.read(bArr) != -1) {
                            sb2.append(dd.k(bArr));
                        }
                    } catch (Exception unused) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            fileInputStream = fileInputStream2;
                        }
                        string = sb2.toString();
                        if (TextUtils.isEmpty(string)) {
                            strEncoderByAlgorithm = "";
                        } else {
                            strEncoderByAlgorithm = EncoderUtil.EncoderByAlgorithm(string);
                        }
                        trackData.g("chip", strEncoderByAlgorithm);
                        trackData.g("sn", g0.k());
                        activeSubscriptionInfoList = ((SubscriptionManager) e8.b.f4712i.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                        if (activeSubscriptionInfoList != null) {
                            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                                if (subscriptionInfo.getSimSlotIndex() == 0) {
                                    String str2 = s6.d.f9538a;
                                    if (e8.b.j()) {
                                        trackData.g("isd", g0.i(e8.b.f4712i, subscriptionInfo.getSubscriptionId()));
                                    }
                                }
                                if (subscriptionInfo.getSimSlotIndex() == 1) {
                                    String str3 = s6.d.f9538a;
                                    if (e8.b.j()) {
                                        trackData.g("isd2", g0.i(e8.b.f4712i, subscriptionInfo.getSubscriptionId()));
                                    }
                                }
                                break;
                            }
                        }
                        long j8 = 9999;
                        e8.b.n(j8).o("device", trackData, j8);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e) {
                                z6.a.c(e.getMessage());
                            }
                            break;
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    fileInputStream.close();
                    break;
                } catch (Exception e4) {
                    z6.a.c(e4.getMessage());
                }
                string = sb2.toString();
                if (TextUtils.isEmpty(string)) {
                    strEncoderByAlgorithm = "";
                } else {
                    strEncoderByAlgorithm = EncoderUtil.EncoderByAlgorithm(string);
                }
                trackData.g("chip", strEncoderByAlgorithm);
                trackData.g("sn", g0.k());
                try {
                    activeSubscriptionInfoList = ((SubscriptionManager) e8.b.f4712i.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                    if (activeSubscriptionInfoList != null && activeSubscriptionInfoList.size() > 0) {
                        while (r1.hasNext()) {
                            if (subscriptionInfo.getSimSlotIndex() == 0) {
                                String str4 = s6.d.f9538a;
                                if (e8.b.j()) {
                                    trackData.g("isd", g0.i(e8.b.f4712i, subscriptionInfo.getSubscriptionId()));
                                }
                            }
                            if (subscriptionInfo.getSimSlotIndex() == 1) {
                                String str5 = s6.d.f9538a;
                                if (e8.b.j()) {
                                    trackData.g("isd2", g0.i(e8.b.f4712i, subscriptionInfo.getSubscriptionId()));
                                }
                            }
                        }
                    }
                    break;
                } catch (Exception e10) {
                    z6.a.c(e10.getMessage());
                }
                long j10 = 9999;
                e8.b.n(j10).o("device", trackData, j10);
                return;
            case 4:
                Context context = e8.b.f4712i;
                try {
                    if (f0.f7670b == null) {
                        f0.f7670b = new eb.d(3);
                    }
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        connectivityManager.registerNetworkCallback(networkRequestBuild, f0.f7670b);
                        return;
                    }
                    return;
                } catch (Exception e11) {
                    ObjectLogUtils objectLogUtils = z6.a.f11258a;
                    z6.a.c(Log.getStackTraceString(e11));
                    return;
                }
            case 5:
                Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
                Intrinsics.checkNotNullParameter("handshake onClose reason for heartbeat", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("SocketServerManager"), "handshake onClose reason for heartbeat");
                }
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
                l2.f();
                return;
            case 6:
                TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = l2.f4772a;
                if (tCCPHandshakeSocketServer2 != null) {
                    tCCPHandshakeSocketServer2.sendRequest(TccpConfig.INSTANCE.getHEARTBEAT_TCCP(), new TccpHeartBeat(22000L));
                    return;
                }
                return;
            case 7:
                Camera2CameraControlImpl.lambda$addInteropConfig$1();
                return;
            case 8:
                Camera2CameraControlImpl.lambda$clearInteropConfig$2();
                return;
            case 9:
                h7.a aVar = t7.a.f10192c;
                if (aVar != null) {
                    pb.a().getContentResolver().unregisterContentObserver(aVar);
                    return;
                }
                return;
            case 10:
                int i8 = FunctionGuideActivity.f2774o;
                Intrinsics.checkNotNullParameter("FunctionGuideActivity", "tag");
                Intrinsics.checkNotNullParameter("permission granted, turn icon", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("FunctionGuideActivity"), "permission granted, turn icon");
                    return;
                }
                return;
            case 11:
                NotificationManager notificationManager2 = wa.c.f10693a;
                if (notificationManager2 != null) {
                    notificationManager2.cancel(2);
                }
                wa.c.f10693a = null;
                wa.c.f10696d = null;
                wa.c.f10694b = null;
                wa.c.f10695c = null;
                m3.m.f7774a = false;
                return;
            default:
                if (yc.f.e) {
                    try {
                        Application application = yc.f.f11123b;
                        if (application == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                            application = null;
                        }
                        application.unbindService(yc.f.f11128i);
                        yc.f.e = false;
                        yc.f.f11125d = null;
                        Log.d("ActionCommunicator", "Unbound target service: " + yc.f.f11124c);
                        return;
                    } catch (Exception e12) {
                        Log.e("ActionCommunicator", "Failed to unbind target service: " + e12.getMessage(), e12);
                        return;
                    }
                }
                return;
        }
    }
}
