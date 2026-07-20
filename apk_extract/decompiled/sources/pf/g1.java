package pf;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 extends j1 {
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(wf.b response, String cachedResponseText) {
        super(response, cachedResponseText);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cachedResponseText, "cachedResponseText");
        this.message = "Unhandled redirect: " + response.b().d().X().f11559a + ' ' + response.b().d().getUrl() + ". Status: " + response.h() + ". Text: \"" + cachedResponseText + Typography.quote;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
