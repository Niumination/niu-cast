package p5;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends PhantomReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f8687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f8688b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(a aVar, ReferenceQueue referenceQueue, Set set) {
        super(aVar, referenceQueue);
        j jVar = j.f8686a;
        this.f8687a = set;
        this.f8688b = jVar;
    }
}
