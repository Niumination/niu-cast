package com.transsion.connectx.link.source;

import android.os.Handler;
import android.os.HandlerThread;
import com.transsion.aiotlink.IStreamDataListener;
import com.transsion.aiotlink.ITCCPListener;
import com.transsion.aiotlink.IUibcListener;
import com.transsion.aiotlink.NativeLinkManager;
import com.transsion.connectx.sdk.TCCPSourceApi;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import k4.j;
import k4.m;
import os.l;
import v4.d;
import v4.e;
import v4.g;

/* JADX INFO: loaded from: classes2.dex */
public class SourceNativeLinkManager implements d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f1828o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f1829p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f1830q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f1831r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f1832s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f1833t = 5;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f1834u = "SourceLinkManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<e> f1835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m2.c f1836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f1837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f1838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NativeLinkManager f1839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f1840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HandlerThread f1841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HandlerThread f1842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f1843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Handler f1844j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ITCCPListener f1845k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f1846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f1847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v4.c f1848n;

    /* JADX INFO: renamed from: com.transsion.connectx.link.source.SourceNativeLinkManager$1, reason: invalid class name */
    public class AnonymousClass1 implements ITCCPListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTccpRequest$0(short s10, int i10, String str) {
            SourceNativeLinkManager.this.S(Short.valueOf(s10), i10, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lambda$onTccpResponse$1(short s10, int i10, short s11, String str) {
            SourceNativeLinkManager.this.getClass();
        }

        @Override // com.transsion.aiotlink.ITCCPListener
        public void onClose() {
            m2.c cVar = SourceNativeLinkManager.this.f1836b;
            if (cVar != null) {
                cVar.n(2);
            }
            SourceNativeLinkManager.this.stopTCCPServer();
            m.e(SourceNativeLinkManager.f1834u, "tccp onClose reason for socket disconnet");
        }

        @Override // com.transsion.aiotlink.ITCCPListener
        public void onConnect(int i10) {
            m.e(SourceNativeLinkManager.f1834u, "tccp connected");
            Runnable runnable = SourceNativeLinkManager.this.f1838d;
            if (runnable != null) {
                runnable.run();
            }
            SourceNativeLinkManager.this.f1848n.h();
        }

        @Override // com.transsion.aiotlink.ITCCPListener
        public void onTccpRequest(final short s10, final int i10, final String str) {
            try {
                SourceNativeLinkManager.this.f1843i.post(new Runnable() { // from class: com.transsion.connectx.link.source.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1849a.lambda$onTccpRequest$0(s10, i10, str);
                    }
                });
            } catch (Exception e10) {
                m.d(SourceNativeLinkManager.f1834u, e10);
            }
        }

        @Override // com.transsion.aiotlink.ITCCPListener
        public void onTccpResponse(final short s10, final int i10, final short s11, final String str) {
            try {
                SourceNativeLinkManager.this.f1843i.post(new Runnable() { // from class: com.transsion.connectx.link.source.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1853a.lambda$onTccpResponse$1(s10, i10, s11, str);
                    }
                });
            } catch (Exception e10) {
                m.d(SourceNativeLinkManager.f1834u, e10);
            }
        }
    }

    /* JADX INFO: renamed from: com.transsion.connectx.link.source.SourceNativeLinkManager$2, reason: invalid class name */
    public class AnonymousClass2 implements IUibcListener {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceiveData$0(short s10, short s11, byte[] bArr) {
            SourceNativeLinkManager.this.I(s10, s11, bArr);
        }

        @Override // com.transsion.aiotlink.IUibcListener
        public void onClose() {
            m.e(SourceNativeLinkManager.f1834u, "uibc closed");
            SourceNativeLinkManager.this.f1839e.closeUibcServer();
        }

        @Override // com.transsion.aiotlink.IUibcListener
        public void onConnect(int i10) {
            m.e(SourceNativeLinkManager.f1834u, "uibc connected");
        }

        @Override // com.transsion.aiotlink.IUibcListener
        public void onReceiveData(byte[] bArr, int i10) {
            m.b(SourceNativeLinkManager.f1834u, "on uibc raw data:" + Arrays.toString(bArr));
            final short sL = k4.c.l(Arrays.copyOfRange(bArr, 0, 2));
            final short sL2 = k4.c.l(Arrays.copyOfRange(bArr, 2, 4));
            final byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 8, bArr.length);
            StringBuilder sbA = i0.a.a("onReceiveData port ", sL2, "type:", sL, ",content:");
            sbA.append(Arrays.toString(bArrCopyOfRange));
            m.b(SourceNativeLinkManager.f1834u, sbA.toString());
            try {
                SourceNativeLinkManager.this.f1844j.post(new Runnable() { // from class: com.transsion.connectx.link.source.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1858a.lambda$onReceiveData$0(sL, sL2, bArrCopyOfRange);
                    }
                });
            } catch (Exception e10) {
                m.d(SourceNativeLinkManager.f1834u, e10);
            }
        }
    }

    public static final class InstanceHolder {
        private static final SourceNativeLinkManager INSTANCE = new SourceNativeLinkManager();

        private InstanceHolder() {
        }
    }

    public static void G(SourceNativeLinkManager sourceNativeLinkManager, short s10, int i10, short s11, String str) {
        sourceNativeLinkManager.getClass();
    }

    public static SourceNativeLinkManager H() {
        return InstanceHolder.INSTANCE;
    }

    @b.a({"NewApi"})
    public final void I(int i10, final int i11, final byte[] bArr) {
        o();
        if (i10 == 0) {
            this.f1835a.forEach(new Consumer() { // from class: v4.m
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((e) obj).f(bArr, i11);
                }
            });
            return;
        }
        if (i10 == 1) {
            this.f1835a.forEach(new Consumer() { // from class: v4.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((e) obj).e(bArr, i11);
                }
            });
            return;
        }
        if (i10 == 2) {
            this.f1835a.forEach(new Consumer() { // from class: v4.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((e) obj).b(bArr, i11);
                }
            });
            return;
        }
        if (i10 == 3) {
            this.f1835a.forEach(new Consumer() { // from class: v4.p
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((e) obj).c(bArr, i11);
                }
            });
        } else if (i10 == 4) {
            this.f1835a.forEach(new Consumer() { // from class: v4.q
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((e) obj).a(bArr, i11);
                }
            });
        } else if (i10 == 5) {
            this.f1835a.forEach(new Consumer() { // from class: v4.r
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((e) obj).d(bArr, i11);
                }
            });
        }
    }

    public final /* synthetic */ void P() {
        m2.c cVar = this.f1836b;
        if (cVar != null) {
            cVar.n(1);
        }
        stopTCCPServer();
        m.e(f1834u, "tccp onClose reason for heartbeat");
    }

    public final /* synthetic */ void Q() {
        this.f1839e.sendTccpRequest(g.f16570w0, this.f1840f.g(new v4.b(0)));
    }

    public final /* synthetic */ void R(byte[] bArr) {
        try {
            this.f1839e.sendTccpData(bArr, bArr.length);
        } catch (Exception e10) {
            m.d(f1834u, e10);
        }
    }

    public void S(Short sh2, int i10, String str) {
        m.e(f1834u, "parseRequest:operator:" + sh2 + ",reqId:" + i10 + ",payload:" + str);
        o();
        if (this.f1836b == null) {
            m.c(f1834u, "sourceListener is null");
        } else {
            if (sh2.shortValue() == 2304) {
                return;
            }
            ji.d.a.f8711a.b(sh2, str);
        }
    }

    public final void T(short s10, int i10, short s11, String str) {
    }

    @Override // v4.d
    public void a(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        this.f1839e.sendAudioData(hi.b.f7118g, bArrArray, bArrArray.length);
    }

    @Override // v4.d
    public void b(String str) {
    }

    @Override // v4.d
    public void c(int i10) {
        this.f1839e.closeAudioServer();
    }

    @Override // v4.d
    public void d(int i10, IStreamDataListener iStreamDataListener) {
        m.e(f1834u, " videoLink createVideoServer new method");
        if (this.f1839e.createVideoServer("video" + i10, i10)) {
            this.f1839e.setVideoListener(i10, iStreamDataListener);
        } else {
            m.c(f1834u, "create video link error");
        }
    }

    @Override // v4.d
    public void e(int i10, ByteBuffer byteBuffer) {
        g(i10, byteBuffer.array());
    }

    @Override // v4.d
    public void f(int i10, IStreamDataListener iStreamDataListener) {
        m.e(f1834u, " audioLink createAudioServer new method");
        if (!this.f1839e.createAudioServer(i10)) {
            m.c(f1834u, "create audio error");
        }
        this.f1839e.setAudioListener(iStreamDataListener);
    }

    @Override // v4.d
    public int g(int i10, byte[] bArr) {
        this.f1839e.sendVideoData(i10, bArr, bArr.length);
        return 1;
    }

    @Override // v4.d
    public void h(int i10, Runnable runnable) {
        this.f1838d = runnable;
        this.f1839e.createTccpServer(i10);
        this.f1839e.listenTccpData(this.f1845k);
        Handler handler = this.f1843i;
        if (handler == null) {
            this.f1843i = new Handler(this.f1841g.getLooper());
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.f1844j;
        if (handler2 == null) {
            this.f1844j = new Handler(this.f1842h.getLooper());
        } else {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    @Override // v4.d
    public void i(int i10) {
        this.f1839e.closeVideoServer(i10);
    }

    @Override // v4.d
    public void j(int i10, e eVar) {
        k(eVar);
        if (this.f1839e.createUibcServer(i10)) {
            this.f1839e.setUibcListener(i10, new AnonymousClass2());
        } else {
            m.c(f1834u, "create uibc error");
        }
    }

    @Override // v4.d
    public void k(e eVar) {
        if (eVar == null || this.f1835a.contains(eVar)) {
            return;
        }
        this.f1835a.add(eVar);
    }

    @Override // v4.d
    public void l(@l m2.c cVar) {
        this.f1836b = cVar;
    }

    @Override // v4.d
    public void m(e eVar) {
        if (eVar != null) {
            this.f1835a.remove(eVar);
        }
    }

    @Override // v4.d
    public void n(byte[] bArr) {
        this.f1839e.sendAudioData(hi.b.f7118g, bArr, bArr.length);
    }

    @Override // v4.d
    public void o() {
        this.f1848n.i();
    }

    @Override // v4.d
    public void p(final byte[] bArr) {
        this.f1837c.execute(new Runnable() { // from class: v4.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f16598a.R(bArr);
            }
        });
    }

    @Override // v4.d
    public void stopTCCPServer() {
        this.f1848n.f();
        this.f1839e.closeTccpServer();
        this.f1839e.closeUibcServer();
        this.f1839e.closeAudioServer();
        this.f1839e.closeFileServer();
        this.f1839e.destroyEventThread();
        Handler handler = this.f1843i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f1843i = null;
        }
        Handler handler2 = this.f1844j;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.f1844j = null;
        }
    }

    public SourceNativeLinkManager() {
        this.f1835a = new ConcurrentLinkedQueue<>();
        this.f1837c = Executors.newSingleThreadExecutor();
        this.f1839e = NativeLinkManager.a();
        this.f1840f = j.a.f8962a;
        HandlerThread handlerThread = new HandlerThread("tccp");
        this.f1841g = handlerThread;
        HandlerThread handlerThread2 = new HandlerThread(TCCPSourceApi.KEY_FEATURE_UIBC);
        this.f1842h = handlerThread2;
        this.f1845k = new AnonymousClass1();
        Runnable runnable = new Runnable() { // from class: v4.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f16596a.P();
            }
        };
        this.f1846l = runnable;
        Runnable runnable2 = new Runnable() { // from class: v4.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f16597a.Q();
            }
        };
        this.f1847m = runnable2;
        this.f1848n = new v4.c(1000, 20, runnable2, runnable);
        m.e(f1834u, "SourceNativeLinkManager constructing.....");
        handlerThread.start();
        handlerThread2.start();
    }
}
