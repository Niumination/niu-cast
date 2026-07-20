package androidx.camera.video.internal.encoder;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface AudioEncoderInfo extends EncoderInfo {
    @NonNull
    Range<Integer> getBitrateRange();
}
