package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class StreamConfigurationMapCompat {
    private final StreamConfigurationMapCompatImpl mImpl;

    public interface StreamConfigurationMapCompatImpl {
        @Nullable
        Size[] getOutputSizes(int i8);

        @Nullable
        <T> Size[] getOutputSizes(@NonNull Class<T> cls);
    }

    private StreamConfigurationMapCompat(@NonNull StreamConfigurationMap streamConfigurationMap) {
        this.mImpl = new StreamConfigurationMapCompatApi23Impl(streamConfigurationMap);
    }

    @NonNull
    private static Size[] concatArrays(@NonNull Size[] sizeArr, @NonNull Size[] sizeArr2) {
        int length = sizeArr.length;
        int length2 = sizeArr2.length;
        Size[] sizeArr3 = new Size[length + length2];
        System.arraycopy(sizeArr, 0, sizeArr3, 0, length);
        System.arraycopy(sizeArr2, 0, sizeArr3, length, length2);
        return sizeArr3;
    }

    @Nullable
    private static Size[] concatNullableArrays(@Nullable Size[] sizeArr, @Nullable Size[] sizeArr2) {
        if (sizeArr == null) {
            return sizeArr2;
        }
        return sizeArr2 == null ? sizeArr : concatArrays(sizeArr, sizeArr2);
    }

    @NonNull
    public static StreamConfigurationMapCompat toStreamConfigurationMapCompat(@NonNull StreamConfigurationMap streamConfigurationMap) {
        return new StreamConfigurationMapCompat(streamConfigurationMap);
    }

    @Nullable
    public Size[] getOutputSizes(int i8) {
        Size[] outputSizes = this.mImpl.getOutputSizes(i8);
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.get(ExtraSupportedOutputSizeQuirk.class);
        return extraSupportedOutputSizeQuirk == null ? outputSizes : concatNullableArrays(outputSizes, extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(i8));
    }

    @Nullable
    public <T> Size[] getOutputSizes(@NonNull Class<T> cls) {
        Size[] outputSizes = this.mImpl.getOutputSizes(cls);
        if (outputSizes == null) {
            return null;
        }
        ExtraSupportedOutputSizeQuirk extraSupportedOutputSizeQuirk = (ExtraSupportedOutputSizeQuirk) DeviceQuirks.get(ExtraSupportedOutputSizeQuirk.class);
        return extraSupportedOutputSizeQuirk == null ? outputSizes : concatNullableArrays(outputSizes, extraSupportedOutputSizeQuirk.getExtraSupportedResolutions(cls));
    }
}
