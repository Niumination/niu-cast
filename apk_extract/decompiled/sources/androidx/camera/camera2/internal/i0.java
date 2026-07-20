package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i0 implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ZoomControl f893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ZoomState f894c;

    public /* synthetic */ i0(ZoomControl zoomControl, ZoomState zoomState, int i8) {
        this.f892a = i8;
        this.f893b = zoomControl;
        this.f894c = zoomState;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f892a) {
            case 0:
                return this.f893b.lambda$setZoomRatio$1(this.f894c, completer);
            default:
                return this.f893b.lambda$setLinearZoom$3(this.f894c, completer);
        }
    }
}
