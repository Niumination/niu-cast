package ko;

import java.lang.annotation.Annotation;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements uo.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f9420b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final dp.f f9421a;

    public static final class a {
        public a() {
        }

        @os.l
        public final f a(@os.l Object obj, @os.m dp.f fVar) {
            l0.p(obj, "value");
            if (d.h(obj.getClass())) {
                return new q(fVar, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new g(fVar, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new j(fVar, (Object[]) obj);
            }
            return obj instanceof Class ? new m(fVar, (Class) obj) : new s(fVar, obj);
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ f(dp.f fVar, kn.w wVar) {
        this(fVar);
    }

    @Override // uo.b
    @os.m
    public dp.f getName() {
        return this.f9421a;
    }

    public f(dp.f fVar) {
        this.f9421a = fVar;
    }
}
