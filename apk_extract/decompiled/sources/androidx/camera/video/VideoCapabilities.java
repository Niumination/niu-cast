package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProvider;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.VideoQualityQuirk;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class VideoCapabilities {
    private static final String TAG = "VideoCapabilities";
    private final CamcorderProfileProxy mHighestProfile;
    private final CamcorderProfileProxy mLowestProfile;
    private final Map<Quality, CamcorderProfileProxy> mSupportedProfileMap = new LinkedHashMap();
    private final TreeMap<Size, Quality> mAreaSortedSizeToQualityMap = new TreeMap<>(new CompareSizesByArea());

    public VideoCapabilities(@NonNull CameraInfoInternal cameraInfoInternal) {
        CamcorderProfileProvider camcorderProfileProvider = cameraInfoInternal.getCamcorderProfileProvider();
        for (Quality quality : Quality.getSortedQualities()) {
            Preconditions.checkState(quality instanceof Quality.ConstantQuality, "Currently only support ConstantQuality");
            int value = ((Quality.ConstantQuality) quality).getValue();
            if (camcorderProfileProvider.hasProfile(value) && isDeviceValidQuality(cameraInfoInternal, quality)) {
                CamcorderProfileProxy camcorderProfileProxy = (CamcorderProfileProxy) Preconditions.checkNotNull(camcorderProfileProvider.get(value));
                Size size = new Size(camcorderProfileProxy.getVideoFrameWidth(), camcorderProfileProxy.getVideoFrameHeight());
                Logger.d(TAG, "profile = " + camcorderProfileProxy);
                this.mSupportedProfileMap.put(quality, camcorderProfileProxy);
                this.mAreaSortedSizeToQualityMap.put(size, quality);
            }
        }
        if (this.mSupportedProfileMap.isEmpty()) {
            Logger.e(TAG, "No supported CamcorderProfile");
            this.mLowestProfile = null;
            this.mHighestProfile = null;
        } else {
            ArrayDeque arrayDeque = new ArrayDeque(this.mSupportedProfileMap.values());
            this.mHighestProfile = (CamcorderProfileProxy) arrayDeque.peekFirst();
            this.mLowestProfile = (CamcorderProfileProxy) arrayDeque.peekLast();
        }
    }

    private static void checkQualityConstantsOrThrow(@NonNull Quality quality) {
        Preconditions.checkArgument(Quality.containsQuality(quality), "Unknown quality: " + quality);
    }

    @NonNull
    public static VideoCapabilities from(@NonNull CameraInfo cameraInfo) {
        return new VideoCapabilities((CameraInfoInternal) cameraInfo);
    }

    private boolean isDeviceValidQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Quality quality) {
        for (VideoQualityQuirk videoQualityQuirk : DeviceQuirks.getAll(VideoQualityQuirk.class)) {
            if (videoQualityQuirk != null && videoQualityQuirk.isProblematicVideoQuality(cameraInfoInternal, quality) && !videoQualityQuirk.workaroundBySurfaceProcessing()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public CamcorderProfileProxy findHighestSupportedCamcorderProfileFor(@NonNull Size size) {
        Quality qualityFindHighestSupportedQualityFor = findHighestSupportedQualityFor(size);
        Logger.d(TAG, "Using supported quality of " + qualityFindHighestSupportedQualityFor + " for size " + size);
        if (qualityFindHighestSupportedQualityFor == Quality.NONE) {
            return null;
        }
        CamcorderProfileProxy profile = getProfile(qualityFindHighestSupportedQualityFor);
        if (profile != null) {
            return profile;
        }
        throw new AssertionError("Camera advertised available quality but did not produce CamcorderProfile for advertised quality.");
    }

    @NonNull
    public Quality findHighestSupportedQualityFor(@NonNull Size size) {
        Map.Entry<Size, Quality> entryCeilingEntry = this.mAreaSortedSizeToQualityMap.ceilingEntry(size);
        if (entryCeilingEntry != null) {
            return entryCeilingEntry.getValue();
        }
        Map.Entry<Size, Quality> entryFloorEntry = this.mAreaSortedSizeToQualityMap.floorEntry(size);
        return entryFloorEntry != null ? entryFloorEntry.getValue() : Quality.NONE;
    }

    @Nullable
    public CamcorderProfileProxy getProfile(@NonNull Quality quality) {
        checkQualityConstantsOrThrow(quality);
        if (quality == Quality.HIGHEST) {
            return this.mHighestProfile;
        }
        return quality == Quality.LOWEST ? this.mLowestProfile : this.mSupportedProfileMap.get(quality);
    }

    @NonNull
    public List<Quality> getSupportedQualities() {
        return new ArrayList(this.mSupportedProfileMap.keySet());
    }

    public boolean isQualitySupported(@NonNull Quality quality) {
        checkQualityConstantsOrThrow(quality);
        return getProfile(quality) != null;
    }
}
