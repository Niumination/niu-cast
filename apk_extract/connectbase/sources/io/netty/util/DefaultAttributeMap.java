package io.netty.util;

import cb.b;
import io.netty.util.internal.ObjectUtil;
import j.d;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultAttributeMap implements AttributeMap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, DefaultAttribute[]> ATTRIBUTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, DefaultAttribute[].class, "attributes");
    private static final DefaultAttribute[] EMPTY_ATTRIBUTES = new DefaultAttribute[0];
    private volatile DefaultAttribute[] attributes = EMPTY_ATTRIBUTES;

    public static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private static final AtomicReferenceFieldUpdater<DefaultAttribute, DefaultAttributeMap> MAP_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttribute.class, DefaultAttributeMap.class, "attributeMap");
        private static final long serialVersionUID = -2661411462200283011L;
        private volatile DefaultAttributeMap attributeMap;
        private final AttributeKey<T> key;

        public DefaultAttribute(DefaultAttributeMap defaultAttributeMap, AttributeKey<T> attributeKey) {
            this.attributeMap = defaultAttributeMap;
            this.key = attributeKey;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRemoved() {
            return this.attributeMap == null;
        }

        @Override // io.netty.util.Attribute
        public T getAndRemove() {
            DefaultAttributeMap defaultAttributeMap = this.attributeMap;
            boolean z10 = defaultAttributeMap != null && d.a(MAP_UPDATER, this, defaultAttributeMap, null);
            T andSet = getAndSet(null);
            if (z10) {
                defaultAttributeMap.removeAttributeIfMatch(this.key, this);
            }
            return andSet;
        }

        @Override // io.netty.util.Attribute
        public AttributeKey<T> key() {
            return this.key;
        }

        @Override // io.netty.util.Attribute
        public void remove() {
            DefaultAttributeMap defaultAttributeMap = this.attributeMap;
            boolean z10 = defaultAttributeMap != null && d.a(MAP_UPDATER, this, defaultAttributeMap, null);
            set(null);
            if (z10) {
                defaultAttributeMap.removeAttributeIfMatch(this.key, this);
            }
        }

        @Override // io.netty.util.Attribute
        public T setIfAbsent(T t10) {
            T t11;
            do {
                t11 = null;
                if (compareAndSet(null, t10)) {
                    break;
                }
                t11 = get();
            } while (t11 == null);
            return t11;
        }
    }

    private static void orderedCopyOnInsert(DefaultAttribute[] defaultAttributeArr, int i10, DefaultAttribute[] defaultAttributeArr2, DefaultAttribute defaultAttribute) {
        int iId = defaultAttribute.key.id();
        int i11 = i10 - 1;
        while (i11 >= 0 && defaultAttributeArr[i11].key.id() >= iId) {
            defaultAttributeArr2[i11 + 1] = defaultAttributeArr[i11];
            i11--;
        }
        int i12 = i11 + 1;
        defaultAttributeArr2[i12] = defaultAttribute;
        if (i12 > 0) {
            System.arraycopy(defaultAttributeArr, 0, defaultAttributeArr2, 0, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void removeAttributeIfMatch(AttributeKey<T> attributeKey, DefaultAttribute<T> defaultAttribute) {
        DefaultAttribute<T>[] defaultAttributeArr;
        DefaultAttribute[] defaultAttributeArr2;
        do {
            defaultAttributeArr = this.attributes;
            int iSearchAttributeByKey = searchAttributeByKey(defaultAttributeArr, attributeKey);
            if (iSearchAttributeByKey < 0 || defaultAttributeArr[iSearchAttributeByKey] != defaultAttribute) {
                return;
            }
            int length = defaultAttributeArr.length;
            int i10 = length - 1;
            defaultAttributeArr2 = i10 == 0 ? EMPTY_ATTRIBUTES : new DefaultAttribute[i10];
            System.arraycopy(defaultAttributeArr, 0, defaultAttributeArr2, 0, iSearchAttributeByKey);
            int i11 = (length - iSearchAttributeByKey) - 1;
            if (i11 > 0) {
                System.arraycopy(defaultAttributeArr, iSearchAttributeByKey + 1, defaultAttributeArr2, iSearchAttributeByKey, i11);
            }
        } while (!d.a(ATTRIBUTES_UPDATER, this, defaultAttributeArr, defaultAttributeArr2));
    }

    private static int searchAttributeByKey(DefaultAttribute[] defaultAttributeArr, AttributeKey<?> attributeKey) {
        int length = defaultAttributeArr.length - 1;
        int i10 = 0;
        while (i10 <= length) {
            int i11 = (i10 + length) >>> 1;
            AttributeKey<?> attributeKey2 = defaultAttributeArr[i11].key;
            if (attributeKey2 == attributeKey) {
                return i11;
            }
            if (attributeKey2.id() < attributeKey.id()) {
                i10 = i11 + 1;
            } else {
                length = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    @Override // io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        DefaultAttribute[] defaultAttributeArr;
        DefaultAttribute[] defaultAttributeArr2;
        ObjectUtil.checkNotNull(attributeKey, b.c.f1408o);
        DefaultAttribute defaultAttribute = null;
        do {
            defaultAttributeArr = this.attributes;
            int iSearchAttributeByKey = searchAttributeByKey(defaultAttributeArr, attributeKey);
            if (iSearchAttributeByKey >= 0) {
                DefaultAttribute defaultAttribute2 = defaultAttributeArr[iSearchAttributeByKey];
                if (!defaultAttribute2.isRemoved()) {
                    return defaultAttribute2;
                }
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                defaultAttributeArr2 = (DefaultAttribute[]) Arrays.copyOf(defaultAttributeArr, defaultAttributeArr.length);
                defaultAttributeArr2[iSearchAttributeByKey] = defaultAttribute;
            } else {
                if (defaultAttribute == null) {
                    defaultAttribute = new DefaultAttribute(this, attributeKey);
                }
                int length = defaultAttributeArr.length;
                defaultAttributeArr2 = new DefaultAttribute[length + 1];
                orderedCopyOnInsert(defaultAttributeArr, length, defaultAttributeArr2, defaultAttribute);
            }
        } while (!d.a(ATTRIBUTES_UPDATER, this, defaultAttributeArr, defaultAttributeArr2));
        return defaultAttribute;
    }

    @Override // io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        ObjectUtil.checkNotNull(attributeKey, b.c.f1408o);
        return searchAttributeByKey(this.attributes, attributeKey) >= 0;
    }
}
