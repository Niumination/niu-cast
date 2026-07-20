package androidx.constraintlayout.core.widgets.analyzer;

import a1.a;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i8) {
        super(constraintWidget);
        this.widgets = new ArrayList<>();
        this.orientation = i8;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : this.widgets) {
            int i8 = this.orientation;
            if (i8 == 0) {
                widgetRun.widget.horizontalChainRun = this;
            } else if (i8 == 1) {
                widgetRun.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl() && this.widgets.size() > 1) {
            this.widget = ((WidgetRun) a.i(1, this.widgets)).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i8 = 0; i8 < this.widgets.size(); i8++) {
            WidgetRun widgetRun = this.widgets.get(i8);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i8 = 0; i8 < this.widgets.size(); i8++) {
            this.widgets.get(i8).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long wrapDimension = 0;
        for (int i8 = 0; i8 < size; i8++) {
            WidgetRun widgetRun = this.widgets.get(i8);
            wrapDimension = ((long) widgetRun.end.margin) + widgetRun.getWrapDimension() + wrapDimension + ((long) widgetRun.start.margin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!this.widgets.get(i8).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.widgets) {
            sb2.append("<");
            sb2.append(widgetRun);
            sb2.append("> ");
        }
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:293:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x0153  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        float f;
        boolean z2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        float f4;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i21 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i22 = 0;
            while (true) {
                i8 = -1;
                i9 = 8;
                if (i22 >= size) {
                    i22 = -1;
                    break;
                } else if (this.widgets.get(i22).widget.getVisibility() != 8) {
                    break;
                } else {
                    i22++;
                }
            }
            int i23 = size - 1;
            for (int i24 = i23; i24 >= 0; i24--) {
                if (this.widgets.get(i24).widget.getVisibility() != 8) {
                    i8 = i24;
                    break;
                }
            }
            int i25 = 0;
            while (true) {
                if (i25 >= 2) {
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    f = 0.0f;
                    break;
                }
                int i26 = 0;
                i11 = 0;
                i12 = 0;
                int i27 = 0;
                f = 0.0f;
                while (i26 < size) {
                    WidgetRun widgetRun = this.widgets.get(i26);
                    if (widgetRun.widget.getVisibility() != i9) {
                        i27++;
                        if (i26 > 0 && i26 >= i22) {
                            i11 += widgetRun.start.margin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.dimension;
                        int i28 = dimensionDependency.value;
                        boolean z3 = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z3) {
                            int i29 = this.orientation;
                            if (i29 == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (i29 == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            } else {
                                i19 = i28;
                            }
                        } else {
                            i19 = i28;
                            if (widgetRun.matchConstraintsType == 1 && i25 == 0) {
                                i20 = dimensionDependency.wrapValue;
                                i12++;
                            } else {
                                if (dimensionDependency.resolved) {
                                    i20 = i19;
                                }
                                if (z3) {
                                    i11 += i20;
                                } else {
                                    i12++;
                                    f4 = widgetRun.widget.mWeight[this.orientation];
                                    if (f4 >= 0.0f) {
                                        f += f4;
                                    }
                                }
                                if (i26 >= i23 && i26 < i8) {
                                    i11 += -widgetRun.end.margin;
                                }
                            }
                            z3 = true;
                            if (z3) {
                                i12++;
                                f4 = widgetRun.widget.mWeight[this.orientation];
                                if (f4 >= 0.0f) {
                                    f += f4;
                                }
                            } else {
                                i11 += i20;
                            }
                            if (i26 >= i23) {
                            }
                        }
                        i20 = i19;
                        if (z3) {
                            i12++;
                            f4 = widgetRun.widget.mWeight[this.orientation];
                            if (f4 >= 0.0f) {
                                f += f4;
                            }
                        } else {
                            i11 += i20;
                        }
                        if (i26 >= i23) {
                        }
                    }
                    i26++;
                    i9 = 8;
                }
                if (i11 < i21 || i12 == 0) {
                    i10 = i27;
                    break;
                } else {
                    i25++;
                    i9 = 8;
                }
            }
            int i30 = this.start.value;
            if (zIsRtl) {
                i30 = this.end.value;
            }
            if (i11 > i21) {
                i30 = zIsRtl ? i30 + ((int) (((i11 - i21) / 2.0f) + 0.5f)) : i30 - ((int) (((i11 - i21) / 2.0f) + 0.5f));
            }
            if (i12 > 0) {
                float f10 = i21 - i11;
                int i31 = (int) ((f10 / i12) + 0.5f);
                int i32 = 0;
                int i33 = 0;
                while (i32 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i32);
                    int i34 = i31;
                    int i35 = i11;
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        if (dimensionDependency2.resolved) {
                            zIsRtl = zIsRtl;
                            i30 = i30;
                            f10 = f10;
                        } else {
                            int i36 = f > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f10) / f) + 0.5f) : i34;
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.widget;
                                i18 = constraintWidget.mMatchConstraintMaxWidth;
                                i17 = constraintWidget.mMatchConstraintMinWidth;
                            } else {
                                ConstraintWidget constraintWidget2 = widgetRun2.widget;
                                int i37 = constraintWidget2.mMatchConstraintMaxHeight;
                                i17 = constraintWidget2.mMatchConstraintMinHeight;
                                i18 = i37;
                            }
                            int iMax = Math.max(i17, widgetRun2.matchConstraintsType == 1 ? Math.min(i36, dimensionDependency2.wrapValue) : i36);
                            if (i18 > 0) {
                                iMax = Math.min(i18, iMax);
                            }
                            if (iMax != i36) {
                                i33++;
                                i36 = iMax;
                            }
                            widgetRun2.dimension.resolve(i36);
                        }
                    } else {
                        zIsRtl = zIsRtl;
                        i30 = i30;
                        f10 = f10;
                    }
                    i32++;
                    i31 = i34;
                    i11 = i35;
                    i30 = i30;
                    f10 = f10;
                    zIsRtl = zIsRtl;
                    i10 = i10;
                }
                z2 = zIsRtl;
                i13 = i10;
                i14 = i30;
                int i38 = i11;
                if (i33 > 0) {
                    i12 -= i33;
                    i11 = 0;
                    for (int i39 = 0; i39 < size; i39++) {
                        WidgetRun widgetRun3 = this.widgets.get(i39);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i39 > 0 && i39 >= i22) {
                                i11 += widgetRun3.start.margin;
                            }
                            i11 += widgetRun3.dimension.value;
                            if (i39 < i23 && i39 < i8) {
                                i11 += -widgetRun3.end.margin;
                            }
                        }
                    }
                } else {
                    i11 = i38;
                }
                i16 = 2;
                if (this.chainStyle == 2 && i33 == 0) {
                    i15 = 0;
                    this.chainStyle = 0;
                } else {
                    i15 = 0;
                }
            } else {
                z2 = zIsRtl;
                i13 = i10;
                i14 = i30;
                i15 = 0;
                i16 = 2;
            }
            if (i11 > i21) {
                this.chainStyle = i16;
            }
            if (i13 > 0 && i12 == 0 && i22 == i8) {
                this.chainStyle = i16;
            }
            int i40 = this.chainStyle;
            if (i40 == 1) {
                int i41 = i13;
                int i42 = i41 > 1 ? (i21 - i11) / (i41 - 1) : i41 == 1 ? (i21 - i11) / 2 : i15;
                if (i12 > 0) {
                    i42 = i15;
                }
                int i43 = i14;
                for (int i44 = i15; i44 < size; i44++) {
                    WidgetRun widgetRun4 = this.widgets.get(z2 ? size - (i44 + 1) : i44);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i43);
                        widgetRun4.end.resolve(i43);
                    } else {
                        if (i44 > 0) {
                            i43 = z2 ? i43 - i42 : i43 + i42;
                        }
                        if (i44 > 0 && i44 >= i22) {
                            i43 = z2 ? i43 - widgetRun4.start.margin : i43 + widgetRun4.start.margin;
                        }
                        if (z2) {
                            widgetRun4.end.resolve(i43);
                        } else {
                            widgetRun4.start.resolve(i43);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                        int i45 = dimensionDependency3.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i45 = dimensionDependency3.wrapValue;
                        }
                        i43 = z2 ? i43 - i45 : i43 + i45;
                        if (z2) {
                            widgetRun4.start.resolve(i43);
                        } else {
                            widgetRun4.end.resolve(i43);
                        }
                        widgetRun4.resolved = true;
                        if (i44 < i23 && i44 < i8) {
                            i43 = z2 ? i43 - (-widgetRun4.end.margin) : i43 + (-widgetRun4.end.margin);
                        }
                    }
                }
                return;
            }
            int i46 = i13;
            if (i40 == 0) {
                int i47 = (i21 - i11) / (i46 + 1);
                if (i12 > 0) {
                    i47 = i15;
                }
                int i48 = i14;
                for (int i49 = i15; i49 < size; i49++) {
                    WidgetRun widgetRun5 = this.widgets.get(z2 ? size - (i49 + 1) : i49);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i48);
                        widgetRun5.end.resolve(i48);
                    } else {
                        int i50 = z2 ? i48 - i47 : i48 + i47;
                        if (i49 > 0 && i49 >= i22) {
                            i50 = z2 ? i50 - widgetRun5.start.margin : i50 + widgetRun5.start.margin;
                        }
                        if (z2) {
                            widgetRun5.end.resolve(i50);
                        } else {
                            widgetRun5.start.resolve(i50);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                        int iMin = dimensionDependency4.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, dimensionDependency4.wrapValue);
                        }
                        i48 = z2 ? i50 - iMin : i50 + iMin;
                        if (z2) {
                            widgetRun5.start.resolve(i48);
                        } else {
                            widgetRun5.end.resolve(i48);
                        }
                        if (i49 < i23 && i49 < i8) {
                            i48 = z2 ? i48 - (-widgetRun5.end.margin) : i48 + (-widgetRun5.end.margin);
                        }
                    }
                }
                return;
            }
            if (i40 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (z2) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i51 = (int) (((i21 - i11) * horizontalBiasPercent) + 0.5f);
                if (i51 < 0 || i12 > 0) {
                    i51 = i15;
                }
                int i52 = z2 ? i14 - i51 : i14 + i51;
                for (int i53 = i15; i53 < size; i53++) {
                    WidgetRun widgetRun6 = this.widgets.get(z2 ? size - (i53 + 1) : i53);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i52);
                        widgetRun6.end.resolve(i52);
                    } else {
                        if (i53 > 0 && i53 >= i22) {
                            i52 = z2 ? i52 - widgetRun6.start.margin : i52 + widgetRun6.start.margin;
                        }
                        if (z2) {
                            widgetRun6.end.resolve(i52);
                        } else {
                            widgetRun6.start.resolve(i52);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                        int i54 = dimensionDependency5.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i54 = dimensionDependency5.wrapValue;
                        }
                        i52 = z2 ? i52 - i54 : i52 + i54;
                        if (z2) {
                            widgetRun6.start.resolve(i52);
                        } else {
                            widgetRun6.end.resolve(i52);
                        }
                        if (i53 < i23 && i53 < i8) {
                            i52 = z2 ? i52 - (-widgetRun6.end.margin) : i52 + (-widgetRun6.end.margin);
                        }
                    }
                }
            }
        }
    }
}
