package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: classes.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i8, byte[] bArr) {
        this.mDelegate.bindBlob(i8, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i8, double d7) {
        this.mDelegate.bindDouble(i8, d7);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i8, long j8) {
        this.mDelegate.bindLong(i8, j8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i8) {
        this.mDelegate.bindNull(i8);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i8, String str) {
        this.mDelegate.bindString(i8, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }
}
