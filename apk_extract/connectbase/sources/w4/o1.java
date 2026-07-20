package w4;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.transsion.connectx.mirror.source.SourceApplication;
import com.transsion.connectx.sdk.DeviceInfo;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class o1 implements o4.a {
    public static final String B = "TrackEventProxy";
    public static final int C = 1;
    public static final int D = 2;
    public static final long E = 500;
    public static final int F = 1;
    public static final int G = 0;
    public static final String H = "2";
    public static final String I = "3";
    public long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v5.a f18089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f18090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f18092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f18093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f18097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f18099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f18100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f18101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f18103q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f18104r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f18105s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f18106t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f18107u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f18108v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f18109w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, z4.b> f18110x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap<String, z4.f> f18111y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConcurrentHashMap<String, z4.f> f18112z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o1 f18113a = new o1();
    }

    public static o1 g() {
        return a.f18113a;
    }

    public static String h(Context context) {
        int i10 = context.getResources().getConfiguration().orientation;
        if (i10 != 1) {
            return i10 != 2 ? "Undefined" : "landscapte";
        }
        return "vertical";
    }

    public static String k() {
        return ("tablet".equalsIgnoreCase(m4.a.C0275a.f10375a.t("ro.tr_device.type", ks.c.f9460f)) || "tablet".equalsIgnoreCase(m4.a.C0275a.f10375a.t("ro.build.characteristics", ks.c.f9460f))) ? "PAD" : "Phone";
    }

    public void A() {
        Z(v5.d.f16663k);
        a0(v5.d.f16663k);
    }

    public void B(String str) {
        this.f18090d = SystemClock.elapsedRealtime();
        this.f18092f = str;
        U();
    }

    public void C(int i10, int i11) {
        if (i10 != 1) {
            m2.b.a("notifyTeardown:do not upload reason:", i10, B);
        } else if (TextUtils.isEmpty(this.f18094h)) {
            k4.m.c(B, "notifyTeardown:pid is empty");
        } else {
            this.f18089c.H(this.f18094h, v5.a.L0, i11 == 2 ? v5.a.K0 : v5.a.J0);
        }
    }

    public void D() {
        Z(v5.d.f16662j);
        a0(v5.d.f16662j);
    }

    public void E(int i10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        z4.b bVar = this.f18110x.get(Integer.valueOf(i10));
        if (bVar != null) {
            long jB = jElapsedRealtime - bVar.b();
            this.f18110x.remove(Integer.valueOf(i10));
            Y(bVar.a(), this.f18110x.size(), jB, bVar.c());
        }
    }

    public void F(String str) {
        if (I.equals(this.f18095i)) {
            this.f18089c.k(str, f(), this.f18094h);
        } else if (H.equals(this.f18095i)) {
            if (j()) {
                this.f18089c.o(str);
            } else {
                this.f18089c.l(str);
            }
        }
    }

    public void G(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.f18088b < 500) {
            return;
        }
        this.f18088b = jElapsedRealtime;
        F(str);
    }

    public void H(String str) {
        this.f18089c.g(str, h(l6.c.f9711b));
    }

    public void I() {
        this.f18089c.h(h(l6.c.f9711b));
    }

    public void J() {
        this.f18089c.i();
    }

    public void K(String str) {
        this.f18089c.j(str);
    }

    public void L(String str) {
        this.f18089c.m(str, h(l6.c.f9711b));
    }

    public void M() {
        this.f18087a = SystemClock.elapsedRealtime();
    }

    public final void N() {
        k4.m.e(B, "onScreenFullWhenMirroring: mVideoAssistantValue = " + this.f18098l);
        if (this.f18099m != 1) {
            return;
        }
        if (H.equals(this.f18095i)) {
            this.f18089c.p();
        } else if (I.equals(this.f18095i)) {
            this.f18089c.q(this.f18094h);
        }
    }

    public void O(int i10) {
        StringBuilder sbA = h.b.a("onScreenLandWhenMirroring: orientation = ", i10, " mLastOrientation = ");
        sbA.append(this.f18099m);
        k4.m.e(B, sbA.toString());
        if (this.f18099m == i10) {
            return;
        }
        this.f18099m = i10;
        if (i10 == 1 || i10 == 3) {
            if (H.equals(this.f18095i)) {
                this.f18089c.r();
            } else if (I.equals(this.f18095i)) {
                this.f18089c.s();
            }
            N();
        }
    }

    public void P() {
        String str;
        if (H.equals(this.f18095i)) {
            str = "pad_con";
        } else {
            str = I.equals(this.f18095i) ? "pc_con" : d6.a.E;
        }
        k4.m.e(B, "onScreenLockedWhenMirroring: mDeviceType = " + this.f18095i + " deviceType = " + str);
        this.f18089c.t(str);
    }

    public void Q() {
        this.f18089c.u(k());
    }

    public void R() {
        this.f18089c.A(h(l6.c.f9711b), this.f18096j, this.f18094h);
    }

    public void S(String str) {
        this.f18089c.z(str, e(this.f18087a));
    }

    public void T() {
        this.f18110x.clear();
    }

    public final void U() {
        if (!v5.d.f16657e.equals(k4.p.a.f8971a.b(SourceApplication.b(), v5.d.f16655c, v5.d.f16656d, v5.d.f16657e))) {
            this.f18093g = v5.d.f16658f;
        } else {
            k4.p.a.f8971a.c(SourceApplication.f1881c, v5.d.f16655c, v5.d.f16656d, v5.d.f16658f);
            this.f18093g = v5.d.f16657e;
        }
    }

    public void V(DeviceInfo deviceInfo) {
        k4.m.e(B, "setConnectDeviceInfo: info = " + deviceInfo.getInfo());
        String[] strArrSplit = deviceInfo.getInfo().split(ks.g.f9491d);
        this.f18094h = strArrSplit[0];
        this.f18095i = strArrSplit[1];
        this.f18096j = strArrSplit[2];
    }

    public void W(String str) {
        if (str == null) {
            str = "";
        }
        this.f18097k = str;
    }

    public void X(int i10) {
        this.f18098l = i10;
    }

    public final void Y(String str, int i10, long j10, boolean z10) {
        if (z10) {
            this.f18089c.G(i10, j10);
        } else {
            this.f18089c.F(str, i10, j10);
        }
    }

    public final void Z(String str) {
        if (this.f18101o == 0 || this.f18107u == 0) {
            return;
        }
        this.f18089c.I(SystemClock.elapsedRealtime() - this.f18107u, this.f18101o, this.f18105s, v5.d.f16659g, str, this.f18103q);
        this.f18109w = true;
        this.f18101o = 0;
        this.f18103q = 0;
        this.f18105s = 0L;
        this.f18111y.clear();
    }

    @Override // o4.a
    public void a(int i10) {
        this.f18089c.b(f(), this.f18094h, i10);
    }

    public final void a0(String str) {
        if (this.f18100n == 0 || this.f18106t == 0) {
            return;
        }
        this.f18089c.I(SystemClock.elapsedRealtime() - this.f18106t, this.f18100n, this.f18104r, v5.d.f16660h, str, this.f18102p);
        this.f18108v = true;
        this.f18100n = 0;
        this.f18102p = 0;
        this.f18104r = 0L;
        this.f18112z.clear();
    }

    @Override // o4.a
    public void b(int i10) {
        this.f18089c.d(f(), this.f18094h, i10);
    }

    @Override // o4.a
    public void c() {
        this.f18089c.n(h(l6.c.f9711b));
    }

    @Override // o4.a
    public void d(int i10, int i11, int i12) {
        this.f18089c.f(f(), this.f18094h, i10, i11, i12);
    }

    public final String e(long j10) {
        if (j10 <= 0) {
            return "0.0min";
        }
        String str = String.format(Locale.US, "%.1f min", Double.valueOf((SystemClock.elapsedRealtime() - j10) / 60000.0d));
        this.f18087a = 0L;
        return str;
    }

    public String f() {
        String strSubstring;
        String str = this.f18094h;
        if (str == null || str.isEmpty() || this.f18094h.length() <= 3) {
            strSubstring = this.f18094h;
            if (strSubstring == null) {
                strSubstring = "";
            }
        } else {
            strSubstring = this.f18094h.substring(0, 4);
        }
        StringBuilder sbA = k.a.a(strSubstring);
        sbA.append(this.f18097k);
        String string = sbA.toString();
        k4.m.b(B, "mMac = " + this.f18097k + ", mPid=" + this.f18094h + ", mDid=" + string);
        return string;
    }

    public void i(Context context) {
        this.f18089c.a(context);
    }

    public final boolean j() {
        k5.z zVar = k5.z.a.f9097a;
        return (zVar == null || zVar.q() == null || !zVar.q().getIsExtendMode()) ? false : true;
    }

    public void l(int i10, String str, boolean z10) {
        this.f18110x.put(Integer.valueOf(i10), new z4.b(str, SystemClock.elapsedRealtime(), z10));
        if (z10) {
            return;
        }
        this.f18089c.D(str);
    }

    public void m(String str) {
        this.f18090d = SystemClock.elapsedRealtime();
        this.f18092f = str;
    }

    public void n(int i10, int i11) {
        if (i10 == 1) {
            return;
        }
        if (this.f18109w) {
            this.f18107u = SystemClock.elapsedRealtime();
            this.f18109w = false;
        }
        this.f18101o += i11;
    }

    public void o() {
        this.f18089c.v(this.f18094h);
    }

    public void p() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.A < 60000) {
            return;
        }
        this.A = jElapsedRealtime;
        this.f18089c.y(k5.z.a.f9097a.q().getIsExtendMode() ? "extend_mode" : "mirror_mode");
    }

    public void q() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.f18091e;
        if (j10 == 0) {
            k4.m.b(B, "The time of open hot is not recorded");
            return;
        }
        this.f18089c.J(this.f18094h, jElapsedRealtime - j10);
        this.f18091e = 0L;
    }

    public void r() {
        this.f18089c.w(this.f18094h, this.f18096j, f());
    }

    public void s() {
        this.f18089c.x(this.f18094h, this.f18096j, f());
    }

    public void t(String str, long j10) {
        this.f18111y.put(str, new z4.f(j10));
    }

    public void u(boolean z10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f18090d;
        if (jElapsedRealtime > 0 && z10) {
            this.f18089c.E(this.f18092f, jElapsedRealtime, this.f18094h, this.f18093g);
        }
    }

    public void v() {
        Z(v5.d.f16661i);
    }

    public void w(String str) {
        z4.f fVar = this.f18111y.get(str);
        if (fVar != null) {
            this.f18105s = fVar.a() + this.f18105s;
            this.f18103q++;
        }
    }

    public void x() {
        a0(v5.d.f16661i);
    }

    public void y(String str) {
        z4.f fVar = this.f18112z.get(str);
        if (fVar != null) {
            this.f18104r = fVar.a() + this.f18104r;
            this.f18102p++;
        }
    }

    public void z(String str, long j10) {
        if (this.f18108v) {
            this.f18106t = SystemClock.elapsedRealtime();
            this.f18108v = false;
        }
        this.f18112z.put(str, new z4.f(j10));
        this.f18100n++;
    }

    public o1() {
        this.f18087a = 0L;
        this.f18088b = 0L;
        this.f18095i = d6.a.E;
        this.f18096j = d6.a.E;
        this.f18098l = 0;
        this.f18099m = 0;
        this.f18108v = true;
        this.f18109w = true;
        this.f18110x = new ConcurrentHashMap<>();
        this.f18111y = new ConcurrentHashMap<>();
        this.f18112z = new ConcurrentHashMap<>();
        this.f18089c = v5.a.C0447a.f16652a;
        o4.b.f12074a = this;
    }
}
