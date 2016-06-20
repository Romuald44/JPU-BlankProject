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
	 * select level.
	 *
	 * @param ControllerOrder
	 *          controllerOrder
	 * @throws Exception
	 */
	public void selectLevel(ControllerOrder controllerOrder) throws Exception;
}
