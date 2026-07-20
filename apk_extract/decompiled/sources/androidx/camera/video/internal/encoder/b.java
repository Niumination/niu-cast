package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Observable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1020a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f1021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1023d;

    public /* synthetic */ b(EncoderImpl.ByteBufferInput byteBufferInput, Observable.Observer observer, Executor executor) {
        this.f1022c = byteBufferInput;
        this.f1023d = observer;
        this.f1021b = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1020a) {
            case 0:
                ((EncoderImpl.ByteBufferInput) this.f1022c).lambda$addObserver$7((Observable.Observer) this.f1023d, this.f1021b);
                break;
            default:
                ((EncoderImpl.MediaCodecCallback) this.f1022c).lambda$onOutputBufferAvailable$1(this.f1021b, (EncoderCallback) this.f1023d);
                break;
        }
    }

    public /* synthetic */ b(EncoderImpl.MediaCodecCallback mediaCodecCallback, Executor executor, EncoderCallback encoderCallback) {
        this.f1022c = mediaCodecCallback;
        this.f1021b = executor;
        this.f1023d = encoderCallback;
    }
}
