package j6;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6108b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6107a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f6109c = new HashMap();

    public static void b() {
        try {
            int codecCount = MediaCodecList.getCodecCount();
            HashMap map = f6109c;
            if (codecCount > 0) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i8);
                    if (!codecInfoAt.isEncoder()) {
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        int length = supportedTypes.length - 1;
                        if (length >= 0) {
                            int i10 = 0;
                            while (true) {
                                int i11 = i10 + 1;
                                String str = supportedTypes[i10];
                                Intrinsics.checkNotNullExpressionValue(str, "types[j]");
                                String lowerCase = str.toLowerCase();
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                map.put(lowerCase, Boolean.TRUE);
                                if (i11 > length) {
                                    break;
                                } else {
                                    i10 = i11;
                                }
                            }
                        }
                    }
                    if (i9 >= codecCount) {
                        break;
                    } else {
                        i8 = i9;
                    }
                }
            }
            String msg = Intrinsics.stringPlus("supportType=", map.keySet());
            Intrinsics.checkNotNullParameter("AnimPlayer.MediaUtil", "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
        } catch (Throwable th2) {
            String msg2 = Intrinsics.stringPlus("getSupportType ", th2);
            Intrinsics.checkNotNullParameter("AnimPlayer.MediaUtil", "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    public static int c(MediaExtractor extractor) {
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        int trackCount = extractor.getTrackCount();
        if (trackCount <= 0) {
            return -1;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8 + 1;
            MediaFormat trackFormat = extractor.getTrackFormat(i8);
            Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(i)");
            String string = trackFormat.getString("mime");
            if (string == null) {
                string = "";
            }
            if (StringsKt__StringsJVMKt.startsWith$default(string, "video/", false, 2, null)) {
                String msg = "Extractor selected track " + i8 + " (" + string + "): " + trackFormat;
                Intrinsics.checkNotNullParameter("AnimPlayer.MediaUtil", "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return i8;
            }
            if (i9 >= trackCount) {
                return -1;
            }
            i8 = i9;
        }
    }

    public final synchronized boolean a(String mimeType) {
        HashMap map;
        String lowerCase;
        try {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            if (!f6108b) {
                f6108b = true;
                b();
            }
            map = f6109c;
            lowerCase = mimeType.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        } catch (Throwable th2) {
            throw th2;
        }
        return map.containsKey(lowerCase);
    }
}
