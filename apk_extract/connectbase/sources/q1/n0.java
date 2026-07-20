package q1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public enum n0 implements Executor {
    INSTANCE;

    public static /* synthetic */ n0[] a() {
        return new n0[]{INSTANCE};
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        command.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
