package x;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.Recorder;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Recorder f10795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f10796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Timebase f10797d;

    public /* synthetic */ b(Recorder recorder, SurfaceRequest surfaceRequest, Timebase timebase, int i8) {
        this.f10794a = i8;
        this.f10795b = recorder;
        this.f10796c = surfaceRequest;
        this.f10797d = timebase;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10794a) {
            case 0:
                this.f10795b.lambda$onSurfaceRequested$0(this.f10796c, this.f10797d);
                break;
            default:
                this.f10795b.lambda$setupVideo$7(this.f10796c, this.f10797d);
                break;
        }
    }
}
