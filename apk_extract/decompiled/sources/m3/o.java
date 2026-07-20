package m3;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static UUID a(int i8) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        UUID uuidFromString = UUID.fromString("0000" + o.d.q(new Object[]{Integer.valueOf(i8 & 65535)}, 1, "%04X", "format(...)") + "-0000-1000-8000-00805F9B34FB");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        return uuidFromString;
    }

    public static boolean b(UUID src, UUID dst) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (((src.getMostSignificantBits() & (-281470681743361L)) == 0 && src.getLeastSignificantBits() == 0) || ((dst.getMostSignificantBits() & (-281470681743361L)) == 0 && dst.getLeastSignificantBits() == 0)) {
            return (src.getMostSignificantBits() & 281470681743360L) == (dst.getMostSignificantBits() & 281470681743360L);
        }
        return Intrinsics.areEqual(src, dst);
    }
}
