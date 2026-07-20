package s1;

import af.r5;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import j1.b0;
import j1.x;
import j1.z;
import java.io.IOException;
import java.util.HashMap;
import m1.r;

/* JADX INFO: loaded from: classes.dex */
public final class f extends c {
    public final /* synthetic */ int D;
    public final k1.a E;
    public r F;
    public r G;
    public final Parcelable H;
    public final Object I;
    public final Object J;
    public final Object K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(x xVar, i iVar, int i8) {
        super(xVar, iVar);
        this.D = i8;
        switch (i8) {
            case 1:
                super(xVar, iVar);
                this.H = new RectF();
                k1.a aVar = new k1.a();
                this.E = aVar;
                this.I = new float[8];
                this.J = new Path();
                this.K = iVar;
                aVar.setAlpha(0);
                aVar.setStyle(Paint.Style.FILL);
                aVar.setColor(iVar.f9481l);
                break;
            default:
                this.E = new k1.a(3, 0);
                this.H = new Rect();
                this.I = new Rect();
                j1.j jVar = xVar.f6011a;
                this.J = jVar == null ? null : (z) ((HashMap) jVar.c()).get(iVar.f9476g);
                r5 r5Var = this.p.f9490x;
                if (r5Var != null) {
                    this.K = new m1.h(this, this, r5Var);
                }
                break;
        }
    }

    @Override // s1.c, l1.f
    public final void d(RectF rectF, Matrix matrix, boolean z2) {
        switch (this.D) {
            case 0:
                super.d(rectF, matrix, z2);
                z zVar = (z) this.J;
                if (zVar != null) {
                    float fC = w1.g.c();
                    rectF.set(0.0f, 0.0f, zVar.f6031a * fC, zVar.f6032b * fC);
                    this.f9461n.mapRect(rectF);
                }
                break;
            default:
                super.d(rectF, matrix, z2);
                RectF rectF2 = (RectF) this.H;
                i iVar = (i) this.K;
                rectF2.set(0.0f, 0.0f, iVar.f9479j, iVar.f9480k);
                this.f9461n.mapRect(rectF2);
                rectF.set(rectF2);
                break;
        }
    }

