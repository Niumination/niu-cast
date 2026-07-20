package w4;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.connectx.sdk.BackupAuthListener;
import com.transsion.connectx.sdk.BackupFileListener;
import com.transsion.connectx.sdk.ReceiveFileTransferListener;
import com.transsion.connectx.sdk.SendFileTransferListener;
import com.transsion.connectx.sdk.TCCPListener;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f17977m = "RemoteCallbackManager";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f17978n = "noPackageName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteCallbackList<TCCPListener> f17979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RemoteCallbackList<ReceiveFileTransferListener> f17980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, TCCPListener> f17981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, ReceiveFileTransferListener> f17982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, SendFileTransferListener> f17983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RemoteCallbackList<SendFileTransferListener> f17984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RemoteCallbackList<TCCPListener> f17985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RemoteCallbackList<TCCPListener> f17986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RemoteCallbackList<TCCPListener> f17987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RemoteCallbackList<TCCPListener> f17988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RemoteCallbackList<BackupFileListener> f17989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RemoteCallbackList<BackupAuthListener> f17990l;

    public interface a<T extends IInterface> {
        void a(T t10) throws RemoteException;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0 f17991a = new c0();
    }

    public static c0 D() {
        return b.f17991a;
    }

    public static /* synthetic */ void N(String str, long j10, String str2, String str3, int i10, ReceiveFileTransferListener receiveFileTransferListener) throws RemoteException {
        receiveFileTransferListener.onConfirmReceiveFile(Collections.singletonList(str), j10, str2, str3, i10);
    }

    public static /* synthetic */ void O(String str, String str2, int i10, SendFileTransferListener sendFileTransferListener) throws RemoteException {
        sendFileTransferListener.onConfirmRequestFile(Collections.singletonList(str), str2, i10);
    }

    public final void A(String str, String str2, @NonNull a<SendFileTransferListener> aVar) {
        RemoteCallbackList<SendFileTransferListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17984f.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (TextUtils.isEmpty(str2) || str2.equals(f17978n) || this.f17984f.getRegisteredCallbackCount() <= 0) {
            return;
        }
        SendFileTransferListener sendFileTransferListener = this.f17983e.get(str2);
        if (sendFileTransferListener == null) {
            k4.m.c(f17977m, str + ":handle app " + str2 + " not in list");
            return;
        }
        synchronized (this.f17984f) {
            try {
                try {
                    int iBeginBroadcast = this.f17984f.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        SendFileTransferListener sendFileTransferListener2 = (SendFileTransferListener) this.f17984f.getBroadcastItem(i10);
                        if (sendFileTransferListener2 != null && sendFileTransferListener2 == sendFileTransferListener) {
                            aVar.a(sendFileTransferListener2);
                        }
                    }
                    remoteCallbackList = this.f17984f;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17984f;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17984f.finishBroadcast();
                throw th2;
            }
        }
    }

    public void A0() {
        C("onTccpEnd", new a0());
    }

    public final void B(String str, @NonNull a<SendFileTransferListener> aVar) {
        RemoteCallbackList<SendFileTransferListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17984f.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17984f.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17984f) {
            try {
                try {
                    int iBeginBroadcast = this.f17984f.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        aVar.a((SendFileTransferListener) this.f17984f.getBroadcastItem(i10));
                    }
                    remoteCallbackList = this.f17984f;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17984f;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17984f.finishBroadcast();
                throw th2;
            }
        }
    }

    public void B0(final int i10) {
        C("onCastError", new a() { // from class: w4.u
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((TCCPListener) iInterface).onError(i10);
            }
        });
    }

    public final void C(String str, @NonNull a<TCCPListener> aVar) {
        RemoteCallbackList<TCCPListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17979a.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17979a.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17979a) {
            try {
                try {
                    int iBeginBroadcast = this.f17979a.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        if (this.f17979a.getBroadcastItem(i10) != null) {
                            Log.i(f17977m, str + ":" + this.f17979a.getBroadcastItem(i10));
                            aVar.a((TCCPListener) this.f17979a.getBroadcastItem(i10));
                        }
                    }
                    remoteCallbackList = this.f17979a;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17979a;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17979a.finishBroadcast();
                throw th2;
            }
        }
    }

    public void C0() {
        C("onTccpStart", new v());
    }

    public void D0(BackupAuthListener backupAuthListener) {
        k4.m.b(f17977m, "registerBackupAuthListener");
        if (backupAuthListener == null) {
            return;
        }
        this.f17990l.register(backupAuthListener);
    }

    @Nullable
    public final <T> String E(T t10, ConcurrentHashMap<String, T> concurrentHashMap) {
        for (String str : concurrentHashMap.keySet()) {
            if (concurrentHashMap.get(str) == t10) {
                return str;
            }
        }
        return null;
    }

    public void E0(BackupFileListener backupFileListener) {
        k4.m.b(f17977m, "registerBackupFileListener");
        if (backupFileListener == null) {
            return;
        }
        this.f17989k.register(backupFileListener);
    }

    public boolean F(String str) {
        return (TextUtils.isEmpty(str) || this.f17982d.get(str) == null) ? false : true;
    }

    public void F0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "registerCastAudioListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17988j.register(tCCPListener);
    }

    public boolean G(String str) {
        return (TextUtils.isEmpty(str) || this.f17981c.get(str) == null) ? false : true;
    }

    public void G0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "registerCastExtendListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17987i.register(tCCPListener);
    }

    public void H0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "registerCastVideoListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17986h.register(tCCPListener);
    }

    public void I0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "registerExtendScreenListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17985g.register(tCCPListener);
    }

    public void J0(String str, ReceiveFileTransferListener receiveFileTransferListener) {
        k4.m.b(f17977m, "registerReceiveFileListener: ");
        if (receiveFileTransferListener == null) {
            k4.m.b(f17977m, "FileTransferListener is null");
        } else {
            this.f17980b.register(receiveFileTransferListener);
            this.f17982d.put(str, receiveFileTransferListener);
        }
    }

    public void K0(String str, SendFileTransferListener sendFileTransferListener) {
        k4.m.b(f17977m, "registerSendFileListener: ");
        if (sendFileTransferListener == null) {
            k4.m.b(f17977m, "FileTransferListener is null");
        } else {
            this.f17984f.register(sendFileTransferListener);
            this.f17983e.put(str, sendFileTransferListener);
        }
    }

    public void L0(String str, TCCPListener tCCPListener) {
        k4.m.b(f17977m, "registerTCCPListener: ");
        if (tCCPListener == null) {
            k4.m.b(f17977m, "listener is null");
        } else {
            this.f17979a.register(tCCPListener);
            this.f17981c.put(str, tCCPListener);
        }
    }

    public void M0(BackupAuthListener backupAuthListener) {
        k4.m.b(f17977m, "unregisterBackupAuthListener");
        if (backupAuthListener == null) {
            return;
        }
        this.f17990l.unregister(backupAuthListener);
    }

    public void N0(BackupFileListener backupFileListener) {
        k4.m.b(f17977m, "unregisterBackupFileListener");
        if (backupFileListener == null) {
            return;
        }
        this.f17989k.unregister(backupFileListener);
    }

    public void O0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "unregisterCastAudioListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17988j.unregister(tCCPListener);
    }

    public void P0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "unregisterCastExtendListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17987i.unregister(tCCPListener);
    }

    public void Q0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "unregisterCastVideoListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17986h.unregister(tCCPListener);
    }

    public void R0(TCCPListener tCCPListener) {
        k4.m.b(f17977m, "unregisterExtendScreenListener");
        if (tCCPListener == null) {
            return;
        }
        this.f17985g.unregister(tCCPListener);
    }

    public void S0(ReceiveFileTransferListener receiveFileTransferListener) {
        if (receiveFileTransferListener == null) {
            return;
        }
        String strE = E(receiveFileTransferListener, this.f17982d);
        if (strE != null) {
            this.f17982d.remove(strE);
        }
        this.f17980b.unregister(receiveFileTransferListener);
    }

    public void T0(SendFileTransferListener sendFileTransferListener) {
        if (sendFileTransferListener == null) {
            return;
        }
        String strE = E(sendFileTransferListener, this.f17983e);
        if (strE != null) {
            this.f17983e.remove(strE);
        }
        this.f17984f.unregister(sendFileTransferListener);
    }

    public void U0(TCCPListener tCCPListener) {
        if (tCCPListener == null) {
            return;
        }
        String strE = E(tCCPListener, this.f17981c);
        if (strE != null) {
            this.f17981c.remove(strE);
        }
        this.f17979a.unregister(tCCPListener);
    }

    public void Z() {
        u("onAllAudioClosed", new a0());
    }

    public void a0() {
        w("onAllVideoClosed", new a0());
    }

    public void b0(final String str, final String str2) {
        s("onRequest", new a() { // from class: w4.n
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((BackupAuthListener) iInterface).onRequest(str, str2);
            }
        });
    }

    public void c0(final long j10, final boolean z10) {
        t("onCancel", new a() { // from class: w4.m
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((BackupFileListener) iInterface).onCancel(j10, z10);
            }
        });
    }

    public void d0(final long j10, final int i10) {
        t("onFail", new a() { // from class: w4.h
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((BackupFileListener) iInterface).onFail(j10, i10);
            }
        });
    }

    public void e0(final long j10) {
        t("onFinish", new a() { // from class: w4.z
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((BackupFileListener) iInterface).onFinish(j10);
            }
        });
    }

    public void f0(final long j10, final double d10, final int i10, final int i11) {
        t("onProgress", new a() { // from class: w4.b0
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((BackupFileListener) iInterface).onProgress(j10, d10, i10, i11);
            }
        });
    }

    public void g0(final long j10, final int i10) {
        t("onStart", new a() { // from class: w4.i
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((BackupFileListener) iInterface).onStart(j10, i10);
            }
        });
    }

    public void h0() {
        v("onCastExtendClosed", new a0());
    }

    public void i0() {
        u("onCastingAudio", new v());
    }

    public void j0() {
        v("onCastingExtend", new v());
    }

    public void k0() {
        w("onCastingVideo", new v());
    }

    public void l0(String str, final long j10, final String str2, final String str3, final String str4, final int i10) {
        if (str2.isEmpty()) {
            k4.m.c(f17977m, "onConfirmReceiveFile: file is empty");
        } else {
            y("onConfirmReceiveFile", str, new a() { // from class: w4.q
                @Override // w4.c0.a
                public final void a(IInterface iInterface) throws RemoteException {
                    c0.N(str2, j10, str3, str4, i10, (ReceiveFileTransferListener) iInterface);
                }
            });
        }
    }

    public void m0(String str, final String str2, final String str3, final int i10) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        A("onConfirmRequestFile", str, new a() { // from class: w4.r
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                c0.O(str2, str3, i10, (SendFileTransferListener) iInterface);
            }
        });
    }

    public void n0() {
        x("onExtendScreenClosed", new a0());
    }

    public void o0(String str, final int i10, final String str2, final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        A("onFileTaskConfirmResult", str, new a() { // from class: w4.p
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((SendFileTransferListener) iInterface).onFileTaskConfirmResult(i10, str2, list);
            }
        });
    }

    public void p0(final int i10) {
        z("onReceiveCancel", new a() { // from class: w4.l
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((ReceiveFileTransferListener) iInterface).onCancelTransfer(i10);
            }
        });
    }

    public void q0(String str) {
        y("onTransferFinish", str, new j());
    }

    public void r0(final String str, final int i10, String str2, final String str3, final int i11) {
        y("onProgress", str2, new a() { // from class: w4.k
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((ReceiveFileTransferListener) iInterface).onProgress(str, i10, str3, i11);
            }
        });
    }

    public final void s(String str, @NonNull a<BackupAuthListener> aVar) {
        RemoteCallbackList<BackupAuthListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17990l.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17990l.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17990l) {
            try {
                try {
                    int iBeginBroadcast = this.f17990l.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        if (this.f17990l.getBroadcastItem(i10) != null) {
                            Log.i(f17977m, str + ":" + this.f17990l.getBroadcastItem(i10));
                            aVar.a((BackupAuthListener) this.f17990l.getBroadcastItem(i10));
                        }
                    }
                    remoteCallbackList = this.f17990l;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17990l;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17990l.finishBroadcast();
                throw th2;
            }
        }
    }

    public void s0(final String str, String str2, final String str3, final int i10) {
        y("onSuccess", str2, new a() { // from class: w4.t
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((ReceiveFileTransferListener) iInterface).onSuccess(str, str3, i10);
            }
        });
    }

    public final void t(String str, @NonNull a<BackupFileListener> aVar) {
        RemoteCallbackList<BackupFileListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17989k.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17989k.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17989k) {
            try {
                try {
                    int iBeginBroadcast = this.f17989k.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        if (this.f17989k.getBroadcastItem(i10) != null) {
                            Log.i(f17977m, str + ":" + this.f17989k.getBroadcastItem(i10));
                            aVar.a((BackupFileListener) this.f17989k.getBroadcastItem(i10));
                        }
                    }
                    remoteCallbackList = this.f17989k;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17989k;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17989k.finishBroadcast();
                throw th2;
            }
        }
    }

    public void t0(String str, final String str2, final int i10, final String str3, final int i11) {
        y("onFailed", str, new a() { // from class: w4.o
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((ReceiveFileTransferListener) iInterface).onFailed(str2, i10, str3, i11);
            }
        });
    }

    public final void u(String str, @NonNull a<TCCPListener> aVar) {
        RemoteCallbackList<TCCPListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17988j.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17988j.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17988j) {
            try {
                try {
                    int iBeginBroadcast = this.f17988j.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        if (this.f17988j.getBroadcastItem(i10) != null) {
                            Log.i(f17977m, str + ":" + this.f17988j.getBroadcastItem(i10));
                            aVar.a((TCCPListener) this.f17988j.getBroadcastItem(i10));
                        }
                    }
                    remoteCallbackList = this.f17988j;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17988j;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17988j.finishBroadcast();
                throw th2;
            }
        }
    }

    public void u0() {
        x("onScreenExtending", new v());
    }

    public final void v(String str, @NonNull a<TCCPListener> aVar) {
        RemoteCallbackList<TCCPListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17987i.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17987i.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17987i) {
            try {
                try {
                    int iBeginBroadcast = this.f17987i.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        if (this.f17987i.getBroadcastItem(i10) != null) {
                            Log.i(f17977m, str + ":" + this.f17987i.getBroadcastItem(i10));
                            aVar.a((TCCPListener) this.f17987i.getBroadcastItem(i10));
                        }
                    }
                    remoteCallbackList = this.f17987i;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17987i;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17987i.finishBroadcast();
                throw th2;
            }
        }
    }

    public void v0(final int i10) {
        B("onSendCancel", new a() { // from class: w4.w
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((SendFileTransferListener) iInterface).onCancelTransfer(i10);
            }
        });
    }

    public final void w(String str, @NonNull a<TCCPListener> aVar) {
        RemoteCallbackList<TCCPListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17986h.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17986h.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17986h) {
            try {
                try {
                    int iBeginBroadcast = this.f17986h.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        if (this.f17986h.getBroadcastItem(i10) != null) {
                            Log.i(f17977m, str + ":" + this.f17986h.getBroadcastItem(i10));
                            aVar.a((TCCPListener) this.f17986h.getBroadcastItem(i10));
                        }
                    }
                    remoteCallbackList = this.f17986h;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17986h;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17986h.finishBroadcast();
                throw th2;
            }
        }
    }

    public void w0(String str) {
        A("onTransferFinish", str, new y());
    }

    public final void x(String str, @NonNull a<TCCPListener> aVar) {
        RemoteCallbackList<TCCPListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17985g.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17985g.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17985g) {
            try {
                try {
                    int iBeginBroadcast = this.f17985g.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        if (this.f17985g.getBroadcastItem(i10) != null) {
                            Log.i(f17977m, str + ":" + this.f17985g.getBroadcastItem(i10));
                            aVar.a((TCCPListener) this.f17985g.getBroadcastItem(i10));
                        }
                    }
                    remoteCallbackList = this.f17985g;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17985g;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17985g.finishBroadcast();
                throw th2;
            }
        }
    }

    public void x0(final String str, final int i10, String str2, final String str3, final int i11) {
        A("onProgress", str2, new a() { // from class: w4.s
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((SendFileTransferListener) iInterface).onProgress(str, i10, str3, i11);
            }
        });
    }

    public final void y(String str, String str2, @NonNull a<ReceiveFileTransferListener> aVar) {
        RemoteCallbackList<ReceiveFileTransferListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17980b.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (TextUtils.isEmpty(str2) || str2.equals(f17978n) || this.f17980b.getRegisteredCallbackCount() <= 0) {
            return;
        }
        ReceiveFileTransferListener receiveFileTransferListener = this.f17982d.get(str2);
        if (receiveFileTransferListener == null) {
            k4.m.c(f17977m, str + ":handle app " + str2 + " not in list");
            return;
        }
        synchronized (this.f17980b) {
            try {
                try {
                    int iBeginBroadcast = this.f17980b.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        ReceiveFileTransferListener receiveFileTransferListener2 = (ReceiveFileTransferListener) this.f17980b.getBroadcastItem(i10);
                        if (receiveFileTransferListener2 != null && receiveFileTransferListener2 == receiveFileTransferListener) {
                            aVar.a(receiveFileTransferListener2);
                        }
                    }
                    remoteCallbackList = this.f17980b;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17980b;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17980b.finishBroadcast();
                throw th2;
            }
        }
    }

    public void y0(final String str, String str2, final String str3, final int i10) {
        A("onSuccess", str2, new a() { // from class: w4.x
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((SendFileTransferListener) iInterface).onSuccess(str, str3, i10);
            }
        });
    }

    public final void z(String str, @NonNull a<ReceiveFileTransferListener> aVar) {
        RemoteCallbackList<ReceiveFileTransferListener> remoteCallbackList;
        StringBuilder sbA = k.c.a(str, ":");
        sbA.append(System.currentTimeMillis());
        sbA.append(",count:");
        sbA.append(this.f17980b.getRegisteredCallbackCount());
        k4.m.b(f17977m, sbA.toString());
        if (this.f17980b.getRegisteredCallbackCount() <= 0) {
            return;
        }
        synchronized (this.f17980b) {
            try {
                try {
                    int iBeginBroadcast = this.f17980b.beginBroadcast();
                    for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                        aVar.a((ReceiveFileTransferListener) this.f17980b.getBroadcastItem(i10));
                    }
                    remoteCallbackList = this.f17980b;
                } catch (RemoteException e10) {
                    k4.m.d(f17977m, e10);
                    remoteCallbackList = this.f17980b;
                }
                remoteCallbackList.finishBroadcast();
            } catch (Throwable th2) {
                this.f17980b.finishBroadcast();
                throw th2;
            }
        }
    }

    public void z0(String str, final String str2, final int i10, final String str3, final int i11) {
        A("onFailed", str, new a() { // from class: w4.g
            @Override // w4.c0.a
            public final void a(IInterface iInterface) throws RemoteException {
                ((SendFileTransferListener) iInterface).onFailed(str2, i10, str3, i11);
            }
        });
    }

    public c0() {
        this.f17979a = new RemoteCallbackList<>();
        this.f17980b = new RemoteCallbackList<>();
        this.f17981c = new ConcurrentHashMap<>();
        this.f17982d = new ConcurrentHashMap<>();
        this.f17983e = new ConcurrentHashMap<>();
        this.f17984f = new RemoteCallbackList<>();
        this.f17985g = new RemoteCallbackList<>();
        this.f17986h = new RemoteCallbackList<>();
        this.f17987i = new RemoteCallbackList<>();
        this.f17988j = new RemoteCallbackList<>();
        this.f17989k = new RemoteCallbackList<>();
        this.f17990l = new RemoteCallbackList<>();
    }
}
