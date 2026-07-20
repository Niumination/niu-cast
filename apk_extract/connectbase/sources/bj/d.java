package bj;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f928r = "d";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f929s = 25;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RenderScript f930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ScriptIntrinsicBlur f931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gj.b f932l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public gj.c f933m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Allocation f934n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Allocation f935o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f936p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f937q;

    public d(a aVar) {
        super(aVar);
        this.f937q = false;
        v(aVar.f918j);
    }

    @Override // bj.b
    public Bitmap f(Bitmap bitmap, boolean z10) {
        dj.c.b(bitmap, "scaledInBitmap == null");
        if (!this.f937q) {
            Log.e(f928r, "RenderScript Runtime is not initialized");
            return bitmap;
        }
        if (this.f935o == null) {
            this.f934n = Allocation.createFromBitmap(this.f930j, bitmap);
            this.f935o = Allocation.createFromBitmap(this.f930j, Bitmap.createBitmap(bitmap));
        } else if (this.f936p != bitmap) {
            this.f934n.destroy();
            this.f935o.destroy();
            this.f934n = Allocation.createFromBitmap(this.f930j, bitmap);
            this.f935o = Allocation.createFromBitmap(this.f930j, Bitmap.createBitmap(bitmap));
        } else {
            this.f934n.copyFrom(bitmap);
        }
        this.f936p = bitmap;
        try {
            int i10 = this.f920b;
            if (i10 == 0) {
                s(bitmap, this.f934n, this.f935o);
                this.f934n.copyTo(bitmap);
            } else if (i10 == 1) {
                t(this.f934n, this.f935o);
                this.f935o.copyTo(bitmap);
            } else if (i10 == 2) {
                u(bitmap, this.f934n, this.f935o);
                this.f934n.copyTo(bitmap);
            }
        } catch (Throwable th2) {
            Log.e(f928r, "Blur the bitmap error", th2);
        }
        return bitmap;
    }

    public void finalize() throws Throwable {
        h();
        super.finalize();
    }

    @Override // bj.b
    public void h() {
        Allocation allocation = this.f934n;
        if (allocation != null) {
            allocation.destroy();
        }
        Allocation allocation2 = this.f935o;
        if (allocation2 != null) {
            allocation2.destroy();
        }
        this.f936p = null;
    }

    public final void s(Bitmap bitmap, Allocation allocation, Allocation allocation2) {
        gj.b bVar = this.f932l;
        if (bVar == null) {
            throw new IllegalStateException("The blur script is unavailable");
        }
        bVar.r(allocation);
        this.f932l.s(allocation2);
        this.f932l.u(bitmap.getWidth());
        this.f932l.q(bitmap.getHeight());
        this.f932l.t(this.f919a);
        this.f932l.a(allocation);
        this.f932l.r(allocation2);
        this.f932l.s(allocation);
        this.f932l.c(allocation2);
    }

    public final void t(Allocation allocation, Allocation allocation2) {
        if (this.f931k == null) {
            throw new IllegalStateException("The blur script is unavailable");
        }
        int iA = dj.b.a(this.f919a, 0, 25);
        this.f919a = iA;
        this.f931k.setRadius(iA);
        this.f931k.setInput(allocation);
        this.f931k.forEach(allocation2);
    }

    public final void u(Bitmap bitmap, Allocation allocation, Allocation allocation2) {
        gj.c cVar = this.f933m;
        if (cVar == null) {
            throw new IllegalStateException("The blur script is unavailable");
        }
        cVar.r(allocation);
        this.f933m.s(allocation2);
        this.f933m.u(bitmap.getWidth());
        this.f933m.q(bitmap.getHeight());
        this.f933m.t(this.f919a);
        this.f933m.c(allocation);
        this.f933m.r(allocation2);
        this.f933m.s(allocation);
        this.f933m.a(allocation2);
    }

    public final void v(Context context) {
        dj.c.b(context, "Please set context for renderscript scheme, forget to set context for builder?");
        try {
            RenderScript renderScriptCreate = RenderScript.create(context.getApplicationContext());
            this.f930j = renderScriptCreate;
            this.f931k = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            this.f932l = new gj.b(this.f930j);
            this.f933m = new gj.c(this.f930j);
            this.f937q = true;
        } catch (RSRuntimeException e10) {
            Log.e(f928r, "Failed to init RenderScript runtime", e10);
            this.f937q = false;
        }
    }
}
