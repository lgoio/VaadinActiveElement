//@see https://vaadin.com/book/vaadin7/-/page/gwt.javascript.html
window.vaadin_addons_ActiveElement = function() {
	var self = this;
	//called by ActiveElement.java
	this.request = function() {
		//The activeElement property returns the currently focused element in the document.
		//@see http://www.w3schools.com/jsref/prop_document_activeelement.asp
		var activeElement = document.activeElement;
		// look for parent id if the focused element doesn't have an id
		while (activeElement.id == null || activeElement.id == "") {
			activeElement=activeElement.parentNode;
		}
		// send the id to ActiveElement.java
		self.showActiveElement(activeElement.id);
	};
}