package com.transsion.widgetslib.widget.shadow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import com.transsion.widgetslib.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ExpandActionButton extends FrameLayout {
    public static final int H = 7;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f3047w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3048x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3049y = 88;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3050z = 265;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatingOvalButton f3054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FloatingOvalButton[] f3055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3057g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3058i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3059n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f3060p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e f3061v;

    public static class SaveState extends View.BaseSavedState {
        public static final Parcelable.Creator<SaveState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3062a;

        public class a implements Parcelable.Creator<SaveState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SaveState createFromParcel(Parcel parcel) {
                return new SaveState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SaveState[] newArray(int i10) {
                return new SaveState[i10];
            }
        }

        public /* synthetic */ SaveState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte((byte) (!this.f3062a ? 1 : 0));
        }

        public SaveState(Parcel parcel) {
            super(parcel);
            this.f3062a = parcel.readByte() == 0;
        }

        public SaveState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ExpandActionButton.this.f3057g) {
                f fVar = ExpandActionButton.this.f3060p;
                if (fVar != null) {
                    fVar.a(view);
                    return;
                }
                return;
            }
            ExpandActionButton expandActionButton = ExpandActionButton.this;
            if (expandActionButton.f3051a) {
                expandActionButton.j();
            } else {
                expandActionButton.l();
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandActionButton.this.f3059n = false;
            ExpandActionButton expandActionButton = ExpandActionButton.this;
            expandActionButton.f3051a = true;
            if (expandActionButton.f3057g) {
                return;
            }
            expandActionButton.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ExpandActionButton.this.setItemsVisibility(0);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandActionButton.this.setItemsVisibility(8);
            ExpandActionButton expandActionButton = ExpandActionButton.this;
            expandActionButton.f3059n = false;
            expandActionButton.f3051a = false;
            if (expandActionButton.f3057g) {
                return;
            }
            expandActionButton.n();
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3066a;

        public d(int i10) {
            this.f3066a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ExpandActionButton.this.f3061v != null) {
                ExpandActionButton.this.f3061v.a(this.f3066a);
            }
        }
    }

    public interface e {
        void a(int i10);
    }

    public interface f {
        void a(View view);
    }

    public ExpandActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3055e = new FloatingOvalButton[3];
        this.f3057g = true;
        LayoutInflater.from(context).inflate(R.layout.os_expand_action_btn_layout, this);
        this.f3054d = (FloatingOvalButton) findViewById(R.id.float_main);
        this.f3055e[0] = (FloatingOvalButton) findViewById(R.id.float_item0);
        this.f3055e[1] = (FloatingOvalButton) findViewById(R.id.float_item1);
        this.f3055e[2] = (FloatingOvalButton) findViewById(R.id.float_item2);
        int i10 = i(7.0f);
        setPadding(i10, i10, i10, i10);
        this.f3052b = i(88.0f);
        this.f3053c = i(265.0f);
        int i11 = context.getResources().getConfiguration().orientation;
        if (i11 == 2) {
            this.f3056f = 1;
        } else if (i11 == 1) {
            this.f3056f = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemsVisibility(int i10) {
        for (int i11 = 0; i11 < this.f3058i; i11++) {
            this.f3055e[i11].setVisibility(i10);
        }
    }

    public final int i(float f10) {
        return (int) TypedValue.applyDimension(1, f10, getResources().getDisplayMetrics());
    }

    public void j() {
        if (this.f3059n) {
            return;
        }
        this.f3059n = true;
        s();
    }

    public void k() {
        if (this.f3051a) {
            for (int i10 = 0; i10 < this.f3058i; i10++) {
                if (this.f3056f == 0) {
                    this.f3055e[i10].setTranslationY(0.0f);
                } else {
                    this.f3055e[i10].setTranslationX(0.0f);
                }
            }
            this.f3054d.getImage().setRotation(0.0f);
            setItemsVisibility(8);
            this.f3051a = false;
            if (this.f3057g) {
                return;
            }
            n();
        }
    }

    public void l() {
        if (this.f3059n) {
            return;
        }
        this.f3059n = true;
        t();
    }

    public boolean m() {
        return this.f3051a;
    }

    public final void n() {
        getLayoutParams().width = this.f3052b;
        getLayoutParams().height = this.f3052b;
        requestLayout();
    }

    public final void o() {
        int i10 = this.f3056f;
        if (i10 == 0) {
            getLayoutParams().height = this.f3053c;
            getLayoutParams().width = this.f3052b;
            requestLayout();
            return;
        }
        if (i10 == 1) {
            getLayoutParams().width = this.f3053c;
            getLayoutParams().height = this.f3052b;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        k();
        int i10 = configuration.orientation;
        if (i10 == 2) {
            setExpandOrientation(1);
        } else if (i10 == 1) {
            setExpandOrientation(0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f3057g) {
            setItemsVisibility(8);
            return;
        }
        for (int i14 = 0; i14 < this.f3058i; i14++) {
            int width = (this.f3054d.getWidth() - this.f3055e[i14].getWidth()) / 2;
            int left = this.f3054d.getLeft() + width;
            int top = this.f3054d.getTop() + width;
            FloatingOvalButton floatingOvalButton = this.f3055e[i14];
            floatingOvalButton.layout(left, top, floatingOvalButton.getWidth() + left, this.f3055e[i14].getHeight() + i13);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SaveState saveState = (SaveState) parcelable;
        super.onRestoreInstanceState(saveState);
        boolean z10 = saveState.f3062a;
        this.f3057g = z10;
        setExpandable(z10);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SaveState saveState = new SaveState(super.onSaveInstanceState());
        saveState.f3062a = this.f3057g;
        return saveState;
    }

    public final void p(int i10, int i11, int i12) {
        FloatingOvalButton floatingOvalButton = this.f3055e[i12];
        floatingOvalButton.setImageResource(i10);
        floatingOvalButton.setImageBackground(new ColorDrawable(i11));
        floatingOvalButton.setClickable(true);
        floatingOvalButton.setOnClickListener(new d(i12));
    }

    public void q(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return;
        }
        this.f3058i = iArr.length <= 3 ? iArr.length : 3;
        for (int i10 = 0; i10 < this.f3058i; i10++) {
            p(iArr[i10], iArr2[i10], i10);
        }
    }

    public void r(int i10, int i11) {
        this.f3054d.setImageResource(i10);
        this.f3054d.setImageBackground(new ColorDrawable(i11));
        this.f3054d.setClickable(true);
        this.f3054d.setOnClickListener(new a());
        setExpandable(true);
    }

    public final void s() {
        ArrayList arrayList = new ArrayList();
        String str = this.f3056f == 0 ? "translationY" : "translationX";
        boolean z10 = getLayoutDirection() == 1;
        for (int i10 = 0; i10 < this.f3058i; i10++) {
            int i11 = (i(56.0f) * i10) + i(64.0f);
            if (!z10 || this.f3056f != 1) {
                i11 = -i11;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f3055e[i10], str, i11, 0.0f);
            objectAnimatorOfFloat.setDuration(238L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f3055e[i10], "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setDuration(238L);
            arrayList.add(objectAnimatorOfFloat);
            arrayList.add(objectAnimatorOfFloat2);
        }
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f3054d.getImage(), Key.ROTATION, z10 ? -135.0f : 135.0f, 0.0f);
        objectAnimatorOfFloat3.setInterpolator(new nj.a());
        objectAnimatorOfFloat3.setDuration(360L);
        arrayList.add(objectAnimatorOfFloat3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    public void setExpandOrientation(int i10) {
        this.f3056f = i10;
        o();
    }

    public void setExpandable(boolean z10) {
        this.f3057g = z10;
        if (z10) {
            o();
        } else if (this.f3051a) {
            j();
        } else {
            if (this.f3059n) {
                return;
            }
            n();
        }
    }

    public void setOnItemButtonClickListener(e eVar) {
        this.f3061v = eVar;
    }

    public void setOnMainButtonClickListener(f fVar) {
        this.f3060p = fVar;
    }

    public final void t() {
        ArrayList arrayList = new ArrayList();
        String str = this.f3056f == 0 ? "translationY" : "translationX";
        boolean z10 = getLayoutDirection() == 1;
        for (int i10 = 0; i10 < this.f3058i; i10++) {
            int i11 = (i(56.0f) * i10) + i(64.0f);
            if (!z10 || this.f3056f != 1) {
                i11 = -i11;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f3055e[i10], str, 0.0f, i11);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f3055e[i10], "alpha", 0.0f, 1.0f);
            arrayList.add(objectAnimatorOfFloat);
            arrayList.add(objectAnimatorOfFloat2);
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f3054d.getImage(), Key.ROTATION, 0.0f, z10 ? -135.0f : 135.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(360L);
        animatorSet.setInterpolator(new nj.a());
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new b());
        animatorSet.start();
    }
}
