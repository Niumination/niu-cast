package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class CamcorderProfileResolutionQuirk implements ProfileResolutionQuirk {
    private static final String TAG = "CamcorderProfileResolutionQuirk";
    private final List<Size> mSupportedResolutions;

    public CamcorderProfileResolutionQuirk(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Size[] outputSizes;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            outputSizes = StreamConfigurationMapCompat.toStreamConfigurationMapCompat(streamConfigurationMap).getOutputSizes(34);
        } else {
            Logger.e(TAG, "StreamConfigurationMap is null");
            outputSizes = null;
        }
        List<Size> listAsList = outputSizes != null ? Arrays.asList((Size[]) outputSizes.clone()) : Collections.emptyList();
        this.mSupportedResolutions = listAsList;
        Logger.d(TAG, "mSupportedResolutions = " + listAsList);
    }

    public static boolean load(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    @Override // androidx.camera.core.impl.quirk.ProfileResolutionQuirk
    @NonNull
    public List<Size> getSupportedResolutions() {
        return new ArrayList(this.mSupportedResolutions);
    }
}
