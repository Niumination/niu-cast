package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface InputBuffer {
    boolean cancel();

    @NonNull
    ByteBuffer getByteBuffer();

    @NonNull
    l getTerminationFuture();

    void setEndOfStream(boolean z2);

    void setPresentationTimeUs(long j8);

    boolean submit();
}
