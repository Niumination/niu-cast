package w4;

import android.content.Intent;
import android.os.Binder;
import android.text.TextUtils;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.mirror.source.service.SourceService;
import com.transsion.connectx.sdk.BackupAuthListener;
import com.transsion.connectx.sdk.BackupFileListener;
import com.transsion.connectx.sdk.DeviceInfo;
import com.transsion.connectx.sdk.FileInfoSyncRequest;
import com.transsion.connectx.sdk.ICapabilityListener;
import com.transsion.connectx.sdk.ITCCPSourceApi;
import com.transsion.connectx.sdk.ReceiveFileTransferListener;
import com.transsion.connectx.sdk.SendFileTransferListener;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.connectx.sdk.VideoConfig;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n0 extends ITCCPSourceApi.Stub {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f18078c = "SourceApiController";

    public static Object Z() {
        m5.m0.a.f10496a.f(0);
        return null;
    }

    public static Object a0(VideoConfig videoConfig, String str) {
        l1.h.f18073a.T(a6.c.b(videoConfig), str);
        return null;
    }

    public static Object b0() {
        l1.h.f18073a.W(c.q());
        return null;
    }

    public static Boolean c0() {
        if (a6.p.b()) {
            k4.m.b(f18078c, "PhoneDevice");
            l1.h.f18073a.Z();
        } else {
            k4.m.b(f18078c, "OtherDevice");
            p5.m0.f12861a.U();
        }
        return Boolean.TRUE;
    }

    public static Object d0() {
        if (a6.p.b()) {
            k4.m.b(f18078c, "PhoneDevice");
            l1.h.f18073a.a0(c.p(SourceApplication.b(), "phone_mirror_pad"));
            return null;
        }
        k4.m.b(f18078c, "OtherDevice");
        p5.m0.f12861a.V();
        return null;
    }

    public static Boolean e0() {
        if (a6.p.b()) {
            k4.m.b(f18078c, "PhoneDevice");
            l1.h.f18073a.L1();
        } else {
            k4.m.b(f18078c, "OtherDevice");
            p5.m0.f12861a.v();
        }
        return Boolean.TRUE;
    }

    public static Object f0(List list, String str, boolean z10, String str2, String str3) {
        m5.m0.a.f10496a.h(list, str, z10, str2, str3);
        return null;
    }

    public static Object g0() {
        l1.h.f18073a.M1();
        return null;
    }

    public static Object h0(FileInfoSyncRequest fileInfoSyncRequest) {
        l1.h.f18073a.H1(fileInfoSyncRequest);
        return null;
    }

    public final <T> T X(i6.d<T> dVar) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return dVar.result();
        } catch (Exception e10) {
            k4.m.d(f18078c, e10);
            return null;
        } finally {
            Binder.restoreCallingWorkSource(jClearCallingIdentity);
        }
    }

    public final void Y() {
        SourceApplication.b().enforceCallingOrSelfPermission("connectx.permission.ACCESS_API", "you have no permission");
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void cancelBackup(long j10) {
        k4.m.e(f18078c, "cancelBackup");
        b4.a.f725a.j();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void cancelFileTransfer() {
        Y();
        k4.m.e(f18078c, "cancelFileTransfer");
        X(new f0());
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castActivity(String str, int i10) {
        Y();
        if (TextUtils.isEmpty(str)) {
            k4.m.c(f18078c, "castActivity:activity is null");
            return false;
        }
        k4.m.e(f18078c, "castActivity:activity:" + str + ",display:" + i10);
        return true;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castActivityByImplicitStart(Intent intent, VideoConfig videoConfig) {
        Y();
        if (intent == null) {
            k4.m.c(f18078c, "castActivityByImplicitStart:intent is null");
            return false;
        }
        if (videoConfig == null) {
            k4.m.c(f18078c, "castActivityByImplicitStart:config is null");
            return false;
        }
        k4.m.e(f18078c, "castActivityByImplicitStart:" + intent.toString() + ks.g.f9491d + videoConfig.toString());
        l1.h.f18073a.U(a6.c.b(videoConfig), intent);
        return true;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castActivityInNewDisplay(final String str, final VideoConfig videoConfig) {
        Y();
        if (TextUtils.isEmpty(str)) {
            k4.m.c(f18078c, "castActivityInNewDisplay:activity is null");
            return false;
        }
        if (videoConfig == null) {
            k4.m.c(f18078c, "castActivityInNewDisplay:config is null");
            return false;
        }
        k4.m.e(f18078c, "castActivityInNewDisplay:activity:" + str + ",config:" + videoConfig);
        X(new i6.d() { // from class: w4.g0
            @Override // i6.d
            public final Object result() {
                return n0.a0(videoConfig, str);
            }
        });
        return true;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castAudio() {
        Y();
        k4.m.e(f18078c, "castAudio");
        X(new i0());
        return false;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castExtendScreen() {
        Y();
        k4.m.e(f18078c, "castExtendScreen");
        X(new h0());
        return false;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean castMainScreen() {
        Y();
        k4.m.e(f18078c, "castMainScreen");
        X(new m0());
        return false;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public List<String> checkServicePermission() {
        Y();
        return a6.h.a.f70a.a(SourceApplication.b());
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void closeExtendScreen() {
        Y();
        k4.m.e(f18078c, "closeExtendScreen");
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean closeMainScreen() {
        Y();
        k4.m.e(f18078c, "closeMainScreen");
        X(new l0());
        return false;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void confirmReceiveFile(final List<String> list, final String str, final boolean z10, final String str2, final String str3) {
        Y();
        X(new i6.d() { // from class: w4.k0
            @Override // i6.d
            public final Object result() {
                return n0.f0(list, str, z10, str2, str3);
            }
        });
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void connectTccpServer(String str, int i10) {
        k4.m.e(f18078c, "connectTccpServer: ip:" + str + ";port:" + i10);
        p5.m0.f12861a.x(str, i10);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void disconnectTccpServer() {
        Y();
        k4.m.e(f18078c, "disconnectTccpServer");
        p5.m0.f12861a.I();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void enableFeature(String str, boolean z10) {
        Y();
        k4.m.e(f18078c, "enableFeature :" + str + ks.g.f9491d + z10);
        enableFeatures(Collections.singletonList(str), z10);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void enableFeatures(List<String> list, boolean z10) {
        Y();
        if (list == null || list.isEmpty()) {
            k4.m.c(f18078c, "enableFeatures:param list empty");
            return;
        }
        l1.h.f18073a.m0(list, z10);
        k4.m.e(f18078c, "enableFeatures: " + list.toString() + ks.g.f9491d + z10);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void executeAction(String str, String str2) {
        Y();
        a5.a.f47a.e(str, str2);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public int getTCCPStatus() {
        Y();
        k4.m.e(f18078c, "getTCCPStatus");
        l1 l1Var = l1.h.f18073a;
        if (l1Var.T0()) {
            return 5;
        }
        if (l1Var.S0()) {
            return 4;
        }
        return l1Var.v0();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean isMotionControlByPc(long j10) {
        Y();
        return l1.h.f18073a.V0(j10);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void recordPeerDeviceMac(String str) {
        k4.m.e(SourceService.f2175x, "Received MAC: " + str);
        o1.a.f18113a.W(str);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerAudioListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "registerAudioListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.F0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerBackupAuthListener(BackupAuthListener backupAuthListener) {
        Y();
        if (backupAuthListener == null) {
            k4.m.c(f18078c, "registerBackupAuthListener:listener is null");
        } else {
            k4.m.e(f18078c, "registerBackupAuthListener");
            c0.b.f17991a.D0(backupAuthListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerBackupFileListener(BackupFileListener backupFileListener) {
        Y();
        if (backupFileListener == null) {
            k4.m.c(f18078c, "registerBackupFileListener:listener is null");
        } else {
            k4.m.e(f18078c, "registerBackupFileListener");
            c0.b.f17991a.E0(backupFileListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerCapabilityLinstner(ICapabilityListener iCapabilityListener) {
        Y();
        if (iCapabilityListener == null) {
            k4.m.c(f18078c, "registerCapabilityLinstner:listener is null");
        } else {
            k4.m.e(f18078c, "registerCapabilityLinstner");
            a5.a.f47a.f(iCapabilityListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerCastExtendListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "registerCastExtendListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.G0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerExtendScreenListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "registerExtendScreenListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.I0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerReceiveFileListener(String str, ReceiveFileTransferListener receiveFileTransferListener) {
        Y();
        if (receiveFileTransferListener == null) {
            k4.m.c(f18078c, "registerReceiveFileListener:listener is null");
        } else {
            k4.m.e(f18078c, "registerReceiveFileListener");
            c0.b.f17991a.J0(str, receiveFileTransferListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerSendFileListener(String str, SendFileTransferListener sendFileTransferListener) {
        Y();
        if (sendFileTransferListener == null) {
            k4.m.c(f18078c, "registerSendFileListener:listener is null");
        } else {
            k4.m.e(f18078c, "registerSendFileListener");
            c0.b.f17991a.K0(str, sendFileTransferListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerTCCPListener(String str, TCCPListener tCCPListener) {
        Y();
        if (tCCPListener == null) {
            k4.m.c(f18078c, "registerTCCPListener:listener is null");
            return;
        }
        k4.m.e(f18078c, "registerTCCPListener：packageName=" + str);
        c0.b.f17991a.L0(str, tCCPListener);
        if (str.equals(a6.f.a())) {
            ((SourceApplication) SourceApplication.b()).a();
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void registerVideoListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "registerVideoListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.H0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void responseAuth(boolean z10, boolean z11) {
        k4.m.e(f18078c, "responseAuth isAuth: " + z10 + "isTrust: " + z11);
        b4.a.f725a.p(z10, z11);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void sendFile(List<String> list, int i10, String str, String str2) {
        Y();
        m5.m0.a.f10496a.y(list, i10, str, str2);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void setConnectDeviceInfo(DeviceInfo deviceInfo) {
        Y();
        k4.m.e(f18078c, "setConnectDeviceInfo:" + deviceInfo);
        if (deviceInfo != null) {
            o1.a.f18113a.V(deviceInfo);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void startExtendScreen() {
        Y();
        k4.m.e(f18078c, "startExtendScreen");
        l1.h.f18073a.w1();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public int startTCCPServer(int i10) {
        Y();
        k4.m.e(f18078c, "request startCastServer,type: " + i10);
        return l1.h.f18073a.J1();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void stopAllCastAudio() {
        Y();
        k4.m.e(f18078c, "stopAllCastAudio");
        l1.h.f18073a.K1();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void stopAllCastVideo() {
        Y();
        k4.m.e(f18078c, "stopAllCastVideo");
        l1.h.f18073a.L1();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void stopTCCPServer() {
        Y();
        k4.m.e(f18078c, "request stopCastServer");
        X(new e0());
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void syncClipText(String str) {
        Y();
        k4.m.e(f18078c, "syncClipText：" + str);
        if (str == null) {
            return;
        }
        l1.h.f18073a.n1(str);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public boolean syncFileInfoRequest(final FileInfoSyncRequest fileInfoSyncRequest) {
        Y();
        k4.m.b(f18078c, "FileTransfer syncFileInfoRequest into");
        X(new i6.d() { // from class: w4.j0
            @Override // i6.d
            public final Object result() {
                return n0.h0(fileInfoSyncRequest);
            }
        });
        return false;
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterAudioListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "unregisterAudioListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.O0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterBackupAuthListener(BackupAuthListener backupAuthListener) {
        Y();
        if (backupAuthListener == null) {
            k4.m.c(f18078c, "unregisterBackupAuthListener:listener is null");
        } else {
            k4.m.e(f18078c, "unregisterBackupAuthListener");
            c0.b.f17991a.M0(backupAuthListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterBackupFileListener(BackupFileListener backupFileListener) {
        Y();
        if (backupFileListener == null) {
            k4.m.c(f18078c, "unregisterBackupFileListener:listener is null");
        } else {
            k4.m.e(f18078c, "unregisterBackupFileListener");
            c0.b.f17991a.N0(backupFileListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterCastExtendListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "unregisterCastExtendListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.P0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterExtendScreenListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "unregisterExtendScreenListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.R0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterReceiveFileListener(ReceiveFileTransferListener receiveFileTransferListener) {
        Y();
        if (receiveFileTransferListener == null) {
            k4.m.c(f18078c, "unregisterReceiveFileListener:listener is null");
        } else {
            k4.m.e(f18078c, "unregisterReceiveFileListener");
            c0.b.f17991a.S0(receiveFileTransferListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterSendFileListener(SendFileTransferListener sendFileTransferListener) {
        Y();
        if (sendFileTransferListener == null) {
            k4.m.c(f18078c, "unregisterSendFileListener:listener is null");
        } else {
            k4.m.e(f18078c, "unregisterSendFileListener");
            c0.b.f17991a.T0(sendFileTransferListener);
        }
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterTCCPListener(TCCPListener tCCPListener) {
        Y();
        if (tCCPListener == null) {
            k4.m.c(f18078c, "unregisterTCCPListener:listener is null");
            return;
        }
        k4.m.e(f18078c, "unregisterTCCPListener");
        c0.b.f17991a.U0(tCCPListener);
        ((SourceApplication) SourceApplication.b()).c();
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void unregisterVideoListener(TCCPListener tCCPListener) {
        Y();
        k4.m.e(f18078c, "unregisterVideoListener:listener：" + tCCPListener);
        if (tCCPListener == null) {
            return;
        }
        c0.b.f17991a.Q0(tCCPListener);
    }

    @Override // com.transsion.connectx.sdk.ITCCPSourceApi
    public void updateMirrorWindowPoint(int i10, int i11) {
        p5.m0.f12861a.E0(i10, i11);
    }
}
