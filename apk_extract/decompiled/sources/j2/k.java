package j2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f6056c = Arrays.asList(i.f6052b, i.f6053c, i.f6054d, i.e);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6058b;

    public k(Context context, int i8, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i8);
        this.f6058b = false;
        this.f6057a = i8;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        List list = f6056c;
        if (i9 <= list.size()) {
            while (i8 < i9) {
                ((j) list.get(i8)).a(sQLiteDatabase);
                i8++;
            }
        } else {
            StringBuilder sbR = o.d.r(i8, i9, "Migration from ", " to ", " was requested, but cannot be performed. Only ");
            sbR.append(list.size());
            sbR.append(" migrations are provided");
            throw new IllegalArgumentException(sbR.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f6058b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!this.f6058b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, this.f6057a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        if (!this.f6058b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i9);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.f6058b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        if (!this.f6058b) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, i8, i9);
    }
}
