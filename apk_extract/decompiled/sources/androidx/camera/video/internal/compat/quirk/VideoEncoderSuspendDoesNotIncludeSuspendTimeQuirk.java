package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk implements Quirk {
    public static boolean load() {
        "Samsung".equalsIgnoreCase(Build.BRAND);
        return false;
    }
}
