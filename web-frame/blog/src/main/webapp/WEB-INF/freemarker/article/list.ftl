<style type="text/css">
html body section.main-section .paper {
	background: none;
	box-shadow: none;
}
</style>
<section class="articles left">
<#list articles! as article>
	<#if article_index % 2 == 0>
		<article class="article">
			<h1><a class="article-url" href="/article/${ (article.uri)! }">${ (article.title)! }</a></h1>
			<p>${ (article.content)! }</p>
			<time>${ (article.time)! }</time>
		</article>
	</#if>
</#list>
</section><section class="articles right">
<#list articles! as article>
	<#if article_index % 2 == 1>
		<article class="article">
			<h1><a class="article-url" href="/article/${ (article.uri)! }">${ (article.title)! }</a></h1>
			<p>${ (article.content)! }</p>
			<time>${ (article.time)! }</time>
		</article>
	</#if>
</#list>
</section>
<script src="${ (project.staticDomain)! }/js/article/list.js" type="text/javascript"></script>