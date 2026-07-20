package i0;

import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5516a;

    public /* synthetic */ a(int i8) {
        this.f5516a = i8;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f5516a) {
            case 0:
                IntentSanitizer.lambda$sanitizeByThrowing$1((String) obj);
                break;
            case 1:
                IntentSanitizer.lambda$sanitizeByFiltering$0((String) obj);
                break;
            default:
                Recorder.lambda$composeRecorderMediaSpec$8((VideoSpec.Builder) obj);
                break;
        }
    }
}
