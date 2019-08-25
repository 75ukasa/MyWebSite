<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
</head>
<body>

	<header>
		<!--wrap-->
		<!--head-->
		<figure>
			<img src="img/PageTop/topimg (1).jpg">
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
			<li><a href="ForwardServlet?id=4">カートを見る</a></li>
		</ul>
	</nav>

	<div class="contents wrap">
		<div class="confirm">
			<h2 align="center">■オーダーシャツの採寸方法・お気に入りのシャツの採寸方法。</h2>
			<table class="table1 fixed v_top wid800">
				<tbody>
					<tr>
						<td><img src="img/size/title_kubi.jpg" border="0"
							align="top"><br> <br> 首周り（ネックサイズ）の採寸です。<br>
							<br>
							シャツの首元を大きく開けて頂いてから採寸をお願いできればと思います。計測箇所はボタンが付いている糸から、ボタンホールの中央までです。<br>
							<br>
							しっかりと伸ばしてお計り頂ければと思います。裏側に縦にシワがよっている場合はクリーニングによって縮みが発生している可能性もあります。しっかり伸ばしてお計り頂くか、計測した数値に縮み（シワの状況）の分だけ０．５～１．０センチ程足したものを計測数値とした場合がよい時もございます
						</td>
						<td><img src="./img/size/neck1.jpg" border="0" align=""><br>
						<img src="./img/size/neck2.jpg" border="0"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="img/size/title_katahaba.jpg"
							border="0"><br> <br>
							お気に入りのシャツの肩巾の採寸方法です。片側の肩先から衿の後ろの中心までを計り、更にもう片一方も衿の後ろから肩先にかけて計って下さい。それを足したものが肩幅になります。<br>
							<br> 採寸の際には肩の縫い代は肩巾に加えて頂ければと思います。<br> <br>
							右の写真やその下に貼ってあります。Youtubeの動画を確認頂きましてお計り頂ければと思います。<br> <br>
							ご着用のシャツの肩巾が狭いと感じた場合はこのサイズにプラスして頂ければと思いますが、あまり肩巾が広いと逆に袖が上がりにくくなる場合もございます。<br>
						<br>ご着用になった際に肩先の先端の骨の所にシャツの肩巾がきていればそのシャツはジャストサイズと言えると思います。</td>
						<td><img src="img/size/katahaba1.jpg" border="0"
							align="top"><br>
						<img src="img/size/katahaba2.jpg" border="0"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="img/size/title_yukitake.jpg"
							border="0"><br> <br>
							（衿の真後ろ、ヨークの中心、肩幅の半分）より肩先を通してカフスの先まで計ります。<br> <br>
							基本的に５ミリ単位です。左右の長さが違う人が当店の経験上半数くらいはいらっしゃいますので、左右をお計り下さい。<br>
							<br> ジャストサイズのシャツをご着用の場合はカフスの先までお計り頂ければと思います。<br> <br>
							袖ははしっかりと伸ばしてお計り下さい。</td>
						<td><img src="img/size/sodetake.jpg" border="0" align="top"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="./img/size/title_ah.jpg"
							border="0" align="top"><br> <br>
							アームホール（袖周り）のサイズです。肩の縫い目の所から脇の下までの縫い目を直線で計ります。<br> <br>
							この部分はカーブしている場所ではありますが、計測は直線で構いません。無理に引っ張って真っ直ぐにする必要はありませんが、真っ直ぐに脇の下の縫い目まで計って頂きまして、これを２倍にした数値がアームホールのサイズとなります。
						</td>
						<td><img src="./img/size/a_hole1.jpg" border="0" align="top"></td>
					</tr>

					<tr>
						<td></td>
						<td><img src="./img/size/a_hole2.jpg" border="0"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="./img/size/title_bust.jpg"
							border="0"><br> <br>
							上胴（バスト）のお採寸です。特に難しことはありません。脇の下辺を真っ直ぐにお計り下さい。<br> <br>
							この時にお計り頂きましたシャツの背中にタックが入っている場合は背中のタックも伸ばしてお計り頂ければと思います。その場合は正面から計ると前身から後ろ身がはみ出してくる場合もありますが、はみ出した分も計った数値を２倍したものが上胴（バスト）のサイズになります。<br>
							<br>
							背中にタックが入ったシャツをお計り頂いた際には御注文時にも同じように背タックをお選び頂ければと思います。背タックを選択しない場合は背巾が狭くなり数値は同じでも着心地が変わる場合もあります。
						</td>
						<td><img src="./img/size/bust.jpg" border="0" align="top"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="./img/size/title_waist.jpg"
							border="0" align="top"><br> <br>
							中胴（ウエスト）の採寸です。上胴と同じように採寸して頂ければと思います。<br> <br>
							目安としてはおへその辺り。シャツで言いますと一番くぼみがある部分が中胴（ウエスト）の部分になります。<br> <br>
							こちらに関しても上胴同様、計測して頂いた数値の２倍が中胴サイズとなります。</td>
						<td><img src="./img/size/waist.jpg" border="0" align="top"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="./img/size/title_hip.jpg"
							border="0" align="top"><br> <br>
							下胴（ヒップ）の採寸です。上胴中胴と同様な採寸方法で良いと思います。裾の部分をお計り下さい。<br> <br>
							こちらに関しても上胴、中胴、同様、計測して頂いた数値の２倍が中胴サイズとなります。</td>
						<td><img src="./img/size/hip.jpg" border="0" align="top"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="./img/size/title_kitake.jpg"
							border="0" align="top"><br> <br>
							シャツの丈、着丈の採寸です。衿の直ぐ下、ヨークと衿の境目から真っ直ぐに裾までを計測します。<br> <br>
							<br></td>
						<td><img src="./img/size/take.jpg" border="0" align="top"><br></td>
					</tr>

					<tr>
						<td valign="top"><img src="./img/size/title_cuffs.jpg"
							border="0"><br> <br>
							カフス周りの採寸です。カフスの右端から左端までの全長をお計り下さい。<br> <br>
							オーダーされたシャツであれば、時計をされる方（一般的には左側）の方がカフス周りを広くしてある場合もありますので、念の為に左右ともお計り頂ければと思います。<br>
							<br>
							採寸の際にカフスの裏側に縦にシワがよっている場合はクリーニングによって縮みが発生している可能性もあります。しっかり伸ばしてお計り頂くか、計測した数値に縮み（シワの状況）の分だけ０．５～１．０センチ程足したものを計測数値とした場合がよい時もございます。
						</td>
						<td><img src="./img/size/cuffs.jpg" border="0" align="top"><br>
						<iframe frameborder="0" allowfullscreen="" class="stube"></iframe></td>
					</tr>
				</tbody>
			</table>

			<h2>■採寸箇所をイラストでご確認下さい</h2>
			<table class="wid726 fixed">
				<tbody>
					<tr>
						<td><img src="./img/size/buck.jpg" border="0"></td>
						<td><img src="./img/size/front.jpg" border="0"></td>
					</tr>
				</tbody>
			</table>
			<br>

		</div>
		<!-- main -->

	</div>
	<p class="gotop wrap">
		<a href="#">PAGETOP</a>
</body>
</html>