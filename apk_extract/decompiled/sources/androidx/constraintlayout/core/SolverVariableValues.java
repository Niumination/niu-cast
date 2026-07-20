package androidx.constraintlayout.core;

import h0.a;
import java.util.Arrays;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i8) {
        int[] iArr;
        int i9 = solverVariable.f1075id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i10 = iArr2[i9];
        if (i10 == -1) {
            iArr2[i9] = i8;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i11 = iArr[i10];
                if (i11 == -1) {
                    break;
                } else {
                    i10 = i11;
                }
            }
            iArr[i10] = i8;
        }
        this.nextKeys[i8] = -1;
    }

    private void addVariable(int i8, SolverVariable solverVariable, float f) {
        this.variables[i8] = solverVariable.f1075id;
        this.values[i8] = f;
        this.previous[i8] = -1;
        this.next[i8] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i8 = 0; i8 < this.HASH_SIZE; i8++) {
            if (this.keys[i8] != -1) {
                String string = hashCode() + " hash [" + i8 + "] => ";
                int i9 = this.keys[i8];
                boolean z2 = false;
                while (!z2) {
                    StringBuilder sbT = d.t(string, " ");
                    sbT.append(this.variables[i9]);
                    string = sbT.toString();
                    int i10 = this.nextKeys[i9];
                    if (i10 != -1) {
                        i9 = i10;
                    } else {
                        z2 = true;
                    }
                }
                System.out.println(string);
            }
        }
    }

    private int findEmptySlot() {
        for (int i8 = 0; i8 < this.SIZE; i8++) {
            if (this.variables[i8] == -1) {
                return i8;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i8 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i8);
        this.values = Arrays.copyOf(this.values, i8);
        this.previous = Arrays.copyOf(this.previous, i8);
        this.next = Arrays.copyOf(this.next, i8);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i8);
        for (int i9 = this.SIZE; i9 < i8; i9++) {
            this.variables[i9] = -1;
            this.nextKeys[i9] = -1;
        }
        this.SIZE = i8;
    }

    private void insertVariable(int i8, SolverVariable solverVariable, float f) {
        int iFindEmptySlot = findEmptySlot();
        addVariable(iFindEmptySlot, solverVariable, f);
        if (i8 != -1) {
            this.previous[iFindEmptySlot] = i8;
            int[] iArr = this.next;
            iArr[iFindEmptySlot] = iArr[i8];
            iArr[i8] = iFindEmptySlot;
        } else {
            this.previous[iFindEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[iFindEmptySlot] = this.head;
                this.head = iFindEmptySlot;
            } else {
                this.next[iFindEmptySlot] = -1;
            }
        }
        int i9 = this.next[iFindEmptySlot];
        if (i9 != -1) {
            this.previous[i9] = iFindEmptySlot;
        }
        addToHashMap(solverVariable, iFindEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i8;
        int i9 = solverVariable.f1075id;
        int i10 = i9 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i11 = iArr2[i10];
        if (i11 == -1) {
            return;
        }
        if (this.variables[i11] == i9) {
            int[] iArr3 = this.nextKeys;
            iArr2[i10] = iArr3[i11];
            iArr3[i11] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i8 = iArr[i11];
            if (i8 == -1 || this.variables[i8] == i9) {
                break;
            } else {
                i11 = i8;
            }
        }
        if (i8 == -1 || this.variables[i8] != i9) {
            return;
        }
        iArr[i11] = iArr[i8];
        iArr[i8] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z2) {
        float f4 = epsilon;
        if (f <= (-f4) || f >= f4) {
            int iIndexOf = indexOf(solverVariable);
            if (iIndexOf == -1) {
                put(solverVariable, f);
                return;
            }
            float[] fArr = this.values;
            float f10 = fArr[iIndexOf] + f;
            fArr[iIndexOf] = f10;
            float f11 = epsilon;
            if (f10 <= (-f11) || f10 >= f11) {
                return;
            }
            fArr[iIndexOf] = 0.0f;
            remove(solverVariable, z2);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i8 = this.mCount;
        for (int i9 = 0; i9 < i8; i9++) {
            SolverVariable variable = getVariable(i9);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i10 = 0; i10 < this.SIZE; i10++) {
            this.variables[i10] = -1;
            this.nextKeys[i10] = -1;
        }
        for (int i11 = 0; i11 < this.HASH_SIZE; i11++) {
            this.keys[i11] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i8 = this.mCount;
        System.out.print("{ ");
        for (int i9 = 0; i9 < i8; i9++) {
            SolverVariable variable = getVariable(i9);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i9) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        int i8 = this.mCount;
        int i9 = this.head;
        for (int i10 = 0; i10 < i8; i10++) {
            float[] fArr = this.values;
            fArr[i9] = fArr[i9] / f;
            i9 = this.next[i9];
            if (i9 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            return this.values[iIndexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i8) {
        int i9 = this.mCount;
        if (i9 == 0) {
            return null;
        }
        int i10 = this.head;
        for (int i11 = 0; i11 < i9; i11++) {
            if (i11 == i8 && i10 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i10]];
            }
            i10 = this.next[i10];
            if (i10 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i8) {
        int i9 = this.mCount;
        int i10 = this.head;
        for (int i11 = 0; i11 < i9; i11++) {
            if (i11 == i8) {
                return this.values[i10];
            }
            i10 = this.next[i10];
            if (i10 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i8 = solverVariable.f1075id;
            int i9 = this.keys[i8 % this.HASH_SIZE];
            if (i9 == -1) {
                return -1;
            }
            if (this.variables[i9] == i8) {
                return i9;
            }
            do {
                i9 = this.nextKeys[i9];
                if (i9 == -1) {
                    break;
                }
            } while (this.variables[i9] != i8);
            if (i9 != -1 && this.variables[i9] == i8) {
                return i9;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i8 = this.mCount;
        int i9 = this.head;
        for (int i10 = 0; i10 < i8; i10++) {
            float[] fArr = this.values;
            fArr[i9] = fArr[i9] * (-1.0f);
            i9 = this.next[i9];
            if (i9 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f) {
        float f4 = epsilon;
        if (f > (-f4) && f < f4) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            this.values[iIndexOf] = f;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i8 = this.mCount;
        int i9 = this.head;
        int i10 = -1;
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = this.variables[i9];
            int i13 = solverVariable.f1075id;
            if (i12 == i13) {
                this.values[i9] = f;
                return;
            }
            if (i12 < i13) {
                i10 = i9;
            }
            i9 = this.next[i9];
            if (i9 == -1) {
                break;
            }
        }
        insertVariable(i10, solverVariable, f);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z2) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f = this.values[iIndexOf];
        if (this.head == iIndexOf) {
            this.head = this.next[iIndexOf];
        }
        this.variables[iIndexOf] = -1;
        int[] iArr = this.previous;
        int i8 = iArr[iIndexOf];
        if (i8 != -1) {
            int[] iArr2 = this.next;
            iArr2[i8] = iArr2[iIndexOf];
        }
        int i9 = this.next[iIndexOf];
        if (i9 != -1) {
            iArr[i9] = iArr[iIndexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z2) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String strB;
        String strB2;
        String strB3 = hashCode() + " { ";
        int i8 = this.mCount;
        for (int i9 = 0; i9 < i8; i9++) {
            SolverVariable variable = getVariable(i9);
            if (variable != null) {
                String str = strB3 + variable + " = " + getVariableValue(i9) + " ";
                int iIndexOf = indexOf(variable);
                String strB4 = a.B(str, "[p: ");
                if (this.previous[iIndexOf] != -1) {
                    StringBuilder sbS = d.s(strB4);
                    sbS.append(this.mCache.mIndexedVariables[this.variables[this.previous[iIndexOf]]]);
                    strB = sbS.toString();
                } else {
                    strB = a.B(strB4, "none");
                }
                String strB5 = a.B(strB, ", n: ");
                if (this.next[iIndexOf] != -1) {
                    StringBuilder sbS2 = d.s(strB5);
                    sbS2.append(this.mCache.mIndexedVariables[this.variables[this.next[iIndexOf]]]);
                    strB2 = sbS2.toString();
                } else {
                    strB2 = a.B(strB5, "none");
                }
                strB3 = a.B(strB2, "]");
            }
        }
        return a.B(strB3, " }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z2) {
        float f = get(arrayRow.variable);
        remove(arrayRow.variable, z2);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i8 = 0;
        int i9 = 0;
        while (i8 < currentSize) {
            int i10 = solverVariableValues.variables[i9];
            if (i10 != -1) {
                add(this.mCache.mIndexedVariables[i10], solverVariableValues.values[i9] * f, z2);
                i8++;
            }
            i9++;
        }
        return f;
    }
}
