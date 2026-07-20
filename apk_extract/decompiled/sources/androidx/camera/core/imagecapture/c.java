package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f967c;

    public /* synthetic */ c(int i8, Object obj, Object obj2) {
        this.f965a = i8;
        this.f966b = obj;
        this.f967c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f965a) {
            case 0:
                ((ProcessingRequest) this.f966b).onProcessFailure((ImageCaptureException) this.f967c);
                break;
            case 1:
                ((ProcessingRequest) this.f966b).onFinalResult((ImageProxy) this.f967c);
                break;
            case 2:
                ((ProcessingRequest) this.f966b).onFinalResult((ImageCapture.OutputFileResults) this.f967c);
                break;
            case 3:
                ((ProcessingNode) this.f966b).lambda$transform$0((ProcessingNode.InputPacket) this.f967c);
                break;
            default:
                ((TakePictureManager) this.f966b).lambda$trackCurrentRequests$1((RequestWithCallback) this.f967c);
                break;
        }
    }
}
