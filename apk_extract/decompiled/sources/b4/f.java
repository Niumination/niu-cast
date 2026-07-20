package b4;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.search.SearchView;
import com.transsion.iotservice.multiscreen.pc.helper.BaseSettingActivity;
import com.transsion.widgetslib.flipper.FlipperLayout;
import com.transsion.widgetsliquid.view.OSLiquidSpringFloatingOvalButton;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;
import kotlin.jvm.internal.Intrinsics;
import nd.l;
import pd.j;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1204b;

    public /* synthetic */ f(Object obj, int i8) {
        this.f1203a = i8;
        this.f1204b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Object obj = this.f1204b;
        switch (this.f1203a) {
            case 0:
                return ((SearchView) obj).lambda$setUpContentOnTouchListener$3(view, motionEvent);
            case 1:
                int i8 = BaseSettingActivity.f2662k;
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.setAlpha(0.2f);
                } else if (action == 1) {
                    view.setAlpha(1.0f);
                    ((BaseSettingActivity) obj).p(false);
                } else if (action == 3) {
                    view.setAlpha(1.0f);
                }
                return false;
            case 2:
                return OSLiquidSpringFloatingOvalButton._init_$lambda$3((OSLiquidSpringFloatingOvalButton) obj, view, motionEvent);
            case 3:
                return OSLiquidToolBar.setIconTouchAnim$lambda$28((OSLiquidToolBar) obj, view, motionEvent);
            case 4:
                return OSLiquidWidgetToolBar.setIconTouchAnim$lambda$28((OSLiquidWidgetToolBar) obj, view, motionEvent);
            case 5:
                FlipperLayout this$0 = (FlipperLayout) obj;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                int action2 = motionEvent.getAction();
                if (action2 == 0) {
                    this$0.C = motionEvent.getX();
                } else if (action2 == 1) {
                    if (this$0.C == motionEvent.getX()) {
                        view.performClick();
                    } else {
                        boolean zV = j.v();
                        ViewPager2 viewPager2 = this$0.f3052a;
                        if (zV) {
                            if (this$0.C > motionEvent.getX()) {
                                if (viewPager2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                    viewPager2 = null;
                                }
                                l.a(viewPager2, this$0.f3056h - 1, true);
                            } else {
                                if (viewPager2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                    viewPager2 = null;
                                }
                                l.a(viewPager2, this$0.f3056h + 1, true);
                            }
                        } else if (this$0.C > motionEvent.getX()) {
                            if (viewPager2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                viewPager2 = null;
                            }
                            l.a(viewPager2, this$0.f3056h + 1, true);
                        } else {
                            if (viewPager2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                viewPager2 = null;
                            }
                            l.a(viewPager2, this$0.f3056h - 1, true);
                        }
                    }
                }
                return true;
            default:
                return ((DragStartHelper) obj).onTouch(view, motionEvent);
        }
    }
}
