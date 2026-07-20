package eb;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.pcconnect.invoke.bridge.Device;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Device f4747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f4748c;

    public /* synthetic */ b0(Device device, boolean z2, int i8) {
        this.f4746a = i8;
        this.f4747b = device;
        this.f4748c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2 = this.f4748c;
        Device device = this.f4747b;
        switch (this.f4746a) {
            case 0:
                li.g2 g2Var = g0.f4759i;
                if (g2Var != null) {
                    g2Var.h(null);
                }
                g0.f4759i = li.l0.p(g0.f4757g, null, null, new c0(device, z2, null), 3);
                break;
            case 1:
                Device device2 = g0.f;
                if (device2 != null) {
                    if (Intrinsics.areEqual(device2.f2950d, device.f2950d)) {
                        String log = "changePhoneExtendState enable:" + z2;
                        Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
                        Intrinsics.checkNotNullParameter(log, "log");
                        if (gc.f6462a <= 4) {
                            Log.i(gc.f6463b.concat("MultiConnectManager"), log);
                        }
                        String str = device.f2949c;
                        if (!z2) {
                            if (!Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_3D)) {
                                x7.f.j();
                                x7.f.d();
                            } else {
                                TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
                                Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
                                Intrinsics.checkNotNullParameter("closeExtendScreen", "log");
                                if (gc.f6462a <= 4) {
                                    Log.i(gc.f6463b.concat("ConnectSdkProxy"), "closeExtendScreen");
                                }
                                x7.f.f10882a.closeExtendScreen();
                            }
                        } else if (!Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_3D)) {
                            x7.f.b();
                            x7.f.a();
                            ob.b.f8417b.m();
                        } else {
                            x7.f.i();
                        }
                    }
                }
                Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
                Intrinsics.checkNotNullParameter("changePhoneMirrorState device not connect", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("MultiConnectManager"), "changePhoneMirrorState device not connect");
                }
                break;
            default:
                g0 g0Var = g0.f4753a;
                Device device3 = g0.f;
                if (device3 != null) {
                    if (Intrinsics.areEqual(device3.f2950d, device.f2950d)) {
                        gc.c("MultiConnectManager", "start changePhoneMirrorState enable:" + z2);
                        if (z2) {
                            int iC = lb.a.c("multi_transfer_connection_way");
                            gc.c("MultiConnectManager", "changePhoneMirrorState: connectWay:" + iC);
                            if (iC == 1 && Intrinsics.areEqual(device.f2949c, ExifInterface.GPS_MEASUREMENT_3D)) {
                                y yVar = y.f4799a;
                                y.u(false);
                                lb.a.f(0, "multi_transfer_connection_way");
                            } else {
                                TCCPHandshakeSocketServer tCCPHandshakeSocketServer = l2.f4772a;
                                l2.d();
                                x7.f.c();
                                x7.f.a();
                            }
                        } else {
                            x7.f.j();
                            x7.f.d();
                        }
                        g0.a(ConnectedDevice.INSTANCE.getSUBTITLE_MIRROR_CAST(), z2);
                    }
                }
                Intrinsics.checkNotNullParameter("MultiConnectManager", "tag");
                Intrinsics.checkNotNullParameter("changePhoneMirrorState device not connect", "log");
                if (gc.f6462a <= 6) {
                    Log.e(gc.f6463b.concat("MultiConnectManager"), "changePhoneMirrorState device not connect");
                }
                break;
        }
    }
}
