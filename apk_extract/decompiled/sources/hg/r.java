package hg;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum r {
    ExplicitPrime(1),
    ExplicitChar(2),
    NamedCurve(3);

    private static final r[] byCode;
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final q Companion = new q();

    static {
        r next;
        r[] rVarArr = new r[256];
        for (int i8 = 0; i8 < 256; i8++) {
            Iterator<r> it = getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.code != i8);
            rVarArr[i8] = next;
        }
        byCode = rVarArr;
    }

    r(int i8) {
        this.code = i8;
    }

    public static EnumEntries<r> getEntries() {
        return $ENTRIES;
    }

    public final int getCode() {
        return this.code;
    }
}
