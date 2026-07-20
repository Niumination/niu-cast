package sq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/ChannelAsFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n1#2:177\n*E\n"})
public final class e<T> extends tq.e<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f15266f = AtomicIntegerFieldUpdater.newUpdater(e.class, "consumed");

    @in.x
    private volatile int consumed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final pq.f0<T> f15267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15268e;

    public /* synthetic */ e(pq.f0 f0Var, boolean z10, um.g gVar, int i10, pq.i iVar, int i11, kn.w wVar) {
        this(f0Var, z10, (i11 & 4) != 0 ? um.i.INSTANCE : gVar, (i11 & 8) != 0 ? -3 : i10, (i11 & 16) != 0 ? pq.i.SUSPEND : iVar);
    }

    @Override // tq.e, sq.i
    @os.m
    public Object a(@os.l j<? super T> jVar, @os.l um.d<? super l2> dVar) {
        if (this.f16030b != -3) {
            Object objH = tq.e.h(this, jVar, dVar);
            return objH == wm.a.COROUTINE_SUSPENDED ? objH : l2.f10208a;
        }
        o();
        Object objE = m.e(jVar, this.f15267d, this.f15268e, dVar);
        return objE == wm.a.COROUTINE_SUSPENDED ? objE : l2.f10208a;
    }

    @Override // tq.e
    @os.l
    public String g() {
        return "channel=" + this.f15267d;
    }

    @Override // tq.e
    @os.m
    public Object i(@os.l pq.d0<? super T> d0Var, @os.l um.d<? super l2> dVar) {
        Object objE = m.e(new tq.y(d0Var), this.f15267d, this.f15268e, dVar);
        return objE == wm.a.COROUTINE_SUSPENDED ? objE : l2.f10208a;
    }

    @Override // tq.e
    @os.l
    public tq.e<T> j(@os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return new e(this.f15267d, this.f15268e, gVar, i10, iVar);
    }

    @Override // tq.e
    @os.l
    public i<T> k() {
        return new e(this.f15267d, this.f15268e, null, 0, null, 28, null);
    }

    @Override // tq.e
    @os.l
    public pq.f0<T> n(@os.l nq.s0 s0Var) {
        o();
        return this.f16030b == -3 ? this.f15267d : super.n(s0Var);
    }

    public final void o() {
        if (this.f15268e && f15266f.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@os.l pq.f0<? extends T> f0Var, boolean z10, @os.l um.g gVar, int i10, @os.l pq.i iVar) {
        super(gVar, i10, iVar);
        this.f15267d = f0Var;
        this.f15268e = z10;
        this.consumed = 0;
    }
}
