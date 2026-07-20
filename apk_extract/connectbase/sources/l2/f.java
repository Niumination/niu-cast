package l2;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.util.HashMap;
import jq.e0;
import jq.h0;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f9647b = "AnimPlayer.MediaUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f9648c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final String f9650e = "video/hevc";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final f f9646a = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final HashMap<String, Boolean> f9649d = new HashMap<>();

    public final boolean a(@os.l MediaFormat mediaFormat) {
        l0.p(mediaFormat, "videoFormat");
        String string = mediaFormat.getString("mime");
        if (string == null) {
            string = "";
        }
        return h0.T2(string, "hevc", false, 2, null);
    }

    public final synchronized boolean b(@os.l String str) {
        HashMap<String, Boolean> map;
        String lowerCase;
        try {
            l0.p(str, "mimeType");
            if (!f9648c) {
                f9648c = true;
                d();
            }
            map = f9649d;
            lowerCase = str.toLowerCase();
            l0.o(lowerCase, "(this as java.lang.String).toLowerCase()");
        } catch (Throwable th2) {
            throw th2;
        }
        return map.containsKey(lowerCase);
    }

    @os.l
    public final MediaExtractor c(@os.l g2.c cVar) {
        l0.p(cVar, "file");
        MediaExtractor mediaExtractor = new MediaExtractor();
        cVar.c(mediaExtractor);
        return mediaExtractor;
    }

    public final void d() {
        try {
            int codecCount = MediaCodecList.getCodecCount();
            if (codecCount > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
                    if (!codecInfoAt.isEncoder()) {
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        int length = supportedTypes.length - 1;
                        if (length >= 0) {
                            int i12 = 0;
                            while (true) {
                                int i13 = i12 + 1;
                                HashMap<String, Boolean> map = f9649d;
                                String str = supportedTypes[i12];
                                l0.o(str, "types[j]");
                                String lowerCase = str.toLowerCase();
                                l0.o(lowerCase, "(this as java.lang.String).toLowerCase()");
                                map.put(lowerCase, Boolean.TRUE);
                                if (i13 > length) {
                                    break;
                                } else {
                                    i12 = i13;
                                }
                            }
                        }
                    }
                    if (i11 >= codecCount) {
                        break;
                    } else {
                        i10 = i11;
                    }
                }
            }
            a.f9640a.e(f9647b, l0.C("supportType=", f9649d.keySet()));
        } catch (Throwable th2) {
            a.f9640a.b(f9647b, l0.C("getSupportType ", th2));
        }
    }

    public final int e(@os.l MediaExtractor mediaExtractor) {
        l0.p(mediaExtractor, "extractor");
        int trackCount = mediaExtractor.getTrackCount();
        if (trackCount <= 0) {
            return -1;
        }
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i10);
            l0.o(trackFormat, "extractor.getTrackFormat(i)");
            String string = trackFormat.getString("mime");
            if (string == null) {
                string = "";
            }
            if (e0.s2(string, "audio/", false, 2, null)) {
                a.f9640a.e(f9647b, "Extractor selected track " + i10 + " (" + string + "): " + trackFormat);
                return i10;
            }
            if (i11 >= trackCount) {
                return -1;
            }
            i10 = i11;
        }
    }

    public final int f(@os.l MediaExtractor mediaExtractor) {
        l0.p(mediaExtractor, "extractor");
        int trackCount = mediaExtractor.getTrackCount();
        if (trackCount <= 0) {
            return -1;
        }
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i10);
            l0.o(trackFormat, "extractor.getTrackFormat(i)");
            String string = trackFormat.getString("mime");
            if (string == null) {
                string = "";
            }
            if (e0.s2(string, "video/", false, 2, null)) {
                a.f9640a.e(f9647b, "Extractor selected track " + i10 + " (" + string + "): " + trackFormat);
                return i10;
            }
            if (i11 >= trackCount) {
                return -1;
            }
            i10 = i11;
        }
    }
}
