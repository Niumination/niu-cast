package cf;

/* JADX INFO: loaded from: classes3.dex */
public enum s {
    HEADER_TABLE_SIZE(1),
    ENABLE_PUSH(2),
    MAX_CONCURRENT_STREAMS(4),
    MAX_FRAME_SIZE(5),
    MAX_HEADER_LIST_SIZE(6),
    INITIAL_WINDOW_SIZE(7);

    private final int bit;

    s(int i8) {
        this.bit = i8;
    }

    public int getBit() {
        return this.bit;
    }
}
