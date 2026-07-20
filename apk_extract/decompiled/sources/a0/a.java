package a0;

import androidx.camera.video.internal.encoder.BufferCopiedEncodedData;
import androidx.camera.video.internal.encoder.EncodedDataImpl;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4b;

    public /* synthetic */ a(AtomicReference atomicReference, int i8) {
        this.f3a = i8;
        this.f4b = atomicReference;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        int i8 = this.f3a;
        AtomicReference atomicReference = this.f4b;
        switch (i8) {
            case 0:
                return BufferCopiedEncodedData.lambda$new$0(atomicReference, completer);
            case 1:
                return EncodedDataImpl.lambda$new$0(atomicReference, completer);
            case 2:
                return EncoderImpl.lambda$acquireInputBuffer$12(atomicReference, completer);
            default:
                return EncoderImpl.lambda$new$0(atomicReference, completer);
        }
    }
}
