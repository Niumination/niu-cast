package d6;

import android.media.MediaCodec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends Lambda implements Function0 {
    public static final s INSTANCE = new s();

    public s() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final MediaCodec.BufferInfo invoke() {
        return new MediaCodec.BufferInfo();
    }
}
