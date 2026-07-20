package sk;

import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final jn.l<Throwable, l2> f15155a = a.INSTANCE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final jn.l<Throwable, l2> f15156b = b.INSTANCE;

    public static final class a extends kn.n0 implements jn.l<Throwable, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
        }
    }

    public static final class b extends kn.n0 implements jn.l<Throwable, l2> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Throwable th2) {
            invoke2(th2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
        }
    }

    public static final void e(jn.l<? super Throwable, l2> lVar) {
        throw new IllegalStateException(lVar == f15156b ? "Another handler was already registered and successfully invoked" : kn.l0.C("Another handler was already registered: ", lVar));
    }

    public static final void f(o oVar, ByteBuffer byteBuffer) {
        tl.p.k(oVar.f15147a, byteBuffer);
        byteBuffer.flip();
    }
}
