package hj;

import dj.u;
import java.net.Proxy;
import java.net.URI;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends Lambda implements Function0 {
    final /* synthetic */ Proxy $proxy;
    final /* synthetic */ u $url;
    final /* synthetic */ r this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Proxy proxy, u uVar) {
        super(0);
        this.this$0 = rVar;
        this.$proxy = proxy;
        this.$url = uVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<Proxy> invoke() {
        Proxy proxy = this.$proxy;
        if (proxy != null) {
            return CollectionsKt.listOf(proxy);
        }
        URI uriH = this.$url.h();
        if (uriH.getHost() == null) {
            return ej.b.l(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = this.this$0.e.f4477j.select(uriH);
        List<Proxy> list = listSelect;
        return (list == null || list.isEmpty()) ? ej.b.l(Proxy.NO_PROXY) : ej.b.w(listSelect);
    }
}
