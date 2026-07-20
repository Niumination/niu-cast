package e1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@i
public final class y {
    public static <K, V> v<K, V> c(final v<K, V> listener, final Executor executor) {
        listener.getClass();
        executor.getClass();
        return new v() { // from class: e1.x
            @Override // e1.v
            public final void onRemoval(z zVar) {
                y.e(executor, listener, zVar);
            }
        };
    }

    public static /* synthetic */ void e(Executor executor, final v vVar, final z zVar) {
        executor.execute(new Runnable() { // from class: e1.w
            @Override // java.lang.Runnable
            public final void run() {
                vVar.onRemoval(zVar);
            }
        });
    }
}
