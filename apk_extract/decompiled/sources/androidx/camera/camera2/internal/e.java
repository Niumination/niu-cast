package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CaptureConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f876c;

    public /* synthetic */ e(int i8, Object obj, Object obj2) {
        this.f874a = i8;
        this.f875b = obj;
        this.f876c = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f874a) {
            case 0:
                return ((Camera2CameraImpl) this.f875b).lambda$isUseCaseAttached$10((String) this.f876c, completer);
            default:
                return ((Camera2CapturePipeline.Pipeline) this.f875b).lambda$submitConfigsInternal$4((CaptureConfig.Builder) this.f876c, completer);
        }
    }
}
