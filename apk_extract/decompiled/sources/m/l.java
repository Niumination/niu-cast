package m;

import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener f7560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest.TransformationInfo f7561c;

    public /* synthetic */ l(SurfaceRequest.TransformationInfoListener transformationInfoListener, SurfaceRequest.TransformationInfo transformationInfo, int i8) {
        this.f7559a = i8;
        this.f7560b = transformationInfoListener;
        this.f7561c = transformationInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7559a) {
            case 0:
                this.f7560b.onTransformationInfoUpdate(this.f7561c);
                break;
            default:
                this.f7560b.onTransformationInfoUpdate(this.f7561c);
                break;
        }
    }
}
