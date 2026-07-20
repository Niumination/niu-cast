package eq;

import jn.p;
import jn.q;
import kn.n0;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final jn.l<Object, Object> f4662a = f.INSTANCE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final jn.l<Object, Boolean> f4663b = b.INSTANCE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final jn.l<Object, Object> f4664c = a.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final jn.l<Object, l2> f4665d = c.INSTANCE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final p<Object, Object, l2> f4666e = C0108d.INSTANCE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final q<Object, Object, Object, l2> f4667f = e.INSTANCE;

    public static final class a extends n0 implements jn.l {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Void invoke(@m Object obj) {
            return null;
        }
    }

    public static final class b extends n0 implements jn.l<Object, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.l
        @l
        public final Boolean invoke(@m Object obj) {
            return Boolean.TRUE;
        }
    }

    public static final class c extends n0 implements jn.l<Object, l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
            invoke2(obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Object obj) {
        }
    }

    /* JADX INFO: renamed from: eq.d$d, reason: collision with other inner class name */
    public static final class C0108d extends n0 implements p<Object, Object, l2> {
        public static final C0108d INSTANCE = new C0108d();

        public C0108d() {
            super(2);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(Object obj, Object obj2) {
            invoke2(obj, obj2);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Object obj, @m Object obj2) {
        }
    }

    public static final class e extends n0 implements q<Object, Object, Object, l2> {
        public static final e INSTANCE = new e();

        public e() {
            super(3);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(Object obj, Object obj2, Object obj3) {
            invoke2(obj, obj2, obj3);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@m Object obj, @m Object obj2, @m Object obj3) {
        }
    }

    public static final class f extends n0 implements jn.l<Object, Object> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Object invoke(@m Object obj) {
            return obj;
        }
    }

    @l
    public static final <T> jn.l<T, Boolean> a() {
        return (jn.l<T, Boolean>) f4663b;
    }

    @l
    public static final q<Object, Object, Object, l2> b() {
        return f4667f;
    }
}
