package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1014c;

    public /* synthetic */ i(int i8, Object obj, Object obj2) {
        this.f1012a = i8;
        this.f1013b = obj;
        this.f1014c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1012a) {
            case 0:
                ((Recorder.RecordingRecord) this.f1013b).lambda$updateVideoRecordEvent$6((VideoRecordEvent) this.f1014c);
                break;
            case 1:
                ((VideoCapture.AnonymousClass2) this.f1013b).lambda$onCaptureCompleted$0((SessionConfig.Builder) this.f1014c);
                break;
            default:
                ((VideoEncoderSession) this.f1013b).lambda$configureVideoEncoderInternal$4((Surface) this.f1014c);
                break;
        }
    }
}
