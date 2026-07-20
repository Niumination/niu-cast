package androidx.camera.camera2.internal;

import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f832d;
    public final /* synthetic */ Object e;

    public /* synthetic */ c(Camera2CameraImpl camera2CameraImpl, Object obj, Object obj2, Object obj3, int i8) {
        this.f829a = i8;
        this.f830b = camera2CameraImpl;
        this.f831c = obj;
        this.f832d = obj2;
        this.e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f829a) {
            case 0:
                this.f830b.lambda$onUseCaseActive$5((String) this.f831c, (SessionConfig) this.f832d, (UseCaseConfig) this.e);
                break;
            case 1:
                this.f830b.lambda$onUseCaseReset$8((String) this.f831c, (SessionConfig) this.f832d, (UseCaseConfig) this.e);
                break;
            case 2:
                this.f830b.lambda$onUseCaseUpdated$7((String) this.f831c, (SessionConfig) this.f832d, (UseCaseConfig) this.e);
                break;
            default:
                ImmediateSurface immediateSurface = (ImmediateSurface) this.f832d;
                a aVar = (a) this.e;
                this.f830b.lambda$configAndClose$1((CaptureSession) this.f831c, immediateSurface, aVar);
                break;
        }
    }
}
