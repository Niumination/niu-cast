package ik;

import af.s1;
import java.util.AbstractQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements ek.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f5901a;

    public o(s1 s1Var) {
        this.f5901a = s1Var;
    }

    @Override // ek.a
    public final void call() {
        s1 s1Var = this.f5901a;
        int size = ((AbstractQueue) s1Var.f574b).size();
        int i8 = 0;
        if (size < 0) {
            int i9 = 0 - size;
            while (i8 < i9) {
                ((AbstractQueue) s1Var.f574b).add(s1Var.f());
                i8++;
            }
            return;
        }
        if (size > 0) {
            while (i8 < size) {
                ((AbstractQueue) s1Var.f574b).poll();
                i8++;
            }
        }
    }
}
