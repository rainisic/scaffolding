<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,600" rel="stylesheet" type="text/css">
	<link href="${ (project.staticDomain)! }/scaffold/front-template/button-default.css" rel="stylesheet" type="text/css">
	<link href="${ (project.staticDomain)! }/css/default.css" rel="stylesheet" type="text/css">
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
	<script src="${ (project.staticDomain)! }/scaffold/jquery/jquery-2.0.2.js" type="text/javascript"></script>
	<script src="${ (project.staticDomain)! }/scaffold/jquery/jquery-migrate-1.2.1.js" type="text/javascript"></script>
	<script src="${ (project.staticDomain)! }/js/layout.js" type="text/javascript"></script>
</body>
</html>