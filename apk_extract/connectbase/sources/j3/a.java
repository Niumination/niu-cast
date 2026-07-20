package j3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import dn.c;
import el.b0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import jq.h0;
import kn.l0;
import kn.r1;
import lm.l2;
import lm.o1;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUtils.kt\ncom/transsion/airtransfer/filetransfer/utils/FileUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f8552a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f8553b = "FileUtils";

    @l
    public final o1<String, Long, String> a(@l Context context, @l Uri uri) throws IllegalAccessException, IOException, InvocationTargetException {
        Long lValueOf;
        String string;
        l0.p(context, "context");
        l0.p(uri, "uri");
        b bVar = b.f8554a;
        bVar.e(f8553b, "getFileInfo uri : " + uri);
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        String strC = null;
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    Integer numValueOf = Integer.valueOf(cursor2.getColumnIndex("_display_name"));
                    if (numValueOf.intValue() <= -1) {
                        numValueOf = null;
                    }
                    string = numValueOf != null ? cursor2.getString(numValueOf.intValue()) : null;
                    bVar.e(f8553b, "fileName :" + string);
                    Integer numValueOf2 = Integer.valueOf(cursor2.getColumnIndex("_size"));
                    if (numValueOf2.intValue() <= -1) {
                        numValueOf2 = null;
                    }
                    lValueOf = numValueOf2 != null ? Long.valueOf(cursor2.getLong(numValueOf2.intValue())) : null;
                } else {
                    lValueOf = null;
                    string = null;
                }
                l2 l2Var = l2.f10208a;
                c.a(cursor, null);
                strC = string;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    c.a(cursor, th2);
                    throw th3;
                }
            }
        } else {
            lValueOf = null;
        }
        String strF = f(context, uri);
        if (strC == null) {
            strC = c(uri);
        }
        if (lValueOf == null) {
            lValueOf = Long.valueOf(e(context, uri));
        }
        return new o1<>(strC, lValueOf, strF);
    }

    @m
    public final String b(@l Context context, @l Uri uri) throws IllegalAccessException, IOException, InvocationTargetException {
        String string;
        l0.p(context, "context");
        l0.p(uri, "uri");
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        String str = null;
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    Integer numValueOf = Integer.valueOf(cursor2.getColumnIndex("_display_name"));
                    if (numValueOf.intValue() <= -1) {
                        numValueOf = null;
                    }
                    string = numValueOf != null ? cursor2.getString(numValueOf.intValue()) : null;
                    b.f8554a.e(f8553b, "fileName :" + string);
                } else {
                    string = null;
                }
                l2 l2Var = l2.f10208a;
                c.a(cursor, null);
                str = string;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    c.a(cursor, th2);
                    throw th3;
                }
            }
        }
        return str == null ? c(uri) : str;
    }

    public final String c(Uri uri) {
        String path = uri.getPath();
        if (path != null) {
            return h0.q5(path, b0.f4502a, null, 2, null);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0049  */
    @m
    public final Long d(@l Context context, @l Uri uri) throws IllegalAccessException, IOException, InvocationTargetException {
        Long lValueOf;
        l0.p(context, "context");
        l0.p(uri, "uri");
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        Long l10 = null;
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    Integer numValueOf = Integer.valueOf(cursor2.getColumnIndex("_size"));
                    if (numValueOf.intValue() <= -1) {
                        numValueOf = null;
                    }
                    if (numValueOf != null) {
                        lValueOf = Long.valueOf(cursor2.getLong(numValueOf.intValue()));
                    } else {
                        lValueOf = null;
                    }
                } else {
                    lValueOf = null;
                }
                l2 l2Var = l2.f10208a;
                c.a(cursor, null);
                l10 = lValueOf;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    c.a(cursor, th2);
                    throw th3;
                }
            }
        }
        return l10 == null ? Long.valueOf(e(context, uri)) : l10;
    }

    public final long e(Context context, Uri uri) throws IllegalAccessException, IOException, InvocationTargetException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            return 0L;
        }
        try {
            b.f8554a.e(f8553b, "getFileSizeFromFileDescriptor fileSize : " + parcelFileDescriptorOpenFileDescriptor.getStatSize());
            long statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
            c.a(parcelFileDescriptorOpenFileDescriptor, null);
            return statSize;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                c.a(parcelFileDescriptorOpenFileDescriptor, th2);
                throw th3;
            }
        }
    }

    @m
    public final String f(@l Context context, @l Uri uri) {
        l0.p(context, "context");
        l0.p(uri, "uri");
        return context.getContentResolver().getType(uri);
    }
}
