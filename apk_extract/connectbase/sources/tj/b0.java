package tj;

import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class b0 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1 f15573a;

    public b0(k1 k1Var) {
        this.f15573a = k1Var;
    }

    @Override // tj.a
    public Collection<k1> a() {
        return Collections.singletonList(this.f15573a);
    }

    public k1 b() {
        return this.f15573a;
    }
}
