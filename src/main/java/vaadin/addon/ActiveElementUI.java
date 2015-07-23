package vaadin.addon;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Demonstration UI
 * 
 * @author Lukas Gottschall <dwd@jdownloader.org>
 * @version 1.0
 * @since JDK7.0
 *
 */
@Theme("activeelement")
@Widgetset("vaadin.addon.ActiveElementWidgetset")
@SuppressWarnings("serial")
public class ActiveElementUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);

		final Button button = new Button(
				"Press [f] key to show the element having focus");
		final TextField textField = new TextField("");

		final ActiveElement activeElement = new ActiveElement();
		// load the ActiveElementConnector.js
		layout.addComponent(activeElement);

		textField.setId("textFieldID");
		button.setId("buttonID");
		layout.addShortcutListener(new ShortcutListener("F", KeyCode.F, null) {

			@Override
			public void handleAction(Object sender, Object target) {
				activeElement.request(new ActiveElement.Runnable() {

					@Override
					public void run(String id) {
						for (int i = 0; i < layout.getComponentCount(); i++) {
							Component component = layout.getComponent(i);
							if (component.getId() != null
									&& component.getId().equals(id))
								Notification
										.show("The Component having focus is:"
												+ component);
						}

					}
				});
			}
		});
		layout.addComponent(button);
		layout.addComponent(textField);

		layout.setComponentAlignment(button, Alignment.MIDDLE_LEFT);
		layout.setComponentAlignment(textField, Alignment.MIDDLE_LEFT);

	}

	@WebServlet(urlPatterns = "/*", name = "ActiveElementUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = ActiveElementUI.class, productionMode = false)
	public static class ActiveElementUIServlet extends VaadinServlet {
	}
}
