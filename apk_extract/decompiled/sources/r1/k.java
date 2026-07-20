package r1;

/* JADX INFO: loaded from: classes.dex */
public enum k {
    MERGE,
    ADD,
    SUBTRACT,
    INTERSECT,
    EXCLUDE_INTERSECTIONS;

    public static k forId(int i8) {
        if (i8 == 1) {
            return MERGE;
        }
        if (i8 == 2) {
            return ADD;
        }
        if (i8 == 3) {
            return SUBTRACT;
        }
        if (i8 != 4) {
            return i8 != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
        }
        return INTERSECT;
    }
}
