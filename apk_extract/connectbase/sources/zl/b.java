package zl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.WritableByteChannel;
import kn.k1;
import kn.l0;
import kn.n0;
import lm.l2;
import os.l;
import os.m;
import pl.k;
import xm.d;
import xm.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    @f(c = "io.ktor.utils.io.jvm.nio.WritingKt", f = "Writing.kt", i = {0, 0, 0, 0}, l = {46}, m = "copyTo", n = {"$this$copyTo", "copied", "copy", "limit"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class a extends d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return b.b(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: zl.b$b, reason: collision with other inner class name */
    public static final class C0608b extends n0 implements jn.l<ByteBuffer, l2> {
        final /* synthetic */ WritableByteChannel $channel;
        final /* synthetic */ k1.g $copied;
        final /* synthetic */ long $limit;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0608b(long j10, k1.g gVar, WritableByteChannel writableByteChannel) {
            super(1);
            this.$limit = j10;
            this.$copied = gVar;
            this.$channel = writableByteChannel;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(ByteBuffer byteBuffer) throws IOException {
            invoke2(byteBuffer);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l ByteBuffer byteBuffer) throws IOException {
            l0.p(byteBuffer, "bb");
            long j10 = this.$limit - this.$copied.element;
            if (j10 >= byteBuffer.remaining()) {
                long jWrite = 0;
                while (byteBuffer.hasRemaining()) {
                    jWrite += (long) this.$channel.write(byteBuffer);
                }
                this.$copied.element += jWrite;
                return;
            }
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + ((int) j10));
            while (byteBuffer.hasRemaining()) {
                this.$channel.write(byteBuffer);
            }
            byteBuffer.limit(iLimit);
            this.$copied.element += j10;
        }
    }

    @m
    public static final Object a(@l k kVar, @l Pipe pipe, long j10, @l um.d<? super Long> dVar) {
        Pipe.SinkChannel sinkChannelSink = pipe.sink();
        l0.o(sinkChannelSink, "pipe.sink()");
        return b(kVar, sinkChannelSink, j10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0077 A[PHI: r2 r7 r9 r11
      0x0077: PHI (r2v2 jn.l<? super java.nio.ByteBuffer, lm.l2>) = (r2v1 jn.l<? super java.nio.ByteBuffer, lm.l2>), (r2v3 jn.l<? super java.nio.ByteBuffer, lm.l2>) binds: [B:27:0x006d, B:34:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x0077: PHI (r7v7 pl.k) = (r7v0 pl.k), (r7v8 pl.k) binds: [B:27:0x006d, B:34:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x0077: PHI (r9v2 long) = (r9v0 long), (r9v3 long) binds: [B:27:0x006d, B:34:0x0093] A[DONT_GENERATE, DONT_INLINE]
      0x0077: PHI (r11v10 kn.k1$g) = (r11v5 kn.k1$g), (r11v11 kn.k1$g) binds: [B:27:0x006d, B:34:0x0093] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x007d  */
    /* JADX WARN: Code duplicated, block: B:32:0x008e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008c -> B:33:0x008f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object b(@os.l pl.k r7, @os.l java.nio.channels.WritableByteChannel r8, long r9, @os.l um.d<? super java.lang.Long> r11) {
        /*
            boolean r0 = r11 instanceof zl.b.a
            if (r0 == 0) goto L13
            r0 = r11
            zl.b$a r0 = (zl.b.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            zl.b$a r0 = new zl.b$a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            long r7 = r0.J$0
            java.lang.Object r9 = r0.L$2
            jn.l r9 = (jn.l) r9
            java.lang.Object r10 = r0.L$1
            kn.k1$g r10 = (kn.k1.g) r10
            java.lang.Object r2 = r0.L$0
            pl.k r2 = (pl.k) r2
            lm.d1.n(r11)
            r11 = r10
            r6 = r2
            r2 = r9
            r9 = r7
            r7 = r6
            goto L8f
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            lm.d1.n(r11)
            r4 = 0
            int r11 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r11 < 0) goto L9d
            boolean r11 = r8 instanceof java.nio.channels.SelectableChannel
            if (r11 == 0) goto L61
            r11 = r8
            java.nio.channels.SelectableChannel r11 = (java.nio.channels.SelectableChannel) r11
            boolean r11 = r11.isBlocking()
            if (r11 == 0) goto L59
            goto L61
        L59:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Non-blocking channels are not supported"
            r7.<init>(r8)
            throw r7
        L61:
            boolean r11 = r7.p0()
            if (r11 == 0) goto L6d
            java.lang.Long r7 = new java.lang.Long
            r7.<init>(r4)
            return r7
        L6d:
            kn.k1$g r11 = new kn.k1$g
            r11.<init>()
            zl.b$b r2 = new zl.b$b
            r2.<init>(r9, r11, r8)
        L77:
            long r4 = r11.element
            int r8 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r8 >= 0) goto L95
            r0.L$0 = r7
            r0.L$1 = r11
            r0.L$2 = r2
            r0.J$0 = r9
            r0.label = r3
            r8 = 0
            java.lang.Object r8 = r7.I(r8, r2, r0)
            if (r8 != r1) goto L8f
            return r1
        L8f:
            boolean r8 = r7.p0()
            if (r8 == 0) goto L77
        L95:
            long r7 = r11.element
            java.lang.Long r9 = new java.lang.Long
            r9.<init>(r7)
            return r9
        L9d:
            java.lang.Long r7 = new java.lang.Long
            r7.<init>(r9)
            java.lang.String r8 = "Limit shouldn't be negative: "
            java.lang.String r7 = kn.l0.C(r8, r7)
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zl.b.b(pl.k, java.nio.channels.WritableByteChannel, long, um.d):java.lang.Object");
    }

    public static /* synthetic */ Object c(k kVar, Pipe pipe, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return a(kVar, pipe, j10, dVar);
    }

    public static /* synthetic */ Object d(k kVar, WritableByteChannel writableByteChannel, long j10, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return b(kVar, writableByteChannel, j10, dVar);
    }
}
