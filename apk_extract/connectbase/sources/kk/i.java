package kk;

import el.b0;
import ik.p0;
import java.util.Set;
import jq.h0;
import kn.l0;
import kn.n0;
import lm.d1;
import nm.o1;
import nm.y;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9223a = 8192;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9224b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9225c = 999;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Set<Character> f9226d = o1.u(Character.valueOf(b0.f4502a), '?', '#', '@');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final lk.a<String> f9227e = lk.a.f10100b.a(y.O("HTTP/1.0", "HTTP/1.1"));

    @xm.f(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0}, l = {87}, m = "parseHeaders", n = {"builder"}, s = {"L$0"})
    public static final class a extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public a(um.d<? super a> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.i(null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 0}, l = {102}, m = "parseHeaders", n = {"input", "builder", "range", "headers"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class b extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.h(null, null, null, this);
        }
    }

    public static final class c extends n0 implements jn.p<Character, Integer, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(2);
        }

        @os.l
        public final Boolean invoke(char c10, int i10) {
            return Boolean.valueOf(c10 == ' ');
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch2, Integer num) {
            return invoke(ch2.charValue(), num.intValue());
        }
    }

    @xm.f(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {31, 46}, m = "parseRequest", n = {"input", "builder", "range", "builder", "method", "uri", lb.f.f9782f}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class d extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.m(null, this);
        }
    }

    @xm.f(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {64, 73}, m = "parseResponse", n = {"input", "builder", "range", "builder", lb.f.f9782f, "statusText", "statusCode"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    public static final class e extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.n(null, this);
        }
    }

    public static final class f extends n0 implements jn.p<Character, Integer, Boolean> {
        public static final f INSTANCE = new f();

        public f() {
            super(2);
        }

        @os.l
        public final Boolean invoke(char c10, int i10) {
            return Boolean.valueOf(c10 == ' ');
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch2, Integer num) {
            return invoke(ch2.charValue(), num.intValue());
        }
    }

    public static final Void a(CharSequence charSequence, char c10) throws l {
        throw new l("Character with code " + (c10 & 255) + " is not allowed in header names, \n" + ((Object) charSequence));
    }

    public static /* synthetic */ void b() {
    }

    public static final boolean c(char c10) {
        return l0.t(c10, 32) <= 0 || h0.S2("\"(),/:;<=>?@[\\]{}", c10, false, 2, null);
    }

    public static final Void d(CharSequence charSequence, lk.h hVar) throws l {
        throw new l("No colon in HTTP header in " + charSequence.subSequence(hVar.f10126a, hVar.f10127b).toString() + " in builder: \n" + ((Object) charSequence));
    }

    public static final int e(@os.l lk.c cVar, @os.l lk.h hVar) throws l {
        l0.p(cVar, "text");
        l0.p(hVar, "range");
        int i10 = hVar.f10127b;
        for (int i11 = hVar.f10126a; i11 < i10; i11++) {
            char cK = cVar.k(i11);
            if (cK == ':' && i11 != hVar.f10126a) {
                hVar.f10126a = i11 + 1;
                return i11;
            }
            if (c(cK)) {
                f(cVar, i11, hVar.f10126a, cK);
                throw new lm.y();
            }
        }
        d(cVar, hVar);
        throw new lm.y();
    }

    public static final Void f(lk.c cVar, int i10, int i11, char c10) throws l {
        if (c10 == ':') {
            throw new l("Empty header names are not allowed as per RFC7230.");
        }
        if (i10 == i11) {
            throw new l("Multiline headers via line folding is not supported since it is deprecated as per RFC7230.");
        }
        a(cVar, c10);
        throw new lm.y();
    }

    public static final void g(@os.l lk.c cVar, @os.l lk.h hVar) throws l {
        l0.p(cVar, "text");
        l0.p(hVar, "range");
        int i10 = hVar.f10126a;
        int i11 = hVar.f10127b;
        int iD = lk.i.d(cVar, i10, i11);
        if (iD >= i11) {
            hVar.f10126a = i11;
            return;
        }
        int i12 = iD;
        int i13 = i12;
        while (i12 < i11) {
            char cK = cVar.k(i12);
            if (cK != '\t' && cK != ' ') {
                if (cK == '\r' || cK == '\n') {
                    a(cVar, cK);
                    throw new lm.y();
                }
                i13 = i12;
            }
            i12++;
        }
        hVar.f10126a = iD;
        hVar.f10127b = i13 + 1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0070 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    /* JADX WARN: Code duplicated, block: B:25:0x007e A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:23:0x0076, B:25:0x007e, B:29:0x0086, B:31:0x008f, B:34:0x009d, B:36:0x00a3, B:39:0x00b9, B:40:0x00c8, B:43:0x00cc, B:19:0x0060, B:44:0x00ea, B:45:0x00f1), top: B:48:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0086 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:23:0x0076, B:25:0x007e, B:29:0x0086, B:31:0x008f, B:34:0x009d, B:36:0x00a3, B:39:0x00b9, B:40:0x00c8, B:43:0x00cc, B:19:0x0060, B:44:0x00ea, B:45:0x00f1), top: B:48:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:23:0x0076, B:25:0x007e, B:29:0x0086, B:31:0x008f, B:34:0x009d, B:36:0x00a3, B:39:0x00b9, B:40:0x00c8, B:43:0x00cc, B:19:0x0060, B:44:0x00ea, B:45:0x00f1), top: B:48:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0071 -> B:48:0x0076). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object h(@os.l pl.k r18, @os.l lk.c r19, @os.l lk.h r20, @os.l um.d<? super kk.f> r21) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.i.h(pl.k, lk.c, lk.h, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @os.m
    public static final Object i(@os.l pl.k kVar, @os.l um.d<? super kk.f> dVar) {
        a aVar;
        lk.c cVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        a aVar2 = aVar;
        Object obj = aVar2.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i11 = aVar2.label;
        if (i11 == 0) {
            d1.n(obj);
            lk.c cVar2 = new lk.c(null, 1, null);
            aVar2.L$0 = cVar2;
            aVar2.label = 1;
            Object objJ = j(kVar, cVar2, null, aVar2, 4, null);
            if (objJ == aVar3) {
                return aVar3;
            }
            obj = objJ;
            cVar = cVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cVar = (lk.c) aVar2.L$0;
            d1.n(obj);
        }
        kk.f fVar = (kk.f) obj;
        return fVar == null ? new kk.f(cVar) : fVar;
    }

    public static /* synthetic */ Object j(pl.k kVar, lk.c cVar, lk.h hVar, um.d dVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            hVar = new lk.h(0, 0);
        }
        return h(kVar, cVar, hVar, dVar);
    }

    public static final p0 k(CharSequence charSequence, lk.h hVar) {
        lk.i.c(charSequence, hVar);
        p0 p0Var = (p0) nm.h0.k5(lk.a.c(lk.f.c(), charSequence, hVar.f10126a, hVar.f10127b, false, c.INSTANCE, 8, null));
        if (p0Var == null) {
            return l(charSequence, hVar);
        }
        hVar.f10126a = p0Var.f8144a.length() + hVar.f10126a;
        return p0Var;
    }

    public static final p0 l(CharSequence charSequence, lk.h hVar) {
        return new p0(lk.i.b(charSequence, hVar).toString());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0085  */
    /* JADX WARN: Code duplicated, block: B:31:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0091 A[Catch: all -> 0x003f, TryCatch #1 {all -> 0x003f, blocks: (B:13:0x0037, B:45:0x00d1, B:48:0x00d7, B:29:0x0088, B:32:0x0091, B:25:0x0074, B:35:0x009b, B:37:0x00b0, B:39:0x00b6, B:41:0x00bc, B:50:0x00df, B:51:0x00e6, B:52:0x00e7, B:53:0x00ee, B:54:0x00ef, B:55:0x0106), top: B:60:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0099  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [kk.i$d] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0085 -> B:29:0x0088). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public static final java.lang.Object m(@os.l pl.k r14, @os.l um.d<? super kk.n> r15) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kk.i.m(pl.k, um.d):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00be A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:13:0x0035, B:36:0x00ba, B:38:0x00be, B:40:0x00c6), top: B:48:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object n(@os.l pl.k kVar, @os.l um.d<? super r> dVar) throws Throwable {
        e eVar;
        lk.c cVar;
        pl.k kVar2;
        lk.h hVar;
        lk.c cVar2;
        CharSequence charSequence;
        int i10;
        CharSequence charSequence2;
        kk.f fVar;
        kk.f fVar2;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i11 = eVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                eVar.label = i11 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object obj = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = eVar.label;
        if (i12 == 0) {
            d1.n(obj);
            lk.c cVar3 = new lk.c(null, 1, null);
            lk.h hVar2 = new lk.h(0, 0);
            try {
                eVar.L$0 = kVar;
                eVar.L$1 = cVar3;
                eVar.L$2 = hVar2;
                eVar.label = 1;
                Object objO = kVar.O(cVar3, 8192, eVar);
                if (objO == aVar) {
                    return aVar;
                }
                kVar2 = kVar;
                hVar = hVar2;
                cVar2 = cVar3;
                obj = objO;
            } catch (Throwable th2) {
                th = th2;
                cVar = cVar3;
                cVar.r();
                throw th;
            }
        } else {
            if (i12 != 1) {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i13 = eVar.I$0;
                CharSequence charSequence3 = (CharSequence) eVar.L$2;
                CharSequence charSequence4 = (CharSequence) eVar.L$1;
                cVar = (lk.c) eVar.L$0;
                try {
                    d1.n(obj);
                    i10 = i13;
                    charSequence2 = charSequence3;
                    charSequence = charSequence4;
                    fVar = (kk.f) obj;
                    if (fVar == null) {
                        fVar2 = new kk.f(cVar);
                    } else {
                        fVar2 = fVar;
                    }
                    return new r(charSequence, i10, charSequence2, fVar2, cVar);
                } catch (Throwable th3) {
                    th = th3;
                    cVar.r();
                    throw th;
                }
            }
            hVar = (lk.h) eVar.L$2;
            cVar2 = (lk.c) eVar.L$1;
            kVar2 = (pl.k) eVar.L$0;
            try {
                d1.n(obj);
            } catch (Throwable th4) {
                th = th4;
                cVar = cVar2;
                cVar.r();
                throw th;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            return null;
        }
        hVar.f10127b = cVar2.f10112g;
        CharSequence charSequenceQ = q(cVar2, hVar);
        int iO = o(cVar2, hVar);
        lk.i.c(cVar2, hVar);
        CharSequence charSequenceSubSequence = cVar2.subSequence(hVar.f10126a, hVar.f10127b);
        hVar.f10126a = hVar.f10127b;
        eVar.L$0 = cVar2;
        eVar.L$1 = charSequenceQ;
        eVar.L$2 = charSequenceSubSequence;
        eVar.I$0 = iO;
        eVar.label = 2;
        Object objH = h(kVar2, cVar2, hVar, eVar);
        if (objH == aVar) {
            return aVar;
        }
        charSequence = charSequenceQ;
        cVar = cVar2;
        i10 = iO;
        charSequence2 = charSequenceSubSequence;
        obj = objH;
        fVar = (kk.f) obj;
        if (fVar == null) {
            fVar2 = new kk.f(cVar);
        } else {
            fVar2 = fVar;
        }
        return new r(charSequence, i10, charSequence2, fVar2, cVar);
    }

    public static final int o(CharSequence charSequence, lk.h hVar) throws l {
        lk.i.c(charSequence, hVar);
        int i10 = hVar.f10127b;
        int i11 = hVar.f10126a;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i11 + 1;
            char cCharAt = charSequence.charAt(i11);
            if (cCharAt == ' ') {
                if (!r(i12)) {
                    i10 = i11;
                    break;
                }
                throw new l("Status-code must be 3-digit. Status received: " + i12 + n1.e.f11183c);
            }
            if ('0' > cCharAt || cCharAt >= ':') {
                throw new NumberFormatException("Illegal digit " + cCharAt + " in status code " + charSequence.subSequence(hVar.f10126a, lk.i.a(charSequence, hVar)).toString());
            }
            i12 = (i12 * 10) + (cCharAt - '0');
            i11 = i13;
        }
        hVar.f10126a = i10;
        return i12;
    }

    public static final CharSequence p(CharSequence charSequence, lk.h hVar) {
        lk.i.c(charSequence, hVar);
        int i10 = hVar.f10126a;
        int iA = lk.i.a(charSequence, hVar);
        int i11 = iA - i10;
        if (i11 <= 0) {
            return "";
        }
        if (i11 == 1 && charSequence.charAt(i10) == '/') {
            hVar.f10126a = iA;
            return "/";
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(i10, iA);
        hVar.f10126a = iA;
        return charSequenceSubSequence;
    }

    public static final CharSequence q(CharSequence charSequence, lk.h hVar) {
        lk.i.c(charSequence, hVar);
        int i10 = hVar.f10126a;
        int i11 = hVar.f10127b;
        if (i10 >= i11) {
            throw new IllegalStateException(l0.C("Failed to parse version: ", charSequence).toString());
        }
        String str = (String) nm.h0.k5(lk.a.c(f9227e, charSequence, i10, i11, false, f.INSTANCE, 8, null));
        if (str == null) {
            return lk.i.b(charSequence, hVar);
        }
        hVar.f10126a = str.length() + hVar.f10126a;
        return str;
    }

    public static final boolean r(int i10) {
        return i10 < 100 || i10 > 999;
    }
}
