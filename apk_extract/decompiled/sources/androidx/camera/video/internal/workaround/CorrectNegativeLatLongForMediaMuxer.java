package androidx.camera.video.internal.workaround;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.NegativeLatLongSavesIncorrectlyQuirk;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CorrectNegativeLatLongForMediaMuxer {
    private CorrectNegativeLatLongForMediaMuxer() {
    }

    @NonNull
    public static Pair<Double, Double> adjustGeoLocation(double d7, double d10) {
        if (DeviceQuirks.get(NegativeLatLongSavesIncorrectlyQuirk.class) != null) {
            d7 = adjustInternal(d7);
            d10 = adjustInternal(d10);
        }
        return Pair.create(Double.valueOf(d7), Double.valueOf(d10));
    }

    private static double adjustInternal(double d7) {
        return d7 >= 0.0d ? d7 : ((d7 * 10000.0d) - 1.0d) / 10000.0d;
    }
}
