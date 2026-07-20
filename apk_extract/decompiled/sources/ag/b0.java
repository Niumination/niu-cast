package ag;

import java.util.List;
import java.util.Set;
import k3.c1;
import k3.d1;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f755a = SetsKt.setOf((Object[]) new Character[]{'/', '?', '#', '@'});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final se.e f756b;

    static {
        List from = CollectionsKt.listOf((Object[]) new String[]{"HTTP/1.0", "HTTP/1.1"});
        Intrinsics.checkNotNullParameter(from, "from");
        f756b = c1.a(from, new b(3), new q(4));
    }

    public static final void a(bg.c cVar, char c9) {
        throw new n0("Character with code " + (c9 & 255) + " is not allowed in header names, \n" + ((Object) cVar));
    }

    public static final int b(bg.c text, bg.h range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int i8 = range.f1325b;
        for (int i9 = range.f1324a; i9 < i8; i9++) {
            char cCharAt = text.charAt(i9);
            if (cCharAt == ':' && i9 != range.f1324a) {
                range.f1324a = i9 + 1;
                return i9;
            }
            if (Intrinsics.compare((int) cCharAt, 32) <= 0 || StringsKt__StringsKt.contains$default("\"(),/:;<=>?@[\\]{}", cCharAt, false, 2, (Object) null)) {
                int i10 = range.f1324a;
                if (cCharAt == ':') {
                    throw new n0("Empty header names are not allowed as per RFC7230.");
                }
                if (i9 == i10) {
                    throw new n0("Multiline headers via line folding is not supported since it is deprecated as per RFC7230.");
                }
                a(text, cCharAt);
                throw null;
            }
        }
        throw new n0("No colon in HTTP header in " + text.subSequence(range.f1324a, range.f1325b).toString() + " in builder: \n" + ((Object) text));
    }

    public static final void c(bg.c text, bg.h range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int i8 = range.f1324a;
        int i9 = range.f1325b;
        Intrinsics.checkNotNullParameter(text, "text");
        while (i8 < i9) {
            char cCharAt = text.charAt(i8);
            if (!CharsKt.isWhitespace(cCharAt) && cCharAt != '\t') {
                break;
            } else {
                i8++;
            }
        }
        if (i8 >= i9) {
            range.f1324a = i9;
            return;
        }
        int i10 = i8;
        int i11 = i10;
        while (i10 < i9) {
            char cCharAt2 = text.charAt(i10);
            if (cCharAt2 != '\t') {
                if (cCharAt2 == '\n' || cCharAt2 == '\r') {
                    a(text, cCharAt2);
                    throw null;
                }
                if (cCharAt2 != ' ') {
                    i11 = i10;
                }
            }
            i10++;
        }
        range.f1324a = i8;
        range.f1325b = i11 + 1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0072 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:25:0x0080 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:23:0x0078, B:25:0x0080, B:29:0x0088, B:32:0x0093, B:19:0x0062, B:33:0x00b0, B:34:0x00b7, B:35:0x00b8, B:37:0x00c2), top: B:41:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0088 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:23:0x0078, B:25:0x0080, B:29:0x0088, B:32:0x0093, B:19:0x0062, B:33:0x00b0, B:34:0x00b7, B:35:0x00b8, B:37:0x00c2), top: B:41:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0093 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:23:0x0078, B:25:0x0080, B:29:0x0088, B:32:0x0093, B:19:0x0062, B:33:0x00b0, B:34:0x00b7, B:35:0x00b8, B:37:0x00c2), top: B:41:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b8 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:23:0x0078, B:25:0x0080, B:29:0x0088, B:32:0x0093, B:19:0x0062, B:33:0x00b0, B:34:0x00b7, B:35:0x00b8, B:37:0x00c2), top: B:41:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:23:0x0078, B:25:0x0080, B:29:0x0088, B:32:0x0093, B:19:0x0062, B:33:0x00b0, B:34:0x00b7, B:35:0x00b8, B:37:0x00c2), top: B:41:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0073 -> B:41:0x0078). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object d(jh.o r18, bg.c r19, bg.h r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.b0.d(jh.o, bg.c, bg.h, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final zf.x e(bg.c text, bg.h range) {
        d1.b(text, range);
        zf.x xVar = (zf.x) CollectionsKt.singleOrNull(se.e.z(bg.g.f1321a, text, range.f1324a, range.f1325b, false, new q(3), 8));
        if (xVar != null) {
            range.f1324a = xVar.f11559a.length() + range.f1324a;
            return xVar;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int iA = d1.a(text, range);
        CharSequence charSequenceSubSequence = text.subSequence(range.f1324a, iA);
        range.f1324a = iA;
        return new zf.x(charSequenceSubSequence.toString());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x0086  */
    /* JADX WARN: Code duplicated, block: B:31:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0092 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x009a A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b0 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bd A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d0 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d6 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00dc A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fe A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0106 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010e A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:13:0x0039, B:52:0x00f0, B:55:0x00f6, B:29:0x0089, B:32:0x0092, B:34:0x009a, B:42:0x00c3, B:44:0x00d0, B:46:0x00d6, B:48:0x00dc, B:57:0x00fe, B:58:0x0105, B:59:0x0106, B:60:0x010d, B:61:0x010e, B:62:0x0130, B:38:0x00b0, B:40:0x00b8, B:41:0x00bd, B:25:0x0075), top: B:68:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0131  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [ag.z] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0086 -> B:29:0x0089). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object f(jh.k r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ag.b0.f(jh.k, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00bf A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:13:0x0036, B:37:0x00bb, B:39:0x00bf, B:41:0x00c7), top: B:52:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object g(jh.o oVar, ContinuationImpl continuationImpl) throws Throwable {
        a0 a0Var;
        bg.c cVar;
        jh.o oVar2;
        bg.h hVar;
        bg.c cVar2;
        CharSequence charSequence;
        int i8;
        CharSequence charSequence2;
        v vVar;
        v vVar2;
        if (continuationImpl instanceof a0) {
            a0Var = (a0) continuationImpl;
            int i9 = a0Var.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                a0Var.label = i9 - Integer.MIN_VALUE;
            } else {
                a0Var = new a0(continuationImpl);
            }
        } else {
            a0Var = new a0(continuationImpl);
        }
        Object obj = a0Var.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = a0Var.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            bg.c cVar3 = new bg.c();
            bg.h hVar2 = new bg.h();
            try {
                a0Var.L$0 = oVar;
                a0Var.L$1 = cVar3;
                a0Var.L$2 = hVar2;
                a0Var.label = 1;
                Object objM = jh.g0.m(oVar, cVar3, 8192, a0Var);
                if (objM == coroutine_suspended) {
                    return coroutine_suspended;
                }
                oVar2 = oVar;
                hVar = hVar2;
                cVar2 = cVar3;
                obj = objM;
            } catch (Throwable th2) {
                th = th2;
                cVar = cVar3;
                cVar.e();
                throw th;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i11 = a0Var.I$0;
                CharSequence charSequence3 = (CharSequence) a0Var.L$2;
                CharSequence charSequence4 = (CharSequence) a0Var.L$1;
                cVar = (bg.c) a0Var.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i8 = i11;
                    charSequence2 = charSequence3;
                    charSequence = charSequence4;
                    vVar = (v) obj;
                    if (vVar == null) {
                        vVar2 = new v(cVar);
                    } else {
                        vVar2 = vVar;
                    }
                    return new q0(charSequence, i8, charSequence2, vVar2, cVar);
                } catch (Throwable th3) {
                    th = th3;
                    cVar.e();
                    throw th;
                }
            }
            hVar = (bg.h) a0Var.L$2;
            cVar2 = (bg.c) a0Var.L$1;
            oVar2 = (jh.o) a0Var.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
                cVar = cVar2;
                cVar.e();
                throw th;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            return null;
        }
        hVar.f1325b = cVar2.f1319i;
        String strI = i(cVar2, hVar);
        int iH = h(cVar2, hVar);
        d1.b(cVar2, hVar);
        CharSequence charSequenceSubSequence = cVar2.subSequence(hVar.f1324a, hVar.f1325b);
        hVar.f1324a = hVar.f1325b;
        a0Var.L$0 = cVar2;
        a0Var.L$1 = strI;
        a0Var.L$2 = charSequenceSubSequence;
        a0Var.I$0 = iH;
        a0Var.label = 2;
        Object objD = d(oVar2, cVar2, hVar, a0Var);
        if (objD == coroutine_suspended) {
            return coroutine_suspended;
        }
        charSequence = strI;
        cVar = cVar2;
        i8 = iH;
        charSequence2 = charSequenceSubSequence;
        obj = objD;
        vVar = (v) obj;
        if (vVar == null) {
            vVar2 = new v(cVar);
        } else {
            vVar2 = vVar;
        }
        return new q0(charSequence, i8, charSequence2, vVar2, cVar);
    }

    public static final int h(bg.c cVar, bg.h hVar) {
        d1.b(cVar, hVar);
        int i8 = hVar.f1325b;
        int i9 = 0;
        for (int i10 = hVar.f1324a; i10 < i8; i10++) {
            char cCharAt = cVar.charAt(i10);
            if (cCharAt == ' ') {
                if (i9 >= 100 && i9 <= 999) {
                    i8 = i10;
                    break;
                }
                throw new n0("Status-code must be 3-digit. Status received: " + i9 + '.');
            }
            if ('0' > cCharAt || cCharAt >= ':') {
                throw new NumberFormatException("Illegal digit " + cCharAt + " in status code " + cVar.subSequence(hVar.f1324a, d1.a(cVar, hVar)).toString());
            }
            i9 = (i9 * 10) + (cCharAt - '0');
        }
        hVar.f1324a = i8;
        return i9;
    }

    public static final String i(bg.c text, bg.h range) {
        d1.b(text, range);
        int i8 = range.f1324a;
        int i9 = range.f1325b;
        if (i8 >= i9) {
            throw new IllegalStateException(("Failed to parse version: " + ((Object) text)).toString());
        }
        String str = (String) CollectionsKt.singleOrNull(se.e.z(f756b, text, i8, i9, false, new q(2), 8));
        if (str != null) {
            range.f1324a = str.length() + range.f1324a;
            return str;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int iA = d1.a(text, range);
        CharSequence charSequenceSubSequence = text.subSequence(range.f1324a, iA);
        range.f1324a = iA;
        throw new n0("Unsupported HTTP version: " + ((Object) charSequenceSubSequence));
    }

    public static final void j(bg.b bVar) {
        if (StringsKt__StringsKt.endsWith$default((CharSequence) bVar, (CharSequence) ":", false, 2, (Object) null)) {
            throw new n0("Host header with ':' should contains port: " + ((Object) bVar));
        }
        for (int i8 = 0; i8 < bVar.length(); i8++) {
            Character chValueOf = Character.valueOf(bVar.charAt(i8));
            Set set = f755a;
            if (set.contains(chValueOf)) {
                throw new n0("Host cannot contain any of the following symbols: " + set);
            }
        }
    }
}
