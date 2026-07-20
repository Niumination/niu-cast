package androidx.constraintlayout.core;

import j.a;
import java.util.Arrays;
import k.c;

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

    private void addToHashMap(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f429id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            iArr[i12] = i10;
        }
        this.nextKeys[i10] = -1;
    }

    private void addVariable(int i10, SolverVariable solverVariable, float f10) {
        this.variables[i10] = solverVariable.f429id;
        this.values[i10] = f10;
        this.previous[i10] = -1;
        this.next[i10] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i10 = 0; i10 < this.HASH_SIZE; i10++) {
            if (this.keys[i10] != -1) {
                String string = hashCode() + " hash [" + i10 + "] => ";
                int i11 = this.keys[i10];
                boolean z10 = false;
                while (!z10) {
                    StringBuilder sbA = c.a(string, " ");
                    sbA.append(this.variables[i11]);
                    string = sbA.toString();
                    int i12 = this.nextKeys[i11];
                    if (i12 != -1) {
                        i11 = i12;
                    } else {
                        z10 = true;
                    }
                }
                System.out.println(string);
            }
        }
    }

    private int findEmptySlot() {
        for (int i10 = 0; i10 < this.SIZE; i10++) {
            if (this.variables[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i10 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i10);
        this.values = Arrays.copyOf(this.values, i10);
        this.previous = Arrays.copyOf(this.previous, i10);
        this.next = Arrays.copyOf(this.next, i10);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i10);
        for (int i11 = this.SIZE; i11 < i10; i11++) {
            this.variables[i11] = -1;
            this.nextKeys[i11] = -1;
        }
        this.SIZE = i10;
    }

    private void insertVariable(int i10, SolverVariable solverVariable, float f10) {
        int iFindEmptySlot = findEmptySlot();
        addVariable(iFindEmptySlot, solverVariable, f10);
        if (i10 != -1) {
            this.previous[iFindEmptySlot] = i10;
            int[] iArr = this.next;
            iArr[iFindEmptySlot] = iArr[i10];
            iArr[i10] = iFindEmptySlot;
        } else {
            this.previous[iFindEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[iFindEmptySlot] = this.head;
                this.head = iFindEmptySlot;
            } else {
                this.next[iFindEmptySlot] = -1;
            }
        }
        int i11 = this.next[iFindEmptySlot];
        if (i11 != -1) {
            this.previous[i11] = iFindEmptySlot;
        }
        addToHashMap(solverVariable, iFindEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i10;
        int i11 = solverVariable.f429id;
        int i12 = i11 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            return;
        }
        if (this.variables[i13] == i11) {
            int[] iArr3 = this.nextKeys;
            iArr2[i12] = iArr3[i13];
            iArr3[i13] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            i10 = iArr[i13];
            if (i10 == -1 || this.variables[i10] == i11) {
                break;
            } else {
                i13 = i10;
            }
        }
        if (i10 == -1 || this.variables[i10] != i11) {
            return;
        }
        iArr[i13] = iArr[i10];
        iArr[i10] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = epsilon;
        if (f10 <= (-f11) || f10 >= f11) {
            int iIndexOf = indexOf(solverVariable);
            if (iIndexOf == -1) {
                put(solverVariable, f10);
                return;
            }
            float[] fArr = this.values;
            float f12 = fArr[iIndexOf] + f10;
            fArr[iIndexOf] = f12;
            float f13 = epsilon;
            if (f12 <= (-f13) || f12 >= f13) {
                return;
            }
            fArr[iIndexOf] = 0.0f;
            remove(solverVariable, z10);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i10 = this.mCount;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i12 = 0; i12 < this.SIZE; i12++) {
            this.variables[i12] = -1;
            this.nextKeys[i12] = -1;
        }
        for (int i13 = 0; i13 < this.HASH_SIZE; i13++) {
            this.keys[i13] = -1;
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
        int i10 = this.mCount;
        System.out.print("{ ");
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i11) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f10) {
        int i10 = this.mCount;
        int i11 = this.head;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.values;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.next[i11];
            if (i11 == -1) {
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
    public SolverVariable getVariable(int i10) {
        int i11 = this.mCount;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.head;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i12]];
            }
            i12 = this.next[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i10) {
        int i11 = this.mCount;
        int i12 = this.head;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.values[i12];
            }
            i12 = this.next[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i10 = solverVariable.f429id;
            int i11 = this.keys[i10 % this.HASH_SIZE];
            if (i11 == -1) {
                return -1;
            }
            if (this.variables[i11] == i10) {
                return i11;
            }
            do {
                i11 = this.nextKeys[i11];
                if (i11 == -1) {
                    break;
                }
            } while (this.variables[i11] != i10);
            if (i11 != -1 && this.variables[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i10 = this.mCount;
        int i11 = this.head;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.values;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.next[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f10) {
        float f11 = epsilon;
        if (f10 > (-f11) && f10 < f11) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f10);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            this.values[iIndexOf] = f10;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i10 = this.mCount;
        int i11 = this.head;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.variables[i11];
            int i15 = solverVariable.f429id;
            if (i14 == i15) {
                this.values[i11] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i11;
            }
            i11 = this.next[i11];
            if (i11 == -1) {
                break;
            }
        }
        insertVariable(i12, solverVariable, f10);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z10) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f10 = this.values[iIndexOf];
        if (this.head == iIndexOf) {
            this.head = this.next[iIndexOf];
        }
        this.variables[iIndexOf] = -1;
        int[] iArr = this.previous;
        int i10 = iArr[iIndexOf];
        if (i10 != -1) {
            int[] iArr2 = this.next;
            iArr2[i10] = iArr2[iIndexOf];
        }
        int i11 = this.next[iIndexOf];
        if (i11 != -1) {
            iArr[i11] = iArr[iIndexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z10) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f10;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String strA;
        String strA2;
        String strA3 = hashCode() + " { ";
        int i10 = this.mCount;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                String str = strA3 + variable + " = " + getVariableValue(i11) + " ";
                int iIndexOf = indexOf(variable);
                String strA4 = a.a(str, "[p: ");
                if (this.previous[iIndexOf] != -1) {
                    StringBuilder sbA = k.a.a(strA4);
                    sbA.append(this.mCache.mIndexedVariables[this.variables[this.previous[iIndexOf]]]);
                    strA = sbA.toString();
                } else {
                    strA = a.a(strA4, "none");
                }
                String strA5 = a.a(strA, ", n: ");
                if (this.next[iIndexOf] != -1) {
                    StringBuilder sbA2 = k.a.a(strA5);
                    sbA2.append(this.mCache.mIndexedVariables[this.variables[this.next[iIndexOf]]]);
                    strA2 = sbA2.toString();
                } else {
                    strA2 = a.a(strA5, "none");
                }
                strA3 = a.a(strA2, "]");
            }
        }
        return a.a(strA3, " }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z10) {
        float f10 = get(arrayRow.variable);
        remove(arrayRow.variable, z10);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i10 = 0;
        int i11 = 0;
        while (i10 < currentSize) {
            int i12 = solverVariableValues.variables[i11];
            if (i12 != -1) {
                add(this.mCache.mIndexedVariables[i12], solverVariableValues.values[i11] * f10, z10);
                i10++;
            }
            i11++;
        }
        return f10;
    }
}
