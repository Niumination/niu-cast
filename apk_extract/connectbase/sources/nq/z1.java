package nq;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 {
    @a2
    public static /* synthetic */ void a() {
    }

    @os.l
    public static final Executor b(@os.l n0 n0Var) {
        Executor executorF0;
        x1 x1Var = n0Var instanceof x1 ? (x1) n0Var : null;
        return (x1Var == null || (executorF0 = x1Var.f0()) == null) ? new j1(n0Var) : executorF0;
    }

    @in.i(name = TypedValues.TransitionType.S_FROM)
    @os.l
    public static final n0 c(@os.l Executor executor) {
        n0 n0Var;
        j1 j1Var = executor instanceof j1 ? (j1) executor : null;
        return (j1Var == null || (n0Var = j1Var.f11869a) == null) ? new y1(executor) : n0Var;
    }

    @in.i(name = TypedValues.TransitionType.S_FROM)
    @os.l
    public static final x1 d(@os.l ExecutorService executorService) {
        return new y1(executorService);
    }
}
