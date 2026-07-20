package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface EncodedData extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    @NonNull
    MediaCodec.BufferInfo getBufferInfo();

    @NonNull
    ByteBuffer getByteBuffer();

    @NonNull
    l getClosedFuture();

    long getPresentationTimeUs();

    boolean isKeyFrame();

    long size();
}
