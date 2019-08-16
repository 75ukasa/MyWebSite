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
<link rel="stylesheet" href="./css/common.css" media="all">
<link rel="stylesheet" href="./css/sub.css" media="all">
<link rel="stylesheet" href="./css/layout.css" media="all">

</head>

<body>

	<header>
		<!--wrap-->
		<!--head-->
		<figure>
			<img src="./img/PageTop/RoyalCaribbeanCotton3.jpg" width="750px"
				height="420px">
		</figure>

		<div class="topimg">
			<ul>
				<li><a href="http://www.kinkodo.jp/shirting/cart.php"> <img
						src="./img/cart.png" alt="cart">
				</a></li>
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

			<article class="detail">

				<h2>${item.id}${item.brandDataBeans.cName}
					${item.brandDataBeans.bName} ${item.remark}</h2>
				<div class="box">
					<figure align="center">
						<img src="./img/cloth/${item.fileName1}">
						<img src="./img/cloth/${item.fileName2}">
					</figure>

				</div>
				<div class="box">
					<h3>【お仕立て上がり￥${item.price}＋税】</h3>
					<p>${item.detail}</p>
				</div>


				<div class="box">
					<table>
						<tbody>
							<tr>
								<th>生地番号</th>
								<td>${item.id}</td>
							</tr>
							<tr>
								<th>生地ブランド</th>
								<td>${item.brandDataBeans.bName}</td>
							</tr>
							<tr>
								<th>生産国</th>
								<td>${item.brandDataBeans.cName}</td>
							</tr>
							<tr>
								<th>素材</th>
								<td>${item.material}</td>
							</tr>
							<tr>
								<th>お仕立て上がり金額</th>
								<td><strong class="blue">￥${item.price}＋税</strong> <font
									color="#ff0066">※価格はオーダーシャツ出来上がりの最小構成価格となります。</font><br>
									白蝶貝ボタンや一部のデザインなどはオプション設定もございます。</td>
							</tr>
							<tr>
								<th>カラー</th>
								<td>${item.color}</td>
							</tr>
							<tr>
								<th>備考</th>
								<td>${item.remark}</td>
							</tr>
							<tr>
								<th>生地の厚さ</th>
								<td>生地の厚さ
									<ul class="kijisize">
										<li class="add">薄い</li>
										<li class="add">やや薄い</li>
										<li class="add">普通</li>
										<li>やや厚い</li>
										<li>厚い</li>
									</ul>

								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<!--div class="txtbox">
<a name="cart" id="cart"></a>

</div-->



				<form action="CartServlet" method="POST">
					<div class="cartbox">

						<p class="t_c">
							カートに追加する枚数 <input type="text" name="num" size="3"> 枚
						</p>
						<ul>
							<li><button type="submit">
									<span>この生地を</span>カートに入れる
								</button></li>
							<li><a href="ForwardServlet?id=4">カートの中身を見る</a></li>
						</ul>
					</div>
					<input type="hidden" name="id" value="${item.id}">

				</form>
			</article>

		</div>
		<!-- main -->

	</div>

	<p class="gotop wrap">
		<a href="#">PAGETOP</a>
</body>
</html>