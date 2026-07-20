package ko;

import java.lang.annotation.Annotation;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f implements uo.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Annotation f9422c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@os.m dp.f fVar, @os.l Annotation annotation) {
        super(fVar);
        l0.p(annotation, "annotation");
        this.f9422c = annotation;
    }

    @Override // uo.c
    @os.l
    public uo.a a() {
        return new e(this.f9422c);
    }
}
