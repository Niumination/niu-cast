package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i8) {
        int i9;
        ChainHead[] chainHeadArr;
        int i10;
        if (i8 == 0) {
            i9 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i10 = 0;
        } else {
            i9 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i10 = 2;
        }
        for (int i11 = 0; i11 < i9; i11++) {
            ChainHead chainHead = chainHeadArr[i11];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i8, i10, chainHead);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0173  */
    /* JADX WARN: Code duplicated, block: B:104:0x0194  */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[PHI: r8 r16
      0x0033: PHI (r8v39 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r16v6 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[PHI: r8 r16
      0x0035: PHI (r8v3 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r16v3 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:202:0x034e  */
    /* JADX WARN: Code duplicated, block: B:221:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:323:0x03a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x016a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i8, int i9, ChainHead chainHead) {
        boolean z2;
        boolean z3;
        boolean z5;
        Object obj;
        int i10;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        ?? r7;
        SolverVariable solverVariable4;
        float f;
        int size;
        ConstraintAnchor constraintAnchor3;
        int i11;
        int i12 = i8;
        ConstraintWidget constraintWidget = chainHead.mFirst;
        ConstraintWidget constraintWidget2 = chainHead.mLast;
        ConstraintWidget constraintWidget3 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget4 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mHead;
        float f4 = chainHead.mTotalWeight;
        boolean z10 = constraintWidgetContainer.mListDimensionBehaviors[i12] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i12 == 0) {
            int i13 = constraintWidget5.mHorizontalChainStyle;
            z2 = i13 == 0;
            z3 = i13 == 1;
            if (i13 == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            int i14 = constraintWidget5.mVerticalChainStyle;
            z2 = i14 == 0;
            z3 = i14 == 1;
            if (i14 == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
        }
        boolean z11 = z3;
        boolean z12 = false;
        boolean z13 = z2;
        ?? r10 = constraintWidget;
        while (true) {
            obj = null;
            if (z12) {
                break;
            }
            ConstraintAnchor constraintAnchor4 = r10.mListAnchors[i9];
            int i15 = z5 ? 1 : 4;
            int margin = constraintAnchor4.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r10.mListDimensionBehaviors[i12];
            float f10 = f4;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z14 = dimensionBehaviour == dimensionBehaviour2 && r10.mResolvedMatchConstraintDefault[i12] == 0;
            ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
            if (constraintAnchor5 != null && r10 != constraintWidget) {
                margin = constraintAnchor5.getMargin() + margin;
            }
            int i16 = margin;
            if (z5 && r10 != constraintWidget && r10 != constraintWidget3) {
                i15 = 8;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchor4.mTarget;
            if (constraintAnchor6 != null) {
                if (r10 == constraintWidget3) {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i16, 6);
                } else {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i16, 8);
                }
                if (z14 && !z5) {
                    i15 = 5;
                }
                linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor4.mTarget.mSolverVariable, i16, (r10 == constraintWidget3 && z5 && r10.isInBarrier(i12)) ? 5 : i15);
            } else {
                constraintWidget = constraintWidget;
            }
            if (z10) {
                if (r10.getVisibility() == 8 || r10.mListDimensionBehaviors[i12] != dimensionBehaviour2) {
                    i11 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r10.mListAnchors;
                    i11 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i9 + 1].mSolverVariable, constraintAnchorArr[i9].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r10.mListAnchors[i9].mSolverVariable, constraintWidgetContainer.mListAnchors[i9].mSolverVariable, i11, 8);
            }
            ConstraintAnchor constraintAnchor7 = r10.mListAnchors[i9 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor7.mOwner;
                ConstraintAnchor constraintAnchor8 = constraintWidget6.mListAnchors[i9].mTarget;
                if (constraintAnchor8 != null && constraintAnchor8.mOwner == r10) {
                    obj = constraintWidget6;
                }
            }
            if (obj != null) {
                r10 = obj;
                z12 = z12;
            } else {
                z12 = true;
            }
            constraintWidget5 = constraintWidget5;
            f4 = f10;
            constraintWidget = constraintWidget;
            r10 = r10;
        }
        ConstraintWidget constraintWidget7 = constraintWidget5;
        float f11 = f4;
        ConstraintWidget constraintWidget8 = constraintWidget;
        if (constraintWidget4 != null) {
            int i17 = i9 + 1;
            if (constraintWidget2.mListAnchors[i17].mTarget != null) {
                ConstraintAnchor constraintAnchor9 = constraintWidget4.mListAnchors[i17];
                if (constraintWidget4.mListDimensionBehaviors[i12] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.mResolvedMatchConstraintDefault[i12] == 0 && !z5) {
                    ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                    if (constraintAnchor10.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor10.mSolverVariable, -constraintAnchor9.getMargin(), 5);
                    } else if (z5) {
                        constraintAnchor3 = constraintAnchor9.mTarget;
                        if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor9.getMargin(), 4);
                        }
                    }
                } else if (z5) {
                    constraintAnchor3 = constraintAnchor9.mTarget;
                    if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor9.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor9.mSolverVariable, constraintWidget2.mListAnchors[i17].mTarget.mSolverVariable, -constraintAnchor9.getMargin(), 6);
            }
        }
        if (z10) {
            int i18 = i9 + 1;
            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i18].mSolverVariable;
            ConstraintAnchor constraintAnchor11 = constraintWidget2.mListAnchors[i18];
            linearSystem.addGreaterThan(solverVariable5, constraintAnchor11.mSolverVariable, constraintAnchor11.getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f12 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f11 : chainHead.mWidgetsMatchCount;
            float f13 = 0.0f;
            float f14 = 0.0f;
            ConstraintWidget constraintWidget9 = null;
            int i19 = 0;
            while (i19 < size) {
                ConstraintWidget constraintWidget10 = arrayList.get(i19);
                float f15 = constraintWidget10.mWeight[i12];
                if (f15 < f13) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget10.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr2[i9 + 1].mSolverVariable, constraintAnchorArr2[i9].mSolverVariable, 0, 4);
                    } else {
                        f15 = 1.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i19++;
                    size = size;
                    arrayList = arrayList;
                    f13 = 0.0f;
                }
                if (f15 == 0.0f) {
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget10.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr3[i9 + 1].mSolverVariable, constraintAnchorArr3[i9].mSolverVariable, 0, 8);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (constraintWidget9 != null) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget9.mListAnchors;
                        SolverVariable solverVariable6 = constraintAnchorArr4[i9].mSolverVariable;
                        int i20 = i9 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr4[i20].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget10.mListAnchors;
                        SolverVariable solverVariable8 = constraintAnchorArr5[i9].mSolverVariable;
                        SolverVariable solverVariable9 = constraintAnchorArr5[i20].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f14, f12, f15, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                    constraintWidget9 = constraintWidget10;
                    f14 = f15;
                }
                i19++;
                size = size;
                arrayList = arrayList;
                f13 = 0.0f;
            }
        }
        if (constraintWidget3 != null && (constraintWidget3 == constraintWidget4 || z5)) {
            ConstraintAnchor constraintAnchor12 = constraintWidget8.mListAnchors[i9];
            int i21 = i9 + 1;
            ConstraintAnchor constraintAnchor13 = constraintWidget2.mListAnchors[i21];
            ConstraintAnchor constraintAnchor14 = constraintAnchor12.mTarget;
            SolverVariable solverVariable10 = constraintAnchor14 != null ? constraintAnchor14.mSolverVariable : null;
            ConstraintAnchor constraintAnchor15 = constraintAnchor13.mTarget;
            SolverVariable solverVariable11 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
            ConstraintAnchor constraintAnchor16 = constraintWidget3.mListAnchors[i9];
            if (constraintWidget4 != null) {
                constraintAnchor13 = constraintWidget4.mListAnchors[i21];
            }
            if (solverVariable10 != null && solverVariable11 != null) {
                if (i12 == 0) {
                    f = constraintWidget7.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget7.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable10, constraintAnchor16.getMargin(), f, solverVariable11, constraintAnchor13.mSolverVariable, constraintAnchor13.getMargin(), 7);
            }
        } else if (!z13 || constraintWidget3 == null) {
            int i22 = 8;
            if (z11 && constraintWidget3 != null) {
                int i23 = chainHead.mWidgetsMatchCount;
                boolean z15 = i23 > 0 && chainHead.mWidgetsCount == i23;
                ConstraintWidget constraintWidget11 = constraintWidget3;
                ConstraintWidget constraintWidget12 = constraintWidget11;
                while (constraintWidget12 != null) {
                    ConstraintWidget constraintWidget13 = constraintWidget12.mNextChainWidget[i12];
                    while (constraintWidget13 != null && constraintWidget13.getVisibility() == i22) {
                        constraintWidget13 = constraintWidget13.mNextChainWidget[i12];
                    }
                    if (constraintWidget12 == constraintWidget3 || constraintWidget12 == constraintWidget4 || constraintWidget13 == null) {
                        constraintWidget11 = constraintWidget11;
                        i10 = i22;
                    } else {
                        ConstraintWidget constraintWidget14 = constraintWidget13 == constraintWidget4 ? null : constraintWidget13;
                        ConstraintAnchor constraintAnchor17 = constraintWidget12.mListAnchors[i9];
                        SolverVariable solverVariable12 = constraintAnchor17.mSolverVariable;
                        ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                        if (constraintAnchor18 != null) {
                            SolverVariable solverVariable13 = constraintAnchor18.mSolverVariable;
                        }
                        int i24 = i9 + 1;
                        SolverVariable solverVariable14 = constraintWidget11.mListAnchors[i24].mSolverVariable;
                        int margin2 = constraintAnchor17.getMargin();
                        int margin3 = constraintWidget12.mListAnchors[i24].getMargin();
                        if (constraintWidget14 != null) {
                            constraintAnchor = constraintWidget14.mListAnchors[i9];
                            SolverVariable solverVariable15 = constraintAnchor.mSolverVariable;
                            ConstraintAnchor constraintAnchor19 = constraintAnchor.mTarget;
                            solverVariable2 = constraintAnchor19 != null ? constraintAnchor19.mSolverVariable : null;
                            solverVariable = solverVariable15;
                        } else {
                            constraintAnchor = constraintWidget4.mListAnchors[i9];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget12.mListAnchors[i24].mSolverVariable;
                        }
                        int margin4 = constraintAnchor != null ? constraintAnchor.getMargin() + margin3 : margin3;
                        int margin5 = constraintWidget11.mListAnchors[i24].getMargin() + margin2;
                        int i25 = z15 ? 8 : 4;
                        if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable2 == null) {
                            i10 = 8;
                        } else {
                            i10 = 8;
                            linearSystem.addCentering(solverVariable12, solverVariable14, margin5, 0.5f, solverVariable, solverVariable2, margin4, i25);
                        }
                        constraintWidget13 = constraintWidget14;
                    }
                    constraintWidget11 = constraintWidget12.getVisibility() != i10 ? constraintWidget12 : constraintWidget11;
                    constraintWidget12 = constraintWidget13;
                    i22 = i10;
                    i12 = i8;
                }
                ConstraintAnchor constraintAnchor20 = constraintWidget3.mListAnchors[i9];
                ConstraintAnchor constraintAnchor21 = constraintWidget8.mListAnchors[i9].mTarget;
                int i26 = i9 + 1;
                ConstraintAnchor constraintAnchor22 = constraintWidget4.mListAnchors[i26];
                ConstraintAnchor constraintAnchor23 = constraintWidget2.mListAnchors[i26].mTarget;
                if (constraintAnchor21 != null) {
                    if (constraintWidget3 != constraintWidget4) {
                        linearSystem.addEquality(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 5);
                    } else if (constraintAnchor23 != null) {
                        linearSystem.addCentering(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 0.5f, constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, constraintAnchor22.getMargin(), 5);
                    }
                }
                if (constraintAnchor23 != null && constraintWidget3 != constraintWidget4) {
                    linearSystem.addEquality(constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, -constraintAnchor22.getMargin(), 5);
                }
            }
        } else {
            int i27 = chainHead.mWidgetsMatchCount;
            boolean z16 = i27 > 0 && chainHead.mWidgetsCount == i27;
            ConstraintWidget constraintWidget15 = constraintWidget3;
            ConstraintWidget constraintWidget16 = constraintWidget15;
            while (constraintWidget16 != null) {
                ConstraintWidget constraintWidget17 = constraintWidget16.mNextChainWidget[i12];
                while (constraintWidget17 != null && constraintWidget17.getVisibility() == 8) {
                    constraintWidget17 = constraintWidget17.mNextChainWidget[i12];
                }
                if (constraintWidget17 != null || constraintWidget16 == constraintWidget4) {
                    ConstraintAnchor constraintAnchor24 = constraintWidget16.mListAnchors[i9];
                    SolverVariable solverVariable16 = constraintAnchor24.mSolverVariable;
                    ConstraintAnchor constraintAnchor25 = constraintAnchor24.mTarget;
                    SolverVariable solverVariable17 = constraintAnchor25 != null ? constraintAnchor25.mSolverVariable : null;
                    if (constraintWidget15 != constraintWidget16) {
                        solverVariable17 = constraintWidget15.mListAnchors[i9 + 1].mSolverVariable;
                    } else if (constraintWidget16 == constraintWidget3) {
                        ConstraintAnchor constraintAnchor26 = constraintWidget8.mListAnchors[i9].mTarget;
                        solverVariable17 = constraintAnchor26 != null ? constraintAnchor26.mSolverVariable : null;
                    }
                    int margin6 = constraintAnchor24.getMargin();
                    int i28 = i9 + 1;
                    int margin7 = constraintWidget16.mListAnchors[i28].getMargin();
                    if (constraintWidget17 != null) {
                        constraintAnchor2 = constraintWidget17.mListAnchors[i9];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget2.mListAnchors[i28].mTarget;
                        if (constraintAnchor2 != null) {
                            solverVariable3 = constraintAnchor2.mSolverVariable;
                        } else {
                            solverVariable3 = null;
                        }
                        SolverVariable solverVariable18 = constraintWidget16.mListAnchors[i28].mSolverVariable;
                        if (constraintAnchor2 != null) {
                            margin7 += constraintAnchor2.getMargin();
                        }
                        int margin8 = constraintWidget15.mListAnchors[i28].getMargin() + margin6;
                        if (solverVariable16 == null && solverVariable17 != null && solverVariable3 != null && solverVariable18 != null) {
                            if (constraintWidget16 == constraintWidget3) {
                                margin8 = constraintWidget3.mListAnchors[i9].getMargin();
                            }
                            constraintWidget17 = constraintWidget17;
                            linearSystem.addCentering(solverVariable16, solverVariable17, margin8, 0.5f, solverVariable3, solverVariable18, constraintWidget16 == constraintWidget4 ? constraintWidget4.mListAnchors[i28].getMargin() : margin7, z16 ? 8 : 5);
                        }
                        if (constraintWidget16.getVisibility() != 8) {
                            constraintWidget16 = constraintWidget15;
                        }
                        constraintWidget15 = constraintWidget16;
                        constraintWidget16 = constraintWidget17;
                    }
                    SolverVariable solverVariable19 = constraintWidget16.mListAnchors[i28].mSolverVariable;
                    if (constraintAnchor2 != null) {
                        margin7 += constraintAnchor2.getMargin();
                    }
                    int margin9 = constraintWidget15.mListAnchors[i28].getMargin() + margin6;
                    if (solverVariable16 == null) {
                    }
                }
                if (constraintWidget16.getVisibility() != 8) {
                    constraintWidget16 = constraintWidget15;
                }
                constraintWidget15 = constraintWidget16;
                constraintWidget16 = constraintWidget17;
            }
        }
        if ((!z13 && !z11) || constraintWidget3 == null || constraintWidget3 == constraintWidget4) {
            return;
        }
        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget3.mListAnchors;
        ConstraintAnchor constraintAnchor27 = constraintAnchorArr6[i9];
        if (constraintWidget4 == null) {
            constraintWidget4 = constraintWidget3;
        }
        int i29 = i9 + 1;
        ConstraintAnchor constraintAnchor28 = constraintWidget4.mListAnchors[i29];
        ConstraintAnchor constraintAnchor29 = constraintAnchor27.mTarget;
        SolverVariable solverVariable20 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
        ConstraintAnchor constraintAnchor30 = constraintAnchor28.mTarget;
        if (constraintAnchor30 != null) {
            solverVariable4 = constraintAnchor30.mSolverVariable;
        } else {
            r7 = 0;
        }
        if (constraintWidget2 != constraintWidget4) {
            ConstraintAnchor constraintAnchor31 = constraintWidget2.mListAnchors[i29].mTarget;
            if (constraintAnchor31 != null) {
                r7 = solverVariable4;
                obj = constraintAnchor31.mSolverVariable;
            }
            r7 = solverVariable4;
            r7 = obj;
        }
        if (constraintWidget3 == constraintWidget4) {
            constraintAnchor28 = constraintAnchorArr6[i29];
        }
        if (solverVariable20 == null || r7 == 0) {
            return;
        }
        linearSystem.addCentering(constraintAnchor27.mSolverVariable, solverVariable20, constraintAnchor27.getMargin(), 0.5f, r7, constraintAnchor28.mSolverVariable, constraintWidget4.mListAnchors[i29].getMargin(), 5);
    }
}
