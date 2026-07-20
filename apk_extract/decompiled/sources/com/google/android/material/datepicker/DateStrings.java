package com.google.android.material.datepicker;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class DateStrings {
    private DateStrings() {
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l4, @Nullable Long l8) {
        return getDateRangeString(l4, l8, null);
    }

    public static String getDateString(long j8) {
        return getDateString(j8, null);
    }

    public static String getDayContentDescription(Context context, long j8, boolean z2, boolean z3, boolean z5) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j8);
        if (z2) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), optionalYearMonthDayOfWeekDay);
        }
        if (z3) {
            return String.format(context.getString(R.string.mtrl_picker_start_date_description), optionalYearMonthDayOfWeekDay);
        }
        return z5 ? String.format(context.getString(R.string.mtrl_picker_end_date_description), optionalYearMonthDayOfWeekDay) : optionalYearMonthDayOfWeekDay;
    }

    public static String getMonthDay(long j8) {
        return getMonthDay(j8, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j8) {
        return getMonthDayOfWeekDay(j8, Locale.getDefault());
    }

    public static String getOptionalYearMonthDayOfWeekDay(long j8) {
        return isDateWithinCurrentYear(j8) ? getMonthDayOfWeekDay(j8) : getYearMonthDayOfWeekDay(j8);
    }

    public static String getYearContentDescription(Context context, int i8) {
        return UtcDates.getTodayCalendar().get(1) == i8 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i8)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i8));
    }

    public static String getYearMonth(long j8) {
        return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j8));
    }

    public static String getYearMonthDay(long j8) {
        return getYearMonthDay(j8, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j8) {
        return getYearMonthDayOfWeekDay(j8, Locale.getDefault());
    }

    private static boolean isDateWithinCurrentYear(long j8) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j8);
        return todayCalendar.get(1) == utcCalendar.get(1);
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l4, @Nullable Long l8, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l4 == null && l8 == null) {
            return Pair.create(null, null);
        }
        if (l4 == null) {
            return Pair.create(null, getDateString(l8.longValue(), simpleDateFormat));
        }
        if (l8 == null) {
            return Pair.create(getDateString(l4.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l4.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l8.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l4.longValue())), simpleDateFormat.format(new Date(l8.longValue())));
        }
        if (utcCalendar.get(1) == utcCalendar2.get(1)) {
            return utcCalendar.get(1) == todayCalendar.get(1) ? Pair.create(getMonthDay(l4.longValue(), Locale.getDefault()), getMonthDay(l8.longValue(), Locale.getDefault())) : Pair.create(getMonthDay(l4.longValue(), Locale.getDefault()), getYearMonthDay(l8.longValue(), Locale.getDefault()));
        }
        return Pair.create(getYearMonthDay(l4.longValue(), Locale.getDefault()), getYearMonthDay(l8.longValue(), Locale.getDefault()));
    }

    public static String getDateString(long j8, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j8));
        }
        return isDateWithinCurrentYear(j8) ? getMonthDay(j8) : getYearMonthDay(j8);
    }

    public static String getMonthDay(long j8, Locale locale) {
        return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j8));
    }

    public static String getMonthDayOfWeekDay(long j8, Locale locale) {
        return UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j8));
    }

    public static String getYearMonthDay(long j8, Locale locale) {
        return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j8));
    }

    public static String getYearMonthDayOfWeekDay(long j8, Locale locale) {
        return UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j8));
    }
}
