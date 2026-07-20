package hj;

import dj.u;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f5475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5476d;
    public final dj.a e;
    public final a8.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f5477g;

    public r(dj.a address, a8.a routeDatabase, i call) {
        dj.l eventListener = dj.l.f4605d;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.e = address;
        this.f = routeDatabase;
        this.f5477g = call;
        this.f5473a = CollectionsKt.emptyList();
        this.f5475c = CollectionsKt.emptyList();
        this.f5476d = new ArrayList();
        u url = address.f4470a;
        q qVar = new q(this, null, url);
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        List<Proxy> proxies = qVar.invoke();
        this.f5473a = proxies;
        this.f5474b = 0;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
    }

    public final boolean a() {
        return this.f5474b < this.f5473a.size() || !this.f5476d.isEmpty();
    }
}
