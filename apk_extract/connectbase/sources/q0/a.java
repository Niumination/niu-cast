package q0;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<K, A> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<K> f13352c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public a1.j<A> f13354e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f13350a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13351b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13353d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public A f13355f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13356g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13357h = -1.0f;

    public interface b {
        void a();
    }

    public static final class c<T> implements d<T> {
        public c() {
        }

        @Override // q0.a.d
        public boolean a(float f10) {
            throw new IllegalStateException("not implemented");
        }

        @Override // q0.a.d
        public a1.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // q0.a.d
        public boolean c(float f10) {
            return false;
        }

        @Override // q0.a.d
        public float d() {
            return 0.0f;
        }

        @Override // q0.a.d
        public float e() {
            return 1.0f;
        }

        @Override // q0.a.d
        public boolean isEmpty() {
            return true;
        }

        public c(C0335a c0335a) {
        }
    }

    public interface d<T> {
        boolean a(float f10);

        a1.a<T> b();

        boolean c(float f10);

        @FloatRange(from = 0.0d, to = 1.0d)
        float d();

        @FloatRange(from = 0.0d, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    public static final class e<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<? extends a1.a<T>> f13358a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a1.a<T> f13360c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f13361d = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public a1.a<T> f13359b = f(0.0f);

        public e(List<? extends a1.a<T>> list) {
            this.f13358a = list;
        }

        @Override // q0.a.d
        public boolean a(float f10) {
            a1.a<T> aVar = this.f13360c;
            a1.a<T> aVar2 = this.f13359b;
            if (aVar == aVar2 && this.f13361d == f10) {
                return true;
            }
            this.f13360c = aVar2;
            this.f13361d = f10;
            return false;
        }

        @Override // q0.a.d
        @NonNull
        public a1.a<T> b() {
            return this.f13359b;
        }

        @Override // q0.a.d
        public boolean c(float f10) {
            if (this.f13359b.a(f10)) {
                return !this.f13359b.h();
            }
            this.f13359b = f(f10);
            return true;
        }

        @Override // q0.a.d
        public float d() {
            return this.f13358a.get(0).e();
        }

        @Override // q0.a.d
        public float e() {
            List<? extends a1.a<T>> list = this.f13358a;
            return list.get(list.size() - 1).b();
        }

        public final a1.a<T> f(float f10) {
            List<? extends a1.a<T>> list = this.f13358a;
            a1.a<T> aVar = list.get(list.size() - 1);
            if (f10 >= aVar.e()) {
                return aVar;
            }
            for (int size = this.f13358a.size() - 2; size >= 1; size--) {
                a1.a<T> aVar2 = this.f13358a.get(size);
                if (this.f13359b != aVar2 && aVar2.a(f10)) {
                    return aVar2;
                }
            }
            return this.f13358a.get(0);
        }

        @Override // q0.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public static final class f<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final a1.a<T> f13362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13363b = -1.0f;

        public f(List<? extends a1.a<T>> list) {
            this.f13362a = list.get(0);
        }

        @Override // q0.a.d
        public boolean a(float f10) {
            if (this.f13363b == f10) {
                return true;
            }
            this.f13363b = f10;
            return false;
        }

        @Override // q0.a.d
        public a1.a<T> b() {
            return this.f13362a;
        }

        @Override // q0.a.d
        public boolean c(float f10) {
            return !this.f13362a.h();
        }

        @Override // q0.a.d
        public float d() {
            return this.f13362a.e();
        }

        @Override // q0.a.d
        public float e() {
            return this.f13362a.b();
        }

        @Override // q0.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public a(List<? extends a1.a<K>> list) {
        this.f13352c = o(list);
    }

    public static <T> d<T> o(List<? extends a1.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        return list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.f13350a.add(bVar);
    }

    public a1.a<K> b() {
        n0.e.a("BaseKeyframeAnimation#getCurrentKeyframe");
        a1.a<K> aVarB = this.f13352c.b();
        n0.e.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarB;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        if (this.f13357h == -1.0f) {
            this.f13357h = this.f13352c.e();
        }
        return this.f13357h;
    }

    public float d() {
        a1.a<K> aVarB = b();
        if (aVarB.h()) {
            return 0.0f;
        }
        return aVarB.f8d.getInterpolation(e());
    }

    public float e() {
        if (this.f13351b) {
            return 0.0f;
        }
        a1.a<K> aVarB = b();
        if (aVarB.h()) {
            return 0.0f;
        }
        return (this.f13353d - aVarB.e()) / (aVarB.b() - aVarB.e());
    }

    public float f() {
        return this.f13353d;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float g() {
        if (this.f13356g == -1.0f) {
            this.f13356g = this.f13352c.d();
        }
        return this.f13356g;
    }

    public A h() {
        float fE = e();
        if (this.f13354e == null && this.f13352c.a(fE)) {
            return this.f13355f;
        }
        a1.a<K> aVarB = b();
        Interpolator interpolator = aVarB.f9e;
        A aI = (interpolator == null || aVarB.f10f == null) ? i(aVarB, d()) : j(aVarB, fE, interpolator.getInterpolation(fE), aVarB.f10f.getInterpolation(fE));
        this.f13355f = aI;
        return aI;
    }

    public abstract A i(a1.a<K> aVar, float f10);

    public A j(a1.a<K> aVar, float f10, float f11, float f12) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i10 = 0; i10 < this.f13350a.size(); i10++) {
            this.f13350a.get(i10).a();
        }
    }

    public void l() {
        this.f13351b = true;
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.f13352c.isEmpty()) {
            return;
        }
        if (f10 < g()) {
            f10 = g();
        } else if (f10 > c()) {
            f10 = c();
        }
        if (f10 == this.f13353d) {
            return;
        }
        this.f13353d = f10;
        if (this.f13352c.c(f10)) {
            k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(@Nullable a1.j<A> jVar) {
        a1.j<A> jVar2 = this.f13354e;
        if (jVar2 != null) {
            jVar2.f34b = null;
        }
        this.f13354e = jVar;
        if (jVar != null) {
            jVar.f34b = this;
        }
    }
}
