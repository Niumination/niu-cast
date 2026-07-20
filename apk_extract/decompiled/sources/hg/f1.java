package hg;

import com.google.android.material.internal.ViewUtils;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum f1 {
    SSL3(ViewUtils.EDGE_TO_EDGE_FLAGS),
    TLS10(769),
    TLS11(770),
    TLS12(771);

    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final e1 Companion = new e1();
    private static final List<f1> byOrdinal = getEntries();

    f1(int i8) {
        this.code = i8;
    }

    public static EnumEntries<f1> getEntries() {
        return $ENTRIES;
    }

    public final int getCode() {
        return this.code;
    }
}
