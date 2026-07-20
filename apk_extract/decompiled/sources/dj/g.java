package dj;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String a6 = (String) obj;
        String b9 = (String) obj2;
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(b9, "b");
        int iMin = Math.min(a6.length(), b9.length());
        for (int i8 = 4; i8 < iMin; i8++) {
            char cCharAt = a6.charAt(i8);
            char cCharAt2 = b9.charAt(i8);
            if (cCharAt != cCharAt2) {
                if (Intrinsics.compare((int) cCharAt, (int) cCharAt2) >= 0) {
                    return 1;
                }
                return -1;
            }
        }
        int length = a6.length();
        int length2 = b9.length();
        if (length == length2) {
            return 0;
        }
        if (length >= length2) {
            return 1;
        }
        return -1;
    }
}
