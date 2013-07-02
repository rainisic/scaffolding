(function() {

	$(document).ready(function() {

		// Add event listener.
		addEventListener();

		$("#publish").click(function() {
			$.ajax({
				url:		"/publish",
				data:		{
					title:		$("#title").val(),
					uri:		$("#uri").val()
				},
				type:		"POST",
				dataType:	"JSON",
				success:	function(json) {
					if (json.statusCode == 200) {
						forward(json.uri);
					} else {
						alert(json.message);
					}
				}
			});
		});
	});

	/**
	 * Add event listener.
	 */
	function addEventListener() {
		
		// Add sidebar event listener.
		$("#activities, #sidebar").hover(sidebarMouseOverActionPerformed, sidebarMouseOutActionPerformed);

		// Navigator bar click event listener.
		$(".category a").click( categoryClickedActionPerformed );

		// Add article click event listener.
		$(".paper").on("click", ".article-url", articleClickedActionPerformed);

		// Add popstate event listener.
		$(window).on('popstate', historyPopStateActionPerformed);
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
	 * Article clicked action performed.
	 *
	 * @param	event	ClickedEvent.
	 */
	function articleClickedActionPerformed(event) {

		// Disable the origin action.
		event.preventDefault();

		// Get the article URI.
		var url = $(event.target).attr("href");

		// Forward to target page.
		forward(url);
	}

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
		event.originalEvent.state ? load(window.location.pathname) : pushHistory(window.location.pathname);
	}

	/**
	 * Forward to given URL
	 *
	 * @param	url	URL for forward.
	 */
	function forward(url) {
		
		// Change the URL location in browser.
		pushHistory(url);

		// Load data.
		load(url);
	}

	/**
	 * Push history.
	 *
	 * @param	url	URL to forward.
	 */
	function pushHistory(url) {
		history.pushState(window.location.pathname, document.title, url);
	}

	/**
	 * Load raw page.
	 *
	 */
	function load(url) {

		// Load raw page.
		$(".paper").fadeOut(300, function() {
			$.get("/raw" + url, function(html) {
				$(".paper").html(html).fadeIn(300);
			});
		});
	}
})();
