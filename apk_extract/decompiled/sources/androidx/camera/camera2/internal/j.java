package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f896b;

    public /* synthetic */ j(Object obj, int i8) {
        this.f895a = i8;
        this.f896b = obj;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        int i8 = this.f895a;
        Object obj = this.f896b;
        switch (i8) {
            case 0:
                return ((Camera2CapturePipeline.AePreCaptureTask) obj).lambda$preCapture$0(completer);
            case 1:
                return ((Camera2CapturePipeline.ResultListener) obj).lambda$new$0(completer);
            case 2:
                return ((Camera2CapturePipeline.TorchTask) obj).lambda$preCapture$0(completer);
            default:
                return ((FocusMeteringControl) obj).lambda$cancelFocusAndMetering$8(completer);
        }
    }
}
