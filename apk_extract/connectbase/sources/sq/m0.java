package sq;

import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class m0 extends tq.d<k0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    public long f15310a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    @in.f
    public um.d<? super l2> f15311b;

    @Override // tq.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@os.l k0<?> k0Var) {
        if (this.f15310a >= 0) {
            return false;
        }
        this.f15310a = k0Var.c0();
        return true;
    }

    @Override // tq.d
    @os.l
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public um.d<l2>[] b(@os.l k0<?> k0Var) {
        long j10 = this.f15310a;
        this.f15310a = -1L;
        this.f15311b = null;
        return k0Var.b0(j10);
    }
}
