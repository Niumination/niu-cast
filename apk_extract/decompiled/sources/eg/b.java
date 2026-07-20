package eg;

import dg.c;
import dg.d;
import dg.e;
import dg.f;
import dg.h;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static final a a(c cVar, int i8, boolean z2) {
        int i9 = 0;
        if (cVar instanceof h) {
            return new a(Regex.INSTANCE.escape(((h) cVar).f4468a), 0, 6);
        }
        if (cVar instanceof f) {
            ((f) cVar).getClass();
            return new a("\\d", 0, 6);
        }
        if (!(cVar instanceof dg.b)) {
            if (cVar instanceof dg.a) {
                if (cVar instanceof dg.a) {
                    a aVarA = a(((dg.a) cVar).f4463a, i8, true);
                    return new a(a1.a.s(new StringBuilder(), aVarA.f4954b, '+'), aVarA.f4953a, 4);
                }
                throw new IllegalStateException(("Unsupported simple grammar element: " + cVar).toString());
            }
            if (!(cVar instanceof e)) {
                throw new IllegalStateException(("Unsupported grammar element: " + cVar).toString());
            }
            StringBuilder sb2 = new StringBuilder("[");
            e eVar = (e) cVar;
            sb2.append(eVar.f4465a);
            sb2.append('-');
            sb2.append(eVar.f4466b);
            sb2.append(']');
            return new a(sb2.toString(), 0, 6);
        }
        StringBuilder sb3 = new StringBuilder();
        int i10 = z2 ? i8 + 1 : i8;
        for (Object obj : ((dg.b) cVar).a()) {
            int i11 = i9 + 1;
            if (i9 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            a aVarA2 = a((c) obj, i10, true);
            if (i9 != 0 && (cVar instanceof d)) {
                sb3.append("|");
            }
            sb3.append(aVarA2.f4954b);
            i10 += aVarA2.f4953a;
            i9 = i11;
        }
        int i12 = i10 - i8;
        if (z2) {
            i12--;
        }
        String string = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new a(string, i12, z2);
    }
}
