package hj;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends Lambda implements Function0 {
    final /* synthetic */ m this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar) {
        super(0);
        this.this$0 = mVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<X509Certificate> invoke() {
        dj.q qVar = this.this$0.f5457d;
        Intrinsics.checkNotNull(qVar);
        List<Certificate> listA = qVar.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listA));
        for (Certificate certificate : listA) {
            if (certificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
