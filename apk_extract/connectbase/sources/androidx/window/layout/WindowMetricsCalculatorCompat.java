package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import dc.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {

    @l
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();

    @l
    private static final String TAG;

    static {
        l0.o("WindowMetricsCalculatorCompat", "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = "WindowMetricsCalculatorCompat";
    }

    private WindowMetricsCalculatorCompat() {
    }

    @RequiresApi(28)
    @b.a({"BanUncheckedReflection"})
    private final DisplayCutout getCutoutForDisplay(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
            return null;
        } catch (ClassNotFoundException e10) {
            Log.w(TAG, e10);
            return null;
        } catch (IllegalAccessException e11) {
            Log.w(TAG, e11);
            return null;
        } catch (InstantiationException e12) {
            Log.w(TAG, e12);
            return null;
        } catch (NoSuchFieldException e13) {
            Log.w(TAG, e13);
            return null;
        } catch (NoSuchMethodException e14) {
            Log.w(TAG, e14);
            return null;
        } catch (InvocationTargetException e15) {
            Log.w(TAG, e15);
            return null;
        }
    }

    private final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", d.f3680k, "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void getRectSizeFromDisplay(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    @l
    public WindowMetrics computeCurrentWindowMetrics(@l Activity activity) {
        l0.p(activity, "activity");
        return new WindowMetrics(ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(activity));
    }

    @Override // androidx.window.layout.WindowMetricsCalculator
    @l
    public WindowMetrics computeMaximumWindowMetrics(@l Activity activity) {
        l0.p(activity, "activity");
        return new WindowMetrics(ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(activity));
    }

    @l
    public final Rect computeWindowBoundsIceCreamSandwich$window_release(@l Activity activity) {
        int i10;
        l0.p(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        l0.o(defaultDisplay, "defaultDisplay");
        Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
        Rect rect = new Rect();
        int i11 = realSizeForDisplay$window_release.x;
        if (i11 == 0 || (i10 = realSizeForDisplay$window_release.y) == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = i11;
            rect.bottom = i10;
        }
        return rect;
    }

    @RequiresApi(24)
    @l
    public final Rect computeWindowBoundsN$window_release(@l Activity activity) {
        l0.p(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            l0.o(defaultDisplay, "defaultDisplay");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i10 = rect.bottom;
            if (i10 + navigationBarHeight == realSizeForDisplay$window_release.y) {
                rect.bottom = i10 + navigationBarHeight;
            } else {
                int i11 = rect.right;
                if (i11 + navigationBarHeight == realSizeForDisplay$window_release.x) {
                    rect.right = i11 + navigationBarHeight;
                }
            }
        }
        return rect;
    }

    @RequiresApi(28)
    @b.a({"BanUncheckedReflection", "BlockedPrivateApi"})
    @l
    public final Rect computeWindowBoundsP$window_release(@l Activity activity) {
        DisplayCutout cutoutForDisplay;
        l0.p(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                if (objInvoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, e11);
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchMethodException e12) {
            Log.w(TAG, e12);
            getRectSizeFromDisplay(activity, rect);
        } catch (InvocationTargetException e13) {
            Log.w(TAG, e13);
            getRectSizeFromDisplay(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayCompatHelperApi17 displayCompatHelperApi17 = DisplayCompatHelperApi17.INSTANCE;
        l0.o(defaultDisplay, "currentDisplay");
        displayCompatHelperApi17.getRealSize(defaultDisplay, point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.INSTANCE;
        if (!activityCompatHelperApi24.isInMultiWindowMode(activity)) {
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i10 = rect.bottom;
            if (i10 + navigationBarHeight == point.y) {
                rect.bottom = i10 + navigationBarHeight;
            } else {
                int i11 = rect.right;
                if (i11 + navigationBarHeight == point.x) {
                    rect.right = i11 + navigationBarHeight;
                } else if (rect.left == navigationBarHeight) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activityCompatHelperApi24.isInMultiWindowMode(activity) && (cutoutForDisplay = getCutoutForDisplay(defaultDisplay)) != null) {
            int i12 = rect.left;
            DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.INSTANCE;
            if (i12 == displayCompatHelperApi28.safeInsetLeft(cutoutForDisplay)) {
                rect.left = 0;
            }
            if (point.x - rect.right == displayCompatHelperApi28.safeInsetRight(cutoutForDisplay)) {
                rect.right = displayCompatHelperApi28.safeInsetRight(cutoutForDisplay) + rect.right;
            }
            if (rect.top == displayCompatHelperApi28.safeInsetTop(cutoutForDisplay)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay)) {
                rect.bottom = displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay) + rect.bottom;
            }
        }
        return rect;
    }

    @RequiresApi(29)
    @b.a({"BanUncheckedReflection", "BlockedPrivateApi"})
    @l
    public final Rect computeWindowBoundsQ$window_release(@l Activity activity) {
        l0.p(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            if (objInvoke != null) {
                return new Rect((Rect) objInvoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (IllegalAccessException e10) {
            Log.w(TAG, e10);
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, e11);
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchMethodException e12) {
            Log.w(TAG, e12);
            return computeWindowBoundsP$window_release(activity);
        } catch (InvocationTargetException e13) {
            Log.w(TAG, e13);
            return computeWindowBoundsP$window_release(activity);
        }
    }

    @VisibleForTesting
    @l
    public final Point getRealSizeForDisplay$window_release(@l Display display) {
        l0.p(display, "display");
        Point point = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(display, point);
        return point;
    }
}
