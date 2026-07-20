package ks;

/* JADX INFO: loaded from: classes3.dex */
public enum h {
    Native("Supports ansi sequences natively"),
    Unsupported("Ansi sequences are stripped out"),
    VirtualTerminal("Supported through windows virtual terminal"),
    Emulation("Emulated through using windows API console commands"),
    Redirected("The stream is redirected to a file or a pipe");

    private final String description;

    h(String str) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }
}
