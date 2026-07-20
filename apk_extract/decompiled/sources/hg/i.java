package hg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f5361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f5362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f5363d;
    public static final i e;
    public static final i f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f5364g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5365a;

    static {
        new i("2.5.4.10");
        new i("2.5.4.11");
        new i("2.5.4.6");
        new i("2.5.4.3");
        new i("2.5.29.17");
        new i("2.5.29.19");
        new i("2.5.29.15");
        new i("2.5.29.37");
        new i("1.3.6.1.5.5.7.3.1");
        new i("1.3.6.1.5.5.7.3.2");
        new i("1 2 840 113549 1 1 1");
        new i("1.2.840.10045.2.1");
        f5361b = new i("1.2.840.10045.4.3.3");
        f5362c = new i("1.2.840.10045.4.3.2");
        f5363d = new i("1.2.840.113549.1.1.13");
        e = new i("1.2.840.113549.1.1.12");
        f = new i("1.2.840.113549.1.1.11");
        f5364g = new i("1.2.840.113549.1.1.5");
        new i("1.2.840.10045.3.1.7");
    }

    public i(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.f5365a = identifier;
        List listSplit$default = StringsKt__StringsKt.split$default(identifier, new String[]{".", " "}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt(StringsKt__StringsKt.trim((CharSequence) ((String) it.next())).toString())));
        }
        CollectionsKt.toIntArray(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && Intrinsics.areEqual(this.f5365a, ((i) obj).f5365a);
    }

    public final int hashCode() {
        return this.f5365a.hashCode();
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("OID(identifier="), this.f5365a, ')');
    }
}
