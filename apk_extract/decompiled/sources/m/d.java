package m;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements SessionConfig.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageCapture f7545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ImageCaptureConfig f7547d;
    public final /* synthetic */ StreamSpec e;

    public /* synthetic */ d(ImageCapture imageCapture, String str, ImageCaptureConfig imageCaptureConfig, StreamSpec streamSpec, int i8) {
        this.f7544a = i8;
        this.f7545b = imageCapture;
        this.f7546c = str;
        this.f7547d = imageCaptureConfig;
        this.e = streamSpec;
    }

    @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        switch (this.f7544a) {
            case 0:
                this.f7545b.lambda$createPipeline$1(this.f7546c, this.f7547d, this.e, sessionConfig, sessionError);
                break;
            default:
                this.f7545b.lambda$createPipelineWithNode$9(this.f7546c, this.f7547d, this.e, sessionConfig, sessionError);
                break;
        }
    }
}
