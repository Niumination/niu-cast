package a0;

import androidx.camera.video.internal.encoder.EncoderImpl;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f19b;

    public /* synthetic */ f(EncoderImpl encoderImpl, int i8) {
        this.f18a = i8;
        this.f19b = encoderImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f18a;
        EncoderImpl encoderImpl = this.f19b;
        switch (i8) {
            case 0:
                encoderImpl.lambda$stop$2();
                break;
            case 1:
                encoderImpl.lambda$release$6();
                break;
            case 2:
                encoderImpl.lambda$requestKeyFrame$8();
                break;
            case 3:
                encoderImpl.lambda$signalSourceStopped$7();
                break;
            case 4:
                encoderImpl.signalEndOfInputStream();
                break;
            default:
                encoderImpl.lambda$stop$3();
                break;
        }
    }
}
