package pl;

import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f13204a = a.f13205a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f13205a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final lm.d0<c> f13206b = lm.f0.b(C0329a.INSTANCE);

        /* JADX INFO: renamed from: pl.k$a$a, reason: collision with other inner class name */
        public static final class C0329a extends kn.n0 implements jn.a<c> {
            public static final C0329a INSTANCE = new C0329a();

            public C0329a() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final c invoke() {
                c cVarC = e.c(false, 1, null);
                o.a(cVarC);
                return cVarC;
            }
        }

        @os.l
        public final k a() {
            return f13206b.getValue();
        }
    }

    public static final class b {

        @xm.f(c = "io.ktor.utils.io.ByteReadChannel$DefaultImpls", f = "ByteReadChannelJVM.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2}, l = {383, 396, 399}, m = "consumeEachBufferRange", n = {"visitor", "$this$consumeEachBufferRange$iv", "continueFlag$iv", "lastChunkReported$iv", "$this$read_u24default$iv$iv", "visitor", "$this$consumeEachBufferRange$iv", "continueFlag$iv", "lastChunkReported$iv", "$this$read_u24default$iv$iv", "buffer$iv$iv", "bytesRead$iv$iv", "cause$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
        public static final class a extends xm.d {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            /* synthetic */ Object result;

            public a(um.d<? super a> dVar) {
                super(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return b.a(null, null, this);
            }
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00af A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ce A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:31:0x00c0, B:33:0x00ce, B:37:0x00e0, B:39:0x00ea, B:43:0x00f3, B:36:0x00d7), top: B:61:0x00c0 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00d7 A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:31:0x00c0, B:33:0x00ce, B:37:0x00e0, B:39:0x00ea, B:43:0x00f3, B:36:0x00d7), top: B:61:0x00c0 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00ea A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:31:0x00c0, B:33:0x00ce, B:37:0x00e0, B:39:0x00ea, B:43:0x00f3, B:36:0x00d7), top: B:61:0x00c0 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:45:0x011f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x0120  */
        /* JADX WARN: Code duplicated, block: B:49:0x0127  */
        /* JADX WARN: Code duplicated, block: B:7:0x0015  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0120 -> B:47:0x0123). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
        public static java.lang.Object a(pl.k r18, jn.p r19, um.d r20) {
            /*
                Method dump skipped, instruction units count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: pl.k.b.a(pl.k, jn.p, um.d):java.lang.Object");
        }

        @lm.k(level = lm.m.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
        public static /* synthetic */ void b() {
        }

        public static /* synthetic */ Object c(k kVar, ByteBuffer byteBuffer, long j10, long j11, long j12, long j13, um.d dVar, int i10, Object obj) {
            if (obj == null) {
                return kVar.d0(byteBuffer, j10, (i10 & 4) != 0 ? 0L : j11, (i10 & 8) != 0 ? 1L : j12, (i10 & 16) != 0 ? Long.MAX_VALUE : j13, dVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peekTo-vHUFkk8");
        }

        public static /* synthetic */ Object d(k kVar, int i10, jn.l lVar, um.d dVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
            }
            if ((i11 & 1) != 0) {
                i10 = 1;
            }
            return kVar.I(i10, lVar, dVar);
        }

        public static /* synthetic */ int e(k kVar, int i10, jn.l lVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAvailable");
            }
            if ((i11 & 1) != 0) {
                i10 = 1;
            }
            return kVar.S(i10, lVar);
        }
    }

    @os.m
    Object B(@os.l um.d<? super Float> dVar);

    @os.m
    Object C(@os.l um.d<? super Short> dVar);

    @os.m
    Object D(@os.l um.d<? super Long> dVar);

    @os.m
    Object E(long j10, int i10, @os.l um.d<? super tl.v> dVar);

    @os.m
    @lm.k(message = "Use read { } instead.")
    @tl.f0
    Object F(@os.l jn.p<? super j0, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar);

    @os.m
    @lm.k(message = "Use read { } instead.")
    <R> Object G(@os.l jn.p<? super d0, ? super um.d<? super R>, ? extends Object> pVar, @os.l um.d<? super R> dVar);

    @os.m
    Object I(int i10, @os.l jn.l<? super ByteBuffer, l2> lVar, @os.l um.d<? super l2> dVar);

    @os.m
    Object K(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar);

    @os.m
    <A extends Appendable> Object O(@os.l A a10, int i10, @os.l um.d<? super Boolean> dVar);

    @os.m
    Object P(long j10, @os.l um.d<? super Long> dVar);

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    /* synthetic */ Object Q(jn.p pVar, um.d dVar);

    @os.l
    tl.q R();

    int S(int i10, @os.l jn.l<? super ByteBuffer, l2> lVar);

    @os.m
    Object T(@os.l um.d<? super Double> dVar);

    long U();

    @lm.k(message = "Use read { } instead.")
    <R> R X(@os.l jn.l<? super b0, ? extends R> lVar);

    @os.m
    Object Y(@os.l um.d<? super l2> dVar);

    @os.m
    Throwable a();

    @os.m
    Object a0(@os.l um.d<? super Byte> dVar);

    boolean c(@os.m Throwable th2);

    @os.m
    Object c0(int i10, @os.l um.d<? super String> dVar);

    int d();

    @os.m
    Object d0(@os.l ByteBuffer byteBuffer, long j10, long j11, long j12, long j13, @os.l um.d<? super Long> dVar);

    boolean e();

    @lm.k(message = "Use read { } instead.")
    @tl.f0
    void i0(@os.l jn.l<? super f0, l2> lVar);

    @os.m
    Object l(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super l2> dVar);

    void m(@os.l tl.q qVar);

    @os.m
    Object n(@os.l tl.o0 o0Var, @os.l um.d<? super Integer> dVar);

    @os.m
    Object n0(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar);

    boolean p0();

    @os.m
    Object r(@os.l um.d<? super Boolean> dVar);

    @os.m
    Object u(int i10, int i11, @os.l um.d<? super tl.v> dVar);

    @os.m
    Object v(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super Integer> dVar);

    @os.m
    Object x(@os.l um.d<? super Integer> dVar);

    @os.m
    Object y(@os.l tl.o0 o0Var, int i10, @os.l um.d<? super l2> dVar);
}
