package ik;

import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    public static final class a extends kn.n0 implements jn.l<Character, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @os.l
        public final Boolean invoke(char c10) {
            return Boolean.valueOf(q.b(c10));
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch2) {
            return invoke(ch2.charValue());
        }
    }

    public static final class b extends kn.n0 implements jn.l<Character, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @os.l
        public final Boolean invoke(char c10) {
            return Boolean.valueOf(q.d(c10));
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch2) {
            return invoke(ch2.charValue());
        }
    }

    public static final class c extends kn.n0 implements jn.l<Character, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @os.l
        public final Boolean invoke(char c10) {
            return Boolean.valueOf(q.b(c10));
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch2) {
            return invoke(ch2.charValue());
        }
    }

    public static final class d extends kn.n0 implements jn.a<String> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return "day-of-month not in [1,31]";
        }
    }

    public static final class e extends kn.n0 implements jn.a<String> {
        public static final e INSTANCE = new e();

        public e() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return "year >= 1601";
        }
    }

    public static final class f extends kn.n0 implements jn.a<String> {
        public static final f INSTANCE = new f();

        public f() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return "hours > 23";
        }
    }

    public static final class g extends kn.n0 implements jn.a<String> {
        public static final g INSTANCE = new g();

        public g() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return "minutes > 59";
        }
    }

    public static final class h extends kn.n0 implements jn.a<String> {
        public static final h INSTANCE = new h();

        public h() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return "seconds > 59";
        }
    }

    public static final class i extends kn.n0 implements jn.l<Character, Boolean> {
        public static final i INSTANCE = new i();

        public i() {
            super(1);
        }

        @os.l
        public final Boolean invoke(char c10) {
            return Boolean.valueOf(q.d(c10));
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch2) {
            return invoke(ch2.charValue());
        }
    }

    public final <T> void a(String str, String str2, T t10) {
        if (t10 == null) {
            throw new w0(str, kn.l0.C("Could not find ", str2));
        }
    }

    public final void b(String str, boolean z10, jn.a<String> aVar) {
        if (!z10) {
            throw new w0(str, aVar.invoke());
        }
    }

    @os.l
    public final kl.d c(@os.l String str) {
        kn.l0.p(str, "source");
        m1 m1Var = new m1(str);
        m mVar = new m();
        m1Var.b(a.INSTANCE);
        while (m1Var.d()) {
            if (m1Var.h(b.INSTANCE)) {
                int i10 = m1Var.f8119b;
                m1Var.b(i.INSTANCE);
                String strSubstring = m1Var.f8118a.substring(i10, m1Var.f8119b);
                kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                q.a(mVar, strSubstring);
                m1Var.b(c.INSTANCE);
            }
        }
        Integer num = mVar.f8117f;
        tn.l lVar = new tn.l(70, 99, 1);
        if (num == null || !lVar.l(num.intValue())) {
            tn.l lVar2 = new tn.l(0, 69, 1);
            if (num != null && lVar2.l(num.intValue())) {
                Integer num2 = mVar.f8117f;
                kn.l0.m(num2);
                mVar.f8117f = Integer.valueOf(num2.intValue() + 2000);
            }
        } else {
            Integer num3 = mVar.f8117f;
            kn.l0.m(num3);
            mVar.f8117f = Integer.valueOf(num3.intValue() + 1900);
        }
        a(str, "day-of-month", mVar.f8115d);
        a(str, y1.o.r.f20670b, mVar.f8116e);
        a(str, y1.o.r.f20669a, mVar.f8117f);
        a(str, RtspHeaders.Values.TIME, mVar.f8114c);
        a(str, RtspHeaders.Values.TIME, mVar.f8113b);
        a(str, RtspHeaders.Values.TIME, mVar.f8112a);
        tn.l lVar3 = new tn.l(1, 31, 1);
        Integer num4 = mVar.f8115d;
        b(str, num4 != null && lVar3.l(num4.intValue()), d.INSTANCE);
        Integer num5 = mVar.f8117f;
        kn.l0.m(num5);
        b(str, num5.intValue() >= 1601, e.INSTANCE);
        Integer num6 = mVar.f8114c;
        kn.l0.m(num6);
        b(str, num6.intValue() <= 23, f.INSTANCE);
        Integer num7 = mVar.f8113b;
        kn.l0.m(num7);
        b(str, num7.intValue() <= 59, g.INSTANCE);
        Integer num8 = mVar.f8112a;
        kn.l0.m(num8);
        b(str, num8.intValue() <= 59, h.INSTANCE);
        return mVar.a();
    }
}
