package ninjabrainbot.data.temp;

/**
 * Keeps track of all DataComponents, to manage write lock to them and monitor changes so that undo works.
 */
public interface IDomainModel {

	void registerDataComponent(IDataComponent<?> dataComponent);

	void notifyDataComponentToBeModified();

	Iterable<IDataComponent<?>> getAllDataComponents();

}