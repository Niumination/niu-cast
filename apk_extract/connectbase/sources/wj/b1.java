package wj;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f18344a = new ArrayList<>();

    public b1 a(@gm.j Object obj) {
        this.f18344a.add(String.valueOf(obj));
        return this;
    }

    public b1 b(String str, @gm.j Object obj) {
        this.f18344a.add(str + "=" + obj);
        return this;
    }

    public String toString() {
        return this.f18344a.toString();
    }
}
