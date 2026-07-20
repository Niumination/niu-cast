package q1;

import java.util.List;
import m1.o;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f8932b;

    public c(b bVar, b bVar2) {
        this.f8931a = bVar;
        this.f8932b = bVar2;
    }

    @Override // q1.e
    public final m1.e g() {
        return new o(this.f8931a.g(), this.f8932b.g());
    }

    @Override // q1.e
    public final List getKeyframes() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // q1.e
    public final boolean isStatic() {
        return this.f8931a.isStatic() && this.f8932b.isStatic();
    }
}
