package b8;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EdgeEffect;
import java.util.ArrayList;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends EdgeEffect {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static float f1220g = 60.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f1221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d8.d f1222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f1224d;
    public z1OoOnew e;
    public c f;

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    /* JADX WARN: Code duplicated, block: B:22:0x006a  */
    public d(ViewGroup viewGroup, int i8, final z1OoOnew z1ooonew) {
        float f;
        d8.b bVar;
        ArrayList arrayList;
        super(viewGroup.getContext());
        this.f1223c = true;
        this.f1224d = 0.0f;
        this.f1221a = viewGroup;
        this.e = z1ooonew;
        float f4 = 1.0f;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    this.f1224d = -1.0f;
                } else if (i8 == 3) {
                    this.f1224d = -1.0f;
                }
                if (this.f1223c) {
                    this.f1222b = new d8.d(viewGroup, d8.d.f4378n);
                    f = 106.0f;
                    f4 = 1.125f;
                } else {
                    this.f1222b = new d8.d(viewGroup, d8.d.f4377m);
                    f = 200.0f;
                }
                d8.d dVar = this.f1222b;
                uk.b bVar2 = new uk.b(0.0f);
                bVar2.c(f);
                bVar2.b(f4);
                dVar.f4391k = bVar2;
                bVar = new d8.b() { // from class: b8.a
                    @Override // d8.b
                    /* JADX INFO: renamed from: b */
                    public final void mo1636b() {
                        z1OoOnew z1ooonew2;
                        d dVar2 = this.f1216a;
                        dVar2.getClass();
                        boolean z2 = vk.b.f10615b;
                        boolean z3 = dVar2.f1223c;
                        if (z2 && z3 && (z1ooonew2 = dVar2.e) != null) {
                            boolean zD = z1ooonew2.d(dVar2);
                            dVar2.e.getClass();
                            Log.d("BounceEdgeEffect", "checkModifyRefreshRateStatus: mIsVertical = " + z3 + "  isBounceEdgeAnimRunning = " + zD + " isRefreshRateLimited = false");
                            if (!zD) {
                                Log.d("BounceEdgeEffect", "Cancel high refresh rate.");
                                vk.a.a(0);
                            }
                        }
                        Log.d("BounceEffect", "fling anim end--------  mIsVertical = " + z3);
                    }
                };
                arrayList = dVar.f4388h;
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
                this.f1222b.a(new d8.c() { // from class: b8.b
                    @Override // d8.c
                    public final void d(float f10) {
                        f fVar;
                        z1OoOnew z1ooonew2 = z1ooonew;
                        if (z1ooonew2 == null || (fVar = z1ooonew2.A) == null || !z1ooonew2.f11243i) {
                            return;
                        }
                        fVar.d(f10);
                        z1ooonew2.B = f10 != 0.0f;
                    }
                });
            }
            this.f1224d = 1.0f;
            this.f1223c = true;
            if (this.f1223c) {
                this.f1222b = new d8.d(viewGroup, d8.d.f4378n);
                f = 106.0f;
                f4 = 1.125f;
            } else {
                this.f1222b = new d8.d(viewGroup, d8.d.f4377m);
                f = 200.0f;
            }
            d8.d dVar2 = this.f1222b;
            uk.b bVar3 = new uk.b(0.0f);
            bVar3.c(f);
            bVar3.b(f4);
            dVar2.f4391k = bVar3;
            bVar = new d8.b() { // from class: b8.a
                @Override // d8.b
                /* JADX INFO: renamed from: b */
                public final void mo1636b() {
                    z1OoOnew z1ooonew2;
                    d dVar3 = this.f1216a;
                    dVar3.getClass();
                    boolean z2 = vk.b.f10615b;
                    boolean z3 = dVar3.f1223c;
                    if (z2 && z3 && (z1ooonew2 = dVar3.e) != null) {
                        boolean zD = z1ooonew2.d(dVar3);
                        dVar3.e.getClass();
                        Log.d("BounceEdgeEffect", "checkModifyRefreshRateStatus: mIsVertical = " + z3 + "  isBounceEdgeAnimRunning = " + zD + " isRefreshRateLimited = false");
                        if (!zD) {
                            Log.d("BounceEdgeEffect", "Cancel high refresh rate.");
                            vk.a.a(0);
                        }
                    }
                    Log.d("BounceEffect", "fling anim end--------  mIsVertical = " + z3);
                }
            };
            arrayList = dVar2.f4388h;
            if (!arrayList.contains(bVar)) {
                arrayList.add(bVar);
            }
            this.f1222b.a(new d8.c() { // from class: b8.b
                @Override // d8.c
                public final void d(float f10) {
                    f fVar;
                    z1OoOnew z1ooonew2 = z1ooonew;
                    if (z1ooonew2 == null || (fVar = z1ooonew2.A) == null || !z1ooonew2.f11243i) {
                        return;
                    }
                    fVar.d(f10);
                    z1ooonew2.B = f10 != 0.0f;
                }
            });
        }
        this.f1224d = 1.0f;
        this.f1223c = false;
        if (this.f1223c) {
            this.f1222b = new d8.d(viewGroup, d8.d.f4378n);
            f = 106.0f;
            f4 = 1.125f;
        } else {
            this.f1222b = new d8.d(viewGroup, d8.d.f4377m);
            f = 200.0f;
        }
        d8.d dVar3 = this.f1222b;
        uk.b bVar4 = new uk.b(0.0f);
        bVar4.c(f);
        bVar4.b(f4);
        dVar3.f4391k = bVar4;
        bVar = new d8.b() { // from class: b8.a
            @Override // d8.b
            /* JADX INFO: renamed from: b */
            public final void mo1636b() {
                z1OoOnew z1ooonew2;
                d dVar4 = this.f1216a;
                dVar4.getClass();
                boolean z2 = vk.b.f10615b;
                boolean z3 = dVar4.f1223c;
                if (z2 && z3 && (z1ooonew2 = dVar4.e) != null) {
                    boolean zD = z1ooonew2.d(dVar4);
                    dVar4.e.getClass();
                    Log.d("BounceEdgeEffect", "checkModifyRefreshRateStatus: mIsVertical = " + z3 + "  isBounceEdgeAnimRunning = " + zD + " isRefreshRateLimited = false");
                    if (!zD) {
                        Log.d("BounceEdgeEffect", "Cancel high refresh rate.");
                        vk.a.a(0);
                    }
                }
                Log.d("BounceEffect", "fling anim end--------  mIsVertical = " + z3);
            }
        };
        arrayList = dVar3.f4388h;
        if (!arrayList.contains(bVar)) {
            arrayList.add(bVar);
        }
        this.f1222b.a(new d8.c() { // from class: b8.b
            @Override // d8.c
            public final void d(float f10) {
                f fVar;
                z1OoOnew z1ooonew2 = z1ooonew;
                if (z1ooonew2 == null || (fVar = z1ooonew2.A) == null || !z1ooonew2.f11243i) {
                    return;
                }
                fVar.d(f10);
                z1ooonew2.B = f10 != 0.0f;
            }
        });
    }

    public final void a() {
        this.f1222b.b();
    }

    @Override // android.widget.EdgeEffect
    public final boolean draw(Canvas canvas) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    /* JADX WARN: Code duplicated, block: B:82:0x0143  */
    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int i8) {
        float f;
        float f4;
        boolean z2;
        boolean z3;
        float f10;
        float f11;
        o.d.x(i8, "on absorb:", "BounceEdgeEffect");
        ViewGroup viewGroup = this.f1221a;
        if (viewGroup == null) {
            return;
        }
        boolean z5 = this.f1223c;
        float translationY = z5 ? viewGroup.getTranslationY() : viewGroup.getTranslationX();
        Log.d("BounceEdgeEffect", "view tanslation:" + translationY);
        if (translationY > Float.MAX_VALUE || translationY < -3.4028235E38f) {
            return;
        }
        d8.d dVar = this.f1222b;
        if (dVar.e) {
            return;
        }
        z1OoOnew z1ooonew = this.e;
        float f12 = this.f1224d;
        if (z1ooonew != null && z5 && z1ooonew.f11254w * f12 < 0.0f) {
            Log.e("BounceEdgeEffect", "onAbsorb: mBase.getDirection() = " + this.e.f11254w + " error absorb.");
            return;
        }
        f1220g = ((WindowManager) viewGroup.getContext().getSystemService("window")).getDefaultDisplay().getRefreshRate();
        boolean z10 = vk.b.f10615b;
        if (z10) {
            z1OoOnew z1ooonew2 = this.e;
            if (z1ooonew2 == null) {
                f10 = 1.0f;
                f11 = 200.0f;
            } else if (z5 && z1ooonew2.E) {
                f11 = 106.0f;
                f10 = 1.125f;
            } else if (z5 && z1ooonew2.D) {
                f10 = 0.5f;
                f11 = 150.0f;
            } else if (z5 && z1ooonew2.F) {
                f11 = 106.0f;
                f10 = 1.125f;
            } else {
                if (!z5 && z1ooonew2.E) {
                    f10 = 0.9f;
                } else if (!z5 && z1ooonew2.D) {
                    f10 = 0.6f;
                    f11 = 180.0f;
                } else if (z5 || !z1ooonew2.F) {
                    f10 = 1.0f;
                    f11 = 200.0f;
                } else {
                    f10 = 0.88f;
                }
                f11 = 250.0f;
            }
            uk.b bVar = new uk.b(0.0f);
            bVar.c(f11);
            bVar.b(f10);
            dVar.f4391k = bVar;
            Log.d("BounceEdgeEffect", "setDampingParameters1501 stiffness=" + f11 + " damping=" + f10);
        } else {
            z1OoOnew z1ooonew3 = this.e;
            if (z1ooonew3 == null) {
                f = 1.0f;
                f4 = 200.0f;
            } else if (z5 && z1ooonew3.E) {
                f4 = 235.0f;
                f = 0.88f;
            } else if (z5 && z1ooonew3.D) {
                f = 0.5f;
                f4 = 150.0f;
            } else if (z5 && z1ooonew3.F) {
                f4 = 240.0f;
                f = 0.9f;
            } else {
                if (!z5 && z1ooonew3.E) {
                    f = 0.9f;
                } else if (!z5 && z1ooonew3.D) {
                    f = 0.6f;
                    f4 = 180.0f;
                } else if (z5 || !z1ooonew3.F) {
                    f = 1.0f;
                    f4 = 200.0f;
                } else {
                    f = 0.88f;
                }
                f4 = 250.0f;
            }
            uk.b bVar2 = new uk.b(0.0f);
            bVar2.c(f4);
            bVar2.b(f);
            dVar.f4391k = bVar2;
            Log.d("BounceEdgeEffect", "setDampingParameters stiffness=" + f4 + " damping=" + f);
        }
        dVar.f4383a = i8 * f12;
        dVar.f();
        if (z10 && z5 && this.e != null) {
            Log.d("BounceEdgeEffect", "checkStartModifyRefreshRateStatus: isRefreshRateLimited = false");
            Log.d("BounceEdgeEffect", "Maintain a high refresh rate.");
            vk.a.a(1);
        }
        z1OoOnew z1ooonew4 = this.e;
        if (z1ooonew4 != null && z1ooonew4.G && vk.b.f10616c && vk.b.f10617d) {
            Context context = viewGroup.getContext();
            if (context == null) {
                z3 = false;
            } else {
                z3 = context.checkSelfPermission("android.permission.VIBRATE") == 0;
                Log.d("BounceEdgeEffect", "hasVibratePermission: granted = " + z3);
            }
            z2 = z3;
        }
        if (z2) {
            if (this.f == null) {
                this.f = new c(viewGroup.getContext());
            }
            Handler handler = viewGroup.getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.f);
                handler.post(this.f);
            }
        }
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f) {
        Log.d("BounceEdgeEffect", "onPull");
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        Log.d("BounceEdgeEffect", "onRelease");
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f, float f4) {
        Log.d("BounceEdgeEffect", "onPull2：" + f);
    }
}
