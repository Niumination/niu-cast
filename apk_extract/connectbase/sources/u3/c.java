package u3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import s3.g;

/* JADX INFO: loaded from: classes2.dex */
public class c extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f16194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f16195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16196g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f16197i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f16198n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f16199p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f16200a;

    static {
        StringBuilder sb2 = new StringBuilder("CREATE TABLE ");
        b.a aVar = b.a.f16186a;
        sb2.append(aVar.a());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, tid INTEGER NOT NULL,event TEXT NOT NULL,et INTEGER NOT NULL,pi INTEGER NOT NULL,created_at INTEGER NOT NULL,uid TEXT,ext TEXT,er_ts INTEGER DEFAULT 0,boot_id TEXT)");
        f16191b = sb2.toString();
        f16192c = "CREATE TABLE " + b.a.f16188c.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, tid INTEGER NOT NULL UNIQUE,ev TEXT,pt INTEGER DEFAULT 0,cf TEXT,ext TEXT)";
        f16193d = "CREATE TABLE " + b.a.f16189d.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, appid INTEGER NOT NULL UNIQUE,base TEXT,cfg TEXT,uid TEXT,try INTEGER DEFAULT 0,date TEXT,cnt INTEGER DEFAULT 0,ext TEXT)";
        f16194e = "ALTER TABLE " + aVar.a() + " ADD COLUMN uid TEXT";
        f16195f = "ALTER TABLE " + aVar.a() + " ADD COLUMN ext TEXT";
        f16196g = "ALTER TABLE " + aVar.a() + " ADD COLUMN er_ts INTEGER";
        f16197i = "ALTER TABLE " + aVar.a() + " ADD COLUMN boot_id TEXT";
        f16198n = "CREATE INDEX IF NOT EXISTS t_idx ON " + aVar.a() + " (tid,created_at)";
        StringBuilder sb3 = new StringBuilder("DROP TABLE ");
        sb3.append(aVar.a());
        f16199p = sb3.toString();
    }

    public c(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 6);
        this.f16200a = context.getDatabasePath(str);
    }

    public void b() {
        close();
        if (this.f16200a.delete()) {
            y3.b.b("mDatabaseFile deleted");
        }
    }

    public boolean c() {
        return this.f16200a.exists() && this.f16200a.length() > ((long) g.H());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        y3.b.b("Creating a new Athena DB");
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(f16191b);
                sQLiteDatabase.execSQL(f16198n);
                sQLiteDatabase.execSQL(f16192c);
                sQLiteDatabase.execSQL(f16193d);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e10) {
                y3.b.b(Log.getStackTraceString(e10));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034 A[Catch: all -> 0x0022, Exception -> 0x0024, SQLiteException -> 0x002f, TryCatch #2 {Exception -> 0x0024, blocks: (B:3:0x0011, B:5:0x0017, B:13:0x0029, B:18:0x0034, B:21:0x003c, B:24:0x0058, B:23:0x0047), top: B:31:0x0011, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x003c A[Catch: all -> 0x0022, Exception -> 0x0024, SQLiteException -> 0x002f, TRY_LEAVE, TryCatch #2 {Exception -> 0x0024, blocks: (B:3:0x0011, B:5:0x0017, B:13:0x0029, B:18:0x0034, B:21:0x003c, B:24:0x0058, B:23:0x0047), top: B:31:0x0011, outer: #0 }] */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        y3.b.b("Upgrading app, replacing Athena DB oldVersion = " + i10);
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (i10 < 4) {
                    sQLiteDatabase.execSQL(f16192c);
                    sQLiteDatabase.execSQL(f16193d);
                }
                if (i10 < 3) {
                    try {
                        sQLiteDatabase.execSQL(f16194e);
                        if (i10 < 5) {
                            sQLiteDatabase.execSQL(f16195f);
                        }
                        if (i10 < 6) {
                            sQLiteDatabase.execSQL(f16196g);
                            sQLiteDatabase.execSQL(f16197i);
                        }
                    } catch (SQLiteException e10) {
                        y3.b.d(Log.getStackTraceString(e10));
                        sQLiteDatabase.execSQL(f16199p);
                        sQLiteDatabase.execSQL(f16191b);
                    }
                } else {
                    if (i10 < 5) {
                        sQLiteDatabase.execSQL(f16195f);
                    }
                    if (i10 < 6) {
                        sQLiteDatabase.execSQL(f16196g);
                        sQLiteDatabase.execSQL(f16197i);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        } catch (Exception e11) {
            y3.b.d(Log.getStackTraceString(e11));
        }
    }
}
