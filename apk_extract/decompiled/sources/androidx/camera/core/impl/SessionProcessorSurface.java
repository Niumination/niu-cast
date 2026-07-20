package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.futures.Futures;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class SessionProcessorSurface extends DeferrableSurface {
    private final int mOutputConfigId;
    private final Surface mSurface;

    public SessionProcessorSurface(@NonNull Surface surface, int i8) {
        this.mSurface = surface;
        this.mOutputConfigId = i8;
    }

    public int getOutputConfigId() {
        return this.mOutputConfigId;
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    @NonNull
    public l provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }
}
