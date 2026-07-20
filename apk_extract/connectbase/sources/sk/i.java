package sk;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import kn.k1;
import lm.d1;
import lm.l2;
import nq.r0;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    @xm.f(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1", f = "CIOReader.kt", i = {0, 1, 2, 3, 3, 4, 4, 5, 5}, l = {da.b.f3634e, y5.a.Z, 108, da.b.f3634e, y5.a.Z, 108}, m = "invokeSuspend", n = {RtspHeaders.Values.TIMEOUT, RtspHeaders.Values.TIMEOUT, RtspHeaders.Values.TIMEOUT, RtspHeaders.Values.TIMEOUT, "$this$withTimeout$iv", RtspHeaders.Values.TIMEOUT, "$this$withTimeout$iv", RtspHeaders.Values.TIMEOUT, "$this$withTimeout$iv"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class a extends xm.o implements jn.p<pl.m0, um.d<? super l2>, Object> {
        final /* synthetic */ pl.c $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ rk.h $selectable;
        final /* synthetic */ rk.j $selector;
        final /* synthetic */ e0.e $socketOptions;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX INFO: renamed from: sk.i$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingDirectImpl$1$timeout$1", f = "CIOReader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0372a extends xm.o implements jn.l<um.d<? super l2>, Object> {
            final /* synthetic */ pl.c $channel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0372a(pl.c cVar, um.d<? super C0372a> dVar) {
                super(1, dVar);
                this.$channel = cVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.l um.d<?> dVar) {
                return new C0372a(this.$channel, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                this.$channel.f(new SocketTimeoutException());
                return l2.f10208a;
            }

            @Override // jn.l
            @os.m
            public final Object invoke(@os.m um.d<? super l2> dVar) {
                return ((C0372a) create(dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rk.h hVar, e0.e eVar, pl.c cVar, ReadableByteChannel readableByteChannel, rk.j jVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$selectable = hVar;
            this.$socketOptions = eVar;
            this.$channel = cVar;
            this.$nioChannel = readableByteChannel;
            this.$selector = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$selectable, this.$socketOptions, this.$channel, this.$nioChannel, this.$selector, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:50:0x0128 A[Catch: all -> 0x0084, PHI: r1 r4 r5 r6 r7
          0x0128: PHI (r1v15 rk.j) = (r1v13 rk.j), (r1v16 rk.j) binds: [B:57:0x0156, B:49:0x0125] A[DONT_GENERATE, DONT_INLINE]
          0x0128: PHI (r4v15 rk.h) = (r4v13 rk.h), (r4v16 rk.h) binds: [B:57:0x0156, B:49:0x0125] A[DONT_GENERATE, DONT_INLINE]
          0x0128: PHI (r5v16 java.nio.channels.ReadableByteChannel) = (r5v14 java.nio.channels.ReadableByteChannel), (r5v17 java.nio.channels.ReadableByteChannel) binds: [B:57:0x0156, B:49:0x0125] A[DONT_GENERATE, DONT_INLINE]
          0x0128: PHI (r6v14 pl.c) = (r6v12 pl.c), (r6v15 pl.c) binds: [B:57:0x0156, B:49:0x0125] A[DONT_GENERATE, DONT_INLINE]
          0x0128: PHI (r7v15 tk.d) = (r7v13 tk.d), (r7v16 tk.d) binds: [B:57:0x0156, B:49:0x0125] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0084, blocks: (B:79:0x01bb, B:37:0x00ee, B:39:0x00f6, B:41:0x0100, B:44:0x0116, B:46:0x011e, B:49:0x0125, B:50:0x0128, B:53:0x013c, B:56:0x0150, B:59:0x0159, B:85:0x01cb, B:87:0x01d3, B:93:0x01ea, B:84:0x01c8, B:80:0x01c1, B:81:0x01c4, B:18:0x007f, B:23:0x009b, B:26:0x00b4, B:29:0x00c0, B:34:0x00d7, B:32:0x00ce, B:7:0x0029, B:76:0x01b1, B:70:0x0185, B:73:0x019b, B:78:0x01b9, B:60:0x015c, B:64:0x0173, B:66:0x017b, B:69:0x0182, B:12:0x0049, B:15:0x0066), top: B:102:0x0006, inners: #3 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x013b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:55:0x014f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x0158  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x011e -> B:37:0x00ee). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0124 -> B:37:0x00ee). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0156 -> B:50:0x0128). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0158 -> B:37:0x00ee). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x017b -> B:78:0x01b9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0181 -> B:78:0x01b9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01ae -> B:76:0x01b1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 526
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sk.i.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.m0 m0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1", f = "CIOReader.kt", i = {0, 0, 1, 1, 1, 2}, l = {46, 46, 57}, m = "invokeSuspend", n = {RtspHeaders.Values.TIMEOUT, "rc", RtspHeaders.Values.TIMEOUT, "rc", "$this$withTimeout$iv", RtspHeaders.Values.TIMEOUT}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
    public static final class b extends xm.o implements jn.p<pl.m0, um.d<? super l2>, Object> {
        final /* synthetic */ ByteBuffer $buffer;
        final /* synthetic */ pl.c $channel;
        final /* synthetic */ ReadableByteChannel $nioChannel;
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        final /* synthetic */ rk.h $selectable;
        final /* synthetic */ rk.j $selector;
        final /* synthetic */ e0.e $socketOptions;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        @xm.f(c = "io.ktor.network.sockets.CIOReaderKt$attachForReadingImpl$1$timeout$1", f = "CIOReader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.l<um.d<? super l2>, Object> {
            final /* synthetic */ pl.c $channel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(pl.c cVar, um.d<? super a> dVar) {
                super(1, dVar);
                this.$channel = cVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.l um.d<?> dVar) {
                return new a(this.$channel, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                this.$channel.f(new SocketTimeoutException());
                return l2.f10208a;
            }

            @Override // jn.l
            @os.m
            public final Object invoke(@os.m um.d<? super l2> dVar) {
                return ((a) create(dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e0.e eVar, pl.c cVar, rk.h hVar, ByteBuffer byteBuffer, bm.h<ByteBuffer> hVar2, ReadableByteChannel readableByteChannel, rk.j jVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$socketOptions = eVar;
            this.$channel = cVar;
            this.$selectable = hVar;
            this.$buffer = byteBuffer;
            this.$pool = hVar2;
            this.$nioChannel = readableByteChannel;
            this.$selector = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$socketOptions, this.$channel, this.$selectable, this.$buffer, this.$pool, this.$nioChannel, this.$selector, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00f2 A[Catch: all -> 0x004b, PHI: r2 r7 r8 r9 r10 r11 r12 r13
          0x00f2: PHI (r2v15 rk.j) = (r2v12 rk.j), (r2v22 rk.j) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE]
          0x00f2: PHI (r7v3 rk.h) = (r7v2 rk.h), (r7v12 rk.h) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE]
          0x00f2: PHI (r8v3 pl.c) = (r8v2 pl.c), (r8v10 pl.c) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE]
          0x00f2: PHI (r9v2 java.nio.ByteBuffer) = (r9v1 java.nio.ByteBuffer), (r9v6 java.nio.ByteBuffer) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE]
          0x00f2: PHI (r10v1 java.nio.channels.ReadableByteChannel) = (r10v0 java.nio.channels.ReadableByteChannel), (r10v5 java.nio.channels.ReadableByteChannel) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE]
          0x00f2: PHI (r11v4 tk.d) = (r11v2 tk.d), (r11v9 tk.d) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE]
          0x00f2: PHI (r12v2 kn.k1$f) = (r12v1 kn.k1$f), (r12v6 kn.k1$f) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE]
          0x00f2: PHI (r13v2 tk.d) = (r13v1 tk.d), (r13v7 tk.d) binds: [B:49:0x011d, B:42:0x00ea] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #2 {all -> 0x004b, blocks: (B:43:0x00f2, B:45:0x00fa, B:48:0x011b, B:50:0x011f, B:15:0x0046), top: B:79:0x0046, outer: #3 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x00fa A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:43:0x00f2, B:45:0x00fa, B:48:0x011b, B:50:0x011f, B:15:0x0046), top: B:79:0x0046, outer: #3 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x011a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x011f A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:43:0x00f2, B:45:0x00fa, B:48:0x011b, B:50:0x011f, B:15:0x0046), top: B:79:0x0046, outer: #3 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00e3 -> B:33:0x00ba). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x011d -> B:43:0x00f2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0176 -> B:66:0x0179). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 411
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sk.i.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.m0 m0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.network.sockets.CIOReaderKt", f = "CIOReader.kt", i = {0}, l = {128}, m = "readFrom", n = {"count"}, s = {"L$0"})
    public static final class c extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.g(null, null, this);
        }
    }

    public static final class d extends kn.n0 implements jn.l<ByteBuffer, l2> {
        final /* synthetic */ k1.f $count;
        final /* synthetic */ ReadableByteChannel $nioChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k1.f fVar, ReadableByteChannel readableByteChannel) {
            super(1);
            this.$count = fVar;
            this.$nioChannel = readableByteChannel;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(ByteBuffer byteBuffer) {
            invoke2(byteBuffer);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l ByteBuffer byteBuffer) {
            kn.l0.p(byteBuffer, "buffer");
            this.$count.element = this.$nioChannel.read(byteBuffer);
        }
    }

    @os.l
    public static final pl.l0 c(@os.l s0 s0Var, @os.l pl.c cVar, @os.l ReadableByteChannel readableByteChannel, @os.l rk.h hVar, @os.l rk.j jVar, @os.m e0.e eVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(cVar, "channel");
        kn.l0.p(readableByteChannel, "nioChannel");
        kn.l0.p(hVar, "selectable");
        kn.l0.p(jVar, "selector");
        return pl.v.j(s0Var, nq.k1.g().plus(new r0("cio-from-nio-reader")), cVar, new a(hVar, eVar, cVar, readableByteChannel, jVar, null));
    }

    public static /* synthetic */ pl.l0 d(s0 s0Var, pl.c cVar, ReadableByteChannel readableByteChannel, rk.h hVar, rk.j jVar, e0.e eVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            eVar = null;
        }
        return c(s0Var, cVar, readableByteChannel, hVar, jVar, eVar);
    }

    @os.l
    public static final pl.l0 e(@os.l s0 s0Var, @os.l pl.c cVar, @os.l ReadableByteChannel readableByteChannel, @os.l rk.h hVar, @os.l rk.j jVar, @os.l bm.h<ByteBuffer> hVar2, @os.m e0.e eVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(cVar, "channel");
        kn.l0.p(readableByteChannel, "nioChannel");
        kn.l0.p(hVar, "selectable");
        kn.l0.p(jVar, "selector");
        kn.l0.p(hVar2, "pool");
        return pl.v.j(s0Var, nq.k1.g().plus(new r0("cio-from-nio-reader")), cVar, new b(eVar, cVar, hVar, hVar2.W0(), hVar2, readableByteChannel, jVar, null));
    }

    public static /* synthetic */ pl.l0 f(s0 s0Var, pl.c cVar, ReadableByteChannel readableByteChannel, rk.h hVar, rk.j jVar, bm.h hVar2, e0.e eVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            eVar = null;
        }
        return e(s0Var, cVar, readableByteChannel, hVar, jVar, hVar2, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object g(pl.n nVar, ReadableByteChannel readableByteChannel, um.d<? super Integer> dVar) {
        c cVar;
        k1.f fVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        c cVar2 = cVar;
        Object obj = cVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar2.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.f fVar2 = new k1.f();
            d dVar2 = new d(fVar2, readableByteChannel);
            cVar2.L$0 = fVar2;
            cVar2.label = 1;
            if (pl.n.a.b(nVar, 0, dVar2, cVar2, 1, null) == aVar) {
                return aVar;
            }
            fVar = fVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (k1.f) cVar2.L$0;
            d1.n(obj);
        }
        return new Integer(fVar.element);
    }

    public static final Object h(rk.h hVar, rk.j jVar, um.d<? super l2> dVar) {
        rk.g gVar = rk.g.READ;
        hVar.e2(gVar, true);
        Object objK = jVar.K(hVar, gVar, dVar);
        return objK == wm.a.COROUTINE_SUSPENDED ? objK : l2.f10208a;
    }
}
