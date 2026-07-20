package cp;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jq.e0;
import kn.l0;
import kn.w;
import lm.l2;
import nm.c1;
import nm.h0;
import nm.m0;
import nm.s0;
import nm.y;
import nm.z;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements ap.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final a f3373e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final String f3374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final List<String> f3375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public static final Map<String, Integer> f3376h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final bp.a.e f3377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final String[] f3378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final Set<Integer> f3379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final List<bp.a.e.c> f3380d;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3381a;

        static {
            int[] iArr = new int[bp.a.e.c.EnumC0043c.values().length];
            iArr[bp.a.e.c.EnumC0043c.NONE.ordinal()] = 1;
            iArr[bp.a.e.c.EnumC0043c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[bp.a.e.c.EnumC0043c.DESC_TO_CLASS_ID.ordinal()] = 3;
            f3381a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String strM3 = h0.m3(y.O('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        f3374f = strM3;
        List<String> listO = y.O(l0.C(strM3, "/Any"), l0.C(strM3, "/Nothing"), l0.C(strM3, "/Unit"), l0.C(strM3, "/Throwable"), l0.C(strM3, "/Number"), l0.C(strM3, "/Byte"), l0.C(strM3, "/Double"), l0.C(strM3, "/Float"), l0.C(strM3, "/Int"), l0.C(strM3, "/Long"), l0.C(strM3, "/Short"), l0.C(strM3, "/Boolean"), l0.C(strM3, "/Char"), l0.C(strM3, "/CharSequence"), l0.C(strM3, "/String"), l0.C(strM3, "/Comparable"), l0.C(strM3, "/Enum"), l0.C(strM3, "/Array"), l0.C(strM3, "/ByteArray"), l0.C(strM3, "/DoubleArray"), l0.C(strM3, "/FloatArray"), l0.C(strM3, "/IntArray"), l0.C(strM3, "/LongArray"), l0.C(strM3, "/ShortArray"), l0.C(strM3, "/BooleanArray"), l0.C(strM3, "/CharArray"), l0.C(strM3, "/Cloneable"), l0.C(strM3, "/Annotation"), l0.C(strM3, "/collections/Iterable"), l0.C(strM3, "/collections/MutableIterable"), l0.C(strM3, "/collections/Collection"), l0.C(strM3, "/collections/MutableCollection"), l0.C(strM3, "/collections/List"), l0.C(strM3, "/collections/MutableList"), l0.C(strM3, "/collections/Set"), l0.C(strM3, "/collections/MutableSet"), l0.C(strM3, "/collections/Map"), l0.C(strM3, "/collections/MutableMap"), l0.C(strM3, "/collections/Map.Entry"), l0.C(strM3, "/collections/MutableMap.MutableEntry"), l0.C(strM3, "/collections/Iterator"), l0.C(strM3, "/collections/MutableIterator"), l0.C(strM3, "/collections/ListIterator"), l0.C(strM3, "/collections/MutableListIterator"));
        f3375g = listO;
        Iterable<s0> iterableH6 = h0.h6(listO);
        int iJ = c1.j(z.b0(iterableH6, 10));
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (s0 s0Var : iterableH6) {
            linkedHashMap.put((String) s0Var.f11692b, Integer.valueOf(s0Var.f11691a));
        }
        f3376h = linkedHashMap;
    }

    public f(@l bp.a.e eVar, @l String[] strArr) {
        Set<Integer> setA6;
        l0.p(eVar, "types");
        l0.p(strArr, "strings");
        this.f3377a = eVar;
        this.f3378b = strArr;
        List<Integer> localNameList = eVar.getLocalNameList();
        if (localNameList.isEmpty()) {
            setA6 = m0.INSTANCE;
        } else {
            l0.o(localNameList, "");
            setA6 = h0.a6(localNameList);
        }
        this.f3379c = setA6;
        ArrayList arrayList = new ArrayList();
        List<bp.a.e.c> recordList = eVar.getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (bp.a.e.c cVar : recordList) {
            int range = cVar.getRange();
            int i10 = 0;
            while (i10 < range) {
                i10++;
                arrayList.add(cVar);
            }
        }
        arrayList.trimToSize();
        l2 l2Var = l2.f10208a;
        this.f3380d = arrayList;
    }

    @Override // ap.c
    public boolean a(int i10) {
        return this.f3379c.contains(Integer.valueOf(i10));
    }

    @Override // ap.c
    @l
    public String b(int i10) {
        return c(i10);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    @Override // ap.c
    @l
    public String c(int i10) {
        String strSubstring;
        bp.a.e.c cVar = this.f3380d.get(i10);
        if (cVar.hasString()) {
            strSubstring = cVar.getString();
        } else if (cVar.hasPredefinedIndex()) {
            List<String> list = f3375g;
            int size = list.size();
            int predefinedIndex = cVar.getPredefinedIndex();
            if (predefinedIndex < 0 || predefinedIndex >= size) {
                strSubstring = this.f3378b[i10];
            } else {
                strSubstring = list.get(cVar.getPredefinedIndex());
            }
        } else {
            strSubstring = this.f3378b[i10];
        }
        if (cVar.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = cVar.getSubstringIndexList();
            l0.o(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            l0.o(num, "begin");
            if (num.intValue() >= 0) {
                int iIntValue = num.intValue();
                l0.o(num2, FloatingWindow.f2049c0);
                if (iIntValue <= num2.intValue() && num2.intValue() <= strSubstring.length()) {
                    l0.o(strSubstring, "string");
                    strSubstring = strSubstring.substring(num.intValue(), num2.intValue());
                    l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
            }
        }
        String strH2 = strSubstring;
        if (cVar.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = cVar.getReplaceCharList();
            l0.o(replaceCharList, "replaceCharList");
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            l0.o(strH2, "string");
            strH2 = e0.h2(strH2, (char) num3.intValue(), (char) num4.intValue(), false, 4, null);
        }
        String strH3 = strH2;
        bp.a.e.c.EnumC0043c operation = cVar.getOperation();
        if (operation == null) {
            operation = bp.a.e.c.EnumC0043c.NONE;
        }
        int i11 = b.f3381a[operation.ordinal()];
        if (i11 == 2) {
            l0.o(strH3, "string");
            strH3 = e0.h2(strH3, jq.m0.f8865c, n1.e.f11183c, false, 4, null);
        } else if (i11 == 3) {
            if (strH3.length() >= 2) {
                l0.o(strH3, "string");
                strH3 = strH3.substring(1, strH3.length() - 1);
                l0.o(strH3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String str = strH3;
            l0.o(str, "string");
            strH3 = e0.h2(str, jq.m0.f8865c, n1.e.f11183c, false, 4, null);
        }
        l0.o(strH3, "string");
        return strH3;
    }

    @l
    public final bp.a.e d() {
        return this.f3377a;
    }
}
