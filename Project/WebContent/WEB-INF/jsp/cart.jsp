<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0" />
<link rel="stylesheet" href="css/common.css" media="all">
<link rel="stylesheet" href="css/sub.css" media="all">
<link rel="stylesheet" href="css/layout.css" media="all">
<script src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="./js/cartItem.js"></script>


</head>

<body>
	<header>
		<!--wrap-->
		<!--head-->
		<figure>
			<img src="img/PageTop/img1_03_s-607.jpg">
		</figure>

		<div class="topimg">
			<ul>
				<li><a href="http://www.kinkodo.jp/shirting/cart.php"> <img
						src="img/cart.png" alt="cart">
				</a></li>
			</ul>
		</div>

	</header>
	<nav class="gmenu">
		<ul id="menu">
			<li><a href="IndexServlet">HOME</a></li>
			<li><a href="ClothServlet">シャツ一覧</a></li>
			<li><a href="ForwardServlet?id=1">デザイン集</a></li>
			<li><a href="CartServlet">カートを見る</a></li>
		</ul>
	</nav>
<body>

	<div class="contents wrap">

		<div class="confirm">

			<article class="cart">
				<h2>ショッピングカート</h2>
				<h1>	${cartActionMessage}</h2>
				<dl class="kijilist clearfix">
				</dl>

				<dl class="kijilist clearfix">
					<c:forEach var="item" items="${cart}" varStatus="status">
						<form action="ItemDelete" method="POST">
							<dt>
								No.${item.id}   ■${item.cloth}   ■${item.remark}   ■${item.brandDataBeans.bName}   ■${item.material}<br>
								<input type="hidden" name="delete_id" value="${item.id}">
								<button  name="id" value="1" >削除</button>
							</dt>

							<dd>
								<input type="hidden" name="Change_id" value="${item.id}">
								<input name="num" type="text" size="3" value="${item.num}">枚
								<button type="submit" name="id" value="2">枚数変更</button>
							</dd>
						</form>
					</c:forEach>
				</dl>

				<p class="contbtn">
					<button type="button" onclick="location.href='IndexServlet'">買い物を続ける</button>
				</p>

				<h2>注文方法を選ぶ</h2>
				<div align="center">

					<a href="Buy"><img src="./img/saisun_1.jpg"
						alt="オーダー(1)お身体を採寸してのご注文"></a>
					</li> <a href="Buy"><img src="./img//saisun_2.jpg"
						alt="オーダー(2)シャツを採寸してのご注文"></a>
					</li>

				</div>

			</article>


		</div>
</html>