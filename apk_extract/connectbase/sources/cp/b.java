package cp;

import an.n;
import el.b0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jq.e0;
import jq.m0;
import kn.l0;
import nm.h0;
import nm.y;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final b f3358a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f3359b = h0.m3(y.O('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final Map<String, String> f3360c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listO = y.O("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iC = n.c(0, listO.size() - 1, 2);
        if (iC >= 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 2;
                StringBuilder sb2 = new StringBuilder();
                String str = f3359b;
                sb2.append(str);
                sb2.append(b0.f4502a);
                sb2.append((String) listO.get(i10));
                int i12 = i10 + 1;
                linkedHashMap.put(sb2.toString(), listO.get(i12));
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(b0.f4502a);
                linkedHashMap.put(j.c.a(sb3, (String) listO.get(i10), "Array"), l0.C("[", listO.get(i12)));
                if (i10 == iC) {
                    break;
                } else {
                    i10 = i11;
                }
            }
        }
        linkedHashMap.put(l0.C(f3359b, "/Unit"), "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : y.O("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, l0.C("java/lang/", str2));
        }
        for (String str3 : y.O("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, l0.C("collections/", str3), l0.C("java/util/", str3));
            a(linkedHashMap, l0.C("collections/Mutable", str3), l0.C("java/util/", str3));
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i13 = 0; i13 < 23; i13++) {
            String strC = l0.C("Function", Integer.valueOf(i13));
            StringBuilder sb4 = new StringBuilder();
            String str4 = f3359b;
            sb4.append(str4);
            sb4.append("/jvm/functions/Function");
            sb4.append(i13);
            a(linkedHashMap, strC, sb4.toString());
            a(linkedHashMap, l0.C("reflect/KFunction", Integer.valueOf(i13)), l0.C(str4, "/reflect/KFunction"));
        }
        for (String str5 : y.O("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, l0.C(str5, ".Companion"), f3359b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f3360c = linkedHashMap;
    }

    public static final void a(Map<String, String> map, String str, String str2) {
        map.put(f3359b + b0.f4502a + str, "L" + str2 + ';');
    }

    @in.n
    @l
    public static final String b(@l String str) {
        l0.p(str, "classId");
        String str2 = f3360c.get(str);
        return str2 == null ? l.a.a(new StringBuilder("L"), e0.h2(str, n1.e.f11183c, m0.f8865c, false, 4, null), ';') : str2;
    }
}
