package vj;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@gm.c
@hm.b
public final class y2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<y2> f17547d = h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y2 f17548e = b.OK.toStatus();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y2 f17549f = b.CANCELLED.toStatus();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y2 f17550g = b.UNKNOWN.toStatus();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y2 f17551h = b.INVALID_ARGUMENT.toStatus();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y2 f17552i = b.DEADLINE_EXCEEDED.toStatus();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y2 f17553j = b.NOT_FOUND.toStatus();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y2 f17554k = b.ALREADY_EXISTS.toStatus();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final y2 f17555l = b.PERMISSION_DENIED.toStatus();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final y2 f17556m = b.UNAUTHENTICATED.toStatus();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y2 f17557n = b.RESOURCE_EXHAUSTED.toStatus();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y2 f17558o = b.FAILED_PRECONDITION.toStatus();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final y2 f17559p = b.ABORTED.toStatus();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final y2 f17560q = b.OUT_OF_RANGE.toStatus();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final y2 f17561r = b.UNIMPLEMENTED.toStatus();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final y2 f17562s = b.INTERNAL.toStatus();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final y2 f17563t = b.UNAVAILABLE.toStatus();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final y2 f17564u = b.DATA_LOSS.toStatus();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final v1.i<y2> f17565v = v1.i.i("grpc-status", false, new c());

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final v1.m<String> f17566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final v1.i<String> f17567x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f17568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f17570c;

    public enum b {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;
        private final byte[] valueAscii;

        b(int i10) {
            this.value = i10;
            this.valueAscii = Integer.toString(i10).getBytes(c1.f.f1177a);
        }

        public final byte[] a() {
            return this.valueAscii;
        }

        public y2 toStatus() {
            return (y2) y2.f17547d.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    public static final class c implements v1.m<y2> {
        public c() {
        }

        @Override // vj.v1.m
        public byte[] a(y2 y2Var) {
            return y2Var.f17568a.valueAscii;
        }

        @Override // vj.v1.m
        public y2 b(byte[] bArr) {
            return y2.l(bArr);
        }

        public y2 c(byte[] bArr) {
            return y2.l(bArr);
        }

        public byte[] d(y2 y2Var) {
            return y2Var.f17568a.valueAscii;
        }

        public c(a aVar) {
        }
    }

    public static final class d implements v1.m<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f17572a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d() {
        }

        public static boolean c(byte b10) {
            return b10 < 32 || b10 >= 126 || b10 == 37;
        }

        public static String e(byte[] bArr) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
            int i10 = 0;
            while (i10 < bArr.length) {
                if (bArr[i10] == 37 && i10 + 2 < bArr.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i10 + 1, 2, c1.f.f1177a), 16));
                        i10 += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bArr[i10]);
                        i10++;
                    }
                }
                byteBufferAllocate.put(bArr[i10]);
                i10++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), c1.f.f1179c);
        }

        public static byte[] g(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[((bArr.length - i10) * 3) + i10];
            if (i10 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i10);
            }
            int i11 = i10;
            while (i10 < bArr.length) {
                byte b10 = bArr[i10];
                if (c(b10)) {
                    bArr2[i11] = 37;
                    byte[] bArr3 = f17572a;
                    bArr2[i11 + 1] = bArr3[(b10 >> 4) & 15];
                    bArr2[i11 + 2] = bArr3[b10 & c1.c.f1123q];
                    i11 += 3;
                } else {
                    bArr2[i11] = b10;
                    i11++;
                }
                i10++;
            }
            return Arrays.copyOf(bArr2, i11);
        }

        @Override // vj.v1.m
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b10 = bArr[i10];
                if (b10 < 32 || b10 >= 126 || (b10 == 37 && i10 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // vj.v1.m
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(c1.f.f1179c);
            for (int i10 = 0; i10 < bytes.length; i10++) {
                if (c(bytes[i10])) {
                    return g(bytes, i10);
                }
            }
            return bytes;
        }

        public d(a aVar) {
        }
    }

    static {
        d dVar = new d();
        f17566w = dVar;
        f17567x = new v1.l("grpc-message", false, dVar);
    }

    public y2(b bVar) {
        this(bVar, null, null);
    }

    public static List<y2> h() {
        TreeMap treeMap = new TreeMap();
        for (b bVar : b.values()) {
            y2 y2Var = (y2) treeMap.put(Integer.valueOf(bVar.value()), new y2(bVar, null, null));
            if (y2Var != null) {
                throw new IllegalStateException("Code value duplication between " + y2Var.f17568a.name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String i(y2 y2Var) {
        if (y2Var.f17569b == null) {
            return y2Var.f17568a.toString();
        }
        return y2Var.f17568a + ": " + y2Var.f17569b;
    }

    public static y2 j(b bVar) {
        return bVar.toStatus();
    }

    public static y2 k(int i10) {
        if (i10 >= 0) {
            List<y2> list = f17547d;
            if (i10 < list.size()) {
                return list.get(i10);
            }
        }
        return f17550g.u("Unknown code " + i10);
    }

    public static y2 l(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? f17548e : m(bArr);
    }

    public static y2 m(byte[] bArr) {
        int i10;
        byte b10;
        int length = bArr.length;
        char c10 = 1;
        if (length != 1) {
            i10 = (length == 2 && (b10 = bArr[0]) >= 48 && b10 <= 57) ? (b10 - 48) * 10 : 0;
            return f17550g.u("Unknown code ".concat(new String(bArr, c1.f.f1177a)));
        }
        c10 = 0;
        byte b11 = bArr[c10];
        if (b11 >= 48 && b11 <= 57) {
            int i11 = (b11 - 48) + i10;
            List<y2> list = f17547d;
            if (i11 < list.size()) {
                return list.get(i11);
            }
        }
        return f17550g.u("Unknown code ".concat(new String(bArr, c1.f.f1177a)));
    }

    public static y2 n(Throwable th2) {
        for (Throwable cause = (Throwable) c1.h0.F(th2, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof z2) {
                return ((z2) cause).getStatus();
            }
            if (cause instanceof a3) {
                return ((a3) cause).getStatus();
            }
        }
        return f17550g.t(th2);
    }

    @gm.j
    public static v1 s(Throwable th2) {
        for (Throwable cause = (Throwable) c1.h0.F(th2, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof z2) {
                return ((z2) cause).getTrailers();
            }
            if (cause instanceof a3) {
                return ((a3) cause).getTrailers();
            }
        }
        return null;
    }

    public z2 c() {
        return new z2(this);
    }

    public z2 d(@gm.j v1 v1Var) {
        return new z2(this, v1Var);
    }

    public a3 e() {
        return new a3(this);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public a3 f(@gm.j v1 v1Var) {
        return new a3(this, v1Var);
    }

    public y2 g(String str) {
        if (str == null) {
            return this;
        }
        if (this.f17569b == null) {
            return new y2(this.f17568a, str, this.f17570c);
        }
        return new y2(this.f17568a, this.f17569b + "\n" + str, this.f17570c);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @gm.j
    public Throwable o() {
        return this.f17570c;
    }

    public b p() {
        return this.f17568a;
    }

    @gm.j
    public String q() {
        return this.f17569b;
    }

    public boolean r() {
        return b.OK == this.f17568a;
    }

    public y2 t(Throwable th2) {
        return c1.b0.a(this.f17570c, th2) ? this : new y2(this.f17568a, this.f17569b, th2);
    }

    public String toString() {
        c1.z.b bVarJ = c1.z.c(this).j("code", this.f17568a.name()).j("description", this.f17569b);
        Throwable th2 = this.f17570c;
        Object objL = th2;
        if (th2 != null) {
            objL = c1.t0.l(th2);
        }
        return bVarJ.j("cause", objL).toString();
    }

    public y2 u(String str) {
        return c1.b0.a(this.f17569b, str) ? this : new y2(this.f17568a, str, this.f17570c);
    }

    public y2(b bVar, @gm.j String str, @gm.j Throwable th2) {
        this.f17568a = (b) c1.h0.F(bVar, "code");
        this.f17569b = str;
        this.f17570c = th2;
    }
}
