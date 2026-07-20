package t;

import androidx.camera.core.processing.SurfaceEdge;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f10157b;

    public /* synthetic */ b(SurfaceEdge surfaceEdge, int i8) {
        this.f10156a = i8;
        this.f10157b = surfaceEdge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f10156a;
        SurfaceEdge surfaceEdge = this.f10157b;
        switch (i8) {
            case 0:
                surfaceEdge.lambda$createSurfaceRequest$1();
                break;
            default:
                surfaceEdge.lambda$createSurfaceRequest$0();
                break;
        }
    }
}
