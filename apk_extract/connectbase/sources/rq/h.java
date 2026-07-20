package rq;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final String b(String str) {
        StringBuilder sb2 = new StringBuilder("\"");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt == '\\') {
                sb2.append("\\\\");
            } else if (cCharAt == '\b') {
                sb2.append("\\b");
            } else if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\t') {
                sb2.append("\\t");
            } else {
                sb2.append(cCharAt);
            }
        }
        sb2.append('\"');
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
