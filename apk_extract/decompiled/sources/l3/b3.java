package l3;

/* JADX INFO: loaded from: classes.dex */
public enum b3 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(b0.zzb),
    ENUM(null),
    MESSAGE(null);

    private final Object zzk;

    b3(Object obj) {
        this.zzk = obj;
    }
}
