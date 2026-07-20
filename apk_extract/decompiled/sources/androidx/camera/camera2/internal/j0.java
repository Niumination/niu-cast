package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f900d;

    public /* synthetic */ j0(Object obj, CallbackToFutureAdapter.Completer completer, Object obj2, int i8) {
        this.f897a = i8;
        this.f898b = obj;
        this.f899c = completer;
        this.f900d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f897a) {
            case 0:
                ((ZoomControl) this.f898b).lambda$setZoomRatio$0(this.f899c, (ZoomState) this.f900d);
                break;
            case 1:
                ((ZoomControl) this.f898b).lambda$setLinearZoom$2(this.f899c, (ZoomState) this.f900d);
                break;
            default:
                ((Camera2CameraImpl) this.f898b).lambda$isUseCaseAttached$9(this.f899c, (String) this.f900d);
                break;
        }
    }
}
