package q1;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public abstract class b1<V> extends a1<V> implements s1<V> {

    public static abstract class a<V> extends b1<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s1<V> f13407a;

        public a(s1<V> delegate) {
            delegate.getClass();
            this.f13407a = delegate;
        }

        @Override // q1.b1, q1.a1, f1.j2
        public Object delegate() {
            return this.f13407a;
        }

        @Override // q1.b1, q1.a1
        /* JADX INFO: renamed from: l */
        public Future delegate() {
            return this.f13407a;
        }

        @Override // q1.b1
        /* JADX INFO: renamed from: m */
        public final s1<V> delegate() {
            return this.f13407a;
        }
    }

    @Override // q1.s1
    public void addListener(Runnable listener, Executor exec) {
        delegate().addListener(listener, exec);
    }

    @Override // q1.a1
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public abstract s1<? extends V> delegate();
}
