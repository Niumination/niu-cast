package ak;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import c1.h0;
import java.util.Iterator;
import vj.e0;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@e0("https://github.com/grpc/grpc-java/issues/4694")
public final class n {

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f324c;

        public a(e eVar, Iterator it) {
            this.f323b = eVar;
            this.f324c = it;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f322a) {
                return;
            }
            while (this.f323b.e() && this.f324c.hasNext()) {
                this.f323b.c(this.f324c.next());
            }
            if (this.f324c.hasNext()) {
                return;
            }
            this.f322a = true;
            this.f323b.b();
        }
    }

    public static <V> void a(Iterable<V> iterable, e<V> eVar) {
        h0.F(iterable, "source");
        b(iterable.iterator(), eVar);
    }

    public static <V> void b(Iterator<V> it, e<V> eVar) {
        h0.F(it, "source");
        h0.F(eVar, TypedValues.AttributesType.S_TARGET);
        eVar.h(new a(eVar, it));
    }
}
