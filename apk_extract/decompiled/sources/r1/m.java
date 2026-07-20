package r1;

/* JADX INFO: loaded from: classes.dex */
public enum m {
    STAR(1),
    POLYGON(2);

    private final int value;

    m(int i8) {
        this.value = i8;
    }

    public static m forValue(int i8) {
        for (m mVar : values()) {
            if (mVar.value == i8) {
                return mVar;
            }
        }
        return null;
    }
}
