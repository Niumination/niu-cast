package androidx.constraintlayout.core;

import h0.a;
import java.util.ArrayList;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public ArrayRowVariables variables;
    SolverVariable variable = null;
    float constantValue = 0.0f;
    boolean used = false;
    ArrayList<SolverVariable> variablesToUpdate = new ArrayList<>();
    boolean isSimpleDefinition = false;

    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f, boolean z2);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i8);

        float getVariableValue(int i8);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f);

        float remove(SolverVariable solverVariable, boolean z2);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z2);
    }

    public ArrayRow() {
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f = 0.0f;
        for (int i8 = 0; i8 < currentSize; i8++) {
            float variableValue = this.variables.getVariableValue(i8);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i8);
                if ((zArr == null || !zArr[variable.f1075id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f)) {
                    f = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i8) {
        this.variables.put(linearSystem.createErrorVariable(i8, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i8, "em"), -1.0f);
        return this;
    }

    public ArrayRow addSingleError(SolverVariable solverVariable, int i8) {
        this.variables.put(solverVariable, i8);
        return this;
    }

    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z2;
        SolverVariable solverVariableChooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (solverVariableChooseSubjectInVariables == null) {
            z2 = true;
        } else {
            pivot(solverVariableChooseSubjectInVariables);
            z2 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
        }
        return z2;
    }

    public SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        float f = 0.0f;
        float f4 = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        SolverVariable solverVariable2 = null;
        for (int i8 = 0; i8 < currentSize; i8++) {
            float variableValue = this.variables.getVariableValue(i8);
            SolverVariable variable = this.variables.getVariable(i8);
            if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f > variableValue) {
                    boolean zIsNew = isNew(variable, linearSystem);
                    z2 = zIsNew;
                    f = variableValue;
                    solverVariable = variable;
                } else if (!z2 && isNew(variable, linearSystem)) {
                    f = variableValue;
                    solverVariable = variable;
                    z2 = true;
                }
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null || f4 > variableValue) {
                    boolean zIsNew2 = isNew(variable, linearSystem);
                    z3 = zIsNew2;
                    f4 = variableValue;
                    solverVariable2 = variable;
                } else if (!z3 && isNew(variable, linearSystem)) {
                    f4 = variableValue;
                    solverVariable2 = variable;
                    z3 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i8, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i9) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i8 > 0 || i9 > 0) {
                this.constantValue = (-i8) + i9;
            }
        } else if (f <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = i8;
        } else if (f >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.constantValue = -i9;
        } else {
            float f4 = 1.0f - f;
            this.variables.put(solverVariable, f4 * 1.0f);
            this.variables.put(solverVariable2, f4 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f);
            this.variables.put(solverVariable4, 1.0f * f);
            if (i8 > 0 || i9 > 0) {
                this.constantValue = (i9 * f) + ((-i8) * f4);
            }
        }
        return this;
    }

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i8) {
        this.variable = solverVariable;
        float f = i8;
        solverVariable.computedValue = f;
        this.constantValue = f;
        this.isSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f, float f4, float f10, SolverVariable solverVariable, int i8, SolverVariable solverVariable2, int i9, SolverVariable solverVariable3, int i10, SolverVariable solverVariable4, int i11) {
        if (f4 == 0.0f || f == f10) {
            this.constantValue = ((-i8) - i9) + i10 + i11;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            float f11 = (f / f4) / (f10 / f4);
            this.constantValue = (i11 * f11) + (i10 * f11) + ((-i8) - i9);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f11);
            this.variables.put(solverVariable3, -f11);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f4, float f10, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f4 == 0.0f || f == f10) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else if (f == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        } else if (f10 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
        } else {
            float f11 = (f / f4) / (f10 / f4);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f11);
            this.variables.put(solverVariable3, -f11);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i8) {
        if (i8 < 0) {
            this.constantValue = i8 * (-1);
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = i8;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i8) {
        boolean z2 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z2 = true;
            }
            this.constantValue = i8;
        }
        if (z2) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i8) {
        boolean z2 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z2 = true;
            }
            this.constantValue = i8;
        }
        if (z2) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f;
        return this;
    }

    public void ensurePositiveConstant() {
        float f = this.constantValue;
        if (f < 0.0f) {
            this.constantValue = f * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public boolean hasKeyVariable() {
        SolverVariable solverVariable = this.variable;
        return solverVariable != null && (solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.constantValue >= 0.0f);
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.variable = null;
            this.variables.clear();
            for (int i8 = 0; i8 < arrayRow.variables.getCurrentSize(); i8++) {
                this.variables.add(arrayRow.variables.getVariable(i8), arrayRow.variables.getVariableValue(i8), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables(null, solverVariable);
    }

    public void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable.definitionId = -1;
            this.variable = null;
        }
        float fRemove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.variable = solverVariable;
        if (fRemove == 1.0f) {
            return;
        }
        this.constantValue /= fRemove;
        this.variables.divideByAmount(fRemove);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    public int sizeInBytes() {
        return this.variables.sizeInBytes() + (this.variable != null ? 4 : 0) + 8;
    }

    public String toReadableString() {
        boolean z2;
        String strB = a.B(this.variable == null ? "0" : "" + this.variable, " = ");
        if (this.constantValue != 0.0f) {
            StringBuilder sbS = d.s(strB);
            sbS.append(this.constantValue);
            strB = sbS.toString();
            z2 = true;
        } else {
            z2 = false;
        }
        int currentSize = this.variables.getCurrentSize();
        for (int i8 = 0; i8 < currentSize; i8++) {
            SolverVariable variable = this.variables.getVariable(i8);
            if (variable != null) {
                float variableValue = this.variables.getVariableValue(i8);
                if (variableValue != 0.0f) {
                    String string = variable.toString();
                    if (z2) {
                        if (variableValue > 0.0f) {
                            strB = a.B(strB, " + ");
                        } else {
                            strB = a.B(strB, " - ");
                            variableValue *= -1.0f;
                        }
                    } else if (variableValue < 0.0f) {
                        strB = a.B(strB, "- ");
                        variableValue *= -1.0f;
                    }
                    strB = variableValue == 1.0f ? a.B(strB, string) : strB + variableValue + " " + string;
                    z2 = true;
                }
            }
        }
        return !z2 ? a.B(strB, "0.0") : strB;
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2) {
        if (solverVariable == null || !solverVariable.isFinalValue) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.constantValue = (solverVariable.computedValue * f) + this.constantValue;
        this.variables.remove(solverVariable, z2);
        if (z2) {
            solverVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2) {
        float fUse = this.variables.use(arrayRow, z2);
        this.constantValue = (arrayRow.constantValue * fUse) + this.constantValue;
        if (z2) {
            arrayRow.variable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2) {
        if (solverVariable == null || !solverVariable.isSynonym) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.constantValue = (solverVariable.synonymDelta * f) + this.constantValue;
        this.variables.remove(solverVariable, z2);
        if (z2) {
            solverVariable.removeFromRow(this);
        }
        this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.synonym], f, z2);
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean z2 = false;
        while (!z2) {
            int currentSize = this.variables.getCurrentSize();
            for (int i8 = 0; i8 < currentSize; i8++) {
                SolverVariable variable = this.variables.getVariable(i8);
                if (variable.definitionId != -1 || variable.isFinalValue || variable.isSynonym) {
                    this.variablesToUpdate.add(variable);
                }
            }
            int size = this.variablesToUpdate.size();
            if (size > 0) {
                for (int i9 = 0; i9 < size; i9++) {
                    SolverVariable solverVariable = this.variablesToUpdate.get(i9);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.isSynonym) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.mRows[solverVariable.definitionId], true);
                    }
                }
                this.variablesToUpdate.clear();
            } else {
                z2 = true;
            }
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variable != null && this.variables.getCurrentSize() == 0) {
            this.isSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        int i8 = solverVariable.strength;
        float f = 1.0f;
        if (i8 != 1) {
            if (i8 == 2) {
                f = 1000.0f;
            } else if (i8 == 3) {
                f = 1000000.0f;
            } else if (i8 == 4) {
                f = 1.0E9f;
            } else if (i8 == 5) {
                f = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f);
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i8) {
        boolean z2 = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z2 = true;
            }
            this.constantValue = i8;
        }
        if (!z2) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i8, SolverVariable solverVariable2) {
        this.constantValue = i8;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
