package u6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10391d;
    public static final String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10396l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f10397a;

    static {
        StringBuilder sb2 = new StringBuilder("CREATE TABLE ");
        b bVar = b.f10381a;
        sb2.append(bVar.a());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, tid INTEGER NOT NULL,event TEXT NOT NULL,et INTEGER NOT NULL,pi INTEGER NOT NULL,created_at INTEGER NOT NULL,uid TEXT,ext TEXT,er_ts INTEGER DEFAULT 0,boot_id TEXT)");
        f10389b = sb2.toString();
        f10390c = "CREATE TABLE " + b.f10383c.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, tid INTEGER NOT NULL UNIQUE,ev TEXT,pt INTEGER DEFAULT 0,cf TEXT,ext TEXT)";
        f10391d = "CREATE TABLE " + b.f10384d.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, appid INTEGER NOT NULL UNIQUE,base TEXT,cfg TEXT,uid TEXT,try INTEGER DEFAULT 0,date TEXT,cnt INTEGER DEFAULT 0,ext TEXT)";
        e = "ALTER TABLE " + bVar.a() + " ADD COLUMN uid TEXT";
        f10392h = "ALTER TABLE " + bVar.a() + " ADD COLUMN ext TEXT";
        f10393i = "ALTER TABLE " + bVar.a() + " ADD COLUMN er_ts INTEGER";
        f10394j = "ALTER TABLE " + bVar.a() + " ADD COLUMN boot_id TEXT";
        f10395k = "CREATE INDEX IF NOT EXISTS t_idx ON " + bVar.a() + " (tid,created_at)";
        StringBuilder sb3 = new StringBuilder("DROP TABLE ");
        sb3.append(bVar.a());
        f10396l = sb3.toString();
    }

    public d(Context context) {
        super(context, "athena.db", (SQLiteDatabase.CursorFactory) null, 6);
        this.f10397a = context.getDatabasePath("athena.db");
    }

    public final boolean a() {
        File file = this.f10397a;
        if (!file.exists()) {
            return false;
        }
        long length = file.length();
        String str = s6.d.f9538a;
        return length > ((long) 10485760);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        z6.a.a("Creating a new Athena DB");
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(f10389b);
                sQLiteDatabase.execSQL(f10395k);
                sQLiteDatabase.execSQL(f10390c);
                sQLiteDatabase.execSQL(f10391d);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e4) {
                z6.a.a(Log.getStackTraceString(e4));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034 A[Catch: all -> 0x0022, Exception -> 0x0024, SQLiteException -> 0x002f, TryCatch #2 {Exception -> 0x0024, blocks: (B:3:0x0011, B:5:0x0017, B:13:0x0029, B:18:0x0034, B:21:0x003c, B:24:0x0058, B:23:0x0047), top: B:31:0x0011, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x003c A[Catch: all -> 0x0022, Exception -> 0x0024, SQLiteException -> 0x002f, TRY_LEAVE, TryCatch #2 {Exception -> 0x0024, blocks: (B:3:0x0011, B:5:0x0017, B:13:0x0029, B:18:0x0034, B:21:0x003c, B:24:0x0058, B:23:0x0047), top: B:31:0x0011, outer: #0 }] */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        z6.a.a("Upgrading app, replacing Athena DB oldVersion = " + i8);
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (i8 < 4) {
                    sQLiteDatabase.execSQL(f10390c);
                    sQLiteDatabase.execSQL(f10391d);
                }
                if (i8 < 3) {
                    try {
                        sQLiteDatabase.execSQL(e);
                        if (i8 < 5) {
                            sQLiteDatabase.execSQL(f10392h);
                        }
                        if (i8 < 6) {
                            sQLiteDatabase.execSQL(f10393i);
                            sQLiteDatabase.execSQL(f10394j);
                        }
                    } catch (SQLiteException e4) {
                        z6.a.c(Log.getStackTraceString(e4));
                        sQLiteDatabase.execSQL(f10396l);
                        sQLiteDatabase.execSQL(f10389b);
                    }
                } else {
                    if (i8 < 5) {
                        sQLiteDatabase.execSQL(f10392h);
                    }
                    if (i8 < 6) {
                        sQLiteDatabase.execSQL(f10393i);
                        sQLiteDatabase.execSQL(f10394j);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        } catch (Exception e10) {
            z6.a.c(Log.getStackTraceString(e10));
        }
    }
}
