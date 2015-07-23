package vaadin.addons;

import java.io.Serializable;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;
import elemental.json.JsonException;

/**
 * Request the next element id having focus<br />
 * <br />
 * <b>Usage:</b><br />
 * <br />
 * 
 * <pre>
 * ActiveElement activeElement = new ActiveElement();
 * layout.addComponent(activeElement);
 * ActiveElement activeElement = new ActiveElement();
 * activeElement.request(new ActiveElement.Runnable() {
 * 	public void run(String id) {
 * 		Notification.show(id);
 * 	}
 * });
 * </pre>
 * 
 * @see http://www.w3schools.com/jsref/prop_document_activeelement.asp
 * @see https://vaadin.com/book/vaadin7/-/page/gwt.javascript.html
 * @author Lukas Gottschall <dwd@jdownloader.org>
 * @version 1.0
 * @since JDK7.0
 *
 */
@SuppressWarnings("serial")
@JavaScript({ "js/ActiveElementConnector.js" })
public class ActiveElement extends AbstractJavaScriptComponent {
	private Runnable runnable;

	/**
	 * Callback for the ActiveElement id
	 * 
	 * @author Lukas Gottschall <dwd@jdownloader.org>
	 * @version 1.0
	 * @since JDK7.0
	 *
	 */
	public static interface Runnable extends Serializable {
		/**
		 * @param next
		 *            id of the element having focus
		 */
		public abstract void run(String id);
	}

	public ActiveElement() {
		// receive the ActiveElement id from JavaScript
		addFunction("showActiveElement", new JavaScriptFunction() {
			public void call(JsonArray arguments) throws JsonException {
				runnable.run(arguments.get(0).asString());
			}
		});
	}

	/**
	 * Request the element having focus
	 * 
	 * @param runnable
	 */
	public void request(Runnable runnable) {
		this.runnable = runnable;
		callFunction("request");
	}
}