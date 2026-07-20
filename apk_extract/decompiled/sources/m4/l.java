package m4;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public interface l extends Future {
    void addListener(Runnable runnable, Executor executor);
}
