package f1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public enum x {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    x(boolean inclusive) {
        this.inclusive = inclusive;
    }

    public static x forBoolean(boolean inclusive) {
        return inclusive ? CLOSED : OPEN;
    }
}
