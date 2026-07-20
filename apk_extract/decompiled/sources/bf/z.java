package bf;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import ze.c2;
import ze.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements oi.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f1302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ vi.c f1303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f1304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c2 f1305d;

    public z(AtomicBoolean atomicBoolean, vi.c cVar, t tVar, c2 c2Var) {
        this.f1302a = atomicBoolean;
        this.f1303b = cVar;
        this.f1304c = tVar;
        this.f1305d = c2Var;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00b0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // oi.i
    public final Object emit(Object obj, Continuation continuation) {
        y yVar;
        z zVar;
        c2 c2Var;
        Object obj2;
        vi.a aVar;
        t tVar;
        z zVar2;
        Object obj3;
        vi.c cVar;
        c2 c2Var2;
        Object obj4;
        c2 c2Var3;
        vi.a aVar2;
        if (continuation instanceof y) {
            yVar = (y) continuation;
            int i8 = yVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                yVar.label = i8 - Integer.MIN_VALUE;
            } else {
                yVar = new y(this, continuation);
            }
        } else {
            yVar = new y(this, continuation);
        }
        Object obj5 = yVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = yVar.label;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    c2Var = (c2) yVar.L$3;
                    aVar = (vi.a) yVar.L$2;
                    obj2 = yVar.L$1;
                    zVar = (z) yVar.L$0;
                    ResultKt.throwOnFailure(obj5);
                } else if (i9 == 2) {
                    obj3 = yVar.L$1;
                    zVar2 = (z) yVar.L$0;
                    ResultKt.throwOnFailure(obj5);
                    cVar = zVar2.f1303b;
                    yVar.L$0 = obj3;
                    yVar.L$1 = cVar;
                    c2Var2 = zVar2.f1305d;
                    yVar.L$2 = c2Var2;
                    yVar.label = 3;
                    if (cVar.d(null, yVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj4 = obj3;
                    c2Var3 = c2Var2;
                    aVar2 = cVar;
                } else {
                    if (i9 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c2Var3 = (c2) yVar.L$2;
                    aVar2 = (vi.a) yVar.L$1;
                    obj4 = yVar.L$0;
                    ResultKt.throwOnFailure(obj5);
                }
                try {
                    c2Var3.d(obj4);
                    Unit unit = Unit.INSTANCE;
                    return Unit.INSTANCE;
                } finally {
                    ((vi.c) aVar2).e(null);
                }
            }
            ResultKt.throwOnFailure(obj5);
            if (this.f1302a.compareAndSet(false, true)) {
                yVar.L$0 = this;
                yVar.L$1 = obj;
                vi.c cVar2 = this.f1303b;
                yVar.L$2 = cVar2;
                c2 c2Var4 = this.f1305d;
                yVar.L$3 = c2Var4;
                yVar.label = 1;
                if (cVar2.d(null, yVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                zVar = this;
                c2Var = c2Var4;
                obj2 = obj;
                aVar = cVar2;
            }
            tVar = this.f1304c;
            yVar.L$0 = this;
            yVar.L$1 = obj;
            yVar.L$2 = null;
            yVar.L$3 = null;
            yVar.label = 2;
            if (tVar.a(yVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj6 = obj;
            zVar2 = this;
            obj3 = obj6;
            cVar = zVar2.f1303b;
            yVar.L$0 = obj3;
            yVar.L$1 = cVar;
            c2Var2 = zVar2.f1305d;
            yVar.L$2 = c2Var2;
            yVar.label = 3;
            if (cVar.d(null, yVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj4 = obj3;
            c2Var3 = c2Var2;
            aVar2 = cVar;
            c2Var3.d(obj4);
            Unit unit2 = Unit.INSTANCE;
            return Unit.INSTANCE;
            c2Var.c(new p1());
            Unit unit3 = Unit.INSTANCE;
            ((vi.c) aVar).e(null);
            obj = obj2;
            this = zVar;
            tVar = this.f1304c;
            yVar.L$0 = this;
            yVar.L$1 = obj;
            yVar.L$2 = null;
            yVar.L$3 = null;
            yVar.label = 2;
            if (tVar.a(yVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj7 = obj;
            zVar2 = this;
            obj3 = obj7;
            cVar = zVar2.f1303b;
            yVar.L$0 = obj3;
            yVar.L$1 = cVar;
            c2Var2 = zVar2.f1305d;
            yVar.L$2 = c2Var2;
            yVar.label = 3;
            if (cVar.d(null, yVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj4 = obj3;
            c2Var3 = c2Var2;
            aVar2 = cVar;
            c2Var3.d(obj4);
            Unit unit4 = Unit.INSTANCE;
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            ((vi.c) aVar).e(null);
            throw th2;
        }
    }
}
