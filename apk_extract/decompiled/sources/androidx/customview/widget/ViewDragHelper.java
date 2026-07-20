package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f4 = f - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    };
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final Runnable mSetIdleRunnable = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i8, int i9) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i8, int i9) {
            return 0;
        }

        public int getOrderedChildIndex(int i8) {
            return i8;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i8, int i9) {
        }

        public boolean onEdgeLock(int i8) {
            return false;
        }

        public void onEdgeTouched(int i8, int i9) {
        }

        public void onViewCaptured(@NonNull View view, int i8) {
        }

        public void onViewDragStateChanged(int i8) {
        }

        public void onViewPositionChanged(@NonNull View view, int i8, int i9, @Px int i10, @Px int i11) {
        }

        public void onViewReleased(@NonNull View view, float f, float f4) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i8);
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.mParentView = viewGroup;
        this.mCallback = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i8 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = i8;
        this.mEdgeSize = i8;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(context, sInterpolator);
    }

    private boolean checkNewEdgeDrag(float f, float f4, int i8, int i9) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f4);
        if ((this.mInitialEdgesTouched[i8] & i9) != i9 || (this.mTrackingEdges & i9) == 0 || (this.mEdgeDragsLocked[i8] & i9) == i9 || (this.mEdgeDragsInProgress[i8] & i9) == i9) {
            return false;
        }
        int i10 = this.mTouchSlop;
        if (fAbs <= i10 && fAbs2 <= i10) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.mCallback.onEdgeLock(i9)) {
            return (this.mEdgeDragsInProgress[i8] & i9) == 0 && fAbs > ((float) this.mTouchSlop);
        }
        int[] iArr = this.mEdgeDragsLocked;
        iArr[i8] = iArr[i8] | i9;
        return false;
    }

    private boolean checkTouchSlop(View view, float f, float f4) {
        if (view == null) {
            return false;
        }
        boolean z2 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z3 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (z2 && z3) {
            float f10 = (f4 * f4) + (f * f);
            int i8 = this.mTouchSlop;
            return f10 > ((float) (i8 * i8));
        }
        if (z2) {
            return Math.abs(f) > ((float) this.mTouchSlop);
        }
        return z3 && Math.abs(f4) > ((float) this.mTouchSlop);
    }

    private int clampMag(int i8, int i9, int i10) {
        int iAbs = Math.abs(i8);
        if (iAbs < i9) {
            return 0;
        }
        if (iAbs > i10) {
            return i8 > 0 ? i10 : -i10;
        }
        return i8;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i8, int i9, int i10) {
        if (i8 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f = width / 2;
        float fDistanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i8) / width)) * f) + f;
        int iAbs = Math.abs(i9);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i8) / i10) + 1.0f) * 256.0f), 600);
    }

    private int computeSettleDuration(View view, int i8, int i9, int i10, int i11) {
        float f;
        float f4;
        float f10;
        float f11;
        int iClampMag = clampMag(i10, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int iClampMag2 = clampMag(i11, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int iAbs = Math.abs(i8);
        int iAbs2 = Math.abs(i9);
        int iAbs3 = Math.abs(iClampMag);
        int iAbs4 = Math.abs(iClampMag2);
        int i12 = iAbs3 + iAbs4;
        int i13 = iAbs + iAbs2;
        if (iClampMag != 0) {
            f = iAbs3;
            f4 = i12;
        } else {
            f = iAbs;
            f4 = i13;
        }
        float f12 = f / f4;
        if (iClampMag2 != 0) {
            f10 = iAbs4;
            f11 = i12;
        } else {
            f10 = iAbs2;
            f11 = i13;
        }
        return (int) ((computeAxisDuration(i9, iClampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f10 / f11)) + (computeAxisDuration(i8, iClampMag, this.mCallback.getViewHorizontalDragRange(view)) * f12));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f, float f4) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f, f4);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i8, int i9, int i10, int i11) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i10 != 0) {
            i8 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i8, i10);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i8 - left);
        }
        int i12 = i8;
        if (i11 != 0) {
            i9 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i9, i11);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i9 - top);
        }
        int i13 = i9;
        if (i10 == 0 && i11 == 0) {
            return;
        }
        this.mCallback.onViewPositionChanged(this.mCapturedView, i12, i13, i12 - left, i13 - top);
    }

    private void ensureMotionHistorySizeForId(int i8) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i8) {
            int i9 = i8 + 1;
            float[] fArr2 = new float[i9];
            float[] fArr3 = new float[i9];
            float[] fArr4 = new float[i9];
            float[] fArr5 = new float[i9];
            int[] iArr = new int[i9];
            int[] iArr2 = new int[i9];
            int[] iArr3 = new int[i9];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i8, int i9, int i10, int i11) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i12 = i8 - left;
        int i13 = i9 - top;
        if (i12 == 0 && i13 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i12, i13, computeSettleDuration(this.mCapturedView, i12, i13, i10, i11));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i8, int i9) {
        int i10 = i8 < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i9 < this.mParentView.getTop() + this.mEdgeSize) {
            i10 |= 4;
        }
        if (i8 > this.mParentView.getRight() - this.mEdgeSize) {
            i10 |= 2;
        }
        return i9 > this.mParentView.getBottom() - this.mEdgeSize ? i10 | 8 : i10;
    }

    private boolean isValidPointerForActionMove(int i8) {
        if (isPointerDown(i8)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i8 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void reportNewEdgeDrags(float f, float f4, int i8) {
        int i9;
        boolean zCheckNewEdgeDrag = checkNewEdgeDrag(f, f4, i8, 1);
        ?? r7 = zCheckNewEdgeDrag;
        if (checkNewEdgeDrag(f4, f, i8, 4)) {
            r7 = (zCheckNewEdgeDrag ? 1 : 0) | 4;
        }
        ?? r10 = r7;
        if (checkNewEdgeDrag(f, f4, i8, 2)) {
            r10 = (r7 == true ? 1 : 0) | 2;
        }
        ?? r11 = r10;
        if (checkNewEdgeDrag(f4, f, i8, 8)) {
            i9 = (r10 == true ? 1 : 0) | 8;
        }
        if (r11 == 0) {
            r11 = i9;
            return;
        }
        r11 = i9;
        int[] iArr = this.mEdgeDragsInProgress;
        iArr[i8] = (iArr[i8] | r11) == true ? 1 : 0;
        this.mCallback.onEdgeDragStarted(r11, i8);
    }

    private void saveInitialMotion(float f, float f4, int i8) {
        ensureMotionHistorySizeForId(i8);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i8] = f;
        fArr[i8] = f;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i8] = f4;
        fArr2[i8] = f4;
        this.mInitialEdgesTouched[i8] = getEdgesTouched((int) f, (int) f4);
        this.mPointersDown |= 1 << i8;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i8 = 0; i8 < pointerCount; i8++) {
            int pointerId = motionEvent.getPointerId(i8);
            if (isValidPointerForActionMove(pointerId)) {
                float x2 = motionEvent.getX(i8);
                float y3 = motionEvent.getY(i8);
                this.mLastMotionX[pointerId] = x2;
                this.mLastMotionY[pointerId] = y3;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean canScroll(@NonNull View view, boolean z2, int i8, int i9, int i10, int i11) {
        int i12;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i13 = i10 + scrollX;
                if (i13 >= childAt.getLeft() && i13 < childAt.getRight() && (i12 = i11 + scrollY) >= childAt.getTop() && i12 < childAt.getBottom() && canScroll(childAt, true, i8, i9, i13 - childAt.getLeft(), i12 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && (view.canScrollHorizontally(-i8) || view.canScrollVertically(-i9));
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i8) {
        if (view.getParent() != this.mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
        }
        this.mCapturedView = view;
        this.mActivePointerId = i8;
        this.mCallback.onViewCaptured(view, i8);
        setDragState(1);
    }

    public boolean continueSettling(boolean z2) {
        if (this.mDragState == 2) {
            boolean zComputeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z2) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    @Nullable
    public View findTopChildUnder(int i8, int i9) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && i9 >= childAt.getTop() && i9 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i8, int i9, int i10, int i11) {
        if (!this.mReleaseInProgress) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i8, i10, i9, i11);
        setDragState(2);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i8, int i9) {
        return isViewUnder(this.mCapturedView, i8, i9);
    }

    public boolean isEdgeTouched(int i8) {
        int length = this.mInitialEdgesTouched.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (isEdgeTouched(i8, i9)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i8) {
        return (this.mPointersDown & (1 << i8)) != 0;
    }

    public boolean isViewUnder(@Nullable View view, int i8, int i9) {
        return view != null && i8 >= view.getLeft() && i8 < view.getRight() && i9 >= view.getTop() && i9 < view.getBottom();
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i8;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i9 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewFindTopChildUnder = findTopChildUnder((int) x2, (int) y3);
            saveInitialMotion(x2, y3, pointerId);
            tryCaptureViewForDrag(viewFindTopChildUnder, pointerId);
            int i10 = this.mInitialEdgesTouched[pointerId];
            int i11 = this.mTrackingEdges;
            if ((i10 & i11) != 0) {
                this.mCallback.onEdgeTouched(i10 & i11, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.mDragState == 1) {
                if (isValidPointerForActionMove(this.mActivePointerId)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x8 = motionEvent.getX(iFindPointerIndex);
                    float y7 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.mLastMotionX;
                    int i12 = this.mActivePointerId;
                    int i13 = (int) (x8 - fArr[i12]);
                    int i14 = (int) (y7 - this.mLastMotionY[i12]);
                    dragTo(this.mCapturedView.getLeft() + i13, this.mCapturedView.getTop() + i14, i13, i14);
                    saveLastMotion(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i9 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i9);
                if (isValidPointerForActionMove(pointerId2)) {
                    float x10 = motionEvent.getX(i9);
                    float y8 = motionEvent.getY(i9);
                    float f = x10 - this.mInitialMotionX[pointerId2];
                    float f4 = y8 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f, f4, pointerId2);
                    if (this.mDragState != 1) {
                        View viewFindTopChildUnder2 = findTopChildUnder((int) x10, (int) y8);
                        if (checkTouchSlop(viewFindTopChildUnder2, f, f4) && tryCaptureViewForDrag(viewFindTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i9++;
            }
            saveLastMotion(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.mDragState == 1) {
                dispatchViewReleased(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x11 = motionEvent.getX(actionIndex);
            float y10 = motionEvent.getY(actionIndex);
            saveInitialMotion(x11, y10, pointerId3);
            if (this.mDragState != 0) {
                if (isCapturedViewUnder((int) x11, (int) y10)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                    return;
                }
                return;
            } else {
                tryCaptureViewForDrag(findTopChildUnder((int) x11, (int) y10), pointerId3);
                int i15 = this.mInitialEdgesTouched[pointerId3];
                int i16 = this.mTrackingEdges;
                if ((i15 & i16) != 0) {
                    this.mCallback.onEdgeTouched(i15 & i16, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i9 >= pointerCount2) {
                    i8 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i9);
                if (pointerId5 != this.mActivePointerId) {
                    View viewFindTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i9), (int) motionEvent.getY(i9));
                    View view = this.mCapturedView;
                    if (viewFindTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                        i8 = this.mActivePointerId;
                        break;
                    }
                }
                i9++;
            }
            if (i8 == -1) {
                releaseViewForPointerUp();
            }
        }
        clearMotionHistory(pointerId4);
    }

    public void setDragState(int i8) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i8) {
            this.mDragState = i8;
            this.mCallback.onViewDragStateChanged(i8);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int i8) {
        this.mEdgeSize = i8;
    }

    public void setEdgeTrackingEnabled(int i8) {
        this.mTrackingEdges = i8;
    }

    public void setMinVelocity(float f) {
        this.mMinVelocity = f;
    }

    public boolean settleCapturedViewAt(int i8, int i9) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i8, i9, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z2;
        View viewFindTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                cancel();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    cancel();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x2 = motionEvent.getX(actionIndex);
                    float y3 = motionEvent.getY(actionIndex);
                    saveInitialMotion(x2, y3, pointerId);
                    int i8 = this.mDragState;
                    if (i8 == 0) {
                        int i9 = this.mInitialEdgesTouched[pointerId];
                        int i10 = this.mTrackingEdges;
                        if ((i9 & i10) != 0) {
                            this.mCallback.onEdgeTouched(i9 & i10, pointerId);
                        }
                    } else if (i8 == 2 && (viewFindTopChildUnder = findTopChildUnder((int) x2, (int) y3)) == this.mCapturedView) {
                        tryCaptureViewForDrag(viewFindTopChildUnder, pointerId);
                    }
                } else if (actionMasked == 6) {
                    clearMotionHistory(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.mInitialMotionX != null && this.mInitialMotionY != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i11 = 0; i11 < pointerCount; i11++) {
                    int pointerId2 = motionEvent.getPointerId(i11);
                    if (isValidPointerForActionMove(pointerId2)) {
                        float x8 = motionEvent.getX(i11);
                        float y7 = motionEvent.getY(i11);
                        float f = x8 - this.mInitialMotionX[pointerId2];
                        float f4 = y7 - this.mInitialMotionY[pointerId2];
                        View viewFindTopChildUnder2 = findTopChildUnder((int) x8, (int) y7);
                        boolean z3 = viewFindTopChildUnder2 != null && checkTouchSlop(viewFindTopChildUnder2, f, f4);
                        if (!z3) {
                            reportNewEdgeDrags(f, f4, pointerId2);
                            if (this.mDragState != 1) {
                                break;
                            }
                        } else {
                            int left = viewFindTopChildUnder2.getLeft();
                            int i12 = (int) f;
                            int iClampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(viewFindTopChildUnder2, left + i12, i12);
                            int top = viewFindTopChildUnder2.getTop();
                            int i13 = (int) f4;
                            int iClampViewPositionVertical = this.mCallback.clampViewPositionVertical(viewFindTopChildUnder2, top + i13, i13);
                            int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(viewFindTopChildUnder2);
                            int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(viewFindTopChildUnder2);
                            if ((viewHorizontalDragRange == 0 || (viewHorizontalDragRange > 0 && iClampViewPositionHorizontal == left)) && (viewVerticalDragRange == 0 || (viewVerticalDragRange > 0 && iClampViewPositionVertical == top))) {
                                break;
                            }
                            reportNewEdgeDrags(f, f4, pointerId2);
                            if (this.mDragState != 1 || (z3 && tryCaptureViewForDrag(viewFindTopChildUnder2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                saveLastMotion(motionEvent);
            }
            z2 = false;
        } else {
            float x10 = motionEvent.getX();
            float y8 = motionEvent.getY();
            z2 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            saveInitialMotion(x10, y8, pointerId3);
            View viewFindTopChildUnder3 = findTopChildUnder((int) x10, (int) y8);
            if (viewFindTopChildUnder3 == this.mCapturedView && this.mDragState == 2) {
                tryCaptureViewForDrag(viewFindTopChildUnder3, pointerId3);
            }
            int i14 = this.mInitialEdgesTouched[pointerId3];
            int i15 = this.mTrackingEdges;
            if ((i14 & i15) != 0) {
                this.mCallback.onEdgeTouched(i14 & i15, pointerId3);
            }
        }
        if (this.mDragState == 1) {
            return true;
        }
        return z2;
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i8, int i9) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean zForceSettleCapturedViewAt = forceSettleCapturedViewAt(i8, i9, 0, 0);
        if (!zForceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return zForceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(View view, int i8) {
        if (view == this.mCapturedView && this.mActivePointerId == i8) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i8)) {
            return false;
        }
        this.mActivePointerId = i8;
        captureChildView(view, i8);
        return true;
    }

    private float clampMag(float f, float f4, float f10) {
        float fAbs = Math.abs(f);
        if (fAbs < f4) {
            return 0.0f;
        }
        if (fAbs > f10) {
            return f > 0.0f ? f10 : -f10;
        }
        return f;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f, @NonNull Callback callback) {
        ViewDragHelper viewDragHelperCreate = create(viewGroup, callback);
        viewDragHelperCreate.mTouchSlop = (int) ((1.0f / f) * viewDragHelperCreate.mTouchSlop);
        return viewDragHelperCreate;
    }

    public boolean isEdgeTouched(int i8, int i9) {
        return isPointerDown(i9) && (this.mInitialEdgesTouched[i9] & i8) != 0;
    }

    public boolean checkTouchSlop(int i8) {
        int length = this.mInitialMotionX.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (checkTouchSlop(i8, i9)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i8, int i9) {
        if (!isPointerDown(i9)) {
            return false;
        }
        boolean z2 = (i8 & 1) == 1;
        boolean z3 = (i8 & 2) == 2;
        float f = this.mLastMotionX[i9] - this.mInitialMotionX[i9];
        float f4 = this.mLastMotionY[i9] - this.mInitialMotionY[i9];
        if (z2 && z3) {
            float f10 = (f4 * f4) + (f * f);
            int i10 = this.mTouchSlop;
            return f10 > ((float) (i10 * i10));
        }
        if (z2) {
            return Math.abs(f) > ((float) this.mTouchSlop);
        }
        return z3 && Math.abs(f4) > ((float) this.mTouchSlop);
    }

    private void clearMotionHistory(int i8) {
        if (this.mInitialMotionX == null || !isPointerDown(i8)) {
            return;
        }
        this.mInitialMotionX[i8] = 0.0f;
        this.mInitialMotionY[i8] = 0.0f;
        this.mLastMotionX[i8] = 0.0f;
        this.mLastMotionY[i8] = 0.0f;
        this.mInitialEdgesTouched[i8] = 0;
        this.mEdgeDragsInProgress[i8] = 0;
        this.mEdgeDragsLocked[i8] = 0;
        this.mPointersDown = (~(1 << i8)) & this.mPointersDown;
    }
}
