package sk;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOif;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOnew;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOtry;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f10144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f10145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10147d;
    public float e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z1OoOnew f10148g;

    public /* synthetic */ b(z1OoOnew z1ooonew, int i8) {
        this.f = i8;
        this.f10148g = z1ooonew;
    }

    public final boolean a(View view, MotionEvent motionEvent, d dVar) {
        String str;
        String str2;
        switch (this.f) {
            case 0:
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int x2 = (int) (motionEvent.getX(0) + iArr[0] + 0.5f);
                int y3 = (int) (motionEvent.getY(0) + iArr[1] + 0.5f);
                z1OoOif z1oooif = (z1OoOif) this.f10148g;
                if (z1oooif.p == Integer.MAX_VALUE || z1oooif.q == Integer.MAX_VALUE) {
                    z1oooif.f11250r = x2;
                    z1oooif.p = x2;
                    z1oooif.f11251s = y3;
                    z1oooif.q = y3;
                    this.f10146c = false;
                    str = "touch move but not down yet";
                } else {
                    int i8 = x2 - z1oooif.f11250r;
                    int i9 = y3 - z1oooif.f11251s;
                    if (Math.abs(i8) <= 1000 && Math.abs(i9) <= 1000) {
                        z1oooif.f11250r = x2;
                        z1oooif.f11251s = y3;
                        if (z1oooif.f11240c != dVar && z1oooif.e != dVar) {
                            this.f10146c = false;
                        } else {
                            if (Math.abs(i9) > Math.abs(i8)) {
                                this.f10144a = view.getTranslationX();
                                float f = i8;
                                this.f10145b = f;
                                this.f10147d = f > 0.0f;
                                return true;
                            }
                            if (!this.f10146c) {
                                int iAbs = Math.abs(i8);
                                int i10 = z1oooif.f11252t;
                                if (iAbs > i10 && i8 != 0) {
                                    i8 = i10 * (i8 < 0 ? -1 : 1);
                                    this.f10146c = true;
                                }
                            }
                        }
                        this.f10144a = view.getTranslationX();
                        float f4 = i8;
                        this.f10145b = f4;
                        this.f10147d = f4 > 0.0f;
                        return false;
                    }
                    str = "current move distance exception need abandon dx=" + i8 + " dy=" + i9;
                }
                Log.e("BounceEffect", str);
                return false;
            default:
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                int x8 = (int) (motionEvent.getX(0) + iArr2[0] + 0.5f);
                int y7 = (int) (motionEvent.getY(0) + iArr2[1] + 0.5f);
                z1OoOtry z1oootry = (z1OoOtry) this.f10148g;
                if (z1oootry.p == Integer.MAX_VALUE || z1oootry.q == Integer.MAX_VALUE) {
                    z1oootry.f11250r = x8;
                    z1oootry.p = x8;
                    z1oootry.f11251s = y7;
                    z1oootry.q = y7;
                    this.f10146c = false;
                    str2 = "touch move but not down yet";
                } else {
                    int i11 = x8 - z1oootry.f11250r;
                    int i12 = y7 - z1oootry.f11251s;
                    if (Math.abs(i11) <= 1000 && Math.abs(i12) <= 1000) {
                        z1oootry.f11250r = x8;
                        z1oootry.f11251s = y7;
                        if (z1oootry.f11240c != dVar && z1oootry.e != dVar) {
                            this.f10146c = false;
                        } else {
                            if (Math.abs(i11) > Math.abs(i12)) {
                                this.f10144a = view.getTranslationY();
                                this.e = y7 - z1oootry.q;
                                float f10 = i12;
                                this.f10145b = f10;
                                this.f10147d = f10 > 0.0f;
                                return true;
                            }
                            if (!this.f10146c) {
                                int iAbs2 = Math.abs(i12);
                                int i13 = z1oootry.f11252t;
                                if (iAbs2 > i13 && i12 != 0) {
                                    i12 = i13 * (i12 < 0 ? -1 : 1);
                                    this.f10146c = true;
                                }
                            }
                        }
                        this.e = y7 - z1oootry.q;
                        this.f10144a = view.getTranslationY();
                        float f11 = i12;
                        this.f10145b = f11;
                        this.f10147d = f11 > 0.0f;
                        return false;
                    }
                    str2 = "current move distance exception need abandon dx=" + i11 + " dy=" + i12;
                }
                Log.e("BounceEffect", str2);
                return false;
        }
    }
}
