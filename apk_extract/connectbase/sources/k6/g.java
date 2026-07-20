package k6;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import com.transsion.athena.aidl.AthenaTrackService;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f9103f = new k6.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f9104g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f9105h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9106i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile int f9107j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile g f9108k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static a f9109l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f9110m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile int f9111n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile long f9112o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f9113p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Context f9114q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static List<Integer> f9115r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static k f9116s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f9117t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f9118u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f9119v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x3.c f9120a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l3.a f9122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9123d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExecutorService f9121b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<TrackDataWrapper> f9124e = new CopyOnWriteArrayList<>();

    public interface a {
        void a(List<s3.a> list);
    }

    public interface b {
        String a(String str);
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x3.c f9125a;

        public /* synthetic */ c(x3.c cVar, e eVar) {
            this(cVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (s3.g.S()) {
                y3.d.e("Athena is in Test mode，should not release this APK（测试模式）[" + g.f9114q.getPackageName() + "]");
                this.f9125a.e(this, 60000L);
                return;
            }
            if (s3.g.Q() && s3.g.f14983p) {
                y3.d.e("  - Athena is in Release mode with log enabled. Please set AthenaAnalytics.setDebug(false) to release this APK （Debug模式）[" + g.f9114q.getPackageName() + "]");
                this.f9125a.e(this, 60000L);
            }
        }

        public c(x3.c cVar) {
            this.f9125a = cVar;
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f9126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SimpleDateFormat f9127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9128c;

        public /* synthetic */ d(Handler handler, e eVar) {
            this(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.f9112o > 0) {
                if (s3.e.p(g.f9114q)) {
                    if (this.f9127b == null) {
                        this.f9127b = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
                    }
                    String str = this.f9127b.format(new Date());
                    if (!str.equals(this.f9128c)) {
                        for (Integer num : t3.d.a()) {
                            if (num.intValue() != 9999) {
                                g.j0(num.intValue()).c1("app_heartbeat", null, num.intValue());
                            }
                        }
                        this.f9128c = str;
                    }
                }
                this.f9126a.postDelayed(this, 3600000L);
            }
        }

        public d(Handler handler) {
            this.f9128c = "";
            this.f9126a = handler;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f9129a;

        public e(boolean z10) {
            this.f9129a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            y3.b.f20688a.f3600m.w(this.f9129a);
        }
    }

    public interface f {
        void a(String str, String str2);
    }

    public static void A(String str, TrackData trackData, long j10) {
        try {
            if (trackData.s() > 524288) {
                y3.b.d("TrackData size is too large, ignored !!");
                return;
            }
            MMKV.mmkvWithID("AthenaKV", 2).encode(Process.myPid() + "_" + j10 + "_" + str + "_" + System.currentTimeMillis(), new TrackDataWrapper(str, trackData, j10));
            y3.b.b(String.format(Locale.getDefault(), "SaveToMMKV tid : %d, eventName : %s", Long.valueOf(j10), str));
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public static boolean A0() {
        return s3.g.H && I();
    }

    @b.a({"WrongConstant"})
    public static void B(final x3.c cVar) {
        cVar.d(new Runnable() { // from class: k6.d
            @Override // java.lang.Runnable
            public final void run() {
                g.o(cVar);
            }
        });
    }

    public static boolean B0() {
        return f9118u && f9119v;
    }

    public static boolean C() {
        return f9114q.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean C0() {
        return s3.g.I && I();
    }

    public static void D(boolean z10) {
        if (c0()) {
            s3.g.o(z10);
        } else {
            y3.b.f("Athena SDK isAthenaEnable = false");
        }
    }

    public static boolean D0(int i10) {
        return E0(i10);
    }

    public static void E(int i10, Bundle bundle) {
    }

    public static boolean E0(long j10) {
        int i10 = y3.d.f20693e;
        int length = String.valueOf(j10).length();
        if (length == 8 || length == 12) {
            return n3.b.l().b(j10, 1.0f) == 0;
        }
        y3.b.b("The parameter tid is illegal.");
        return false;
    }

    @Deprecated
    public static void F(long j10, Bundle bundle) {
    }

    public static void F0() {
        f9108k.getClass();
        if (!c0()) {
            y3.b.b("Athena SDK isAthenaEnable = false");
            return;
        }
        TrackData trackData = new TrackData();
        if (z0()) {
            trackData.m("iid", "").m("iid2", "");
        }
        if (A0()) {
            trackData.m("isd", "").m("isd2", "");
        }
        if (v0()) {
            trackData.m("aid", y3.e.k(f9114q));
        }
        trackData.m("chip", "").m("sn", "");
        try {
            List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) f9114q.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList != null && activeSubscriptionInfoList.size() > 0) {
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    if (subscriptionInfo.getSimSlotIndex() == 0 && A0()) {
                        subscriptionInfo.getSubscriptionId();
                        trackData.m("isd", "");
                    } else if (subscriptionInfo.getSimSlotIndex() == 1 && A0()) {
                        subscriptionInfo.getSubscriptionId();
                        trackData.m("isd2", "");
                    }
                }
            }
        } catch (Exception e10) {
            y3.b.d(e10.getMessage());
        }
        j0(9999).c1("device", trackData, 9999);
    }

    public static void G0() {
        if (f9111n != 0 || f9108k == null || f9108k.P() == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 600;
        f9108k.P().c(messageObtain, 100L);
    }

    public static void H(x3.c cVar) {
        cVar.e(new k6.e(), 6000L);
    }

    @Deprecated
    public static String H0(int i10, String str) {
        return "";
    }

    public static boolean I() {
        return f9114q.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") == 0;
    }

    @Deprecated
    public static String I0(long j10, String str) {
        return "";
    }

    public static void J0(int i10) {
        if (f9114q == null) {
            throw new RuntimeException("init Athena SDK first!");
        }
        int i11 = y3.d.f20693e;
        try {
            Class.forName("com.transsion.athena.attribution.ReferrerTask");
            try {
                j0(i10).P().e((Runnable) Class.forName("com.transsion.athena.attribution.ReferrerTask").getConstructor(Context.class, Integer.TYPE).newInstance(f9114q, Integer.valueOf(i10)), r4.a.O);
            } catch (Exception e10) {
                d6.b bVar = y3.b.f20688a;
                y3.b.d(Log.getStackTraceString(e10));
            }
        } catch (ClassNotFoundException unused) {
            y3.b.d("athena-attribution lib is not integrated !");
        }
    }

    public static void K() {
        s3.g.R = false;
    }

    public static void K0(short s10, String str) {
        s3.g.i(s10, str);
    }

    public static void L() {
        s3.g.J = false;
    }

    public static void L0(String str) {
        s3.g.h(str, false);
    }

    public static void M() {
        s3.g.G = false;
    }

    public static void M0(int i10, String str) {
        if (i10 < 1000 || i10 > 9999) {
            y3.b.e("appId %d is illegal", Integer.valueOf(i10));
        } else if (TextUtils.isEmpty(str)) {
            y3.b.d("sdkVersion can not be null or empty");
        } else {
            s3.g.e(i10, str);
        }
    }

    public static void N() {
        s3.g.H = false;
    }

    public static void N0(a aVar) {
        f9109l = aVar;
    }

    public static void O() {
        s3.g.I = false;
    }

    @Deprecated
    public static void O0(String str) {
    }

    public static void P0(boolean z10) {
        s3.g.t(z10);
        if (f9111n == 0) {
            if (f9108k == null) {
                y3.b.b("Init method not called.");
                return;
            }
            x3.c cVarP = f9108k.P();
            if (cVarP != null) {
                cVarP.d(new e(z10));
            }
        }
    }

    public static void Q(boolean z10) {
        x3.c cVarP;
        s3.g.x(z10);
        if (f9108k == null) {
            y3.b.b("Init method not called.");
        } else {
            if (f9111n != 0 || (cVarP = f9108k.P()) == null || z10) {
                return;
            }
            cVarP.a();
        }
    }

    public static void Q0(int i10) {
        x3.c cVarP;
        if (f9111n != 0 || (cVarP = f9108k.P()) == null) {
            return;
        }
        cVarP.b(i10);
    }

    public static void R() {
        s3.g.F = true;
    }

    @Deprecated
    public static void R0(ArrayList<Integer> arrayList) {
    }

    @Deprecated
    public static void S(boolean z10) {
        y3.b.d("The CodeTable module is closed");
    }

    public static void S0(int i10) {
        s3.g.m(i10);
    }

    public static void T(boolean z10) {
        s3.g.K = z10;
    }

    public static void T0(int i10) {
        s3.g.q(i10);
    }

    public static void U() {
        s3.g.C = true;
    }

    public static void U0(int i10) {
        k(i10, true);
    }

    public static void V() {
        s3.g.D = true;
    }

    public static void V0(long j10) {
        k(j10, true);
    }

    public static void W(boolean z10) {
        f9118u = z10;
    }

    public static void W0(boolean z10) {
        s3.g.C(z10);
    }

    public static void X() {
        s3.g.E = true;
    }

    @Deprecated
    public static void X0(b bVar) {
        f9103f = bVar;
    }

    public static void Y() {
        s3.g.d();
    }

    public static void Y0(int i10) {
        f9107j = i10;
    }

    @Deprecated
    public static void Z() {
    }

    public static void Z0(String str) {
        f9113p = str;
    }

    public static void a0() {
        if ((f9107j == 3 || c0()) && f9111n == 0) {
            w3.j.d().g();
        }
    }

    public static void a1() {
        if (f9108k != null) {
            g gVar = f9108k;
            gVar.getClass();
            if ((f9107j == 3 || c0()) && f9111n == 0 && gVar.P() != null) {
                gVar.P().i();
            }
        }
    }

    @Deprecated
    public static void b0(boolean z10) {
    }

    @Deprecated
    public static void b1(boolean z10) {
    }

    public static /* synthetic */ String c(String str) {
        return str;
    }

    public static boolean c0() {
        return (f9114q == null || f9108k == null || !s3.g.O()) ? false : true;
    }

    public static String d0(Context context) {
        return y3.a.a();
    }

    public static String e0(Context context, boolean z10) {
        return z10 ? y3.a.d(context) : y3.a.a();
    }

    public static String f0() {
        return s3.g.D();
    }

    public static a g0() {
        return f9109l;
    }

    public static /* synthetic */ String h(String str) {
        return str;
    }

    public static Context h0() {
        return f9114q;
    }

    public static g i0(int i10) {
        return j0(i10);
    }

    public static g j0(long j10) {
        if (f9108k == null) {
            synchronized (g.class) {
                try {
                    if (f9108k == null) {
                        f9108k = new g();
                        if (f9111n == 0) {
                            x3.c cVarP = f9108k.P();
                            Handler handler = new Handler(Looper.getMainLooper());
                            B(cVarP);
                            cVarP.e(new c(cVarP), r4.a.O);
                            H(cVarP);
                            l(handler);
                            handler.postDelayed(new d(handler), 3600000L);
                            y(cVarP);
                        } else {
                            g gVar = f9108k;
                            Context context = f9114q;
                            gVar.getClass();
                            try {
                                y3.b.f("AthenaAnalytics bindTrackService");
                                Intent intent = new Intent(context, (Class<?>) AthenaTrackService.class);
                                intent.setPackage(context.getApplicationInfo().packageName);
                                context.bindService(intent, new h(gVar), 1);
                            } catch (Exception e10) {
                                y3.b.d(Log.getStackTraceString(e10));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (y3.d.h(j10)) {
            int i10 = (int) j10;
            if (f9111n == 0 && t3.d.b(i10)) {
                Message message = new Message();
                message.what = 400;
                message.arg1 = i10;
                f9108k.P().c(message, 0L);
            } else if (f9111n == 1 && t3.d.b(i10)) {
                y3.b.b("multi process appid " + i10 + " register successful");
            }
        }
        return f9108k;
    }

    public static void k(long j10, boolean z10) {
        if (f9114q == null) {
            return;
        }
        if (f9112o == 0 || z10) {
            f9112o = j10;
        }
        k kVar = f9116s;
        if (kVar != null) {
            kVar.d(f9112o);
            return;
        }
        k kVar2 = new k();
        f9116s = kVar2;
        kVar2.f9145k = f9112o;
        ((Application) f9114q).registerActivityLifecycleCallbacks(f9116s);
    }

    @Deprecated
    public static long k0() {
        return 0L;
    }

    public static void l(Handler handler) {
        handler.postDelayed(new k6.c(), 6000L);
    }

    public static long m0() {
        return f9112o;
    }

    public static b n0() {
        return f9103f;
    }

    public static /* synthetic */ void o(x3.c cVar) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            if (Build.VERSION.SDK_INT >= 33) {
                f9114q.registerReceiver(new j(), intentFilter, null, cVar.g(), 4);
            } else {
                f9114q.registerReceiver(new j(), intentFilter, null, cVar.g());
            }
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public static /* synthetic */ void o0() {
        y3.f.h(f9114q);
    }

    public static boolean p(Class<?> cls) {
        List<Integer> list;
        return (cls == null || (list = f9115r) == null || !list.contains(Integer.valueOf(cls.hashCode()))) ? false : true;
    }

    public static void p0() {
        if (f9112o > 0) {
            g gVar = f9108k;
            gVar.getClass();
            if (!c0()) {
                y3.b.b("Athena SDK isAthenaEnable = false");
                return;
            }
            for (Integer num : t3.d.a()) {
                if (num.intValue() != 9999) {
                    gVar.c1("app_launch", null, num.intValue());
                }
            }
        }
    }

    public static void q0(List<Class<?>> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (f9115r == null) {
            f9115r = new ArrayList();
        }
        for (Class<?> cls : list) {
            if (cls != null) {
                int iHashCode = cls.hashCode();
                if (!f9115r.contains(Integer.valueOf(iHashCode))) {
                    f9115r.add(Integer.valueOf(iHashCode));
                }
            }
        }
    }

    public static void r(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        s3.g.g(str, obj);
    }

    public static void r0(Class<?> cls) {
        if (cls == null) {
            return;
        }
        if (f9115r == null) {
            f9115r = new ArrayList();
        }
        try {
            int iHashCode = cls.hashCode();
            if (f9115r.contains(Integer.valueOf(iHashCode))) {
                return;
            }
            f9115r.add(Integer.valueOf(iHashCode));
        } catch (Exception unused) {
        }
    }

    public static void s(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        s3.g.n(str, obj);
    }

    @Deprecated
    public static void s0(Context context, String str, int i10, String str2, boolean z10, boolean z11) {
        if (str2 == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            if (y3.d.g()) {
                y3.b.b(i10 + "初始化传入gaid为空");
            }
        } else if (Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$").matcher(str2).matches()) {
            y3.d.f(str2);
            m0.a aVarA = m0.a.a(context);
            if (aVarA != null) {
                String strI = aVarA.i("athena_id");
                if (!TextUtils.isEmpty(strI) && !TextUtils.equals(str2, strI)) {
                    y3.d.f20689a = strI;
                }
            }
        } else if (y3.d.g()) {
            y3.b.d(i10 + "初始化传入gaid不合法");
        }
        u0(context, str, i10, z10, z11);
    }

    public static void t(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        s3.g.s(str, obj);
    }

    @Deprecated
    public static void t0(Context context, String str, int i10, boolean z10) {
        u0(context, str, i10, z10, false);
    }

    public static void u(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        s3.g.w(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void u0(Context context, String str, int i10, boolean z10, boolean z11) {
        boolean zEquals;
        String str2;
        if (context == null || i10 < 1000 || i10 > 9999) {
            throw new IllegalArgumentException("The parameter is illegal.");
        }
        if (f9114q == null) {
            f9114q = context.getApplicationContext();
        }
        s3.g.t(z10);
        s3.g.h(str, z11);
        boolean z12 = false;
        if (z11) {
            t3.d.e(i10);
            k(i10, false);
        }
        l.b(f9114q);
        if (f9111n == -1) {
            String str3 = f9113p;
            try {
                try {
                    str2 = context.getApplicationContext().getApplicationInfo().processName;
                } catch (Exception e10) {
                    d6.b bVar = y3.b.f20688a;
                    y3.b.d(Log.getStackTraceString(e10));
                    str2 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = str2;
                }
                zEquals = TextUtils.equals(str3, y3.e.p(context));
            } catch (Exception unused) {
                zEquals = 1;
            }
            f9111n = !zEquals;
            if (f9111n == 0 && f9117t == 0 && s3.g.K) {
                f9117t = new Random().nextInt(601) + 300;
            }
        }
        j0(9999);
        j0(i10);
        y3.a.c(context, i10, f9117t);
        int i11 = y3.d.f20693e;
        try {
            Class.forName("com.tencent.mmkv.MMKV");
            z12 = true;
        } catch (ClassNotFoundException unused2) {
        }
        f9119v = z12;
    }

    public static void v(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        s3.g.z(str, obj);
    }

    public static boolean v0() {
        return s3.g.J && I();
    }

    public static boolean w0() {
        return f9107j == 3;
    }

    public static boolean x0(int i10, String str) {
        return n3.b.l().a(i10, str, 1.0f) == 0;
    }

    public static void y(x3.c cVar) {
        cVar.d(new k6.f());
    }

    public static boolean z0() {
        return s3.g.G && I();
    }

    public final void G(final String str, final TrackData trackData, final long j10) {
        try {
            if (this.f9122c == null || !this.f9123d) {
                if (B0()) {
                    A(str, trackData, j10);
                } else if (this.f9124e.size() < 100) {
                    this.f9124e.add(new TrackDataWrapper(str, trackData, j10));
                }
            } else if (trackData.s() < 524288) {
                this.f9121b.submit(new Runnable() { // from class: k6.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f9098a.m(str, trackData, j10);
                    }
                });
            } else {
                y3.b.d("TrackByAidl trackData size is too large, ignored !!");
            }
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public final void J() {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002a  */
    public final x3.c P() {
        x3.c cVarP;
        if (this.f9120a == null && f9114q != null) {
            if (f9107j == 2 && !y3.d.j(f9114q)) {
                f9107j = 1;
            }
            Context context = f9114q;
            int i10 = f9107j;
            if (i10 == 1) {
                cVarP = x3.h.p(context);
            } else if (i10 == 2) {
                cVarP = x3.a.j(context);
            } else if (i10 != 3) {
                cVarP = null;
            } else {
                cVarP = x3.h.p(context);
            }
            this.f9120a = cVarP;
        }
        return this.f9120a;
    }

    public void c1(String str, TrackData trackData, int i10) {
        d1(str, trackData, i10);
    }

    public void d1(String str, TrackData trackData, long j10) {
        int i10 = y3.d.f20693e;
        int length = String.valueOf(j10).length();
        if ((length != 8 && length != 12 && length != 4) || TextUtils.isEmpty(str)) {
            y3.b.b("The parameter tid : " + j10 + " or event name : " + str + " is illegal.");
            return;
        }
        if (!t3.d.c(j10)) {
            y3.b.b("The tid " + j10 + " is not belong the app");
            return;
        }
        try {
            if (trackData != null) {
                x(str, trackData, j10);
            } else {
                x(str, new TrackData(), j10);
            }
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public void e1(int i10, String str, int i11, int i12, int i13, String str2, String str3) {
        f1(i10, str, i11, i12, i13, str2, str3);
    }

    public void f1(long j10, String str, int i10, int i11, int i12, String str2, String str3) {
        d1(str, new TrackData().f("int1", i10, 0).e("int2", i11).e("int3", i12).m("string1", str2).m("string2", str3), j10);
    }

    public void g1(int i10, String str) {
        long j10 = i10;
        if (j0(j10) == null) {
            y3.b.d("init AthenaAnalytics first");
            return;
        }
        if (!((PowerManager) f9114q.getSystemService("power")).isScreenOn()) {
            y3.b.d("page_enter can not triggler when screen off");
            return;
        }
        if (System.currentTimeMillis() - f9110m <= s3.g.K()) {
            y3.b.d("page_enter triggler once at most during a session");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            y3.b.d("sence can not be empty");
            return;
        }
        if (str.length() >= 2000) {
            y3.b.d("sence is too long");
            str = str.substring(0, 2000);
        }
        j0(j10).c1("page_enter", new TrackData().m("sence", str).m("purl", ""), i10);
        f9110m = System.currentTimeMillis();
    }

    public void h1(int i10, String str) {
        i1(i10, str);
    }

    public void i1(long j10, String str) {
        d1(str, new TrackData().f("count", 1, 1), j10);
    }

    public void l0(String str, f fVar) {
        if (!c0()) {
            y3.b.b("Athena SDK isAthenaEnable = false");
            return;
        }
        if (f9107j == 2 && f9111n == 0) {
            Message message = new Message();
            message.what = 405;
            message.obj = new t3.b(str, fVar);
            f9108k.P().c(message, 0L);
        }
    }

    public final /* synthetic */ void m(String str, TrackData trackData, long j10) {
        try {
            this.f9122c.N(str, trackData, j10);
            y3.b.b(String.format(Locale.getDefault(), "TrackByAidl tid : %d, eventName : %s", Long.valueOf(j10), str));
        } catch (RemoteException e10) {
            y3.b.d("TrackByAidl " + e10.getMessage());
        }
    }

    public final void x(String str, TrackData trackData, long j10) {
        if (f9111n == 0 || f9107j == 2) {
            P().f(str, trackData, j10);
            return;
        }
        if (f9114q != null) {
            String str2 = s3.g.f14975h;
            try {
                if (!TextUtils.isEmpty("")) {
                    trackData.a().put("scode", "");
                }
                if (this.f9121b == null) {
                    this.f9121b = Executors.newSingleThreadExecutor();
                }
                G(str, trackData, j10);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public boolean y0() {
        if (f9111n != 0 || P() == null) {
            return false;
        }
        return P().h();
    }

    public void z(int i10, String str) {
        if (!c0()) {
            y3.b.b("Athena SDK isAthenaEnable = false");
            return;
        }
        if (f9107j == 3 && f9111n == 0) {
            if (!y3.d.h(i10) || !t3.d.b(i10)) {
                y3.b.b("The parameter appid is illegal");
                return;
            }
            Message message = new Message();
            message.what = 400;
            message.arg1 = i10;
            message.obj = str;
            f9108k.P().c(message, 0L);
        }
    }
}
