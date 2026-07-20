package pl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kn.k1;
import lm.d1;
import lm.l2;
import tl.s0;
import tl.u0;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
@ul.d
public abstract class f implements pl.c, pl.k, pl.n, pl.j0, pl.z, pl.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final pl.g f13192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final tl.s f13193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final tl.v f13194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final wl.a f13195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final Object f13196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final tl.s f13197h;

    public static final class a extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13198a;

        public a(int i10) {
            this.f13198a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("atLeast parameter shouldn't be negative: ", Integer.valueOf(this.f13198a)));
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {782}, m = "readSuspendableSession$suspendImpl", n = {"this"}, s = {"L$0"})
    public static final class a0 extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a0(um.d<? super a0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.N1(f.this, null, this);
        }
    }

    public static final class b extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13199a;

        public b(int i10) {
            this.f13199a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(kn.l0.C("atLeast parameter shouldn't be larger than max buffer size of 4088: ", Integer.valueOf(this.f13199a)));
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {808}, m = "readUTF8Line$suspendImpl", n = {"sb"}, s = {"L$0"})
    public static final class b0 extends xm.d {
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
            return f.O1(f.this, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {126}, m = "awaitAtLeastNBytesAvailableForRead$ktor_io", n = {"this", "count"}, s = {"L$0", "I$0"})
    public static final class c extends xm.d {
        int I$0;
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
            return f.this.L0(0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2", f = "ByteChannelSequential.kt", i = {}, l = {801}, m = "invokeSuspend", n = {}, s = {})
    public static final class c0 extends xm.o implements jn.p<Integer, um.d<? super tl.a>, Object> {
        /* synthetic */ int I$0;
        int label;

        public c0(um.d<? super c0> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c0 c0Var = f.this.new c0(dVar);
            c0Var.I$0 = ((Number) obj).intValue();
            return c0Var;
        }

        @os.m
        public final Object invoke(int i10, @os.m um.d<? super tl.a> dVar) {
            return ((c0) create(Integer.valueOf(i10), dVar)).invokeSuspend(l2.f10208a);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                int i11 = this.I$0;
                f.this.H0(i11);
                f fVar = f.this;
                this.label = 1;
                obj = fVar.w(i11, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                return f.this.f13194e;
            }
            return null;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(Integer num, um.d<? super tl.a> dVar) {
            return invoke(num.intValue(), dVar);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {y5.a.f20730l0}, m = "awaitAtLeastNBytesAvailableForWrite$ktor_io", n = {"this", "count"}, s = {"L$0", "I$0"})
    public static final class d extends xm.d {
        int I$0;
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
            return f.this.M0(0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {862, 863}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class d0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public d0(um.d<? super d0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.h2(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {890}, m = "awaitFreeSpace$suspendImpl", n = {"this"}, s = {"L$0"})
    public static final class e extends xm.d {
        Object L$0;
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
            return f.N0(f.this, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {867, 868}, m = "writeAvailableSuspend", n = {"this", "src", TypedValues.CycleType.S_WAVE_OFFSET, "length"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class e0 extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
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
            return f.this.i2(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: pl.f$f, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {692}, m = "awaitSuspend", n = {"this", "atLeast"}, s = {"L$0", "I$0"})
    public static final class C0327f extends xm.d {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C0327f(um.d<? super C0327f> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.P0(0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {185}, m = "writeByte$suspendImpl", n = {"this", "b"}, s = {"L$0", "B$0"})
    public static final class f0 extends xm.d {
        byte B$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public f0(um.d<? super f0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.j2(f.this, (byte) 0, this);
        }
    }

    public static final class g implements p0 {
        public g() {
        }

        @Override // pl.n0
        public void a(int i10) throws Throwable {
            f.this.f13193d.d();
            f.this.J0(i10);
        }

        @Override // pl.n0
        @os.m
        public tl.o0 b(int i10) {
            if (f.this.q() == 0) {
                return null;
            }
            return (tl.o0) f.this.f13193d.T0(i10);
        }

        @Override // pl.p0
        @os.m
        public Object c(int i10, @os.l um.d<? super l2> dVar) {
            Object objM0;
            return (f.this.q() >= i10 || (objM0 = f.this.M0(i10, dVar)) != wm.a.COROUTINE_SUSPENDED) ? l2.f10208a : objM0;
        }

        @Override // pl.n0
        public void flush() {
            f.this.flush();
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {224}, m = "writeDouble$suspendImpl", n = {"this", "d"}, s = {"L$0", "D$0"})
    public static final class g0 extends xm.d {
        double D$0;
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
            return f.k2(f.this, 0.0d, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {753}, m = "discardSuspend", n = {"this", "max", "discarded"}, s = {"L$0", "J$0", "J$1"})
    public static final class h extends xm.d {
        long J$0;
        long J$1;
        Object L$0;
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
            return f.this.U0(0L, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {218}, m = "writeFloat$suspendImpl", n = {"this", "f"}, s = {"L$0", "F$0"})
    public static final class h0 extends xm.d {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public h0(um.d<? super h0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.l2(f.this, 0.0f, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {TypedValues.Custom.TYPE_BOOLEAN}, m = "peekTo-vHUFkk8", n = {"bytesCopied"}, s = {"L$0"})
    public static final class i extends xm.d {
        Object L$0;
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
            return f.this.d0(null, 0L, 0L, 0L, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {241}, m = "writeFully$suspendImpl", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class i0 extends xm.d {
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
            return f.m2(f.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2", f = "ByteChannelSequential.kt", i = {0}, l = {907}, m = "invokeSuspend", n = {"$this$readSuspendableSession"}, s = {"L$0"})
    public static final class j extends xm.o implements jn.p<pl.j0, um.d<? super l2>, Object> {
        final /* synthetic */ k1.g $bytesCopied;
        final /* synthetic */ ByteBuffer $destination;
        final /* synthetic */ long $destinationOffset;
        final /* synthetic */ long $max;
        final /* synthetic */ long $min;
        final /* synthetic */ long $offset;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(long j10, long j11, k1.g gVar, long j12, ByteBuffer byteBuffer, long j13, um.d<? super j> dVar) {
            super(2, dVar);
            this.$min = j10;
            this.$offset = j11;
            this.$bytesCopied = gVar;
            this.$max = j12;
            this.$destination = byteBuffer;
            this.$destinationOffset = j13;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            j jVar = new j(this.$min, this.$offset, this.$bytesCopied, this.$max, this.$destination, this.$destinationOffset, dVar);
            jVar.L$0 = obj;
            return jVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            pl.j0 j0Var;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                pl.j0 j0Var2 = (pl.j0) this.L$0;
                int iC = (int) tn.u.C(this.$min + this.$offset, pl.j.f13203a);
                this.L$0 = j0Var2;
                this.label = 1;
                if (j0Var2.w(iC, this) == aVar) {
                    return aVar;
                }
                j0Var = j0Var2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j0Var = (pl.j0) this.L$0;
                d1.n(obj);
            }
            tl.o0 o0VarB = j0Var.b(1);
            if (o0VarB == null) {
                tl.o0.H.getClass();
                o0VarB = tl.o0.L;
            }
            tl.m mVar = o0VarB.f15821b;
            int i11 = mVar.f15874c;
            int i12 = mVar.f15873b;
            long j10 = i11 - i12;
            long j11 = this.$offset;
            if (j10 > j11) {
                this.$bytesCopied.element = Math.min(((long) (i11 - i12)) - j11, Math.min(this.$max, ((long) this.$destination.limit()) - this.$destinationOffset));
                ql.f.e(o0VarB.f15820a, this.$destination, this.$offset, this.$bytesCopied.element, this.$destinationOffset);
            }
            return l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.j0 j0Var, @os.m um.d<? super l2> dVar) {
            return ((j) create(j0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {252}, m = "writeFully$suspendImpl", n = {"this", "src", "currentIndex", "endIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class j0 extends xm.d {
        int I$0;
        int I$1;
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
            return f.o2(f.this, null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {559}, m = "readAvailable$ktor_io", n = {"this", "dst"}, s = {"L$0", "L$1"})
    public static final class k extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public k(um.d<? super k> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.l1(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {266}, m = "writeFully-rGWNHyQ$suspendImpl", n = {"this", "memory", "endIndex", "currentIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class k0 extends xm.d {
        int I$0;
        int I$1;
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
            return f.p2(f.this, null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m = "readAvailable$suspendImpl", n = {"this", "dst", TypedValues.CycleType.S_WAVE_OFFSET, "length"}, s = {"L$0", "L$1", "I$0", "I$1"})
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
            return f.n1(f.this, null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {206}, m = "writeInt$suspendImpl", n = {"this", b9.i.f771b}, s = {"L$0", "I$0"})
    public static final class l0 extends xm.d {
        int I$0;
        Object L$0;
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
            return f.q2(f.this, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {639, 641}, m = "readBooleanSlow", n = {"this"}, s = {"L$0"})
    public static final class m extends xm.d {
        Object L$0;
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
            return f.this.q1(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {212}, m = "writeLong$suspendImpl", n = {"this", a8.l.f173c}, s = {"L$0", "J$0"})
    public static final class m0 extends xm.d {
        long J$0;
        Object L$0;
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
            return f.r2(f.this, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {359}, m = "readByteSlow", n = {"this"}, s = {"L$0"})
    public static final class n extends xm.d {
        Object L$0;
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
            return f.this.s1(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {230}, m = "writePacket$suspendImpl", n = {"this", "packet"}, s = {"L$0", "L$1"})
    public static final class n0 extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public n0(um.d<? super n0> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.s2(f.this, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {920}, m = "readDoubleSlow", n = {"this", "this_$iv", "n$iv"}, s = {"L$0", "L$1", "I$0"})
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
            return f.this.u1(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION}, m = "writeShort$suspendImpl", n = {"this", p6.s.f13016a}, s = {"L$0", "S$0"})
    public static final class o0 extends xm.d {
        Object L$0;
        short S$0;
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
            return f.t2(f.this, (short) 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {920}, m = "readFloatSlow", n = {"this", "this_$iv", "n$iv"}, s = {"L$0", "L$1", "I$0"})
    public static final class p extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return f.this.w1(this);
        }
    }

    public static final class q extends ul.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13201a;

        public q(int i10) {
            this.f13201a = i10;
        }

        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException(c.a.a(new StringBuilder("Not enough space in the destination buffer to write "), this.f13201a, " bytes"));
        }
    }

    public static final class r extends ul.h {
        @Override // ul.h
        @os.l
        public Void a() {
            throw new IllegalArgumentException("n shouldn't be negative");
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {616, 620}, m = "readFully$suspendImpl", n = {"this", "dst", TypedValues.CycleType.S_WAVE_OFFSET, "length"}, s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class s extends xm.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
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
            return f.z1(f.this, null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {591, 592}, m = "readFullySuspend", n = {"this", "dst", p6.n.f13005a}, s = {"L$0", "L$1", "I$0"})
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
            return f.this.A1(null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0, 0}, l = {627}, m = "readFullySuspend", n = {"this", "dst", TypedValues.CycleType.S_WAVE_OFFSET, "length", "written"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
    public static final class u extends xm.d {
        int I$0;
        int I$1;
        int I$2;
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
            return f.this.B1(null, 0, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {920}, m = "readIntSlow", n = {"this", "this_$iv", "n$iv"}, s = {"L$0", "L$1", "I$0"})
    public static final class v extends xm.d {
        int I$0;
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
            return f.this.D1(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {920}, m = "readLongSlow", n = {"this", "this_$iv", "n$iv"}, s = {"L$0", "L$1", "I$0"})
    public static final class w extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return f.this.F1(this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {532}, m = "readPacketSuspend", n = {"this", "builder", "remaining"}, s = {"L$0", "L$1", "I$0"})
    public static final class x extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return f.this.I1(null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {499}, m = "readRemainingSuspend", n = {"this", "builder", "limit"}, s = {"L$0", "L$1", "J$0"})
    public static final class y extends xm.d {
        long J$0;
        Object L$0;
        Object L$1;
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
            return f.this.K1(null, 0L, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {920}, m = "readShortSlow", n = {"this", "this_$iv", "n$iv"}, s = {"L$0", "L$1", "I$0"})
    public static final class z extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return f.this.M1(this);
        }
    }

    public f(@os.l tl.o0 o0Var, boolean z10, @os.l bm.h<ul.b> hVar) {
        kn.l0.p(o0Var, "initial");
        kn.l0.p(hVar, "pool");
        this.f13191b = z10;
        this.f13192c = new pl.g();
        this.f13193d = new tl.s(0, hVar);
        this.f13194e = new tl.v((ul.b) o0Var, hVar);
        this.f13195f = new wl.a();
        this.f13196g = new Object();
        this.f13197h = w0.b(0, 1, null);
    }

    public static Object C1(f fVar, um.d dVar) {
        if (!fVar.f13194e.c1(4)) {
            return fVar.D1(dVar);
        }
        int iE = tl.m0.e(fVar.f13194e);
        if (fVar.R() != tl.q.BIG_ENDIAN) {
            iE = Integer.reverseBytes(iE);
        }
        fVar.H0(4);
        return new Integer(iE);
    }

    public static Object E1(f fVar, um.d dVar) {
        if (!fVar.f13194e.c1(8)) {
            return fVar.F1(dVar);
        }
        long jG = tl.m0.g(fVar.f13194e);
        if (fVar.R() != tl.q.BIG_ENDIAN) {
            jG = Long.reverseBytes(jG);
        }
        fVar.H0(8);
        return new Long(jG);
    }

    public static Object H1(f fVar, int i10, int i11, um.d dVar) throws Throwable {
        R0(fVar, i10, null, 2, null);
        tl.s sVarA = w0.a(i11);
        int iMin = (int) Math.min(i10, fVar.f13194e.S0());
        int i12 = i10 - iMin;
        sVarA.m2(fVar.f13194e, iMin);
        fVar.H0(iMin);
        fVar.Q0(i12, sVarA);
        return i12 > 0 ? fVar.I1(sVarA, i12, dVar) : sVarA.z2();
    }

    public static Object J1(f fVar, long j10, int i10, um.d dVar) throws Throwable {
        fVar.W0();
        tl.s sVarA = w0.a(i10);
        sVarA.n2(fVar.f13194e, Math.min(j10, fVar.f13194e.S0()));
        long jP0 = j10 - ((long) sVarA.P0());
        if (jP0 != 0 && !fVar.p0()) {
            return fVar.K1(sVarA, j10, dVar);
        }
        fVar.H0((int) jP0);
        fVar.X0(sVarA);
        return sVarA.z2();
    }

    public static Object K0(f fVar, int i10, um.d dVar) {
        if (!(i10 >= 0)) {
            new a(i10).a();
            throw new lm.y();
        }
        long j10 = i10;
        if (!(j10 <= pl.j.f13203a)) {
            new b(i10).a();
            throw new lm.y();
        }
        fVar.S0();
        if (i10 == 0) {
            return Boolean.valueOf(!fVar.p0());
        }
        return fVar.f13194e.S0() >= j10 ? Boolean.TRUE : fVar.P0(i10, dVar);
    }

    public static Object L1(f fVar, um.d dVar) {
        if (!fVar.f13194e.c1(2)) {
            return fVar.M1(dVar);
        }
        short sK = tl.m0.k(fVar.f13194e);
        if (fVar.R() != tl.q.BIG_ENDIAN) {
            sK = Short.reverseBytes(sK);
        }
        fVar.H0(2);
        return new Short(sK);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object N0(f fVar, um.d dVar) throws Throwable {
        e eVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = fVar.new e(dVar);
            }
        } else {
            eVar = fVar.new e(dVar);
        }
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            d1.n(obj);
            fVar.flush();
            eVar.L$0 = fVar;
            eVar.label = 1;
            if (fVar.M0(1, eVar) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fVar = (f) eVar.L$0;
            d1.n(obj);
        }
        fVar.V0();
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, pl.f] */
    /* JADX WARN: Type inference failed for: r4v1, types: [pl.f] */
    /* JADX WARN: Type inference failed for: r4v2, types: [pl.f] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, lm.l2] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @lm.k(message = "Use read instead.")
    public static Object N1(f fVar, jn.p pVar, um.d dVar) {
        a0 a0Var;
        ?? r10;
        if (dVar instanceof a0) {
            a0Var = (a0) dVar;
            int i10 = a0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                a0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                a0Var = new a0(dVar);
            }
        } else {
            a0Var = new a0(dVar);
        }
        Object obj = a0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = a0Var.label;
        try {
            if (i11 == 0) {
                d1.n(obj);
                a0Var.L$0 = fVar;
                a0Var.label = 1;
                Object objInvoke = pVar.invoke(fVar, a0Var);
                r10 = fVar;
                if (objInvoke == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f fVar2 = (f) a0Var.L$0;
                d1.n(obj);
                r10 = fVar2;
            }
            r10.S0();
            fVar = l2.f10208a;
            return fVar;
        } catch (Throwable th2) {
            fVar.S0();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object O1(f fVar, int i10, um.d dVar) {
        b0 b0Var;
        StringBuilder sb2;
        if (dVar instanceof b0) {
            b0Var = (b0) dVar;
            int i11 = b0Var.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                b0Var.label = i11 - Integer.MIN_VALUE;
            } else {
                b0Var = fVar.new b0(dVar);
            }
        } else {
            b0Var = fVar.new b0(dVar);
        }
        Object obj = b0Var.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i12 = b0Var.label;
        if (i12 == 0) {
            d1.n(obj);
            StringBuilder sb3 = new StringBuilder();
            b0Var.L$0 = sb3;
            b0Var.label = 1;
            Object objO = fVar.O(sb3, i10, b0Var);
            if (objO == obj2) {
                return obj2;
            }
            obj = objO;
            sb2 = sb3;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sb2 = (StringBuilder) b0Var.L$0;
            d1.n(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return sb2.toString();
        }
        return null;
    }

    public static Object P1(f fVar, Appendable appendable, int i10, um.d dVar) throws Throwable {
        if (!fVar.p0()) {
            return ul.j.g(appendable, i10, fVar.new c0(null), dVar);
        }
        Throwable thB = fVar.f13192c.b();
        if (thB == null) {
            return Boolean.FALSE;
        }
        throw thB;
    }

    public static /* synthetic */ void R0(f fVar, int i10, tl.s sVar, int i11, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClosed");
        }
        if ((i11 & 2) != 0) {
            sVar = null;
        }
        fVar.Q0(i10, sVar);
    }

    public static Object T0(f fVar, long j10, um.d dVar) throws Throwable {
        long jT1 = fVar.f13194e.t1(j10);
        if (jT1 != j10 && !fVar.p0()) {
            return fVar.U0(j10, jT1, dVar);
        }
        fVar.W0();
        return new Long(jT1);
    }

    @lm.k(level = lm.m.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void e1() {
    }

    public static Object f2(f fVar, tl.o0 o0Var, um.d dVar) throws Throwable {
        tl.m mVar = o0Var.f15821b;
        int i10 = mVar.f15874c - mVar.f15873b;
        if (i10 == 0) {
            return new Integer(0);
        }
        int iMin = Math.min(i10, fVar.q());
        if (iMin == 0) {
            return fVar.h2(o0Var, dVar);
        }
        s0.h(fVar.f13193d, o0Var, iMin);
        fVar.J0(iMin);
        return new Integer(iMin);
    }

    public static Object g2(f fVar, byte[] bArr, int i10, int i11, um.d dVar) throws Throwable {
        if (i11 == 0) {
            return new Integer(0);
        }
        int iMin = Math.min(i11, fVar.q());
        if (iMin == 0) {
            return fVar.i2(bArr, i10, i11, dVar);
        }
        s0.j(fVar.f13193d, bArr, i10, iMin);
        fVar.J0(iMin);
        return new Integer(iMin);
    }

    @lm.k(level = lm.m.ERROR, message = "Setting byte order is no longer supported. Read/write in big endian and use reverseByteOrder() extensions.")
    public static /* synthetic */ void h1() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object j2(f fVar, byte b10, um.d dVar) throws Throwable {
        f0 f0Var;
        if (dVar instanceof f0) {
            f0Var = (f0) dVar;
            int i10 = f0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                f0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                f0Var = fVar.new f0(dVar);
            }
        } else {
            f0Var = fVar.new f0(dVar);
        }
        Object obj = f0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = f0Var.label;
        if (i11 == 0) {
            d1.n(obj);
            f0Var.L$0 = fVar;
            f0Var.B$0 = b10;
            f0Var.label = 1;
            if (fVar.M0(1, f0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b10 = f0Var.B$0;
            fVar = (f) f0Var.L$0;
            d1.n(obj);
        }
        fVar.f13193d.d1(b10);
        fVar.J0(1);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object k2(f fVar, double d10, um.d dVar) throws Throwable {
        g0 g0Var;
        if (dVar instanceof g0) {
            g0Var = (g0) dVar;
            int i10 = g0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                g0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                g0Var = fVar.new g0(dVar);
            }
        } else {
            g0Var = fVar.new g0(dVar);
        }
        Object obj = g0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = g0Var.label;
        if (i11 == 0) {
            d1.n(obj);
            g0Var.L$0 = fVar;
            g0Var.D$0 = d10;
            g0Var.label = 1;
            if (fVar.M0(8, g0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d10 = g0Var.D$0;
            fVar = (f) g0Var.L$0;
            d1.n(obj);
        }
        tl.s sVar = fVar.f13193d;
        if (fVar.o0() != tl.q.BIG_ENDIAN) {
            d10 = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10)));
        }
        u0.a(sVar, d10);
        fVar.J0(8);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object l2(f fVar, float f10, um.d dVar) throws Throwable {
        h0 h0Var;
        if (dVar instanceof h0) {
            h0Var = (h0) dVar;
            int i10 = h0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                h0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                h0Var = fVar.new h0(dVar);
            }
        } else {
            h0Var = fVar.new h0(dVar);
        }
        Object obj = h0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = h0Var.label;
        if (i11 == 0) {
            d1.n(obj);
            h0Var.L$0 = fVar;
            h0Var.F$0 = f10;
            h0Var.label = 1;
            if (fVar.M0(4, h0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f10 = h0Var.F$0;
            fVar = (f) h0Var.L$0;
            d1.n(obj);
        }
        tl.s sVar = fVar.f13193d;
        if (fVar.o0() != tl.q.BIG_ENDIAN) {
            f10 = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10)));
        }
        u0.b(sVar, f10);
        fVar.J0(4);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object m2(f fVar, tl.e eVar, um.d dVar) throws Throwable {
        i0 i0Var;
        if (dVar instanceof i0) {
            i0Var = (i0) dVar;
            int i10 = i0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                i0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                i0Var = fVar.new i0(dVar);
            }
        } else {
            i0Var = fVar.new i0(dVar);
        }
        Object obj = i0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = i0Var.label;
        if (i11 == 0) {
            d1.n(obj);
            i0Var.L$0 = fVar;
            i0Var.L$1 = eVar;
            i0Var.label = 1;
            if (fVar.M0(1, i0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar = (tl.e) i0Var.L$1;
            fVar = (f) i0Var.L$0;
            d1.n(obj);
        }
        tl.m mVar = eVar.f15821b;
        int i12 = mVar.f15874c - mVar.f15873b;
        s0.p(fVar.f13193d, eVar, 0, 2, null);
        fVar.J0(i12);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object n1(f fVar, byte[] bArr, int i10, int i11, um.d dVar) throws Throwable {
        l lVar;
        if (dVar instanceof l) {
            lVar = (l) dVar;
            int i12 = lVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                lVar.label = i12 - Integer.MIN_VALUE;
            } else {
                lVar = fVar.new l(dVar);
            }
        } else {
            lVar = fVar.new l(dVar);
        }
        Object obj = lVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = lVar.label;
        if (i13 == 0) {
            d1.n(obj);
            Throwable thB = fVar.f13192c.b();
            if (thB != null) {
                throw thB;
            }
            if (fVar.f13192c.a() && fVar.d() == 0) {
                return new Integer(-1);
            }
            if (i11 == 0) {
                return new Integer(0);
            }
            if (fVar.d() == 0) {
                lVar.L$0 = fVar;
                lVar.L$1 = bArr;
                lVar.I$0 = i10;
                lVar.I$1 = i11;
                lVar.label = 1;
                if (fVar.P0(1, lVar) == aVar) {
                    return aVar;
                }
            }
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i11 = lVar.I$1;
            i10 = lVar.I$0;
            bArr = (byte[]) lVar.L$1;
            fVar = (f) lVar.L$0;
            d1.n(obj);
        }
        if (!fVar.f13194e.k()) {
            fVar.k1();
        }
        int iMin = (int) Math.min(i11, fVar.f13194e.S0());
        tl.i0.r(fVar.f13194e, bArr, i10, iMin);
        fVar.H0(iMin);
        return new Integer(iMin);
    }

    public static Object n2(f fVar, tl.o0 o0Var, um.d dVar) {
        Object objH = fVar.h(o0Var, dVar);
        return objH == wm.a.COROUTINE_SUSPENDED ? objH : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0049  */
    /* JADX WARN: Code duplicated, block: B:18:0x0059 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0057 -> B:19:0x005a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.Object o2(pl.f r5, byte[] r6, int r7, int r8, um.d r9) {
        /*
            boolean r0 = r9 instanceof pl.f.j0
            if (r0 == 0) goto L13
            r0 = r9
            pl.f$j0 r0 = (pl.f.j0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$j0 r0 = new pl.f$j0
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$0
            pl.f r8 = (pl.f) r8
            lm.d1.n(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L5a
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            lm.d1.n(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L47:
            if (r8 >= r5) goto L6e
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r5
            r0.label = r3
            java.lang.Object r9 = r6.M0(r3, r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            int r9 = r6.q()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            tl.s r2 = r6.f13193d
            tl.s0.j(r2, r7, r8, r9)
            int r8 = r8 + r9
            r6.J0(r9)
            goto L47
        L6e:
            lm.l2 r5 = lm.l2.f10208a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.o2(pl.f, byte[], int, int, um.d):java.lang.Object");
    }

    public static Object p1(f fVar, um.d dVar) {
        if (!fVar.f13194e.k()) {
            return fVar.q1(dVar);
        }
        boolean z10 = fVar.f13194e.readByte() == 1;
        fVar.H0(1);
        return Boolean.valueOf(z10);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:18:0x0055 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0053 -> B:19:0x0056). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.Object p2(pl.f r5, java.nio.ByteBuffer r6, int r7, int r8, um.d r9) {
        /*
            boolean r0 = r9 instanceof pl.f.k0
            if (r0 == 0) goto L13
            r0 = r9
            pl.f$k0 r0 = (pl.f.k0) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$k0 r0 = new pl.f$k0
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            pl.f r8 = (pl.f) r8
            lm.d1.n(r9)
            r4 = r7
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r4
            goto L56
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            lm.d1.n(r9)
        L43:
            if (r7 >= r8) goto L6a
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r9 = r5.M0(r3, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            int r9 = r5.q()
            int r2 = r8 - r7
            int r9 = java.lang.Math.min(r9, r2)
            tl.s r2 = r5.f13193d
            tl.s0.x(r2, r6, r7, r9)
            int r7 = r7 + r9
            r5.J0(r9)
            goto L43
        L6a:
            lm.l2 r5 = lm.l2.f10208a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.p2(pl.f, java.nio.ByteBuffer, int, int, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object q2(f fVar, int i10, um.d dVar) throws Throwable {
        l0 l0Var;
        if (dVar instanceof l0) {
            l0Var = (l0) dVar;
            int i11 = l0Var.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                l0Var.label = i11 - Integer.MIN_VALUE;
            } else {
                l0Var = fVar.new l0(dVar);
            }
        } else {
            l0Var = fVar.new l0(dVar);
        }
        Object obj = l0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = l0Var.label;
        if (i12 == 0) {
            d1.n(obj);
            l0Var.L$0 = fVar;
            l0Var.I$0 = i10;
            l0Var.label = 1;
            if (fVar.M0(4, l0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = l0Var.I$0;
            fVar = (f) l0Var.L$0;
            d1.n(obj);
        }
        tl.s sVar = fVar.f13193d;
        if (fVar.o0() != tl.q.BIG_ENDIAN) {
            i10 = Integer.reverseBytes(i10);
        }
        u0.c(sVar, i10);
        fVar.J0(4);
        return l2.f10208a;
    }

    public static Object r1(f fVar, um.d dVar) {
        if (fVar.f13194e.B1()) {
            return fVar.s1(dVar);
        }
        byte b10 = fVar.f13194e.readByte();
        fVar.H0(1);
        return Byte.valueOf(b10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object r2(f fVar, long j10, um.d dVar) throws Throwable {
        m0 m0Var;
        if (dVar instanceof m0) {
            m0Var = (m0) dVar;
            int i10 = m0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                m0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                m0Var = fVar.new m0(dVar);
            }
        } else {
            m0Var = fVar.new m0(dVar);
        }
        Object obj = m0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = m0Var.label;
        if (i11 == 0) {
            d1.n(obj);
            m0Var.L$0 = fVar;
            m0Var.J$0 = j10;
            m0Var.label = 1;
            if (fVar.M0(8, m0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = m0Var.J$0;
            fVar = (f) m0Var.L$0;
            d1.n(obj);
        }
        tl.s sVar = fVar.f13193d;
        if (fVar.o0() != tl.q.BIG_ENDIAN) {
            j10 = Long.reverseBytes(j10);
        }
        u0.f(sVar, j10);
        fVar.J0(8);
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object s2(f fVar, tl.v vVar, um.d dVar) throws Throwable {
        n0 n0Var;
        if (dVar instanceof n0) {
            n0Var = (n0) dVar;
            int i10 = n0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                n0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                n0Var = fVar.new n0(dVar);
            }
        } else {
            n0Var = fVar.new n0(dVar);
        }
        Object obj = n0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = n0Var.label;
        if (i11 == 0) {
            d1.n(obj);
            n0Var.L$0 = fVar;
            n0Var.L$1 = vVar;
            n0Var.label = 1;
            if (fVar.M0(1, n0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            vVar = (tl.v) n0Var.L$1;
            fVar = (f) n0Var.L$0;
            d1.n(obj);
        }
        int iS0 = (int) vVar.S0();
        fVar.f13193d.l2(vVar);
        fVar.J0(iS0);
        return l2.f10208a;
    }

    public static Object t1(f fVar, um.d dVar) {
        if (!fVar.f13194e.c1(8)) {
            return fVar.u1(dVar);
        }
        double dA = tl.m0.a(fVar.f13194e);
        if (fVar.R() != tl.q.BIG_ENDIAN) {
            dA = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(dA)));
        }
        fVar.H0(8);
        return new Double(dA);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object t2(f fVar, short s10, um.d dVar) throws Throwable {
        o0 o0Var;
        if (dVar instanceof o0) {
            o0Var = (o0) dVar;
            int i10 = o0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                o0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                o0Var = fVar.new o0(dVar);
            }
        } else {
            o0Var = fVar.new o0(dVar);
        }
        Object obj = o0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = o0Var.label;
        if (i11 == 0) {
            d1.n(obj);
            o0Var.L$0 = fVar;
            o0Var.S$0 = s10;
            o0Var.label = 1;
            if (fVar.M0(2, o0Var) == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s10 = o0Var.S$0;
            fVar = (f) o0Var.L$0;
            d1.n(obj);
        }
        u0.j(fVar.f13193d, fVar.o0() == tl.q.BIG_ENDIAN ? s10 : Short.reverseBytes(s10));
        fVar.J0(2);
        return l2.f10208a;
    }

    @tl.f0
    public static Object u2(f fVar, jn.p pVar, um.d dVar) {
        Object objInvoke = pVar.invoke(fVar.V(), dVar);
        return objInvoke == wm.a.COROUTINE_SUSPENDED ? objInvoke : l2.f10208a;
    }

    public static Object v1(f fVar, um.d dVar) {
        if (!fVar.f13194e.c1(4)) {
            return fVar.w1(dVar);
        }
        float fC = tl.m0.c(fVar.f13194e);
        if (fVar.R() != tl.q.BIG_ENDIAN) {
            fC = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(fC)));
        }
        fVar.H0(4);
        return new Float(fC);
    }

    public static Object y1(f fVar, tl.o0 o0Var, int i10, um.d dVar) throws Throwable {
        Object objX1 = fVar.x1(o0Var, i10, dVar);
        return objX1 == wm.a.COROUTINE_SUSPENDED ? objX1 : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object z1(f fVar, byte[] bArr, int i10, int i11, um.d dVar) throws EOFException {
        s sVar;
        if (dVar instanceof s) {
            sVar = (s) dVar;
            int i12 = sVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                sVar.label = i12 - Integer.MIN_VALUE;
            } else {
                sVar = fVar.new s(dVar);
            }
        } else {
            sVar = fVar.new s(dVar);
        }
        Object objV = sVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = sVar.label;
        if (i13 != 0) {
            if (i13 == 1) {
                i11 = sVar.I$1;
                i10 = sVar.I$0;
                bArr = (byte[]) sVar.L$1;
                fVar = (f) sVar.L$0;
                d1.n(objV);
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objV);
            }
            return l2.f10208a;
        }
        d1.n(objV);
        sVar.L$0 = fVar;
        sVar.L$1 = bArr;
        sVar.I$0 = i10;
        sVar.I$1 = i11;
        sVar.label = 1;
        objV = fVar.v(bArr, i10, i11, sVar);
        if (objV == aVar) {
            return aVar;
        }
        int iIntValue = ((Number) objV).intValue();
        if (iIntValue == i11) {
            return l2.f10208a;
        }
        if (iIntValue == -1) {
            throw new EOFException("Unexpected end of stream");
        }
        sVar.L$0 = null;
        sVar.L$1 = null;
        sVar.label = 2;
        if (fVar.B1(bArr, i10 + iIntValue, i11 - iIntValue, sVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    @Override // pl.n
    @os.m
    public Object A(long j10, @os.l um.d<? super l2> dVar) {
        return r2(this, j10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object A1(tl.e eVar, int i10, um.d<? super l2> dVar) {
        t tVar;
        if (dVar instanceof t) {
            tVar = (t) dVar;
            int i11 = tVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                tVar.label = i11 - Integer.MIN_VALUE;
            } else {
                tVar = new t(dVar);
            }
        } else {
            tVar = new t(dVar);
        }
        Object obj = tVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = tVar.label;
        if (i12 != 0) {
            if (i12 == 1) {
                i10 = tVar.I$0;
                eVar = (tl.e) tVar.L$1;
                this = (f) tVar.L$0;
                d1.n(obj);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
        d1.n(obj);
        tVar.L$0 = this;
        tVar.L$1 = eVar;
        tVar.I$0 = i10;
        tVar.label = 1;
        if (P0(i10, tVar) == aVar) {
            return aVar;
        }
        tVar.L$0 = null;
        tVar.L$1 = null;
        tVar.label = 2;
        if (this.x1(eVar, i10, tVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    @Override // pl.k
    @os.m
    public Object B(@os.l um.d<? super Float> dVar) {
        return v1(this, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0050  */
    /* JADX WARN: Code duplicated, block: B:18:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    /* JADX WARN: Code duplicated, block: B:22:0x0074  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0067 -> B:20:0x006b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object B1(byte[] r8, int r9, int r10, um.d<? super lm.l2> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof pl.f.u
            if (r0 == 0) goto L13
            r0 = r11
            pl.f$u r0 = (pl.f.u) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$u r0 = new pl.f$u
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            int r7 = r0.I$2
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r2 = r0.L$0
            pl.f r2 = (pl.f) r2
            lm.d1.n(r11)
            r5 = r0
            r0 = r8
            r8 = r2
            r2 = r5
            r6 = r10
            r10 = r9
            r9 = r6
            goto L6b
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            lm.d1.n(r11)
            r11 = 0
            r5 = r8
            r8 = r7
            r7 = r11
            r11 = r10
            r10 = r9
            r9 = r5
        L4e:
            if (r7 >= r11) goto L80
            int r2 = r10 + r7
            int r4 = r11 - r7
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r7
            r0.label = r3
            java.lang.Object r2 = r8.v(r9, r2, r4, r0)
            if (r2 != r1) goto L67
            return r1
        L67:
            r5 = r0
            r0 = r11
            r11 = r2
            r2 = r5
        L6b:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r4 = -1
            if (r11 == r4) goto L78
            int r7 = r7 + r11
            r11 = r0
            r0 = r2
            goto L4e
        L78:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r8 = "Unexpected end of stream"
            r7.<init>(r8)
            throw r7
        L80:
            lm.l2 r7 = lm.l2.f10208a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.B1(byte[], int, int, um.d):java.lang.Object");
    }

    @Override // pl.k
    @os.m
    public Object C(@os.l um.d<? super Short> dVar) {
        return L1(this, dVar);
    }

    @Override // pl.k
    @os.m
    public Object D(@os.l um.d<? super Long> dVar) {
        return E1(this, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x0077
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object D1(um.d<? super java.lang.Integer> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof pl.f.v
            if (r0 == 0) goto L13
            r0 = r8
            pl.f$v r0 = (pl.f.v) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$v r0 = new pl.f$v
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            int r7 = r0.I$0
            java.lang.Object r2 = r0.L$1
            pl.f r2 = (pl.f) r2
            java.lang.Object r5 = r0.L$0
            pl.f r5 = (pl.f) r5
            lm.d1.n(r8)
            r8 = r7
            r7 = r2
            r2 = r0
            r0 = r5
            goto L53
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            lm.d1.n(r8)
            r2 = r0
            r8 = r3
            r0 = r7
        L44:
            r2.L$0 = r0
            r2.L$1 = r7
            r2.I$0 = r8
            r2.label = r4
            java.lang.Object r5 = r7.P0(r8, r2)
            if (r5 != r1) goto L53
            return r1
        L53:
            tl.v r5 = r7.f13194e
            boolean r5 = r5.c1(r8)
            if (r5 == 0) goto L77
            tl.v r7 = r0.f13194e
            int r7 = tl.m0.e(r7)
            tl.q r8 = r0.R()
            tl.q r1 = tl.q.BIG_ENDIAN
            if (r8 != r1) goto L6a
            goto L6e
        L6a:
            int r7 = java.lang.Integer.reverseBytes(r7)
        L6e:
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            r0.H0(r3)
            return r8
        L77:
            r5 = 2
            r6 = 0
            R0(r7, r8, r6, r5, r6)
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.D1(um.d):java.lang.Object");
    }

    @Override // pl.k
    @os.m
    public Object E(long j10, int i10, @os.l um.d<? super tl.v> dVar) {
        return J1(this, j10, i10, dVar);
    }

    @Override // pl.k
    @os.m
    @lm.k(message = "Use read instead.")
    public Object F(@os.l jn.p<? super pl.j0, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        return N1(this, pVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0053 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0051 -> B:18:0x0054). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x0078
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object F1(um.d<? super java.lang.Long> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof pl.f.w
            if (r0 == 0) goto L13
            r0 = r8
            pl.f$w r0 = (pl.f.w) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$w r0 = new pl.f$w
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            int r7 = r0.I$0
            java.lang.Object r2 = r0.L$1
            pl.f r2 = (pl.f) r2
            java.lang.Object r5 = r0.L$0
            pl.f r5 = (pl.f) r5
            lm.d1.n(r8)
            r8 = r7
            r7 = r2
            r2 = r0
            r0 = r5
            goto L54
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            lm.d1.n(r8)
            r2 = r0
            r8 = r3
            r0 = r7
        L45:
            r2.L$0 = r0
            r2.L$1 = r7
            r2.I$0 = r8
            r2.label = r4
            java.lang.Object r5 = r7.P0(r8, r2)
            if (r5 != r1) goto L54
            return r1
        L54:
            tl.v r5 = r7.f13194e
            boolean r5 = r5.c1(r8)
            if (r5 == 0) goto L78
            tl.v r7 = r0.f13194e
            long r7 = tl.m0.g(r7)
            tl.q r1 = r0.R()
            tl.q r2 = tl.q.BIG_ENDIAN
            if (r1 != r2) goto L6b
            goto L6f
        L6b:
            long r7 = java.lang.Long.reverseBytes(r7)
        L6f:
            java.lang.Long r1 = new java.lang.Long
            r1.<init>(r7)
            r0.H0(r3)
            return r1
        L78:
            r5 = 2
            r6 = 0
            R0(r7, r8, r6, r5, r6)
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.F1(um.d):java.lang.Object");
    }

    @lm.k(level = lm.m.ERROR, message = "Consider providing consumed count of bytes")
    public final void G0() {
        H0(0);
    }

    public final Object G1(int i10, jn.a aVar, um.d<?> dVar) throws Throwable {
        while (true) {
            P0(i10, dVar);
            if (this.f13194e.c1(i10)) {
                aVar.invoke();
                throw new lm.y();
            }
            R0(this, i10, null, 2, null);
        }
    }

    @Override // pl.n
    @os.m
    public Object H(byte b10, @os.l um.d<? super l2> dVar) {
        return j2(this, b10, dVar);
    }

    public final void H0(int i10) {
        b2(this.f13192c.f() + ((long) i10));
        this.f13195f.c();
    }

    @lm.k(level = lm.m.ERROR, message = "Consider providing written count of bytes")
    public final void I0() throws Throwable {
        J0(0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object I1(tl.s sVar, int i10, um.d<? super tl.v> dVar) throws Throwable {
        x xVar;
        if (dVar instanceof x) {
            xVar = (x) dVar;
            int i11 = xVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                xVar.label = i11 - Integer.MIN_VALUE;
            } else {
                xVar = new x(dVar);
            }
        } else {
            xVar = new x(dVar);
        }
        Object obj = xVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = xVar.label;
        if (i12 == 0) {
            d1.n(obj);
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i13 = xVar.I$0;
            sVar = (tl.s) xVar.L$1;
            f fVar = (f) xVar.L$0;
            d1.n(obj);
            i10 = i13;
            this = fVar;
        }
        while (i10 > 0) {
            int iMin = (int) Math.min(i10, this.f13194e.S0());
            i10 -= iMin;
            sVar.m2(this.f13194e, iMin);
            this.H0(iMin);
            this.Q0(i10, sVar);
            if (i10 > 0) {
                xVar.L$0 = this;
                xVar.L$1 = sVar;
                xVar.I$0 = i10;
                xVar.label = 1;
                if (this.P0(1, xVar) == aVar) {
                    return aVar;
                }
            }
        }
        this.Q0(i10, sVar);
        return sVar.z2();
    }

    @Override // pl.n
    @os.m
    @tl.f0
    public Object J(@os.l jn.p<? super p0, ? super um.d<? super l2>, ? extends Object> pVar, @os.l um.d<? super l2> dVar) {
        return u2(this, pVar, dVar);
    }

    public final void J0(int i10) throws Throwable {
        c2(this.f13192c.g() + ((long) i10));
        if (this.f13192c.a()) {
            this.f13193d.close();
            V0();
        }
        if (q0() || q() == 0) {
            flush();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K1(tl.s sVar, long j10, um.d<? super tl.v> dVar) throws Throwable {
        y yVar;
        if (dVar instanceof y) {
            yVar = (y) dVar;
            int i10 = yVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                yVar.label = i10 - Integer.MIN_VALUE;
            } else {
                yVar = new y(dVar);
            }
        } else {
            yVar = new y(dVar);
        }
        Object obj = yVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = yVar.label;
        if (i11 == 0) {
            d1.n(obj);
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j11 = yVar.J$0;
            tl.s sVar2 = (tl.s) yVar.L$1;
            f fVar = (f) yVar.L$0;
            d1.n(obj);
            sVar = sVar2;
            this = fVar;
            j10 = j11;
        }
        while (sVar.P0() < j10) {
            long jMin = Math.min(j10 - ((long) sVar.P0()), this.f13194e.S0());
            sVar.n2(this.f13194e, jMin);
            this.H0((int) jMin);
            this.X0(sVar);
            if (this.p0() || sVar.P0() == ((int) j10)) {
                break;
            }
            yVar.L$0 = this;
            yVar.L$1 = sVar;
            yVar.J$0 = j10;
            yVar.label = 1;
            if (this.P0(1, yVar) == aVar) {
                return aVar;
            }
        }
        this.X0(sVar);
        return sVar.z2();
    }

    @Override // pl.n
    @os.m
    public Object L(@os.l tl.o0 o0Var, @os.l um.d<? super Integer> dVar) {
        return f2(this, o0Var, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object L0(int i10, @os.l um.d<? super l2> dVar) {
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
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = cVar.label;
        if (i12 == 0) {
            d1.n(obj);
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i13 = cVar.I$0;
            f fVar = (f) cVar.L$0;
            d1.n(obj);
            i10 = i13;
            this = fVar;
        }
        while (this.d() < i10 && !this.f13192c.a()) {
            wl.a aVar2 = this.f13195f;
            cVar.L$0 = this;
            cVar.I$0 = i10;
            cVar.label = 1;
            if (aVar2.d(cVar) == aVar) {
                return aVar;
            }
        }
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object M0(int i10, @os.l um.d<? super l2> dVar) {
        d dVar2;
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
        if (i12 == 0) {
            d1.n(obj);
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i13 = dVar2.I$0;
            f fVar = (f) dVar2.L$0;
            d1.n(obj);
            i10 = i13;
            this = fVar;
        }
        while (this.q() < i10 && !this.f13192c.a()) {
            if (!this.Y0()) {
                wl.a aVar2 = this.f13195f;
                dVar2.L$0 = this;
                dVar2.I$0 = i10;
                dVar2.label = 1;
                if (aVar2.d(dVar2) == aVar) {
                    return aVar;
                }
            }
        }
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x0078
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object M1(um.d<? super java.lang.Short> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof pl.f.z
            if (r0 == 0) goto L13
            r0 = r7
            pl.f$z r0 = (pl.f.z) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$z r0 = new pl.f$z
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$1
            pl.f r2 = (pl.f) r2
            java.lang.Object r5 = r0.L$0
            pl.f r5 = (pl.f) r5
            lm.d1.n(r7)
            r7 = r6
            r6 = r2
            r2 = r0
            r0 = r5
            goto L53
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            lm.d1.n(r7)
            r2 = r0
            r7 = r4
            r0 = r6
        L44:
            r2.L$0 = r0
            r2.L$1 = r6
            r2.I$0 = r7
            r2.label = r3
            java.lang.Object r5 = r6.P0(r7, r2)
            if (r5 != r1) goto L53
            return r1
        L53:
            tl.v r5 = r6.f13194e
            boolean r5 = r5.c1(r7)
            if (r5 == 0) goto L78
            tl.v r6 = r0.f13194e
            short r6 = tl.m0.k(r6)
            tl.q r7 = r0.R()
            tl.q r1 = tl.q.BIG_ENDIAN
            if (r7 != r1) goto L6a
            goto L6f
        L6a:
            short r6 = (short) r6
            short r6 = java.lang.Short.reverseBytes(r6)
        L6f:
            java.lang.Short r7 = new java.lang.Short
            r7.<init>(r6)
            r0.H0(r4)
            return r7
        L78:
            r5 = 0
            R0(r6, r7, r5, r4, r5)
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.M1(um.d):java.lang.Object");
    }

    @Override // pl.n
    @os.m
    public Object N(@os.l um.d<? super l2> dVar) {
        return N0(this, dVar);
    }

    @Override // pl.k
    @os.m
    public <A extends Appendable> Object O(@os.l A a10, int i10, @os.l um.d<? super Boolean> dVar) {
        return P1(this, a10, i10, dVar);
    }

    @os.m
    public final Object O0(@os.l um.d<? super Boolean> dVar) {
        return !this.f13194e.B1() ? Boolean.TRUE : P0(1, dVar);
    }

    @Override // pl.k
    @os.m
    public Object P(long j10, @os.l um.d<? super Long> dVar) {
        return T0(this, j10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object P0(int i10, @os.l um.d<? super Boolean> dVar) throws Throwable {
        C0327f c0327f;
        if (dVar instanceof C0327f) {
            c0327f = (C0327f) dVar;
            int i11 = c0327f.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c0327f.label = i11 - Integer.MIN_VALUE;
            } else {
                c0327f = new C0327f(dVar);
            }
        } else {
            c0327f = new C0327f(dVar);
        }
        Object obj = c0327f.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = c0327f.label;
        if (i12 == 0) {
            d1.n(obj);
            if (i10 < 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            c0327f.L$0 = this;
            c0327f.I$0 = i10;
            c0327f.label = 1;
            if (L0(i10, c0327f) == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = c0327f.I$0;
            this = (f) c0327f.L$0;
            d1.n(obj);
        }
        this.k1();
        Throwable thB = this.f13192c.b();
        if (thB == null) {
            return Boolean.valueOf(!this.p0() && this.d() >= i10);
        }
        throw thB;
    }

    @Override // pl.k
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ Object Q(jn.p pVar, um.d dVar) {
        return pl.c.a.a(this, pVar, dVar);
    }

    public final void Q0(int i10, tl.s sVar) throws Throwable {
        Throwable thB = this.f13192c.b();
        if (thB != null) {
            if (sVar == null) {
                throw thB;
            }
            sVar.close();
            throw thB;
        }
        if (!this.f13192c.a() || d() >= i10) {
            return;
        }
        if (sVar != null) {
            sVar.close();
        }
        throw new EOFException(i10 + " bytes required but EOF reached");
    }

    public final tl.o0 Q1(int i10) {
        if (this.f13194e.B1()) {
            k1();
        }
        tl.o0 o0Var = (tl.o0) this.f13194e.k2(i10);
        if (o0Var == null) {
            a2(ul.b.f16311i.a());
            Z1(0);
        } else {
            a2(o0Var);
            tl.m mVar = o0Var.f15821b;
            Z1(mVar.f15874c - mVar.f15873b);
        }
        return o0Var;
    }

    @Override // pl.k
    @os.l
    public tl.q R() {
        return this.f13192c.e();
    }

    public final double R1(double d10) {
        return R() == tl.q.BIG_ENDIAN ? d10 : Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10)));
    }

    public final void S0() {
        tl.m mVar = this.f13192c.d().f15821b;
        int iC = this.f13192c.c() - (mVar.f15874c - mVar.f15873b);
        if (this.f13192c.d() != tl.e.f15818d.a()) {
            ul.k.e(this.f13194e, this.f13192c.d());
        }
        if (iC > 0) {
            H0(iC);
        }
        Z1(0);
        a2(ul.b.f16311i.a());
    }

    public final float S1(float f10) {
        return R() == tl.q.BIG_ENDIAN ? f10 : Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10)));
    }

    @Override // pl.k
    @os.m
    public Object T(@os.l um.d<? super Double> dVar) {
        return t1(this, dVar);
    }

    public final int T1(int i10) {
        return R() == tl.q.BIG_ENDIAN ? i10 : Integer.reverseBytes(i10);
    }

    @Override // pl.k
    public long U() {
        return this.f13192c.f();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:24:0x0063  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0049 -> B:19:0x004d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object U0(long r9, long r11, um.d<? super java.lang.Long> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof pl.f.h
            if (r0 == 0) goto L13
            r0 = r13
            pl.f$h r0 = (pl.f.h) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$h r0 = new pl.f$h
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            long r8 = r0.J$1
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$0
            pl.f r12 = (pl.f) r12
            lm.d1.n(r13)
            goto L4d
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            lm.d1.n(r13)
        L3a:
            r0.L$0 = r8
            r0.J$0 = r9
            r0.J$1 = r11
            r0.label = r3
            java.lang.Object r13 = r8.w(r3, r0)
            if (r13 != r1) goto L49
            return r1
        L49:
            r6 = r11
            r12 = r8
            r10 = r9
            r8 = r6
        L4d:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L56
            goto L6f
        L56:
            tl.v r13 = r12.f13194e
            long r4 = r10 - r8
            long r4 = r13.t1(r4)
            long r8 = r8 + r4
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 >= 0) goto L6f
            boolean r13 = r12.p0()
            if (r13 == 0) goto L6a
            goto L6f
        L6a:
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
            goto L3a
        L6f:
            r12.W0()
            java.lang.Long r10 = new java.lang.Long
            r10.<init>(r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.U0(long, long, um.d):java.lang.Object");
    }

    public final long U1(long j10) {
        return R() == tl.q.BIG_ENDIAN ? j10 : Long.reverseBytes(j10);
    }

    @Override // pl.a0
    @os.l
    public p0 V() {
        return new g();
    }

    public final void V0() throws Throwable {
        if (this.f13192c.a()) {
            Throwable thB = this.f13192c.b();
            if (thB != null) {
                throw thB;
            }
            throw new pl.s("Channel is already closed");
        }
    }

    public final short V1(short s10) {
        return R() == tl.q.BIG_ENDIAN ? s10 : Short.reverseBytes(s10);
    }

    @Override // pl.a0
    public void W(int i10) throws Throwable {
        this.f13193d.d();
        J0(i10);
    }

    public final void W0() throws Throwable {
        Throwable thB = this.f13192c.b();
        if (thB != null) {
            throw thB;
        }
    }

    public final <T> T W1(jn.a<? extends T> aVar, jn.a<? extends T> aVar2) {
        return o0() == tl.q.BIG_ENDIAN ? aVar.invoke() : aVar2.invoke();
    }

    public final void X0(tl.s sVar) throws Throwable {
        Throwable thB = this.f13192c.b();
        if (thB == null) {
            return;
        }
        sVar.close();
        throw thB;
    }

    public final void X1(boolean z10) {
        this.f13192c.i(z10);
    }

    public final boolean Y0() {
        if (this.f13193d.D2()) {
            return false;
        }
        Z0();
        this.f13195f.c();
        return true;
    }

    public final void Y1(Throwable th2) {
        this.f13192c.j(th2);
    }

    @Override // pl.z
    @os.l
    public pl.j0 Z() {
        return this;
    }

    public final void Z0() {
        synchronized (this.f13196g) {
            ul.b bVarH2 = this.f13193d.h2();
            kn.l0.m(bVarH2);
            this.f13197h.k2(bVarH2);
            l2 l2Var = l2.f10208a;
        }
    }

    public final void Z1(int i10) {
        this.f13192c.k(i10);
    }

    @Override // pl.k, pl.n
    @os.m
    public final Throwable a() {
        return this.f13192c.b();
    }

    @Override // pl.k
    @os.m
    public Object a0(@os.l um.d<? super Byte> dVar) {
        return r1(this, dVar);
    }

    public final boolean a1() {
        return this.f13192c.a();
    }

    public final void a2(ul.b bVar) {
        this.f13192c.l(bVar);
    }

    @Override // pl.f0
    @os.m
    public tl.o0 b(int i10) throws Throwable {
        Throwable thB = this.f13192c.b();
        if (thB != null) {
            throw thB;
        }
        S0();
        return Q1(i10);
    }

    @Override // pl.f0
    public int b0(int i10) throws Throwable {
        Throwable thB = this.f13192c.b();
        if (thB != null) {
            throw thB;
        }
        if (i10 == 0) {
            return 0;
        }
        int iO = this.f13194e.o(i10);
        H0(i10);
        Q1(1);
        return iO;
    }

    public final int b1() {
        return this.f13197h.P0();
    }

    public final void b2(long j10) {
        this.f13192c.n(j10);
    }

    @Override // pl.k
    public boolean c(@os.m Throwable th2) {
        if (this.f13192c.b() != null || this.f13192c.a()) {
            return false;
        }
        if (th2 == null) {
            th2 = new CancellationException("Channel cancelled");
        }
        return f(th2);
    }

    @Override // pl.k
    @os.m
    public Object c0(int i10, @os.l um.d<? super String> dVar) {
        return O1(this, i10, dVar);
    }

    public final int c1() {
        return this.f13192c.c();
    }

    public final void c2(long j10) {
        this.f13192c.o(j10);
    }

    @Override // pl.k
    public int d() {
        return this.f13197h.P0() + ((int) this.f13194e.S0());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    @Override // pl.k
    @os.m
    public final Object d0(@os.l ByteBuffer byteBuffer, long j10, long j11, long j12, long j13, @os.l um.d<? super Long> dVar) {
        i iVar;
        k1.g gVar;
        if (dVar instanceof i) {
            iVar = (i) dVar;
            int i10 = iVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar = new i(dVar);
            }
        } else {
            iVar = new i(dVar);
        }
        Object obj = iVar.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = iVar.label;
        if (i11 == 0) {
            d1.n(obj);
            k1.g gVar2 = new k1.g();
            jn.p<? super pl.j0, ? super um.d<? super l2>, ? extends Object> jVar = new j(j12, j11, gVar2, j13, byteBuffer, j10, null);
            iVar.L$0 = gVar2;
            iVar.label = 1;
            if (F(jVar, iVar) == obj2) {
                return obj2;
            }
            gVar = gVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gVar = (k1.g) iVar.L$0;
            d1.n(obj);
        }
        return new Long(gVar.element);
    }

    public final ul.b d1() {
        return this.f13192c.d();
    }

    public final int d2() {
        return this.f13193d.P0() + d();
    }

    @Override // pl.k, pl.n
    public boolean e() {
        return this.f13192c.a();
    }

    @Override // pl.n
    @os.m
    public Object e0(short s10, @os.l um.d<? super l2> dVar) {
        return t2(this, s10, dVar);
    }

    public final long e2(@os.l f fVar, long j10) throws Throwable {
        kn.l0.p(fVar, "dst");
        long jS0 = this.f13194e.S0();
        if (jS0 > j10) {
            return 0L;
        }
        fVar.f13193d.l2(this.f13194e);
        int i10 = (int) jS0;
        fVar.J0(i10);
        H0(i10);
        return jS0;
    }

    @Override // pl.n
    public boolean f(@os.m Throwable th2) {
        if (this.f13192c.a() || this.f13192c.b() != null) {
            return false;
        }
        Y1(th2);
        X1(true);
        if (th2 != null) {
            this.f13194e.z2();
            this.f13193d.close();
            this.f13197h.close();
        } else {
            flush();
        }
        this.f13195f.b(th2);
        return true;
    }

    @Override // pl.n
    @os.m
    public Object f0(float f10, @os.l um.d<? super l2> dVar) {
        return l2(this, f10, dVar);
    }

    @os.l
    public final tl.v f1() {
        return this.f13194e;
    }

    @Override // pl.n
    public void flush() {
        Y0();
    }

    @Override // pl.n
    public void g(@os.l tl.q qVar) {
        kn.l0.p(qVar, "value");
        this.f13192c.p(qVar);
    }

    @os.l
    public final tl.s g1() {
        return this.f13193d;
    }

    @Override // pl.n
    @os.m
    public Object h(@os.l tl.e eVar, @os.l um.d<? super l2> dVar) {
        return m2(this, eVar, dVar);
    }

    @Override // pl.n
    @os.m
    public Object h0(int i10, @os.l um.d<? super l2> dVar) {
        return q2(this, i10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object h2(tl.o0 o0Var, um.d<? super Integer> dVar) {
        d0 d0Var;
        if (dVar instanceof d0) {
            d0Var = (d0) dVar;
            int i10 = d0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                d0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                d0Var = new d0(dVar);
            }
        } else {
            d0Var = new d0(dVar);
        }
        Object objL = d0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = d0Var.label;
        if (i11 != 0) {
            if (i11 == 1) {
                o0Var = (tl.o0) d0Var.L$1;
                this = (f) d0Var.L$0;
                d1.n(objL);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objL);
            }
        }
        d1.n(objL);
        d0Var.L$0 = this;
        d0Var.L$1 = o0Var;
        d0Var.label = 1;
        if (M0(1, d0Var) == aVar) {
            return aVar;
        }
        d0Var.L$0 = null;
        d0Var.L$1 = null;
        d0Var.label = 2;
        objL = this.L(o0Var, d0Var);
        return objL == aVar ? aVar : objL;
    }

    @Override // pl.n
    @os.m
    public Object i(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super l2> dVar) {
        return o2(this, bArr, i10, i11, dVar);
    }

    @Override // pl.k
    @lm.k(message = "Use read instead.")
    public void i0(@os.l jn.l<? super pl.f0, l2> lVar) {
        kn.l0.p(lVar, "consumer");
        try {
            lVar.invoke(this);
        } finally {
            S0();
        }
    }

    public final long i1() {
        return this.f13192c.f();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i2(byte[] bArr, int i10, int i11, um.d<? super Integer> dVar) {
        e0 e0Var;
        if (dVar instanceof e0) {
            e0Var = (e0) dVar;
            int i12 = e0Var.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                e0Var.label = i12 - Integer.MIN_VALUE;
            } else {
                e0Var = new e0(dVar);
            }
        } else {
            e0Var = new e0(dVar);
        }
        Object objS = e0Var.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i13 = e0Var.label;
        if (i13 != 0) {
            if (i13 == 1) {
                i11 = e0Var.I$1;
                i10 = e0Var.I$0;
                bArr = (byte[]) e0Var.L$1;
                this = (f) e0Var.L$0;
                d1.n(objS);
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objS);
            }
        }
        d1.n(objS);
        e0Var.L$0 = this;
        e0Var.L$1 = bArr;
        e0Var.I$0 = i10;
        e0Var.I$1 = i11;
        e0Var.label = 1;
        if (M0(1, e0Var) == aVar) {
            return aVar;
        }
        e0Var.L$0 = null;
        e0Var.L$1 = null;
        e0Var.label = 2;
        objS = this.s(bArr, i10, i11, e0Var);
        return objS == aVar ? aVar : objS;
    }

    public final long j1() {
        return this.f13192c.g();
    }

    public final void k1() {
        synchronized (this.f13196g) {
            ul.k.q(this.f13194e, this.f13197h);
        }
    }

    @Override // pl.k
    @os.m
    public Object l(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super l2> dVar) {
        return z1(this, bArr, i10, i11, dVar);
    }

    @Override // pl.z
    public void l0() {
        S0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object l1(@os.l tl.e eVar, @os.l um.d<? super Integer> dVar) throws Throwable {
        k kVar;
        if (dVar instanceof k) {
            kVar = (k) dVar;
            int i10 = kVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                kVar.label = i10 - Integer.MIN_VALUE;
            } else {
                kVar = new k(dVar);
            }
        } else {
            kVar = new k(dVar);
        }
        Object obj = kVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = kVar.label;
        if (i11 == 0) {
            d1.n(obj);
            Throwable thB = this.f13192c.b();
            if (thB != null) {
                throw thB;
            }
            if (this.f13192c.a() && d() == 0) {
                return new Integer(-1);
            }
            tl.m mVar = eVar.f15821b;
            if (mVar.f15872a - mVar.f15874c == 0) {
                return new Integer(0);
            }
            if (d() == 0) {
                kVar.L$0 = this;
                kVar.L$1 = eVar;
                kVar.label = 1;
                if (P0(1, kVar) == aVar) {
                    return aVar;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar = (tl.e) kVar.L$1;
            this = (f) kVar.L$0;
            d1.n(obj);
        }
        if (!this.f13194e.k()) {
            this.k1();
        }
        tl.m mVar2 = eVar.f15821b;
        int iMin = (int) Math.min(mVar2.f15872a - mVar2.f15874c, this.f13194e.S0());
        tl.i0.q(this.f13194e, eVar, iMin);
        this.H0(iMin);
        return new Integer(iMin);
    }

    @Override // pl.k
    public void m(@os.l tl.q qVar) {
        kn.l0.p(qVar, "value");
        this.f13192c.m(qVar);
    }

    @Override // pl.n
    @os.m
    public Object m0(@os.l tl.o0 o0Var, @os.l um.d<? super l2> dVar) {
        return n2(this, o0Var, dVar);
    }

    @Override // pl.k
    @os.m
    public Object n(@os.l tl.o0 o0Var, @os.l um.d<? super Integer> dVar) {
        return l1(o0Var, dVar);
    }

    @Override // pl.n
    public long o() {
        return this.f13192c.g();
    }

    @Override // pl.n
    @os.l
    public tl.q o0() {
        return this.f13192c.h();
    }

    public final int o1() throws Throwable {
        Throwable thB = this.f13192c.b();
        if (thB != null) {
            throw thB;
        }
        if (d() <= 0) {
            return -1;
        }
        k1();
        return -1;
    }

    @Override // pl.n
    @os.m
    public Object p(@os.l tl.v vVar, @os.l um.d<? super l2> dVar) {
        return s2(this, vVar, dVar);
    }

    @Override // pl.k
    public boolean p0() {
        return this.f13192c.a() && this.f13194e.B1() && this.f13197h.P0() == 0 && this.f13193d.D2();
    }

    @Override // pl.n
    public int q() {
        return Math.max(0, 4088 - (this.f13193d.P0() + d()));
    }

    @Override // pl.n
    public boolean q0() {
        return this.f13191b;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object q1(um.d<? super Boolean> dVar) throws Throwable {
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
        Object objR = mVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = mVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                this = (f) mVar.L$0;
                d1.n(objR);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objR);
            }
        }
        d1.n(objR);
        mVar.L$0 = this;
        mVar.label = 1;
        if (P0(1, mVar) == aVar) {
            return aVar;
        }
        R0(this, 1, null, 2, null);
        mVar.L$0 = null;
        mVar.label = 2;
        objR = this.r(mVar);
        return objR == aVar ? aVar : objR;
    }

    @Override // pl.k
    @os.m
    public Object r(@os.l um.d<? super Boolean> dVar) {
        return p1(this, dVar);
    }

    @Override // pl.n
    @os.m
    public Object s(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super Integer> dVar) {
        return g2(this, bArr, i10, i11, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003e -> B:18:0x0041). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object s1(um.d<? super java.lang.Byte> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof pl.f.n
            if (r0 == 0) goto L13
            r0 = r5
            pl.f$n r0 = (pl.f.n) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$n r0 = new pl.f$n
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            pl.f r4 = (pl.f) r4
            lm.d1.n(r5)
            goto L41
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            lm.d1.n(r5)
        L36:
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.P0(r3, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            tl.v r5 = r4.f13194e
            boolean r5 = r5.B1()
            if (r5 != 0) goto L57
            tl.v r5 = r4.f13194e
            byte r5 = r5.readByte()
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)
            r4.H0(r3)
            return r5
        L57:
            r5 = 2
            r2 = 0
            R0(r4, r3, r2, r5, r2)
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.s1(um.d):java.lang.Object");
    }

    @Override // pl.n
    @os.m
    public Object t(double d10, @os.l um.d<? super l2> dVar) {
        return k2(this, d10, dVar);
    }

    @Override // pl.k
    @os.m
    public Object u(int i10, int i11, @os.l um.d<? super tl.v> dVar) {
        return H1(this, i10, i11, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0053 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0051 -> B:18:0x0054). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x0080
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object u1(um.d<? super java.lang.Double> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof pl.f.o
            if (r0 == 0) goto L13
            r0 = r8
            pl.f$o r0 = (pl.f.o) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$o r0 = new pl.f$o
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            int r7 = r0.I$0
            java.lang.Object r2 = r0.L$1
            pl.f r2 = (pl.f) r2
            java.lang.Object r5 = r0.L$0
            pl.f r5 = (pl.f) r5
            lm.d1.n(r8)
            r8 = r7
            r7 = r2
            r2 = r0
            r0 = r5
            goto L54
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            lm.d1.n(r8)
            r2 = r0
            r8 = r3
            r0 = r7
        L45:
            r2.L$0 = r0
            r2.L$1 = r7
            r2.I$0 = r8
            r2.label = r4
            java.lang.Object r5 = r7.P0(r8, r2)
            if (r5 != r1) goto L54
            return r1
        L54:
            tl.v r5 = r7.f13194e
            boolean r5 = r5.c1(r8)
            if (r5 == 0) goto L80
            tl.v r7 = r0.f13194e
            double r7 = tl.m0.a(r7)
            tl.q r1 = r0.R()
            tl.q r2 = tl.q.BIG_ENDIAN
            if (r1 != r2) goto L6b
            goto L77
        L6b:
            long r7 = java.lang.Double.doubleToRawLongBits(r7)
            long r7 = java.lang.Long.reverseBytes(r7)
            double r7 = java.lang.Double.longBitsToDouble(r7)
        L77:
            java.lang.Double r1 = new java.lang.Double
            r1.<init>(r7)
            r0.H0(r3)
            return r1
        L80:
            r5 = 2
            r6 = 0
            R0(r7, r8, r6, r5, r6)
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.u1(um.d):java.lang.Object");
    }

    @Override // pl.k
    @os.m
    public Object v(@os.l byte[] bArr, int i10, int i11, @os.l um.d<? super Integer> dVar) {
        return n1(this, bArr, i10, i11, dVar);
    }

    @Override // pl.j0
    @os.m
    public Object w(int i10, @os.l um.d<? super Boolean> dVar) {
        return K0(this, i10, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:18:0x0053). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x007f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object w1(um.d<? super java.lang.Float> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof pl.f.p
            if (r0 == 0) goto L13
            r0 = r8
            pl.f$p r0 = (pl.f.p) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.f$p r0 = new pl.f$p
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            int r7 = r0.I$0
            java.lang.Object r2 = r0.L$1
            pl.f r2 = (pl.f) r2
            java.lang.Object r5 = r0.L$0
            pl.f r5 = (pl.f) r5
            lm.d1.n(r8)
            r8 = r7
            r7 = r2
            r2 = r0
            r0 = r5
            goto L53
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            lm.d1.n(r8)
            r2 = r0
            r8 = r3
            r0 = r7
        L44:
            r2.L$0 = r0
            r2.L$1 = r7
            r2.I$0 = r8
            r2.label = r4
            java.lang.Object r5 = r7.P0(r8, r2)
            if (r5 != r1) goto L53
            return r1
        L53:
            tl.v r5 = r7.f13194e
            boolean r5 = r5.c1(r8)
            if (r5 == 0) goto L7f
            tl.v r7 = r0.f13194e
            float r7 = tl.m0.c(r7)
            tl.q r8 = r0.R()
            tl.q r1 = tl.q.BIG_ENDIAN
            if (r8 != r1) goto L6a
            goto L76
        L6a:
            int r7 = java.lang.Float.floatToRawIntBits(r7)
            int r7 = java.lang.Integer.reverseBytes(r7)
            float r7 = java.lang.Float.intBitsToFloat(r7)
        L76:
            java.lang.Float r8 = new java.lang.Float
            r8.<init>(r7)
            r0.H0(r3)
            return r8
        L7f:
            r5 = 2
            r6 = 0
            R0(r7, r8, r6, r5, r6)
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.f.w1(um.d):java.lang.Object");
    }

    @Override // pl.k
    @os.m
    public Object x(@os.l um.d<? super Integer> dVar) {
        return C1(this, dVar);
    }

    public final Object x1(tl.e eVar, int i10, um.d<? super l2> dVar) throws Throwable {
        tl.m mVar = eVar.f15821b;
        if (!(i10 <= mVar.f15872a - mVar.f15874c)) {
            new q(i10).a();
            throw new lm.y();
        }
        if (!(i10 >= 0)) {
            new r().a();
            throw new lm.y();
        }
        if (this.f13192c.b() != null) {
            Throwable thB = this.f13192c.b();
            kn.l0.m(thB);
            throw thB;
        }
        if (this.f13194e.S0() >= i10) {
            tl.i0.q(this.f13194e, eVar, i10);
            l2 l2Var = l2.f10208a;
            H0(i10);
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            return l2Var;
        }
        if (!this.f13192c.a()) {
            Object objA1 = A1(eVar, i10, dVar);
            return objA1 == wm.a.COROUTINE_SUSPENDED ? objA1 : l2.f10208a;
        }
        StringBuilder sbA = h.b.a("Channel is closed and not enough bytes available: required ", i10, " but ");
        sbA.append(d());
        sbA.append(" available");
        throw new EOFException(sbA.toString());
    }

    @Override // pl.k
    @os.m
    public Object y(@os.l tl.o0 o0Var, int i10, @os.l um.d<? super l2> dVar) {
        return y1(this, o0Var, i10, dVar);
    }

    @Override // pl.n
    @os.m
    public Object z(@os.l ByteBuffer byteBuffer, int i10, int i11, @os.l um.d<? super l2> dVar) {
        return p2(this, byteBuffer, i10, i11, dVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(tl.o0 o0Var, boolean z10, bm.h hVar, int i10, kn.w wVar) {
        if ((i10 & 4) != 0) {
            ul.b.f16311i.getClass();
            hVar = ul.b.f16315w;
        }
        this(o0Var, z10, hVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public f(tl.o0 o0Var, boolean z10) {
        this(o0Var, z10, ul.b.f16315w);
        kn.l0.p(o0Var, "initial");
        ul.b.f16311i.getClass();
    }
}
