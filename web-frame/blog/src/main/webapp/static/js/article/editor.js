(function() {
	
	$(document).ready(function() {
		
		// Add event listener.
		addEventListener();
		
	});

	/**
	 * Add event listener.
	 */
	function addEventListener() {
		
		// Publish button click action.
		$("#publish").click( publishClickActionPerformed );
		
		// Update button click action.
		$("#update").click( updateClickActionPerformed );
	}

	/**
	 * Publish button click action perform.
	 */
	function publishClickActionPerformed() {
		publishOrUpdate("publish");
	}

	/**
	 * Update button click action perform.
	 */
	function updateClickActionPerformed() {
		publishOrUpdate("update");
	}

	/**
	 * Save or update article.
	 * @param type
	 */
	function publishOrUpdate(type) {
		
		// Select HTTP method.
		var method;
		if (type === "publish") {
			method = "POST";
		} else if (type === "update") {
			method = "POST";
		}
		
		// Validate data.
		if (validate()) {
			
			// Prepare data.
			var data = {
				uri:		$("#uri").val(),
				title:		$("#title").val(),
				content:	$("#content").val()
			}
			
			// Send data.
			$.ajax({
				url:		"/article/" + type,
				data:		data,
				type:		method,
				dataType:	"JSON",
				success:	function(json) {
					if (json && json.statusCode === 200) {
						alert(json.message);
					}
				}
			});
		}
	}

	/**
	 * Validate data.
	 */
	function validate() {
		return true;
	}
	
})();
