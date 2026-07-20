package dl;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import kn.l0;
import kn.n0;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    @xm.f(c = "io.ktor.server.netty.http2.HttpFrameAdapterKt", f = "HttpFrameAdapter.kt", i = {0, 0, 1, 1, 1, 1}, l = {15, 19}, m = "http2frameLoop", n = {"$this$http2frameLoop", "bc", "$this$http2frameLoop", "bc", "message", t2.a.f15437d}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
    public static final class a extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return b.a(null, null, this);
        }
    }

    /* JADX INFO: renamed from: dl.b$b, reason: collision with other inner class name */
    public static final class C0086b extends n0 implements jn.l<ByteBuffer, l2> {
        final /* synthetic */ ByteBuf $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0086b(ByteBuf byteBuf) {
            super(1);
            this.$content = byteBuf;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(ByteBuffer byteBuffer) {
            invoke2(byteBuffer);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l ByteBuffer byteBuffer) {
            l0.p(byteBuffer, "bb");
            int i10 = this.$content.readableBytes();
            if (byteBuffer.remaining() <= i10) {
                this.$content.readBytes(byteBuffer);
                return;
            }
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i10);
            this.$content.readBytes(byteBuffer);
            byteBuffer.limit(iLimit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0068 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0069  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[Catch: all -> 0x003c, v -> 0x00a4, TryCatch #5 {v -> 0x00a4, all -> 0x003c, blocks: (B:13:0x0036, B:31:0x0077, B:33:0x007d, B:36:0x0098, B:27:0x006a, B:29:0x0072, B:20:0x0050), top: B:53:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:33:0x007d A[Catch: all -> 0x003c, v -> 0x00a4, TryCatch #5 {v -> 0x00a4, all -> 0x003c, blocks: (B:13:0x0036, B:31:0x0077, B:33:0x007d, B:36:0x0098, B:27:0x006a, B:29:0x0072, B:20:0x0050), top: B:53:0x0020 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[LOOP:0: B:31:0x0077->B:61:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r2v4, types: [pl.n] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, pl.n] */
    /* JADX WARN: Type inference failed for: r5v1, types: [pl.n] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object a(@os.l pq.f0<? extends io.netty.handler.codec.http2.Http2DataFrame> r12, @os.l pl.n r13, @os.l um.d<? super lm.l2> r14) {
        /*
            boolean r0 = r14 instanceof dl.b.a
            if (r0 == 0) goto L13
            r0 = r14
            dl.b$a r0 = (dl.b.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            dl.b$a r0 = new dl.b$a
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r12 = r0.L$3
            io.netty.buffer.ByteBuf r12 = (io.netty.buffer.ByteBuf) r12
            java.lang.Object r13 = r0.L$2
            io.netty.handler.codec.http2.Http2DataFrame r13 = (io.netty.handler.codec.http2.Http2DataFrame) r13
            java.lang.Object r2 = r0.L$1
            pl.n r2 = (pl.n) r2
            java.lang.Object r5 = r0.L$0
            pq.f0 r5 = (pq.f0) r5
            lm.d1.n(r14)     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r14 = r13
            r13 = r5
            goto L77
        L3c:
            r12 = move-exception
            goto Lb0
        L3f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L47:
            java.lang.Object r12 = r0.L$1
            r2 = r12
            pl.n r2 = (pl.n) r2
            java.lang.Object r12 = r0.L$0
            pq.f0 r12 = (pq.f0) r12
            lm.d1.n(r14)     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            goto L6a
        L54:
            lm.d1.n(r14)
        L57:
            r0.L$0 = r12     // Catch: java.lang.Throwable -> Lab pq.v -> Lae
            r0.L$1 = r13     // Catch: java.lang.Throwable -> Lab pq.v -> Lae
            r14 = 0
            r0.L$2 = r14     // Catch: java.lang.Throwable -> Lab pq.v -> Lae
            r0.L$3 = r14     // Catch: java.lang.Throwable -> Lab pq.v -> Lae
            r0.label = r4     // Catch: java.lang.Throwable -> Lab pq.v -> Lae
            java.lang.Object r14 = r12.n(r0)     // Catch: java.lang.Throwable -> Lab pq.v -> Lae
            if (r14 != r1) goto L69
            return r1
        L69:
            r2 = r13
        L6a:
            io.netty.handler.codec.http2.Http2DataFrame r14 = (io.netty.handler.codec.http2.Http2DataFrame) r14     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            io.netty.buffer.ByteBuf r13 = r14.content()     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            if (r13 != 0) goto L74
            io.netty.buffer.ByteBuf r13 = io.netty.buffer.Unpooled.EMPTY_BUFFER     // Catch: java.lang.Throwable -> L3c pq.v -> La4
        L74:
            r11 = r13
            r13 = r12
            r12 = r11
        L77:
            int r5 = r12.readableBytes()     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            if (r5 <= 0) goto L98
            dl.b$b r7 = new dl.b$b     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r7.<init>(r12)     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r0.L$0 = r13     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r0.L$2 = r14     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r0.L$3 = r12     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r0.label = r3     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r6 = 0
            r9 = 1
            r10 = 0
            r5 = r2
            r8 = r0
            java.lang.Object r5 = pl.n.a.b(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            if (r5 != r1) goto L77
            return r1
        L98:
            r2.flush()     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            r12.release()     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            boolean r12 = r14.isEndStream()     // Catch: java.lang.Throwable -> L3c pq.v -> La4
            if (r12 == 0) goto La8
        La4:
            pl.o.a(r2)
            goto Lb9
        La8:
            r12 = r13
            r13 = r2
            goto L57
        Lab:
            r12 = move-exception
            r2 = r13
            goto Lb0
        Lae:
            r2 = r13
            goto La4
        Lb0:
            r2.f(r12)     // Catch: java.lang.Throwable -> Lb4
            goto La4
        Lb4:
            r12 = move-exception
            pl.o.a(r2)
            throw r12
        Lb9:
            lm.l2 r12 = lm.l2.f10208a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: dl.b.a(pq.f0, pl.n, um.d):java.lang.Object");
    }
}
