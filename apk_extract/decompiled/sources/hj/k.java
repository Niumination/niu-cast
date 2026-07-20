package hj;

import java.security.cert.Certificate;
import java.util.List;
import k3.lc;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends Lambda implements Function0 {
    final /* synthetic */ dj.a $address;
    final /* synthetic */ dj.f $certificatePinner;
    final /* synthetic */ dj.q $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(dj.f fVar, dj.q qVar, dj.a aVar) {
        super(0);
        this.$certificatePinner = fVar;
        this.$unverifiedHandshake = qVar;
        this.$address = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<Certificate> invoke() {
        lc lcVar = this.$certificatePinner.f4533b;
        Intrinsics.checkNotNull(lcVar);
        return lcVar.a(this.$address.f4470a.e, this.$unverifiedHandshake.a());
    }
}
