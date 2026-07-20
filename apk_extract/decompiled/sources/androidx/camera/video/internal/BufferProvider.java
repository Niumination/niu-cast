package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Observable;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface BufferProvider<T> extends Observable<State> {

    public enum State {
        ACTIVE,
        INACTIVE
    }

    @NonNull
    l acquireBuffer();
}
