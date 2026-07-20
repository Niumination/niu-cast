package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.ByteBufferInput f1027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f1028c;

    public /* synthetic */ d(EncoderImpl.ByteBufferInput byteBufferInput, CallbackToFutureAdapter.Completer completer, int i8) {
        this.f1026a = i8;
        this.f1027b = byteBufferInput;
        this.f1028c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1026a) {
            case 0:
                this.f1027b.lambda$acquireBuffer$4(this.f1028c);
                break;
            default:
                this.f1027b.lambda$fetchData$0(this.f1028c);
                break;
        }
    }
}
