<#if article??>
	<h1>Update article</h1>
<#else>
	<h1>Create article</h1>
</#if>
<fieldset id="editor">
	<legend>Article Information</legend>
	<p>
		<label for="title">Title:</label>
		<input id="title" type="text" value="${ (article.title)! }">
	</p>
	<p>
		<label for="uri">URI:</label>
		<input id="uri" type="text" value="${ (article.uri)! }">
	</p>
	<p>
		<textarea id="content">${ (article.content)! }</textarea>
	</p>
	<p class="text-right">
		<#if article??>
			<button id="update" type="button" class="btn btn-primary">UPDATE</button>
		<#else>
			<button id="publish" type="button" class="btn btn-primary">PUBLISH</button>
		</#if>
	</p>
</fieldset>
<script src="${ (project.staticDomain)! }/js/article/editor.js" type="text/javascript"></script>