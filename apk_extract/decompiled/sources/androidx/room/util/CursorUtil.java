package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CursorUtil {
    private CursorUtil() {
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i8 = 0; i8 < cursor.getColumnCount(); i8++) {
                    int type = cursor.getType(i8);
                    if (type == 0) {
                        objArr[i8] = null;
                    } else if (type == 1) {
                        objArr[i8] = Long.valueOf(cursor.getLong(i8));
                    } else if (type == 2) {
                        objArr[i8] = Double.valueOf(cursor.getDouble(i8));
                    } else if (type == 3) {
                        objArr[i8] = cursor.getString(i8);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i8] = cursor.getBlob(i8);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            cursor.close();
            return matrixCursor;
        } catch (Throwable th2) {
            cursor.close();
            throw th2;
        }
    }

    public static int getColumnIndex(@NonNull Cursor cursor, @NonNull String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndex("`" + str + "`");
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor cursor, @NonNull String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }
}
