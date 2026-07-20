package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface ImageProxyBundle {
    @NonNull
    List<Integer> getCaptureIds();

    @NonNull
    l getImageProxy(int i8);
}
