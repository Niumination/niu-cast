package m;

import androidx.arch.core.util.Function;
import androidx.camera.core.ImageCapture;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7548a;

    public /* synthetic */ f(int i8) {
        this.f7548a = i8;
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        switch (this.f7548a) {
            case 0:
                return ImageCapture.lambda$submitStillCaptureRequest$10((List) obj);
            default:
                return VideoCapture.Defaults.lambda$static$0((VideoEncoderConfig) obj);
        }
    }
}
