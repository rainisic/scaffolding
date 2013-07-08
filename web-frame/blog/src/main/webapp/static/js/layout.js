$(document).ready(function() {
	
	// Global event listener.
	addGlobalEventListener();
});

/**
 * Add global event listener.
 */
function addGlobalEventListener() {
	
	// Sidebar event listener.
	$("#activities, #sidebar").hover(sidebarMouseOverActionPerformed, sidebarMouseOutActionPerformed);
	
	// Navigator event listener.
	$(".category a").click( categoryClickedActionPerformed );
	
	// Window event listener.
	$(window).on("popstate", historyPopStateActionPerformed);
	
}

/**
 * Side bar mouse over.
 */
function sidebarMouseOverActionPerformed() { $("#sidebar").addClass("visible"); }

/**
 * Side bar mouse out.
 */
function sidebarMouseOutActionPerformed() { $("#sidebar").removeClass("visible"); }

/**
 * Category item clicked action performed.
 *
 * @param	event	ClickedEvent.
 */
function categoryClickedActionPerformed(event) {
	
	// Disable the origin action.
	event.preventDefault();

	// Get the link URL.
	var url = $(event.target).attr("href");

	// Forward.
	forward(url);
}

/**
 * History pop state.
 *
 * @param	event	Current PopStateEvent object.
 */
function historyPopStateActionPerformed(event) {
	event.originalEvent.state ?
		load(window.location.pathname + window.location.search) :
		pushHistory(window.location.pathname + window.location.search);
}

/**
 * Forward to URL.
 * 
 * @param container Update container.
 * @param url	The URL to forward.
 */
function forward(url) {
	
	// Push history.
	pushHistory(url);
	
	// Load resources.
	load(url);
}

/**
 * Push history state.
 */
function pushHistory(url) {
	history.pushState(window.location.pathname + window.location.search, document.title, url);
}

/**
 * Load container data.
 */
function load(url) {
	
	// Hide container.
	$(".paper").fadeOut(300, function() {

		// Load data.
		$.get(url, { dataType: "raw" }, function(html) {

			// Update container content.
			$(".paper").html(html).fadeIn(300);
		});
	});
}