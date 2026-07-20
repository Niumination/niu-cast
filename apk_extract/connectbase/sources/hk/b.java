package hk;

import gk.u;
import gk.w;
import ik.i;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import jn.p;
import kn.l0;
import lm.d1;
import lm.l2;
import nk.y;
import nq.k1;
import nq.s0;
import os.l;
import os.m;
import pl.k;
import v1.e;
import xm.f;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final e f7241a;

    @f(c = "io.ktor.gson.GsonConverter$convertForReceive$2", f = "GsonSupport.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends o implements p<s0, um.d<? super Object>, Object> {
        final /* synthetic */ k $channel;
        final /* synthetic */ nl.f<uk.c, dk.b> $context;
        final /* synthetic */ un.d<?> $javaType;
        int label;
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, nl.f<uk.c, dk.b> fVar, b bVar, un.d<?> dVar, um.d<? super a> dVar2) {
            super(2, dVar2);
            this.$channel = kVar;
            this.$context = fVar;
            this.this$0 = bVar;
            this.$javaType = dVar;
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return new a(this.$channel, this.$context, this.this$0, this.$javaType, dVar);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Object invoke(s0 s0Var, um.d<? super Object> dVar) {
            return invoke2(s0Var, (um.d<Object>) dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws d {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            InputStream inputStreamF = yl.b.f(this.$channel, null, 1, null);
            Charset charsetK = uk.e.k(this.$context.getContext().d());
            if (charsetK == null) {
                charsetK = jq.f.f8800b;
            }
            Object objFromJson = this.this$0.f7241a.fromJson((Reader) new InputStreamReader(inputStreamF, charsetK), (Class<Object>) in.b.g(this.$javaType));
            if (objFromJson != null) {
                return objFromJson;
            }
            throw new d();
        }

        @m
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@l s0 s0Var, @m um.d<Object> dVar) {
            return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // gk.u
    @m
    public Object a(@l nl.f<uk.c, dk.b> fVar, @l um.d<Object> dVar) throws hk.a {
        uk.c cVarE = fVar.E();
        Object obj = cVarE.f16295b;
        k kVar = obj instanceof k ? (k) obj : null;
        if (kVar == null) {
            return null;
        }
        un.d<?> dVarB = wn.d.b(cVarE.f16294a);
        if (c.d(this.f7241a, dVarB)) {
            throw new hk.a(dVarB);
        }
        return nq.k.g(k1.c(), new a(kVar, fVar, this, dVarB, null), dVar);
    }

    @Override // gk.u
    @m
    public Object b(@l nl.f<Object, dk.b> fVar, @l i iVar, @l Object obj, @l um.d<Object> dVar) {
        String json = this.f7241a.toJson(obj);
        l0.o(json, "gson.toJson(value)");
        return new y(json, ik.k.b(iVar, w.d(fVar.getContext(), null, 1, null)), null, 4, null);
    }

    public b(@l e eVar) {
        l0.p(eVar, "gson");
        this.f7241a = eVar;
    }

    public /* synthetic */ b(e eVar, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? new e() : eVar);
    }
}
