package oh;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public enum y {
    TEXT(false, 1),
    BINARY(false, 2),
    CLOSE(true, 8),
    PING(true, 9),
    PONG(true, 10);

    private static final y[] byOpcodeArray;
    private static final int maxOpcode;
    private final boolean controlFrame;
    private final int opcode;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final x Companion = new x();

    static {
        y next;
        Iterator<y> it = getEntries().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int i8 = next.opcode;
                do {
                    y next2 = it.next();
                    int i9 = next2.opcode;
                    if (i8 < i9) {
                        next = next2;
                        i8 = i9;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Intrinsics.checkNotNull(next);
        int i10 = next.opcode;
        maxOpcode = i10;
        int i11 = i10 + 1;
        y[] yVarArr = new y[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            Iterator<y> it2 = getEntries().iterator();
            boolean z2 = false;
            y yVar = null;
            while (true) {
                if (!it2.hasNext()) {
                    if (z2) {
                        break;
                    }
                } else {
                    y next3 = it2.next();
                    if (next3.opcode == i12) {
                        if (!z2) {
                            z2 = true;
                            yVar = next3;
                        }
                    }
                }
                yVar = null;
                break;
            }
            yVarArr[i12] = yVar;
        }
        byOpcodeArray = yVarArr;
    }

    y(boolean z2, int i8) {
        this.controlFrame = z2;
        this.opcode = i8;
    }

    public static EnumEntries<y> getEntries() {
        return $ENTRIES;
    }

    public final boolean getControlFrame() {
        return this.controlFrame;
    }

    public final int getOpcode() {
        return this.opcode;
    }
}
