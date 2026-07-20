package androidx.camera.camera2.internal;

import androidx.camera.core.impl.utils.futures.AsyncFunction;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements AsyncFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f907b;

    public /* synthetic */ n(Object obj, int i8) {
        this.f906a = i8;
        this.f907b = obj;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
    public final m4.l apply(Object obj) {
        int i8 = this.f906a;
        Object obj2 = this.f907b;
        switch (i8) {
            case 0:
                return ((Camera2CapturePipeline.Pipeline) obj2).lambda$executeCapture$2((Boolean) obj);
            default:
                return ((Camera2CapturePipeline.TorchTask) obj2).lambda$preCapture$2((Void) obj);
        }
    }
}
