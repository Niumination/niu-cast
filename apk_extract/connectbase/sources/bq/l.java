package bq;

import eo.y;
import kn.l0;
import kn.w;
import os.m;
import p6.s;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l implements bq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f1097a;

    public static final class a extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1098b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(int i10) {
            StringBuilder sbA = h.b.a("must have at least ", i10, " value parameter");
            sbA.append(i10 > 1 ? s.f13016a : "");
            super(sbA.toString());
            this.f1098b = i10;
        }

        @Override // bq.b
        public boolean b(@os.l y yVar) {
            l0.p(yVar, "functionDescriptor");
            return yVar.h().size() >= this.f1098b;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1099b;

        public b(int i10) {
            super(k.b.a("must have exactly ", i10, " value parameters"));
            this.f1099b = i10;
        }

        @Override // bq.b
        public boolean b(@os.l y yVar) {
            l0.p(yVar, "functionDescriptor");
            return yVar.h().size() == this.f1099b;
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final c f1100b = new c();

        public c() {
            super("must have no value parameters");
        }

        @Override // bq.b
        public boolean b(@os.l y yVar) {
            l0.p(yVar, "functionDescriptor");
            return yVar.h().isEmpty();
        }
    }

    public static final class d extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final d f1101b = new d();

        public d() {
            super("must have a single value parameter");
        }

        @Override // bq.b
        public boolean b(@os.l y yVar) {
            l0.p(yVar, "functionDescriptor");
            return yVar.h().size() == 1;
        }
    }

    public /* synthetic */ l(String str, w wVar) {
        this(str);
    }

    @Override // bq.b
    @m
    public String a(@os.l y yVar) {
        return bq.b.a.a(this, yVar);
    }

    @Override // bq.b
    @os.l
    public String getDescription() {
        return this.f1097a;
    }

    public l(String str) {
        this.f1097a = str;
    }
}
