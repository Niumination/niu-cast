package androidx.camera.core.impl.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CompareSizesByArea implements Comparator<Size> {
    private boolean mReverse;

    public CompareSizesByArea() {
        this(false);
    }

    public CompareSizesByArea(boolean z2) {
        this.mReverse = z2;
    }

    @Override // java.util.Comparator
    public int compare(@NonNull Size size, @NonNull Size size2) {
        int iSignum = Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        return this.mReverse ? iSignum * (-1) : iSignum;
    }
}
