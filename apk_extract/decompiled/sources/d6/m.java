package d6;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static String a(int i8) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        switch (i8) {
            case CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB /* 10001 */:
                str = "0x1 MediaExtractor exception";
                break;
            case CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR /* 10002 */:
                str = "0x2 MediaCodec exception";
                break;
            case 10003:
                str = "0x3 thread create fail";
                break;
            case 10004:
                str = "0x4 render create fail";
                break;
            case 10005:
                str = "0x5 parse config fail";
                break;
            case 10006:
                str = "0x6 vapx fail";
                break;
            default:
                str = EnvironmentCompat.MEDIA_UNKNOWN;
                break;
        }
        sb2.append(str);
        sb2.append(' ');
        sb2.append("");
        return sb2.toString();
    }
}
