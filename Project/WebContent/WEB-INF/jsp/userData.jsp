<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<meta name="format-detection" content="telephone=no">
		<meta name="viewport"
			content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=0" />


		<link rel="stylesheet" href="css/common.css" media="all">
		<link rel="stylesheet" href="css/layout.css" media="all">
		<link rel="stylesheet" href="css/materialize.css" media="all">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>


	<body>
		<!--wrap-->
		<!--head-->
		<div class="row center">
            <h2>
                <a href="Index">Made-To-Order</a>
            </h2>
        </div>


		<div class="container">
		<div class="row center">
			<h5 class=" col s12 light">ユーザー情報</h5>
		</div>
		<div class="row">
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<form action="UserDataUpdateConfirm" method="POST">
							<c:if test="${validationMessage != null}">
								<p class="red-text center-align">${validationMessage}</p>
							</c:if>
							<br> <br>
							<div class="row">
								<div class="input-field col s5">
									<input type="text" name="user_name" value="a"> <label class="active">名前</label>
								</div>
								<div class="input-field col s5">
									<input type="text" name="login_id" value="${udb.loginId}"> <label class="active">ふりがな</label>
								</div>
								<div class="input-field col s2">
									<input type="text" name="login_id" value="男性"> <label class="active">性別</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s4">
									<input type="text" name="login_id" value="${udb.loginId}"> <label class="active">郵便番号</label>
								</div>
								<div class="input-field col s8">
									<input type="text" name="user_address" value="${udb.address}"> <label class="active">住所</label>
								</div>
							</div>
							<div class="row">
								<div class="input-field col s12">
									<input type="text" name="login_id" value="${udb.loginId}"> <label class="active">電話番号</label>
								</div>
							</div>
							<div class="row">
								<div class="conbtn">
									<button class="btn" type="submit">更新</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--  購入履歴 -->
		<div class="row center">
			<h5 class=" col s12 light">購入履歴</h5>
		</div>
		<div class="row">
			<div class="col s12">
				<div class="card grey lighten-5">
					<div class="card-content">
						<table class="bordered">
							<thead>
								<tr>
									<th style="width: 20%"></th>
									<th class="center">購入日時</th>
									<th class="center">購入金額</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="BuyData" items="${BuyDataList}" >
									<tr>
										<td class="center">
											<div class="conbtn">
												<button type="button">詳細</button>
											</div>
										</td>
										<td class="center">${BuyData.formatDate}</td>
										<td class="center">${BuyData.totalPrice}円</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>