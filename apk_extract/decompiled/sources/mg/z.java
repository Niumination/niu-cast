package mg;

import java.util.ArrayList;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zg.a f8081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f8082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f8083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f8084d;
    public final ArrayList e;
    public final ArrayList f;

    public z(zg.a key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f8081a = key;
        this.f8082b = new ArrayList();
        this.f8083c = new ArrayList();
        this.f8084d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    public final void a(Function3 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ArrayList arrayList = this.f8082b;
        hh.h hVar = c.f8052n;
        arrayList.add(new o(hVar, new t(0, hVar, this, new w(new v(block, null), null), u.INSTANCE)));
    }
}
