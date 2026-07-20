package wj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {
    public static final long A;
    public static final long B = Long.MAX_VALUE;
    public static final long C;
    public static final long D;
    public static final long E = Long.MAX_VALUE;
    public static final vj.g2 F;
    public static final vj.g2 G;
    public static final String H = "pick_first";
    public static final vj.e.c<Boolean> I;
    public static final vj.n J;
    public static final f3.d<Executor> K;
    public static final f3.d<ScheduledExecutorService> L;
    public static final c1.q0<c1.o0> M;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vj.v1.i<String> f19359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final vj.v1.i<byte[]> f19360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final vj.v1.i<String> f19361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final vj.v1.i<byte[]> f19362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final vj.v1.i<String> f19363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final vj.v1.i<String> f19364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final vj.v1.i<String> f19365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final vj.v1.i<String> f19366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f19367m = 80;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19368n = 443;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f19369o = "application/grpc";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f19370p = "POST";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f19371q = "trailers";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f19373s = "grpc-encoding";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f19374t = "grpc-accept-encoding";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f19375u = "content-encoding";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f19376v = "accept-encoding";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f19377w = 4194304;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f19378x = 8192;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c1.m0 f19379y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f19380z = "1.63.0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f19355a = Logger.getLogger(v0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<vj.y2.b> f19356b = Collections.unmodifiableSet(EnumSet.of(vj.y2.b.OK, vj.y2.b.INVALID_ARGUMENT, vj.y2.b.NOT_FOUND, vj.y2.b.ALREADY_EXISTS, vj.y2.b.FAILED_PRECONDITION, vj.y2.b.ABORTED, vj.y2.b.OUT_OF_RANGE, vj.y2.b.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f19357c = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f19372r = "grpc-timeout";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vj.v1.i<Long> f19358d = vj.v1.i.e(f19372r, new k());

    public class a implements vj.g2 {
        @Override // vj.g2
        @gm.j
        public vj.f2 a(SocketAddress socketAddress) {
            return null;
        }
    }

    public class b extends vj.n {
    }

    public class c implements f3.d<Executor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f19381a = "grpc-default-executor";

        @Override // wj.f3.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void close(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // wj.f3.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(v0.m("grpc-default-executor-%d", true));
        }

        public String toString() {
            return f19381a;
        }
    }

    public class d implements f3.d<ScheduledExecutorService> {
        @Override // wj.f3.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void close(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // wj.f3.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService a() {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, v0.m("grpc-timer-%d", true));
            try {
                scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
            return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    public class e implements c1.q0<c1.o0> {
        @Override // c1.q0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c1.o0 get() {
            return new c1.o0();
        }
    }

    public class f implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.n.a f19382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f19383b;

        public f(vj.n.a aVar, u uVar) {
            this.f19382a = aVar;
            this.f19383b = uVar;
        }

        @Override // wj.u
        public void d(u.a aVar, Executor executor) {
            this.f19383b.d(aVar, executor);
        }

        @Override // vj.m1
        public vj.c1 e() {
            return this.f19383b.e();
        }

        @Override // vj.a1
        public q1.s1<vj.v0.l> j() {
            return this.f19383b.j();
        }

        @Override // wj.u
        public s k(vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar, vj.n[] nVarArr) {
            vj.n nVarA = this.f19382a.a(new vj.n.b.a().b(eVar).a(), v1Var);
            c1.h0.h0(nVarArr[nVarArr.length - 1] == v0.J, "lb tracer already assigned");
            nVarArr[nVarArr.length - 1] = nVarA;
            return this.f19383b.k(w1Var, v1Var, eVar, nVarArr);
        }
    }

    public static final class g implements vj.f1.a<byte[]> {
        public g() {
        }

        @Override // vj.v1.m
        public byte[] a(Object obj) {
            return (byte[]) obj;
        }

        @Override // vj.v1.m
        public Object b(byte[] bArr) {
            return bArr;
        }

        public byte[] c(byte[] bArr) {
            return bArr;
        }

        public byte[] d(byte[] bArr) {
            return bArr;
        }

        public g(a aVar) {
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final char[] f19384a = jq.j.f8822b.toCharArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Set<Character> f19385b = Collections.unmodifiableSet(new HashSet(Arrays.asList('-', '_', Character.valueOf(n1.e.f11183c), '~')));

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Set<Character> f19386c = Collections.unmodifiableSet(new HashSet(Arrays.asList('!', Character.valueOf(jq.m0.f8865c), Character.valueOf(jq.m0.f8866d), '\'', '(', ')', Character.valueOf(kl.f.f9277j), '+', Character.valueOf(StringUtil.COMMA), ';', Character.valueOf(fl.h.f6043c))));

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Set<Character> f19387d = Collections.unmodifiableSet(new HashSet(Arrays.asList(Character.valueOf(n1.e.f11184d), Character.valueOf(ks.a.f9445d), ']', '@')));

        public static String a(String str) {
            c1.h0.F(str, "authority");
            int length = str.length();
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (b(str.charAt(i11))) {
                    i10++;
                }
            }
            if (i10 == 0) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder((i10 * 2) + length);
            for (int i12 = 0; i12 < length; i12++) {
                char cCharAt = str.charAt(i12);
                if (b(cCharAt)) {
                    sb2.append('%');
                    char[] cArr = f19384a;
                    sb2.append(cArr[cCharAt >>> 4]);
                    sb2.append(cArr[cCharAt & 15]);
                } else {
                    sb2.append(cCharAt);
                }
            }
            return sb2.toString();
        }

        public static boolean b(char c10) {
            if (c10 > 127) {
                return false;
            }
            if ((c10 < 'a' || c10 > 'z') && (c10 < 'A' || c10 > 'Z')) {
                return ((c10 >= '0' && c10 <= '9') || f19385b.contains(Character.valueOf(c10)) || f19386c.contains(Character.valueOf(c10)) || f19387d.contains(Character.valueOf(c10))) ? false : true;
            }
            return false;
        }
    }

    @hm.b
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19389b;

        public /* synthetic */ i(String str, String str2, a aVar) {
            this(str, str2);
        }

        public String a() {
            return this.f19389b;
        }

        public String b() {
            return this.f19388a;
        }

        public String toString() {
            return this.f19388a + " " + this.f19389b;
        }

        public i(String str, String str2) {
            this.f19388a = (String) c1.h0.F(str, "userAgentName");
            this.f19389b = (String) c1.h0.F(str2, "implementationVersion");
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NO_ERROR' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class j {
        public static final j CANCEL;
        public static final j COMPRESSION_ERROR;
        public static final j CONNECT_ERROR;
        public static final j ENHANCE_YOUR_CALM;
        public static final j FLOW_CONTROL_ERROR;
        public static final j FRAME_SIZE_ERROR;
        public static final j HTTP_1_1_REQUIRED;
        public static final j INADEQUATE_SECURITY;
        public static final j INTERNAL_ERROR;
        public static final j NO_ERROR;
        public static final j PROTOCOL_ERROR;
        public static final j REFUSED_STREAM;
        public static final j SETTINGS_TIMEOUT;
        public static final j STREAM_CLOSED;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j[] f19390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ j[] f19391b;
        private final int code;
        private final vj.y2 status;

        static {
            vj.y2 y2Var = vj.y2.f17563t;
            j jVar = new j("NO_ERROR", 0, 0, y2Var);
            NO_ERROR = jVar;
            vj.y2 y2Var2 = vj.y2.f17562s;
            j jVar2 = new j("PROTOCOL_ERROR", 1, 1, y2Var2);
            PROTOCOL_ERROR = jVar2;
            j jVar3 = new j("INTERNAL_ERROR", 2, 2, y2Var2);
            INTERNAL_ERROR = jVar3;
            j jVar4 = new j("FLOW_CONTROL_ERROR", 3, 3, y2Var2);
            FLOW_CONTROL_ERROR = jVar4;
            j jVar5 = new j("SETTINGS_TIMEOUT", 4, 4, y2Var2);
            SETTINGS_TIMEOUT = jVar5;
            j jVar6 = new j("STREAM_CLOSED", 5, 5, y2Var2);
            STREAM_CLOSED = jVar6;
            j jVar7 = new j("FRAME_SIZE_ERROR", 6, 6, y2Var2);
            FRAME_SIZE_ERROR = jVar7;
            j jVar8 = new j("REFUSED_STREAM", 7, 7, y2Var);
            REFUSED_STREAM = jVar8;
            j jVar9 = new j("CANCEL", 8, 8, vj.y2.f17549f);
            CANCEL = jVar9;
            j jVar10 = new j("COMPRESSION_ERROR", 9, 9, y2Var2);
            COMPRESSION_ERROR = jVar10;
            j jVar11 = new j("CONNECT_ERROR", 10, 10, y2Var2);
            CONNECT_ERROR = jVar11;
            j jVar12 = new j("ENHANCE_YOUR_CALM", 11, 11, vj.y2.f17557n.u("Bandwidth exhausted"));
            ENHANCE_YOUR_CALM = jVar12;
            j jVar13 = new j("INADEQUATE_SECURITY", 12, 12, vj.y2.f17555l.u("Permission denied as protocol is not secure enough to call"));
            INADEQUATE_SECURITY = jVar13;
            j jVar14 = new j("HTTP_1_1_REQUIRED", 13, 13, vj.y2.f17550g);
            HTTP_1_1_REQUIRED = jVar14;
            f19391b = new j[]{jVar, jVar2, jVar3, jVar4, jVar5, jVar6, jVar7, jVar8, jVar9, jVar10, jVar11, jVar12, jVar13, jVar14};
            f19390a = a();
        }

        public j(String str, int i10, int i11, vj.y2 y2Var) {
            super(str, i10);
            this.code = i11;
            String str2 = "HTTP/2 error code: " + name();
            this.status = y2Var.u(y2Var.f17569b != null ? j.c.a(k.c.a(str2, " ("), y2Var.f17569b, ")") : str2);
        }

        public static j[] a() {
            j[] jVarArrValues = values();
            j[] jVarArr = new j[((int) jVarArrValues[jVarArrValues.length - 1].code()) + 1];
            for (j jVar : jVarArrValues) {
                jVarArr[(int) jVar.code()] = jVar;
            }
            return jVarArr;
        }

        public static j forCode(long j10) {
            j[] jVarArr = f19390a;
            if (j10 >= jVarArr.length || j10 < 0) {
                return null;
            }
            return jVarArr[(int) j10];
        }

        public static vj.y2 statusForCode(long j10) {
            j jVarForCode = forCode(j10);
            if (jVarForCode != null) {
                return jVarForCode.status();
            }
            return vj.y2.k(INTERNAL_ERROR.status().f17568a.value()).u("Unrecognized HTTP/2 error code: " + j10);
        }

        public static j valueOf(String str) {
            return (j) Enum.valueOf(j.class, str);
        }

        public static j[] values() {
            return (j[]) f19391b.clone();
        }

        public long code() {
            return this.code;
        }

        public vj.y2 status() {
            return this.status;
        }
    }

    @b1.e
    public static class k implements vj.v1.d<Long> {
        @Override // vj.v1.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long b(String str) {
            c1.h0.e(str.length() > 0, "empty timeout");
            c1.h0.e(str.length() <= 9, "bad timeout format");
            long j10 = Long.parseLong(str.substring(0, str.length() - 1));
            char cCharAt = str.charAt(str.length() - 1);
            if (cCharAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(j10));
            }
            if (cCharAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(j10));
            }
            if (cCharAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(j10));
            }
            if (cCharAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j10));
            }
            if (cCharAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j10));
            }
            if (cCharAt == 'n') {
                return Long.valueOf(j10);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
        }

        @Override // vj.v1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(Long l10) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l10.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l10.longValue() < 100000000) {
                return l10 + p6.n.f13005a;
            }
            if (l10.longValue() < 100000000000L) {
                return timeUnit.toMicros(l10.longValue()) + p6.u.f13018b;
            }
            if (l10.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l10.longValue()) + p6.m.f13003a;
            }
            if (l10.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l10.longValue()) + "S";
            }
            if (l10.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l10.longValue()) + "M";
            }
            return timeUnit.toHours(l10.longValue()) + "H";
        }
    }

    static {
        vj.v1.d<String> dVar = vj.v1.f17427f;
        f19359e = vj.v1.i.e(f19373s, dVar);
        f19360f = vj.f1.b(f19374t, new g());
        f19361g = vj.v1.i.e(f19375u, dVar);
        f19362h = vj.f1.b(f19376v, new g());
        f19363i = vj.v1.i.e("content-length", dVar);
        f19364j = vj.v1.i.e("content-type", dVar);
        f19365k = vj.v1.i.e("te", dVar);
        f19366l = vj.v1.i.e("user-agent", dVar);
        c1.m0 m0VarH = c1.m0.h(StringUtil.COMMA);
        m0VarH.getClass();
        f19379y = m0VarH.r(c1.e.c0.f1149f);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        A = timeUnit.toNanos(20L);
        C = TimeUnit.HOURS.toNanos(2L);
        D = timeUnit.toNanos(20L);
        F = new h2();
        G = new a();
        I = vj.e.c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        J = new b();
        K = new c();
        L = new d();
        M = new e();
    }

    public static String b(String str, int i10) {
        try {
            return new URI(null, null, str, i10, null, null, null).getAuthority();
        } catch (URISyntaxException e10) {
            throw new IllegalArgumentException("Invalid host or port: " + str + " " + i10, e10);
        }
    }

    public static URI c(String str) {
        c1.h0.F(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e10) {
            throw new IllegalArgumentException(m.a.a("Invalid authority: ", str), e10);
        }
    }

    public static String d(String str) {
        c1.h0.u(c(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void e(@gm.j Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            f19355a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e10);
        }
    }

    public static void f(k3.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                e(next);
            }
        }
    }

    public static void g(InputStream inputStream) throws IOException {
        while (inputStream.read(new byte[256]) != -1) {
        }
    }

    public static vj.n[] h(vj.e eVar, vj.v1 v1Var, int i10, boolean z10) {
        List<vj.n.a> list = eVar.f17092g;
        int size = list.size();
        vj.n[] nVarArr = new vj.n[size + 1];
        vj.n.b.a aVarB = new vj.n.b.a().b(eVar);
        aVarB.f17191b = i10;
        aVarB.f17192c = z10;
        vj.n.b bVarA = aVarB.a();
        for (int i11 = 0; i11 < list.size(); i11++) {
            nVarArr[i11] = list.get(i11).a(bVarA, v1Var);
        }
        nVarArr[size] = J;
        return nVarArr;
    }

    public static boolean i(String str, boolean z10) {
        String strTrim = System.getenv(str);
        if (strTrim == null) {
            strTrim = System.getProperty(str);
        }
        if (strTrim != null) {
            strTrim = strTrim.trim();
        }
        if (z10) {
            return c1.g0.j(strTrim) || Boolean.parseBoolean(strTrim);
        }
        return !c1.g0.j(strTrim) && Boolean.parseBoolean(strTrim);
    }

    public static i j() {
        return new i("gRPC Java", f19380z);
    }

    public static String k(String str, @gm.j String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str2 != null) {
            sb2.append(str2);
            sb2.append(' ');
        }
        sb2.append("grpc-java-");
        sb2.append(str);
        sb2.append("/1.63.0");
        return sb2.toString();
    }

    public static String l(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", null).invoke(inetSocketAddress, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory m(String str, boolean z10) {
        q1.x2 x2Var = new q1.x2();
        x2Var.f13756b = Boolean.valueOf(z10);
        q1.x2 x2VarF = x2Var.f(str);
        x2VarF.getClass();
        return q1.x2.c(x2VarF);
    }

    @gm.j
    public static u n(vj.o1.g gVar, boolean z10) {
        vj.o1.j jVar = gVar.f17213a;
        u uVarB = jVar != null ? ((p3) jVar.f()).b() : null;
        if (uVarB != null) {
            vj.n.a aVar = gVar.f17214b;
            return aVar == null ? uVarB : new f(aVar, uVarB);
        }
        if (!gVar.f17215c.r()) {
            if (gVar.f17216d) {
                return new j0(s(gVar.f17215c), t.a.DROPPED);
            }
            if (!z10) {
                return new j0(s(gVar.f17215c), t.a.PROCESSED);
            }
        }
        return null;
    }

    public static vj.y2.b o(int i10) {
        if (i10 >= 100 && i10 < 200) {
            return vj.y2.b.INTERNAL;
        }
        if (i10 != 400) {
            if (i10 == 401) {
                return vj.y2.b.UNAUTHENTICATED;
            }
            if (i10 == 403) {
                return vj.y2.b.PERMISSION_DENIED;
            }
            if (i10 == 404) {
                return vj.y2.b.UNIMPLEMENTED;
            }
            if (i10 != 429) {
                if (i10 != 431) {
                    switch (i10) {
                        case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                        case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                        case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                            break;
                        default:
                            return vj.y2.b.UNKNOWN;
                    }
                }
            }
            return vj.y2.b.UNAVAILABLE;
        }
        return vj.y2.b.INTERNAL;
    }

    public static vj.y2 p(int i10) {
        return o(i10).toStatus().u("HTTP status code " + i10);
    }

    public static boolean q(String str) {
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (!lowerCase.startsWith(f19369o)) {
            return false;
        }
        if (lowerCase.length() == 16) {
            return true;
        }
        char cCharAt = lowerCase.charAt(16);
        return cCharAt == '+' || cCharAt == ';';
    }

    public static <T> boolean r(Iterable<T> iterable, T t10) {
        if (iterable instanceof Collection) {
            try {
                return ((Collection) iterable).contains(t10);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (c1.b0.a(it.next(), t10)) {
                return true;
            }
        }
        return false;
    }

    public static vj.y2 s(vj.y2 y2Var) {
        c1.h0.d(y2Var != null);
        if (!f19356b.contains(y2Var.f17568a)) {
            return y2Var;
        }
        return vj.y2.f17562s.u("Inappropriate status code from control plane: " + y2Var.f17568a + " " + y2Var.f17569b).t(y2Var.f17570c);
    }

    public static boolean t(vj.e eVar) {
        return !Boolean.TRUE.equals(eVar.j(I));
    }
}
