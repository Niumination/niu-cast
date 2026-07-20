package a6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import com.transsion.connectx.mirror.source.R;
import com.transsion.connectx.mirror.source.pad.view.WindowButton;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f58a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Float f59b;

        public a(View view, Float f10) {
            this.f58a = view;
            this.f59b = f10;
        }

        @Override // android.view.View.OnTouchListener
        @b.a({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f58a.setAlpha(this.f59b.floatValue());
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            this.f58a.setAlpha(1.0f);
            return false;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f60a;

        public b(View view) {
            this.f60a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
            this.f60a.setVisibility(8);
        }
    }

    @BindingAdapter({"clickAlpha"})
    public static void c(View view, Float f10) {
        view.setOnTouchListener(new a(view, f10));
    }

    @BindingAdapter({t2.a.f15437d})
    public static void d(WindowButton windowButton, final z4.g gVar) {
        if (gVar == null) {
            return;
        }
        windowButton.setVisibility(gVar.d().booleanValue() ? 0 : 8);
        windowButton.setImageSrc(gVar.a().intValue());
        windowButton.setText(gVar.b());
        windowButton.setLineVisible(gVar.c().booleanValue());
        windowButton.setOnClickListener(new View.OnClickListener() { // from class: a6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                gVar.e();
            }
        });
    }

    @BindingAdapter({"videoLoading"})
    public static void e(View view, Boolean bool) {
        if (bool == null) {
            return;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) view.getTag(R.id.video_loading_animator);
        if (objectAnimator != null && objectAnimator.isRunning()) {
            objectAnimator.cancel();
        }
        if (bool.booleanValue()) {
            view.setAlpha(1.0f);
            view.setVisibility(0);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.addListener(new b(view));
        view.setTag(R.id.video_loading_animator, objectAnimatorOfFloat);
        objectAnimatorOfFloat.start();
    }
}
