package z4;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private a() {
    }

    private static boolean checkOffset(String str, int i8, char c9) {
        return i8 < str.length() && str.charAt(i8) == c9;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i8) {
        while (i8 < str.length()) {
            char cCharAt = str.charAt(i8);
            if (cCharAt < '0' || cCharAt > '9') {
                return i8;
            }
            i8++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb2, int i8, int i9) {
        String string = Integer.toString(i8);
        for (int length = i9 - string.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(string);
    }

    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i8;
        int i9;
        int i10;
        int i11;
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i12 = index + 4;
            int i13 = parseInt(str, index, i12);
            if (checkOffset(str, i12, '-')) {
                i12 = index + 5;
            }
            int i14 = i12 + 2;
            int i15 = parseInt(str, i12, i14);
            if (checkOffset(str, i14, '-')) {
                i14 = i12 + 3;
            }
            int i16 = i14 + 2;
            int i17 = parseInt(str, i14, i16);
            boolean zCheckOffset = checkOffset(str, i16, 'T');
            if (!zCheckOffset && str.length() <= i16) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i13, i15 - 1, i17);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i16);
                return gregorianCalendar.getTime();
            }
            if (zCheckOffset) {
                int i18 = i14 + 5;
                int i19 = parseInt(str, i14 + 3, i18);
                if (checkOffset(str, i18, ':')) {
                    i18 = i14 + 6;
                }
                int i20 = i18 + 2;
                int i21 = parseInt(str, i18, i20);
                if (checkOffset(str, i20, ':')) {
                    i20 = i18 + 3;
                }
                if (str.length() <= i20 || (cCharAt = str.charAt(i20)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i9 = i21;
                    i10 = 0;
                    i11 = 0;
                    i16 = i20;
                    i8 = i19;
                } else {
                    int i22 = i20 + 2;
                    i11 = parseInt(str, i20, i22);
                    if (i11 > 59 && i11 < 63) {
                        i11 = 59;
                    }
                    if (checkOffset(str, i22, '.')) {
                        int i23 = i20 + 3;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i20 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i20 + 6);
                        int i24 = parseInt(str, i23, iMin);
                        int i25 = iMin - i23;
                        if (i25 == 1) {
                            i24 *= 100;
                        } else if (i25 == 2) {
                            i24 *= 10;
                        }
                        i8 = i19;
                        i16 = iIndexOfNonDigit;
                        i9 = i21;
                        i10 = i24;
                    } else {
                        i8 = i19;
                        i16 = i22;
                        i9 = i21;
                        i10 = 0;
                    }
                }
            } else {
                i8 = 0;
                i9 = 0;
                i10 = 0;
                i11 = 0;
            }
            if (str.length() <= i16) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i16);
            if (cCharAt2 == 'Z') {
                timeZone = TIMEZONE_UTC;
                length = i16 + 1;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i16);
                if (strSubstring.length() < 5) {
                    strSubstring = strSubstring.concat("00");
                }
                length = i16 + strSubstring.length();
                if (strSubstring.equals("+0000") || strSubstring.equals("+00:00")) {
                    timeZone = TIMEZONE_UTC;
                } else {
                    String strConcat = "GMT".concat(strSubstring);
                    TimeZone timeZone2 = TimeZone.getTimeZone(strConcat);
                    String id2 = timeZone2.getID();
                    if (!id2.equals(strConcat) && !id2.replace(":", "").equals(strConcat)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + strConcat + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, i13);
            gregorianCalendar2.set(2, i15 - 1);
            gregorianCalendar2.set(5, i17);
            gregorianCalendar2.set(11, i8);
            gregorianCalendar2.set(12, i9);
            gregorianCalendar2.set(13, i11);
            gregorianCalendar2.set(14, i10);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + Typography.quote;
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException(h0.a.k("Failed to parse date [", str2, "]: ", message), parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static int parseInt(String str, int i8, int i9) throws NumberFormatException {
        int i10;
        int i11;
        if (i8 < 0 || i9 > str.length() || i8 > i9) {
            throw new NumberFormatException(str);
        }
        if (i8 < i9) {
            i11 = i8 + 1;
            int iDigit = Character.digit(str.charAt(i8), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i8, i9));
            }
            i10 = -iDigit;
        } else {
            i10 = 0;
            i11 = i8;
        }
        while (i11 < i9) {
            int i12 = i11 + 1;
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i8, i9));
            }
            i10 = (i10 * 10) - iDigit2;
            i11 = i12;
        }
        return -i10;
    }

    public static String format(Date date, boolean z2) {
        return format(date, z2, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z2, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb2 = new StringBuilder(19 + (z2 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb2, gregorianCalendar.get(1), 4);
        sb2.append('-');
        padInt(sb2, gregorianCalendar.get(2) + 1, 2);
        sb2.append('-');
        padInt(sb2, gregorianCalendar.get(5), 2);
        sb2.append('T');
        padInt(sb2, gregorianCalendar.get(11), 2);
        sb2.append(':');
        padInt(sb2, gregorianCalendar.get(12), 2);
        sb2.append(':');
        padInt(sb2, gregorianCalendar.get(13), 2);
        if (z2) {
            sb2.append('.');
            padInt(sb2, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i8 = offset / 60000;
            int iAbs = Math.abs(i8 / 60);
            int iAbs2 = Math.abs(i8 % 60);
            sb2.append(offset >= 0 ? '+' : '-');
            padInt(sb2, iAbs, 2);
            sb2.append(':');
            padInt(sb2, iAbs2, 2);
        } else {
            sb2.append('Z');
        }
        return sb2.toString();
    }
}
