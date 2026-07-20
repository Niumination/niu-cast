package zj;

import java.lang.reflect.Array;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f11723c;

    public /* synthetic */ y(s sVar, int i8) {
        this.f11722b = i8;
        this.f11723c = sVar;
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        switch (this.f11722b) {
            case 0:
                Iterable iterable = (Iterable) obj;
                if (iterable != null) {
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        this.f11723c.a(l0Var, it.next());
                    }
                    break;
                }
                break;
            default:
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i8 = 0; i8 < length; i8++) {
                        this.f11723c.a(l0Var, Array.get(obj, i8));
                    }
                    break;
                }
                break;
        }
    }
}
