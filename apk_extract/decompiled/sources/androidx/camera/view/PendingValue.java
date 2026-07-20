package androidx.camera.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
class PendingValue<T> {

    @Nullable
    private CallbackToFutureAdapter.Completer<Void> mCompleter;

    @Nullable
    private m4.l mListenableFuture;

    @Nullable
    private T mValue;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$setValue$0(Object obj, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCompleter = completer;
        return a1.a.p(obj, "PendingValue ");
    }

    @MainThread
    public void propagateIfHasValue(Function<T, m4.l> function) {
        Threads.checkMainThread();
        T t3 = this.mValue;
        if (t3 != null) {
            m4.l lVarApply = function.apply(t3);
            CallbackToFutureAdapter.Completer<Void> completer = this.mCompleter;
            Objects.requireNonNull(completer);
            Futures.propagate(lVarApply, completer);
        }
    }

    @MainThread
    public m4.l setValue(@NonNull T t3) {
        Threads.checkMainThread();
        m4.l lVar = this.mListenableFuture;
        if (lVar != null) {
            Preconditions.checkState(!lVar.isDone(), "#setValue() is called after the value is propagated.");
            this.mListenableFuture.cancel(false);
        }
        this.mValue = t3;
        m4.l future = CallbackToFutureAdapter.getFuture(new e(0, this, t3));
        this.mListenableFuture = future;
        return future;
    }
}
