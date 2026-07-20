package bq;

import eo.y;
import kn.l0;
import kn.w;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements bq.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f1057a;

    public static final class a extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final a f1058b = new a();

        public a() {
            super("must be a member function");
        }

        @Override // bq.b
        public boolean b(@os.l y yVar) {
            l0.p(yVar, "functionDescriptor");
            return yVar.O() != null;
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final b f1059b = new b();

        public b() {
            super("must be a member or an extension function");
        }

        @Override // bq.b
        public boolean b(@os.l y yVar) {
            l0.p(yVar, "functionDescriptor");
            return (yVar.O() == null && yVar.R() == null) ? false : true;
        }
    }

    public /* synthetic */ f(String str, w wVar) {
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
        return this.f1057a;
    }

    public f(String str) {
        this.f1057a = str;
    }
}
