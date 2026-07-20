package ks;

/* JADX INFO: loaded from: classes3.dex */
public enum b {
    Colors16("16 colors"),
    Colors256("256 colors"),
    TrueColor("24-bit colors");

    private final String description;

    b(String str) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }
}
