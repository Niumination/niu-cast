package cf;

import af.d2;
import af.d6;
import af.h6;
import af.k2;
import af.l1;
import af.l6;
import af.n2;
import af.o5;
import af.p2;
import af.q2;
import af.q3;
import af.r1;
import af.t1;
import af.v1;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import k3.sc;
import k3.t8;
import k3.v8;
import kotlin.UByte;
import kotlin.text.Typography;
import ze.p1;
import ze.q1;
import ze.r0;
import ze.r2;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements af.j0, d, m0 {
    public static final Map P;
    public static final Logger Q;
    public final SocketFactory A;
    public final SSLSocketFactory B;
    public int C;
    public final LinkedList D;
    public final df.c E;
    public q2 F;
    public boolean G;
    public long H;
    public long I;
    public final af.f J;
    public final int K;
    public final l6 L;
    public final v1 M;
    public final ze.i0 N;
    public final int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f1611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f1614d;
    public final k2 e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ef.m f1615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d2 f1616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f1617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o0 f1618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f1619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r0 f1620l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1621m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap f1622n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Executor f1623o;
    public final o5 p;
    public final ScheduledExecutorService q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f1624r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1625s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public p f1626t;
    public ze.b u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ze.q2 f1627v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1628w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public r1 f1629x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1630y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1631z;

    static {
        EnumMap enumMap = new EnumMap(ef.a.class);
        ef.a aVar = ef.a.NO_ERROR;
        ze.q2 q2Var = ze.q2.f11410m;
        enumMap.put(aVar, q2Var.h("No error: A GRPC status of OK should have been sent"));
        enumMap.put(ef.a.PROTOCOL_ERROR, q2Var.h("Protocol error"));
        enumMap.put(ef.a.INTERNAL_ERROR, q2Var.h("Internal error"));
        enumMap.put(ef.a.FLOW_CONTROL_ERROR, q2Var.h("Flow control error"));
        enumMap.put(ef.a.STREAM_CLOSED, q2Var.h("Stream closed"));
        enumMap.put(ef.a.FRAME_TOO_LARGE, q2Var.h("Frame too large"));
        enumMap.put(ef.a.REFUSED_STREAM, ze.q2.f11411n.h("Refused stream"));
        enumMap.put(ef.a.CANCEL, ze.q2.f.h("Cancelled"));
        enumMap.put(ef.a.COMPRESSION_ERROR, q2Var.h("Compression error"));
        enumMap.put(ef.a.CONNECT_ERROR, q2Var.h("Connect error"));
        enumMap.put(ef.a.ENHANCE_YOUR_CALM, ze.q2.f11408k.h("Enhance your calm"));
        enumMap.put(ef.a.INADEQUATE_SECURITY, ze.q2.f11406i.h("Inadequate security"));
        P = Collections.unmodifiableMap(enumMap);
        Q = Logger.getLogger(q.class.getName());
    }

    public q(j jVar, InetSocketAddress inetSocketAddress, String str, ze.b bVar, ze.i0 i0Var, af.f fVar) {
        k2 k2Var = l1.f426v;
        ef.m mVar = new ef.m();
        this.f1614d = new Random();
        Object obj = new Object();
        this.f1619k = obj;
        this.f1622n = new HashMap();
        this.C = 0;
        this.D = new LinkedList();
        this.M = new v1(this, 2);
        this.O = 30000;
        v8.i(inetSocketAddress, "address");
        this.f1611a = inetSocketAddress;
        this.f1612b = str;
        this.f1624r = jVar.f1563j;
        this.f = jVar.f1567n;
        Executor executor = jVar.f1558b;
        v8.i(executor, "executor");
        this.f1623o = executor;
        this.p = new o5(jVar.f1558b);
        ScheduledExecutorService scheduledExecutorService = jVar.f1560d;
        v8.i(scheduledExecutorService, "scheduledExecutorService");
        this.q = scheduledExecutorService;
        this.f1621m = 3;
        this.A = SocketFactory.getDefault();
        this.B = jVar.f1561h;
        df.c cVar = jVar.f1562i;
        v8.i(cVar, "connectionSpec");
        this.E = cVar;
        v8.i(k2Var, "stopwatchFactory");
        this.e = k2Var;
        this.f1615g = mVar;
        this.f1613c = "grpc-java-okhttp/1.60.0";
        this.N = i0Var;
        this.J = fVar;
        this.K = jVar.f1568o;
        jVar.e.getClass();
        this.L = new l6();
        this.f1620l = r0.a(q.class, inetSocketAddress.toString());
        ze.b bVar2 = ze.b.f11321b;
        ze.a aVar = d6.f222b;
        IdentityHashMap identityHashMap = new IdentityHashMap(1);
        identityHashMap.put(aVar, bVar);
        for (Map.Entry entry : bVar2.f11322a.entrySet()) {
            if (!identityHashMap.containsKey(entry.getKey())) {
                identityHashMap.put((ze.a) entry.getKey(), entry.getValue());
            }
        }
        this.u = new ze.b(identityHashMap);
        synchronized (obj) {
        }
    }

    public static void h(q qVar, ef.a aVar, String str) {
        qVar.getClass();
        qVar.r(0, aVar, v(aVar).a(str));
    }

    public static Socket i(q qVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws r2 {
        qVar.getClass();
        Socket socket = null;
        try {
            InetAddress address = inetSocketAddress2.getAddress();
            SocketFactory socketFactory = qVar.A;
            Socket socketCreateSocket = address != null ? socketFactory.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : socketFactory.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            try {
                socketCreateSocket.setTcpNoDelay(true);
                socketCreateSocket.setSoTimeout(qVar.O);
                qj.d dVarF = sc.f(socketCreateSocket);
                qj.s sVarA = sc.a(sc.d(socketCreateSocket));
                i1.a aVarJ = qVar.j(inetSocketAddress, str, str2);
                se.e eVar = (se.e) aVarJ.f5525c;
                ff.a aVar = (ff.a) aVarJ.f5524b;
                Locale locale = Locale.US;
                sVarA.v("CONNECT " + aVar.f5031a + ":" + aVar.f5032b + " HTTP/1.1");
                sVarA.v("\r\n");
                int length = ((String[]) eVar.f9720b).length / 2;
                for (int i8 = 0; i8 < length; i8++) {
                    int i9 = i8 * 2;
                    String[] strArr = (String[]) eVar.f9720b;
                    sVarA.v((i9 < 0 || i9 >= strArr.length) ? null : strArr[i9]);
                    sVarA.v(": ");
                    int i10 = i9 + 1;
                    sVarA.v((i10 < 0 || i10 >= strArr.length) ? null : strArr[i10]);
                    sVarA.v("\r\n");
                }
                sVarA.v("\r\n");
                sVarA.flush();
                df.m mVarG = df.m.g(p(dVarF));
                while (!p(dVarF).equals("")) {
                }
                int i11 = mVarG.f4459c;
                if (i11 >= 200 && i11 < 300) {
                    socketCreateSocket.setSoTimeout(0);
                    return socketCreateSocket;
                }
                qj.f fVar = new qj.f();
                try {
                    socketCreateSocket.shutdownOutput();
                    dVarF.W(fVar, 1024L);
                } catch (IOException e) {
                    fVar.m0("Unable to read body: " + e.toString());
                }
                try {
                    socketCreateSocket.close();
                } catch (IOException unused) {
                }
                Locale locale2 = Locale.US;
                throw new r2(ze.q2.f11411n.h("Response returned from proxy was not successful (expected 2xx, got " + i11 + " " + ((String) mVarG.f4458b) + "). Response body:\n" + fVar.w()));
            } catch (IOException e4) {
                e = e4;
                socket = socketCreateSocket;
                if (socket != null) {
                    l1.b(socket);
                }
                throw new r2(ze.q2.f11411n.h("Failed trying to connect with proxy").g(e));
            }
        } catch (IOException e10) {
            e = e10;
        }
    }

    public static String p(qj.d dVar) throws EOFException {
        qj.f fVar = new qj.f();
        while (dVar.W(fVar, 1L) != -1) {
            if (fVar.k(fVar.f9195b - 1) == 10) {
                if (Long.MAX_VALUE < 0) {
                    throw new IllegalArgumentException(o.d.j("limit < 0: ", Long.MAX_VALUE).toString());
                }
                long j8 = Long.MAX_VALUE != Long.MAX_VALUE ? Long.MAX_VALUE + 1 : Long.MAX_VALUE;
                long jL = fVar.l((byte) 10, 0L, j8);
                if (jL != -1) {
                    return rj.a.a(fVar, jL);
                }
                if (j8 < fVar.f9195b && fVar.k(j8 - 1) == 13 && fVar.k(j8) == 10) {
                    return rj.a.a(fVar, j8);
                }
                qj.f fVar2 = new qj.f();
                fVar.i(fVar2, 0L, Math.min(32, fVar.f9195b));
                throw new EOFException("\\n not found: limit=" + Math.min(fVar.f9195b, Long.MAX_VALUE) + " content=" + fVar2.o(fVar2.f9195b).hex() + Typography.ellipsis);
            }
        }
        throw new EOFException("\\n not found: " + fVar.o(fVar.f9195b).hex());
    }

    public static ze.q2 v(ef.a aVar) {
        ze.q2 q2Var = (ze.q2) P.get(aVar);
        if (q2Var != null) {
            return q2Var;
        }
        return ze.q2.f11404g.h("Unknown http2 error code: " + aVar.httpCode);
    }

    @Override // af.r3
    public final void a(ze.q2 q2Var) {
        c(q2Var);
        synchronized (this.f1619k) {
            try {
                Iterator it = this.f1622n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    it.remove();
                    ((n) entry.getValue()).f1600n.s(q2Var, new p1(), false);
                    o((n) entry.getValue());
                }
                for (n nVar : this.D) {
                    nVar.f1600n.r(q2Var, af.c0.MISCARRIED, true, new p1());
                    o(nVar);
                }
                this.D.clear();
                u();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // cf.d
    public final void b(Exception exc) {
        r(0, ef.a.INTERNAL_ERROR, ze.q2.f11411n.g(exc));
    }

    @Override // af.r3
    public final void c(ze.q2 q2Var) {
        synchronized (this.f1619k) {
            try {
                if (this.f1627v != null) {
                    return;
                }
                this.f1627v = q2Var;
                this.f1616h.i(q2Var);
                u();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ze.q0
    public final r0 d() {
        return this.f1620l;
    }

    @Override // cf.m0
    public final l0[] e() {
        l0[] l0VarArr;
        l0 l0Var;
        synchronized (this.f1619k) {
            l0VarArr = new l0[this.f1622n.size()];
            Iterator it = this.f1622n.values().iterator();
            int i8 = 0;
            while (it.hasNext()) {
                int i9 = i8 + 1;
                m mVar = ((n) it.next()).f1600n;
                synchronized (mVar.f1591w) {
                    l0Var = mVar.J;
                }
                l0VarArr[i8] = l0Var;
                i8 = i9;
            }
        }
        return l0VarArr;
    }

    @Override // af.e0
    public final af.b0 f(ze.r1 r1Var, p1 p1Var, ze.f fVar, ze.n[] nVarArr) {
        n nVar;
        v8.i(r1Var, "method");
        v8.i(p1Var, "headers");
        ze.b bVar = this.u;
        h6 h6Var = new h6(nVarArr);
        for (ze.n nVar2 : nVarArr) {
            nVar2.n(bVar, p1Var);
        }
        synchronized (this.f1619k) {
            nVar = new n(r1Var, p1Var, this.f1617i, this, this.f1618j, this.f1619k, this.f1624r, this.f, this.f1612b, this.f1613c, h6Var, this.L, fVar);
        }
        return nVar;
    }

    @Override // af.r3
    public final Runnable g(q3 q3Var) {
        this.f1616h = (d2) q3Var;
        if (this.G) {
            q2 q2Var = new q2(new tj.w(this, 2), this.q, this.H, this.I, false);
            this.F = q2Var;
            synchronized (q2Var) {
                if (q2Var.f530d) {
                    q2Var.b();
                }
            }
        }
        c cVar = new c(this.p, this);
        ef.m mVar = this.f1615g;
        qj.s sVarA = sc.a(cVar);
        mVar.getClass();
        b bVar = new b(cVar, new ef.l(sVarA, true), 0);
        synchronized (this.f1619k) {
            e eVar = new e(this, bVar);
            this.f1617i = eVar;
            this.f1618j = new o0(this, eVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.p.execute(new af.m0(this, 4, countDownLatch, cVar));
        try {
            q();
            countDownLatch.countDown();
            this.p.execute(new af.f(this, 14));
            return null;
        } catch (Throwable th2) {
            countDownLatch.countDown();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0195 A[EDGE_INSN: B:107:0x0195->B:159:0x023f BREAK  A[LOOP:9: B:146:0x021c->B:157:0x023b]] */
    /* JADX WARN: Code duplicated, block: B:108:0x0198  */
    /* JADX WARN: Code duplicated, block: B:110:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:113:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:115:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:122:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:127:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:134:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:137:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:19:0x005e  */
    /* JADX WARN: Code duplicated, block: B:205:0x012c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x0151 A[EDGE_INSN: B:212:0x0151->B:92:0x0151 BREAK  A[LOOP:3: B:87:0x013b->B:91:0x0149], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:0x01c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x012c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:80:0x0119 A[LOOP:7: B:52:0x00d2->B:80:0x0119, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:88:0x013d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0149 A[LOOP:3: B:87:0x013b->B:91:0x0149, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:94:0x0155  */
    public final i1.a j(InetSocketAddress inetSocketAddress, String str, String str2) {
        String strSubstring;
        String strW;
        int i8;
        int i9;
        InetAddress byAddress;
        byte[] address;
        int i10;
        int i11;
        int i12;
        int i13;
        qj.f fVar;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        char cCharAt;
        int i20;
        int i21;
        int i22;
        int iA;
        int i23;
        df.m mVar = new df.m(1);
        mVar.f4459c = -1;
        mVar.f4458b = "https";
        String hostName = inetSocketAddress.getHostName();
        if (hostName == null) {
            throw new IllegalArgumentException("host == null");
        }
        int length = hostName.length();
        int i24 = 0;
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= length) {
                strSubstring = hostName.substring(0, length);
                break;
            }
            if (hostName.charAt(iCharCount) == '%') {
                qj.f fVar2 = new qj.f();
                fVar2.l0(0, iCharCount, hostName);
                while (iCharCount < length) {
                    int iCodePointAt = hostName.codePointAt(iCharCount);
                    if (iCodePointAt != 37 || (i23 = iCharCount + 2) >= length) {
                        fVar2.n0(iCodePointAt);
                    } else {
                        int iA2 = ff.a.a(hostName.charAt(iCharCount + 1));
                        int iA3 = ff.a.a(hostName.charAt(i23));
                        if (iA2 == -1 || iA3 == -1) {
                            fVar2.n0(iCodePointAt);
                        } else {
                            fVar2.S((iA2 << 4) + iA3);
                            iCharCount = i23;
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                }
                strSubstring = fVar2.w();
                break;
            }
            iCharCount++;
        }
        if (!strSubstring.startsWith("[") || !strSubstring.endsWith("]")) {
            try {
                String lowerCase = IDN.toASCII(strSubstring).toLowerCase(Locale.US);
                if (!lowerCase.isEmpty()) {
                    int i25 = 0;
                    while (true) {
                        if (i25 >= lowerCase.length()) {
                            strW = lowerCase;
                            break;
                        }
                        char cCharAt2 = lowerCase.charAt(i25);
                        if (cCharAt2 > 31 && cCharAt2 < 127 && " #%/:?@[\\]".indexOf(cCharAt2) == -1) {
                            i25++;
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            strW = null;
            break;
        }
        int length2 = strSubstring.length() - 1;
        int i26 = 16;
        byte[] bArr = new byte[16];
        int i27 = -1;
        int i28 = -1;
        int i29 = 0;
        int i30 = 1;
        while (true) {
            try {
                if (i30 < length2) {
                    if (i29 != i26) {
                        int i31 = i30 + 2;
                        if (i31 > length2 || !strSubstring.regionMatches(i30, "::", i24, 2)) {
                            if (i29 == 0) {
                                i20 = i30;
                                i21 = 0;
                                while (i20 < length2) {
                                    iA = ff.a.a(strSubstring.charAt(i20));
                                    if (iA == -1) {
                                        break;
                                        break;
                                    }
                                    i21 = (i21 << 4) + iA;
                                    i20++;
                                }
                                i22 = i20 - i30;
                                if (i22 == 0) {
                                }
                            } else if (strSubstring.regionMatches(i30, ":", i24, 1)) {
                                i30++;
                                i20 = i30;
                                i21 = 0;
                                while (i20 < length2) {
                                    iA = ff.a.a(strSubstring.charAt(i20));
                                    if (iA == -1) {
                                        break;
                                    }
                                    i21 = (i21 << 4) + iA;
                                    i20++;
                                }
                                i22 = i20 - i30;
                                if (i22 == 0 && i22 <= 4) {
                                    int i32 = i29 + 1;
                                    bArr[i29] = (byte) (255 & (i21 >>> 8));
                                    i29 += 2;
                                    bArr[i32] = (byte) (i21 & 255);
                                    i28 = i30;
                                    i30 = i20;
                                    i24 = 0;
                                    i26 = 16;
                                }
                            } else {
                                if (strSubstring.regionMatches(i30, ".", i24, 1)) {
                                    int i33 = i29 - 2;
                                    int i34 = i33;
                                    int i35 = i28;
                                    while (true) {
                                        if (i35 >= length2) {
                                            int i36 = i27;
                                            if (i34 == i29 + 2) {
                                                i29 += 2;
                                                i27 = i36;
                                                i8 = 16;
                                            }
                                        } else if (i34 != 16) {
                                            if (i34 == i33) {
                                                i16 = i35;
                                                i17 = 0;
                                                while (true) {
                                                    i18 = i33;
                                                    if (i16 < length2) {
                                                        cCharAt = strSubstring.charAt(i16);
                                                        i19 = i27;
                                                        if (cCharAt < '0' && cCharAt <= '9') {
                                                            if ((i17 != 0 || i35 == i16) && (i17 = ((i17 * 10) + cCharAt) - 48) <= 255) {
                                                                i16++;
                                                                i33 = i18;
                                                                i27 = i19;
                                                            }
                                                        }
                                                    } else {
                                                        i19 = i27;
                                                    }
                                                    if (i16 - i35 == 0) {
                                                        bArr[i34] = (byte) i17;
                                                        i34++;
                                                        i35 = i16;
                                                        i33 = i18;
                                                        i27 = i19;
                                                    }
                                                }
                                            } else if (strSubstring.charAt(i35) == '.') {
                                                i35++;
                                                i16 = i35;
                                                i17 = 0;
                                                while (true) {
                                                    i18 = i33;
                                                    if (i16 < length2) {
                                                        cCharAt = strSubstring.charAt(i16);
                                                        i19 = i27;
                                                        if (cCharAt < '0') {
                                                        }
                                                    } else {
                                                        i19 = i27;
                                                    }
                                                    if (i16 - i35 == 0) {
                                                        bArr[i34] = (byte) i17;
                                                        i34++;
                                                        i35 = i16;
                                                        i33 = i18;
                                                        i27 = i19;
                                                    }
                                                    i16++;
                                                    i33 = i18;
                                                    i27 = i19;
                                                }
                                            }
                                        }
                                    }
                                }
                                byAddress = null;
                                if (byAddress == null) {
                                    strW = null;
                                    break;
                                }
                                address = byAddress.getAddress();
                                i10 = 16;
                                if (address.length == 16) {
                                    throw new AssertionError();
                                }
                                i11 = i9;
                                i12 = i11;
                                i13 = -1;
                                while (i11 < address.length) {
                                    i14 = i11;
                                    while (i14 < i10 && address[i14] == 0 && address[i14 + 1] == 0) {
                                        i14 += 2;
                                        i10 = 16;
                                    }
                                    i15 = i14 - i11;
                                    if (i15 > i12) {
                                        i12 = i15;
                                        i13 = i11;
                                    }
                                    i11 = i14 + 2;
                                    i10 = 16;
                                }
                                fVar = new qj.f();
                                while (i9 < address.length) {
                                    if (i9 == i13) {
                                        fVar.S(58);
                                        i9 += i12;
                                        if (i9 == 16) {
                                            fVar.S(58);
                                        }
                                    } else {
                                        if (i9 > 0) {
                                            fVar.S(58);
                                        }
                                        fVar.a0(((address[i9] & UByte.MAX_VALUE) << 8) | (address[i9 + 1] & UByte.MAX_VALUE));
                                        i9 += 2;
                                    }
                                }
                                strW = fVar.w();
                            }
                            i9 = 0;
                            byAddress = null;
                            if (byAddress == null) {
                                strW = null;
                                break;
                            }
                            address = byAddress.getAddress();
                            i10 = 16;
                            if (address.length == 16) {
                                throw new AssertionError();
                            }
                            i11 = i9;
                            i12 = i11;
                            i13 = -1;
                            while (i11 < address.length) {
                                i14 = i11;
                                while (i14 < i10) {
                                    i14 += 2;
                                    i10 = 16;
                                }
                                i15 = i14 - i11;
                                if (i15 > i12) {
                                    i12 = i15;
                                    i13 = i11;
                                }
                                i11 = i14 + 2;
                                i10 = 16;
                            }
                            fVar = new qj.f();
                            while (i9 < address.length) {
                                if (i9 == i13) {
                                    fVar.S(58);
                                    i9 += i12;
                                    if (i9 == 16) {
                                        fVar.S(58);
                                    }
                                } else {
                                    if (i9 > 0) {
                                        fVar.S(58);
                                    }
                                    fVar.a0(((address[i9] & UByte.MAX_VALUE) << 8) | (address[i9 + 1] & UByte.MAX_VALUE));
                                    i9 += 2;
                                }
                            }
                            strW = fVar.w();
                        } else if (i27 == -1) {
                            i29 += 2;
                            if (i31 == length2) {
                                i27 = i29;
                                i8 = 16;
                            } else {
                                i30 = i31;
                                i27 = i29;
                                i20 = i30;
                                i21 = 0;
                                while (i20 < length2) {
                                    iA = ff.a.a(strSubstring.charAt(i20));
                                    if (iA == -1) {
                                        break;
                                        break;
                                    }
                                    i21 = (i21 << 4) + iA;
                                    i20++;
                                }
                                i22 = i20 - i30;
                                if (i22 == 0) {
                                }
                                i9 = 0;
                                byAddress = null;
                                if (byAddress == null) {
                                    strW = null;
                                    break;
                                }
                                address = byAddress.getAddress();
                                i10 = 16;
                                if (address.length == 16) {
                                    throw new AssertionError();
                                }
                                i11 = i9;
                                i12 = i11;
                                i13 = -1;
                                while (i11 < address.length) {
                                    i14 = i11;
                                    while (i14 < i10) {
                                        i14 += 2;
                                        i10 = 16;
                                    }
                                    i15 = i14 - i11;
                                    if (i15 > i12) {
                                        i12 = i15;
                                        i13 = i11;
                                    }
                                    i11 = i14 + 2;
                                    i10 = 16;
                                }
                                fVar = new qj.f();
                                while (i9 < address.length) {
                                    if (i9 == i13) {
                                        fVar.S(58);
                                        i9 += i12;
                                        if (i9 == 16) {
                                            fVar.S(58);
                                        }
                                    } else {
                                        if (i9 > 0) {
                                            fVar.S(58);
                                        }
                                        fVar.a0(((address[i9] & UByte.MAX_VALUE) << 8) | (address[i9 + 1] & UByte.MAX_VALUE));
                                        i9 += 2;
                                    }
                                }
                                strW = fVar.w();
                            }
                        }
                    }
                    i9 = i24;
                    byAddress = null;
                    if (byAddress == null) {
                        strW = null;
                        break;
                    }
                    address = byAddress.getAddress();
                    i10 = 16;
                    if (address.length == 16) {
                        throw new AssertionError();
                    }
                    i11 = i9;
                    i12 = i11;
                    i13 = -1;
                    while (i11 < address.length) {
                        i14 = i11;
                        while (i14 < i10) {
                            i14 += 2;
                            i10 = 16;
                        }
                        i15 = i14 - i11;
                        if (i15 > i12) {
                            i12 = i15;
                            i13 = i11;
                        }
                        i11 = i14 + 2;
                        i10 = 16;
                    }
                    fVar = new qj.f();
                    while (i9 < address.length) {
                        if (i9 == i13) {
                            fVar.S(58);
                            i9 += i12;
                            if (i9 == 16) {
                                fVar.S(58);
                            }
                        } else {
                            if (i9 > 0) {
                                fVar.S(58);
                            }
                            fVar.a0(((address[i9] & UByte.MAX_VALUE) << 8) | (address[i9 + 1] & UByte.MAX_VALUE));
                            i9 += 2;
                        }
                    }
                    strW = fVar.w();
                } else {
                    i8 = i26;
                }
                if (i29 != i8) {
                    if (i27 != -1) {
                        int i37 = i29 - i27;
                        System.arraycopy(bArr, i27, bArr, 16 - i37, i37);
                        i9 = 0;
                        Arrays.fill(bArr, i27, (16 - i29) + i27, (byte) 0);
                    }
                    i9 = 0;
                    byAddress = null;
                    if (byAddress == null) {
                        strW = null;
                        break;
                    }
                    address = byAddress.getAddress();
                    i10 = 16;
                    if (address.length == 16) {
                        throw new AssertionError();
                    }
                    i11 = i9;
                    i12 = i11;
                    i13 = -1;
                    while (i11 < address.length) {
                        i14 = i11;
                        while (i14 < i10) {
                            i14 += 2;
                            i10 = 16;
                        }
                        i15 = i14 - i11;
                        if (i15 > i12) {
                            i12 = i15;
                            i13 = i11;
                        }
                        i11 = i14 + 2;
                        i10 = 16;
                    }
                    fVar = new qj.f();
                    while (i9 < address.length) {
                        if (i9 == i13) {
                            fVar.S(58);
                            i9 += i12;
                            if (i9 == 16) {
                                fVar.S(58);
                            }
                        } else {
                            if (i9 > 0) {
                                fVar.S(58);
                            }
                            fVar.a0(((address[i9] & UByte.MAX_VALUE) << 8) | (address[i9 + 1] & UByte.MAX_VALUE));
                            i9 += 2;
                        }
                    }
                    strW = fVar.w();
                } else {
                    i9 = 0;
                }
                byAddress = InetAddress.getByAddress(bArr);
                if (byAddress == null) {
                    strW = null;
                    break;
                }
                address = byAddress.getAddress();
                i10 = 16;
                if (address.length == 16) {
                    throw new AssertionError();
                }
                i11 = i9;
                i12 = i11;
                i13 = -1;
                while (i11 < address.length) {
                    i14 = i11;
                    while (i14 < i10) {
                        i14 += 2;
                        i10 = 16;
                    }
                    i15 = i14 - i11;
                    if (i15 > i12) {
                        i12 = i15;
                        i13 = i11;
                    }
                    i11 = i14 + 2;
                    i10 = 16;
                }
                fVar = new qj.f();
                while (i9 < address.length) {
                    if (i9 == i13) {
                        fVar.S(58);
                        i9 += i12;
                        if (i9 == 16) {
                            fVar.S(58);
                        }
                    } else {
                        if (i9 > 0) {
                            fVar.S(58);
                        }
                        fVar.a0(((address[i9] & UByte.MAX_VALUE) << 8) | (address[i9 + 1] & UByte.MAX_VALUE));
                        i9 += 2;
                    }
                }
                strW = fVar.w();
            } catch (UnknownHostException unused2) {
                throw new AssertionError();
            }
        }
        if (strW == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(hostName));
        }
        mVar.f4460d = strW;
        int port = inetSocketAddress.getPort();
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException(a1.a.o(port, "unexpected port: "));
        }
        mVar.f4459c = port;
        if (((String) mVar.f4458b) == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (((String) mVar.f4460d) == null) {
            throw new IllegalStateException("host == null");
        }
        ff.a aVar = new ff.a(mVar);
        f5.a aVar2 = new f5.a();
        aVar2.f4985b = new t1(1);
        aVar2.f4984a = aVar;
        aVar2.f("Host", aVar.f5031a + ":" + aVar.f5032b);
        aVar2.f("User-Agent", this.f1613c);
        if (str != null && str2 != null) {
            try {
                aVar2.f("Proxy-Authorization", "Basic " + qj.j.of((str + ":" + str2).getBytes("ISO-8859-1")).base64());
            } catch (UnsupportedEncodingException unused3) {
                throw new AssertionError();
            }
        }
        if (((ff.a) aVar2.f4984a) != null) {
            return new i1.a(aVar2);
        }
        throw new IllegalStateException("url == null");
    }

    public final void k(int i8, ze.q2 q2Var, af.c0 c0Var, boolean z2, ef.a aVar, p1 p1Var) {
        synchronized (this.f1619k) {
            try {
                n nVar = (n) this.f1622n.remove(Integer.valueOf(i8));
                if (nVar != null) {
                    if (aVar != null) {
                        this.f1617i.f(i8, ef.a.CANCEL);
                    }
                    if (q2Var != null) {
                        m mVar = nVar.f1600n;
                        if (p1Var == null) {
                            p1Var = new p1();
                        }
                        mVar.r(q2Var, c0Var, z2, p1Var);
                    }
                    if (!s()) {
                        u();
                        o(nVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final int l() {
        URI uriA = l1.a(this.f1612b);
        return uriA.getPort() != -1 ? uriA.getPort() : this.f1611a.getPort();
    }

    public final r2 m() {
        synchronized (this.f1619k) {
            try {
                ze.q2 q2Var = this.f1627v;
                if (q2Var != null) {
                    return new r2(q2Var);
                }
                return new r2(ze.q2.f11411n.h("Connection closed"));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000c  */
    public final boolean n(int i8) {
        boolean z2;
        synchronized (this.f1619k) {
            if (i8 < this.f1621m) {
                z2 = true;
                if ((i8 & 1) != 1) {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    public final void o(n nVar) {
        if (this.f1631z && this.D.isEmpty() && this.f1622n.isEmpty()) {
            this.f1631z = false;
            q2 q2Var = this.F;
            if (q2Var != null) {
                synchronized (q2Var) {
                    try {
                        if (!q2Var.f530d) {
                            p2 p2Var = q2Var.e;
                            if (p2Var == p2.PING_SCHEDULED || p2Var == p2.PING_DELAYED) {
                                q2Var.e = p2.IDLE;
                            }
                            if (q2Var.e == p2.PING_SENT) {
                                q2Var.e = p2.IDLE_AND_PING_SENT;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
        if (nVar.e) {
            this.M.l(nVar, false);
        }
    }

    public final void q() {
        synchronized (this.f1619k) {
            try {
                this.f1617i.r();
                ef.o oVar = new ef.o();
                oVar.c(7, this.f);
                this.f1617i.e(oVar);
                int i8 = this.f;
                if (i8 > 65535) {
                    this.f1617i.d(0, i8 - 65535);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void r(int i8, ef.a aVar, ze.q2 q2Var) {
        synchronized (this.f1619k) {
            try {
                if (this.f1627v == null) {
                    this.f1627v = q2Var;
                    this.f1616h.i(q2Var);
                }
                if (aVar != null && !this.f1628w) {
                    this.f1628w = true;
                    this.f1617i.c0(0, aVar, new byte[0]);
                }
                Iterator it = this.f1622n.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() > i8) {
                        it.remove();
                        ((n) entry.getValue()).f1600n.r(q2Var, af.c0.REFUSED, false, new p1());
                        o((n) entry.getValue());
                    }
                }
                for (n nVar : this.D) {
                    nVar.f1600n.r(q2Var, af.c0.MISCARRIED, true, new p1());
                    o(nVar);
                }
                this.D.clear();
                u();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean s() {
        boolean z2 = false;
        while (true) {
            LinkedList linkedList = this.D;
            if (linkedList.isEmpty() || this.f1622n.size() >= this.C) {
                break;
            }
            t((n) linkedList.poll());
            z2 = true;
        }
        return z2;
    }

    public final void t(n nVar) {
        v8.n(nVar.f1600n.K == -1, "StreamId already assigned");
        this.f1622n.put(Integer.valueOf(this.f1621m), nVar);
        if (!this.f1631z) {
            this.f1631z = true;
            q2 q2Var = this.F;
            if (q2Var != null) {
                q2Var.b();
            }
        }
        if (nVar.e) {
            this.M.l(nVar, true);
        }
        nVar.f1600n.y(this.f1621m);
        q1 q1Var = nVar.f1596j.f11422a;
        if ((q1Var != q1.UNARY && q1Var != q1.SERVER_STREAMING) || nVar.q) {
            this.f1617i.flush();
        }
        int i8 = this.f1621m;
        if (i8 < 2147483645) {
            this.f1621m = i8 + 2;
        } else {
            this.f1621m = Integer.MAX_VALUE;
            r(Integer.MAX_VALUE, ef.a.NO_ERROR, ze.q2.f11411n.h("Stream ids exhausted"));
        }
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.e("logId", this.f1620l.f11421c);
        aVarA.d(this.f1611a, "address");
        return aVarA.toString();
    }

    public final void u() {
        if (this.f1627v == null || !this.f1622n.isEmpty() || !this.D.isEmpty() || this.f1630y) {
            return;
        }
        this.f1630y = true;
        q2 q2Var = this.F;
        if (q2Var != null) {
            q2Var.c();
        }
        r1 r1Var = this.f1629x;
        if (r1Var != null) {
            r2 r2VarM = m();
            synchronized (r1Var) {
                try {
                    if (!r1Var.f548d) {
                        r1Var.f548d = true;
                        r1Var.e = r2VarM;
                        LinkedHashMap linkedHashMap = r1Var.f547c;
                        r1Var.f547c = null;
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            try {
                                ((Executor) entry.getValue()).execute(new af.q1((n2) entry.getKey(), r2VarM));
                            } catch (Throwable th2) {
                                r1.f544g.log(Level.SEVERE, "Failed to execute PingCallback", th2);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            this.f1629x = null;
        }
        if (!this.f1628w) {
            this.f1628w = true;
            this.f1617i.c0(0, ef.a.NO_ERROR, new byte[0]);
        }
        this.f1617i.close();
    }
}
