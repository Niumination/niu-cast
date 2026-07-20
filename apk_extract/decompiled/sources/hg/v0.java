package hg;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum v0 {
    ChangeCipherSpec(20),
    Alert(21),
    Handshake(22),
    ApplicationData(23);

    private static final v0[] byCode;
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final u0 Companion = new u0();

    static {
        v0 next;
        v0[] v0VarArr = new v0[256];
        for (int i8 = 0; i8 < 256; i8++) {
            Iterator<v0> it = getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.code != i8);
            v0VarArr[i8] = next;
        }
        byCode = v0VarArr;
    }

    v0(int i8) {
        this.code = i8;
    }

    public static EnumEntries<v0> getEntries() {
        return $ENTRIES;
    }

    public final int getCode() {
        return this.code;
    }
}
