package io.netty.handler.codec;

import io.netty.util.AsciiString;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import ks.a;
import n1.e;
import rs.f;

/* JADX INFO: loaded from: classes3.dex */
public final class DateFormatter {
    private static final String[] CALENDAR_MONTH_TO_SHORT_NAME;
    private static final String[] DAY_OF_WEEK_TO_SHORT_NAME;
    private static final BitSet DELIMITERS;
    private static final FastThreadLocal<DateFormatter> INSTANCES;
    private final GregorianCalendar cal;
    private int dayOfMonth;
    private boolean dayOfMonthFound;
    private int hours;
    private int minutes;
    private int month;
    private boolean monthFound;

    /* JADX INFO: renamed from: sb, reason: collision with root package name */
    private final StringBuilder f8304sb;
    private int seconds;
    private boolean timeFound;
    private int year;
    private boolean yearFound;

    static {
        BitSet bitSet = new BitSet();
        DELIMITERS = bitSet;
        bitSet.set(9);
        for (char c10 = ' '; c10 <= '/'; c10 = (char) (c10 + 1)) {
            DELIMITERS.set(c10);
        }
        for (char c11 = ';'; c11 <= '@'; c11 = (char) (c11 + 1)) {
            DELIMITERS.set(c11);
        }
        for (char c12 = a.f9445d; c12 <= '`'; c12 = (char) (c12 + 1)) {
            DELIMITERS.set(c12);
        }
        for (char c13 = f.f14859a; c13 <= '~'; c13 = (char) (c13 + 1)) {
            DELIMITERS.set(c13);
        }
        DAY_OF_WEEK_TO_SHORT_NAME = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        CALENDAR_MONTH_TO_SHORT_NAME = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        INSTANCES = new FastThreadLocal<DateFormatter>() { // from class: io.netty.handler.codec.DateFormatter.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DateFormatter initialValue() {
                return new DateFormatter();
            }
        };
    }

    public static StringBuilder append(Date date, StringBuilder sb2) {
        return formatter().append0((Date) ObjectUtil.checkNotNull(date, "date"), (StringBuilder) ObjectUtil.checkNotNull(sb2, "sb"));
    }

    private StringBuilder append0(Date date, StringBuilder sb2) {
        this.cal.setTime(date);
        sb2.append(DAY_OF_WEEK_TO_SHORT_NAME[this.cal.get(7) - 1]);
        sb2.append(", ");
        appendZeroLeftPadded(this.cal.get(5), sb2).append(' ');
        sb2.append(CALENDAR_MONTH_TO_SHORT_NAME[this.cal.get(2)]);
        sb2.append(' ');
        sb2.append(this.cal.get(1));
        sb2.append(' ');
        appendZeroLeftPadded(this.cal.get(11), sb2).append(e.f11184d);
        appendZeroLeftPadded(this.cal.get(12), sb2).append(e.f11184d);
        StringBuilder sbAppendZeroLeftPadded = appendZeroLeftPadded(this.cal.get(13), sb2);
        sbAppendZeroLeftPadded.append(" GMT");
        return sbAppendZeroLeftPadded;
    }

    private static StringBuilder appendZeroLeftPadded(int i10, StringBuilder sb2) {
        if (i10 < 10) {
            sb2.append('0');
        }
        sb2.append(i10);
        return sb2;
    }

    private Date computeDate() {
        this.cal.set(5, this.dayOfMonth);
        this.cal.set(2, this.month);
        this.cal.set(1, this.year);
        this.cal.set(11, this.hours);
        this.cal.set(12, this.minutes);
        this.cal.set(13, this.seconds);
        return this.cal.getTime();
    }

    public static String format(Date date) {
        return formatter().format0((Date) ObjectUtil.checkNotNull(date, "date"));
    }

    private String format0(Date date) {
        append0(date, this.f8304sb);
        return this.f8304sb.toString();
    }

    private static DateFormatter formatter() {
        DateFormatter dateFormatter = INSTANCES.get();
        dateFormatter.reset();
        return dateFormatter;
    }

    private static int getNumericalValue(char c10) {
        return c10 - '0';
    }

    private static boolean isDelim(char c10) {
        return DELIMITERS.get(c10);
    }

    private static boolean isDigit(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    private boolean normalizeAndValidate() {
        int i10 = this.dayOfMonth;
        if (i10 < 1 || i10 > 31 || this.hours > 23 || this.minutes > 59 || this.seconds > 59) {
            return false;
        }
        int i11 = this.year;
        if (i11 >= 70 && i11 <= 99) {
            this.year = i11 + 1900;
        } else if (i11 >= 0 && i11 < 70) {
            this.year = i11 + 2000;
        } else if (i11 < 1601) {
            return false;
        }
        return true;
    }

    private Date parse0(CharSequence charSequence, int i10, int i11) {
        if (parse1(charSequence, i10, i11) && normalizeAndValidate()) {
            return computeDate();
        }
        return null;
    }

    private boolean parse1(CharSequence charSequence, int i10, int i11) {
        int i12 = -1;
        while (i10 < i11) {
            if (isDelim(charSequence.charAt(i10))) {
                if (i12 == -1) {
                    continue;
                } else {
                    if (parseToken(charSequence, i12, i10)) {
                        return true;
                    }
                    i12 = -1;
                }
            } else if (i12 == -1) {
                i12 = i10;
            }
            i10++;
        }
        return i12 != -1 && parseToken(charSequence, i12, charSequence.length());
    }

    public static Date parseHttpDate(CharSequence charSequence) {
        return parseHttpDate(charSequence, 0, charSequence.length());
    }

    private boolean parseToken(CharSequence charSequence, int i10, int i11) {
        if (!this.timeFound) {
            boolean zTryParseTime = tryParseTime(charSequence, i10, i11);
            this.timeFound = zTryParseTime;
            if (zTryParseTime) {
                return this.dayOfMonthFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.dayOfMonthFound) {
            boolean zTryParseDayOfMonth = tryParseDayOfMonth(charSequence, i10, i11);
            this.dayOfMonthFound = zTryParseDayOfMonth;
            if (zTryParseDayOfMonth) {
                return this.timeFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.monthFound) {
            boolean zTryParseMonth = tryParseMonth(charSequence, i10, i11);
            this.monthFound = zTryParseMonth;
            if (zTryParseMonth) {
                return this.timeFound && this.dayOfMonthFound && this.yearFound;
            }
        }
        if (!this.yearFound) {
            this.yearFound = tryParseYear(charSequence, i10, i11);
        }
        return this.timeFound && this.dayOfMonthFound && this.monthFound && this.yearFound;
    }

    private boolean tryParseDayOfMonth(CharSequence charSequence, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 1) {
            char cCharAt = charSequence.charAt(i10);
            if (!isDigit(cCharAt)) {
                return false;
            }
            this.dayOfMonth = getNumericalValue(cCharAt);
            return true;
        }
        if (i12 != 2) {
            return false;
        }
        char cCharAt2 = charSequence.charAt(i10);
        char cCharAt3 = charSequence.charAt(i10 + 1);
        if (!isDigit(cCharAt2) || !isDigit(cCharAt3)) {
            return false;
        }
        this.dayOfMonth = (getNumericalValue(cCharAt2) * 10) + getNumericalValue(cCharAt3);
        return true;
    }

    private boolean tryParseMonth(CharSequence charSequence, int i10, int i11) {
        if (i11 - i10 != 3) {
            return false;
        }
        char lowerCase = AsciiString.toLowerCase(charSequence.charAt(i10));
        char lowerCase2 = AsciiString.toLowerCase(charSequence.charAt(i10 + 1));
        char lowerCase3 = AsciiString.toLowerCase(charSequence.charAt(i10 + 2));
        if (lowerCase == 'j' && lowerCase2 == 'a' && lowerCase3 == 'n') {
            this.month = 0;
        } else if (lowerCase == 'f' && lowerCase2 == 'e' && lowerCase3 == 'b') {
            this.month = 1;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'r') {
            this.month = 2;
        } else if (lowerCase == 'a' && lowerCase2 == 'p' && lowerCase3 == 'r') {
            this.month = 3;
        } else if (lowerCase == 'm' && lowerCase2 == 'a' && lowerCase3 == 'y') {
            this.month = 4;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'n') {
            this.month = 5;
        } else if (lowerCase == 'j' && lowerCase2 == 'u' && lowerCase3 == 'l') {
            this.month = 6;
        } else if (lowerCase == 'a' && lowerCase2 == 'u' && lowerCase3 == 'g') {
            this.month = 7;
        } else if (lowerCase == 's' && lowerCase2 == 'e' && lowerCase3 == 'p') {
            this.month = 8;
        } else if (lowerCase == 'o' && lowerCase2 == 'c' && lowerCase3 == 't') {
            this.month = 9;
        } else if (lowerCase == 'n' && lowerCase2 == 'o' && lowerCase3 == 'v') {
            this.month = 10;
        } else {
            if (lowerCase != 'd' || lowerCase2 != 'e' || lowerCase3 != 'c') {
                return false;
            }
            this.month = 11;
        }
        return true;
    }

    private boolean tryParseTime(CharSequence charSequence, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 >= 5 && i12 <= 8) {
            int i13 = -1;
            int i14 = -1;
            int i15 = 0;
            int numericalValue = 0;
            int i16 = 0;
            while (i10 < i11) {
                char cCharAt = charSequence.charAt(i10);
                if (isDigit(cCharAt)) {
                    numericalValue = (numericalValue * 10) + getNumericalValue(cCharAt);
                    i15++;
                    if (i15 > 2) {
                        return false;
                    }
                } else {
                    if (cCharAt != ':' || i15 == 0) {
                        return false;
                    }
                    if (i16 != 0) {
                        if (i16 != 1) {
                            return false;
                        }
                        i14 = numericalValue;
                        numericalValue = i13;
                    }
                    i16++;
                    i15 = 0;
                    i13 = numericalValue;
                    numericalValue = 0;
                }
                i10++;
            }
            int i17 = i15 > 0 ? numericalValue : -1;
            if (i13 >= 0 && i14 >= 0 && i17 >= 0) {
                this.hours = i13;
                this.minutes = i14;
                this.seconds = i17;
                return true;
            }
        }
        return false;
    }

    private boolean tryParseYear(CharSequence charSequence, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 2) {
            char cCharAt = charSequence.charAt(i10);
            char cCharAt2 = charSequence.charAt(i10 + 1);
            if (!isDigit(cCharAt) || !isDigit(cCharAt2)) {
                return false;
            }
            this.year = (getNumericalValue(cCharAt) * 10) + getNumericalValue(cCharAt2);
            return true;
        }
        if (i12 != 4) {
            return false;
        }
        char cCharAt3 = charSequence.charAt(i10);
        char cCharAt4 = charSequence.charAt(i10 + 1);
        char cCharAt5 = charSequence.charAt(i10 + 2);
        char cCharAt6 = charSequence.charAt(i10 + 3);
        if (!isDigit(cCharAt3) || !isDigit(cCharAt4) || !isDigit(cCharAt5) || !isDigit(cCharAt6)) {
            return false;
        }
        this.year = (getNumericalValue(cCharAt5) * 10) + (getNumericalValue(cCharAt4) * 100) + (getNumericalValue(cCharAt3) * 1000) + getNumericalValue(cCharAt6);
        return true;
    }

    public void reset() {
        this.timeFound = false;
        this.hours = -1;
        this.minutes = -1;
        this.seconds = -1;
        this.dayOfMonthFound = false;
        this.dayOfMonth = -1;
        this.monthFound = false;
        this.month = -1;
        this.yearFound = false;
        this.year = -1;
        this.cal.clear();
        this.f8304sb.setLength(0);
    }

    private DateFormatter() {
        this.cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        this.f8304sb = new StringBuilder(29);
        reset();
    }

    public static Date parseHttpDate(CharSequence charSequence, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return null;
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("Can't have end < start");
        }
        if (i12 <= 64) {
            return formatter().parse0((CharSequence) ObjectUtil.checkNotNull(charSequence, "txt"), i10, i11);
        }
        throw new IllegalArgumentException("Can't parse more than 64 chars, looks like a user error or a malformed header");
    }
}
