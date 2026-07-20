package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class QualitySelector {
    private static final String TAG = "QualitySelector";
    private final FallbackStrategy mFallbackStrategy;
    private final List<Quality> mPreferredQualityList;

    public QualitySelector(@NonNull List<Quality> list, @NonNull FallbackStrategy fallbackStrategy) {
        Preconditions.checkArgument((list.isEmpty() && fallbackStrategy == FallbackStrategy.NONE) ? false : true, "No preferred quality and fallback strategy.");
        this.mPreferredQualityList = Collections.unmodifiableList(new ArrayList(list));
        this.mFallbackStrategy = fallbackStrategy;
    }

    private void addByFallbackStrategy(@NonNull List<Quality> list, @NonNull Set<Quality> set) {
        if (list.isEmpty() || set.containsAll(list)) {
            return;
        }
        Logger.d(TAG, "Select quality by fallbackStrategy = " + this.mFallbackStrategy);
        FallbackStrategy fallbackStrategy = this.mFallbackStrategy;
        if (fallbackStrategy == FallbackStrategy.NONE) {
            return;
        }
        Preconditions.checkState(fallbackStrategy instanceof FallbackStrategy.RuleStrategy, "Currently only support type RuleStrategy");
        FallbackStrategy.RuleStrategy ruleStrategy = (FallbackStrategy.RuleStrategy) this.mFallbackStrategy;
        List<Quality> sortedQualities = Quality.getSortedQualities();
        Quality fallbackQuality = ruleStrategy.getFallbackQuality() == Quality.HIGHEST ? sortedQualities.get(0) : ruleStrategy.getFallbackQuality() == Quality.LOWEST ? (Quality) a1.a.j(1, sortedQualities) : ruleStrategy.getFallbackQuality();
        Preconditions.checkState(sortedQualities.indexOf(fallbackQuality) != -1);
        ArrayList arrayList = new ArrayList();
        for (int i8 = r4 - 1; i8 >= 0; i8--) {
            Quality quality = sortedQualities.get(i8);
            if (list.contains(quality)) {
                arrayList.add(quality);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i9 = r4 + 1; i9 < sortedQualities.size(); i9++) {
            Quality quality2 = sortedQualities.get(i9);
            if (list.contains(quality2)) {
                arrayList2.add(quality2);
            }
        }
        Logger.d(TAG, "sizeSortedQualities = " + sortedQualities + ", fallback quality = " + fallbackQuality + ", largerQualities = " + arrayList + ", smallerQualities = " + arrayList2);
        int fallbackRule = ruleStrategy.getFallbackRule();
        if (fallbackRule != 0) {
            if (fallbackRule == 1) {
                set.addAll(arrayList);
                set.addAll(arrayList2);
                return;
            }
            if (fallbackRule == 2) {
                set.addAll(arrayList);
                return;
            }
            if (fallbackRule == 3) {
                set.addAll(arrayList2);
                set.addAll(arrayList);
            } else {
                if (fallbackRule != 4) {
                    throw new AssertionError("Unhandled fallback strategy: " + this.mFallbackStrategy);
                }
                set.addAll(arrayList2);
            }
        }
    }

    private static void checkQualityConstantsOrThrow(@NonNull List<Quality> list) {
        for (Quality quality : list) {
            Preconditions.checkArgument(Quality.containsQuality(quality), "qualities contain invalid quality: " + quality);
        }
    }

    @NonNull
    public static QualitySelector from(@NonNull Quality quality) {
        return from(quality, FallbackStrategy.NONE);
    }

    @NonNull
    public static QualitySelector fromOrderedList(@NonNull List<Quality> list) {
        return fromOrderedList(list, FallbackStrategy.NONE);
    }

    @NonNull
    private static Size getProfileVideoSize(@NonNull CamcorderProfileProxy camcorderProfileProxy) {
        return new Size(camcorderProfileProxy.getVideoFrameWidth(), camcorderProfileProxy.getVideoFrameHeight());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Map<Quality, Size> getQualityToResolutionMap(@NonNull CameraInfo cameraInfo) {
        VideoCapabilities videoCapabilitiesFrom = VideoCapabilities.from(cameraInfo);
        HashMap map = new HashMap();
        for (Quality quality : videoCapabilitiesFrom.getSupportedQualities()) {
            CamcorderProfileProxy profile = videoCapabilitiesFrom.getProfile(quality);
            Objects.requireNonNull(profile);
            map.put(quality, getProfileVideoSize(profile));
        }
        return map;
    }

    @Nullable
    public static Size getResolution(@NonNull CameraInfo cameraInfo, @NonNull Quality quality) {
        checkQualityConstantsOrThrow(quality);
        CamcorderProfileProxy profile = VideoCapabilities.from(cameraInfo).getProfile(quality);
        if (profile != null) {
            return getProfileVideoSize(profile);
        }
        return null;
    }

    @NonNull
    public static List<Quality> getSupportedQualities(@NonNull CameraInfo cameraInfo) {
        return VideoCapabilities.from(cameraInfo).getSupportedQualities();
    }

    public static boolean isQualitySupported(@NonNull CameraInfo cameraInfo, @NonNull Quality quality) {
        return VideoCapabilities.from(cameraInfo).isQualitySupported(quality);
    }

    @NonNull
    public List<Quality> getPrioritizedQualities(@NonNull CameraInfo cameraInfo) {
        List<Quality> supportedQualities = VideoCapabilities.from(cameraInfo).getSupportedQualities();
        if (supportedQualities.isEmpty()) {
            Logger.w(TAG, "No supported quality on the device.");
            return new ArrayList();
        }
        Logger.d(TAG, "supportedQualities = " + supportedQualities);
        Set<Quality> linkedHashSet = new LinkedHashSet<>();
        for (Quality quality : this.mPreferredQualityList) {
            if (quality == Quality.HIGHEST) {
                linkedHashSet.addAll(supportedQualities);
                break;
            }
            if (quality == Quality.LOWEST) {
                ArrayList arrayList = new ArrayList(supportedQualities);
                Collections.reverse(arrayList);
                linkedHashSet.addAll(arrayList);
                break;
            }
            if (supportedQualities.contains(quality)) {
                linkedHashSet.add(quality);
            } else {
                Logger.w(TAG, "quality is not supported and will be ignored: " + quality);
            }
        }
        addByFallbackStrategy(supportedQualities, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    @NonNull
    public String toString() {
        return "QualitySelector{preferredQualities=" + this.mPreferredQualityList + ", fallbackStrategy=" + this.mFallbackStrategy + "}";
    }

    @NonNull
    public static QualitySelector from(@NonNull Quality quality, @NonNull FallbackStrategy fallbackStrategy) {
        Preconditions.checkNotNull(quality, "quality cannot be null");
        Preconditions.checkNotNull(fallbackStrategy, "fallbackStrategy cannot be null");
        checkQualityConstantsOrThrow(quality);
        return new QualitySelector(Collections.singletonList(quality), fallbackStrategy);
    }

    @NonNull
    public static QualitySelector fromOrderedList(@NonNull List<Quality> list, @NonNull FallbackStrategy fallbackStrategy) {
        Preconditions.checkNotNull(list, "qualities cannot be null");
        Preconditions.checkNotNull(fallbackStrategy, "fallbackStrategy cannot be null");
        Preconditions.checkArgument(!list.isEmpty(), "qualities cannot be empty");
        checkQualityConstantsOrThrow(list);
        return new QualitySelector(list, fallbackStrategy);
    }

    private static void checkQualityConstantsOrThrow(@NonNull Quality quality) {
        Preconditions.checkArgument(Quality.containsQuality(quality), "Invalid quality: " + quality);
    }
}
