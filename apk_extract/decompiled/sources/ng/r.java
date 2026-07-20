package ng;

import af.r5;
import ag.o0;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import m3.c6;
import m3.d6;
import zf.f0;
import zf.g0;
import zf.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends qg.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o0 f8270d;
    public final Lazy e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final jh.o f8271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ag.d f8272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f8274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r5 f8275l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(b call, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, jh.o input, o0 request) {
        super(call);
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f8270d = request;
        final int i8 = 0;
        this.e = LazyKt.lazy(new Function0(this) { // from class: ng.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r f8269b;

            {
                this.f8269b = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2 */
            /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
            /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ?? EmptyList;
                switch (i8) {
                    case 0:
                        return new vg.f(this.f8269b);
                    case 1:
                        r rVar = this.f8269b;
                        zf.d0 parameters = rVar.h();
                        Intrinsics.checkNotNullParameter(rVar, "<this>");
                        Intrinsics.checkNotNullParameter(parameters, "parameters");
                        f0 f0VarA = c6.a();
                        for (String str : rVar.h().names()) {
                            List listB = parameters.b(str);
                            if (listB != null) {
                                List list = listB;
                                EmptyList = new ArrayList(CollectionsKt.i(list));
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    EmptyList.add(zf.d.d((String) it.next(), 0, 0, true, 11));
                                }
                            } else {
                                EmptyList = 0;
                            }
                            if (EmptyList == 0) {
                                EmptyList = CollectionsKt.emptyList();
                            }
                            f0VarA.c(zf.d.d(str, 0, 0, false, 15), (Iterable) EmptyList);
                        }
                        return new s((g0) f0VarA.build());
                    default:
                        String string = this.f8269b.f8270d.f776d.toString();
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, '?', 0, false, 6, (Object) null);
                        Integer numValueOf = Integer.valueOf(iIndexOf$default);
                        if (iIndexOf$default == -1) {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            return d6.b(numValueOf.intValue() + 1, 4, string);
                        }
                        zf.d0.f11496b.getClass();
                        return zf.m.f11519c;
                }
            }
        });
        this.f8271h = input;
        this.f8272i = new ag.d(request.f797a);
        final int i9 = 1;
        this.f8273j = LazyKt.lazy(new Function0(this) { // from class: ng.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r f8269b;

            {
                this.f8269b = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2 */
            /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
            /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ?? EmptyList;
                switch (i9) {
                    case 0:
                        return new vg.f(this.f8269b);
                    case 1:
                        r rVar = this.f8269b;
                        zf.d0 parameters = rVar.h();
                        Intrinsics.checkNotNullParameter(rVar, "<this>");
                        Intrinsics.checkNotNullParameter(parameters, "parameters");
                        f0 f0VarA = c6.a();
                        for (String str : rVar.h().names()) {
                            List listB = parameters.b(str);
                            if (listB != null) {
                                List list = listB;
                                EmptyList = new ArrayList(CollectionsKt.i(list));
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    EmptyList.add(zf.d.d((String) it.next(), 0, 0, true, 11));
                                }
                            } else {
                                EmptyList = 0;
                            }
                            if (EmptyList == 0) {
                                EmptyList = CollectionsKt.emptyList();
                            }
                            f0VarA.c(zf.d.d(str, 0, 0, false, 15), (Iterable) EmptyList);
                        }
                        return new s((g0) f0VarA.build());
                    default:
                        String string = this.f8269b.f8270d.f776d.toString();
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, '?', 0, false, 6, (Object) null);
                        Integer numValueOf = Integer.valueOf(iIndexOf$default);
                        if (iIndexOf$default == -1) {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            return d6.b(numValueOf.intValue() + 1, 4, string);
                        }
                        zf.d0.f11496b.getClass();
                        return zf.m.f11519c;
                }
            }
        });
        final int i10 = 2;
        this.f8274k = LazyKt.lazy(new Function0(this) { // from class: ng.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r f8269b;

            {
                this.f8269b = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2 */
            /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
            /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ?? EmptyList;
                switch (i10) {
                    case 0:
                        return new vg.f(this.f8269b);
                    case 1:
                        r rVar = this.f8269b;
                        zf.d0 parameters = rVar.h();
                        Intrinsics.checkNotNullParameter(rVar, "<this>");
                        Intrinsics.checkNotNullParameter(parameters, "parameters");
                        f0 f0VarA = c6.a();
                        for (String str : rVar.h().names()) {
                            List listB = parameters.b(str);
                            if (listB != null) {
                                List list = listB;
                                EmptyList = new ArrayList(CollectionsKt.i(list));
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    EmptyList.add(zf.d.d((String) it.next(), 0, 0, true, 11));
                                }
                            } else {
                                EmptyList = 0;
                            }
                            if (EmptyList == 0) {
                                EmptyList = CollectionsKt.emptyList();
                            }
                            f0VarA.c(zf.d.d(str, 0, 0, false, 15), (Iterable) EmptyList);
                        }
                        return new s((g0) f0VarA.build());
                    default:
                        String string = this.f8269b.f8270d.f776d.toString();
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, '?', 0, false, 6, (Object) null);
                        Integer numValueOf = Integer.valueOf(iIndexOf$default);
                        if (iIndexOf$default == -1) {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            return d6.b(numValueOf.intValue() + 1, 4, string);
                        }
                        zf.d0.f11496b.getClass();
                        return zf.m.f11519c;
                }
            }
        });
        String string = request.e.toString();
        String string2 = request.f776d.toString();
        ag.v vVar = request.f797a;
        String[] strArr = zf.v.f11551a;
        bg.b bVarB = vVar.b("Host");
        if (bVarB != null) {
            bVarB.toString();
        }
        zf.x xVar = zf.x.f11553b;
        String method = request.f775c.f11559a;
        Intrinsics.checkNotNullParameter(method, "method");
        zf.x xVar2 = zf.x.f11553b;
        if (!Intrinsics.areEqual(method, xVar2.f11559a)) {
            xVar2 = zf.x.f11554c;
            if (!Intrinsics.areEqual(method, xVar2.f11559a)) {
                xVar2 = zf.x.f11555d;
                if (!Intrinsics.areEqual(method, xVar2.f11559a)) {
                    xVar2 = zf.x.e;
                    if (!Intrinsics.areEqual(method, xVar2.f11559a)) {
                        xVar2 = zf.x.f;
                        if (!Intrinsics.areEqual(method, xVar2.f11559a)) {
                            xVar2 = zf.x.f11556g;
                            if (!Intrinsics.areEqual(method, xVar2.f11559a)) {
                                xVar2 = zf.x.f11557h;
                                if (!Intrinsics.areEqual(method, xVar2.f11559a)) {
                                    xVar2 = new zf.x(method);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f8275l = new r5(inetSocketAddress, inetSocketAddress2, string, string2, xVar2);
    }

    @Override // vg.c
    public final vg.f f() {
        return (vg.f) this.e.getValue();
    }

    @Override // vg.c
    public final i0 g() {
        return this.f8275l;
    }

    @Override // vg.c
    public final zf.d0 h() {
        return (zf.d0) this.f8274k.getValue();
    }

    @Override // vg.c
    public final zf.d0 s() {
        return (zf.d0) this.f8273j.getValue();
    }
}
