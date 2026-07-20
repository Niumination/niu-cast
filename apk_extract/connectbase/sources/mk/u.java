package mk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kn.l0;
import kn.n0;
import lm.l2;
import lm.t0;
import nm.k0;

/* JADX INFO: loaded from: classes2.dex */
@f
public final class u implements w<b> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final a f10825h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final fl.b<u> f10826i = new fl.b<>("WebsocketDeflateExtension");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f10827j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f10828k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f10829l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final b f10830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final x<b, ? extends w<b>> f10831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<y> f10832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final Inflater f10833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final Deflater f10834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10836g;

    public static final class a implements x<b, u> {
        public a() {
        }

        @Override // mk.x
        public boolean a() {
            return u.f10827j;
        }

        @Override // mk.x
        public boolean b() {
            return u.f10828k;
        }

        @Override // mk.x
        public boolean c() {
            return u.f10829l;
        }

        @Override // mk.x
        @os.l
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public u d(@os.l jn.l<? super b, l2> lVar) {
            l0.p(lVar, "config");
            b bVar = new b();
            lVar.invoke(bVar);
            return new u(bVar);
        }

        @Override // mk.x
        @os.l
        public fl.b<u> getKey() {
            return u.f10826i;
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10839c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public jn.l<? super List<y>, l2> f10840d = e.INSTANCE;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public jn.l<? super g, Boolean> f10841e = a.INSTANCE;

        public static final class a extends n0 implements jn.l<g, Boolean> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l g gVar) {
                l0.p(gVar, "it");
                return Boolean.TRUE;
            }
        }

        /* JADX INFO: renamed from: mk.u$b$b, reason: collision with other inner class name */
        public static final class C0284b extends n0 implements jn.l<g, Boolean> {
            final /* synthetic */ jn.l<g, Boolean> $block;
            final /* synthetic */ jn.l<g, Boolean> $old;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0284b(jn.l<? super g, Boolean> lVar, jn.l<? super g, Boolean> lVar2) {
                super(1);
                this.$block = lVar;
                this.$old = lVar2;
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l g gVar) {
                l0.p(gVar, "it");
                return Boolean.valueOf(this.$block.invoke(gVar).booleanValue() && this.$old.invoke(gVar).booleanValue());
            }
        }

        public static final class c extends n0 implements jn.l<g, Boolean> {
            final /* synthetic */ int $bytes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(int i10) {
                super(1);
                this.$bytes = i10;
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l g gVar) {
                l0.p(gVar, TypedValues.AttributesType.S_FRAME);
                return Boolean.valueOf(gVar.f10770c.length > this.$bytes);
            }
        }

        public static final class d extends n0 implements jn.l<List<y>, l2> {
            final /* synthetic */ jn.l<List<y>, l2> $block;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public d(jn.l<? super List<y>, l2> lVar) {
                super(1);
                this.$block = lVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(List<y> list) {
                invoke2(list);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l List<y> list) {
                l0.p(list, "it");
                b.this.f10840d.invoke(list);
                this.$block.invoke(list);
            }
        }

        public static final class e extends n0 implements jn.l<List<y>, l2> {
            public static final e INSTANCE = new e();

            public e() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l List<y> list) {
                l0.p(list, "it");
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(List<y> list) {
                invoke2(list);
                return l2.f10208a;
            }
        }

        @os.l
        public final List<y> a() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.f10837a) {
                arrayList2.add(v.f10843b);
            }
            if (this.f10838b) {
                arrayList2.add(v.f10844c);
            }
            arrayList.add(new y(v.f10846e, arrayList2));
            this.f10840d.invoke(arrayList);
            return arrayList;
        }

        public final void b(@os.l jn.l<? super g, Boolean> lVar) {
            l0.p(lVar, "block");
            this.f10841e = new C0284b(lVar, this.f10841e);
        }

        public final void c(int i10) {
            b(new c(i10));
        }

        public final void d(@os.l jn.l<? super List<y>, l2> lVar) {
            l0.p(lVar, "block");
            this.f10840d = new d(lVar);
        }

        public final boolean e() {
            return this.f10837a;
        }

        @os.l
        public final jn.l<g, Boolean> f() {
            return this.f10841e;
        }

        public final int g() {
            return this.f10839c;
        }

        @os.l
        public final jn.l<List<y>, l2> h() {
            return this.f10840d;
        }

        public final boolean i() {
            return this.f10838b;
        }

        public final void j(boolean z10) {
            this.f10837a = z10;
        }

        public final void k(@os.l jn.l<? super g, Boolean> lVar) {
            l0.p(lVar, "<set-?>");
            this.f10841e = lVar;
        }

        public final void l(int i10) {
            this.f10839c = i10;
        }

        public final void m(@os.l jn.l<? super List<y>, l2> lVar) {
            l0.p(lVar, "<set-?>");
            this.f10840d = lVar;
        }

        public final void n(boolean z10) {
            this.f10838b = z10;
        }
    }

    public u(@os.l b bVar) {
        l0.p(bVar, "config");
        this.f10830a = bVar;
        this.f10831b = f10825h;
        this.f10832c = bVar.a();
        this.f10833d = new Inflater(true);
        this.f10834e = new Deflater(bVar.f10839c, true);
        this.f10835f = true;
        this.f10836g = true;
    }

    @Override // mk.w
    @os.l
    public x<b, ? extends w<b>> a() {
        return this.f10831b;
    }

    @Override // mk.w
    @os.l
    public g b(@os.l g gVar) {
        l0.p(gVar, TypedValues.AttributesType.S_FRAME);
        if (!gVar.f10772e || (!(gVar instanceof g.f) && !(gVar instanceof g.a))) {
            return gVar;
        }
        byte[] bArrC = lk.g.c(this.f10833d, gVar.f10770c);
        if (!this.f10836g) {
            this.f10833d.reset();
        }
        return g.f10766i.c(gVar.f10768a, gVar.f10769b, bArrC, !f10827j, gVar.f10773f, gVar.f10774g);
    }

    @Override // mk.w
    @os.l
    public g c(@os.l g gVar) {
        l0.p(gVar, TypedValues.AttributesType.S_FRAME);
        if ((!(gVar instanceof g.f) && !(gVar instanceof g.a)) || !this.f10830a.f10841e.invoke(gVar).booleanValue()) {
            return gVar;
        }
        byte[] bArrA = lk.g.a(this.f10834e, gVar.f10770c);
        if (!this.f10835f) {
            this.f10834e.reset();
        }
        return g.f10766i.c(gVar.f10768a, gVar.f10769b, bArrA, f10827j, gVar.f10773f, gVar.f10774g);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // mk.w
    @os.l
    public List<y> d(@os.l List<y> list) {
        Object next;
        l0.p(list, "requestedProtocols");
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!l0.g(((y) next).f10849a, v.f10846e));
        y yVar = (y) next;
        if (yVar == null) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (t0<String, String> t0Var : yVar.d()) {
            String strComponent1 = t0Var.component1();
            String strComponent2 = t0Var.component2();
            String lowerCase = strComponent1.toLowerCase();
            l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
            switch (lowerCase.hashCode()) {
                case -708713803:
                    if (!lowerCase.equals(v.f10843b)) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strComponent1 + ", " + strComponent2 + ')').toString());
                    }
                    if (!jq.e0.S1(strComponent2)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    this.f10836g = false;
                    arrayList.add(v.f10843b);
                    break;
                    break;
                case 646404390:
                    if (!lowerCase.equals(v.f10845d)) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strComponent1 + ", " + strComponent2 + ')').toString());
                    }
                    break;
                    break;
                case 1266201133:
                    if (!lowerCase.equals(v.f10844c)) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strComponent1 + ", " + strComponent2 + ')').toString());
                    }
                    if (!jq.e0.S1(strComponent2)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    this.f10835f = false;
                    arrayList.add(v.f10844c);
                    break;
                    break;
                case 2034279582:
                    if (!lowerCase.equals(v.f10842a)) {
                        throw new IllegalStateException(("Unsupported extension parameter: (" + strComponent1 + ", " + strComponent2 + ')').toString());
                    }
                    if (Integer.parseInt(strComponent2) != 15) {
                        throw new IllegalStateException("Only 15 window size is supported");
                    }
                    break;
                    break;
                default:
                    throw new IllegalStateException(("Unsupported extension parameter: (" + strComponent1 + ", " + strComponent2 + ')').toString());
            }
        }
        return nm.x.k(new y(v.f10846e, arrayList));
    }

    @Override // mk.w
    public boolean e(@os.l List<y> list) {
        Object next;
        l0.p(list, "negotiatedProtocols");
        Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!l0.g(((y) next).f10849a, v.f10846e));
        y yVar = (y) next;
        if (yVar == null) {
            return false;
        }
        b bVar = this.f10830a;
        this.f10836g = bVar.f10838b;
        this.f10835f = bVar.f10837a;
        for (t0<String, String> t0Var : yVar.d()) {
            String strComponent1 = t0Var.component1();
            String strComponent2 = t0Var.component2();
            switch (strComponent1.hashCode()) {
                case -708713803:
                    if (strComponent1.equals(v.f10843b) && !jq.e0.S1(strComponent2)) {
                        throw new IllegalStateException(l0.C("WebSocket permessage-deflate extension parameter client_no_context_takeover shouldn't have a value. Current: ", strComponent2).toString());
                    }
                    break;
                    break;
                case 646404390:
                    if (strComponent1.equals(v.f10845d) && !jq.e0.S1(strComponent2) && Integer.parseInt(strComponent2) != 15) {
                        throw new IllegalStateException("Only 15 window size is supported.");
                    }
                    break;
                    break;
                case 1266201133:
                    if (strComponent1.equals(v.f10844c) && !jq.e0.S1(strComponent2)) {
                        throw new IllegalStateException(l0.C("WebSocket permessage-deflate extension parameter server_no_context_takeover shouldn't have a value. Current: ", strComponent2).toString());
                    }
                    break;
                    break;
                case 2034279582:
                    strComponent1.equals(v.f10842a);
                    break;
            }
        }
        return true;
    }

    @Override // mk.w
    @os.l
    public List<y> f() {
        return this.f10832c;
    }
}
