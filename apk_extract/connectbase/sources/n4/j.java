package n4;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f11384g = "WifiP2pHandler";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f11385h = "smart_connect_state";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f11386i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f11387j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f11388k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte f11389l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WifiP2pManager f11390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public WifiP2pManager.Channel f11391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i6.a f11392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue<i6.c<Boolean>> f11393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public ContentResolver f11394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ContentObserver f11395f;

    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        public static /* synthetic */ void b(boolean z10, i6.c cVar) {
            cVar.a(Boolean.valueOf(z10));
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            final boolean zP = j.this.p();
            k4.m.e(j.f11384g, "mSmartConnectEnable:" + zP);
            i6.b.b(j.this.f11393d, new i6.b.a() { // from class: n4.i
                @Override // i6.b.a
                public final void a(Object obj) {
                    j.a.b(zP, (i6.c) obj);
                }
            });
        }
    }

    public class b implements WifiP2pManager.ActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WifiP2pConfig f11397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i6.c f11398b;

        public b(WifiP2pConfig wifiP2pConfig, i6.c cVar) {
            this.f11397a = wifiP2pConfig;
            this.f11398b = cVar;
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i10) {
            m2.b.a("onFailure: ", i10, j.f11384g);
            this.f11398b.a(null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            k4.m.e(j.f11384g, "onSuccess: " + this.f11397a.toString());
            j.this.E(this.f11398b);
        }
    }

    public class c implements WifiP2pManager.ActionListener {
        public c(j jVar) {
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i10) {
            m2.b.a("releaseP2P. removeGroup. onFailure. i:", i10, j.f11384g);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            k4.m.e(j.f11384g, "releaseP2P. removeGroup. onSuccess.");
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i6.c f11400a;

        public d(i6.c cVar) {
            this.f11400a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            WifiP2pInfo wifiP2pInfoD = new e(jVar.f11390a, jVar.f11391b, 5000L).d();
            if (wifiP2pInfoD == null) {
                k4.m.c(j.f11384g, "onConnectionInfoAvailable: goInfo is null");
                return;
            }
            InetAddress inetAddress = wifiP2pInfoD.groupOwnerAddress;
            if (inetAddress == null || TextUtils.isEmpty(inetAddress.getHostAddress())) {
                k4.m.c(j.f11384g, "onConnectionInfoAvailable: goInfo ip is null");
                return;
            }
            k4.m.e(j.f11384g, "onConnectionInfoAvailable: " + wifiP2pInfoD.toString());
            this.f11400a.a(wifiP2pInfoD.groupOwnerAddress.getHostAddress());
            j.this.f11392c.e().e(this);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WifiP2pManager f11402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WifiP2pManager.Channel f11403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f11404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f11405d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public WifiP2pInfo f11406e;

        @Nullable
        @WorkerThread
        public final WifiP2pInfo d() {
            final Runnable runnable = new Runnable() { // from class: n4.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11408a.f11405d = true;
                }
            };
            i6.a.b.f7724a.e().b(runnable, this.f11404c);
            this.f11402a.requestConnectionInfo(this.f11403b, new WifiP2pManager.ConnectionInfoListener() { // from class: n4.l
                @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                    this.f11409a.f(runnable, wifiP2pInfo);
                }
            });
            while (!this.f11405d) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e10) {
                    k4.m.d(j.f11384g, e10);
                }
            }
            return this.f11406e;
        }

        public final /* synthetic */ void e() {
            this.f11405d = true;
        }

        public final void f(Runnable runnable, WifiP2pInfo wifiP2pInfo) {
            this.f11405d = true;
            this.f11406e = wifiP2pInfo;
            i6.a.b.f7724a.e().e(runnable);
        }

        public e(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, long j10) {
            this.f11405d = false;
            this.f11402a = wifiP2pManager;
            this.f11403b = channel;
            this.f11404c = j10;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f11407a = new j();
    }

    public static j n() {
        return f.f11407a;
    }

    public static /* synthetic */ void r(int i10, String str, int i11, boolean z10, boolean z11, i6.c cVar) throws Throwable {
        Socket socket;
        OutputStream outputStream;
        k4.m.e(f11384g, "echoIpToGo. start.");
        OutputStream outputStream2 = null;
        outputStream2 = null;
        outputStream2 = null;
        Socket socket2 = null;
        try {
            k4.m.e(f11384g, "echoIpToGo. try. start.");
            socket = new Socket();
            try {
                socket.setSoTimeout(i10 * 1000);
                socket.bind(null);
                k4.m.e(f11384g, "echoIpToGo. try. before connect.");
                socket.connect(new InetSocketAddress(str, i11), 10000);
                k4.m.e(f11384g, "echoIpToGo. try. after connect.");
                outputStream2 = socket.getOutputStream();
                byte[] bArr = {z10 ? (byte) 1 : (byte) 0, z11 ? (byte) 1 : (byte) 0};
                k4.m.e(f11384g, "echoIpToGo. try. before write.");
                outputStream2.write(bArr);
                outputStream2.flush();
                k4.m.e(f11384g, "echoIpToGo. try. after write.");
                Thread.sleep(2000L);
                if (cVar != null) {
                    cVar.a(Boolean.TRUE);
                }
                k4.m.e(f11384g, "echoIpToGo. try. finally.");
                k4.d.c(outputStream2, socket);
            } catch (Exception e10) {
                e = e10;
                outputStream = outputStream2;
                socket2 = socket;
                try {
                    k4.m.e(f11384g, "echoIpToGo. try. catch. err:" + e.getMessage());
                    k4.m.d(f11384g, e);
                    if (cVar != null) {
                        cVar.a(Boolean.FALSE);
                    }
                    k4.m.e(f11384g, "echoIpToGo. try. finally.");
                    k4.d.c(outputStream, socket2);
                } catch (Throwable th2) {
                    th = th2;
                    socket = socket2;
                    outputStream2 = outputStream;
                    k4.m.e(f11384g, "echoIpToGo. try. finally.");
                    k4.d.c(outputStream2, socket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                k4.m.e(f11384g, "echoIpToGo. try. finally.");
                k4.d.c(outputStream2, socket);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            outputStream = null;
        } catch (Throwable th4) {
            th = th4;
            socket = null;
        }
    }

    public void A(final Context context) {
        i6.a.b.f7724a.b(new Runnable() { // from class: n4.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f11380a.t(context);
            }
        });
    }

    public void B(i6.c<Boolean> cVar) {
        if (cVar == null || this.f11393d.contains(cVar)) {
            return;
        }
        this.f11393d.add(cVar);
    }

    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void v(Context context) {
        x(context);
        if (this.f11391b != null) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                k4.m.e(f11384g, "releaseP2P Manifest.permission.ACCESS_FINE_LOCATION don't grant");
            } else {
                this.f11390a.requestGroupInfo(this.f11391b, new WifiP2pManager.GroupInfoListener() { // from class: n4.c
                    @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
                    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
                        this.f11371a.u(wifiP2pGroup);
                    }
                });
            }
        }
    }

    public void D(final Context context) {
        i6.a.b.f7724a.b(new Runnable() { // from class: n4.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f11372a.v(context);
            }
        });
    }

    public final void E(final i6.c<String> cVar) {
        this.f11392c.e().f(new d(cVar), new Runnable() { // from class: n4.h
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(null);
            }
        }, 0, 500L, 40);
    }

    public void F(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName(n4.a.f11350f, n4.a.f11351g);
            intent.setAction(n4.a.f11353i);
            k4.m.e(f11384g, "startWcnScan. action:" + intent.getAction());
            context.startService(intent);
        } catch (Exception e10) {
            k4.m.e(f11384g, "startWcnScan. err:" + e10.getMessage());
            k4.m.d(f11384g, e10);
        }
    }

    public void G(i6.c<Boolean> cVar) {
        if (cVar != null) {
            this.f11393d.remove(cVar);
        }
    }

    @RequiresApi(api = 29)
    @b.a({"MissingPermission"})
    public void l(Context context, n4.b bVar, i6.c<String> cVar) {
        WifiP2pConfig wifiP2pConfigBuild = new WifiP2pConfig.Builder().setNetworkName(bVar.c()).setPassphrase(bVar.a()).build();
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            k4.m.c(f11384g, "you should grant access fine location permission");
            return;
        }
        k4.m.e(f11384g, "connect. method. start.");
        this.f11390a.connect(this.f11391b, wifiP2pConfigBuild, new b(wifiP2pConfigBuild, cVar));
        k4.m.e(f11384g, "connect. method. end.");
    }

    public void m(final String str, final int i10, @Nullable final i6.c<Boolean> cVar, final boolean z10, final boolean z11, final int i11) {
        i6.a.b.f7724a.e().b(new Runnable() { // from class: n4.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                j.r(i11, str, i10, z10, z11, cVar);
            }
        }, 100L);
    }

    public void o(Context context) {
        WifiP2pManager wifiP2pManager = (WifiP2pManager) context.getSystemService(WifiP2pManager.class);
        this.f11390a = wifiP2pManager;
        this.f11391b = wifiP2pManager.initialize(context, context.getMainLooper(), new g());
        ContentResolver contentResolver = context.getContentResolver();
        this.f11394e = contentResolver;
        contentResolver.registerContentObserver(Settings.Global.getUriFor(f11385h), true, this.f11395f);
    }

    public boolean p() {
        return true;
    }

    @WorkerThread
    public boolean q() {
        WifiP2pInfo wifiP2pInfoD = new e(this.f11390a, this.f11391b, 2000L).d();
        return (wifiP2pInfoD == null || wifiP2pInfoD.groupOwnerAddress == null) ? false : true;
    }

    public final /* synthetic */ void t(Context context) {
        z(context);
        try {
            Thread.sleep(2000L);
        } catch (Exception e10) {
            k4.m.d(f11384g, e10);
        }
        F(context);
    }

    public final void u(WifiP2pGroup wifiP2pGroup) {
        if (wifiP2pGroup != null) {
            this.f11390a.removeGroup(this.f11391b, new c());
        }
        k4.m.e(f11384g, "releaseP2P wifiP2pGroup == null");
    }

    public void x(Context context) {
        try {
            k4.m.e(f11384g, "releaseP2P. notifyWcnFileSendFinish.");
            Intent intent = new Intent();
            intent.setClassName(n4.a.f11350f, n4.a.f11351g);
            intent.setAction(n4.a.f11357m);
            context.startService(intent);
        } catch (Exception e10) {
            k4.m.e(f11384g, "releaseP2P. notifyWcnFileSendFinish. err:" + e10.getMessage());
            k4.m.d(f11384g, e10);
        }
        try {
            Thread.sleep(1000L);
        } catch (Exception e11) {
            k4.m.d(f11384g, e11);
        }
        try {
            k4.m.e(f11384g, "releaseP2P. notifyWcnTransferComplete.");
            Intent intent2 = new Intent();
            intent2.setClassName(n4.a.f11350f, n4.a.f11351g);
            intent2.setAction(n4.a.f11355k);
            context.startService(intent2);
        } catch (Exception e12) {
            k4.m.e(f11384g, "releaseP2P. notifyWcnTransferComplete. err:" + e12.getMessage());
            k4.m.d(f11384g, e12);
        }
    }

    public void y() {
        ContentResolver contentResolver = this.f11394e;
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this.f11395f);
        }
    }

    public void z(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName(n4.a.f11350f, n4.a.f11352h);
            intent.setAction(n4.a.f11359o);
            intent.putExtra("state", 1);
            k4.m.e(f11384g, "openSmartConnect. action:" + intent.getAction());
            context.startService(intent);
        } catch (Exception e10) {
            k4.m.e(f11384g, "openSmartConnect. err:" + e10.getMessage());
            k4.m.d(f11384g, e10);
        }
    }

    public j() {
        this.f11392c = i6.a.b.f7724a;
        this.f11393d = new ConcurrentLinkedQueue<>();
        this.f11395f = new a(null);
    }
}
