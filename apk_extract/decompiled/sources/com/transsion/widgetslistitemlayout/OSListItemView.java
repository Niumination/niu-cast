package com.transsion.widgetslistitemlayout;

import af.f;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.view.BadgeView;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetslib.widget.seekbar.OSSeekbar;
import java.util.Arrays;
import ke.a;
import ke.c;
import ke.d;
import pd.j;
import u8.b;

/* JADX INFO: loaded from: classes3.dex */
public class OSListItemView extends RelativeLayout {

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static int f3785l0 = 1;
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public OSIconTextView F;
    public BadgeView G;
    public Button H;
    public int I;
    public boolean J;
    public String K;
    public boolean L;
    public BadgeView M;
    public OSIconTextView N;
    public OSSmoothRoundCorner O;
    public OSIconTextView P;
    public ObjectAnimator Q;
    public boolean R;
    public boolean S;
    public View T;
    public View U;
    public View V;
    public View W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3786a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f3787a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3788b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3789b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3790c;
    public a c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3791d;
    public boolean d0;
    public String e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f3792e0;
    public float f0;
    public Path g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f3793h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f3794h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3795i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f3796i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3797j;
    public FrameLayout j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3798k;
    public b k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3800m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3802o;
    public boolean p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3803r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3804s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3805t;
    public boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Switch f3806v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RadioButton f3807w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ProgressBar f3808x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OSSeekbar f3809y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f3810z;

    public OSListItemView(Context context) {
        super(context);
        this.f3797j = "";
        this.f3802o = 0;
        this.R = true;
        this.S = false;
        this.f3787a0 = j.e(getContext(), R$attr.os_layer_medium, R$color.os_layer_medium_hios);
        this.f3789b0 = 1;
        this.c0 = null;
        this.f3792e0 = false;
        this.f0 = 0.0f;
        this.f3794h0 = false;
        this.f3796i0 = false;
        this.f3786a = 0;
        a(context, null);
    }

    @Deprecated
    public static int getInteractiveMode() {
        return f3785l0;
    }

    @Deprecated
    public static void setInteractiveMode(int i8) {
        f3785l0 = i8;
    }

    private void setItemBg(Boolean bool) {
        this.f3792e0 = bool.booleanValue();
        if (this.c0 == null) {
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(this.f3787a0);
        if (bool.booleanValue()) {
            setBackground(this.c0.b(this.f3789b0, this.f3802o, this.R, colorDrawable, this.f3794h0));
        } else {
            setBackground(this.c0.b(0, this.f3802o, this.R, colorDrawable, this.f3794h0));
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (this.c0 == null) {
            this.c0 = new a(context, this);
        }
        this.f0 = getResources().getDimension(R$dimen.os_radius_l);
        if (this.k0 == null) {
            this.k0 = new b();
        }
        if (this.g0 == null) {
            this.g0 = new Path();
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSListItemView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.OSListItemView_lil_title) {
                    this.f3788b = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.OSListItemView_lil_subtitle) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f3790c = string;
                    if (!TextUtils.isEmpty(string)) {
                        this.f3796i0 = true;
                    }
                } else if (index == R$styleable.OSListItemView_lil_describe_title) {
                    this.f3791d = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.OSListItemView_lil_describe_subtitle) {
                    this.e = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.OSListItemView_lil_left_image) {
                    this.f3793h = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.f3798k = true;
                } else if (index == R$styleable.OSListItemView_lil_left_text_icon) {
                    this.f3795i = typedArrayObtainStyledAttributes.getString(index);
                    this.f3798k = true;
                } else if (index == R$styleable.OSListItemView_lil_left_image_dimen) {
                    this.f3800m = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.OSListItemView_lil_right_layout_type) {
                    int i9 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    this.f3801n = i9;
                    if (i9 == 2) {
                        this.f3799l = true;
                    }
                    if (i9 == 3 || i9 == 4 || i9 == 5) {
                        this.f3792e0 = true;
                    }
                } else if (index == R$styleable.OSListItemView_lil_right_image) {
                    this.f3797j = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.OSListItemView_lil_sub_progressbar) {
                    this.p = typedArrayObtainStyledAttributes.getBoolean(index, false);
                    this.f3792e0 = true;
                } else if (index == R$styleable.OSListItemView_lil_sub_seekbar) {
                    this.q = typedArrayObtainStyledAttributes.getBoolean(index, false);
                    this.f3792e0 = true;
                } else if (index == R$styleable.OSListItemView_lil_right_show_divide_line) {
                    this.f3803r = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSListItemView_lil_corners_angle_type) {
                    this.f3802o = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.OSListItemView_lil_item_type) {
                    this.f3786a = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.OSListItemView_lil_describe_show_red_dot) {
                    this.f3804s = typedArrayObtainStyledAttributes.getBoolean(index, false);
                    this.f3792e0 = true;
                } else if (index == R$styleable.OSListItemView_lil_group_title_show_arrow) {
                    this.f3805t = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSListItemView_lil_group_title_expand_up_and_down) {
                    this.u = typedArrayObtainStyledAttributes.getBoolean(index, false);
                    this.f3792e0 = true;
                } else if (index == R$styleable.OSListItemView_lil_open_new_page) {
                    boolean z2 = typedArrayObtainStyledAttributes.getBoolean(index, false);
                    setOpenNewPage(z2);
                    this.d0 = !z2;
                    this.f3792e0 = true;
                } else if (index == R$styleable.OSListItemView_lil_interactive_type) {
                    this.f3789b0 = typedArrayObtainStyledAttributes.getInt(index, 1);
                } else if (index == R$styleable.OSListItemView_lil_button_style_mod) {
                    this.I = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.OSListItemView_lil_button_short) {
                    this.J = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSListItemView_lil_button_text) {
                    this.K = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.OSListItemView_lil_left_image_show_badge) {
                    this.L = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSListItemView_lil_show_click_bg) {
                    this.f3792e0 = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSListItemView_lil_is_hios) {
                    this.R = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == R$styleable.OSListItemView_lil_intercept_right_view_touch_event) {
                    this.S = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSListItemView_lil_bg_color) {
                    this.f3787a0 = typedArrayObtainStyledAttributes.getColor(index, context.getColor(R$color.os_layer_medium_hios));
                } else if (index == R$styleable.OSListItemView_lil_show_bottom_divider) {
                    this.f3794h0 = typedArrayObtainStyledAttributes.getBoolean(index, false);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        setClickable(true);
        RelativeLayout.inflate(getContext(), R$layout.os_view_list_item_layout, this);
        if (this.f3786a == 1) {
            setMinimumHeight(getResources().getDimensionPixelOffset(R$dimen.os_list_item_title_min_height));
            int dimensionPixelOffset = this.R ? getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding) : getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_xos);
            setPadding(dimensionPixelOffset, getPaddingTop(), dimensionPixelOffset, getPaddingBottom());
        } else {
            setMinimumHeight(getResources().getDimensionPixelOffset(R$dimen.os_list_item_content_min_height));
            if (getBackground() == null) {
                setItemBg(Boolean.valueOf(this.f3792e0));
            }
        }
        c();
    }

