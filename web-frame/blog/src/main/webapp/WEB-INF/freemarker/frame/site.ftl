<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<@tiles.insertAttribute name="header" />
</head>
<body>
	<header class="site-header">
		<div id="activities" class="activities">Activities</div>
		<ul class="categories">
			<li class="category active"><a href="/">Home</a></li>
			<li class="category">Labs</li>
			<li class="category">APIs</li>
			<li class="category">Extensions</li>
		</ul>
	</header>
	<aside id="sidebar">
		<header>
			<div class="activities">Activities</div>
		</header>
	</aside>
	<section class="main-section">
		<section class="paper">
			<@tiles.insertAttribute name="body" />
		</section>
	</section>
</body>
</html>