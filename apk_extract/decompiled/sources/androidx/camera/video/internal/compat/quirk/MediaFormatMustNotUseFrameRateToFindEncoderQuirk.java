package androidx.camera.video.internal.compat.quirk;

import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaFormatMustNotUseFrameRateToFindEncoderQuirk implements Quirk {
    public static boolean load() {
        return false;
    }
}
