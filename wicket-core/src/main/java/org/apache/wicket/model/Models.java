package org.apache.wicket.model;

import org.apache.wicket.Component;
import org.danekja.java.util.function.serializable.SerializableConsumer;
import org.danekja.java.util.function.serializable.SerializableFunction;
import org.danekja.java.util.function.serializable.SerializableSupplier;

/**
 *
 */
class Models {

	static <R, T> IModel<R> smartModel(final IModel<T> wrappedModel,
	                                   final SerializableSupplier<R> getObject,
	                                   final SerializableConsumer<R> setObject,
	                                   final SerializableSupplier<Void> detacher,
	                                   final SerializableFunction<? super T, R> mapper) {

		if (wrappedModel instanceof IComponentAssignedModel) {

			return new IComponentAssignedModel<>()
			{
				@Override
				public IWrapModel<R> wrapOnAssignment(final Component component)
				{
					final IWrapModel<T> wrappingModel = ((IComponentAssignedModel) wrappedModel).wrapOnAssignment(component);
					return new IWrapModel<>()
					{
						@Override
						public R getObject() {
							return mapper.apply(wrappingModel.getObject());
						}

						@Override
						public IModel<?> getWrappedModel() {
							return wrappingModel;
						}
					};
				}

				@Override
				public R getObject()
				{
					return getObject.get();
				}

				@Override
				public void setObject(final R object)
				{
					setObject.accept(object);
				}

				@Override
				public void detach()
				{
					detacher.get();
				}
			};
		}
		else
		{
			return new IModel<>()
			{
				@Override
				public R getObject()
				{
					return getObject.get();
				}

				@Override
				public void detach()
				{
					detacher.get();
				}
			};
		}
	}
}
