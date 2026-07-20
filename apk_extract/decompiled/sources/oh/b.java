package oh;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum b {
    NORMAL(1000),
    GOING_AWAY(1001),
    PROTOCOL_ERROR(1002),
    CANNOT_ACCEPT(1003),
    CLOSED_ABNORMALLY(1006),
    NOT_CONSISTENT(1007),
    VIOLATED_POLICY(1008),
    TOO_BIG(1009),
    NO_EXTENSION(1010),
    INTERNAL_ERROR(1011),
    SERVICE_RESTART(1012),
    TRY_AGAIN_LATER(1013);


    @JvmField
    public static final b UNEXPECTED_CONDITION;
    private static final Map<Short, b> byCodeMap;
    private final short code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final a Companion = new a();

    static {
        EnumEntries<b> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.i(entries)), 16));
        for (b bVar : entries) {
            linkedHashMap.put(Short.valueOf(bVar.code), bVar);
        }
        byCodeMap = linkedHashMap;
        UNEXPECTED_CONDITION = INTERNAL_ERROR;
    }

    b(short s2) {
        this.code = s2;
    }

    public static EnumEntries<b> getEntries() {
        return $ENTRIES;
    }

    public final short getCode() {
        return this.code;
    }
}
