package androidx.camera.camera2.internal;

import android.util.Size;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return MeteringRepeatingSession.lambda$getProperPreviewSize$0((Size) obj, (Size) obj2);
    }
}
