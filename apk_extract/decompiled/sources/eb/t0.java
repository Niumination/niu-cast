package eb;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4798b;

    public /* synthetic */ t0(Object obj, int i8) {
        this.f4797a = i8;
        this.f4798b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object obj2 = this.f4798b;
        switch (this.f4797a) {
            case 0:
                li.l0.p(y0.f4822l, qi.r.f9163a, null, new s0((r0) obj2, null), 2);
                return Unit.INSTANCE;
            case 1:
                li.l0.p(y0.f4822l, qi.r.f9163a, null, new w0((r0) obj2, null), 2);
                return Unit.INSTANCE;
            case 2:
                y yVar = y.f4799a;
                li.l0.p(y.f4800b, null, null, new t(null), 3);
                ((li.g2) obj2).h(null);
                return Unit.INSTANCE;
            case 3:
                sj.a aVar = jc.a.f6146a;
                jc.a.b((e1) obj2);
                return Unit.INSTANCE;
            case 4:
                ((li.x0) obj2).dispose();
                return Unit.INSTANCE;
            case 5:
                Throwable th2 = (Throwable) obj;
                if (th2 != null) {
                    ((li.r1) obj2).C(new CancellationException(th2.getMessage()));
                }
                return Unit.INSTANCE;
            default:
                Result.Companion companion = Result.INSTANCE;
                Unit unit = Unit.INSTANCE;
                ((li.l) obj2).resumeWith(Result.m159constructorimpl(unit));
                return unit;
        }
    }
}
