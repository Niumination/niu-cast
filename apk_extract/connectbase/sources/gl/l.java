package gl;

import lm.a1;
import lm.l2;
import lm.m;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(level = m.WARNING, message = "Ktor Semaphore is deprecated and will be removed in ktor 2.0.0. Consider using kotlinx.coroutines Semaphore instead.", replaceWith = @a1(expression = "Semaphore", imports = {"kotlinx.coroutines.sync.Semaphore"}))
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ar.d f6750b;

    public l(int i10) {
        this.f6749a = i10;
        this.f6750b = ar.f.b(i10, 0, 2, null);
    }

    @os.m
    public final Object a(@os.l um.d<? super l2> dVar) {
        Object objB = this.f6750b.b(dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
    }

    @os.m
    @lm.k(level = m.WARNING, message = "Ktor Semaphore is deprecated and will be removed in ktor 2.0.0. Consider using kotlinx.coroutines Semaphore instead.", replaceWith = @a1(expression = "acquire()", imports = {"kotlinx.coroutines.sync.Semaphore"}))
    public final Object b(@os.l um.d<? super l2> dVar) {
        Object objB = this.f6750b.b(dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : l2.f10208a;
    }

    public final int c() {
        return this.f6749a;
    }

    @lm.k(level = m.WARNING, message = "Ktor Semaphore is deprecated and will be removed in ktor 2.0.0. Consider using kotlinx.coroutines Semaphore instead.", replaceWith = @a1(expression = "release()", imports = {"kotlinx.coroutines.sync.Semaphore"}))
    public final void d() {
        this.f6750b.release();
    }

    public final void e() {
        this.f6750b.release();
    }
}
