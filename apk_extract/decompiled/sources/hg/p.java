package hg;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum p {
    ECDHE("ECDHE_ECDSA"),
    RSA("RSA");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jvmName;

    p(String str) {
        this.jvmName = str;
    }

    public static EnumEntries<p> getEntries() {
        return $ENTRIES;
    }

    public final String getJvmName() {
        return this.jvmName;
    }
}
