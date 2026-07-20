package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.internal.utils.SizeUtil;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class SurfaceConfig {

    public enum ConfigSize {
        VGA(0),
        PREVIEW(1),
        RECORD(2),
        MAXIMUM(3),
        NOT_SUPPORT(4);

        final int mId;

        ConfigSize(int i8) {
            this.mId = i8;
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        RAW
    }

    @NonNull
    public static SurfaceConfig create(@NonNull ConfigType configType, @NonNull ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize);
    }

    @NonNull
    public static ConfigType getConfigType(int i8) {
        if (i8 == 35) {
            return ConfigType.YUV;
        }
        if (i8 == 256) {
            return ConfigType.JPEG;
        }
        return i8 == 32 ? ConfigType.RAW : ConfigType.PRIV;
    }

    @NonNull
    public static SurfaceConfig transformSurfaceConfig(int i8, @NonNull Size size, @NonNull SurfaceSizeDefinition surfaceSizeDefinition) {
        ConfigSize configSize;
        ConfigType configType = getConfigType(i8);
        ConfigSize configSize2 = ConfigSize.VGA;
        int area = SizeUtil.getArea(size);
        if (area <= SizeUtil.getArea(surfaceSizeDefinition.getAnalysisSize())) {
            configSize = ConfigSize.VGA;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getPreviewSize())) {
            configSize = ConfigSize.PREVIEW;
        } else {
            configSize = area <= SizeUtil.getArea(surfaceSizeDefinition.getRecordSize()) ? ConfigSize.RECORD : ConfigSize.MAXIMUM;
        }
        return create(configType, configSize);
    }

    @NonNull
    public abstract ConfigSize getConfigSize();

    @NonNull
    public abstract ConfigType getConfigType();

    public final boolean isSupported(@NonNull SurfaceConfig surfaceConfig) {
        return surfaceConfig.getConfigSize().getId() <= getConfigSize().getId() && surfaceConfig.getConfigType() == getConfigType();
    }
}
