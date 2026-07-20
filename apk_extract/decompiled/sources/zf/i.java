package zf;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends c6.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f11505h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11506d;
    public final String e;

    static {
        String str = vj.e.ANY_MARKER;
        f11505h = new i(str, str);
    }

    public i(String str, String str2, String str3, List list) {
        super(str3, list);
        this.f11506d = str;
        this.e = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (StringsKt__StringsJVMKt.equals(this.f11506d, iVar.f11506d, true) && StringsKt__StringsJVMKt.equals(this.e, iVar.e, true) && Intrinsics.areEqual((List) this.f1435c, (List) iVar.f1435c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Locale locale = Locale.ROOT;
        String lowerCase = this.f11506d.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.e.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        int iHashCode2 = lowerCase2.hashCode();
        return (((List) this.f1435c).hashCode() * 31) + iHashCode2 + (iHashCode * 31) + iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0065  */
    public final boolean k(i pattern) {
        boolean zEquals;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (!Intrinsics.areEqual(pattern.f11506d, vj.e.ANY_MARKER) && !StringsKt__StringsJVMKt.equals(pattern.f11506d, this.f11506d, true)) {
            return false;
        }
        String str = pattern.e;
        if (!Intrinsics.areEqual(str, vj.e.ANY_MARKER) && !StringsKt__StringsJVMKt.equals(str, this.e, true)) {
            return false;
        }
        Iterator it = ((List) pattern.f1435c).iterator();
        do {
            zEquals = true;
            if (!it.hasNext()) {
                return true;
            }
            o oVar = (o) it.next();
            String str2 = oVar.f11528a;
            boolean zAreEqual = Intrinsics.areEqual(str2, vj.e.ANY_MARKER);
            String str3 = oVar.f11529b;
            if (!zAreEqual) {
                String strH = h(str2);
                if (!Intrinsics.areEqual(str3, vj.e.ANY_MARKER)) {
                    zEquals = StringsKt__StringsJVMKt.equals(strH, str3, true);
                } else if (strH == null) {
                    zEquals = false;
                    break;
                    break;
                }
            } else if (!Intrinsics.areEqual(str3, vj.e.ANY_MARKER)) {
                List list = (List) this.f1435c;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    do {
                        if (!it2.hasNext()) {
                            zEquals = false;
                            break;
                        }
                    } while (!StringsKt__StringsJVMKt.equals(((o) it2.next()).f11529b, str3, true));
                } else {
                    zEquals = false;
                    break;
                    break;
                }
            }
        } while (zEquals);
        return false;
    }

    public /* synthetic */ i(String str, String str2) {
        this(str, str2, CollectionsKt.emptyList());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(String contentType, String contentSubtype, List parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }
}
