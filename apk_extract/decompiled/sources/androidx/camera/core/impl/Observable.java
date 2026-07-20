package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface Observable<T> {

    public interface Observer<T> {
        void onError(@NonNull Throwable th2);

        void onNewData(@Nullable T t3);
    }

    void addObserver(@NonNull Executor executor, @NonNull Observer<? super T> observer);

    @NonNull
    l fetchData();

    void removeObserver(@NonNull Observer<? super T> observer);
}
