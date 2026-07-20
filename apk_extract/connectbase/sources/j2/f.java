package j2;

import android.opengl.GLES20;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import f2.a0;
import f2.p;
import f2.z;
import java.util.Collection;
import java.util.HashMap;
import kn.l0;
import kn.w;
import l2.n;
import l2.o;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final a f8499f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final String f8500g = "AnimPlayer.MixRender";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final e f8501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public g f8502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public l2.c f8503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public l2.c f8504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public l2.c f8505e;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public f(@l e eVar) {
        l0.p(eVar, "mixAnimPlugin");
        this.f8501a = eVar;
        this.f8503c = new l2.c();
        this.f8504d = new l2.c();
        this.f8505e = new l2.c();
    }

    public final float[] a(float[] fArr, int i10, int i11, int i12, int i13, j.b bVar) {
        a0 a0Var;
        if (bVar != j.b.CENTER_FULL) {
            return n.f9679a.a(i10, i11, new a0(0, 0, i10, i11), fArr);
        }
        if (i10 <= i12 && i11 <= i13) {
            return n.f9679a.a(i12, i13, new a0((i12 - i10) / 2, (i13 - i11) / 2, i10, i11), fArr);
        }
        float f10 = (i10 * 1.0f) / i11;
        float f11 = i12;
        float f12 = i13;
        if (f10 > (1.0f * f11) / f12) {
            int i14 = (int) (f11 / f10);
            a0Var = new a0(0, (i13 - i14) / 2, i12, i14);
        } else {
            int i15 = (int) (f12 * f10);
            a0Var = new a0((i12 - i15) / 2, 0, i15, i13);
        }
        return n.f9679a.a(i12, i13, a0Var, fArr);
    }

    @l
    public final l2.c b() {
        return this.f8505e;
    }

    @m
    public final g c() {
        return this.f8502b;
    }

    @l
    public final l2.c d() {
        return this.f8504d;
    }

    @l
    public final l2.c e() {
        return this.f8503c;
    }

    public final void f() {
        HashMap<String, j> map;
        Collection<j> collectionValues;
        this.f8502b = new g();
        GLES20.glDisable(2929);
        k kVar = this.f8501a.f8489d;
        if (kVar == null || (map = kVar.f8551a) == null || (collectionValues = map.values()) == null) {
            return;
        }
        for (j jVar : collectionValues) {
            l2.a aVar = l2.a.f9640a;
            aVar.e(f8500g, l0.C("init srcId=", jVar.f8533a));
            jVar.f8545m = o.f9680a.a(jVar.f8546n);
            StringBuilder sb2 = new StringBuilder("textureProgram=");
            g gVar = this.f8502b;
            sb2.append(gVar == null ? null : Integer.valueOf(gVar.f8516a));
            sb2.append(",textureId=");
            sb2.append(jVar.f8545m);
            aVar.e(f8500g, sb2.toString());
        }
    }

    public final void g(int i10) {
        if (i10 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i10}, 0);
        }
    }

    public final void h(@l f2.a aVar, @l j2.a aVar2, @l j jVar) {
        int iIntValue;
        g gVar;
        z zVar;
        l0.p(aVar, "config");
        l0.p(aVar2, TypedValues.AttributesType.S_FRAME);
        l0.p(jVar, "src");
        p pVar = this.f8501a.f8486a.f5740d;
        Integer numValueOf = null;
        if (pVar != null && (zVar = pVar.f5805b) != null) {
            numValueOf = Integer.valueOf(zVar.h());
        }
        if (numValueOf == null || (iIntValue = numValueOf.intValue()) <= 0 || (gVar = this.f8502b) == null) {
            return;
        }
        gVar.i();
        l2.c cVar = this.f8503c;
        cVar.b(l2.p.f9682a.a(aVar.f5653c, aVar.f5654d, aVar2.f8476d, cVar.f9644a));
        this.f8503c.c(gVar.f8521f);
        l2.c cVar2 = this.f8504d;
        float[] fArr = cVar2.f9644a;
        a0 a0Var = aVar2.f8476d;
        cVar2.b(a(fArr, a0Var.f5668c, a0Var.f5669d, jVar.f8536d, jVar.f8537e, jVar.f8544l));
        this.f8504d.c(gVar.f8522g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, jVar.f8545m);
        GLES20.glUniform1i(gVar.f8517b, 0);
        l2.c cVar3 = this.f8505e;
        n nVar = n.f9679a;
        cVar3.b(nVar.a(aVar.f5655e, aVar.f5656f, aVar2.f8477e, cVar3.f9644a));
        if (aVar2.f8478f == 90) {
            l2.c cVar4 = this.f8505e;
            cVar4.b(nVar.b(cVar4.f9644a));
        }
        this.f8505e.c(gVar.f8523h);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(36197, iIntValue);
        GLES20.glUniform1i(gVar.f8518c, 1);
        if (jVar.f8538f == j.d.TXT && this.f8501a.f8495j) {
            GLES20.glUniform1i(gVar.f8519d, 1);
            float[] fArrM = m(jVar.f8543k);
            GLES20.glUniform4f(gVar.f8520e, fArrM[1], fArrM[2], fArrM[3], fArrM[0]);
        } else {
            GLES20.glUniform1i(gVar.f8519d, 0);
            GLES20.glUniform4f(gVar.f8520e, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisable(3042);
    }

    public final void i(@l l2.c cVar) {
        l0.p(cVar, "<set-?>");
        this.f8505e = cVar;
    }

    public final void j(@m g gVar) {
        this.f8502b = gVar;
    }

    public final void k(@l l2.c cVar) {
        l0.p(cVar, "<set-?>");
        this.f8504d = cVar;
    }

    public final void l(@l l2.c cVar) {
        l0.p(cVar, "<set-?>");
        this.f8503c = cVar;
    }

    public final float[] m(int i10) {
        return new float[]{((i10 >>> 24) & 255) / 255.0f, ((i10 >>> 16) & 255) / 255.0f, ((i10 >>> 8) & 255) / 255.0f, (i10 & 255) / 255.0f};
    }
}
