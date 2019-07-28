<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0"/>
<link rel="stylesheet" href="./css/common.css" media="all">
<link rel="stylesheet" href="./css/sub.css" media="all">
<link rel="stylesheet" href="./css/layout.css" media="all">

</head>

<body>

<header>
	<!--wrap-->
	<!--head-->
	<figure>
		<img src="./img/PageTop/RoyalCaribbeanCotton3.jpg" width="750px" height="420px">
	</figure>

	<div class="topimg">
		<ul>
			<li>
				<a href="http://www.kinkodo.jp/shirting/cart.php">
					<img src="./img/cart.png" alt="cart">
				</a>
			</li>
		</ul>
	</div>

</header>
<nav class="gmenu">
		<ul id="menu">
			<li><a href="indexServlet">HOME</a></li>
			<li><a href="ClothServlet">シャツ一覧</a></li>
			<li><a href="ForwardServlet?id=1">デザイン集</a></li>
			<li><a href="ForwardServlet?id=4">カートを見る</a></li>
		</ul>
</nav>
<div class="contents wrap">
<div class="clearfix">

<article class="newkiji">



<h2 align="center">${Name}生地一覧</h2>


<aside>
<div>

<c:forEach var="item" items="${itemList}" varStatus="status">

<dl>
<dt><a href="DetailServlet?id=${item.id}">
<figure><img src="./img/cloth/${item.fileName1}" alt=""></figure>
</a>
</dt>
<dd>
<h3><p>No.${item.id}<br>・${item.brandDataBeans.cName}<br>・${item.brandDataBeans.bName}<br>・${item.material}</p></h3>
<p>${item.cloth}
</p></dd>
<dd><h1>【お仕立てあがり￥${item.price}＋税】</h1></dd>
</dl>

</c:forEach>

</div>
</aside>

</article>

<div>
<nav class="page clearfix">
<ol>
		<li class="nav_on"><a href="index.php?p=1&amp;br_no=&amp;co_no=&amp;st_no=&amp;pr_no=&amp;rec=">1</a></li>
		<li><a href="index.php?p=2&amp;br_no=&amp;co_no=&amp;st_no=&amp;pr_no=&amp;rec=">2</a></li>
		<li><a href="index.php?p=3&amp;br_no=&amp;co_no=&amp;st_no=&amp;pr_no=&amp;rec=">3</a></li>
		<li><a href="index.php?p=4&amp;br_no=&amp;co_no=&amp;st_no=&amp;pr_no=&amp;rec=">4</a></li>
		<li><a href="index.php?p=5&amp;br_no=&amp;co_no=&amp;st_no=&amp;pr_no=&amp;rec=">5</a></li>
		<li><a href="index.php?p=6&amp;br_no=&amp;co_no=&amp;st_no=&amp;pr_no=&amp;rec=">6</a></li>
</ol>
<a href="index.php?p=2&amp;br_no=&amp;co_no=&amp;st_no=&amp;pr_no=&amp;rec=" class="btn">next<img src="./img/icon_next.jpg"></a>
</nav>
</div>

</div><!-- main -->

</div>

<p class="gotop wrap">
<a href="#">PAGETOP</a>
</body>
</html>