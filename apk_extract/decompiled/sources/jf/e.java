package jf;

import ag.d0;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pf.e0;
import zg.s;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f6265a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f6266b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f6267c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1 f6268d = new ag.b(13);
    public boolean e = true;
    public boolean f = true;

    public e() {
        boolean z2 = s.f11604a;
    }

    public final void a(e0 plugin, Function1 configure) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(configure, "configure");
        LinkedHashMap linkedHashMap = this.f6266b;
        linkedHashMap.put(plugin.getKey(), new gi.a(1, (Function1) linkedHashMap.get(plugin.getKey()), configure));
        LinkedHashMap linkedHashMap2 = this.f6265a;
        if (linkedHashMap2.containsKey(plugin.getKey())) {
            return;
        }
        linkedHashMap2.put(plugin.getKey(), new d0(plugin, 15));
    }
}
