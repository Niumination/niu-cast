package androidx.core.database;

import android.database.Cursor;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class CursorKt {
    @m
    public static final byte[] getBlobOrNull(@l Cursor cursor, int i10) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getBlob(i10);
    }

    @m
    public static final Double getDoubleOrNull(@l Cursor cursor, int i10) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i10));
    }

    @m
    public static final Float getFloatOrNull(@l Cursor cursor, int i10) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i10));
    }

    @m
    public static final Integer getIntOrNull(@l Cursor cursor, int i10) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i10));
    }

    @m
    public static final Long getLongOrNull(@l Cursor cursor, int i10) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i10));
    }

    @m
    public static final Short getShortOrNull(@l Cursor cursor, int i10) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i10));
    }

    @m
    public static final String getStringOrNull(@l Cursor cursor, int i10) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getString(i10);
    }
}
