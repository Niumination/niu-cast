package j2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h implements c, k2.c {
    public static final a2.b e = new a2.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f6048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l2.a f6049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l2.a f6050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f6051d;

    public h(l2.a aVar, l2.a aVar2, a aVar3, k kVar) {
        this.f6048a = kVar;
        this.f6049b = aVar;
        this.f6050c = aVar2;
        this.f6051d = aVar3;
    }

    public static Long c(SQLiteDatabase sQLiteDatabase, d2.j jVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        d2.d dVar = (d2.d) jVar;
        ArrayList arrayList = new ArrayList(Arrays.asList(dVar.f4269a, String.valueOf(m2.a.a(dVar.f4271c))));
        byte[] bArr = dVar.f4270b;
        if (bArr != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb2.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            Cursor cursor = cursorQuery;
            return !cursor.moveToNext() ? null : Long.valueOf(cursor.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String i(Iterable iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(((b) it.next()).f6039a);
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static Object k(Cursor cursor, f fVar) {
        try {
            return fVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase a() {
        k kVar = this.f6048a;
        kVar.getClass();
        l2.a aVar = this.f6050c;
        long jA = aVar.a();
        while (true) {
            try {
                return kVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e4) {
                if (aVar.a() >= ((long) this.f6051d.f6037c) + jA) {
                    throw new k2.a("Timed out while trying to open db.", e4);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6048a.close();
    }

    public final Object g(f fVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = fVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final Object h(k2.b bVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        l2.a aVar = this.f6050c;
        long jA = aVar.a();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objExecute = bVar.execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objExecute;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e4) {
                if (aVar.a() >= ((long) this.f6051d.f6037c) + jA) {
                    throw new k2.a("Timed out while trying to acquire the lock.", e4);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
