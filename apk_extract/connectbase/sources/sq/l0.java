package sq;

import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public static final vq.u0 f15308a = new vq.u0("NO_VALUE");

    @os.l
    public static final <T> e0<T> a(int i10, int i11, @os.l pq.i iVar) {
        if (i10 < 0) {
            throw new IllegalArgumentException(h.a.a("replay cannot be negative, but was ", i10).toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException(h.a.a("extraBufferCapacity cannot be negative, but was ", i11).toString());
        }
        if (i10 <= 0 && i11 <= 0 && iVar != pq.i.SUSPEND) {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + iVar).toString());
        }
        int i12 = i11 + i10;
        if (i12 < 0) {
            i12 = Integer.MAX_VALUE;
        }
        return new k0(i10, i12, iVar);
    }

    public static /* synthetic */ e0 b(int i10, int i11, pq.i iVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            iVar = pq.i.SUSPEND;
        }
        return a(i10, i11, iVar);
    }

    @os.l
    public static final <T> i<T> e(@os.l j0<? extends T> j0Var, @os.l um.g gVar, int i10, @os.l pq.i iVar) {
        return ((i10 == 0 || i10 == -3) && iVar == pq.i.SUSPEND) ? j0Var : new tq.i(j0Var, gVar, i10, iVar);
    }

    public static final Object f(Object[] objArr, long j10) {
        return objArr[((int) j10) & (objArr.length - 1)];
    }

    public static final void g(Object[] objArr, long j10, Object obj) {
        objArr[((int) j10) & (objArr.length - 1)] = obj;
    }
}
