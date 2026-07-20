package i;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ArchTaskExecutor.lambda$static$0(runnable);
    }
}
