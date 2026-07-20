package x;

import androidx.camera.video.AudioSpec;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10801b;

    public /* synthetic */ d(int i8, int i9) {
        this.f10800a = i9;
        this.f10801b = i8;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        int i8 = this.f10800a;
        int i9 = this.f10801b;
        switch (i8) {
            case 0:
                Recorder.Builder.lambda$setTargetVideoEncodingBitRate$1(i9, (VideoSpec.Builder) obj);
                break;
            case 1:
                ((AudioSpec.Builder) obj).setSource(i9);
                break;
            default:
                ((VideoSpec.Builder) obj).setAspectRatio(i9);
                break;
        }
    }
}
