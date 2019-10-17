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
	<script type="text/javascript" src="../js/gm
	enu.js"></script>
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
						<dt>NO-${item.id}  ■${item.cloth}   ■${item.remark}   ■${item.brandDataBeans.bName}   ■${item.material}</dt>
						<dd>単価：${item.unitPrice}円&nbsp;&nbsp;&nbsp;${item.num}枚&nbsp;&nbsp;&nbsp;小計：${item.subPrice}円＋税</dd>
					</c:forEach>
				</dl>


				<h3>配送料</h3>
				<dl class="kijilist clearfix">
					<dd>500円＋税</dd>
				</dl>

				<h3>オプション料</h3>
				<dl class="kijilist clearfix">
					<c:if test = "${oderData.pocketBeans.poketPrice > 0}">
						<dt>ポケットの種類   : 【${oderData.pocketBeans.pocketType}】</dt>
						<dd>小計  :   ${oderData.pocketBeans.poketPrice}円＋税</dd>
					</c:if>

					<c:if test = "${oderData.nameDsingBeans.desingType != null}">
						<dt>ネームの種類   : 【${oderData.nameDsingBeans.desingType}】</dt>
						<dd>小計  :   ${oderData.nameDsingBeans.desingPrice}円＋税</dd>
					</c:if>

					<c:if test = "${oderData.nameColorBeans1.colorType != null}">
						<c:if test = "${oderData.nameColorBeans1.colorPrice > 0}">
							<dt>ネームカラー   : 【${oderData.nameColorBeans1.colorType}】</dt>
							<dd>小計  :   ${oderData.nameColorBeans1.colorPrice}円＋税</dd>
						</c:if>
					</c:if>

					<c:if test = "${oderData.nameColorBeans2.colorType != null}">
						<c:if test = "${oderData.nameColorBeans2.colorPrice > 0}">
							<dt>ネームカラー重ね字   : 【${oderData.nameColorBeans2.colorType}】</dt>
							<dd>小計  :   ${oderData.nameColorBeans2.colorPrice}円＋税</dd>
						</c:if>
					</c:if>

					<c:if test = "${oderData. buttonDesingBeans.buttonPrice > 0}">
						<dt>ボタンの種類   : 【${oderData. buttonDesingBeans.buttonTyupe}】</dt>
						<dd>小計  :  ${oderData. buttonDesingBeans.buttonPrice}円＋税</dd>
					</c:if>

				</dl>

				<h3>合計金額</h3>
				<dl class="kijilist clearfix">
					<dd>
						小計（税抜き）  :  ${oderData.price.subtotal}円<br>
						合計（税込み）  :  ${oderData.price.total}円
					</dd>
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

								<dt>ネームのイニシャル</dt>
								<dd>${oderData.nameSpelling}</dd>

								<dt>ネームカラー</dt>
								<c:if test = "${oderData.nameColorBeans1.colorType != null}">
									<dd>${oderData.nameColorBeans1.colorType}</dd>
								</c:if>

								<c:if test = "${oderData.nameColorBeans2.colorType != null}">
									<dt>ネームカラー重ね時</dt>
									<dd>${oderData.nameColorBeans2.colorType}</dd>
								</c:if>

								<dt>ネームの場所</dt>
								<dd>${oderData.namePosition}</dd>
							</c:if>

							<dt>ボタンの選択</dt>
							<dd>${oderData. buttonDesingBeans.buttonTyupe}</dd>

							<dt>ボタン付け糸</dt>
							<dd>>${oderData. buttonThread1}</dd>

							<dt>ボタンホール糸</dt>
							<dd>${oderData. buttonThread2}</dd>

							<dt>その他のご要望</dt>
							<dd>${oderData.requestBeans.otherRequest}</dd>

					</dl>

				</div>

				<div>
					<h3>お客様情報</h3>
					<dl class="orderlist">
						<dt>郵便番号</dt>
						<dd>${oderData.userDataBeans.zip}</dd>
						<dt>ご住所都道府県</dt>
						<dd>${oderData.userDataBeans.pref}</dd>
						<dt>市町村、番地</dt>
						<dd>${oderData.userDataBeans.address}</dd>
						<dt>お名前</dt>
						<dd>${oderData.userDataBeans.name}</dd>
						<dt>ふりがな</dt>
						<dd>${oderData.userDataBeans.kana}</dd>
						<dt>お電話番号</dt>
						<dd>${oderData.userDataBeans.tel}</dd>
						<dt>性別</dt>
						<dd>男性</dd>
						<dt>配送金額</dt>
						<dd>全国一律\500+税とさせて頂きます。</dd>
					</dl>
				</div>

				<div>
					<ul class="conbtn">
					<p class="t_c">お客様が入力された内容を登録すると、次回のご注文がスムーズになります。</p>
						<li><button type="submit">登録</button></li>
					</ul>
				</div>

				<div class="note">
					<p>上記の内容に間違いがなければ「ご注文完了」ボタンをクリックして下さい。</p>
				</div>


				<div>
					<ul class="conbtn">
						<li><button type="button" onclick="window.history.back()">ご注文内容の修正</button></li>
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