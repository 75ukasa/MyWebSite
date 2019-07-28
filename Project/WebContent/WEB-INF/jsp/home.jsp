<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<meta name="format-detection" content="telephone=no">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0"/>
		<link rel="stylesheet" href="./css/common.css" media="all">
		<link rel="stylesheet" href="./css/top.css" media="all">
		<link rel="stylesheet" href="./css/layout.css" media="all">
		<link rel="stylesheet" href="./css/marker.css" media="all">
	</head>

	<body>
		<header>
			<div class="head">
				<p >世界で一枚しかないフルオーダーシャツをお作りします。</p>
			</div>
			<div id="header_search" class="clearfix">
				<form action="//www.google.com/search">
					<input type="hidden" name="ie" value="utf-8">
					<input type="hidden" name="oe" value="utf-8">
					<input type="hidden" name="filter" value="0">
					<input type="text" name="q" size="23" maxlength="30" value="" placeholder="サイト内検索">
					<input id="search_btn" name="submit" type="image" src="./img/search.jpg" alt="検索" align="absmiddle">
				</form>
			</div>
			<!--wrap-->
			<!--head-->
			<figure>
				<img src="./img/PageTop/1486370887.jpg">
			</figure>

			<div class="topimg">
				<ul>
					<li>
						<a href="">
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
			<h2>クリック一つで速やかにお好みの生地へ。生地の選択方法を
			<span style="font-size: 32pt">
				<font color="#ff0000">3</font>
			</span>通り用意いたしました。</h2>
			<p align="center"><img src="./img/click.jpg" width="60" height="80" border="0" class="example3" alt="3通りのオーダーシャツ通販の方法">それぞれの↓バナーをクリックして頂ければ、速やかにお好みの生地にたどり着けます。</p>
			<div class="tside">
				<aside>
					<div class="tside">
						<aside>
							<nav>
								<script type="text/javascript" src="/com/js/accord.js"></script>
								<ul>
									<li>
										<p><a class="accord" data-target="accrd01">ブランドで選ぶ</a></p>
										<ul class="accrd01" style="display: block;">
										<li class="canclini"><a href="BrandCategory?id=1&No=1&name=カンクリーニ" alt="オーダーシャツ生地カンクリーニ">Canclini</a></li>
										<li class="tmason"><a href="BrandCategory?id=2&No=1&name=トーマスメイソン" alt="オーダーシャツ生地トーマスメイソン">Thomas Mason</a>
							   			<li class="alumo"><a href="BrandCategory?id=3&No=1&name=アルモ" alt="オーダーシャツ生地アルモ">Alumo</a></li>
										<li class="carlo"><a href="BrandCategory?id=4&No=1&name=カルロリーバ" alt="オーダーシャツ生地カルロリーバ">Carlo Riva</a></li>
										<li class="leggiuno"><a href="BrandCategory&id=5?No=1&name=レジウノ" alt="オーダーシャツ生地レジウノ">leggiuno</a></li>
										<li class="giza"><a href="BrandCategory?id=6&No=1&name=ギザ" alt="エジプト綿GIZA">Giza</a></li>
									</ul>
								</li>

								<li><p><a class="accord" data-target="accrd02">カラーで選ぶ</a></p>
									<ul class="accrd02" style="display: block;">
										<li><a href="ColorCategoty?id=ホワイト"><img src="./img/colorSelect/side_whites.jpg" alt="オーダーシャツ生地ホワイト">ホワイト</a></li>
										<li><a href="ColorCategoty?id=ブルー"><img src="./img/colorSelect/side_blue.jpg" alt="オーダーシャツ生地ブルー">ブルー</a></li>
										<li><a href="ColorCategoty?id=ピンク"><img src="./img/colorSelect/side_pink.jpg" alt="オーダーシャツ生地ピンク">ピンク</a></li>
										<li><a href="ColorCategoty?id=グレー"><img src="./img/colorSelect/side_grey.jpg" alt="オーダーシャツ生地グレー">グレー</a></li>
										<li><a href="ColorCategoty?id=ブラック"><img src="./img/colorSelect/side_black.jpg" alt="オーダーシャツ生地ブラック">ブラック</a></li>
										<li><a href="ColorCategoty?id=マルチ"><img src="./img/colorSelect/side_multi.jpg" alt="オーダーシャツ生地マルチカラー">マルチカラー</a></li>
									</ul>
								</li>
								<li>
									<p><a class="accord" data-target="accrd04">価格帯で選ぶ</a></p>
									<ul class="accrd04" style="display: block;">
											<li><a href="PriceCategory?id=2&name=￥18,000までの" alt="オーダーシャツ生地18,000円まで"><b>18,000</b>+税　まで</a></li>
											<li><a href="PriceCategory?id=2&name=￥20,000までの" alt="オーダーシャツ生地20,000円まで"><b>20,000</b>+税　まで</a></li>
											<li><a href="PriceCategory?id=3&name=￥25,000までの" alt="オーダーシャツ生地25,000円まで"><b>25,000</b>+税　まで</a></li>
											<li><a href="PriceCategory?id=4&name=￥26,000以上の" alt="オーダーシャツ生地26,000円まで"><b>26,000</b>+税　以上</a></li>
								 		</ul>
								 	</li>
								 </ul>
							</nav>
						</aside>
					</div>
					<h2>採寸方法</h2>
					<table valign="middle">
						<tbody>
							<tr>
								<td><a href="ForwardServlet?id=2"><img src="./img/saisun_1.jpg" style="margin-right: 2px;" alt="身体を採寸してオーダーシャツの通販をご注文を頂く方法"></a></td>
								<td><a href="ForwardServlet?id=3"><img src="./img/saisun_2.jpg" style="margin-left: 2px;" alt="お気に入りのシャツを採寸してオーダーシャツの通販をご注文を頂く方法"></a></td>
							</tr>
						</tbody>
					</table>
				</aside>
			</div>
		</div>
	</body>
</html>