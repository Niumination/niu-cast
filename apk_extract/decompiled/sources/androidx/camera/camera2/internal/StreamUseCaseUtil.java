package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class StreamUseCaseUtil {
    private static Map<Class<?>, Long> sUseCaseToStreamUseCaseMapping;

    private StreamUseCaseUtil() {
    }

    @RequiresApi(api = 33)
    private static Map<Class<?>, Long> getUseCaseToStreamUseCaseMapping() {
        if (sUseCaseToStreamUseCaseMapping == null) {
            HashMap map = new HashMap();
            sUseCaseToStreamUseCaseMapping = map;
            map.put(ImageAnalysis.class, 1L);
            sUseCaseToStreamUseCaseMapping.put(Preview.class, 1L);
            sUseCaseToStreamUseCaseMapping.put(ImageCapture.class, 2L);
            sUseCaseToStreamUseCaseMapping.put(MediaCodec.class, 3L);
        }
        return sUseCaseToStreamUseCaseMapping;
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static void populateSurfaceToStreamUseCaseMapping(@NonNull Collection<SessionConfig> collection, @NonNull Map<DeferrableSurface, Long> map, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, boolean z2) {
        CameraCharacteristics.Key key = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        if (cameraCharacteristicsCompat.get(key) == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (long j8 : (long[]) cameraCharacteristicsCompat.get(key)) {
            hashSet.add(Long.valueOf(j8));
        }
        for (SessionConfig sessionConfig : collection) {
            if (sessionConfig.getTemplateType() == 5) {
                map.clear();
                return;
            }
            for (DeferrableSurface deferrableSurface : sessionConfig.getSurfaces()) {
                Config implementationOptions = sessionConfig.getImplementationOptions();
                Config.Option<Long> option = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
                if (!implementationOptions.containsOption(option) || !putStreamUseCaseToMappingIfAvailable(map, deferrableSurface, (Long) sessionConfig.getImplementationOptions().retrieveOption(option), hashSet)) {
                    if (z2) {
                        putStreamUseCaseToMappingIfAvailable(map, deferrableSurface, getUseCaseToStreamUseCaseMapping().get(deferrableSurface.getContainerClass()), hashSet);
                    }
                }
            }
        }
    }

    private static boolean putStreamUseCaseToMappingIfAvailable(Map<DeferrableSurface, Long> map, DeferrableSurface deferrableSurface, @Nullable Long l4, Set<Long> set) {
        if (l4 == null || !set.contains(l4)) {
            return false;
        }
        map.put(deferrableSurface, l4);
        return true;
    }
}
