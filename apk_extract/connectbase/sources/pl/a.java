package pl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.k1;
import lm.c1;
import lm.d1;
import nq.l2;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pl.c, pl.k, pl.n, pl.d0, pl.z, pl.a0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final C0326a f13169n = new C0326a();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13170o = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_state");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13171p = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_closed");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13172q = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_readOp");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13173r = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_writeOp");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f13174s = -8;

    @os.l
    private volatile /* synthetic */ Object _closed;

    @os.l
    private volatile /* synthetic */ Object _readOp;

    @os.l
    private volatile /* synthetic */ Object _state;

    @os.l
    volatile /* synthetic */ Object _writeOp;

    @os.m
    private volatile l2 attachedJob;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final bm.h<wl.h.c> f13176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public tl.q f13180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public tl.q f13181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final wl.g f13182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public final wl.o f13183j;

    @os.m
    private volatile wl.e joining;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public final wl.b<Boolean> f13184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public final wl.b<lm.l2> f13185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public final jn.l<um.d<? super lm.l2>, Object> f13186m;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private volatile int writeSuspensionSize;

    /* JADX INFO: renamed from: pl.a$a, reason: collision with other inner class name */
    public static final class C0326a {
        public C0326a() {
        }

        public C0326a(kn.w wVar) {
        }
    }

    public static final class a0 extends kn.n0 implements jn.l<pl.b0, lm.l2> {
        final /* synthetic */ jn.l<pl.f0, lm.l2> $consumer;
        final /* synthetic */ a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a0(jn.l<? super pl.f0, lm.l2> lVar, a aVar) {
            super(1);
            this.$consumer = lVar;
            this.this$0 = aVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(pl.b0 b0Var) {
            invoke2(b0Var);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l pl.b0 b0Var) {
            kn.l0.p(b0Var, "$this$lookAhead");
            try {
                this.$consumer.invoke(this.this$0.f13182i);
                this.this$0.f13182i.a();
            } catch (Throwable th2) {
                this.this$0.f13182i.a();
                throw th2;
            }
        }
    }

    public static final class b extends kn.n0 implements jn.l<Throwable, lm.l2> {
        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
            invoke2(th2);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            a.this.attachedJob = null;
            if (th2 == null) {
                return;
            }
            a.this.c(pl.y.a(th2));
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2486}, m = "readShort", n = {"this_$iv", "size$iv"}, s = {"L$0", "I$0"})
    public static final class b0 extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b0(um.d<? super b0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.C(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {1900}, m = "awaitAtLeastSuspend", n = {"this"}, s = {"L$0"})
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
            return a.this.g1(0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2248}, m = "readSuspendLoop", n = {"this", ik.f.b.f7973h}, s = {"L$0", "I$0"})
    public static final class c0 extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c0(um.d<? super c0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.p2(0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0}, l = {1532, 1533}, m = "awaitFreeSpaceOrDelegate", n = {"this", "block", "min"}, s = {"L$0", "L$1", "I$0"})
    public static final class d extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return a.this.k1(0, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel$readSuspendableSession$2", f = "ByteBufferChannel.kt", i = {}, l = {1650}, m = "invokeSuspend", n = {}, s = {})
    public static final class d0 extends xm.o implements jn.p<pl.d0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ jn.p<pl.j0, um.d<? super lm.l2>, Object> $consumer;
        int label;
        final /* synthetic */ a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d0(jn.p<? super pl.j0, ? super um.d<? super lm.l2>, ? extends Object> pVar, a aVar, um.d<? super d0> dVar) {
            super(2, dVar);
            this.$consumer = pVar;
            this.this$0 = aVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new d0(this.$consumer, this.this$0, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, lm.l2] */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    d1.n(obj);
                    jn.p<pl.j0, um.d<? super lm.l2>, Object> pVar = this.$consumer;
                    wl.g gVar = this.this$0.f13182i;
                    this.label = 1;
                    if (pVar.invoke(gVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                this.this$0.f13182i.a();
                this = lm.l2.f10208a;
                return this;
            } catch (Throwable th2) {
                this.this$0.f13182i.a();
                throw th2;
            }
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.d0 d0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((d0) create(d0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0}, l = {1960}, m = "consumeEachBufferRangeSuspend", n = {"this", "visitor", "last"}, s = {"L$0", "L$1", "I$0"})
    public static final class e extends xm.d {
        int I$0;
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
            return a.this.r1(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {2117}, m = "readUTF8Line$suspendImpl", n = {"sb"}, s = {"L$0"})
    public static final class e0 extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public e0(um.d<? super e0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.s2(a.this, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {1216, 1287, 1295}, m = "copyDirect$ktor_io", n = {"this", "src", "joined", "byteOrder", "copied", "this_$iv", "capacity$iv", "current$iv", "state", "dstBuffer", "$this$copyDirect_u24lambda_u2d77", "limit", "autoFlush", "before$iv", "this", "src", "joined", "byteOrder", "copied", "limit", "autoFlush", "this", "src", "joined", "byteOrder", "copied", "limit", "autoFlush"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "Z$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "Z$0"})
    public static final class f extends xm.d {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
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
            return a.this.s1(null, 0L, null, this);
        }
    }

    public static final class f0 extends kn.n0 implements jn.l<pl.b0, lm.l2> {
        final /* synthetic */ char[] $array;
        final /* synthetic */ CharBuffer $buffer;
        final /* synthetic */ k1.f $consumed;
        final /* synthetic */ k1.a $eol;
        final /* synthetic */ int $limit;
        final /* synthetic */ Appendable $out;
        final /* synthetic */ a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(k1.a aVar, a aVar2, Appendable appendable, char[] cArr, CharBuffer charBuffer, k1.f fVar, int i10) {
            super(1);
            this.$eol = aVar;
            this.this$0 = aVar2;
            this.$out = appendable;
            this.$array = cArr;
            this.$buffer = charBuffer;
            this.$consumed = fVar;
            this.$limit = i10;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(pl.b0 b0Var) throws IOException {
            invoke2(b0Var);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l pl.b0 b0Var) throws IOException {
            boolean z10;
            ByteBuffer byteBufferB;
            int iMax;
            kn.l0.p(b0Var, "$this$lookAhead");
            k1.a aVar = this.$eol;
            a aVar2 = this.this$0;
            Appendable appendable = this.$out;
            char[] cArr = this.$array;
            CharBuffer charBuffer = this.$buffer;
            kn.l0.o(charBuffer, "buffer");
            a aVar3 = this.this$0;
            k1.f fVar = this.$consumed;
            char[] cArr2 = this.$array;
            int i10 = this.$limit;
            int i11 = 1;
            do {
                z10 = false;
                if (aVar3.d() < i11 || (byteBufferB = b0Var.b(0, 1)) == null) {
                    break;
                }
                int iPosition = byteBufferB.position();
                if (byteBufferB.remaining() < i11) {
                    aVar2.H2(byteBufferB, i11);
                }
                long jG = wl.l.g(byteBufferB, cArr2, 0, Math.min(cArr2.length, i10 - fVar.element));
                b0Var.b0(byteBufferB.position() - iPosition);
                int i12 = (int) (jG >> 32);
                int i13 = (int) (4294967295L & jG);
                iMax = -1;
                if (i13 == -1) {
                    iMax = 0;
                } else if (i13 != 0 || !byteBufferB.hasRemaining()) {
                    iMax = Math.max(1, i13);
                }
                fVar.element += i12;
                if (appendable instanceof StringBuilder) {
                    z10 = false;
                    ((StringBuilder) appendable).append(cArr, 0, i12);
                } else {
                    z10 = false;
                    appendable.append(charBuffer, 0, i12);
                }
                i11 = iMax;
            } while (iMax > 0);
            aVar.element = i11 != 0 ? z10 : true;
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0}, l = {1722}, m = "discardSuspend", n = {"this", "discarded", "max"}, s = {"L$0", "L$1", "J$0"})
    public static final class g extends xm.d {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public g(um.d<? super g> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.x1(0L, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {2076}, m = "readUTF8LineToUtf8Suspend", n = {"result"}, s = {"L$0"})
    public static final class g0 extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public g0(um.d<? super g0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.v2(null, 0, null, null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0}, l = {1174, 1182}, m = "joinFromSuspend", n = {"this", "src", "delegateClose"}, s = {"L$0", "L$1", "Z$0"})
    public static final class h extends xm.d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public h(um.d<? super h> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.L1(null, false, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {2081}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "this_$iv", "$this$readLineLoop$iv", "out$iv", "ca$iv", "cb$iv", "required$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$1"})
    public static final class h0 extends xm.o implements jn.p<pl.d0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ char[] $ca;
        final /* synthetic */ CharBuffer $cb;
        final /* synthetic */ int $consumed0;
        final /* synthetic */ k1.f $consumed1;
        final /* synthetic */ int $limit;
        final /* synthetic */ Appendable $out;
        final /* synthetic */ k1.a $result;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(Appendable appendable, char[] cArr, CharBuffer charBuffer, k1.f fVar, int i10, k1.a aVar, int i11, um.d<? super h0> dVar) {
            super(2, dVar);
            this.$out = appendable;
            this.$ca = cArr;
            this.$cb = charBuffer;
            this.$consumed1 = fVar;
            this.$consumed0 = i10;
            this.$result = aVar;
            this.$limit = i11;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            h0 h0Var = a.this.new h0(this.$out, this.$ca, this.$cb, this.$consumed1, this.$consumed0, this.$result, this.$limit, dVar);
            h0Var.L$0 = obj;
            return h0Var;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x007c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0087  */
        /* JADX WARN: Code duplicated, block: B:20:0x0098  */
        /* JADX WARN: Code duplicated, block: B:23:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:24:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:25:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:28:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:31:0x00df  */
        /* JADX WARN: Code duplicated, block: B:32:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:61:0x0152  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object, pl.d0] */
        /* JADX WARN: Type inference failed for: r13v2, types: [pl.b0] */
        /* JADX WARN: Type inference failed for: r13v5 */
        /* JADX WARN: Type inference failed for: r13v6 */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x007a -> B:12:0x007d). Please report as a decompilation issue!!! */
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
                Method dump skipped, instruction units count: 345
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: pl.a.h0.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.d0 d0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((h0) create(d0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {2, 2, 2, 2, 5, 5}, l = {1819, 1821, 1826, 1831, 1833, 1837}, m = "lookAheadSuspend$suspendImpl", n = {"this", "visitor", "result", "this_$iv", "this", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    public static final class i<R> extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public i(um.d<? super i> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.M1(a.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0}, l = {1527}, m = "write$suspendImpl", n = {"this", "block", "min"}, s = {"L$0", "L$1", "I$0"})
    public static final class i0 extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public i0(um.d<? super i0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.Y2(a.this, 0, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {2433}, m = "peekTo-vHUFkk8$suspendImpl", n = {"bytesCopied"}, s = {"L$0"})
    public static final class j extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public j(um.d<? super j> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.O1(a.this, null, 0L, 0L, 0L, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {1075, 1077, 1079}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class j0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public j0(um.d<? super j0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.f3(null, this);
        }
    }

    public static final class k extends kn.n0 implements jn.l<ByteBuffer, lm.l2> {
        final /* synthetic */ k1.f $bytesCopied;
        final /* synthetic */ ByteBuffer $destination;
        final /* synthetic */ long $destinationOffset;
        final /* synthetic */ long $max;
        final /* synthetic */ long $offset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(long j10, long j11, ByteBuffer byteBuffer, long j12, k1.f fVar) {
            super(1);
            this.$offset = j10;
            this.$max = j11;
            this.$destination = byteBuffer;
            this.$destinationOffset = j12;
            this.$bytesCopied = fVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(ByteBuffer byteBuffer) {
            invoke2(byteBuffer);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l ByteBuffer byteBuffer) {
            kn.l0.p(byteBuffer, "nioBuffer");
            if (byteBuffer.remaining() > this.$offset) {
                ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                kn.l0.m(byteBufferDuplicate);
                byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) this.$offset));
                int iLimit = byteBufferDuplicate.limit();
                byteBufferDuplicate.limit((int) Math.min(byteBufferDuplicate.limit(), Math.min(this.$max, ((long) this.$destination.limit()) - this.$destinationOffset) + this.$offset));
                this.$bytesCopied.element = byteBufferDuplicate.remaining();
                ql.i.e(byteBufferDuplicate, this.$destination, (int) this.$destinationOffset);
                byteBufferDuplicate.limit(iLimit);
            }
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {1083, 1085, 1087}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class k0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public k0(um.d<? super k0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.g3(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0}, l = {731, 735}, m = "readAvailableSuspend", n = {"this", "dst", TypedValues.CycleType.S_WAVE_OFFSET, "length"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class l extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public l(um.d<? super l> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.b2(null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, l = {938, 938, 938, 2476, 2531, 938, 938, 2558}, m = "writeByte$suspendImpl", n = {"joined$iv$iv", "this_$iv$iv$iv", "b", "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", "b", "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", "b"}, s = {"L$0", "L$1", "B$0", "L$0", "L$1", "L$2", "B$0", "I$0", "L$0", "L$1", "B$0"})
    public static final class l0 extends xm.d {
        byte B$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public l0(um.d<? super l0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.h3(a.this, (byte) 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {739, 743}, m = "readAvailableSuspend", n = {"this", "dst"}, s = {"L$0", "L$1"})
    public static final class m extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public m(um.d<? super m> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.Z1(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {1101}, m = "writeFully$suspendImpl", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class m0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public m0(um.d<? super m0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.l3(a.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {747, 751}, m = "readAvailableSuspend", n = {"this", "dst"}, s = {"L$0", "L$1"})
    public static final class n extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public n(um.d<? super n> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.a2(null, this);
        }
    }

    public static final class n0 extends kn.n0 implements jn.l<ByteBuffer, lm.l2> {
        final /* synthetic */ tl.e $src;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(tl.e eVar) {
            super(1);
            this.$src = eVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(ByteBuffer byteBuffer) {
            invoke2(byteBuffer);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l ByteBuffer byteBuffer) {
            kn.l0.p(byteBuffer, "buffer");
            tl.p0.b(this.$src, byteBuffer, 0, 2, null);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0}, l = {1730, 1738}, m = "readBlockSuspend", n = {"this", "block", "min"}, s = {"L$0", "L$1", "I$0"})
    public static final class o extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public o(um.d<? super o> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.c2(0, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {1124, 1126}, m = "writeFullySuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class o0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public o0(um.d<? super o0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.p3(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {}, l = {820}, m = "readBoolean", n = {}, s = {})
    public static final class p extends xm.d {
        int label;
        /* synthetic */ Object result;

        public p(um.d<? super p> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.r(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {1134, 1136}, m = "writeFullySuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class p0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public p0(um.d<? super p0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.q3(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2486}, m = "readByte", n = {"this_$iv", "size$iv"}, s = {"L$0", "I$0"})
    public static final class q extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public q(um.d<? super q> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.a0(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0}, l = {1441}, m = "writeFullySuspend", n = {"this", "src", "currentOffset", "currentLength"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class q0 extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public q0(um.d<? super q0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.r3(null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2486}, m = "readDouble", n = {"this_$iv", "size$iv"}, s = {"L$0", "I$0"})
    public static final class r extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public r(um.d<? super r> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.T(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, l = {946, 946, 946, 2476, 2531, 946, 946, 2558}, m = "writeInt$suspendImpl", n = {"joined$iv$iv", "this_$iv$iv$iv", b9.i.f771b, "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", b9.i.f771b, "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", b9.i.f771b}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0"})
    public static final class r0 extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public r0(um.d<? super r0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.s3(a.this, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2486}, m = "readFloat", n = {"this_$iv", "size$iv"}, s = {"L$0", "I$0"})
    public static final class s extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public s(um.d<? super s> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.B(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, l = {950, 950, 950, 2476, 2531, 950, 950, 2558}, m = "writeLong$suspendImpl", n = {"joined$iv$iv", "this_$iv$iv$iv", a8.l.f173c, "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", a8.l.f173c, "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", a8.l.f173c}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "J$0"})
    public static final class s0 extends xm.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public s0(um.d<? super s0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.t3(a.this, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0}, l = {593}, m = "readFullySuspend", n = {"this", "dst", "copied"}, s = {"L$0", "L$1", "I$0"})
    public static final class t extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public t(um.d<? super t> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.e2(null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 1}, l = {1762, 1764}, m = "writePacketSuspend", n = {"this", "packet", "packet"}, s = {"L$0", "L$1", "L$0"})
    public static final class t0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public t0(um.d<? super t0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.v3(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0}, l = {616}, m = "readFullySuspend", n = {"this", "dst", p6.n.f13005a, "copied"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class u extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public u(um.d<? super u> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.f2(null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, l = {942, 942, 942, 2476, 2531, 942, 942, 2558}, m = "writeShort$suspendImpl", n = {"joined$iv$iv", "this_$iv$iv$iv", p6.s.f13016a, "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", p6.s.f13016a, "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", p6.s.f13016a}, s = {"L$0", "L$1", "S$0", "L$0", "L$1", "L$2", "S$0", "I$0", "L$0", "L$1", "S$0"})
    public static final class u0 extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        short S$0;
        int label;
        /* synthetic */ Object result;

        public u0(um.d<? super u0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.x3(a.this, (short) 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0}, l = {630}, m = "readFullySuspend", n = {"this", "dst", "currentOffset", "currentLength", "consumed"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
    public static final class v extends xm.d {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public v(um.d<? super v> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.g2(null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0}, l = {1458, 1460}, m = "writeSuspend", n = {"this", "src", TypedValues.CycleType.S_WAVE_OFFSET, "length"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class v0 extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public v0(um.d<? super v0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.z3(null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2486}, m = "readInt", n = {"this_$iv", "size$iv"}, s = {"L$0", "I$0"})
    public static final class w extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public w(um.d<? super w> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.x(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2462}, m = "writeSuspend", n = {"this", ik.f.b.f7973h}, s = {"L$0", "I$0"})
    public static final class w0 extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public w0(um.d<? super w0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.y3(0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0}, l = {2486}, m = "readLong", n = {"this_$iv", "size$iv"}, s = {"L$0", "I$0"})
    public static final class x extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public x(um.d<? super x> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.D(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {1864}, m = "writeSuspendSession$suspendImpl", n = {"session"}, s = {"L$0"})
    public static final class x0 extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public x0(um.d<? super x0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.D3(a.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0}, l = {802}, m = "readPacketSuspend", n = {"this", "builder", "buffer", "remaining"}, s = {"L$0", "L$1", "L$2", "I$0"})
    public static final class y extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public y(um.d<? super y> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.j2(0, null, null, this);
        }
    }

    public static final class y0 extends kn.n0 implements jn.l<um.d<? super lm.l2>, Object> {
        public y0() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Object invoke(@os.l um.d<? super lm.l2> dVar) throws Throwable {
            Throwable thC;
            kn.l0.p(dVar, "ucont");
            int i10 = a.this.writeSuspensionSize;
            while (true) {
                wl.c cVarX0 = a.x0(a.this);
                if (cVarX0 != null && (thC = cVarX0.c()) != null) {
                    pl.b.b(thC);
                    throw new lm.y();
                }
                if (!a.this.B3(i10)) {
                    c1.a aVar = c1.Companion;
                    dVar.resumeWith(c1.m59constructorimpl(lm.l2.f10208a));
                    break;
                }
                a aVar2 = a.this;
                um.d dVarE = wm.c.e(dVar);
                a aVar3 = a.this;
                while (true) {
                    if (((um.d) aVar2._writeOp) != null) {
                        throw new IllegalStateException("Operation is already in progress");
                    }
                    if (!aVar3.B3(i10)) {
                        break;
                    }
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a.f13173r;
                    if (j.d.a(atomicReferenceFieldUpdater, aVar2, null, dVarE)) {
                        if (!aVar3.B3(i10) && j.d.a(atomicReferenceFieldUpdater, aVar2, dVarE, null)) {
                            break;
                        }
                        break;
                    }
                }
            }
            a.this.A1(i10);
            if (a.this.Q2()) {
                a.this.E2();
            }
            return wm.a.COROUTINE_SUSPENDED;
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0}, l = {2156}, m = "readRemainingSuspend", n = {"this", "builder$iv", "remaining", "$this$writeWhile$iv", "tail$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class z extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public z(um.d<? super z> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.m2(0L, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {1557, 1569}, m = "writeWhileSuspend", n = {"this", "block", "continueWriting", "this_$iv", "capacity$iv", "current$iv", "capacity", "dst", "$this$writeWhileSuspend_u24lambda_u2d99", "before$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0"})
    public static final class z0 extends xm.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public z0(um.d<? super z0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.H3(null, this);
        }
    }

    public a(boolean z10, @os.l bm.h<wl.h.c> hVar, int i10) {
        kn.l0.p(hVar, "pool");
        this.f13175b = z10;
        this.f13176c = hVar;
        this.f13177d = i10;
        this._state = wl.h.a.f19709c;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        tl.q qVar = tl.q.BIG_ENDIAN;
        this.f13180g = qVar;
        this.f13181h = qVar;
        this.f13182i = new wl.g(this);
        this.f13183j = new wl.o(this);
        this.f13184k = new wl.b<>();
        this.f13185l = new wl.b<>();
        this.f13186m = new y0();
    }

    @lm.k(level = lm.m.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void D1() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, lm.l2] */
    @tl.f0
    public static Object D3(a aVar, jn.p pVar, um.d dVar) {
        x0 x0Var;
        wl.o oVar;
        if (dVar instanceof x0) {
            x0Var = (x0) dVar;
            int i10 = x0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                x0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                x0Var = aVar.new x0(dVar);
            }
        } else {
            x0Var = aVar.new x0(dVar);
        }
        Object obj = x0Var.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = x0Var.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                oVar = aVar.f13183j;
                oVar.e();
                x0Var.L$0 = oVar;
                x0Var.label = 1;
                if (pVar.invoke(oVar, x0Var) == aVar2) {
                    return aVar2;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                oVar = (wl.o) x0Var.L$0;
                d1.n(obj);
            }
            oVar.f();
            aVar = lm.l2.f10208a;
            return aVar;
        } catch (Throwable th2) {
            aVar.f();
            throw th2;
        }
    }

    public static Object E3(a aVar, jn.l lVar, um.d dVar) throws Throwable {
        if (!aVar.G3(lVar)) {
            return lm.l2.f10208a;
        }
        wl.c cVar = (wl.c) aVar._closed;
        if (cVar == null) {
            Object objH3 = aVar.H3(lVar, dVar);
            return objH3 == wm.a.COROUTINE_SUSPENDED ? objH3 : lm.l2.f10208a;
        }
        pl.b.b(cVar.c());
        throw new lm.y();
    }

    public static /* synthetic */ void F1() {
    }

    @lm.k(level = lm.m.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void I1() {
    }

    /* JADX WARN: Code duplicated, block: B:105:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f7 A[PHI: r9
      0x00f7: PHI (r9v23 java.lang.Object) = (r9v33 java.lang.Object), (r9v34 java.lang.Object) binds: [B:53:0x00f4, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x010b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x010c  */
    /* JADX WARN: Code duplicated, block: B:63:0x011a  */
    /* JADX WARN: Code duplicated, block: B:67:0x0122  */
    /* JADX WARN: Code duplicated, block: B:69:0x0126  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:82:0x0146  */
    /* JADX WARN: Code duplicated, block: B:85:0x014d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0166 A[PHI: r9
      0x0166: PHI (r9v22 java.lang.Object) = (r9v35 java.lang.Object), (r9v36 java.lang.Object) binds: [B:86:0x0163, B:18:0x0043] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object M1(a aVar, jn.p pVar, um.d dVar) throws Throwable {
        i iVar;
        Object objInvoke;
        a aVar2;
        Throwable th2;
        a aVar3;
        jn.p pVar2;
        k1.h hVar;
        T t10;
        k1.h hVar2;
        k1.h hVar3;
        Object objInvoke2;
        Object obj;
        Object obj2;
        Throwable thA;
        Object objInvoke3;
        a aVar4;
        Object objInvoke4;
        k1.h hVar4;
        Object objInvoke5;
        Object obj3;
        Object obj4;
        wl.h hVar5;
        T t11;
        wl.h hVar6;
        if (dVar instanceof i) {
            iVar = (i) dVar;
            int i10 = iVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar = aVar.new i(dVar);
            }
        } else {
            iVar = aVar.new i(dVar);
        }
        Object obj5 = iVar.result;
        wm.a aVar5 = wm.a.COROUTINE_SUSPENDED;
        boolean z10 = true;
        switch (iVar.label) {
            case 0:
                d1.n(obj5);
                Throwable thA2 = aVar.a();
                if (thA2 != null) {
                    wl.d dVar2 = new wl.d(thA2);
                    iVar.label = 1;
                    objInvoke = pVar.invoke(dVar2, iVar);
                    if (objInvoke == aVar5) {
                        obj = objInvoke;
                        return aVar5;
                    }
                    obj = objInvoke;
                    return obj;
                }
                if (((wl.h) aVar._state) == wl.h.f.f19719c) {
                    wl.m mVar = wl.m.f19728b;
                    iVar.label = 2;
                    objInvoke2 = pVar.invoke(mVar, iVar);
                    if (objInvoke2 == aVar5) {
                        obj2 = objInvoke2;
                        return aVar5;
                    }
                    obj2 = objInvoke2;
                    return obj2;
                }
                k1.h hVar7 = new k1.h();
                if (aVar.O2() != null) {
                    try {
                        if (((wl.h) aVar._state).f19708b._availableForRead$internal != 0) {
                            iVar.L$0 = aVar;
                            iVar.L$1 = pVar;
                            iVar.L$2 = hVar7;
                            iVar.L$3 = aVar;
                            iVar.L$4 = hVar7;
                            iVar.label = 3;
                            Object objInvoke6 = pVar.invoke(aVar, iVar);
                            if (objInvoke6 == aVar5) {
                                return aVar5;
                            }
                            aVar3 = aVar;
                            pVar2 = pVar;
                            aVar2 = aVar3;
                            hVar = hVar7;
                            t10 = objInvoke6;
                            hVar2 = hVar;
                            hVar.element = t10;
                            aVar2.B2();
                            aVar2.U2();
                            hVar3 = hVar2;
                            pVar = pVar2;
                            if (!z10) {
                                thA = aVar3.a();
                                if (thA != null) {
                                    wl.d dVar3 = new wl.d(thA);
                                    iVar.L$0 = null;
                                    iVar.L$1 = null;
                                    iVar.L$2 = null;
                                    iVar.L$3 = null;
                                    iVar.L$4 = null;
                                    iVar.label = 4;
                                    objInvoke3 = pVar.invoke(dVar3, iVar);
                                    if (objInvoke3 == aVar5) {
                                        obj3 = objInvoke3;
                                        return aVar5;
                                    }
                                    obj3 = objInvoke3;
                                    return obj3;
                                }
                                if (((wl.h) aVar3._state) == wl.h.f.f19719c) {
                                    wl.m mVar2 = wl.m.f19728b;
                                    iVar.L$0 = null;
                                    iVar.L$1 = null;
                                    iVar.L$2 = null;
                                    iVar.L$3 = null;
                                    iVar.L$4 = null;
                                    iVar.label = 5;
                                    objInvoke5 = pVar.invoke(mVar2, iVar);
                                    if (objInvoke5 == aVar5) {
                                        obj4 = objInvoke5;
                                        return aVar5;
                                    }
                                    obj4 = objInvoke5;
                                    return obj4;
                                }
                                try {
                                    iVar.L$0 = aVar3;
                                    iVar.L$1 = hVar3;
                                    iVar.L$2 = hVar3;
                                    iVar.L$3 = null;
                                    iVar.L$4 = null;
                                    iVar.label = 6;
                                    objInvoke4 = pVar.invoke(aVar3, iVar);
                                    if (objInvoke4 == aVar5) {
                                        return aVar5;
                                    }
                                    hVar4 = hVar3;
                                    aVar4 = aVar3;
                                    t11 = objInvoke4;
                                    hVar3.element = t11;
                                    hVar6 = (wl.h) aVar4._state;
                                    if (!hVar6.a() && hVar6 != wl.h.f.f19719c) {
                                        if ((hVar6 instanceof wl.h.d) || (hVar6 instanceof wl.h.e)) {
                                            aVar4.B2();
                                        }
                                        aVar4.U2();
                                    }
                                    hVar3 = hVar4;
                                } catch (Throwable th3) {
                                    th = th3;
                                    aVar4 = aVar3;
                                    hVar5 = (wl.h) aVar4._state;
                                    if (!hVar5.a()) {
                                        if (hVar5 instanceof wl.h.d) {
                                            aVar4.B2();
                                        } else {
                                            aVar4.B2();
                                        }
                                        aVar4.U2();
                                    }
                                    throw th;
                                }
                            }
                            return hVar3.element;
                        }
                        aVar.B2();
                        aVar.U2();
                    } catch (Throwable th4) {
                        aVar2 = aVar;
                        th2 = th4;
                        aVar2.B2();
                        aVar2.U2();
                        throw th2;
                    }
                }
                aVar3 = aVar;
                hVar3 = hVar7;
                z10 = false;
                if (!z10) {
                    thA = aVar3.a();
                    if (thA != null) {
                        wl.d dVar4 = new wl.d(thA);
                        iVar.L$0 = null;
                        iVar.L$1 = null;
                        iVar.L$2 = null;
                        iVar.L$3 = null;
                        iVar.L$4 = null;
                        iVar.label = 4;
                        objInvoke3 = pVar.invoke(dVar4, iVar);
                        if (objInvoke3 == aVar5) {
                            obj3 = objInvoke3;
                            return aVar5;
                        }
                        obj3 = objInvoke3;
                        return obj3;
                    }
                    if (((wl.h) aVar3._state) == wl.h.f.f19719c) {
                        wl.m mVar3 = wl.m.f19728b;
                        iVar.L$0 = null;
                        iVar.L$1 = null;
                        iVar.L$2 = null;
                        iVar.L$3 = null;
                        iVar.L$4 = null;
                        iVar.label = 5;
                        objInvoke5 = pVar.invoke(mVar3, iVar);
                        if (objInvoke5 == aVar5) {
                            obj4 = objInvoke5;
                            return aVar5;
                        }
                        obj4 = objInvoke5;
                        return obj4;
                    }
                    iVar.L$0 = aVar3;
                    iVar.L$1 = hVar3;
                    iVar.L$2 = hVar3;
                    iVar.L$3 = null;
                    iVar.L$4 = null;
                    iVar.label = 6;
                    objInvoke4 = pVar.invoke(aVar3, iVar);
                    if (objInvoke4 == aVar5) {
                        return aVar5;
                    }
                    hVar4 = hVar3;
                    aVar4 = aVar3;
                    t11 = objInvoke4;
                    hVar3.element = t11;
                    hVar6 = (wl.h) aVar4._state;
                    if (!hVar6.a()) {
                        if (hVar6 instanceof wl.h.d) {
                            aVar4.B2();
                        } else {
                            aVar4.B2();
                        }
                        aVar4.U2();
                    }
                    hVar3 = hVar4;
                }
                return hVar3.element;
            case 1:
                d1.n(obj5);
                obj = obj5;
                obj = objInvoke;
                return obj;
            case 2:
                d1.n(obj5);
                obj2 = obj5;
                obj2 = objInvoke2;
                return obj2;
            case 3:
                hVar = (k1.h) iVar.L$4;
                aVar2 = (a) iVar.L$3;
                hVar2 = (k1.h) iVar.L$2;
                pVar2 = (jn.p) iVar.L$1;
                aVar3 = (a) iVar.L$0;
                try {
                    d1.n(obj5);
                    t10 = obj5;
                    hVar.element = t10;
                    aVar2.B2();
                    aVar2.U2();
                    hVar3 = hVar2;
                    pVar = pVar2;
                    if (!z10) {
                        thA = aVar3.a();
                        if (thA != null) {
                            wl.d dVar5 = new wl.d(thA);
                            iVar.L$0 = null;
                            iVar.L$1 = null;
                            iVar.L$2 = null;
                            iVar.L$3 = null;
                            iVar.L$4 = null;
                            iVar.label = 4;
                            objInvoke3 = pVar.invoke(dVar5, iVar);
                            if (objInvoke3 == aVar5) {
                                obj3 = objInvoke3;
                                return aVar5;
                            }
                            obj3 = objInvoke3;
                            return obj3;
                        }
                        if (((wl.h) aVar3._state) == wl.h.f.f19719c) {
                            wl.m mVar4 = wl.m.f19728b;
                            iVar.L$0 = null;
                            iVar.L$1 = null;
                            iVar.L$2 = null;
                            iVar.L$3 = null;
                            iVar.L$4 = null;
                            iVar.label = 5;
                            objInvoke5 = pVar.invoke(mVar4, iVar);
                            if (objInvoke5 == aVar5) {
                                obj4 = objInvoke5;
                                return aVar5;
                            }
                            obj4 = objInvoke5;
                            return obj4;
                        }
                        iVar.L$0 = aVar3;
                        iVar.L$1 = hVar3;
                        iVar.L$2 = hVar3;
                        iVar.L$3 = null;
                        iVar.L$4 = null;
                        iVar.label = 6;
                        objInvoke4 = pVar.invoke(aVar3, iVar);
                        if (objInvoke4 == aVar5) {
                            return aVar5;
                        }
                        hVar4 = hVar3;
                        aVar4 = aVar3;
                        t11 = objInvoke4;
                        hVar3.element = t11;
                        hVar6 = (wl.h) aVar4._state;
                        if (!hVar6.a()) {
                            if (hVar6 instanceof wl.h.d) {
                                aVar4.B2();
                            } else {
                                aVar4.B2();
                            }
                            aVar4.U2();
                        }
                        hVar3 = hVar4;
                    }
                    return hVar3.element;
                } catch (Throwable th5) {
                    th2 = th5;
                    aVar2.B2();
                    aVar2.U2();
                    throw th2;
                }
            case 4:
                d1.n(obj5);
                obj3 = obj5;
                obj3 = objInvoke3;
                return obj3;
            case 5:
                d1.n(obj5);
                obj4 = obj5;
                obj4 = objInvoke5;
                return obj4;
            case 6:
                hVar3 = (k1.h) iVar.L$2;
                hVar4 = (k1.h) iVar.L$1;
                aVar4 = (a) iVar.L$0;
                try {
                    d1.n(obj5);
                    t11 = obj5;
                    hVar3.element = t11;
                    hVar6 = (wl.h) aVar4._state;
                    if (!hVar6.a()) {
                        if (hVar6 instanceof wl.h.d) {
                            aVar4.B2();
                        } else {
                            aVar4.B2();
                        }
                        aVar4.U2();
                    }
                    hVar3 = hVar4;
                    return hVar3.element;
                } catch (Throwable th6) {
                    th = th6;
                    hVar5 = (wl.h) aVar4._state;
                    if (!hVar5.a() && hVar5 != wl.h.f.f19719c) {
                        if ((hVar5 instanceof wl.h.d) || (hVar5 instanceof wl.h.e)) {
                            aVar4.B2();
                        }
                        aVar4.U2();
                    }
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static Object O1(a aVar, ByteBuffer byteBuffer, long j10, long j11, long j12, long j13, um.d dVar) {
        j jVar;
        k1.f fVar;
        if (dVar instanceof j) {
            jVar = (j) dVar;
            int i10 = jVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                jVar.label = i10 - Integer.MIN_VALUE;
            } else {
                jVar = aVar.new j(dVar);
            }
        } else {
            jVar = aVar.new j(dVar);
        }
        Object obj = jVar.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = jVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.f fVar2 = new k1.f();
            int iC = (int) tn.u.C(j12 + j11, pl.j.f13203a);
            jn.l<? super ByteBuffer, lm.l2> kVar = new k(j11, j13, byteBuffer, j10, fVar2);
            jVar.L$0 = fVar2;
            jVar.label = 1;
            if (aVar.I(iC, kVar, jVar) == obj2) {
                return obj2;
            }
            fVar = fVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (k1.f) jVar.L$0;
            d1.n(obj);
        }
        return new Long(fVar.element);
    }

    public static Object R1(a aVar, int i10, jn.l lVar, um.d dVar) throws Throwable {
        Object objC2;
        int i11;
        if (i10 < 0) {
            throw new IllegalArgumentException("min should be positive or zero");
        }
        ByteBuffer byteBufferO2 = aVar.O2();
        boolean z10 = false;
        if (byteBufferO2 != null) {
            wl.j jVar = ((wl.h) aVar._state).f19708b;
            try {
                if (jVar._availableForRead$internal != 0 && (i11 = jVar._availableForRead$internal) > 0 && i11 >= i10) {
                    int iPosition = byteBufferO2.position();
                    int iLimit = byteBufferO2.limit();
                    lVar.invoke(byteBufferO2);
                    if (iLimit != byteBufferO2.limit()) {
                        throw new IllegalStateException("Buffer limit modified.");
                    }
                    int iPosition2 = byteBufferO2.position() - iPosition;
                    if (iPosition2 < 0) {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.");
                    }
                    if (!jVar.t(iPosition2)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    aVar.l1(byteBufferO2, jVar, iPosition2);
                    z10 = true;
                }
                aVar.B2();
                aVar.U2();
            } catch (Throwable th2) {
                aVar.B2();
                aVar.U2();
                throw th2;
            }
        }
        return (z10 || aVar.p0() || (objC2 = aVar.c2(i10, lVar, dVar)) != wm.a.COROUTINE_SUSPENDED) ? lm.l2.f10208a : objC2;
    }

    public static int V1(a aVar, tl.e eVar, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAsMuchAsPossible");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            tl.m mVar = eVar.f15821b;
            i11 = mVar.f15872a - mVar.f15874c;
        }
        return aVar.T1(eVar, i10, i11);
    }

    public static Object W1(a aVar, ByteBuffer byteBuffer, um.d dVar) throws Throwable {
        int iS1 = aVar.S1(byteBuffer);
        if (iS1 == 0 && ((wl.c) aVar._closed) != null) {
            iS1 = ((wl.h) aVar._state).f19708b.e() ? aVar.S1(byteBuffer) : -1;
        } else if (iS1 <= 0 && byteBuffer.hasRemaining()) {
            return aVar.Z1(byteBuffer, dVar);
        }
        return new Integer(iS1);
    }

    public static Object X1(a aVar, tl.o0 o0Var, um.d dVar) {
        int iV1 = V1(aVar, o0Var, 0, 0, 6, null);
        if (iV1 == 0 && ((wl.c) aVar._closed) != null) {
            iV1 = ((wl.h) aVar._state).f19708b.e() ? V1(aVar, o0Var, 0, 0, 6, null) : -1;
        } else if (iV1 <= 0) {
            tl.m mVar = o0Var.f15821b;
            if (mVar.f15872a > mVar.f15874c) {
                return aVar.a2(o0Var, dVar);
            }
        }
        return new Integer(iV1);
    }

    public static Object Y1(a aVar, byte[] bArr, int i10, int i11, um.d dVar) throws Throwable {
        int iU1 = aVar.U1(bArr, i10, i11);
        if (iU1 == 0 && ((wl.c) aVar._closed) != null) {
            iU1 = ((wl.h) aVar._state).f19708b.e() ? aVar.U1(bArr, i10, i11) : -1;
        } else if (iU1 <= 0 && i11 != 0) {
            return aVar.b2(bArr, i10, i11, dVar);
        }
        return new Integer(iU1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object Y2(a aVar, int i10, jn.l lVar, um.d dVar) {
        i0 i0Var;
        a aVar2;
        if (dVar instanceof i0) {
            i0Var = (i0) dVar;
            int i11 = i0Var.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                i0Var.label = i11 - Integer.MIN_VALUE;
            } else {
                i0Var = aVar.new i0(dVar);
            }
        } else {
            i0Var = aVar.new i0(dVar);
        }
        Object obj = i0Var.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i12 = i0Var.label;
        if (i12 == 0) {
            d1.n(obj);
            if (i10 <= 0) {
                throw new IllegalArgumentException("min should be positive");
            }
            if (i10 > 4088) {
                aVar2 = aVar;
                throw new IllegalArgumentException(k.b.a("Min(", i10, ") should'nt be greater than (4088)").toString());
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i13 = i0Var.I$0;
            jn.l lVar2 = (jn.l) i0Var.L$1;
            a aVar4 = (a) i0Var.L$0;
            d1.n(obj);
            i10 = i13;
            aVar2 = aVar4;
            lVar = lVar2;
        }
        aVar2 = aVar;
        while (aVar2.k(i10, lVar) < 0) {
            i0Var.L$0 = aVar2;
            i0Var.L$1 = lVar;
            i0Var.I$0 = i10;
            i0Var.label = 1;
            if (aVar2.k1(i10, lVar, i0Var) == aVar3) {
                return aVar3;
            }
        }
        return lm.l2.f10208a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object Z1(ByteBuffer byteBuffer, um.d<? super Integer> dVar) throws Throwable {
        m mVar;
        if (dVar instanceof m) {
            mVar = (m) dVar;
            int i10 = mVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                mVar.label = i10 - Integer.MIN_VALUE;
            } else {
                mVar = new m(dVar);
            }
        } else {
            mVar = new m(dVar);
        }
        Object objN2 = mVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = mVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                byteBuffer = (ByteBuffer) mVar.L$1;
                this = (a) mVar.L$0;
                d1.n(objN2);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objN2);
            }
        }
        d1.n(objN2);
        mVar.L$0 = this;
        mVar.L$1 = byteBuffer;
        mVar.label = 1;
        objN2 = n2(1, mVar);
        if (objN2 == aVar) {
            return aVar;
        }
        if (!((Boolean) objN2).booleanValue()) {
            return new Integer(-1);
        }
        mVar.L$0 = null;
        mVar.L$1 = null;
        mVar.label = 2;
        objN2 = this.n0(byteBuffer, mVar);
        return objN2 == aVar ? aVar : objN2;
    }

    public static Object c3(a aVar, ByteBuffer byteBuffer, um.d dVar) throws Throwable {
        a aVarA2;
        a aVarA3;
        wl.e eVar = aVar.joining;
        if (eVar != null && (aVarA3 = aVar.A2(aVar, eVar)) != null) {
            return aVarA3.j0(byteBuffer, dVar);
        }
        int iZ2 = aVar.Z2(byteBuffer);
        if (iZ2 > 0) {
            return new Integer(iZ2);
        }
        wl.e eVar2 = aVar.joining;
        return (eVar2 == null || (aVarA2 = aVar.A2(aVar, eVar2)) == null) ? aVar.f3(byteBuffer, dVar) : aVarA2.f3(byteBuffer, dVar);
    }

    public static Object d2(a aVar, tl.o0 o0Var, int i10, um.d dVar) {
        Object objF2;
        int iV1 = V1(aVar, o0Var, 0, i10, 2, null);
        return (iV1 != i10 && (objF2 = aVar.f2(o0Var, i10 - iV1, dVar)) == wm.a.COROUTINE_SUSPENDED) ? objF2 : lm.l2.f10208a;
    }

    public static Object d3(a aVar, tl.o0 o0Var, um.d dVar) throws Throwable {
        a aVarA2;
        a aVarA3;
        wl.e eVar = aVar.joining;
        if (eVar != null && (aVarA3 = aVar.A2(aVar, eVar)) != null) {
            return aVarA3.L(o0Var, dVar);
        }
        int iA3 = aVar.a3(o0Var);
        if (iA3 > 0) {
            return new Integer(iA3);
        }
        wl.e eVar2 = aVar.joining;
        return (eVar2 == null || (aVarA2 = aVar.A2(aVar, eVar2)) == null) ? aVar.g3(o0Var, dVar) : aVarA2.g3(o0Var, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0051  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:21:0x0054). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object e2(java.nio.ByteBuffer r6, int r7, um.d<? super java.lang.Integer> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof pl.a.t
            if (r0 == 0) goto L13
            r0 = r8
            pl.a$t r0 = (pl.a.t) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$t r0 = new pl.a$t
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            pl.a r7 = (pl.a) r7
            lm.d1.n(r8)
            goto L54
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            lm.d1.n(r8)
        L3c:
            boolean r8 = r6.hasRemaining()
            if (r8 == 0) goto L82
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r8 = r5.n2(r3, r0)
            if (r8 != r1) goto L51
            return r1
        L51:
            r4 = r7
            r7 = r5
            r5 = r4
        L54:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L65
            int r8 = r7.S1(r6)
            int r5 = r5 + r8
            r4 = r7
            r7 = r5
            r5 = r4
            goto L3c
        L65:
            pq.v r5 = new pq.v
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Unexpected EOF: expected "
            r7.<init>(r8)
            int r6 = r6.remaining()
            r7.append(r6)
            java.lang.String r6 = " more bytes"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L82:
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.e2(java.nio.ByteBuffer, int, um.d):java.lang.Object");
    }

    public static Object e3(a aVar, byte[] bArr, int i10, int i11, um.d dVar) throws Throwable {
        a aVarA2;
        wl.e eVar = aVar.joining;
        if (eVar != null && (aVarA2 = aVar.A2(aVar, eVar)) != null) {
            return aVarA2.s(bArr, i10, i11, dVar);
        }
        int iB3 = aVar.b3(bArr, i10, i11);
        return iB3 > 0 ? new Integer(iB3) : aVar.z3(bArr, i10, i11, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f3(ByteBuffer byteBuffer, um.d<? super Integer> dVar) {
        j0 j0Var;
        a aVarA2;
        if (dVar instanceof j0) {
            j0Var = (j0) dVar;
            int i10 = j0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                j0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                j0Var = new j0(dVar);
            }
        } else {
            j0Var = new j0(dVar);
        }
        Object objJ0 = j0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = j0Var.label;
        if (i11 == 0) {
            d1.n(objJ0);
            j0Var.L$0 = this;
            j0Var.L$1 = byteBuffer;
            j0Var.label = 1;
            if (y3(1, j0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                if (i11 == 2) {
                    d1.n(objJ0);
                }
                if (i11 == 3) {
                    d1.n(objJ0);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            byteBuffer = (ByteBuffer) j0Var.L$1;
            this = (a) j0Var.L$0;
            d1.n(objJ0);
        }
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = this.A2(this, eVar)) == null) {
            j0Var.L$0 = null;
            j0Var.L$1 = null;
            j0Var.label = 3;
            objJ0 = this.j0(byteBuffer, j0Var);
            return objJ0 == aVar ? aVar : objJ0;
        }
        j0Var.L$0 = null;
        j0Var.L$1 = null;
        j0Var.label = 2;
        objJ0 = aVarA2.f3(byteBuffer, j0Var);
        return objJ0 == aVar ? aVar : objJ0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0053 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0073  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0054 -> B:19:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object g2(byte[] r7, int r8, int r9, um.d<? super lm.l2> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof pl.a.v
            if (r0 == 0) goto L13
            r0 = r10
            pl.a$v r0 = (pl.a.v) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$v r0 = new pl.a$v
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r6 = r0.I$2
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            byte[] r9 = (byte[]) r9
            java.lang.Object r2 = r0.L$0
            pl.a r2 = (pl.a) r2
            lm.d1.n(r10)
            goto L5b
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            lm.d1.n(r10)
            r10 = 0
        L41:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.I$2 = r10
            r0.label = r3
            java.lang.Object r2 = r6.n2(r3, r0)
            if (r2 != r1) goto L54
            return r1
        L54:
            r4 = r2
            r2 = r6
            r6 = r10
            r10 = r4
            r5 = r9
            r9 = r7
            r7 = r5
        L5b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L73
            int r8 = r8 + r6
            int r6 = r7 - r6
            int r10 = r2.U1(r9, r8, r6)
            if (r10 < r6) goto L6f
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L6f:
            r7 = r9
            r9 = r6
            r6 = r2
            goto L41
        L73:
            pq.v r6 = new pq.v
            java.lang.String r8 = "Unexpected EOF: expected "
            java.lang.String r9 = " more bytes"
            java.lang.String r7 = k.b.a(r8, r7, r9)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.g2(byte[], int, int, um.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g3(tl.o0 o0Var, um.d<? super Integer> dVar) {
        k0 k0Var;
        a aVarA2;
        if (dVar instanceof k0) {
            k0Var = (k0) dVar;
            int i10 = k0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                k0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                k0Var = new k0(dVar);
            }
        } else {
            k0Var = new k0(dVar);
        }
        Object objL = k0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = k0Var.label;
        if (i11 == 0) {
            d1.n(objL);
            k0Var.L$0 = this;
            k0Var.L$1 = o0Var;
            k0Var.label = 1;
            if (y3(1, k0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                if (i11 == 2) {
                    d1.n(objL);
                }
                if (i11 == 3) {
                    d1.n(objL);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o0Var = (tl.o0) k0Var.L$1;
            this = (a) k0Var.L$0;
            d1.n(objL);
        }
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = this.A2(this, eVar)) == null) {
            k0Var.L$0 = null;
            k0Var.L$1 = null;
            k0Var.label = 3;
            objL = this.L(o0Var, k0Var);
            return objL == aVar ? aVar : objL;
        }
        k0Var.L$0 = null;
        k0Var.L$1 = null;
        k0Var.label = 2;
        objL = aVarA2.g3(o0Var, k0Var);
        return objL == aVar ? aVar : objL;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x013f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:97:0x00d3 A[EXC_TOP_SPLITTER, PHI: r2 r6 r8 r9 r10
      0x00d3: PHI (r2v11 java.nio.ByteBuffer) = (r2v4 java.nio.ByteBuffer), (r2v12 java.nio.ByteBuffer) binds: [B:43:0x00cf, B:64:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r6v1 wl.j) = (r6v0 wl.j), (r6v2 wl.j) binds: [B:43:0x00cf, B:64:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r8v11 pl.a) = (r8v0 pl.a), (r8v13 pl.a) binds: [B:43:0x00cf, B:64:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r9v12 int) = (r9v5 int), (r9v14 int) binds: [B:43:0x00cf, B:64:0x0143] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r10v13 byte) = (r10v4 byte), (r10v14 byte) binds: [B:43:0x00cf, B:64:0x0143] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e4 -> B:47:0x00e7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.Object h3(pl.a r8, byte r9, um.d r10) {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.h3(pl.a, byte, um.d):java.lang.Object");
    }

    public static Object i1(a aVar, um.d dVar) throws Throwable {
        Object objN2 = aVar.n2(1, dVar);
        return objN2 == wm.a.COROUTINE_SUSPENDED ? objN2 : lm.l2.f10208a;
    }

    public static Object i2(a aVar, int i10, int i11, um.d dVar) throws Throwable {
        Throwable th2;
        wl.c cVar = (wl.c) aVar._closed;
        if (cVar != null && (th2 = cVar.f19693a) != null) {
            pl.b.b(th2);
            throw new lm.y();
        }
        if (i10 == 0) {
            tl.v.f15884f.getClass();
            return tl.v.f15885g;
        }
        tl.s sVarA = tl.w0.a(i11);
        ByteBuffer byteBufferW0 = wl.f.d().W0();
        while (i10 > 0) {
            try {
                byteBufferW0.clear();
                if (byteBufferW0.remaining() > i10) {
                    byteBufferW0.limit(i10);
                }
                int iS1 = aVar.S1(byteBufferW0);
                if (iS1 == 0) {
                    break;
                }
                byteBufferW0.flip();
                tl.r0.a(sVarA, byteBufferW0);
                i10 -= iS1;
            } catch (Throwable th3) {
                wl.f.f19701d.recycle(byteBufferW0);
                sVarA.close();
                throw th3;
            }
        }
        if (i10 != 0) {
            return aVar.j2(i10, sVarA, byteBufferW0, dVar);
        }
        wl.f.f19701d.recycle(byteBufferW0);
        return sVarA.z2();
    }

    public static Object i3(a aVar, double d10, um.d dVar) {
        Object objA = aVar.A(Double.doubleToRawLongBits(d10), dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : lm.l2.f10208a;
    }

    @tl.f0
    public static Object j1(a aVar, um.d dVar) throws Throwable {
        Object objY3 = aVar.y3(1, dVar);
        return objY3 == wm.a.COROUTINE_SUSPENDED ? objY3 : lm.l2.f10208a;
    }

    public static Object j3(a aVar, float f10, um.d dVar) {
        Object objH0 = aVar.h0(Float.floatToRawIntBits(f10), dVar);
        return objH0 == wm.a.COROUTINE_SUSPENDED ? objH0 : lm.l2.f10208a;
    }

    public static Object k3(a aVar, ByteBuffer byteBuffer, um.d dVar) throws Throwable {
        Object objP3;
        a aVarA2;
        wl.e eVar = aVar.joining;
        if (eVar == null || (aVarA2 = aVar.A2(aVar, eVar)) == null) {
            aVar.Z2(byteBuffer);
            return (byteBuffer.hasRemaining() && (objP3 = aVar.p3(byteBuffer, dVar)) == wm.a.COROUTINE_SUSPENDED) ? objP3 : lm.l2.f10208a;
        }
        Object objM = aVarA2.M(byteBuffer, dVar);
        return objM == wm.a.COROUTINE_SUSPENDED ? objM : lm.l2.f10208a;
    }

    public static /* synthetic */ Object l2(a aVar, long j10, int i10, um.d dVar) throws Throwable {
        if (!aVar.e()) {
            return aVar.m2(j10, i10, dVar);
        }
        Throwable thA = aVar.a();
        if (thA == null) {
            return aVar.y2(j10, i10);
        }
        pl.b.b(thA);
        throw new lm.y();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object l3(a aVar, tl.e eVar, um.d dVar) {
        m0 m0Var;
        n0 n0Var;
        if (dVar instanceof m0) {
            m0Var = (m0) dVar;
            int i10 = m0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                m0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                m0Var = aVar.new m0(dVar);
            }
        } else {
            m0Var = aVar.new m0(dVar);
        }
        Object obj = m0Var.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = m0Var.label;
        if (i11 == 0) {
            d1.n(obj);
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            tl.e eVar2 = (tl.e) m0Var.L$1;
            a aVar3 = (a) m0Var.L$0;
            d1.n(obj);
            eVar = eVar2;
            aVar = aVar3;
        }
        do {
            tl.m mVar = eVar.f15821b;
            if (mVar.f15874c - mVar.f15873b <= 0) {
                return lm.l2.f10208a;
            }
            n0Var = new n0(eVar);
            m0Var.L$0 = aVar;
            m0Var.L$1 = eVar;
            m0Var.label = 1;
        } while (pl.n.a.b(aVar, 0, n0Var, m0Var, 1, null) != aVar2);
        return aVar2;
    }

    public static Object m3(a aVar, tl.o0 o0Var, um.d dVar) throws Throwable {
        Object objQ3;
        aVar.a3(o0Var);
        tl.m mVar = o0Var.f15821b;
        return (mVar.f15874c <= mVar.f15873b || (objQ3 = aVar.q3(o0Var, dVar)) != wm.a.COROUTINE_SUSPENDED) ? lm.l2.f10208a : objQ3;
    }

    public static Object n3(a aVar, byte[] bArr, int i10, int i11, um.d dVar) throws Throwable {
        Object objR3;
        a aVarA2;
        wl.e eVar = aVar.joining;
        if (eVar != null && (aVarA2 = aVar.A2(aVar, eVar)) != null) {
            Object objI = aVarA2.i(bArr, i10, i11, dVar);
            return objI == wm.a.COROUTINE_SUSPENDED ? objI : lm.l2.f10208a;
        }
        while (i11 > 0) {
            int iB3 = aVar.b3(bArr, i10, i11);
            if (iB3 == 0) {
                break;
            }
            i10 += iB3;
            i11 -= iB3;
        }
        return (i11 != 0 && (objR3 = aVar.r3(bArr, i10, i11, dVar)) == wm.a.COROUTINE_SUSPENDED) ? objR3 : lm.l2.f10208a;
    }

    public static Object o3(a aVar, ByteBuffer byteBuffer, int i10, int i11, um.d dVar) {
        Object objM = aVar.M(ql.f.n(byteBuffer, i10, i11 - i10), dVar);
        return objM == wm.a.COROUTINE_SUSPENDED ? objM : lm.l2.f10208a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x004a  */
    /* JADX WARN: Code duplicated, block: B:21:0x0056 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0054 -> B:22:0x0057). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x004a
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object p3(java.nio.ByteBuffer r7, um.d<? super lm.l2> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof pl.a.o0
            if (r0 == 0) goto L13
            r0 = r8
            pl.a$o0 r0 = (pl.a.o0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$o0 r0 = new pl.a$o0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lm.d1.n(r8)
            goto L74
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            pl.a r7 = (pl.a) r7
            lm.d1.n(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L57
        L41:
            lm.d1.n(r8)
        L44:
            boolean r8 = r7.hasRemaining()
            if (r8 == 0) goto L77
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.X2(r4, r0)
            if (r8 != r1) goto L57
            return r1
        L57:
            wl.e r8 = r6.joining
            if (r8 != 0) goto L5c
            goto L62
        L5c:
            pl.a r8 = r6.A2(r6, r8)
            if (r8 != 0) goto L66
        L62:
            r6.Z2(r7)
            goto L44
        L66:
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r8.M(r7, r0)
            if (r6 != r1) goto L74
            return r1
        L74:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L77:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.p3(java.nio.ByteBuffer, um.d):java.lang.Object");
    }

    @tl.f0
    public static Object r2(a aVar, jn.p pVar, um.d dVar) {
        Object objG = aVar.G(new d0(pVar, aVar, null), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object s2(a aVar, int i10, um.d dVar) {
        e0 e0Var;
        StringBuilder sb2;
        if (dVar instanceof e0) {
            e0Var = (e0) dVar;
            int i11 = e0Var.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                e0Var.label = i11 - Integer.MIN_VALUE;
            } else {
                e0Var = aVar.new e0(dVar);
            }
        } else {
            e0Var = aVar.new e0(dVar);
        }
        Object obj = e0Var.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i12 = e0Var.label;
        if (i12 == 0) {
            d1.n(obj);
            StringBuilder sb3 = new StringBuilder();
            e0Var.L$0 = sb3;
            e0Var.label = 1;
            Object objO = aVar.O(sb3, i10, e0Var);
            if (objO == obj2) {
                return obj2;
            }
            obj = objO;
            sb2 = sb3;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sb2 = (StringBuilder) e0Var.L$0;
            d1.n(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return sb2.toString();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x013a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:97:0x00cf A[EXC_TOP_SPLITTER, PHI: r2 r3 r6 r8 r9
      0x00cf: PHI (r2v11 java.nio.ByteBuffer) = (r2v4 java.nio.ByteBuffer), (r2v12 java.nio.ByteBuffer) binds: [B:43:0x00cd, B:64:0x013e] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r3v2 int) = (r3v0 int), (r3v4 int) binds: [B:43:0x00cd, B:64:0x013e] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r6v4 wl.j) = (r6v1 wl.j), (r6v5 wl.j) binds: [B:43:0x00cd, B:64:0x013e] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r8v10 pl.a) = (r8v0 pl.a), (r8v12 pl.a) binds: [B:43:0x00cd, B:64:0x013e] A[DONT_GENERATE, DONT_INLINE]
      0x00cf: PHI (r9v7 int) = (r9v0 int), (r9v9 int) binds: [B:43:0x00cd, B:64:0x013e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e0 -> B:47:0x00e3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.Object s3(pl.a r8, int r9, um.d r10) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.s3(pl.a, int, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x013c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:97:0x00d3 A[EXC_TOP_SPLITTER, PHI: r2 r7 r10 r11 r12
      0x00d3: PHI (r2v11 java.nio.ByteBuffer) = (r2v4 java.nio.ByteBuffer), (r2v12 java.nio.ByteBuffer) binds: [B:43:0x00cf, B:64:0x0140] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r7v1 wl.j) = (r7v0 wl.j), (r7v2 wl.j) binds: [B:43:0x00cf, B:64:0x0140] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r10v10 pl.a) = (r10v0 pl.a), (r10v12 pl.a) binds: [B:43:0x00cf, B:64:0x0140] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r11v6 int) = (r11v3 int), (r11v8 int) binds: [B:43:0x00cf, B:64:0x0140] A[DONT_GENERATE, DONT_INLINE]
      0x00d3: PHI (r12v3 long) = (r12v0 long), (r12v4 long) binds: [B:43:0x00cf, B:64:0x0140] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e4 -> B:47:0x00e7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.Object t3(pl.a r10, long r11, um.d r13) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.t3(pl.a, long, um.d):java.lang.Object");
    }

    public static Object u3(a aVar, tl.v vVar, um.d dVar) throws Throwable {
        a aVarA2;
        a aVarA3;
        wl.e eVar = aVar.joining;
        if (eVar != null && (aVarA3 = aVar.A2(aVar, eVar)) != null) {
            Object objP = aVarA3.p(vVar, dVar);
            return objP == wm.a.COROUTINE_SUSPENDED ? objP : lm.l2.f10208a;
        }
        while (!vVar.B1() && aVar.V2(vVar) != 0) {
            try {
            } catch (Throwable th2) {
                vVar.z2();
                throw th2;
            }
        }
        if (vVar.S0() <= 0) {
            return lm.l2.f10208a;
        }
        wl.e eVar2 = aVar.joining;
        if (eVar2 == null || (aVarA2 = aVar.A2(aVar, eVar2)) == null) {
            Object objV3 = aVar.v3(vVar, dVar);
            return objV3 == wm.a.COROUTINE_SUSPENDED ? objV3 : lm.l2.f10208a;
        }
        Object objP2 = aVarA2.p(vVar, dVar);
        return objP2 == wm.a.COROUTINE_SUSPENDED ? objP2 : lm.l2.f10208a;
    }

    public static Object w1(a aVar, long j10, um.d dVar) throws Throwable {
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException(kn.l0.C("max shouldn't be negative: ", new Long(j10)).toString());
        }
        ByteBuffer byteBufferO2 = aVar.O2();
        if (byteBufferO2 != null) {
            wl.j jVar = ((wl.h) aVar._state).f19708b;
            try {
                if (jVar._availableForRead$internal != 0) {
                    int iS = jVar.s((int) Math.min(2147483647L, j10));
                    aVar.l1(byteBufferO2, jVar, iS);
                    j11 = iS;
                }
            } finally {
                aVar.B2();
                aVar.U2();
            }
        }
        long j12 = j11;
        return (j12 == j10 || aVar.p0()) ? new Long(j12) : aVar.x1(j12, j10, dVar);
    }

    public static final wl.c x0(a aVar) {
        return (wl.c) aVar._closed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x004d  */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    /* JADX WARN: Code duplicated, block: B:32:0x0082 A[Catch: all -> 0x00a2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:21:0x005a, B:32:0x0082), top: B:39:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0064 A[EDGE_INSN: B:42:0x0064->B:24:0x0064 BREAK  A[LOOP:0: B:15:0x0047->B:33:0x009b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0076 -> B:29:0x0079). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object x1(long r11, long r13, um.d<? super java.lang.Long> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof pl.a.g
            if (r0 == 0) goto L13
            r0 = r15
            pl.a$g r0 = (pl.a.g) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$g r0 = new pl.a$g
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            kn.k1$g r12 = (kn.k1.g) r12
            java.lang.Object r13 = r0.L$0
            pl.a r13 = (pl.a) r13
            lm.d1.n(r15)
            r8 = r10
            r10 = r13
            r13 = r8
            goto L79
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            lm.d1.n(r15)
            kn.k1$g r15 = new kn.k1$g
            r15.<init>()
            r15.element = r11
            r12 = r15
        L47:
            long r4 = r12.element
            int r11 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r11 >= 0) goto Laa
            java.nio.ByteBuffer r11 = r10.O2()
            if (r11 != 0) goto L54
            goto L64
        L54:
            java.lang.Object r15 = r10._state
            wl.h r15 = (wl.h) r15
            wl.j r15 = r15.f19708b
            int r2 = r15._availableForRead$internal     // Catch: java.lang.Throwable -> La2
            if (r2 != 0) goto L82
            r10.B2()
            r10.U2()
        L64:
            boolean r11 = r10.p0()
            if (r11 != 0) goto Laa
            r0.L$0 = r10
            r0.L$1 = r12
            r0.J$0 = r13
            r0.label = r3
            java.lang.Object r15 = r10.n2(r3, r0)
            if (r15 != r1) goto L79
            return r1
        L79:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r11 = r15.booleanValue()
            if (r11 != 0) goto L47
            goto Laa
        L82:
            long r4 = r12.element     // Catch: java.lang.Throwable -> La2
            long r4 = r13 - r4
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r4 = java.lang.Math.min(r6, r4)     // Catch: java.lang.Throwable -> La2
            int r2 = (int) r4     // Catch: java.lang.Throwable -> La2
            int r2 = r15.s(r2)     // Catch: java.lang.Throwable -> La2
            r10.l1(r11, r15, r2)     // Catch: java.lang.Throwable -> La2
            long r4 = r12.element     // Catch: java.lang.Throwable -> La2
            long r6 = (long) r2     // Catch: java.lang.Throwable -> La2
            long r4 = r4 + r6
            r12.element = r4     // Catch: java.lang.Throwable -> La2
            r10.B2()
            r10.U2()
            goto L47
        La2:
            r11 = move-exception
            r10.B2()
            r10.U2()
            throw r11
        Laa:
            long r10 = r12.element
            java.lang.Long r12 = new java.lang.Long
            r12.<init>(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.x1(long, long, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x013d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:97:0x00d0 A[EXC_TOP_SPLITTER, PHI: r2 r6 r8 r9 r10
      0x00d0: PHI (r2v6 int) = (r2v1 int), (r2v7 int) binds: [B:43:0x00cf, B:64:0x0141] A[DONT_GENERATE, DONT_INLINE]
      0x00d0: PHI (r6v3 wl.j) = (r6v1 wl.j), (r6v4 wl.j) binds: [B:43:0x00cf, B:64:0x0141] A[DONT_GENERATE, DONT_INLINE]
      0x00d0: PHI (r8v11 pl.a) = (r8v0 pl.a), (r8v13 pl.a) binds: [B:43:0x00cf, B:64:0x0141] A[DONT_GENERATE, DONT_INLINE]
      0x00d0: PHI (r9v11 short) = (r9v0 short), (r9v13 short) binds: [B:43:0x00cf, B:64:0x0141] A[DONT_GENERATE, DONT_INLINE]
      0x00d0: PHI (r10v11 java.nio.ByteBuffer) = (r10v3 java.nio.ByteBuffer), (r10v12 java.nio.ByteBuffer) binds: [B:43:0x00cf, B:64:0x0141] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e1 -> B:47:0x00e4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.Object x3(pl.a r8, short r9, um.d r10) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.x3(pl.a, short, um.d):java.lang.Object");
    }

    public static final um.d z0(a aVar) {
        return (um.d) aVar._writeOp;
    }

    @Override // pl.n
    @os.m
    public Object A(long j10, @os.l um.d<? super lm.l2> dVar) {
        return t3(this, j10, dVar);
    }

    public final void A1(int i10) {
        wl.h hVar;
        wl.h.f fVar;
        a aVar;
        wl.e eVar = this.joining;
        if (eVar != null && (aVar = eVar.f19696a) != null) {
            aVar.flush();
        }
        do {
            hVar = (wl.h) this._state;
            fVar = wl.h.f.f19719c;
            if (hVar == fVar) {
                return;
            } else {
                hVar.f19708b.e();
            }
        } while (hVar != ((wl.h) this._state));
        int i11 = hVar.f19708b._availableForWrite$internal;
        if (hVar.f19708b._availableForRead$internal >= 1) {
            E2();
        }
        wl.e eVar2 = this.joining;
        if (i11 >= i10) {
            if (eVar2 == null || ((wl.h) this._state) == fVar) {
                G2();
            }
        }
    }

    public final a A2(a aVar, wl.e eVar) {
        while (((wl.h) aVar._state) == wl.h.f.f19719c) {
            aVar = eVar.f19696a;
            eVar = aVar.joining;
            if (eVar == null) {
                return aVar;
            }
        }
        return null;
    }

    public final void A3(int i10, nq.p<? super lm.l2> pVar) throws Throwable {
        Throwable thC;
        while (true) {
            wl.c cVar = (wl.c) this._closed;
            if (cVar != null && (thC = cVar.c()) != null) {
                pl.b.b(thC);
                throw new lm.y();
            }
            if (!B3(i10)) {
                c1.a aVar = c1.Companion;
                pVar.resumeWith(c1.m59constructorimpl(lm.l2.f10208a));
                break;
            }
            while (true) {
                if (((um.d) this._writeOp) != null) {
                    throw new IllegalStateException("Operation is already in progress");
                }
                if (!B3(i10)) {
                    break;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13173r;
                if (j.d.a(atomicReferenceFieldUpdater, this, null, pVar)) {
                    if (!B3(i10) && j.d.a(atomicReferenceFieldUpdater, this, pVar, null)) {
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        A1(i10);
        if (Q2()) {
            E2();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:51:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0069 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:51:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    /* JADX WARN: Code duplicated, block: B:37:0x008c  */
    /* JADX WARN: Code duplicated, block: B:40:0x009c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00a9 -> B:12:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.k
    @os.m
    public final java.lang.Object B(@os.l um.d<? super java.lang.Float> r10) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.B(um.d):java.lang.Object");
    }

    public final wl.c B1() {
        return (wl.c) this._closed;
    }

    public final void B2() {
        Object obj;
        wl.h hVarF;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        wl.h hVar = null;
        do {
            obj = this._state;
            wl.h hVar2 = (wl.h) obj;
            wl.h.b bVar = (wl.h.b) hVar;
            if (bVar != null) {
                bVar.f19708b.m();
                G2();
                hVar = null;
            }
            hVarF = hVar2.f();
            if ((hVarF instanceof wl.h.b) && ((wl.h) this._state) == hVar2 && hVarF.f19708b.q()) {
                hVarF = wl.h.a.f19709c;
                hVar = hVarF;
            }
            atomicReferenceFieldUpdater = f13170o;
        } while (!j.d.a(atomicReferenceFieldUpdater, this, obj, hVarF));
        wl.h.a aVar = wl.h.a.f19709c;
        if (hVarF == aVar) {
            wl.h.b bVar2 = (wl.h.b) hVar;
            if (bVar2 != null) {
                x2(bVar2.f19710c);
            }
            G2();
            return;
        }
        if ((hVarF instanceof wl.h.b) && hVarF.f19708b.j() && hVarF.f19708b.q() && j.d.a(atomicReferenceFieldUpdater, this, hVarF, aVar)) {
            hVarF.f19708b.m();
            x2(((wl.h.b) hVarF).f19710c);
            G2();
        }
    }

    public final boolean B3(int i10) {
        wl.e eVar = this.joining;
        wl.h hVar = (wl.h) this._state;
        if (((wl.c) this._closed) != null) {
            return false;
        }
        if (eVar == null) {
            if (hVar.f19708b._availableForWrite$internal >= i10 || hVar == wl.h.a.f19709c) {
                return false;
            }
        } else if (hVar == wl.h.f.f19719c || (hVar instanceof wl.h.g) || (hVar instanceof wl.h.e)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:50:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0069 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:50:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    /* JADX WARN: Code duplicated, block: B:37:0x008c  */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    /* JADX WARN: Code duplicated, block: B:41:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.Short] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009c -> B:12:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.k
    @os.m
    public final java.lang.Object C(@os.l um.d<? super java.lang.Short> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof pl.a.b0
            if (r0 == 0) goto L13
            r0 = r10
            pl.a$b0 r0 = (pl.a.b0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$b0 r0 = new pl.a$b0
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            pl.a r2 = (pl.a) r2
            lm.d1.n(r10)
            r8 = r0
            r0 = r9
            r9 = r2
        L2f:
            r2 = r8
            goto La0
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            lm.d1.n(r10)
            r10 = 2
        L3e:
            kn.k1$h r2 = new kn.k1$h
            r2.<init>()
            java.nio.ByteBuffer r4 = r9.O2()
            r5 = 0
            if (r4 != 0) goto L4b
            goto L7f
        L4b:
            java.lang.Object r6 = r9._state
            wl.h r6 = (wl.h) r6
            wl.j r6 = r6.f19708b
            int r7 = r6._availableForRead$internal     // Catch: java.lang.Throwable -> L6d
            if (r7 != 0) goto L5c
        L55:
            r9.B2()
            r9.U2()
            goto L7f
        L5c:
            boolean r7 = r6.t(r10)     // Catch: java.lang.Throwable -> L6d
            if (r7 != 0) goto L63
            goto L55
        L63:
            int r5 = r4.remaining()     // Catch: java.lang.Throwable -> L6d
            if (r5 >= r10) goto L6f
            r9.H2(r4, r10)     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r10 = move-exception
            goto Lb9
        L6f:
            short r5 = r4.getShort()     // Catch: java.lang.Throwable -> L6d
            java.lang.Short r7 = new java.lang.Short     // Catch: java.lang.Throwable -> L6d
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L6d
            r2.element = r7     // Catch: java.lang.Throwable -> L6d
            r9.l1(r4, r6, r10)     // Catch: java.lang.Throwable -> L6d
            r5 = r3
            goto L55
        L7f:
            if (r5 == 0) goto L8f
            T r9 = r2.element
            if (r9 != 0) goto L8c
            java.lang.String r9 = "result"
            kn.l0.S(r9)
            r9 = 0
            goto L8e
        L8c:
            java.lang.Number r9 = (java.lang.Number) r9
        L8e:
            return r9
        L8f:
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r2 = r9.n2(r10, r0)
            if (r2 != r1) goto L9c
            return r1
        L9c:
            r8 = r0
            r0 = r10
            r10 = r2
            goto L2f
        La0:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lab
            r10 = r0
            r0 = r2
            goto L3e
        Lab:
            pq.v r9 = new pq.v
            java.lang.String r10 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r10 = k.b.a(r10, r0, r1)
            r9.<init>(r10)
            throw r9
        Lb9:
            r9.B2()
            r9.U2()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.C(um.d):java.lang.Object");
    }

    @os.m
    public final wl.e C1() {
        return this.joining;
    }

    public final void C2() {
        Object obj;
        wl.h hVarG;
        wl.h.b bVar;
        wl.h hVar = null;
        do {
            obj = this._state;
            hVarG = ((wl.h) obj).g();
            if ((hVarG instanceof wl.h.b) && hVarG.f19708b.j()) {
                hVarG = wl.h.a.f19709c;
                hVar = hVarG;
            }
        } while (!j.d.a(f13170o, this, obj, hVarG));
        if (hVarG != wl.h.a.f19709c || (bVar = (wl.h.b) hVar) == null) {
            return;
        }
        x2(bVar.f19710c);
    }

    public final Object C3(ByteBuffer byteBuffer, int i10, wl.j jVar, jn.l<? super a, lm.l2> lVar, jn.l<? super ByteBuffer, lm.l2> lVar2, um.d<? super lm.l2> dVar) throws Throwable {
        do {
            try {
                y3(i10, dVar);
                if (this.joining != null) {
                    C2();
                    wl.e eVar = this.joining;
                    kn.l0.m(eVar);
                    if (((wl.h) this._state) == wl.h.f.f19719c) {
                        lVar.invoke(eVar.f19696a);
                    } else {
                        while (((wl.h) this._state) != wl.h.f.f19719c) {
                            y3(1, dVar);
                        }
                        lVar.invoke(eVar.f19696a);
                    }
                    return lm.l2.f10208a;
                }
            } catch (Throwable th2) {
                C2();
                U2();
                throw th2;
            }
        } while (!jVar.w(i10));
        Q1(byteBuffer, i10);
        if (byteBuffer.remaining() < i10) {
            byteBuffer.limit(byteBuffer.capacity());
            lVar2.invoke(byteBuffer);
            o1(byteBuffer);
        } else {
            lVar2.invoke(byteBuffer);
        }
        m1(byteBuffer, jVar, i10);
        if (jVar.k() || q0()) {
            flush();
        }
        C2();
        U2();
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d A[Catch: all -> 0x006e, TRY_ENTER, TryCatch #0 {all -> 0x006e, blocks: (B:20:0x0052, B:23:0x005d, B:26:0x0064, B:28:0x006a, B:31:0x0070), top: B:50:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006a A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:20:0x0052, B:23:0x005d, B:26:0x0064, B:28:0x006a, B:31:0x0070), top: B:50:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:37:0x008d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0090  */
    /* JADX WARN: Code duplicated, block: B:41:0x009c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.Long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009d -> B:12:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.k
    @os.m
    public final java.lang.Object D(@os.l um.d<? super java.lang.Long> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof pl.a.x
            if (r0 == 0) goto L13
            r0 = r11
            pl.a$x r0 = (pl.a.x) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$x r0 = new pl.a$x
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$0
            pl.a r2 = (pl.a) r2
            lm.d1.n(r11)
            r9 = r0
            r0 = r10
            r10 = r2
        L2f:
            r2 = r9
            goto La1
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            lm.d1.n(r11)
            r11 = 8
        L3f:
            kn.k1$h r2 = new kn.k1$h
            r2.<init>()
            java.nio.ByteBuffer r4 = r10.O2()
            r5 = 0
            if (r4 != 0) goto L4c
            goto L80
        L4c:
            java.lang.Object r6 = r10._state
            wl.h r6 = (wl.h) r6
            wl.j r6 = r6.f19708b
            int r7 = r6._availableForRead$internal     // Catch: java.lang.Throwable -> L6e
            if (r7 != 0) goto L5d
        L56:
            r10.B2()
            r10.U2()
            goto L80
        L5d:
            boolean r7 = r6.t(r11)     // Catch: java.lang.Throwable -> L6e
            if (r7 != 0) goto L64
            goto L56
        L64:
            int r5 = r4.remaining()     // Catch: java.lang.Throwable -> L6e
            if (r5 >= r11) goto L70
            r10.H2(r4, r11)     // Catch: java.lang.Throwable -> L6e
            goto L70
        L6e:
            r11 = move-exception
            goto Lba
        L70:
            long r7 = r4.getLong()     // Catch: java.lang.Throwable -> L6e
            java.lang.Long r5 = new java.lang.Long     // Catch: java.lang.Throwable -> L6e
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L6e
            r2.element = r5     // Catch: java.lang.Throwable -> L6e
            r10.l1(r4, r6, r11)     // Catch: java.lang.Throwable -> L6e
            r5 = r3
            goto L56
        L80:
            if (r5 == 0) goto L90
            T r10 = r2.element
            if (r10 != 0) goto L8d
            java.lang.String r10 = "result"
            kn.l0.S(r10)
            r10 = 0
            goto L8f
        L8d:
            java.lang.Number r10 = (java.lang.Number) r10
        L8f:
            return r10
        L90:
            r0.L$0 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r2 = r10.n2(r11, r0)
            if (r2 != r1) goto L9d
            return r1
        L9d:
            r9 = r0
            r0 = r11
            r11 = r2
            goto L2f
        La1:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto Lac
            r11 = r0
            r0 = r2
            goto L3f
        Lac:
            pq.v r10 = new pq.v
            java.lang.String r11 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r11 = k.b.a(r11, r0, r1)
            r10.<init>(r11)
            throw r10
        Lba:
            r10.B2()
            r10.U2()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.D(um.d):java.lang.Object");
    }

    public final void D2(Throwable th2) {
        um.d dVar = (um.d) f13172q.getAndSet(this, null);
        if (dVar != null) {
            if (th2 != null) {
                c1.a aVar = c1.Companion;
                w.a.a(th2, dVar);
            } else {
                Boolean boolValueOf = Boolean.valueOf(((wl.h) this._state).f19708b._availableForRead$internal > 0);
                c1.a aVar2 = c1.Companion;
                dVar.resumeWith(c1.m59constructorimpl(boolValueOf));
            }
        }
        um.d dVar2 = (um.d) f13173r.getAndSet(this, null);
        if (dVar2 == null) {
            return;
        }
        c1.a aVar3 = c1.Companion;
        if (th2 == null) {
            th2 = new pl.s(pl.b.f13187a);
        }
        w.a.a(th2, dVar2);
    }

    @Override // pl.k
    @os.m
    public Object E(long j10, int i10, @os.l um.d<? super tl.v> dVar) {
        return l2(this, j10, i10, dVar);
    }

    public final um.d<Boolean> E1() {
        return (um.d) this._readOp;
    }

    public final void E2() {
        um.d dVar = (um.d) f13172q.getAndSet(this, null);
        if (dVar == null) {
            return;
        }
        wl.c cVar = (wl.c) this._closed;
        Throwable th2 = cVar != null ? cVar.f19693a : null;
        if (th2 != null) {
            c1.a aVar = c1.Companion;
            w.a.a(th2, dVar);
        } else {
            Boolean bool = Boolean.TRUE;
            c1.a aVar2 = c1.Companion;
            dVar.resumeWith(c1.m59constructorimpl(bool));
        }
    }

    @Override // pl.k
    @os.m
    @tl.f0
    public Object F(@os.l jn.p<? super pl.j0, ? super um.d<? super lm.l2>, ? extends Object> pVar, @os.l um.d<? super lm.l2> dVar) {
        return r2(this, pVar, dVar);
    }

    public final void F2(jn.a<? extends Throwable> aVar) {
        um.d dVar = (um.d) f13172q.getAndSet(this, null);
        if (dVar == null) {
            return;
        }
        c1.a aVar2 = c1.Companion;
        w.a.a(aVar.invoke(), dVar);
    }

    public final boolean F3(ByteBuffer byteBuffer, wl.j jVar, jn.l<? super ByteBuffer, Boolean> lVar) {
        int iCapacity = byteBuffer.capacity() - this.f13177d;
        boolean z10 = true;
        while (z10) {
            int iU = jVar.u(1);
            if (iU == 0) {
                break;
            }
            int i10 = this.f13179f;
            int i11 = i10 + iU;
            if (i11 > iCapacity) {
                i11 = iCapacity;
            }
            byteBuffer.limit(i11);
            byteBuffer.position(i10);
            try {
                boolean zBooleanValue = lVar.invoke(byteBuffer).booleanValue();
                if (byteBuffer.limit() != i11) {
                    throw new IllegalStateException("Buffer limit modified.");
                }
                int iPosition = byteBuffer.position() - i10;
                if (iPosition < 0) {
                    throw new IllegalStateException("Position has been moved backward: pushback is not supported.");
                }
                m1(byteBuffer, jVar, iPosition);
                if (iPosition < iU) {
                    jVar.a(iU - iPosition);
                }
                z10 = zBooleanValue;
            } catch (Throwable th2) {
                jVar.a(iU);
                throw th2;
            }
        }
        return z10;
    }

    @Override // pl.k
    @os.m
    public <R> Object G(@os.l jn.p<? super pl.d0, ? super um.d<? super R>, ? extends Object> pVar, @os.l um.d<? super R> dVar) {
        return M1(this, pVar, dVar);
    }

    public final int G1() {
        return this.f13177d;
    }

    public final void G2() {
        um.d dVar;
        wl.c cVar;
        do {
            dVar = (um.d) this._writeOp;
            if (dVar == null) {
                return;
            }
            cVar = (wl.c) this._closed;
            if (cVar == null && this.joining != null) {
                wl.h hVar = (wl.h) this._state;
                if (!(hVar instanceof wl.h.g) && !(hVar instanceof wl.h.e) && hVar != wl.h.f.f19719c) {
                    return;
                }
            }
        } while (!j.d.a(f13173r, this, dVar, null));
        c1.a aVar = c1.Companion;
        dVar.resumeWith(c1.m59constructorimpl(cVar == null ? lm.l2.f10208a : d1.a(cVar.c())));
    }

    public final boolean G3(jn.l<? super ByteBuffer, Boolean> lVar) throws Throwable {
        a aVarA2;
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = A2(this, eVar)) == null) {
            aVarA2 = this;
        }
        ByteBuffer byteBufferP2 = aVarA2.P2();
        if (byteBufferP2 == null) {
            return true;
        }
        wl.j jVar = ((wl.h) aVarA2._state).f19708b;
        long jO = aVarA2.o();
        try {
            wl.c cVar = (wl.c) aVarA2._closed;
            if (cVar != null) {
                pl.b.b(cVar.c());
                throw new lm.y();
            }
            boolean zF3 = aVarA2.F3(byteBufferP2, jVar, lVar);
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            return zF3;
        } catch (Throwable th2) {
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            throw th2;
        }
    }

    @Override // pl.n
    @os.m
    public Object H(byte b10, @os.l um.d<? super lm.l2> dVar) {
        return h3(this, b10, dVar);
    }

    public final wl.h H1() {
        return (wl.h) this._state;
    }

    public final void H2(ByteBuffer byteBuffer, int i10) {
        int iRemaining = byteBuffer.remaining();
        byteBuffer.limit(byteBuffer.position() + i10);
        int i11 = i10 - iRemaining;
        for (int i12 = 0; i12 < i11; i12++) {
            byteBuffer.put((byteBuffer.capacity() - 8) + i12, byteBuffer.get(i12));
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cf A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:37:0x00ca, B:40:0x00cf, B:42:0x00d5, B:45:0x00df, B:34:0x00ad), top: B:87:0x00ca }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d5 A[Catch: all -> 0x00d9, TryCatch #1 {all -> 0x00d9, blocks: (B:37:0x00ca, B:40:0x00cf, B:42:0x00d5, B:45:0x00df, B:34:0x00ad), top: B:87:0x00ca }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00df A[Catch: all -> 0x00d9, TRY_LEAVE, TryCatch #1 {all -> 0x00d9, blocks: (B:37:0x00ca, B:40:0x00cf, B:42:0x00d5, B:45:0x00df, B:34:0x00ad), top: B:87:0x00ca }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:57:0x010e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0111  */
    /* JADX WARN: Code duplicated, block: B:61:0x0117  */
    /* JADX WARN: Code duplicated, block: B:63:0x011b  */
    /* JADX WARN: Code duplicated, block: B:65:0x011e  */
    /* JADX WARN: Code duplicated, block: B:67:0x0139 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x013d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e3, code lost:
    
        if (((wl.c) r10._closed) != null) goto L47;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c7 -> B:87:0x00ca). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H3(jn.l<? super java.nio.ByteBuffer, java.lang.Boolean> r17, um.d<? super lm.l2> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.H3(jn.l, um.d):java.lang.Object");
    }

    @Override // pl.k
    @os.m
    public Object I(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar, @os.l um.d<? super lm.l2> dVar) {
        return R1(this, i10, lVar, dVar);
    }

    public final void I2(wl.c cVar) {
        this._closed = cVar;
    }

    public final void I3(jn.q<? super a, ? super ByteBuffer, ? super wl.j, lm.l2> qVar) throws Throwable {
        a aVarA2;
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = A2(this, eVar)) == null) {
            aVarA2 = this;
        }
        ByteBuffer byteBufferP2 = aVarA2.P2();
        if (byteBufferP2 == null) {
            return;
        }
        wl.j jVar = ((wl.h) aVarA2._state).f19708b;
        long jO = aVarA2.o();
        try {
            wl.c cVar = (wl.c) aVarA2._closed;
            if (cVar != null) {
                pl.b.b(cVar.c());
                throw new lm.y();
            }
            qVar.invoke(aVarA2, byteBufferP2, jVar);
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
        } catch (Throwable th2) {
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            throw th2;
        }
    }

    @Override // pl.n
    @os.m
    @tl.f0
    public Object J(@os.l jn.p<? super pl.p0, ? super um.d<? super lm.l2>, ? extends Object> pVar, @os.l um.d<? super lm.l2> dVar) {
        return D3(this, pVar, dVar);
    }

    public final um.d<lm.l2> J1() {
        return (um.d) this._writeOp;
    }

    public final void J2(um.d<? super Boolean> dVar) {
        this._readOp = dVar;
    }

    @Override // pl.k
    @os.m
    public final Object K(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar) throws Throwable {
        int iS1 = S1(byteBuffer);
        return !byteBuffer.hasRemaining() ? new Integer(iS1) : e2(byteBuffer, iS1, dVar);
    }

    @os.m
    public final Object K1(@os.l a aVar, boolean z10, @os.l um.d<? super lm.l2> dVar) {
        if (((wl.c) aVar._closed) != null && ((wl.h) aVar._state) == wl.h.f.f19719c) {
            if (z10) {
                wl.c cVar = (wl.c) aVar._closed;
                kn.l0.m(cVar);
                f(cVar.f19693a);
            }
            return lm.l2.f10208a;
        }
        wl.c cVar2 = (wl.c) this._closed;
        if (cVar2 != null) {
            if (((wl.c) aVar._closed) != null) {
                return lm.l2.f10208a;
            }
            pl.b.b(cVar2.c());
            throw new lm.y();
        }
        wl.e eVarN2 = aVar.N2(this, z10);
        if (aVar.S2(eVarN2)) {
            Object objH1 = aVar.h1(dVar);
            return objH1 == wm.a.COROUTINE_SUSPENDED ? objH1 : lm.l2.f10208a;
        }
        Object objL1 = L1(aVar, z10, eVarN2, dVar);
        return objL1 == wm.a.COROUTINE_SUSPENDED ? objL1 : lm.l2.f10208a;
    }

    public void K2(long j10) {
        this.totalBytesRead = j10;
    }

    @Override // pl.n
    @os.m
    public Object L(@os.l tl.o0 o0Var, @os.l um.d<? super Integer> dVar) {
        return d3(this, o0Var, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object L1(a aVar, boolean z10, wl.e eVar, um.d<? super lm.l2> dVar) {
        h hVar;
        if (dVar instanceof h) {
            hVar = (h) dVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar);
            }
        } else {
            hVar = new h(dVar);
        }
        Object obj = hVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = hVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                z10 = hVar.Z$0;
                aVar = (a) hVar.L$1;
                this = (a) hVar.L$0;
                d1.n(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return lm.l2.f10208a;
        }
        d1.n(obj);
        hVar.L$0 = this;
        hVar.L$1 = aVar;
        hVar.Z$0 = z10;
        hVar.label = 1;
        if (s1(aVar, Long.MAX_VALUE, eVar, hVar) == aVar2) {
            return aVar2;
        }
        if (z10 && aVar.p0()) {
            pl.o.a(this);
            return lm.l2.f10208a;
        }
        this.flush();
        hVar.L$0 = null;
        hVar.L$1 = null;
        hVar.label = 2;
        if (aVar.h1(hVar) == aVar2) {
            return aVar2;
        }
        return lm.l2.f10208a;
    }

    public void L2(long j10) {
        this.totalBytesWritten = j10;
    }

    @Override // pl.n
    @os.m
    public Object M(@os.l ByteBuffer byteBuffer, @os.l um.d<? super lm.l2> dVar) {
        return k3(this, byteBuffer, dVar);
    }

    public final void M2(um.d<? super lm.l2> dVar) {
        this._writeOp = dVar;
    }

    @Override // pl.n
    @os.m
    @tl.f0
    public Object N(@os.l um.d<? super lm.l2> dVar) {
        return j1(this, dVar);
    }

    public final wl.h.c N1() {
        wl.h.c cVarW0 = this.f13176c.W0();
        cVarW0.f19712d.order(R().getNioOrder());
        cVarW0.f19711c.order(o0().getNioOrder());
        cVarW0.f19708b.m();
        return cVarW0;
    }

    public final wl.e N2(a aVar, boolean z10) {
        if (this == aVar) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        wl.e eVar = new wl.e(aVar, z10);
        aVar.g(o0());
        this.joining = eVar;
        wl.c cVar = (wl.c) this._closed;
        if (cVar == null) {
            flush();
            return eVar;
        }
        Throwable th2 = cVar.f19693a;
        if (th2 != null) {
            aVar.f(th2);
        } else if (z10 && ((wl.h) this._state) == wl.h.f.f19719c) {
            pl.o.a(aVar);
        } else {
            aVar.flush();
        }
        return eVar;
    }

    @Override // pl.k
    @os.m
    public <A extends Appendable> Object O(@os.l A a10, int i10, @os.l um.d<? super Boolean> dVar) {
        return u2(a10, i10, dVar);
    }

    public final ByteBuffer O2() throws Throwable {
        Object obj;
        Throwable th2;
        Throwable th3;
        wl.h hVarD;
        Throwable th4;
        do {
            obj = this._state;
            wl.h hVar = (wl.h) obj;
            if (kn.l0.g(hVar, wl.h.f.f19719c)) {
                wl.c cVar = (wl.c) this._closed;
                if (cVar == null || (th2 = cVar.f19693a) == null) {
                    return null;
                }
                pl.b.b(th2);
                throw new lm.y();
            }
            if (kn.l0.g(hVar, wl.h.a.f19709c)) {
                wl.c cVar2 = (wl.c) this._closed;
                if (cVar2 == null || (th3 = cVar2.f19693a) == null) {
                    return null;
                }
                pl.b.b(th3);
                throw new lm.y();
            }
            wl.c cVar3 = (wl.c) this._closed;
            if (cVar3 != null && (th4 = cVar3.f19693a) != null) {
                pl.b.b(th4);
                throw new lm.y();
            }
            if (hVar.f19708b._availableForRead$internal == 0) {
                return null;
            }
            hVarD = hVar.d();
        } while (!j.d.a(f13170o, this, obj, hVarD));
        ByteBuffer byteBufferB = hVarD.b();
        P1(byteBufferB, R(), this.f13178e, hVarD.f19708b._availableForRead$internal);
        return byteBufferB;
    }

    @Override // pl.k
    @os.m
    public Object P(long j10, @os.l um.d<? super Long> dVar) {
        return w1(this, j10, dVar);
    }

    public final void P1(ByteBuffer byteBuffer, tl.q qVar, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int iCapacity = byteBuffer.capacity() - this.f13177d;
        int i12 = i11 + i10;
        byteBuffer.order(qVar.getNioOrder());
        if (i12 <= iCapacity) {
            iCapacity = i12;
        }
        byteBuffer.limit(iCapacity);
        byteBuffer.position(i10);
    }

    @os.m
    public final ByteBuffer P2() throws Throwable {
        Object obj;
        wl.h hVar;
        wl.h.a aVar;
        wl.h hVarE;
        um.d dVar = (um.d) this._writeOp;
        if (dVar != null) {
            throw new IllegalStateException(kn.l0.C("Write operation is already in progress: ", dVar));
        }
        wl.h hVar2 = null;
        wl.h.c cVarN1 = null;
        do {
            obj = this._state;
            hVar = (wl.h) obj;
            if (this.joining != null) {
                if (cVarN1 != null) {
                    x2(cVarN1);
                }
                return null;
            }
            if (((wl.c) this._closed) != null) {
                if (cVarN1 != null) {
                    x2(cVarN1);
                }
                wl.c cVar = (wl.c) this._closed;
                kn.l0.m(cVar);
                pl.b.b(cVar.c());
                throw new lm.y();
            }
            aVar = wl.h.a.f19709c;
            if (hVar == aVar) {
                if (cVarN1 == null) {
                    cVarN1 = N1();
                }
                hVarE = cVarN1.f19715g;
            } else {
                if (hVar == wl.h.f.f19719c) {
                    if (cVarN1 != null) {
                        x2(cVarN1);
                    }
                    if (this.joining != null) {
                        return null;
                    }
                    wl.c cVar2 = (wl.c) this._closed;
                    kn.l0.m(cVar2);
                    pl.b.b(cVar2.c());
                    throw new lm.y();
                }
                hVarE = hVar.e();
            }
        } while (!j.d.a(f13170o, this, obj, hVarE));
        if (((wl.c) this._closed) != null) {
            C2();
            U2();
            wl.c cVar3 = (wl.c) this._closed;
            kn.l0.m(cVar3);
            pl.b.b(cVar3.c());
            throw new lm.y();
        }
        ByteBuffer byteBufferC = hVarE.c();
        if (cVarN1 != null) {
            if (hVar == null) {
                kn.l0.S("old");
            } else {
                hVar2 = hVar;
            }
            if (hVar2 != aVar) {
                x2(cVarN1);
            }
        }
        P1(byteBufferC, o0(), this.f13179f, hVarE.f19708b._availableForWrite$internal);
        return byteBufferC;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0037 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    @Override // pl.k
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public final Object Q(jn.p pVar, um.d dVar) throws Throwable {
        Object objR1;
        ByteBuffer byteBufferO2 = O2();
        if (byteBufferO2 != null) {
            wl.j jVar = ((wl.h) this._state).f19708b;
            try {
                if (jVar._availableForRead$internal != 0) {
                    while (byteBufferO2.hasRemaining()) {
                        boolean zBooleanValue = ((Boolean) pVar.invoke(byteBufferO2, Boolean.FALSE)).booleanValue();
                        f1(byteBufferO2, jVar);
                        if (!zBooleanValue) {
                            B2();
                            U2();
                        }
                    }
                }
                B2();
                U2();
                if (((wl.c) this._closed) != null) {
                    objR1 = r1(pVar, dVar);
                    if (objR1 == wm.a.COROUTINE_SUSPENDED) {
                        return objR1;
                    }
                    return lm.l2.f10208a;
                }
                pVar.invoke(wl.i.a(), Boolean.TRUE);
            } catch (Throwable th2) {
                B2();
                U2();
                throw th2;
            }
        } else {
            if (((wl.c) this._closed) != null) {
                objR1 = r1(pVar, dVar);
                if (objR1 == wm.a.COROUTINE_SUSPENDED) {
                    return objR1;
                }
                return lm.l2.f10208a;
            }
            pVar.invoke(wl.i.a(), Boolean.TRUE);
        }
        return lm.l2.f10208a;
    }

    public final void Q1(@os.l ByteBuffer byteBuffer, int i10) {
        kn.l0.p(byteBuffer, "buffer");
        P1(byteBuffer, o0(), this.f13179f, i10);
    }

    public final boolean Q2() {
        return this.joining != null && (((wl.h) this._state) == wl.h.a.f19709c || (((wl.h) this._state) instanceof wl.h.b));
    }

    @Override // pl.k
    @os.l
    public tl.q R() {
        return this.f13180g;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0000 A[EDGE_INSN: B:80:0x0000->B:75:0x0000 BREAK  A[LOOP:1: B:14:0x0022->B:81:?], SYNTHETIC] */
    public final Object R2(int i10, um.d<? super Boolean> dVar) {
        while (true) {
            wl.h hVar = (wl.h) this._state;
            if (hVar.f19708b._availableForRead$internal >= i10 || !(this.joining == null || ((um.d) this._writeOp) == null || (hVar != wl.h.a.f19709c && !(hVar instanceof wl.h.b)))) {
                break;
            }
            wl.c cVar = (wl.c) this._closed;
            if (cVar != null) {
                Throwable th2 = cVar.f19693a;
                if (th2 != null) {
                    c1.a aVar = c1.Companion;
                    w.a.a(th2, dVar);
                    return wm.a.COROUTINE_SUSPENDED;
                }
                boolean zE = ((wl.h) this._state).f19708b.e();
                boolean z10 = false;
                boolean z11 = ((wl.h) this._state).f19708b._availableForRead$internal >= i10;
                c1.a aVar2 = c1.Companion;
                if (zE && z11) {
                    z10 = true;
                }
                dVar.resumeWith(c1.m59constructorimpl(Boolean.valueOf(z10)));
                return wm.a.COROUTINE_SUSPENDED;
            }
            while (true) {
                if (((um.d) this._readOp) != null) {
                    throw new IllegalStateException("Operation is already in progress");
                }
                if (((wl.c) this._closed) != null) {
                    break;
                }
                wl.h hVar2 = (wl.h) this._state;
                if (hVar2.f19708b._availableForRead$internal >= i10 || !(this.joining == null || ((um.d) this._writeOp) == null || (hVar2 != wl.h.a.f19709c && !(hVar2 instanceof wl.h.b)))) {
                    break;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f13172q;
                if (j.d.a(atomicReferenceFieldUpdater, this, null, dVar)) {
                    if (((wl.c) this._closed) != null) {
                        if (!j.d.a(atomicReferenceFieldUpdater, this, dVar, null)) {
                            break;
                            break;
                        }
                    } else {
                        wl.h hVar3 = (wl.h) this._state;
                        if (hVar3.f19708b._availableForRead$internal >= i10 || (this.joining != null && ((um.d) this._writeOp) != null && (hVar3 == wl.h.a.f19709c || (hVar3 instanceof wl.h.b)))) {
                            if (!j.d.a(atomicReferenceFieldUpdater, this, dVar, null)) {
                                break;
                            }
                        }
                    }
                }
            }
            return wm.a.COROUTINE_SUSPENDED;
        }
        c1.a aVar3 = c1.Companion;
        dVar.resumeWith(c1.m59constructorimpl(Boolean.TRUE));
        return wm.a.COROUTINE_SUSPENDED;
    }

    @Override // pl.k
    public int S(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar) throws Throwable {
        int i11;
        kn.l0.p(lVar, "block");
        if (i10 <= 0) {
            throw new IllegalArgumentException("min should be positive");
        }
        if (i10 > 4088) {
            throw new IllegalArgumentException(k.b.a("Min(", i10, ") shouldn't be greater than 4088").toString());
        }
        ByteBuffer byteBufferO2 = O2();
        boolean z10 = false;
        if (byteBufferO2 == null) {
            i11 = 0;
        } else {
            wl.j jVar = ((wl.h) this._state).f19708b;
            try {
                if (jVar._availableForRead$internal == 0) {
                    B2();
                    U2();
                    i11 = 0;
                } else {
                    int iR = jVar.r(i10);
                    if (iR <= 0 || iR < i10) {
                        i11 = 0;
                    } else {
                        int iPosition = byteBufferO2.position();
                        int iLimit = byteBufferO2.limit();
                        lVar.invoke(byteBufferO2);
                        if (iLimit != byteBufferO2.limit()) {
                            throw new IllegalStateException("Buffer limit shouldn't be modified.");
                        }
                        int iPosition2 = byteBufferO2.position() - iPosition;
                        if (iPosition2 < 0) {
                            throw new IllegalStateException("Position shouldn't been moved backwards.");
                        }
                        l1(byteBufferO2, jVar, iPosition2);
                        if (iPosition2 < iR) {
                            jVar.c(iR - iPosition2);
                        }
                        z10 = true;
                        i11 = iPosition2;
                    }
                    B2();
                    U2();
                }
            } catch (Throwable th2) {
                B2();
                U2();
                throw th2;
            }
        }
        if (z10) {
            return i11;
        }
        return -1;
    }

    public final int S1(ByteBuffer byteBuffer) throws Throwable {
        ByteBuffer byteBufferO2 = O2();
        int i10 = 0;
        if (byteBufferO2 != null) {
            wl.j jVar = ((wl.h) this._state).f19708b;
            try {
                if (jVar._availableForRead$internal != 0) {
                    int iCapacity = byteBufferO2.capacity() - this.f13177d;
                    while (true) {
                        int iRemaining = byteBuffer.remaining();
                        if (iRemaining == 0) {
                            break;
                        }
                        int i11 = this.f13178e;
                        int iS = jVar.s(Math.min(iCapacity - i11, iRemaining));
                        if (iS == 0) {
                            break;
                        }
                        byteBufferO2.limit(i11 + iS);
                        byteBufferO2.position(i11);
                        byteBuffer.put(byteBufferO2);
                        l1(byteBufferO2, jVar, iS);
                        i10 += iS;
                    }
                }
                B2();
                U2();
            } catch (Throwable th2) {
                B2();
                U2();
                throw th2;
            }
        }
        return i10;
    }

    public final boolean S2(wl.e eVar) {
        if (!T2(true)) {
            return false;
        }
        z1(eVar);
        um.d dVar = (um.d) f13172q.getAndSet(this, null);
        if (dVar != null) {
            c1.a aVar = c1.Companion;
            dVar.resumeWith(c1.m59constructorimpl(d1.a(new IllegalStateException("Joining is in progress"))));
        }
        G2();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d A[Catch: all -> 0x006e, TRY_ENTER, TryCatch #0 {all -> 0x006e, blocks: (B:20:0x0052, B:23:0x005d, B:26:0x0064, B:28:0x006a, B:31:0x0070), top: B:51:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006a A[Catch: all -> 0x006e, TryCatch #0 {all -> 0x006e, blocks: (B:20:0x0052, B:23:0x005d, B:26:0x0064, B:28:0x006a, B:31:0x0070), top: B:51:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:37:0x008d  */
    /* JADX WARN: Code duplicated, block: B:40:0x009d  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.Long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00aa -> B:12:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.k
    @os.m
    public final java.lang.Object T(@os.l um.d<? super java.lang.Double> r11) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.T(um.d):java.lang.Object");
    }

    public final int T1(tl.e eVar, int i10, int i11) throws Throwable {
        int iS;
        do {
            ByteBuffer byteBufferO2 = O2();
            boolean z10 = false;
            if (byteBufferO2 == null) {
                iS = 0;
            } else {
                wl.j jVar = ((wl.h) this._state).f19708b;
                try {
                    if (jVar._availableForRead$internal == 0) {
                        B2();
                        U2();
                        iS = 0;
                    } else {
                        tl.m mVar = eVar.f15821b;
                        int i12 = mVar.f15872a - mVar.f15874c;
                        iS = jVar.s(Math.min(byteBufferO2.remaining(), Math.min(i12, i11)));
                        if (iS > 0) {
                            if (i12 < byteBufferO2.remaining()) {
                                byteBufferO2.limit(byteBufferO2.position() + i12);
                            }
                            tl.k.b(eVar, byteBufferO2);
                            l1(byteBufferO2, jVar, iS);
                            z10 = true;
                        }
                        B2();
                        U2();
                    }
                } catch (Throwable th2) {
                    B2();
                    U2();
                    throw th2;
                }
            }
            i10 += iS;
            i11 -= iS;
            if (!z10) {
                break;
            }
            tl.m mVar2 = eVar.f15821b;
            if (mVar2.f15872a <= mVar2.f15874c) {
                break;
            }
        } while (((wl.h) this._state).f19708b._availableForRead$internal > 0);
        return i10;
    }

    public final boolean T2(boolean z10) {
        Object obj;
        wl.h.f fVar;
        wl.h.c cVar = null;
        do {
            obj = this._state;
            wl.h hVar = (wl.h) obj;
            if (cVar != null) {
                cVar.f19708b.m();
                G2();
                cVar = null;
            }
            wl.c cVar2 = (wl.c) this._closed;
            fVar = wl.h.f.f19719c;
            if (hVar == fVar) {
                return true;
            }
            if (hVar != wl.h.a.f19709c) {
                if (cVar2 != null && (hVar instanceof wl.h.b) && (hVar.f19708b.q() || cVar2.f19693a != null)) {
                    if (cVar2.f19693a != null) {
                        hVar.f19708b.f();
                    }
                    cVar = ((wl.h.b) hVar).f19710c;
                } else {
                    if (!z10 || !(hVar instanceof wl.h.b) || !hVar.f19708b.q()) {
                        return false;
                    }
                    cVar = ((wl.h.b) hVar).f19710c;
                }
            }
        } while (!j.d.a(f13170o, this, obj, fVar));
        if (cVar != null && ((wl.h) this._state) == fVar) {
            x2(cVar);
        }
        return true;
    }

    @Override // pl.k
    public long U() {
        return this.totalBytesRead;
    }

    public final int U1(byte[] bArr, int i10, int i11) throws Throwable {
        ByteBuffer byteBufferO2 = O2();
        int i12 = 0;
        if (byteBufferO2 != null) {
            wl.j jVar = ((wl.h) this._state).f19708b;
            try {
                if (jVar._availableForRead$internal != 0) {
                    int iCapacity = byteBufferO2.capacity() - this.f13177d;
                    while (true) {
                        int i13 = i11 - i12;
                        if (i13 == 0) {
                            break;
                        }
                        int i14 = this.f13178e;
                        int iS = jVar.s(Math.min(iCapacity - i14, i13));
                        if (iS == 0) {
                            break;
                        }
                        byteBufferO2.limit(i14 + iS);
                        byteBufferO2.position(i14);
                        byteBufferO2.get(bArr, i10 + i12, iS);
                        l1(byteBufferO2, jVar, iS);
                        i12 += iS;
                    }
                }
                B2();
                U2();
            } catch (Throwable th2) {
                B2();
                U2();
                throw th2;
            }
        }
        return i12;
    }

    public final boolean U2() {
        if (((wl.c) this._closed) == null || !T2(false)) {
            return false;
        }
        wl.e eVar = this.joining;
        if (eVar != null) {
            z1(eVar);
        }
        E2();
        G2();
        return true;
    }

    @Override // pl.a0
    @os.m
    public pl.p0 V() {
        wl.o oVar = this.f13183j;
        oVar.e();
        return oVar;
    }

    public final int V2(tl.v vVar) throws Throwable {
        a aVarA2;
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = A2(this, eVar)) == null) {
            aVarA2 = this;
        }
        ByteBuffer byteBufferP2 = aVarA2.P2();
        if (byteBufferP2 == null) {
            return 0;
        }
        wl.j jVar = ((wl.h) aVarA2._state).f19708b;
        long jO = aVarA2.o();
        try {
            wl.c cVar = (wl.c) aVarA2._closed;
            if (cVar != null) {
                pl.b.b(cVar.c());
                throw new lm.y();
            }
            int iV = jVar.v((int) Math.min(vVar.S0(), byteBufferP2.remaining()));
            if (iV > 0) {
                byteBufferP2.limit(byteBufferP2.position() + iV);
                tl.p.o(vVar, byteBufferP2);
                aVarA2.m1(byteBufferP2, jVar, iV);
            }
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            return iV;
        } catch (Throwable th2) {
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            throw th2;
        }
    }

    @Override // pl.a0
    public void W(int i10) {
        this.f13183j.a(i10);
        this.f13183j.f();
    }

    public final boolean W2(ByteBuffer byteBuffer, int i10, wl.j jVar, jn.l<? super ByteBuffer, lm.l2> lVar) {
        if (!jVar.w(i10)) {
            return false;
        }
        Q1(byteBuffer, i10);
        if (byteBuffer.remaining() < i10) {
            byteBuffer.limit(byteBuffer.capacity());
            lVar.invoke(byteBuffer);
            o1(byteBuffer);
        } else {
            lVar.invoke(byteBuffer);
        }
        m1(byteBuffer, jVar, i10);
        if (jVar.k() || q0()) {
            flush();
        }
        C2();
        U2();
        return true;
    }

    @Override // pl.k
    public <R> R X(@os.l jn.l<? super pl.b0, ? extends R> lVar) {
        kn.l0.p(lVar, "visitor");
        Throwable thA = a();
        if (thA != null) {
            return lVar.invoke(new wl.d(thA));
        }
        if (((wl.h) this._state) == wl.h.f.f19719c) {
            return lVar.invoke(wl.m.f19728b);
        }
        boolean z10 = false;
        R rInvoke = null;
        if (O2() != null) {
            try {
                if (((wl.h) this._state).f19708b._availableForRead$internal == 0) {
                    B2();
                    U2();
                } else {
                    rInvoke = lVar.invoke(this);
                    B2();
                    U2();
                    z10 = true;
                }
            } catch (Throwable th2) {
                B2();
                U2();
                throw th2;
            }
        }
        if (z10) {
            kn.l0.m(rInvoke);
            return rInvoke;
        }
        Throwable thA2 = a();
        return thA2 == null ? lVar.invoke(wl.m.f19728b) : lVar.invoke(new wl.d(thA2));
    }

    @os.m
    public final Object X2(int i10, @os.l um.d<? super lm.l2> dVar) throws Throwable {
        Throwable thC;
        if (!B3(i10)) {
            wl.c cVar = (wl.c) this._closed;
            if (cVar != null && (thC = cVar.c()) != null) {
                pl.b.b(thC);
                throw new lm.y();
            }
            if (wm.a.COROUTINE_SUSPENDED == null) {
                return null;
            }
            return lm.l2.f10208a;
        }
        this.writeSuspensionSize = i10;
        if (this.attachedJob != null) {
            Object objInvoke = this.f13186m.invoke(dVar);
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (objInvoke == aVar) {
                xm.h.c(dVar);
            }
            return objInvoke == aVar ? objInvoke : lm.l2.f10208a;
        }
        wl.b<lm.l2> bVar = this.f13185l;
        this.f13186m.invoke(bVar);
        Object objH = bVar.h(wm.c.e(dVar));
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        if (objH == aVar2) {
            xm.h.c(dVar);
        }
        return objH == aVar2 ? objH : lm.l2.f10208a;
    }

    @Override // pl.k
    @os.m
    public Object Y(@os.l um.d<? super lm.l2> dVar) {
        return i1(this, dVar);
    }

    @Override // pl.z
    @os.l
    public pl.j0 Z() {
        return this.f13182i;
    }

    public final int Z2(ByteBuffer byteBuffer) throws Throwable {
        a aVarA2;
        int iV;
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = A2(this, eVar)) == null) {
            aVarA2 = this;
        }
        ByteBuffer byteBufferP2 = aVarA2.P2();
        int i10 = 0;
        if (byteBufferP2 == null) {
            return 0;
        }
        wl.j jVar = ((wl.h) aVarA2._state).f19708b;
        long jO = aVarA2.o();
        try {
            wl.c cVar = (wl.c) aVarA2._closed;
            if (cVar != null) {
                pl.b.b(cVar.c());
                throw new lm.y();
            }
            int iLimit = byteBuffer.limit();
            while (true) {
                int iPosition = iLimit - byteBuffer.position();
                if (iPosition != 0 && (iV = jVar.v(Math.min(iPosition, byteBufferP2.remaining()))) != 0) {
                    if (iV <= 0) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    byteBuffer.limit(byteBuffer.position() + iV);
                    byteBufferP2.put(byteBuffer);
                    i10 += iV;
                    aVarA2.P1(byteBufferP2, aVarA2.o0(), aVarA2.p1(byteBufferP2, aVarA2.f13179f + i10), jVar._availableForWrite$internal);
                }
                byteBuffer.limit(iLimit);
                aVarA2.m1(byteBufferP2, jVar, i10);
                if (jVar.k() || aVarA2.q0()) {
                    aVarA2.flush();
                }
                if (aVarA2 != this) {
                    L2((aVarA2.o() - jO) + o());
                }
                aVarA2.C2();
                aVarA2.U2();
                return i10;
            }
        } catch (Throwable th2) {
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            throw th2;
        }
    }

    @Override // pl.k, pl.n
    @os.m
    public Throwable a() {
        wl.c cVar = (wl.c) this._closed;
        if (cVar == null) {
            return null;
        }
        return cVar.f19693a;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:50:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0069 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:50:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0080  */
    /* JADX WARN: Code duplicated, block: B:36:0x0084  */
    /* JADX WARN: Code duplicated, block: B:37:0x008b  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:41:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x009b  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Byte] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009b -> B:12:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.k
    @os.m
    public final java.lang.Object a0(@os.l um.d<? super java.lang.Byte> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof pl.a.q
            if (r0 == 0) goto L13
            r0 = r10
            pl.a$q r0 = (pl.a.q) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$q r0 = new pl.a$q
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            pl.a r2 = (pl.a) r2
            lm.d1.n(r10)
            r8 = r0
            r0 = r9
            r9 = r2
        L2f:
            r2 = r8
            goto L9f
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            lm.d1.n(r10)
            r10 = r3
        L3e:
            kn.k1$h r2 = new kn.k1$h
            r2.<init>()
            java.nio.ByteBuffer r4 = r9.O2()
            r5 = 0
            if (r4 != 0) goto L4b
            goto L7e
        L4b:
            java.lang.Object r6 = r9._state
            wl.h r6 = (wl.h) r6
            wl.j r6 = r6.f19708b
            int r7 = r6._availableForRead$internal     // Catch: java.lang.Throwable -> L6d
            if (r7 != 0) goto L5c
        L55:
            r9.B2()
            r9.U2()
            goto L7e
        L5c:
            boolean r7 = r6.t(r10)     // Catch: java.lang.Throwable -> L6d
            if (r7 != 0) goto L63
            goto L55
        L63:
            int r5 = r4.remaining()     // Catch: java.lang.Throwable -> L6d
            if (r5 >= r10) goto L6f
            r9.H2(r4, r10)     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r10 = move-exception
            goto Lb8
        L6f:
            byte r5 = r4.get()     // Catch: java.lang.Throwable -> L6d
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)     // Catch: java.lang.Throwable -> L6d
            r2.element = r5     // Catch: java.lang.Throwable -> L6d
            r9.l1(r4, r6, r10)     // Catch: java.lang.Throwable -> L6d
            r5 = r3
            goto L55
        L7e:
            if (r5 == 0) goto L8e
            T r9 = r2.element
            if (r9 != 0) goto L8b
            java.lang.String r9 = "result"
            kn.l0.S(r9)
            r9 = 0
            goto L8d
        L8b:
            java.lang.Number r9 = (java.lang.Number) r9
        L8d:
            return r9
        L8e:
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r2 = r9.n2(r10, r0)
            if (r2 != r1) goto L9b
            return r1
        L9b:
            r8 = r0
            r0 = r10
            r10 = r2
            goto L2f
        L9f:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Laa
            r10 = r0
            r0 = r2
            goto L3e
        Laa:
            pq.v r9 = new pq.v
            java.lang.String r10 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r10 = k.b.a(r10, r0, r1)
            r9.<init>(r10)
            throw r9
        Lb8:
            r9.B2()
            r9.U2()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.a0(um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a2(tl.o0 o0Var, um.d<? super Integer> dVar) throws Throwable {
        n nVar;
        if (dVar instanceof n) {
            nVar = (n) dVar;
            int i10 = nVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                nVar.label = i10 - Integer.MIN_VALUE;
            } else {
                nVar = new n(dVar);
            }
        } else {
            nVar = new n(dVar);
        }
        Object objN2 = nVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = nVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                o0Var = (tl.o0) nVar.L$1;
                this = (a) nVar.L$0;
                d1.n(objN2);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objN2);
            }
        }
        d1.n(objN2);
        nVar.L$0 = this;
        nVar.L$1 = o0Var;
        nVar.label = 1;
        objN2 = n2(1, nVar);
        if (objN2 == aVar) {
            return aVar;
        }
        if (!((Boolean) objN2).booleanValue()) {
            return new Integer(-1);
        }
        nVar.L$0 = null;
        nVar.L$1 = null;
        nVar.label = 2;
        objN2 = this.n(o0Var, nVar);
        return objN2 == aVar ? aVar : objN2;
    }

    public final int a3(tl.e eVar) throws Throwable {
        a aVarA2;
        wl.e eVar2 = this.joining;
        if (eVar2 == null || (aVarA2 = A2(this, eVar2)) == null) {
            aVarA2 = this;
        }
        ByteBuffer byteBufferP2 = aVarA2.P2();
        int i10 = 0;
        if (byteBufferP2 == null) {
            return 0;
        }
        wl.j jVar = ((wl.h) aVarA2._state).f19708b;
        long jO = aVarA2.o();
        try {
            wl.c cVar = (wl.c) aVarA2._closed;
            if (cVar != null) {
                pl.b.b(cVar.c());
                throw new lm.y();
            }
            while (true) {
                tl.m mVar = eVar.f15821b;
                int iV = jVar.v(Math.min(mVar.f15874c - mVar.f15873b, byteBufferP2.remaining()));
                if (iV == 0) {
                    break;
                }
                tl.p0.d(eVar, byteBufferP2, iV);
                i10 += iV;
                aVarA2.P1(byteBufferP2, aVarA2.o0(), aVarA2.p1(byteBufferP2, aVarA2.f13179f + i10), jVar._availableForWrite$internal);
            }
            aVarA2.m1(byteBufferP2, jVar, i10);
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            return i10;
        } catch (Throwable th2) {
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            throw th2;
        }
    }

    @Override // pl.b0
    @os.m
    public ByteBuffer b(int i10, int i11) {
        wl.h hVar = (wl.h) this._state;
        int i12 = hVar.f19708b._availableForRead$internal;
        int i13 = this.f13178e;
        if (i12 < i11 + i10) {
            return null;
        }
        if (hVar.a() || !((hVar instanceof wl.h.d) || (hVar instanceof wl.h.e))) {
            if (O2() == null) {
                return null;
            }
            return b(i10, i11);
        }
        ByteBuffer byteBufferB = hVar.b();
        P1(byteBufferB, R(), p1(byteBufferB, i13 + i10), i12 - i10);
        if (byteBufferB.remaining() >= i11) {
            return byteBufferB;
        }
        return null;
    }

    @Override // pl.b0
    public void b0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        wl.h hVar = (wl.h) this._state;
        if (!hVar.f19708b.t(i10)) {
            throw new IllegalStateException(k.b.a("Unable to consume ", i10, " bytes: not enough available bytes"));
        }
        if (i10 > 0) {
            l1(hVar.b(), hVar.f19708b, i10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b2(byte[] bArr, int i10, int i11, um.d<? super Integer> dVar) throws Throwable {
        l lVar;
        if (dVar instanceof l) {
            lVar = (l) dVar;
            int i12 = lVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                lVar.label = i12 - Integer.MIN_VALUE;
            } else {
                lVar = new l(dVar);
            }
        } else {
            lVar = new l(dVar);
        }
        Object objN2 = lVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = lVar.label;
        if (i13 != 0) {
            if (i13 == 1) {
                i11 = lVar.I$1;
                i10 = lVar.I$0;
                bArr = (byte[]) lVar.L$1;
                this = (a) lVar.L$0;
                d1.n(objN2);
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objN2);
            }
        }
        d1.n(objN2);
        lVar.L$0 = this;
        lVar.L$1 = bArr;
        lVar.I$0 = i10;
        lVar.I$1 = i11;
        lVar.label = 1;
        objN2 = n2(1, lVar);
        if (objN2 == aVar) {
            return aVar;
        }
        if (!((Boolean) objN2).booleanValue()) {
            return new Integer(-1);
        }
        lVar.L$0 = null;
        lVar.L$1 = null;
        lVar.label = 2;
        objN2 = this.v(bArr, i10, i11, lVar);
        return objN2 == aVar ? aVar : objN2;
    }

    public final int b3(byte[] bArr, int i10, int i11) throws Throwable {
        a aVarA2;
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = A2(this, eVar)) == null) {
            aVarA2 = this;
        }
        ByteBuffer byteBufferP2 = aVarA2.P2();
        int i12 = 0;
        if (byteBufferP2 == null) {
            return 0;
        }
        wl.j jVar = ((wl.h) aVarA2._state).f19708b;
        long jO = aVarA2.o();
        try {
            wl.c cVar = (wl.c) aVarA2._closed;
            if (cVar != null) {
                pl.b.b(cVar.c());
                throw new lm.y();
            }
            while (true) {
                int iV = jVar.v(Math.min(i11 - i12, byteBufferP2.remaining()));
                if (iV == 0) {
                    aVarA2.m1(byteBufferP2, jVar, i12);
                    if (jVar.k() || aVarA2.q0()) {
                        aVarA2.flush();
                    }
                    if (aVarA2 != this) {
                        L2((aVarA2.o() - jO) + o());
                    }
                    aVarA2.C2();
                    aVarA2.U2();
                    return i12;
                }
                if (iV <= 0) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                byteBufferP2.put(bArr, i10 + i12, iV);
                i12 += iV;
                aVarA2.P1(byteBufferP2, aVarA2.o0(), aVarA2.p1(byteBufferP2, aVarA2.f13179f + i12), jVar._availableForWrite$internal);
            }
        } catch (Throwable th2) {
            if (jVar.k() || aVarA2.q0()) {
                aVarA2.flush();
            }
            if (aVarA2 != this) {
                L2((aVarA2.o() - jO) + o());
            }
            aVarA2.C2();
            aVarA2.U2();
            throw th2;
        }
    }

    @Override // pl.k
    public boolean c(@os.m Throwable th2) {
        if (th2 == null) {
            th2 = new CancellationException("Channel has been cancelled");
        }
        return f(th2);
    }

    @Override // pl.k
    @os.m
    public Object c0(int i10, @os.l um.d<? super String> dVar) {
        return s2(this, i10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c2(int i10, jn.l<? super ByteBuffer, lm.l2> lVar, um.d<? super lm.l2> dVar) throws Throwable {
        o oVar;
        if (dVar instanceof o) {
            oVar = (o) dVar;
            int i11 = oVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                oVar.label = i11 - Integer.MIN_VALUE;
            } else {
                oVar = new o(dVar);
            }
        } else {
            oVar = new o(dVar);
        }
        Object objN2 = oVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = oVar.label;
        if (i12 != 0) {
            if (i12 == 1) {
                i10 = oVar.I$0;
                lVar = (jn.l) oVar.L$1;
                this = (a) oVar.L$0;
                d1.n(objN2);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objN2);
            }
            return lm.l2.f10208a;
        }
        d1.n(objN2);
        int i13 = i10 < 1 ? 1 : i10;
        oVar.L$0 = this;
        oVar.L$1 = lVar;
        oVar.I$0 = i10;
        oVar.label = 1;
        objN2 = n2(i13, oVar);
        if (objN2 == aVar) {
            return aVar;
        }
        if (!((Boolean) objN2).booleanValue()) {
            if (i10 <= 0) {
                return lm.l2.f10208a;
            }
            throw new EOFException(k.b.a("Got EOF but at least ", i10, " bytes were expected"));
        }
        oVar.L$0 = null;
        oVar.L$1 = null;
        oVar.label = 2;
        if (this.I(i10, lVar, oVar) == aVar) {
            return aVar;
        }
        return lm.l2.f10208a;
    }

    @Override // pl.k
    public int d() {
        return ((wl.h) this._state).f19708b._availableForRead$internal;
    }

    @Override // pl.k
    @os.m
    public Object d0(@os.l ByteBuffer byteBuffer, long j10, long j11, long j12, long j13, @os.l um.d<? super Long> dVar) {
        return O1(this, byteBuffer, j10, j11, j12, j13, dVar);
    }

    @Override // pl.k, pl.n
    public boolean e() {
        return ((wl.c) this._closed) != null;
    }

    @Override // pl.n
    @os.m
    public Object e0(short s10, @os.l um.d<? super lm.l2> dVar) {
        return x3(this, s10, dVar);
    }

    @Override // pl.n
    public boolean f(@os.m Throwable th2) {
        wl.c cVar;
        wl.e eVar;
        if (((wl.c) this._closed) != null) {
            return false;
        }
        if (th2 == null) {
            wl.c.f19691b.getClass();
            cVar = wl.c.f19692c;
        } else {
            cVar = new wl.c(th2);
        }
        ((wl.h) this._state).f19708b.e();
        if (!j.d.a(f13171p, this, null, cVar)) {
            return false;
        }
        ((wl.h) this._state).f19708b.e();
        if (((wl.h) this._state).f19708b.j() || th2 != null) {
            U2();
        }
        D2(th2);
        if (((wl.h) this._state) == wl.h.f.f19719c && (eVar = this.joining) != null) {
            z1(eVar);
        }
        if (th2 == null) {
            this.f13185l.f(new pl.s(pl.b.f13187a));
            this.f13184k.d(Boolean.valueOf(((wl.h) this._state).f19708b.e()));
            return true;
        }
        l2 l2Var = this.attachedJob;
        if (l2Var != null) {
            l2.a.b(l2Var, null, 1, null);
        }
        this.f13184k.f(th2);
        this.f13185l.f(th2);
        return true;
    }

    @Override // pl.n
    @os.m
    public Object f0(float f10, @os.l um.d<? super lm.l2> dVar) {
        return j3(this, f10, dVar);
    }

    public final int f1(ByteBuffer byteBuffer, wl.j jVar) {
        int iPosition = byteBuffer.position() - this.f13178e;
        if (iPosition > 0) {
            if (!jVar.t(iPosition)) {
                throw new IllegalStateException("Consumed more bytes than available");
            }
            l1(byteBuffer, jVar, iPosition);
            P1(byteBuffer, R(), this.f13178e, jVar._availableForRead$internal);
        }
        return iPosition;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0063 -> B:12:0x0035). Please report as a decompilation issue!!! */
    public final Object f2(tl.o0 o0Var, int i10, um.d<? super lm.l2> dVar) throws Throwable {
        u uVar;
        a aVar;
        int iV1;
        int i11;
        tl.o0 o0Var2;
        tl.m mVar;
        u uVar2;
        int i12;
        if (dVar instanceof u) {
            uVar = (u) dVar;
            int i13 = uVar.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                uVar.label = i13 - Integer.MIN_VALUE;
            } else {
                uVar = new u(dVar);
            }
        } else {
            uVar = new u(dVar);
        }
        Object obj = uVar.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i14 = uVar.label;
        if (i14 == 0) {
            d1.n(obj);
            aVar = this;
            iV1 = 0;
            i11 = i10;
            o0Var2 = o0Var;
            mVar = o0Var2.f15821b;
            if (mVar.f15872a > mVar.f15874c || iV1 >= i11) {
                return lm.l2.f10208a;
            }
            uVar.L$0 = aVar;
            uVar.L$1 = o0Var2;
            uVar.I$0 = i11;
            uVar.I$1 = iV1;
            uVar.label = 1;
            Object objN2 = aVar.n2(1, uVar);
            if (objN2 == aVar2) {
                return aVar2;
            }
            uVar2 = uVar;
            i12 = i11;
            obj = objN2;
        } else {
            if (i14 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iV1 = uVar.I$1;
            int i15 = uVar.I$0;
            o0Var2 = (tl.o0) uVar.L$1;
            a aVar3 = (a) uVar.L$0;
            d1.n(obj);
            uVar2 = uVar;
            i12 = i15;
            aVar = aVar3;
        }
        u uVar3 = uVar2;
        if (!((Boolean) obj).booleanValue()) {
            throw new pq.v("Unexpected EOF: expected " + (i12 - iV1) + " more bytes");
        }
        iV1 += V1(aVar, o0Var2, 0, i12 - iV1, 2, null);
        i11 = i12;
        uVar = uVar3;
        mVar = o0Var2.f15821b;
        if (mVar.f15872a > mVar.f15874c) {
        }
        return lm.l2.f10208a;
    }

    @Override // pl.n
    public void flush() {
        A1(1);
    }

    @Override // pl.n
    public void g(@os.l tl.q qVar) {
        kn.l0.p(qVar, "newOrder");
        if (this.f13181h != qVar) {
            this.f13181h = qVar;
            wl.e eVar = this.joining;
            a aVar = eVar == null ? null : eVar.f19696a;
            if (aVar == null) {
                return;
            }
            aVar.g(qVar);
        }
    }

    @Override // pl.n
    @os.m
    public Object g0(@os.l jn.l<? super ByteBuffer, Boolean> lVar, @os.l um.d<? super lm.l2> dVar) {
        return E3(this, lVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g1(int i10, um.d<? super Boolean> dVar) throws Throwable {
        c cVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i11 = cVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                cVar.label = i11 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object objN2 = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = cVar.label;
        if (i12 == 0) {
            d1.n(objN2);
            cVar.L$0 = this;
            cVar.label = 1;
            objN2 = n2(i10, cVar);
            if (objN2 == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (a) cVar.L$0;
            d1.n(objN2);
        }
        boolean zBooleanValue = ((Boolean) objN2).booleanValue();
        if (zBooleanValue && ((wl.h) this._state).a()) {
            this.O2();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @Override // pl.n
    @os.m
    public Object h(@os.l tl.e eVar, @os.l um.d<? super lm.l2> dVar) {
        return l3(this, eVar, dVar);
    }

    @Override // pl.n
    @os.m
    public Object h0(int i10, @os.l um.d<? super lm.l2> dVar) {
        return s3(this, i10, dVar);
    }

    public final Object h1(um.d<? super lm.l2> dVar) {
        if (((wl.c) this._closed) != null) {
            return lm.l2.f10208a;
        }
        wl.e eVar = this.joining;
        if (eVar != null) {
            Object objA = eVar.a(dVar);
            return objA == wm.a.COROUTINE_SUSPENDED ? objA : lm.l2.f10208a;
        }
        if (((wl.c) this._closed) != null) {
            return lm.l2.f10208a;
        }
        throw new IllegalStateException("Only works for joined.");
    }

    public final boolean h2(pl.b0 b0Var, Appendable appendable, char[] cArr, CharBuffer charBuffer, jn.l<? super Integer, Boolean> lVar, jn.l<? super Integer, lm.l2> lVar2, jn.l<? super ByteBuffer, Long> lVar3) throws IOException {
        ByteBuffer byteBufferB;
        int i10 = 1;
        while (lVar.invoke(Integer.valueOf(i10)).booleanValue() && (byteBufferB = b0Var.b(0, 1)) != null) {
            int iPosition = byteBufferB.position();
            if (byteBufferB.remaining() < i10) {
                H2(byteBufferB, i10);
            }
            long jLongValue = lVar3.invoke(byteBufferB).longValue();
            b0Var.b0(byteBufferB.position() - iPosition);
            int i11 = (int) (jLongValue >> 32);
            int i12 = (int) (jLongValue & 4294967295L);
            int iMax = -1;
            if (i12 == -1) {
                iMax = 0;
            } else if (i12 != 0 || !byteBufferB.hasRemaining()) {
                iMax = Math.max(1, i12);
            }
            lVar2.invoke(Integer.valueOf(i11));
            if (appendable instanceof StringBuilder) {
                ((StringBuilder) appendable).append(cArr, 0, i11);
            } else {
                appendable.append(charBuffer, 0, i11);
            }
            i10 = iMax;
            if (iMax <= 0) {
                break;
            }
        }
        return i10 == 0;
    }

    @Override // pl.n
    @os.m
    public Object i(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super lm.l2> dVar) {
        return n3(this, bArr, i10, i11, dVar);
    }

    @Override // pl.k
    @tl.f0
    public void i0(@os.l jn.l<? super pl.f0, lm.l2> lVar) {
        kn.l0.p(lVar, "consumer");
        X(new a0(lVar, this));
    }

    @Override // pl.c
    public void j(@os.l l2 l2Var) {
        kn.l0.p(l2Var, "job");
        l2 l2Var2 = this.attachedJob;
        if (l2Var2 != null) {
            l2.a.b(l2Var2, null, 1, null);
        }
        this.attachedJob = l2Var;
        l2.a.g(l2Var, true, false, new b(), 2, null);
    }

    @Override // pl.n
    @os.m
    public Object j0(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar) {
        return c3(this, byteBuffer, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:20:0x0044, B:22:0x004d, B:25:0x0054, B:31:0x007b), top: B:39:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0064 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0065 -> B:29:0x0069). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object j2(int r6, tl.s r7, java.nio.ByteBuffer r8, um.d<? super tl.v> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof pl.a.y
            if (r0 == 0) goto L13
            r0 = r9
            pl.a$y r0 = (pl.a.y) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$y r0 = new pl.a$y
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$2
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$1
            tl.s r7 = (tl.s) r7
            java.lang.Object r8 = r0.L$0
            pl.a r8 = (pl.a) r8
            lm.d1.n(r9)     // Catch: java.lang.Throwable -> L35
            goto L69
        L35:
            r5 = move-exception
            goto L87
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            lm.d1.n(r9)
        L42:
            if (r6 <= 0) goto L7b
            r8.clear()     // Catch: java.lang.Throwable -> L51
            int r9 = r8.remaining()     // Catch: java.lang.Throwable -> L51
            if (r9 <= r6) goto L54
            r8.limit(r6)     // Catch: java.lang.Throwable -> L51
            goto L54
        L51:
            r5 = move-exception
            r6 = r8
            goto L87
        L54:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L51
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L51
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L51
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L51
            r0.label = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r9 = r5.K(r8, r0)     // Catch: java.lang.Throwable -> L51
            if (r9 != r1) goto L65
            return r1
        L65:
            r4 = r8
            r8 = r5
            r5 = r6
            r6 = r4
        L69:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: java.lang.Throwable -> L35
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L35
            r6.flip()     // Catch: java.lang.Throwable -> L35
            tl.r0.a(r7, r6)     // Catch: java.lang.Throwable -> L35
            int r5 = r5 - r9
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r4
            goto L42
        L7b:
            tl.v r5 = r7.z2()     // Catch: java.lang.Throwable -> L51
            bm.h r6 = wl.f.d()
            r6.recycle(r8)
            return r5
        L87:
            r7.close()     // Catch: java.lang.Throwable -> L8b
            throw r5     // Catch: java.lang.Throwable -> L8b
        L8b:
            r5 = move-exception
            bm.h r7 = wl.f.d()
            r7.recycle(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.j2(int, tl.s, java.nio.ByteBuffer, um.d):java.lang.Object");
    }

    @Override // pl.n
    public int k(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar) throws Throwable {
        a aVarA2;
        int i11;
        int i12;
        kn.l0.p(lVar, "block");
        if (i10 <= 0) {
            throw new IllegalArgumentException("min should be positive");
        }
        if (i10 > 4088) {
            throw new IllegalArgumentException(k.b.a("Min(", i10, ") shouldn't be greater than 4088").toString());
        }
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = A2(this, eVar)) == null) {
            aVarA2 = this;
        }
        ByteBuffer byteBufferP2 = aVarA2.P2();
        int iPosition = 0;
        if (byteBufferP2 == null) {
            i12 = 0;
        } else {
            wl.j jVar = ((wl.h) aVarA2._state).f19708b;
            long jO = aVarA2.o();
            try {
                wl.c cVar = (wl.c) aVarA2._closed;
                if (cVar != null) {
                    pl.b.b(cVar.c());
                    throw new lm.y();
                }
                int iU = jVar.u(i10);
                if (iU <= 0) {
                    i11 = 0;
                } else {
                    aVarA2.P1(byteBufferP2, aVarA2.o0(), aVarA2.f13179f, iU);
                    int iPosition2 = byteBufferP2.position();
                    int iLimit = byteBufferP2.limit();
                    lVar.invoke(byteBufferP2);
                    if (iLimit != byteBufferP2.limit()) {
                        throw new IllegalStateException("Buffer limit modified");
                    }
                    iPosition = byteBufferP2.position() - iPosition2;
                    if (iPosition < 0) {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported");
                    }
                    if (iPosition < 0) {
                        throw new IllegalStateException();
                    }
                    aVarA2.m1(byteBufferP2, jVar, iPosition);
                    if (iPosition < iU) {
                        jVar.a(iU - iPosition);
                    }
                    i11 = 1;
                }
                if (jVar.k() || aVarA2.q0()) {
                    aVarA2.flush();
                }
                if (aVarA2 != this) {
                    L2((aVarA2.o() - jO) + o());
                }
                aVarA2.C2();
                aVarA2.U2();
                i12 = iPosition;
                iPosition = i11;
            } catch (Throwable th2) {
                if (jVar.k() || aVarA2.q0()) {
                    aVarA2.flush();
                }
                if (aVarA2 != this) {
                    L2((aVarA2.o() - jO) + o());
                }
                aVarA2.C2();
                aVarA2.U2();
                throw th2;
            }
        }
        if (iPosition == 0) {
            return -1;
        }
        return i12;
    }

    @Override // pl.n
    @os.m
    public Object k0(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar, @os.l um.d<? super lm.l2> dVar) {
        return Y2(this, i10, lVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object k1(int i10, jn.l<? super ByteBuffer, lm.l2> lVar, um.d<? super lm.l2> dVar) {
        d dVar2;
        a aVarA2;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i11 = dVar2.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i11 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object obj = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = dVar2.label;
        if (i12 != 0) {
            if (i12 == 1) {
                i10 = dVar2.I$0;
                lVar = (jn.l) dVar2.L$1;
                this = (a) dVar2.L$0;
                d1.n(obj);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return lm.l2.f10208a;
        }
        d1.n(obj);
        dVar2.L$0 = this;
        dVar2.L$1 = lVar;
        dVar2.I$0 = i10;
        dVar2.label = 1;
        if (y3(i10, dVar2) == aVar) {
            return aVar;
        }
        wl.e eVar = this.joining;
        if (eVar == null || (aVarA2 = this.A2(this, eVar)) == null) {
            return lm.l2.f10208a;
        }
        dVar2.L$0 = null;
        dVar2.L$1 = null;
        dVar2.label = 2;
        if (aVarA2.k0(i10, lVar, dVar2) == aVar) {
            return aVar;
        }
        return lm.l2.f10208a;
    }

    public final <T extends Number> Object k2(int i10, jn.l<? super ByteBuffer, ? extends T> lVar, um.d<? super T> dVar) throws Throwable {
        T t10;
        do {
            ByteBuffer byteBufferO2 = O2();
            boolean z10 = false;
            if (byteBufferO2 == null) {
                t10 = null;
            } else {
                wl.j jVar = ((wl.h) this._state).f19708b;
                try {
                    if (jVar._availableForRead$internal == 0) {
                        B2();
                        U2();
                        t10 = null;
                    } else {
                        if (jVar.t(i10)) {
                            if (byteBufferO2.remaining() < i10) {
                                H2(byteBufferO2, i10);
                            }
                            T tInvoke = lVar.invoke(byteBufferO2);
                            l1(byteBufferO2, jVar, i10);
                            z10 = true;
                            t10 = tInvoke;
                        } else {
                            t10 = null;
                        }
                        B2();
                        U2();
                    }
                } catch (Throwable th2) {
                    B2();
                    U2();
                    throw th2;
                }
            }
            if (z10) {
                if (t10 != null) {
                    return t10;
                }
                kn.l0.S("result");
                return null;
            }
        } while (((Boolean) n2(i10, dVar)).booleanValue());
        throw new pq.v(k.b.a("EOF while ", i10, " bytes expected"));
    }

    @Override // pl.k
    @os.m
    public final Object l(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super lm.l2> dVar) throws Throwable {
        Object objG2;
        int iU1 = U1(bArr, i10, i11);
        return (iU1 >= i11 || (objG2 = g2(bArr, i10 + iU1, i11 - iU1, dVar)) != wm.a.COROUTINE_SUSPENDED) ? lm.l2.f10208a : objG2;
    }

    @Override // pl.z
    public void l0() {
        this.f13182i.a();
        wl.h hVar = (wl.h) this._state;
        if ((hVar instanceof wl.h.d) || (hVar instanceof wl.h.e)) {
            B2();
            U2();
        }
    }

    public final void l1(ByteBuffer byteBuffer, wl.j jVar, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f13178e = p1(byteBuffer, this.f13178e + i10);
        jVar.a(i10);
        K2(U() + ((long) i10));
        G2();
    }

    @Override // pl.k
    public void m(@os.l tl.q qVar) {
        kn.l0.p(qVar, "<set-?>");
        this.f13180g = qVar;
    }

    @Override // pl.n
    @os.m
    public Object m0(@os.l tl.o0 o0Var, @os.l um.d<? super lm.l2> dVar) {
        return m3(this, o0Var, dVar);
    }

    public final void m1(ByteBuffer byteBuffer, wl.j jVar, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f13179f = p1(byteBuffer, this.f13179f + i10);
        jVar.c(i10);
        L2(o() + ((long) i10));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006d A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:48:0x00d0, B:22:0x0063, B:24:0x006d, B:27:0x0077, B:29:0x008d, B:31:0x0093), top: B:58:0x00d0 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x008d A[Catch: all -> 0x0072, TryCatch #0 {all -> 0x0072, blocks: (B:48:0x00d0, B:22:0x0063, B:24:0x006d, B:27:0x0077, B:29:0x008d, B:31:0x0093), top: B:58:0x00d0 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c7 A[Catch: all -> 0x00cc, TryCatch #2 {all -> 0x00cc, blocks: (B:41:0x00be, B:43:0x00c7, B:47:0x00cf), top: B:62:0x00be }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #2 {all -> 0x00cc, blocks: (B:41:0x00be, B:43:0x00c7, B:47:0x00cf), top: B:62:0x00be }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a6 -> B:35:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00bb -> B:40:0x00bc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object m2(long r12, int r14, um.d<? super tl.v> r15) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.m2(long, int, um.d):java.lang.Object");
    }

    @Override // pl.k
    @os.m
    public Object n(@os.l tl.o0 o0Var, @os.l um.d<? super Integer> dVar) {
        return X1(this, o0Var, dVar);
    }

    @Override // pl.k
    @os.m
    public Object n0(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar) {
        return W1(this, byteBuffer, dVar);
    }

    public final void n1(@os.l ByteBuffer byteBuffer, @os.l wl.j jVar, int i10) {
        kn.l0.p(byteBuffer, "buffer");
        kn.l0.p(jVar, "capacity");
        m1(byteBuffer, jVar, i10);
    }

    public final Object n2(int i10, um.d<? super Boolean> dVar) throws Throwable {
        if (((wl.h) this._state).f19708b._availableForRead$internal >= i10) {
            return Boolean.TRUE;
        }
        wl.c cVar = (wl.c) this._closed;
        if (cVar == null) {
            return i10 == 1 ? o2(1, dVar) : p2(i10, dVar);
        }
        Throwable th2 = cVar.f19693a;
        if (th2 != null) {
            pl.b.b(th2);
            throw new lm.y();
        }
        wl.j jVar = ((wl.h) this._state).f19708b;
        boolean z10 = jVar.e() && jVar._availableForRead$internal >= i10;
        if (((um.d) this._readOp) == null) {
            return Boolean.valueOf(z10);
        }
        throw new IllegalStateException("Read operation is already in progress");
    }

    @Override // pl.n
    public long o() {
        return this.totalBytesWritten;
    }

    @Override // pl.n
    @os.l
    public tl.q o0() {
        return this.f13181h;
    }

    public final void o1(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - this.f13177d;
        int iPosition = byteBuffer.position();
        for (int i10 = iCapacity; i10 < iPosition; i10++) {
            byteBuffer.put(i10 - iCapacity, byteBuffer.get(i10));
        }
    }

    public final Object o2(int i10, um.d<? super Boolean> dVar) throws Throwable {
        wl.h hVar = (wl.h) this._state;
        if (hVar.f19708b._availableForRead$internal >= i10 || !(this.joining == null || ((um.d) this._writeOp) == null || (hVar != wl.h.a.f19709c && !(hVar instanceof wl.h.b)))) {
            return Boolean.TRUE;
        }
        wl.b<Boolean> bVar = this.f13184k;
        R2(i10, bVar);
        Object objH = bVar.h(wm.c.e(dVar));
        if (objH == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objH;
    }

    @Override // pl.n
    @os.m
    public Object p(@os.l tl.v vVar, @os.l um.d<? super lm.l2> dVar) {
        return u3(this, vVar, dVar);
    }

    @Override // pl.k
    public boolean p0() {
        return ((wl.h) this._state) == wl.h.f.f19719c && ((wl.c) this._closed) != null;
    }

    public final int p1(ByteBuffer byteBuffer, int i10) {
        return i10 >= byteBuffer.capacity() - this.f13177d ? i10 - (byteBuffer.capacity() - this.f13177d) : i10;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    /* JADX WARN: Code duplicated, block: B:23:0x005a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0063  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0058 -> B:24:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object p2(int r6, um.d<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof pl.a.c0
            if (r0 == 0) goto L13
            r0 = r7
            pl.a$c0 r0 = (pl.a.c0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$c0 r0 = new pl.a$c0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$0
            pl.a r6 = (pl.a) r6
            lm.d1.n(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L5b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            lm.d1.n(r7)
        L3b:
            java.lang.Object r7 = r5._state
            wl.h r7 = (wl.h) r7
            wl.j r7 = r7.f19708b
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L48
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            return r5
        L48:
            java.lang.Object r7 = r5._closed
            wl.c r7 = (wl.c) r7
            if (r7 != 0) goto L66
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.o2(r6, r0)
            if (r7 != r1) goto L5b
            return r1
        L5b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L3b
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L66:
            java.lang.Throwable r7 = r7.f19693a
            if (r7 != 0) goto L8f
            java.lang.Object r7 = r5._state
            wl.h r7 = (wl.h) r7
            wl.j r7 = r7.f19708b
            boolean r0 = r7.e()
            if (r0 == 0) goto L7b
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L7b
            goto L7c
        L7b:
            r3 = 0
        L7c:
            java.lang.Object r5 = r5._readOp
            um.d r5 = (um.d) r5
            if (r5 != 0) goto L87
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        L87:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Read operation is already in progress"
            r5.<init>(r6)
            throw r5
        L8f:
            pl.b.b(r7)
            lm.y r5 = new lm.y
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.p2(int, um.d):java.lang.Object");
    }

    @Override // pl.n
    public int q() {
        return ((wl.h) this._state).f19708b._availableForWrite$internal;
    }

    @Override // pl.n
    public boolean q0() {
        return this.f13175b;
    }

    public final boolean q1(boolean z10, jn.p<? super ByteBuffer, ? super Boolean, Boolean> pVar) throws Throwable {
        ByteBuffer byteBufferO2 = O2();
        if (byteBufferO2 == null) {
            z10 = false;
        } else {
            wl.j jVar = ((wl.h) this._state).f19708b;
            try {
                if (jVar._availableForRead$internal != 0) {
                    while (true) {
                        if (!byteBufferO2.hasRemaining() && !z10) {
                            B2();
                            U2();
                            break;
                        }
                        boolean zBooleanValue = pVar.invoke(byteBufferO2, Boolean.valueOf(z10)).booleanValue();
                        f1(byteBufferO2, jVar);
                        if (!zBooleanValue || (z10 && !byteBufferO2.hasRemaining())) {
                            B2();
                            U2();
                            return true;
                        }
                    }
                } else {
                    B2();
                    U2();
                    z10 = false;
                }
            } catch (Throwable th2) {
                B2();
                U2();
                throw th2;
            }
        }
        if (z10 || ((wl.c) this._closed) == null) {
            return z10;
        }
        pVar.invoke(wl.i.a(), Boolean.TRUE);
        return true;
    }

    public final boolean q2(int i10) {
        wl.h hVar = (wl.h) this._state;
        return hVar.f19708b._availableForRead$internal < i10 && (this.joining == null || ((um.d) this._writeOp) == null || !(hVar == wl.h.a.f19709c || (hVar instanceof wl.h.b)));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x005e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0075 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0056 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x004c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object q3(tl.o0 r7, um.d<? super lm.l2> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof pl.a.p0
            if (r0 == 0) goto L13
            r0 = r8
            pl.a$p0 r0 = (pl.a.p0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$p0 r0 = new pl.a$p0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lm.d1.n(r8)
            goto L76
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.lang.Object r6 = r0.L$1
            tl.o0 r6 = (tl.o0) r6
            java.lang.Object r7 = r0.L$0
            pl.a r7 = (pl.a) r7
            lm.d1.n(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L59
        L41:
            lm.d1.n(r8)
        L44:
            tl.m r8 = r7.f15821b
            int r2 = r8.f15874c
            int r8 = r8.f15873b
            if (r2 <= r8) goto L79
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.X2(r4, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            wl.e r8 = r6.joining
            if (r8 != 0) goto L5e
            goto L64
        L5e:
            pl.a r8 = r6.A2(r6, r8)
            if (r8 != 0) goto L68
        L64:
            r6.a3(r7)
            goto L44
        L68:
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r8.m0(r7, r0)
            if (r6 != r1) goto L76
            return r1
        L76:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L79:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.q3(tl.o0, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // pl.k
    @os.m
    public final Object r(@os.l um.d<? super Boolean> dVar) throws Throwable {
        p pVar;
        if (dVar instanceof p) {
            pVar = (p) dVar;
            int i10 = pVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                pVar.label = i10 - Integer.MIN_VALUE;
            } else {
                pVar = new p(dVar);
            }
        } else {
            pVar = new p(dVar);
        }
        Object objA0 = pVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = pVar.label;
        if (i11 == 0) {
            d1.n(objA0);
            pVar.label = 1;
            objA0 = a0(pVar);
            if (objA0 == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(objA0);
        }
        return Boolean.valueOf(((Number) objA0).byteValue() != 0);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0057  */
    /* JADX WARN: Code duplicated, block: B:22:0x005e A[Catch: all -> 0x00a5, LOOP:0: B:22:0x005e->B:68:0x005e, LOOP_START, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a5, blocks: (B:19:0x0053, B:22:0x005e, B:37:0x0089, B:40:0x009e), top: B:62:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0064 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x0086  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088  */
    /* JADX WARN: Code duplicated, block: B:39:0x009c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00a7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c7 -> B:56:0x00cb). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object r1(jn.p<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r9, um.d<? super lm.l2> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.r1(jn.p, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0040  */
    /* JADX WARN: Code duplicated, block: B:18:0x0050 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0051 -> B:20:0x0057). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object r3(byte[] r7, int r8, int r9, um.d<? super lm.l2> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof pl.a.q0
            if (r0 == 0) goto L13
            r0 = r10
            pl.a$q0 r0 = (pl.a.q0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$q0 r0 = new pl.a$q0
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.L$0
            pl.a r9 = (pl.a) r9
            lm.d1.n(r10)
            goto L57
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            lm.d1.n(r10)
        L3e:
            if (r9 <= 0) goto L66
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r3
            java.lang.Object r10 = r6.s(r7, r8, r9, r0)
            if (r10 != r1) goto L51
            return r1
        L51:
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
        L57:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            int r7 = r7 + r10
            int r6 = r6 - r10
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L3e
        L66:
            lm.l2 r6 = lm.l2.f10208a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.r3(byte[], int, int, um.d):java.lang.Object");
    }

    @Override // pl.n
    @os.m
    public Object s(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super Integer> dVar) {
        return e3(this, bArr, i10, i11, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:166:0x036f A[Catch: all -> 0x036c, TryCatch #7 {all -> 0x036c, blocks: (B:49:0x0138, B:51:0x013e, B:58:0x014c, B:158:0x0351, B:161:0x0359, B:163:0x0365, B:166:0x036f, B:169:0x0377, B:171:0x0380, B:189:0x03db, B:191:0x03df, B:61:0x0156, B:54:0x0143, B:209:0x0442, B:210:0x0445, B:48:0x012c), top: B:228:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0375  */
    /* JADX WARN: Code duplicated, block: B:169:0x0377 A[Catch: all -> 0x036c, TryCatch #7 {all -> 0x036c, blocks: (B:49:0x0138, B:51:0x013e, B:58:0x014c, B:158:0x0351, B:161:0x0359, B:163:0x0365, B:166:0x036f, B:169:0x0377, B:171:0x0380, B:189:0x03db, B:191:0x03df, B:61:0x0156, B:54:0x0143, B:209:0x0442, B:210:0x0445, B:48:0x012c), top: B:228:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0380 A[Catch: all -> 0x036c, TRY_LEAVE, TryCatch #7 {all -> 0x036c, blocks: (B:49:0x0138, B:51:0x013e, B:58:0x014c, B:158:0x0351, B:161:0x0359, B:163:0x0365, B:166:0x036f, B:169:0x0377, B:171:0x0380, B:189:0x03db, B:191:0x03df, B:61:0x0156, B:54:0x0143, B:209:0x0442, B:210:0x0445, B:48:0x012c), top: B:228:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:174:0x03a7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:175:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:178:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:179:0x03bb A[Catch: all -> 0x0061, TryCatch #1 {all -> 0x0061, blocks: (B:14:0x0049, B:176:0x03b1, B:179:0x03bb, B:183:0x03c4, B:21:0x0085), top: B:216:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:183:0x03c4 A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #1 {all -> 0x0061, blocks: (B:14:0x0049, B:176:0x03b1, B:179:0x03bb, B:183:0x03c4, B:21:0x0085), top: B:216:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:188:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:191:0x03df A[Catch: all -> 0x036c, TRY_LEAVE, TryCatch #7 {all -> 0x036c, blocks: (B:49:0x0138, B:51:0x013e, B:58:0x014c, B:158:0x0351, B:161:0x0359, B:163:0x0365, B:166:0x036f, B:169:0x0377, B:171:0x0380, B:189:0x03db, B:191:0x03df, B:61:0x0156, B:54:0x0143, B:209:0x0442, B:210:0x0445, B:48:0x012c), top: B:228:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0404 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:209:0x0442 A[Catch: all -> 0x036c, TRY_ENTER, TryCatch #7 {all -> 0x036c, blocks: (B:49:0x0138, B:51:0x013e, B:58:0x014c, B:158:0x0351, B:161:0x0359, B:163:0x0365, B:166:0x036f, B:169:0x0377, B:171:0x0380, B:189:0x03db, B:191:0x03df, B:61:0x0156, B:54:0x0143, B:209:0x0442, B:210:0x0445, B:48:0x012c), top: B:228:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:51:0x013e A[Catch: all -> 0x036c, TryCatch #7 {all -> 0x036c, blocks: (B:49:0x0138, B:51:0x013e, B:58:0x014c, B:158:0x0351, B:161:0x0359, B:163:0x0365, B:166:0x036f, B:169:0x0377, B:171:0x0380, B:189:0x03db, B:191:0x03df, B:61:0x0156, B:54:0x0143, B:209:0x0442, B:210:0x0445, B:48:0x012c), top: B:228:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0142 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x0143 A[Catch: all -> 0x036c, TryCatch #7 {all -> 0x036c, blocks: (B:49:0x0138, B:51:0x013e, B:58:0x014c, B:158:0x0351, B:161:0x0359, B:163:0x0365, B:166:0x036f, B:169:0x0377, B:171:0x0380, B:189:0x03db, B:191:0x03df, B:61:0x0156, B:54:0x0143, B:209:0x0442, B:210:0x0445, B:48:0x012c), top: B:228:0x012c }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0152  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:163:0x0365 -> B:49:0x0138). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x03dd -> B:194:0x0405). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x0402 -> B:194:0x0405). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public final java.lang.Object s1(@os.l pl.a r26, long r27, @os.m wl.e r29, @os.l um.d<? super java.lang.Long> r30) {
        /*
            Method dump skipped, instruction units count: 1105
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.s1(pl.a, long, wl.e, um.d):java.lang.Object");
    }

    @Override // pl.n
    @os.m
    public Object t(double d10, @os.l um.d<? super lm.l2> dVar) {
        return i3(this, d10, dVar);
    }

    @os.l
    public final wl.h t1() {
        return (wl.h) this._state;
    }

    @os.l
    public String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + ((wl.h) this._state) + ')';
    }

    @Override // pl.k
    @os.m
    public Object u(int i10, int i11, @os.l um.d<? super tl.v> dVar) {
        return i2(this, i10, i11, dVar);
    }

    public final Object u1(jn.l<? super a, lm.l2> lVar, um.d<? super lm.l2> dVar) throws Throwable {
        wl.e eVar = this.joining;
        kn.l0.m(eVar);
        if (((wl.h) this._state) == wl.h.f.f19719c) {
            lVar.invoke(eVar.f19696a);
            return lm.l2.f10208a;
        }
        while (((wl.h) this._state) != wl.h.f.f19719c) {
            y3(1, dVar);
        }
        lVar.invoke(eVar.f19696a);
        return lm.l2.f10208a;
    }

    public final Object u2(Appendable appendable, int i10, um.d<? super Boolean> dVar) throws Throwable {
        if (((wl.h) this._state) == wl.h.f.f19719c) {
            Throwable thA = a();
            if (thA == null) {
                return Boolean.FALSE;
            }
            throw thA;
        }
        k1.f fVar = new k1.f();
        char[] cArr = new char[8192];
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        k1.a aVar = new k1.a();
        X(new f0(aVar, this, appendable, cArr, charBufferWrap, fVar, i10));
        if (aVar.element) {
            return Boolean.TRUE;
        }
        if (fVar.element == 0 && p0()) {
            return Boolean.FALSE;
        }
        int i11 = i10 - fVar.element;
        kn.l0.o(charBufferWrap, "buffer");
        return v2(appendable, i11, cArr, charBufferWrap, fVar.element, dVar);
    }

    @Override // pl.k
    @os.m
    public Object v(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super Integer> dVar) {
        return Y1(this, bArr, i10, i11, dVar);
    }

    public final Object v1(wl.e eVar, jn.l<? super a, lm.l2> lVar, um.d<? super lm.l2> dVar) throws Throwable {
        while (((wl.h) this._state) != wl.h.f.f19719c) {
            y3(1, dVar);
        }
        lVar.invoke(eVar.f19696a);
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object v2(Appendable appendable, int i10, char[] cArr, CharBuffer charBuffer, int i11, um.d<? super Boolean> dVar) {
        g0 g0Var;
        k1.a aVar;
        if (dVar instanceof g0) {
            g0Var = (g0) dVar;
            int i12 = g0Var.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                g0Var.label = i12 - Integer.MIN_VALUE;
            } else {
                g0Var = new g0(dVar);
            }
        } else {
            g0Var = new g0(dVar);
        }
        g0 g0Var2 = g0Var;
        Object obj = g0Var2.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i13 = g0Var2.label;
        if (i13 == 0) {
            d1.n(obj);
            k1.f fVar = new k1.f();
            k1.a aVar3 = new k1.a();
            aVar3.element = true;
            h0 h0Var = new h0(appendable, cArr, charBuffer, fVar, i11, aVar3, i10, null);
            g0Var2.L$0 = aVar3;
            g0Var2.label = 1;
            if (G(h0Var, g0Var2) == aVar2) {
                return aVar2;
            }
            aVar = aVar3;
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            aVar = (k1.a) g0Var2.L$0;
            d1.n(obj);
        }
        return Boolean.valueOf(aVar.element);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0050 A[Catch: all -> 0x006c, TryCatch #0 {all -> 0x006c, blocks: (B:28:0x005d, B:33:0x0068, B:23:0x004a, B:25:0x0050, B:31:0x0062, B:36:0x0071), top: B:47:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:27:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0061 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062 A[Catch: all -> 0x006c, TryCatch #0 {all -> 0x006c, blocks: (B:28:0x005d, B:33:0x0068, B:23:0x004a, B:25:0x0050, B:31:0x0062, B:36:0x0071), top: B:47:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:38:0x007e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x007f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [pl.a] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [tl.a] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [tl.a] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, pl.a] */
    /* JADX WARN: Type inference failed for: r6v5, types: [pl.a] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005a -> B:47:0x005d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object v3(tl.v r7, um.d<? super lm.l2> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof pl.a.t0
            if (r0 == 0) goto L13
            r0 = r8
            pl.a$t0 r0 = (pl.a.t0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$t0 r0 = new pl.a$t0
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$0
            tl.v r6 = (tl.v) r6
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L2e
            goto L80
        L2e:
            r7 = move-exception
            goto L8c
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.L$1
            tl.v r6 = (tl.v) r6
            java.lang.Object r7 = r0.L$0
            pl.a r7 = (pl.a) r7
            lm.d1.n(r8)     // Catch: java.lang.Throwable -> L2e
            r5 = r7
            r7 = r6
            r6 = r5
            goto L5d
        L47:
            lm.d1.n(r8)
        L4a:
            boolean r8 = r7.B1()     // Catch: java.lang.Throwable -> L6c
            if (r8 != 0) goto L86
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6c
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L6c
            r0.label = r4     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r8 = r6.y3(r4, r0)     // Catch: java.lang.Throwable -> L6c
            if (r8 != r1) goto L5d
            return r1
        L5d:
            wl.e r8 = r6.joining     // Catch: java.lang.Throwable -> L6c
            if (r8 != 0) goto L62
            goto L68
        L62:
            pl.a r8 = r6.A2(r6, r8)     // Catch: java.lang.Throwable -> L6c
            if (r8 != 0) goto L71
        L68:
            r6.V2(r7)     // Catch: java.lang.Throwable -> L6c
            goto L4a
        L6c:
            r6 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L8c
        L71:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6c
            r6 = 0
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6c
            r0.label = r3     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r6 = r8.p(r7, r0)     // Catch: java.lang.Throwable -> L6c
            if (r6 != r1) goto L7f
            return r1
        L7f:
            r6 = r7
        L80:
            lm.l2 r7 = lm.l2.f10208a     // Catch: java.lang.Throwable -> L2e
            r6.z2()
            return r7
        L86:
            r7.z2()
            lm.l2 r6 = lm.l2.f10208a
            return r6
        L8c:
            r6.z2()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.v3(tl.v, um.d):java.lang.Object");
    }

    @Override // pl.d0
    @os.m
    public final Object w(int i10, @os.l um.d<? super Boolean> dVar) throws Throwable {
        if (i10 < 0) {
            throw new IllegalArgumentException(kn.l0.C("atLeast parameter shouldn't be negative: ", new Integer(i10)).toString());
        }
        if (i10 > 4088) {
            throw new IllegalArgumentException(kn.l0.C("atLeast parameter shouldn't be larger than max buffer size of 4088: ", new Integer(i10)).toString());
        }
        if (((wl.h) this._state).f19708b._availableForRead$internal >= i10) {
            if (((wl.h) this._state).a() || (((wl.h) this._state) instanceof wl.h.g)) {
                O2();
            }
            return Boolean.TRUE;
        }
        if (((wl.h) this._state).a() || (((wl.h) this._state) instanceof wl.h.g)) {
            return g1(i10, dVar);
        }
        return i10 == 1 ? o2(1, dVar) : n2(i10, dVar);
    }

    public final boolean w2(jn.p<? super ByteBuffer, ? super wl.j, Boolean> pVar) throws Throwable {
        ByteBuffer byteBufferO2 = O2();
        if (byteBufferO2 == null) {
            return false;
        }
        wl.j jVar = ((wl.h) this._state).f19708b;
        try {
            if (jVar._availableForRead$internal == 0) {
                return false;
            }
            return pVar.invoke(byteBufferO2, jVar).booleanValue();
        } finally {
            B2();
            U2();
        }
    }

    public final Object w3(int i10, jn.l<? super a, lm.l2> lVar, jn.l<? super ByteBuffer, lm.l2> lVar2, um.d<? super lm.l2> dVar) throws Throwable {
        a aVarA2;
        wl.e eVar = this.joining;
        if (eVar != null && (aVarA2 = A2(this, eVar)) != null) {
            lVar.invoke(aVarA2);
            return lm.l2.f10208a;
        }
        ByteBuffer byteBufferP2 = P2();
        if (byteBufferP2 == null) {
            wl.e eVar2 = this.joining;
            kn.l0.m(eVar2);
            if (((wl.h) this._state) == wl.h.f.f19719c) {
                lVar.invoke(eVar2.f19696a);
            } else {
                while (((wl.h) this._state) != wl.h.f.f19719c) {
                    y3(1, dVar);
                }
                lVar.invoke(eVar2.f19696a);
            }
            return lm.l2.f10208a;
        }
        wl.j jVar = ((wl.h) this._state).f19708b;
        if (jVar.w(i10)) {
            Q1(byteBufferP2, i10);
            if (byteBufferP2.remaining() < i10) {
                byteBufferP2.limit(byteBufferP2.capacity());
                lVar2.invoke(byteBufferP2);
                o1(byteBufferP2);
            } else {
                lVar2.invoke(byteBufferP2);
            }
            m1(byteBufferP2, jVar, i10);
            if (jVar.k() || q0()) {
                flush();
            }
            C2();
            U2();
            return lm.l2.f10208a;
        }
        do {
            try {
                y3(i10, dVar);
                if (this.joining != null) {
                    C2();
                    wl.e eVar3 = this.joining;
                    kn.l0.m(eVar3);
                    if (((wl.h) this._state) == wl.h.f.f19719c) {
                        lVar.invoke(eVar3.f19696a);
                    } else {
                        while (((wl.h) this._state) != wl.h.f.f19719c) {
                            y3(1, dVar);
                        }
                        lVar.invoke(eVar3.f19696a);
                    }
                }
                return lm.l2.f10208a;
            } catch (Throwable th2) {
                C2();
                U2();
                throw th2;
            }
        } while (!jVar.w(i10));
        Q1(byteBufferP2, i10);
        if (byteBufferP2.remaining() < i10) {
            byteBufferP2.limit(byteBufferP2.capacity());
            lVar2.invoke(byteBufferP2);
            o1(byteBufferP2);
        } else {
            lVar2.invoke(byteBufferP2);
        }
        m1(byteBufferP2, jVar, i10);
        if (jVar.k() || q0()) {
            flush();
        }
        C2();
        U2();
        return lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:50:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0069 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:20:0x0051, B:23:0x005c, B:26:0x0063, B:28:0x0069, B:31:0x006f), top: B:50:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    /* JADX WARN: Code duplicated, block: B:37:0x008c  */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    /* JADX WARN: Code duplicated, block: B:41:0x009b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x009c  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.Integer] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009c -> B:12:0x002f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.k
    @os.m
    public final java.lang.Object x(@os.l um.d<? super java.lang.Integer> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof pl.a.w
            if (r0 == 0) goto L13
            r0 = r10
            pl.a$w r0 = (pl.a.w) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$w r0 = new pl.a$w
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r9 = r0.I$0
            java.lang.Object r2 = r0.L$0
            pl.a r2 = (pl.a) r2
            lm.d1.n(r10)
            r8 = r0
            r0 = r9
            r9 = r2
        L2f:
            r2 = r8
            goto La0
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            lm.d1.n(r10)
            r10 = 4
        L3e:
            kn.k1$h r2 = new kn.k1$h
            r2.<init>()
            java.nio.ByteBuffer r4 = r9.O2()
            r5 = 0
            if (r4 != 0) goto L4b
            goto L7f
        L4b:
            java.lang.Object r6 = r9._state
            wl.h r6 = (wl.h) r6
            wl.j r6 = r6.f19708b
            int r7 = r6._availableForRead$internal     // Catch: java.lang.Throwable -> L6d
            if (r7 != 0) goto L5c
        L55:
            r9.B2()
            r9.U2()
            goto L7f
        L5c:
            boolean r7 = r6.t(r10)     // Catch: java.lang.Throwable -> L6d
            if (r7 != 0) goto L63
            goto L55
        L63:
            int r5 = r4.remaining()     // Catch: java.lang.Throwable -> L6d
            if (r5 >= r10) goto L6f
            r9.H2(r4, r10)     // Catch: java.lang.Throwable -> L6d
            goto L6f
        L6d:
            r10 = move-exception
            goto Lb9
        L6f:
            int r5 = r4.getInt()     // Catch: java.lang.Throwable -> L6d
            java.lang.Integer r7 = new java.lang.Integer     // Catch: java.lang.Throwable -> L6d
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L6d
            r2.element = r7     // Catch: java.lang.Throwable -> L6d
            r9.l1(r4, r6, r10)     // Catch: java.lang.Throwable -> L6d
            r5 = r3
            goto L55
        L7f:
            if (r5 == 0) goto L8f
            T r9 = r2.element
            if (r9 != 0) goto L8c
            java.lang.String r9 = "result"
            kn.l0.S(r9)
            r9 = 0
            goto L8e
        L8c:
            java.lang.Number r9 = (java.lang.Number) r9
        L8e:
            return r9
        L8f:
            r0.L$0 = r9
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r2 = r9.n2(r10, r0)
            if (r2 != r1) goto L9c
            return r1
        L9c:
            r8 = r0
            r0 = r10
            r10 = r2
            goto L2f
        La0:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto Lab
            r10 = r0
            r0 = r2
            goto L3e
        Lab:
            pq.v r9 = new pq.v
            java.lang.String r10 = "EOF while "
            java.lang.String r1 = " bytes expected"
            java.lang.String r10 = k.b.a(r10, r0, r1)
            r9.<init>(r10)
            throw r9
        Lb9:
            r9.B2()
            r9.U2()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.x(um.d):java.lang.Object");
    }

    public final void x2(wl.h.c cVar) {
        this.f13176c.recycle(cVar);
    }

    @Override // pl.k
    @os.m
    public Object y(@os.l tl.o0 o0Var, int i10, @os.l um.d<? super lm.l2> dVar) {
        return d2(this, o0Var, i10, dVar);
    }

    public final void y1(int i10, ByteBuffer byteBuffer, wl.j jVar, jn.l<? super ByteBuffer, lm.l2> lVar) {
        if (byteBuffer.remaining() < i10) {
            byteBuffer.limit(byteBuffer.capacity());
            lVar.invoke(byteBuffer);
            o1(byteBuffer);
        } else {
            lVar.invoke(byteBuffer);
        }
        m1(byteBuffer, jVar, i10);
        if (jVar.k() || q0()) {
            flush();
        }
        C2();
        U2();
    }

    public final tl.v y2(long j10, int i10) {
        tl.s sVarA = tl.w0.a(i10);
        try {
            ul.b bVarO = ul.k.o(sVarA, 1, null);
            while (true) {
                try {
                    tl.m mVar = bVarO.f15821b;
                    if (mVar.f15872a - mVar.f15874c > j10) {
                        bVarO.w0((int) j10);
                    }
                    j10 -= (long) V1(this, bVarO, 0, 0, 6, null);
                    if (j10 <= 0 || p0()) {
                        break;
                    }
                    bVarO = ul.k.o(sVarA, 1, bVarO);
                } catch (Throwable th2) {
                    ul.k.b(sVarA, bVarO);
                    throw th2;
                }
            }
            ul.k.b(sVarA, bVarO);
            return sVarA.z2();
        } catch (Throwable th3) {
            sVarA.close();
            throw th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object y3(int i10, um.d<? super lm.l2> dVar) throws Throwable {
        w0 w0Var;
        Throwable thC;
        if (dVar instanceof w0) {
            w0Var = (w0) dVar;
            int i11 = w0Var.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                w0Var.label = i11 - Integer.MIN_VALUE;
            } else {
                w0Var = new w0(dVar);
            }
        } else {
            w0Var = new w0(dVar);
        }
        Object obj = w0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = w0Var.label;
        if (i12 == 0) {
            d1.n(obj);
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i13 = w0Var.I$0;
            a aVar2 = (a) w0Var.L$0;
            d1.n(obj);
            i10 = i13;
            this = aVar2;
        }
        while (this.B3(i10)) {
            w0Var.L$0 = this;
            w0Var.I$0 = i10;
            w0Var.label = 1;
            nq.q qVar = new nq.q(wm.c.e(w0Var), 1);
            qVar.F();
            this.A3(i10, qVar);
            Object objZ = qVar.z();
            if (objZ == wm.a.COROUTINE_SUSPENDED) {
                xm.h.c(w0Var);
            }
            if (objZ == aVar) {
                return aVar;
            }
        }
        wl.c cVar = (wl.c) this._closed;
        if (cVar == null || (thC = cVar.c()) == null) {
            return lm.l2.f10208a;
        }
        pl.b.b(thC);
        throw new lm.y();
    }

    @Override // pl.n
    @os.m
    public Object z(@os.l ByteBuffer byteBuffer, int i10, int i11, @os.l um.d<? super lm.l2> dVar) {
        return o3(this, byteBuffer, i10, i11, dVar);
    }

    public final void z1(wl.e eVar) {
        wl.c cVar = (wl.c) this._closed;
        if (cVar == null) {
            return;
        }
        this.joining = null;
        if (!eVar.f19697b) {
            eVar.f19696a.flush();
            eVar.b();
            return;
        }
        wl.h hVar = (wl.h) eVar.f19696a._state;
        boolean z10 = (hVar instanceof wl.h.g) || (hVar instanceof wl.h.e);
        Throwable th2 = cVar.f19693a;
        if (th2 == null && z10) {
            eVar.f19696a.flush();
        } else {
            eVar.f19696a.f(th2);
        }
        eVar.b();
    }

    @os.l
    public final a z2() {
        a aVarA2;
        wl.e eVar = this.joining;
        return (eVar == null || (aVarA2 = A2(this, eVar)) == null) ? this : aVarA2;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    /* JADX WARN: Code duplicated, block: B:27:0x006d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0080 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:20:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:31:0x0080
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object z3(byte[] r8, int r9, int r10, um.d<? super java.lang.Integer> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof pl.a.v0
            if (r0 == 0) goto L13
            r0 = r11
            pl.a$v0 r0 = (pl.a.v0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.a$v0 r0 = new pl.a$v0
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lm.d1.n(r11)
            goto L81
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r0.L$0
            pl.a r10 = (pl.a) r10
            lm.d1.n(r11)
            r5 = r10
            r10 = r7
            r7 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L5c
        L48:
            lm.d1.n(r11)
        L4b:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r9
            r0.I$1 = r10
            r0.label = r4
            java.lang.Object r11 = r7.X2(r4, r0)
            if (r11 != r1) goto L5c
            return r1
        L5c:
            wl.e r11 = r7.joining
            if (r11 != 0) goto L61
            goto L67
        L61:
            pl.a r11 = r7.A2(r7, r11)
            if (r11 != 0) goto L73
        L67:
            int r11 = r7.b3(r8, r9, r10)
            if (r11 <= 0) goto L4b
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r11)
            return r7
        L73:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r11 = r11.z3(r8, r9, r10, r0)
            if (r11 != r1) goto L81
            return r1
        L81:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.a.z3(byte[], int, int, um.d):java.lang.Object");
    }

    public /* synthetic */ a(boolean z10, bm.h hVar, int i10, int i11, kn.w wVar) {
        this(z10, (i11 & 2) != 0 ? wl.f.c() : hVar, (i11 & 4) != 0 ? 8 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@os.l ByteBuffer byteBuffer) {
        this(false, wl.f.b(), 0);
        kn.l0.p(byteBuffer, t2.a.f15437d);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        kn.l0.o(byteBufferSlice, "content.slice()");
        wl.h.c cVar = new wl.h.c(byteBufferSlice, 0);
        cVar.f19708b.l();
        this._state = cVar.f19715g;
        C2();
        pl.o.a(this);
        U2();
    }
}
