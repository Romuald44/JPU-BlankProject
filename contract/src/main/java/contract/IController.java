package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 * @throws Exception
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws Exception;
	/**
	 * Remove key.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void removeKey(final ControllerOrder controllerOrder);
	/**
	 * select level.
	 *
	 * @param ControllerOrder
	 *          controllerOrder
	 * @throws Exception
	 */
	public void selectLevel(ControllerOrder controllerOrder) throws Exception;
}
