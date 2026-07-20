package pf;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class j1 extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient wf.b f8852a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(wf.b response, String cachedResponseText) {
        super("Bad response: " + response + ". Text: \"" + cachedResponseText + Typography.quote);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(cachedResponseText, "cachedResponseText");
        this.f8852a = response;
    }

    public final wf.b getResponse() {
        return this.f8852a;
    }
}
