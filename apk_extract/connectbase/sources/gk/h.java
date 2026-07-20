package gk;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final String f6619a = "abcdefghijklmnopqrstuvwxyz0123456789+/=-";

    public static final class a extends kn.n0 implements jn.l<dk.b, String> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final String invoke(@os.l dk.b bVar) {
            kn.l0.p(bVar, "it");
            return h.h(bVar);
        }
    }

    public static final class b extends kn.n0 implements jn.l<dk.b, String> {
        final /* synthetic */ char[] $dictionaryCharacters;
        final /* synthetic */ int $length;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10, char[] cArr) {
            super(1);
            this.$length = i10;
            this.$dictionaryCharacters = cArr;
        }

        @Override // jn.l
        @os.m
        public final String invoke(@os.l dk.b bVar) {
            kn.l0.p(bVar, "it");
            return h.i(rn.f.Default, this.$length, this.$dictionaryCharacters);
        }
    }

    public static final void c(@os.l i.b bVar, @os.l String str) {
        kn.l0.p(bVar, "<this>");
        kn.l0.p(str, "name");
        bVar.n(str, a.INSTANCE);
    }

    public static /* synthetic */ void d(i.b bVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "CallId";
        }
        c(bVar, str);
    }

    public static final List<Character> e(String str) {
        char[] cArrB = fl.r.b(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = cArrB.length;
        int i10 = 0;
        while (i10 < length) {
            char c10 = cArrB[i10];
            i10++;
            Character chValueOf = Character.valueOf(c10);
            Object arrayList = linkedHashMap.get(chValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(chValueOf, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c10));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((List) entry.getValue()).size() > 1) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return nm.h0.q5(linkedHashMap2.keySet());
    }

    public static final void f(@os.l g.a aVar, int i10, @os.l String str) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(str, "dictionary");
        if (i10 < 1) {
            throw new IllegalArgumentException(kn.l0.C("Call id should be at least one characters length: ", Integer.valueOf(i10)).toString());
        }
        if (str.length() <= 1) {
            throw new IllegalArgumentException("Dictionary should consist of several different characters");
        }
        char[] cArrP5 = nm.h0.P5(nm.r.O8(fl.r.b(str)));
        if (cArrP5.length != str.length()) {
            throw new IllegalArgumentException(kn.l0.C("Dictionary should not contain duplicates, found: ", e(str)).toString());
        }
        aVar.a(new b(i10, cArrP5));
    }

    public static /* synthetic */ void g(g.a aVar, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 64;
        }
        if ((i11 & 2) != 0) {
            str = f6619a;
        }
        f(aVar, i10, str);
    }

    @os.m
    public static final String h(@os.l dk.b bVar) {
        kn.l0.p(bVar, "<this>");
        fl.c cVarC = bVar.c();
        g.f6599d.getClass();
        return (String) cVarC.b(g.f6601f);
    }

    public static final String i(rn.f fVar, int i10, char[] cArr) {
        char[] cArr2 = new char[i10];
        int length = cArr.length;
        for (int i11 = 0; i11 < i10; i11++) {
            cArr2[i11] = cArr[fVar.nextInt(length)];
        }
        return new String(cArr2);
    }

    public static final boolean j(String str, char[] cArr) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (nm.p.x(cArr, str.charAt(i10), 0, cArr.length) < 0) {
                return false;
            }
            i10 = i11;
        }
        return true;
    }
}
