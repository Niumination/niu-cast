package androidx.constraintlayout.core;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import h0.a;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    ArrayRow[] mRows;
    private Row mTempGoal;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int TABLE_SIZE = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;

    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2);

        void updateFromSystem(LinearSystem linearSystem);
    }

    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mRows = null;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.mCache.solverVariablePool.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.setType(type, str);
        } else {
            solverVariableAcquire.reset();
            solverVariableAcquire.setType(type, str);
        }
        int i8 = this.mPoolVariablesCount;
        int i9 = POOL_SIZE;
        if (i8 >= i9) {
            int i10 = i9 * 2;
            POOL_SIZE = i10;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i10);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i11 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i11 + 1;
        solverVariableArr[i11] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        int i8;
        if (SIMPLIFY_SYNONYMS && arrayRow.isSimpleDefinition) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i9 = this.mNumRows;
            arrayRowArr[i9] = arrayRow;
            SolverVariable solverVariable = arrayRow.variable;
            solverVariable.definitionId = i9;
            this.mNumRows = i9 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i10 = 0;
            while (i10 < this.mNumRows) {
                if (this.mRows[i10] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i10];
                if (arrayRow2 != null && arrayRow2.isSimpleDefinition) {
                    arrayRow2.variable.setFinalValue(this, arrayRow2.constantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i10] = null;
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (true) {
                        i8 = this.mNumRows;
                        if (i11 >= i8) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i13 = i11 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i11];
                        arrayRowArr2[i13] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.variable;
                        if (solverVariable2.definitionId == i11) {
                            solverVariable2.definitionId = i13;
                        }
                        i12 = i11;
                        i11++;
                    }
                    if (i12 < i8) {
                        this.mRows[i12] = null;
                    }
                    this.mNumRows = i8 - 1;
                    i10--;
                }
                i10++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void addSingleError(ArrayRow arrayRow, int i8) {
        addSingleError(arrayRow, i8, 0);
    }

    private void computeValues() {
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            ArrayRow arrayRow = this.mRows[i8];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(type, null);
        solverVariableAcquireSolverVariable.setName(str);
        int i8 = this.mVariablesID + 1;
        this.mVariablesID = i8;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f1075id = i8;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, solverVariableAcquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String strB = "";
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            StringBuilder sbS = d.s(strB);
            sbS.append(this.mRows[i8]);
            strB = a.B(sbS.toString(), "\n");
        }
        StringBuilder sbS2 = d.s(strB);
        sbS2.append(this.mGoal);
        sbS2.append("\n");
        System.out.println(sbS2.toString());
    }

    private void displaySolverVariables() {
        StringBuilder sb2 = new StringBuilder("Display Rows (");
        sb2.append(this.mNumRows);
        sb2.append("x");
        System.out.println(a.m(sb2, ")\n", this.mNumColumns));
    }

    private int enforceBFS(Row row) throws Exception {
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            ArrayRow arrayRow = this.mRows[i8];
            if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && arrayRow.constantValue < 0.0f) {
                boolean z2 = false;
                int i9 = 0;
                while (!z2) {
                    Metrics metrics = sMetrics;
                    if (metrics != null) {
                        metrics.bfs++;
                    }
                    i9++;
                    float f = Float.MAX_VALUE;
                    int i10 = 0;
                    int i11 = -1;
                    int i12 = -1;
                    int i13 = 0;
                    while (true) {
                        if (i10 >= this.mNumRows) {
                            break;
                        }
                        ArrayRow arrayRow2 = this.mRows[i10];
                        if (arrayRow2.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < 0.0f) {
                            int i14 = 9;
                            if (SKIP_COLUMNS) {
                                int currentSize = arrayRow2.variables.getCurrentSize();
                                int i15 = 0;
                                while (i15 < currentSize) {
                                    SolverVariable variable = arrayRow2.variables.getVariable(i15);
                                    float f4 = arrayRow2.variables.get(variable);
                                    if (f4 > 0.0f) {
                                        int i16 = 0;
                                        while (i16 < i14) {
                                            float f10 = variable.strengthVector[i16] / f4;
                                            if ((f10 < f && i16 == i13) || i16 > i13) {
                                                i13 = i16;
                                                i12 = variable.f1075id;
                                                i11 = i10;
                                                f = f10;
                                            }
                                            i16++;
                                            i14 = 9;
                                        }
                                    }
                                    i15++;
                                    i14 = 9;
                                }
                            } else {
                                for (int i17 = 1; i17 < this.mNumColumns; i17++) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i17];
                                    float f11 = arrayRow2.variables.get(solverVariable);
                                    if (f11 > 0.0f) {
                                        for (int i18 = 0; i18 < 9; i18++) {
                                            float f12 = solverVariable.strengthVector[i18] / f11;
                                            if ((f12 < f && i18 == i13) || i18 > i13) {
                                                i13 = i18;
                                                i11 = i10;
                                                i12 = i17;
                                                f = f12;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i10++;
                    }
                    if (i11 != -1) {
                        ArrayRow arrayRow3 = this.mRows[i11];
                        arrayRow3.variable.definitionId = -1;
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow3.pivot(this.mCache.mIndexedVariables[i12]);
                        SolverVariable solverVariable2 = arrayRow3.variable;
                        solverVariable2.definitionId = i11;
                        solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                    } else {
                        z2 = true;
                    }
                    if (i9 > this.mNumColumns / 2) {
                        z2 = true;
                    }
                }
                return i9;
            }
        }
        return 0;
    }

    private String getDisplaySize(int i8) {
        int i9 = i8 * 4;
        int i10 = i9 / 1024;
        int i11 = i10 / 1024;
        if (i11 > 0) {
            return a.h(i11, "", " Mb");
        }
        return i10 > 0 ? a.h(i10, "", " Kb") : a.h(i9, "", " bytes");
    }

    private String getDisplayStrength(int i8) {
        if (i8 == 1) {
            return "LOW";
        }
        if (i8 == 2) {
            return "MEDIUM";
        }
        if (i8 == 3) {
            return "HIGH";
        }
        if (i8 == 4) {
            return "HIGHEST";
        }
        if (i8 == 5) {
            return "EQUALITY";
        }
        if (i8 == 8) {
            return "FIXED";
        }
        return i8 == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i8 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i8;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i8);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i9 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i9];
        this.mMaxColumns = i9;
        this.mMaxRows = i9;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i9);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(Row row, boolean z2) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i8 = 0; i8 < this.mNumColumns; i8++) {
            this.mAlreadyTestedCandidates[i8] = false;
        }
        boolean z3 = false;
        int i9 = 0;
        while (!z3) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i9++;
            if (i9 >= this.mNumColumns * 2) {
                return i9;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().f1075id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i10 = pivotCandidate.f1075id;
                if (zArr[i10]) {
                    return i9;
                }
                zArr[i10] = true;
            }
            if (pivotCandidate != null) {
                float f = Float.MAX_VALUE;
                int i11 = -1;
                for (int i12 = 0; i12 < this.mNumRows; i12++) {
                    ArrayRow arrayRow = this.mRows[i12];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f4 = arrayRow.variables.get(pivotCandidate);
                        if (f4 < 0.0f) {
                            float f10 = (-arrayRow.constantValue) / f4;
                            if (f10 < f) {
                                i11 = i12;
                                f = f10;
                            }
                        }
                    }
                }
                if (i11 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i11];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i11;
                    solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                }
            } else {
                z3 = true;
            }
        }
        return i9;
    }

    private void releaseRows() {
        int i8 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i8 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i8];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i8] = null;
                i8++;
            }
            return;
        }
        while (i8 < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i8];
            if (arrayRow2 != null) {
                this.mCache.arrayRowPool.release(arrayRow2);
            }
            this.mRows[i8] = null;
            i8++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i8) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableCreateObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableCreateObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableCreateObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableCreateObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable solverVariableCreateObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable solverVariableCreateObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable solverVariableCreateObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable solverVariableCreateObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow arrayRowCreateRow = createRow();
        double d7 = f;
        double d10 = i8;
        arrayRowCreateRow.createRowWithAngle(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable8, (float) (Math.sin(d7) * d10));
        addConstraint(arrayRowCreateRow);
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowWithAngle(solverVariableCreateObjectVariable, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable7, (float) (Math.cos(d7) * d10));
        addConstraint(arrayRowCreateRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i9, int i10) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowCentering(solverVariable, solverVariable2, i8, f, solverVariable3, solverVariable4, i9);
        if (i10 != 8) {
            arrayRowCreateRow.addError(this, i10);
        }
        addConstraint(arrayRowCreateRow);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0098  */
    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable solverVariablePickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.isSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z2 = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z3 = false;
        if (!arrayRow.isSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable solverVariableCreateExtraVariable = createExtraVariable();
                arrayRow.variable = solverVariableCreateExtraVariable;
                int i8 = this.mNumRows;
                addRow(arrayRow);
                if (this.mNumRows == i8 + 1) {
                    this.mTempGoal.initFromRow(arrayRow);
                    optimize(this.mTempGoal, true);
                    if (solverVariableCreateExtraVariable.definitionId == -1) {
                        if (arrayRow.variable == solverVariableCreateExtraVariable && (solverVariablePickPivot = arrayRow.pickPivot(solverVariableCreateExtraVariable)) != null) {
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow.pivot(solverVariablePickPivot);
                        }
                        if (!arrayRow.isSimpleDefinition) {
                            arrayRow.variable.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.optimizedArrayRowPool.release(arrayRow);
                        } else {
                            this.mCache.arrayRowPool.release(arrayRow);
                        }
                        this.mNumRows--;
                    }
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            } else {
                z3 = z2;
            }
        }
        if (z3) {
            return;
        }
        addRow(arrayRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, int i9) {
        if (USE_BASIC_SYNONYMS && i9 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i8);
            return null;
        }
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowEquals(solverVariable, solverVariable2, i8);
        if (i9 != 8) {
            arrayRowCreateRow.addError(this, i9);
        }
        addConstraint(arrayRowCreateRow);
        return arrayRowCreateRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i8);
        addConstraint(arrayRowCreateRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, int i9) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i8);
        if (i9 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i9);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i8);
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, int i9) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i8);
        if (i9 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i9);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i8) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i8 != 8) {
            arrayRowCreateRow.addError(this, i8);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i8) {
        if (solverVariable.definitionId != -1 || i8 != 0) {
            addEquality(solverVariable, solverVariable2, i8, 8);
            return;
        }
        if (solverVariable2.isSynonym) {
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.synonym];
        }
        if (solverVariable.isSynonym) {
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.synonym];
        } else {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        }
    }

    public final void cleanupRows() {
        int i8;
        int i9 = 0;
        while (i9 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i9];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i10 = i9;
                while (true) {
                    i8 = this.mNumRows;
                    if (i10 >= i8 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i11 = i10 + 1;
                    arrayRowArr[i10] = arrayRowArr[i11];
                    i10 = i11;
                }
                this.mRows[i8 - 1] = null;
                this.mNumRows = i8 - 1;
                i9--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.optimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.arrayRowPool.release(arrayRow);
                }
            }
            i9++;
        }
    }

    public SolverVariable createErrorVariable(int i8, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i9 = this.mVariablesID + 1;
        this.mVariablesID = i9;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f1075id = i9;
        solverVariableAcquireSolverVariable.strength = i8;
        this.mCache.mIndexedVariables[i9] = solverVariableAcquireSolverVariable;
        this.mGoal.addError(solverVariableAcquireSolverVariable);
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i8 = this.mVariablesID + 1;
        this.mVariablesID = i8;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f1075id = i8;
        this.mCache.mIndexedVariables[i8] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i8 = solverVariable.f1075id;
            if (i8 == -1 || i8 > this.mVariablesID || this.mCache.mIndexedVariables[i8] == null) {
                if (i8 != -1) {
                    solverVariable.reset();
                }
                int i9 = this.mVariablesID + 1;
                this.mVariablesID = i9;
                this.mNumColumns++;
                solverVariable.f1075id = i9;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i9] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRowAcquire;
        if (OPTIMIZED_ENGINE) {
            arrayRowAcquire = this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        } else {
            arrayRowAcquire = this.mCache.arrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRowAcquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i8 = this.mVariablesID + 1;
        this.mVariablesID = i8;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.f1075id = i8;
        this.mCache.mIndexedVariables[i8] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String strM = a.m(new StringBuilder(" num vars "), "\n", this.mVariablesID);
        for (int i8 = 0; i8 < this.mVariablesID + 1; i8++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i8];
            if (solverVariable != null && solverVariable.isFinalValue) {
                strM = strM + " $[" + i8 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String strB = a.B(strM, "\n");
        for (int i9 = 0; i9 < this.mVariablesID + 1; i9++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i9];
            if (solverVariable2 != null && solverVariable2.isSynonym) {
                strB = strB + " ~[" + i9 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.synonym] + " + " + solverVariable2.synonymDelta + "\n";
            }
        }
        String strB2 = a.B(strB, "\n\n #  ");
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            StringBuilder sbS = d.s(strB2);
            sbS.append(this.mRows[i10].toReadableString());
            strB2 = a.B(sbS.toString(), "\n #  ");
        }
        if (this.mGoal != null) {
            StringBuilder sbT = d.t(strB2, "Goal: ");
            sbT.append(this.mGoal);
            sbT.append("\n");
            strB2 = sbT.toString();
        }
        System.out.println(strB2);
    }

    public void displaySystemInformation() {
        int iSizeInBytes = 0;
        for (int i8 = 0; i8 < this.TABLE_SIZE; i8++) {
            ArrayRow arrayRow = this.mRows[i8];
            if (arrayRow != null) {
                iSizeInBytes += arrayRow.sizeInBytes();
            }
        }
        int iSizeInBytes2 = 0;
        for (int i9 = 0; i9 < this.mNumRows; i9++) {
            ArrayRow arrayRow2 = this.mRows[i9];
            if (arrayRow2 != null) {
                iSizeInBytes2 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb2 = new StringBuilder("Linear System -> Table size: ");
        sb2.append(this.TABLE_SIZE);
        sb2.append(" (");
        int i10 = this.TABLE_SIZE;
        sb2.append(getDisplaySize(i10 * i10));
        sb2.append(") -- row sizes: ");
        sb2.append(getDisplaySize(iSizeInBytes));
        sb2.append(", actual size: ");
        sb2.append(getDisplaySize(iSizeInBytes2));
        sb2.append(" rows: ");
        sb2.append(this.mNumRows);
        sb2.append("/");
        sb2.append(this.mMaxRows);
        sb2.append(" cols: ");
        sb2.append(this.mNumColumns);
        sb2.append("/");
        sb2.append(this.mMaxColumns);
        sb2.append(" 0 occupied cells, ");
        sb2.append(getDisplaySize(0));
        printStream.println(sb2.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String strB = "";
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            if (this.mRows[i8].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder sbS = d.s(strB);
                sbS.append(this.mRows[i8].toReadableString());
                strB = a.B(sbS.toString(), "\n");
            }
        }
        StringBuilder sbS2 = d.s(strB);
        sbS2.append(this.mGoal);
        sbS2.append("\n");
        System.out.println(sbS2.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int iSizeInBytes = 0;
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            ArrayRow arrayRow = this.mRows[i8];
            if (arrayRow != null) {
                iSizeInBytes = arrayRow.sizeInBytes() + iSizeInBytes;
            }
        }
        return iSizeInBytes;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int i8) {
        return this.mRows[i8];
    }

    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            if (!this.mRows[i8].isSimpleDefinition) {
                minimizeGoal(this.mGoal);
                return;
            }
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i8;
        if (!arrayRow.isSimpleDefinition || (solverVariable = arrayRow.variable) == null) {
            return;
        }
        int i9 = solverVariable.definitionId;
        if (i9 != -1) {
            while (true) {
                i8 = this.mNumRows;
                if (i9 >= i8 - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i10 = i9 + 1;
                ArrayRow arrayRow2 = arrayRowArr[i10];
                SolverVariable solverVariable2 = arrayRow2.variable;
                if (solverVariable2.definitionId == i10) {
                    solverVariable2.definitionId = i9;
                }
                arrayRowArr[i9] = arrayRow2;
                i9 = i10;
            }
            this.mNumRows = i8 - 1;
        }
        SolverVariable solverVariable3 = arrayRow.variable;
        if (!solverVariable3.isFinalValue) {
            solverVariable3.setFinalValue(this, arrayRow.constantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.optimizedArrayRowPool.release(arrayRow);
        } else {
            this.mCache.arrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        Cache cache;
        int i8 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i8 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i8];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i8++;
        }
        cache.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> map = this.mVariables;
        if (map != null) {
            map.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i9 = 0; i9 < this.mNumRows; i9++) {
            ArrayRow arrayRow = this.mRows[i9];
            if (arrayRow != null) {
                arrayRow.used = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public void addSingleError(ArrayRow arrayRow, int i8, int i9) {
        arrayRow.addSingleError(createErrorVariable(i9, null), i8);
    }

    public void addEquality(SolverVariable solverVariable, int i8) {
        if (USE_BASIC_SYNONYMS && solverVariable.definitionId == -1) {
            float f = i8;
            solverVariable.setFinalValue(this, f);
            for (int i9 = 0; i9 < this.mVariablesID + 1; i9++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i9];
                if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.f1075id) {
                    solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f);
                }
            }
            return;
        }
        int i10 = solverVariable.definitionId;
        if (i10 != -1) {
            ArrayRow arrayRow = this.mRows[i10];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = i8;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = i8;
                return;
            } else {
                ArrayRow arrayRowCreateRow = createRow();
                arrayRowCreateRow.createRowEquals(solverVariable, i8);
                addConstraint(arrayRowCreateRow);
                return;
            }
        }
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowDefinition(solverVariable, i8);
        addConstraint(arrayRowCreateRow2);
    }
}
