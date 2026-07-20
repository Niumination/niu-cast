package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes3.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor classDescriptor, D d7);

    R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d7);

    R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d7);

    R visitModuleDeclaration(ModuleDescriptor moduleDescriptor, D d7);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d7);

    R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d7);

    R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, D d7);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d7);

    R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d7);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d7);

    R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d7);

    R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d7);

    R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d7);
}
