package androidx.sqlite.db;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i8, byte[] bArr);

    void bindDouble(int i8, double d7);

    void bindLong(int i8, long j8);

    void bindNull(int i8);

    void bindString(int i8, String str);

    void clearBindings();
}
