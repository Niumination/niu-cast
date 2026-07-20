package kd;

import af.f;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.core.widget.NestedScrollView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import k3.z8;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f6825w = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6829d;
    public View e;
    public b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f6830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Canvas f6831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap f6832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BitmapDrawable f6833j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6837n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap f6838o;
    public final RenderScript p;
    public final ScriptIntrinsicBlur q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Allocation f6839r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Allocation f6840s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Bitmap f6841t;
    public boolean u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f6826a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f6827b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f6828c = new Rect();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6834k = 25;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6835l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6836m = Color.parseColor("#F7F7F7");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f6842v = new f(this, 24);

    public d(Context context) {
        RenderScript renderScriptCreate = RenderScript.create(context);
        this.p = renderScriptCreate;
        this.q = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    public final void a(Bitmap bitmap) {
        c();
        RenderScript renderScript = this.p;
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap);
        this.f6839r = allocationCreateFromBitmap;
        this.f6840s = Allocation.createTyped(renderScript, allocationCreateFromBitmap.getType());
        this.f6841t = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public final boolean b(View view, Rect rect) {
        int height;
        int i8 = rect.left;
        int i9 = rect.top;
        int i10 = rect.right;
        int i11 = rect.bottom;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i12 = iArr[0];
        int i13 = iArr[1];
        int width = view.getWidth();
        if (view == this.e && this.f6837n) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(this.e, null);
                height = objInvoke instanceof Integer ? ((Integer) objInvoke).intValue() : 0;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                z8.c("d", "reflect invoke computeVerticalScrollRange() fail!", e);
            }
        } else {
            height = view.getHeight();
        }
        rect.left = i12;
        rect.top = i13;
        int i14 = width + i12;
        rect.right = i14;
        int i15 = height + i13;
        rect.bottom = i15;
        return (i8 == i12 && i9 == i13 && i10 == i14 && i11 == i15) ? false : true;
    }

    public final void c() {
        Allocation allocation = this.f6839r;
        if (allocation != null) {
            allocation.destroy();
            this.f6839r = null;
        }
        Allocation allocation2 = this.f6840s;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f6840s = null;
        }
        Bitmap bitmap = this.f6841t;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.f6841t.recycle();
            }
            this.f6841t = null;
        }
    }

    public final void d() {
        this.f6833j = null;
        Bitmap bitmap = this.f6832i;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.f6832i.recycle();
                z8.f("d", "recycleViewBlurBg, ViewBlurBitmap");
            }
            this.f6832i = null;
        }
        Bitmap bitmap2 = this.f6838o;
        if (bitmap2 != null) {
            if (!bitmap2.isRecycled()) {
                this.f6838o.recycle();
                z8.f("d", "recycleViewBlurBg, ScrollViewBitmap");
            }
            this.f6838o = null;
        }
        c();
    }

    public final void e() {
        View view = this.e;
        if (view != null && this.f != null) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.f);
            this.e.getViewTreeObserver().removeOnGlobalLayoutListener(this.f6830g);
            this.e.removeCallbacks(this.f6842v);
            this.f6830g = null;
            this.f = null;
        }
        d();
    }

    /* JADX WARN: Code duplicated, block: B:102:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:82:0x023e  */
    public final void f() {
        Bitmap bitmap;
        boolean z2;
        ByteBuffer byteBuffer;
        ByteBuffer byteBufferAllocate;
        View view = this.f6829d;
        if (view == null || this.e == null) {
            return;
        }
        Rect rect = this.f6826a;
        boolean zB = b(view, rect);
        View view2 = this.e;
        Rect rect2 = this.f6827b;
        boolean zB2 = b(view2, rect2);
        Rect rect3 = this.f6828c;
        rect3.set(rect);
        int paddingBottom = this.e.getPaddingBottom();
        boolean zIntersect = this.u ? rect3.intersect(rect2.left - this.e.getPaddingStart(), rect2.top - this.e.getPaddingTop(), rect2.right - this.e.getPaddingEnd(), rect2.bottom - paddingBottom) : rect3.intersect(rect2.left, rect2.top, rect2.right, rect2.bottom);
        z8.b("d", "RectBlurred: " + rect2.toShortString() + ", RectBlur: " + rect.toShortString() + ", RectIntersect: " + rect3.toShortString() + ", paddingBottom: " + paddingBottom);
        if (zIntersect) {
            int iWidth = rect3.width();
            int iHeight = rect3.height();
            int iCeil = (int) Math.ceil((iWidth * 1.0f) / this.f6835l);
            int iCeil2 = (int) Math.ceil((iHeight * 1.0f) / this.f6835l);
            if (iCeil > 0 && iCeil2 > 0) {
                int i8 = rect2.left - rect3.left;
                int i9 = rect2.top - rect3.top;
                float f = 1.0f / this.f6835l;
                StringBuilder sbR = o.d.r(iWidth, iHeight, "width: ", ", height: ", ", dx: ");
                sbR.append(i8);
                sbR.append(", dy: ");
                sbR.append(i9);
                sbR.append(", ViewBlurredLocChange: ");
                sbR.append(zB2);
                sbR.append(", ViewBlurLocChange: ");
                sbR.append(zB);
                sbR.append(", bitmapWidth: ");
                sbR.append(iCeil);
                sbR.append(", bitmapHeight: ");
                sbR.append(iCeil2);
                z8.f("d", sbR.toString());
                if (zB || zB2) {
                    d();
                }
                if (this.f6837n) {
                    if (this.f6838o == null) {
                        int iCeil3 = (int) Math.ceil((rect2.height() * 1.0f) / this.f6835l);
                        if (iCeil3 != 0) {
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, iCeil3, Bitmap.Config.ARGB_4444);
                            this.f6838o = bitmapCreateBitmap;
                            bitmapCreateBitmap.eraseColor(this.f6836m);
                            Canvas canvas = new Canvas(this.f6838o);
                            canvas.scale(f, f);
                            this.e.draw(canvas);
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                    int scrollY = this.e.getScrollY();
                    StringBuilder sbU = a1.a.u(scrollY, "scrollY: ", ", blurred view height: ");
                    sbU.append(rect2.height());
                    z8.f("d", sbU.toString());
                    int i10 = this.f6835l;
                    int i11 = (-i8) / i10;
                    int i12 = (scrollY - i9) / i10;
                    int i13 = iWidth / i10;
                    int i14 = iHeight / i10;
                    if (i11 < 0 || i12 < 0 || i13 <= 0 || i14 <= 0) {
                        z8.g("pivot or dimen out source bitmap");
                    } else if (i11 + i13 > this.f6838o.getWidth() || i12 + i14 > this.f6838o.getHeight()) {
                        z8.g("need dst bitmap dimen over source bitmap");
                    } else {
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f6838o, i11, i12, i13, i14);
                        Bitmap bitmap2 = this.f6832i;
                        if (bitmap2 == null) {
                            this.f6832i = bitmapCreateBitmap2;
                        } else {
                            try {
                                byteBufferAllocate = ByteBuffer.allocate(bitmapCreateBitmap2.getByteCount());
                                try {
                                    try {
                                        bitmapCreateBitmap2.copyPixelsToBuffer(byteBufferAllocate);
                                        bitmap2.eraseColor(0);
                                        bitmap2.copyPixelsFromBuffer(ByteBuffer.wrap(byteBufferAllocate.array()));
                                        if (!bitmapCreateBitmap2.isRecycled()) {
                                            bitmapCreateBitmap2.recycle();
                                        }
                                        byteBufferAllocate.clear();
                                    } catch (Exception e) {
                                        e = e;
                                        z8.c("d", "copy src form buffer fail!", e);
                                        if (!bitmapCreateBitmap2.isRecycled()) {
                                            bitmapCreateBitmap2.recycle();
                                        }
                                        if (byteBufferAllocate != null) {
                                            byteBufferAllocate.clear();
                                        }
                                        bitmap = null;
                                        if (bitmap != null) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteBuffer = byteBufferAllocate;
                                    if (!bitmapCreateBitmap2.isRecycled()) {
                                        bitmapCreateBitmap2.recycle();
                                    }
                                    if (byteBuffer != null) {
                                        byteBuffer.clear();
                                    }
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                byteBufferAllocate = null;
                            } catch (Throwable th3) {
                                th = th3;
                                byteBuffer = null;
                                if (!bitmapCreateBitmap2.isRecycled()) {
                                    bitmapCreateBitmap2.recycle();
                                }
                                if (byteBuffer != null) {
                                    byteBuffer.clear();
                                }
                                throw th;
                            }
                        }
                        if (z2) {
                            a(this.f6832i);
                        }
                    }
                } else {
                    if (this.f6832i == null) {
                        this.f6832i = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_4444);
                        Canvas canvas2 = new Canvas(this.f6832i);
                        this.f6831h = canvas2;
                        canvas2.scale(f, f);
                        this.f6831h.translate(i8, i9);
                        a(this.f6832i);
                    }
                    this.f6832i.eraseColor(this.f6836m);
                    this.e.draw(this.f6831h);
                }
                bitmap = this.f6832i;
            }
            if (bitmap != null || bitmap.isRecycled()) {
            }
            if (this.f6839r != null && this.f6840s != null) {
                float f4 = this.f6834k;
                ScriptIntrinsicBlur scriptIntrinsicBlur = this.q;
                scriptIntrinsicBlur.setRadius(f4);
                this.f6839r.copyFrom(this.f6832i);
                scriptIntrinsicBlur.setInput(this.f6839r);
                scriptIntrinsicBlur.forEach(this.f6840s);
                this.f6840s.copyTo(this.f6841t);
            }
            Bitmap bitmap3 = this.f6841t;
            BitmapDrawable bitmapDrawable = this.f6833j;
            if (bitmapDrawable != null) {
                this.f6829d.invalidateDrawable(bitmapDrawable);
                z8.f("d", "updateBlurViewBackground, 22222");
                return;
            }
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.f6829d.getResources(), bitmap3);
            this.f6833j = bitmapDrawable2;
            this.f6829d.setBackground(bitmapDrawable2);
            z8.f("d", "updateBlurViewBackground, 11111: " + this.f6833j);
            return;
        }
        z8.g("Hasn't intersect region between two views!");
        bitmap = null;
        if (bitmap != null) {
        }
    }

    public void setBlurView(View view) {
        z8.f("d", "setBlurView, viewBlur: " + view);
        if (view == null || view == this.f6829d) {
            return;
        }
        this.f6829d = view;
        this.f6826a.setEmpty();
    }

    public void setBlurredView(View view) {
        int i8 = 0;
        if (view == null) {
            return;
        }
        e();
        this.e = view;
        this.f6837n = (view instanceof NestedScrollView) || (view instanceof ScrollView) || (view instanceof OverBoundNestedScrollView);
        this.u = (view instanceof ViewGroup) && ((ViewGroup) view).getClipToPadding();
        z8.f("d", "setBlurredView, blurredView: " + view + ", clipToPadding: " + this.u + ", paddingBottom: " + this.e.getPaddingBottom());
        if (this.f6830g == null) {
            this.f6830g = new a(this, i8);
            this.e.getViewTreeObserver().addOnGlobalLayoutListener(this.f6830g);
            View view2 = this.e;
            f fVar = this.f6842v;
            view2.removeCallbacks(fVar);
            this.e.postDelayed(fVar, 2000L);
        }
        if (this.f == null) {
            this.f = new b(this);
            this.e.getViewTreeObserver().addOnScrollChangedListener(this.f);
        }
    }

    public void setCallback(c cVar) {
    }

    public void setEraseColor(@ColorInt int i8) {
        if (i8 != 0) {
            this.f6836m = i8;
        }
    }

    public void setRadius(@IntRange(from = 1, to = 25) int i8) {
        if (i8 < 1 || i8 > 25) {
            return;
        }
        this.f6834k = i8;
    }

    public void setScaleFactor(@IntRange(from = 1) int i8) {
        if (i8 >= 1) {
            this.f6835l = i8;
        }
    }
}
