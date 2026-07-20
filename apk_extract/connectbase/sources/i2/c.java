package i2;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import f2.a0;
import f2.b0;
import f2.p;
import f2.z;
import kn.l0;
import kn.w;
import l2.n;
import lm.t0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final a f7677e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final String f7678f = "AnimPlayer.MaskRender";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final i2.a f7679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public d f7680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public l2.c f7681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public l2.c f7682d;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public c(@l i2.a aVar) {
        l0.p(aVar, "maskAnimPlugin");
        this.f7679a = aVar;
        this.f7681c = new l2.c();
        this.f7682d = new l2.c();
    }

    @m
    public final d a() {
        return this.f7680b;
    }

    @l
    public final l2.c b() {
        return this.f7681c;
    }

    public final void c(boolean z10) {
        this.f7680b = new d(z10);
        GLES20.glDisable(2929);
    }

    public final void d(@l f2.a aVar) {
        z zVar;
        d dVar;
        t0<a0, b0> t0Var;
        t0<a0, b0> t0Var2;
        t0<a0, b0> t0Var3;
        t0<a0, b0> t0Var4;
        l0.p(aVar, "config");
        p pVar = this.f7679a.f7670a.f5740d;
        b0 b0Var = null;
        Integer numValueOf = (pVar == null || (zVar = pVar.f5805b) == null) ? null : Integer.valueOf(zVar.h());
        if (numValueOf == null || numValueOf.intValue() <= 0 || (dVar = this.f7680b) == null) {
            return;
        }
        b bVar = aVar.f5664n;
        Integer numValueOf2 = bVar == null ? null : Integer.valueOf(bVar.f7675c);
        if (numValueOf2 == null) {
            return;
        }
        int iIntValue = numValueOf2.intValue();
        b bVar2 = aVar.f5664n;
        Bitmap bitmap = bVar2 == null ? null : bVar2.f7676d;
        if (bitmap == null) {
            return;
        }
        a0 first = (bVar2 == null || (t0Var = bVar2.f7673a) == null) ? null : t0Var.getFirst();
        if (first == null) {
            return;
        }
        b bVar3 = aVar.f5664n;
        b0 second = (bVar3 == null || (t0Var2 = bVar3.f7673a) == null) ? null : t0Var2.getSecond();
        if (second == null) {
            return;
        }
        b bVar4 = aVar.f5664n;
        a0 first2 = (bVar4 == null || (t0Var3 = bVar4.f7674b) == null) ? null : t0Var3.getFirst();
        if (first2 == null) {
            first2 = new a0(0, 0, aVar.f5653c, aVar.f5654d);
        }
        b bVar5 = aVar.f5664n;
        if (bVar5 != null && (t0Var4 = bVar5.f7674b) != null) {
            b0Var = t0Var4.getSecond();
        }
        if (b0Var == null) {
            b0Var = new b0(aVar.f5653c, aVar.f5654d);
        }
        dVar.d();
        l2.c cVar = this.f7681c;
        cVar.b(l2.p.f9682a.a(b0Var.f5678a, b0Var.f5679b, first2, cVar.f9644a));
        this.f7681c.c(dVar.f7693c);
        if (iIntValue <= 0 && !bitmap.isRecycled()) {
            b bVar6 = aVar.f5664n;
            iIntValue = bVar6 == null ? 0 : bVar6.j();
        }
        if (iIntValue > 0) {
            l2.c cVar2 = this.f7682d;
            cVar2.b(n.f9679a.a(second.f5678a, second.f5679b, first, cVar2.f9644a));
            this.f7682d.c(dVar.f7694d);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, iIntValue);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glUniform1i(dVar.f7692b, 0);
            GLES20.glEnable(3042);
            GLES20.glBlendFuncSeparate(1, 770, 0, 770);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisable(3042);
        }
    }

    public final void e(@m d dVar) {
        this.f7680b = dVar;
    }

    public final void f(@l l2.c cVar) {
        l0.p(cVar, "<set-?>");
        this.f7681c = cVar;
    }
}
