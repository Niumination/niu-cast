package dp;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jq.e0;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3819a;

        static {
            int[] iArr = new int[i.values().length];
            iArr[i.BEGINNING.ordinal()] = 1;
            iArr[i.AFTER_DOT.ordinal()] = 2;
            iArr[i.MIDDLE.ordinal()] = 3;
            f3819a = iArr;
        }
    }

    @m
    public static final <V> V a(@l c cVar, @l Map<c, ? extends V> map) {
        Object next;
        l0.p(cVar, "<this>");
        l0.p(map, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<c, ? extends V> entry : map.entrySet()) {
            c key = entry.getKey();
            if (l0.g(cVar, key) || b(cVar, key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = g((c) ((Map.Entry) next).getKey(), cVar).b().length();
                do {
                    Object next2 = it.next();
                    int length2 = g((c) ((Map.Entry) next2).getKey(), cVar).b().length();
                    if (length > length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 == null) {
            return null;
        }
        return (V) entry2.getValue();
    }

    public static final boolean b(@l c cVar, @l c cVar2) {
        l0.p(cVar, "<this>");
        l0.p(cVar2, "packageName");
        return l0.g(f(cVar), cVar2);
    }

    public static final boolean c(@l c cVar, @l c cVar2) {
        l0.p(cVar, "<this>");
        l0.p(cVar2, "packageName");
        if (l0.g(cVar, cVar2) || cVar2.d()) {
            return true;
        }
        String strB = cVar.b();
        l0.o(strB, "this.asString()");
        String strB2 = cVar2.b();
        l0.o(strB2, "packageName.asString()");
        return d(strB, strB2);
    }

    public static final boolean d(String str, String str2) {
        return e0.s2(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean e(@m String str) {
        if (str == null) {
            return false;
        }
        i iVar = i.BEGINNING;
        int i10 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            i10++;
            int i11 = a.f3819a[iVar.ordinal()];
            if (i11 == 1 || i11 == 2) {
                if (!Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
                iVar = i.MIDDLE;
            } else if (i11 != 3) {
                continue;
            } else if (cCharAt == '.') {
                iVar = i.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(cCharAt)) {
                return false;
            }
        }
        return iVar != i.AFTER_DOT;
    }

    @m
    public static final c f(@l c cVar) {
        l0.p(cVar, "<this>");
        if (cVar.d()) {
            return null;
        }
        return cVar.e();
    }

    @l
    public static final c g(@l c cVar, @l c cVar2) {
        l0.p(cVar, "<this>");
        l0.p(cVar2, "prefix");
        if (!c(cVar, cVar2) || cVar2.d()) {
            return cVar;
        }
        if (l0.g(cVar, cVar2)) {
            c cVar3 = c.f3809c;
            l0.o(cVar3, ps.a.f13319u);
            return cVar3;
        }
        String strB = cVar.b();
        l0.o(strB, "asString()");
        String strSubstring = strB.substring(cVar2.b().length() + 1);
        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        return new c(strSubstring);
    }
}
