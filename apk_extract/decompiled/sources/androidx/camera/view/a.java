package androidx.camera.view;

import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1050b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f1049a = i8;
        this.f1050b = obj;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        int i8 = this.f1049a;
        Object obj2 = this.f1050b;
        switch (i8) {
            case 0:
                return ((CameraController) obj2).lambda$new$0((ProcessCameraProviderWrapper) obj);
            default:
                return ((PreviewStreamStateObserver) obj2).lambda$startPreviewStreamStateFlow$1((Void) obj);
        }
    }
}
