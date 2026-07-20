package ni;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import li.s2;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i extends FunctionReferenceImpl implements Function3 {
    public static final i INSTANCE = new i();

    public i() {
        super(3, m.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((m) obj, (ti.f) obj2, obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(m mVar, ti.f fVar, Object obj) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = m.f8295d;
        mVar.getClass();
        v vVar = (v) m.f8299k.get(mVar);
        while (!mVar.w()) {
            long andIncrement = m.e.getAndIncrement(mVar);
            long j8 = o.f8307b;
            long j10 = andIncrement / j8;
            int i8 = (int) (andIncrement % j8);
            if (vVar.f9170c != j10) {
                v vVarM = mVar.m(j10, vVar);
                if (vVarM == null) {
                    continue;
                } else {
                    vVar = vVarM;
                }
            }
            Object objI = mVar.I(vVar, i8, andIncrement, fVar);
            if (objI == o.f8316m) {
                s2 s2Var = fVar instanceof s2 ? (s2) fVar : null;
                if (s2Var != null) {
                    s2Var.c(vVar, i8);
                    return;
                }
                return;
            }
            if (objI != o.f8318o) {
                if (objI == o.f8317n) {
                    throw new IllegalStateException("unexpected");
                }
                vVar.b();
                ((ti.e) fVar).e = objI;
                return;
            }
            if (andIncrement < mVar.t()) {
                vVar.b();
            }
        }
        ((ti.e) fVar).e = o.f8315l;
    }
}
