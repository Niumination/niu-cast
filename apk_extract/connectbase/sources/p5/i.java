package p5;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.res.AssetManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.connectx.mirror.source.SourceApplication;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.k1;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFloatWindowAnim.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatWindowAnim.kt\ncom/transsion/connectx/mirror/source/pad/FloatWindowAnim\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,227:1\n260#2:228\n*S KotlinDebug\n*F\n+ 1 FloatWindowAnim.kt\ncom/transsion/connectx/mirror/source/pad/FloatWindowAnim\n*L\n125#1:228\n*E\n"})
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f12842b = "FloatWindowAnim";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f12843c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f12844d = 0.5f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f12845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public static volatile Runnable f12846f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ValueAnimator f12849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ValueAnimator f12850j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final i f12841a = new i();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final nq.s0 f12847g = nq.t0.a(k1.e());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final AnimatorSet f12848h = new AnimatorSet();

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f12851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f12852b;

        public a(View view, Runnable runnable) {
            this.f12851a = view;
            this.f12852b = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
            this.f12851a.setVisibility(8);
            Runnable runnable = this.f12852b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }
    }

    public static final class b implements h2.a {

        @xm.f(c = "com.transsion.connectx.mirror.source.pad.FloatWindowAnim$loopSetupAnim$1$1$onVideoComplete$1", f = "FloatWindowAnim.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
            int label;

            public a(um.d<? super a> dVar) {
                super(2, dVar);
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                return new a(dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    this.label = 1;
                    if (nq.d1.b(200L, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                Runnable runnable = i.f12846f;
                if (runnable != null) {
                    runnable.run();
                }
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        @Override // h2.a
        public void a() {
            k4.m.e(i.f12842b, "onVideoComplete");
            i iVar = i.f12841a;
            i.f12845e = true;
            nq.k.f(i.f12847g, null, null, new a(null), 3, null);
        }

        @Override // h2.a
        public void b() {
            k4.m.e(i.f12842b, "onVideoDestroy");
        }

        @Override // h2.a
        public void c(int i10, @os.m String str) {
            k4.m.e(i.f12842b, "onFailed");
        }

        @Override // h2.a
        public void d() {
            k4.m.e(i.f12842b, "onVideoStart");
        }

        @Override // h2.a
        public void e(int i10, @os.m f2.a aVar) {
        }

        @Override // h2.a
        public boolean f(@os.l f2.a aVar) {
            return h2.a.C0189a.a(this, aVar);
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f12853a;

        public c(ConstraintLayout constraintLayout) {
            this.f12853a = constraintLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
            this.f12853a.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f12854a;

        public d(ConstraintLayout constraintLayout) {
            this.f12854a = constraintLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
            SpringAnimation springAnimation = new SpringAnimation(this.f12854a, DynamicAnimation.SCALE_X, 1.0f);
            springAnimation.getSpring().setStiffness(290.0f);
            springAnimation.getSpring().setDampingRatio(0.8f);
            SpringAnimation springAnimation2 = new SpringAnimation(this.f12854a, DynamicAnimation.SCALE_Y, 1.0f);
            springAnimation2.getSpring().setStiffness(290.0f);
            springAnimation2.getSpring().setDampingRatio(0.8f);
            springAnimation.start();
            springAnimation2.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@os.l Animator animator) {
            kn.l0.p(animator, "animation");
        }
    }

    static {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.02f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        f12849i = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setDuration(100L);
        f12850j = valueAnimatorOfFloat2;
    }

    public static /* synthetic */ void k(i iVar, View view, Runnable runnable, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            runnable = null;
        }
        iVar.i(view, runnable);
    }

    public static final void l(AnimView animView, final LinearLayout linearLayout) {
        kn.l0.p(animView, "$anim");
        kn.l0.p(linearLayout, "$bg");
        f12841a.i(animView, new Runnable() { // from class: p5.e
            @Override // java.lang.Runnable
            public final void run() {
                i.m(linearLayout);
            }
        });
    }

    public static final void m(LinearLayout linearLayout) {
        kn.l0.p(linearLayout, "$bg");
        k(f12841a, linearLayout, null, 2, null);
    }

    public static final void n(View view, ValueAnimator valueAnimator) {
        kn.l0.p(view, "$bg");
        kn.l0.p(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kn.l0.n(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    public static /* synthetic */ void t(i iVar, ConstraintLayout constraintLayout, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        iVar.s(constraintLayout, j10);
    }

    public static final void u(ConstraintLayout constraintLayout, ValueAnimator valueAnimator) {
        kn.l0.p(constraintLayout, "$constraintLayout");
        kn.l0.p(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kn.l0.n(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        constraintLayout.setAlpha(((Float) animatedValue).floatValue());
    }

    public static final void w(ConstraintLayout constraintLayout, ValueAnimator valueAnimator) {
        kn.l0.p(constraintLayout, "$constraintLayout");
        kn.l0.p(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kn.l0.n(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        constraintLayout.setScaleX(fFloatValue);
        constraintLayout.setScaleY(fFloatValue);
        constraintLayout.setAlpha(fFloatValue);
    }

    public final void i(final View view, Runnable runnable) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p5.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.n(view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a(view, runnable));
        valueAnimatorOfFloat.start();
    }

    @b.a({"Recycle"})
    public final void j(@os.l final AnimView animView, @os.l final LinearLayout linearLayout) {
        Runnable runnable;
        kn.l0.p(animView, dc.d.f3683n);
        kn.l0.p(linearLayout, "bg");
        k4.m.e(f12842b, "hideSetupAnim: mIsSetupAnimComplete: " + f12845e);
        f12846f = new Runnable() { // from class: p5.f
            @Override // java.lang.Runnable
            public final void run() {
                i.l(animView, linearLayout);
            }
        };
        if (!f12845e || (runnable = f12846f) == null) {
            return;
        }
        runnable.run();
    }

    public final void o(@os.l AnimView animView) {
        kn.l0.p(animView, dc.d.f3683n);
        f12845e = false;
        f12846f = null;
        animView.setLoop(1);
        animView.setAnimListener(new b());
        String str = m0.f12861a.P() ? "xos" : "hios";
        a6.j jVar = a6.j.f71a;
        Application applicationB = SourceApplication.b();
        kn.l0.o(applicationB, "getInstance(...)");
        String str2 = jVar.c(applicationB) ? "light" : "dark";
        AssetManager assets = animView.getResources().getAssets();
        kn.l0.o(assets, "getAssets(...)");
        animView.f(assets, "pad/" + str + "/" + str2 + "/video.mp4");
    }

    public final void p() {
        f12848h.cancel();
    }

    public final void q(@os.l ImageView imageView, boolean z10) {
        kn.l0.p(imageView, "imageView");
        AnimatorSet animatorSet = f12848h;
        k4.m.e(f12842b, "setAnimChange play : " + z10 + ", mColorAnimator.isStarted: " + animatorSet.isStarted() + ",alpha: " + imageView.getAlpha() + " ");
        if (!z10) {
            animatorSet.cancel();
            return;
        }
        if (animatorSet.isStarted() || imageView.getAlpha() == 0.5f) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.5f);
        objectAnimatorOfFloat.setDuration(450L);
        animatorSet.setStartDelay(5000L);
        animatorSet.playTogether(objectAnimatorOfFloat);
        animatorSet.start();
    }

    public final void r(@os.l ImageView imageView) {
        kn.l0.p(imageView, "imageView");
        k4.m.e(f12842b, "setFloatButtonLight: alpha: " + imageView.getAlpha() + " ");
        q(imageView, false);
        imageView.setAlpha(1.0f);
    }

    public final void s(@os.l final ConstraintLayout constraintLayout, long j10) {
        kn.l0.p(constraintLayout, "constraintLayout");
        if (constraintLayout.getVisibility() == 0) {
            ValueAnimator valueAnimator = f12850j;
            k4.m.e(f12842b, "startWindowMenuGone: mMenuGoneAnim.isRunning: " + valueAnimator.isRunning());
            if (valueAnimator.isRunning()) {
                return;
            }
            k4.m.e(f12842b, "startWindowMenuGone start");
            valueAnimator.removeAllListeners();
            valueAnimator.setStartDelay(j10);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p5.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    i.u(constraintLayout, valueAnimator2);
                }
            });
            valueAnimator.addListener(new c(constraintLayout));
            valueAnimator.start();
        }
    }

    public final void v(@os.l final ConstraintLayout constraintLayout, float f10, float f11) {
        kn.l0.p(constraintLayout, "constraintLayout");
        k4.m.e(f12842b, "x: $" + f10 + ", y: $" + f11 + ",constraintLayout.x: " + constraintLayout.getWidth() + ", constraintLayout.y: " + constraintLayout.getWidth());
        constraintLayout.setVisibility(0);
        constraintLayout.setPivotX(f10);
        constraintLayout.setPivotY(f11);
        ValueAnimator valueAnimator = f12849i;
        valueAnimator.removeAllListeners();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: p5.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                i.w(constraintLayout, valueAnimator2);
            }
        });
        valueAnimator.addListener(new d(constraintLayout));
        valueAnimator.start();
    }
}
