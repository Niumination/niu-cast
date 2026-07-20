package xg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import m3.c6;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f10927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mg.r f10928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10930d;
    public final boolean e;
    public final g0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f10931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f10932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10933i;

    public c0(n0 routing, mg.r call, ArrayList tracers) throws ug.a {
        Intrinsics.checkNotNullParameter(routing, "routing");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(tracers, "tracers");
        this.f10927a = routing;
        this.f10928b = call;
        this.f10929c = tracers;
        this.e = StringsKt__StringsKt.endsWith$default((CharSequence) m3.k.c(call.g()), '/', false, 2, (Object) null);
        this.f10931g = new ArrayList(16);
        this.f10932h = n.f10968a;
        try {
            List listB = b(m3.k.c(call.g()));
            this.f10930d = listB;
            this.f = tracers.isEmpty() ? null : new g0(call, listB);
        } catch (zf.k0 e) {
            throw new ug.a("Url decode failed for " + m3.k.a(this.f10928b.g()), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:138:0x02bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:141:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:143:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x02bd -> B:139:0x02c0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(xg.u r28, int r29, java.util.ArrayList r30, double r31, kotlin.coroutines.jvm.internal.ContinuationImpl r33) {
        /*
            Method dump skipped, instruction units count: 842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xg.c0.a(xg.u, int, java.util.ArrayList, double, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final List b(String str) {
        if (str.length() == 0 || Intrinsics.areEqual(str, "/")) {
            return CollectionsKt.emptyList();
        }
        int length = str.length();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (str.charAt(i10) == '/') {
                i9++;
            }
        }
        ArrayList arrayList = new ArrayList(i9);
        int i11 = 0;
        while (i8 < length) {
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', i11, false, 4, (Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = length;
            }
            if (iIndexOf$default != i11) {
                arrayList.add(zf.d.c(str, i11, iIndexOf$default, 4));
            }
            i11 = iIndexOf$default + 1;
            i8 = iIndexOf$default;
        }
        zg.a aVar = d.f10934a;
        mg.r rVar = this.f10928b;
        Intrinsics.checkNotNullParameter(rVar, "<this>");
        zg.h hVarI = rVar.i();
        hVarI.getClass();
        zg.a key = d.f10934a;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!hVarI.c().containsKey(key) && StringsKt__StringsJVMKt.endsWith$default(str, "/", false, 2, null)) {
            arrayList.add("");
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object c(ContinuationImpl continuationImpl) {
        b0 b0Var;
        f0 result;
        zf.z zVar;
        if (continuationImpl instanceof b0) {
            b0Var = (b0) continuationImpl;
            int i8 = b0Var.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                b0Var.label = i8 - Integer.MIN_VALUE;
            } else {
                b0Var = new b0(this, continuationImpl);
            }
        } else {
            b0Var = new b0(this, continuationImpl);
        }
        b0 b0Var2 = b0Var;
        Object obj = b0Var2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = b0Var2.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            b0Var2.L$0 = this;
            b0Var2.label = 1;
            if (a(this.f10927a, 0, arrayList, -1.7976931348623157E308d, b0Var2) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (c0) b0Var2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ArrayList arrayList2 = this.f10931g;
        if (arrayList2.isEmpty()) {
            l lVar = this.f10932h;
            if (lVar == null || (zVar = lVar.f10964j) == null) {
                zVar = zf.z.p;
            }
            result = new d0(this.f10927a, "No matched subtrees found", zVar);
        } else {
            zf.f0 f0VarA = c6.a();
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            double dMin = Double.MAX_VALUE;
            if (lastIndex >= 0) {
                int i10 = 0;
                while (true) {
                    Object obj2 = arrayList2.get(i10);
                    Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
                    e0 e0Var = (e0) obj2;
                    f0VarA.e(e0Var.f10938b);
                    double d7 = e0Var.f10939c;
                    if (d7 == -1.0d) {
                        d7 = 1.0d;
                    }
                    dMin = Math.min(dMin, d7);
                    if (i10 == lastIndex) {
                        break;
                    }
                    i10++;
                }
            }
            result = new e0(((e0) CollectionsKt.last((List) arrayList2)).f10943a, f0VarA.build(), dMin);
        }
        g0 g0Var = this.f;
        if (g0Var != null) {
            Intrinsics.checkNotNullParameter(result, "result");
            g0Var.f10950d = result;
        }
        if (g0Var != null) {
            Iterator it = this.f10929c.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(g0Var);
            }
        }
        return result;
    }
}
