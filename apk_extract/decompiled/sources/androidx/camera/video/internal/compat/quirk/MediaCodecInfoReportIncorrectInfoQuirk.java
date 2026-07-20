package androidx.camera.video.internal.compat.quirk;

import android.media.MediaFormat;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaCodecInfoReportIncorrectInfoQuirk implements Quirk {
    private static boolean isHuaweiMate9() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isLGK430() {
        return "lge".equalsIgnoreCase(Build.BRAND) && "lg-k430".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isMotoC() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isNokia1() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isPositivoTwist2Pro() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isRedmiNote4() {
        return "Xiaomi".equalsIgnoreCase(Build.BRAND) && "redmi note 4".equalsIgnoreCase(Build.MODEL);
    }

    private boolean isVideoFormat(@NonNull MediaFormat mediaFormat) {
        return mediaFormat.getString("mime").contains("video/");
    }

    private static boolean isX230() {
        return "LGE".equalsIgnoreCase(Build.BRAND) && "LG-X230".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isX650() {
        return "infinix".equalsIgnoreCase(Build.BRAND) && "infinix x650".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isNokia1() || isMotoC() || isX650() || isX230() || isHuaweiMate9() || isPositivoTwist2Pro() || isRedmiNote4() || isLGK430();
    }

    public boolean isUnSupportMediaCodecInfo(@NonNull MediaFormat mediaFormat) {
        if (isNokia1() || isMotoC() || isX650() || isX230() || isPositivoTwist2Pro()) {
            return "video/mp4v-es".equals(mediaFormat.getString("mime"));
        }
        if (isHuaweiMate9() && isVideoFormat(mediaFormat)) {
            return mediaFormat.getInteger("width") == 3840 && mediaFormat.getInteger("height") == 2160;
        }
        if ((isRedmiNote4() || isLGK430()) && "video/avc".equals(mediaFormat.getString("mime"))) {
            return mediaFormat.getInteger("width") == 1920 && mediaFormat.getInteger("height") == 1080;
        }
        return false;
    }
}
