package sj;

import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class b0 implements k {
    @Override // sj.k
    public a a(final q qVar) {
        return d.H(qVar).orElseGet(new Supplier() { // from class: sj.a0
            @Override // java.util.function.Supplier
            public final Object get() {
                return d.d0(n1.i.f11236l, qVar);
            }
        });
    }
}
