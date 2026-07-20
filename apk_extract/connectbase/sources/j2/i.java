package j2;

import android.graphics.Bitmap;
import f2.a0;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public String f8525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public j.d f8526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public j.c f8527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public String f8528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public Bitmap f8529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public a0 f8530f;

    public i(@l j jVar) {
        l0.p(jVar, "src");
        this.f8525a = "";
        this.f8526b = j.d.UNKNOWN;
        this.f8527c = j.c.UNKNOWN;
        this.f8528d = "";
        this.f8525a = jVar.f8533a;
        this.f8526b = jVar.f8538f;
        this.f8527c = jVar.f8539g;
        this.f8528d = jVar.f8540h;
        this.f8529e = jVar.f8546n;
    }

    @m
    public final Bitmap a() {
        return this.f8529e;
    }

    @m
    public final a0 b() {
        return this.f8530f;
    }

    @l
    public final String c() {
        return this.f8525a;
    }

    @l
    public final j.c d() {
        return this.f8527c;
    }

    @l
    public final String e() {
        return this.f8528d;
    }

    @l
    public final j.d f() {
        return this.f8526b;
    }

    public final void g(@m Bitmap bitmap) {
        this.f8529e = bitmap;
    }

    public final void h(@m a0 a0Var) {
        this.f8530f = a0Var;
    }

    public final void i(@l String str) {
        l0.p(str, "<set-?>");
        this.f8525a = str;
    }

    public final void j(@l j.c cVar) {
        l0.p(cVar, "<set-?>");
        this.f8527c = cVar;
    }

    public final void k(@l String str) {
        l0.p(str, "<set-?>");
        this.f8528d = str;
    }

    public final void l(@l j.d dVar) {
        l0.p(dVar, "<set-?>");
        this.f8526b = dVar;
    }
}