    public final void b() {
        int i8 = 0;
        if (this.B != null && this.N == null) {
            OSIconTextView oSIconTextView = (OSIconTextView) ((ViewStub) findViewById(R$id.lil_stub_type_item_group_title_arrow)).inflate();
            this.N = oSIconTextView;
            if (this.f3786a != 1 || this.B == null || oSIconTextView == null) {
                return;
            }
            if (this.u) {
                oSIconTextView.setText(getContext().getString(R$string.os_Expand_up_and_down));
                TextView textView = this.C;
                if (textView != null) {
                    textView.getViewTreeObserver().addOnPreDrawListener(new c(this, i8));
                    return;
                }
                return;
            }
            if (this.f3805t) {
                oSIconTextView.setText("arrow_down");
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                layoutParams.addRule(15);
                this.N.setLayoutParams(layoutParams);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.N, "rotationX", 0.0f, 0.0f);
                this.Q = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R$anim.os_interpolator_liv_item_collapse));
                this.Q.setDuration(300L);
                this.Q.addListener(new d(this, i8));
            }
        }
    }

    public final void c() {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        int dimensionPixelSize;
        if (this.f3786a == 1) {
            if (this.B == null) {
                ((ViewStub) findViewById(R$id.lil_stub_type_item_group_title)).inflate();
                this.B = (TextView) findViewById(R$id.lil_type_item_group_title_title);
            }
            if (this.C == null) {
                this.C = (TextView) findViewById(R$id.lil_type_item_group_title_subtitle);
            }
            if (this.f3805t || this.u) {
                b();
            }
        } else {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_top);
            if (this.R) {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding);
                dimensionPixelOffset2 = dimensionPixelOffset;
            } else {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_xos);
                dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_end_xos);
            }
            if (this.f3798k) {
                if (!this.R) {
                    dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_space250);
                }
                if (this.O == null && this.f3793h != null) {
                    OSSmoothRoundCorner oSSmoothRoundCorner = (OSSmoothRoundCorner) ((ViewStub) findViewById(R$id.lil_stub_left_layout)).inflate();
                    this.O = oSSmoothRoundCorner;
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) oSSmoothRoundCorner.getLayoutParams();
                    layoutParams.addRule(15);
                    layoutParams.addRule(20);
                    this.O.setLayoutParams(layoutParams);
                } else if (this.P == null && !TextUtils.isEmpty(this.f3795i)) {
                    OSIconTextView oSIconTextView = (OSIconTextView) ((ViewStub) findViewById(R$id.lil_stub_left_text_icon_layout)).inflate();
                    this.P = oSIconTextView;
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) oSIconTextView.getLayoutParams();
                    layoutParams2.addRule(15);
                    layoutParams2.addRule(20);
                    this.P.setLayoutParams(layoutParams2);
                }
                if (this.L) {
                    BadgeView badgeView = (BadgeView) ((ViewStub) findViewById(R$id.lil_stub_left_image_badge)).inflate();
                    this.M = badgeView;
                    post(new ke.b(this, (RelativeLayout.LayoutParams) badgeView.getLayoutParams(), getResources().getDimensionPixelSize(R$dimen.os_list_item_left_image_badge_margin_top), getResources().getDimensionPixelSize(R$dimen.os_list_item_left_image_badge_margin_end)));
                    setClipToPadding(false);
                }
                View view = this.T;
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams3.removeRule(20);
                    OSSmoothRoundCorner oSSmoothRoundCorner2 = this.O;
                    if (oSSmoothRoundCorner2 != null) {
                        layoutParams3.addRule(17, oSSmoothRoundCorner2.getId());
                    } else {
                        OSIconTextView oSIconTextView2 = this.P;
                        if (oSIconTextView2 != null) {
                            layoutParams3.addRule(17, oSIconTextView2.getId());
                        }
                    }
                    this.T.setPadding(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
                    this.T.setLayoutParams(layoutParams3);
                }
                if (this.f3800m == 1) {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.os_list_item_left_image_big_dimen);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.os_list_item_padding_top);
                    int dimensionPixelOffset4 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_content_min_height);
                    if ((dimensionPixelSize2 * 2) + dimensionPixelSize > dimensionPixelOffset4) {
                        dimensionPixelOffset3 = (dimensionPixelOffset4 - dimensionPixelSize) / 2;
                    }
                } else {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.os_list_item_left_image_small_dimen);
                }
                OSSmoothRoundCorner oSSmoothRoundCorner3 = this.O;
                if (oSSmoothRoundCorner3 != null && this.f3793h != null) {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) oSSmoothRoundCorner3.getLayoutParams();
                    layoutParams4.width = dimensionPixelSize;
                    layoutParams4.height = dimensionPixelSize;
                    this.O.setLayoutParams(layoutParams4);
                    this.O.setImageDrawable(this.f3793h);
                } else if (this.P != null && !TextUtils.isEmpty(this.f3795i)) {
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
                    layoutParams5.width = dimensionPixelSize;
                    layoutParams5.height = dimensionPixelSize;
                    this.P.setLayoutParams(layoutParams5);
                    this.P.setText(this.f3795i);
                }
            }
            if (this.f3788b != null) {
                if (this.T == null) {
                    View viewInflate = ((ViewStub) findViewById(R$id.lil_stub_title_layout)).inflate();
                    this.T = viewInflate;
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) viewInflate.getLayoutParams();
                    OSSmoothRoundCorner oSSmoothRoundCorner4 = this.O;
                    if (oSSmoothRoundCorner4 == null && this.P == null) {
                        layoutParams6.addRule(20);
                    } else if (oSSmoothRoundCorner4 != null) {
                        layoutParams6.addRule(17, oSSmoothRoundCorner4.getId());
                    } else {
                        OSIconTextView oSIconTextView3 = this.P;
                        if (oSIconTextView3 != null) {
                            layoutParams6.addRule(17, oSIconTextView3.getId());
                        }
                    }
                    layoutParams6.addRule(15);
                    this.T.setPadding(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
                    this.T.setLayoutParams(layoutParams6);
                }
                if (this.f3810z == null) {
                    this.f3810z = (TextView) this.T.findViewById(R$id.lil_title);
                }
                if (!TextUtils.isEmpty(this.f3788b)) {
                    this.f3810z.setText(this.f3788b);
                }
                if (this.f3804s) {
                    if (this.U == null) {
                        this.U = ((ViewStub) findViewById(R$id.lil_stub_right_layout)).inflate();
                    }
                    RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
                    layoutParams7.addRule(15);
                    layoutParams7.addRule(21);
                    this.U.setLayoutParams(layoutParams7);
                    if (this.G == null) {
                        this.G = (BadgeView) ((ViewStub) this.U.findViewById(R$id.os_stub_list_view_red_point)).inflate();
                    }
                }
                if (this.f3790c != null) {
                    if (this.A == null) {
                        this.A = (TextView) ((ViewStub) this.T.findViewById(R$id.lil_stub_subtitle)).inflate();
                        dimensionPixelOffset3 = getResources().getDimensionPixelSize(R$dimen.os_list_item_padding_top);
                    }
                    if (!TextUtils.isEmpty(this.f3790c)) {
                        this.A.setText(this.f3790c);
                    }
                }
                if (this.p && this.f3808x == null) {
                    ProgressBar progressBar = (ProgressBar) ((ViewStub) this.T.findViewById(R$id.lil_stub_sub_progressbar)).inflate();
                    this.f3808x = progressBar;
                    this.f3808x.setLayoutParams((LinearLayout.LayoutParams) progressBar.getLayoutParams());
                    dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_progressbar_padding);
                    if (!this.R) {
                        dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_end_xos_progress);
                    }
                    View view2 = this.T;
                    view2.setPadding(view2.getPaddingLeft(), getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_top), view2.getPaddingRight(), view2.getPaddingBottom());
                }
                if (this.q && this.f3809y == null) {
                    setClipToPadding(false);
                    setClipChildren(false);
                    this.f3809y = (OSSeekbar) ((ViewStub) this.T.findViewById(R$id.lil_stub_sub_seekbar)).inflate();
                    int iApplyDimension = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                    this.f3809y.setPadding(iApplyDimension, 0, iApplyDimension, 0);
                    LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f3809y.getLayoutParams();
                    if (this.A == null) {
                        layoutParams8.topMargin = getResources().getDimensionPixelOffset(R$dimen.os_list_item_progressbar_internal_margin_top);
                    }
                    this.f3809y.setLayoutParams(layoutParams8);
                    dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_progressbar_padding);
                    View view3 = this.T;
                    view3.setPadding(view3.getPaddingLeft(), getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_top), view3.getPaddingRight(), view3.getPaddingBottom());
                }
            }
            if (this.f3801n != 0) {
                if (!this.R && !this.q && !this.p) {
                    dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_end_xos_icon);
                }
                if (this.U == null) {
                    this.U = ((ViewStub) findViewById(R$id.lil_stub_right_layout)).inflate();
                }
                if (this.f3803r && this.W == null) {
                    this.W = ((ViewStub) findViewById(R$id.lil_stub_right_divide_line)).inflate();
                }
                int i8 = this.f3801n;
                if (i8 == 2) {
                    if (this.F == null) {
                        if (this.U == null) {
                            this.U = ((ViewStub) findViewById(R$id.lil_stub_right_layout)).inflate();
                        }
                        OSIconTextView oSIconTextView4 = (OSIconTextView) this.U.findViewById(R$id.lil_right_image);
                        this.F = oSIconTextView4;
                        oSIconTextView4.setVisibility(0);
                        this.F.setDuplicateParentStateEnabled(false);
                        this.F.setClickable(true);
                        this.F.setTextColor(getContext().getColorStateList(R$color.os_icon_secondary));
                        if (this.f3786a == 2) {
                            this.F.setTextSize(0, getContext().getResources().getDimension(R$dimen.os_fontsize_h3));
                            this.F.setTextColor(j.d(R$attr.os_icon_disable, getContext().getColor(R$color.os_icon_disable_hios), getContext()));
                            this.F.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R$dimen.os_list_item_left_image_badge_margin_end), 0, 0, 0);
                        }
                    }
                    if (this.f3799l) {
                        if (TextUtils.isEmpty(this.f3797j)) {
                            this.F.setText(R$string.os_arrow_right_bold);
                            this.F.setRotationY(j.v() ? 180.0f : 0.0f);
                            this.F.setTextColor(j.d(R$attr.os_icon_disable, getContext().getColor(R$color.os_icon_disable_hios), getContext()));
                            this.F.setTextSize(0, getContext().getResources().getDimension(R$dimen.os_fontsize_h3));
                            this.F.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R$dimen.os_list_item_left_image_badge_margin_end), 0, 0, 0);
                            if (!this.d0) {
                                setOpenNewPage(true);
                            }
                        } else {
                            this.F.setText(this.f3797j);
                        }
                    }
                    if (this.f3791d != null) {
                        if (this.V == null) {
                            View viewInflate2 = ((ViewStub) findViewById(R$id.lil_stub_describe_layout)).inflate();
                            this.V = viewInflate2;
                            viewInflate2.setPadding(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
                        }
                        if (this.D == null) {
                            this.D = (TextView) ((ViewStub) findViewById(R$id.lil_stub_describe_title)).inflate();
                        }
                        TextView textView = this.D;
                        if (textView != null) {
                            textView.setMaxWidth(Integer.MAX_VALUE);
                        }
                        if (!TextUtils.isEmpty(this.f3791d)) {
                            this.D.setText(this.f3791d);
                        }
                        if (this.e != null) {
                            if (this.E == null) {
                                this.E = (TextView) ((ViewStub) findViewById(R$id.lil_stub_describe_subtitle)).inflate();
                            }
                            if (!TextUtils.isEmpty(this.e)) {
                                this.E.setText(this.e);
                            }
                        }
                    }
                } else if (i8 == 3) {
                    if (this.f3807w == null) {
                        RadioButton radioButton = (RadioButton) ((ViewStub) findViewById(R$id.lil_stub_right_radio)).inflate();
                        this.f3807w = radioButton;
                        radioButton.setClickable(false);
                        this.f3807w.setFocusable(false);
                        this.f3807w.setDuplicateParentStateEnabled(true);
                    }
                } else if (i8 == 4) {
                    if (this.f3806v == null) {
                        this.f3806v = (Switch) ((ViewStub) findViewById(R$id.lil_stub_right_switch)).inflate();
                    }
                } else if (i8 == 5) {
                    Context context = getContext();
                    if (this.H == null) {
                        this.H = (Button) ((ViewStub) findViewById(R$id.lil_stub_right_button)).inflate();
                    }
                    int i9 = this.I;
                    if (i9 == 1) {
                        this.H.setTextColor(ContextCompat.getColorStateList(context, com.transsion.widgetslib.R$color.os_platform_basic_color_selector));
                        this.H.setBackgroundResource(com.transsion.widgetslib.R$drawable.os_btn_big_gray);
                    } else if (i9 == 2) {
                        this.H.setTextColor(ContextCompat.getColorStateList(context, com.transsion.widgetslib.R$color.os_platform_red_color_selector));
                        this.H.setBackgroundResource(com.transsion.widgetslib.R$drawable.os_btn_big_gray);
                    } else if (i9 == 3) {
                        this.H.setTextColor(ContextCompat.getColorStateList(context, com.transsion.widgetslib.R$color.os_button_on_color_outline_selector));
                        this.H.setBackgroundResource(com.transsion.widgetslib.R$drawable.os_btn_big_outline_white);
                    }
                    int dimensionPixelOffset5 = (!j.t(context) || (j.r(context) && !j.m(context))) ? 0 : getResources().getDimensionPixelOffset(R$dimen.os_list_item_right_button_width_large_patch);
                    if (this.J) {
                        this.H.setWidth(getResources().getDimensionPixelOffset(R$dimen.os_list_item_right_button_short_width) + dimensionPixelOffset5);
                    } else {
                        this.H.setWidth(getResources().getDimensionPixelOffset(R$dimen.os_list_item_right_button_width) + dimensionPixelOffset5);
                    }
                    this.H.setText(this.K);
                }
                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
                layoutParams9.addRule(15);
                layoutParams9.addRule(21);
                this.U.setLayoutParams(layoutParams9);
                View view4 = this.T;
                if (view4 != null) {
                    RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) view4.getLayoutParams();
                    layoutParams10.addRule(16, this.U.getId());
                    this.T.setPadding(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
                    this.T.setLayoutParams(layoutParams10);
                }
            } else if (!this.R && !this.q && !this.p) {
                dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding_end_xos);
            }
            setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            post(new f(this, 25));
        }
        setBottomDividerVisible(this.f3794h0);
    }

    public final void d(Drawable drawable) {
        OSSmoothRoundCorner oSSmoothRoundCorner;
        this.f3793h = drawable;
        int i8 = this.f3786a;
        if (i8 == 0 || i8 == 2) {
            this.f3798k = true;
            this.f3800m = 0;
            if (this.O == null) {
                c();
            }
            oSSmoothRoundCorner = this.O;
        } else {
            oSSmoothRoundCorner = null;
        }
        oSSmoothRoundCorner.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (this.R) {
            b bVar = this.k0;
            bVar.getClass();
            if (bVar.b(l9.a.f7350k).c()) {
                int i8 = this.f3802o;
                if (i8 == 1) {
                    this.k0.a(canvas, getWidth(), getHeight(), this.f0, u8.a.ALL);
                } else if (i8 == 2) {
                    this.k0.a(canvas, getWidth(), getHeight(), this.f0, u8.a.TOP);
                } else if (i8 == 3) {
                    this.k0.a(canvas, getWidth(), getHeight(), this.f0, u8.a.BOTTOM);
                }
            } else {
                if (this.c0 == null) {
                    Context context = getContext();
                    if (this.c0 == null) {
                        this.c0 = new a(context, this);
                    }
                    this.c0 = this.c0;
                }
                a aVar = this.c0;
                int i9 = this.f3802o;
                float dimension = aVar.f8734a.getResources().getDimension(R$dimen.os_list_item_corners_radius);
                if (aVar.f6843l == null) {
                    aVar.f6843l = new Path();
                    aVar.f6844m = new RectF();
                    aVar.f6845n = new float[8];
                }
                if (i9 == 1) {
                    Arrays.fill(aVar.f6845n, dimension);
                } else if (i9 == 2) {
                    Arrays.fill(aVar.f6845n, 0, 4, dimension);
                    float[] fArr = aVar.f6845n;
                    Arrays.fill(fArr, 4, fArr.length, 0.0f);
                } else if (i9 == 3) {
                    Arrays.fill(aVar.f6845n, 0, 4, 0.0f);
                    float[] fArr2 = aVar.f6845n;
                    Arrays.fill(fArr2, 4, fArr2.length, dimension);
                } else {
                    Arrays.fill(aVar.f6845n, 0.0f);
                }
                aVar.f6843l.reset();
                aVar.f6844m.set(0.0f, 0.0f, getWidth(), getHeight());
                aVar.f6843l.addRoundRect(aVar.f6844m, aVar.f6845n, Path.Direction.CCW);
                canvas.clipPath(aVar.f6843l);
            }
        }
        super.draw(canvas);
    }

    @Nullable
    public BadgeView getBadgeView() {
        if (this.f3786a != 0) {
            return null;
        }
        this.f3788b = "";
        this.f3804s = true;
        if (this.G == null) {
            c();
        }
        return this.G;
    }

    public Button getButton() {
        return this.H;
    }

    public BadgeView getLeftImageBadgeView() {
        return this.M;
    }

    @Nullable
    public ProgressBar getProgressBar() {
        if (this.f3786a != 0) {
            return null;
        }
        this.f3788b = "";
        this.p = true;
        if (this.f3808x == null) {
            c();
        }
        return this.f3808x;
    }

    @Nullable
    public RadioButton getRadioButton() {
        if (this.f3786a != 0) {
            return null;
        }
        this.f3801n = 3;
        if (this.f3807w == null) {
            c();
        }
        return this.f3807w;
    }

    @Nullable
    public OSIconTextView getRightImageView() {
        int i8 = this.f3786a;
        if (i8 != 0 && i8 != 2) {
            return null;
        }
        this.f3801n = 2;
        if (this.F == null) {
            c();
        }
        return this.F;
    }

    @Nullable
    public OSSeekbar getSeekBar() {
        if (this.f3786a != 0) {
            return null;
        }
        this.f3788b = "";
        this.q = true;
        if (this.f3809y == null) {
            c();
        }
        return this.f3809y;
    }

    @Nullable
    public Switch getSwitch() {
        if (this.f3786a != 0) {
            return null;
        }
        this.f3801n = 4;
        if (this.f3806v == null) {
            c();
        }
        return this.f3806v;
    }

    @Nullable
    public TextView getViewDescribeSubtitle() {
        int i8 = this.f3786a;
        if (i8 != 0 && i8 != 2) {
            return null;
        }
        this.f3801n = 2;
        this.e = "";
        if (this.E == null) {
            c();
        }
        return this.E;
    }

    @Nullable
    public TextView getViewDescribeTitle() {
        int i8 = this.f3786a;
        if (i8 != 0 && i8 != 2) {
            return null;
        }
        this.f3801n = 2;
        this.f3791d = "";
        this.f3799l = true;
        if (this.D == null) {
            c();
        }
        return this.D;
    }

    @Nullable
    public TextView getViewGroupSubTitle() {
        if (this.f3786a != 1) {
            return null;
        }
        if (this.C == null) {
            c();
        }
        return this.C;
    }

    @Nullable
    public TextView getViewGroupTitle() {
        if (this.f3786a != 1) {
            return null;
        }
        if (this.B == null) {
            c();
        }
        return this.B;
    }

    @Nullable
    public OSIconTextView getViewGroupTitleArrow() {
        if (this.f3786a != 1) {
            return null;
        }
        if (this.N == null) {
            c();
        }
        return this.N;
    }

    @Nullable
    public View getViewRightDivideLine() {
        if (this.f3786a != 0 || this.f3801n == 0) {
            return null;
        }
        if (this.W == null) {
            this.W = ((ViewStub) findViewById(R$id.lil_stub_right_divide_line)).inflate();
        }
        return this.W;
    }

    @Nullable
    public TextView getViewSubtitle() {
        int i8 = this.f3786a;
        if (i8 != 0 && i8 != 2) {
            return null;
        }
        this.f3790c = "";
        if (this.A == null) {
            c();
        }
        return this.A;
    }

    @Nullable
    public TextView getViewTitle() {
        int i8 = this.f3786a;
        if (i8 != 0 && i8 != 2) {
            return null;
        }
        this.f3788b = "";
        if (this.f3810z == null) {
            c();
        }
        return this.f3810z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.Q;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.Q.cancel();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OSIconTextView oSIconTextView;
        int action = motionEvent.getAction();
        boolean z2 = false;
        if (action == 0) {
            if (this.F != null && (getContext().getString(R$string.os_arrow_right_bold).equalsIgnoreCase(this.F.getText().toString()) || getContext().getString(R$string.os_Expand_up_and_down).equalsIgnoreCase(this.F.getText().toString()))) {
                z2 = true;
            }
            if (this.S) {
                z2 = true;
            }
            if (z2) {
                OSIconTextView oSIconTextView2 = this.F;
                if (oSIconTextView2 != null) {
                    oSIconTextView2.setPressed(true);
                }
                return true;
            }
        } else if ((action == 1 || action == 3) && (oSIconTextView = this.F) != null) {
            oSIconTextView.setPressed(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        a aVar = this.c0;
        if (aVar.e != null && ((view = aVar.f8735b) == null || view.isEnabled())) {
            int action = motionEvent.getAction();
            Rect rect = aVar.f8739h;
            if (action == 0) {
                ValueAnimator valueAnimator = aVar.f8736c;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                aVar.e.setAlpha(255);
                aVar.f8740i = true;
                View view2 = aVar.f8735b;
                if (view2 != null) {
                    view2.getGlobalVisibleRect(rect);
                }
            } else if (action == 1) {
                if (!aVar.f8741j && action == 1 && aVar.f8740i) {
                    aVar.f8742k = true;
                } else {
                    aVar.a(100L);
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (!aVar.f8741j) {
                        aVar.a(100L);
                    } else {
                        aVar.a(100L);
                    }
                }
            } else if (aVar.f8735b != null && aVar.f8740i) {
                aVar.f8740i = rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        if (z2) {
            a aVar = this.c0;
            if (aVar.f8741j && aVar.f8742k) {
                aVar.a(150L);
            }
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            a aVar = this.c0;
            if (aVar.f8741j && aVar.f8742k) {
                aVar.a(150L);
            }
        }
    }

    public void setBottomDividerVisible(boolean z2) {
        this.f3794h0 = z2;
        if (!z2) {
            FrameLayout frameLayout = this.j0;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
                return;
            }
            return;
        }
        if (this.j0 == null) {
            this.j0 = (FrameLayout) ((ViewStub) findViewById(R$id.lil_stub_divide_layout)).inflate();
        }
        this.j0.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j0.getLayoutParams();
        layoutParams.addRule(12);
        OSSmoothRoundCorner oSSmoothRoundCorner = this.O;
        if (oSSmoothRoundCorner != null || this.P != null) {
            layoutParams.setMarginStart(getResources().getDimensionPixelOffset(R$dimen.os_list_item_padding) + (oSSmoothRoundCorner != null ? oSSmoothRoundCorner.getLayoutParams() : this.P.getLayoutParams()).width);
        }
        this.j0.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        a aVar;
        Drawable drawable;
        super.setEnabled(z2);
        if (z2 || (drawable = (aVar = this.c0).e) == null || drawable.getAlpha() == 0) {
            return;
        }
        ValueAnimator valueAnimator = aVar.f8736c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            aVar.f8736c.cancel();
        } else {
            aVar.e.setAlpha(0);
            aVar.f8742k = false;
        }
    }

    public void setGroupArrowExpend(boolean z2) {
        if (this.f3786a != 1) {
            return;
        }
        setShowGroupTitleArrow(true);
        OSIconTextView oSIconTextView = this.N;
        if (oSIconTextView != null) {
            oSIconTextView.setRotationX(z2 ? -180.0f : 0.0f);
        }
    }

    public void setInteractiveType(int i8) {
        this.f3789b0 = i8;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        setBackground(null);
        setItemBg(Boolean.valueOf(this.f3792e0));
        setPadding(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    public void setIsShowLeftImageBadgeView(boolean z2) {
        this.L = z2;
    }

    public void setItemEnable(boolean z2) {
        Drawable drawable;
        Drawable drawable2;
        setEnabled(z2);
        if (z2) {
            TextView textView = this.f3810z;
            if (textView != null) {
                textView.setTextColor(j.e(getContext(), R$attr.os_text_primary, R$color.os_text_primary_hios));
            }
            TextView textView2 = this.A;
            if (textView2 != null) {
                textView2.setTextColor(j.e(getContext(), R$attr.os_text_info, R$color.os_text_info_hios));
            }
            TextView textView3 = this.B;
            if (textView3 != null) {
                textView3.setTextColor(j.e(getContext(), R$attr.os_text_info, R$color.os_text_info_hios));
            }
            TextView textView4 = this.D;
            if (textView4 != null) {
                textView4.setTextColor(j.e(getContext(), R$attr.os_text_info, R$color.os_text_info_hios));
            }
            if (this.O != null && (drawable2 = this.f3793h) != null) {
                drawable2.setAlpha(255);
                this.O.setImageDrawable(this.f3793h);
            }
        } else {
            TextView textView5 = this.f3810z;
            if (textView5 != null) {
                textView5.setTextColor(j.e(getContext(), R$attr.os_text_disable, R$color.os_text_disable_hios));
            }
            TextView textView6 = this.A;
            if (textView6 != null) {
                textView6.setTextColor(j.e(getContext(), R$attr.os_text_disable, R$color.os_text_disable_hios));
            }
            TextView textView7 = this.B;
            if (textView7 != null) {
                textView7.setTextColor(j.e(getContext(), R$attr.os_text_disable, R$color.os_text_disable_hios));
            }
            TextView textView8 = this.D;
            if (textView8 != null) {
                textView8.setTextColor(j.e(getContext(), R$attr.os_text_disable, R$color.os_text_disable_hios));
            }
            if (this.O != null && (drawable = this.f3793h) != null) {
                drawable.setAlpha(102);
                this.O.setImageDrawable(this.f3793h);
            }
        }
        Button button = this.H;
        if (button != null) {
            button.setEnabled(z2);
        }
        RadioButton radioButton = this.f3807w;
        if (radioButton != null) {
            radioButton.setEnabled(z2);
        }
        Switch r7 = this.f3806v;
        if (r7 != null) {
            r7.setEnabled(z2);
        }
        OSSeekbar oSSeekbar = this.f3809y;
        if (oSSeekbar != null) {
            oSSeekbar.setEnabled(z2);
        }
        ProgressBar progressBar = this.f3808x;
        if (progressBar != null) {
            progressBar.setEnabled(z2);
            int iE = j.e(getContext(), R$attr.os_brand_primary, R$color.os_brand_primary_hios);
            if (!z2) {
                iE = j.e(getContext(), R$attr.os_grayfill_base, R$color.os_grayfill_base_hios);
            }
            this.f3808x.setProgressTintList(ColorStateList.valueOf(iE));
        }
    }

    public void setLeftImageStrokeColor(int i8) {
        OSSmoothRoundCorner oSSmoothRoundCorner = this.O;
        if (oSSmoothRoundCorner != null) {
            oSSmoothRoundCorner.setStrokeColor(i8);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        if (this.f3786a != 1) {
            setItemBg(Boolean.TRUE);
        }
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        if (this.f3786a != 1) {
            setItemBg(Boolean.TRUE);
        }
        super.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMenuClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }

    public void setOpenNewPage(boolean z2) {
        this.c0.setOpenNewPage(z2);
    }

    public void setRedDotVisible(boolean z2) {
        if (this.f3810z == null) {
            return;
        }
        if (this.G == null) {
            this.G = (BadgeView) ((ViewStub) findViewById(R$id.os_stub_list_view_red_point)).inflate();
        }
        this.G.setVisibility(z2 ? 0 : 8);
    }

    public void setShowGroupTitleArrow(boolean z2) {
        if (this.f3786a != 1) {
            return;
        }
        this.f3805t = z2;
        if (this.N == null) {
            b();
        }
        this.N.setVisibility(z2 ? 0 : 8);
    }

    public OSListItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3797j = "";
        this.f3802o = 0;
        this.R = true;
        this.S = false;
        this.f3787a0 = j.e(getContext(), R$attr.os_layer_medium, R$color.os_layer_medium_hios);
        this.f3789b0 = 1;
        this.c0 = null;
        this.f3792e0 = false;
        this.f0 = 0.0f;
        this.f3794h0 = false;
        this.f3796i0 = false;
        a(context, attributeSet);
    }

    public OSListItemView(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3797j = "";
        this.f3802o = 0;
        this.R = true;
        this.S = false;
        this.f3787a0 = j.e(getContext(), R$attr.os_layer_medium, R$color.os_layer_medium_hios);
        this.f3789b0 = 1;
        this.c0 = null;
        this.f3792e0 = false;
        this.f0 = 0.0f;
        this.f3794h0 = false;
        this.f3796i0 = false;
        a(context, attributeSet);
    }
}
