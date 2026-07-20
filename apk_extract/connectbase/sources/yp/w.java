package yp;

/* JADX INFO: loaded from: classes3.dex */
public enum w {
    IN("in"),
    OUT("out"),
    INV("");


    @os.l
    private final String presentation;

    w(String str) {
        this.presentation = str;
    }

    @Override // java.lang.Enum
    @os.l
    public String toString() {
        return this.presentation;
    }
}
