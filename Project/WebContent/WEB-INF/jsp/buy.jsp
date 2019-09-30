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
<link rel="stylesheet" href="./css/order.css" media="all">
<link rel="stylesheet" href="./css/layout.css" media="all">


</head>

<body>

	<header>
		<!--wrap-->
		<!--head-->
		<figure>
			<img src="./img/PageTop/gr167_d01.jpg">
		</figure>


	</header>
	<script type="text/javascript" src="../js/gmenu.js"></script>
	<nav class="gmenu"></nav>
<body>

	<div class="contents wrap">

		<article class="confirm">
			<h2>ご注文内容確認</h2>

			<p class="t_c">お客様が入力された内容は、以下の通りです。内容のご確認をお願いします。</p>

			<div>
				<h3>ご注文生地</h3>

				<dl class="kijilist clearfix">

					<c:forEach var="item" items="${cart}" varStatus="status">
						<dt>NO-${item.id}  グレーの変わり織りチェック イタリア CANCLINI カンクリーニ社 綿１００％</dt>
						<dd>単価：18,000円&nbsp;&nbsp;&nbsp;1枚&nbsp;&nbsp;&nbsp;小計：18,000円</dd>
					</c:forEach>
				</dl>


				<h3>配送料</h3>
				<dl class="kijilist clearfix">
					<dd>500円＋税</dd>
				</dl>

				<h3>オプション料</h3>
				<dl class="kijilist clearfix">
					<c:if test = "${oderData.pocketBeans.poketPrice > 0}">
						<dd>ポケット【${oderData.pocketBeans.pocketType}】 : ${oderData.pocketBeans.poketPrice}円＋税</dd>
					</c:if>

					<c:if test = "${oderData.nameDsingBeans.desingType != null}">
						<dd>ネームの種類【${oderData.nameDsingBeans.desingType}】 : ${oderData.nameDsingBeans.desingPrice}円＋税</dd>
					</c:if>
				</dl>

				<h3>合計金額</h3>
				<dl class="kijilist clearfix">
					<dd>18,500円＋税（仕様決定後に金額が変わる場合がございます）</dd>
				</dl>

			</div>
			<form action="order01_complete.php" method="POST">
				<div>
					<h3>ご注文内容</h3>
					<dl class="orderlist">

							<dt>項目名</dt>
							<dd>&nbsp;</dd>
							<dt>首周り</dt>
							<dd> ${oderData.sizeBeanse.neck} センチ</dd>

							<dt>肩幅</dt>
							<dd>${oderData.sizeBeanse.shoulder} センチ</dd>

							<dt>アームホール</dt>
							<dd>${oderData.sizeBeanse.arm} センチ</dd>

							<dt>裄丈右</dt>
							<dd>${oderData.sizeBeanse.sleeveRigt} センチ</dd>

							<dt>裄丈左</dt>
							<dd>${oderData.sizeBeanse.sleeveLeft} センチ</dd>

							<dt>上胴（バスト）</dt>
							<dd>${oderData.sizeBeanse.bust} センチ</dd>

							<dt>中胴（ウエスト）</dt>
							<dd>${oderData.sizeBeanse.waist}  センチ</dd>

							<dt>下胴（ヒップ）</dt>
							<dd>${oderData.sizeBeanse.hips} センチ</dd>

							<dt>着丈</dt>
							<dd>${oderData.sizeBeanse.length} センチ</dd>

							<dt>カフス周り右</dt>
							<dd>${oderData.sizeBeanse.cuffsRigt} センチ</dd>

							<dt>カフス周り左</dt>
							<dd>${oderData.sizeBeanse.cuffsLeft} センチ</dd>

							<dt>ご身長</dt>
							<dd>${oderData.sizeBeanse.height} センチ</dd>


							<dt>シャツのシルエット</dt>
							<dd>${oderData.silhouetteType}</dd>

							<dt>衿のデザイン</dt>
							<dd>${oderData.collarType}</dd>

							<dt>衿デザインのご要望</dt>
							<dd>${oderData.requestBeans.collarRequest}</dd>

							<dt>カフスのデザイン</dt>
							<dd>${oderData.cuffsDesingType}</dd>

							<dt>カフスのコンバーチブル仕様</dt>
							<dd>${oderData.cuffsButtonType}</dd>

							<dt>カフスの時計仕様</dt>
							<dd>${oderData.cuffsWatchType}</dd>

							<dt>カフスデザインのご要望</dt>
							<dd>${oderData.requestBeans.cuffsRequest}</dd>

							<dt>ポケットのデザイン</dt>
							<dd>${oderData.pocketBeans.pocketType}</dd>

							<dt>ポケットデザインのご要望</dt>
							<dd>${oderData.requestBeans.pocketRequest}</dd>

							<dt>ネームの有無</dt>
							<dd>${oderData.nameMessage}</dd>
							<c:if test = "${oderData.nameMessage == 'ネームを入いれる'}">
								<dt>ネームの種類</dt>
								<dd>${oderData.nameDsingBeans.desingType}</dd>


							</c:if>
							<dt>ボタンの選択</dt>
							<dd>プラスチック ホワイト 二穴ボタン ミシン付け</dd>
							<dt>ボタン付け糸</dt>
							<dd>１）ブラック</dd>
							<dt>ボタンホール糸</dt>
							<dd>１）ブラック</dd>
							<dt>ボタン位置</dt>
							<dd>通常の位置 （第二ボタン衿台より５．５センチ）</dd>
							<dt>その他のご要望</dt>
							<dd></dd>

					</dl>

				</div>

				<div>
					<h3>お客様情報</h3>
					<dl class="orderlist">
						<dt>郵便番号</dt>
						<dd>166-0004</dd>
						<dt>ご住所都道府県</dt>
						<dd>東京都</dd>
						<dt>市町村、番地</dt>
						<dd>１３４</dd>
						<dt>お名前</dt>
						<dd>あ</dd>
						<dt>ふりがな</dt>
						<dd>あ</dd>
						<dt>お電話番号</dt>
						<dd>09022340156</dd>
						<dt>年齢</dt>
						<dd>１２</dd>
						<dt>性別</dt>
						<dd>男性</dd>
						<dt>配送金額</dt>
						<dd>全国一律\500+税とさせて頂きます。</dd>
					</dl>
				</div>

				<div class="note">
					<p>上記の内容に間違いがなければ「ご注文完了」ボタンをクリックして下さい。</p>
				</div>


				<div>
					<ul class="conbtn">
						<li><button type="button"
								onclick="location.href='order01.php'">ご注文内容の修正</button></li>
						<li><button type="submit">ご注文完了</button></li>
					</ul>
				</div>
			</form>

		</article>

	</div>
	<!-- contents -->
	<p class="gotop wrap">
		<a href="#">PAGETOP</a>

		</section>
</body>
</html>