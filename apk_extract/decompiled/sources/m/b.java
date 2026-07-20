package m;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.impl.VideoCaptureConfig;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements SessionConfig.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StreamSpec f7540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UseCase f7541d;
    public final /* synthetic */ UseCaseConfig e;

    public /* synthetic */ b(UseCase useCase, String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec, int i8) {
        this.f7538a = i8;
        this.f7541d = useCase;
        this.f7539b = str;
        this.e = useCaseConfig;
        this.f7540c = streamSpec;
    }

    @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        switch (this.f7538a) {
            case 0:
                ((ImageAnalysis) this.f7541d).lambda$createPipeline$1(this.f7539b, (ImageAnalysisConfig) this.e, this.f7540c, sessionConfig, sessionError);
                break;
            case 1:
                ((Preview) this.f7541d).lambda$addCameraSurfaceAndErrorListener$1(this.f7539b, (PreviewConfig) this.e, this.f7540c, sessionConfig, sessionError);
                break;
            case 2:
                ((StreamSharing) this.f7541d).lambda$addCameraErrorListener$0(this.f7539b, this.e, this.f7540c, sessionConfig, sessionError);
                break;
            default:
                ((VideoCapture) this.f7541d).lambda$createPipeline$3(this.f7539b, (VideoCaptureConfig) this.e, this.f7540c, sessionConfig, sessionError);
                break;
        }
    }
}
