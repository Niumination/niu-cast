package com.transsion.iotservice.multiscreen.pc.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.iotservice.multiscreen.pc.R$dimen;
import com.transsion.iotservice.multiscreen.pc.R$id;
import com.transsion.iotservice.multiscreen.pc.R$layout;
import com.transsion.iotservice.multiscreen.pc.R$styleable;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import li.h0;
import li.l0;
import li.v0;
import md.i;
import pd.j;
import qi.c;
import qi.r;
import si.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/view/RoundedCardView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titleResId", "", "setTitle", "(I)V", "contentResId", "setContent", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RoundedCardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2897d;
    public String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LottieAnimationView f2898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f2899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f2900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f2901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f2902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f2904n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCardView(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        boolean z2 = this.f2896c;
        int i8 = z2 ? -1 : ViewCompat.MEASURED_STATE_MASK;
        int color = z2 ? -3355444 : Color.parseColor("#66000000");
        String str = z2 ? this.e : this.f2897d;
        this.f2899i.setTextColor(i8);
        this.f2900j.setTextColor(color);
        if (str.length() > 0) {
            v0 v0Var = v0.f7498a;
            l0.p(this.f2904n, e.f10118a, null, new cc.c(str, this, null), 2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        Path path = this.f2901k;
        if (!path.isEmpty()) {
            canvas.clipPath(path);
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f2903m);
        paint.setAntiAlias(true);
        canvas.drawPath(path, paint);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h0.b(this.f2904n, null);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i8 <= 0 || i9 <= 0) {
            return;
        }
        RectF rectF = this.f2902l;
        rectF.set(0.0f, 0.0f, i8, i9);
        i iVar = new i();
        iVar.f8024a = Math.min(rectF.width(), rectF.height());
        iVar.setRadius(this.f2894a);
        iVar.setSmoothness(this.f2895b);
        Path path = new Path();
        String[] strArr = j.f8764a;
        float radius = iVar.getRadius();
        float smoothness = iVar.getSmoothness();
        path.reset();
        if (radius == 0.0f || smoothness == 0.0f) {
            path.addRect(rectF, Path.Direction.CCW);
        }
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float f = rectF.top;
        float f4 = rectF.left;
        float f10 = rectF.right;
        float f11 = rectF.bottom;
        float f12 = fWidth / 2.0f;
        path.moveTo(f12 + f4, f);
        path.lineTo(Math.max(f12, fWidth - iVar.f8030i) + f4, f);
        float f13 = iVar.f8030i - iVar.e;
        float f14 = f10 - f13;
        float f15 = f13 - iVar.f;
        path.cubicTo(f14, f, f10 - f15, f, f10 - (f15 - iVar.f8028g), iVar.f8029h + f);
        float f16 = iVar.f8025b;
        float f17 = f10 - f16;
        float f18 = f + f16;
        float f19 = iVar.f8026c;
        path.arcTo(f17 - f16, f18 - f16, f17 + f16, f16 + f18, f19 + 270.0f, 90.0f - (f19 * 2.0f), false);
        float f20 = iVar.f8030i;
        float f21 = f20 - iVar.e;
        float f22 = fHeight / 2.0f;
        path.cubicTo(f10, (f21 - iVar.f) + f, f10, f21 + f, f10, Math.min(f22, f20) + f);
        path.lineTo(f10, fHeight + f);
        path.lineTo(f4, f11 + f);
        path.lineTo(f4, Math.min(f22, iVar.f8030i) + f);
        float f23 = iVar.f8030i - iVar.e;
        float f24 = f23 + f;
        float f25 = f23 - iVar.f;
        path.cubicTo(f4, f24, f4, f25 + f, f4 + iVar.f8029h, (f25 - iVar.f8028g) + f);
        float f26 = iVar.f8025b;
        float f27 = f4 + f26;
        float f28 = f + f26;
        float f29 = f27 - f26;
        float f30 = f28 - f26;
        float f31 = f27 + f26;
        float f32 = f28 + f26;
        float f33 = iVar.f8026c;
        path.arcTo(f29, f30, f31, f32, f33 + 180.0f, 90.0f - (f33 * 2.0f), false);
        float f34 = iVar.f8030i;
        float f35 = f34 - iVar.e;
        path.cubicTo((f35 - iVar.f) + f4, f, f35 + f4, f, Math.min(f12, f34) + f4, f);
        path.close();
        Path path2 = this.f2901k;
        path2.reset();
        path2.set(path);
    }

    public final void setContent(int contentResId) {
        this.f2900j.setText(contentResId);
    }

    public final void setTitle(int titleResId) {
        this.f2899i.setText(titleResId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RoundedCardView(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundedCardView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2894a = 22.0f;
        this.f2895b = 0.8f;
        this.f2897d = "";
        this.e = "";
        this.f2901k = new Path();
        this.f2902l = new RectF();
        this.f2903m = -1;
        v0 v0Var = v0.f7498a;
        this.f2904n = h0.a(r.f9163a.plus(l0.d()));
        Intrinsics.checkNotNullParameter("RoundedCardView", "tag");
        Intrinsics.checkNotNullParameter("init", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("RoundedCardView"), "init");
        }
        LayoutInflater.from(context).inflate(R$layout.view_round_card, (ViewGroup) this, true);
        this.f2898h = (LottieAnimationView) findViewById(R$id.lottieView);
        TextView textView = (TextView) findViewById(R$id.titleText);
        this.f2899i = textView;
        TextView textView2 = (TextView) findViewById(R$id.contentText);
        this.f2900j = textView2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundedCardView);
        this.f2894a = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundedCardView_os_smooth_radius, context.getResources().getDimension(R$dimen.os_radius_xxl));
        this.f2895b = typedArrayObtainStyledAttributes.getFloat(R$styleable.RoundedCardView_os_smooth_smoothness, 0.8f);
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z2 = (context.getResources().getConfiguration().uiMode & 48) != 32;
        String log = "PhoneUtil,getUIMode: isLightMode=" + z2 + " (true: light, false: dark)";
        Intrinsics.checkNotNullParameter("PhoneUtil", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PhoneUtil"), log);
        }
        this.f2896c = !z2;
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.RoundedCardView_light_lottie_file);
        this.f2897d = string == null ? "" : string;
        String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.RoundedCardView_dark_lottie_file);
        this.e = string2 == null ? "" : string2;
        int i9 = R$attr.os_layer_medium;
        int i10 = R$color.os_layer_medium_xos;
        String[] strArr = j.f8764a;
        this.f2903m = j.d(i9, context.getColor(i10), context);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.RoundedCardView_title_text, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.RoundedCardView_content_text, 0);
        String string3 = typedArrayObtainStyledAttributes.getString(R$styleable.RoundedCardView_title_text_str);
        String string4 = typedArrayObtainStyledAttributes.getString(R$styleable.RoundedCardView_content_text_str);
        if (resourceId != 0) {
            textView.setText(resourceId);
        } else {
            textView.setText(string3 == null ? "" : string3);
        }
        if (resourceId2 != 0) {
            textView2.setText(resourceId2);
        } else {
            textView2.setText(string4 != null ? string4 : "");
        }
        typedArrayObtainStyledAttributes.recycle();
        setLayerType(2, null);
        a();
    }
}
