package xj;

/* JADX INFO: loaded from: classes3.dex */
public enum g {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3);

    int levelInt;

    g(int i8) {
        this.levelInt = i8;
    }

    private int getLevelInt() {
        return this.levelInt;
    }
}
