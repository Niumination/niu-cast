package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.video.internal.BufferProvider;
import java.util.concurrent.Executor;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface Encoder {
    public static final long NO_TIMESTAMP = -1;

    public interface ByteBufferInput extends EncoderInput, BufferProvider<InputBuffer> {
    }

    public interface EncoderInput {
    }

    public interface SurfaceInput extends EncoderInput {

        public interface OnSurfaceUpdateListener {
            void onSurfaceUpdate(@NonNull Surface surface);
        }

        void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull OnSurfaceUpdateListener onSurfaceUpdateListener);
    }

    int getConfiguredBitrate();

    @NonNull
    EncoderInfo getEncoderInfo();

    @NonNull
    EncoderInput getInput();

    @NonNull
    l getReleasedFuture();

    void pause();

    void release();

    void requestKeyFrame();

    void setEncoderCallback(@NonNull EncoderCallback encoderCallback, @NonNull Executor executor);

    void start();

    void stop();

    void stop(long j8);
}
