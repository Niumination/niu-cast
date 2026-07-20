package com.transsion.widgetthemes.util;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.transsion.widgetsThemes.R$dimen;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PointAnimUtil {
    public static float CIRCLE_RADIU = 0.0f;
    public static int CIRCLE_SPACING = 0;
    public static int POINT_OFFSET = 0;
    public static final int STATE_CHANGING = 4;
    public static final int STATE_SELECTED = 2;
    public static final int STATE_UNSELECTED = 1;
    private int mCenterX;
    private int mCenterY;
    private ArrayList<Point> mPoints;
    private long mStartTime;
    private final View mTargetView;
    private Point p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    private Point f3840p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    private Point f3841p2;
    private int mDuration = 300;
    public int mState = 1;
    private boolean mSelected = false;
    private int mLayoutDir = -1;
    private final Interpolator mInterpolator = new AccelerateInterpolator();

    public PointAnimUtil(View view) {
        this.mTargetView = view;
        Resources resources = view.getResources();
        CIRCLE_RADIU = resources.getDimension(R$dimen.os_overflowmenu_circle_radiu);
        int dimension = (int) resources.getDimension(R$dimen.os_overflowmenu_circle_spacing);
        CIRCLE_SPACING = dimension;
        POINT_OFFSET = (int) ((CIRCLE_RADIU * 2.0f) + dimension);
        initPoint();
    }

    private void initLTRPostion(ArrayList<Point> arrayList) {
        int i8 = this.mCenterX - POINT_OFFSET;
        this.p0.setStartPos(i8, i8, CIRCLE_RADIU);
        int i9 = this.mCenterY;
        this.f3840p1.setStartPos(i8, i9, CIRCLE_RADIU);
        int i10 = this.mCenterY + POINT_OFFSET;
        this.f3841p2.setStartPos(i8, i10, CIRCLE_RADIU);
        this.f3840p1.setDestPos(i10, i8);
        this.f3841p2.setDestPos(i9, i9);
        arrayList.add(0, this.p0);
        arrayList.add(1, this.f3840p1);
        arrayList.add(2, this.f3841p2);
    }

    private void initPoint() {
        this.p0 = new Point();
        this.f3840p1 = new Point();
        this.f3841p2 = new Point();
    }

    private void initRTLPosition(ArrayList<Point> arrayList) {
        int i8 = this.mCenterX;
        int i9 = POINT_OFFSET;
        int i10 = i8 + i9;
        int i11 = this.mCenterY - i9;
        this.p0.setStartPos(i10, i11, CIRCLE_RADIU);
        int i12 = this.mCenterY;
        this.f3840p1.setStartPos(i10, i12, CIRCLE_RADIU);
        this.f3841p2.setStartPos(i10, this.mCenterY + POINT_OFFSET, CIRCLE_RADIU);
        this.f3840p1.setDestPos(i11, i11);
        this.f3841p2.setDestPos(i12, i12);
        arrayList.add(0, this.p0);
        arrayList.add(1, this.f3840p1);
        arrayList.add(2, this.f3841p2);
    }

    private void resetDestPosition(Point point, Point point2, int i8) {
        if (this.mSelected) {
            this.mState = 2;
            if (this.mLayoutDir == 0) {
                point.setDestPos(this.mCenterX - POINT_OFFSET, this.mCenterY);
                int i9 = this.mCenterX;
                int i10 = POINT_OFFSET;
                point2.setDestPos(i9 - i10, this.mCenterY + i10);
            } else {
                point.setDestPos(this.mCenterX + POINT_OFFSET, this.mCenterY);
                int i11 = this.mCenterX;
                int i12 = POINT_OFFSET;
                point2.setDestPos(i11 + i12, this.mCenterY + i12);
            }
        } else {
            this.mState = 1;
            if (this.mLayoutDir == 0) {
                int i13 = this.mCenterX;
                int i14 = POINT_OFFSET;
                point.setDestPos(i13 + i14, this.mCenterY - i14);
                point2.setDestPos(this.mCenterX, this.mCenterY);
            } else {
                int i15 = this.mCenterX;
                int i16 = POINT_OFFSET;
                point.setDestPos(i15 - i16, this.mCenterY - i16);
                point2.setDestPos(this.mCenterX, this.mCenterY);
            }
        }
        this.mTargetView.invalidate();
    }

    public void abort() {
        if (this.mState != 4) {
            return;
        }
        if (this.mSelected) {
            this.mState = 2;
        } else {
            this.mState = 1;
        }
        resetDestPosition(this.mPoints.get(1), this.mPoints.get(2), 0);
    }

    public void setCetnerPosition(int i8, int i9) {
        this.mCenterX = i8;
        this.mCenterY = i9;
    }

    public void setDuration(int i8) {
        this.mDuration = i8;
    }

    public void setPointDir(int i8, ArrayList<Point> arrayList) {
        if (this.mLayoutDir != i8) {
            arrayList.clear();
            if (i8 == 0) {
                initLTRPostion(arrayList);
            } else {
                initRTLPosition(arrayList);
            }
        }
        this.mPoints = arrayList;
        this.mLayoutDir = i8;
    }

    public void start(boolean z2, int i8) {
        if (this.mState == 4) {
            resetDestPosition(this.mPoints.get(1), this.mPoints.get(2), 1);
        }
        this.mSelected = z2;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mState = 4;
        update();
    }

    public void update() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float interpolation = this.mInterpolator.getInterpolation(Math.min((jCurrentAnimationTimeMillis - this.mStartTime) / (this.mDuration * 1.0f), 1.0f));
        if (this.mPoints.size() < 3) {
            return;
        }
        Point point = this.mPoints.get(1);
        int i8 = point.f3836x;
        point.f3836x = (int) (((point.f3837x1 - i8) * interpolation) + i8);
        int i9 = point.f3838y;
        point.f3838y = (int) (((point.f3839y1 - i9) * interpolation) + i9);
        Point point2 = this.mPoints.get(2);
        int i10 = point2.f3836x;
        point2.f3836x = (int) (((point2.f3837x1 - i10) * interpolation) + i10);
        int i11 = point2.f3838y;
        point2.f3838y = (int) (((point2.f3839y1 - i11) * interpolation) + i11);
        this.mTargetView.invalidate();
        if (jCurrentAnimationTimeMillis - this.mStartTime >= this.mDuration) {
            resetDestPosition(point, point2, 0);
        }
    }
}
