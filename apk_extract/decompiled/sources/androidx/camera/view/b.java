package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.lifecycle.ProcessCameraProvider;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function {
    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return new ProcessCameraProviderWrapperImpl((ProcessCameraProvider) obj);
    }
}