    @Override // s1.c, p1.g
    public final void e(ColorFilter colorFilter, x1.c cVar) {
        switch (this.D) {
            case 0:
                super.e(colorFilter, cVar);
                if (colorFilter == b0.F) {
                    this.F = new r(cVar, null);
                } else if (colorFilter == b0.I) {
                    this.G = new r(cVar, null);
                }
                break;
            default:
                super.e(colorFilter, cVar);
                if (colorFilter == b0.F) {
                    this.F = new r(cVar, null);
                } else if (colorFilter == 1) {
                    this.G = new r(cVar, null);
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:49:0x011e  */
    @Override // s1.c
    public final void i(Canvas canvas, Matrix matrix, int i8) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmapD;
        switch (this.D) {
            case 0:
                r rVar = this.G;
                x xVar = this.f9462o;
                z zVar = (z) this.J;
                if (rVar == null || (bitmap2 = (Bitmap) rVar.f()) == null) {
                    String str = this.p.f9476g;
                    o1.a aVar = xVar.f6017j;
                    if (aVar != null) {
                        Context contextH = xVar.h();
                        Context context = aVar.f8359a;
                        if (contextH != null) {
                            if (context instanceof Application) {
                                contextH = contextH.getApplicationContext();
                            }
                            if (contextH != context) {
                                xVar.f6017j = null;
                            }
                        } else if (context != null) {
                            xVar.f6017j = null;
                        }
                    }
                    if (xVar.f6017j == null) {
                        xVar.f6017j = new o1.a(xVar.getCallback(), xVar.f6018k, xVar.f6011a.c());
                    }
                    o1.a aVar2 = xVar.f6017j;
                    if (aVar2 != null) {
                        String str2 = aVar2.f8360b;
                        z zVar2 = (z) aVar2.f8361c.get(str);
                        if (zVar2 != null) {
                            bitmapD = zVar2.f;
                            if (bitmapD != null) {
                                bitmap = null;
                            } else {
                                Context context2 = aVar2.f8359a;
                                if (context2 == null) {
                                    bitmap = null;
                                } else {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inScaled = true;
                                    options.inDensity = 160;
                                    String str3 = zVar2.f6034d;
                                    boolean zStartsWith = str3.startsWith("data:");
                                    int i9 = zVar2.f6032b;
                                    int i10 = zVar2.f6031a;
                                    if (!zStartsWith || str3.indexOf("base64,") <= 0) {
                                        try {
                                            if (!TextUtils.isEmpty(str2)) {
                                                bitmap = null;
                                                try {
                                                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context2.getAssets().open(str2 + str3), null, options);
                                                    if (bitmapDecodeStream != null) {
                                                        bitmapD = w1.g.d(bitmapDecodeStream, i10, i9);
                                                        synchronized (o1.a.f8358d) {
                                                            ((z) aVar2.f8361c.get(str)).f = bitmapD;
                                                        }
                                                    } else {
                                                        w1.b.b("Decoded image `" + str + "` is null.");
                                                    }
                                                } catch (IllegalArgumentException e) {
                                                    w1.b.c("Unable to decode image `" + str + "`.", e);
                                                }
                                                break;
                                            } else {
                                                bitmap = null;
                                                try {
                                                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                                                } catch (IOException e4) {
                                                    e = e4;
                                                }
                                            }
                                        } catch (IOException e10) {
                                            e = e10;
                                            bitmap = null;
                                        }
                                        w1.b.c("Unable to open asset.", e);
                                    } else {
                                        try {
                                            byte[] bArrDecode = Base64.decode(str3.substring(str3.indexOf(44) + 1), 0);
                                            bitmapD = w1.g.d(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options), i10, i9);
                                            synchronized (o1.a.f8358d) {
                                                ((z) aVar2.f8361c.get(str)).f = bitmapD;
                                                break;
                                            }
                                            bitmap = null;
                                        } catch (IllegalArgumentException e11) {
                                            w1.b.c("data URL did not have correct base64 format.", e11);
                                            bitmap = null;
                                            bitmapD = null;
                                        }
                                    }
                                }
                                bitmapD = bitmap;
                            }
                        } else {
                            bitmap = null;
                            bitmapD = bitmap;
                        }
                        bitmap2 = bitmapD;
                    } else {
                        bitmap = null;
                        bitmap2 = null;
                    }
                    if (bitmap2 == null) {
                        bitmap2 = zVar != null ? zVar.f : bitmap;
                    }
                }
                if (bitmap2 == null || bitmap2.isRecycled() || zVar == null) {
                    return;
                }
                float fC = w1.g.c();
                k1.a aVar3 = this.E;
                aVar3.setAlpha(i8);
                r rVar2 = this.F;
                if (rVar2 != null) {
                    aVar3.setColorFilter((ColorFilter) rVar2.f());
                }
                canvas.save();
                canvas.concat(matrix);
                int width = bitmap2.getWidth();
                int height = bitmap2.getHeight();
                Rect rect = (Rect) this.H;
                rect.set(0, 0, width, height);
                boolean z2 = xVar.p;
                Rect rect2 = (Rect) this.I;
                if (z2) {
                    rect2.set(0, 0, (int) (zVar.f6031a * fC), (int) (zVar.f6032b * fC));
                } else {
                    rect2.set(0, 0, (int) (bitmap2.getWidth() * fC), (int) (bitmap2.getHeight() * fC));
                }
                m1.h hVar = (m1.h) this.K;
                if (hVar != null) {
                    hVar.b(aVar3, matrix, i8);
                }
                canvas.drawBitmap(bitmap2, rect, rect2, aVar3);
                canvas.restore();
                return;
            default:
                i iVar = (i) this.K;
                int iAlpha = Color.alpha(iVar.f9481l);
                if (iAlpha == 0) {
                    return;
                }
                r rVar3 = this.G;
                Integer num = rVar3 == null ? null : (Integer) rVar3.f();
                Paint paint = this.E;
                if (num != null) {
                    paint.setColor(num.intValue());
                } else {
                    paint.setColor(iVar.f9481l);
                }
                m1.e eVar = this.f9467w.f7620j;
                int iIntValue = (int) ((((iAlpha / 255.0f) * (eVar == null ? 100 : ((Integer) eVar.f()).intValue())) / 100.0f) * (i8 / 255.0f) * 255.0f);
                paint.setAlpha(iIntValue);
                r rVar4 = this.F;
                if (rVar4 != null) {
                    paint.setColorFilter((ColorFilter) rVar4.f());
                }
                if (iIntValue > 0) {
                    float[] fArr = (float[]) this.I;
                    fArr[0] = 0.0f;
                    fArr[1] = 0.0f;
                    float f = iVar.f9479j;
                    fArr[2] = f;
                    fArr[3] = 0.0f;
                    fArr[4] = f;
                    float f4 = iVar.f9480k;
                    fArr[5] = f4;
                    fArr[6] = 0.0f;
                    fArr[7] = f4;
                    matrix.mapPoints(fArr);
                    Path path = (Path) this.J;
                    path.reset();
                    path.moveTo(fArr[0], fArr[1]);
                    path.lineTo(fArr[2], fArr[3]);
                    path.lineTo(fArr[4], fArr[5]);
                    path.lineTo(fArr[6], fArr[7]);
                    path.lineTo(fArr[0], fArr[1]);
                    path.close();
                    canvas.drawPath(path, paint);
                    return;
                }
                return;
        }
    }
}
