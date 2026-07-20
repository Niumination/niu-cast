package ze;

/* JADX INFO: loaded from: classes3.dex */
public enum o2 {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNAUTHENTICATED(16);

    private final int value;
    private final byte[] valueAscii;

    o2(int i8) {
        this.value = i8;
        this.valueAscii = Integer.toString(i8).getBytes(h4.f.f5247a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] valueAscii() {
        return this.valueAscii;
    }

    public q2 toStatus() {
        return (q2) q2.f11403d.get(this.value);
    }

    public int value() {
        return this.value;
    }
}
