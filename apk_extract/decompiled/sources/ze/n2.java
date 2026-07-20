package ze;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class n2 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p2 f11386a;

    public n2(p2 p2Var) {
        this.f11386a = p2Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        p2 p2Var = this.f11386a;
        int iB = p2Var.b(obj) - p2Var.b(obj2);
        return iB != 0 ? iB : obj.getClass().getName().compareTo(obj2.getClass().getName());
    }
}
