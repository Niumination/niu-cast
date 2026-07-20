package m3;

import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class e6 {
    public static final void a(zf.j0 j0Var, StringBuilder sb2) {
        List listListOf;
        sb2.append(j0Var.c().f11526a);
        String str = j0Var.c().f11526a;
        int iHashCode = str.hashCode();
        if (iHashCode != -1081572750) {
            if (iHashCode != 3143036) {
                if (iHashCode == 92611469 && str.equals("about")) {
                    CharSequence charSequence = j0Var.f11509a;
                    sb2.append(":");
                    sb2.append(charSequence);
                    return;
                }
            } else if (str.equals("file")) {
                CharSequence charSequence2 = j0Var.f11509a;
                String strC = c(j0Var);
                sb2.append("://");
                sb2.append(charSequence2);
                if (!StringsKt__StringsKt.startsWith$default((CharSequence) strC, '/', false, 2, (Object) null)) {
                    sb2.append('/');
                }
                sb2.append((CharSequence) strC);
                return;
            }
        } else if (str.equals("mailto")) {
            Intrinsics.checkNotNullParameter(j0Var, "<this>");
            StringBuilder sb3 = new StringBuilder();
            String str2 = j0Var.e;
            String str3 = j0Var.f;
            Intrinsics.checkNotNullParameter(sb3, "<this>");
            if (str2 != null) {
                sb3.append(str2);
                if (str3 != null) {
                    sb3.append(':');
                    sb3.append(str3);
                }
                sb3.append("@");
            }
            CharSequence string = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            CharSequence charSequence3 = j0Var.f11509a;
            sb2.append(":");
            sb2.append(string);
            sb2.append(charSequence3);
            return;
        }
        sb2.append("://");
        sb2.append(b(j0Var));
        String encodedPath = c(j0Var);
        zf.f0 encodedQueryParameters = j0Var.f11515i;
        boolean z2 = j0Var.f11510b;
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
        Intrinsics.checkNotNullParameter(encodedQueryParameters, "encodedQueryParameters");
        if (!StringsKt.isBlank(encodedPath) && !StringsKt__StringsJVMKt.startsWith$default(encodedPath, "/", false, 2, null)) {
            sb2.append('/');
        }
        sb2.append((CharSequence) encodedPath);
        if (!((Map) encodedQueryParameters.f574b).isEmpty() || z2) {
            sb2.append("?");
        }
        Set<Map.Entry> setA = encodedQueryParameters.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setA) {
            String str4 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listListOf = CollectionsKt.listOf(TuplesKt.to(str4, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.i(list2));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(TuplesKt.to(str4, (String) it.next()));
                }
                listListOf = arrayList2;
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, listListOf);
        }
        CollectionsKt___CollectionsKt.joinTo(arrayList, sb2, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 2) != 0 ? ", " : "&", (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 4) != 0 ? "" : null, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 8) == 0 ? null : "", (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 16) != 0 ? -1 : 0, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 32) != 0 ? "..." : null, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 64) != 0 ? null : new zf.o0(0));
        if (j0Var.f11513g.length() > 0) {
            sb2.append('#');
            sb2.append(j0Var.f11513g);
        }
    }

    public static final String b(zf.j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        StringBuilder sb2 = new StringBuilder();
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        StringBuilder sb3 = new StringBuilder();
        String str = j0Var.e;
        String str2 = j0Var.f;
        Intrinsics.checkNotNullParameter(sb3, "<this>");
        if (str != null) {
            sb3.append(str);
            if (str2 != null) {
                sb3.append(':');
                sb3.append(str2);
            }
            sb3.append("@");
        }
        String string = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb2.append(string);
        sb2.append(j0Var.f11509a);
        int i8 = j0Var.f11511c;
        if (i8 != 0 && i8 != j0Var.c().f11527b) {
            sb2.append(":");
            sb2.append(String.valueOf(j0Var.f11511c));
        }
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    public static final String c(zf.j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        List list = j0Var.f11514h;
        if (list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return ((CharSequence) CollectionsKt.first(list)).length() == 0 ? "/" : (String) CollectionsKt.first(list);
        }
        return CollectionsKt___CollectionsKt.joinToString$default(list, "/", null, null, 0, null, null, 62, null);
    }

    public static final void d(zf.j0 j0Var, String value) {
        List mutableList;
        Intrinsics.checkNotNullParameter(j0Var, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(value)) {
            mutableList = CollectionsKt.emptyList();
        } else {
            mutableList = Intrinsics.areEqual(value, "/") ? zf.m0.f11520a : CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default(value, new char[]{'/'}, false, 0, 6, (Object) null));
        }
        j0Var.d(mutableList);
    }
}
