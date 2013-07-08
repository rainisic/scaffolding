(function() {
	
	$(document).ready(function() {
		
		// Add event listener.
		addEventListener();
	});

	/**
	 * Add event listener.
	 */
	function addEventListener() {
		
		// Article event listener.
		$(".article-url").click( articleClickActionPerformed );
	}

	/**
	 * Forward to given page.
	 * 
	 * @param event	
	 */
	function articleClickActionPerformed(event) {
		
		// Disable the origin action.
		event.preventDefault();

		// Get the article URI.
		var url = $(event.target).attr("href");

		// Forward to target page.
		forward(url);
	}
})();