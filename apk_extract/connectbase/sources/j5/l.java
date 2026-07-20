package j5;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Display;
import android.view.Surface;
import com.transsion.connectx.mirror.source.SourceApplication;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8574g = 100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8575h = 128;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f8576i = 256;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f8577j = 1024;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8578k = 512;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8579l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8580m = "MirrorDisplayManager";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8581n = 265;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8582o = 34;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public b f8583a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f8585c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f8587e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f8584b = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m4.c f8586d = m4.a.C0275a.f10375a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DisplayManager.DisplayListener f8588f = new a();

    public class a implements DisplayManager.DisplayListener {
        public a() {
        }

        public static /* synthetic */ boolean b(int i10, b bVar) {
            return bVar.f8590a.getDisplay().getDisplayId() == i10;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(final int i10) {
            m2.b.a("onDisplayAdded displayId = ", i10, l.f8580m);
            l.this.P(SourceApplication.b());
            List list = (List) l.this.f8584b.stream().filter(new Predicate() { // from class: j5.k
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return l.a.b(i10, (l.b) obj);
                }
            }).collect(Collectors.toList());
            if (list.isEmpty()) {
                k4.m.c(l.f8580m, "onDisplayAdded: displayId=" + i10 + " not found");
                return;
            }
            b bVar = (b) list.get(0);
            k4.m.e(l.f8580m, "onDisplayAdded: reparentActivity:" + bVar.j());
            l.this.f8586d.k(bVar.f8596g, i10, bVar.f8595f);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
            m2.b.a("onDisplayRemoved displayId = ", i10, l.f8580m);
            u5.c.f16204a.a(false);
            l.this.P(SourceApplication.b());
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final VirtualDisplay f8590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f8594e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8596g;

        public int i() {
            return this.f8596g;
        }

        public String j() {
            return this.f8592c;
        }

        public String k() {
            return this.f8591b;
        }

        @os.l
        public VirtualDisplay l() {
            return this.f8590a;
        }

        public boolean m() {
            return this.f8594e;
        }

        public boolean n() {
            return this.f8595f;
        }

        public boolean o() {
            return this.f8593d;
        }

        public void p(int i10) {
            this.f8596g = i10;
        }

        public void q(boolean z10) {
            this.f8595f = z10;
        }

        public void r(String str) {
            this.f8592c = str;
        }

        public void s(boolean z10) {
            this.f8593d = z10;
        }

        public b(@os.l VirtualDisplay virtualDisplay, @os.l String str, boolean z10) {
            this.f8593d = false;
            this.f8590a = virtualDisplay;
            this.f8591b = str;
            this.f8594e = z10;
        }
    }

    public l() {
        HandlerThread handlerThread = new HandlerThread("virtual_display_handler");
        handlerThread.start();
        this.f8587e = new Handler(handlerThread.getLooper());
    }

    public static /* synthetic */ boolean G(b bVar) {
        return bVar.f8591b != null;
    }

    public static /* synthetic */ boolean I(int i10, b bVar) {
        return bVar.f8590a.getDisplay().getDisplayId() == i10;
    }

    public static /* synthetic */ boolean J(int i10, b bVar) {
        return bVar.f8590a.getDisplay().getDisplayId() == i10;
    }

    public static /* synthetic */ boolean K(int i10, b bVar) {
        return bVar.f8590a.getDisplay().getDisplayId() == i10;
    }

    @os.m
    public VirtualDisplay A(int i10) {
        if (i10 == 0) {
            b bVar = this.f8583a;
            if (bVar == null) {
                return null;
            }
            return bVar.f8590a;
        }
        for (b bVar2 : this.f8584b) {
            if (bVar2.f8590a.getDisplay().getDisplayId() == i10) {
                return bVar2.f8590a;
            }
        }
        return null;
    }

    public VirtualDisplay B(Context context, r4.d dVar, Intent intent, Surface surface) {
        k4.m.e(f8580m, "startApp: " + dVar.toString());
        VirtualDisplay virtualDisplayR = r(context, dVar);
        if (virtualDisplayR == null) {
            k4.m.c(f8580m, "start app failed,vd is null");
            return null;
        }
        if (surface == null) {
            k4.m.c(f8580m, "start app failed, surface is null");
            return null;
        }
        virtualDisplayR.setSurface(surface);
        context.getApplicationContext().startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(virtualDisplayR.getDisplay().getDisplayId()).toBundle());
        this.f8584b.add(new b(virtualDisplayR, intent.getPackage(), false));
        return virtualDisplayR;
    }

    public final boolean C() {
        if (this.f8584b.size() < 100) {
            return true;
        }
        k4.m.c(f8580m, "can not create sub vd anymore,max:100");
        return false;
    }

    public final /* synthetic */ void L(int i10, boolean z10, r4.d dVar, Surface surface, CountDownLatch countDownLatch, Context context, VirtualDisplay[] virtualDisplayArr) {
        k4.m.e(f8580m, "reparentActivityToNewDisplay:from:" + i10 + ",onTop:" + z10 + ",config:" + dVar.toString());
        if (surface == null) {
            k4.m.c(f8580m, "start app failed, surface is null");
            countDownLatch.countDown();
            return;
        }
        String strZ = z(i10);
        if (strZ == null) {
            k4.m.c(f8580m, "start app failed, packageName is null");
            countDownLatch.countDown();
            return;
        }
        VirtualDisplay virtualDisplayR = r(context, dVar);
        if (virtualDisplayR == null) {
            k4.m.c(f8580m, "reparentActivityToNewDisplay failed,vd is null");
            countDownLatch.countDown();
            return;
        }
        k4.m.e(f8580m, "reparentActivityToNewDisplay:to:" + virtualDisplayR.getDisplay().getDisplayId());
        b bVar = new b(virtualDisplayR, strZ, false);
        bVar.f8596g = i10;
        bVar.f8595f = z10;
        this.f8584b.add(bVar);
        virtualDisplayR.setSurface(surface);
        virtualDisplayArr[0] = virtualDisplayR;
        countDownLatch.countDown();
    }

    public VirtualDisplay N(Context context, r4.d dVar, Surface surface) {
        o();
        VirtualDisplay virtualDisplayT = t(context, dVar);
        if (virtualDisplayT == null) {
            k4.m.c(f8580m, "can not open extendScreen");
            return null;
        }
        if (surface == null) {
            k4.m.c(f8580m, "start extend screen, surface is null");
            return null;
        }
        virtualDisplayT.setSurface(surface);
        b bVar = new b(virtualDisplayT, x(), false);
        this.f8583a = bVar;
        return bVar.f8590a;
    }

    public VirtualDisplay O(Context context, r4.d dVar, Surface surface) {
        o();
        VirtualDisplay virtualDisplayP = p(context, dVar);
        if (virtualDisplayP == null) {
            k4.m.c(f8580m, "can not open mainScreen");
            return null;
        }
        if (surface == null) {
            k4.m.c(f8580m, "start app failed, surface is null");
            return null;
        }
        virtualDisplayP.setSurface(surface);
        b bVar = new b(virtualDisplayP, this.f8585c, true);
        this.f8583a = bVar;
        return bVar.f8590a;
    }

    public void P(Context context) {
        for (Display display : ((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplays()) {
            k4.m.e(f8580m, "Display ID: " + display.getDisplayId() + ", Name: " + display.getName());
        }
        k4.m.e(f8580m, "-------------------------------------------------------------------");
    }

    public void Q(final int i10, String str, String str2) {
        if (i10 == 0) {
            this.f8585c = str;
            b bVar = this.f8583a;
            if (bVar != null) {
                bVar.f8591b = str;
                bVar.f8592c = str2;
                return;
            }
            return;
        }
        b bVarOrElse = this.f8584b.stream().filter(new Predicate() { // from class: j5.g
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return l.J(i10, (l.b) obj);
            }
        }).findAny().orElse(null);
        if (bVarOrElse == null) {
            k4.m.b(f8580m, "current display is not exist");
            return;
        }
        k4.m.b(f8580m, "activity changed to refresh display info");
        bVarOrElse.f8591b = str;
        bVarOrElse.f8592c = str2;
    }

    public void R() {
        k4.m.e(f8580m, "registerDisplayListener");
        ((DisplayManager) SourceApplication.b().getSystemService("display")).registerDisplayListener(this.f8588f, this.f8587e);
    }

    public void S() {
        X();
        b bVar = this.f8583a;
        if (bVar != null) {
            bVar.f8590a.release();
        }
        Iterator<b> it = this.f8584b.iterator();
        while (it.hasNext()) {
            it.next().f8590a.release();
        }
        this.f8584b.clear();
    }

    public void T(final int i10) {
        b bVar;
        m2.b.a("removeDisplayById:", i10, f8580m);
        b bVarOrElse = this.f8584b.stream().filter(new Predicate() { // from class: j5.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return l.K(i10, (l.b) obj);
            }
        }).findAny().orElse(null);
        if (bVarOrElse == null && (bVar = this.f8583a) != null && i10 == bVar.f8590a.getDisplay().getDisplayId()) {
            bVarOrElse = this.f8583a;
        }
        if (bVarOrElse == null) {
            k4.m.c(f8580m, "removeDisplayById:display not found");
            return;
        }
        m2.b.a("remove DisplayById is ", i10, f8580m);
        this.f8584b.remove(bVarOrElse);
        bVarOrElse.f8590a.release();
    }

    public VirtualDisplay U(final Context context, final int i10, final r4.d dVar, final boolean z10, final Surface surface) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final VirtualDisplay[] virtualDisplayArr = {null};
        this.f8587e.post(new Runnable() { // from class: j5.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f8563a.L(i10, z10, dVar, surface, countDownLatch, context, virtualDisplayArr);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e10) {
            k4.m.d(f8580m, e10);
        }
        return virtualDisplayArr[0];
    }

    @b.a({"NewApi"})
    public VirtualDisplay V(Context context, r4.d dVar, String str, Surface surface, Boolean bool) {
        k4.m.e(f8580m, "startApp: " + dVar.toString());
        VirtualDisplay virtualDisplayT = bool.booleanValue() ? t(context, dVar) : r(context, dVar);
        if (virtualDisplayT == null) {
            k4.m.c(f8580m, "start app " + str + " failed,vd is null");
            return null;
        }
        if (surface == null) {
            k4.m.c(f8580m, "start app failed, surface is null");
            return null;
        }
        virtualDisplayT.setSurface(surface);
        context.getApplicationContext().startActivity(context.getPackageManager().getLaunchIntentForPackage(str), ActivityOptions.makeBasic().setLaunchDisplayId(virtualDisplayT.getDisplay().getDisplayId()).toBundle());
        this.f8584b.add(new b(virtualDisplayT, str, false));
        return virtualDisplayT;
    }

    @b.a({"NewApi"})
    public VirtualDisplay W(Context context, r4.d dVar, int i10, Surface surface, final String str) {
        k4.m.e(f8580m, "start notification: " + dVar.toString());
        VirtualDisplay virtualDisplayQ = q(str, context, dVar, surface);
        if (virtualDisplayQ == null) {
            k4.m.c(f8580m, "open notification" + i10 + " failed,virtualDisplay is null");
            return null;
        }
        if (surface == null) {
            k4.m.c(f8580m, "start app failed, surface is null");
            return null;
        }
        if (o5.g.a.f12095a.s(i10, virtualDisplayQ.getDisplay(), context) != null) {
            if (this.f8584b.stream().noneMatch(new Predicate() { // from class: j5.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((l.b) obj).f8591b.equals(str);
                }
            })) {
                this.f8584b.add(new b(virtualDisplayQ, str, false));
            }
            return virtualDisplayQ;
        }
        k4.m.c(f8580m, "AppNotificationManager start notification id is" + i10 + " failed,send fail");
        return null;
    }

    public void X() {
        k4.m.e(f8580m, "unregisterDisplayListener");
        ((DisplayManager) SourceApplication.b().getSystemService("display")).unregisterDisplayListener(this.f8588f);
    }

    public int m(final String str) {
        b bVarOrElse = this.f8584b.stream().filter(new Predicate() { // from class: j5.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((l.b) obj).f8591b.equals(str);
            }
        }).findAny().orElse(null);
        if (bVarOrElse != null) {
            return bVarOrElse.f8590a.getDisplay().getDisplayId();
        }
        return -1;
    }

    public void n(int i10) {
        for (b bVar : this.f8584b) {
            if (bVar.f8590a.getDisplay().getDisplayId() == i10) {
                bVar.f8590a.release();
                this.f8584b.remove(bVar);
                return;
            }
        }
    }

    public synchronized void o() {
        b bVar = this.f8583a;
        if (bVar != null) {
            bVar.f8590a.release();
            this.f8583a = null;
        }
    }

    public VirtualDisplay p(Context context, r4.d dVar) {
        return s(context, dVar, Build.VERSION.SDK_INT >= 34 ? 1 | this.f8586d.n() : 1);
    }

    public final VirtualDisplay q(final String str, Context context, r4.d dVar, Surface surface) {
        b bVarOrElse = this.f8584b.stream().filter(new Predicate() { // from class: j5.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((l.b) obj).f8591b.equals(str);
            }
        }).findAny().orElse(null);
        if (bVarOrElse != null) {
            return bVarOrElse.f8590a;
        }
        VirtualDisplay virtualDisplayR = r(context, dVar);
        if (virtualDisplayR == null) {
            return null;
        }
        virtualDisplayR.setSurface(surface);
        return virtualDisplayR;
    }

    public VirtualDisplay r(Context context, r4.d dVar) {
        if (!C()) {
            return null;
        }
        int iN = this.f8586d.n();
        int i10 = iN | 265;
        if (Build.VERSION.SDK_INT >= 33) {
            i10 = iN | 1289;
        }
        return s(context, dVar, i10);
    }

    @b.a({"NewApi"})
    public final VirtualDisplay s(Context context, r4.d dVar, int i10) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        int i11 = i10 | 128;
        k4.m.e(f8580m, "createVirtualDisplay: " + i11);
        VirtualDisplay virtualDisplayCreateVirtualDisplay = displayManager.createVirtualDisplay(dVar.h(), dVar.j(), dVar.f(), dVar.c(), null, i11, null, null);
        if (virtualDisplayCreateVirtualDisplay == null) {
            k4.m.c(f8580m, "createVirtualDisplay fail");
            return null;
        }
        dVar.l(virtualDisplayCreateVirtualDisplay.getDisplay().getRefreshRate());
        return virtualDisplayCreateVirtualDisplay;
    }

    public VirtualDisplay t(Context context, r4.d dVar) {
        if (!C()) {
            return null;
        }
        int iN = this.f8586d.n();
        int i10 = iN | 777;
        if (Build.VERSION.SDK_INT >= 33) {
            i10 = iN | 1801;
        }
        return s(context, dVar, i10);
    }

    @os.m
    public b u(@os.l final String str) {
        return str.equals(this.f8585c) ? this.f8583a : this.f8584b.stream().filter(new Predicate() { // from class: j5.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals(((l.b) obj).f8591b);
            }
        }).findAny().orElse(null);
    }

    public int v(@os.l final String str) {
        if (str.equals(this.f8585c)) {
            return 0;
        }
        b bVarOrElse = this.f8584b.stream().filter(new c()).filter(new Predicate() { // from class: j5.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((l.b) obj).f8591b.equals(str);
            }
        }).findAny().orElse(null);
        if (bVarOrElse != null) {
            return bVarOrElse.f8590a.getDisplay().getDisplayId();
        }
        return -1;
    }

    public int w(Context context, int i10) {
        Display display;
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        if (displayManager == null || (display = displayManager.getDisplay(i10)) == null) {
            return 0;
        }
        return display.getRotation();
    }

    public String x() {
        return this.f8585c;
    }

    @os.m
    public b y() {
        return this.f8583a;
    }

    @os.m
    public String z(final int i10) {
        ComponentName componentNameB;
        b bVar;
        m2.b.a("get packageNameByDisplayId:", i10, f8580m);
        if (i10 != 0 && ((bVar = this.f8583a) == null || bVar.f8590a.getDisplay().getDisplayId() != i10)) {
            b bVarOrElse = this.f8584b.stream().filter(new Predicate() { // from class: j5.a
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return l.I(i10, (l.b) obj);
                }
            }).findAny().orElse(null);
            if (bVarOrElse != null) {
                return bVarOrElse.f8591b;
            }
            return null;
        }
        if (TextUtils.isEmpty(this.f8585c) && (componentNameB = k4.a.b(SourceApplication.b())) != null && !TextUtils.isEmpty(componentNameB.getPackageName())) {
            this.f8585c = componentNameB.getPackageName();
        }
        return this.f8585c;
    }
}
