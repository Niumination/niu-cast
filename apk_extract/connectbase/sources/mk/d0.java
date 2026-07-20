package mk;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import fl.a1;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import lm.d1;
import nq.l0;
import nq.l2;
import nq.r0;
import nq.s0;
import nq.u0;

/* JADX INFO: loaded from: classes2.dex */
@c0
public final class d0 implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final pl.k f10756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final um.g f10757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public b f10759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final j f10760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final q f10761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final pq.l<mk.g> f10762g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final l2 f10763i;

    public static final class a extends Exception implements l0<a> {
        private final long frameSize;

        public a(long j10) {
            this.frameSize = j10;
        }

        public final long getFrameSize() {
            return this.frameSize;
        }

        @Override // java.lang.Throwable
        @os.l
        public String getMessage() {
            return kn.l0.C("Frame is too big: ", Long.valueOf(this.frameSize));
        }

        @Override // nq.l0
        @os.l
        public a createCopy() {
            a aVar = new a(this.frameSize);
            aVar.initCause(this);
            return aVar;
        }
    }

    public enum b {
        HEADER,
        BODY,
        END
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10765a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.HEADER.ordinal()] = 1;
            iArr[b.BODY.ordinal()] = 2;
            iArr[b.END.ordinal()] = 3;
            f10765a = iArr;
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketReader", f = "WebSocketReader.kt", i = {0}, l = {y5.a.f20716e0}, m = "handleFrameIfProduced", n = {"this"}, s = {"L$0"})
    public static final class d extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d0.this.i(this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketReader", f = "WebSocketReader.kt", i = {0, 0, 1, 1}, l = {90, 98}, m = "parseLoop", n = {"this", "buffer", "this", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class e extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d0.this.j(null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketReader", f = "WebSocketReader.kt", i = {0, 0, 1, 1}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, TabLayout.f3131k0}, m = "readLoop", n = {"this", "buffer", "this", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class f extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public f(um.d<? super f> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d0.this.k(null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.websocket.WebSocketReader$readerJob$1", f = "WebSocketReader.kt", i = {0}, l = {41}, m = "invokeSuspend", n = {"buffer"}, s = {"L$0"})
    public static final class g extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ bm.h<ByteBuffer> $pool;
        Object L$0;
        int label;
        final /* synthetic */ d0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(bm.h<ByteBuffer> hVar, d0 d0Var, um.d<? super g> dVar) {
            super(2, dVar);
            this.$pool = hVar;
            this.this$0 = d0Var;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new g(this.$pool, this.this$0, dVar);
        }

        /* JADX INFO: Infinite loop detected, blocks: 4, insns: 0 */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            Throwable th2;
            ByteBuffer byteBuffer;
            a e10;
            d0 d0Var;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    ByteBuffer byteBufferW0 = this.$pool.W0();
                    try {
                        d0 d0Var2 = this.this$0;
                        this.L$0 = byteBufferW0;
                        this.label = 1;
                        if (d0Var2.k(byteBufferW0, this) == aVar) {
                            return aVar;
                        }
                        byteBuffer = byteBufferW0;
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (gl.c unused) {
                        byteBuffer = byteBufferW0;
                        pq.f0.a.b(this.this$0.f10762g, null, 1, null);
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (ClosedChannelException unused2) {
                        byteBuffer = byteBufferW0;
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (CancellationException unused3) {
                        byteBuffer = byteBufferW0;
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (a e11) {
                        byteBuffer = byteBufferW0;
                        e10 = e11;
                        this.this$0.f10762g.f(e10);
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (Throwable th3) {
                        th2 = th3;
                        throw th2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteBuffer = (ByteBuffer) this.L$0;
                    try {
                        d1.n(obj);
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (gl.c unused4) {
                        pq.f0.a.b(this.this$0.f10762g, null, 1, null);
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (ClosedChannelException unused5) {
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (CancellationException unused6) {
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (a e12) {
                        e10 = e12;
                        this.this$0.f10762g.f(e10);
                        this.$pool.recycle(byteBuffer);
                        d0Var = this.this$0;
                    } catch (Throwable th4) {
                        th2 = th4;
                        throw th2;
                    }
                }
                pq.g0.a.a(d0Var.f10762g, null, 1, null);
                return lm.l2.f10208a;
            } catch (Throwable th5) {
                this.$pool.recycle(aVar);
                pq.g0.a.a(this.this$0.f10762g, null, 1, null);
                throw th5;
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((g) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    public d0(@os.l pl.k kVar, @os.l um.g gVar, long j10, @os.l bm.h<ByteBuffer> hVar) {
        kn.l0.p(kVar, "byteChannel");
        kn.l0.p(gVar, "coroutineContext");
        kn.l0.p(hVar, "pool");
        this.f10756a = kVar;
        this.f10757b = gVar;
        this.f10758c = j10;
        this.f10759d = b.HEADER;
        this.f10760e = new j();
        this.f10761f = new q();
        this.f10762g = pq.o.d(8, null, null, 6, null);
        this.f10763i = nq.k.e(this, new r0("ws-reader"), u0.ATOMIC, new g(hVar, this, null));
    }

    public static /* synthetic */ void g() {
    }

    public final long F0() {
        return this.f10758c;
    }

    @os.l
    public final pq.f0<mk.g> d() {
        return this.f10762g;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f10757b;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(um.d<? super lm.l2> dVar) {
        d dVar2;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i10 = dVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object obj = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 == 0) {
            d1.n(obj);
            if (!this.f10761f.a()) {
                this.f10759d = b.HEADER;
                j jVar = this.f10760e;
                mk.g gVarC = mk.g.f10766i.c(jVar.f10786b, jVar.e(), a1.i(this.f10761f.d(jVar.f10795k)), jVar.f10787c, jVar.f10788d, jVar.f10789e);
                pq.l<mk.g> lVar = this.f10762g;
                dVar2.L$0 = this;
                dVar2.label = 1;
                if (lVar.L(gVarC, dVar2) == aVar) {
                    return aVar;
                }
            }
            return lm.l2.f10208a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (d0) dVar2.L$0;
        d1.n(obj);
        this.f10760e.a();
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object j(ByteBuffer byteBuffer, um.d<? super lm.l2> dVar) throws a {
        e eVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            d1.n(obj);
        } else {
            if (i11 != 1 && i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) eVar.L$1;
            d0 d0Var = (d0) eVar.L$0;
            d1.n(obj);
            byteBuffer = byteBuffer2;
            this = d0Var;
        }
        while (byteBuffer.hasRemaining()) {
            int i12 = c.f10765a[this.f10759d.ordinal()];
            if (i12 == 1) {
                this.f10760e.b(byteBuffer);
                if (!this.f10760e.c()) {
                    return lm.l2.f10208a;
                }
                this.f10759d = b.BODY;
                long j10 = this.f10760e.f10794j;
                if (j10 > 2147483647L || j10 > this.f10758c) {
                    throw new a(this.f10760e.f10794j);
                }
                this.f10761f.c((int) j10, byteBuffer);
                eVar.L$0 = this;
                eVar.L$1 = byteBuffer;
                eVar.label = 1;
                if (this.i(eVar) == aVar) {
                    return aVar;
                }
            } else if (i12 == 2) {
                this.f10761f.b(byteBuffer);
                eVar.L$0 = this;
                eVar.L$1 = byteBuffer;
                eVar.label = 2;
                if (this.i(eVar) == aVar) {
                    return aVar;
                }
            } else if (i12 == 3) {
                return lm.l2.f10208a;
            }
        }
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x005e  */
    /* JADX WARN: Code duplicated, block: B:24:0x006a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0080 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:13:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object k(java.nio.ByteBuffer r7, um.d<? super lm.l2> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof mk.d0.f
            if (r0 == 0) goto L13
            r0 = r8
            mk.d0$f r0 = (mk.d0.f) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            mk.d0$f r0 = new mk.d0$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            mk.d0 r7 = (mk.d0) r7
            lm.d1.n(r8)
        L31:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L81
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            mk.d0 r7 = (mk.d0) r7
            lm.d1.n(r8)
            goto L61
        L49:
            lm.d1.n(r8)
            r7.clear()
        L4f:
            pl.k r8 = r6.f10756a
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.n0(r7, r0)
            if (r8 != r1) goto L5e
            return r1
        L5e:
            r5 = r7
            r7 = r6
            r6 = r5
        L61:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r2 = -1
            if (r8 != r2) goto L71
            mk.d0$b r6 = mk.d0.b.END
            r7.f10759d = r6
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L71:
            r6.flip()
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r7.j(r6, r0)
            if (r8 != r1) goto L31
            return r1
        L81:
            r7.compact()
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: mk.d0.k(java.nio.ByteBuffer, um.d):java.lang.Object");
    }

    public final void w0(long j10) {
        this.f10758c = j10;
    }

    public /* synthetic */ d0(pl.k kVar, um.g gVar, long j10, bm.h hVar, int i10, kn.w wVar) {
        this(kVar, gVar, j10, (i10 & 8) != 0 ? gl.b.a() : hVar);
    }
}
