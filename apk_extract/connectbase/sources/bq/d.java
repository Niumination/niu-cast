package bq;

import eo.y;
import java.util.Arrays;
import java.util.Collection;
import jq.r;
import kn.l0;
import kn.n0;
import kn.w;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public final dp.f f1050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public final r f1051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final Collection<dp.f> f1052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.l<y, String> f1053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final bq.b[] f1054e;

    public static final class a extends n0 implements jn.l {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Void invoke(@os.l y yVar) {
            l0.p(yVar, "$this$null");
            return null;
        }
    }

    public static final class b extends n0 implements jn.l {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Void invoke(@os.l y yVar) {
            l0.p(yVar, "$this$null");
            return null;
        }
    }

    public static final class c extends n0 implements jn.l {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @m
        public final Void invoke(@os.l y yVar) {
            l0.p(yVar, "$this$null");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(dp.f fVar, r rVar, Collection<dp.f> collection, jn.l<? super y, String> lVar, bq.b... bVarArr) {
        this.f1050a = fVar;
        this.f1051b = rVar;
        this.f1052c = collection;
        this.f1053d = lVar;
        this.f1054e = bVarArr;
    }

    @os.l
    public final bq.c a(@os.l y yVar) {
        l0.p(yVar, "functionDescriptor");
        bq.b[] bVarArr = this.f1054e;
        int length = bVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            bq.b bVar = bVarArr[i10];
            i10++;
            String strA = bVar.a(yVar);
            if (strA != null) {
                return new bq.c.b(strA);
            }
        }
        String strInvoke = this.f1053d.invoke(yVar);
        return strInvoke != null ? new bq.c.b(strInvoke) : bq.c.C0045c.f1049b;
    }

    public final boolean b(@os.l y yVar) {
        l0.p(yVar, "functionDescriptor");
        if (this.f1050a != null && !l0.g(yVar.getName(), this.f1050a)) {
            return false;
        }
        if (this.f1051b != null) {
            String strB = yVar.getName().b();
            l0.o(strB, "functionDescriptor.name.asString()");
            if (!this.f1051b.matches(strB)) {
                return false;
            }
        }
        Collection<dp.f> collection = this.f1052c;
        return collection == null || collection.contains(yVar.getName());
    }

    public /* synthetic */ d(dp.f fVar, bq.b[] bVarArr, jn.l lVar, int i10, w wVar) {
        this(fVar, bVarArr, (jn.l<? super y, String>) ((i10 & 4) != 0 ? a.INSTANCE : lVar));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@os.l dp.f fVar, @os.l bq.b[] bVarArr, @os.l jn.l<? super y, String> lVar) {
        this(fVar, (r) null, (Collection<dp.f>) null, lVar, (bq.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        l0.p(fVar, "name");
        l0.p(bVarArr, "checks");
        l0.p(lVar, "additionalChecks");
    }

    public /* synthetic */ d(r rVar, bq.b[] bVarArr, jn.l lVar, int i10, w wVar) {
        this(rVar, bVarArr, (jn.l<? super y, String>) ((i10 & 4) != 0 ? b.INSTANCE : lVar));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@os.l r rVar, @os.l bq.b[] bVarArr, @os.l jn.l<? super y, String> lVar) {
        this((dp.f) null, rVar, (Collection<dp.f>) null, lVar, (bq.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        l0.p(rVar, "regex");
        l0.p(bVarArr, "checks");
        l0.p(lVar, "additionalChecks");
    }

    public /* synthetic */ d(Collection collection, bq.b[] bVarArr, jn.l lVar, int i10, w wVar) {
        this((Collection<dp.f>) collection, bVarArr, (jn.l<? super y, String>) ((i10 & 4) != 0 ? c.INSTANCE : lVar));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@os.l Collection<dp.f> collection, @os.l bq.b[] bVarArr, @os.l jn.l<? super y, String> lVar) {
        this((dp.f) null, (r) null, collection, lVar, (bq.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        l0.p(collection, "nameList");
        l0.p(bVarArr, "checks");
        l0.p(lVar, "additionalChecks");
    }
}
