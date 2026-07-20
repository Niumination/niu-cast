package zf;

import java.util.LinkedHashMap;
import k3.q1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final se.e f11491a;

    static {
        Intrinsics.checkNotNullParameter("\\d", "value");
        dg.f grammar = new dg.f();
        Intrinsics.checkNotNullParameter(grammar, "grammar");
        dg.g gVarC = q1.c(new dg.a(grammar), ".");
        Intrinsics.checkNotNullParameter("\\d", "value");
        dg.f grammar2 = new dg.f();
        Intrinsics.checkNotNullParameter(grammar2, "grammar");
        dg.g gVarC2 = q1.c(q1.b(gVarC, new dg.a(grammar2)), ".");
        Intrinsics.checkNotNullParameter("\\d", "value");
        dg.f grammar3 = new dg.f();
        Intrinsics.checkNotNullParameter(grammar3, "grammar");
        dg.g gVarC3 = q1.c(q1.b(gVarC2, new dg.a(grammar3)), ".");
        Intrinsics.checkNotNullParameter("\\d", "value");
        dg.f grammar4 = new dg.f();
        Intrinsics.checkNotNullParameter(grammar4, "grammar");
        dg.g gVarB = q1.b(gVarC3, new dg.a(grammar4));
        Intrinsics.checkNotNullParameter("\\d", "value");
        dg.d dVarA = q1.a(q1.a(new dg.f(), new dg.e('A', 'F')), new dg.e('a', 'f'));
        Intrinsics.checkNotNullParameter(dVarA, "<this>");
        Intrinsics.checkNotNullParameter(":", "value");
        dg.d grammar5 = q1.a(dVarA, new dg.h(":"));
        Intrinsics.checkNotNullParameter(grammar5, "grammar");
        dg.a grammar6 = new dg.a(grammar5);
        Intrinsics.checkNotNullParameter("[", "<this>");
        Intrinsics.checkNotNullParameter(grammar6, "grammar");
        dg.d dVarA2 = q1.a(gVarB, q1.c(q1.b(new dg.h("["), grammar6), "]"));
        Intrinsics.checkNotNullParameter(dVarA2, "<this>");
        f11491a = new se.e(new Regex(eg.b.a(dVarA2, 1, false).f4954b), new LinkedHashMap());
    }
}
