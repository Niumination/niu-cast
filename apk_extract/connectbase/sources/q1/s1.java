package q1;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@o0
@t1.f("Use the methods in Futures (like immediateFuture) or SettableFuture")
public interface s1<V> extends Future<V> {
    void addListener(Runnable listener, Executor executor);
}
