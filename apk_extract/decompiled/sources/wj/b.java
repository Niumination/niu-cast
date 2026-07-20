package wj;

/* JADX INFO: loaded from: classes3.dex */
public enum b {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private final int levelInt;
    private final String levelStr;

    b(int i8, String str) {
        this.levelInt = i8;
        this.levelStr = str;
    }

    public static b intToLevel(int i8) {
        if (i8 == 0) {
            return TRACE;
        }
        if (i8 == 10) {
            return DEBUG;
        }
        if (i8 == 20) {
            return INFO;
        }
        if (i8 == 30) {
            return WARN;
        }
        if (i8 == 40) {
            return ERROR;
        }
        throw new IllegalArgumentException(h0.a.h(i8, "Level integer [", "] not recognized."));
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
