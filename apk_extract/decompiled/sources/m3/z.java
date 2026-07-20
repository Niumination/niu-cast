package m3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public static xg.v a(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return Intrinsics.areEqual(path, "/") ? xg.v.f10992b : new xg.v(SequencesKt.toList(SequencesKt.map(SequencesKt.filter(StringsKt__StringsKt.splitToSequence$default((CharSequence) path, new String[]{"/"}, false, 0, 6, (Object) null), new qg.y0(19)), new qg.y0(20))));
    }
}
