package fh;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    String a(String str);

    long b(ContentResolver contentResolver, long j10, String str);

    int c(ContentResolver contentResolver, String str, ContentValues contentValues, String str2, String[] strArr);

    long d(ContentResolver contentResolver, String str);

    int e(ContentResolver contentResolver, long j10, String str, ContentValues contentValues, String str2, String[] strArr);

    String f(String str);

    Uri g(ContentResolver contentResolver, String str, ContentValues contentValues);

    boolean h(Context context);

    Cursor i(ContentResolver contentResolver, String str, String[] strArr, String str2, String[] strArr2, String str3);

    Uri j(ContentResolver contentResolver, String str, long j10, long j11);

    Uri k(ContentResolver contentResolver, long j10, String str, long j11);

    Uri l(ContentResolver contentResolver, long j10, String str, long j11, long j12);

    Cursor m(ContentResolver contentResolver, long j10, String str, String[] strArr, String str2, String[] strArr2, String str3);

    Uri n(ContentResolver contentResolver, String str, long j10);

    Uri o(ContentResolver contentResolver, String str, ContentValues contentValues);

    Uri p(ContentResolver contentResolver, long j10, String str, ContentValues contentValues);

    Uri q(ContentResolver contentResolver, long j10, String str, ContentValues contentValues);
}
