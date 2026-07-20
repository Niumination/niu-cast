package hg;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum t {
    WARNING(1),
    FATAL(2);

    private static final t[] byCode;
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final s Companion = new s();

    static {
        t next;
        t[] tVarArr = new t[256];
        for (int i8 = 0; i8 < 256; i8++) {
            Iterator<t> it = getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.code != i8);
            tVarArr[i8] = next;
        }
        byCode = tVarArr;
    }

    t(int i8) {
        this.code = i8;
    }

    public static EnumEntries<t> getEntries() {
        return $ENTRIES;
    }

    public final int getCode() {
        return this.code;
    }
}
