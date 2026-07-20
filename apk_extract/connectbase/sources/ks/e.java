package ks;

/* JADX INFO: loaded from: classes3.dex */
public enum e {
    Strip("Strip all ansi sequences"),
    Default("Print ansi sequences if the stream is a terminal"),
    Force("Always print ansi sequences, even if the stream is redirected");

    private final String description;

    e(String str) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }
}
