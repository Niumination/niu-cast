package kf;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import zf.r;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends UnsupportedOperationException {
    private final String message;

    public d(wf.b response, KClass<?> from, KClass<?> to) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        StringBuilder sb2 = new StringBuilder("\n        Expected response body of the type '");
        sb2.append(to);
        sb2.append("' but was '");
        sb2.append(from);
        sb2.append("'\n        In response from `");
        Intrinsics.checkNotNullParameter(response, "<this>");
        sb2.append(response.b().d().getUrl());
        sb2.append("`\n        Response status `");
        sb2.append(response.h());
        sb2.append("`\n        Response header `ContentType: ");
        r rVarA = response.a();
        String[] strArr = v.f11551a;
        sb2.append(rVarA.get("Content-Type"));
        sb2.append("` \n        Request header `Accept: ");
        Intrinsics.checkNotNullParameter(response, "<this>");
        sb2.append(response.b().d().a().get("Accept"));
        sb2.append("`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
        this.message = StringsKt.trimIndent(sb2.toString());
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
