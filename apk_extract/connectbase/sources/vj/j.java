package vj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n2> f17164a;

    public j(n2... n2VarArr) {
        for (n2 n2Var : n2VarArr) {
            n2Var.getClass();
        }
        this.f17164a = Collections.unmodifiableList(new ArrayList(Arrays.asList(n2VarArr)));
    }

    public static n2 a(n2... n2VarArr) {
        if (n2VarArr.length != 0) {
            return new j(n2VarArr);
        }
        throw new IllegalArgumentException("At least one credential is required");
    }

    public List<n2> b() {
        return this.f17164a;
    }
}
