package c1;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class u<F, T> extends m<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final t<? super F, ? extends T> function;
    private final m<T> resultEquivalence;

    public u(t<? super F, ? extends T> function, m<T> resultEquivalence) {
        function.getClass();
        this.function = function;
        resultEquivalence.getClass();
        this.resultEquivalence = resultEquivalence;
    }

    @Override // c1.m
    public boolean doEquivalent(F f10, F f11) {
        return this.resultEquivalence.equivalent(this.function.apply(f10), this.function.apply(f11));
    }

    @Override // c1.m
    public int doHash(F f10) {
        return this.resultEquivalence.hash(this.function.apply(f10));
    }

    public boolean equals(@gm.a Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.function.equals(uVar.function) && this.resultEquivalence.equals(uVar.resultEquivalence);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
