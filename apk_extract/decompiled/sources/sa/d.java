package sa;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.bean.LottieAsset;
import com.transsion.iotservice.multiscreen.pc.bean.RoundedCardData;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import com.transsion.iotservice.multiscreen.pc.ui.view.RoundedCardView;
import com.transsion.widgetslib.view.indicator.PageIndicatorWrapper;
import com.transsion.widgetslib.view.indicator.SpringPageIndicator;
import com.transsion.widgetslistitemlayout.OSListItemView;
import d6.t;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.rd;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final void a(LottieAnimationView lottieAnimationView, LottieAsset lottieAssetConfig, Boolean bool) {
        String path;
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        Intrinsics.checkNotNullParameter(lottieAssetConfig, "lottieAssetConfig");
        if (lottieAssetConfig.getSupportDayNight()) {
            path = Intrinsics.areEqual(bool, Boolean.TRUE) ? h0.a.B(lottieAssetConfig.getPath(), "/night") : h0.a.B(lottieAssetConfig.getPath(), "/light");
        } else {
            path = lottieAssetConfig.getPath();
        }
        if (lottieAssetConfig.getContainImage()) {
            lottieAnimationView.setImageAssetsFolder(path + "/images");
        }
        if (StringsKt__StringsKt.contains$default(lottieAssetConfig.getPath(), "trusted_device", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((String) na.c.f8133a.getValue(), "hios", false, 2, (Object) null)) {
            lottieAnimationView.setAlpha(Intrinsics.areEqual(bool, Boolean.TRUE) ? 0.24f : 0.12f);
            lottieAnimationView.setBackgroundColor(0);
        }
        lottieAnimationView.setAnimation(path + "/data.json");
        lottieAnimationView.d();
    }

    public static final void b(int i8, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i8);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void c(OSListItemView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            switch (str.hashCode()) {
                case -2115632797:
                    if (str.equals("top_corners_round")) {
                        view.f3802o = 2;
                        view.invalidate();
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        view.f3802o = 0;
                        view.invalidate();
                        break;
                    }
                    break;
                case 108704142:
                    if (str.equals("round")) {
                        view.f3802o = 1;
                        view.invalidate();
                        break;
                    }
                    break;
                case 1598204857:
                    if (str.equals("bottom_corners_round")) {
                        view.f3802o = 3;
                        view.invalidate();
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(OSListItemView view, MutableLiveData mutableLiveData) {
        String str;
        TextView viewDescribeTitle;
        Intrinsics.checkNotNullParameter(view, "view");
        if (mutableLiveData == null || (str = (String) mutableLiveData.getValue()) == null || (viewDescribeTitle = view.getViewDescribeTitle()) == null) {
            return;
        }
        viewDescribeTitle.setText(str);
    }

    public static final void e(OSListItemView view, boolean z2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Switch r7 = view.getSwitch();
        if (r7 != null) {
            r7.setChecked(z2);
        }
    }

    public static final void f(OSListItemView view, String str, String str2) {
        TextView viewSubtitle;
        TextView viewTitle;
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null && (viewTitle = view.getViewTitle()) != null) {
            viewTitle.setText(str);
        }
        if (str2 == null || (viewSubtitle = view.getViewSubtitle()) == null) {
            return;
        }
        viewSubtitle.setText(str2);
    }

    public static final void g(AnimView view, VapResource vapResource, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (vapResource == null) {
            Intrinsics.checkNotNullParameter("AnimView", "tag");
            Intrinsics.checkNotNullParameter("item null stopPlay", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("AnimView"), "item null stopPlay");
            }
            d6.d dVar = view.f2299a;
            t tVar = dVar.f4314d;
            if (tVar != null) {
                tVar.f4353j = true;
            }
            d6.l lVar = dVar.e;
            if (lVar == null) {
                return;
            }
            lVar.f4332h = true;
            return;
        }
        d6.d dVar2 = view.f2299a;
        t tVar2 = dVar2.f4314d;
        if (tVar2 != null) {
            tVar2.f4353j = true;
        }
        d6.l lVar2 = dVar2.e;
        if (lVar2 != null) {
            lVar2.f4332h = true;
        }
        Intrinsics.checkNotNullParameter("AnimView", "tag");
        Intrinsics.checkNotNullParameter("playAnim", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("AnimView"), "playAnim");
        }
        i(view, vapResource, bool, bool2 != null ? bool2.booleanValue() : true);
    }

    public static final void h(ViewPager2 vp, ListAdapter listAdapter, List list, final PageIndicatorWrapper pageIndicatorWrapper, Integer num) {
        Intrinsics.checkNotNullParameter(vp, "vp");
        RecyclerView.Adapter adapter = vp.getAdapter();
        vp.setCurrentItem(num != null ? num.intValue() : 0);
        if (adapter == null) {
            vp.setOffscreenPageLimit(1);
            if (list != null && list.size() > 1 && pageIndicatorWrapper != null) {
                int size = list.size();
                for (int i8 = 0; i8 < size; i8++) {
                    SpringPageIndicator springPageIndicator = pageIndicatorWrapper.f3272a;
                    springPageIndicator.A.add(new td.e());
                    if (springPageIndicator.f3291x == null || springPageIndicator.f3289v == null) {
                        springPageIndicator.B = 0;
                        springPageIndicator.C = 0;
                        td.e eVar = (td.e) springPageIndicator.A.get(0);
                        springPageIndicator.f3289v = eVar;
                        springPageIndicator.f3291x = eVar;
                    }
                    springPageIndicator.d();
                    springPageIndicator.a();
                    springPageIndicator.requestLayout();
                }
            }
            vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.transsion.iotservice.multiscreen.pc.adapter.CommonDataBindingAdapter$bindViewPager2$2$1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public final void onPageScrolled(int i9, float f, int i10) {
                    PageIndicatorWrapper pageIndicatorWrapper2 = pageIndicatorWrapper;
                    if (pageIndicatorWrapper2 != null) {
                        pageIndicatorWrapper2.setActiveMarker(i9);
                    }
                    float f4 = (j.v() ? -1 : 1) * f;
                    if (pageIndicatorWrapper2 != null) {
                        pageIndicatorWrapper2.a(f4);
                    }
                    super.onPageScrolled(i9, f, i10);
                }
            });
            if (listAdapter != null) {
                vp.setAdapter(listAdapter);
                listAdapter.submitList(list);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static void i(AnimView animView, VapResource vapResource, Boolean bool, boolean z2) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Ref.IntRef intRef = new Ref.IntRef();
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        c cVar = new c(atomicBoolean, intRef, atomicBoolean2, animView, vapResource, z2, bool);
        animView.setAnimListener(new b(atomicBoolean, animView, cVar, intRef, vapResource, bool, z2, atomicBoolean2));
        if (animView.getParent() != null) {
            rd.a(animView, vapResource, bool, z2);
            animView.postDelayed(cVar, 300L);
        } else if (!animView.isLaidOut() || animView.isLayoutRequested()) {
            animView.addOnLayoutChangeListener(new a(animView, vapResource, z2, bool, cVar));
        } else {
            rd.a(animView, vapResource, bool, z2);
            animView.postDelayed(cVar, 300L);
        }
    }

    public static final void j(View view, AnimationSet animationSet) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (animationSet == null) {
            view.clearAnimation();
        } else {
            view.startAnimation(animationSet);
            view.setVisibility(0);
        }
    }

    public static final void k(RoundedCardView view, RoundedCardData roundedCardData) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (roundedCardData != null) {
            view.setTitle(roundedCardData.getTitleResId());
            view.setContent(roundedCardData.getContentResId());
            String lightPath = roundedCardData.getLightLottiePath();
            String darkPath = roundedCardData.getDarkLottiePath();
            Intrinsics.checkNotNullParameter(lightPath, "lightPath");
            Intrinsics.checkNotNullParameter(darkPath, "darkPath");
            view.f2897d = lightPath;
            view.e = darkPath;
            view.a();
        }
    }

    public static final void l(OSListItemView view, int i8) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), i8);
        if (drawable != null) {
            view.d(drawable);
            view.setLeftImageStrokeColor(0);
        }
    }
}
