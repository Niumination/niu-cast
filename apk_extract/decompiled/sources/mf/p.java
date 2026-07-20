package mf;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zf.s;
import zf.t;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f8042a;

    static {
        String[] strArr = v.f11551a;
        f8042a = SetsKt.setOf((Object[]) new String[]{"Date", "Expires", "Last-Modified", "If-Modified-Since", "If-Unmodified-Since"});
    }

    public static final void a(t requestHeaders, cg.j content, lc.a block) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(block, "block");
        gi.a block2 = new gi.a(4, requestHeaders, content);
        Intrinsics.checkNotNullParameter(block2, "block");
        s sVar = new s();
        block2.invoke(sVar);
        sVar.o().c(new lc.a(block, 1));
        String[] strArr = v.f11551a;
        if (requestHeaders.get("User-Agent") == null && content.c().get("User-Agent") == null) {
            boolean z2 = zg.s.f11604a;
            block.invoke("User-Agent", "ktor-client");
        }
        zf.i iVarB = content.b();
        if ((iVarB == null || (string = iVarB.toString()) == null) && (string = content.c().get("Content-Type")) == null) {
            string = requestHeaders.get("Content-Type");
        }
        Long lA = content.a();
        if ((lA == null || (string2 = lA.toString()) == null) && (string2 = content.c().get("Content-Length")) == null) {
            string2 = requestHeaders.get("Content-Length");
        }
        if (string != null) {
            block.invoke("Content-Type", string);
        }
        if (string2 != null) {
            block.invoke("Content-Length", string2);
        }
    }
}
