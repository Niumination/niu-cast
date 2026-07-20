package ik;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.widgetslib.view.swipmenu.OSSwipeMenuLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @os.l
    public static final r0[] f8163e0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f8186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f8158c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final r0 f8160d = new r0(100, "Continue");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final r0 f8162e = new r0(101, "Switching Protocols");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final r0 f8164f = new r0(102, "Processing");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final r0 f8165g = new r0(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, "OK");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final r0 f8166h = new r0(201, "Created");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final r0 f8167i = new r0(202, "Accepted");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final r0 f8168j = new r0(203, "Non-Authoritative Information");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final r0 f8169k = new r0(204, "No Content");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public static final r0 f8170l = new r0(205, "Reset Content");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public static final r0 f8171m = new r0(206, "Partial Content");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final r0 f8172n = new r0(207, "Multi-Status");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public static final r0 f8173o = new r0(300, "Multiple Choices");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final r0 f8174p = new r0(301, "Moved Permanently");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public static final r0 f8175q = new r0(302, "Found");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public static final r0 f8176r = new r0(303, "See Other");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public static final r0 f8177s = new r0(304, "Not Modified");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public static final r0 f8178t = new r0(305, "Use Proxy");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @os.l
    public static final r0 f8179u = new r0(306, "Switch Proxy");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final r0 f8180v = new r0(307, "Temporary Redirect");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final r0 f8181w = new r0(308, "Permanent Redirect");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final r0 f8182x = new r0(400, "Bad Request");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final r0 f8183y = new r0(TypedValues.CycleType.TYPE_CURVE_FIT, "Unauthorized");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public static final r0 f8184z = new r0(TypedValues.CycleType.TYPE_VISIBILITY, "Payment Required");

    @os.l
    public static final r0 A = new r0(TypedValues.CycleType.TYPE_ALPHA, "Forbidden");

    @os.l
    public static final r0 B = new r0(404, "Not Found");

    @os.l
    public static final r0 C = new r0(405, "Method Not Allowed");

    @os.l
    public static final r0 D = new r0(406, "Not Acceptable");

    @os.l
    public static final r0 E = new r0(407, "Proxy Authentication Required");

    @os.l
    public static final r0 F = new r0(408, "Request Timeout");

    @os.l
    public static final r0 G = new r0(409, "Conflict");

    @os.l
    public static final r0 H = new r0(410, "Gone");

    @os.l
    public static final r0 I = new r0(411, "Length Required");

    @os.l
    public static final r0 J = new r0(412, "Precondition Failed");

    @os.l
    public static final r0 K = new r0(413, "Payload Too Large");

    @os.l
    public static final r0 L = new r0(414, "Request-URI Too Long");

    @os.l
    public static final r0 M = new r0(415, "Unsupported Media Type");

    @os.l
    public static final r0 N = new r0(TypedValues.CycleType.TYPE_PATH_ROTATE, "Requested Range Not Satisfiable");

    @os.l
    public static final r0 O = new r0(417, "Expectation Failed");

    @os.l
    public static final r0 P = new r0(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, "Unprocessable Entity");

    @os.l
    public static final r0 Q = new r0(TypedValues.CycleType.TYPE_WAVE_PERIOD, "Locked");

    @os.l
    public static final r0 R = new r0(TypedValues.CycleType.TYPE_WAVE_OFFSET, "Failed Dependency");

    @os.l
    public static final r0 S = new r0(426, "Upgrade Required");

    @os.l
    public static final r0 T = new r0(429, "Too Many Requests");

    @os.l
    public static final r0 U = new r0(431, "Request Header Fields Too Large");

    @os.l
    public static final r0 V = new r0(OSSwipeMenuLayout.D0, "Internal Server Error");

    @os.l
    public static final r0 W = new r0(TypedValues.PositionType.TYPE_TRANSITION_EASING, "Not Implemented");

    @os.l
    public static final r0 X = new r0(TypedValues.PositionType.TYPE_DRAWPATH, "Bad Gateway");

    @os.l
    public static final r0 Y = new r0(TypedValues.PositionType.TYPE_PERCENT_WIDTH, "Service Unavailable");

    @os.l
    public static final r0 Z = new r0(TypedValues.PositionType.TYPE_PERCENT_HEIGHT, "Gateway Timeout");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @os.l
    public static final r0 f8156a0 = new r0(TypedValues.PositionType.TYPE_SIZE_PERCENT, "HTTP Version Not Supported");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @os.l
    public static final r0 f8157b0 = new r0(TypedValues.PositionType.TYPE_PERCENT_X, "Variant Also Negotiates");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @os.l
    public static final r0 f8159c0 = new r0(TypedValues.PositionType.TYPE_PERCENT_Y, "Insufficient Storage");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @os.l
    public static final List<r0> f8161d0 = s0.a();

    public static final class a {
        public a() {
        }

        @os.l
        public final r0 A() {
            return r0.W;
        }

        @os.l
        public final r0 B() {
            return r0.f8177s;
        }

        @os.l
        public final r0 C() {
            return r0.f8165g;
        }

        @os.l
        public final r0 D() {
            return r0.f8171m;
        }

        @os.l
        public final r0 E() {
            return r0.K;
        }

        @os.l
        public final r0 F() {
            return r0.f8184z;
        }

        @os.l
        public final r0 G() {
            return r0.f8181w;
        }

        @os.l
        public final r0 H() {
            return r0.J;
        }

        @os.l
        public final r0 I() {
            return r0.f8164f;
        }

        @os.l
        public final r0 J() {
            return r0.E;
        }

        @os.l
        public final r0 K() {
            return r0.U;
        }

        @os.l
        public final r0 L() {
            return r0.F;
        }

        @os.l
        public final r0 M() {
            return r0.L;
        }

        @os.l
        public final r0 N() {
            return r0.N;
        }

        @os.l
        public final r0 O() {
            return r0.f8170l;
        }

        @os.l
        public final r0 P() {
            return r0.f8176r;
        }

        @os.l
        public final r0 Q() {
            return r0.Y;
        }

        @os.l
        public final r0 R() {
            return r0.f8179u;
        }

        @os.l
        public final r0 S() {
            return r0.f8162e;
        }

        @os.l
        public final r0 T() {
            return r0.f8180v;
        }

        @os.l
        public final r0 U() {
            return r0.T;
        }

        @os.l
        public final r0 V() {
            return r0.f8183y;
        }

        @os.l
        public final r0 W() {
            return r0.P;
        }

        @os.l
        public final r0 X() {
            return r0.M;
        }

        @os.l
        public final r0 Y() {
            return r0.S;
        }

        @os.l
        public final r0 Z() {
            return r0.f8178t;
        }

        @os.l
        public final r0 a(int i10) {
            r0 r0Var = (1 > i10 || i10 >= 1000) ? null : r0.f8163e0[i10];
            return r0Var == null ? new r0(i10, "Unknown Status Code") : r0Var;
        }

        @os.l
        public final r0 a0() {
            return r0.f8157b0;
        }

        @os.l
        public final r0 b() {
            return r0.f8167i;
        }

        @os.l
        public final r0 b0() {
            return r0.f8156a0;
        }

        @os.l
        public final List<r0> c() {
            return r0.f8161d0;
        }

        @os.l
        public final r0 d() {
            return r0.X;
        }

        @os.l
        public final r0 e() {
            return r0.f8182x;
        }

        @os.l
        public final r0 f() {
            return r0.G;
        }

        @os.l
        public final r0 g() {
            return r0.f8160d;
        }

        @os.l
        public final r0 h() {
            return r0.f8166h;
        }

        @os.l
        public final r0 i() {
            return r0.O;
        }

        @os.l
        public final r0 j() {
            return r0.R;
        }

        @os.l
        public final r0 k() {
            return r0.A;
        }

        @os.l
        public final r0 l() {
            return r0.f8175q;
        }

        @os.l
        public final r0 m() {
            return r0.Z;
        }

        @os.l
        public final r0 n() {
            return r0.H;
        }

        @os.l
        public final r0 o() {
            return r0.f8159c0;
        }

        @os.l
        public final r0 p() {
            return r0.V;
        }

        @os.l
        public final r0 q() {
            return r0.I;
        }

        @os.l
        public final r0 r() {
            return r0.Q;
        }

        @os.l
        public final r0 s() {
            return r0.C;
        }

        @os.l
        public final r0 t() {
            return r0.f8174p;
        }

        @os.l
        public final r0 u() {
            return r0.f8172n;
        }

        @os.l
        public final r0 v() {
            return r0.f8173o;
        }

        @os.l
        public final r0 w() {
            return r0.f8169k;
        }

        @os.l
        public final r0 x() {
            return r0.f8168j;
        }

        @os.l
        public final r0 y() {
            return r0.D;
        }

        @os.l
        public final r0 z() {
            return r0.B;
        }

        public a(kn.w wVar) {
        }
    }

    static {
        Object next;
        r0[] r0VarArr = new r0[1000];
        for (int i10 = 0; i10 < 1000; i10++) {
            Iterator<T> it = f8161d0.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((r0) next).f8185a != i10);
            r0VarArr[i10] = (r0) next;
        }
        f8163e0 = r0VarArr;
    }

    public r0(int i10, @os.l String str) {
        kn.l0.p(str, "description");
        this.f8185a = i10;
        this.f8186b = str;
    }

    public static /* synthetic */ r0 f0(r0 r0Var, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = r0Var.f8185a;
        }
        if ((i11 & 2) != 0) {
            str = r0Var.f8186b;
        }
        return r0Var.e0(i10, str);
    }

    public final int c0() {
        return this.f8185a;
    }

    @os.l
    public final String d0() {
        return this.f8186b;
    }

    @os.l
    public final r0 e0(int i10, @os.l String str) {
        kn.l0.p(str, "description");
        return new r0(i10, str);
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof r0) && ((r0) obj).f8185a == this.f8185a;
    }

    @os.l
    public final r0 g0(@os.l String str) {
        kn.l0.p(str, "value");
        return f0(this, 0, str, 1, null);
    }

    @os.l
    public final String h0() {
        return this.f8186b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f8185a);
    }

    public final int i0() {
        return this.f8185a;
    }

    @os.l
    public String toString() {
        return this.f8185a + ' ' + this.f8186b;
    }
}
