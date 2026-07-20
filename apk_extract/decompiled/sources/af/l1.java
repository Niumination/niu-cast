package af;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f410a = Logger.getLogger(l1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f411b = Collections.unmodifiableSet(EnumSet.of(ze.o2.OK, ze.o2.INVALID_ARGUMENT, ze.o2.NOT_FOUND, ze.o2.ALREADY_EXISTS, ze.o2.FAILED_PRECONDITION, ze.o2.ABORTED, ze.o2.OUT_OF_RANGE, ze.o2.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f412c = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ze.k1 f413d = new ze.k1("grpc-timeout", new k2(13));
    public static final ze.k1 e;
    public static final ze.n1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ze.k1 f414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ze.n1 f415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ze.k1 f416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ze.k1 f417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ze.k1 f418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ze.k1 f419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final sj.a f420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f422o;
    public static final long p;
    public static final j4 q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ze.e f423r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final j1 f424s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final k2 f425t;
    public static final k2 u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final k2 f426v;

    static {
        ze.p2 p2Var = ze.p1.f11398d;
        e = new ze.k1("grpc-encoding", p2Var);
        f = ze.t0.a("grpc-accept-encoding", new k2(12));
        f414g = new ze.k1("content-encoding", p2Var);
        f415h = ze.t0.a("accept-encoding", new k2(12));
        f416i = new ze.k1("content-length", p2Var);
        f417j = new ze.k1("content-type", p2Var);
        f418k = new ze.k1("te", p2Var);
        f419l = new ze.k1("user-agent", p2Var);
        se.e eVar = new se.e(new h4.c(), 10);
        h4.e eVar2 = h4.e.f5246c;
        eVar2.getClass();
        f420m = new sj.a(eVar, eVar2);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f421n = timeUnit.toNanos(20L);
        f422o = TimeUnit.HOURS.toNanos(2L);
        p = timeUnit.toNanos(20L);
        q = new j4();
        f423r = new ze.e("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f424s = new j1();
        f425t = new k2(9);
        u = new k2(10);
        f426v = new k2(11);
    }

    public static URI a(String str) {
        v8.i(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e4) {
            throw new IllegalArgumentException("Invalid authority: ".concat(str), e4);
        }
    }

    public static void b(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e4) {
            f410a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e4);
        }
    }

    public static void c(InputStream inputStream) {
        while (inputStream.read(new byte[256]) != -1) {
        }
    }

    public static ze.n[] d(ze.f fVar, ze.p1 p1Var, int i8, boolean z2) {
        List list = fVar.e;
        int size = list.size();
        ze.n[] nVarArr = new ze.n[size + 1];
        ze.f fVar2 = ze.f.f11346i;
        k3.b0 b0Var = new k3.b0(fVar, i8, z2);
        for (int i9 = 0; i9 < list.size(); i9++) {
            nVarArr[i9] = ((ze.m) list.get(i9)).a(b0Var, p1Var);
        }
        nVarArr[size] = f424s;
        return nVarArr;
    }

    public static String e(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static m4.n f(String str) {
        Boolean bool = Boolean.TRUE;
        String.format(Locale.ROOT, str, 0);
        return new m4.n(Executors.defaultThreadFactory(), str, new AtomicLong(0L), bool);
    }

    public static e0 g(ze.x0 x0Var, boolean z2) {
        j0 j0Var;
        ze.i iVar = x0Var.f11466a;
        if (iVar == null) {
            j0Var = null;
        } else {
            f2 f2Var = (f2) iVar.d();
            j0Var = f2Var.u;
            if (j0Var == null) {
                f2Var.f267j.execute(new w1(f2Var, 1));
                j0Var = null;
            }
        }
        if (j0Var != null) {
            p001if.p pVar = x0Var.f11467b;
            return pVar == null ? j0Var : new f1(pVar, j0Var);
        }
        ze.q2 q2Var = x0Var.f11468c;
        if (!q2Var.e()) {
            if (x0Var.f11469d) {
                return new f1(j(q2Var), c0.DROPPED);
            }
            if (!z2) {
                return new f1(j(q2Var), c0.PROCESSED);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0029  */
    /* JADX WARN: Code duplicated, block: B:25:0x0035  */
    public static ze.q2 h(int i8) {
        ze.o2 o2Var;
        if ((i8 >= 100 && i8 < 200) || i8 == 400) {
            o2Var = ze.o2.INTERNAL;
        } else if (i8 == 401) {
            o2Var = ze.o2.UNAUTHENTICATED;
        } else if (i8 == 403) {
            o2Var = ze.o2.PERMISSION_DENIED;
        } else if (i8 == 404) {
            o2Var = ze.o2.UNIMPLEMENTED;
        } else if (i8 == 429) {
            o2Var = ze.o2.UNAVAILABLE;
        } else if (i8 != 431) {
            switch (i8) {
                case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                    o2Var = ze.o2.UNAVAILABLE;
                    break;
                default:
                    o2Var = ze.o2.UNKNOWN;
                    break;
            }
        } else {
            o2Var = ze.o2.INTERNAL;
        }
        return o2Var.toStatus().h("HTTP status code " + i8);
    }

    public static boolean i(String str) {
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("application/grpc")) {
            return false;
        }
        if (lowerCase.length() == 16) {
            return true;
        }
        char cCharAt = lowerCase.charAt(16);
        return cCharAt == '+' || cCharAt == ';';
    }

    public static ze.q2 j(ze.q2 q2Var) {
        v8.e(q2Var != null);
        if (!f411b.contains(q2Var.f11413a)) {
            return q2Var;
        }
        return ze.q2.f11410m.h("Inappropriate status code from control plane: " + q2Var.f11413a + " " + q2Var.f11414b).g(q2Var.f11415c);
    }
}
