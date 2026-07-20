package x4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    private u() {
    }

    private static String getDatePartOfDateTimePattern(int i8) {
        if (i8 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i8 == 1) {
            return "MMMM d, yyyy";
        }
        if (i8 == 2) {
            return "MMM d, yyyy";
        }
        if (i8 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Unknown DateFormat style: "));
    }

    private static String getTimePartOfDateTimePattern(int i8) {
        if (i8 == 0 || i8 == 1) {
            return "h:mm:ss a z";
        }
        if (i8 == 2) {
            return "h:mm:ss a";
        }
        if (i8 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Unknown DateFormat style: "));
    }

    public static DateFormat getUsDateTimeFormat(int i8, int i9) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i8) + " " + getTimePartOfDateTimePattern(i9), Locale.US);
    }
}
