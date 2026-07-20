package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;

    @VisibleForTesting
    static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;

    @VisibleForTesting
    static final int POOL_LIMIT = 15;
    private static final int STRING = 4;

    @VisibleForTesting
    static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = new TreeMap<>();

    @VisibleForTesting
    int mArgCount;
    private final int[] mBindingTypes;

    @VisibleForTesting
    final byte[][] mBlobBindings;

    @VisibleForTesting
    final int mCapacity;

    @VisibleForTesting
    final double[] mDoubleBindings;

    @VisibleForTesting
    final long[] mLongBindings;
    private volatile String mQuery;

    @VisibleForTesting
    final String[] mStringBindings;

    private RoomSQLiteQuery(int i8) {
        this.mCapacity = i8;
        int i9 = i8 + 1;
        this.mBindingTypes = new int[i9];
        this.mLongBindings = new long[i9];
        this.mDoubleBindings = new double[i9];
        this.mStringBindings = new String[i9];
        this.mBlobBindings = new byte[i9][];
    }

    public static RoomSQLiteQuery acquire(String str, int i8) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            try {
                Map.Entry<Integer, RoomSQLiteQuery> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i8));
                if (entryCeilingEntry == null) {
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i8);
                    roomSQLiteQuery.init(str, i8);
                    return roomSQLiteQuery;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery value = entryCeilingEntry.getValue();
                value.init(str, i8);
                return value;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery.1
            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindBlob(int i8, byte[] bArr) {
                RoomSQLiteQuery.this.bindBlob(i8, bArr);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindDouble(int i8, double d7) {
                RoomSQLiteQuery.this.bindDouble(i8, d7);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindLong(int i8, long j8) {
                RoomSQLiteQuery.this.bindLong(i8, j8);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindNull(int i8) {
                RoomSQLiteQuery.this.bindNull(i8);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindString(int i8, String str) {
                RoomSQLiteQuery.this.bindString(i8, str);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void clearBindings() {
                RoomSQLiteQuery.this.clearBindings();
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        });
        return roomSQLiteQueryAcquire;
    }

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i8 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i8;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i8, byte[] bArr) {
        this.mBindingTypes[i8] = 5;
        this.mBlobBindings[i8] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i8, double d7) {
        this.mBindingTypes[i8] = 3;
        this.mDoubleBindings[i8] = d7;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i8, long j8) {
        this.mBindingTypes[i8] = 2;
        this.mLongBindings[i8] = j8;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i8) {
        this.mBindingTypes[i8] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i8, String str) {
        this.mBindingTypes[i8] = 4;
        this.mStringBindings[i8] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i8 = 1; i8 <= this.mArgCount; i8++) {
            int i9 = this.mBindingTypes[i8];
            if (i9 == 1) {
                supportSQLiteProgram.bindNull(i8);
            } else if (i9 == 2) {
                supportSQLiteProgram.bindLong(i8, this.mLongBindings[i8]);
            } else if (i9 == 3) {
                supportSQLiteProgram.bindDouble(i8, this.mDoubleBindings[i8]);
            } else if (i9 == 4) {
                supportSQLiteProgram.bindString(i8, this.mStringBindings[i8]);
            } else if (i9 == 5) {
                supportSQLiteProgram.bindBlob(i8, this.mBlobBindings[i8]);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, (Object) null);
        Arrays.fill(this.mBlobBindings, (Object) null);
        this.mQuery = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.mBindingTypes, 0, this.mBindingTypes, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mLongBindings, 0, this.mLongBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mStringBindings, 0, this.mStringBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mBlobBindings, 0, this.mBlobBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mDoubleBindings, 0, this.mDoubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    public void init(String str, int i8) {
        this.mQuery = str;
        this.mArgCount = i8;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.mCapacity), this);
            prunePoolLocked();
        }
    }
}
