package mk;

import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import fl.a1;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kn.l0;
import lm.i0;
import nq.n1;
import tl.d1;
import tl.u0;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final c f10766i = new c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final byte[] f10767j = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final k f10769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final byte[] f10770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final n1 f10771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f10773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final ByteBuffer f10775h;

    public static final class a extends g {
        public /* synthetic */ a(boolean z10, byte[] bArr, boolean z11, boolean z12, boolean z13, int i10, kn.w wVar) {
            this(z10, bArr, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) != 0 ? false : z13);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, @os.l byte[] bArr, boolean z11, boolean z12, boolean z13) {
            super(z10, k.BINARY, bArr, l.f10801a, z11, z12, z13);
            l0.p(bArr, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, @os.l ByteBuffer byteBuffer) {
            this(z10, a1.i(byteBuffer));
            l0.p(byteBuffer, "buffer");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, @os.l byte[] bArr) {
            this(z10, bArr, false, false, false);
            l0.p(bArr, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(boolean z10, @os.l tl.v vVar) {
            this(z10, d1.i(vVar, 0, 1, null));
            l0.p(vVar, "packet");
        }
    }

    public static final class c {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10776a;

            static {
                int[] iArr = new int[k.values().length];
                iArr[k.BINARY.ordinal()] = 1;
                iArr[k.TEXT.ordinal()] = 2;
                iArr[k.CLOSE.ordinal()] = 3;
                iArr[k.PING.ordinal()] = 4;
                iArr[k.PONG.ordinal()] = 5;
                f10776a = iArr;
            }
        }

        public c() {
        }

        @os.l
        public final g a(boolean z10, @os.l k kVar, @os.l ByteBuffer byteBuffer) {
            l0.p(kVar, "frameType");
            l0.p(byteBuffer, "buffer");
            return b(z10, kVar, a1.i(byteBuffer));
        }

        @os.l
        public final g b(boolean z10, @os.l k kVar, @os.l byte[] bArr) {
            l0.p(kVar, "frameType");
            l0.p(bArr, "data");
            int i10 = a.f10776a[kVar.ordinal()];
            if (i10 == 1) {
                return new a(z10, bArr);
            }
            if (i10 == 2) {
                return new f(z10, bArr);
            }
            if (i10 == 3) {
                return new b(bArr);
            }
            if (i10 == 4) {
                return new d(bArr);
            }
            if (i10 == 5) {
                return new e(bArr, l.f10801a);
            }
            throw new i0();
        }

        @os.l
        public final g c(boolean z10, @os.l k kVar, @os.l byte[] bArr, boolean z11, boolean z12, boolean z13) {
            l0.p(kVar, "frameType");
            l0.p(bArr, "data");
            int i10 = a.f10776a[kVar.ordinal()];
            if (i10 == 1) {
                return new a(z10, bArr, z11, z12, z13);
            }
            if (i10 == 2) {
                return new f(z10, bArr, z11, z12, z13);
            }
            if (i10 == 3) {
                return new b(bArr);
            }
            if (i10 == 4) {
                return new d(bArr);
            }
            if (i10 == 5) {
                return new e(bArr, l.f10801a);
            }
            throw new i0();
        }

        public c(kn.w wVar) {
        }
    }

    public static final class f extends g {
        public /* synthetic */ f(boolean z10, byte[] bArr, boolean z11, boolean z12, boolean z13, int i10, kn.w wVar) {
            this(z10, bArr, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) != 0 ? false : z13);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z10, @os.l byte[] bArr, boolean z11, boolean z12, boolean z13) {
            super(z10, k.TEXT, bArr, l.f10801a, z11, z12, z13);
            l0.p(bArr, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public f(boolean z10, @os.l byte[] bArr) {
            this(z10, bArr, false, false, false);
            l0.p(bArr, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public f(boolean z10, @os.l tl.v vVar) {
            this(z10, d1.i(vVar, 0, 1, null));
            l0.p(vVar, "packet");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public f(boolean z10, @os.l ByteBuffer byteBuffer) {
            this(z10, a1.i(byteBuffer));
            l0.p(byteBuffer, "buffer");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public f(@os.l String str) {
            l0.p(str, "text");
            CharsetEncoder charsetEncoderNewEncoder = jq.f.f8800b.newEncoder();
            l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
            this(true, rl.a.j(charsetEncoderNewEncoder, str, 0, str.length()));
        }
    }

    public /* synthetic */ g(boolean z10, k kVar, byte[] bArr, n1 n1Var, boolean z11, boolean z12, boolean z13, kn.w wVar) {
        this(z10, kVar, bArr, n1Var, z11, z12, z13);
    }

    @os.l
    public final g b() {
        c cVar = f10766i;
        boolean z10 = this.f10768a;
        k kVar = this.f10769b;
        byte[] bArr = this.f10770c;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        return cVar.b(z10, kVar, bArrCopyOf);
    }

    @os.l
    public final ByteBuffer c() {
        return this.f10775h;
    }

    @os.l
    public final byte[] d() {
        return this.f10770c;
    }

    @os.l
    public final n1 e() {
        return this.f10771d;
    }

    public final boolean f() {
        return this.f10768a;
    }

    @os.l
    public final k g() {
        return this.f10769b;
    }

    public final boolean h() {
        return this.f10772e;
    }

    public final boolean i() {
        return this.f10773f;
    }

    public final boolean j() {
        return this.f10774g;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Frame ");
        sb2.append(this.f10769b);
        sb2.append(" (fin=");
        sb2.append(this.f10768a);
        sb2.append(", buffer len = ");
        return u.a.a(sb2, this.f10770c.length, ')');
    }

    public static final class b extends g {
        public b() {
            this(g.f10767j);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l byte[] bArr) {
            super(true, k.CLOSE, bArr, l.f10801a, false, false, false);
            l0.p(bArr, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@os.l tl.v vVar) {
            this(d1.i(vVar, 0, 1, null));
            l0.p(vVar, "packet");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@os.l ByteBuffer byteBuffer) {
            this(a1.i(byteBuffer));
            l0.p(byteBuffer, "buffer");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(@os.l mk.a aVar) {
            l0.p(aVar, HomeKeyReceiver.f2161e);
            tl.s sVarA = w0.a(0);
            try {
                u0.j(sVarA, aVar.f10732a);
                d1.Y(sVarA, aVar.f10733b, 0, 0, null, 14, null);
                this(sVarA.z2());
            } catch (Throwable th2) {
                sVarA.close();
                throw th2;
            }
        }
    }

    public static final class d extends g {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@os.l byte[] bArr) {
            super(true, k.PING, bArr, l.f10801a, false, false, false);
            l0.p(bArr, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public d(@os.l tl.v vVar) {
            this(d1.i(vVar, 0, 1, null));
            l0.p(vVar, "packet");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public d(@os.l ByteBuffer byteBuffer) {
            this(a1.i(byteBuffer));
            l0.p(byteBuffer, "buffer");
        }
    }

    public static final class e extends g {
        public /* synthetic */ e(byte[] bArr, n1 n1Var, int i10, kn.w wVar) {
            this(bArr, (i10 & 2) != 0 ? l.f10801a : n1Var);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@os.l byte[] bArr, @os.l n1 n1Var) {
            super(true, k.PONG, bArr, n1Var, false, false, false);
            l0.p(bArr, "data");
            l0.p(n1Var, "disposableHandle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e(@os.l tl.v vVar) {
            this(d1.i(vVar, 0, 1, null), l.f10801a);
            l0.p(vVar, "packet");
        }

        public /* synthetic */ e(ByteBuffer byteBuffer, n1 n1Var, int i10, kn.w wVar) {
            this(byteBuffer, (i10 & 2) != 0 ? l.f10801a : n1Var);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e(@os.l ByteBuffer byteBuffer, @os.l n1 n1Var) {
            this(a1.i(byteBuffer), n1Var);
            l0.p(byteBuffer, "buffer");
            l0.p(n1Var, "disposableHandle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e(@os.l ByteBuffer byteBuffer) {
            this(a1.i(byteBuffer), l.f10801a);
            l0.p(byteBuffer, "buffer");
        }
    }

    public g(boolean z10, k kVar, byte[] bArr, n1 n1Var, boolean z11, boolean z12, boolean z13) {
        this.f10768a = z10;
        this.f10769b = kVar;
        this.f10770c = bArr;
        this.f10771d = n1Var;
        this.f10772e = z11;
        this.f10773f = z12;
        this.f10774g = z13;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        l0.o(byteBufferWrap, "wrap(data)");
        this.f10775h = byteBufferWrap;
    }

    public /* synthetic */ g(boolean z10, k kVar, byte[] bArr, n1 n1Var, boolean z11, boolean z12, boolean z13, int i10, kn.w wVar) {
        this(z10, kVar, bArr, (i10 & 8) != 0 ? l.f10801a : n1Var, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? false : z12, (i10 & 64) != 0 ? false : z13);
    }
}
