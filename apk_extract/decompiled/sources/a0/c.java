package a0;

import androidx.camera.video.internal.encoder.EncoderImpl;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f10b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f11c;

    public /* synthetic */ c(EncoderImpl encoderImpl, long j8, int i8) {
        this.f9a = i8;
        this.f10b = encoderImpl;
        this.f11c = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9a) {
            case 0:
                this.f10b.lambda$start$1(this.f11c);
                break;
            default:
                this.f10b.lambda$pause$5(this.f11c);
                break;
        }
    }
}
