package androidx.constraintlayout.core.parser;

import c.a;

/* JADX INFO: loaded from: classes.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String str, CLElement cLElement) {
        this.mReason = str;
        if (cLElement != null) {
            this.mElementClass = cLElement.getStrClass();
            this.mLineNumber = cLElement.getLine();
        } else {
            this.mElementClass = "unknown";
            this.mLineNumber = 0;
        }
    }

    public String reason() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mReason);
        sb2.append(" (");
        sb2.append(this.mElementClass);
        sb2.append(" at line ");
        return a.a(sb2, this.mLineNumber, ")");
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
