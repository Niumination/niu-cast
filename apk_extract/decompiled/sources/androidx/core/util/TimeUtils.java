package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Object sFormatSync = new Object();
    private static char[] sFormatStr = new char[24];

    private TimeUtils() {
    }

    private static int accumField(int i8, int i9, boolean z2, int i10) {
        if (i8 > 99 || (z2 && i10 >= 3)) {
            return i9 + 3;
        }
        if (i8 > 9 || (z2 && i10 >= 2)) {
            return i9 + 2;
        }
        if (z2 || i8 > 0) {
            return i9 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j8, StringBuilder sb2) {
        synchronized (sFormatSync) {
            sb2.append(sFormatStr, 0, formatDurationLocked(j8, 0));
        }
    }

    private static int formatDurationLocked(long j8, int i8) {
        char c9;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        long j10 = j8;
        if (sFormatStr.length < i8) {
            sFormatStr = new char[i8];
        }
        char[] cArr = sFormatStr;
        if (j10 == 0) {
            int i14 = i8 - 1;
            while (i14 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j10 > 0) {
            c9 = '+';
        } else {
            j10 = -j10;
            c9 = '-';
        }
        int i15 = (int) (j10 % 1000);
        int iFloor = (int) Math.floor(j10 / 1000);
        if (iFloor > SECONDS_PER_DAY) {
            i9 = iFloor / SECONDS_PER_DAY;
            iFloor -= SECONDS_PER_DAY * i9;
        } else {
            i9 = 0;
        }
        if (iFloor > SECONDS_PER_HOUR) {
            i10 = iFloor / SECONDS_PER_HOUR;
            iFloor -= i10 * SECONDS_PER_HOUR;
        } else {
            i10 = 0;
        }
        if (iFloor > SECONDS_PER_MINUTE) {
            int i16 = iFloor / SECONDS_PER_MINUTE;
            i11 = iFloor - (i16 * SECONDS_PER_MINUTE);
            i12 = i16;
        } else {
            i11 = iFloor;
            i12 = 0;
        }
        if (i8 != 0) {
            int iAccumField = accumField(i9, 1, false, 0);
            int iAccumField2 = iAccumField + accumField(i10, 1, iAccumField > 0, 2);
            int iAccumField3 = iAccumField2 + accumField(i12, 1, iAccumField2 > 0, 2);
            int iAccumField4 = iAccumField3 + accumField(i11, 1, iAccumField3 > 0, 2);
            i13 = 0;
            for (int iAccumField5 = accumField(i15, 2, true, iAccumField4 > 0 ? 3 : 0) + 1 + iAccumField4; iAccumField5 < i8; iAccumField5++) {
                cArr[i13] = ' ';
                i13++;
            }
        } else {
            i13 = 0;
        }
        cArr[i13] = c9;
        int i17 = i13 + 1;
        boolean z2 = i8 != 0;
        int iPrintField = printField(cArr, i9, 'd', i17, false, 0);
        int iPrintField2 = printField(cArr, i10, 'h', iPrintField, iPrintField != i17, z2 ? 2 : 0);
        int iPrintField3 = printField(cArr, i12, 'm', iPrintField2, iPrintField2 != i17, z2 ? 2 : 0);
        int iPrintField4 = printField(cArr, i11, 's', iPrintField3, iPrintField3 != i17, z2 ? 2 : 0);
        int iPrintField5 = printField(cArr, i15, 'm', iPrintField4, true, (!z2 || iPrintField4 == i17) ? 0 : 3);
        cArr[iPrintField5] = 's';
        return iPrintField5 + 1;
    }

    private static int printField(char[] cArr, int i8, char c9, int i9, boolean z2, int i10) {
        int i11;
        if (!z2 && i8 <= 0) {
            return i9;
        }
        if ((!z2 || i10 < 3) && i8 <= 99) {
            i11 = i9;
        } else {
            int i12 = i8 / 100;
            cArr[i9] = (char) (i12 + 48);
            i11 = i9 + 1;
            i8 -= i12 * 100;
        }
        if ((z2 && i10 >= 2) || i8 > 9 || i9 != i11) {
            int i13 = i8 / 10;
            cArr[i11] = (char) (i13 + 48);
            i11++;
            i8 -= i13 * 10;
        }
        cArr[i11] = (char) (i8 + 48);
        cArr[i11 + 1] = c9;
        return i11 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j8, PrintWriter printWriter, int i8) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j8, i8)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j8, PrintWriter printWriter) {
        formatDuration(j8, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j8, long j10, PrintWriter printWriter) {
        if (j8 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j8 - j10, printWriter, 0);
        }
    }
}
