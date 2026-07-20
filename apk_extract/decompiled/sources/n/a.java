package n;

import androidx.camera.core.imagecapture.TakePictureManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TakePictureManager f8116b;

    public /* synthetic */ a(TakePictureManager takePictureManager, int i8) {
        this.f8115a = i8;
        this.f8116b = takePictureManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f8115a;
        TakePictureManager takePictureManager = this.f8116b;
        switch (i8) {
            case 0:
                takePictureManager.lambda$trackCurrentRequests$0();
                break;
            default:
                takePictureManager.issueNextRequest();
                break;
        }
    }
}
