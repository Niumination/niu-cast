package sk;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;
import lm.d1;
import lm.l2;
import nq.k1;
import nq.r0;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    @xm.f(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1", f = "CIOWriter.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<pl.i0, um.d<? super l2>, Object> {
        final /* synthetic */ pl.c $channel;
        final /* synthetic */ WritableByteChannel $nioChannel;
        final /* synthetic */ rk.h $selectable;
        final /* synthetic */ rk.j $selector;
        final /* synthetic */ e0.e $socketOptions;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: sk.j$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1$1", f = "CIOWriter.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {96, 108, 108}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", RtspHeaders.Values.TIMEOUT, "$this$lookAheadSuspend", RtspHeaders.Values.TIMEOUT, "buffer", "rc", "$this$lookAheadSuspend", RtspHeaders.Values.TIMEOUT, "buffer", "rc", "$this$withTimeout$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
        public static final class C0373a extends xm.o implements jn.p<pl.d0, um.d<? super l2>, Object> {
            final /* synthetic */ pl.i0 $$this$reader;
            final /* synthetic */ pl.c $channel;
            final /* synthetic */ WritableByteChannel $nioChannel;
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

            /* JADX INFO: renamed from: sk.j$a$a$a, reason: collision with other inner class name */
            @xm.f(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1$1$timeout$1", f = "CIOWriter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0374a extends xm.o implements jn.l<um.d<? super l2>, Object> {
                final /* synthetic */ pl.c $channel;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0374a(pl.c cVar, um.d<? super C0374a> dVar) {
                    super(1, dVar);
                    this.$channel = cVar;
                }

                @Override // xm.a
                @os.l
                public final um.d<l2> create(@os.l um.d<?> dVar) {
                    return new C0374a(this.$channel, dVar);
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
                    return ((C0374a) create(dVar)).invokeSuspend(l2.f10208a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0373a(e0.e eVar, pl.i0 i0Var, pl.c cVar, WritableByteChannel writableByteChannel, rk.h hVar, rk.j jVar, um.d<? super C0373a> dVar) {
                super(2, dVar);
                this.$socketOptions = eVar;
                this.$$this$reader = i0Var;
                this.$channel = cVar;
                this.$nioChannel = writableByteChannel;
                this.$selectable = hVar;
                this.$selector = jVar;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                C0373a c0373a = new C0373a(this.$socketOptions, this.$$this$reader, this.$channel, this.$nioChannel, this.$selectable, this.$selector, dVar);
                c0373a.L$0 = obj;
                return c0373a;
            }

            /* JADX WARN: Code duplicated, block: B:37:0x00dd  */
            /* JADX WARN: Code duplicated, block: B:39:0x00ea  */
            /* JADX WARN: Code duplicated, block: B:42:0x00fe  */
            /* JADX WARN: Code duplicated, block: B:44:0x011b A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:47:0x0122  */
            /* JADX WARN: Code duplicated, block: B:49:0x0126  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ab -> B:35:0x00d7). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00cc -> B:24:0x00a6). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0124 -> B:40:0x00f6). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x013b -> B:56:0x015b). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0158 -> B:56:0x015b). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r21) {
                /*
                    Method dump skipped, instruction units count: 377
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: sk.j.a.C0373a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l pl.d0 d0Var, @os.m um.d<? super l2> dVar) {
                return ((C0373a) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rk.h hVar, pl.c cVar, WritableByteChannel writableByteChannel, e0.e eVar, rk.j jVar, um.d<? super a> dVar) {
            super(2, dVar);
            this.$selectable = hVar;
            this.$channel = cVar;
            this.$nioChannel = writableByteChannel;
            this.$socketOptions = eVar;
            this.$selector = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$selectable, this.$channel, this.$nioChannel, this.$socketOptions, this.$selector, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v5, types: [java.nio.channels.WritableByteChannel] */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws IOException {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    pl.i0 i0Var = (pl.i0) this.L$0;
                    this.$selectable.e2(rk.g.WRITE, false);
                    pl.c cVar = this.$channel;
                    C0373a c0373a = new C0373a(this.$socketOptions, i0Var, cVar, this.$nioChannel, this.$selectable, this.$selector, null);
                    this.label = 1;
                    if (cVar.G(c0373a, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                this.$selectable.e2(rk.g.WRITE, false);
                this = this.$nioChannel;
                if (this instanceof SocketChannel) {
                    try {
                        ((SocketChannel) this).socket().shutdownOutput();
                    } catch (ClosedChannelException unused) {
                    }
                }
                return l2.f10208a;
            } catch (Throwable th2) {
                this.$selectable.e2(rk.g.WRITE, false);
                WritableByteChannel writableByteChannel = this.$nioChannel;
                if (writableByteChannel instanceof SocketChannel) {
                    try {
                        ((SocketChannel) writableByteChannel).socket().shutdownOutput();
                    } catch (ClosedChannelException unused2) {
                    }
                }
                throw th2;
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.i0 i0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(i0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingImpl$1", f = "CIOWriter.kt", i = {0, 1, 1, 2, 2, 2}, l = {39, 52, 52}, m = "invokeSuspend", n = {RtspHeaders.Values.TIMEOUT, RtspHeaders.Values.TIMEOUT, "rc", RtspHeaders.Values.TIMEOUT, "rc", "$this$withTimeout$iv"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class b extends xm.o implements jn.p<pl.i0, um.d<? super l2>, Object> {
        final /* synthetic */ ByteBuffer $buffer;
        final /* synthetic */ pl.c $channel;
        final /* synthetic */ WritableByteChannel $nioChannel;
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
        int label;

        @xm.f(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingImpl$1$timeout$1", f = "CIOWriter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
        public b(e0.e eVar, ByteBuffer byteBuffer, pl.c cVar, rk.h hVar, bm.h<ByteBuffer> hVar2, WritableByteChannel writableByteChannel, rk.j jVar, um.d<? super b> dVar) {
            super(2, dVar);
            this.$socketOptions = eVar;
            this.$buffer = byteBuffer;
            this.$channel = cVar;
            this.$selectable = hVar;
            this.$pool = hVar2;
            this.$nioChannel = writableByteChannel;
            this.$selector = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = new b(this.$socketOptions, this.$buffer, this.$channel, this.$selectable, this.$pool, this.$nioChannel, this.$selector, dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:46:0x00ea A[Catch: all -> 0x005b, TryCatch #3 {all -> 0x005b, blocks: (B:71:0x0171, B:72:0x0175, B:44:0x00e2, B:30:0x0095, B:33:0x00b5, B:37:0x00c1, B:43:0x00dd, B:46:0x00ea, B:49:0x0106, B:51:0x010e, B:54:0x012a, B:56:0x0130, B:59:0x0136, B:73:0x017f, B:74:0x0182, B:15:0x0056, B:20:0x0062, B:23:0x0070, B:28:0x007f, B:26:0x0076, B:8:0x002e, B:66:0x0165, B:68:0x016b, B:61:0x0141, B:63:0x0149, B:70:0x016f), top: B:87:0x000a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:51:0x010e A[Catch: all -> 0x005b, TryCatch #3 {all -> 0x005b, blocks: (B:71:0x0171, B:72:0x0175, B:44:0x00e2, B:30:0x0095, B:33:0x00b5, B:37:0x00c1, B:43:0x00dd, B:46:0x00ea, B:49:0x0106, B:51:0x010e, B:54:0x012a, B:56:0x0130, B:59:0x0136, B:73:0x017f, B:74:0x0182, B:15:0x0056, B:20:0x0062, B:23:0x0070, B:28:0x007f, B:26:0x0076, B:8:0x002e, B:66:0x0165, B:68:0x016b, B:61:0x0141, B:63:0x0149, B:70:0x016f), top: B:87:0x000a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0129 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x0130 A[Catch: all -> 0x005b, TryCatch #3 {all -> 0x005b, blocks: (B:71:0x0171, B:72:0x0175, B:44:0x00e2, B:30:0x0095, B:33:0x00b5, B:37:0x00c1, B:43:0x00dd, B:46:0x00ea, B:49:0x0106, B:51:0x010e, B:54:0x012a, B:56:0x0130, B:59:0x0136, B:73:0x017f, B:74:0x0182, B:15:0x0056, B:20:0x0062, B:23:0x0070, B:28:0x007f, B:26:0x0076, B:8:0x002e, B:66:0x0165, B:68:0x016b, B:61:0x0141, B:63:0x0149, B:70:0x016f), top: B:87:0x000a, inners: #1 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x0134  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00dd -> B:44:0x00e2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0132 -> B:49:0x0106). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0147 -> B:66:0x0165). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0162 -> B:66:0x0165). Please report as a decompilation issue!!! */
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
                Method dump skipped, instruction units count: 410
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sk.j.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.i0 i0Var, @os.m um.d<? super l2> dVar) {
            return ((b) create(i0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.l
    public static final pl.h0 a(@os.l s0 s0Var, @os.l pl.c cVar, @os.l WritableByteChannel writableByteChannel, @os.l rk.h hVar, @os.l rk.j jVar, @os.m e0.e eVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(cVar, "channel");
        kn.l0.p(writableByteChannel, "nioChannel");
        kn.l0.p(hVar, "selectable");
        kn.l0.p(jVar, "selector");
        return pl.v.b(s0Var, k1.g().plus(new r0("cio-to-nio-writer")), cVar, new a(hVar, cVar, writableByteChannel, eVar, jVar, null));
    }

    public static /* synthetic */ pl.h0 b(s0 s0Var, pl.c cVar, WritableByteChannel writableByteChannel, rk.h hVar, rk.j jVar, e0.e eVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            eVar = null;
        }
        return a(s0Var, cVar, writableByteChannel, hVar, jVar, eVar);
    }

    @os.l
    public static final pl.h0 c(@os.l s0 s0Var, @os.l pl.c cVar, @os.l WritableByteChannel writableByteChannel, @os.l rk.h hVar, @os.l rk.j jVar, @os.l bm.h<ByteBuffer> hVar2, @os.m e0.e eVar) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(cVar, "channel");
        kn.l0.p(writableByteChannel, "nioChannel");
        kn.l0.p(hVar, "selectable");
        kn.l0.p(jVar, "selector");
        kn.l0.p(hVar2, "pool");
        return pl.v.b(s0Var, k1.g().plus(new r0("cio-to-nio-writer")), cVar, new b(eVar, hVar2.W0(), cVar, hVar, hVar2, writableByteChannel, jVar, null));
    }

    public static /* synthetic */ pl.h0 d(s0 s0Var, pl.c cVar, WritableByteChannel writableByteChannel, rk.h hVar, rk.j jVar, bm.h hVar2, e0.e eVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            eVar = null;
        }
        return c(s0Var, cVar, writableByteChannel, hVar, jVar, hVar2, eVar);
    }
}
