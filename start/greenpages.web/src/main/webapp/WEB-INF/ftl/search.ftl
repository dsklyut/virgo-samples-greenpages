<!DOCTYPE HTML>
<html>
<head>
<title>GreenPages</title>
  <link rel="stylesheet" href="/greenpages/styles/main.css" type="text/css" />
  <link rel="stylesheet" href="/greenpages/styles/local.css" type="text/css" />
  <link rel="stylesheet" href="/greenpages/styles/print.css" type="text/css" media="print" />
</head>
<body class="main tundra">
	<div id="page">
		<div id="mini-header">
			<div id="mini-header-left"></div>
			<div id="mini-header-right"></div>
		</div> <!-- /mini-header -->

		<div id="primary-navigation">
			<div id="primary-left">
				<ul>
					<li><a href="/greenpages" title="Admin Console">GreenPages</a></li>
				</ul>
			</div>
			<img id="left-curve" src="/greenpages/images/menu-curve-left.png"/>
			<div id="primary-right">
				<ul>
					<li><a href="/admin" title="Admin Console">Admin Console</a></li>
					<li><a href="http://www.eclipse.org/virgo" title="Admin Console">Virgo</a></li>
				</ul>
			</div>
			<img id="right-curve" src="/greenpages/images/menu-curve-right.png"/>
		</div><!-- /primary-navigation -->

		<div id="container">
		<div id="content-no-nav">
			<h1>Virgo Web Server - Greenpages sample</h1>
			<p/>
			<form name="searchForm" method="GET" action="search.htm">
				<input name="query" type="text"/> <input type="submit"/>
			</form>
			<#if listingList?? && (listingList?size > 0)>
				<table id="results">
					<thead>
						<tr>
							<th>Last Name</th>
							<th>First Name</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<#list listingList as listing>
							<tr>
								<td>${listing.lastName}</td>
								<td>${listing.firstName}</td>
								<td><a href="entry.htm?id=${listing.listingNumber}">view</a></td>
							</tr>
						</#list>
					</tbody>
				</table>
			<#else>
				<h2>No results found.</h2>
			</#if>
		</div> <!-- /content -->
		</div> <!-- /container -->
    
    <div id="footer-wrapper">
        <div id="footer-left">&copy; Copyright 2008, 2010 VMware Inc. Licensed under the Eclipse Public License v1.0.</div>
        <div id="footer-right"></div> 
    </div> <!-- /footer-wrapper -->

  </div> <!-- /page -->

</body>
</html>