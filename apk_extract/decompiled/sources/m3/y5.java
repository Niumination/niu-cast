package m3;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class y5 {
    public static final Charset a(zf.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        String name = iVar.h("charset");
        if (name == null) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(Charsets.INSTANCE, "<this>");
            Intrinsics.checkNotNullParameter(name, "name");
            Charset charsetForName = Charset.forName(name);
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            return charsetForName;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final zf.i b(zf.i iVar, Charset charset) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String value = k3.ab.b(charset);
        iVar.getClass();
        Intrinsics.checkNotNullParameter("charset", "name");
        Intrinsics.checkNotNullParameter(value, "value");
        List list = (List) iVar.f1435c;
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                List<zf.o> list2 = list;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (zf.o oVar : list2) {
                        if (StringsKt__StringsJVMKt.equals(oVar.f11528a, "charset", true) && StringsKt__StringsJVMKt.equals(oVar.f11529b, value, true)) {
                            return iVar;
                        }
                    }
                }
            } else {
                zf.o oVar2 = (zf.o) list.get(0);
                if (StringsKt__StringsJVMKt.equals(oVar2.f11528a, "charset", true) && StringsKt__StringsJVMKt.equals(oVar2.f11529b, value, true)) {
                    return iVar;
                }
            }
        }
        List listPlus = CollectionsKt.plus((Collection<? extends zf.o>) list, new zf.o("charset", value));
        return new zf.i(iVar.f11506d, iVar.e, (String) iVar.f1434b, listPlus);
    }
}
