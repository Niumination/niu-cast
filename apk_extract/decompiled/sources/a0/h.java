package a0;

import androidx.camera.video.internal.encoder.EncoderCallback;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f24a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderCallback f25b;

    public /* synthetic */ h(EncoderCallback encoderCallback, int i8) {
        this.f24a = i8;
        this.f25b = encoderCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f24a;
        EncoderCallback encoderCallback = this.f25b;
        switch (i8) {
            case 0:
                encoderCallback.onEncodeStop();
                break;
            case 1:
                encoderCallback.onEncodeStart();
                break;
            default:
                encoderCallback.onEncodePaused();
                break;
        }
    }
}
