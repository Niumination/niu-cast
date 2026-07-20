package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import j.c;
import n1.e;
import wj.h2;
import y5.a;

/* JADX INFO: loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb2 = new StringBuilder(64);
                sb2.append(scheme);
                sb2.append(e.f11184d);
                if (schemeSpecificPart != null) {
                    for (int i10 = 0; i10 < schemeSpecificPart.length(); i10++) {
                        char cCharAt = schemeSpecificPart.charAt(i10);
                        if (cCharAt == '-' || cCharAt == '@' || cCharAt == '.') {
                            sb2.append(cCharAt);
                        } else {
                            sb2.append(a.N);
                        }
                    }
                }
                return sb2.toString();
            }
            if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase(h2.f18719h) || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                StringBuilder sb3 = new StringBuilder("//");
                sb3.append(uri.getHost() != null ? uri.getHost() : "");
                schemeSpecificPart = c.a(sb3, uri.getPort() != -1 ? ":" + uri.getPort() : "", "/...");
            }
        }
        StringBuilder sb4 = new StringBuilder(64);
        if (scheme != null) {
            sb4.append(scheme);
            sb4.append(e.f11184d);
        }
        if (schemeSpecificPart != null) {
            sb4.append(schemeSpecificPart);
        }
        return sb4.toString();
    }
}
