package fg;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum r {
    READ(1),
    WRITE(4),
    ACCEPT(16),
    CONNECT(8);

    private static final int[] flags;
    private static final int size;
    private final int flag;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final q Companion = new q();
    private static final r[] AllInterests = (r[]) getEntries().toArray(new r[0]);

    static {
        EnumEntries<r> entries = getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.i(entries));
        Iterator<r> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().flag));
        }
        flags = CollectionsKt.toIntArray(arrayList);
        size = getEntries().size();
    }

    r(int i8) {
        this.flag = i8;
    }

    public static EnumEntries<r> getEntries() {
        return $ENTRIES;
    }

    public final int getFlag() {
        return this.flag;
    }
}
