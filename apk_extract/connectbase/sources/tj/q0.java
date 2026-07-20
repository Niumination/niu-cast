package tj;

import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack<String> f15728a = new Stack<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p0 f15729b;

    public void a(String str) {
        c();
        this.f15728a.push(str);
    }

    public void b(p0 p0Var) {
        c();
        String str = p0Var.f15726a;
        p0 p0Var2 = p0Var.f15727b;
        while (true) {
            this.f15728a.push(str);
            if (p0Var2 == null) {
                return;
            }
            str = p0Var2.f15726a;
            p0Var2 = p0Var2.f15727b;
        }
    }

    public final void c() {
        if (this.f15729b != null) {
            throw new sj.c.d("Adding to PathBuilder after getting result");
        }
    }

    public p0 d() {
        if (this.f15729b == null) {
            p0 p0Var = null;
            while (!this.f15728a.isEmpty()) {
                p0Var = new p0(this.f15728a.pop(), p0Var);
            }
            this.f15729b = p0Var;
        }
        return this.f15729b;
    }
}
