package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements CallbackToFutureAdapter.Resolver, SurfaceRequest.TransformationInfoListener, PreviewViewImplementation.OnSurfaceNotInUseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1059c;

    public /* synthetic */ f(PreviewView.AnonymousClass1 anonymousClass1, PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        this.f1058b = anonymousClass1;
        this.f1057a = previewStreamStateObserver;
        this.f1059c = cameraInternal;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((PreviewStreamStateObserver) this.f1057a).lambda$waitForCaptureResult$2((CameraInfo) this.f1058b, (List) this.f1059c, completer);
    }

    @Override // androidx.camera.view.PreviewViewImplementation.OnSurfaceNotInUseListener
    public void onSurfaceNotInUse() {
        ((PreviewView.AnonymousClass1) this.f1058b).lambda$onSurfaceRequested$2((PreviewStreamStateObserver) this.f1057a, (CameraInternal) this.f1059c);
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((PreviewView.AnonymousClass1) this.f1057a).lambda$onSurfaceRequested$1((CameraInternal) this.f1058b, (SurfaceRequest) this.f1059c, transformationInfo);
    }

    public /* synthetic */ f(Object obj, Object obj2, Object obj3) {
        this.f1057a = obj;
        this.f1058b = obj2;
        this.f1059c = obj3;
    }
}
