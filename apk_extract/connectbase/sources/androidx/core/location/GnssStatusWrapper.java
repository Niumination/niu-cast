package androidx.core.location;

import android.location.GnssStatus;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static float getCarrierFrequencyHz(GnssStatus gnssStatus, int i10) {
            return gnssStatus.getCarrierFrequencyHz(i10);
        }

        @DoNotInline
        public static boolean hasCarrierFrequencyHz(GnssStatus gnssStatus, int i10) {
            return gnssStatus.hasCarrierFrequencyHz(i10);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static float getBasebandCn0DbHz(GnssStatus gnssStatus, int i10) {
            return gnssStatus.getBasebandCn0DbHz(i10);
        }

        @DoNotInline
        public static boolean hasBasebandCn0DbHz(GnssStatus gnssStatus, int i10) {
            return gnssStatus.hasBasebandCn0DbHz(i10);
        }
    }

    public GnssStatusWrapper(Object obj) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull((GnssStatus) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GnssStatusWrapper) {
            return this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i10) {
        return this.mWrapped.getAzimuthDegrees(i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i10) {
        return Api30Impl.getBasebandCn0DbHz(this.mWrapped, i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i10) {
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i10) {
        return this.mWrapped.getCn0DbHz(i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i10) {
        return this.mWrapped.getConstellationType(i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i10) {
        return this.mWrapped.getElevationDegrees(i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i10) {
        return this.mWrapped.getSvid(i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i10) {
        return this.mWrapped.hasAlmanacData(i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i10) {
        return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i10) {
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, i10);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i10) {
        return this.mWrapped.hasEphemerisData(i10);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i10) {
        return this.mWrapped.usedInFix(i10);
    }
}
