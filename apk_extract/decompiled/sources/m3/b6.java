package m3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class b6 {
    public static zf.y a(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List listSplit$default = StringsKt__StringsKt.split$default(value, new String[]{"/", "."}, false, 0, 6, (Object) null);
        if (listSplit$default.size() != 3) {
            throw new IllegalStateException(("Failed to parse HttpProtocolVersion. Expected format: protocol/major.minor, but actual: " + ((Object) value)).toString());
        }
        String name = (String) listSplit$default.get(0);
        String str = (String) listSplit$default.get(1);
        String str2 = (String) listSplit$default.get(2);
        int i8 = Integer.parseInt(str);
        int i9 = Integer.parseInt(str2);
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual(name, "HTTP") && i8 == 1 && i9 == 0) {
            return zf.y.f;
        }
        if (Intrinsics.areEqual(name, "HTTP") && i8 == 1 && i9 == 1) {
            return zf.y.e;
        }
        return (Intrinsics.areEqual(name, "HTTP") && i8 == 2 && i9 == 0) ? zf.y.f11560d : new zf.y(name, i8, i9);
    }
}
