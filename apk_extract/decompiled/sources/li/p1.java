package li;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface p1 extends CoroutineContext.Element {
    x0 A(Function1 function1);

    boolean H();

    Object S(Continuation continuation);

    boolean a();

    o a0(x1 x1Var);

    void h(CancellationException cancellationException);

    boolean isCancelled();

    x0 s(boolean z2, boolean z3, Function1 function1);

    boolean start();

    CancellationException t();
}
