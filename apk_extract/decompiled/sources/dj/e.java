package dj;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import k3.lc;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends Lambda implements Function0 {
    final /* synthetic */ String $hostname;
    final /* synthetic */ List $peerCertificates;
    final /* synthetic */ f this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, List list, String str) {
        super(0);
        this.this$0 = fVar;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    @Override // kotlin.jvm.functions.Function0
    public final List<X509Certificate> invoke() {
        List listA;
        lc lcVar = this.this$0.f4533b;
        if (lcVar != null) {
            listA = lcVar.a(this.$hostname, this.$peerCertificates);
            if (listA == null) {
                listA = this.$peerCertificates;
            }
        } else {
            listA = this.$peerCertificates;
        }
        List<Certificate> list = listA;
        ArrayList arrayList = new ArrayList(CollectionsKt.i(list));
        for (Certificate certificate : list) {
            if (certificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
