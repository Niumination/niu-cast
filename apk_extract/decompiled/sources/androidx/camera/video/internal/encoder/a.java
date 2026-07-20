package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.BufferProvider;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1019c;

    public /* synthetic */ a(int i8, Object obj, Object obj2) {
        this.f1017a = i8;
        this.f1018b = obj;
        this.f1019c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1017a) {
            case 0:
                ((EncoderImpl) this.f1018b).lambda$matchAcquisitionsAndFreeBufferIndexes$14((InputBufferImpl) this.f1019c);
                break;
            case 1:
                EncoderImpl.ByteBufferInput.lambda$setActive$9((Map.Entry) this.f1018b, (BufferProvider.State) this.f1019c);
                break;
            case 2:
                ((Observable.Observer) this.f1018b).onNewData((BufferProvider.State) this.f1019c);
                break;
            case 3:
                ((EncoderImpl.ByteBufferInput) this.f1018b).lambda$removeObserver$8((Observable.Observer) this.f1019c);
                break;
            case 4:
                ((EncoderImpl.MediaCodecCallback) this.f1018b).lambda$onOutputFormatChanged$7((MediaFormat) this.f1019c);
                break;
            case 5:
                ((EncoderCallback) this.f1018b).onEncodedData((EncodedDataImpl) this.f1019c);
                break;
            case 6:
                EncoderImpl.MediaCodecCallback.lambda$onOutputFormatChanged$6((EncoderCallback) this.f1018b, (MediaFormat) this.f1019c);
                break;
            case 7:
                ((EncoderImpl.MediaCodecCallback) this.f1018b).lambda$onError$4((MediaCodec.CodecException) this.f1019c);
                break;
            default:
                ((Encoder.SurfaceInput.OnSurfaceUpdateListener) this.f1018b).onSurfaceUpdate((Surface) this.f1019c);
                break;
        }
    }
}
