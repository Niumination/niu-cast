package androidx.camera.video;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1011b;

    public /* synthetic */ f(Object obj, int i8) {
        this.f1010a = i8;
        this.f1011b = obj;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        int i8 = this.f1010a;
        Object obj2 = this.f1011b;
        switch (i8) {
            case 0:
                Recorder.RecordingRecord.lambda$initializeRecording$2((MediaStoreOutputOptions) obj2, (Uri) obj);
                break;
            case 1:
                Recorder.RecordingRecord.lambda$initializeRecording$5((ParcelFileDescriptor) obj2, (Uri) obj);
                break;
            default:
                ((VideoEncoderSession) obj2).onSurfaceRequestComplete((SurfaceRequest.Result) obj);
                break;
        }
    }
}
