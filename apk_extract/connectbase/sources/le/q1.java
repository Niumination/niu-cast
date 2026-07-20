package le;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.transsion.hubsdk.trancare.trancare.TranTrancareProvider;

/* JADX INFO: loaded from: classes2.dex */
public class q1 implements fh.c {
    public static /* synthetic */ Object K(ContentResolver contentResolver, long j10, String str) throws RemoteException {
        return Long.valueOf(TranTrancareProvider.getLastDataTime(contentResolver, j10, str));
    }

    public static /* synthetic */ Object L(ContentResolver contentResolver, String str) throws RemoteException {
        return Long.valueOf(TranTrancareProvider.getLastDataTime(contentResolver, str));
    }

    public static /* synthetic */ Object U(Context context) throws RemoteException {
        return Boolean.valueOf(TranTrancareProvider.isKeyGuardUnlocked(context));
    }

    public static /* synthetic */ Object X(ContentResolver contentResolver, long j10, String str, ContentValues contentValues, String str2, String[] strArr) throws RemoteException {
        return Integer.valueOf(TranTrancareProvider.update(contentResolver, j10, str, contentValues, str2, strArr));
    }

    public static /* synthetic */ Object Y(ContentResolver contentResolver, String str, ContentValues contentValues, String str2, String[] strArr) throws RemoteException {
        return Integer.valueOf(TranTrancareProvider.update(contentResolver, str, contentValues, str2, strArr));
    }

    @Override // fh.c
    public String a(final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.j1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.encryptionString(str);
            }
        }, "trancare");
    }

    @Override // fh.c
    public long b(final ContentResolver contentResolver, final long j10, final String str) {
        return ((Long) new zb.f().c(new zb.f.b() { // from class: le.o1
            @Override // zb.f.b
            public final Object run() {
                return q1.K(contentResolver, j10, str);
            }
        }, "trancare")).longValue();
    }

    @Override // fh.c
    public int c(final ContentResolver contentResolver, final String str, final ContentValues contentValues, final String str2, final String[] strArr) {
        return ((Integer) new zb.f().c(new zb.f.b() { // from class: le.p1
            @Override // zb.f.b
            public final Object run() {
                return q1.Y(contentResolver, str, contentValues, str2, strArr);
            }
        }, "trancare")).intValue();
    }

    @Override // fh.c
    public long d(final ContentResolver contentResolver, final String str) {
        return ((Long) new zb.f().c(new zb.f.b() { // from class: le.c1
            @Override // zb.f.b
            public final Object run() {
                return q1.L(contentResolver, str);
            }
        }, "trancare")).longValue();
    }

    @Override // fh.c
    public int e(final ContentResolver contentResolver, final long j10, final String str, final ContentValues contentValues, final String str2, final String[] strArr) {
        return ((Integer) new zb.f().c(new zb.f.b() { // from class: le.h1
            @Override // zb.f.b
            public final Object run() {
                return q1.X(contentResolver, j10, str, contentValues, str2, strArr);
            }
        }, "trancare")).intValue();
    }

    @Override // fh.c
    public String f(final String str) {
        return (String) new zb.f().c(new zb.f.b() { // from class: le.n1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.deEncryptionString(str);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri g(final ContentResolver contentResolver, final String str, final ContentValues contentValues) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.m1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.insert(contentResolver, str, contentValues);
            }
        }, "trancare");
    }

    @Override // fh.c
    public boolean h(final Context context) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: le.g1
            @Override // zb.f.b
            public final Object run() {
                return q1.U(context);
            }
        }, "trancare")).booleanValue();
    }

    @Override // fh.c
    public Cursor i(final ContentResolver contentResolver, final String str, final String[] strArr, final String str2, final String[] strArr2, final String str3) {
        return (Cursor) new zb.f().c(new zb.f.b() { // from class: le.l1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.query(contentResolver, str, strArr, str2, strArr2, str3);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri j(final ContentResolver contentResolver, final String str, final long j10, final long j11) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.f1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.initDataSheet(contentResolver, str, j10, j11);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri k(final ContentResolver contentResolver, final long j10, final String str, final long j11) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.e1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.initDataSheet(contentResolver, j10, str, j11);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri l(final ContentResolver contentResolver, final long j10, final String str, final long j11, final long j12) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.k1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.initDataSheet(contentResolver, j10, str, j11, j12);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Cursor m(final ContentResolver contentResolver, final long j10, final String str, final String[] strArr, final String str2, final String[] strArr2, final String str3) {
        return (Cursor) new zb.f().c(new zb.f.b() { // from class: le.a1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.query(contentResolver, j10, str, strArr, str2, strArr2, str3);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri n(final ContentResolver contentResolver, final String str, final long j10) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.i1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.initDataSheet(contentResolver, str, j10);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri o(final ContentResolver contentResolver, final String str, final ContentValues contentValues) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.z0
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.insertCache(contentResolver, str, contentValues);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri p(final ContentResolver contentResolver, final long j10, final String str, final ContentValues contentValues) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.b1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.insertCache(contentResolver, j10, str, contentValues);
            }
        }, "trancare");
    }

    @Override // fh.c
    public Uri q(final ContentResolver contentResolver, final long j10, final String str, final ContentValues contentValues) {
        return (Uri) new zb.f().c(new zb.f.b() { // from class: le.d1
            @Override // zb.f.b
            public final Object run() {
                return TranTrancareProvider.insert(contentResolver, j10, str, contentValues);
            }
        }, "trancare");
    }
}
