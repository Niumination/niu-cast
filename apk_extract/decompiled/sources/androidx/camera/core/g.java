package androidx.camera.core;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f958b;

    public /* synthetic */ g(Object obj, int i8) {
        this.f957a = i8;
        this.f958b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f957a;
        Object obj = this.f958b;
        switch (i8) {
            case 0:
                ((ImageAnalysisNonBlockingAnalyzer) obj).analyzeCachedImage();
                break;
            default:
                ((ImageCapture.ImageCaptureRequestProcessor) obj).processNextRequest();
                break;
        }
    }
}
