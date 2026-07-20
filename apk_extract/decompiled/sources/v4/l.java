package v4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final l COMPACT = new l("", "", false);
    public static final l PRETTY = new l("\n", "  ", true);
    private final String indent;
    private final String newline;
    private final boolean spaceAfterSeparators;

    private l(String str, String str2, boolean z2) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.newline = str;
        this.indent = str2;
        this.spaceAfterSeparators = z2;
    }

    public String getIndent() {
        return this.indent;
    }

    public String getNewline() {
        return this.newline;
    }

    public boolean usesSpaceAfterSeparators() {
        return this.spaceAfterSeparators;
    }

    public l withIndent(String str) {
        return new l(this.newline, str, this.spaceAfterSeparators);
    }

    public l withNewline(String str) {
        return new l(str, this.indent, this.spaceAfterSeparators);
    }

    public l withSpaceAfterSeparators(boolean z2) {
        return new l(this.newline, this.indent, z2);
    }
}
