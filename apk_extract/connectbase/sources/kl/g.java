package kl;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends IllegalStateException {
    public g(@l String str, int i10, @l String str2) {
        l0.p(str, "data");
        l0.p(str2, "pattern");
        StringBuilder sb2 = new StringBuilder("Failed to parse date string: \"");
        sb2.append(str);
        sb2.append("\" at index ");
        sb2.append(i10);
        sb2.append(". Pattern: \"");
        super(l.a.a(sb2, str2, '\"'));
    }
}
