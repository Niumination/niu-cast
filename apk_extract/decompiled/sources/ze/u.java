package ze;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public enum u implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Context.DirectExecutor";
    }
}
