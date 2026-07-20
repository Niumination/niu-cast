package androidx.core.location;

import android.location.Location;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(@os.l Location location) {
        l0.p(location, "<this>");
        return location.getLatitude();
    }

    public static final double component2(@os.l Location location) {
        l0.p(location, "<this>");
        return location.getLongitude();
    }
}
