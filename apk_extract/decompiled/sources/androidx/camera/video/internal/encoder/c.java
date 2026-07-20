package androidx.camera.video.internal.encoder;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.ByteBufferInput f1025b;

    public /* synthetic */ c(EncoderImpl.ByteBufferInput byteBufferInput, int i8) {
        this.f1024a = i8;
        this.f1025b = byteBufferInput;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        int i8 = this.f1024a;
        EncoderImpl.ByteBufferInput byteBufferInput = this.f1025b;
        switch (i8) {
            case 0:
                return byteBufferInput.lambda$fetchData$1(completer);
            default:
                return byteBufferInput.lambda$acquireBuffer$5(completer);
        }
    }
}
